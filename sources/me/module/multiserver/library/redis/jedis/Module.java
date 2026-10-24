package me.module.multiserver.library.redis.jedis;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Module.class */
public class Module {
    private final String name;
    private final int version;

    public Module(String str, int i) {
        this.name = str;
        this.version = i;
    }

    public String getName() {
        return this.name;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Module)) {
            return false;
        }
        Module module = (Module) obj;
        if (this.version != module.version) {
            return false;
        }
        return this.name == null ? module.name == null : this.name.equals(module.name);
    }

    public int hashCode() {
        return (31 * (this.name != null ? this.name.hashCode() : 0)) + this.version;
    }
}
