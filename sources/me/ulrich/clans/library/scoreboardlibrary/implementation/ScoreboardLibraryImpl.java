package me.ulrich.clans.library.scoreboardlibrary.implementation;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.library.scoreboardlibrary.implementation.objective.ObjectiveManagerImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.objective.ObjectiveManagerTask;
import me.ulrich.clans.library.scoreboardlibrary.implementation.objective.ObjectiveUpdaterTask;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PacketAdapterProvider;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.ScoreboardLibraryPlayer;
import me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.TaskScheduler;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.AbstractSidebar;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.PlayerDependantLocaleSidebar;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.SidebarTask;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.SidebarUpdaterTask;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.SingleLocaleSidebar;
import me.ulrich.clans.library.scoreboardlibrary.implementation.team.TeamManagerImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.team.TeamManagerTask;
import me.ulrich.clans.library.scoreboardlibrary.implementation.team.TeamUpdaterTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/ScoreboardLibraryImpl.class */
public final class ScoreboardLibraryImpl implements ScoreboardLibrary {
    private final Plugin plugin;
    private final PacketAdapterProvider packetAdapter;
    private final TaskScheduler taskScheduler;
    private volatile Set<TeamManagerImpl> teamManagers;
    private volatile Set<ObjectiveManagerImpl> objectiveManagers;
    private volatile Set<AbstractSidebar> sidebars;
    private final Listener localeListener;
    private TeamUpdaterTask teamTask;
    private ObjectiveUpdaterTask objectiveTask;
    private SidebarUpdaterTask sidebarTask;
    private volatile boolean closed;
    private final Map<Player, ScoreboardLibraryPlayer> playerMap = new MapMaker().weakKeys().makeMap();
    private final Object lock = new Object();

    public ScoreboardLibraryImpl(@NotNull Plugin plugin) {
        Preconditions.checkNotNull(plugin, "plugin");
        try {
            Adventure.class.getName();
            this.plugin = plugin;
            this.packetAdapter = PacketAdapterLoader.loadPacketAdapter(plugin);
            this.taskScheduler = TaskScheduler.create(plugin);
            Class<?> cls = null;
            try {
                cls = Class.forName("org.bukkit.event.player.PlayerLocaleChangeEvent");
            } catch (ClassNotFoundException e) {
            }
            if (cls == null) {
                this.localeListener = null;
                return;
            }
            this.localeListener = new Listener() { // from class: me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl.1
            };
            plugin.getServer().getPluginManager().registerEvent(cls, this.localeListener, EventPriority.NORMAL, (listener, event) -> {
                Player player = ((PlayerEvent) event).getPlayer();
                this.taskScheduler.runNextTick(() -> {
                    ScoreboardLibraryPlayer player2 = getPlayer(player);
                    if (player2 != null) {
                        TeamManagerImpl teamManagerImpl = (TeamManagerImpl) player2.teamManagerQueue().current();
                        if (teamManagerImpl != null) {
                            teamManagerImpl.taskQueue().add(new TeamManagerTask.ReloadPlayer(player));
                        }
                        ObjectiveManagerImpl objectiveManagerImpl = (ObjectiveManagerImpl) player2.objectiveManagerQueue().current();
                        if (objectiveManagerImpl != null) {
                            objectiveManagerImpl.taskQueue().add(new ObjectiveManagerTask.ReloadPlayer(player));
                        }
                        AbstractSidebar abstractSidebar = (AbstractSidebar) player2.sidebarQueue().current();
                        if (abstractSidebar instanceof PlayerDependantLocaleSidebar) {
                            abstractSidebar.taskQueue().add(new SidebarTask.ReloadPlayer(player));
                        }
                    }
                });
            }, plugin);
        } catch (NoClassDefFoundError e2) {
            throw new IllegalStateException("Adventure is not in the classpath");
        }
    }

    @NotNull
    public Plugin plugin() {
        return this.plugin;
    }

    @NotNull
    public PacketAdapterProvider packetAdapter() {
        return this.packetAdapter;
    }

    @NotNull
    public TaskScheduler taskScheduler() {
        return this.taskScheduler;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    @NotNull
    public Sidebar createSidebar(int i, @Nullable Locale locale, @NotNull String str) {
        checkClosed();
        if (i <= 0) {
            throw new IllegalArgumentException("invalid maxLines value: " + i);
        }
        AbstractSidebar playerDependantLocaleSidebar = locale == null ? new PlayerDependantLocaleSidebar(this, i, str) : new SingleLocaleSidebar(this, i, str, locale);
        sidebars().add(playerDependantLocaleSidebar);
        return playerDependantLocaleSidebar;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    @NotNull
    public TeamManagerImpl createTeamManager() {
        checkClosed();
        TeamManagerImpl teamManagerImpl = new TeamManagerImpl(this);
        teamManagers().add(teamManagerImpl);
        return teamManagerImpl;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    @NotNull
    public ObjectiveManager createObjectiveManager() {
        checkClosed();
        ObjectiveManagerImpl objectiveManagerImpl = new ObjectiveManagerImpl(this);
        objectiveManagers().add(objectiveManagerImpl);
        return objectiveManagerImpl;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    public void close() {
        if (this.closed) {
            return;
        }
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.localeListener != null) {
                HandlerList.unregisterAll(this.localeListener);
            }
            if (this.teamManagers != null) {
                this.teamTask.task().cancel();
                synchronized (this.teamTask.lock()) {
                    for (TeamManagerImpl teamManagerImpl : this.teamManagers) {
                        teamManagerImpl.close();
                        teamManagerImpl.tick();
                    }
                }
            }
            if (this.objectiveManagers != null) {
                this.objectiveTask.task().cancel();
                synchronized (this.objectiveTask.lock()) {
                    for (ObjectiveManagerImpl objectiveManagerImpl : this.objectiveManagers) {
                        objectiveManagerImpl.close();
                        objectiveManagerImpl.tick();
                    }
                }
            }
            if (this.sidebars != null) {
                this.sidebarTask.task().cancel();
                synchronized (this.sidebarTask.lock()) {
                    for (AbstractSidebar abstractSidebar : this.sidebars) {
                        abstractSidebar.close();
                        abstractSidebar.tick();
                    }
                }
            }
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    public boolean closed() {
        return this.closed;
    }

    public Set<TeamManagerImpl> teamManagers() {
        if (this.teamManagers == null) {
            synchronized (this.lock) {
                if (this.teamManagers == null) {
                    this.teamManagers = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.75f, 2));
                    this.teamTask = new TeamUpdaterTask(this);
                }
            }
        }
        return this.teamManagers;
    }

    public Set<ObjectiveManagerImpl> objectiveManagers() {
        if (this.objectiveManagers == null) {
            synchronized (this.lock) {
                if (this.objectiveManagers == null) {
                    this.objectiveManagers = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.75f, 2));
                    this.objectiveTask = new ObjectiveUpdaterTask(this);
                }
            }
        }
        return this.objectiveManagers;
    }

    public Set<AbstractSidebar> sidebars() {
        if (this.sidebars == null) {
            synchronized (this.lock) {
                if (this.sidebars == null) {
                    this.sidebars = Collections.newSetFromMap(new ConcurrentHashMap(4, 0.75f, 2));
                    this.sidebarTask = new SidebarUpdaterTask(this);
                }
            }
        }
        return this.sidebars;
    }

    @NotNull
    public ScoreboardLibraryPlayer getOrCreatePlayer(@NotNull Player player) {
        return this.playerMap.computeIfAbsent(player, ScoreboardLibraryPlayer::new);
    }

    @Nullable
    public ScoreboardLibraryPlayer getPlayer(@NotNull Player player) {
        return this.playerMap.get(player);
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("ScoreboardLibrary is closed");
        }
    }
}
