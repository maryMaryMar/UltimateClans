package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect;

import java.lang.invoke.MethodHandle;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/util/reflect/MethodAccessor.class */
public final class MethodAccessor {
    private final MethodHandle handle;

    public MethodAccessor(@NotNull MethodHandle methodHandle) {
        this.handle = methodHandle;
    }

    public Object invoke(Object... objArr) {
        try {
            return (Object) this.handle.invokeExact(objArr);
        } catch (Throwable th) {
            throw new IllegalStateException("couldn't set value of field", th);
        }
    }
}
