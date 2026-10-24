package me.ulrich.clans.data.addons;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LandBoxData.class */
public class LandBoxData {
    private Location location;
    private BlockData data;
    private Material material;
    private byte data_legacy;

    public LandBoxData(Location location, BlockData blockData, Material material, byte b) {
        setLocation(location);
        setData(blockData);
        setMaterial(material);
        setData_legacy(b);
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BlockData getData() {
        return this.data;
    }

    public void setData(BlockData blockData) {
        this.data = blockData;
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public byte getData_legacy() {
        return this.data_legacy;
    }

    public void setData_legacy(byte b) {
        this.data_legacy = b;
    }
}
