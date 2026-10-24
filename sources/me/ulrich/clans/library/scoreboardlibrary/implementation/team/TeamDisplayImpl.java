package me.ulrich.clans.library.scoreboardlibrary.implementation.team;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.CollisionRule;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.NameTagVisibility;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.EntriesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.team.TeamDisplayPacketAdapter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamDisplayImpl.class */
public final class TeamDisplayImpl implements TeamDisplay, ImmutableTeamProperties<Component> {
    private final ScoreboardTeamImpl team;
    private final TeamDisplayPacketAdapter packetAdapter;
    private boolean friendlyFire;
    private boolean canSeeFriendlyInvisibles;
    private final Set<Player> players = new HashSet(4);
    private final List<String> entries = new ArrayList(4);
    private final List<String> syncedEntries = new ArrayList(4);
    private Component displayName = Component.empty();
    private Component prefix = Component.empty();
    private Component suffix = Component.empty();
    private NameTagVisibility nameTagVisibility = NameTagVisibility.ALWAYS;
    private CollisionRule collisionRule = CollisionRule.ALWAYS;
    private NamedTextColor playerColor = null;

    public TeamDisplayImpl(@NotNull ScoreboardTeamImpl scoreboardTeamImpl) {
        this.team = scoreboardTeamImpl;
        this.packetAdapter = scoreboardTeamImpl.packetAdapter().createTeamDisplayAdapter(this);
        this.packetAdapter.updateTeamPackets();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public ScoreboardTeam team() {
        return this.team;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public Collection<String> entries() {
        return Collections.unmodifiableCollection(this.entries);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    public Collection<String> syncedEntries() {
        return this.syncedEntries;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean addEntry(@NotNull String str) {
        if (this.entries.contains(str)) {
            return false;
        }
        this.entries.add(str);
        this.team.teamManager().taskQueue().add(new TeamManagerTask.AddEntries(this, Collections.singleton(str)));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean addEntries(@NotNull Collection<String> collection) {
        HashSet hashSet = new HashSet(this.entries);
        ArrayList arrayList = new ArrayList(collection);
        Objects.requireNonNull(hashSet);
        arrayList.removeIf((v1) -> {
            return r1.contains(v1);
        });
        if (arrayList.isEmpty()) {
            return false;
        }
        this.entries.addAll(arrayList);
        this.team.teamManager().taskQueue().add(new TeamManagerTask.AddEntries(this, arrayList));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean removeEntry(@NotNull String str) {
        if (!this.entries.remove(str)) {
            return false;
        }
        this.team.teamManager().taskQueue().add(new TeamManagerTask.RemoveEntries(this, Collections.singleton(str)));
        return true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean removeEntries(@NotNull Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection);
        arrayList.retainAll(this.entries);
        if (arrayList.isEmpty()) {
            return false;
        }
        this.entries.removeAll(arrayList);
        this.team.teamManager().taskQueue().add(new TeamManagerTask.RemoveEntries(this, arrayList));
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: displayName, reason: merged with bridge method [inline-methods] */
    public Component mo890displayName() {
        return this.displayName;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay displayName(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        Component componentAsComponent = componentLike.asComponent();
        if (!Objects.equals(this.displayName, componentAsComponent)) {
            this.displayName = componentAsComponent;
            scheduleUpdate();
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: prefix, reason: merged with bridge method [inline-methods] */
    public Component mo889prefix() {
        return this.prefix;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay prefix(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        Component componentAsComponent = componentLike.asComponent();
        if (!Objects.equals(this.prefix, componentAsComponent)) {
            this.prefix = componentAsComponent;
            scheduleUpdate();
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties
    @NotNull
    /* JADX INFO: renamed from: suffix, reason: merged with bridge method [inline-methods] */
    public Component mo888suffix() {
        return this.suffix;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay suffix(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        Component componentAsComponent = componentLike.asComponent();
        if (!Objects.equals(this.suffix, componentAsComponent)) {
            this.suffix = componentAsComponent;
            scheduleUpdate();
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean friendlyFire() {
        return this.friendlyFire;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay friendlyFire(boolean z) {
        if (this.friendlyFire != z) {
            this.friendlyFire = z;
            scheduleUpdate();
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean canSeeFriendlyInvisibles() {
        return this.canSeeFriendlyInvisibles;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay canSeeFriendlyInvisibles(boolean z) {
        if (this.canSeeFriendlyInvisibles != z) {
            this.canSeeFriendlyInvisibles = z;
            scheduleUpdate();
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public NameTagVisibility nameTagVisibility() {
        return this.nameTagVisibility;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay nameTagVisibility(@NotNull NameTagVisibility nameTagVisibility) {
        Preconditions.checkNotNull(nameTagVisibility);
        if (!Objects.equals(this.nameTagVisibility, nameTagVisibility)) {
            this.nameTagVisibility = nameTagVisibility;
            scheduleUpdate();
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public CollisionRule collisionRule() {
        return this.collisionRule;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay collisionRule(@NotNull CollisionRule collisionRule) {
        Preconditions.checkNotNull(collisionRule);
        if (!Objects.equals(this.collisionRule, collisionRule)) {
            this.collisionRule = collisionRule;
            scheduleUpdate();
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @Nullable
    public NamedTextColor playerColor() {
        return this.playerColor;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay playerColor(@Nullable NamedTextColor namedTextColor) {
        if (!Objects.equals(this.playerColor, namedTextColor)) {
            this.playerColor = namedTextColor;
            scheduleUpdate();
        }
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public void refresh() {
        scheduleUpdate();
    }

    @NotNull
    public TeamDisplayPacketAdapter packetAdapter() {
        return this.packetAdapter;
    }

    @NotNull
    public Set<Player> players() {
        return this.players;
    }

    public void handleUpdateDisplay() {
        this.packetAdapter.updateTeamPackets();
        packetAdapter().sendProperties(PropertiesPacketType.UPDATE, players());
    }

    public void handleAddEntries(@NotNull Collection<String> collection) {
        this.packetAdapter.sendEntries(EntriesPacketType.ADD, players(), collection);
        this.syncedEntries.addAll(collection);
        this.packetAdapter.updateTeamPackets();
    }

    public void handleRemoveEntries(@NotNull Collection<String> collection) {
        this.packetAdapter.sendEntries(EntriesPacketType.REMOVE, players(), collection);
        this.syncedEntries.removeAll(collection);
        this.packetAdapter.updateTeamPackets();
    }

    private void scheduleUpdate() {
        Queue<TeamManagerTask> queueTaskQueue = this.team.teamManager().taskQueue();
        TeamManagerTask teamManagerTaskPeek = queueTaskQueue.peek();
        if ((teamManagerTaskPeek instanceof TeamManagerTask.UpdateTeamDisplay) && ((TeamManagerTask.UpdateTeamDisplay) teamManagerTaskPeek).teamDisplay() == this) {
            return;
        }
        queueTaskQueue.add(new TeamManagerTask.UpdateTeamDisplay(this));
    }
}
