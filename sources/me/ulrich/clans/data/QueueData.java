package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/QueueData.class */
public class QueueData {
    private ClanEnum.QueueSync type;
    private UUID uuid;

    public QueueData(ClanEnum.QueueSync queueSync, UUID uuid) {
        setType(queueSync);
        setUuid(uuid);
    }

    public ClanEnum.QueueSync getType() {
        return this.type;
    }

    public void setType(ClanEnum.QueueSync queueSync) {
        this.type = queueSync;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
