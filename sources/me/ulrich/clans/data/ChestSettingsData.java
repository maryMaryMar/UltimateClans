package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ChestSettingsData.class */
public class ChestSettingsData {
    private int extraChest;
    private List<Integer> lockedPages;

    public ChestSettingsData(int i, List<Integer> list) {
        setExtraChest(i);
        setLockedPages(list);
    }

    public int getExtraChest() {
        return this.extraChest;
    }

    public void setExtraChest(int i) {
        this.extraChest = i;
    }

    public List<Integer> getLockedPages() {
        return this.lockedPages;
    }

    public void setLockedPages(List<Integer> list) {
        this.lockedPages = list;
    }
}
