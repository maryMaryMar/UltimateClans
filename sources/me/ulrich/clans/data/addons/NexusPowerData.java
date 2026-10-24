package me.ulrich.clans.data.addons;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusPowerData.class */
public class NexusPowerData {
    private int power;
    private int claimGain;
    private int powerLoseAmount;
    private int finalPower;
    private int max;

    public NexusPowerData(int i, int i2, int i3, int i4, int i5) {
        setPower(i);
        setClaimGain(i2);
        setPowerLoseAmount(i3);
        setFinalPower(i4);
        setMax(i5);
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int i) {
        this.power = i;
    }

    public int getClaimGain() {
        return this.claimGain;
    }

    public void setClaimGain(int i) {
        this.claimGain = i;
    }

    public int getPowerLoseAmount() {
        return this.powerLoseAmount;
    }

    public void setPowerLoseAmount(int i) {
        this.powerLoseAmount = i;
    }

    public int getFinalPower() {
        return this.finalPower;
    }

    public void setFinalPower(int i) {
        this.finalPower = i;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }
}
