package me.module.mail.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player("Commands.player", "", " "),
    COMMANDS_player_permission("Commands.player.permission", "uclans.player.mail", "# Use empty for don't need permissions"),
    COMMANDS_player_alias("Commands.player.alias", "mail", "# Alias for command."),
    COMMANDS_player_cooldown("Commands.player.cooldown", 0, "# Command cooldown."),
    COMMANDS_player_value("Commands.player.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_disabled_worlds("Commands.player.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_player_disabled_regions("Commands.player.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_mail("Commands.mail", "", " ", "# mail command"),
    COMMANDS_mail_help("Commands.mail.help", "", new String[0]),
    COMMANDS_mail_help_aliases("Commands.mail.help.aliases", "help", new String[0]),
    COMMANDS_mail_help_show("Commands.mail.help.show", "", new String[0]),
    COMMANDS_mail_help_usage("Commands.mail.help.usage", "", new String[0]),
    COMMANDS_mail_help_error("Commands.mail.help.error", "", new String[0]),
    COMMANDS_mail_help_success("Commands.mail.help.success", "", new String[0]),
    COMMANDS_mail_clear("Commands.mail.clear", "", new String[0]),
    COMMANDS_mail_clear_aliases("Commands.mail.clear.aliases", "clear", new String[0]),
    COMMANDS_mail_clear_show("Commands.mail.clear.show", "", new String[0]),
    COMMANDS_mail_clear_usage("Commands.mail.clear.usage", "", new String[0]),
    COMMANDS_mail_clear_error("Commands.mail.clear.error", "", new String[0]),
    COMMANDS_mail_clear_success("Commands.mail.clear.success", "", new String[0]),
    COMMANDS_mail_read("Commands.mail.read", "", new String[0]),
    COMMANDS_mail_read_aliases("Commands.mail.read.aliases", "read", new String[0]),
    COMMANDS_mail_read_show("Commands.mail.read.show", "", new String[0]),
    COMMANDS_mail_read_usage("Commands.mail.read.usage", "", new String[0]),
    COMMANDS_mail_read_error("Commands.mail.read.error", "", new String[0]),
    COMMANDS_mail_read_success("Commands.mail.read.success", "", new String[0]),
    COMMANDS_mail_send("Commands.mail.send", "", new String[0]),
    COMMANDS_mail_send_aliases("Commands.mail.send.aliases", "send", new String[0]),
    COMMANDS_mail_send_show("Commands.mail.send.show", "", new String[0]),
    COMMANDS_mail_send_usage("Commands.mail.send.usage", "", new String[0]),
    COMMANDS_mail_send_error("Commands.mail.send.error", "", new String[0]),
    COMMANDS_mail_send_success("Commands.mail.send.success", "", new String[0]);

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
