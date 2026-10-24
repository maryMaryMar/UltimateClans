package me.ulrich.clans.manager.EnumFiles;

import java.util.Arrays;
import me.ulrich.clans.library.enumconfig.interfaces.ConfigurationEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/EnumFiles/Modules.class */
public enum Modules implements ConfigurationEnum {
    CONFIG_extensions_auto_update("Config.extensions.auto_download", true, new String[0]),
    CONFIG_modules("Config.modules", "", " "),
    CONFIG_modules_auto_update("Config.modules.auto_update", false, new String[0]),
    CONFIG_modules_list("Config.modules.list", "", new String[0]),
    CONFIG_modules_list_anvil_26("Config.modules.list.anvil_26.enabled", true, new String[0]),
    CONFIG_modules_list_anvil_1_21("Config.modules.list.anvil_1_21.enabled", true, new String[0]),
    CONFIG_modules_list_anvil_1_20("Config.modules.list.anvil_1_20.enabled", true, new String[0]),
    CONFIG_modules_list_anvil_1_19("Config.modules.list.anvil_1_19.enabled", true, new String[0]),
    CONFIG_modules_list_anvil_1_18("Config.modules.list.anvil_1_18.enabled", true, new String[0]),
    CONFIG_modules_list_banner("Config.modules.list.banner.enabled", true, new String[0]),
    CONFIG_modules_list_chat("Config.modules.list.chat.enabled", true, new String[0]),
    CONFIG_modules_list_discord("Config.modules.list.discord.enabled", true, new String[0]),
    CONFIG_modules_list_home("Config.modules.list.home.enabled", true, new String[0]),
    CONFIG_modules_list_levelup("Config.modules.list.levelup.enabled", true, new String[0]),
    CONFIG_modules_list_logger("Config.modules.list.logger.enabled", true, new String[0]),
    CONFIG_modules_list_mail("Config.modules.list.mail.enabled", true, new String[0]),
    CONFIG_modules_list_multiserver("Config.modules.list.multiserver.enabled", true, new String[0]),
    CONFIG_modules_list_rewards("Config.modules.list.rewards.enabled", true, new String[0]),
    CONFIG_modules_list_rivalally("Config.modules.list.rivalally.enabled", true, new String[0]),
    CONFIG_modules_preferences("Config.modules.preferences", "", "# PREFERENCES: ", "# - Preferences preferably use the top of the list, if there is no implementation of the item, it searches for the next one, if none of the items in the list exist, it searches for the first one added."),
    CONFIG_modules_preferences_holograms("Config.modules.preferences.holograms", Arrays.asList("DECENTHOLOGRAMS", "HOLOGRAMS", "HOLOGRAPHICDISPLAYS", "CMI", "FANCYHOLOGRAMS"), "# Extensions with HOLOGRAM category"),
    CONFIG_modules_preferences_regions("Config.modules.preferences.regions", Arrays.asList("WORLDGUARD", "ULTRAREGIONS"), "# Extensions with REGION category"),
    CONFIG_modules_preferences_money("Config.modules.preferences.money", Arrays.asList("VAULT", "TOKENENCHANT"), "# Extensions with MONEY category."),
    CONFIG_modules_preferences_map("Config.modules.preferences.map", Arrays.asList("DYNMAP", "BLUEMAP"), "# Extensions with MAP category."),
    CONFIG_modules_preferences_scoreboard("Config.modules.preferences.scoreboard", Arrays.asList("TAB", "CMI", "FEATHERBOARD", "STERNALBOARD", "SIMPLESCORE"), "# Extensions with SCOREBOARD category."),
    CONFIG_modules_preferences_claim("Config.modules.preferences.claim", Arrays.asList(new Object[0]), "# Extensions with CLAIM category."),
    CONFIG_modules_preferences_event("Config.modules.preferences.event", Arrays.asList(new Object[0]), "# Extensions with EVENT category."),
    CONFIG_modules_preferences_item("Config.modules.preferences.item", Arrays.asList("NEXO", "ITEMSADDER", "CRAFTENGINE"), "# Extensions with ITEM category."),
    CONFIG_hooks("Config.hooks", "", " "),
    CONFIG_hooks_duels("Config.hooks.duels", true, new String[0]),
    CONFIG_hooks_supervanish("Config.hooks.supervanish", true, new String[0]),
    CONFIG_hooks_premiumvanish("Config.hooks.premiumvanish", true, new String[0]),
    CONFIG_hooks_pvpmanager("Config.hooks.pvpmanager", true, new String[0]),
    CONFIG_hooks_cmi("Config.hooks.cmi", true, new String[0]),
    CONFIG_hooks_deluxecombat("Config.hooks.deluxecombat", false, new String[0]),
    CONFIG_hooks_itemsadder("Config.hooks.itemsadder", true, new String[0]),
    CONFIG_hooks_nbtapi("Config.hooks.nbtapi", true, new String[0]),
    CONFIG_hooks_essentials("Config.hooks.essentials", true, new String[0]),
    CONFIG_hooks_redischat("Config.hooks.redischat", true, new String[0]);

    private String path;
    private Object defaultValue;
    private String[] comments;

    Modules(String str, Object obj, String... strArr) {
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
