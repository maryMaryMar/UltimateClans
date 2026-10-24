package me.ulrich.clans.library.kyori.adventure.util;

import java.util.function.BooleanSupplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/TriState.class */
public enum TriState {
    NOT_SET,
    FALSE,
    TRUE;

    @Nullable
    public Boolean toBoolean() {
        switch (this) {
            case TRUE:
                return Boolean.TRUE;
            case FALSE:
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    public boolean toBooleanOrElse(boolean z) {
        switch (this) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            default:
                return z;
        }
    }

    public boolean toBooleanOrElseGet(@NotNull BooleanSupplier booleanSupplier) {
        switch (this) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            default:
                return booleanSupplier.getAsBoolean();
        }
    }

    @NotNull
    public static TriState byBoolean(boolean z) {
        return z ? TRUE : FALSE;
    }

    @NotNull
    public static TriState byBoolean(@Nullable Boolean bool) {
        return bool == null ? NOT_SET : byBoolean(bool.booleanValue());
    }
}
