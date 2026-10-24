package me.module.discord.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/EnumFiles/Lang.class */
public enum Lang implements ConfigurationEnum {
    DISABLED_FUNCTION("LANGUAGE.disabled function", "%tag% <red>This function/addon appears to be off.", new String[0]),
    HELP_CLAN_HEADER_SUBCOMMAND("COMUM.help clan header subcommand", "<newline><blue><bold>Help with subcommands:</bold> <newline> <green>[!] <gray>subcmd <gray>| <red><> <gray>obligatory <gray>| <light_purple>() <gray>optional <newline> ", new String[0]),
    HELP_LIST_EMPTY("COMUM.help list empty", " <red>- There is nothing on this list.", new String[0]),
    PLAYER_DONT_PERMISSION_ROLE("COMUM.clan dont permission role", "%tag% <red>Your current role you cannot do this.", new String[0]),
    PLAYER_DONT_HAVE_CLAN("LANGUAGE.player donthave clan", "%tag% <red>This player does not have a clan.", new String[0]),
    STATE_TRUE("LANGUAGE.state true", "<green>ENABLED", new String[0]),
    STATE_FALSE("LANGUAGE.state false", "<red>DISABLED", new String[0]),
    CLAN_DONT_ALLY("LANGUAGE.clan dont ally", "%tag% <red>This Clan is not an ally.", new String[0]),
    CLAN_DELETED_SMALL("LANGUAGE.clan deleted small", "<red><strikethrough>Deleted", new String[0]),
    CLAN_WAIT_ENABLE("LANGUAGE.clan wait enable", "<red><strikethrough>Still getting started... wait!", new String[0]),
    TRANSLACTION_CONSOLE("LANGUAGE.translaction console", "<red>Console", new String[0]),
    TRANSLACTION_TRUE("LANGUAGE.translaction true", "<green>YES", new String[0]),
    TRANSLACTION_FALSE("LANGUAGE.translaction false", "<red>NO", new String[0]),
    HEADER_HELP("COMUM.header help", "<green><bold>Admin Discord Commands:", new String[0]),
    COMMAND_BY_PLAYER("COMUM.command by player", "%tag% <red>This command must be used by a player.", new String[0]),
    NO_PERMISSION("COMUM.no permission", "%tag% <red>You dont have permissions for this.", new String[0]),
    HELP_CLAN_DISCORD_GETLINK("LANGUAGE.help discord getlink", "<click:suggest_command:\"%UUID% \"><hover:show_text:'<green>Click to view.'>%tag% <green>Success! Link your Discord server using <aqua>/link %UUID%<green>. or <red>[CLICK HERE] <green>to copy</hover></click>", new String[0]),
    HELP_CLAN_DISCORD_ALREADY_CONNECTED("LANGUAGE.help discord already_connected", "<click:suggest_command:\"%UUID% \"><hover:show_text:'<green>Click to view.'>%tag% <green>Your clan is already connected to Discord! If you need to connect, use <aqua>/link %UUID%<green> and <red>[CLICK HERE] <green>to view the token</hover></click>", new String[0]),
    HELP_CLAN_DISCORD_NOT_CONNECTED("LANGUAGE.help discord not_connected", "%tag% <red>Your clan is not connected to Discord.", new String[0]),
    HELP_CLIENT_DISCORD_SUCCESSFULLY_REGISTERED("LANGUAGE.help client discord successfully registered", "<aqua> - Discord client successfully registered!", new String[0]),
    HELP_CLIENT_DISCORD_ALREADY_REGISTERED("LANGUAGE.help client discord already registered", "<yellow> - This client is already registered.", new String[0]),
    HELP_CLIENT_DISCORD_ID_NOT_REGISTERED("LANGUAGE.help client discord id not registered", "<yellow> - This Discord ID was not registered. <newline><yellow> -  Use <aqua>/register-client <yellow>on Discord first.", new String[0]),
    HELP_CLIENT_DISCORD_ALREADY_LINKED_TO_ANOTHER("LANGUAGE.help client discord already linked to another", "<yellow> - This client is already linked to another Discord account.", new String[0]),
    HELP_CLIENT_DISCORD_ACCOUNT_ALREADY_LINKED_TO_ANOTHER("LANGUAGE.help client discord account already linked to another", "<yellow> - This Discord account is already linked to another client.", new String[0]),
    HELP_CLIENT_DISCORD_VALIDATION_FAILED("LANGUAGE.help client discord validation failed", "<yellow> - Client validation failed.", new String[0]),
    HELP_CLIENT_DISCORD_REGISTRATION_FAILED("LANGUAGE.help client discord registration failed", "<yellow> - Registration failed: <red>{response}", new String[0]),
    HELP_CLAN_DISCORD_ERROR_CONNECTION_REFUSED("LANGUAGE.help discord error connection_refused", "%tag% <red>The connection to the bot was refused.", new String[0]),
    HELP_CLAN_DISCORD_ERROR_CONNECTION_NOT_REGISTERED("LANGUAGE.help discord error connection not registered", "%tag% <red>Connection failed: The server license (Client ID) is invalid or not registered.", new String[0]),
    HELP_CLAN_DISCORD_ERROR_CONNECTION_IP_LIMIT("LANGUAGE.help discord connection ip_limit", "%tag% <red>Connection failed: The server has exceeded the limit of simultaneous connections. Please try again later.", new String[0]),
    HELP_CLAN_DISCORD_ERROR_CONNECTION_IP_BANNED("LANGUAGE.help discord connection ip_banned", "%tag% <red>Connection failed: This server's IP has been temporarily blocked by the bot protection system.", new String[0]),
    HELP_CLAN_DISCORD_ERROR_CONNECTION_INTERNAL("LANGUAGE.help discord connection internal", "%tag% <red>Connection failed: Internal authentication information is missing. Contact the staff.", new String[0]),
    HELP_CLAN_DISCORD_ERROR_CONNECTION_DEREGISTERED("LANGUAGE.help discord connection deregistered", "%tag% <red>Your client has been deregistered. The integration has been disconnected.", new String[0]),
    HELP_CLAN_DISCORD_INTEGRATION_REMOVED("LANGUAGE.help discord integration removed", "%tag% <red>Integration successfully removed from both sides!", new String[0]),
    HELP_CLAN_DISCORD_MESSAGE_BLOCKED("LANGUAGE.help discord message blocked", "%tag% <red>Message blocked: Please wait {seconds} second(s) before sending again.", new String[0]),
    HELP_CLAN_DISCORD_LINK_NOTIFICATION_SUCCESS("LANGUAGE.help discord link notification success", "%tag% <aqua>Notification <green>channel successfully linked!", new String[0]),
    HELP_CLAN_DISCORD_LINK_CHAT_SUCCESS("LANGUAGE.help discord link chat success", "%tag% <aqua>Chat <green>channel successfully linked!", new String[0]),
    HELP_CLAN_DISCORD_LINK_GENERAL_SUCCESS("LANGUAGE.help discord link general success", "%tag% <green>Channel successfully linked!", new String[0]),
    HELP_CLAN_DISCORD_LINK_SEND_ERROR("LANGUAGE.help discord link send error", "%tag% <red>An error occurred while attempting to send.!", new String[0]),
    HELP_CLAN_DISCORD_UNLINK_NOTIFICATION_SUCCESS("LANGUAGE.help discord unlink notification success", "%tag% <aqua>Notification <green>channel successfully Unlinked!", new String[0]),
    HELP_CLAN_DISCORD_UNLINK_CHAT_SUCCESS("LANGUAGE.help discord unlink chat success", "%tag% <aqua>Chat <green>channel successfully Unlinked!", new String[0]),
    HELP_CLAN_DISCORD_UNLINK_GENERAL_SUCCESS("LANGUAGE.help discord unlink general success", "%tag% <green>Channel successfully Unlinked!", new String[0]),
    CHAT_clandiscordcreatewebhook_message("CHAT.clandiscordcreatewebhook.message", Arrays.asList(" ", "<red><strikethrough>-<gray><strikethrough>---------------------------------------------<red><strikethrough>-", "<red>! <yellow>Creating webhook, write the webook url in the chat.", "<red>! <yellow><red>https://discord.com/api/webhooks/{channel}/{token}</red> <yellow>", "<red>! <yellow> or <red>webhooks/{channel}/{token}", "<click:run_command:\"/{_clan} {_cancel}\"><hover:show_text:\"<green>Click to cancel, or use <aqua>/{_clan} {_cancel}\"><red>[CANCEL]</red></hover></click>", "<red><strikethrough>-<gray><strikethrough>---------------------------------------------<red><strikethrough>-", " "), new String[0]),
    CHAT_clandiscordcreatewebhook_actionbar("CHAT.clandiscordcreatewebhook.actionbar", "<red><bold>!</bold> <yellow>>Creating webhook, write in chat!", new String[0]),
    CHAT_clandiscordcreatewebhook_title_line("CHAT.clandiscordcreatewebhook.title.line", "<red>! <yellow>Creating webhook", new String[0]),
    CHAT_clandiscordcreatewebhook_title_subline("CHAT.clandiscordcreatewebhook.title.subline", "<yellow>Write in the chat.", new String[0]),
    CHAT_clandiscordcreatewebhook_bossbar("CHAT.clandiscordcreatewebhook.bossbar", "<red><bold>!</bold> <yellow>Creating webhook, write in chat! <red>({time})", new String[0]),
    CONFIG_icon_name("GUI.Config.Icon.name", "<green>Discord webhook.", new String[0]),
    CONFIG_icon_lore("GUI.Config.Icon.lore", Arrays.asList("", " <white>Is Connected: <aqua>%uclans_is_connected_formated%", "", " <yellow>CLICK to view."), new String[0]),
    COMMANDS_discord_register_help_show("COMMANDS.discord_register.help.show", " <click:run_command:\"/discord_register help\"><hover:show_text:\"<green>Click to show.\"><green>/discord_register help <gray>- <yellow>Show help menu.</hover></click>", new String[0]),
    COMMANDS_discord_register_help_usage("COMMANDS.discord_register.help.usage", "%tag% <red>Error, use: <green>/discord_register help", new String[0]),
    COMMANDS_discord_register_help_error("COMMANDS.discord_register.help.error", "%tag% <red>Error to execute.", new String[0]),
    COMMANDS_discord_register_help_success("COMMANDS.discord_register.help.success", "%tag% <green>Success to execute.", new String[0]),
    COMMANDS_discord_register_client_show("COMMANDS.discord_register.client.show", "<click:suggest_command:\"/discord_register client <red><discord_id>\"><hover:show_text:'<green>Click to register client the clan'> <aqua>/discord_register client <red><discord_id> <gray>-<yellow> Register client clan discord.</hover></click>", new String[0]),
    COMMANDS_discord_register_client_usage("COMMANDS.discord_register.client.usage", "%tag% <red>Use <aqua>/discord_register client <red><discord_id>", new String[0]),
    COMMANDS_discord_register_client_error("COMMANDS.discord_register.client.error", "%tag% <red>An error occurred while register client the clan.", new String[0]),
    COMMANDS_discord_register_client_success("COMMANDS.discord_register.client.success", "%tag% <green>Client request successfully submitted; please wait...", new String[0]),
    COMMANDS_discord_help_show("COMMANDS.discord.help.show", "<click:run_command:\"/{_clan} {_discord} \"><hover:show_text:'<green>Click to expand discord commands.'> <aqua>/{_clan} {_discord} <gray>-<yellow> Clan Discord.</hover></click> <hover:show_text:'<green>With sub commands.'><green>[!]</hover>", new String[0]),
    COMMANDS_discord_help_usage("COMMANDS.discord.help.usage", "%tag% <red>Use <aqua>/{_clan} {_discord}", new String[0]),
    COMMANDS_discord_help_error("COMMANDS.discord.help.error", "%tag% <red>Error.", new String[0]),
    COMMANDS_discord_help_success("COMMANDS.discord.help.success", "%tag% <green>Success.", new String[0]),
    COMMANDS_discord_register_show("COMMANDS.discord.register.show", "<click:suggest_command:\"/{_clan} {_discord} {_register} \"><hover:show_text:'<green>Click to register the clan'> <aqua>/{_clan} {_discord} {_register} <gray>-<yellow> Register clan discord.</hover></click>", new String[0]),
    COMMANDS_discord_register_usage("COMMANDS.discord.register.usage", "%tag% <red>Use <aqua>/{_clan} {_discord} {_register}", new String[0]),
    COMMANDS_discord_register_error("COMMANDS.discord.register.error", "%tag% <red>An error occurred while registering the clan.", new String[0]),
    COMMANDS_discord_register_success("COMMANDS.discord.register.success", "%tag% <green>Pre-registration request successfully submitted; please wait...", new String[0]),
    COMMANDS_discord_unregister_show("COMMANDS.discord.unregister.show", "<click:suggest_command:\"/{_clan} {_discord} {_unregister} \"><hover:show_text:'<green>Click to unregister the clan'> <aqua>/{_clan} {_discord} {_unregister} <gray>-<yellow> Unregister clan discord.</hover></click>", new String[0]),
    COMMANDS_discord_unregister_usage("COMMANDS.discord.unregister.usage", "%tag% <red>Use <aqua>/{_clan} {_discord} {_unregister}", new String[0]),
    COMMANDS_discord_unregister_error("COMMANDS.discord.unregister.error", "%tag% <red>An error occurred while unregistering the clan.", new String[0]),
    COMMANDS_discord_unregister_success("COMMANDS.discord.unregister.success", "%tag% <green>An unregister request was sent.", new String[0]);

    public String LanguageTag = "LANGUAGE";
    private String path;
    private Object defaultValue;
    private String[] comments;

    Lang(String str, Object obj, String... strArr) {
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
