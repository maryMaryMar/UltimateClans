package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanModeration_permissions.class */
public class ClanModeration_permissions {
    private String key;
    private boolean value;

    public ClanModeration_permissions(String str, boolean z) {
        setKey(str);
        setValue(z);
    }

    public boolean isValue() {
        return this.value;
    }

    public void setValue(boolean z) {
        this.value = z;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
