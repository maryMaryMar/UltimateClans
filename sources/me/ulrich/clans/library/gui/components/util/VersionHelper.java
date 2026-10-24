package me.ulrich.clans.library.gui.components.util;

import com.google.common.primitives.Ints;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.gui.components.exception.GuiException;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/gui/components/util/VersionHelper.class */
public final class VersionHelper {
    private static final int V1_11 = 1110;
    private static final int V1_13 = 1130;
    private static final int V1_14 = 1140;
    private static final int V1_16_5 = 1165;
    private static final int V1_12_1 = 1121;
    private static final int V1_20_1 = 1201;
    private static final int V1_20_5 = 1205;
    public static final boolean IS_COMPONENT_LEGACY;
    public static final boolean IS_ITEM_LEGACY;
    public static final boolean IS_UNBREAKABLE_LEGACY;
    public static final boolean IS_PDC_VERSION;
    public static final boolean IS_SKULL_OWNER_LEGACY;
    public static final boolean IS_CUSTOM_MODEL_DATA;
    public static final boolean IS_PLAYER_PROFILE_API;
    public static final boolean IS_ITEM_NAME_COMPONENT;
    private static final boolean IS_PAPER;
    public static final boolean IS_FOLIA;
    private static final String CRAFTBUKKIT_PACKAGE = Bukkit.getServer().getClass().getPackage().getName();
    private static final int CURRENT_VERSION = getCurrentVersion();

    private static boolean checkPaper() {
        try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static boolean checkFolia() {
        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static int getCurrentVersion() {
        Matcher matcher = Pattern.compile("(?<version>\\d+\\.\\d+)(?<patch>\\.\\d+)?").matcher(Bukkit.getBukkitVersion());
        StringBuilder sb = new StringBuilder();
        if (matcher.find()) {
            sb.append(matcher.group("version").replace(".", ""));
            String strGroup = matcher.group("patch");
            if (strGroup == null) {
                sb.append("0");
            } else {
                sb.append(strGroup.replace(".", ""));
            }
        }
        Integer numTryParse = Ints.tryParse(sb.toString());
        if (numTryParse == null) {
            throw new GuiException("Could not retrieve server version!");
        }
        return numTryParse.intValue();
    }

    public static Class<?> craftClass(@NotNull String str) {
        return Class.forName(CRAFTBUKKIT_PACKAGE + "." + str);
    }

    static {
        IS_COMPONENT_LEGACY = CURRENT_VERSION < V1_16_5;
        IS_ITEM_LEGACY = CURRENT_VERSION < V1_13;
        IS_UNBREAKABLE_LEGACY = CURRENT_VERSION < V1_11;
        IS_PDC_VERSION = CURRENT_VERSION >= V1_14;
        IS_SKULL_OWNER_LEGACY = CURRENT_VERSION < V1_12_1;
        IS_CUSTOM_MODEL_DATA = CURRENT_VERSION >= V1_14;
        IS_PLAYER_PROFILE_API = CURRENT_VERSION >= V1_20_1;
        IS_ITEM_NAME_COMPONENT = CURRENT_VERSION >= V1_20_5;
        IS_PAPER = checkPaper();
        IS_FOLIA = checkFolia();
    }
}
