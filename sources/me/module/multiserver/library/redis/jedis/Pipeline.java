package me.module.multiserver.library.redis.jedis;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import me.module.multiserver.library.redis.jedis.bloom.TDigestMergeParams;
import me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands;
import me.module.multiserver.library.redis.jedis.commands.PipelineBinaryCommands;
import me.module.multiserver.library.redis.jedis.commands.PipelineCommands;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.commands.RedisModulePipelineCommands;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;
import me.module.multiserver.library.redis.jedis.graph.GraphCommandObjects;
import me.module.multiserver.library.redis.jedis.graph.ResultSet;
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
import me.module.multiserver.library.redis.jedis.search.SearchResult;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationBuilder;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationResult;
import me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField;
import me.module.multiserver.library.redis.jedis.timeseries.AggregationType;
import me.module.multiserver.library.redis.jedis.timeseries.TSAlterParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSCreateParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSElement;
import me.module.multiserver.library.redis.jedis.timeseries.TSGetParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyValue;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyedElements;
import me.module.multiserver.library.redis.jedis.timeseries.TSMGetParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSMRangeParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSRangeParams;
import me.module.multiserver.library.redis.jedis.util.KeyValue;
import org.json.JSONArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Pipeline.class */
public class Pipeline extends Queable implements Closeable, DatabasePipelineCommands, PipelineBinaryCommands, PipelineCommands, RedisModulePipelineCommands {
    protected final Connection connection;
    private final CommandObjects commandObjects = new CommandObjects();
    private final GraphCommandObjects graphCommandObjects;

    public Pipeline(Connection connection) {
        this.connection = connection;
        this.graphCommandObjects = new GraphCommandObjects(this.connection);
    }

    public Pipeline(Jedis jedis) {
        this.connection = jedis.getConnection();
        this.graphCommandObjects = new GraphCommandObjects(this.connection);
    }

    public final <T> Response<T> appendCommand(CommandObject<T> commandObject) {
        this.connection.sendCommand(commandObject.getArguments());
        return enqueResponse(commandObject.getBuilder());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        sync();
    }

    public void sync() {
        if (hasPipelinedResponse()) {
            Iterator<Object> it = this.connection.getMany(getPipelinedResponseLength()).iterator();
            while (it.hasNext()) {
                generateResponse(it.next());
            }
        }
    }

    public List<Object> syncAndReturnAll() {
        if (!hasPipelinedResponse()) {
            return Collections.emptyList();
        }
        List<Object> many = this.connection.getMany(getPipelinedResponseLength());
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = many.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(generateResponse(it.next()).get());
            } catch (JedisDataException e) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public final boolean hasPipelinedResponse() {
        return getPipelinedResponseLength() > 0;
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Boolean> exists(String str) {
        return appendCommand(this.commandObjects.exists(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> exists(String... strArr) {
        return appendCommand(this.commandObjects.exists(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> persist(String str) {
        return appendCommand(this.commandObjects.persist(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> type(String str) {
        return appendCommand(this.commandObjects.type(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<byte[]> dump(String str) {
        return appendCommand(this.commandObjects.dump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> restore(String str, long j, byte[] bArr) {
        return appendCommand(this.commandObjects.restore(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> restore(String str, long j, byte[] bArr, RestoreParams restoreParams) {
        return appendCommand(this.commandObjects.restore(str, j, bArr, restoreParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> expire(String str, long j) {
        return appendCommand(this.commandObjects.expire(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> expire(String str, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.expire(str, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> pexpire(String str, long j) {
        return appendCommand(this.commandObjects.pexpire(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> pexpire(String str, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.pexpire(str, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> expireTime(String str) {
        return appendCommand(this.commandObjects.expireTime(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> pexpireTime(String str) {
        return appendCommand(this.commandObjects.pexpireTime(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> expireAt(String str, long j) {
        return appendCommand(this.commandObjects.expireAt(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> expireAt(String str, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.expireAt(str, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> pexpireAt(String str, long j) {
        return appendCommand(this.commandObjects.pexpireAt(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> pexpireAt(String str, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.pexpireAt(str, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> ttl(String str) {
        return appendCommand(this.commandObjects.ttl(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> pttl(String str) {
        return appendCommand(this.commandObjects.pttl(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> touch(String str) {
        return appendCommand(this.commandObjects.touch(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> touch(String... strArr) {
        return appendCommand(this.commandObjects.touch(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<List<String>> sort(String str) {
        return appendCommand(this.commandObjects.sort(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> sort(String str, String str2) {
        return appendCommand(this.commandObjects.sort(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<List<String>> sort(String str, SortingParams sortingParams) {
        return appendCommand(this.commandObjects.sort(str, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> sort(String str, SortingParams sortingParams, String str2) {
        return appendCommand(this.commandObjects.sort(str, sortingParams, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<List<String>> sortReadonly(String str, SortingParams sortingParams) {
        return appendCommand(this.commandObjects.sortReadonly(str, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> del(String str) {
        return appendCommand(this.commandObjects.del(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> del(String... strArr) {
        return appendCommand(this.commandObjects.del(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> unlink(String str) {
        return appendCommand(this.commandObjects.unlink(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> unlink(String... strArr) {
        return appendCommand(this.commandObjects.unlink(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Boolean> copy(String str, String str2, boolean z) {
        return appendCommand(this.commandObjects.copy(str, str2, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> rename(String str, String str2) {
        return appendCommand(this.commandObjects.rename(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> renamenx(String str, String str2) {
        return appendCommand(this.commandObjects.renamenx(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> memoryUsage(String str) {
        return appendCommand(this.commandObjects.memoryUsage(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> memoryUsage(String str, int i) {
        return appendCommand(this.commandObjects.memoryUsage(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> objectRefcount(String str) {
        return appendCommand(this.commandObjects.objectRefcount(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> objectEncoding(String str) {
        return appendCommand(this.commandObjects.objectEncoding(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> objectIdletime(String str) {
        return appendCommand(this.commandObjects.objectIdletime(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Long> objectFreq(String str) {
        return appendCommand(this.commandObjects.objectFreq(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> migrate(String str, int i, String str2, int i2) {
        return appendCommand(this.commandObjects.migrate(str, i, str2, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> migrate(String str, int i, int i2, MigrateParams migrateParams, String... strArr) {
        return appendCommand(this.commandObjects.migrate(str, i, i2, migrateParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<Set<String>> keys(String str) {
        return appendCommand(this.commandObjects.keys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<ScanResult<String>> scan(String str) {
        return appendCommand(this.commandObjects.scan(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<ScanResult<String>> scan(String str, ScanParams scanParams) {
        return appendCommand(this.commandObjects.scan(str, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<ScanResult<String>> scan(String str, ScanParams scanParams, String str2) {
        return appendCommand(this.commandObjects.scan(str, scanParams, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineCommands
    public Response<String> randomKey() {
        return appendCommand(this.commandObjects.randomKey());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> get(String str) {
        return appendCommand(this.commandObjects.get(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> setGet(String str, String str2, SetParams setParams) {
        return appendCommand(this.commandObjects.setGet(str, str2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> getDel(String str) {
        return appendCommand(this.commandObjects.getDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> getEx(String str, GetExParams getExParams) {
        return appendCommand(this.commandObjects.getEx(str, getExParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Boolean> setbit(String str, long j, boolean z) {
        return appendCommand(this.commandObjects.setbit(str, j, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Boolean> getbit(String str, long j) {
        return appendCommand(this.commandObjects.getbit(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> setrange(String str, long j, String str2) {
        return appendCommand(this.commandObjects.setrange(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> getrange(String str, long j, long j2) {
        return appendCommand(this.commandObjects.getrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> getSet(String str, String str2) {
        return appendCommand(this.commandObjects.getSet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> setnx(String str, String str2) {
        return appendCommand(this.commandObjects.setnx(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> setex(String str, long j, String str2) {
        return appendCommand(this.commandObjects.setex(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> psetex(String str, long j, String str2) {
        return appendCommand(this.commandObjects.psetex(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<List<String>> mget(String... strArr) {
        return appendCommand(this.commandObjects.mget(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> mset(String... strArr) {
        return appendCommand(this.commandObjects.mset(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> msetnx(String... strArr) {
        return appendCommand(this.commandObjects.msetnx(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> incr(String str) {
        return appendCommand(this.commandObjects.incr(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> incrBy(String str, long j) {
        return appendCommand(this.commandObjects.incrBy(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Double> incrByFloat(String str, double d) {
        return appendCommand(this.commandObjects.incrByFloat(str, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> decr(String str) {
        return appendCommand(this.commandObjects.decr(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> decrBy(String str, long j) {
        return appendCommand(this.commandObjects.decrBy(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> append(String str, String str2) {
        return appendCommand(this.commandObjects.append(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> substr(String str, int i, int i2) {
        return appendCommand(this.commandObjects.substr(str, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> strlen(String str) {
        return appendCommand(this.commandObjects.strlen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> bitcount(String str) {
        return appendCommand(this.commandObjects.bitcount(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> bitcount(String str, long j, long j2) {
        return appendCommand(this.commandObjects.bitcount(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> bitcount(String str, long j, long j2, BitCountOption bitCountOption) {
        return appendCommand(this.commandObjects.bitcount(str, j, j2, bitCountOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> bitpos(String str, boolean z) {
        return appendCommand(this.commandObjects.bitpos(str, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> bitpos(String str, boolean z, BitPosParams bitPosParams) {
        return appendCommand(this.commandObjects.bitpos(str, z, bitPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<List<Long>> bitfield(String str, String... strArr) {
        return appendCommand(this.commandObjects.bitfield(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<List<Long>> bitfieldReadonly(String str, String... strArr) {
        return appendCommand(this.commandObjects.bitfieldReadonly(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<Long> bitop(BitOP bitOP, String str, String... strArr) {
        return appendCommand(this.commandObjects.bitop(bitOP, str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<LCSMatchResult> strAlgoLCSKeys(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        return appendCommand(this.commandObjects.strAlgoLCSKeys(str, str2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<LCSMatchResult> lcs(String str, String str2, LCSParams lCSParams) {
        return appendCommand(this.commandObjects.lcs(str, str2, lCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> set(String str, String str2) {
        return appendCommand(this.commandObjects.set(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineCommands
    public Response<String> set(String str, String str2, SetParams setParams) {
        return appendCommand(this.commandObjects.set(str, str2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> rpush(String str, String... strArr) {
        return appendCommand(this.commandObjects.rpush(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> lpush(String str, String... strArr) {
        return appendCommand(this.commandObjects.lpush(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> llen(String str) {
        return appendCommand(this.commandObjects.llen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> lrange(String str, long j, long j2) {
        return appendCommand(this.commandObjects.lrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> ltrim(String str, long j, long j2) {
        return appendCommand(this.commandObjects.ltrim(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> lindex(String str, long j) {
        return appendCommand(this.commandObjects.lindex(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> lset(String str, long j, String str2) {
        return appendCommand(this.commandObjects.lset(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> lrem(String str, long j, String str2) {
        return appendCommand(this.commandObjects.lrem(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> lpop(String str) {
        return appendCommand(this.commandObjects.lpop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> lpop(String str, int i) {
        return appendCommand(this.commandObjects.lpop(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> lpos(String str, String str2) {
        return appendCommand(this.commandObjects.lpos(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> lpos(String str, String str2, LPosParams lPosParams) {
        return appendCommand(this.commandObjects.lpos(str, str2, lPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<Long>> lpos(String str, String str2, LPosParams lPosParams, long j) {
        return appendCommand(this.commandObjects.lpos(str, str2, lPosParams, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> rpop(String str) {
        return appendCommand(this.commandObjects.rpop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> rpop(String str, int i) {
        return appendCommand(this.commandObjects.rpop(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> linsert(String str, ListPosition listPosition, String str2, String str3) {
        return appendCommand(this.commandObjects.linsert(str, listPosition, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> lpushx(String str, String... strArr) {
        return appendCommand(this.commandObjects.lpushx(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<Long> rpushx(String str, String... strArr) {
        return appendCommand(this.commandObjects.rpushx(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> blpop(int i, String str) {
        return appendCommand(this.commandObjects.blpop(i, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyedListElement> blpop(double d, String str) {
        return appendCommand(this.commandObjects.blpop(d, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> brpop(int i, String str) {
        return appendCommand(this.commandObjects.brpop(i, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyedListElement> brpop(double d, String str) {
        return appendCommand(this.commandObjects.brpop(d, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> blpop(int i, String... strArr) {
        return appendCommand(this.commandObjects.blpop(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyedListElement> blpop(double d, String... strArr) {
        return appendCommand(this.commandObjects.blpop(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<List<String>> brpop(int i, String... strArr) {
        return appendCommand(this.commandObjects.brpop(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyedListElement> brpop(double d, String... strArr) {
        return appendCommand(this.commandObjects.brpop(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> rpoplpush(String str, String str2) {
        return appendCommand(this.commandObjects.rpoplpush(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> brpoplpush(String str, String str2, int i) {
        return appendCommand(this.commandObjects.brpoplpush(str, str2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> lmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2) {
        return appendCommand(this.commandObjects.lmove(str, str2, listDirection, listDirection2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<String> blmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2, double d) {
        return appendCommand(this.commandObjects.blmove(str, str2, listDirection, listDirection2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyValue<String, List<String>>> lmpop(ListDirection listDirection, String... strArr) {
        return appendCommand(this.commandObjects.lmpop(listDirection, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyValue<String, List<String>>> lmpop(ListDirection listDirection, int i, String... strArr) {
        return appendCommand(this.commandObjects.lmpop(listDirection, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyValue<String, List<String>>> blmpop(long j, ListDirection listDirection, String... strArr) {
        return appendCommand(this.commandObjects.blmpop(j, listDirection, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineCommands
    public Response<KeyValue<String, List<String>>> blmpop(long j, ListDirection listDirection, int i, String... strArr) {
        return appendCommand(this.commandObjects.blmpop(j, listDirection, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hset(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.hset(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hset(String str, Map<String, String> map) {
        return appendCommand(this.commandObjects.hset(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<String> hget(String str, String str2) {
        return appendCommand(this.commandObjects.hget(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hsetnx(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.hsetnx(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<String> hmset(String str, Map<String, String> map) {
        return appendCommand(this.commandObjects.hmset(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<List<String>> hmget(String str, String... strArr) {
        return appendCommand(this.commandObjects.hmget(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hincrBy(String str, String str2, long j) {
        return appendCommand(this.commandObjects.hincrBy(str, str2, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Double> hincrByFloat(String str, String str2, double d) {
        return appendCommand(this.commandObjects.hincrByFloat(str, str2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Boolean> hexists(String str, String str2) {
        return appendCommand(this.commandObjects.hexists(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hdel(String str, String... strArr) {
        return appendCommand(this.commandObjects.hdel(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hlen(String str) {
        return appendCommand(this.commandObjects.hlen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Set<String>> hkeys(String str) {
        return appendCommand(this.commandObjects.hkeys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<List<String>> hvals(String str) {
        return appendCommand(this.commandObjects.hvals(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Map<String, String>> hgetAll(String str) {
        return appendCommand(this.commandObjects.hgetAll(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<String> hrandfield(String str) {
        return appendCommand(this.commandObjects.hrandfield(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<List<String>> hrandfield(String str, long j) {
        return appendCommand(this.commandObjects.hrandfield(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Map<String, String>> hrandfieldWithValues(String str, long j) {
        return appendCommand(this.commandObjects.hrandfieldWithValues(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<ScanResult<Map.Entry<String, String>>> hscan(String str, String str2, ScanParams scanParams) {
        return appendCommand(this.commandObjects.hscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineCommands
    public Response<Long> hstrlen(String str, String str2) {
        return appendCommand(this.commandObjects.hstrlen(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> sadd(String str, String... strArr) {
        return appendCommand(this.commandObjects.sadd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Set<String>> smembers(String str) {
        return appendCommand(this.commandObjects.smembers(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> srem(String str, String... strArr) {
        return appendCommand(this.commandObjects.srem(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<String> spop(String str) {
        return appendCommand(this.commandObjects.spop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Set<String>> spop(String str, long j) {
        return appendCommand(this.commandObjects.spop(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> scard(String str) {
        return appendCommand(this.commandObjects.scard(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Boolean> sismember(String str, String str2) {
        return appendCommand(this.commandObjects.sismember(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<List<Boolean>> smismember(String str, String... strArr) {
        return appendCommand(this.commandObjects.smismember(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<String> srandmember(String str) {
        return appendCommand(this.commandObjects.srandmember(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<List<String>> srandmember(String str, int i) {
        return appendCommand(this.commandObjects.srandmember(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<ScanResult<String>> sscan(String str, String str2, ScanParams scanParams) {
        return appendCommand(this.commandObjects.sscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Set<String>> sdiff(String... strArr) {
        return appendCommand(this.commandObjects.sdiff(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> sdiffstore(String str, String... strArr) {
        return appendCommand(this.commandObjects.sdiffstore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Set<String>> sinter(String... strArr) {
        return appendCommand(this.commandObjects.sinter(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> sinterstore(String str, String... strArr) {
        return appendCommand(this.commandObjects.sinterstore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> sintercard(String... strArr) {
        return appendCommand(this.commandObjects.sintercard(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> sintercard(int i, String... strArr) {
        return appendCommand(this.commandObjects.sintercard(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Set<String>> sunion(String... strArr) {
        return appendCommand(this.commandObjects.sunion(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> sunionstore(String str, String... strArr) {
        return appendCommand(this.commandObjects.sunionstore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineCommands
    public Response<Long> smove(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.smove(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zadd(String str, double d, String str2) {
        return appendCommand(this.commandObjects.zadd(str, d, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zadd(String str, double d, String str2, ZAddParams zAddParams) {
        return appendCommand(this.commandObjects.zadd(str, d, str2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zadd(String str, Map<String, Double> map) {
        return appendCommand(this.commandObjects.zadd(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zadd(String str, Map<String, Double> map, ZAddParams zAddParams) {
        return appendCommand(this.commandObjects.zadd(str, map, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Double> zaddIncr(String str, double d, String str2, ZAddParams zAddParams) {
        return appendCommand(this.commandObjects.zaddIncr(str, d, str2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zrem(String str, String... strArr) {
        return appendCommand(this.commandObjects.zrem(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Double> zincrby(String str, double d, String str2) {
        return appendCommand(this.commandObjects.zincrby(str, d, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Double> zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams) {
        return appendCommand(this.commandObjects.zincrby(str, d, str2, zIncrByParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zrank(String str, String str2) {
        return appendCommand(this.commandObjects.zrank(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zrevrank(String str, String str2) {
        return appendCommand(this.commandObjects.zrevrank(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrange(String str, long j, long j2) {
        return appendCommand(this.commandObjects.zrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrange(String str, long j, long j2) {
        return appendCommand(this.commandObjects.zrevrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrangeWithScores(String str, long j, long j2) {
        return appendCommand(this.commandObjects.zrangeWithScores(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrevrangeWithScores(String str, long j, long j2) {
        return appendCommand(this.commandObjects.zrevrangeWithScores(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<String> zrandmember(String str) {
        return appendCommand(this.commandObjects.zrandmember(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrandmember(String str, long j) {
        return appendCommand(this.commandObjects.zrandmember(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrandmemberWithScores(String str, long j) {
        return appendCommand(this.commandObjects.zrandmemberWithScores(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zcard(String str) {
        return appendCommand(this.commandObjects.zcard(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Double> zscore(String str, String str2) {
        return appendCommand(this.commandObjects.zscore(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Double>> zmscore(String str, String... strArr) {
        return appendCommand(this.commandObjects.zmscore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Tuple> zpopmax(String str) {
        return appendCommand(this.commandObjects.zpopmax(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zpopmax(String str, int i) {
        return appendCommand(this.commandObjects.zpopmax(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Tuple> zpopmin(String str) {
        return appendCommand(this.commandObjects.zpopmin(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zpopmin(String str, int i) {
        return appendCommand(this.commandObjects.zpopmin(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zcount(String str, double d, double d2) {
        return appendCommand(this.commandObjects.zcount(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zcount(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zcount(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrangeByScore(String str, double d, double d2) {
        return appendCommand(this.commandObjects.zrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrangeByScore(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrangeByScore(String str, double d, double d2) {
        return appendCommand(this.commandObjects.zrevrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrangeByScore(String str, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScore(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrangeByScore(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zrevrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrangeByScore(String str, String str2, String str3, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScore(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrangeByScore(String str, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScore(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(String str, double d, double d2) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(String str, double d, double d2) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrangeByScore(String str, String str2, String str3, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScore(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrange(String str, ZRangeParams zRangeParams) {
        return appendCommand(this.commandObjects.zrange(str, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<Tuple>> zrangeWithScores(String str, ZRangeParams zRangeParams) {
        return appendCommand(this.commandObjects.zrangeWithScores(str, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zrangestore(String str, String str2, ZRangeParams zRangeParams) {
        return appendCommand(this.commandObjects.zrangestore(str, str2, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zremrangeByRank(String str, long j, long j2) {
        return appendCommand(this.commandObjects.zremrangeByRank(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zremrangeByScore(String str, double d, double d2) {
        return appendCommand(this.commandObjects.zremrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zremrangeByScore(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zremrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zlexcount(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zlexcount(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrangeByLex(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrangeByLex(String str, String str2, String str3, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByLex(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrangeByLex(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zrevrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<List<String>> zrevrangeByLex(String str, String str2, String str3, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByLex(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zremrangeByLex(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.zremrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<ScanResult<Tuple>> zscan(String str, String str2, ScanParams scanParams) {
        return appendCommand(this.commandObjects.zscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<KeyedZSetElement> bzpopmax(double d, String... strArr) {
        return appendCommand(this.commandObjects.bzpopmax(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<KeyedZSetElement> bzpopmin(double d, String... strArr) {
        return appendCommand(this.commandObjects.bzpopmin(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<KeyValue<String, List<Tuple>>> zmpop(SortedSetOption sortedSetOption, String... strArr) {
        return appendCommand(this.commandObjects.zmpop(sortedSetOption, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<KeyValue<String, List<Tuple>>> zmpop(SortedSetOption sortedSetOption, int i, String... strArr) {
        return appendCommand(this.commandObjects.zmpop(sortedSetOption, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<KeyValue<String, List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, String... strArr) {
        return appendCommand(this.commandObjects.bzmpop(j, sortedSetOption, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<KeyValue<String, List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, int i, String... strArr) {
        return appendCommand(this.commandObjects.bzmpop(j, sortedSetOption, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Set<String>> zdiff(String... strArr) {
        return appendCommand(this.commandObjects.zdiff(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Set<Tuple>> zdiffWithScores(String... strArr) {
        return appendCommand(this.commandObjects.zdiffWithScores(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zdiffStore(String str, String... strArr) {
        return appendCommand(this.commandObjects.zdiffStore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zinterstore(String str, String... strArr) {
        return appendCommand(this.commandObjects.zinterstore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zinterstore(String str, ZParams zParams, String... strArr) {
        return appendCommand(this.commandObjects.zinterstore(str, zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Set<String>> zinter(ZParams zParams, String... strArr) {
        return appendCommand(this.commandObjects.zinter(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Set<Tuple>> zinterWithScores(ZParams zParams, String... strArr) {
        return appendCommand(this.commandObjects.zinterWithScores(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zintercard(String... strArr) {
        return appendCommand(this.commandObjects.zintercard(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zintercard(long j, String... strArr) {
        return appendCommand(this.commandObjects.zintercard(j, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Set<String>> zunion(ZParams zParams, String... strArr) {
        return appendCommand(this.commandObjects.zunion(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Set<Tuple>> zunionWithScores(ZParams zParams, String... strArr) {
        return appendCommand(this.commandObjects.zunionWithScores(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zunionstore(String str, String... strArr) {
        return appendCommand(this.commandObjects.zunionstore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineCommands
    public Response<Long> zunionstore(String str, ZParams zParams, String... strArr) {
        return appendCommand(this.commandObjects.zunionstore(str, zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geoadd(String str, double d, double d2, String str2) {
        return appendCommand(this.commandObjects.geoadd(str, d, d2, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geoadd(String str, Map<String, GeoCoordinate> map) {
        return appendCommand(this.commandObjects.geoadd(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geoadd(String str, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map) {
        return appendCommand(this.commandObjects.geoadd(str, geoAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Double> geodist(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.geodist(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Double> geodist(String str, String str2, String str3, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geodist(str, str2, str3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<String>> geohash(String str, String... strArr) {
        return appendCommand(this.commandObjects.geohash(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoCoordinate>> geopos(String str, String... strArr) {
        return appendCommand(this.commandObjects.geopos(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadius(str, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadiusReadonly(str, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadius(str, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadiusReadonly(str, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadiusByMember(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadiusByMemberReadonly(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadiusByMember(str, str2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadiusByMemberReadonly(str, str2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> georadiusStore(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return appendCommand(this.commandObjects.georadiusStore(str, d, d2, d3, geoUnit, geoRadiusParam, geoRadiusStoreParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> georadiusByMemberStore(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return appendCommand(this.commandObjects.georadiusByMemberStore(str, str2, d, geoUnit, geoRadiusParam, geoRadiusStoreParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> geosearch(String str, String str2, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> geosearch(String str, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(str, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> geosearch(String str, String str2, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(str, str2, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> geosearch(String str, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(str, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<List<GeoRadiusResponse>> geosearch(String str, GeoSearchParam geoSearchParam) {
        return appendCommand(this.commandObjects.geosearch(str, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geosearchStore(String str, String str2, String str3, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(str, str2, str3, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(str, str2, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geosearchStore(String str, String str2, String str3, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(str, str2, str3, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(str, str2, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geosearchStore(String str, String str2, GeoSearchParam geoSearchParam) {
        return appendCommand(this.commandObjects.geosearchStore(str, str2, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineCommands
    public Response<Long> geosearchStoreStoreDist(String str, String str2, GeoSearchParam geoSearchParam) {
        return appendCommand(this.commandObjects.geosearchStoreStoreDist(str, str2, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineCommands
    public Response<Long> pfadd(String str, String... strArr) {
        return appendCommand(this.commandObjects.pfadd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineCommands
    public Response<String> pfmerge(String str, String... strArr) {
        return appendCommand(this.commandObjects.pfmerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineCommands
    public Response<Long> pfcount(String str) {
        return appendCommand(this.commandObjects.pfcount(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineCommands
    public Response<Long> pfcount(String... strArr) {
        return appendCommand(this.commandObjects.pfcount(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<StreamEntryID> xadd(String str, StreamEntryID streamEntryID, Map<String, String> map) {
        return appendCommand(this.commandObjects.xadd(str, streamEntryID, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<StreamEntryID> xadd(String str, XAddParams xAddParams, Map<String, String> map) {
        return appendCommand(this.commandObjects.xadd(str, xAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xlen(String str) {
        return appendCommand(this.commandObjects.xlen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        return appendCommand(this.commandObjects.xrange(str, streamEntryID, streamEntryID2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return appendCommand(this.commandObjects.xrange(str, streamEntryID, streamEntryID2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        return appendCommand(this.commandObjects.xrevrange(str, streamEntryID, streamEntryID2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return appendCommand(this.commandObjects.xrevrange(str, streamEntryID, streamEntryID2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrange(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.xrange(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrange(String str, String str2, String str3, int i) {
        return appendCommand(this.commandObjects.xrange(str, str2, str3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrevrange(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.xrevrange(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xrevrange(String str, String str2, String str3, int i) {
        return appendCommand(this.commandObjects.xrevrange(str, str2, str3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xack(String str, String str2, StreamEntryID... streamEntryIDArr) {
        return appendCommand(this.commandObjects.xack(str, str2, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<String> xgroupCreate(String str, String str2, StreamEntryID streamEntryID, boolean z) {
        return appendCommand(this.commandObjects.xgroupCreate(str, str2, streamEntryID, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<String> xgroupSetID(String str, String str2, StreamEntryID streamEntryID) {
        return appendCommand(this.commandObjects.xgroupSetID(str, str2, streamEntryID));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xgroupDestroy(String str, String str2) {
        return appendCommand(this.commandObjects.xgroupDestroy(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Boolean> xgroupCreateConsumer(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.xgroupCreateConsumer(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xgroupDelConsumer(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.xgroupDelConsumer(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<StreamPendingSummary> xpending(String str, String str2) {
        return appendCommand(this.commandObjects.xpending(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamPendingEntry>> xpending(String str, String str2, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i, String str3) {
        return appendCommand(this.commandObjects.xpending(str, str2, streamEntryID, streamEntryID2, i, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamPendingEntry>> xpending(String str, String str2, XPendingParams xPendingParams) {
        return appendCommand(this.commandObjects.xpending(str, str2, xPendingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xdel(String str, StreamEntryID... streamEntryIDArr) {
        return appendCommand(this.commandObjects.xdel(str, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xtrim(String str, long j, boolean z) {
        return appendCommand(this.commandObjects.xtrim(str, j, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Long> xtrim(String str, XTrimParams xTrimParams) {
        return appendCommand(this.commandObjects.xtrim(str, xTrimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntry>> xclaim(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        return appendCommand(this.commandObjects.xclaim(str, str2, str3, j, xClaimParams, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamEntryID>> xclaimJustId(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        return appendCommand(this.commandObjects.xclaimJustId(str, str2, str3, j, xClaimParams, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Map.Entry<StreamEntryID, List<StreamEntry>>> xautoclaim(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return appendCommand(this.commandObjects.xautoclaim(str, str2, str3, j, streamEntryID, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<Map.Entry<StreamEntryID, List<StreamEntryID>>> xautoclaimJustId(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return appendCommand(this.commandObjects.xautoclaimJustId(str, str2, str3, j, streamEntryID, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<StreamInfo> xinfoStream(String str) {
        return appendCommand(this.commandObjects.xinfoStream(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<StreamFullInfo> xinfoStreamFull(String str) {
        return appendCommand(this.commandObjects.xinfoStreamFull(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<StreamFullInfo> xinfoStreamFull(String str, int i) {
        return appendCommand(this.commandObjects.xinfoStreamFull(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    @Deprecated
    public Response<List<StreamGroupInfo>> xinfoGroup(String str) {
        return appendCommand(this.commandObjects.xinfoGroup(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamGroupInfo>> xinfoGroups(String str) {
        return appendCommand(this.commandObjects.xinfoGroups(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<StreamConsumersInfo>> xinfoConsumers(String str, String str2) {
        return appendCommand(this.commandObjects.xinfoConsumers(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<Map.Entry<String, List<StreamEntry>>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map) {
        return appendCommand(this.commandObjects.xread(xReadParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineCommands
    public Response<List<Map.Entry<String, List<StreamEntry>>>> xreadGroup(String str, String str2, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map) {
        return appendCommand(this.commandObjects.xreadGroup(str, str2, xReadGroupParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> eval(String str) {
        return appendCommand(this.commandObjects.eval(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> eval(String str, int i, String... strArr) {
        return appendCommand(this.commandObjects.eval(str, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> eval(String str, List<String> list, List<String> list2) {
        return appendCommand(this.commandObjects.eval(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> evalReadonly(String str, List<String> list, List<String> list2) {
        return appendCommand(this.commandObjects.evalReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> evalsha(String str) {
        return appendCommand(this.commandObjects.evalsha(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> evalsha(String str, int i, String... strArr) {
        return appendCommand(this.commandObjects.evalsha(str, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> evalsha(String str, List<String> list, List<String> list2) {
        return appendCommand(this.commandObjects.evalsha(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineCommands
    public Response<Object> evalshaReadonly(String str, List<String> list, List<String> list2) {
        return appendCommand(this.commandObjects.evalshaReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<Long> waitReplicas(String str, int i, long j) {
        return appendCommand(this.commandObjects.waitReplicas(str, i, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<Object> eval(String str, String str2) {
        return appendCommand(this.commandObjects.eval(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<Object> evalsha(String str, String str2) {
        return appendCommand(this.commandObjects.evalsha(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<List<Boolean>> scriptExists(String str, String... strArr) {
        return appendCommand(this.commandObjects.scriptExists(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<String> scriptLoad(String str, String str2) {
        return appendCommand(this.commandObjects.scriptLoad(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<String> scriptFlush(String str) {
        return appendCommand(this.commandObjects.scriptFlush(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<String> scriptFlush(String str, FlushMode flushMode) {
        return appendCommand(this.commandObjects.scriptFlush(str, flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedPipelineCommands
    public Response<String> scriptKill(String str) {
        return appendCommand(this.commandObjects.scriptKill(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<Object> fcall(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return appendCommand(this.commandObjects.fcall(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<Object> fcall(String str, List<String> list, List<String> list2) {
        return appendCommand(this.commandObjects.fcall(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<Object> fcallReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return appendCommand(this.commandObjects.fcallReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<Object> fcallReadonly(String str, List<String> list, List<String> list2) {
        return appendCommand(this.commandObjects.fcallReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<String> functionDelete(byte[] bArr) {
        return appendCommand(this.commandObjects.functionDelete(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionDelete(String str) {
        return appendCommand(this.commandObjects.functionDelete(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<byte[]> functionDump() {
        return appendCommand(this.commandObjects.functionDump());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<List<LibraryInfo>> functionList(String str) {
        return appendCommand(this.commandObjects.functionList(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<List<LibraryInfo>> functionList() {
        return appendCommand(this.commandObjects.functionList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<List<LibraryInfo>> functionListWithCode(String str) {
        return appendCommand(this.commandObjects.functionListWithCode(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<List<LibraryInfo>> functionListWithCode() {
        return appendCommand(this.commandObjects.functionListWithCode());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<List<Object>> functionListBinary() {
        return appendCommand(this.commandObjects.functionListBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<List<Object>> functionList(byte[] bArr) {
        return appendCommand(this.commandObjects.functionList(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<List<Object>> functionListWithCodeBinary() {
        return appendCommand(this.commandObjects.functionListWithCodeBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<List<Object>> functionListWithCode(byte[] bArr) {
        return appendCommand(this.commandObjects.functionListWithCode(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<String> functionLoad(byte[] bArr) {
        return appendCommand(this.commandObjects.functionLoad(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionLoad(String str) {
        return appendCommand(this.commandObjects.functionLoad(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<String> functionLoadReplace(byte[] bArr) {
        return appendCommand(this.commandObjects.functionLoadReplace(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionLoadReplace(String str) {
        return appendCommand(this.commandObjects.functionLoadReplace(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionRestore(byte[] bArr) {
        return appendCommand(this.commandObjects.functionRestore(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy) {
        return appendCommand(this.commandObjects.functionRestore(bArr, functionRestorePolicy));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionFlush() {
        return appendCommand(this.commandObjects.functionFlush());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionFlush(FlushMode flushMode) {
        return appendCommand(this.commandObjects.functionFlush(flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<String> functionKill() {
        return appendCommand(this.commandObjects.functionKill());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineCommands
    public Response<FunctionStats> functionStats() {
        return appendCommand(this.commandObjects.functionStats());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionPipelineBinaryCommands
    public Response<Object> functionStatsBinary() {
        return appendCommand(this.commandObjects.functionStatsBinary());
    }

    public Response<Long> publish(String str, String str2) {
        return appendCommand(this.commandObjects.publish(str, str2));
    }

    public Response<LCSMatchResult> strAlgoLCSStrings(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        return appendCommand(this.commandObjects.strAlgoLCSStrings(str, str2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geoadd(byte[] bArr, double d, double d2, byte[] bArr2) {
        return appendCommand(this.commandObjects.geoadd(bArr, d, d2, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geoadd(byte[] bArr, Map<byte[], GeoCoordinate> map) {
        return appendCommand(this.commandObjects.geoadd(bArr, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geoadd(byte[] bArr, GeoAddParams geoAddParams, Map<byte[], GeoCoordinate> map) {
        return appendCommand(this.commandObjects.geoadd(bArr, geoAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Double> geodist(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.geodist(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Double> geodist(byte[] bArr, byte[] bArr2, byte[] bArr3, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geodist(bArr, bArr2, bArr3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<byte[]>> geohash(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.geohash(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoCoordinate>> geopos(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.geopos(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadius(bArr, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadiusReadonly(bArr, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadius(bArr, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadiusReadonly(bArr, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadiusByMember(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.georadiusByMemberReadonly(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadiusByMember(bArr, bArr2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return appendCommand(this.commandObjects.georadiusByMemberReadonly(bArr, bArr2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> georadiusStore(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return appendCommand(this.commandObjects.georadiusStore(bArr, d, d2, d3, geoUnit, geoRadiusParam, geoRadiusStoreParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> georadiusByMemberStore(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return appendCommand(this.commandObjects.georadiusByMemberStore(bArr, bArr2, d, geoUnit, geoRadiusParam, geoRadiusStoreParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(bArr, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, byte[] bArr2, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(bArr, bArr2, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearch(bArr, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<List<GeoRadiusResponse>> geosearch(byte[] bArr, GeoSearchParam geoSearchParam) {
        return appendCommand(this.commandObjects.geosearch(bArr, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(bArr, bArr2, bArr3, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(bArr, bArr2, bArr3, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return appendCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geosearchStore(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        return appendCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoPipelineBinaryCommands
    public Response<Long> geosearchStoreStoreDist(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        return appendCommand(this.commandObjects.geosearchStoreStoreDist(bArr, bArr2, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hset(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.hset(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hset(byte[] bArr, Map<byte[], byte[]> map) {
        return appendCommand(this.commandObjects.hset(bArr, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<byte[]> hget(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.hget(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hsetnx(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.hsetnx(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<String> hmset(byte[] bArr, Map<byte[], byte[]> map) {
        return appendCommand(this.commandObjects.hmset(bArr, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<List<byte[]>> hmget(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.hmget(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hincrBy(byte[] bArr, byte[] bArr2, long j) {
        return appendCommand(this.commandObjects.hincrBy(bArr, bArr2, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Double> hincrByFloat(byte[] bArr, byte[] bArr2, double d) {
        return appendCommand(this.commandObjects.hincrByFloat(bArr, bArr2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Boolean> hexists(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.hexists(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hdel(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.hdel(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hlen(byte[] bArr) {
        return appendCommand(this.commandObjects.hlen(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Set<byte[]>> hkeys(byte[] bArr) {
        return appendCommand(this.commandObjects.hkeys(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<List<byte[]>> hvals(byte[] bArr) {
        return appendCommand(this.commandObjects.hvals(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Map<byte[], byte[]>> hgetAll(byte[] bArr) {
        return appendCommand(this.commandObjects.hgetAll(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<byte[]> hrandfield(byte[] bArr) {
        return appendCommand(this.commandObjects.hrandfield(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<List<byte[]>> hrandfield(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.hrandfield(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Map<byte[], byte[]>> hrandfieldWithValues(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.hrandfieldWithValues(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<ScanResult<Map.Entry<byte[], byte[]>>> hscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return appendCommand(this.commandObjects.hscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashPipelineBinaryCommands
    public Response<Long> hstrlen(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.hstrlen(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineBinaryCommands
    public Response<Long> pfadd(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.pfadd(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineBinaryCommands
    public Response<String> pfmerge(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.pfmerge(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineBinaryCommands
    public Response<Long> pfcount(byte[] bArr) {
        return appendCommand(this.commandObjects.pfcount(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogPipelineBinaryCommands
    public Response<Long> pfcount(byte[]... bArr) {
        return appendCommand(this.commandObjects.pfcount(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Boolean> exists(byte[] bArr) {
        return appendCommand(this.commandObjects.exists(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> exists(byte[]... bArr) {
        return appendCommand(this.commandObjects.exists(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> persist(byte[] bArr) {
        return appendCommand(this.commandObjects.persist(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<String> type(byte[] bArr) {
        return appendCommand(this.commandObjects.type(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<byte[]> dump(byte[] bArr) {
        return appendCommand(this.commandObjects.dump(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<String> restore(byte[] bArr, long j, byte[] bArr2) {
        return appendCommand(this.commandObjects.restore(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<String> restore(byte[] bArr, long j, byte[] bArr2, RestoreParams restoreParams) {
        return appendCommand(this.commandObjects.restore(bArr, j, bArr2, restoreParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> expire(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.expire(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> expire(byte[] bArr, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.expire(bArr, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> pexpire(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.pexpire(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> pexpire(byte[] bArr, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.pexpire(bArr, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> expireTime(byte[] bArr) {
        return appendCommand(this.commandObjects.expireTime(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> pexpireTime(byte[] bArr) {
        return appendCommand(this.commandObjects.pexpireTime(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> expireAt(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.expireAt(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> expireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.expireAt(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> pexpireAt(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.pexpireAt(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> pexpireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        return appendCommand(this.commandObjects.pexpireAt(bArr, j, expiryOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> ttl(byte[] bArr) {
        return appendCommand(this.commandObjects.ttl(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> pttl(byte[] bArr) {
        return appendCommand(this.commandObjects.pttl(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> touch(byte[] bArr) {
        return appendCommand(this.commandObjects.touch(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> touch(byte[]... bArr) {
        return appendCommand(this.commandObjects.touch(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<List<byte[]>> sort(byte[] bArr) {
        return appendCommand(this.commandObjects.sort(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<List<byte[]>> sort(byte[] bArr, SortingParams sortingParams) {
        return appendCommand(this.commandObjects.sort(bArr, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<List<byte[]>> sortReadonly(byte[] bArr, SortingParams sortingParams) {
        return appendCommand(this.commandObjects.sortReadonly(bArr, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> del(byte[] bArr) {
        return appendCommand(this.commandObjects.del(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> del(byte[]... bArr) {
        return appendCommand(this.commandObjects.del(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> unlink(byte[] bArr) {
        return appendCommand(this.commandObjects.unlink(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> unlink(byte[]... bArr) {
        return appendCommand(this.commandObjects.unlink(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Boolean> copy(byte[] bArr, byte[] bArr2, boolean z) {
        return appendCommand(this.commandObjects.copy(bArr, bArr2, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<String> rename(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.rename(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> renamenx(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.renamenx(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2) {
        return appendCommand(this.commandObjects.sort(bArr, sortingParams, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> sort(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.sort(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> memoryUsage(byte[] bArr) {
        return appendCommand(this.commandObjects.memoryUsage(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> memoryUsage(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.memoryUsage(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> objectRefcount(byte[] bArr) {
        return appendCommand(this.commandObjects.objectRefcount(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<byte[]> objectEncoding(byte[] bArr) {
        return appendCommand(this.commandObjects.objectEncoding(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> objectIdletime(byte[] bArr) {
        return appendCommand(this.commandObjects.objectIdletime(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Long> objectFreq(byte[] bArr) {
        return appendCommand(this.commandObjects.objectFreq(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<String> migrate(String str, int i, byte[] bArr, int i2) {
        return appendCommand(this.commandObjects.migrate(str, i, bArr, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<String> migrate(String str, int i, int i2, MigrateParams migrateParams, byte[]... bArr) {
        return appendCommand(this.commandObjects.migrate(str, i, i2, migrateParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<Set<byte[]>> keys(byte[] bArr) {
        return appendCommand(this.commandObjects.keys(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<ScanResult<byte[]>> scan(byte[] bArr) {
        return appendCommand(this.commandObjects.scan(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams) {
        return appendCommand(this.commandObjects.scan(bArr, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2) {
        return appendCommand(this.commandObjects.scan(bArr, scanParams, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyPipelineBinaryCommands
    public Response<byte[]> randomBinaryKey() {
        return appendCommand(this.commandObjects.randomBinaryKey());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> rpush(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.rpush(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> lpush(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.lpush(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> llen(byte[] bArr) {
        return appendCommand(this.commandObjects.llen(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> lrange(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.lrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<String> ltrim(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.ltrim(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> lindex(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.lindex(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<String> lset(byte[] bArr, long j, byte[] bArr2) {
        return appendCommand(this.commandObjects.lset(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> lrem(byte[] bArr, long j, byte[] bArr2) {
        return appendCommand(this.commandObjects.lrem(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> lpop(byte[] bArr) {
        return appendCommand(this.commandObjects.lpop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> lpop(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.lpop(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> lpos(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.lpos(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams) {
        return appendCommand(this.commandObjects.lpos(bArr, bArr2, lPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<Long>> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams, long j) {
        return appendCommand(this.commandObjects.lpos(bArr, bArr2, lPosParams, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> rpop(byte[] bArr) {
        return appendCommand(this.commandObjects.rpop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> rpop(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.rpop(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> linsert(byte[] bArr, ListPosition listPosition, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.linsert(bArr, listPosition, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> lpushx(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.lpushx(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<Long> rpushx(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.rpushx(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> blpop(int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.blpop(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> blpop(double d, byte[]... bArr) {
        return appendCommand(this.commandObjects.blpop(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> brpop(int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.brpop(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<List<byte[]>> brpop(double d, byte[]... bArr) {
        return appendCommand(this.commandObjects.brpop(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> rpoplpush(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.rpoplpush(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> brpoplpush(byte[] bArr, byte[] bArr2, int i) {
        return appendCommand(this.commandObjects.brpoplpush(bArr, bArr2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> lmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2) {
        return appendCommand(this.commandObjects.lmove(bArr, bArr2, listDirection, listDirection2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<byte[]> blmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2, double d) {
        return appendCommand(this.commandObjects.blmove(bArr, bArr2, listDirection, listDirection2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection listDirection, byte[]... bArr) {
        return appendCommand(this.commandObjects.lmpop(listDirection, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection listDirection, int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.lmpop(listDirection, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<KeyValue<byte[], List<byte[]>>> blmpop(long j, ListDirection listDirection, byte[]... bArr) {
        return appendCommand(this.commandObjects.blmpop(j, listDirection, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListPipelineBinaryCommands
    public Response<KeyValue<byte[], List<byte[]>>> blmpop(long j, ListDirection listDirection, int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.blmpop(j, listDirection, i, bArr));
    }

    public Response<Long> publish(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.publish(bArr, bArr2));
    }

    public Response<LCSMatchResult> strAlgoLCSStrings(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        return appendCommand(this.commandObjects.strAlgoLCSStrings(bArr, bArr2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<Long> waitReplicas(byte[] bArr, int i, long j) {
        return appendCommand(this.commandObjects.waitReplicas(bArr, i, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<Object> eval(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.eval(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<Object> evalsha(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.evalsha(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<List<Boolean>> scriptExists(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.scriptExists(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<byte[]> scriptLoad(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.scriptLoad(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<String> scriptFlush(byte[] bArr) {
        return appendCommand(this.commandObjects.scriptFlush(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<String> scriptFlush(byte[] bArr, FlushMode flushMode) {
        return appendCommand(this.commandObjects.scriptFlush(bArr, flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedPipelineCommands
    public Response<String> scriptKill(byte[] bArr) {
        return appendCommand(this.commandObjects.scriptKill(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> eval(byte[] bArr) {
        return appendCommand(this.commandObjects.eval(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> eval(byte[] bArr, int i, byte[]... bArr2) {
        return appendCommand(this.commandObjects.eval(bArr, i, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> eval(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return appendCommand(this.commandObjects.eval(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> evalReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return appendCommand(this.commandObjects.evalReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> evalsha(byte[] bArr) {
        return appendCommand(this.commandObjects.evalsha(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> evalsha(byte[] bArr, int i, byte[]... bArr2) {
        return appendCommand(this.commandObjects.evalsha(bArr, i, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return appendCommand(this.commandObjects.evalsha(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyPipelineBinaryCommands
    public Response<Object> evalshaReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return appendCommand(this.commandObjects.evalshaReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> sadd(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.sadd(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Set<byte[]>> smembers(byte[] bArr) {
        return appendCommand(this.commandObjects.smembers(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> srem(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.srem(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<byte[]> spop(byte[] bArr) {
        return appendCommand(this.commandObjects.spop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Set<byte[]>> spop(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.spop(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> scard(byte[] bArr) {
        return appendCommand(this.commandObjects.scard(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Boolean> sismember(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.sismember(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<List<Boolean>> smismember(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.smismember(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<byte[]> srandmember(byte[] bArr) {
        return appendCommand(this.commandObjects.srandmember(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<List<byte[]>> srandmember(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.srandmember(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<ScanResult<byte[]>> sscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return appendCommand(this.commandObjects.sscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Set<byte[]>> sdiff(byte[]... bArr) {
        return appendCommand(this.commandObjects.sdiff(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> sdiffstore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.sdiffstore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Set<byte[]>> sinter(byte[]... bArr) {
        return appendCommand(this.commandObjects.sinter(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> sinterstore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.sinterstore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> sintercard(byte[]... bArr) {
        return appendCommand(this.commandObjects.sintercard(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> sintercard(int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.sintercard(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Set<byte[]>> sunion(byte[]... bArr) {
        return appendCommand(this.commandObjects.sunion(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> sunionstore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.sunionstore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetPipelineBinaryCommands
    public Response<Long> smove(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.smove(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zadd(byte[] bArr, double d, byte[] bArr2) {
        return appendCommand(this.commandObjects.zadd(bArr, d, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zadd(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        return appendCommand(this.commandObjects.zadd(bArr, d, bArr2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zadd(byte[] bArr, Map<byte[], Double> map) {
        return appendCommand(this.commandObjects.zadd(bArr, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zadd(byte[] bArr, Map<byte[], Double> map, ZAddParams zAddParams) {
        return appendCommand(this.commandObjects.zadd(bArr, map, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Double> zaddIncr(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        return appendCommand(this.commandObjects.zaddIncr(bArr, d, bArr2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zrem(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zrem(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Double> zincrby(byte[] bArr, double d, byte[] bArr2) {
        return appendCommand(this.commandObjects.zincrby(bArr, d, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Double> zincrby(byte[] bArr, double d, byte[] bArr2, ZIncrByParams zIncrByParams) {
        return appendCommand(this.commandObjects.zincrby(bArr, d, bArr2, zIncrByParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zrank(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.zrank(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zrevrank(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.zrevrank(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrange(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.zrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrange(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.zrevrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrangeWithScores(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.zrangeWithScores(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrevrangeWithScores(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.zrevrangeWithScores(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<byte[]> zrandmember(byte[] bArr) {
        return appendCommand(this.commandObjects.zrandmember(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrandmember(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.zrandmember(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrandmemberWithScores(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.zrandmemberWithScores(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zcard(byte[] bArr) {
        return appendCommand(this.commandObjects.zcard(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Double> zscore(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.zscore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Double>> zmscore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zmscore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Tuple> zpopmax(byte[] bArr) {
        return appendCommand(this.commandObjects.zpopmax(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zpopmax(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.zpopmax(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Tuple> zpopmin(byte[] bArr) {
        return appendCommand(this.commandObjects.zpopmin(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zpopmin(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.zpopmin(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zcount(byte[] bArr, double d, double d2) {
        return appendCommand(this.commandObjects.zcount(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zcount(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrangeByScore(byte[] bArr, double d, double d2) {
        return appendCommand(this.commandObjects.zrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrangeByScore(byte[] bArr, double d, double d2) {
        return appendCommand(this.commandObjects.zrevrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScore(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zrevrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScore(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScore(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScore(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zremrangeByRank(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.zremrangeByRank(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zremrangeByScore(byte[] bArr, double d, double d2) {
        return appendCommand(this.commandObjects.zremrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zremrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zremrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zlexcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zlexcount(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return appendCommand(this.commandObjects.zrangeByLex(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zrevrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return appendCommand(this.commandObjects.zrevrangeByLex(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> zrange(byte[] bArr, ZRangeParams zRangeParams) {
        return appendCommand(this.commandObjects.zrange(bArr, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<Tuple>> zrangeWithScores(byte[] bArr, ZRangeParams zRangeParams) {
        return appendCommand(this.commandObjects.zrangeWithScores(bArr, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zrangestore(byte[] bArr, byte[] bArr2, ZRangeParams zRangeParams) {
        return appendCommand(this.commandObjects.zrangestore(bArr, bArr2, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zremrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.zremrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<ScanResult<Tuple>> zscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return appendCommand(this.commandObjects.zscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> bzpopmax(double d, byte[]... bArr) {
        return appendCommand(this.commandObjects.bzpopmax(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<List<byte[]>> bzpopmin(double d, byte[]... bArr) {
        return appendCommand(this.commandObjects.bzpopmin(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<KeyValue<byte[], List<Tuple>>> zmpop(SortedSetOption sortedSetOption, byte[]... bArr) {
        return appendCommand(this.commandObjects.zmpop(sortedSetOption, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<KeyValue<byte[], List<Tuple>>> zmpop(SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.zmpop(sortedSetOption, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<KeyValue<byte[], List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, byte[]... bArr) {
        return appendCommand(this.commandObjects.bzmpop(j, sortedSetOption, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<KeyValue<byte[], List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        return appendCommand(this.commandObjects.bzmpop(j, sortedSetOption, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Set<byte[]>> zdiff(byte[]... bArr) {
        return appendCommand(this.commandObjects.zdiff(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Set<Tuple>> zdiffWithScores(byte[]... bArr) {
        return appendCommand(this.commandObjects.zdiffWithScores(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zdiffStore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zdiffStore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Set<byte[]>> zinter(ZParams zParams, byte[]... bArr) {
        return appendCommand(this.commandObjects.zinter(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Set<Tuple>> zinterWithScores(ZParams zParams, byte[]... bArr) {
        return appendCommand(this.commandObjects.zinterWithScores(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zinterstore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zinterstore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zinterstore(bArr, zParams, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zintercard(byte[]... bArr) {
        return appendCommand(this.commandObjects.zintercard(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zintercard(long j, byte[]... bArr) {
        return appendCommand(this.commandObjects.zintercard(j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Set<byte[]>> zunion(ZParams zParams, byte[]... bArr) {
        return appendCommand(this.commandObjects.zunion(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Set<Tuple>> zunionWithScores(ZParams zParams, byte[]... bArr) {
        return appendCommand(this.commandObjects.zunionWithScores(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zunionstore(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zunionstore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetPipelineBinaryCommands
    public Response<Long> zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        return appendCommand(this.commandObjects.zunionstore(bArr, zParams, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<byte[]> xadd(byte[] bArr, XAddParams xAddParams, Map<byte[], byte[]> map) {
        return appendCommand(this.commandObjects.xadd(bArr, xAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xlen(byte[] bArr) {
        return appendCommand(this.commandObjects.xlen(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.xrange(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return appendCommand(this.commandObjects.xrange(bArr, bArr2, bArr3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.xrevrange(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return appendCommand(this.commandObjects.xrevrange(bArr, bArr2, bArr3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xack(byte[] bArr, byte[] bArr2, byte[]... bArr3) {
        return appendCommand(this.commandObjects.xack(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<String> xgroupCreate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        return appendCommand(this.commandObjects.xgroupCreate(bArr, bArr2, bArr3, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<String> xgroupSetID(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.xgroupSetID(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xgroupDestroy(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.xgroupDestroy(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Boolean> xgroupCreateConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.xgroupCreateConsumer(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xgroupDelConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return appendCommand(this.commandObjects.xgroupDelConsumer(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xdel(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.xdel(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xtrim(byte[] bArr, long j, boolean z) {
        return appendCommand(this.commandObjects.xtrim(bArr, j, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Long> xtrim(byte[] bArr, XTrimParams xTrimParams) {
        return appendCommand(this.commandObjects.xtrim(bArr, xTrimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Object> xpending(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.xpending(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<Object>> xpending(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) {
        return appendCommand(this.commandObjects.xpending(bArr, bArr2, bArr3, bArr4, i, bArr5));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<Object>> xpending(byte[] bArr, byte[] bArr2, XPendingParams xPendingParams) {
        return appendCommand(this.commandObjects.xpending(bArr, bArr2, xPendingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        return appendCommand(this.commandObjects.xclaim(bArr, bArr2, bArr3, j, xClaimParams, bArr4));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        return appendCommand(this.commandObjects.xclaimJustId(bArr, bArr2, bArr3, j, xClaimParams, bArr4));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<Object>> xautoclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        return appendCommand(this.commandObjects.xautoclaim(bArr, bArr2, bArr3, j, bArr4, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<Object>> xautoclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        return appendCommand(this.commandObjects.xautoclaimJustId(bArr, bArr2, bArr3, j, bArr4, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Object> xinfoStream(byte[] bArr) {
        return appendCommand(this.commandObjects.xinfoStream(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Object> xinfoStreamFull(byte[] bArr) {
        return appendCommand(this.commandObjects.xinfoStreamFull(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<Object> xinfoStreamFull(byte[] bArr, int i) {
        return appendCommand(this.commandObjects.xinfoStreamFull(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    @Deprecated
    public Response<List<Object>> xinfoGroup(byte[] bArr) {
        return appendCommand(this.commandObjects.xinfoGroup(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<Object>> xinfoGroups(byte[] bArr) {
        return appendCommand(this.commandObjects.xinfoGroups(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<Object>> xinfoConsumers(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.xinfoConsumers(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xread(XReadParams xReadParams, Map.Entry<byte[], byte[]>... entryArr) {
        return appendCommand(this.commandObjects.xread(xReadParams, entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamPipelineBinaryCommands
    public Response<List<byte[]>> xreadGroup(byte[] bArr, byte[] bArr2, XReadGroupParams xReadGroupParams, Map.Entry<byte[], byte[]>... entryArr) {
        return appendCommand(this.commandObjects.xreadGroup(bArr, bArr2, xReadGroupParams, entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<String> set(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.set(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<String> set(byte[] bArr, byte[] bArr2, SetParams setParams) {
        return appendCommand(this.commandObjects.set(bArr, bArr2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> get(byte[] bArr) {
        return appendCommand(this.commandObjects.get(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> setGet(byte[] bArr, byte[] bArr2, SetParams setParams) {
        return appendCommand(this.commandObjects.setGet(bArr, bArr2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> getDel(byte[] bArr) {
        return appendCommand(this.commandObjects.getDel(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> getEx(byte[] bArr, GetExParams getExParams) {
        return appendCommand(this.commandObjects.getEx(bArr, getExParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Boolean> setbit(byte[] bArr, long j, boolean z) {
        return appendCommand(this.commandObjects.setbit(bArr, j, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Boolean> getbit(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.getbit(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> setrange(byte[] bArr, long j, byte[] bArr2) {
        return appendCommand(this.commandObjects.setrange(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> getrange(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.getrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> getSet(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.getSet(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> setnx(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.setnx(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<String> setex(byte[] bArr, long j, byte[] bArr2) {
        return appendCommand(this.commandObjects.setex(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<String> psetex(byte[] bArr, long j, byte[] bArr2) {
        return appendCommand(this.commandObjects.psetex(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<List<byte[]>> mget(byte[]... bArr) {
        return appendCommand(this.commandObjects.mget(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<String> mset(byte[]... bArr) {
        return appendCommand(this.commandObjects.mset(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> msetnx(byte[]... bArr) {
        return appendCommand(this.commandObjects.msetnx(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> incr(byte[] bArr) {
        return appendCommand(this.commandObjects.incr(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> incrBy(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.incrBy(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Double> incrByFloat(byte[] bArr, double d) {
        return appendCommand(this.commandObjects.incrByFloat(bArr, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> decr(byte[] bArr) {
        return appendCommand(this.commandObjects.decr(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> decrBy(byte[] bArr, long j) {
        return appendCommand(this.commandObjects.decrBy(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> append(byte[] bArr, byte[] bArr2) {
        return appendCommand(this.commandObjects.append(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<byte[]> substr(byte[] bArr, int i, int i2) {
        return appendCommand(this.commandObjects.substr(bArr, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> strlen(byte[] bArr) {
        return appendCommand(this.commandObjects.strlen(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> bitcount(byte[] bArr) {
        return appendCommand(this.commandObjects.bitcount(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> bitcount(byte[] bArr, long j, long j2) {
        return appendCommand(this.commandObjects.bitcount(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> bitcount(byte[] bArr, long j, long j2, BitCountOption bitCountOption) {
        return appendCommand(this.commandObjects.bitcount(bArr, j, j2, bitCountOption));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> bitpos(byte[] bArr, boolean z) {
        return appendCommand(this.commandObjects.bitpos(bArr, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> bitpos(byte[] bArr, boolean z, BitPosParams bitPosParams) {
        return appendCommand(this.commandObjects.bitpos(bArr, z, bitPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<List<Long>> bitfield(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.bitfield(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<List<Long>> bitfieldReadonly(byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.bitfieldReadonly(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<Long> bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2) {
        return appendCommand(this.commandObjects.bitop(bitOP, bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<LCSMatchResult> strAlgoLCSKeys(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        return appendCommand(this.commandObjects.strAlgoLCSKeys(bArr, bArr2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftCreate(String str, IndexOptions indexOptions, Schema schema) {
        return appendCommand(this.commandObjects.ftCreate(str, indexOptions, schema));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftCreate(String str, FTCreateParams fTCreateParams, Iterable<SchemaField> iterable) {
        return appendCommand(this.commandObjects.ftCreate(str, fTCreateParams, iterable));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftAlter(String str, Schema schema) {
        return appendCommand(this.commandObjects.ftAlter(str, schema));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftAlter(String str, Iterable<SchemaField> iterable) {
        return appendCommand(this.commandObjects.ftAlter(str, iterable));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<SearchResult> ftSearch(String str, String str2) {
        return appendCommand(this.commandObjects.ftSearch(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<SearchResult> ftSearch(String str, String str2, FTSearchParams fTSearchParams) {
        return appendCommand(this.commandObjects.ftSearch(str, str2, fTSearchParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<SearchResult> ftSearch(String str, Query query) {
        return appendCommand(this.commandObjects.ftSearch(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<SearchResult> ftSearch(byte[] bArr, Query query) {
        return appendCommand(this.commandObjects.ftSearch(bArr, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftExplain(String str, Query query) {
        return appendCommand(this.commandObjects.ftExplain(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<List<String>> ftExplainCLI(String str, Query query) {
        return appendCommand(this.commandObjects.ftExplainCLI(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<AggregationResult> ftAggregate(String str, AggregationBuilder aggregationBuilder) {
        return appendCommand(this.commandObjects.ftAggregate(str, aggregationBuilder));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<AggregationResult> ftCursorRead(String str, long j, int i) {
        return appendCommand(this.commandObjects.ftCursorRead(str, j, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftCursorDel(String str, long j) {
        return appendCommand(this.commandObjects.ftCursorDel(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftDropIndex(String str) {
        return appendCommand(this.commandObjects.ftDropIndex(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftDropIndexDD(String str) {
        return appendCommand(this.commandObjects.ftDropIndexDD(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftSynUpdate(String str, String str2, String... strArr) {
        return appendCommand(this.commandObjects.ftSynUpdate(str, str2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Map<String, List<String>>> ftSynDump(String str) {
        return appendCommand(this.commandObjects.ftSynDump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftDictAdd(String str, String... strArr) {
        return appendCommand(this.commandObjects.ftDictAdd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftDictDel(String str, String... strArr) {
        return appendCommand(this.commandObjects.ftDictDel(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Set<String>> ftDictDump(String str) {
        return appendCommand(this.commandObjects.ftDictDump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftDictAddBySampleKey(String str, String str2, String... strArr) {
        return appendCommand(this.commandObjects.ftDictAddBySampleKey(str, str2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftDictDelBySampleKey(String str, String str2, String... strArr) {
        return appendCommand(this.commandObjects.ftDictDelBySampleKey(str, str2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Set<String>> ftDictDumpBySampleKey(String str, String str2) {
        return appendCommand(this.commandObjects.ftDictDumpBySampleKey(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Map<String, Object>> ftInfo(String str) {
        return appendCommand(this.commandObjects.ftInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Set<String>> ftTagVals(String str, String str2) {
        return appendCommand(this.commandObjects.ftTagVals(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftAliasAdd(String str, String str2) {
        return appendCommand(this.commandObjects.ftAliasAdd(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftAliasUpdate(String str, String str2) {
        return appendCommand(this.commandObjects.ftAliasUpdate(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftAliasDel(String str) {
        return appendCommand(this.commandObjects.ftAliasDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Map<String, String>> ftConfigGet(String str) {
        return appendCommand(this.commandObjects.ftConfigGet(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Map<String, String>> ftConfigGet(String str, String str2) {
        return appendCommand(this.commandObjects.ftConfigGet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftConfigSet(String str, String str2) {
        return appendCommand(this.commandObjects.ftConfigSet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<String> ftConfigSet(String str, String str2, String str3) {
        return appendCommand(this.commandObjects.ftConfigSet(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftSugAdd(String str, String str2, double d) {
        return appendCommand(this.commandObjects.ftSugAdd(str, str2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftSugAddIncr(String str, String str2, double d) {
        return appendCommand(this.commandObjects.ftSugAddIncr(str, str2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<List<String>> ftSugGet(String str, String str2) {
        return appendCommand(this.commandObjects.ftSugGet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<List<String>> ftSugGet(String str, String str2, boolean z, int i) {
        return appendCommand(this.commandObjects.ftSugGet(str, str2, z, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<List<Tuple>> ftSugGetWithScores(String str, String str2) {
        return appendCommand(this.commandObjects.ftSugGetWithScores(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<List<Tuple>> ftSugGetWithScores(String str, String str2, boolean z, int i) {
        return appendCommand(this.commandObjects.ftSugGetWithScores(str, str2, z, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Boolean> ftSugDel(String str, String str2) {
        return appendCommand(this.commandObjects.ftSugDel(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands
    public Response<Long> ftSugLen(String str) {
        return appendCommand(this.commandObjects.ftSugLen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringPipelineBinaryCommands
    public Response<LCSMatchResult> lcs(byte[] bArr, byte[] bArr2, LCSParams lCSParams) {
        return appendCommand(this.commandObjects.lcs(bArr, bArr2, lCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonSet(String str, Path2 path2, Object obj) {
        return appendCommand(this.commandObjects.jsonSet(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonSetWithEscape(String str, Path2 path2, Object obj) {
        return appendCommand(this.commandObjects.jsonSetWithEscape(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonSet(String str, Path path, Object obj) {
        return appendCommand(this.commandObjects.jsonSet(str, path, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonSet(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams) {
        return appendCommand(this.commandObjects.jsonSet(str, path2, obj, jsonSetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonSetWithEscape(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams) {
        return appendCommand(this.commandObjects.jsonSetWithEscape(str, path2, obj, jsonSetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonSet(String str, Path path, Object obj, JsonSetParams jsonSetParams) {
        return appendCommand(this.commandObjects.jsonSet(str, path, obj, jsonSetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Object> jsonGet(String str) {
        return appendCommand(this.commandObjects.jsonGet(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public <T> Response<T> jsonGet(String str, Class<T> cls) {
        return appendCommand(this.commandObjects.jsonGet(str, cls));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Object> jsonGet(String str, Path2... path2Arr) {
        return appendCommand(this.commandObjects.jsonGet(str, path2Arr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Object> jsonGet(String str, Path... pathArr) {
        return appendCommand(this.commandObjects.jsonGet(str, pathArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public <T> Response<T> jsonGet(String str, Class<T> cls, Path... pathArr) {
        return appendCommand(this.commandObjects.jsonGet(str, cls, pathArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<JSONArray>> jsonMGet(Path2 path2, String... strArr) {
        return appendCommand(this.commandObjects.jsonMGet(path2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public <T> Response<List<T>> jsonMGet(Path path, Class<T> cls, String... strArr) {
        return appendCommand(this.commandObjects.jsonMGet(path, cls, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonDel(String str) {
        return appendCommand(this.commandObjects.jsonDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonDel(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonDel(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonDel(String str, Path path) {
        return appendCommand(this.commandObjects.jsonDel(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonClear(String str) {
        return appendCommand(this.commandObjects.jsonClear(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonClear(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonClear(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonClear(String str, Path path) {
        return appendCommand(this.commandObjects.jsonClear(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Boolean>> jsonToggle(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonToggle(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<String> jsonToggle(String str, Path path) {
        return appendCommand(this.commandObjects.jsonToggle(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Class<?>> jsonType(String str) {
        return appendCommand(this.commandObjects.jsonType(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Class<?>>> jsonType(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonType(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Class<?>> jsonType(String str, Path path) {
        return appendCommand(this.commandObjects.jsonType(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonStrAppend(String str, Object obj) {
        return appendCommand(this.commandObjects.jsonStrAppend(str, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonStrAppend(String str, Path2 path2, Object obj) {
        return appendCommand(this.commandObjects.jsonStrAppend(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonStrAppend(String str, Path path, Object obj) {
        return appendCommand(this.commandObjects.jsonStrAppend(str, path, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonStrLen(String str) {
        return appendCommand(this.commandObjects.jsonStrLen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonStrLen(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonStrLen(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonStrLen(String str, Path path) {
        return appendCommand(this.commandObjects.jsonStrLen(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<JSONArray> jsonNumIncrBy(String str, Path2 path2, double d) {
        return appendCommand(this.commandObjects.jsonNumIncrBy(str, path2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Double> jsonNumIncrBy(String str, Path path, double d) {
        return appendCommand(this.commandObjects.jsonNumIncrBy(str, path, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrAppend(String str, Path2 path2, Object... objArr) {
        return appendCommand(this.commandObjects.jsonArrAppend(str, path2, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrAppendWithEscape(String str, Path2 path2, Object... objArr) {
        return appendCommand(this.commandObjects.jsonArrAppendWithEscape(str, path2, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonArrAppend(String str, Path path, Object... objArr) {
        return appendCommand(this.commandObjects.jsonArrAppend(str, path, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrIndex(String str, Path2 path2, Object obj) {
        return appendCommand(this.commandObjects.jsonArrIndex(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrIndexWithEscape(String str, Path2 path2, Object obj) {
        return appendCommand(this.commandObjects.jsonArrIndexWithEscape(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonArrIndex(String str, Path path, Object obj) {
        return appendCommand(this.commandObjects.jsonArrIndex(str, path, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrInsert(String str, Path2 path2, int i, Object... objArr) {
        return appendCommand(this.commandObjects.jsonArrInsert(str, path2, i, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrInsertWithEscape(String str, Path2 path2, int i, Object... objArr) {
        return appendCommand(this.commandObjects.jsonArrInsertWithEscape(str, path2, i, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonArrInsert(String str, Path path, int i, Object... objArr) {
        return appendCommand(this.commandObjects.jsonArrInsert(str, path, i, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Object> jsonArrPop(String str) {
        return appendCommand(this.commandObjects.jsonArrPop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonArrLen(String str, Path path) {
        return appendCommand(this.commandObjects.jsonArrLen(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrTrim(String str, Path2 path2, int i, int i2) {
        return appendCommand(this.commandObjects.jsonArrTrim(str, path2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonArrTrim(String str, Path path, int i, int i2) {
        return appendCommand(this.commandObjects.jsonArrTrim(str, path, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public <T> Response<T> jsonArrPop(String str, Class<T> cls, Path path) {
        return appendCommand(this.commandObjects.jsonArrPop(str, cls, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Object>> jsonArrPop(String str, Path2 path2, int i) {
        return appendCommand(this.commandObjects.jsonArrPop(str, path2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Object> jsonArrPop(String str, Path path, int i) {
        return appendCommand(this.commandObjects.jsonArrPop(str, path, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public <T> Response<T> jsonArrPop(String str, Class<T> cls, Path path, int i) {
        return appendCommand(this.commandObjects.jsonArrPop(str, cls, path, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Long> jsonArrLen(String str) {
        return appendCommand(this.commandObjects.jsonArrLen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Long>> jsonArrLen(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonArrLen(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public <T> Response<T> jsonArrPop(String str, Class<T> cls) {
        return appendCommand(this.commandObjects.jsonArrPop(str, cls));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<List<Object>> jsonArrPop(String str, Path2 path2) {
        return appendCommand(this.commandObjects.jsonArrPop(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands
    public Response<Object> jsonArrPop(String str, Path path) {
        return appendCommand(this.commandObjects.jsonArrPop(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<String> tsCreate(String str) {
        return appendCommand(this.commandObjects.tsCreate(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<String> tsCreate(String str, TSCreateParams tSCreateParams) {
        return appendCommand(this.commandObjects.tsCreate(str, tSCreateParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsDel(String str, long j, long j2) {
        return appendCommand(this.commandObjects.tsDel(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<String> tsAlter(String str, TSAlterParams tSAlterParams) {
        return appendCommand(this.commandObjects.tsAlter(str, tSAlterParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsAdd(String str, double d) {
        return appendCommand(this.commandObjects.tsAdd(str, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsAdd(String str, long j, double d) {
        return appendCommand(this.commandObjects.tsAdd(str, j, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsAdd(String str, long j, double d, TSCreateParams tSCreateParams) {
        return appendCommand(this.commandObjects.tsAdd(str, j, d, tSCreateParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<Long>> tsMAdd(Map.Entry<String, TSElement>... entryArr) {
        return appendCommand(this.commandObjects.tsMAdd(entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsIncrBy(String str, double d) {
        return appendCommand(this.commandObjects.tsIncrBy(str, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsIncrBy(String str, double d, long j) {
        return appendCommand(this.commandObjects.tsIncrBy(str, d, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsDecrBy(String str, double d) {
        return appendCommand(this.commandObjects.tsDecrBy(str, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<Long> tsDecrBy(String str, double d, long j) {
        return appendCommand(this.commandObjects.tsDecrBy(str, d, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSElement>> tsRange(String str, long j, long j2) {
        return appendCommand(this.commandObjects.tsRange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSElement>> tsRange(String str, TSRangeParams tSRangeParams) {
        return appendCommand(this.commandObjects.tsRange(str, tSRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSElement>> tsRevRange(String str, long j, long j2) {
        return appendCommand(this.commandObjects.tsRevRange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSElement>> tsRevRange(String str, TSRangeParams tSRangeParams) {
        return appendCommand(this.commandObjects.tsRevRange(str, tSRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSKeyedElements>> tsMRange(long j, long j2, String... strArr) {
        return appendCommand(this.commandObjects.tsMRange(j, j2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSKeyedElements>> tsMRange(TSMRangeParams tSMRangeParams) {
        return appendCommand(this.commandObjects.tsMRange(tSMRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSKeyedElements>> tsMRevRange(long j, long j2, String... strArr) {
        return appendCommand(this.commandObjects.tsMRevRange(j, j2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSKeyedElements>> tsMRevRange(TSMRangeParams tSMRangeParams) {
        return appendCommand(this.commandObjects.tsMRevRange(tSMRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<TSElement> tsGet(String str) {
        return appendCommand(this.commandObjects.tsGet(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<TSElement> tsGet(String str, TSGetParams tSGetParams) {
        return appendCommand(this.commandObjects.tsGet(str, tSGetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<TSKeyValue<TSElement>>> tsMGet(TSMGetParams tSMGetParams, String... strArr) {
        return appendCommand(this.commandObjects.tsMGet(tSMGetParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<String> tsCreateRule(String str, String str2, AggregationType aggregationType, long j) {
        return appendCommand(this.commandObjects.tsCreateRule(str, str2, aggregationType, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<String> tsCreateRule(String str, String str2, AggregationType aggregationType, long j, long j2) {
        return appendCommand(this.commandObjects.tsCreateRule(str, str2, aggregationType, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<String> tsDeleteRule(String str, String str2) {
        return appendCommand(this.commandObjects.tsDeleteRule(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands
    public Response<List<String>> tsQueryIndex(String... strArr) {
        return appendCommand(this.commandObjects.tsQueryIndex(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<String> bfReserve(String str, double d, long j) {
        return appendCommand(this.commandObjects.bfReserve(str, d, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<String> bfReserve(String str, double d, long j, BFReserveParams bFReserveParams) {
        return appendCommand(this.commandObjects.bfReserve(str, d, j, bFReserveParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<Boolean> bfAdd(String str, String str2) {
        return appendCommand(this.commandObjects.bfAdd(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<List<Boolean>> bfMAdd(String str, String... strArr) {
        return appendCommand(this.commandObjects.bfMAdd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<List<Boolean>> bfInsert(String str, String... strArr) {
        return appendCommand(this.commandObjects.bfInsert(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<List<Boolean>> bfInsert(String str, BFInsertParams bFInsertParams, String... strArr) {
        return appendCommand(this.commandObjects.bfInsert(str, bFInsertParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<Boolean> bfExists(String str, String str2) {
        return appendCommand(this.commandObjects.bfExists(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<List<Boolean>> bfMExists(String str, String... strArr) {
        return appendCommand(this.commandObjects.bfMExists(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<Map.Entry<Long, byte[]>> bfScanDump(String str, long j) {
        return appendCommand(this.commandObjects.bfScanDump(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<String> bfLoadChunk(String str, long j, byte[] bArr) {
        return appendCommand(this.commandObjects.bfLoadChunk(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterPipelineCommands
    public Response<Map<String, Object>> bfInfo(String str) {
        return appendCommand(this.commandObjects.bfInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<String> cfReserve(String str, long j) {
        return appendCommand(this.commandObjects.cfReserve(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<String> cfReserve(String str, long j, CFReserveParams cFReserveParams) {
        return appendCommand(this.commandObjects.cfReserve(str, j, cFReserveParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Boolean> cfAdd(String str, String str2) {
        return appendCommand(this.commandObjects.cfAdd(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Boolean> cfAddNx(String str, String str2) {
        return appendCommand(this.commandObjects.cfAddNx(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<List<Boolean>> cfInsert(String str, String... strArr) {
        return appendCommand(this.commandObjects.cfInsert(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<List<Boolean>> cfInsert(String str, CFInsertParams cFInsertParams, String... strArr) {
        return appendCommand(this.commandObjects.cfInsert(str, cFInsertParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<List<Boolean>> cfInsertNx(String str, String... strArr) {
        return appendCommand(this.commandObjects.cfInsertNx(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<List<Boolean>> cfInsertNx(String str, CFInsertParams cFInsertParams, String... strArr) {
        return appendCommand(this.commandObjects.cfInsertNx(str, cFInsertParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Boolean> cfExists(String str, String str2) {
        return appendCommand(this.commandObjects.cfExists(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Boolean> cfDel(String str, String str2) {
        return appendCommand(this.commandObjects.cfDel(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Long> cfCount(String str, String str2) {
        return appendCommand(this.commandObjects.cfCount(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Map.Entry<Long, byte[]>> cfScanDump(String str, long j) {
        return appendCommand(this.commandObjects.cfScanDump(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<String> cfLoadChunk(String str, long j, byte[] bArr) {
        return appendCommand(this.commandObjects.cfLoadChunk(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterPipelineCommands
    public Response<Map<String, Object>> cfInfo(String str) {
        return appendCommand(this.commandObjects.cfInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<String> cmsInitByDim(String str, long j, long j2) {
        return appendCommand(this.commandObjects.cmsInitByDim(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<String> cmsInitByProb(String str, double d, double d2) {
        return appendCommand(this.commandObjects.cmsInitByProb(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<List<Long>> cmsIncrBy(String str, Map<String, Long> map) {
        return appendCommand(this.commandObjects.cmsIncrBy(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<List<Long>> cmsQuery(String str, String... strArr) {
        return appendCommand(this.commandObjects.cmsQuery(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<String> cmsMerge(String str, String... strArr) {
        return appendCommand(this.commandObjects.cmsMerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<String> cmsMerge(String str, Map<String, Long> map) {
        return appendCommand(this.commandObjects.cmsMerge(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchPipelineCommands
    public Response<Map<String, Object>> cmsInfo(String str) {
        return appendCommand(this.commandObjects.cmsInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<String> topkReserve(String str, long j) {
        return appendCommand(this.commandObjects.topkReserve(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<String> topkReserve(String str, long j, long j2, long j3, double d) {
        return appendCommand(this.commandObjects.topkReserve(str, j, j2, j3, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<List<String>> topkAdd(String str, String... strArr) {
        return appendCommand(this.commandObjects.topkAdd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<List<String>> topkIncrBy(String str, Map<String, Long> map) {
        return appendCommand(this.commandObjects.topkIncrBy(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<List<Boolean>> topkQuery(String str, String... strArr) {
        return appendCommand(this.commandObjects.topkQuery(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<List<Long>> topkCount(String str, String... strArr) {
        return appendCommand(this.commandObjects.topkCount(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<List<String>> topkList(String str) {
        return appendCommand(this.commandObjects.topkList(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterPipelineCommands
    public Response<Map<String, Object>> topkInfo(String str) {
        return appendCommand(this.commandObjects.topkInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<String> tdigestCreate(String str) {
        return appendCommand(this.commandObjects.tdigestCreate(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<String> tdigestCreate(String str, int i) {
        return appendCommand(this.commandObjects.tdigestCreate(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<String> tdigestReset(String str) {
        return appendCommand(this.commandObjects.tdigestReset(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<String> tdigestMerge(String str, String... strArr) {
        return appendCommand(this.commandObjects.tdigestMerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<String> tdigestMerge(TDigestMergeParams tDigestMergeParams, String str, String... strArr) {
        return appendCommand(this.commandObjects.tdigestMerge(tDigestMergeParams, str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<Map<String, Object>> tdigestInfo(String str) {
        return appendCommand(this.commandObjects.tdigestInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<String> tdigestAdd(String str, double... dArr) {
        return appendCommand(this.commandObjects.tdigestAdd(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<List<Double>> tdigestCDF(String str, double... dArr) {
        return appendCommand(this.commandObjects.tdigestCDF(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<List<Double>> tdigestQuantile(String str, double... dArr) {
        return appendCommand(this.commandObjects.tdigestQuantile(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<Double> tdigestMin(String str) {
        return appendCommand(this.commandObjects.tdigestMin(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<Double> tdigestMax(String str) {
        return appendCommand(this.commandObjects.tdigestMax(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<Double> tdigestTrimmedMean(String str, double d, double d2) {
        return appendCommand(this.commandObjects.tdigestTrimmedMean(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<List<Long>> tdigestRank(String str, double... dArr) {
        return appendCommand(this.commandObjects.tdigestRank(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<List<Long>> tdigestRevRank(String str, double... dArr) {
        return appendCommand(this.commandObjects.tdigestRevRank(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<List<Double>> tdigestByRank(String str, long... jArr) {
        return appendCommand(this.commandObjects.tdigestByRank(str, jArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchPipelineCommands
    public Response<List<Double>> tdigestByRevRank(String str, long... jArr) {
        return appendCommand(this.commandObjects.tdigestByRevRank(str, jArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphQuery(String str, String str2) {
        return appendCommand(this.graphCommandObjects.graphQuery(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphReadonlyQuery(String str, String str2) {
        return appendCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphQuery(String str, String str2, long j) {
        return appendCommand(this.graphCommandObjects.graphQuery(str, str2, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphReadonlyQuery(String str, String str2, long j) {
        return appendCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphQuery(String str, String str2, Map<String, Object> map) {
        return appendCommand(this.graphCommandObjects.graphQuery(str, str2, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphReadonlyQuery(String str, String str2, Map<String, Object> map) {
        return appendCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphQuery(String str, String str2, Map<String, Object> map, long j) {
        return appendCommand(this.graphCommandObjects.graphQuery(str, str2, map, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<ResultSet> graphReadonlyQuery(String str, String str2, Map<String, Object> map, long j) {
        return appendCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2, map, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<String> graphDelete(String str) {
        return appendCommand(this.graphCommandObjects.graphDelete(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands
    public Response<List<String>> graphProfile(String str, String str2) {
        return appendCommand(this.commandObjects.graphProfile(str, str2));
    }

    public Response<Long> waitReplicas(int i, long j) {
        return appendCommand(this.commandObjects.waitReplicas(i, j));
    }

    public Response<List<String>> time() {
        return appendCommand(new CommandObject(this.commandObjects.commandArguments(Protocol.Command.TIME), BuilderFactory.STRING_LIST));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<String> select(int i) {
        return appendCommand(new CommandObject(this.commandObjects.commandArguments(Protocol.Command.SELECT), BuilderFactory.STRING));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<Long> dbSize() {
        return appendCommand(new CommandObject(this.commandObjects.commandArguments(Protocol.Command.DBSIZE), BuilderFactory.LONG));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<String> swapDB(int i, int i2) {
        return appendCommand(new CommandObject(this.commandObjects.commandArguments(Protocol.Command.SWAPDB).add(Integer.valueOf(i)).add(Integer.valueOf(i2)), BuilderFactory.STRING));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<Long> move(String str, int i) {
        return appendCommand(new CommandObject(this.commandObjects.commandArguments(Protocol.Command.MOVE).key(str).add(Integer.valueOf(i)), BuilderFactory.LONG));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<Long> move(byte[] bArr, int i) {
        return appendCommand(new CommandObject(this.commandObjects.commandArguments(Protocol.Command.MOVE).key(bArr).add(Integer.valueOf(i)), BuilderFactory.LONG));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<Boolean> copy(String str, String str2, int i, boolean z) {
        return appendCommand(this.commandObjects.copy(str, str2, i, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<Boolean> copy(byte[] bArr, byte[] bArr2, int i, boolean z) {
        return appendCommand(this.commandObjects.copy(bArr, bArr2, i, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<String> migrate(String str, int i, byte[] bArr, int i2, int i3) {
        return appendCommand(this.commandObjects.migrate(str, i, bArr, i2, i3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<String> migrate(String str, int i, String str2, int i2, int i3) {
        return appendCommand(this.commandObjects.migrate(str, i, str2, i2, i3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<String> migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, byte[]... bArr) {
        return appendCommand(this.commandObjects.migrate(str, i, i2, i3, migrateParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabasePipelineCommands
    public Response<String> migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, String... strArr) {
        return appendCommand(this.commandObjects.migrate(str, i, i2, i3, migrateParams, strArr));
    }

    public Response<Object> sendCommand(ProtocolCommand protocolCommand, String... strArr) {
        return sendCommand(new CommandArguments(protocolCommand).addObjects(strArr));
    }

    public Response<Object> sendCommand(ProtocolCommand protocolCommand, byte[]... bArr) {
        return sendCommand(new CommandArguments(protocolCommand).addObjects(bArr));
    }

    public Response<Object> sendCommand(CommandArguments commandArguments) {
        return executeCommand(new CommandObject(commandArguments, BuilderFactory.RAW_OBJECT));
    }

    public <T> Response<T> executeCommand(CommandObject<T> commandObject) {
        return appendCommand(commandObject);
    }
}
