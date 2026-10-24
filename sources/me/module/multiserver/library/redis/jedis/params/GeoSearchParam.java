package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.GeoCoordinate;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;
import me.module.multiserver.library.redis.jedis.args.SortingOrder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/GeoSearchParam.class */
public class GeoSearchParam implements IParams {
    private String member;
    private GeoCoordinate coord;
    private double radius;
    private double width;
    private double height;
    private GeoUnit unit;
    private boolean fromMember = false;
    private boolean fromLonLat = false;
    private boolean byRadius = false;
    private boolean byBox = false;
    private boolean withCoord = false;
    private boolean withDist = false;
    private boolean withHash = false;
    private Integer count = null;
    private boolean any = false;
    private SortingOrder sortingOrder = null;

    public static GeoSearchParam geoSearchParam() {
        return new GeoSearchParam();
    }

    public GeoSearchParam fromMember(String str) {
        this.fromMember = true;
        this.member = str;
        return this;
    }

    public GeoSearchParam fromLonLat(double d, double d2) {
        this.fromLonLat = true;
        this.coord = new GeoCoordinate(d, d2);
        return this;
    }

    public GeoSearchParam fromLonLat(GeoCoordinate geoCoordinate) {
        this.fromLonLat = true;
        this.coord = geoCoordinate;
        return this;
    }

    public GeoSearchParam byRadius(double d, GeoUnit geoUnit) {
        this.byRadius = true;
        this.radius = d;
        this.unit = geoUnit;
        return this;
    }

    public GeoSearchParam byBox(double d, double d2, GeoUnit geoUnit) {
        this.byBox = true;
        this.width = d;
        this.height = d2;
        this.unit = geoUnit;
        return this;
    }

    public GeoSearchParam withCoord() {
        this.withCoord = true;
        return this;
    }

    public GeoSearchParam withDist() {
        this.withDist = true;
        return this;
    }

    public GeoSearchParam withHash() {
        this.withHash = true;
        return this;
    }

    public GeoSearchParam asc() {
        return sortingOrder(SortingOrder.ASC);
    }

    public GeoSearchParam desc() {
        return sortingOrder(SortingOrder.DESC);
    }

    public GeoSearchParam sortingOrder(SortingOrder sortingOrder) {
        this.sortingOrder = sortingOrder;
        return this;
    }

    public GeoSearchParam count(int i) {
        return count(i, false);
    }

    public GeoSearchParam count(int i, boolean z) {
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
        if (this.fromMember) {
            commandArguments.add(Protocol.Keyword.FROMMEMBER);
            commandArguments.add(this.member);
        } else if (this.fromLonLat) {
            commandArguments.add(Protocol.Keyword.FROMLONLAT);
            commandArguments.add(Double.valueOf(this.coord.getLongitude()));
            commandArguments.add(Double.valueOf(this.coord.getLatitude()));
        }
        if (this.byRadius) {
            commandArguments.add(Protocol.Keyword.BYRADIUS);
            commandArguments.add(Double.valueOf(this.radius));
        } else if (this.byBox) {
            commandArguments.add(Protocol.Keyword.BYBOX);
            commandArguments.add(Double.valueOf(this.width));
            commandArguments.add(Double.valueOf(this.height));
        }
        commandArguments.add(this.unit);
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
