package me.ulrich.clans.data.addons;

import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusPlayerRegion.class */
public class NexusPlayerRegion {
    private UUID player;
    private Optional<UUID> region;
    private long enter;

    public NexusPlayerRegion(UUID uuid, Optional<UUID> optional, long j) {
        setPlayer(uuid);
        setRegion(optional);
        setEnter(j);
    }

    public UUID getPlayer() {
        return this.player;
    }

    public void setPlayer(UUID uuid) {
        this.player = uuid;
    }

    public Optional<UUID> getRegion() {
        return this.region;
    }

    public void setRegion(Optional<UUID> optional) {
        this.region = optional;
    }

    public long getEnter() {
        return this.enter;
    }

    public void setEnter(long j) {
        this.enter = j;
    }
}
