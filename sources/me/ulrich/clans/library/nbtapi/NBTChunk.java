package me.ulrich.clans.library.nbtapi;

import me.ulrich.clans.library.nbtapi.utils.CheckUtil;
import me.ulrich.clans.library.nbtapi.utils.MinecraftVersion;
import org.bukkit.Chunk;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTChunk.class */
@Deprecated
public class NBTChunk {
    private final Chunk chunk;

    public NBTChunk(Chunk chunk) {
        this.chunk = chunk;
    }

    public NBTCompound getPersistentDataContainer() {
        CheckUtil.assertAvailable(MinecraftVersion.MC1_16_R3);
        return new NBTPersistentDataContainer(this.chunk.getPersistentDataContainer());
    }
}
