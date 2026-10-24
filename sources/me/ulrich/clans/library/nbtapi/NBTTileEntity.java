package me.ulrich.clans.library.nbtapi;

import me.ulrich.clans.library.nbtapi.utils.CheckUtil;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTTileEntity.class */
public class NBTTileEntity extends NBTCompound {
    private final BlockState tile;
    private final boolean readonly;
    private final Object compound;
    private boolean closed;

    protected NBTTileEntity(BlockState blockState, boolean z) {
        super(null, null);
        this.closed = false;
        if (blockState == null || (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3) && !blockState.isPlaced())) {
            throw new NullPointerException("Tile can't be null/not placed!");
        }
        this.tile = blockState;
        this.readonly = z;
        if (z) {
            this.compound = getCompound();
        } else {
            this.compound = null;
        }
    }

    @Deprecated
    public NBTTileEntity(BlockState blockState) {
        super(null, null);
        this.closed = false;
        if (blockState == null || (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3) && !blockState.isPlaced())) {
            throw new NullPointerException("Tile can't be null/not placed!");
        }
        this.readonly = false;
        this.compound = null;
        this.tile = blockState;
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
            return NBTReflectionUtil.getTileEntityNBTTagCompound(this.tile);
        }
        throw new NbtApiException("BlockEntity NBT needs to be accessed sync!");
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setCompound(Object obj) {
        if (this.readonly) {
            throw new NbtApiException("Tried setting data in read only mode!");
        }
        if (!Bukkit.isPrimaryThread()) {
            throw new NbtApiException("BlockEntity NBT needs to be accessed sync!");
        }
        NBTReflectionUtil.setTileEntityNBTTagCompound(this.tile, obj);
    }

    public NBTCompound getPersistentDataContainer() {
        CheckUtil.assertAvailable(MinecraftVersion.MC1_14_R1);
        if (hasTag("PublicBukkitValues")) {
            return getCompound("PublicBukkitValues");
        }
        NBTContainer nBTContainer = new NBTContainer();
        nBTContainer.addCompound("PublicBukkitValues").setString("__nbtapi", "Marker to make the PersistentDataContainer have content");
        mergeCompound((NBTCompound) nBTContainer);
        return getCompound("PublicBukkitValues");
    }
}
