package me.ulrich.clans.library.kyori.adventure.util;

import java.util.ServiceLoader;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Services0.class */
final class Services0 {
    private Services0() {
    }

    static <S> ServiceLoader<S> loader(Class<S> cls) {
        return ServiceLoader.load(cls, cls.getClassLoader());
    }
}
