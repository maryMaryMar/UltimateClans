package me.ulrich.clans.library.hikari.util;

import javax.management.ConstructorParameters;
import me.module.multiserver.library.redis.jedis.resps.AccessControlLogEntry;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/Credentials.class */
public final class Credentials {
    private final String username;
    private final String password;

    public static Credentials of(String str, String str2) {
        return new Credentials(str, str2);
    }

    @ConstructorParameters({AccessControlLogEntry.USERNAME, "password"})
    public Credentials(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
