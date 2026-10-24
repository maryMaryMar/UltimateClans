package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.GeoCoordinate;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;
import me.module.multiserver.library.redis.jedis.params.GeoAddParams;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusParam;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusStoreParam;
import me.module.multiserver.library.redis.jedis.params.GeoSearchParam;
import me.module.multiserver.library.redis.jedis.resps.GeoRadiusResponse;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/GeoPipelineBinaryCommands.class */
public interface GeoPipelineBinaryCommands {
    Response<Long> geoadd(byte[] bArr, double d, double d2, byte[] bArr2);

    Response<Long> geoadd(byte[] bArr, Map<byte[], GeoCoordinate> map);

    Response<Long> geoadd(byte[] bArr, GeoAddParams geoAddParams, Map<byte[], GeoCoordinate> map);

    Response<Double> geodist(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Double> geodist(byte[] bArr, byte[] bArr2, byte[] bArr3, GeoUnit geoUnit);

    Response<List<byte[]>> geohash(byte[] bArr, byte[]... bArr2);

    Response<List<GeoCoordinate>> geopos(byte[] bArr, byte[]... bArr2);

    Response<List<GeoRadiusResponse>> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<List<GeoRadiusResponse>> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<List<GeoRadiusResponse>> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<Long> georadiusStore(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    Response<Long> georadiusByMemberStore(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, byte[] bArr2, double d, double d2, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoSearchParam geoSearchParam);

    Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, GeoUnit geoUnit);

    Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, double d2, GeoUnit geoUnit);

    Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam);

    Response<Long> geosearchStoreStoreDist(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam);
}
