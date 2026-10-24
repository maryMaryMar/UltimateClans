package me.ulrich.clans.data;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/RewardsData.class */
public class RewardsData {
    private UUID id;
    private UUID clanUUID;
    private UUID sender;
    private Optional<String> description;
    private List<String> rewards;
    private List<UUID> collectedBy;
    private long date;
    private Optional<Material> icon;
    private Optional<String> complement;

    public RewardsData(UUID uuid, UUID uuid2, UUID uuid3, Optional<String> optional, List<String> list, List<UUID> list2, Optional<Material> optional2, long j, Optional<String> optional3) {
        setId(uuid);
        setClanUUID(uuid2);
        setSender(uuid3);
        setDescription(optional);
        setRewards(list);
        setCollectedBy(list2);
        setIcon(optional2);
        setDate(j);
        setComplement(optional3);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public void setClanUUID(UUID uuid) {
        this.clanUUID = uuid;
    }

    public UUID getSender() {
        return this.sender;
    }

    public void setSender(UUID uuid) {
        this.sender = uuid;
    }

    public List<String> getRewards() {
        return this.rewards;
    }

    public void setRewards(List<String> list) {
        this.rewards = list;
    }

    public List<UUID> getCollectedBy() {
        return this.collectedBy;
    }

    public void setCollectedBy(List<UUID> list) {
        this.collectedBy = list;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public Optional<String> getDescription() {
        return this.description;
    }

    public void setDescription(Optional<String> optional) {
        this.description = optional;
    }

    public Optional<Material> getIcon() {
        return this.icon;
    }

    public void setIcon(Optional<Material> optional) {
        this.icon = optional;
    }

    public Optional<String> getComplement() {
        return this.complement;
    }

    public void setComplement(Optional<String> optional) {
        this.complement = optional;
    }
}
