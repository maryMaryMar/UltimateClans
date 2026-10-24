package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AllyInvite.class */
public class AllyInvite {
    private UUID clanSender;
    private UUID clanReceiver;
    private Long expires;

    public AllyInvite(UUID uuid, UUID uuid2, Long l) {
        setClanSender(uuid);
        setClanReceiver(uuid2);
        setExpires(l);
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

    public Long getExpires() {
        return this.expires;
    }

    public void setExpires(Long l) {
        this.expires = l;
    }
}
