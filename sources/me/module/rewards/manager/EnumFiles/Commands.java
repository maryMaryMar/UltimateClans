package me.module.rewards.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/EnumFiles/Commands.class */
public enum Commands implements ConfigurationEnum {
    COMMANDS("Commands", "", " ", "#permissions and alias"),
    COMMANDS_player_rewards("Commands.player.rewards", "", " ", "# Clan rewards"),
    COMMANDS_player_rewards_permission("Commands.player.rewards.permission", "uclans.player.rewards", new String[0]),
    COMMANDS_player_rewards_alias("Commands.player.rewards.alias", "rewards", "# Alias for command."),
    COMMANDS_player_rewards_cooldown("Commands.player.rewards.cooldown", 0, "# in seconds"),
    COMMANDS_player_rewards_value("Commands.player.rewards.value", Double.valueOf(0.0d), "# Value to use."),
    COMMANDS_player_rewards_disabled_worlds("Commands.player.rewards.disabled_worlds", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_playe_rewardsr_disabled_regions("Commands.player.rewards.disabled_regions", Arrays.asList(new Object[0]), new String[0]),
    COMMANDS_rewards_help("Commands.rewards.help", "", new String[0]),
    COMMANDS_rewards_help_aliases("Commands.rewards.help.aliases", "help", new String[0]),
    COMMANDS_rewards_help_show("Commands.rewards.help.show", "", new String[0]),
    COMMANDS_rewards_help_usage("Commands.rewards.help.usage", "", new String[0]),
    COMMANDS_rewards_help_error("Commands.rewards.help.error", "", new String[0]),
    COMMANDS_rewards_help_success("Commands.rewards.help.success", "", new String[0]),
    COMMANDS_rewards_list("Commands.rewards.list", "", new String[0]),
    COMMANDS_rewards_list_aliases("Commands.rewards.list.aliases", "list", new String[0]),
    COMMANDS_rewards_list_show("Commands.rewards.list.show", "", new String[0]),
    COMMANDS_rewards_list_usage("Commands.rewards.list.usage", "", new String[0]),
    COMMANDS_rewards_list_error("Commands.rewards.list.error", "", new String[0]),
    COMMANDS_rewards_list_success("Commands.rewards.list.success", "", new String[0]),
    COMMANDS_rewards_collect("Commands.rewards.collect", "", new String[0]),
    COMMANDS_rewards_collect_aliases("Commands.rewards.collect.aliases", "collect", new String[0]),
    COMMANDS_rewards_collect_show("Commands.rewards.collect.show", "", new String[0]),
    COMMANDS_rewards_collect_usage("Commands.rewards.collect.usage", "", new String[0]),
    COMMANDS_rewards_collect_error("Commands.rewards.collect.error", "", new String[0]),
    COMMANDS_rewards_collect_success("Commands.rewards.collect.success", "", new String[0]);

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
