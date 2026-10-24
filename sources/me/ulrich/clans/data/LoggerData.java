package me.ulrich.clans.data;

import java.util.UUID;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/LoggerData.class */
public class LoggerData {
    private UUID id;
    private UUID clan_id;
    private String text;
    private long date;
    private String plugin;
    private Material material;

    public LoggerData(UUID uuid, UUID uuid2, String str, long j, String str2, Material material) {
        setId(uuid);
        setClan_id(uuid2);
        setText(str);
        setDate(j);
        setPlugin(str2);
        setMaterial(material);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public UUID getClan_id() {
        return this.clan_id;
    }

    public void setClan_id(UUID uuid) {
        this.clan_id = uuid;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public String getPlugin() {
        return this.plugin;
    }

    public void setPlugin(String str) {
        this.plugin = str;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
