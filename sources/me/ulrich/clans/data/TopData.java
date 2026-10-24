package me.ulrich.clans.data;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/TopData.class */
public class TopData {
    private UUID uuid;
    private Float value;

    public TopData(UUID uuid, Float f) {
        setUuid(uuid);
        setValue(f);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float f) {
        this.value = f;
    }
}
