package me.ulrich.clans.library.hikari;

import java.sql.SQLException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/SQLExceptionOverride.class */
public interface SQLExceptionOverride {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/SQLExceptionOverride$Override.class */
    public enum Override {
        CONTINUE_EVICT,
        DO_NOT_EVICT,
        MUST_EVICT
    }

    default Override adjudicate(SQLException sQLException) {
        return Override.CONTINUE_EVICT;
    }
}
