package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/EncodedLocationData.class */
public class EncodedLocationData {
    private String server;
    private String world;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    public EncodedLocationData(String str, String str2, double d, double d2, double d3, float f, float f2) {
        setServer(str);
        setWorld(str2);
        setX(d);
        setY(d2);
        setZ(d3);
        setYaw(f);
        setPitch(f2);
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public String getWorld() {
        return this.world;
    }

    public void setWorld(String str) {
        this.world = str;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double d) {
        this.x = d;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double d) {
        this.y = d;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double d) {
        this.z = d;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float f) {
        this.yaw = f;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float f) {
        this.pitch = f;
    }
}
