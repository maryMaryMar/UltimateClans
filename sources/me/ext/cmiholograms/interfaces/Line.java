package me.ext.cmiholograms.interfaces;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Cmiholograms.jar:me/ext/cmiholograms/interfaces/Line.class */
public interface Line {
    default void updateHologram(Hologram hologram) {
        hologram.updateLine(hologram.getLineIndex(this), this);
    }
}
