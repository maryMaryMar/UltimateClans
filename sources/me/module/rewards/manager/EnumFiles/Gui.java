package me.module.rewards.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/EnumFiles/Gui.class */
public enum Gui implements ConfigurationEnum {
    General_levelup_rewards("General.levelup_rewards", "", "#Clan levelup config"),
    General_levelup_rewards_opensound("General.levelup_rewards.opensound", "block.slime_block.hit", new String[0]),
    General_levelup_rewards_rows("General.levelup_rewards.rows", 4, new String[0]),
    General_levelup_rewards_pagesize("General.levelup_rewards.pagesize", 27, new String[0]),
    General_levelup_rewards_items("General.levelup_rewards.items", "", new String[0]),
    General_levelup_rewards_items_fill("General.levelup_rewards.items.fill", "", new String[0]),
    General_levelup_rewards_items_fill_material("General.levelup_rewards.items.fill.material", "BLUE_STAINED_GLASS_PANE", "# Use ; \"<ITEM>;<ITEM>;<ITEM>\" to add more than one item to the fill."),
    General_levelup_rewards_items_fill_amount("General.levelup_rewards.items.fill.amount", 1, new String[0]),
    General_levelup_rewards_items_fill_glow("General.levelup_rewards.items.fill.glow", false, new String[0]),
    General_levelup_rewards_items_fill_enabled("General.levelup_rewards.items.fill.enabled", true, "# This option can be applied to all items."),
    General_levelup_rewards_items_fill_slot("General.levelup_rewards.items.fill.slot", 27, "# This option can be applied to all items."),
    General_levelup_rewards_items_fill_mimeslots("General.levelup_rewards.items.fill.mimeslots", Arrays.asList(28, 29, 30, 31, 32, 33, 34, 35), "# This option can be applied to all items."),
    General_levelup_rewards_items_fill_nbt("General.levelup_rewards.items.fill.nbt", "", "# Nbts can be applied to all items in all menus by following this example"),
    General_levelup_rewards_items_fill_nbt_string("General.levelup_rewards.items.fill.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    General_levelup_rewards_items_fill_model("General.levelup_rewards.items.fill.model", 0, "# Used for CustomModelData options, just add the number. This option can be applied to all items."),
    General_levelup_rewards_items_current("General.levelup_rewards.items.current", "", new String[0]),
    General_levelup_rewards_items_current_sound_click("General.levelup_rewards.items.current.clicksound", "", new String[0]),
    General_levelup_rewards_items_current_material("General.levelup_rewards.items.current.material", "PAPER", new String[0]),
    General_levelup_rewards_items_current_texture("General.levelup_rewards.items.current.texture", "", new String[0]),
    General_levelup_rewards_items_current_data("General.levelup_rewards.items.current.data", 0, new String[0]),
    General_levelup_rewards_items_current_amount("General.levelup_rewards.items.current.amount", 1, new String[0]),
    General_levelup_rewards_items_current_glow("General.levelup_rewards.items.current.glow", false, new String[0]),
    General_levelup_rewards_items_previous("General.levelup_rewards.items.previous", "", new String[0]),
    General_levelup_rewards_items_previous_sound_click("General.levelup_rewards.items.previous.clicksound", "", new String[0]),
    General_levelup_rewards_items_previous_material("General.levelup_rewards.items.previous.material", "ARROW", new String[0]),
    General_levelup_rewards_items_previous_texture("General.levelup_rewards.items.previous.texture", "", new String[0]),
    General_levelup_rewards_items_previous_amount("General.levelup_rewards.items.previous.amount", 1, new String[0]),
    General_levelup_rewards_items_previous_glow("General.levelup_rewards.items.previous.glow", false, new String[0]),
    General_levelup_rewards_items_previous_slot("General.levelup_rewards.items.previous.slot", 29, new String[0]),
    General_levelup_rewards_items_next("General.levelup_rewards.items.next", "", new String[0]),
    General_levelup_rewards_items_next_sound_click("General.levelup_rewards.items.next.clicksound", "", new String[0]),
    General_levelup_rewards_items_next_material("General.levelup_rewards.items.next.material", "ARROW", new String[0]),
    General_levelup_rewards_items_next_texture("General.levelup_rewards.items.next.texture", "", new String[0]),
    General_levelup_rewards_items_next_amount("General.levelup_rewards.items.next.amount", 1, new String[0]),
    General_levelup_rewards_items_next_glow("General.levelup_rewards.items.next.glow", false, new String[0]),
    General_levelup_rewards_items_next_slot("General.levelup_rewards.items.next.slot", 33, new String[0]),
    General_levelup_rewards_items_back("General.levelup_rewards.items.back", "", new String[0]),
    General_levelup_rewards_items_back_sound_click("General.levelup_rewards.items.back.clicksound", "", new String[0]),
    General_levelup_rewards_items_back_material("General.levelup_rewards.items.back.material", "IRON_DOOR", new String[0]),
    General_levelup_rewards_items_back_texture("General.levelup_rewards.items.back.texture", "", new String[0]),
    General_levelup_rewards_items_back_data("General.levelup_rewards.items.back.data", 0, new String[0]),
    General_levelup_rewards_items_back_amount("General.levelup_rewards.items.back.amount", 1, new String[0]),
    General_levelup_rewards_items_back_glow("General.levelup_rewards.items.back.glow", true, new String[0]),
    General_levelup_rewards_items_back_slot("General.levelup_rewards.items.back.slot", 31, "# This option can be applied to all items.");

    private String path;
    private Object defaultValue;
    private String[] comments;

    Gui(String str, Object obj, String... strArr) {
        this.path = str;
        this.defaultValue = obj;
        this.comments = strArr;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public String getPath() {
        return this.path;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    @Override // me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum
    public String[] getComments() {
        return this.comments;
    }
}
