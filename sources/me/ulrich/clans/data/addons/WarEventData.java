package me.ulrich.clans.data.addons;

import java.util.List;
import java.util.UUID;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/WarEventData.class */
public class WarEventData {
    private UUID clanId1;
    private UUID clanId2;
    private List<Player> clanJoined1;
    private List<Player> clanJoined2;
    private int max;
    private String arena;
    private String kit;

    public WarEventData(UUID uuid, UUID uuid2, List<Player> list, List<Player> list2, int i, String str, String str2) {
        setClanId1(uuid);
        setClanId2(uuid2);
        setClanJoined1(list);
        setClanJoined2(list2);
        setMax(i);
        setArena(str);
        setKit(str2);
    }

    public UUID getClanId1() {
        return this.clanId1;
    }

    public void setClanId1(UUID uuid) {
        this.clanId1 = uuid;
    }

    public UUID getClanId2() {
        return this.clanId2;
    }

    public void setClanId2(UUID uuid) {
        this.clanId2 = uuid;
    }

    public List<Player> getClanJoined1() {
        return this.clanJoined1;
    }

    public void setClanJoined1(List<Player> list) {
        this.clanJoined1 = list;
    }

    public List<Player> getClanJoined2() {
        return this.clanJoined2;
    }

    public void setClanJoined2(List<Player> list) {
        this.clanJoined2 = list;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public String getArena() {
        return this.arena;
    }

    public void setArena(String str) {
        this.arena = str;
    }

    public String getKit() {
        return this.kit;
    }

    public void setKit(String str) {
        this.kit = str;
    }
}
