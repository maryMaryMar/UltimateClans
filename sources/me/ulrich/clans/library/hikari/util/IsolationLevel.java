package me.ulrich.clans.library.hikari.util;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/IsolationLevel.class */
public enum IsolationLevel {
    TRANSACTION_NONE(0),
    TRANSACTION_READ_UNCOMMITTED(1),
    TRANSACTION_READ_COMMITTED(2),
    TRANSACTION_CURSOR_STABILITY(3),
    TRANSACTION_REPEATABLE_READ(4),
    TRANSACTION_LAST_COMMITTED(5),
    TRANSACTION_SERIALIZABLE(8),
    TRANSACTION_SQL_SERVER_SNAPSHOT_ISOLATION_LEVEL(4096);

    private final int levelId;

    IsolationLevel(int i) {
        this.levelId = i;
    }

    public int getLevelId() {
        return this.levelId;
    }
}
