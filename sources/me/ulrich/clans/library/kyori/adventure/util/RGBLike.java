package me.ulrich.clans.library.kyori.adventure.util;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/RGBLike.class */
public interface RGBLike {
    int red();

    int green();

    int blue();

    @NotNull
    default HSVLike asHSV() {
        return HSVLike.fromRGB(red(), green(), blue());
    }
}
