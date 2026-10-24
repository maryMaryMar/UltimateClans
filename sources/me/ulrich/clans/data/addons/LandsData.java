package me.ulrich.clans.data.addons;

import java.util.List;
import java.util.UUID;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LandsData.class */
public class LandsData {
    private UUID uuid;
    private UUID clanid;
    private long claimdate;
    private Location loc1;
    private Location loc2;
    private int level;
    private Location spawn;
    private List<UUID> banned;
    private long lastActivity;
    private String name;
    private List<UUID> trusted;
    private LandsData_flags flags;

    public LandsData(UUID uuid, UUID uuid2, Location location, Location location2, Location location3, List<UUID> list, List<UUID> list2, String str, long j, long j2, int i, LandsData_flags landsData_flags) {
        setUuid(uuid);
        setClanid(uuid2);
        setLoc1(location);
        setLoc2(location2);
        setClaimdate(j);
        setLevel(i);
        setSpawn(location3);
        setBanned(list);
        setTrusted(list2);
        setLastActivity(j2);
        setName(str);
        setFlags(landsData_flags);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getClanid() {
        return this.clanid;
    }

    public void setClanid(UUID uuid) {
        this.clanid = uuid;
    }

    public long getClaimdate() {
        return this.claimdate;
    }

    public void setClaimdate(long j) {
        this.claimdate = j;
    }

    public Location getLoc1() {
        return this.loc1;
    }

    public void setLoc1(Location location) {
        this.loc1 = location;
    }

    public Location getLoc2() {
        return this.loc2;
    }

    public void setLoc2(Location location) {
        this.loc2 = location;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public Location getSpawn() {
        return this.spawn;
    }

    public void setSpawn(Location location) {
        this.spawn = location;
    }

    public List<UUID> getBanned() {
        return this.banned;
    }

    public void setBanned(List<UUID> list) {
        this.banned = list;
    }

    public long getLastActivity() {
        return this.lastActivity;
    }

    public void setLastActivity(long j) {
        this.lastActivity = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<UUID> getTrusted() {
        return this.trusted;
    }

    public void setTrusted(List<UUID> list) {
        this.trusted = list;
    }

    public LandsData_flags getFlags() {
        return this.flags;
    }

    public void setFlags(LandsData_flags landsData_flags) {
        this.flags = landsData_flags;
    }
}
