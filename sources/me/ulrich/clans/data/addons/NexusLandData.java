package me.ulrich.clans.data.addons;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusLandData.class */
public class NexusLandData {
    private UUID uuid;
    private UUID clanUUID;
    private String name;
    private NexusStatsData stats;
    private List<UUID> bannedPlayers;
    private NexusSettingsData landSettings;
    private List<NexusTerrainData> terrains;
    private List<UUID> trustedPlayers;
    private Location home;
    private Long creationDate;
    private Optional<NexusData> nexus;

    public NexusLandData(UUID uuid, UUID uuid2, String str, List<UUID> list, NexusSettingsData nexusSettingsData, NexusStatsData nexusStatsData, List<NexusTerrainData> list2, List<UUID> list3, Location location, Long l, Optional<NexusData> optional) {
        setUuid(uuid);
        setClanUUID(uuid2);
        setName(str);
        setBannedPlayers(list);
        setLandSettings(nexusSettingsData);
        setStats(nexusStatsData);
        setTerrains(list2);
        setTrustedPlayers(list3);
        setHome(location);
        setCreationDate(l);
        setNexus(optional);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public void setClanUUID(UUID uuid) {
        this.clanUUID = uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public NexusStatsData getStats() {
        return this.stats;
    }

    public void setStats(NexusStatsData nexusStatsData) {
        this.stats = nexusStatsData;
    }

    public List<UUID> getBannedPlayers() {
        return this.bannedPlayers;
    }

    public void setBannedPlayers(List<UUID> list) {
        this.bannedPlayers = list;
    }

    public NexusSettingsData getLandSettings() {
        return this.landSettings;
    }

    public void setLandSettings(NexusSettingsData nexusSettingsData) {
        this.landSettings = nexusSettingsData;
    }

    public List<NexusTerrainData> getTerrains() {
        return this.terrains;
    }

    public void setTerrains(List<NexusTerrainData> list) {
        this.terrains = list;
    }

    public List<UUID> getTrustedPlayers() {
        return this.trustedPlayers;
    }

    public void setTrustedPlayers(List<UUID> list) {
        this.trustedPlayers = list;
    }

    public Location getHome() {
        return this.home;
    }

    public void setHome(Location location) {
        this.home = location;
    }

    public Long getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Long l) {
        this.creationDate = l;
    }

    public Optional<NexusData> getNexus() {
        return this.nexus;
    }

    public void setNexus(Optional<NexusData> optional) {
        this.nexus = optional;
    }
}
