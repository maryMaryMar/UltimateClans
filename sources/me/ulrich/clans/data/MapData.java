package me.ulrich.clans.data;

import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/MapData.class */
public class MapData {
    private String borderColor;
    private double borderOpacity;
    private String fillColor;
    private String finalDescription;
    private double fillOpacity;
    private Object[] objects;
    private String markName;
    private Location loc1;
    private Location loc2;
    private int borderSize;

    public MapData(String str, Location location, Location location2, String str2, double d, int i, String str3, double d2, String str4, Object... objArr) {
        setMarkName(str);
        setBorderColor(str2);
        setBorderOpacity(d);
        setBorderSize(i);
        setFillColor(str3);
        setFillOpacity(d2);
        setFinalDescription(str4);
        setObjects(objArr);
        setLoc1(location);
        setLoc2(location2);
    }

    public String getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(String str) {
        this.borderColor = str;
    }

    public double getBorderOpacity() {
        return this.borderOpacity;
    }

    public void setBorderOpacity(double d) {
        this.borderOpacity = d;
    }

    public String getFillColor() {
        return this.fillColor;
    }

    public void setFillColor(String str) {
        this.fillColor = str;
    }

    public String getFinalDescription() {
        return this.finalDescription;
    }

    public void setFinalDescription(String str) {
        this.finalDescription = str;
    }

    public double getFillOpacity() {
        return this.fillOpacity;
    }

    public void setFillOpacity(double d) {
        this.fillOpacity = d;
    }

    public Object[] getObjects() {
        return this.objects;
    }

    public void setObjects(Object[] objArr) {
        this.objects = objArr;
    }

    public String getMarkName() {
        return this.markName;
    }

    public void setMarkName(String str) {
        this.markName = str;
    }

    public Location getLoc1() {
        return this.loc1;
    }

    public void setLoc1(Location location) {
        this.loc1 = location;
    }

    public Location getLoc2() {
        return this.loc2;
    }

    public void setLoc2(Location location) {
        this.loc2 = location;
    }

    public int getBorderSize() {
        return this.borderSize;
    }

    public void setBorderSize(int i) {
        this.borderSize = i;
    }
}
