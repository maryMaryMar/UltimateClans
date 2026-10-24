package me.module.banner.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player("Commands.player", "", " "),
    COMMANDS_player_permission("Commands.player.permission", "uclans.player.banner", "# Use empty for don't need permissions"),
    COMMANDS_player_alias("Commands.player.alias", "banner", "# Alias for command."),
    COMMANDS_player_cooldown("Commands.player.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_value("Commands.player.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_disabled_worlds("Commands.player.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_disabled_regions("Commands.player.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_banner("Commands.banner", "", " ", "# Banner command"),
    COMMANDS_banner_permission("Commands.banner.permission", "uclans.player.banner", new String[0]),
    COMMANDS_banner_cooldown("Commands.banner.cooldown", 0, "# in seconds"),
    COMMANDS_banner_help("Commands.banner.help", "", new String[0]),
    COMMANDS_banner_help_aliases("Commands.banner.help.aliases", "banner", new String[0]),
    COMMANDS_banner_help_show("Commands.banner.help.show", "", new String[0]),
    COMMANDS_banner_help_usage("Commands.banner.help.usage", "", new String[0]),
    COMMANDS_banner_help_error("Commands.banner.help.error", "", new String[0]),
    COMMANDS_banner_help_success("Commands.banner.help.success", "", new String[0]),
    COMMANDS_banner_upload("Commands.banner.upload", "", new String[0]),
    COMMANDS_banner_upload_aliases("Commands.banner.upload.aliases", "upload", new String[0]),
    COMMANDS_banner_upload_show("Commands.banner.upload.show", "", new String[0]),
    COMMANDS_banner_upload_usage("Commands.banner.upload.usage", "", new String[0]),
    COMMANDS_banner_upload_error("Commands.banner.upload.error", "", new String[0]),
    COMMANDS_banner_upload_success("Commands.banner.upload.success", "", new String[0]),
    COMMANDS_banner_delete("Commands.banner.delete", "", new String[0]),
    COMMANDS_banner_delete_aliases("Commands.banner.delete.aliases", "delete", new String[0]),
    COMMANDS_banner_delete_show("Commands.banner.delete.show", "", new String[0]),
    COMMANDS_banner_delete_usage("Commands.banner.delete.usage", "", new String[0]),
    COMMANDS_banner_delete_error("Commands.banner.delete.error", "", new String[0]),
    COMMANDS_banner_delete_success("Commands.banner.delete.success", "", new String[0]),
    COMMANDS_banner_view("Commands.banner.view", "", new String[0]),
    COMMANDS_banner_view_aliases("Commands.banner.view.aliases", "view", new String[0]),
    COMMANDS_banner_view_show("Commands.banner.view.show", "", new String[0]),
    COMMANDS_banner_view_usage("Commands.banner.view.usage", "", new String[0]),
    COMMANDS_banner_view_error("Commands.banner.view.error", "", new String[0]),
    COMMANDS_banner_view_success("Commands.banner.view.success", "", new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Commands(String str, Object obj, String... strArr) {
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
