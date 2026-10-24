package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.ScoreboardLibraryPlayer;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.GlobalLineInfo;
import me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar.line.LocaleLineHandler;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/AbstractSidebar.class */
public abstract class AbstractSidebar implements Sidebar, PlayerDisplayable {
    private final ScoreboardLibraryImpl scoreboardLibrary;
    private final ObjectivePacketAdapter packetAdapter;
    private final GlobalLineInfo[] lines;
    private boolean closed;
    private Component title = Component.empty();
    private final Set<Player> players = new HashSet(8);
    private final Queue<SidebarTask> taskQueue = new ConcurrentLinkedQueue();

    public AbstractSidebar(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl, int i, @NotNull String str) {
        this.scoreboardLibrary = scoreboardLibraryImpl;
        this.packetAdapter = scoreboardLibraryImpl.packetAdapter().createObjectiveAdapter(str);
        this.lines = new GlobalLineInfo[i];
    }

    @NotNull
    protected abstract Set<Player> internalPlayers();

    protected abstract void forEachLineHandler(@NotNull Consumer<LocaleLineHandler> consumer);

    @Nullable
    protected abstract LocaleLineHandler addPlayer0(@NotNull Player player);

    @Nullable
    protected abstract LocaleLineHandler removePlayer0(@NotNull Player player);

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.taskQueue.add(SidebarTask.Close.INSTANCE);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final boolean closed() {
        return this.closed;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @NotNull
    public final Collection<Player> players() {
        return this.closed ? Collections.emptySet() : Collections.unmodifiableSet(this.players);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final boolean addPlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.add(player)) {
            return false;
        }
        this.taskQueue.add(new SidebarTask.AddPlayer(player));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final boolean removePlayer(@NotNull Player player) {
        Preconditions.checkNotNull(player);
        checkClosed();
        if (!this.players.remove(player)) {
            return false;
        }
        this.taskQueue.add(new SidebarTask.RemovePlayer(player));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final int maxLines() {
        return this.lines.length;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @NotNull
    public String objectiveName() {
        return this.packetAdapter.objectiveName();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final void line(int i, @Nullable ComponentLike componentLike, @Nullable ScoreFormat scoreFormat) {
        checkClosed();
        Component componentAsComponent = componentLike == null ? null : componentLike.asComponent();
        GlobalLineInfo lineInfo = getLineInfo(i);
        boolean z = !Objects.equals(lineInfo.value(), componentAsComponent);
        boolean z2 = !Objects.equals(lineInfo.scoreFormat(), scoreFormat);
        if (z || z2) {
            lineInfo.value(componentAsComponent);
            lineInfo.scoreFormat(scoreFormat);
            this.taskQueue.add(new SidebarTask.UpdateLine(i, z, z2));
            updateScores();
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void refreshLine(int i) {
        checkClosed();
        GlobalLineInfo globalLineInfo = this.lines[i];
        if (globalLineInfo != null) {
            this.taskQueue.add(new SidebarTask.UpdateLine(i, globalLineInfo.value() != null, globalLineInfo.scoreFormat() != null));
        }
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @Nullable
    public final Component line(int i) {
        checkClosed();
        GlobalLineInfo globalLineInfo = this.lines[i];
        if (globalLineInfo == null) {
            return null;
        }
        return globalLineInfo.value();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    @NotNull
    public final Component title() {
        return this.title;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public final void title(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        checkClosed();
        Component componentAsComponent = componentLike.asComponent();
        if (Objects.equals(this.title, componentAsComponent)) {
            return;
        }
        this.title = componentAsComponent;
        this.taskQueue.add(SidebarTask.UpdateTitle.INSTANCE);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar
    public void refreshTitle() {
        checkClosed();
        this.taskQueue.add(SidebarTask.UpdateTitle.INSTANCE);
    }

    @NotNull
    public final ScoreboardLibraryImpl scoreboardLibrary() {
        return this.scoreboardLibrary;
    }

    public final ObjectivePacketAdapter packetAdapter() {
        return this.packetAdapter;
    }

    @Nullable
    public final GlobalLineInfo[] lines() {
        return this.lines;
    }

    @NotNull
    public final Queue<SidebarTask> taskQueue() {
        return this.taskQueue;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable
    public final void display(@NotNull Player player) {
        Set setSingleton = Collections.singleton(player);
        this.packetAdapter.sendProperties(setSingleton, PropertiesPacketType.CREATE, this.title, ObjectiveRenderType.INTEGER, ScoreFormat.blank());
        LocaleLineHandler localeLineHandler = (LocaleLineHandler) Objects.requireNonNull(addPlayer0(player));
        localeLineHandler.addPlayer(player);
        localeLineHandler.show(player);
        this.packetAdapter.display(setSingleton, ObjectiveDisplaySlot.sidebar());
    }

    public final boolean tick() {
        while (true) {
            SidebarTask sidebarTaskPoll = this.taskQueue.poll();
            if (sidebarTaskPoll == null) {
                return true;
            }
            if (sidebarTaskPoll instanceof SidebarTask.Close) {
                forEachLineHandler((v0) -> {
                    v0.hide();
                });
                this.packetAdapter.remove(internalPlayers());
                Iterator<Player> it = internalPlayers().iterator();
                while (it.hasNext()) {
                    ((ScoreboardLibraryPlayer) Objects.requireNonNull(this.scoreboardLibrary.getPlayer(it.next()))).sidebarQueue().remove(this);
                }
                return false;
            }
            if (sidebarTaskPoll instanceof SidebarTask.AddPlayer) {
                this.scoreboardLibrary.getOrCreatePlayer(((SidebarTask.AddPlayer) sidebarTaskPoll).player()).sidebarQueue().add(this);
            } else if (sidebarTaskPoll instanceof SidebarTask.RemovePlayer) {
                SidebarTask.RemovePlayer removePlayer = (SidebarTask.RemovePlayer) sidebarTaskPoll;
                LocaleLineHandler localeLineHandlerRemovePlayer0 = removePlayer0(removePlayer.player());
                if (localeLineHandlerRemovePlayer0 != null) {
                    localeLineHandlerRemovePlayer0.hide(removePlayer.player());
                    localeLineHandlerRemovePlayer0.removePlayer(removePlayer.player());
                    this.packetAdapter.remove(Collections.singleton(removePlayer.player()));
                }
                ((ScoreboardLibraryPlayer) Objects.requireNonNull(this.scoreboardLibrary.getPlayer(removePlayer.player()))).sidebarQueue().remove(this);
            } else if (sidebarTaskPoll instanceof SidebarTask.ReloadPlayer) {
                SidebarTask.ReloadPlayer reloadPlayer = (SidebarTask.ReloadPlayer) sidebarTaskPoll;
                LocaleLineHandler localeLineHandlerRemovePlayer1 = removePlayer0(reloadPlayer.player());
                if (localeLineHandlerRemovePlayer1 != null) {
                    this.packetAdapter.remove(Collections.singleton(reloadPlayer.player()));
                    localeLineHandlerRemovePlayer1.hide(reloadPlayer.player());
                    localeLineHandlerRemovePlayer1.removePlayer(reloadPlayer.player());
                    display(reloadPlayer.player());
                }
            } else if (sidebarTaskPoll instanceof SidebarTask.UpdateLine) {
                SidebarTask.UpdateLine updateLine = (SidebarTask.UpdateLine) sidebarTaskPoll;
                forEachLineHandler(localeLineHandler -> {
                    if (updateLine.updateValue()) {
                        Component componentValue = this.lines[updateLine.line()].value();
                        localeLineHandler.updateLine(updateLine.line(), componentValue == null ? null : GlobalTranslator.render(componentValue, localeLineHandler.locale()));
                    }
                    if (updateLine.updateScore()) {
                        localeLineHandler.updateScoreFormat(updateLine.line());
                    }
                });
            } else if (sidebarTaskPoll instanceof SidebarTask.UpdateScores) {
                forEachLineHandler((v0) -> {
                    v0.updateScores();
                });
                for (GlobalLineInfo globalLineInfo : this.lines) {
                    if (globalLineInfo != null) {
                        globalLineInfo.updateScore(false);
                    }
                }
            } else if (sidebarTaskPoll instanceof SidebarTask.UpdateTitle) {
                this.packetAdapter.sendProperties(internalPlayers(), PropertiesPacketType.UPDATE, this.title, ObjectiveRenderType.INTEGER, ScoreFormat.blank());
            }
        }
    }

    private void updateScores() {
        int i = 0;
        for (GlobalLineInfo globalLineInfo : this.lines) {
            if (globalLineInfo != null && globalLineInfo.value() != null) {
                i++;
            }
        }
        boolean z = false;
        int i2 = 0;
        for (GlobalLineInfo globalLineInfo2 : this.lines) {
            if (globalLineInfo2 != null && globalLineInfo2.value() != null) {
                int i3 = (i - i2) - 1;
                if (globalLineInfo2.objectiveScore() != i3) {
                    z = true;
                    globalLineInfo2.updateScore(true);
                    globalLineInfo2.objectiveScore(i3);
                }
                i2++;
            }
        }
        if (z) {
            this.taskQueue.add(SidebarTask.UpdateScores.INSTANCE);
        }
    }

    @NotNull
    private GlobalLineInfo getLineInfo(int i) {
        GlobalLineInfo globalLineInfo = this.lines[i];
        if (globalLineInfo == null) {
            String str = "§" + Character.toChars(128 + i)[0];
            GlobalLineInfo[] globalLineInfoArr = this.lines;
            GlobalLineInfo globalLineInfo2 = new GlobalLineInfo(this, str, i);
            globalLineInfoArr[i] = globalLineInfo2;
            globalLineInfo = globalLineInfo2;
            updateScores();
        }
        return globalLineInfo;
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("Sidebar is closed");
        }
    }
}
