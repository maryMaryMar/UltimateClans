package me.ulrich.clans.data;

import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanRivalAlly.class */
public class ClanRivalAlly {
    private List<UUID> rival;
    private List<UUID> ally;

    public ClanRivalAlly(List<UUID> list, List<UUID> list2) {
        setRival(list);
        setAlly(list2);
    }

    public List<UUID> getRival() {
        return this.rival;
    }

    public void setRival(List<UUID> list) {
        this.rival = list;
    }

    public List<UUID> getAlly() {
        return this.ally;
    }

    public void setAlly(List<UUID> list) {
        this.ally = list;
    }
}
