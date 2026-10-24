package me.ulrich.clans.data;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/ModerationData.class */
public class ModerationData {
    private String id;
    private String name;
    private int priority;
    private HashMap<String, Boolean> permissionList;
    private boolean editable;
    private boolean upgradable;
    private GuiItemsData icon;
    private Optional<UUID> owner;

    public ModerationData(String str, String str2, int i, HashMap<String, Boolean> map, boolean z, boolean z2, GuiItemsData guiItemsData, Optional<UUID> optional) {
        setId(str);
        setName(str2);
        setPriority(i);
        setPermissionList(map);
        setEditable(z);
        setUpgradable(z2);
        setIcon(guiItemsData);
        setOwner(optional);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public HashMap<String, Boolean> getPermissionList() {
        return this.permissionList;
    }

    public void setPermissionList(HashMap<String, Boolean> map) {
        this.permissionList = map;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public void setEditable(boolean z) {
        this.editable = z;
    }

    public boolean isUpgradable() {
        return this.upgradable;
    }

    public void setUpgradable(boolean z) {
        this.upgradable = z;
    }

    public GuiItemsData getIcon() {
        return this.icon;
    }

    public void setIcon(GuiItemsData guiItemsData) {
        this.icon = guiItemsData;
    }

    public Optional<UUID> getOwner() {
        return this.owner;
    }

    public void setOwner(Optional<UUID> optional) {
        this.owner = optional;
    }
}
