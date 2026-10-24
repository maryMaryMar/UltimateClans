package me.ulrich.clans.data.addons;

import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/WarKitData.class */
public class WarKitData {
    private String name;
    private String desc;
    private String serialized;
    private long creationDate;
    private Material icon;

    public WarKitData(String str, String str2, String str3, long j, Material material) {
        setName(str);
        setDesc(str2);
        setSerialized(str3);
        setCreationDate(j);
        setIcon(material);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getSerialized() {
        return this.serialized;
    }

    public void setSerialized(String str) {
        this.serialized = str;
    }

    public long getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(long j) {
        this.creationDate = j;
    }

    public Material getIcon() {
        return this.icon;
    }

    public void setIcon(Material material) {
        this.icon = material;
    }
}
