package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/RivalRemove.class */
public class RivalRemove {
    private UUID clanSender;
    private UUID clanReceiver;
    private long expires;

    public RivalRemove(UUID uuid, UUID uuid2, long j) {
        setClanSender(uuid);
        setClanReceiver(uuid2);
        setExpires(j);
    }

    public UUID getClanSender() {
        return this.clanSender;
    }

    public void setClanSender(UUID uuid) {
        this.clanSender = uuid;
    }

    public UUID getClanReceiver() {
        return this.clanReceiver;
    }

    public void setClanReceiver(UUID uuid) {
        this.clanReceiver = uuid;
    }

    public long getExpires() {
        return this.expires;
    }

    public void setExpires(long j) {
        this.expires = j;
    }
}
