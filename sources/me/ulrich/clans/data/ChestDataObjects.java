package me.ulrich.clans.data;

import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ChestDataObjects.class */
public class ChestDataObjects {
    private int slot;
    private String item;
    private String id;
    private int page;

    public ChestDataObjects(String str, int i, int i2, String str2) {
        setId(str);
        setSlot(i);
        setItem(str2);
        setPage(i2);
    }

    public int getSlot() {
        return this.slot;
    }

    public void setSlot(int i) {
        this.slot = i;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String str) {
        this.item = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChestDataObjects chestDataObjects = (ChestDataObjects) obj;
        return Objects.equals(this.id, chestDataObjects.id) && Objects.equals(this.item, chestDataObjects.item);
    }

    public int hashCode() {
        return Objects.hash(this.id);
    }

    public String toString() {
        return "ChestDataObjects{id=" + this.id + ", slot='" + this.slot + "', item='" + this.item + "', page='" + this.page + "'}";
    }
}
