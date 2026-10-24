package me.ulrich.clans.library.nbtapi.utils;

import me.ulrich.clans.library.nbtapi.NbtApiException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/CheckUtil.class */
public class CheckUtil {
    private CheckUtil() {
    }

    public static void assertAvailable(MinecraftVersion minecraftVersion) {
        if (!MinecraftVersion.isAtLeastVersion(minecraftVersion)) {
            throw new NbtApiException("This Method is only avaliable for the version " + minecraftVersion.name() + " and above!");
        }
    }
}
