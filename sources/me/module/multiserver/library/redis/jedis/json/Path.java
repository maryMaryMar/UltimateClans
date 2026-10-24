package me.module.multiserver.library.redis.jedis.json;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/Path.class */
public class Path {
    public static final Path ROOT_PATH = new Path(".");
    private final String strPath;

    public Path(String str) {
        this.strPath = str;
    }

    public String toString() {
        return this.strPath;
    }

    public static Path of(String str) {
        return new Path(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Path)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return toString().equals(((Path) obj).toString());
    }

    public int hashCode() {
        return this.strPath.hashCode();
    }
}
