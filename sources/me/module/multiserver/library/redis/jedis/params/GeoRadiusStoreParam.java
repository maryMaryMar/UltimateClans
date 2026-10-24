package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/GeoRadiusStoreParam.class */
public class GeoRadiusStoreParam implements IParams {
    private boolean store = false;
    private boolean storeDist = false;
    private String key;

    public static GeoRadiusStoreParam geoRadiusStoreParam() {
        return new GeoRadiusStoreParam();
    }

    public GeoRadiusStoreParam store(String str) {
        if (str != null) {
            this.store = true;
            this.key = str;
        }
        return this;
    }

    public GeoRadiusStoreParam storeDist(String str) {
        if (str != null) {
            this.storeDist = true;
            this.key = str;
        }
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.storeDist) {
            commandArguments.add(Protocol.Keyword.STOREDIST).key(this.key);
        } else {
            if (!this.store) {
                throw new IllegalArgumentException(getClass().getSimpleName() + " must has store or storedist option");
            }
            commandArguments.add(Protocol.Keyword.STORE).key(this.key);
        }
    }
}
