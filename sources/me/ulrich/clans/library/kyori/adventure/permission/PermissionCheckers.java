package me.ulrich.clans.library.kyori.adventure.permission;

import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/permission/PermissionCheckers.class */
final class PermissionCheckers {
    static final PermissionChecker NOT_SET = new Always(TriState.NOT_SET);
    static final PermissionChecker FALSE = new Always(TriState.FALSE);
    static final PermissionChecker TRUE = new Always(TriState.TRUE);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/permission/PermissionCheckers$Always.class */
    private static final class Always implements PermissionChecker {
        private final TriState value;

        private Always(TriState triState) {
            this.value = triState;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.permission.PermissionChecker
        @NotNull
        public TriState value(@NotNull String str) {
            return this.value;
        }

        public String toString() {
            return PermissionChecker.class.getSimpleName() + ".always(" + this.value + ")";
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((Always) obj).value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }
    }

    private PermissionCheckers() {
    }
}
