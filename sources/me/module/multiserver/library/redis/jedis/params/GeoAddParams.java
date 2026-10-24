package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/GeoAddParams.class */
public class GeoAddParams implements IParams {
    private boolean nx = false;
    private boolean xx = false;
    private boolean ch = false;

    public static GeoAddParams geoAddParams() {
        return new GeoAddParams();
    }

    public GeoAddParams nx() {
        this.nx = true;
        return this;
    }

    public GeoAddParams xx() {
        this.xx = true;
        return this;
    }

    public GeoAddParams ch() {
        this.ch = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.nx) {
            commandArguments.add(Protocol.Keyword.NX);
        } else if (this.xx) {
            commandArguments.add(Protocol.Keyword.XX);
        }
        if (this.ch) {
            commandArguments.add(Protocol.Keyword.CH);
        }
    }
}
