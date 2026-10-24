package me.ulrich.clans.data.addons;

import java.util.Optional;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LeagueRewardData.class */
public class LeagueRewardData {
    private ItemStack item;
    private Optional<String> command;

    public LeagueRewardData(ItemStack itemStack, Optional<String> optional) {
        setItem(itemStack);
        setCommand(optional);
    }

    public ItemStack getItem() {
        return this.item;
    }

    public void setItem(ItemStack itemStack) {
        this.item = itemStack;
    }

    public Optional<String> getCommand() {
        return this.command;
    }

    public void setCommand(Optional<String> optional) {
        this.command = optional;
    }
}
