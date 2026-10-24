package me.ulrich.clans.library.nbtapi.utils.metrics.bukkit;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.logging.Level;
import me.ulrich.clans.library.nbtapi.utils.metrics.MetricsBase;
import me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/bukkit/Metrics.class */
public class Metrics {
    private final Plugin plugin;
    private final MetricsBase metricsBase;

    public Metrics(Plugin plugin, int i) {
        this.plugin = plugin;
        File file = new File(new File(plugin.getDataFolder().getParentFile(), "bStats"), "config.yml");
        YamlConfiguration yamlConfigurationLoadConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!yamlConfigurationLoadConfiguration.isSet("serverUuid")) {
            yamlConfigurationLoadConfiguration.addDefault("enabled", true);
            yamlConfigurationLoadConfiguration.addDefault("serverUuid", UUID.randomUUID().toString());
            yamlConfigurationLoadConfiguration.addDefault("logFailedRequests", false);
            yamlConfigurationLoadConfiguration.addDefault("logSentData", false);
            yamlConfigurationLoadConfiguration.addDefault("logResponseStatusText", false);
            yamlConfigurationLoadConfiguration.options().header("bStats (https://bStats.org) collects some basic information for plugin authors, like how\nmany people use their plugin and their total player count. It's recommended to keep bStats\nenabled, but if you're not comfortable with this, you can turn this setting off. There is no\nperformance penalty associated with having metrics enabled, and data sent to bStats is fully\nanonymous.\nLearn more here: https://bstats.org/docs/server-owners").copyDefaults(true);
            try {
                yamlConfigurationLoadConfiguration.save(file);
            } catch (IOException e) {
            }
        }
        boolean z = yamlConfigurationLoadConfiguration.getBoolean("enabled", true);
        String string = yamlConfigurationLoadConfiguration.getString("serverUuid");
        boolean z2 = yamlConfigurationLoadConfiguration.getBoolean("logFailedRequests", false);
        boolean z3 = yamlConfigurationLoadConfiguration.getBoolean("logSentData", false);
        boolean z4 = yamlConfigurationLoadConfiguration.getBoolean("logResponseStatusText", false);
        boolean z5 = false;
        try {
            z5 = Class.forName("io.papermc.paper.threadedregions.RegionizedServer") != null;
        } catch (Exception e2) {
        }
        Consumer consumer = this::appendPlatformData;
        Consumer consumer2 = this::appendServiceData;
        Consumer consumer3 = z5 ? null : runnable -> {
            Bukkit.getScheduler().runTask(plugin, runnable);
        };
        Objects.requireNonNull(plugin);
        this.metricsBase = new MetricsBase("bukkit", string, i, z, consumer, consumer2, consumer3, plugin::isEnabled, (str, th) -> {
            this.plugin.getLogger().log(Level.WARNING, str, th);
        }, str2 -> {
            this.plugin.getLogger().log(Level.INFO, str2);
        }, z2, z3, z4, false);
    }

    public void shutdown() {
        this.metricsBase.shutdown();
    }

    public void addCustomChart(CustomChart customChart) {
        this.metricsBase.addCustomChart(customChart);
    }

    private void appendPlatformData(JsonObjectBuilder jsonObjectBuilder) {
        jsonObjectBuilder.appendField("playerAmount", getPlayerAmount());
        jsonObjectBuilder.appendField("onlineMode", Bukkit.getOnlineMode() ? 1 : 0);
        jsonObjectBuilder.appendField("bukkitVersion", Bukkit.getVersion());
        jsonObjectBuilder.appendField("bukkitName", Bukkit.getName());
        jsonObjectBuilder.appendField("javaVersion", System.getProperty("java.version"));
        jsonObjectBuilder.appendField("osName", System.getProperty("os.name"));
        jsonObjectBuilder.appendField("osArch", System.getProperty("os.arch"));
        jsonObjectBuilder.appendField("osVersion", System.getProperty("os.version"));
        jsonObjectBuilder.appendField("coreCount", Runtime.getRuntime().availableProcessors());
    }

    private void appendServiceData(JsonObjectBuilder jsonObjectBuilder) {
        jsonObjectBuilder.appendField("pluginVersion", this.plugin.getDescription().getVersion());
    }

    private int getPlayerAmount() {
        try {
            Method method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", new Class[0]);
            return method.getReturnType().equals(Collection.class) ? ((Collection) method.invoke(Bukkit.getServer(), new Object[0])).size() : ((Player[]) method.invoke(Bukkit.getServer(), new Object[0])).length;
        } catch (Exception e) {
            return Bukkit.getOnlinePlayers().size();
        }
    }
}
