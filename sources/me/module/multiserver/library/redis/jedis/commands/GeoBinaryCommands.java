package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.GeoCoordinate;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;
import me.module.multiserver.library.redis.jedis.params.GeoAddParams;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusParam;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusStoreParam;
import me.module.multiserver.library.redis.jedis.params.GeoSearchParam;
import me.module.multiserver.library.redis.jedis.resps.GeoRadiusResponse;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/GeoBinaryCommands.class */
public interface GeoBinaryCommands {
    long geoadd(byte[] bArr, double d, double d2, byte[] bArr2);

    long geoadd(byte[] bArr, Map<byte[], GeoCoordinate> map);

    long geoadd(byte[] bArr, GeoAddParams geoAddParams, Map<byte[], GeoCoordinate> map);

    Double geodist(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Double geodist(byte[] bArr, byte[] bArr2, byte[] bArr3, GeoUnit geoUnit);

    List<byte[]> geohash(byte[] bArr, byte[]... bArr2);

    List<GeoCoordinate> geopos(byte[] bArr, byte[]... bArr2);

    List<GeoRadiusResponse> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    long georadiusStore(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    long georadiusByMemberStore(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    List<GeoRadiusResponse> geosearch(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(byte[] bArr, byte[] bArr2, double d, double d2, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(byte[] bArr, GeoSearchParam geoSearchParam);

    long geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, GeoUnit geoUnit);

    long geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    long geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, double d2, GeoUnit geoUnit);

    long geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    long geosearchStore(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam);

    long geosearchStoreStoreDist(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam);
}
