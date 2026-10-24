package me.ulrich.clans.data.addons;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LeagueSeasonData.class */
public class LeagueSeasonData {
    private UUID id;
    private String name;
    private Material icon;
    private String desc;
    private long start;
    private long end;
    private String rawname;
    private Optional<UUID> winner;
    private Optional<LeagueRewardsData> rewards;
    private AddonEnum.LeagueStatus status;

    public LeagueSeasonData(UUID uuid, String str, String str2, Material material, String str3, long j, long j2, Optional<UUID> optional, Optional<LeagueRewardsData> optional2, AddonEnum.LeagueStatus leagueStatus) {
        setId(uuid);
        setRawname(str);
        setName(str2);
        setIcon(material);
        setDesc(str3);
        setStart(j);
        setEnd(j2);
        setWinner(optional);
        setRewards(optional2);
        setStatus(leagueStatus);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Material getIcon() {
        return this.icon;
    }

    public void setIcon(Material material) {
        this.icon = material;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public String getRawname() {
        return this.rawname;
    }

    public void setRawname(String str) {
        this.rawname = str;
    }

    public Optional<UUID> getWinner() {
        return this.winner;
    }

    public void setWinner(Optional<UUID> optional) {
        this.winner = optional;
    }

    public Optional<LeagueRewardsData> getRewards() {
        return this.rewards;
    }

    public void setRewards(Optional<LeagueRewardsData> optional) {
        this.rewards = optional;
    }

    public AddonEnum.LeagueStatus getStatus() {
        return this.status;
    }

    public void setStatus(AddonEnum.LeagueStatus leagueStatus) {
        this.status = leagueStatus;
    }
}
