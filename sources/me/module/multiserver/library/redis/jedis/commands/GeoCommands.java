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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/GeoCommands.class */
public interface GeoCommands {
    long geoadd(String str, double d, double d2, String str2);

    long geoadd(String str, Map<String, GeoCoordinate> map);

    long geoadd(String str, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map);

    Double geodist(String str, String str2, String str3);

    Double geodist(String str, String str2, String str3, GeoUnit geoUnit);

    List<String> geohash(String str, String... strArr);

    List<GeoCoordinate> geopos(String str, String... strArr);

    List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    List<GeoRadiusResponse> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam);

    long georadiusStore(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    long georadiusByMemberStore(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam);

    List<GeoRadiusResponse> geosearch(String str, String str2, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(String str, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(String str, String str2, double d, double d2, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(String str, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    List<GeoRadiusResponse> geosearch(String str, GeoSearchParam geoSearchParam);

    long geosearchStore(String str, String str2, String str3, double d, GeoUnit geoUnit);

    long geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit);

    long geosearchStore(String str, String str2, String str3, double d, double d2, GeoUnit geoUnit);

    long geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit);

    long geosearchStore(String str, String str2, GeoSearchParam geoSearchParam);

    long geosearchStoreStoreDist(String str, String str2, GeoSearchParam geoSearchParam);
}
