package me.module.multiserver.library.redis.jedis.util;

import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/IOUtils.class */
public class IOUtils {
    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
            }
        }
    }

    private IOUtils() {
        throw new InstantiationError("Must not instantiate this class");
    }
}
