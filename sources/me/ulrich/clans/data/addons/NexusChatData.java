package me.ulrich.clans.data.addons;

import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusChatData.class */
public class NexusChatData {
    private String key;
    private Object value;
    private Player player;
    private AddonEnum.NexusDataType dataType;
    private long expires;
    private boolean reopen;

    public NexusChatData(String str, Object obj, Player player, AddonEnum.NexusDataType nexusDataType, long j, boolean z) {
        setKey(str);
        setValue(obj);
        setPlayer(player);
        setDataType(nexusDataType);
        setExpires(j);
        setReopen(z);
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public AddonEnum.NexusDataType getDataType() {
        return this.dataType;
    }

    public void setDataType(AddonEnum.NexusDataType nexusDataType) {
        this.dataType = nexusDataType;
    }

    public long getExpires() {
        return this.expires;
    }

    public void setExpires(long j) {
        this.expires = j;
    }

    public boolean isReopen() {
        return this.reopen;
    }

    public void setReopen(boolean z) {
        this.reopen = z;
    }
}
