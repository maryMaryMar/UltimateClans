package me.ulrich.clans.library.hikari;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/HikariPoolMXBean.class */
public interface HikariPoolMXBean {
    int getIdleConnections();

    int getActiveConnections();

    int getTotalConnections();

    int getThreadsAwaitingConnection();

    void softEvictConnections();

    void suspendPool();

    void resumePool();
}
