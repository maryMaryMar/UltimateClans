package me.ulrich.clans.data;

import java.util.HashMap;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/GuiData.class */
public class GuiData {
    private String id;
    private String title;
    private String opensound;
    private HashMap<String, GuiItemsData> items;
    private int rows;
    private int pageSize;

    public GuiData(String str, String str2, int i, int i2, String str3, HashMap<String, GuiItemsData> map) {
        setId(str);
        setTitle(str2);
        setOpensound(str3);
        setRows(i);
        setPageSize(i2);
        setItems(map);
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

    public HashMap<String, GuiItemsData> getItems() {
        return this.items;
    }

    public void setItems(HashMap<String, GuiItemsData> map) {
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
