package me.module.multiserver.library.redis.jedis;

import a.a.b.f;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import me.module.multiserver.library.redis.jedis.args.BitCountOption;
import me.module.multiserver.library.redis.jedis.args.BitOP;
import me.module.multiserver.library.redis.jedis.args.ExpiryOption;
import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.FunctionRestorePolicy;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;
import me.module.multiserver.library.redis.jedis.args.ListDirection;
import me.module.multiserver.library.redis.jedis.args.ListPosition;
import me.module.multiserver.library.redis.jedis.args.SortedSetOption;
import me.module.multiserver.library.redis.jedis.bloom.BFInsertParams;
import me.module.multiserver.library.redis.jedis.bloom.BFReserveParams;
import me.module.multiserver.library.redis.jedis.bloom.CFInsertParams;
import me.module.multiserver.library.redis.jedis.bloom.CFReserveParams;
import me.module.multiserver.library.redis.jedis.bloom.RedisBloomProtocol;
import me.module.multiserver.library.redis.jedis.bloom.TDigestMergeParams;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.graph.GraphProtocol;
import me.module.multiserver.library.redis.jedis.json.JsonProtocol;
import me.module.multiserver.library.redis.jedis.json.JsonSetParams;
import me.module.multiserver.library.redis.jedis.json.Path;
import me.module.multiserver.library.redis.jedis.json.Path2;
import me.module.multiserver.library.redis.jedis.params.BitPosParams;
import me.module.multiserver.library.redis.jedis.params.GeoAddParams;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusParam;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusStoreParam;
import me.module.multiserver.library.redis.jedis.params.GeoSearchParam;
import me.module.multiserver.library.redis.jedis.params.GetExParams;
import me.module.multiserver.library.redis.jedis.params.LCSParams;
import me.module.multiserver.library.redis.jedis.params.LPosParams;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;
import me.module.multiserver.library.redis.jedis.params.RestoreParams;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.params.SetParams;
import me.module.multiserver.library.redis.jedis.params.SortingParams;
import me.module.multiserver.library.redis.jedis.params.StrAlgoLCSParams;
import me.module.multiserver.library.redis.jedis.params.XAddParams;
import me.module.multiserver.library.redis.jedis.params.XAutoClaimParams;
import me.module.multiserver.library.redis.jedis.params.XClaimParams;
import me.module.multiserver.library.redis.jedis.params.XPendingParams;
import me.module.multiserver.library.redis.jedis.params.XReadGroupParams;
import me.module.multiserver.library.redis.jedis.params.XReadParams;
import me.module.multiserver.library.redis.jedis.params.XTrimParams;
import me.module.multiserver.library.redis.jedis.params.ZAddParams;
import me.module.multiserver.library.redis.jedis.params.ZIncrByParams;
import me.module.multiserver.library.redis.jedis.params.ZParams;
import me.module.multiserver.library.redis.jedis.params.ZRangeParams;
import me.module.multiserver.library.redis.jedis.resps.FunctionStats;
import me.module.multiserver.library.redis.jedis.resps.GeoRadiusResponse;
import me.module.multiserver.library.redis.jedis.resps.KeyedListElement;
import me.module.multiserver.library.redis.jedis.resps.KeyedZSetElement;
import me.module.multiserver.library.redis.jedis.resps.LCSMatchResult;
import me.module.multiserver.library.redis.jedis.resps.LibraryInfo;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.resps.StreamConsumersInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamFullInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamGroupInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingSummary;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.search.FTCreateParams;
import me.module.multiserver.library.redis.jedis.search.FTSearchParams;
import me.module.multiserver.library.redis.jedis.search.IndexOptions;
import me.module.multiserver.library.redis.jedis.search.Query;
import me.module.multiserver.library.redis.jedis.search.Schema;
import me.module.multiserver.library.redis.jedis.search.SearchProtocol;
import me.module.multiserver.library.redis.jedis.search.SearchResult;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationBuilder;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationResult;
import me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField;
import me.module.multiserver.library.redis.jedis.timeseries.AggregationType;
import me.module.multiserver.library.redis.jedis.timeseries.TSAlterParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSCreateParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSElement;
import me.module.multiserver.library.redis.jedis.timeseries.TSGetParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSInfo;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyValue;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyedElements;
import me.module.multiserver.library.redis.jedis.timeseries.TSMGetParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSMRangeParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSRangeParams;
import me.module.multiserver.library.redis.jedis.timeseries.TimeSeriesProtocol;
import me.module.multiserver.library.redis.jedis.util.KeyValue;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/CommandObjects.class */
public class CommandObjects {
    private static final f GSON = new f();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/CommandObjects$GsonObjectBuilder.class */
    private class GsonObjectBuilder<T> extends Builder<T> {
        private final Class<T> clazz;

        public GsonObjectBuilder(Class<T> cls) {
            this.clazz = cls;
        }

        @Override // me.module.multiserver.library.redis.jedis.Builder
        public T build(Object obj) {
            return (T) CommandObjects.GSON.a(BuilderFactory.STRING.build(obj), (Class) this.clazz);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/CommandObjects$GsonObjectListBuilder.class */
    private class GsonObjectListBuilder<T> extends Builder<List<T>> {
        private final Class<T> clazz;

        public GsonObjectListBuilder(Class<T> cls) {
            this.clazz = cls;
        }

        @Override // me.module.multiserver.library.redis.jedis.Builder
        public List<T> build(Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) BuilderFactory.STRING_LIST.build(obj).stream().map(str -> {
                return CommandObjects.GSON.a(str, (Class) this.clazz);
            }).collect(Collectors.toList());
        }
    }

    protected CommandArguments commandArguments(ProtocolCommand protocolCommand) {
        return new CommandArguments(protocolCommand);
    }

    public final CommandObject<Boolean> exists(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXISTS).key(str), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> exists(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXISTS).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Boolean> exists(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXISTS).key(bArr), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> exists(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXISTS).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> persist(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.PERSIST).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> persist(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PERSIST).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<String> type(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.TYPE).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> type(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.TYPE).key(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> dump(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.DUMP).key(str), BuilderFactory.BINARY);
    }

    public final CommandObject<byte[]> dump(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.DUMP).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<String> restore(String str, long j, byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.RESTORE).key(str).add(Long.valueOf(j)).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> restore(String str, long j, byte[] bArr, RestoreParams restoreParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.RESTORE).key(str).add(Long.valueOf(j)).add(bArr).addParams(restoreParams), BuilderFactory.STRING);
    }

    public final CommandObject<String> restore(byte[] bArr, long j, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RESTORE).key(bArr).add(Long.valueOf(j)).add(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<String> restore(byte[] bArr, long j, byte[] bArr2, RestoreParams restoreParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.RESTORE).key(bArr).add(Long.valueOf(j)).add(bArr2).addParams(restoreParams), BuilderFactory.STRING);
    }

    public final CommandObject<Long> expire(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIRE).key(str).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expire(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIRE).key(bArr).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expire(String str, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIRE).key(str).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expire(byte[] bArr, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIRE).key(bArr).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpire(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIRE).key(str).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpire(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIRE).key(bArr).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpire(String str, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIRE).key(str).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpire(byte[] bArr, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIRE).key(bArr).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expireTime(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIRETIME).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expireTime(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIRETIME).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpireTime(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIRETIME).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpireTime(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIRETIME).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expireAt(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIREAT).key(str).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expireAt(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIREAT).key(bArr).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expireAt(String str, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIREAT).key(str).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> expireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.EXPIREAT).key(bArr).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpireAt(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIREAT).key(str).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpireAt(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIREAT).key(bArr).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpireAt(String str, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIREAT).key(str).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pexpireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.PEXPIREAT).key(bArr).add(Long.valueOf(j)).add(expiryOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> ttl(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.TTL).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> ttl(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.TTL).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pttl(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.PTTL).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pttl(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PTTL).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> touch(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.TOUCH).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> touch(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.TOUCH).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> touch(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.TOUCH).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> touch(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.TOUCH).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> sort(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(str), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> sort(String str, SortingParams sortingParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(str).addParams(sortingParams), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<byte[]>> sort(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(bArr), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> sort(byte[] bArr, SortingParams sortingParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(bArr).addParams(sortingParams), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Long> sort(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(str).add(Protocol.Keyword.STORE).key(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sort(String str, SortingParams sortingParams, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(str).addParams(sortingParams).add(Protocol.Keyword.STORE).key(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sort(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(bArr).add(Protocol.Keyword.STORE).key(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT).key(bArr).addParams(sortingParams).add(Protocol.Keyword.STORE).key(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<List<byte[]>> sortReadonly(byte[] bArr, SortingParams sortingParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT_RO).key(bArr).addParams(sortingParams), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<String>> sortReadonly(String str, SortingParams sortingParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SORT_RO).key(str).addParams(sortingParams), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<Long> del(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.DEL).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> del(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.DEL).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> del(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.DEL).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> del(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.DEL).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> unlink(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.UNLINK).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> unlink(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.UNLINK).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> unlink(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.UNLINK).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> unlink(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.UNLINK).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Boolean> copy(String str, String str2, boolean z) {
        CommandArguments commandArgumentsKey = commandArguments(Protocol.Command.COPY).key(str).key(str2);
        if (z) {
            commandArgumentsKey.add(Protocol.Keyword.REPLACE);
        }
        return new CommandObject<>(commandArgumentsKey, BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> copy(byte[] bArr, byte[] bArr2, boolean z) {
        CommandArguments commandArgumentsKey = commandArguments(Protocol.Command.COPY).key(bArr).key(bArr2);
        if (z) {
            commandArgumentsKey.add(Protocol.Keyword.REPLACE);
        }
        return new CommandObject<>(commandArgumentsKey, BuilderFactory.BOOLEAN);
    }

    public final CommandObject<String> rename(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RENAME).key(str).key(str2), BuilderFactory.STRING);
    }

    public final CommandObject<Long> renamenx(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RENAMENX).key(str).key(str2), BuilderFactory.LONG);
    }

    public final CommandObject<String> rename(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RENAME).key(bArr).key(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<Long> renamenx(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RENAMENX).key(bArr).key(bArr2), BuilderFactory.LONG);
    }

    public CommandObject<Long> dbSize() {
        return new CommandObject<>(commandArguments(Protocol.Command.DBSIZE), BuilderFactory.LONG);
    }

    public CommandObject<Set<String>> keys(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.KEYS).key(str), BuilderFactory.STRING_SET);
    }

    public CommandObject<Set<byte[]>> keys(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.KEYS).key(bArr), BuilderFactory.BINARY_SET);
    }

    public CommandObject<ScanResult<String>> scan(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCAN).add(str), BuilderFactory.SCAN_RESPONSE);
    }

    public CommandObject<ScanResult<String>> scan(String str, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCAN).add(str).addParams(scanParams), BuilderFactory.SCAN_RESPONSE);
    }

    public CommandObject<ScanResult<String>> scan(String str, ScanParams scanParams, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCAN).add(str).addParams(scanParams).add(Protocol.Keyword.TYPE).add(str2), BuilderFactory.SCAN_RESPONSE);
    }

    public CommandObject<ScanResult<byte[]>> scan(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCAN).add(bArr), BuilderFactory.SCAN_BINARY_RESPONSE);
    }

    public CommandObject<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCAN).add(bArr).addParams(scanParams), BuilderFactory.SCAN_BINARY_RESPONSE);
    }

    public CommandObject<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCAN).add(bArr).addParams(scanParams).add(Protocol.Keyword.TYPE).add(bArr2), BuilderFactory.SCAN_BINARY_RESPONSE);
    }

    public final CommandObject<String> randomKey() {
        return new CommandObject<>(commandArguments(Protocol.Command.RANDOMKEY), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> randomBinaryKey() {
        return new CommandObject<>(commandArguments(Protocol.Command.RANDOMKEY), BuilderFactory.BINARY);
    }

    public final CommandObject<String> set(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SET).key(str).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<String> set(String str, String str2, SetParams setParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SET).key(str).add(str2).addParams(setParams), BuilderFactory.STRING);
    }

    public final CommandObject<String> set(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SET).key(bArr).add(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<String> set(byte[] bArr, byte[] bArr2, SetParams setParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SET).key(bArr).add(bArr2).addParams(setParams), BuilderFactory.STRING);
    }

    public final CommandObject<String> get(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.GET).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> setGet(String str, String str2, SetParams setParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SET).key(str).add(str2).addParams(setParams).add(Protocol.Keyword.GET), BuilderFactory.STRING);
    }

    public final CommandObject<String> getDel(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETDEL).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> getEx(String str, GetExParams getExParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETEX).key(str).addParams(getExParams), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> get(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.GET).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<byte[]> setGet(byte[] bArr, byte[] bArr2, SetParams setParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SET).key(bArr).add(bArr2).addParams(setParams).add(Protocol.Keyword.GET), BuilderFactory.BINARY);
    }

    public final CommandObject<byte[]> getDel(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETDEL).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<byte[]> getEx(byte[] bArr, GetExParams getExParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETEX).key(bArr).addParams(getExParams), BuilderFactory.BINARY);
    }

    public final CommandObject<String> getSet(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETSET).key(str).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> getSet(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETSET).key(bArr).add(bArr2), BuilderFactory.BINARY);
    }

    public final CommandObject<Long> setnx(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETNX).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<String> setex(String str, long j, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETEX).key(str).add(Long.valueOf(j)).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<String> psetex(String str, long j, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.PSETEX).key(str).add(Long.valueOf(j)).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<Long> setnx(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETNX).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> setex(byte[] bArr, long j, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETEX).key(bArr).add(Long.valueOf(j)).add(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<String> psetex(byte[] bArr, long j, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.PSETEX).key(bArr).add(Long.valueOf(j)).add(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<Boolean> setbit(String str, long j, boolean z) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETBIT).key(str).add(Long.valueOf(j)).add(Boolean.valueOf(z)), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> setbit(byte[] bArr, long j, boolean z) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETBIT).key(bArr).add(Long.valueOf(j)).add(Boolean.valueOf(z)), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> getbit(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETBIT).key(str).add(Long.valueOf(j)), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> getbit(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETBIT).key(bArr).add(Long.valueOf(j)), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> setrange(String str, long j, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETRANGE).key(str).add(Long.valueOf(j)).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> setrange(byte[] bArr, long j, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SETRANGE).key(bArr).add(Long.valueOf(j)).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> getrange(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> getrange(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GETRANGE).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.BINARY);
    }

    public final CommandObject<List<String>> mget(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.MGET).keys(strArr), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<byte[]>> mget(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.MGET).keys(bArr), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<String> mset(String... strArr) {
        return new CommandObject<>(addFlatKeyValueArgs(commandArguments(Protocol.Command.MSET), strArr), BuilderFactory.STRING);
    }

    public final CommandObject<Long> msetnx(String... strArr) {
        return new CommandObject<>(addFlatKeyValueArgs(commandArguments(Protocol.Command.MSETNX), strArr), BuilderFactory.LONG);
    }

    public final CommandObject<String> mset(byte[]... bArr) {
        return new CommandObject<>(addFlatKeyValueArgs(commandArguments(Protocol.Command.MSET), bArr), BuilderFactory.STRING);
    }

    public final CommandObject<Long> msetnx(byte[]... bArr) {
        return new CommandObject<>(addFlatKeyValueArgs(commandArguments(Protocol.Command.MSETNX), bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> incr(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.INCR).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> incrBy(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.INCRBY).key(str).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Double> incrByFloat(String str, double d) {
        return new CommandObject<>(commandArguments(Protocol.Command.INCRBYFLOAT).key(str).add(Double.valueOf(d)), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Long> incr(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.INCR).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> incrBy(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.INCRBY).key(bArr).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Double> incrByFloat(byte[] bArr, double d) {
        return new CommandObject<>(commandArguments(Protocol.Command.INCRBYFLOAT).key(bArr).add(Double.valueOf(d)), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Long> decr(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.DECR).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> decrBy(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.DECRBY).key(str).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> decr(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.DECR).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> decrBy(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.DECRBY).key(bArr).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> append(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.APPEND).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> append(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.APPEND).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> substr(String str, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SUBSTR).key(str).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> substr(byte[] bArr, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SUBSTR).key(bArr).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY);
    }

    public final CommandObject<Long> strlen(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.STRLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> strlen(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.STRLEN).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitcount(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITCOUNT).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitcount(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITCOUNT).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitcount(String str, long j, long j2, BitCountOption bitCountOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITCOUNT).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(bitCountOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitcount(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITCOUNT).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitcount(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITCOUNT).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitcount(byte[] bArr, long j, long j2, BitCountOption bitCountOption) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITCOUNT).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(bitCountOption), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitpos(String str, boolean z) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITPOS).key(str).add(Integer.valueOf(z ? 1 : 0)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitpos(String str, boolean z, BitPosParams bitPosParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITPOS).key(str).add(Integer.valueOf(z ? 1 : 0)).addParams(bitPosParams), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitpos(byte[] bArr, boolean z) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITPOS).key(bArr).add(Integer.valueOf(z ? 1 : 0)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitpos(byte[] bArr, boolean z, BitPosParams bitPosParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITPOS).key(bArr).add(Integer.valueOf(z ? 1 : 0)).addParams(bitPosParams), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> bitfield(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITFIELD).key(str).addObjects(strArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> bitfieldReadonly(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITFIELD_RO).key(str).addObjects(strArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> bitfield(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITFIELD).key(bArr).addObjects(bArr2), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> bitfieldReadonly(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITFIELD_RO).key(bArr).addObjects(bArr2), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> bitop(BitOP bitOP, String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITOP).add(bitOP).key(str).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.BITOP).add(bitOP).key(bArr).keys(bArr2), BuilderFactory.LONG);
    }

    @Deprecated
    public final CommandObject<LCSMatchResult> strAlgoLCSKeys(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.STRALGO).add(Protocol.Keyword.LCS).add(Protocol.Keyword.KEYS).key(str).key(str2).addParams(strAlgoLCSParams), BuilderFactory.STR_ALGO_LCS_RESULT_BUILDER);
    }

    @Deprecated
    public final CommandObject<LCSMatchResult> strAlgoLCSKeys(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.STRALGO).add(Protocol.Keyword.LCS).add(Protocol.Keyword.KEYS).key(bArr).key(bArr2).addParams(strAlgoLCSParams), BuilderFactory.STR_ALGO_LCS_RESULT_BUILDER);
    }

    public final CommandObject<LCSMatchResult> lcs(String str, String str2, LCSParams lCSParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.LCS).key(str).key(str2).addParams(lCSParams), BuilderFactory.STR_ALGO_LCS_RESULT_BUILDER);
    }

    public final CommandObject<LCSMatchResult> lcs(byte[] bArr, byte[] bArr2, LCSParams lCSParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.LCS).key(bArr).key(bArr2).addParams(lCSParams), BuilderFactory.STR_ALGO_LCS_RESULT_BUILDER);
    }

    public final CommandObject<Long> rpush(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPUSH).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> rpush(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPUSH).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lpush(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPUSH).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lpush(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPUSH).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> llen(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.LLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> llen(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LLEN).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> lrange(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<byte[]>> lrange(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LRANGE).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<String> ltrim(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LTRIM).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING);
    }

    public final CommandObject<String> ltrim(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LTRIM).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING);
    }

    public final CommandObject<String> lindex(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.LINDEX).key(str).add(Long.valueOf(j)), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> lindex(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.LINDEX).key(bArr).add(Long.valueOf(j)), BuilderFactory.BINARY);
    }

    public final CommandObject<String> lset(String str, long j, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LSET).key(str).add(Long.valueOf(j)).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<String> lset(byte[] bArr, long j, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LSET).key(bArr).add(Long.valueOf(j)).add(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<Long> lrem(String str, long j, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LREM).key(str).add(Long.valueOf(j)).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lrem(byte[] bArr, long j, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LREM).key(bArr).add(Long.valueOf(j)).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> lpop(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOP).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> lpop(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOP).key(str).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<byte[]> lpop(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOP).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<List<byte[]>> lpop(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOP).key(bArr).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<String> rpop(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPOP).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> rpop(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPOP).key(str).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<byte[]> rpop(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPOP).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<List<byte[]>> rpop(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPOP).key(bArr).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Long> lpos(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOS).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lpos(String str, String str2, LPosParams lPosParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOS).key(str).add(str2).addParams(lPosParams), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> lpos(String str, String str2, LPosParams lPosParams, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOS).key(str).add(str2).addParams(lPosParams).add(Protocol.Keyword.COUNT).add(Long.valueOf(j)), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> lpos(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOS).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOS).key(bArr).add(bArr2).addParams(lPosParams), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPOS).key(bArr).add(bArr2).addParams(lPosParams).add(Protocol.Keyword.COUNT).add(Long.valueOf(j)), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> linsert(String str, ListPosition listPosition, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.LINSERT).key(str).add(listPosition).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> linsert(byte[] bArr, ListPosition listPosition, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.LINSERT).key(bArr).add(listPosition).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lpushx(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPUSHX).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> rpushx(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPUSHX).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> lpushx(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LPUSHX).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> rpushx(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPUSHX).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> blpop(int i, String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLPOP).blocking().key(str).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> blpop(int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLPOP).blocking().keys(strArr).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<KeyedListElement> blpop(double d, String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLPOP).blocking().key(str).add(Double.valueOf(d)), BuilderFactory.KEYED_LIST_ELEMENT);
    }

    public final CommandObject<KeyedListElement> blpop(double d, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLPOP).blocking().keys(strArr).add(Double.valueOf(d)), BuilderFactory.KEYED_LIST_ELEMENT);
    }

    public final CommandObject<List<byte[]>> blpop(int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLPOP).blocking().keys(bArr).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> blpop(double d, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLPOP).blocking().keys(bArr).add(Double.valueOf(d)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<String>> brpop(int i, String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOP).blocking().key(str).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> brpop(int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOP).blocking().keys(strArr).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<KeyedListElement> brpop(double d, String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOP).blocking().key(str).add(Double.valueOf(d)), BuilderFactory.KEYED_LIST_ELEMENT);
    }

    public final CommandObject<KeyedListElement> brpop(double d, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOP).blocking().keys(strArr).add(Double.valueOf(d)), BuilderFactory.KEYED_LIST_ELEMENT);
    }

    public final CommandObject<List<byte[]>> brpop(int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOP).blocking().keys(bArr).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> brpop(double d, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOP).blocking().keys(bArr).add(Double.valueOf(d)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<String> rpoplpush(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPOPLPUSH).key(str).key(str2), BuilderFactory.STRING);
    }

    public final CommandObject<String> brpoplpush(String str, String str2, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOPLPUSH).blocking().key(str).key(str2).add(Integer.valueOf(i)), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> rpoplpush(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.RPOPLPUSH).key(bArr).key(bArr2), BuilderFactory.BINARY);
    }

    public final CommandObject<byte[]> brpoplpush(byte[] bArr, byte[] bArr2, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.BRPOPLPUSH).blocking().key(bArr).key(bArr2).add(Integer.valueOf(i)), BuilderFactory.BINARY);
    }

    public final CommandObject<String> lmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LMOVE).key(str).key(str2).add(listDirection).add(listDirection2), BuilderFactory.STRING);
    }

    public final CommandObject<String> blmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2, double d) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLMOVE).blocking().key(str).key(str2).add(listDirection).add(listDirection2).add(Double.valueOf(d)), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> lmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2) {
        return new CommandObject<>(commandArguments(Protocol.Command.LMOVE).key(bArr).key(bArr2).add(listDirection).add(listDirection2), BuilderFactory.BINARY);
    }

    public final CommandObject<byte[]> blmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2, double d) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLMOVE).blocking().key(bArr).key(bArr2).add(listDirection).add(listDirection2).add(Double.valueOf(d)), BuilderFactory.BINARY);
    }

    public final CommandObject<KeyValue<String, List<String>>> lmpop(ListDirection listDirection, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LMPOP).add(Integer.valueOf(strArr.length)).keys(strArr).add(listDirection), BuilderFactory.KEYED_STRING_LIST);
    }

    public final CommandObject<KeyValue<String, List<String>>> lmpop(ListDirection listDirection, int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LMPOP).add(Integer.valueOf(strArr.length)).keys(strArr).add(listDirection).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.KEYED_STRING_LIST);
    }

    public final CommandObject<KeyValue<String, List<String>>> blmpop(long j, ListDirection listDirection, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(strArr.length)).keys(strArr).add(listDirection), BuilderFactory.KEYED_STRING_LIST);
    }

    public final CommandObject<KeyValue<String, List<String>>> blmpop(long j, ListDirection listDirection, int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(strArr.length)).keys(strArr).add(listDirection).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.KEYED_STRING_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection listDirection, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LMPOP).add(Integer.valueOf(bArr.length)).keys(bArr).add(listDirection), BuilderFactory.KEYED_BINARY_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection listDirection, int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.LMPOP).add(Integer.valueOf(bArr.length)).keys(bArr).add(listDirection).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.KEYED_BINARY_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<byte[]>>> blmpop(long j, ListDirection listDirection, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(bArr.length)).keys(bArr).add(listDirection), BuilderFactory.KEYED_BINARY_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<byte[]>>> blmpop(long j, ListDirection listDirection, int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BLMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(bArr.length)).keys(bArr).add(listDirection).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.KEYED_BINARY_LIST);
    }

    public final CommandObject<Long> hset(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSET).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> hset(String str, Map<String, String> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.HSET).key(str), map), BuilderFactory.LONG);
    }

    public final CommandObject<String> hget(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HGET).key(str).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<Long> hsetnx(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSETNX).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<String> hmset(String str, Map<String, String> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.HMSET).key(str), map), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> hmget(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HMGET).key(str).addObjects(strArr), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<Long> hset(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSET).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> hset(byte[] bArr, Map<byte[], byte[]> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.HSET).key(bArr), map), BuilderFactory.LONG);
    }

    public final CommandObject<byte[]> hget(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HGET).key(bArr).add(bArr2), BuilderFactory.BINARY);
    }

    public final CommandObject<Long> hsetnx(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSETNX).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<String> hmset(byte[] bArr, Map<byte[], byte[]> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.HMSET).key(bArr), map), BuilderFactory.STRING);
    }

    public final CommandObject<List<byte[]>> hmget(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HMGET).key(bArr).addObjects(bArr2), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Long> hincrBy(String str, String str2, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.HINCRBY).key(str).add(str2).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Double> hincrByFloat(String str, String str2, double d) {
        return new CommandObject<>(commandArguments(Protocol.Command.HINCRBYFLOAT).key(str).add(str2).add(Double.valueOf(d)), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Boolean> hexists(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HEXISTS).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> hdel(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HDEL).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> hlen(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.HLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> hincrBy(byte[] bArr, byte[] bArr2, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.HINCRBY).key(bArr).add(bArr2).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Double> hincrByFloat(byte[] bArr, byte[] bArr2, double d) {
        return new CommandObject<>(commandArguments(Protocol.Command.HINCRBYFLOAT).key(bArr).add(bArr2).add(Double.valueOf(d)), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Boolean> hexists(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HEXISTS).key(bArr).add(bArr2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> hdel(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HDEL).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> hlen(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HLEN).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> hkeys(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.HKEYS).key(str), BuilderFactory.STRING_SET);
    }

    public final CommandObject<List<String>> hvals(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.HVALS).key(str), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<Set<byte[]>> hkeys(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HKEYS).key(bArr), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<List<byte[]>> hvals(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HVALS).key(bArr), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Map<String, String>> hgetAll(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.HGETALL).key(str), BuilderFactory.STRING_MAP);
    }

    public final CommandObject<String> hrandfield(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.HRANDFIELD).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> hrandfield(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.HRANDFIELD).key(str).add(Long.valueOf(j)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<Map<String, String>> hrandfieldWithValues(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.HRANDFIELD).key(str).add(Long.valueOf(j)).add(Protocol.Keyword.WITHVALUES), BuilderFactory.STRING_MAP);
    }

    public final CommandObject<Map<byte[], byte[]>> hgetAll(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HGETALL).key(bArr), BuilderFactory.BINARY_MAP);
    }

    public final CommandObject<byte[]> hrandfield(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.HRANDFIELD).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<List<byte[]>> hrandfield(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.HRANDFIELD).key(bArr).add(Long.valueOf(j)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Map<byte[], byte[]>> hrandfieldWithValues(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.HRANDFIELD).key(bArr).add(Long.valueOf(j)).add(Protocol.Keyword.WITHVALUES), BuilderFactory.BINARY_MAP);
    }

    public final CommandObject<ScanResult<Map.Entry<String, String>>> hscan(String str, String str2, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSCAN).key(str).add(str2).addParams(scanParams), BuilderFactory.HSCAN_RESPONSE);
    }

    public final CommandObject<Long> hstrlen(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSTRLEN).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<ScanResult<Map.Entry<byte[], byte[]>>> hscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSCAN).key(bArr).add(bArr2).addParams(scanParams), BuilderFactory.HSCAN_BINARY_RESPONSE);
    }

    public final CommandObject<Long> hstrlen(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.HSTRLEN).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sadd(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SADD).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sadd(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SADD).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> smembers(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SMEMBERS).key(str), BuilderFactory.STRING_SET);
    }

    public final CommandObject<Set<byte[]>> smembers(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SMEMBERS).key(bArr), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Long> srem(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SREM).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> srem(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SREM).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> spop(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SPOP).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> spop(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SPOP).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<Set<String>> spop(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.SPOP).key(str).add(Long.valueOf(j)), BuilderFactory.STRING_SET);
    }

    public final CommandObject<Set<byte[]>> spop(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.SPOP).key(bArr).add(Long.valueOf(j)), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Long> scard(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCARD).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> scard(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCARD).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Boolean> sismember(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SISMEMBER).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> sismember(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SISMEMBER).key(bArr).add(bArr2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<List<Boolean>> smismember(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SMISMEMBER).key(str).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<List<Boolean>> smismember(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SMISMEMBER).key(bArr).addObjects(bArr2), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<String> srandmember(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SRANDMEMBER).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> srandmember(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SRANDMEMBER).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<List<String>> srandmember(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.SRANDMEMBER).key(str).add(Integer.valueOf(i)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<byte[]>> srandmember(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.SRANDMEMBER).key(bArr).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<ScanResult<String>> sscan(String str, String str2, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SSCAN).key(str).add(str2).addParams(scanParams), BuilderFactory.SSCAN_RESPONSE);
    }

    public final CommandObject<ScanResult<byte[]>> sscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.SSCAN).key(bArr).add(bArr2).addParams(scanParams), BuilderFactory.SSCAN_BINARY_RESPONSE);
    }

    public final CommandObject<Set<String>> sdiff(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SDIFF).keys(strArr), BuilderFactory.STRING_SET);
    }

    public final CommandObject<Long> sdiffstore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SDIFFSTORE).key(str).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Set<byte[]>> sdiff(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SDIFF).keys(bArr), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Long> sdiffstore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SDIFFSTORE).key(bArr).keys(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> sinter(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTER).keys(strArr), BuilderFactory.STRING_SET);
    }

    public final CommandObject<Long> sinterstore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTERSTORE).key(str).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sintercard(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTERCARD).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sintercard(int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTERCARD).add(Integer.valueOf(strArr.length)).keys(strArr).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)), BuilderFactory.LONG);
    }

    public final CommandObject<Set<byte[]>> sinter(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTER).keys(bArr), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Long> sinterstore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTERSTORE).key(bArr).keys(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sintercard(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTERCARD).add(Integer.valueOf(bArr.length)).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> sintercard(int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SINTERCARD).add(Integer.valueOf(bArr.length)).keys(bArr).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> sunion(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SUNION).keys(strArr), BuilderFactory.STRING_SET);
    }

    public final CommandObject<Long> sunionstore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SUNIONSTORE).key(str).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Set<byte[]>> sunion(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SUNION).keys(bArr), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Long> sunionstore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SUNIONSTORE).key(bArr).keys(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> smove(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.SMOVE).key(str).key(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> smove(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.SMOVE).key(bArr).key(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(String str, double d, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(str).add(Double.valueOf(d)).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(String str, double d, String str2, ZAddParams zAddParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(str).addParams(zAddParams).add(Double.valueOf(d)).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(String str, Map<String, Double> map) {
        return new CommandObject<>(addSortedSetFlatMapArgs(commandArguments(Protocol.Command.ZADD).key(str), map), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(String str, Map<String, Double> map, ZAddParams zAddParams) {
        return new CommandObject<>(addSortedSetFlatMapArgs(commandArguments(Protocol.Command.ZADD).key(str).addParams(zAddParams), map), BuilderFactory.LONG);
    }

    public final CommandObject<Double> zaddIncr(String str, double d, String str2, ZAddParams zAddParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(str).add(Protocol.Keyword.INCR).addParams(zAddParams).add(Double.valueOf(d)).add(str2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Long> zadd(byte[] bArr, double d, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(bArr).add(Double.valueOf(d)).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(bArr).addParams(zAddParams).add(Double.valueOf(d)).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(byte[] bArr, Map<byte[], Double> map) {
        return new CommandObject<>(addSortedSetFlatMapArgs(commandArguments(Protocol.Command.ZADD).key(bArr), map), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zadd(byte[] bArr, Map<byte[], Double> map, ZAddParams zAddParams) {
        return new CommandObject<>(addSortedSetFlatMapArgs(commandArguments(Protocol.Command.ZADD).key(bArr).addParams(zAddParams), map), BuilderFactory.LONG);
    }

    public final CommandObject<Double> zaddIncr(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(bArr).add(Protocol.Keyword.INCR).addParams(zAddParams).add(Double.valueOf(d)).add(bArr2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> zincrby(String str, double d, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINCRBY).key(str).add(Double.valueOf(d)).add(str2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(str).addParams(zIncrByParams).add(Double.valueOf(d)).add(str2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> zincrby(byte[] bArr, double d, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINCRBY).key(bArr).add(Double.valueOf(d)).add(bArr2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> zincrby(byte[] bArr, double d, byte[] bArr2, ZIncrByParams zIncrByParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZADD).key(bArr).addParams(zIncrByParams).add(Double.valueOf(d)).add(bArr2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Long> zrem(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREM).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zrem(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREM).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zrank(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANK).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zrevrank(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANK).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zrank(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANK).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zrevrank(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANK).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> zrandmember(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANDMEMBER).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> zrandmember(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANDMEMBER).key(str).add(Long.valueOf(j)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<Tuple>> zrandmemberWithScores(String str, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANDMEMBER).key(str).add(Long.valueOf(j)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<byte[]> zrandmember(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANDMEMBER).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<List<byte[]>> zrandmember(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANDMEMBER).key(bArr).add(Long.valueOf(j)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<Tuple>> zrandmemberWithScores(byte[] bArr, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANDMEMBER).key(bArr).add(Long.valueOf(j)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Long> zcard(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZCARD).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Double> zscore(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZSCORE).key(str).add(str2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<List<Double>> zmscore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZMSCORE).key(str).addObjects(strArr), BuilderFactory.DOUBLE_LIST);
    }

    public final CommandObject<Long> zcard(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZCARD).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Double> zscore(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZSCORE).key(bArr).add(bArr2), BuilderFactory.DOUBLE);
    }

    public final CommandObject<List<Double>> zmscore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZMSCORE).key(bArr).addObjects(bArr2), BuilderFactory.DOUBLE_LIST);
    }

    public final CommandObject<Tuple> zpopmax(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMAX).key(str), BuilderFactory.TUPLE);
    }

    public final CommandObject<List<Tuple>> zpopmax(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMAX).key(str).add(Integer.valueOf(i)), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Tuple> zpopmin(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMIN).key(str), BuilderFactory.TUPLE);
    }

    public final CommandObject<List<Tuple>> zpopmin(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMIN).key(str).add(Integer.valueOf(i)), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Tuple> zpopmax(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMAX).key(bArr), BuilderFactory.TUPLE);
    }

    public final CommandObject<List<Tuple>> zpopmax(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMAX).key(bArr).add(Integer.valueOf(i)), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Tuple> zpopmin(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMIN).key(bArr), BuilderFactory.TUPLE);
    }

    public final CommandObject<List<Tuple>> zpopmin(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZPOPMIN).key(bArr).add(Integer.valueOf(i)), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<KeyedZSetElement> bzpopmax(double d, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZPOPMAX).blocking().keys(strArr).add(Double.valueOf(d)), BuilderFactory.KEYED_ZSET_ELEMENT);
    }

    public final CommandObject<KeyedZSetElement> bzpopmin(double d, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZPOPMIN).blocking().keys(strArr).add(Double.valueOf(d)), BuilderFactory.KEYED_ZSET_ELEMENT);
    }

    public final CommandObject<List<byte[]>> bzpopmax(double d, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZPOPMAX).blocking().keys(bArr).add(Double.valueOf(d)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> bzpopmin(double d, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZPOPMIN).blocking().keys(bArr).add(Double.valueOf(d)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Long> zcount(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZCOUNT).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zcount(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZCOUNT).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zcount(byte[] bArr, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZCOUNT).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZCOUNT).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> zrange(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrange(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeWithScores(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeWithScores(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<String>> zrange(String str, ZRangeParams zRangeParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(str).addParams(zRangeParams), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeWithScores(String str, ZRangeParams zRangeParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(str).addParams(zRangeParams).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Long> zrangestore(String str, String str2, ZRangeParams zRangeParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGESTORE).key(str).add(str2).addParams(zRangeParams), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> zrangeByScore(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrangeByScore(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(str2).add(str3), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrangeByScore(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrangeByScore(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(str2).add(str3), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrangeByScore(String str, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrangeByScore(String str, String str2, String str3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(str2).add(str3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrangeByScore(String str, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrangeByScore(String str, String str2, String str3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(str2).add(str3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(str2).add(str3).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(str2).add(str3).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(str).add(str2).add(str3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(str).add(str2).add(str3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<byte[]>> zrange(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrange(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGE).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeWithScores(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeWithScores(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGE).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<byte[]>> zrange(byte[] bArr, ZRangeParams zRangeParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(bArr).addParams(zRangeParams), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeWithScores(byte[] bArr, ZRangeParams zRangeParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGE).key(bArr).addParams(zRangeParams).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Long> zrangestore(byte[] bArr, byte[] bArr2, ZRangeParams zRangeParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGESTORE).key(bArr).add(bArr2).addParams(zRangeParams), BuilderFactory.LONG);
    }

    public final CommandObject<List<byte[]>> zrangeByScore(byte[] bArr, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrangeByScore(byte[] bArr, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Long> zremrangeByRank(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYRANK).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zremrangeByScore(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYSCORE).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zremrangeByScore(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYSCORE).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zremrangeByRank(byte[] bArr, long j, long j2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYRANK).key(bArr).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zremrangeByScore(byte[] bArr, double d, double d2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYSCORE).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zremrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYSCORE).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zlexcount(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZLEXCOUNT).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> zrangeByLex(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYLEX).key(str).add(str2).add(str3), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrangeByLex(String str, String str2, String str3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYLEX).key(str).add(str2).add(str3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrangeByLex(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYLEX).key(str).add(str2).add(str3), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> zrevrangeByLex(String str, String str2, String str3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYLEX).key(str).add(str2).add(str3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<Long> zremrangeByLex(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYLEX).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zlexcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZLEXCOUNT).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<List<byte[]>> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYLEX).key(bArr).add(bArr2).add(bArr3), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZRANGEBYLEX).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYLEX).key(bArr).add(bArr2).add(bArr3), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREVRANGEBYLEX).key(bArr).add(bArr2).add(bArr3).add(Protocol.Keyword.LIMIT).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Long> zremrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZREMRANGEBYLEX).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<ScanResult<Tuple>> zscan(String str, String str2, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZSCAN).key(str).add(str2).addParams(scanParams), BuilderFactory.ZSCAN_RESPONSE);
    }

    public final CommandObject<ScanResult<Tuple>> zscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZSCAN).key(bArr).add(bArr2).addParams(scanParams), BuilderFactory.ZSCAN_RESPONSE);
    }

    public final CommandObject<Set<String>> zdiff(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZDIFF).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.STRING_ORDERED_SET);
    }

    public final CommandObject<Set<Tuple>> zdiffWithScores(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZDIFF).add(Integer.valueOf(strArr.length)).keys(strArr).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_ZSET);
    }

    public final CommandObject<Long> zdiffStore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZDIFFSTORE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Set<byte[]>> zdiff(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZDIFF).add(Integer.valueOf(bArr.length)).keys(bArr), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Set<Tuple>> zdiffWithScores(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZDIFF).add(Integer.valueOf(bArr.length)).keys(bArr).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_ZSET);
    }

    public final CommandObject<Long> zdiffStore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZDIFFSTORE).key(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zinterstore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERSTORE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zinterstore(String str, ZParams zParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERSTORE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(zParams), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> zinter(ZParams zParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTER).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(zParams), BuilderFactory.STRING_ORDERED_SET);
    }

    public final CommandObject<Set<Tuple>> zinterWithScores(ZParams zParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTER).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(zParams).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_ZSET);
    }

    public final CommandObject<Long> zintercard(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERCARD).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zintercard(long j, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERCARD).add(Integer.valueOf(strArr.length)).keys(strArr).add(Protocol.Keyword.LIMIT).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zinterstore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERSTORE).key(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERSTORE).key(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addParams(zParams), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zintercard(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERCARD).add(Integer.valueOf(bArr.length)).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zintercard(long j, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTERCARD).add(Integer.valueOf(bArr.length)).keys(bArr).add(Protocol.Keyword.LIMIT).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Set<byte[]>> zinter(ZParams zParams, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTER).add(Integer.valueOf(bArr.length)).keys(bArr).addParams(zParams), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Set<Tuple>> zinterWithScores(ZParams zParams, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZINTER).add(Integer.valueOf(bArr.length)).keys(bArr).addParams(zParams).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_ZSET);
    }

    public final CommandObject<Long> zunionstore(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNIONSTORE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zunionstore(String str, ZParams zParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNIONSTORE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(zParams), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> zunion(ZParams zParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNION).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(zParams), BuilderFactory.STRING_ORDERED_SET);
    }

    public final CommandObject<Set<Tuple>> zunionWithScores(ZParams zParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNION).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(zParams).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_ZSET);
    }

    public final CommandObject<Long> zunionstore(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNIONSTORE).key(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNIONSTORE).key(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addParams(zParams), BuilderFactory.LONG);
    }

    public final CommandObject<Set<byte[]>> zunion(ZParams zParams, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNION).add(Integer.valueOf(bArr.length)).keys(bArr).addParams(zParams), BuilderFactory.BINARY_SET);
    }

    public final CommandObject<Set<Tuple>> zunionWithScores(ZParams zParams, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZUNION).add(Integer.valueOf(bArr.length)).keys(bArr).addParams(zParams).add(Protocol.Keyword.WITHSCORES), BuilderFactory.TUPLE_ZSET);
    }

    public final CommandObject<KeyValue<String, List<Tuple>>> zmpop(SortedSetOption sortedSetOption, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZMPOP).add(Integer.valueOf(strArr.length)).keys(strArr).add(sortedSetOption), BuilderFactory.KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<String, List<Tuple>>> zmpop(SortedSetOption sortedSetOption, int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZMPOP).add(Integer.valueOf(strArr.length)).keys(strArr).add(sortedSetOption).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<String, List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(strArr.length)).keys(strArr).add(sortedSetOption), BuilderFactory.KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<String, List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(strArr.length)).keys(strArr).add(sortedSetOption).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<Tuple>>> zmpop(SortedSetOption sortedSetOption, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZMPOP).add(Integer.valueOf(bArr.length)).keys(bArr).add(sortedSetOption), BuilderFactory.BINARY_KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<Tuple>>> zmpop(SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.ZMPOP).add(Integer.valueOf(bArr.length)).keys(bArr).add(sortedSetOption).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.BINARY_KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(bArr.length)).keys(bArr).add(sortedSetOption), BuilderFactory.BINARY_KEYED_TUPLE_LIST);
    }

    public final CommandObject<KeyValue<byte[], List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.BZMPOP).blocking().add(Long.valueOf(j)).add(Integer.valueOf(bArr.length)).keys(bArr).add(sortedSetOption).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.BINARY_KEYED_TUPLE_LIST);
    }

    public final CommandObject<Long> geoadd(String str, double d, double d2, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOADD).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geoadd(String str, Map<String, GeoCoordinate> map) {
        return new CommandObject<>(addGeoCoordinateFlatMapArgs(commandArguments(Protocol.Command.GEOADD).key(str), map), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geoadd(String str, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map) {
        return new CommandObject<>(addGeoCoordinateFlatMapArgs(commandArguments(Protocol.Command.GEOADD).key(str).addParams(geoAddParams), map), BuilderFactory.LONG);
    }

    public final CommandObject<Double> geodist(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEODIST).key(str).add(str2).add(str3), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> geodist(String str, String str2, String str3, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEODIST).key(str).add(str2).add(str3).add(geoUnit), BuilderFactory.DOUBLE);
    }

    public final CommandObject<List<String>> geohash(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOHASH).key(str).addObjects(strArr), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<GeoCoordinate>> geopos(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOPOS).key(str).addObjects(strArr), BuilderFactory.GEO_COORDINATE_LIST);
    }

    public final CommandObject<Long> geoadd(byte[] bArr, double d, double d2, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOADD).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geoadd(byte[] bArr, Map<byte[], GeoCoordinate> map) {
        return new CommandObject<>(addGeoCoordinateFlatMapArgs(commandArguments(Protocol.Command.GEOADD).key(bArr), map), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geoadd(byte[] bArr, GeoAddParams geoAddParams, Map<byte[], GeoCoordinate> map) {
        return new CommandObject<>(addGeoCoordinateFlatMapArgs(commandArguments(Protocol.Command.GEOADD).key(bArr).addParams(geoAddParams), map), BuilderFactory.LONG);
    }

    public final CommandObject<Double> geodist(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEODIST).key(bArr).add(bArr2).add(bArr3), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> geodist(byte[] bArr, byte[] bArr2, byte[] bArr3, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEODIST).key(bArr).add(bArr2).add(bArr3).add(geoUnit), BuilderFactory.DOUBLE);
    }

    public final CommandObject<List<byte[]>> geohash(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOHASH).key(bArr).addObjects(bArr2), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<GeoCoordinate>> geopos(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOPOS).key(bArr).addObjects(bArr2), BuilderFactory.GEO_COORDINATE_LIST);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS_RO).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS_RO).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<Long> georadiusStore(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit).addParams(geoRadiusParam).addParams(geoRadiusStoreParam), BuilderFactory.LONG);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER).key(str).add(str2).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER).key(str).add(str2).add(Double.valueOf(d)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER_RO).key(str).add(str2).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER_RO).key(str).add(str2).add(Double.valueOf(d)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<Long> georadiusByMemberStore(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER).key(str).add(str2).add(Double.valueOf(d)).add(geoUnit).addParams(geoRadiusParam).addParams(geoRadiusStoreParam), BuilderFactory.LONG);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS_RO).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS_RO).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<Long> georadiusStore(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUS).key(bArr).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(Double.valueOf(d3)).add(geoUnit).addParams(geoRadiusParam).addParams(geoRadiusStoreParam), BuilderFactory.LONG);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER).key(bArr).add(bArr2).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER).key(bArr).add(bArr2).add(Double.valueOf(d)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER_RO).key(bArr).add(bArr2).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER_RO).key(bArr).add(bArr2).add(Double.valueOf(d)).add(geoUnit).addParams(geoRadiusParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<Long> georadiusByMemberStore(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEORADIUSBYMEMBER).key(bArr).add(bArr2).add(Double.valueOf(d)).add(geoUnit).addParams(geoRadiusParam).addParams(geoRadiusStoreParam), BuilderFactory.LONG);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(String str, String str2, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(str).add(Protocol.Keyword.FROMMEMBER).add(str2).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(String str, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(str).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(String str, String str2, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(str).add(Protocol.Keyword.FROMMEMBER).add(str2).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(String str, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(str).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(String str, GeoSearchParam geoSearchParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(str).addParams(geoSearchParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<Long> geosearchStore(String str, String str2, String str3, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(str).add(str2).add(Protocol.Keyword.FROMMEMBER).add(str3).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(str).add(str2).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(String str, String str2, String str3, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(str).add(str2).add(Protocol.Keyword.FROMMEMBER).add(str3).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(str).add(str2).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(String str, String str2, GeoSearchParam geoSearchParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(str).add(str2).addParams(geoSearchParam), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStoreStoreDist(String str, String str2, GeoSearchParam geoSearchParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(str).add(str2).addParams(geoSearchParam).add(Protocol.Keyword.STOREDIST), BuilderFactory.LONG);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(bArr).add(Protocol.Keyword.FROMMEMBER).add(bArr2).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(bArr).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(byte[] bArr, byte[] bArr2, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(bArr).add(Protocol.Keyword.FROMMEMBER).add(bArr2).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(bArr).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoSearchParam geoSearchParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCH).key(bArr).addParams(geoSearchParam), BuilderFactory.GEORADIUS_WITH_PARAMS_RESULT);
    }

    public final CommandObject<Long> geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(bArr).add(bArr2).add(Protocol.Keyword.FROMMEMBER).add(bArr3).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(bArr).add(bArr2).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYRADIUS).add(Double.valueOf(d)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(bArr).add(bArr2).add(Protocol.Keyword.FROMMEMBER).add(bArr3).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(bArr).add(bArr2).add(Protocol.Keyword.FROMLONLAT).add(Double.valueOf(geoCoordinate.getLongitude())).add(Double.valueOf(geoCoordinate.getLatitude())).add(Protocol.Keyword.BYBOX).add(Double.valueOf(d)).add(Double.valueOf(d2)).add(geoUnit), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(bArr).add(bArr2).addParams(geoSearchParam), BuilderFactory.LONG);
    }

    public final CommandObject<Long> geosearchStoreStoreDist(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        return new CommandObject<>(commandArguments(Protocol.Command.GEOSEARCHSTORE).key(bArr).add(bArr2).addParams(geoSearchParam).add(Protocol.Keyword.STOREDIST), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pfadd(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFADD).key(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<String> pfmerge(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFMERGE).key(str).keys(strArr), BuilderFactory.STRING);
    }

    public final CommandObject<Long> pfadd(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFADD).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<String> pfmerge(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFMERGE).key(bArr).keys(bArr2), BuilderFactory.STRING);
    }

    public final CommandObject<Long> pfcount(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFCOUNT).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pfcount(String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFCOUNT).keys(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pfcount(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFCOUNT).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> pfcount(byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.PFCOUNT).keys(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<StreamEntryID> xadd(String str, StreamEntryID streamEntryID, Map<String, String> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.XADD).key(str).add(streamEntryID == null ? StreamEntryID.NEW_ENTRY : streamEntryID), map), BuilderFactory.STREAM_ENTRY_ID);
    }

    public final CommandObject<StreamEntryID> xadd(String str, XAddParams xAddParams, Map<String, String> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.XADD).key(str).addParams(xAddParams), map), BuilderFactory.STREAM_ENTRY_ID);
    }

    public final CommandObject<Long> xlen(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.XLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<byte[]> xadd(byte[] bArr, XAddParams xAddParams, Map<byte[], byte[]> map) {
        return new CommandObject<>(addFlatMapArgs(commandArguments(Protocol.Command.XADD).key(bArr).addParams(xAddParams), map), BuilderFactory.BINARY);
    }

    public final CommandObject<Long> xlen(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XLEN).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<List<StreamEntry>> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XRANGE).key(str).add(streamEntryID == null ? "-" : streamEntryID).add(streamEntryID2 == null ? Marker.ANY_NON_NULL_MARKER : streamEntryID2), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XRANGE).key(str).add(streamEntryID == null ? "-" : streamEntryID).add(streamEntryID2 == null ? Marker.ANY_NON_NULL_MARKER : streamEntryID2).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XREVRANGE).key(str).add(streamEntryID == null ? Marker.ANY_NON_NULL_MARKER : streamEntryID).add(streamEntryID2 == null ? "-" : streamEntryID2), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XREVRANGE).key(str).add(streamEntryID == null ? Marker.ANY_NON_NULL_MARKER : streamEntryID).add(streamEntryID2 == null ? "-" : streamEntryID2).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrange(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XRANGE).key(str).add(str2).add(str3), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrange(String str, String str2, String str3, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XRANGE).key(str).add(str2).add(str3).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrevrange(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XREVRANGE).key(str).add(str2).add(str3), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntry>> xrevrange(String str, String str2, String str3, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XREVRANGE).key(str).add(str2).add(str3).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<byte[]>> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XRANGE).key(bArr).add(bArr2 == null ? "-" : bArr2).add(bArr3 == null ? Marker.ANY_NON_NULL_MARKER : bArr3), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XRANGE).key(bArr).add(bArr2 == null ? "-" : bArr2).add(bArr3 == null ? Marker.ANY_NON_NULL_MARKER : bArr3).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XREVRANGE).key(bArr).add(bArr2 == null ? Marker.ANY_NON_NULL_MARKER : bArr2).add(bArr3 == null ? "-" : bArr3), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XREVRANGE).key(bArr).add(bArr2 == null ? Marker.ANY_NON_NULL_MARKER : bArr2).add(bArr3 == null ? "-" : bArr3).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Long> xack(String str, String str2, StreamEntryID... streamEntryIDArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XACK).key(str).add(str2).addObjects(streamEntryIDArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> xack(byte[] bArr, byte[] bArr2, byte[]... bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XACK).key(bArr).add(bArr2).addObjects(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<String> xgroupCreate(String str, String str2, StreamEntryID streamEntryID, boolean z) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.CREATE).key(str).add(str2).add(streamEntryID == null ? "0-0" : streamEntryID);
        if (z) {
            commandArgumentsAdd.add(Protocol.Keyword.MKSTREAM);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING);
    }

    public final CommandObject<String> xgroupSetID(String str, String str2, StreamEntryID streamEntryID) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.SETID).key(str).add(str2).add(streamEntryID), BuilderFactory.STRING);
    }

    public final CommandObject<Long> xgroupDestroy(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.DESTROY).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Boolean> xgroupCreateConsumer(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.CREATECONSUMER).key(str).add(str2).add(str3), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> xgroupDelConsumer(String str, String str2, String str3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.DELCONSUMER).key(str).add(str2).add(str3), BuilderFactory.LONG);
    }

    public final CommandObject<String> xgroupCreate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.CREATE).key(bArr).add(bArr2).add(bArr3);
        if (z) {
            commandArgumentsAdd.add(Protocol.Keyword.MKSTREAM);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING);
    }

    public final CommandObject<String> xgroupSetID(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.SETID).key(bArr).add(bArr2).add(bArr3), BuilderFactory.STRING);
    }

    public final CommandObject<Long> xgroupDestroy(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.DESTROY).key(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Boolean> xgroupCreateConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.CREATECONSUMER).key(bArr).add(bArr2).add(bArr3), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> xgroupDelConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new CommandObject<>(commandArguments(Protocol.Command.XGROUP).add(Protocol.Keyword.DELCONSUMER).key(bArr).add(bArr2).add(bArr3), BuilderFactory.LONG);
    }

    public final CommandObject<Long> xdel(String str, StreamEntryID... streamEntryIDArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XDEL).key(str).addObjects(streamEntryIDArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> xtrim(String str, long j, boolean z) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XTRIM).key(str).add(Protocol.Keyword.MAXLEN);
        if (z) {
            commandArgumentsAdd.add(Protocol.BYTES_TILDE);
        }
        commandArgumentsAdd.add(Long.valueOf(j));
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG);
    }

    public final CommandObject<Long> xtrim(String str, XTrimParams xTrimParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XTRIM).key(str).addParams(xTrimParams), BuilderFactory.LONG);
    }

    public final CommandObject<Long> xdel(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XDEL).key(bArr).addObjects(bArr2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> xtrim(byte[] bArr, long j, boolean z) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XTRIM).key(bArr).add(Protocol.Keyword.MAXLEN);
        if (z) {
            commandArgumentsAdd.add(Protocol.BYTES_TILDE);
        }
        commandArgumentsAdd.add(Long.valueOf(j));
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG);
    }

    public final CommandObject<Long> xtrim(byte[] bArr, XTrimParams xTrimParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XTRIM).key(bArr).addParams(xTrimParams), BuilderFactory.LONG);
    }

    public final CommandObject<StreamPendingSummary> xpending(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XPENDING).key(str).add(str2), BuilderFactory.STREAM_PENDING_SUMMARY);
    }

    @Deprecated
    public final CommandObject<List<StreamPendingEntry>> xpending(String str, String str2, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i, String str3) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XPENDING).key(str).add(str2).add(streamEntryID == null ? "-" : streamEntryID).add(streamEntryID2 == null ? Marker.ANY_NON_NULL_MARKER : streamEntryID2).add(Integer.valueOf(i));
        if (str3 != null) {
            commandArgumentsAdd.add(str3);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STREAM_PENDING_ENTRY_LIST);
    }

    public final CommandObject<List<StreamPendingEntry>> xpending(String str, String str2, XPendingParams xPendingParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XPENDING).key(str).add(str2).addParams(xPendingParams), BuilderFactory.STREAM_PENDING_ENTRY_LIST);
    }

    public final CommandObject<Object> xpending(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XPENDING).key(bArr).add(bArr2), BuilderFactory.RAW_OBJECT);
    }

    @Deprecated
    public final CommandObject<List<Object>> xpending(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XPENDING).key(bArr).add(bArr2).add(bArr3 == null ? "-" : bArr3).add(bArr4 == null ? Marker.ANY_NON_NULL_MARKER : bArr4).add(Integer.valueOf(i));
        if (bArr5 != null) {
            commandArgumentsAdd.add(bArr5);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> xpending(byte[] bArr, byte[] bArr2, XPendingParams xPendingParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XPENDING).key(bArr).add(bArr2).addParams(xPendingParams), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<StreamEntry>> xclaim(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XCLAIM).key(str).add(str2).add(str3).add(Long.valueOf(j)).addObjects(streamEntryIDArr).addParams(xClaimParams), BuilderFactory.STREAM_ENTRY_LIST);
    }

    public final CommandObject<List<StreamEntryID>> xclaimJustId(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XCLAIM).key(str).add(str2).add(str3).add(Long.valueOf(j)).addObjects(streamEntryIDArr).addParams(xClaimParams).add(Protocol.Keyword.JUSTID), BuilderFactory.STREAM_ENTRY_ID_LIST);
    }

    public final CommandObject<Map.Entry<StreamEntryID, List<StreamEntry>>> xautoclaim(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XAUTOCLAIM).key(str).add(str2).add(str3).add(Long.valueOf(j)).add(streamEntryID).addParams(xAutoClaimParams), BuilderFactory.STREAM_AUTO_CLAIM_RESPONSE);
    }

    public final CommandObject<Map.Entry<StreamEntryID, List<StreamEntryID>>> xautoclaimJustId(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XAUTOCLAIM).key(str).add(str2).add(str3).add(Long.valueOf(j)).add(streamEntryID).addParams(xAutoClaimParams).add(Protocol.Keyword.JUSTID), BuilderFactory.STREAM_AUTO_CLAIM_ID_RESPONSE);
    }

    public final CommandObject<List<byte[]>> xclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        return new CommandObject<>(commandArguments(Protocol.Command.XCLAIM).key(bArr).add(bArr2).add(bArr3).add(Long.valueOf(j)).addObjects(bArr4).addParams(xClaimParams), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> xclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        return new CommandObject<>(commandArguments(Protocol.Command.XCLAIM).key(bArr).add(bArr2).add(bArr3).add(Long.valueOf(j)).addObjects(bArr4).addParams(xClaimParams).add(Protocol.Keyword.JUSTID), BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<Object>> xautoclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XAUTOCLAIM).key(bArr).add(bArr2).add(bArr3).add(Long.valueOf(j)).add(bArr4).addParams(xAutoClaimParams), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> xautoclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.XAUTOCLAIM).key(bArr).add(bArr2).add(bArr3).add(Long.valueOf(j)).add(bArr4).addParams(xAutoClaimParams).add(Protocol.Keyword.JUSTID), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<StreamInfo> xinfoStream(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.STREAM).key(str), BuilderFactory.STREAM_INFO);
    }

    public final CommandObject<Object> xinfoStream(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.STREAM).key(bArr), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<StreamFullInfo> xinfoStreamFull(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.STREAM).key(str).add(Protocol.Keyword.FULL), BuilderFactory.STREAM_INFO_FULL);
    }

    public final CommandObject<StreamFullInfo> xinfoStreamFull(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.STREAM).key(str).add(Protocol.Keyword.FULL).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.STREAM_INFO_FULL);
    }

    public final CommandObject<Object> xinfoStreamFull(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.STREAM).key(bArr).add(Protocol.Keyword.FULL).add(Protocol.Keyword.COUNT).add(Integer.valueOf(i)), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> xinfoStreamFull(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.STREAM).key(bArr).add(Protocol.Keyword.FULL), BuilderFactory.RAW_OBJECT);
    }

    @Deprecated
    public final CommandObject<List<StreamGroupInfo>> xinfoGroup(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.GROUPS).key(str), BuilderFactory.STREAM_GROUP_INFO_LIST);
    }

    public final CommandObject<List<StreamGroupInfo>> xinfoGroups(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.GROUPS).key(str), BuilderFactory.STREAM_GROUP_INFO_LIST);
    }

    @Deprecated
    public final CommandObject<List<Object>> xinfoGroup(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.GROUPS).key(bArr), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> xinfoGroups(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.GROUPS).key(bArr), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<StreamConsumersInfo>> xinfoConsumers(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.CONSUMERS).key(str).add(str2), BuilderFactory.STREAM_CONSUMERS_INFO_LIST);
    }

    public final CommandObject<List<Object>> xinfoConsumers(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.XINFO).add(Protocol.Keyword.CONSUMERS).key(bArr).add(bArr2), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Map.Entry<String, List<StreamEntry>>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XREAD).addParams(xReadParams).add(Protocol.Keyword.STREAMS);
        Set<Map.Entry<String, StreamEntryID>> setEntrySet = map.entrySet();
        setEntrySet.forEach(entry -> {
            commandArgumentsAdd.key(entry.getKey());
        });
        setEntrySet.forEach(entry2 -> {
            commandArgumentsAdd.add(entry2.getValue());
        });
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STREAM_READ_RESPONSE);
    }

    public final CommandObject<List<Map.Entry<String, List<StreamEntry>>>> xreadGroup(String str, String str2, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XREADGROUP).add(Protocol.Keyword.GROUP).add(str).add(str2).addParams(xReadGroupParams).add(Protocol.Keyword.STREAMS);
        Set<Map.Entry<String, StreamEntryID>> setEntrySet = map.entrySet();
        setEntrySet.forEach(entry -> {
            commandArgumentsAdd.key(entry.getKey());
        });
        setEntrySet.forEach(entry2 -> {
            commandArgumentsAdd.add(entry2.getValue());
        });
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STREAM_READ_RESPONSE);
    }

    public final CommandObject<List<byte[]>> xread(XReadParams xReadParams, Map.Entry<byte[], byte[]>... entryArr) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XREAD).addParams(xReadParams).add(Protocol.Keyword.STREAMS);
        for (Map.Entry<byte[], byte[]> entry : entryArr) {
            commandArgumentsAdd.key(entry.getKey());
        }
        for (Map.Entry<byte[], byte[]> entry2 : entryArr) {
            commandArgumentsAdd.add(entry2.getValue());
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<List<byte[]>> xreadGroup(byte[] bArr, byte[] bArr2, XReadGroupParams xReadGroupParams, Map.Entry<byte[], byte[]>... entryArr) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.XREADGROUP).add(Protocol.Keyword.GROUP).add(bArr).add(bArr2).addParams(xReadGroupParams).add(Protocol.Keyword.STREAMS);
        for (Map.Entry<byte[], byte[]> entry : entryArr) {
            commandArgumentsAdd.key(entry.getKey());
        }
        for (Map.Entry<byte[], byte[]> entry2 : entryArr) {
            commandArgumentsAdd.add(entry2.getValue());
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.BINARY_LIST);
    }

    public final CommandObject<Object> eval(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(str).add(0), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> eval(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(str).add(0).processKey(str2), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> eval(String str, int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(str).add(Integer.valueOf(i)).addObjects(strArr).processKeys((String[]) Arrays.copyOf(strArr, i)), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> eval(String str, List<String> list, List<String> list2) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(str).add(Integer.valueOf(strArr.length)).keys(strArr).addObjects((String[]) list2.toArray(new String[list2.size()])), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> evalReadonly(String str, List<String> list, List<String> list2) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL_RO).add(str).add(Integer.valueOf(strArr.length)).keys(strArr).addObjects((String[]) list2.toArray(new String[list2.size()])), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> eval(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(bArr).add(0), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> eval(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(bArr).add(0).processKey(bArr2), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> eval(byte[] bArr, int i, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(bArr).add(Integer.valueOf(i)).addObjects(bArr2).processKeys((byte[][]) Arrays.copyOf(bArr2, i)), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> eval(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        byte[][] bArr2 = (byte[][]) list.toArray(new byte[list.size()][]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL).add(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addObjects((byte[][]) list2.toArray(new byte[list2.size()][])), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> evalReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        byte[][] bArr2 = (byte[][]) list.toArray(new byte[list.size()][]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVAL_RO).add(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addObjects((byte[][]) list2.toArray(new byte[list2.size()][])), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> evalsha(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(str).add(0), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> evalsha(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(str).add(0).processKey(str2), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> evalsha(String str, int i, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(str).add(Integer.valueOf(i)).addObjects(strArr).processKeys((String[]) Arrays.copyOf(strArr, i)), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> evalsha(String str, List<String> list, List<String> list2) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(str).add(Integer.valueOf(strArr.length)).keys(strArr).addObjects((String[]) list2.toArray(new String[list2.size()])), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> evalshaReadonly(String str, List<String> list, List<String> list2) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA_RO).add(str).add(Integer.valueOf(strArr.length)).keys(strArr).addObjects((String[]) list2.toArray(new String[list2.size()])), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> evalsha(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(bArr).add(0), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> evalsha(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(bArr).add(0).processKey(bArr2), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> evalsha(byte[] bArr, int i, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(bArr).add(Integer.valueOf(i)).addObjects(bArr2).processKeys((byte[][]) Arrays.copyOf(bArr2, i)), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        byte[][] bArr2 = (byte[][]) list.toArray(new byte[list.size()][]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA).add(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addObjects((byte[][]) list2.toArray(new byte[list2.size()][])), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> evalshaReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        byte[][] bArr2 = (byte[][]) list.toArray(new byte[list.size()][]);
        return new CommandObject<>(commandArguments(Protocol.Command.EVALSHA_RO).add(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addObjects((byte[][]) list2.toArray(new byte[list2.size()][])), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<List<Boolean>> scriptExists(String str, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.EXISTS).addObjects(strArr).processKey(str), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<String> scriptLoad(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.LOAD).add(str).processKey(str2), BuilderFactory.STRING);
    }

    public final CommandObject<String> scriptFlush(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.FLUSH).processKey(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> scriptFlush(String str, FlushMode flushMode) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.FLUSH).add(flushMode).processKey(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> scriptKill(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.KILL).processKey(str), BuilderFactory.STRING);
    }

    public final CommandObject<List<Boolean>> scriptExists(byte[] bArr, byte[]... bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.EXISTS).addObjects(bArr2).processKey(bArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<byte[]> scriptLoad(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.LOAD).add(bArr).processKey(bArr2), BuilderFactory.BINARY);
    }

    public final CommandObject<String> scriptFlush(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.FLUSH).processKey(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> scriptFlush(byte[] bArr, FlushMode flushMode) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.FLUSH).add(flushMode).processKey(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> scriptKill(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.SCRIPT).add(Protocol.Keyword.KILL).processKey(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<Object> fcall(String str, List<String> list, List<String> list2) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new CommandObject<>(commandArguments(Protocol.Command.FCALL).add(str).add(Integer.valueOf(strArr.length)).keys(strArr).addObjects((String[]) list2.toArray(new String[list2.size()])), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<Object> fcallReadonly(String str, List<String> list, List<String> list2) {
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        return new CommandObject<>(commandArguments(Protocol.Command.FCALL_RO).add(str).add(Integer.valueOf(strArr.length)).keys(strArr).addObjects((String[]) list2.toArray(new String[list2.size()])), BuilderFactory.ENCODED_OBJECT);
    }

    public final CommandObject<String> functionDelete(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.DELETE).add(str), BuilderFactory.STRING);
    }

    public final CommandObject<List<LibraryInfo>> functionList() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST), BuilderFactory.LIBRARY_LIST);
    }

    public final CommandObject<List<LibraryInfo>> functionList(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST).add(Protocol.Keyword.LIBRARYNAME).add(str), BuilderFactory.LIBRARY_LIST);
    }

    public final CommandObject<List<LibraryInfo>> functionListWithCode() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST).add(Protocol.Keyword.WITHCODE), BuilderFactory.LIBRARY_LIST);
    }

    public final CommandObject<List<LibraryInfo>> functionListWithCode(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST).add(Protocol.Keyword.LIBRARYNAME).add(str).add(Protocol.Keyword.WITHCODE), BuilderFactory.LIBRARY_LIST);
    }

    public final CommandObject<String> functionLoad(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LOAD).add(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> functionLoadReplace(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LOAD).add(Protocol.Keyword.REPLACE).add(str), BuilderFactory.STRING);
    }

    public final CommandObject<FunctionStats> functionStats() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.STATS), FunctionStats.FUNCTION_STATS_BUILDER);
    }

    public final CommandObject<Object> functionStatsBinary() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.STATS), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<String> functionFlush() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.FLUSH), BuilderFactory.STRING);
    }

    public final CommandObject<String> functionFlush(FlushMode flushMode) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.FLUSH).add(flushMode), BuilderFactory.STRING);
    }

    public final CommandObject<String> functionKill() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.KILL), BuilderFactory.STRING);
    }

    public final CommandObject<Object> fcall(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        byte[][] bArr2 = (byte[][]) list.toArray(new byte[list.size()][]);
        return new CommandObject<>(commandArguments(Protocol.Command.FCALL).add(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addObjects((byte[][]) list2.toArray(new byte[list2.size()][])), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<Object> fcallReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        byte[][] bArr2 = (byte[][]) list.toArray(new byte[list.size()][]);
        return new CommandObject<>(commandArguments(Protocol.Command.FCALL_RO).add(bArr).add(Integer.valueOf(bArr2.length)).keys(bArr2).addObjects((byte[][]) list2.toArray(new byte[list2.size()][])), BuilderFactory.RAW_OBJECT);
    }

    public final CommandObject<String> functionDelete(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.DELETE).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<byte[]> functionDump() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.DUMP), BuilderFactory.BINARY);
    }

    public final CommandObject<List<Object>> functionListBinary() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> functionList(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST).add(Protocol.Keyword.LIBRARYNAME).add(bArr), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> functionListWithCodeBinary() {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST).add(Protocol.Keyword.WITHCODE), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> functionListWithCode(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LIST).add(Protocol.Keyword.LIBRARYNAME).add(bArr).add(Protocol.Keyword.WITHCODE), BuilderFactory.RAW_OBJECT_LIST);
    }

    public final CommandObject<String> functionLoad(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LOAD).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> functionLoadReplace(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Keyword.LOAD).add(Protocol.Keyword.REPLACE).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> functionRestore(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Command.RESTORE).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy) {
        return new CommandObject<>(commandArguments(Protocol.Command.FUNCTION).add(Protocol.Command.RESTORE).add(bArr).add(functionRestorePolicy.getRaw()), BuilderFactory.STRING);
    }

    @Deprecated
    public final CommandObject<LCSMatchResult> strAlgoLCSStrings(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.STRALGO).add(Protocol.Keyword.LCS).add(Protocol.Keyword.STRINGS).add(str).add(str2).addParams(strAlgoLCSParams), BuilderFactory.STR_ALGO_LCS_RESULT_BUILDER);
    }

    @Deprecated
    public final CommandObject<LCSMatchResult> strAlgoLCSStrings(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        return new CommandObject<>(commandArguments(Protocol.Command.STRALGO).add(Protocol.Keyword.LCS).add(Protocol.Keyword.STRINGS).add(bArr).add(bArr2).addParams(strAlgoLCSParams), BuilderFactory.STR_ALGO_LCS_RESULT_BUILDER);
    }

    public final CommandObject<Boolean> copy(String str, String str2, int i, boolean z) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.COPY).key(str).key(str2).add(Protocol.Keyword.DB).add(Integer.valueOf(i));
        if (z) {
            commandArgumentsAdd.add(Protocol.Keyword.REPLACE);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> copy(byte[] bArr, byte[] bArr2, int i, boolean z) {
        CommandArguments commandArgumentsAdd = commandArguments(Protocol.Command.COPY).key(bArr).key(bArr2).add(Protocol.Keyword.DB).add(Integer.valueOf(i));
        if (z) {
            commandArgumentsAdd.add(Protocol.Keyword.REPLACE);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.BOOLEAN);
    }

    public final CommandObject<String> migrate(String str, int i, String str2, int i2) {
        return migrate(str, i, str2, 0, i2);
    }

    public final CommandObject<String> migrate(String str, int i, String str2, int i2, int i3) {
        return new CommandObject<>(commandArguments(Protocol.Command.MIGRATE).add(str).add(Integer.valueOf(i)).key(str2).add(Integer.valueOf(i2)).add(Integer.valueOf(i3)), BuilderFactory.STRING);
    }

    public final CommandObject<String> migrate(String str, int i, int i2, MigrateParams migrateParams, String... strArr) {
        return migrate(str, i, 0, i2, migrateParams, strArr);
    }

    public final CommandObject<String> migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, String... strArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.MIGRATE).add(str).add(Integer.valueOf(i)).add(new byte[0]).add(Integer.valueOf(i2)).add(Integer.valueOf(i3)).addParams(migrateParams).add(Protocol.Keyword.KEYS).keys(strArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> migrate(String str, int i, byte[] bArr, int i2) {
        return migrate(str, i, bArr, 0, i2);
    }

    public final CommandObject<String> migrate(String str, int i, byte[] bArr, int i2, int i3) {
        return new CommandObject<>(commandArguments(Protocol.Command.MIGRATE).add(str).add(Integer.valueOf(i)).key(bArr).add(Integer.valueOf(i2)).add(Integer.valueOf(i3)), BuilderFactory.STRING);
    }

    public final CommandObject<String> migrate(String str, int i, int i2, MigrateParams migrateParams, byte[]... bArr) {
        return migrate(str, i, 0, i2, migrateParams, bArr);
    }

    public final CommandObject<String> migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, byte[]... bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.MIGRATE).add(str).add(Integer.valueOf(i)).add(new byte[0]).add(Integer.valueOf(i2)).add(Integer.valueOf(i3)).addParams(migrateParams).add(Protocol.Keyword.KEYS).keys(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<Long> memoryUsage(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.MEMORY).add(Protocol.Keyword.USAGE).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> memoryUsage(String str, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.MEMORY).add(Protocol.Keyword.USAGE).key(str).add(Protocol.Keyword.SAMPLES).add(Integer.valueOf(i)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> memoryUsage(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.MEMORY).add(Protocol.Keyword.USAGE).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> memoryUsage(byte[] bArr, int i) {
        return new CommandObject<>(commandArguments(Protocol.Command.MEMORY).add(Protocol.Keyword.USAGE).key(bArr).add(Protocol.Keyword.SAMPLES).add(Integer.valueOf(i)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> objectRefcount(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.REFCOUNT).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<String> objectEncoding(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.ENCODING).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<Long> objectIdletime(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.IDLETIME).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> objectFreq(String str) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.FREQ).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> objectRefcount(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.REFCOUNT).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<byte[]> objectEncoding(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.ENCODING).key(bArr), BuilderFactory.BINARY);
    }

    public final CommandObject<Long> objectIdletime(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.IDLETIME).key(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> objectFreq(byte[] bArr) {
        return new CommandObject<>(commandArguments(Protocol.Command.OBJECT).add(Protocol.Keyword.FREQ).key(bArr), BuilderFactory.LONG);
    }

    public CommandObject<Long> waitReplicas(int i, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.WAIT).add(Integer.valueOf(i)).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> waitReplicas(String str, int i, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.WAIT).add(Integer.valueOf(i)).add(Long.valueOf(j)).processKey(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> waitReplicas(byte[] bArr, int i, long j) {
        return new CommandObject<>(commandArguments(Protocol.Command.WAIT).add(Integer.valueOf(i)).add(Long.valueOf(j)).processKey(bArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> publish(String str, String str2) {
        return new CommandObject<>(commandArguments(Protocol.Command.PUBLISH).add(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> publish(byte[] bArr, byte[] bArr2) {
        return new CommandObject<>(commandArguments(Protocol.Command.PUBLISH).add(bArr).add(bArr2), BuilderFactory.LONG);
    }

    public CommandObject<String> ftCreate(String str, IndexOptions indexOptions, Schema schema) {
        CommandArguments commandArgumentsAdd = commandArguments(SearchProtocol.SearchCommand.CREATE).add(str).addParams(indexOptions).add(SearchProtocol.SearchKeyword.SCHEMA);
        schema.fields.forEach(field -> {
            commandArgumentsAdd.addParams(field);
        });
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING);
    }

    public CommandObject<String> ftCreate(String str, FTCreateParams fTCreateParams, Iterable<SchemaField> iterable) {
        CommandArguments commandArgumentsAdd = commandArguments(SearchProtocol.SearchCommand.CREATE).add(str).addParams(fTCreateParams).add(SearchProtocol.SearchKeyword.SCHEMA);
        iterable.forEach(schemaField -> {
            commandArgumentsAdd.addParams(schemaField);
        });
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING);
    }

    public CommandObject<String> ftAlter(String str, Schema schema) {
        CommandArguments commandArgumentsAdd = commandArguments(SearchProtocol.SearchCommand.ALTER).add(str).add(SearchProtocol.SearchKeyword.SCHEMA).add(SearchProtocol.SearchKeyword.ADD);
        schema.fields.forEach(field -> {
            commandArgumentsAdd.addParams(field);
        });
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING);
    }

    public CommandObject<String> ftAlter(String str, Iterable<SchemaField> iterable) {
        CommandArguments commandArgumentsAdd = commandArguments(SearchProtocol.SearchCommand.ALTER).add(str).add(SearchProtocol.SearchKeyword.SCHEMA).add(SearchProtocol.SearchKeyword.ADD);
        iterable.forEach(schemaField -> {
            commandArgumentsAdd.addParams(schemaField);
        });
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING);
    }

    public CommandObject<SearchResult> ftSearch(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SEARCH).add(str).add(str2), new SearchResult.SearchResultBuilder(true, false, false, true));
    }

    public CommandObject<SearchResult> ftSearch(String str, String str2, FTSearchParams fTSearchParams) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SEARCH).add(str).add(str2).addParams(fTSearchParams), new SearchResult.SearchResultBuilder(!fTSearchParams.getNoContent(), fTSearchParams.getWithScores(), false, true));
    }

    public CommandObject<SearchResult> ftSearch(String str, Query query) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SEARCH).add(str).addParams(query), new SearchResult.SearchResultBuilder(!query.getNoContent(), query.getWithScores(), query.getWithPayloads(), true));
    }

    public CommandObject<SearchResult> ftSearch(byte[] bArr, Query query) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SEARCH).add(bArr).addParams(query), new SearchResult.SearchResultBuilder(!query.getNoContent(), query.getWithScores(), query.getWithPayloads(), false));
    }

    public CommandObject<String> ftExplain(String str, Query query) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.EXPLAIN).add(str).addParams(query), BuilderFactory.STRING);
    }

    public CommandObject<List<String>> ftExplainCLI(String str, Query query) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.EXPLAINCLI).add(str).addParams(query), BuilderFactory.STRING_LIST);
    }

    public CommandObject<AggregationResult> ftAggregate(String str, AggregationBuilder aggregationBuilder) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.AGGREGATE).add(str).addObjects(aggregationBuilder.getArgs()), !aggregationBuilder.isWithCursor() ? BuilderFactory.SEARCH_AGGREGATION_RESULT : BuilderFactory.SEARCH_AGGREGATION_RESULT_WITH_CURSOR);
    }

    public CommandObject<AggregationResult> ftCursorRead(String str, long j, int i) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.CURSOR).add(SearchProtocol.SearchKeyword.READ).add(str).add(Long.valueOf(j)).add(Integer.valueOf(i)), BuilderFactory.SEARCH_AGGREGATION_RESULT_WITH_CURSOR);
    }

    public CommandObject<String> ftCursorDel(String str, long j) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.CURSOR).add(SearchProtocol.SearchKeyword.DEL).add(str).add(Long.valueOf(j)), BuilderFactory.STRING);
    }

    public CommandObject<String> ftDropIndex(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.DROPINDEX).add(str), BuilderFactory.STRING);
    }

    public CommandObject<String> ftDropIndexDD(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.DROPINDEX).add(str).add(SearchProtocol.SearchKeyword.DD), BuilderFactory.STRING);
    }

    public CommandObject<String> ftSynUpdate(String str, String str2, String... strArr) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SYNUPDATE).add(str).add(str2).addObjects(strArr), BuilderFactory.STRING);
    }

    public CommandObject<Map<String, List<String>>> ftSynDump(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SYNDUMP).add(str), BuilderFactory.SEARCH_SYNONYM_GROUPS);
    }

    public final CommandObject<Long> ftDictAdd(String str, String... strArr) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.DICTADD).add(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Long> ftDictDel(String str, String... strArr) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.DICTDEL).add(str).addObjects(strArr), BuilderFactory.LONG);
    }

    public final CommandObject<Set<String>> ftDictDump(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.DICTDUMP).add(str), BuilderFactory.STRING_SET);
    }

    public final CommandObject<Long> ftDictAddBySampleKey(String str, String str2, String... strArr) {
        return addProcessKey(ftDictAdd(str2, strArr), str);
    }

    public final CommandObject<Long> ftDictDelBySampleKey(String str, String str2, String... strArr) {
        return addProcessKey(ftDictDel(str2, strArr), str);
    }

    public final CommandObject<Set<String>> ftDictDumpBySampleKey(String str, String str2) {
        return addProcessKey(ftDictDump(str2), str);
    }

    public CommandObject<Map<String, Object>> ftInfo(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.INFO).add(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    public CommandObject<Set<String>> ftTagVals(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.TAGVALS).add(str).add(str2), BuilderFactory.STRING_SET);
    }

    public CommandObject<String> ftAliasAdd(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.ALIASADD).add(str).add(str2), BuilderFactory.STRING);
    }

    public CommandObject<String> ftAliasUpdate(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.ALIASUPDATE).add(str).add(str2), BuilderFactory.STRING);
    }

    public CommandObject<String> ftAliasDel(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.ALIASDEL).add(str), BuilderFactory.STRING);
    }

    public final CommandObject<Map<String, String>> ftConfigGet(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.CONFIG).add(SearchProtocol.SearchKeyword.GET).add(str), BuilderFactory.STRING_MAP_FROM_PAIRS);
    }

    public CommandObject<Map<String, String>> ftConfigGet(String str, String str2) {
        return ftConfigGet(str2);
    }

    public final CommandObject<String> ftConfigSet(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.CONFIG).add(SearchProtocol.SearchKeyword.SET).add(str).add(str2), BuilderFactory.STRING);
    }

    public CommandObject<String> ftConfigSet(String str, String str2, String str3) {
        return ftConfigSet(str2, str3);
    }

    public final CommandObject<Long> ftSugAdd(String str, String str2, double d) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SUGADD).key(str).add(str2).add(Double.valueOf(d)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> ftSugAddIncr(String str, String str2, double d) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SUGADD).key(str).add(str2).add(Double.valueOf(d)).add(SearchProtocol.SearchKeyword.INCR), BuilderFactory.LONG);
    }

    public final CommandObject<List<String>> ftSugGet(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SUGGET).key(str).add(str2), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> ftSugGet(String str, String str2, boolean z, int i) {
        CommandArguments commandArgumentsAdd = commandArguments(SearchProtocol.SearchCommand.SUGGET).key(str).add(str2);
        if (z) {
            commandArgumentsAdd.add(SearchProtocol.SearchKeyword.FUZZY);
        }
        commandArgumentsAdd.add(SearchProtocol.SearchKeyword.MAX).add(Integer.valueOf(i));
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<Tuple>> ftSugGetWithScores(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SUGGET).key(str).add(str2).add(SearchProtocol.SearchKeyword.WITHSCORES), BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<List<Tuple>> ftSugGetWithScores(String str, String str2, boolean z, int i) {
        CommandArguments commandArgumentsAdd = commandArguments(SearchProtocol.SearchCommand.SUGGET).key(str).add(str2);
        if (z) {
            commandArgumentsAdd.add(SearchProtocol.SearchKeyword.FUZZY);
        }
        commandArgumentsAdd.add(SearchProtocol.SearchKeyword.MAX).add(Integer.valueOf(i));
        commandArgumentsAdd.add(SearchProtocol.SearchKeyword.WITHSCORES);
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.TUPLE_LIST);
    }

    public final CommandObject<Boolean> ftSugDel(String str, String str2) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SUGDEL).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> ftSugLen(String str) {
        return new CommandObject<>(commandArguments(SearchProtocol.SearchCommand.SUGLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<String> jsonSet(String str, Path2 path2, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path2).add(obj), BuilderFactory.STRING);
    }

    public final CommandObject<String> jsonSetWithEscape(String str, Path2 path2, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path2).add(GSON.b(obj)), BuilderFactory.STRING);
    }

    public final CommandObject<String> jsonSet(String str, Path path, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path).add(GSON.b(obj)), BuilderFactory.STRING);
    }

    public final CommandObject<String> jsonSetWithPlainString(String str, Path path, String str2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path).add(str2), BuilderFactory.STRING);
    }

    public final CommandObject<String> jsonSet(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path2).add(obj).addParams(jsonSetParams), BuilderFactory.STRING);
    }

    public final CommandObject<String> jsonSetWithEscape(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path2).add(GSON.b(obj)).addParams(jsonSetParams), BuilderFactory.STRING);
    }

    public final CommandObject<String> jsonSet(String str, Path path, Object obj, JsonSetParams jsonSetParams) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.SET).key(str).add(path).add(GSON.b(obj)).addParams(jsonSetParams), BuilderFactory.STRING);
    }

    public final CommandObject<Object> jsonGet(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.GET).key(str), new GsonObjectBuilder(Object.class));
    }

    public final <T> CommandObject<T> jsonGet(String str, Class<T> cls) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.GET).key(str), new GsonObjectBuilder(cls));
    }

    public final CommandObject<Object> jsonGet(String str, Path2... path2Arr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.GET).key(str).addObjects(path2Arr), BuilderFactory.JSON_OBJECT);
    }

    public final CommandObject<Object> jsonGet(String str, Path... pathArr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.GET).key(str).addObjects(pathArr), new GsonObjectBuilder(Object.class));
    }

    public final CommandObject<String> jsonGetAsPlainString(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.GET).key(str).add(path), BuilderFactory.STRING);
    }

    public final <T> CommandObject<T> jsonGet(String str, Class<T> cls, Path... pathArr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.GET).key(str).addObjects(pathArr), new GsonObjectBuilder(cls));
    }

    public final CommandObject<List<JSONArray>> jsonMGet(Path2 path2, String... strArr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.MGET).keys(strArr).add(path2), BuilderFactory.JSON_ARRAY_LIST);
    }

    public final <T> CommandObject<List<T>> jsonMGet(Path path, Class<T> cls, String... strArr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.MGET).keys(strArr).add(path), new GsonObjectListBuilder(cls));
    }

    public final CommandObject<Long> jsonDel(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.DEL).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonDel(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.DEL).key(str).add(path2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonDel(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.DEL).key(str).add(path), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonClear(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.CLEAR).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonClear(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.CLEAR).key(str).add(path2), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonClear(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.CLEAR).key(str).add(path), BuilderFactory.LONG);
    }

    public final CommandObject<List<Boolean>> jsonToggle(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.TOGGLE).key(str).add(path2), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<String> jsonToggle(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.TOGGLE).key(str).add(path), BuilderFactory.STRING);
    }

    public final CommandObject<Class<?>> jsonType(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.TYPE).key(str), BuilderFactory.JSON_TYPE);
    }

    public final CommandObject<List<Class<?>>> jsonType(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.TYPE).key(str).add(path2), BuilderFactory.JSON_TYPE_LIST);
    }

    public final CommandObject<Class<?>> jsonType(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.TYPE).key(str).add(path), BuilderFactory.JSON_TYPE);
    }

    public final CommandObject<Long> jsonStrAppend(String str, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.STRAPPEND).key(str).add(GSON.b(obj)), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonStrAppend(String str, Path2 path2, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.STRAPPEND).key(str).add(path2).add(GSON.b(obj)), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonStrAppend(String str, Path path, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.STRAPPEND).key(str).add(path).add(GSON.b(obj)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonStrLen(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.STRLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonStrLen(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.STRLEN).key(str).add(path2), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonStrLen(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.STRLEN).key(str).add(path), BuilderFactory.LONG);
    }

    public final CommandObject<JSONArray> jsonNumIncrBy(String str, Path2 path2, double d) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.NUMINCRBY).key(str).add(path2).add(Double.valueOf(d)), BuilderFactory.JSON_ARRAY);
    }

    public final CommandObject<Double> jsonNumIncrBy(String str, Path path, double d) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.NUMINCRBY).key(str).add(path).add(Double.valueOf(d)), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Long> jsonArrAppend(String str, String str2, JSONObject... jSONObjectArr) {
        CommandArguments commandArgumentsAdd = commandArguments(JsonProtocol.JsonCommand.ARRAPPEND).key(str).add(str2);
        for (JSONObject jSONObject : jSONObjectArr) {
            commandArgumentsAdd.add(jSONObject);
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonArrAppend(String str, Path2 path2, Object... objArr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRAPPEND).key(str).add(path2).addObjects(objArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> jsonArrAppendWithEscape(String str, Path2 path2, Object... objArr) {
        CommandArguments commandArgumentsAdd = commandArguments(JsonProtocol.JsonCommand.ARRAPPEND).key(str).add(path2);
        for (Object obj : objArr) {
            commandArgumentsAdd.add(GSON.b(obj));
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonArrAppend(String str, Path path, Object... objArr) {
        CommandArguments commandArgumentsAdd = commandArguments(JsonProtocol.JsonCommand.ARRAPPEND).key(str).add(path);
        for (Object obj : objArr) {
            commandArgumentsAdd.add(GSON.b(obj));
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonArrIndex(String str, Path2 path2, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRINDEX).key(str).add(path2).add(obj), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> jsonArrIndexWithEscape(String str, Path2 path2, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRINDEX).key(str).add(path2).add(GSON.b(obj)), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonArrIndex(String str, Path path, Object obj) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRINDEX).key(str).add(path).add(GSON.b(obj)), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonArrInsert(String str, Path2 path2, int i, Object... objArr) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRINSERT).key(str).add(path2).add(Integer.valueOf(i)).addObjects(objArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> jsonArrInsertWithEscape(String str, Path2 path2, int i, Object... objArr) {
        CommandArguments commandArgumentsAdd = commandArguments(JsonProtocol.JsonCommand.ARRINSERT).key(str).add(path2).add(Integer.valueOf(i));
        for (Object obj : objArr) {
            commandArgumentsAdd.add(GSON.b(obj));
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonArrInsert(String str, Path path, int i, Object... objArr) {
        CommandArguments commandArgumentsAdd = commandArguments(JsonProtocol.JsonCommand.ARRINSERT).key(str).add(path).add(Integer.valueOf(i));
        for (Object obj : objArr) {
            commandArgumentsAdd.add(GSON.b(obj));
        }
        return new CommandObject<>(commandArgumentsAdd, BuilderFactory.LONG);
    }

    public final CommandObject<Object> jsonArrPop(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str), new GsonObjectBuilder(Object.class));
    }

    public final <T> CommandObject<T> jsonArrPop(String str, Class<T> cls) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str), new GsonObjectBuilder(cls));
    }

    public final CommandObject<List<Object>> jsonArrPop(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str).add(path2), new GsonObjectListBuilder(Object.class));
    }

    public final CommandObject<Object> jsonArrPop(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str).add(path), new GsonObjectBuilder(Object.class));
    }

    public final <T> CommandObject<T> jsonArrPop(String str, Class<T> cls, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str).add(path), new GsonObjectBuilder(cls));
    }

    public final CommandObject<List<Object>> jsonArrPop(String str, Path2 path2, int i) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str).add(path2).add(Integer.valueOf(i)), new GsonObjectListBuilder(Object.class));
    }

    public final CommandObject<Object> jsonArrPop(String str, Path path, int i) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str).add(path).add(Integer.valueOf(i)), new GsonObjectBuilder(Object.class));
    }

    public final <T> CommandObject<T> jsonArrPop(String str, Class<T> cls, Path path, int i) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRPOP).key(str).add(path).add(Integer.valueOf(i)), new GsonObjectBuilder(cls));
    }

    public final CommandObject<Long> jsonArrLen(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonArrLen(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRLEN).key(str).add(path2), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonArrLen(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRLEN).key(str).add(path), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonArrTrim(String str, Path2 path2, int i, int i2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRTRIM).key(str).add(path2).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> jsonArrTrim(String str, Path path, int i, int i2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.ARRTRIM).key(str).add(path).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonObjLen(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.OBJLEN).key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonObjLen(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.OBJLEN).key(str).add(path), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonObjLen(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.OBJLEN).key(str).add(path2), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<String>> jsonObjKeys(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.OBJKEYS).key(str), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> jsonObjKeys(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.OBJKEYS).key(str).add(path), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<List<String>>> jsonObjKeys(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.OBJKEYS).key(str).add(path2), BuilderFactory.STRING_LIST_LIST);
    }

    public final CommandObject<Long> jsonDebugMemory(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.DEBUG).add("MEMORY").key(str), BuilderFactory.LONG);
    }

    public final CommandObject<Long> jsonDebugMemory(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.DEBUG).add("MEMORY").key(str).add(path), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> jsonDebugMemory(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.DEBUG).add("MEMORY").key(str).add(path2), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Object>> jsonResp(String str) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.RESP).key(str), BuilderFactory.ENCODED_OBJECT_LIST);
    }

    public final CommandObject<List<Object>> jsonResp(String str, Path path) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.RESP).key(str).add(path), BuilderFactory.ENCODED_OBJECT_LIST);
    }

    public final CommandObject<List<List<Object>>> jsonResp(String str, Path2 path2) {
        return new CommandObject<>(commandArguments(JsonProtocol.JsonCommand.RESP).key(str).add(path2), BuilderFactory.ENCODED_OBJECT_LIST_LIST);
    }

    public final CommandObject<String> tsCreate(String str) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.CREATE).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> tsCreate(String str, TSCreateParams tSCreateParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.CREATE).key(str).addParams(tSCreateParams), BuilderFactory.STRING);
    }

    public final CommandObject<Long> tsDel(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.DEL).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.LONG);
    }

    public final CommandObject<String> tsAlter(String str, TSAlterParams tSAlterParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.ALTER).key(str).addParams(tSAlterParams), BuilderFactory.STRING);
    }

    public final CommandObject<Long> tsAdd(String str, double d) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.ADD).key(str).add(Protocol.BYTES_ASTERISK).add(Double.valueOf(d)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> tsAdd(String str, long j, double d) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.ADD).key(str).add(Long.valueOf(j)).add(Double.valueOf(d)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> tsAdd(String str, long j, double d, TSCreateParams tSCreateParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.ADD).key(str).add(Long.valueOf(j)).add(Double.valueOf(d)).addParams(tSCreateParams), BuilderFactory.LONG);
    }

    public final CommandObject<List<Long>> tsMAdd(Map.Entry<String, TSElement>... entryArr) {
        CommandArguments commandArguments = commandArguments(TimeSeriesProtocol.TimeSeriesCommand.MADD);
        for (Map.Entry<String, TSElement> entry : entryArr) {
            commandArguments.key(entry.getKey()).add(Long.valueOf(entry.getValue().getTimestamp())).add(Double.valueOf(entry.getValue().getValue()));
        }
        return new CommandObject<>(commandArguments, BuilderFactory.LONG_LIST);
    }

    public final CommandObject<Long> tsIncrBy(String str, double d) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.INCRBY).key(str).add(Double.valueOf(d)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> tsIncrBy(String str, double d, long j) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.INCRBY).key(str).add(Double.valueOf(d)).add(TimeSeriesProtocol.TimeSeriesKeyword.TIMESTAMP).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> tsDecrBy(String str, double d) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.DECRBY).key(str).add(Double.valueOf(d)), BuilderFactory.LONG);
    }

    public final CommandObject<Long> tsDecrBy(String str, double d, long j) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.DECRBY).key(str).add(Double.valueOf(d)).add(TimeSeriesProtocol.TimeSeriesKeyword.TIMESTAMP).add(Long.valueOf(j)), BuilderFactory.LONG);
    }

    public final CommandObject<List<TSElement>> tsRange(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.RANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.TIMESERIES_ELEMENT_LIST);
    }

    public final CommandObject<List<TSElement>> tsRange(String str, TSRangeParams tSRangeParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.RANGE).key(str).addParams(tSRangeParams), BuilderFactory.TIMESERIES_ELEMENT_LIST);
    }

    public final CommandObject<List<TSElement>> tsRevRange(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.REVRANGE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.TIMESERIES_ELEMENT_LIST);
    }

    public final CommandObject<List<TSElement>> tsRevRange(String str, TSRangeParams tSRangeParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.REVRANGE).key(str).addParams(tSRangeParams), BuilderFactory.TIMESERIES_ELEMENT_LIST);
    }

    public final CommandObject<List<TSKeyedElements>> tsMRange(long j, long j2, String... strArr) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.MRANGE).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(TimeSeriesProtocol.TimeSeriesKeyword.FILTER).addObjects(strArr), BuilderFactory.TIMESERIES_MRANGE_RESPONSE);
    }

    public final CommandObject<List<TSKeyedElements>> tsMRange(TSMRangeParams tSMRangeParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.MRANGE).addParams(tSMRangeParams), BuilderFactory.TIMESERIES_MRANGE_RESPONSE);
    }

    public final CommandObject<List<TSKeyedElements>> tsMRevRange(long j, long j2, String... strArr) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.MREVRANGE).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(TimeSeriesProtocol.TimeSeriesKeyword.FILTER).addObjects(strArr), BuilderFactory.TIMESERIES_MRANGE_RESPONSE);
    }

    public final CommandObject<List<TSKeyedElements>> tsMRevRange(TSMRangeParams tSMRangeParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.MREVRANGE).addParams(tSMRangeParams), BuilderFactory.TIMESERIES_MRANGE_RESPONSE);
    }

    public final CommandObject<TSElement> tsGet(String str) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.GET).key(str), BuilderFactory.TIMESERIES_ELEMENT);
    }

    public final CommandObject<TSElement> tsGet(String str, TSGetParams tSGetParams) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.GET).key(str).addParams(tSGetParams), BuilderFactory.TIMESERIES_ELEMENT);
    }

    public final CommandObject<List<TSKeyValue<TSElement>>> tsMGet(TSMGetParams tSMGetParams, String... strArr) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.MGET).addParams(tSMGetParams).add(TimeSeriesProtocol.TimeSeriesKeyword.FILTER).addObjects(strArr), BuilderFactory.TIMESERIES_MGET_RESPONSE);
    }

    public final CommandObject<String> tsCreateRule(String str, String str2, AggregationType aggregationType, long j) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.CREATERULE).key(str).key(str2).add(TimeSeriesProtocol.TimeSeriesKeyword.AGGREGATION).add(aggregationType).add(Long.valueOf(j)), BuilderFactory.STRING);
    }

    public final CommandObject<String> tsCreateRule(String str, String str2, AggregationType aggregationType, long j, long j2) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.CREATERULE).key(str).key(str2).add(TimeSeriesProtocol.TimeSeriesKeyword.AGGREGATION).add(aggregationType).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING);
    }

    public final CommandObject<String> tsDeleteRule(String str, String str2) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.DELETERULE).key(str).key(str2), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> tsQueryIndex(String... strArr) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.QUERYINDEX).addObjects(strArr), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<TSInfo> tsInfo(String str) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.INFO).key(str), TSInfo.TIMESERIES_INFO);
    }

    public final CommandObject<TSInfo> tsInfoDebug(String str) {
        return new CommandObject<>(commandArguments(TimeSeriesProtocol.TimeSeriesCommand.INFO).key(str).add(TimeSeriesProtocol.TimeSeriesKeyword.DEBUG), TSInfo.TIMESERIES_INFO);
    }

    public final CommandObject<String> bfReserve(String str, double d, long j) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.RESERVE).key(str).add(Double.valueOf(d)).add(Long.valueOf(j)), BuilderFactory.STRING);
    }

    public final CommandObject<String> bfReserve(String str, double d, long j, BFReserveParams bFReserveParams) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.RESERVE).key(str).add(Double.valueOf(d)).add(Long.valueOf(j)).addParams(bFReserveParams), BuilderFactory.STRING);
    }

    public final CommandObject<Boolean> bfAdd(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.ADD).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<List<Boolean>> bfMAdd(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.MADD).key(str).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<List<Boolean>> bfInsert(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.INSERT).key(str).add(RedisBloomProtocol.RedisBloomKeyword.ITEMS).addObjects(strArr), BuilderFactory.BOOLEAN_WITH_ERROR_LIST);
    }

    public final CommandObject<List<Boolean>> bfInsert(String str, BFInsertParams bFInsertParams, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.INSERT).key(str).addParams(bFInsertParams).add(RedisBloomProtocol.RedisBloomKeyword.ITEMS).addObjects(strArr), BuilderFactory.BOOLEAN_WITH_ERROR_LIST);
    }

    public final CommandObject<Boolean> bfExists(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.EXISTS).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<List<Boolean>> bfMExists(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.MEXISTS).key(str).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<Map.Entry<Long, byte[]>> bfScanDump(String str, long j) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.SCANDUMP).key(str).add(Long.valueOf(j)), BuilderFactory.BLOOM_SCANDUMP_RESPONSE);
    }

    public final CommandObject<String> bfLoadChunk(String str, long j, byte[] bArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.LOADCHUNK).key(str).add(Long.valueOf(j)).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<Map<String, Object>> bfInfo(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.BloomFilterCommand.INFO).key(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    public final CommandObject<String> cfReserve(String str, long j) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.RESERVE).key(str).add(Long.valueOf(j)), BuilderFactory.STRING);
    }

    public final CommandObject<String> cfReserve(String str, long j, CFReserveParams cFReserveParams) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.RESERVE).key(str).add(Long.valueOf(j)).addParams(cFReserveParams), BuilderFactory.STRING);
    }

    public final CommandObject<Boolean> cfAdd(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.ADD).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Boolean> cfAddNx(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.ADDNX).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<List<Boolean>> cfInsert(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.INSERT).key(str).add(RedisBloomProtocol.RedisBloomKeyword.ITEMS).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<List<Boolean>> cfInsert(String str, CFInsertParams cFInsertParams, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.INSERT).key(str).addParams(cFInsertParams).add(RedisBloomProtocol.RedisBloomKeyword.ITEMS).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<List<Boolean>> cfInsertNx(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.INSERTNX).key(str).add(RedisBloomProtocol.RedisBloomKeyword.ITEMS).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<List<Boolean>> cfInsertNx(String str, CFInsertParams cFInsertParams, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.INSERTNX).key(str).addParams(cFInsertParams).add(RedisBloomProtocol.RedisBloomKeyword.ITEMS).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<Boolean> cfExists(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.EXISTS).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<List<Boolean>> cfMExists(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.MEXISTS).key(str).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<Boolean> cfDel(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.DEL).key(str).add(str2), BuilderFactory.BOOLEAN);
    }

    public final CommandObject<Long> cfCount(String str, String str2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.COUNT).key(str).add(str2), BuilderFactory.LONG);
    }

    public final CommandObject<Map.Entry<Long, byte[]>> cfScanDump(String str, long j) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.SCANDUMP).key(str).add(Long.valueOf(j)), BuilderFactory.BLOOM_SCANDUMP_RESPONSE);
    }

    public final CommandObject<String> cfLoadChunk(String str, long j, byte[] bArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.LOADCHUNK).key(str).add(Long.valueOf(j)).add(bArr), BuilderFactory.STRING);
    }

    public final CommandObject<Map<String, Object>> cfInfo(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CuckooFilterCommand.INFO).key(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    public final CommandObject<String> cmsInitByDim(String str, long j, long j2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CountMinSketchCommand.INITBYDIM).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)), BuilderFactory.STRING);
    }

    public final CommandObject<String> cmsInitByProb(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CountMinSketchCommand.INITBYPROB).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.STRING);
    }

    public final CommandObject<List<Long>> cmsIncrBy(String str, Map<String, Long> map) {
        CommandArguments commandArgumentsKey = commandArguments(RedisBloomProtocol.CountMinSketchCommand.INCRBY).key(str);
        map.entrySet().forEach(entry -> {
            commandArgumentsKey.add(entry.getKey()).add(entry.getValue());
        });
        return new CommandObject<>(commandArgumentsKey, BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> cmsQuery(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CountMinSketchCommand.QUERY).key(str).addObjects(strArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<String> cmsMerge(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CountMinSketchCommand.MERGE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> cmsMerge(String str, Map<String, Long> map) {
        CommandArguments commandArgumentsKey = commandArguments(RedisBloomProtocol.CountMinSketchCommand.MERGE).key(str);
        commandArgumentsKey.add(Integer.valueOf(map.size()));
        map.entrySet().forEach(entry -> {
            commandArgumentsKey.key(entry.getKey());
        });
        commandArgumentsKey.add(RedisBloomProtocol.RedisBloomKeyword.WEIGHTS);
        map.entrySet().forEach(entry2 -> {
            commandArgumentsKey.add(entry2.getValue());
        });
        return new CommandObject<>(commandArgumentsKey, BuilderFactory.STRING);
    }

    public final CommandObject<Map<String, Object>> cmsInfo(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.CountMinSketchCommand.INFO).key(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    public final CommandObject<String> topkReserve(String str, long j) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.RESERVE).key(str).add(Long.valueOf(j)), BuilderFactory.STRING);
    }

    public final CommandObject<String> topkReserve(String str, long j, long j2, long j3, double d) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.RESERVE).key(str).add(Long.valueOf(j)).add(Long.valueOf(j2)).add(Long.valueOf(j3)).add(Double.valueOf(d)), BuilderFactory.STRING);
    }

    public final CommandObject<List<String>> topkAdd(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.ADD).key(str).addObjects(strArr), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> topkIncrBy(String str, Map<String, Long> map) {
        CommandArguments commandArgumentsKey = commandArguments(RedisBloomProtocol.TopKCommand.INCRBY).key(str);
        map.entrySet().forEach(entry -> {
            commandArgumentsKey.add(entry.getKey()).add(entry.getValue());
        });
        return new CommandObject<>(commandArgumentsKey, BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<Boolean>> topkQuery(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.QUERY).key(str).addObjects(strArr), BuilderFactory.BOOLEAN_LIST);
    }

    public final CommandObject<List<Long>> topkCount(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.COUNT).key(str).addObjects(strArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<String>> topkList(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.LIST).key(str), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<Map<String, Object>> topkInfo(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TopKCommand.INFO).key(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    public final CommandObject<String> tdigestCreate(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.CREATE).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> tdigestCreate(String str, int i) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.CREATE).key(str).add(RedisBloomProtocol.RedisBloomKeyword.COMPRESSION).add(Integer.valueOf(i)), BuilderFactory.STRING);
    }

    public final CommandObject<String> tdigestReset(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.RESET).key(str), BuilderFactory.STRING);
    }

    public final CommandObject<String> tdigestMerge(String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.MERGE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr), BuilderFactory.STRING);
    }

    public final CommandObject<String> tdigestMerge(TDigestMergeParams tDigestMergeParams, String str, String... strArr) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.MERGE).key(str).add(Integer.valueOf(strArr.length)).keys(strArr).addParams(tDigestMergeParams), BuilderFactory.STRING);
    }

    public final CommandObject<Map<String, Object>> tdigestInfo(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.INFO).key(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    public final CommandObject<String> tdigestAdd(String str, double... dArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.ADD).key(str), dArr), BuilderFactory.STRING);
    }

    public final CommandObject<List<Double>> tdigestCDF(String str, double... dArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.CDF).key(str), dArr), BuilderFactory.DOUBLE_LIST);
    }

    public final CommandObject<List<Double>> tdigestQuantile(String str, double... dArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.QUANTILE).key(str), dArr), BuilderFactory.DOUBLE_LIST);
    }

    public final CommandObject<Double> tdigestMin(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.MIN).key(str), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> tdigestMax(String str) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.MAX).key(str), BuilderFactory.DOUBLE);
    }

    public final CommandObject<Double> tdigestTrimmedMean(String str, double d, double d2) {
        return new CommandObject<>(commandArguments(RedisBloomProtocol.TDigestCommand.TRIMMED_MEAN).key(str).add(Double.valueOf(d)).add(Double.valueOf(d2)), BuilderFactory.DOUBLE);
    }

    public final CommandObject<List<Long>> tdigestRank(String str, double... dArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.RANK).key(str), dArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Long>> tdigestRevRank(String str, double... dArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.REVRANK).key(str), dArr), BuilderFactory.LONG_LIST);
    }

    public final CommandObject<List<Double>> tdigestByRank(String str, long... jArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.BYRANK).key(str), jArr), BuilderFactory.DOUBLE_LIST);
    }

    public final CommandObject<List<Double>> tdigestByRevRank(String str, long... jArr) {
        return new CommandObject<>(addFlatArgs(commandArguments(RedisBloomProtocol.TDigestCommand.BYREVRANK).key(str), jArr), BuilderFactory.DOUBLE_LIST);
    }

    public final CommandObject<List<String>> graphList() {
        return new CommandObject<>(commandArguments(GraphProtocol.GraphCommand.LIST), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> graphProfile(String str, String str2) {
        return new CommandObject<>(commandArguments(GraphProtocol.GraphCommand.PROFILE).key(str).add(str2), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<String>> graphExplain(String str, String str2) {
        return new CommandObject<>(commandArguments(GraphProtocol.GraphCommand.EXPLAIN).key(str).add(str2), BuilderFactory.STRING_LIST);
    }

    public final CommandObject<List<List<String>>> graphSlowlog(String str) {
        return new CommandObject<>(commandArguments(GraphProtocol.GraphCommand.SLOWLOG).key(str), BuilderFactory.STRING_LIST_LIST);
    }

    public final CommandObject<String> graphConfigSet(String str, Object obj) {
        return new CommandObject<>(commandArguments(GraphProtocol.GraphCommand.CONFIG).add(GraphProtocol.GraphKeyword.SET).add(str).add(obj), BuilderFactory.STRING);
    }

    public final CommandObject<Map<String, Object>> graphConfigGet(String str) {
        return new CommandObject<>(commandArguments(GraphProtocol.GraphCommand.CONFIG).add(GraphProtocol.GraphKeyword.GET).add(str), BuilderFactory.ENCODED_OBJECT_MAP);
    }

    private CommandArguments addFlatArgs(CommandArguments commandArguments, long... jArr) {
        for (long j : jArr) {
            commandArguments.add(Long.valueOf(j));
        }
        return commandArguments;
    }

    private CommandArguments addFlatArgs(CommandArguments commandArguments, double... dArr) {
        for (double d : dArr) {
            commandArguments.add(Double.valueOf(d));
        }
        return commandArguments;
    }

    private CommandArguments addFlatKeyValueArgs(CommandArguments commandArguments, String... strArr) {
        for (int i = 0; i < strArr.length; i += 2) {
            commandArguments.key(strArr[i]).add(strArr[i + 1]);
        }
        return commandArguments;
    }

    private CommandArguments addFlatKeyValueArgs(CommandArguments commandArguments, byte[]... bArr) {
        for (int i = 0; i < bArr.length; i += 2) {
            commandArguments.key(bArr[i]).add(bArr[i + 1]);
        }
        return commandArguments;
    }

    private CommandArguments addFlatMapArgs(CommandArguments commandArguments, Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            commandArguments.add(entry.getKey());
            commandArguments.add(entry.getValue());
        }
        return commandArguments;
    }

    private CommandArguments addSortedSetFlatMapArgs(CommandArguments commandArguments, Map<?, Double> map) {
        for (Map.Entry<?, Double> entry : map.entrySet()) {
            commandArguments.add(entry.getValue());
            commandArguments.add(entry.getKey());
        }
        return commandArguments;
    }

    private CommandArguments addGeoCoordinateFlatMapArgs(CommandArguments commandArguments, Map<?, GeoCoordinate> map) {
        for (Map.Entry<?, GeoCoordinate> entry : map.entrySet()) {
            GeoCoordinate value = entry.getValue();
            commandArguments.add(Double.valueOf(value.getLongitude()));
            commandArguments.add(Double.valueOf(value.getLatitude()));
            commandArguments.add(entry.getKey());
        }
        return commandArguments;
    }

    private <T> CommandObject<T> addProcessKey(CommandObject<T> commandObject, String str) {
        commandObject.getArguments().processKey(str);
        return commandObject;
    }
}
