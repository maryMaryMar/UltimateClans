package me.ext.fancyholograms.interfaces;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Fancyholograms.jar:me/ext/fancyholograms/interfaces/Line.class */
public interface Line {
    default void updateHologram(Hologram hologram) {
        hologram.updateLine(hologram.getLineIndex(this), this);
    }
}
