package me.module.multiserver.library.redis.jedis.util;

import java.net.URI;
import me.module.multiserver.library.redis.jedis.HostAndPort;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/JedisURIHelper.class */
public final class JedisURIHelper {
    private static final int DEFAULT_DB = 0;
    private static final String REDIS = "redis";
    private static final String REDISS = "rediss";

    private JedisURIHelper() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static HostAndPort getHostAndPort(URI uri) {
        return new HostAndPort(uri.getHost(), uri.getPort());
    }

    public static String getUser(URI uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null) {
            return null;
        }
        String str = userInfo.split(":", 2)[0];
        if (str.isEmpty()) {
            str = null;
        }
        return str;
    }

    public static String getPassword(URI uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo != null) {
            return userInfo.split(":", 2)[1];
        }
        return null;
    }

    public static int getDBIndex(URI uri) {
        String[] strArrSplit = uri.getPath().split("/", 2);
        if (strArrSplit.length <= 1) {
            return 0;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public static boolean isValid(URI uri) {
        return (isEmpty(uri.getScheme()) || isEmpty(uri.getHost()) || uri.getPort() == -1) ? false : true;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isRedisScheme(URI uri) {
        return REDIS.equals(uri.getScheme());
    }

    public static boolean isRedisSSLScheme(URI uri) {
        return REDISS.equals(uri.getScheme());
    }
}
