package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.SaveMode;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ShutdownParams.class */
public class ShutdownParams implements IParams {
    private SaveMode saveMode;
    private boolean now;
    private boolean force;

    public static ShutdownParams shutdownParams() {
        return new ShutdownParams();
    }

    public ShutdownParams saveMode(SaveMode saveMode) {
        this.saveMode = saveMode;
        return this;
    }

    public ShutdownParams nosave() {
        return saveMode(SaveMode.NOSAVE);
    }

    public ShutdownParams save() {
        return saveMode(SaveMode.SAVE);
    }

    public ShutdownParams now() {
        this.now = true;
        return this;
    }

    public ShutdownParams force() {
        this.force = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.saveMode != null) {
            commandArguments.add(SafeEncoder.encode(this.saveMode.getRaw()));
        }
        if (this.now) {
            commandArguments.add(Protocol.Keyword.NOW.getRaw());
        }
        if (this.force) {
            commandArguments.add(Protocol.Keyword.FORCE.getRaw());
        }
    }
}
