package me.module.multiserver.library.redis.jedis.resps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/AccessControlUser.class */
public class AccessControlUser {
    private final List<String> flags = new ArrayList();
    private final List<String> keys = new ArrayList();
    private final List<String> passwords = new ArrayList();
    private final List<String> channels = new ArrayList();
    private String commands;

    public void addFlag(String str) {
        this.flags.add(str);
    }

    public List<String> getFlags() {
        return this.flags;
    }

    public void addKey(String str) {
        this.keys.add(str);
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public void addKeys(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.keys.addAll(Arrays.asList(str.split(" ")));
    }

    public void addPassword(String str) {
        this.passwords.add(str);
    }

    public List<String> getPassword() {
        return this.passwords;
    }

    public void addChannel(String str) {
        this.channels.add(str);
    }

    public List<String> getChannels() {
        return this.channels;
    }

    public void addChannels(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.channels.addAll(Arrays.asList(str.split(" ")));
    }

    public String getCommands() {
        return this.commands;
    }

    public void setCommands(String str) {
        this.commands = str;
    }

    public String toString() {
        return "AccessControlUser{flags=" + this.flags + ", passwords=" + this.passwords + ", commands='" + this.commands + "', keys='" + this.keys + "', channels='" + this.channels + "'}";
    }
}
