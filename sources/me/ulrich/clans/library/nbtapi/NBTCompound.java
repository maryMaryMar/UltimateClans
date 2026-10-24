package me.ulrich.clans.library.nbtapi;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.module.multiserver.library.redis.jedis.search.IndexOptions;
import me.ulrich.clans.library.nbtapi.iface.NBTHandler;
import me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT;
import me.ulrich.clans.library.nbtapi.iface.ReadableNBT;
import me.ulrich.clans.library.nbtapi.utils.CheckUtil;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import me.ulrich.clans.library.nbtapi.utils.PathUtil;
import me.ulrich.clans.library.nbtapi.utils.UUIDUtil;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.Forge1710Mappings;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;
import me.ulrich.clans.library.udojava.evalex.Expression;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTCompound.class */
public class NBTCompound implements ReadWriteNBT {
    private final ReadWriteLock readWriteLock;
    private final Lock readLock;
    private final Lock writeLock;
    private String compundName;
    private NBTCompound parent;
    private final boolean readOnly;
    private Object readOnlyCache;

    /* JADX INFO: renamed from: me.ulrich.clans.library.nbtapi.NBTCompound$1, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTCompound$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType = new int[NBTType.values().length];

        static {
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagByte.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagByteArray.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagCompound.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagDouble.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagEnd.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagFloat.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagInt.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagIntArray.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagList.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagLong.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagShort.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagString.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[NBTType.NBTTagLongArray.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    protected NBTCompound(NBTCompound nBTCompound, String str) {
        this(nBTCompound, str, false);
    }

    protected NBTCompound(NBTCompound nBTCompound, String str, boolean z) {
        this.readWriteLock = new ReentrantReadWriteLock();
        this.readLock = this.readWriteLock.readLock();
        this.writeLock = this.readWriteLock.writeLock();
        this.compundName = str;
        this.parent = nBTCompound;
        this.readOnly = z;
    }

    protected Lock getReadLock() {
        return this.readLock;
    }

    protected Lock getWriteLock() {
        return this.writeLock;
    }

    protected void saveCompound() {
        if (this.parent != null) {
            this.parent.saveCompound();
        }
    }

    protected void setResolvedObject(Object obj) {
        if (isClosed()) {
            throw new NbtApiException("Tried using closed NBT data!");
        }
        if (this.readOnly) {
            this.readOnlyCache = obj;
        }
    }

    protected void setClosed() {
        if (this.parent != null) {
            this.parent.setClosed();
        }
    }

    protected boolean isClosed() {
        if (this.parent != null) {
            return this.parent.isClosed();
        }
        return false;
    }

    protected boolean isReadOnly() {
        return this.readOnly;
    }

    protected Object getResolvedObject() {
        if (isClosed()) {
            throw new NbtApiException("Tried using closed NBT data!");
        }
        if (this.readOnlyCache != null) {
            return this.readOnlyCache;
        }
        Object compound = getCompound();
        if (compound instanceof Optional) {
            compound = ((Optional) compound).orElse(null);
        }
        if (compound == null) {
            return null;
        }
        if (!NBTReflectionUtil.validCompound(this)) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object toCompount = NBTReflectionUtil.getToCompount(compound, this);
        if (this.readOnly) {
            this.readOnlyCache = toCompount;
        }
        return toCompount;
    }

    public String getName() {
        return this.compundName;
    }

    public Object getCompound() {
        return this.parent.getCompound();
    }

    protected void setCompound(Object obj) {
        this.parent.setCompound(obj);
    }

    public NBTCompound getParent() {
        return this.parent;
    }

    public void mergeCompound(NBTCompound nBTCompound) {
        if (nBTCompound == null) {
            return;
        }
        try {
            this.writeLock.lock();
            NBTReflectionUtil.mergeOtherNBTCompound(this, nBTCompound);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void mergeCompound(ReadableNBT readableNBT) {
        if (!(readableNBT instanceof NBTCompound)) {
            throw new NbtApiException("Unknown NBT object: " + readableNBT);
        }
        mergeCompound((NBTCompound) readableNBT);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setString(String str, String str2) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_STRING, str, str2);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public String getString(String str) {
        try {
            this.readLock.lock();
            return (String) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_STRING, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setInteger(String str, Integer num) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_INT, str, num);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Integer getInteger(String str) {
        try {
            this.readLock.lock();
            return (Integer) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_INT, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setDouble(String str, Double d) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_DOUBLE, str, d);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Double getDouble(String str) {
        try {
            this.readLock.lock();
            return (Double) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_DOUBLE, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setByte(String str, Byte b) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BYTE, str, b);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Byte getByte(String str) {
        try {
            this.readLock.lock();
            return (Byte) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BYTE, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setShort(String str, Short sh) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_SHORT, str, sh);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Short getShort(String str) {
        try {
            this.readLock.lock();
            return (Short) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_SHORT, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setLong(String str, Long l) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_LONG, str, l);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Long getLong(String str) {
        try {
            this.readLock.lock();
            return (Long) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_LONG, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setFloat(String str, Float f) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_FLOAT, str, f);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Float getFloat(String str) {
        try {
            this.readLock.lock();
            return (Float) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_FLOAT, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setByteArray(String str, byte[] bArr) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BYTEARRAY, str, bArr);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public byte[] getByteArray(String str) {
        try {
            this.readLock.lock();
            return (byte[]) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BYTEARRAY, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setIntArray(String str, int[] iArr) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_INTARRAY, str, iArr);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public int[] getIntArray(String str) {
        try {
            this.readLock.lock();
            return (int[]) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_INTARRAY, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setLongArray(String str, long[] jArr) {
        CheckUtil.assertAvailable(MinecraftVersion.MC1_16_R1);
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_LONGARRAY, str, jArr);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public long[] getLongArray(String str) {
        CheckUtil.assertAvailable(MinecraftVersion.MC1_16_R1);
        try {
            this.readLock.lock();
            return (long[]) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_LONGARRAY, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setBoolean(String str, Boolean bool) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BOOLEAN, str, bool);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    protected void set(String str, Object obj) {
        NBTReflectionUtil.set(this, str, obj);
        saveCompound();
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Boolean getBoolean(String str) {
        try {
            this.readLock.lock();
            return (Boolean) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BOOLEAN, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Deprecated
    public void setObject(String str, Object obj) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setObject(this, str, obj);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Deprecated
    public <T> T getObject(String str, Class<T> cls) {
        try {
            this.readLock.lock();
            return (T) NBTReflectionUtil.getObject(this, str, cls);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setItemStack(String str, ItemStack itemStack) {
        try {
            this.writeLock.lock();
            removeKey(str);
            addCompound(str).mergeCompound((NBTCompound) NBTItem.convertItemtoNBT(itemStack));
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public ItemStack getItemStack(String str) {
        try {
            this.readLock.lock();
            NBTCompound compound = getCompound(str);
            if (compound == null) {
                return null;
            }
            return NBTItem.convertNBTtoItem(compound);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setItemStackArray(String str, ItemStack[] itemStackArr) {
        try {
            this.writeLock.lock();
            removeKey(str);
            addCompound(str).mergeCompound((NBTCompound) NBTItem.convertItemArraytoNBT(itemStackArr));
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public ItemStack[] getItemStackArray(String str) {
        try {
            this.readLock.lock();
            NBTCompound compound = getCompound(str);
            if (compound == null) {
                return null;
            }
            return NBTItem.convertNBTtoItemArray(compound);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void setUUID(String str, UUID uuid) {
        try {
            this.writeLock.lock();
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R4)) {
                setIntArray(str, UUIDUtil.uuidToIntArray(uuid));
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R1)) {
                NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_UUID, str, uuid);
            } else {
                setString(str, uuid.toString());
            }
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public UUID getUUID(String str) {
        try {
            this.readLock.lock();
            NBTType type = getType(str);
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R4) && type == NBTType.NBTTagIntArray) {
                return UUIDUtil.uuidFromIntArray(getIntArray(str));
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R1) && type == NBTType.NBTTagIntArray) {
                return (UUID) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_UUID, str);
            }
            if (type != NBTType.NBTTagString) {
                return null;
            }
            try {
                return UUID.fromString(getString(str));
            } catch (IllegalArgumentException e) {
                return null;
            }
        } finally {
            this.readLock.unlock();
        }
    }

    @Deprecated
    public Boolean hasKey(String str) {
        return Boolean.valueOf(hasTag(str));
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public boolean hasTag(String str) {
        try {
            this.readLock.lock();
            Boolean bool = (Boolean) NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_HAS_KEY, str);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void removeKey(String str) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.remove(this, str);
            saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public Set<String> getKeys() {
        try {
            this.readLock.lock();
            return new HashSet(NBTReflectionUtil.getKeys(this));
        } finally {
            this.readLock.unlock();
        }
    }

    public NBTCompound addCompound(String str) {
        try {
            this.writeLock.lock();
            if (getType(str) == NBTType.NBTTagCompound) {
                NBTCompound compound = getCompound(str);
                this.writeLock.unlock();
                return compound;
            }
            NBTReflectionUtil.addNBTTagCompound(this, str);
            NBTCompound compound2 = getCompound(str);
            if (compound2 == null) {
                throw new NbtApiException("Error while adding Compound, got null!");
            }
            saveCompound();
            this.writeLock.unlock();
            return compound2;
        } catch (Throwable th) {
            this.writeLock.unlock();
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTCompound getCompound(String str) {
        try {
            this.readLock.lock();
            if (getType(str) != NBTType.NBTTagCompound) {
                this.readLock.unlock();
                return null;
            }
            NBTCompound nBTCompound = new NBTCompound(this, str, this.readOnly);
            if (NBTReflectionUtil.validCompound(nBTCompound)) {
                this.readLock.unlock();
                return nBTCompound;
            }
            this.readLock.unlock();
            return null;
        } catch (Throwable th) {
            this.readLock.unlock();
            throw th;
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public NBTCompound getOrCreateCompound(String str) {
        return addCompound(str);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<String> getStringList(String str) {
        try {
            this.writeLock.lock();
            NBTList<String> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagString, String.class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<Integer> getIntegerList(String str) {
        try {
            this.writeLock.lock();
            NBTList<Integer> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagInt, Integer.class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<int[]> getIntArrayList(String str) {
        try {
            this.writeLock.lock();
            NBTList<int[]> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagIntArray, int[].class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<UUID> getUUIDList(String str) {
        try {
            this.writeLock.lock();
            NBTList<UUID> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagIntArray, UUID.class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<Float> getFloatList(String str) {
        try {
            this.writeLock.lock();
            NBTList<Float> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagFloat, Float.class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<Double> getDoubleList(String str) {
        try {
            this.writeLock.lock();
            NBTList<Double> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagDouble, Double.class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTList<Long> getLongList(String str) {
        try {
            this.writeLock.lock();
            NBTList<Long> list = NBTReflectionUtil.getList(this, str, NBTType.NBTTagLong, Long.class);
            saveCompound();
            return list;
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTType getListType(String str) {
        try {
            this.readLock.lock();
            if (getType(str) != NBTType.NBTTagList) {
                return null;
            }
            return NBTReflectionUtil.getListType(this, str);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTCompoundList getCompoundList(String str) {
        try {
            this.writeLock.lock();
            NBTCompoundList nBTCompoundList = (NBTCompoundList) NBTReflectionUtil.getList(this, str, NBTType.NBTTagCompound, NBTListCompound.class);
            saveCompound();
            return nBTCompoundList;
        } finally {
            this.writeLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public <T> T getOrDefault(String str, T t) {
        if (t == null) {
            throw new NullPointerException("Default type in getOrDefault can't be null!");
        }
        if (!hasTag(str)) {
            return t;
        }
        Class<?> cls = t.getClass();
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return (T) getBoolean(str);
        }
        if (cls == Byte.class || cls == Byte.TYPE) {
            return (T) getByte(str);
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return (T) getShort(str);
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return (T) getInteger(str);
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return (T) getLong(str);
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return (T) getFloat(str);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return (T) getDouble(str);
        }
        if (cls == byte[].class) {
            return (T) getByteArray(str);
        }
        if (cls == int[].class) {
            return (T) getIntArray(str);
        }
        if (cls == long[].class) {
            return (T) getLongArray(str);
        }
        if (cls == String.class) {
            return (T) getString(str);
        }
        if (cls == UUID.class) {
            T t2 = (T) getUUID(str);
            return t2 == null ? t : t2;
        }
        if (!cls.isEnum()) {
            throw new NbtApiException("Unsupported type for getOrDefault: " + cls.getName());
        }
        T t3 = (T) getEnum(str, t.getClass());
        return t3 == null ? t : t3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public <T> T getOrNull(String str, Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("Default type in getOrNull can't be null!");
        }
        if (!hasTag(str)) {
            return null;
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return (T) getBoolean(str);
        }
        if (cls == Byte.class || cls == Byte.TYPE) {
            return (T) getByte(str);
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return (T) getShort(str);
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return (T) getInteger(str);
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return (T) getLong(str);
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return (T) getFloat(str);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return (T) getDouble(str);
        }
        if (cls == byte[].class) {
            return (T) getByteArray(str);
        }
        if (cls == int[].class) {
            return (T) getIntArray(str);
        }
        if (cls == long[].class) {
            return (T) getLongArray(str);
        }
        if (cls == String.class) {
            return (T) getString(str);
        }
        if (cls == UUID.class) {
            return (T) getUUID(str);
        }
        if (cls.isEnum()) {
            return (T) getEnum(str, cls);
        }
        throw new NbtApiException("Unsupported type for getOrNull: " + cls.getName());
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public <T> T resolveOrNull(String str, Class<?> cls) {
        List<PathUtil.PathSegment> listSplitPath = PathUtil.splitPath(str);
        NBTCompound compound = this;
        for (int i = 0; i < listSplitPath.size() - 1; i++) {
            PathUtil.PathSegment pathSegment = listSplitPath.get(i);
            if (!pathSegment.hasIndex()) {
                compound = compound.getCompound(pathSegment.getPath());
                if (compound == null) {
                    return null;
                }
            } else if (compound.getType(pathSegment.getPath()) == NBTType.NBTTagList && compound.getListType(pathSegment.getPath()) == NBTType.NBTTagCompound) {
                NBTCompoundList compoundList = compound.getCompoundList(pathSegment.getPath());
                compound = pathSegment.getIndex() >= 0 ? compoundList.get(pathSegment.getIndex()) : compoundList.get(compoundList.size() + pathSegment.getIndex());
            }
        }
        PathUtil.PathSegment pathSegment2 = listSplitPath.get(listSplitPath.size() - 1);
        return !pathSegment2.hasIndex() ? (T) compound.getOrNull(pathSegment2.getPath(), cls) : (T) getIndexedValue(compound, pathSegment2, cls);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public <T> T resolveOrDefault(String str, T t) {
        List<PathUtil.PathSegment> listSplitPath = PathUtil.splitPath(str);
        NBTCompound compound = this;
        for (int i = 0; i < listSplitPath.size() - 1; i++) {
            PathUtil.PathSegment pathSegment = listSplitPath.get(i);
            if (!pathSegment.hasIndex()) {
                compound = compound.getCompound(pathSegment.getPath());
                if (compound == null) {
                    return t;
                }
            } else if (compound.getType(pathSegment.getPath()) == NBTType.NBTTagList && compound.getListType(pathSegment.getPath()) == NBTType.NBTTagCompound) {
                NBTCompoundList compoundList = compound.getCompoundList(pathSegment.getPath());
                compound = pathSegment.getIndex() >= 0 ? compoundList.get(pathSegment.getIndex()) : compoundList.get(compoundList.size() + pathSegment.getIndex());
            }
        }
        PathUtil.PathSegment pathSegment2 = listSplitPath.get(listSplitPath.size() - 1);
        return !pathSegment2.hasIndex() ? (T) compound.getOrDefault(pathSegment2.getPath(), t) : (T) getIndexedValue(compound, pathSegment2, t.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T getIndexedValue(NBTCompound nBTCompound, PathUtil.PathSegment pathSegment, Class<T> cls) {
        if (cls == String.class) {
            if (nBTCompound.getType(pathSegment.getPath()) != NBTType.NBTTagList || nBTCompound.getListType(pathSegment.getPath()) != NBTType.NBTTagString) {
                throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
            }
            if (pathSegment.getIndex() >= 0) {
                return (T) nBTCompound.getStringList(pathSegment.getPath()).get(pathSegment.getIndex());
            }
            NBTList<String> stringList = nBTCompound.getStringList(pathSegment.getPath());
            return (T) stringList.get(stringList.size() + pathSegment.getIndex());
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            if (nBTCompound.getType(pathSegment.getPath()) == NBTType.NBTTagList && nBTCompound.getListType(pathSegment.getPath()) == NBTType.NBTTagInt) {
                if (pathSegment.getIndex() >= 0) {
                    return (T) nBTCompound.getIntegerList(pathSegment.getPath()).get(pathSegment.getIndex());
                }
                NBTList<Integer> integerList = nBTCompound.getIntegerList(pathSegment.getPath());
                return (T) integerList.get(integerList.size() + pathSegment.getIndex());
            }
            if (nBTCompound.getType(pathSegment.getPath()) == NBTType.NBTTagIntArray) {
                if (pathSegment.getIndex() >= 0) {
                    int[] intArray = nBTCompound.getIntArray(pathSegment.getPath());
                    if (intArray != null) {
                        return (T) Integer.valueOf(intArray[pathSegment.getIndex()]);
                    }
                } else {
                    int[] intArray2 = nBTCompound.getIntArray(pathSegment.getPath());
                    if (intArray2 != null) {
                        return (T) Integer.valueOf(intArray2[intArray2.length + pathSegment.getIndex()]);
                    }
                }
            }
            throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            if (nBTCompound.getType(pathSegment.getPath()) == NBTType.NBTTagList && nBTCompound.getListType(pathSegment.getPath()) == NBTType.NBTTagLong) {
                if (pathSegment.getIndex() >= 0) {
                    return (T) nBTCompound.getLongList(pathSegment.getPath()).get(pathSegment.getIndex());
                }
                NBTList<Long> longList = nBTCompound.getLongList(pathSegment.getPath());
                return (T) longList.get(longList.size() + pathSegment.getIndex());
            }
            if (nBTCompound.getType(pathSegment.getPath()) == NBTType.NBTTagLongArray) {
                if (pathSegment.getIndex() >= 0) {
                    long[] longArray = nBTCompound.getLongArray(pathSegment.getPath());
                    if (longArray != null) {
                        return (T) Long.valueOf(longArray[pathSegment.getIndex()]);
                    }
                } else {
                    long[] longArray2 = nBTCompound.getLongArray(pathSegment.getPath());
                    if (longArray2 != null) {
                        return (T) Long.valueOf(longArray2[longArray2.length + pathSegment.getIndex()]);
                    }
                }
            }
            throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            if (nBTCompound.getType(pathSegment.getPath()) != NBTType.NBTTagList || nBTCompound.getListType(pathSegment.getPath()) != NBTType.NBTTagFloat) {
                throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
            }
            if (pathSegment.getIndex() >= 0) {
                return (T) nBTCompound.getFloatList(pathSegment.getPath()).get(pathSegment.getIndex());
            }
            NBTList<Float> floatList = nBTCompound.getFloatList(pathSegment.getPath());
            return (T) floatList.get(floatList.size() + pathSegment.getIndex());
        }
        if (cls == Double.TYPE || cls == Double.class) {
            if (nBTCompound.getType(pathSegment.getPath()) != NBTType.NBTTagList || nBTCompound.getListType(pathSegment.getPath()) != NBTType.NBTTagDouble) {
                throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
            }
            if (pathSegment.getIndex() >= 0) {
                return (T) nBTCompound.getDoubleList(pathSegment.getPath()).get(pathSegment.getIndex());
            }
            NBTList<Double> doubleList = nBTCompound.getDoubleList(pathSegment.getPath());
            return (T) doubleList.get(doubleList.size() + pathSegment.getIndex());
        }
        if (cls == int[].class) {
            if (nBTCompound.getType(pathSegment.getPath()) != NBTType.NBTTagList || nBTCompound.getListType(pathSegment.getPath()) != NBTType.NBTTagIntArray) {
                throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
            }
            if (pathSegment.getIndex() >= 0) {
                return (T) nBTCompound.getIntArrayList(pathSegment.getPath()).get(pathSegment.getIndex());
            }
            NBTList<int[]> intArrayList = nBTCompound.getIntArrayList(pathSegment.getPath());
            return (T) intArrayList.get(intArrayList.size() + pathSegment.getIndex());
        }
        if (cls != Byte.TYPE && cls != Byte.class) {
            throw new NbtApiException("Unable to get indexed value for type " + cls);
        }
        if (nBTCompound.getType(pathSegment.getPath()) == NBTType.NBTTagByteArray) {
            if (pathSegment.getIndex() >= 0) {
                byte[] byteArray = nBTCompound.getByteArray(pathSegment.getPath());
                if (byteArray != null) {
                    return (T) Byte.valueOf(byteArray[pathSegment.getIndex()]);
                }
            } else {
                byte[] byteArray2 = nBTCompound.getByteArray(pathSegment.getPath());
                if (byteArray2 != null) {
                    return (T) Byte.valueOf(byteArray2[byteArray2.length + pathSegment.getIndex()]);
                }
            }
        }
        throw new NbtApiException("No fitting list/array found for " + pathSegment.getPath() + " of type " + cls);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT, me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public ReadWriteNBT resolveCompound(String str) {
        List<PathUtil.PathSegment> listSplitPath = PathUtil.splitPath(str);
        NBTCompound compound = this;
        for (int i = 0; i < listSplitPath.size(); i++) {
            PathUtil.PathSegment pathSegment = listSplitPath.get(i);
            if (!pathSegment.hasIndex()) {
                compound = compound.getCompound(pathSegment.getPath());
                if (compound == null) {
                    return null;
                }
            } else if (compound.getType(pathSegment.getPath()) == NBTType.NBTTagList && compound.getListType(pathSegment.getPath()) == NBTType.NBTTagCompound) {
                NBTCompoundList compoundList = compound.getCompoundList(pathSegment.getPath());
                compound = pathSegment.getIndex() >= 0 ? compoundList.get(pathSegment.getIndex()) : compoundList.get(compoundList.size() + pathSegment.getIndex());
            }
        }
        return compound;
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public ReadWriteNBT resolveOrCreateCompound(String str) {
        List<PathUtil.PathSegment> listSplitPath = PathUtil.splitPath(str);
        NBTCompound orCreateCompound = this;
        for (int i = 0; i < listSplitPath.size(); i++) {
            PathUtil.PathSegment pathSegment = listSplitPath.get(i);
            if (!pathSegment.hasIndex()) {
                orCreateCompound = orCreateCompound.getOrCreateCompound(pathSegment.getPath());
                if (orCreateCompound == null) {
                    return null;
                }
            } else if (orCreateCompound.getType(pathSegment.getPath()) == NBTType.NBTTagList && orCreateCompound.getListType(pathSegment.getPath()) == NBTType.NBTTagCompound) {
                NBTCompoundList compoundList = orCreateCompound.getCompoundList(pathSegment.getPath());
                orCreateCompound = pathSegment.getIndex() >= 0 ? compoundList.get(pathSegment.getIndex()) : compoundList.get(compoundList.size() + pathSegment.getIndex());
            }
        }
        return orCreateCompound;
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public <E extends Enum<?>> void setEnum(String str, E e) {
        if (e == null) {
            removeKey(str);
        } else {
            setString(str, e.name());
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public <E extends Enum<E>> E getEnum(String str, Class<E> cls) {
        String string;
        if (str == null || cls == null || (string = getString(str)) == null) {
            return null;
        }
        try {
            return (E) Enum.valueOf(cls, string);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTType getType(String str) {
        try {
            this.readLock.lock();
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                Object data = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET, str);
                if (data == null) {
                    return null;
                }
                return NBTType.valueOf(((Byte) ReflectionMethod.COMPOUND_OWN_TYPE_LEGACY.run(data, new Object[0])).byteValue());
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_21_R4)) {
                Object data2 = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET, str);
                if (data2 == null) {
                    return null;
                }
                return NBTType.fromName((String) ReflectionMethod.TAGTYPE_GET_NAME.run(ReflectionMethod.TAGTYPE_OWN_TYPE.run(data2, new Object[0]), new Object[0]));
            }
            Object data3 = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_TYPE, str);
            if (data3 == null) {
                return null;
            }
            return NBTType.valueOf(((Byte) data3).byteValue());
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public void writeCompound(OutputStream outputStream) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.writeApiNBT(this, outputStream);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public <T> T get(String str, NBTHandler<T> nBTHandler) {
        return nBTHandler.get(this, str);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public <T> void set(String str, T t, NBTHandler<T> nBTHandler) {
        nBTHandler.set(this, str, t);
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public String toString() {
        return asNBTString();
    }

    @Deprecated
    public String toString(String str) {
        return asNBTString();
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT
    public void clearNBT() {
        Iterator<String> it = getKeys().iterator();
        while (it.hasNext()) {
            removeKey(it.next());
        }
    }

    @Deprecated
    public String asNBTString() {
        try {
            this.readLock.lock();
            Object resolvedObject = getResolvedObject();
            if (resolvedObject == null) {
                return "{}";
            }
            return (MinecraftVersion.isForgePresent() && MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) ? Forge1710Mappings.toString(resolvedObject) : resolvedObject.toString();
        } finally {
            this.readLock.unlock();
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NBTCompound)) {
            return false;
        }
        NBTCompound nBTCompound = (NBTCompound) obj;
        if (!getKeys().equals(nBTCompound.getKeys())) {
            return false;
        }
        Iterator<String> it = getKeys().iterator();
        while (it.hasNext()) {
            if (!isEqual(this, nBTCompound, it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // me.ulrich.clans.library.nbtapi.iface.ReadableNBT
    public NBTCompound extractDifference(ReadableNBT readableNBT) {
        if (this == readableNBT) {
            return new NBTContainer();
        }
        if (readableNBT instanceof NBTCompound) {
            return saveDiff(new NBTContainer(), this, (NBTCompound) readableNBT);
        }
        throw new NbtApiException("Unknown NBT object: " + readableNBT);
    }

    private static NBTCompound saveDiff(NBTCompound nBTCompound, NBTCompound nBTCompound2, NBTCompound nBTCompound3) {
        Iterator<String> it = nBTCompound2.getKeys().iterator();
        while (it.hasNext()) {
            saveDiff(nBTCompound, nBTCompound2, nBTCompound3, it.next());
        }
        return nBTCompound;
    }

    private static void saveDiff(NBTCompound nBTCompound, NBTCompound nBTCompound2, NBTCompound nBTCompound3, String str) {
        boolean z = nBTCompound2.getType(str) != nBTCompound3.getType(str);
        switch (AnonymousClass1.$SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[nBTCompound2.getType(str).ordinal()]) {
            case 1:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setByte(str, nBTCompound2.getByte(str));
                }
                break;
            case 2:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setByteArray(str, nBTCompound2.getByteArray(str));
                }
                break;
            case 3:
                NBTCompound compound = nBTCompound2.getCompound(str);
                if (compound != null) {
                    if (!z) {
                        NBTCompound compound2 = nBTCompound3.getCompound(str);
                        if (compound2 != null) {
                            NBTCompound nBTCompoundExtractDifference = compound.extractDifference((ReadableNBT) compound2);
                            if (!nBTCompoundExtractDifference.getKeys().isEmpty()) {
                                nBTCompound.addCompound(str).mergeCompound(nBTCompoundExtractDifference);
                            }
                        } else {
                            nBTCompound.addCompound(str).mergeCompound(compound);
                        }
                    } else {
                        nBTCompound.addCompound(str).mergeCompound(compound);
                    }
                    break;
                }
                break;
            case 4:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setDouble(str, nBTCompound2.getDouble(str));
                }
                break;
            case 6:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setFloat(str, nBTCompound2.getFloat(str));
                }
                break;
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setInteger(str, nBTCompound2.getInteger(str));
                }
                break;
            case 8:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setIntArray(str, nBTCompound2.getIntArray(str));
                }
                break;
            case 9:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.set(str, NBTReflectionUtil.getEntry(nBTCompound2, str));
                }
                break;
            case 10:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setLong(str, nBTCompound2.getLong(str));
                }
                break;
            case IndexOptions.DEFAULT_FLAGS /* 11 */:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setShort(str, nBTCompound2.getShort(str));
                }
                break;
            case 12:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setString(str, nBTCompound2.getString(str));
                }
                break;
            case 13:
                if (z || !isEqual(nBTCompound2, nBTCompound3, str)) {
                    nBTCompound.setLongArray(str, nBTCompound2.getLongArray(str));
                }
                break;
        }
    }

    private static boolean isEqual(NBTCompound nBTCompound, NBTCompound nBTCompound2, String str) {
        if (nBTCompound.getType(str) != nBTCompound2.getType(str)) {
            return false;
        }
        switch (AnonymousClass1.$SwitchMap$de$tr7zw$changeme$nbtapi$NBTType[nBTCompound.getType(str).ordinal()]) {
            case 1:
                return nBTCompound.getByte(str).equals(nBTCompound2.getByte(str));
            case 2:
                return Arrays.equals(nBTCompound.getByteArray(str), nBTCompound2.getByteArray(str));
            case 3:
                NBTCompound compound = nBTCompound.getCompound(str);
                return compound != null && compound.equals(nBTCompound2.getCompound(str));
            case 4:
                return nBTCompound.getDouble(str).equals(nBTCompound2.getDouble(str));
            case 5:
                return true;
            case 6:
                return nBTCompound.getFloat(str).equals(nBTCompound2.getFloat(str));
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                return nBTCompound.getInteger(str).equals(nBTCompound2.getInteger(str));
            case 8:
                return Arrays.equals(nBTCompound.getIntArray(str), nBTCompound2.getIntArray(str));
            case 9:
                return NBTReflectionUtil.getEntry(nBTCompound, str).toString().equals(NBTReflectionUtil.getEntry(nBTCompound2, str).toString());
            case 10:
                return nBTCompound.getLong(str).equals(nBTCompound2.getLong(str));
            case IndexOptions.DEFAULT_FLAGS /* 11 */:
                return nBTCompound.getShort(str).equals(nBTCompound2.getShort(str));
            case 12:
                return nBTCompound.getString(str).equals(nBTCompound2.getString(str));
            case 13:
                return Arrays.equals(nBTCompound.getLongArray(str), nBTCompound2.getLongArray(str));
            default:
                return false;
        }
    }
}
