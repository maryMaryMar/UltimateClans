package me.ulrich.clans.data.addons;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LandsData_flags.class */
public class LandsData_flags {
    private boolean monster_spawn;
    private boolean animal_spawn;
    private boolean leaf_decay;
    private boolean pvp;
    private boolean lava_flow;
    private boolean water_flow;
    private boolean tnt;
    private boolean mob_grief;

    public LandsData_flags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        setMonster_spawn(z);
        setAnimal_spawn(z2);
        setLeaf_decay(z3);
        setPvp(z4);
        setWater_flow(z5);
        setLava_flow(z6);
        setTnt(z7);
        setMob_grief(z8);
    }

    public boolean isMonster_spawn() {
        return this.monster_spawn;
    }

    public void setMonster_spawn(boolean z) {
        this.monster_spawn = z;
    }

    public boolean isAnimal_spawn() {
        return this.animal_spawn;
    }

    public void setAnimal_spawn(boolean z) {
        this.animal_spawn = z;
    }

    public boolean isLeaf_decay() {
        return this.leaf_decay;
    }

    public void setLeaf_decay(boolean z) {
        this.leaf_decay = z;
    }

    public boolean isPvp() {
        return this.pvp;
    }

    public void setPvp(boolean z) {
        this.pvp = z;
    }

    public boolean isLava_flow() {
        return this.lava_flow;
    }

    public void setLava_flow(boolean z) {
        this.lava_flow = z;
    }

    public boolean isTnt() {
        return this.tnt;
    }

    public void setTnt(boolean z) {
        this.tnt = z;
    }

    public boolean isWater_flow() {
        return this.water_flow;
    }

    public void setWater_flow(boolean z) {
        this.water_flow = z;
    }

    public boolean isMob_grief() {
        return this.mob_grief;
    }

    public void setMob_grief(boolean z) {
        this.mob_grief = z;
    }
}
