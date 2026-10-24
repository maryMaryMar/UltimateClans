package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AddonInfo.class */
public class AddonInfo {
    private boolean enabled;
    private String data;

    public AddonInfo(boolean z, String str) {
        this.enabled = z;
        this.data = str;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String getData() {
        return this.data;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setData(String str) {
        this.data = str;
    }
}
