package me.module.multiserver.library.redis.jedis.json;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/Path2.class */
public class Path2 {
    public static final Path2 ROOT_PATH = new Path2("$");
    private final String str;

    public Path2(String str) {
        if (str == null) {
            throw new NullPointerException("Path cannot be null.");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Path cannot be empty.");
        }
        if (str.charAt(0) == '$') {
            this.str = str;
        } else if (str.charAt(0) == '.') {
            this.str = '$' + str;
        } else {
            this.str = "$." + str;
        }
    }

    public String toString() {
        return this.str;
    }

    public static Path2 of(String str) {
        return new Path2(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Path2)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return toString().equals(((Path2) obj).toString());
    }

    public int hashCode() {
        return this.str.hashCode();
    }
}
