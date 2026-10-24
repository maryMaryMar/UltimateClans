package me.ulrich.clans.library.gui.components.util;

import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/util/Legacy.class */
public final class Legacy {
    public static final LegacyComponentSerializer SERIALIZER = LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();

    private Legacy() {
        throw new UnsupportedOperationException("Class should not be instantiated!");
    }
}
