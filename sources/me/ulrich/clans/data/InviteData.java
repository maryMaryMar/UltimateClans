package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/InviteData.class */
public class InviteData {
    private UUID id;
    private UUID player;
    private UUID clanID;
    private UUID inviter;
    private long date;

    public InviteData(UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4, long j) {
        setId(uuid);
        setPlayer(uuid2);
        setClanID(uuid3);
        setInviter(uuid4);
        setDate(j);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public UUID getPlayer() {
        return this.player;
    }

    public void setPlayer(UUID uuid) {
        this.player = uuid;
    }

    public UUID getClanID() {
        return this.clanID;
    }

    public void setClanID(UUID uuid) {
        this.clanID = uuid;
    }

    public UUID getInviter() {
        return this.inviter;
    }

    public void setInviter(UUID uuid) {
        this.inviter = uuid;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }
}
