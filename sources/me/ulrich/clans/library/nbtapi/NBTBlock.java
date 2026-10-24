package me.ulrich.clans.library.nbtapi;

import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import org.bukkit.block.Block;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTBlock.class */
@Deprecated
public class NBTBlock {
    private final Block block;
    private final NBTChunk nbtChunk;

    public NBTBlock(Block block) {
        this.block = block;
        if (!MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R3)) {
            throw new NbtApiException("NBTBlock is only working for 1.16.4+!");
        }
        this.nbtChunk = new NBTChunk(block.getChunk());
    }

    @Deprecated
    public NBTCompound getData() {
        return this.nbtChunk.getPersistentDataContainer().getOrCreateCompound("blocks").getOrCreateCompound(this.block.getX() + "_" + this.block.getY() + "_" + this.block.getZ());
    }
}
