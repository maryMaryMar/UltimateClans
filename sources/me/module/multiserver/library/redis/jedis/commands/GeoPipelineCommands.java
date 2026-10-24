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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/GeoPipelineCommands.class */
public interface GeoPipelineCommands {
    Response<Long> geoadd(String str, double d, double d2, String str2);

    Response<Long> geoadd(String str, Map<String, GeoCoordinate> map);

    Response<Long> geoadd(String str, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map);

    Response<Double> geodist(String str, String str2, String str3);

    Response<Double> geodist(String str, String str2, String str3, GeoUnit geoUnit);

    Response<List<String>> geohash(String str, String... strArr);

    Response<List<GeoCoordinate>> geopos(String str, String... strArr);

    Response<List<GeoRadiusResponse>> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<List<GeoRadiusResponse>> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<List<GeoRadiusResponse>> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    Response<Long> georadiusStore(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    Response<Long> georadiusByMemberStore(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    Response<List<GeoRadiusResponse>> geosearch(String str, String str2, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(String str, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(String str, String str2, double d, double d2, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(String str, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    Response<List<GeoRadiusResponse>> geosearch(String str, GeoSearchParam geoSearchParam);

    Response<Long> geosearchStore(String str, String str2, String str3, double d, GeoUnit geoUnit);

    Response<Long> geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    Response<Long> geosearchStore(String str, String str2, String str3, double d, double d2, GeoUnit geoUnit);

    Response<Long> geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    Response<Long> geosearchStore(String str, String str2, GeoSearchParam geoSearchParam);

    Response<Long> geosearchStoreStoreDist(String str, String str2, GeoSearchParam geoSearchParam);
}
