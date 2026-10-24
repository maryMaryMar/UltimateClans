package me.ulrich.clans.library.kyori.adventure.resource;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/resource/ResourcePackStatus.class */
public enum ResourcePackStatus {
    ACCEPTED(true),
    DECLINED(false),
    INVALID_URL(false),
    FAILED_DOWNLOAD(false),
    DOWNLOADED(true),
    FAILED_RELOAD(false),
    DISCARDED(false),
    SUCCESSFULLY_LOADED(false);

    private final boolean intermediate;

    ResourcePackStatus(boolean z) {
        this.intermediate = z;
    }

    public boolean intermediate() {
        return this.intermediate;
    }
}
