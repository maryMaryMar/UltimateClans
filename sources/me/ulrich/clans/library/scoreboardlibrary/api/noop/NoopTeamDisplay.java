package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.api.team.ScoreboardTeam;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.CollisionRule;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.NameTagVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopTeamDisplay.class */
class NoopTeamDisplay implements TeamDisplay {
    private final NoopScoreboardTeam team;
    private boolean friendlyFire;
    private boolean canSeeFriendlyInvisibles;
    private final Set<String> entries = new HashSet();
    private Component displayName = Component.empty();
    private Component prefix = Component.empty();
    private Component suffix = Component.empty();
    private NameTagVisibility nameTagVisibility = NameTagVisibility.ALWAYS;
    private CollisionRule collisionRule = CollisionRule.ALWAYS;
    private NamedTextColor playerColor = null;

    NoopTeamDisplay(@NotNull NoopScoreboardTeam noopScoreboardTeam) {
        this.team = noopScoreboardTeam;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public ScoreboardTeam team() {
        return this.team;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public Collection<String> entries() {
        return Collections.unmodifiableSet(this.entries);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean addEntry(@NotNull String str) {
        return this.entries.add(str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean addEntries(@NotNull Collection<String> collection) {
        return this.entries.addAll(collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean removeEntry(@NotNull String str) {
        return this.entries.remove(str);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean removeEntries(@NotNull Collection<String> collection) {
        return this.entries.removeAll(collection);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    /* JADX INFO: renamed from: displayName */
    public Component mo890displayName() {
        return this.displayName;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay displayName(@NotNull ComponentLike componentLike) {
        this.displayName = componentLike.asComponent();
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    /* JADX INFO: renamed from: prefix */
    public Component mo889prefix() {
        return this.prefix;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay prefix(@NotNull ComponentLike componentLike) {
        this.prefix = componentLike.asComponent();
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    /* JADX INFO: renamed from: suffix */
    public Component mo888suffix() {
        return this.suffix;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay suffix(@NotNull ComponentLike componentLike) {
        this.suffix = componentLike.asComponent();
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean friendlyFire() {
        return this.friendlyFire;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay friendlyFire(boolean z) {
        this.friendlyFire = z;
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public boolean canSeeFriendlyInvisibles() {
        return this.canSeeFriendlyInvisibles;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    @NotNull
    public TeamDisplay canSeeFriendlyInvisibles(boolean z) {
        this.canSeeFriendlyInvisibles = z;
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
        this.nameTagVisibility = nameTagVisibility;
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
        this.collisionRule = collisionRule;
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
        this.playerColor = namedTextColor;
        return this;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.team.TeamDisplay
    public void refresh() {
    }
}
