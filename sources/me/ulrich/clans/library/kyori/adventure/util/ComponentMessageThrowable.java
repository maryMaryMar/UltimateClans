package me.ulrich.clans.library.kyori.adventure.util;

import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/ComponentMessageThrowable.class */
public interface ComponentMessageThrowable {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    static Component getMessage(@Nullable Throwable th) {
        if (th instanceof ComponentMessageThrowable) {
            return ((ComponentMessageThrowable) th).componentMessage();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    static Component getOrConvertMessage(@Nullable Throwable th) {
        String message;
        if (th instanceof ComponentMessageThrowable) {
            return ((ComponentMessageThrowable) th).componentMessage();
        }
        if (th == 0 || (message = th.getMessage()) == null) {
            return null;
        }
        return Component.text(message);
    }

    @Nullable
    Component componentMessage();
}
