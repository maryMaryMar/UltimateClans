package me.ulrich.clans.data.addons;

import me.ulrich.clans.data.ClanEnum;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LeaderboardData.class */
public class LeaderboardData {
    private String id;
    private AddonEnum.LookType lookType;
    private ClanEnum.PlaceholderTop placeholderTop;
    private int num;
    private Location location;
    private BlockFace face;

    public LeaderboardData(String str, Location location, AddonEnum.LookType lookType, ClanEnum.PlaceholderTop placeholderTop, int i, BlockFace blockFace) {
        setId(str);
        setLookType(lookType);
        setPlaceholderTop(placeholderTop);
        setNum(i);
        setLocation(location);
        setFace(blockFace);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public AddonEnum.LookType getLookType() {
        return this.lookType;
    }

    public void setLookType(AddonEnum.LookType lookType) {
        this.lookType = lookType;
    }

    public ClanEnum.PlaceholderTop getPlaceholderTop() {
        return this.placeholderTop;
    }

    public void setPlaceholderTop(ClanEnum.PlaceholderTop placeholderTop) {
        this.placeholderTop = placeholderTop;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int i) {
        this.num = i;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BlockFace getFace() {
        return this.face;
    }

    public void setFace(BlockFace blockFace) {
        this.face = blockFace;
    }
}
