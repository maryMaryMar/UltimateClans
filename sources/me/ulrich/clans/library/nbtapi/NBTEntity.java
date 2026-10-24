package me.ulrich.clans.library.nbtapi;

import me.ulrich.clans.library.nbtapi.utils.CheckUtil;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTEntity.class */
public class NBTEntity extends NBTCompound {
    private final Entity ent;
    private final boolean readonly;
    private final Object compound;
    private boolean closed;

    protected NBTEntity(Entity entity, boolean z) {
        super(null, null);
        this.closed = false;
        if (entity == null) {
            throw new NullPointerException("Entity can't be null!");
        }
        this.readonly = z;
        this.ent = entity;
        if (z) {
            this.compound = getCompound();
        } else {
            this.compound = null;
        }
    }

    @Deprecated
    public NBTEntity(Entity entity) {
        super(null, null);
        this.closed = false;
        if (entity == null) {
            throw new NullPointerException("Entity can't be null!");
        }
        this.readonly = false;
        this.compound = null;
        this.ent = entity;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setClosed() {
        this.closed = true;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected boolean isClosed() {
        return this.closed;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected boolean isReadOnly() {
        return this.readonly;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    public Object getCompound() {
        if (this.readonly && this.compound != null) {
            return this.compound;
        }
        if (Bukkit.isPrimaryThread()) {
            return NBTReflectionUtil.getEntityNBTTagCompound(NBTReflectionUtil.getNMSEntity(this.ent));
        }
        throw new NbtApiException("Entity NBT needs to be accessed sync!");
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setCompound(Object obj) {
        if (this.readonly) {
            throw new NbtApiException("Tried setting data in read only mode!");
        }
        if (!Bukkit.isPrimaryThread()) {
            throw new NbtApiException("Entity NBT needs to be accessed sync!");
        }
        NBTReflectionUtil.setEntityNBTTag(obj, NBTReflectionUtil.getNMSEntity(this.ent));
    }

    public NBTCompound getPersistentDataContainer() {
        CheckUtil.assertAvailable(MinecraftVersion.MC1_14_R1);
        return new NBTPersistentDataContainer(this.ent.getPersistentDataContainer());
    }
}
