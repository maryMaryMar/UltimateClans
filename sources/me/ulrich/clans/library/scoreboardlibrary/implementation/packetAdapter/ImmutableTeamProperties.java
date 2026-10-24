package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.CollisionRule;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.NameTagVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/ImmutableTeamProperties.class */
public interface ImmutableTeamProperties<T> {
    @NotNull
    default Collection<String> syncedEntries() {
        return ImmutableList.of();
    }

    @NotNull
    /* JADX INFO: renamed from: displayName */
    T mo890displayName();

    @NotNull
    /* JADX INFO: renamed from: prefix */
    T mo889prefix();

    @NotNull
    /* JADX INFO: renamed from: suffix */
    T mo888suffix();

    default boolean friendlyFire() {
        return false;
    }

    default boolean canSeeFriendlyInvisibles() {
        return false;
    }

    @NotNull
    default NameTagVisibility nameTagVisibility() {
        return NameTagVisibility.ALWAYS;
    }

    @NotNull
    default CollisionRule collisionRule() {
        return CollisionRule.ALWAYS;
    }

    @Nullable
    default NamedTextColor playerColor() {
        return null;
    }

    default int packOptions() {
        int i = 0;
        if (friendlyFire()) {
            i = 0 | 1;
        }
        if (canSeeFriendlyInvisibles()) {
            i |= 2;
        }
        return i;
    }
}
