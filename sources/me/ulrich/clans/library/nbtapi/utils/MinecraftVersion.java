package me.ulrich.clans.library.nbtapi.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ulrich.clans.library.nbtapi.utils.metrics.bukkit.Metrics;
import me.ulrich.clans.library.nbtapi.utils.metrics.charts.DrilldownPie;
import me.ulrich.clans.library.nbtapi.utils.metrics.charts.SimplePie;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/MinecraftVersion.class */
public enum MinecraftVersion {
    UNKNOWN(Integer.MAX_VALUE),
    MC1_7_R4(174),
    MC1_8_R3(183),
    MC1_9_R1(191),
    MC1_9_R2(192),
    MC1_10_R1(1101),
    MC1_11_R1(1111),
    MC1_12_R1(1121),
    MC1_13_R1(1131),
    MC1_13_R2(1132),
    MC1_14_R1(1141),
    MC1_15_R1(1151),
    MC1_16_R1(1161),
    MC1_16_R2(1162),
    MC1_16_R3(1163),
    MC1_17_R1(1171),
    MC1_18_R1(1181, true),
    MC1_18_R2(1182, true),
    MC1_19_R1(1191, true),
    MC1_19_R2(1192, true),
    MC1_19_R3(1193, true),
    MC1_20_R1(1201, true),
    MC1_20_R2(1202, true),
    MC1_20_R3(1203, true),
    MC1_20_R4(1204, true),
    MC1_21_R1(1211, true),
    MC1_21_R2(1212, true),
    MC1_21_R3(1213, true),
    MC1_21_R4(1214, true),
    MC1_21_R5(1215, true),
    MC1_21_R6(1216, true),
    MC1_21_R7(1217, true),
    MC26_1(260100, true),
    MC26_2(260200, true),
    MC26_3(260300, true);

    private static MinecraftVersion version;
    private static Boolean hasGsonSupport;
    private static Boolean isForgePresent;
    private static Boolean isNeoForgePresent;
    private static Boolean isFabricPresent;
    private static Boolean isFoliaPresent;
    protected static final String VERSION = "2.16.1";
    private final int versionId;
    private final boolean mojangMapping;
    private static boolean bStatsDisabled = false;
    private static boolean disablePackageWarning = false;
    private static boolean updateCheckDisabled = true;
    private static Logger logger = Logger.getLogger("NBTAPI");
    private static final Map<String, MinecraftVersion> VERSION_TO_REVISION = new HashMap<String, MinecraftVersion>() { // from class: me.ulrich.clans.library.nbtapi.utils.MinecraftVersion.1
        {
            put("1.20", MinecraftVersion.MC1_20_R1);
            put("1.20.1", MinecraftVersion.MC1_20_R1);
            put("1.20.2", MinecraftVersion.MC1_20_R2);
            put("1.20.3", MinecraftVersion.MC1_20_R3);
            put("1.20.4", MinecraftVersion.MC1_20_R3);
            put("1.20.5", MinecraftVersion.MC1_20_R4);
            put("1.20.6", MinecraftVersion.MC1_20_R4);
            put("1.21", MinecraftVersion.MC1_21_R1);
            put("1.21.1", MinecraftVersion.MC1_21_R1);
            put("1.21.2", MinecraftVersion.MC1_21_R2);
            put("1.21.3", MinecraftVersion.MC1_21_R2);
            put("1.21.4", MinecraftVersion.MC1_21_R3);
            put("1.21.5", MinecraftVersion.MC1_21_R4);
            put("1.21.6", MinecraftVersion.MC1_21_R5);
            put("1.21.7", MinecraftVersion.MC1_21_R5);
            put("1.21.8", MinecraftVersion.MC1_21_R5);
            put("1.21.9", MinecraftVersion.MC1_21_R6);
            put("1.21.10", MinecraftVersion.MC1_21_R6);
            put("1.21.11", MinecraftVersion.MC1_21_R7);
            put("26.1", MinecraftVersion.MC26_1);
            put("26.2", MinecraftVersion.MC26_2);
            put("26.3", MinecraftVersion.MC26_3);
        }
    };

    MinecraftVersion(int i) {
        this(i, false);
    }

    MinecraftVersion(int i, boolean z) {
        this.versionId = i;
        this.mojangMapping = z;
    }

    public int getVersionId() {
        return this.versionId;
    }

    public boolean isMojangMapping() {
        return this.mojangMapping;
    }

    public String getPackageName() {
        if (this == UNKNOWN) {
            try {
                return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            } catch (Exception e) {
            }
        }
        return name().replace("MC", "v");
    }

    public static boolean isAtLeastVersion(MinecraftVersion minecraftVersion) {
        return getVersion().getVersionId() >= minecraftVersion.getVersionId();
    }

    public static boolean isNewerThan(MinecraftVersion minecraftVersion) {
        return getVersion().getVersionId() > minecraftVersion.getVersionId();
    }

    public static MinecraftVersion getVersion() {
        if (version != null) {
            return version;
        }
        try {
            String str = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            logger.info("[NBTAPI] Found Minecraft: " + str + "! Trying to find NMS support");
            version = valueOf(str.replace("v", "MC"));
        } catch (Exception e) {
            logger.info("[NBTAPI] Found Minecraft: " + Bukkit.getServer().getBukkitVersion().split("-")[0] + "! Trying to find NMS support");
            version = VERSION_TO_REVISION.get(Bukkit.getServer().getBukkitVersion().split("-")[0]);
            if (version == null) {
                String str2 = Bukkit.getServer().getBukkitVersion().split("-")[0].split(".build")[0];
                for (Map.Entry<String, MinecraftVersion> entry : VERSION_TO_REVISION.entrySet()) {
                    if (str2.startsWith(entry.getKey()) && version == null) {
                        version = entry.getValue();
                    } else if (str2.startsWith(entry.getKey()) && entry.getValue().getVersionId() > version.getVersionId()) {
                        version = entry.getValue();
                    }
                }
            }
            if (version == null) {
                version = UNKNOWN;
            }
        }
        if (version != UNKNOWN) {
            logger.info("[NBTAPI] NMS support '" + version.name() + "' loaded!");
        } else {
            logger.warning("[NBTAPI] This Server-Version(" + Bukkit.getServer().getBukkitVersion() + ") is not supported by this NBT-API Version(" + VERSION + ") located in " + VersionChecker.getPlugin() + ". The NBT-API will try to work as good as it can! Some functions may not work!");
        }
        init();
        return version;
    }

    public static String getNBTAPIVersion() {
        return VERSION;
    }

    private static void init() {
        String str = "de.tr7zw.changeme.nbtapi.utils";
        String str2 = "de.tr7zw.nbtapi.utils";
        try {
            if (hasGsonSupport() && !bStatsDisabled) {
                JavaPlugin plugin = Bukkit.getPluginManager().getPlugin(VersionChecker.getPlugin());
                if (plugin != null && (plugin instanceof JavaPlugin)) {
                    getLogger().info("[NBTAPI] Using the plugin '" + plugin.getName() + "' to create a bStats instance!");
                    Metrics metrics = new Metrics(plugin, 1058);
                    metrics.addCustomChart(new SimplePie("nbtapi_version", () -> {
                        return VERSION;
                    }));
                    metrics.addCustomChart(new DrilldownPie("nms_version", () -> {
                        HashMap map = new HashMap();
                        HashMap map2 = new HashMap();
                        map2.put(Bukkit.getName(), 1);
                        map.put(getVersion().name(), map2);
                        return map;
                    }));
                    metrics.addCustomChart(new SimplePie("shaded", () -> {
                        return Boolean.toString(!"NBTAPI".equals(VersionChecker.getPlugin()));
                    }));
                    metrics.addCustomChart(new SimplePie("server_software", () -> {
                        return Bukkit.getName();
                    }));
                    metrics.addCustomChart(new SimplePie("parent_plugin", () -> {
                        return VersionChecker.getPluginforBStats();
                    }));
                    metrics.addCustomChart(new SimplePie("parent_plugin_type", () -> {
                        return VersionChecker.getPluginType();
                    }));
                    metrics.addCustomChart(new SimplePie("special_environment", () -> {
                        if (isFoliaPresent()) {
                            return "Folia";
                        }
                        if (isForgePresent()) {
                            return "Forge";
                        }
                        if (isFabricPresent()) {
                            return "Fabric";
                        }
                        return isNeoForgePresent() ? "NeoForge" : "None";
                    }));
                    metrics.addCustomChart(new SimplePie("bindings_check", () -> {
                        boolean z = false;
                        for (ClassWrapper classWrapper : ClassWrapper.values()) {
                            if (classWrapper.isEnabled() && classWrapper.getClazz() == null) {
                                z = true;
                            }
                        }
                        for (ReflectionMethod reflectionMethod : ReflectionMethod.values()) {
                            if (reflectionMethod.isCompatible() && !reflectionMethod.isLoaded()) {
                                z = true;
                            }
                        }
                        return z ? "Failed" : "Pass";
                    }));
                } else if (plugin == null) {
                    getLogger().info("[NBTAPI] Unable to create a bStats instance!!");
                }
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "[NBTAPI] Error enabling Metrics!", (Throwable) e);
        }
        if (hasGsonSupport() && !updateCheckDisabled) {
            new Thread(() -> {
                try {
                    VersionChecker.checkForUpdates();
                } catch (Exception e2) {
                    logger.log(Level.WARNING, "[NBTAPI] Error while checking for updates! Error: " + e2.getMessage());
                }
            }).start();
        }
        if (!disablePackageWarning && MinecraftVersion.class.getPackage().getName().equals(str)) {
            logger.warning("#########################################- NBTAPI -#########################################");
            logger.warning("The NBT-API package has not been moved! This *will* cause problems with other plugins containing");
            logger.warning("a different version of the api! Please read the guide on the plugin page on how to get the");
            logger.warning("Maven Shade plugin to relocate the api to your personal location! If you are not the developer,");
            logger.warning("please check your plugins and contact their developer, so they can fix this issue.");
            logger.warning("#########################################- NBTAPI -#########################################");
        }
        if (disablePackageWarning || "NBTAPI".equals(VersionChecker.getPlugin())) {
            return;
        }
        if (!"de.tr7zw.nbtapi.utils".equals(str2)) {
            logger.warning("#########################################- NBTAPI -#########################################");
            logger.warning("The NBT-API inside " + VersionChecker.getPlugin() + " is the plugin version, not the API!");
            logger.warning("The plugin itself should never be shaded! Remove the `-plugin` from the dependency and fix your shading setup.");
            logger.warning("For more info check: https://github.com/tr7zw/Item-NBT-API/wiki/Using-Maven#option-2-shading-the-nbt-api-into-your-plugin");
            logger.warning("#########################################- NBTAPI -#########################################");
            return;
        }
        if (MinecraftVersion.class.getPackage().getName().equals("de.tr7zw.nbtapi.utils")) {
            logger.warning("#########################################- NBTAPI -#########################################");
            logger.warning("The NBT-API inside " + VersionChecker.getPlugin() + " is located at 'de.tr7zw.nbtapi.utils'!");
            logger.warning("This package name is reserved for the official NBTAPI plugin, and not intended to be used for shading!");
            logger.warning("Please change the relocate to something else. For example: com.example.util.nbtapi");
            logger.warning("#########################################- NBTAPI -#########################################");
        }
    }

    public static boolean hasGsonSupport() {
        if (hasGsonSupport != null) {
            return hasGsonSupport.booleanValue();
        }
        try {
            Class.forName("com.google.gson.Gson");
            hasGsonSupport = true;
        } catch (Exception e) {
            logger.info("[NBTAPI] Gson not found! This will not allow the usage of some methods!");
            hasGsonSupport = false;
        }
        return hasGsonSupport.booleanValue();
    }

    public static boolean isFabricPresent() {
        if (isFabricPresent != null) {
            return isFabricPresent.booleanValue();
        }
        try {
            logger.info("[NBTAPI] Found Fabric: " + Class.forName("net.fabricmc.api.ModInitializer"));
            isFabricPresent = true;
        } catch (Exception e) {
            isFabricPresent = false;
        }
        return isFabricPresent.booleanValue();
    }

    public static boolean isForgePresent() {
        if (isForgePresent != null) {
            return isForgePresent.booleanValue();
        }
        try {
            logger.info("[NBTAPI] Found Forge: " + (getVersion() == MC1_7_R4 ? Class.forName("cpw.mods.fml.common.Loader") : Class.forName("net.minecraftforge.fml.common.Loader")));
            isForgePresent = true;
        } catch (Exception e) {
            isForgePresent = false;
        }
        return isForgePresent.booleanValue();
    }

    public static boolean isNeoForgePresent() {
        if (isNeoForgePresent != null) {
            return isNeoForgePresent.booleanValue();
        }
        try {
            logger.info("[NBTAPI] Found NeoForge: " + Class.forName("net.neoforged.neoforge.common.NeoForge"));
            isNeoForgePresent = true;
        } catch (Exception e) {
            isNeoForgePresent = false;
        }
        return isNeoForgePresent.booleanValue();
    }

    public static boolean isFoliaPresent() {
        if (isFoliaPresent != null) {
            return isFoliaPresent.booleanValue();
        }
        try {
            logger.info("[NBTAPI] Found Folia: " + Class.forName("io.papermc.paper.threadedregions.RegionizedServer"));
            isFoliaPresent = true;
        } catch (Exception e) {
            isFoliaPresent = false;
        }
        return isFoliaPresent.booleanValue();
    }

    public static void disableBStats() {
        bStatsDisabled = true;
    }

    public static void disableUpdateCheck() {
        updateCheckDisabled = true;
    }

    public static void enableUpdateCheck() {
        updateCheckDisabled = false;
    }

    public static void disablePackageWarning() {
        disablePackageWarning = true;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void replaceLogger(Logger logger2) {
        if (logger2 == null) {
            throw new NullPointerException("Logger can not be null!");
        }
        logger = logger2;
    }
}
