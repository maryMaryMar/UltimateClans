package me.ulrich.clans.library.kyori.adventure.permission;

import java.util.Objects;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointer;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/permission/PermissionChecker.class */
public interface PermissionChecker extends Predicate<String> {
    public static final Pointer<PermissionChecker> POINTER = Pointer.pointer(PermissionChecker.class, Key.key(Adventure.NAMESPACE, "permission"));

    @NotNull
    static PermissionChecker always(@NotNull TriState triState) {
        Objects.requireNonNull(triState);
        if (triState == TriState.TRUE) {
            return PermissionCheckers.TRUE;
        }
        return triState == TriState.FALSE ? PermissionCheckers.FALSE : PermissionCheckers.NOT_SET;
    }

    @NotNull
    TriState value(@NotNull String str);

    @Override // java.util.function.Predicate
    default boolean test(@NotNull String str) {
        return value(str) == TriState.TRUE;
    }
}
