package me.ulrich.clans.data.addons;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusLocalEventData.class */
public class NexusLocalEventData {
    private Material material;
    private BlockData blockData;
    private Byte legacyData;

    public NexusLocalEventData(Material material, BlockData blockData, Byte b) {
        setMaterial(material);
        setBlockData(blockData);
        setLegacyData(b);
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BlockData getBlockData() {
        return this.blockData;
    }

    public void setBlockData(BlockData blockData) {
        this.blockData = blockData;
    }

    public Byte getLegacyData() {
        return this.legacyData;
    }

    public void setLegacyData(Byte b) {
        this.legacyData = b;
    }
}
