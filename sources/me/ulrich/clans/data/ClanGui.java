package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ClanGui.class */
public class ClanGui {
    private String id;
    private String invName;
    private int invRows;
    private List<GuiItemStack> items;
    private String soundOpen;

    public ClanGui(String str, String str2, int i, String str3, List<GuiItemStack> list) {
        setId(str);
        setInvName(str2);
        setInvRows(i);
        setSoundOpen(str3);
        setItems(list);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getInvName() {
        return this.invName;
    }

    public void setInvName(String str) {
        this.invName = str;
    }

    public int getInvRows() {
        return this.invRows;
    }

    public void setInvRows(int i) {
        this.invRows = i;
    }

    public String getSoundOpen() {
        return this.soundOpen;
    }

    public void setSoundOpen(String str) {
        this.soundOpen = str;
    }

    public List<GuiItemStack> getItems() {
        return this.items;
    }

    public void setItems(List<GuiItemStack> list) {
        this.items = list;
    }
}
