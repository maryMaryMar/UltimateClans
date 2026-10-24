package me.ulrich.clans.library.nbtapi;

import me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT;
import me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTCompoundList;
import me.ulrich.clans.library.nbtapi.iface.ReadableNBT;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTCompoundList.class */
public class NBTCompoundList extends NBTList<ReadWriteNBT> implements ReadWriteNBTCompoundList {
    protected NBTCompoundList(NBTCompound nBTCompound, String str, NBTType nBTType, Object obj) {
        super(nBTCompound, str, nBTType, obj);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTCompoundList
    public NBTListCompound addCompound() {
        return (NBTListCompound) addCompound((NBTCompound) null);
    }

    public NBTCompound addCompound(NBTCompound nBTCompound) {
        if (getParent().isReadOnly()) {
            throw new NbtApiException("Tried setting data in read only mode!");
        }
        try {
            Object objNewInstance = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
                ReflectionMethod.LIST_ADD.run(this.listObject, Integer.valueOf(size()), objNewInstance);
            } else {
                ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, objNewInstance);
            }
            getParent().saveCompound();
            NBTListCompound nBTListCompound = new NBTListCompound(this, objNewInstance);
            if (nBTCompound != null) {
                nBTListCompound.mergeCompound(nBTCompound);
            }
            return nBTListCompound;
        } catch (Exception e) {
            throw new NbtApiException(e);
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTCompoundList
    public ReadWriteNBT addCompound(ReadableNBT readableNBT) {
        if (readableNBT instanceof NBTCompound) {
            return addCompound((NBTCompound) readableNBT);
        }
        return null;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTList, java.util.List, java.util.Collection, me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTList
    @Deprecated
    public boolean add(ReadWriteNBT readWriteNBT) {
        return addCompound(readWriteNBT) != null;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTList, java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTList
    public void add(int i, ReadWriteNBT readWriteNBT) {
        if (readWriteNBT != null) {
            throw new NbtApiException("You need to pass null! ListCompounds from other lists won't work.");
        }
        if (getParent().isReadOnly()) {
            throw new NbtApiException("Tried setting data in read only mode!");
        }
        try {
            Object objNewInstance = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
                ReflectionMethod.LIST_ADD.run(this.listObject, Integer.valueOf(i), objNewInstance);
            } else {
                ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, objNewInstance);
            }
            super.getParent().saveCompound();
        } catch (Exception e) {
            throw new NbtApiException(e);
        }
    }

    @Override // java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadableNBTList
    public NBTListCompound get(int i) {
        try {
            return new NBTListCompound(this, ReflectionMethod.LIST_GET_COMPOUND.run(this.listObject, Integer.valueOf(i)));
        } catch (Exception e) {
            throw new NbtApiException(e);
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTList, java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTList
    public NBTListCompound set(int i, ReadWriteNBT readWriteNBT) {
        throw new NbtApiException("This method doesn't work in the ListCompound context.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.ulrich.clans.library.nbtapi.NBTList
    public Object asTag(ReadWriteNBT readWriteNBT) {
        return null;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTList, java.util.List, me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTList, me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTCompoundList
    public /* bridge */ /* synthetic */ ReadWriteNBT remove(int i) {
        return (ReadWriteNBT) super.remove(i);
    }
}
