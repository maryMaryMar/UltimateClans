package me.module.discord.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_admin("Commands.admin", "", " "),
    COMMANDS_admin_permission("Commands.admin.permission", "uclans.discord_register.admin", "# NOT RECOMMENDED: Use empty for don't need permissions"),
    COMMANDS_admin_alias("Commands.admin.alias", "discord_register", "# Alias for command."),
    COMMANDS_discord_register_help("Commands.discord_register.help", "", new String[0]),
    COMMANDS_discord_register_help_aliases("Commands.discord_register.help.aliases", Arrays.asList("ajuda"), new String[0]),
    COMMANDS_discord_register_help_show("Commands.discord_register.help.show", "", new String[0]),
    COMMANDS_discord_register_help_usage("Commands.discord_register.help.usage", "", new String[0]),
    COMMANDS_discord_register_help_error("Commands.discord_register.help.error", "", new String[0]),
    COMMANDS_discord_register_help_success("Commands.discord_register.help.success", "", new String[0]),
    COMMANDS_discord_register_client("Commands.discord_register.client", "", new String[0]),
    COMMANDS_discord_register_client_aliases("Commands.discord_register.client.aliases", Arrays.asList("client"), new String[0]),
    COMMANDS_discord_register_client_show("Commands.discord_register.client.show", "", new String[0]),
    COMMANDS_discord_register_client_usage("Commands.discord_register.client.usage", "", new String[0]),
    COMMANDS_discord_register_client_error("Commands.discord_register.client.error", "", new String[0]),
    COMMANDS_discord_register_client_success("Commands.discord_register.client.success", "", new String[0]),
    COMMANDS_player("Commands.player", "", " "),
    COMMANDS_player_permission("Commands.player.permission", "uclans.player.discord", "# Use empty for don't need permissions"),
    COMMANDS_player_alias("Commands.player.alias", "discord", "# Alias for command."),
    COMMANDS_player_cooldown("Commands.player.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_value("Commands.player.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_disabled_worlds("Commands.player.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_disabled_regions("Commands.player.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_discord("Commands.discord", "", " ", "# Discord command"),
    COMMANDS_discord_help("Commands.discord.help", "", new String[0]),
    COMMANDS_discord_help_aliases("Commands.discord.help.aliases", "discord", new String[0]),
    COMMANDS_discord_help_show("Commands.discord.help.show", "", new String[0]),
    COMMANDS_discord_help_usage("Commands.discord.help.usage", "", new String[0]),
    COMMANDS_discord_help_error("Commands.discord.help.error", "", new String[0]),
    COMMANDS_discord_help_success("Commands.discord.help.success", "", new String[0]),
    COMMANDS_discord_register("Commands.discord.register", "", new String[0]),
    COMMANDS_discord_register_aliases("Commands.discord.register.aliases", "register", new String[0]),
    COMMANDS_discord_register_show("Commands.discord.register.show", "", new String[0]),
    COMMANDS_discord_register_usage("Commands.discord.register.usage", "", new String[0]),
    COMMANDS_discord_register_error("Commands.discord.register.error", "", new String[0]),
    COMMANDS_discord_register_success("Commands.discord.register.success", "", new String[0]),
    COMMANDS_discord_unregister("Commands.discord.unregister", "", new String[0]),
    COMMANDS_discord_unregister_aliases("Commands.discord.unregister.aliases", "unregister", new String[0]),
    COMMANDS_discord_unregister_show("Commands.discord.unregister.show", "", new String[0]),
    COMMANDS_discord_unregister_usage("Commands.discord.unregister.usage", "", new String[0]),
    COMMANDS_discord_unregister_error("Commands.discord.unregister.error", "", new String[0]),
    COMMANDS_discord_unregister_success("Commands.discord.unregister.success", "", new String[0]);

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
