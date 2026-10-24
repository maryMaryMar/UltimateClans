package me.module.levelup.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/EnumFiles/Config.class */
public enum Config implements ConfigurationEnum {
    CONFIG_date_format_short("Config.date_format_short", "dd/MM/yyyy", new String[0]),
    CONFIG_levelup_icon("Config.Levelup.Icon", "", " "),
    CONFIG_levelup_icon_click_sound("Config.Levelup.Icon.click_sound", "", new String[0]),
    CONFIG_levelup_icon_material("Config.Levelup.Icon.material", "ANVIL", new String[0]),
    CONFIG_levelup_icon_name("Config.Levelup.Icon.name", "", new String[0]),
    CONFIG_levelup_icon_texture("Config.Levelup.Icon.texture", "", new String[0]),
    CONFIG_levelup_icon_lore("Config.Levelup.Icon.lore", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_levelup_icon_glow("Config.Levelup.Icon.glow", false, new String[0]),
    CONFIG_levelup_icon_slot("Config.Levelup.Icon.slot", 29, new String[0]),
    CONFIG_levelup_icon_page("Config.Levelup.Icon.page", "clan_home", new String[0]),
    CONFIG_levelup_icon_mimeslots("Config.Levelup.Icon.mimeslots", Arrays.asList(new Object[0]), "# avaliable: TOP, BOTTOM, BORDER, ALL or numeric list"),
    CONFIG_levelup_icon_nbt_string("Config.Levelup.Icon.nbt.string", Arrays.asList(new Object[0]), new String[0]),
    CONFIG_levelup_icon_nbt_integer("Config.Levelup.Icon.model", 0, new String[0]),
    CONFIG_levelup_icon_left_click_action("Config.Levelup.Icon.left_click_action", Arrays.asList("/{_clan} {_level} {_view} -gui"), new String[0]),
    CONFIG_levelup_icon_right_click_action("Config.Levelup.Icon.right_click_action", Arrays.asList("/{_clan} {_level} {_view} -gui"), new String[0]),
    CONFIG_permissions("Config.Permissions", "", " ", "#Permissions are for advanced connoisseurs, be careful when editing this!"),
    CONFIG_permissions_view("Config.Permissions.view", "", new String[0]),
    CONFIG_permissions_view_name("Config.Permissions.view.name", "Levelup-View", new String[0]),
    CONFIG_permissions_view_default_value("Config.Permissions.view.default_value", true, new String[0]),
    CONFIG_permissions_view_applicable_roles("Config.Permissions.view.applicable_roles", Arrays.asList("member", "moderator", "admin"), new String[0]),
    CONFIG_permissions_up("Config.Permissions.up", "", new String[0]),
    CONFIG_permissions_up_name("Config.Permissions.up.name", "Levelup-up", new String[0]),
    CONFIG_permissions_up_default_value("Config.Permissions.up.default_value", true, new String[0]),
    CONFIG_permissions_up_applicable_roles("Config.Permissions.up.applicable_roles", Arrays.asList("member", "moderator", "admin"), new String[0]),
    LEVEL("Level", " ", "# Level configurations", "# Configure the amount of points required according to the points set in the created quests, create a balance according to your server"),
    LEVEL_points_mode("Level.points.formula", "({CLAN_LEVEL}*{BASE})*{EXPONENT}", "# The basis is calculated according to the formula.", "# default: '({CLAN_LEVEL}*{BASE})*{EXPONENT}'", "# Variables: {CLAN_LEVEL} = current clan level, {BASE} = base value, {EXPONENT} = exponent value", "# TO OLD METHOD USE '{BASE}+({BASE}*Math.pow({CLAN_LEVEL},{EXPONENT}))'."),
    LEVEL_points_base("Level.points.base", 50, "#Required points are the basis for scoring points for levels."),
    LEVEL_points_exponent("Level.points.exponent", Float.valueOf(1.0f), "# This is the multiplier to be applied in each formula"),
    LEVEL_points_start_level("Level.points.start_level", 0, "# Start level."),
    LEVEL_points_max_level("Level.points.max_level", 20, "# The maximum level a clan can reach."),
    LEVEL_points_block_level_decay("Level.points.block_level_decay", false, "# When enabling this option, the clan does not drop in level when losing points."),
    LEVEL_patent_list("Level.patent.list", " ", "#Use this formatting as an example or uncomment the lines:", "#    list:", "#      beginner:", "#        name: '<gray>Beginner'", "#        required_level: 0", "#        rewards: []", "#        rewards_only_once: true", "#        rewards_disabled_world: []"),
    LEVEL_patent_list_beginner("Level.patent.list.beginner", "", new String[0]),
    LEVEL_patent_list_beginner_name("Level.patent.list.beginner.name", "<gray>Beginner", "# Name that will appear in menus, texts and placeholders"),
    LEVEL_patent_list_beginner_required_level("Level.patent.list.beginner.required_level", 0, "# How many levels is required"),
    LEVEL_patent_list_beginner_rewards("Level.patent.list.beginner.rewards", Arrays.asList(new Object[0]), "# Commands triggered when reaching level", "# The variable for players nickname is %player%", "# ex: 'eco give %player% 5000'"),
    LEVEL_patent_list_beginner_rewards_only_once("Level.patent.list.beginner.rewards_only_once", true, "# The reward is sent only the first time the clan reaches this level"),
    LEVEL_patent_list_beginner_rewards_disabled_world("Level.patent.list.beginner.rewards_disabled_world", Arrays.asList(new Object[0]), "# Worlds where you cannot receive command rewards"),
    LEVEL_actions("Level.actions", "", " ", "#The actions give points to the clan according to the development", "#The actions are under development.", "#If you dont want to use this use values 0 \"zero\""),
    LEVEL_actions_CREATE("Level.actions.CREATE", 100, new String[0]),
    LEVEL_actions_NEWMEMBER("Level.actions.NEWMEMBER", 20, new String[0]),
    LEVEL_actions_REMOVEMEMBER("Level.actions.REMOVEMEMBER", -20, new String[0]),
    LEVEL_actions_WARWIN("Level.actions.WARWIN", 150, new String[0]),
    LEVEL_actions_WARLOSE("Level.actions.WARLOSE", -150, new String[0]),
    LEVEL_actions_NEWALLINCE("Level.actions.NEWALLIANCE", 10, new String[0]),
    LEVEL_actions_REMOVEALLINCE("Level.actions.REMOVEALLIANCE", -10, new String[0]),
    LEVEL_actions_NEWRIVAL("Level.actions.NEWRIVAL", 10, new String[0]),
    LEVEL_actions_REMOVERIVAL("Level.actions.REMOVERIVAL", -10, new String[0]),
    LEVEL_actions_PROMOTEMEMBER("Level.actions.PROMOTEMEMBER", 30, new String[0]),
    LEVEL_actions_DEMOTEMEMBER("Level.actions.DEMOTEMEMBER", -30, new String[0]),
    LEVEL_actions_DEATHMEMBER("Level.actions.DEATHMEMBER", -2, new String[0]),
    LEVEL_actions_KILLMEMBER("Level.actions.KILLMEMBER", 2, new String[0]),
    LEVEL_actions_CLANVERIFY("Level.actions.CLANVERIFY", 150, new String[0]),
    LEVEL_level_requeriments("Level.requeriments", " ", "# If the list of requirements is smaller than Level.points.max_level, standard items will be created only with POINTS requirements"),
    LEVEL_level_requeriments_show_command_rewards("Level.requeriments.show_command_rewards", true, "# If this is false, This will hide the rewards."),
    LEVEL_level_requeriments_rewards_only_once("Level.requeriments.rewards_only_once", true, "# If TRUE, the clan will not receive the same reward and surprise when passing the same level twice."),
    LEVEL_level_requeriments_hide_upcoming_requirements("Level.requeriments.hide_upcoming_requirements", false, "# If TRUE, requirements for levels above the next available level stay hidden in the level GUI."),
    LEVEL_level_requeriments_icon("Level.requeriments.icon", "PAPER", new String[0]),
    LEVEL_level_requeriments_list_one_level("Level.requeriments.list.one.level", 1, "# !important! Requirement level", "#Any placeholder can be used here, internal or external.", "#Valid operators for placeholders: ==, !=, >=, <=, <, >"),
    LEVEL_level_requeriments_list_one_rewards("Level.requeriments.list.one.rewards", Arrays.asList("eco give %player% 100"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_one_surprise("Level.requeriments.list.one.surprise", Arrays.asList("eco give %player% 100"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_one_points("Level.requeriments.list.one.points", "{FORMULA}", "# Level.points.formula", "# extra placeholders linked to requirements, empty to disable"),
    LEVEL_level_requeriments_list_one_requires("Level.requeriments.list.one.requires", Arrays.asList("%uclans_hasbanner%==true;false= <white>Clan Banner: <red><bold>NO</bold> <gray>(need %value%);true= <white>Clan Banner: <green><bold>OK</bold> <gray>(%value%)", "%uclans_count_members%>=2;false= <white>Clan Members: <red><bold>NO</bold> <gray>(need %value% member(s));true= <white>Clan Members: <green><bold>OK</bold> <gray>(%value% members)", "%uclans_creation_hours%>=1;false= <white>Clan Creation: <red><bold>NO</bold> <gray>(need %value% hour(s));true= <white>Clan Creation: <green><bold>OK</bold> <gray>(%value% hours)"), new String[0]),
    LEVEL_level_requeriments_list_one_cost("Level.requeriments.list.one.cost", Arrays.asList(new Object[0]), "#variables: bank=AMOUNT, money=AMOUNT, exp=AMOUNT, item=ITEM:AMOUNT"),
    LEVEL_level_requeriments_list_five_level("Level.requeriments.list.five.level", 5, "# !important! Requirement level", "#Any placeholder can be used here, internal or external.", "#Valid operators for placeholders: ==, !=, >=, <=, <, >"),
    LEVEL_level_requeriments_list_five_rewards("Level.requeriments.list.five.rewards", Arrays.asList("eco give %player% 500"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_five_surprise_rewards("Level.requeriments.list.five.surprise", Arrays.asList("eco give %player% 1000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_five_points("Level.requeriments.list.five.points", "{FORMULA}", "# Level.points.formula"),
    LEVEL_level_requeriments_list_five_description("Level.requeriments.list.five.description", Arrays.asList(" <gray>- Money: $500"), new String[0]),
    LEVEL_level_requeriments_list_five_requires("Level.requeriments.list.five.requires", Arrays.asList("%uclans_hasbanner%==true;false= <white>Clan Banner: <red><bold>NO</bold> <gray>(need %value%);true= <white>Clan Banner: <green><bold>OK</bold> <gray>(%value%)", "%uclans_count_members%>=5;false= <white>Clan Members: <red><bold>NO</bold> <gray>(need %value% member(s));true= <white>Clan Members: <green><bold>OK</bold> <gray>(%value% members)", "%uclans_creation_hours%>=24;false= <white>Clan Creation: <red><bold>NO</bold> <gray>(need %value% hour(s));true= <white>Clan Creation: <green><bold>OK</bold> <gray>(%value% hours)", "%uclans_bank_balance%>=1.000;false= <white>Clan Bank: <red><bold>NO</bold> <gray>(need %value% money);true= <white>Clan Bank: <green><bold>OK</bold> <gray>(%value% money)", "%uclans_clan_kdr%>=2.0;false= <white>Clan KDR: <red><bold>NO</bold> <gray>(need %value% kdr);true= <white>Clan Kdr: <green><bold>OK</bold> <gray>(%value% kdr)", "%uclans_clan_war_win%>=1;false= <white>Clan War: <red><bold>NO</bold> <gray>(need %value% war);true= <white>Clan War: <green><bold>OK</bold> <gray>(%value% war)"), "# extra plugins linked to requirements, empty to disable"),
    LEVEL_level_requeriments_list_five_cost("Level.requeriments.list.five.cost", Arrays.asList("bank=1.000"), "#variables: bank=AMOUNT, money=AMOUNT, exp=AMOUNT, item=ITEM:AMOUNT"),
    LEVEL_level_requeriments_list_ten_level("Level.requeriments.list.ten.level", 10, "# !important! Requirement level", "#Any placeholder can be used here, internal or external.", "#Valid operators for placeholders: ==, !=, >=, <=, <, >"),
    LEVEL_level_requeriments_list_ten_rewards("Level.requeriments.list.ten.rewards", Arrays.asList("eco give %player% 1000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_ten_surprise_rewards("Level.requeriments.list.ten.surprise", Arrays.asList("eco give %player% 5000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_ten_points("Level.requeriments.list.ten.points", "{FORMULA}", "# Level.points.formula"),
    LEVEL_level_requeriments_list_ten_description("Level.requeriments.list.ten.description", Arrays.asList(new Object[0]), new String[0]),
    LEVEL_level_requeriments_list_ten_requires("Level.requeriments.list.ten.requires", Arrays.asList("%uclans_hasbanner%==true;false= <white>Clan Banner: <red><bold>NO</bold> <gray>(need %value%);true= <white>Clan Banner: <green><bold>OK</bold> <gray>(%value%)", "%uclans_count_members%>=10;false= <white>Clan Members: <red><bold>NO</bold> <gray>(need %value% member(s));true= <white>Clan Members: <green><bold>OK</bold> <gray>(%value% members)", "%uclans_creation_hours%>=48;false= <white>Clan Creation: <red><bold>NO</bold> <gray>(need %value% hour(s));true= <white>Clan Creation: <green><bold>OK</bold> <gray>(%value% hours)", "%uclans_bank_balance%>=10.000;false= <white>Clan Bank: <red><bold>NO</bold> <gray>(need %value% money);true= <white>Clan Bank: <green><bold>OK</bold> <gray>(%value% money)", "%uclans_clan_kdr%>=3.0;false= <white>Clan KDR: <red><bold>NO</bold> <gray>(need %value% kdr);true= <white>Clan Kdr: <green><bold>OK</bold> <gray>(%value% kdr)", "%uclans_clan_war_win%>=5;false= <white>Clan War: <red><bold>NO</bold> <gray>(need %value% war);true= <white>Clan War: <green><bold>OK</bold> <gray>(%value% war)", "CHECKITEM:[iron_ingot:10];false= <white>View Items: <red><bold>NO</bold> <gray>(need: %value%);true= <white>View Items: <green><bold>OK</bold> <gray>(%value%)"), "# extra plugins linked to requirements, empty to disable"),
    LEVEL_level_requeriments_list_ten_cost("Level.requeriments.list.ten.cost", Arrays.asList("bank=10.000", "item=iron_ingot:10"), "#variables: bank=AMOUNT, money=AMOUNT, exp=AMOUNT, item=ITEM:AMOUNT"),
    LEVEL_level_requeriments_list_fifteen_level("Level.requeriments.list.fifteen.level", 15, "# !important! Requirement level", "#Any placeholder can be used here, internal or external.", "#Valid operators for placeholders: ==, !=, >=, <=, <, >"),
    LEVEL_level_requeriments_list_fifteen_rewards("Level.requeriments.list.fifteen.rewards", Arrays.asList("eco give %player% 1000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_fifteen_surprise_rewards("Level.requeriments.list.fifteen.surprise", Arrays.asList("eco give %player% 5000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_fifteen_points("Level.requeriments.list.fifteen.points", "{FORMULA}", "# Level.points.formula"),
    LEVEL_level_requeriments_list_fifteen_description("Level.requeriments.list.fifteen.description", Arrays.asList(new Object[0]), new String[0]),
    LEVEL_level_requeriments_list_fifteen_requires("Level.requeriments.list.fifteen.requires", Arrays.asList("%uclans_hasbanner%==true;false= <white>Clan Banner: <red><bold>NO</bold> <gray>(need %value%);true= <white>Clan Banner: <green><bold>OK</bold> <gray>(%value%)", "%uclans_count_members%>=10;false= <white>Clan Members: <red><bold>NO</bold> <gray>(need %value% member(s));true= <white>Clan Members: <green><bold>OK</bold> <gray>(%value% members)", "%uclans_creation_hours%>=72;false= <white>Clan Creation: <red><bold>NO</bold> <gray>(need %value% hour(s));true= <white>Clan Creation: <green><bold>OK</bold> <gray>(%value% hours)", "%uclans_bank_balance%>=50.000;false= <white>Clan Bank: <red><bold>NO</bold> <gray>(need %value% money);true= <white>Clan Bank: <green><bold>OK</bold> <gray>(%value% money)", "%uclans_clan_kdr%>=4.0;false= <white>Clan KDR: <red><bold>NO</bold> <gray>(need %value% kdr);true= <white>Clan Kdr: <green><bold>OK</bold> <gray>(%value% kdr)", "%uclans_clan_war_win%>=10;false= <white>Clan War: <red><bold>NO</bold> <gray>(need %value% war);true= <white>Clan War: <green><bold>OK</bold> <gray>(%value% war)", "CHECKITEM:[diamond:5];false= <white>View Items: <red><bold>NO</bold> <gray>(need: %value%);true= <white>View Items: <green><bold>OK</bold> <gray>(%value%)", "%clannexus_hasland%==true;false= <white>Nexus Land: <red><bold>NO</bold> <gray>(need: %value%);true= <white>Nexus Land: <green><bold>OK</bold> <gray>(%value%)", "%land_nexus_power%>1;false= <white>Nexus Power: <red><bold>NO</bold> <gray>(need: %value%);true= <white>Nexus Power: <green><bold>OK</bold> <gray>(%value%)"), "# extra plugins linked to requirements, empty to disable"),
    LEVEL_level_requeriments_list_fifteen_cost("Level.requeriments.list.fifteen.cost", Arrays.asList("bank=10.000", "item=diamond:5"), "#variables: bank=AMOUNT, money=AMOUNT, exp=AMOUNT, item=ITEM:AMOUNT"),
    LEVEL_level_requeriments_list_twenty_level("Level.requeriments.list.twenty.level", 20, "# !important! Requirement level", "#Any placeholder can be used here, internal or external.", "#Valid operators for placeholders: ==, !=, >=, <=, <, >"),
    LEVEL_level_requeriments_list_twenty_rewards("Level.requeriments.list.twenty.rewards", Arrays.asList("eco give %player% 2000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_twenty_surprise_rewards("Level.requeriments.list.twenty.surprise", Arrays.asList("eco give %player% 10000"), "# Rewards will be stored for each player to claim, if they are in the clan at the time of the levelup."),
    LEVEL_level_requeriments_list_twenty_points("Level.requeriments.list.twenty.points", "{FORMULA}", "# Level.points.formula"),
    LEVEL_level_requeriments_list_twenty_description("Level.requeriments.list.twenty.description", Arrays.asList(new Object[0]), new String[0]),
    LEVEL_level_requeriments_list_twenty_requires("Level.requeriments.list.twenty.requires", Arrays.asList("%uclans_count_members%>=15;false= <white>Clan Members: <red><bold>NO</bold> <gray>(need %value% member(s));true= <white>Clan Members: <green><bold>OK</bold> <gray>(%value% members)", "%uclans_bank_balance%>=100.000;false= <white>Clan Bank: <red><bold>NO</bold> <gray>(need %value% money);true= <white>Clan Bank: <green><bold>OK</bold> <gray>(%value% money)", "%uclans_clan_kdr%>=4.0;false= <white>Clan KDR: <red><bold>NO</bold> <gray>(need %value% kdr);true= <white>Clan Kdr: <green><bold>OK</bold> <gray>(%value% kdr)", "%uclans_clan_war_win%>=10;false= <white>Clan War: <red><bold>NO</bold> <gray>(need %value% war);true= <white>Clan War: <green><bold>OK</bold> <gray>(%value% war)", "CHECKITEM:[emerald:10];false= <white>View Items: <red><bold>NO</bold> <gray>(need: %value%);true= <white>View Items: <green><bold>OK</bold> <gray>(%value%)", "%clannexus_hasland%==true;false= <white>Nexus Land: <red><bold>NO</bold> <gray>(need: %value%);true= <white>Nexus Land: <green><bold>OK</bold> <gray>(%value%)", "%land_nexus_power%>2;false= <white>Nexus Power: <red><bold>NO</bold> <gray>(need: %value%);true= <white>Nexus Power: <green><bold>OK</bold> <gray>(%value%)", "%clannexus_land_chunks_amount%>2;false= <white>Nexus Chunks: <red><bold>NO</bold> <gray>(need: %value%);true= <white>Nexus Chunks: <green><bold>OK</bold> <gray>(%value%)"), "# extra plugins linked to requirements, empty to disable"),
    LEVEL_level_requeriments_list_twenty_cost("Level.requeriments.list.twenty.cost", Arrays.asList("bank=100.000", "item=emerald:10"), "#variables: bank=AMOUNT, money=AMOUNT, exp=AMOUNT, item=ITEM:AMOUNT");

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
