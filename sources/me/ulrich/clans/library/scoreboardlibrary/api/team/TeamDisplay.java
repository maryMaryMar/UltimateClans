package me.ulrich.clans.library.scoreboardlibrary.api.team;

import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.CollisionRule;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.NameTagVisibility;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/team/TeamDisplay.class */
@ApiStatus.NonExtendable
public interface TeamDisplay {
    @NotNull
    ScoreboardTeam team();

    @NotNull
    Collection<String> entries();

    boolean addEntry(@NotNull String str);

    boolean addEntries(@NotNull Collection<String> collection);

    boolean removeEntry(@NotNull String str);

    boolean removeEntries(@NotNull Collection<String> collection);

    @NotNull
    Component displayName();

    @NotNull
    TeamDisplay displayName(@NotNull ComponentLike componentLike);

    @NotNull
    Component prefix();

    @NotNull
    TeamDisplay prefix(@NotNull ComponentLike componentLike);

    @NotNull
    Component suffix();

    @NotNull
    TeamDisplay suffix(@NotNull ComponentLike componentLike);

    boolean friendlyFire();

    @NotNull
    TeamDisplay friendlyFire(boolean z);

    boolean canSeeFriendlyInvisibles();

    @NotNull
    TeamDisplay canSeeFriendlyInvisibles(boolean z);

    @NotNull
    NameTagVisibility nameTagVisibility();

    @NotNull
    TeamDisplay nameTagVisibility(@NotNull NameTagVisibility nameTagVisibility);

    @NotNull
    CollisionRule collisionRule();

    @NotNull
    TeamDisplay collisionRule(@NotNull CollisionRule collisionRule);

    @Nullable
    NamedTextColor playerColor();

    @NotNull
    TeamDisplay playerColor(@Nullable NamedTextColor namedTextColor);

    void refresh();
}
