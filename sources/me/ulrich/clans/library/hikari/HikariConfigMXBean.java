package me.ulrich.clans.library.hikari;

import me.ulrich.clans.library.hikari.util.Credentials;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/HikariConfigMXBean.class */
public interface HikariConfigMXBean {
    long getConnectionTimeout();

    void setConnectionTimeout(long j);

    long getValidationTimeout();

    void setValidationTimeout(long j);

    long getIdleTimeout();

    void setIdleTimeout(long j);

    long getLeakDetectionThreshold();

    void setLeakDetectionThreshold(long j);

    long getMaxLifetime();

    void setMaxLifetime(long j);

    int getMinimumIdle();

    void setMinimumIdle(int i);

    int getMaximumPoolSize();

    void setMaximumPoolSize(int i);

    void setPassword(String str);

    void setUsername(String str);

    void setCredentials(Credentials credentials);

    String getPoolName();

    String getCatalog();

    void setCatalog(String str);
}
