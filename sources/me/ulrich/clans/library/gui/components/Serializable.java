package me.ulrich.clans.library.gui.components;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/Serializable.class */
public interface Serializable {
    List<String> encodeGui();

    void decodeGui(@NotNull List<String> list);
}
