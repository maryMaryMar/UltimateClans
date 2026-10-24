package me.ulrich.clans.data;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/EntityOptionsData.class */
public class EntityOptionsData {
    private boolean baby;
    private boolean glowing;
    private boolean invisible;
    private boolean base;
    private boolean arms;
    private boolean tamed;

    public EntityOptionsData(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        setBaby(z);
        setGlowing(z2);
        setInvisible(z3);
        setBase(z4);
        setArms(z5);
        setTamed(z6);
    }

    public boolean isBaby() {
        return this.baby;
    }

    public void setBaby(boolean z) {
        this.baby = z;
    }

    public boolean isInvisible() {
        return this.invisible;
    }

    public void setInvisible(boolean z) {
        this.invisible = z;
    }

    public boolean isGlowing() {
        return this.glowing;
    }

    public void setGlowing(boolean z) {
        this.glowing = z;
    }

    public boolean isBase() {
        return this.base;
    }

    public void setBase(boolean z) {
        this.base = z;
    }

    public boolean isTamed() {
        return this.tamed;
    }

    public void setTamed(boolean z) {
        this.tamed = z;
    }

    public boolean isArms() {
        return this.arms;
    }

    public void setArms(boolean z) {
        this.arms = z;
    }
}
