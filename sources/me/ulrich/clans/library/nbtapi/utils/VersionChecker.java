package me.ulrich.clans.library.nbtapi.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import me.ulrich.clans.library.nbtapi.NBTItem;
import org.bukkit.configuration.file.YamlConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/VersionChecker.class */
public class VersionChecker {
    private static final String USER_AGENT = "nbt-api Version check";
    private static final String REQUEST_URL = "https://api.spiget.org/v2/resources/7939/versions?size=100";
    public static boolean hideOk = false;

    protected static void checkForUpdates() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(REQUEST_URL).openConnection();
        httpURLConnection.addRequestProperty("User-Agent", USER_AGENT);
        JsonArray jsonArray = new JsonParser().parse(new InputStreamReader(httpURLConnection.getInputStream()));
        if (!jsonArray.isJsonArray()) {
            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Error when looking for Updates! Got non Json Array: '" + jsonArray.toString() + "'");
            return;
        }
        JsonArray jsonArray2 = jsonArray;
        JsonObject jsonObject = jsonArray2.get(jsonArray2.size() - 1);
        int versionDifference = getVersionDifference(jsonObject.get("name").getAsString());
        if (versionDifference == -1) {
            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] The NBT-API in '" + getPlugin() + "' seems to be outdated!");
            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Current Version: '2.16.1' Newest Version: " + jsonObject.get("name").getAsString() + "'");
            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Please update the NBTAPI or the plugin that contains the api(nag the mod author when the newest release has an old version, not the NBTAPI dev)!");
        } else if (versionDifference == 0) {
            if (hideOk) {
                return;
            }
            MinecraftVersion.getLogger().log(Level.INFO, "[NBTAPI] The NBT-API seems to be up-to-date!");
        } else if (versionDifference == 1) {
            MinecraftVersion.getLogger().log(Level.INFO, "[NBTAPI] The NBT-API in '" + getPlugin() + "' seems to be a future Version, not yet released on Spigot/CurseForge! This is not an error!");
            MinecraftVersion.getLogger().log(Level.INFO, "[NBTAPI] Current Version: '2.16.1' Newest Version: " + jsonObject.get("name").getAsString() + "'");
        }
    }

    private static int getVersionDifference(String str) {
        if ("2.16.1".equals(str)) {
            return 0;
        }
        if ("2.16.1".split("\\.").length != 3 || str.split("\\.").length != 3) {
            return -1;
        }
        int i = Integer.parseInt("2.16.1".split("\\.")[0]);
        int i2 = Integer.parseInt("2.16.1".split("\\.")[1]);
        String str2 = "2.16.1".split("\\.")[2];
        int i3 = Integer.parseInt(str.split("\\.")[0]);
        int i4 = Integer.parseInt(str.split("\\.")[1]);
        String str3 = str.split("\\.")[2];
        if (i < i3) {
            return -1;
        }
        if (i > i3) {
            return 1;
        }
        if (i2 < i4) {
            return -1;
        }
        if (i2 > i4) {
            return 1;
        }
        int i5 = Integer.parseInt(str2.split("-")[0]);
        int i6 = Integer.parseInt(str3.split("-")[0]);
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        if (str3.contains("-") || !str2.contains("-")) {
            return (str3.contains("-") && str2.contains("-")) ? 0 : 1;
        }
        return -1;
    }

    protected static String getPlugin() {
        ClassLoader classLoader = VersionChecker.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("paper-plugin.yml");
        if (resourceAsStream != null) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
                try {
                    String string = YamlConfiguration.loadConfiguration(inputStreamReader).getString("name");
                    inputStreamReader.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Error reading paper-plugin.yml: " + e2.getMessage());
            }
        }
        InputStream resourceAsStream2 = classLoader.getResourceAsStream("plugin.yml");
        if (resourceAsStream2 != null) {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(resourceAsStream2);
                try {
                    String string2 = YamlConfiguration.loadConfiguration(inputStreamReader2).getString("name");
                    inputStreamReader2.close();
                    return string2;
                } catch (Throwable th3) {
                    try {
                        inputStreamReader2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e3) {
            } catch (IllegalArgumentException e4) {
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Error reading plugin.yml: " + e4.getMessage());
            }
        }
        return NBTItem.class.getPackage().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getPluginforBStats() {
        ClassLoader classLoader = VersionChecker.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("paper-plugin.yml");
        if (resourceAsStream != null) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
                try {
                    String string = YamlConfiguration.loadConfiguration(inputStreamReader).getString("name");
                    inputStreamReader.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Error reading paper-plugin.yml: " + e2.getMessage());
            }
        }
        InputStream resourceAsStream2 = classLoader.getResourceAsStream("plugin.yml");
        if (resourceAsStream2 == null) {
            return "UnknownPlugin";
        }
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(resourceAsStream2);
            try {
                String string2 = YamlConfiguration.loadConfiguration(inputStreamReader2).getString("name");
                inputStreamReader2.close();
                return string2;
            } catch (Throwable th3) {
                try {
                    inputStreamReader2.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException e3) {
            return "UnknownPlugin";
        } catch (IllegalArgumentException e4) {
            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Error reading plugin.yml: " + e4.getMessage());
            return "UnknownPlugin";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getPluginType() {
        ClassLoader classLoader = VersionChecker.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("paper-plugin.yml");
        if (resourceAsStream != null) {
            try {
                resourceAsStream.close();
                return "PaperPlugin";
            } catch (IOException e) {
                return "PaperPlugin";
            }
        }
        InputStream resourceAsStream2 = classLoader.getResourceAsStream("plugin.yml");
        if (resourceAsStream2 == null) {
            return "UnknownPlugin";
        }
        try {
            resourceAsStream2.close();
            return "SpigotPlugin";
        } catch (IOException e2) {
            return "SpigotPlugin";
        }
    }
}
