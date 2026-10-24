package me.ulrich.clans.data.addons;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusSettingsData.class */
public class NexusSettingsData {
    private boolean visitation;
    private boolean drop;
    private boolean pickup;
    private boolean itemConsume;
    private boolean otherInteract;
    private boolean entityInteract;

    public NexusSettingsData(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        setVisitation(z);
        setDrop(z2);
        setPickup(z3);
        setItemConsume(z4);
        setOtherInteract(z5);
        setEntityInteract(z6);
    }

    public boolean isVisitation() {
        return this.visitation;
    }

    public void setVisitation(boolean z) {
        this.visitation = z;
    }

    public boolean isDrop() {
        return this.drop;
    }

    public void setDrop(boolean z) {
        this.drop = z;
    }

    public boolean isPickup() {
        return this.pickup;
    }

    public void setPickup(boolean z) {
        this.pickup = z;
    }

    public boolean isItemConsume() {
        return this.itemConsume;
    }

    public void setItemConsume(boolean z) {
        this.itemConsume = z;
    }

    public boolean isOtherInteract() {
        return this.otherInteract;
    }

    public void setOtherInteract(boolean z) {
        this.otherInteract = z;
    }

    public boolean isEntityInteract() {
        return this.entityInteract;
    }

    public void setEntityInteract(boolean z) {
        this.entityInteract = z;
    }
}
