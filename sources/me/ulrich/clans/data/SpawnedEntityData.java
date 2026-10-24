package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/SpawnedEntityData.class */
public class SpawnedEntityData {
    private int id;
    private long lastMove;
    private boolean afk;
    private int passager;

    public SpawnedEntityData(int i, long j, boolean z, int i2) {
        setId(i);
        setLastMove(j);
        setAfk(z);
        setPassager(i2);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public long getLastMove() {
        return this.lastMove;
    }

    public void setLastMove(long j) {
        this.lastMove = j;
    }

    public boolean isAfk() {
        return this.afk;
    }

    public void setAfk(boolean z) {
        this.afk = z;
    }

    public int getPassager() {
        return this.passager;
    }

    public void setPassager(int i) {
        this.passager = i;
    }
}
