package me.module.levelup.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/EnumFiles/Gui.class */
public enum Gui implements ConfigurationEnum {
    General_levelup_home("General.levelup_home", "", "#Clan levelup config"),
    General_levelup_home_opensound("General.levelup_home.opensound", "block.slime_block.hit", new String[0]),
    General_levelup_home_rows("General.levelup_home.rows", 6, new String[0]),
    General_levelup_home_pagesize("General.levelup_home.pagesize", 24, new String[0]),
    General_levelup_home_items("General.levelup_home.items", "", new String[0]),
    General_levelup_home_items_fill("General.levelup_home.items.fill", "", new String[0]),
    General_levelup_home_items_fill_material("General.levelup_home.items.fill.material", "BLUE_STAINED_GLASS_PANE", "# Use ; \"<ITEM>;<ITEM>;<ITEM>\" to add more than one item to the fill."),
    General_levelup_home_items_fill_amount("General.levelup_home.items.fill.amount", 1, new String[0]),
    General_levelup_home_items_fill_glow("General.levelup_home.items.fill.glow", false, new String[0]),
    General_levelup_home_items_fill_enabled("General.levelup_home.items.fill.enabled", true, "# This option can be applied to all items."),
    General_levelup_home_items_fill_slot("General.levelup_home.items.fill.slot", 36, "# This option can be applied to all items."),
    General_levelup_home_items_fill_mimeslots("General.levelup_home.items.fill.mimeslots", Arrays.asList(37, 38, 39, 40, 41, 42, 43, 44), "# This option can be applied to all items."),
    General_levelup_home_items_fill_nbt("General.levelup_home.items.fill.nbt", "", "# Nbts can be applied to all items in all menus by following this example"),
    General_levelup_home_items_fill_nbt_string("General.levelup_home.items.fill.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    General_levelup_home_items_fill_model("General.levelup_home.items.fill.model", 0, "# Used for CustomModelData options, just add the number. This option can be applied to all items."),
    General_levelup_home_items_fill2("General.levelup_home.items.fill2", "", new String[0]),
    General_levelup_home_items_fill2_material("General.levelup_home.items.fill2.material", "GRAY_STAINED_GLASS_PANE", "# Use ; \"<ITEM>;<ITEM>;<ITEM>\" to add more than one item to the fill2."),
    General_levelup_home_items_fill2_amount("General.levelup_home.items.fill2.amount", 1, new String[0]),
    General_levelup_home_items_fill2_glow("General.levelup_home.items.fill2.glow", false, new String[0]),
    General_levelup_home_items_fill2_enabled("General.levelup_home.items.fill2.enabled", true, "# This option can be applied to all items."),
    General_levelup_home_items_fill2_slot("General.levelup_home.items.fill2.slot", 0, "# This option can be applied to all items."),
    General_levelup_home_items_fill2_mimeslots("General.levelup_home.items.fill2.mimeslots", Arrays.asList("ALL"), "# This option can be applied to all items."),
    General_levelup_home_items_fill2_nbt("General.levelup_home.items.fill2.nbt", "", "# Nbts can be applied to all items in all menus by following this example"),
    General_levelup_home_items_fill2_nbt_string("General.levelup_home.items.fill2.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    General_levelup_home_items_fill2_model("General.levelup_home.items.fill2.model", 0, "# Used for CustomModelData options, just add the number. This option can be applied to all items."),
    General_levelup_home_items_current("General.levelup_home.items.current", "", new String[0]),
    General_levelup_home_items_current_sound_click("General.levelup_home.items.current.clicksound", "", new String[0]),
    General_levelup_home_items_current_material("General.levelup_home.items.current.material", "ENDER_PEARL", new String[0]),
    General_levelup_home_items_current_texture("General.levelup_home.items.current.texture", "", new String[0]),
    General_levelup_home_items_current_data("General.levelup_home.items.current.data", 0, new String[0]),
    General_levelup_home_items_current_amount("General.levelup_home.items.current.amount", 1, new String[0]),
    General_levelup_home_items_current_glow("General.levelup_home.items.current.glow", false, new String[0]),
    General_levelup_home_items_current_slot("General.levelup_home.items.current.slot", 0, new String[0]),
    General_levelup_home_items_current_mimeslots("General.levelup_home.items.current.mimeslots", Arrays.asList(9, 18, 27, 28, 29, 20, 11, 2, 3, 4, 13, 22, 31, 32, 33, 24, 15, 6, 7, 8, 17, 26, 35), new String[0]),
    General_levelup_home_items_levelup("General.levelup_home.items.levelup", "", new String[0]),
    General_levelup_home_items_levelup_sound_click("General.levelup_home.items.levelup.clicksound", "", new String[0]),
    General_levelup_home_items_levelup_material("General.levelup_home.items.levelup.material", "ENDER_EYE", new String[0]),
    General_levelup_home_items_levelup_texture("General.levelup_home.items.levelup.texture", "", new String[0]),
    General_levelup_home_items_levelup_data("General.levelup_home.items.levelup.data", 0, new String[0]),
    General_levelup_home_items_levelup_amount("General.levelup_home.items.levelup.amount", 1, new String[0]),
    General_levelup_home_items_levelup_glow("General.levelup_home.items.levelup.glow", true, new String[0]),
    General_levelup_home_items_surprise("General.levelup_home.items.surprise", "", new String[0]),
    General_levelup_home_items_surprise_sound_click("General.levelup_home.items.surprise.clicksound", "", new String[0]),
    General_levelup_home_items_surprise_material("General.levelup_home.items.surprise.material", "CHEST_MINECART", new String[0]),
    General_levelup_home_items_surprise_texture("General.levelup_home.items.surprise.texture", "", new String[0]),
    General_levelup_home_items_surprise_amount("General.levelup_home.items.surprise.amount", 1, new String[0]),
    General_levelup_home_items_surprise_glow("General.levelup_home.items.surprise.glow", true, new String[0]),
    General_levelup_home_items_surprise_collected("General.levelup_home.items.surprise_collected", "", new String[0]),
    General_levelup_home_items_surprise_collected_sound_click("General.levelup_home.items.surprise_collected.clicksound", "", new String[0]),
    General_levelup_home_items_surprise_collected_material("General.levelup_home.items.surprise_collected.material", "HOPPER_MINECART", new String[0]),
    General_levelup_home_items_surprise_collected_texture("General.levelup_home.items.surprise_collected.texture", "", new String[0]),
    General_levelup_home_items_surprise_collected_amount("General.levelup_home.items.surprise_collected.amount", 1, new String[0]),
    General_levelup_home_items_surprise_collected_glow("General.levelup_home.items.surprise_collected.glow", true, new String[0]),
    General_levelup_home_items_previous("General.levelup_home.items.previous", "", new String[0]),
    General_levelup_home_items_previous_sound_click("General.levelup_home.items.previous.clicksound", "", new String[0]),
    General_levelup_home_items_previous_material("General.levelup_home.items.previous.material", "ARROW", new String[0]),
    General_levelup_home_items_previous_texture("General.levelup_home.items.previous.texture", "", new String[0]),
    General_levelup_home_items_previous_amount("General.levelup_home.items.previous.amount", 1, new String[0]),
    General_levelup_home_items_previous_glow("General.levelup_home.items.previous.glow", false, new String[0]),
    General_levelup_home_items_previous_slot("General.levelup_home.items.previous.slot", 47, new String[0]),
    General_levelup_home_items_finallist("General.levelup_home.items.finallist", "", new String[0]),
    General_levelup_home_items_finallist_sound_click("General.levelup_home.items.finallist.clicksound", "", new String[0]),
    General_levelup_home_items_finallist_material("General.levelup_home.items.finallist.material", "BARRIER", new String[0]),
    General_levelup_home_items_finallist_texture("General.levelup_home.items.finallist.texture", "", new String[0]),
    General_levelup_home_items_finallist_amount("General.levelup_home.items.finallist.amount", 1, new String[0]),
    General_levelup_home_items_finallist_glow("General.levelup_home.items.finallist.glow", true, new String[0]),
    General_levelup_home_items_next("General.levelup_home.items.next", "", new String[0]),
    General_levelup_home_items_next_sound_click("General.levelup_home.items.next.clicksound", "", new String[0]),
    General_levelup_home_items_next_material("General.levelup_home.items.next.material", "ARROW", new String[0]),
    General_levelup_home_items_next_texture("General.levelup_home.items.next.texture", "", new String[0]),
    General_levelup_home_items_next_amount("General.levelup_home.items.next.amount", 1, new String[0]),
    General_levelup_home_items_next_glow("General.levelup_home.items.next.glow", false, new String[0]),
    General_levelup_home_items_next_slot("General.levelup_home.items.next.slot", 51, new String[0]),
    General_levelup_home_items_back("General.levelup_home.items.back", "", new String[0]),
    General_levelup_home_items_back_sound_click("General.levelup_home.items.back.clicksound", "", new String[0]),
    General_levelup_home_items_back_material("General.levelup_home.items.back.material", "IRON_DOOR", new String[0]),
    General_levelup_home_items_back_texture("General.levelup_home.items.back.texture", "", new String[0]),
    General_levelup_home_items_back_data("General.levelup_home.items.back.data", 0, new String[0]),
    General_levelup_home_items_back_amount("General.levelup_home.items.back.amount", 1, new String[0]),
    General_levelup_home_items_back_glow("General.levelup_home.items.back.glow", true, new String[0]),
    General_levelup_home_items_back_slot("General.levelup_home.items.back.slot", 49, "# This option can be applied to all items."),
    General_levelup_confirm("General.levelup_confirm", "", "#Clan levelup confirm"),
    General_levelup_confirm_opensound("General.levelup_confirm.opensound", "block.slime_block.hit", new String[0]),
    General_levelup_confirm_rows("General.levelup_confirm.rows", 3, new String[0]),
    General_levelup_confirm_items("General.levelup_confirm.items", "", new String[0]),
    General_levelup_confirm_items_fill("General.levelup_confirm.items.fill", "", new String[0]),
    General_levelup_confirm_items_fill_material("General.levelup_confirm.items.fill.material", "RED_STAINED_GLASS_PANE", "# Use ; \"<ITEM>;<ITEM>;<ITEM>\" to add more than one item to the fill."),
    General_levelup_confirm_items_fill_amount("General.levelup_confirm.items.fill.amount", 1, new String[0]),
    General_levelup_confirm_items_fill_glow("General.levelup_confirm.items.fill.glow", false, new String[0]),
    General_levelup_confirm_items_fill_enabled("General.levelup_confirm.items.fill.enabled", true, "# This option can be applied to all items."),
    General_levelup_confirm_items_fill_slot("General.levelup_confirm.items.fill.slot", 0, "# This option can be applied to all items."),
    General_levelup_confirm_items_fill_mimeslots("General.levelup_confirm.items.fill.mimeslots", Arrays.asList("ALL"), "# This option can be applied to all items."),
    General_levelup_confirm_items_fill_nbt("General.levelup_confirm.items.fill.nbt", "", "# Nbts can be applied to all items in all menus by following this example"),
    General_levelup_confirm_items_fill_nbt_string("General.levelup_confirm.items.fill.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    General_levelup_confirm_items_fill_model("General.levelup_confirm.items.fill.model", 0, "# Used for CustomModelData options, just add the number. This option can be applied to all items."),
    General_levelup_confirm_items_confirm("General.levelup_confirm.items.confirm", "", new String[0]),
    General_levelup_confirm_items_confirm_sound_click("General.levelup_confirm.items.confirm.clicksound", "", new String[0]),
    General_levelup_confirm_items_confirm_material("General.levelup_confirm.items.confirm.material", "DIAMOND_BLOCK", new String[0]),
    General_levelup_confirm_items_confirm_texture("General.levelup_confirm.items.confirm.texture", "", new String[0]),
    General_levelup_confirm_items_confirm_data("General.levelup_confirm.items.confirm.data", 0, new String[0]),
    General_levelup_confirm_items_confirm_amount("General.levelup_confirm.items.confirm.amount", 1, new String[0]),
    General_levelup_confirm_items_confirm_glow("General.levelup_confirm.items.confirm.glow", true, new String[0]),
    General_levelup_confirm_items_confirm_slot("General.levelup_confirm.items.confirm.slot", 10, "# This option can be applied to all items."),
    General_levelup_confirm_items_confirm_mimeslots("General.levelup_confirm.items.confirm.mimeslots", Arrays.asList(11, 12), "# This option can be applied to all items."),
    General_levelup_confirm_items_cancel("General.levelup_confirm.items.cancel", "", new String[0]),
    General_levelup_confirm_items_cancel_sound_click("General.levelup_confirm.items.cancel.clicksound", "", new String[0]),
    General_levelup_confirm_items_cancel_material("General.levelup_confirm.items.cancel.material", "REDSTONE_BLOCK", new String[0]),
    General_levelup_confirm_items_cancel_texture("General.levelup_confirm.items.cancel.texture", "", new String[0]),
    General_levelup_confirm_items_cancel_data("General.levelup_confirm.items.cancel.data", 0, new String[0]),
    General_levelup_confirm_items_cancel_amount("General.levelup_confirm.items.cancel.amount", 1, new String[0]),
    General_levelup_confirm_items_cancel_glow("General.levelup_confirm.items.cancel.glow", true, new String[0]),
    General_levelup_confirm_items_cancel_slot("General.levelup_confirm.items.cancel.slot", 14, "# This option can be applied to all items."),
    General_levelup_confirm_items_cancel_mimeslots("General.levelup_confirm.items.cancel.mimeslots", Arrays.asList(15, 16), "# This option can be applied to all items.");

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
