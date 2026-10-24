package me.ulrich.clans.data.addons;

import java.util.List;
import java.util.UUID;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LeagueRewardsData.class */
public class LeagueRewardsData {
    private List<String> commands;
    private List<ItemStack> items;
    private List<UUID> collectedBy;

    public LeagueRewardsData(List<String> list, List<ItemStack> list2, List<UUID> list3) {
        setCommands(list);
        setItems(list2);
        setCollectedBy(list3);
    }

    public List<String> getCommands() {
        return this.commands;
    }

    public void setCommands(List<String> list) {
        this.commands = list;
    }

    public List<ItemStack> getItems() {
        return this.items;
    }

    public void setItems(List<ItemStack> list) {
        this.items = list;
    }

    public List<UUID> getCollectedBy() {
        return this.collectedBy;
    }

    public void setCollectedBy(List<UUID> list) {
        this.collectedBy = list;
    }
}
