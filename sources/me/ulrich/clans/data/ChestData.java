package me.ulrich.clans.data;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ChestData.class */
public class ChestData {
    private UUID clanid;
    private HashMap<Integer, List<ChestDataObjects>> listChest;

    public ChestData(UUID uuid, HashMap<Integer, List<ChestDataObjects>> map) {
        setClanid(uuid);
        setListChest(map);
    }

    public UUID getClanid() {
        return this.clanid;
    }

    public void setClanid(UUID uuid) {
        this.clanid = uuid;
    }

    public HashMap<Integer, List<ChestDataObjects>> getListChest() {
        return this.listChest;
    }

    public void setListChest(HashMap<Integer, List<ChestDataObjects>> map) {
        this.listChest = map;
    }
}
