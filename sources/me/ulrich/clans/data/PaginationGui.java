package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/PaginationGui.class */
public class PaginationGui {
    private String id;
    private String invName;
    private int invRows;
    private List<GuiItemStack> items;
    private String soundOpen;
    private int maxItems;

    public PaginationGui(String str, String str2, int i, String str3, int i2, List<GuiItemStack> list) {
        setId(str);
        setInvName(str2);
        setInvRows(i);
        setItems(list);
        setSoundOpen(str3);
        setMaxItems(i2);
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

    public int getMaxItems() {
        return this.maxItems;
    }

    public void setMaxItems(int i) {
        this.maxItems = i;
    }
}
