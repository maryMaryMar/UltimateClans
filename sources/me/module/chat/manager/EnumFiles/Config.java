package me.module.chat.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CLAN_chat("Clan.chat", "", " "),
    CLAN_chat_priority("Clan.chat.priority", "LOWEST", "#Clan Chat listener priority.", "#values (lowercase or UPPERCASE): LOWEST, LOW, NORMAL, HIGH, HIGHEST."),
    CLAN_chat_format("Clan.chat.format", "<hover:show_text:\"<green>Clan %uclans_tag_color%<newline><newline><white> Leader: <aqua>%uclans_leader%<newline><white> Members: <aqua>%uclans_count_members%<newline><white> Level: <aqua>%uclans_level%\">%uclans_tag_color% <light_purple>> <light_purple>%uclans_player_role_formated%<dark_purple>%player%<light_purple>: <light_purple>%chat_message%</hover>", new String[0]),
    CLAN_chat_spy_tag("Clan.chat.spy_tag", "<dark_gray>[SPY] ", new String[0]),
    CLAN_chat_enable_colors("Clan.chat.enable_colors", false, new String[0]),
    CLAN_chat_enabled_decoration("Clan.chat.disabled_decoration", Arrays.asList("OBFUSCATED", "BOLD", "ITALIC", "UNDERLINED", "STRIKETHROUGH"), "# BOLD, ITALIC, UNDERLINED, STRIKETHROUGH, OBFUSCATED"),
    CLAN_chat_shortcut("Clan.chat.shortcut", "@", "# This shortcut is used to send clan messages quickly using shortcuts. use empty to disable"),
    CLAN_chat_console_chat("Clan.chat.console_chat", true, new String[0]),
    PLAYER_DONT_HAVE_CLAN("Clan.player donthave clan", "%tag% <red>This player does not have a clan.", new String[0]),
    PLAYER_TRUE("Clan.true", "<green>Enabled", new String[0]),
    PLAYER_FALSE("Clan.false", "<red>Disabled", new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Config(String str, Object obj, String... strArr) {
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
