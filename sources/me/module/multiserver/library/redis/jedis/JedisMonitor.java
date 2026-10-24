package me.module.multiserver.library.redis.jedis;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisMonitor.class */
public abstract class JedisMonitor {
    protected Connection client;

    public void proceed(Connection connection) {
        this.client = connection;
        this.client.setTimeoutInfinite();
        do {
            onCommand(connection.getBulkReply());
        } while (connection.isConnected());
    }

    public abstract void onCommand(String str);
}
