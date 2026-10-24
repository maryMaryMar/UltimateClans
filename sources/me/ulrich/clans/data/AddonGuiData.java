package me.ulrich.clans.data;

import java.util.HashMap;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/AddonGuiData.class */
public class AddonGuiData implements Cloneable {
    private String id;
    private String title;
    private String opensound;
    private HashMap<String, AddonGuiItemsData> items;
    private int rows;
    private int pageSize;

    public AddonGuiData(String str, String str2, int i, int i2, String str3, HashMap<String, AddonGuiItemsData> map) {
        setId(str);
        setTitle(str2);
        setPageSize(i2);
        setOpensound(str3);
        setRows(i);
        setItems(map);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AddonGuiData m385clone() {
        try {
            return (AddonGuiData) super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getOpensound() {
        return this.opensound;
    }

    public void setOpensound(String str) {
        this.opensound = str;
    }

    public HashMap<String, AddonGuiItemsData> getItems() {
        return this.items;
    }

    public void setItems(HashMap<String, AddonGuiItemsData> map) {
        this.items = map;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int i) {
        this.rows = i;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }
}
