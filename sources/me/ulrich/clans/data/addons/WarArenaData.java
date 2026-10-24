package me.ulrich.clans.data.addons;

import me.ulrich.clans.data.ClanEnum;
import org.bukkit.Location;
import org.bukkit.Material;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/WarArenaData.class */
public class WarArenaData {
    private String name;
    private ClanEnum.EventState state;
    private boolean enabled;
    private Location spawn2;
    private Location spawn1;
    private Location lobby;
    private Location exit;
    private Location point1;
    private Location point2;
    private Material icon;
    private String desc;
    private Location spectator;
    private AddonEnum.ArenaMode mode;

    public WarArenaData(String str, ClanEnum.EventState eventState, boolean z, Location location, Location location2, Location location3, Location location4, Location location5, Location location6, Material material, String str2, Location location7, AddonEnum.ArenaMode arenaMode) {
        setName(str);
        setState(eventState);
        setEnabled(z);
        setSpawn1(location);
        setSpawn2(location2);
        setLobby(location3);
        setExit(location4);
        setPoint1(location5);
        setPoint2(location6);
        setIcon(material);
        setDesc(str2);
        setSpectator(location7);
        setMode(arenaMode);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public ClanEnum.EventState getState() {
        return this.state;
    }

    public void setState(ClanEnum.EventState eventState) {
        this.state = eventState;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public Location getSpawn2() {
        return this.spawn2;
    }

    public void setSpawn2(Location location) {
        this.spawn2 = location;
    }

    public Location getSpawn1() {
        return this.spawn1;
    }

    public void setSpawn1(Location location) {
        this.spawn1 = location;
    }

    public Location getLobby() {
        return this.lobby;
    }

    public void setLobby(Location location) {
        this.lobby = location;
    }

    public Location getExit() {
        return this.exit;
    }

    public void setExit(Location location) {
        this.exit = location;
    }

    public Location getPoint1() {
        return this.point1;
    }

    public void setPoint1(Location location) {
        this.point1 = location;
    }

    public Location getPoint2() {
        return this.point2;
    }

    public void setPoint2(Location location) {
        this.point2 = location;
    }

    public Material getIcon() {
        return this.icon;
    }

    public void setIcon(Material material) {
        this.icon = material;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public Location getSpectator() {
        return this.spectator;
    }

    public void setSpectator(Location location) {
        this.spectator = location;
    }

    public AddonEnum.ArenaMode getMode() {
        return this.mode;
    }

    public void setMode(AddonEnum.ArenaMode arenaMode) {
        this.mode = arenaMode;
    }
}
