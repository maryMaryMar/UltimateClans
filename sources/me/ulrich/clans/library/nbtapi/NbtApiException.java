package me.ulrich.clans.library.nbtapi;

import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NbtApiException.class */
public class NbtApiException extends RuntimeException {
    private static final long serialVersionUID = -993309714559452334L;
    public static Boolean confirmedBroken = null;

    public NbtApiException() {
    }

    public NbtApiException(String str, Throwable th) {
        super(generateMessage(str), th);
    }

    public NbtApiException(String str) {
        super(generateMessage(str));
    }

    public NbtApiException(Throwable th) {
        super(generateMessage(th == null ? null : th.toString()), th);
    }

    private static String generateMessage(String str) {
        if (str == null) {
            return null;
        }
        if (confirmedBroken == null) {
            return "[?][" + MinecraftVersion.getNBTAPIVersion() + "]" + str;
        }
        return !confirmedBroken.booleanValue() ? "[Selfchecked][" + MinecraftVersion.getNBTAPIVersion() + "]" + str : "[" + MinecraftVersion.getVersion() + "][" + MinecraftVersion.getNBTAPIVersion() + "]There were errors detected during the server self-check! Please, make sure that NBT-API is up to date. Error message: " + str;
    }
}
