package me.ulrich.clans.library.nbtapi;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTListCompound.class */
public class NBTListCompound extends NBTCompound {
    private NBTList<?> owner;
    private Object compound;

    protected NBTListCompound(NBTList<?> nBTList, Object obj) {
        super(null, null);
        this.owner = nBTList;
        this.compound = obj;
    }

    public NBTList<?> getListParent() {
        return this.owner;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected boolean isClosed() {
        return this.owner.getParent().isClosed();
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected boolean isReadOnly() {
        return this.owner.getParent().isReadOnly();
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    public Object getCompound() {
        if (isClosed()) {
            throw new NbtApiException("Tried using closed NBT data!");
        }
        return this.compound;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setCompound(Object obj) {
        if (isClosed()) {
            throw new NbtApiException("Tried using closed NBT data!");
        }
        if (isReadOnly()) {
            throw new NbtApiException("Tried setting data in read only mode!");
        }
        this.compound = obj;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void saveCompound() {
        this.owner.save();
    }
}
