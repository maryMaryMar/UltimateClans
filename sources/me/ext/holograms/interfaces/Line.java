package me.ext.holograms.interfaces;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Holograms.jar:me/ext/holograms/interfaces/Line.class */
public interface Line {
    default void updateHologram(Hologram hologram) {
        hologram.updateLine(hologram.getLineIndex(this), this);
    }
}
