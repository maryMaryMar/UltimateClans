package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.SortingOrder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/GeoRadiusParam.class */
public class GeoRadiusParam implements IParams {
    private boolean withCoord = false;
    private boolean withDist = false;
    private boolean withHash = false;
    private Integer count = null;
    private boolean any = false;
    private SortingOrder sortingOrder = null;

    public static GeoRadiusParam geoRadiusParam() {
        return new GeoRadiusParam();
    }

    public GeoRadiusParam withCoord() {
        this.withCoord = true;
        return this;
    }

    public GeoRadiusParam withDist() {
        this.withDist = true;
        return this;
    }

    public GeoRadiusParam withHash() {
        this.withHash = true;
        return this;
    }

    public GeoRadiusParam sortAscending() {
        return sortingOrder(SortingOrder.ASC);
    }

    public GeoRadiusParam sortDescending() {
        return sortingOrder(SortingOrder.DESC);
    }

    public GeoRadiusParam sortingOrder(SortingOrder sortingOrder) {
        this.sortingOrder = sortingOrder;
        return this;
    }

    public GeoRadiusParam count(int i) {
        if (i > 0) {
            this.count = Integer.valueOf(i);
        }
        return this;
    }

    public GeoRadiusParam count(int i, boolean z) {
        if (i > 0) {
            this.count = Integer.valueOf(i);
            if (z) {
                this.any = true;
            }
        }
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.withCoord) {
            commandArguments.add(Protocol.Keyword.WITHCOORD);
        }
        if (this.withDist) {
            commandArguments.add(Protocol.Keyword.WITHDIST);
        }
        if (this.withHash) {
            commandArguments.add(Protocol.Keyword.WITHHASH);
        }
        if (this.count != null) {
            commandArguments.add(Protocol.Keyword.COUNT).add(this.count);
            if (this.any) {
                commandArguments.add(Protocol.Keyword.ANY);
            }
        }
        if (this.sortingOrder != null) {
            commandArguments.add(this.sortingOrder);
        }
    }
}
