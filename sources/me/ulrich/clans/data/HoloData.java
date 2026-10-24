package me.ulrich.clans.data;

import java.util.List;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/HoloData.class */
public class HoloData {
    private String id;
    private Location loc;
    private Object hologram;
    private Object extra;
    private List<String> lines;

    public HoloData(String str, Location location, Object obj, List<String> list, Object... objArr) {
        setId(str);
        setLoc(location);
        setHologram(obj);
        setLines(list);
        setExtra(objArr);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Location getLoc() {
        return this.loc;
    }

    public void setLoc(Location location) {
        this.loc = location;
    }

    public Object getHologram() {
        return this.hologram;
    }

    public void setHologram(Object obj) {
        this.hologram = obj;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public List<String> getLines() {
        return this.lines;
    }

    public void setLines(List<String> list) {
        this.lines = list;
    }
}
