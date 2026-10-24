package me.ulrich.clans.data;

import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CustomModerationData.class */
public class CustomModerationData {
    private String name;
    private List<String> permissions;
    private GuiItemsData icon;
    private UUID owner;

    public CustomModerationData(UUID uuid, String str, List<String> list, GuiItemsData guiItemsData) {
        setName(str);
        setPermissions(list);
        setIcon(guiItemsData);
        setOwner(uuid);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<String> list) {
        this.permissions = list;
    }

    public GuiItemsData getIcon() {
        return this.icon;
    }

    public void setIcon(GuiItemsData guiItemsData) {
        this.icon = guiItemsData;
    }

    public UUID getOwner() {
        return this.owner;
    }

    public void setOwner(UUID uuid) {
        this.owner = uuid;
    }
}
