package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/util/reflect/ConstructorAccessor.class */
public interface ConstructorAccessor<T> {
    @NotNull
    T invoke(Object... objArr);
}
