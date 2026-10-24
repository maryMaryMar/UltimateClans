package me.ulrich.clans.library.nbtapi.utils.nmsmappings;


/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/nmsmappings/PackageWrapper.class */
public enum PackageWrapper {
    NMS("net.minecraft.server"),
    CRAFTBUKKIT("org.bukkit.craftbukkit"),
    NONE("");

    private final String uri;

    PackageWrapper(String str) {
        this.uri = str;
    }

    public String getUri() {
        return this.uri;
    }
}
