package me.ulrich.clans.data;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/NbtData.class */
public class NbtData {
    private List<String> string;
    private int model;

    public NbtData(List<String> list, int i) {
        setString(list);
        setModel(i);
    }

    public List<String> getString() {
        return this.string;
    }

    public void setString(List<String> list) {
        this.string = list;
    }

    public int getModel() {
        return this.model;
    }

    public void setModel(int i) {
        this.model = i;
    }
}
