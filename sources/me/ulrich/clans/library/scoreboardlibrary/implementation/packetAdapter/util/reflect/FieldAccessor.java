package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect;

import java.lang.invoke.MethodHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/util/reflect/FieldAccessor.class */
public final class FieldAccessor<T, V> {
    private final MethodHandle getter;
    private final MethodHandle setter;

    public FieldAccessor(@NotNull MethodHandle methodHandle, @Nullable MethodHandle methodHandle2) {
        this.getter = methodHandle;
        this.setter = methodHandle2;
    }

    public Object get(@Nullable T t) {
        try {
            return t == null ? (Object) this.getter.invoke() : (Object) this.getter.invoke(t);
        } catch (Throwable th) {
            throw new IllegalStateException("couldn't set value of field", th);
        }
    }

    public void set(T t, V v) {
        if (this.setter == null) {
            throw new IllegalStateException("cannot set static final field");
        }
        try {
            this.setter.invokeExact(t, v);
        } catch (Throwable th) {
            throw new IllegalStateException("couldn't set value of field", th);
        }
    }
}
