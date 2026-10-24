package me.ulrich.clans.library.hikari.hibernate;

import java.util.Map;
import java.util.Properties;
import me.module.multiserver.library.redis.jedis.resps.AccessControlLogEntry;
import me.ulrich.clans.library.hikari.HikariConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/hibernate/HikariConfigurationUtil.class */
public class HikariConfigurationUtil {
    public static final String CONFIG_PREFIX = "hibernate.hikari.";
    public static final String CONFIG_PREFIX_DATASOURCE = "hibernate.hikari.dataSource.";

    public static HikariConfig loadConfiguration(Map map) {
        Properties properties = new Properties();
        copyProperty("hibernate.connection.isolation", map, "transactionIsolation", properties);
        copyProperty("hibernate.connection.autocommit", map, "autoCommit", properties);
        copyProperty("hibernate.connection.driver_class", map, "driverClassName", properties);
        copyProperty("hibernate.connection.url", map, "jdbcUrl", properties);
        copyProperty("hibernate.connection.username", map, AccessControlLogEntry.USERNAME, properties);
        copyProperty("hibernate.connection.password", map, "password", properties);
        for (String str : map.keySet()) {
            if (str.startsWith(CONFIG_PREFIX)) {
                properties.setProperty(str.substring(CONFIG_PREFIX.length()), (String) map.get(str));
            }
        }
        return new HikariConfig(properties);
    }

    private static void copyProperty(String str, Map map, String str2, Properties properties) {
        if (map.containsKey(str)) {
            properties.setProperty(str2, (String) map.get(str));
        }
    }
}
