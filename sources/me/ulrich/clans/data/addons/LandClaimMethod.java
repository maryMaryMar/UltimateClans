package me.ulrich.clans.data.addons;

import java.util.List;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LandClaimMethod.class */
public class LandClaimMethod {
    private UUID uuid;
    private Long start;
    private Location loc1;
    private Location loc2;
    private Player player;
    private BlockData data1;
    private BlockData data2;
    private List<LandBoxData> box;
    private byte legacy_data;
    private byte legacy_data2;
    private Material material1;
    private Material material2;

    public LandClaimMethod(UUID uuid, Long l, Location location, BlockData blockData, byte b, Material material, Location location2, BlockData blockData2, byte b2, Material material2, Player player, List<LandBoxData> list) {
        setUuid(uuid);
        setStart(l);
        setLoc1(location);
        setData1(blockData);
        setLegacy_data(b);
        setMaterial1(material);
        setLoc2(location2);
        setData2(blockData2);
        setLegacy_data2(b2);
        setMaterial2(material2);
        setPlayer(player);
        setBox(list);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getStart() {
        return this.start;
    }

    public void setStart(Long l) {
        this.start = l;
    }

    public Location getLoc1() {
        return this.loc1;
    }

    public void setLoc1(Location location) {
        this.loc1 = location;
    }

    public Location getLoc2() {
        return this.loc2;
    }

    public void setLoc2(Location location) {
        this.loc2 = location;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BlockData getData1() {
        return this.data1;
    }

    public void setData1(BlockData blockData) {
        this.data1 = blockData;
    }

    public BlockData getData2() {
        return this.data2;
    }

    public void setData2(BlockData blockData) {
        this.data2 = blockData;
    }

    public List<LandBoxData> getBox() {
        return this.box;
    }

    public void setBox(List<LandBoxData> list) {
        this.box = list;
    }

    public byte getLegacy_data() {
        return this.legacy_data;
    }

    public void setLegacy_data(byte b) {
        this.legacy_data = b;
    }

    public byte getLegacy_data2() {
        return this.legacy_data2;
    }

    public void setLegacy_data2(byte b) {
        this.legacy_data2 = b;
    }

    public Material getMaterial1() {
        return this.material1;
    }

    public void setMaterial1(Material material) {
        this.material1 = material;
    }

    public Material getMaterial2() {
        return this.material2;
    }

    public void setMaterial2(Material material) {
        this.material2 = material;
    }
}
