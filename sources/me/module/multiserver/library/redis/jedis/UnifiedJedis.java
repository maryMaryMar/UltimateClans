package me.module.multiserver.library.redis.jedis;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
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
import me.module.multiserver.library.redis.jedis.commands.JedisBinaryCommands;
import me.module.multiserver.library.redis.jedis.commands.JedisCommands;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.commands.RedisModuleCommands;
import me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands;
import me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands;
import me.module.multiserver.library.redis.jedis.executors.ClusterCommandExecutor;
import me.module.multiserver.library.redis.jedis.executors.CommandExecutor;
import me.module.multiserver.library.redis.jedis.executors.DefaultCommandExecutor;
import me.module.multiserver.library.redis.jedis.executors.RetryableCommandExecutor;
import me.module.multiserver.library.redis.jedis.executors.SimpleCommandExecutor;
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
import me.module.multiserver.library.redis.jedis.providers.ClusterConnectionProvider;
import me.module.multiserver.library.redis.jedis.providers.ConnectionProvider;
import me.module.multiserver.library.redis.jedis.providers.PooledConnectionProvider;
import me.module.multiserver.library.redis.jedis.providers.ShardedConnectionProvider;
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
import me.module.multiserver.library.redis.jedis.timeseries.TSInfo;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyValue;
import me.module.multiserver.library.redis.jedis.timeseries.TSKeyedElements;
import me.module.multiserver.library.redis.jedis.timeseries.TSMGetParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSMRangeParams;
import me.module.multiserver.library.redis.jedis.timeseries.TSRangeParams;
import me.module.multiserver.library.redis.jedis.util.IOUtils;
import me.module.multiserver.library.redis.jedis.util.JedisURIHelper;
import me.module.multiserver.library.redis.jedis.util.KeyValue;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/UnifiedJedis.class */
public class UnifiedJedis implements AutoCloseable, JedisBinaryCommands, JedisCommands, RedisModuleCommands, SampleBinaryKeyedCommands, SampleKeyedCommands {
    protected final ConnectionProvider provider;
    protected final CommandExecutor executor;
    private final CommandObjects commandObjects;
    private final GraphCommandObjects graphCommandObjects;

    public UnifiedJedis() {
        this(new HostAndPort(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT));
    }

    public UnifiedJedis(HostAndPort hostAndPort) {
        this(new PooledConnectionProvider(hostAndPort));
    }

    public UnifiedJedis(String str) {
        this(URI.create(str));
    }

    public UnifiedJedis(URI uri) {
        this(JedisURIHelper.getHostAndPort(uri), DefaultJedisClientConfig.builder().user(JedisURIHelper.getUser(uri)).password(JedisURIHelper.getPassword(uri)).database(JedisURIHelper.getDBIndex(uri)).ssl(JedisURIHelper.isRedisSSLScheme(uri)).build());
    }

    public UnifiedJedis(URI uri, JedisClientConfig jedisClientConfig) {
        this(JedisURIHelper.getHostAndPort(uri), DefaultJedisClientConfig.builder().connectionTimeoutMillis(jedisClientConfig.getConnectionTimeoutMillis()).socketTimeoutMillis(jedisClientConfig.getSocketTimeoutMillis()).blockingSocketTimeoutMillis(jedisClientConfig.getBlockingSocketTimeoutMillis()).user(JedisURIHelper.getUser(uri)).password(JedisURIHelper.getPassword(uri)).database(JedisURIHelper.getDBIndex(uri)).clientName(jedisClientConfig.getClientName()).ssl(JedisURIHelper.isRedisSSLScheme(uri)).sslSocketFactory(jedisClientConfig.getSslSocketFactory()).sslParameters(jedisClientConfig.getSslParameters()).hostnameVerifier(jedisClientConfig.getHostnameVerifier()).build());
    }

    public UnifiedJedis(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this(new PooledConnectionProvider(hostAndPort, jedisClientConfig));
    }

    public UnifiedJedis(ConnectionProvider connectionProvider) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = connectionProvider;
        this.executor = new DefaultCommandExecutor(connectionProvider);
        this.commandObjects = new CommandObjects();
    }

    public UnifiedJedis(JedisSocketFactory jedisSocketFactory) {
        this(new Connection(jedisSocketFactory));
    }

    public UnifiedJedis(Connection connection) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = null;
        this.executor = new SimpleCommandExecutor(connection);
        this.commandObjects = new CommandObjects();
    }

    public UnifiedJedis(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, int i) {
        this(new ClusterConnectionProvider(set, jedisClientConfig), i, Duration.ofMillis(i * jedisClientConfig.getSocketTimeoutMillis()));
    }

    public UnifiedJedis(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, int i, Duration duration) {
        this(new ClusterConnectionProvider(set, jedisClientConfig), i, duration);
    }

    public UnifiedJedis(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, int i, Duration duration) {
        this(new ClusterConnectionProvider(set, jedisClientConfig, genericObjectPoolConfig), i, duration);
    }

    public UnifiedJedis(ClusterConnectionProvider clusterConnectionProvider, int i, Duration duration) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = clusterConnectionProvider;
        this.executor = new ClusterCommandExecutor(clusterConnectionProvider, i, duration);
        this.commandObjects = new ClusterCommandObjects();
    }

    public UnifiedJedis(ShardedConnectionProvider shardedConnectionProvider) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = shardedConnectionProvider;
        this.executor = new DefaultCommandExecutor(shardedConnectionProvider);
        this.commandObjects = new ShardedCommandObjects(shardedConnectionProvider.getHashingAlgo());
    }

    public UnifiedJedis(ShardedConnectionProvider shardedConnectionProvider, Pattern pattern) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = shardedConnectionProvider;
        this.executor = new DefaultCommandExecutor(shardedConnectionProvider);
        this.commandObjects = new ShardedCommandObjects(shardedConnectionProvider.getHashingAlgo(), pattern);
    }

    public UnifiedJedis(ConnectionProvider connectionProvider, int i, Duration duration) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = connectionProvider;
        this.executor = new RetryableCommandExecutor(connectionProvider, i, duration);
        this.commandObjects = new CommandObjects();
    }

    public UnifiedJedis(CommandExecutor commandExecutor) {
        this.graphCommandObjects = new GraphCommandObjects(this);
        this.provider = null;
        this.executor = commandExecutor;
        this.commandObjects = new CommandObjects();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.executor);
    }

    public final <T> T executeCommand(CommandObject<T> commandObject) {
        return (T) this.executor.executeCommand(commandObject);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public boolean exists(String str) {
        return ((Boolean) executeCommand(this.commandObjects.exists(str))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long exists(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.exists(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long persist(String str) {
        return ((Long) executeCommand(this.commandObjects.persist(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String type(String str) {
        return (String) executeCommand(this.commandObjects.type(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public boolean exists(byte[] bArr) {
        return ((Boolean) executeCommand(this.commandObjects.exists(bArr))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long exists(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.exists(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long persist(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.persist(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String type(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.type(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public byte[] dump(String str) {
        return (byte[]) executeCommand(this.commandObjects.dump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String restore(String str, long j, byte[] bArr) {
        return (String) executeCommand(this.commandObjects.restore(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String restore(String str, long j, byte[] bArr, RestoreParams restoreParams) {
        return (String) executeCommand(this.commandObjects.restore(str, j, bArr, restoreParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public byte[] dump(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.dump(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String restore(byte[] bArr, long j, byte[] bArr2) {
        return (String) executeCommand(this.commandObjects.restore(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String restore(byte[] bArr, long j, byte[] bArr2, RestoreParams restoreParams) {
        return (String) executeCommand(this.commandObjects.restore(bArr, j, bArr2, restoreParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expire(String str, long j) {
        return ((Long) executeCommand(this.commandObjects.expire(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expire(String str, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.expire(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpire(String str, long j) {
        return ((Long) executeCommand(this.commandObjects.pexpire(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpire(String str, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.pexpire(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expireTime(String str) {
        return ((Long) executeCommand(this.commandObjects.expireTime(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpireTime(String str) {
        return ((Long) executeCommand(this.commandObjects.pexpireTime(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expireAt(String str, long j) {
        return ((Long) executeCommand(this.commandObjects.expireAt(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expireAt(String str, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.expireAt(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpireAt(String str, long j) {
        return ((Long) executeCommand(this.commandObjects.pexpireAt(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpireAt(String str, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.pexpireAt(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expire(byte[] bArr, long j) {
        return ((Long) executeCommand(this.commandObjects.expire(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expire(byte[] bArr, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.expire(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpire(byte[] bArr, long j) {
        return ((Long) executeCommand(this.commandObjects.pexpire(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpire(byte[] bArr, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.pexpire(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expireTime(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.expireTime(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpireTime(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.pexpireTime(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expireAt(byte[] bArr, long j) {
        return ((Long) executeCommand(this.commandObjects.expireAt(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.expireAt(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpireAt(byte[] bArr, long j) {
        return ((Long) executeCommand(this.commandObjects.pexpireAt(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        return ((Long) executeCommand(this.commandObjects.expireAt(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long ttl(String str) {
        return ((Long) executeCommand(this.commandObjects.ttl(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pttl(String str) {
        return ((Long) executeCommand(this.commandObjects.pttl(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long touch(String str) {
        return ((Long) executeCommand(this.commandObjects.touch(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long touch(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.touch(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long ttl(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.ttl(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pttl(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.pttl(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long touch(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.touch(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long touch(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.touch(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public List<String> sort(String str) {
        return (List) executeCommand(this.commandObjects.sort(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public List<String> sort(String str, SortingParams sortingParams) {
        return (List) executeCommand(this.commandObjects.sort(str, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long sort(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.sort(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long sort(String str, SortingParams sortingParams, String str2) {
        return ((Long) executeCommand(this.commandObjects.sort(str, sortingParams, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public List<String> sortReadonly(String str, SortingParams sortingParams) {
        return (List) executeCommand(this.commandObjects.sortReadonly(str, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public List<byte[]> sort(byte[] bArr) {
        return (List) executeCommand(this.commandObjects.sort(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public List<byte[]> sort(byte[] bArr, SortingParams sortingParams) {
        return (List) executeCommand(this.commandObjects.sort(bArr, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long sort(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.sort(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public List<byte[]> sortReadonly(byte[] bArr, SortingParams sortingParams) {
        return (List) executeCommand(this.commandObjects.sortReadonly(bArr, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.sort(bArr, sortingParams, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long del(String str) {
        return ((Long) executeCommand(this.commandObjects.del(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long del(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.del(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long unlink(String str) {
        return ((Long) executeCommand(this.commandObjects.unlink(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long unlink(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.unlink(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long del(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.del(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long del(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.del(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long unlink(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.unlink(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long unlink(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.unlink(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long memoryUsage(String str) {
        return (Long) executeCommand(this.commandObjects.memoryUsage(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long memoryUsage(String str, int i) {
        return (Long) executeCommand(this.commandObjects.memoryUsage(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long memoryUsage(byte[] bArr) {
        return (Long) executeCommand(this.commandObjects.memoryUsage(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long memoryUsage(byte[] bArr, int i) {
        return (Long) executeCommand(this.commandObjects.memoryUsage(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public boolean copy(String str, String str2, boolean z) {
        return ((Boolean) executeCommand(this.commandObjects.copy(str, str2, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String rename(String str, String str2) {
        return (String) executeCommand(this.commandObjects.rename(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long renamenx(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.renamenx(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public boolean copy(byte[] bArr, byte[] bArr2, boolean z) {
        return ((Boolean) executeCommand(this.commandObjects.copy(bArr, bArr2, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String rename(byte[] bArr, byte[] bArr2) {
        return (String) executeCommand(this.commandObjects.rename(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long renamenx(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.renamenx(bArr, bArr2))).longValue();
    }

    public long dbSize() {
        return ((Long) executeCommand(this.commandObjects.dbSize())).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Set<String> keys(String str) {
        return (Set) executeCommand(this.commandObjects.keys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public ScanResult<String> scan(String str) {
        return (ScanResult) executeCommand(this.commandObjects.scan(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public ScanResult<String> scan(String str, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.scan(str, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public ScanResult<String> scan(String str, ScanParams scanParams, String str2) {
        return (ScanResult) executeCommand(this.commandObjects.scan(str, scanParams, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Set<byte[]> keys(byte[] bArr) {
        return (Set) executeCommand(this.commandObjects.keys(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public ScanResult<byte[]> scan(byte[] bArr) {
        return (ScanResult) executeCommand(this.commandObjects.scan(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public ScanResult<byte[]> scan(byte[] bArr, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.scan(bArr, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public ScanResult<byte[]> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2) {
        return (ScanResult) executeCommand(this.commandObjects.scan(bArr, scanParams, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String randomKey() {
        return (String) executeCommand(this.commandObjects.randomKey());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public byte[] randomBinaryKey() {
        return (byte[]) executeCommand(this.commandObjects.randomBinaryKey());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String set(String str, String str2) {
        return (String) executeCommand(this.commandObjects.set(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String set(String str, String str2, SetParams setParams) {
        return (String) executeCommand(this.commandObjects.set(str, str2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String get(String str) {
        return (String) executeCommand(this.commandObjects.get(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String setGet(String str, String str2, SetParams setParams) {
        return (String) executeCommand(this.commandObjects.setGet(str, str2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getDel(String str) {
        return (String) executeCommand(this.commandObjects.getDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getEx(String str, GetExParams getExParams) {
        return (String) executeCommand(this.commandObjects.getEx(str, getExParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String set(byte[] bArr, byte[] bArr2) {
        return (String) executeCommand(this.commandObjects.set(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String set(byte[] bArr, byte[] bArr2, SetParams setParams) {
        return (String) executeCommand(this.commandObjects.set(bArr, bArr2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] get(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.get(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] setGet(byte[] bArr, byte[] bArr2, SetParams setParams) {
        return (byte[]) executeCommand(this.commandObjects.setGet(bArr, bArr2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getDel(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.getDel(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getEx(byte[] bArr, GetExParams getExParams) {
        return (byte[]) executeCommand(this.commandObjects.getEx(bArr, getExParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public boolean setbit(String str, long j, boolean z) {
        return ((Boolean) executeCommand(this.commandObjects.setbit(str, j, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public boolean getbit(String str, long j) {
        return ((Boolean) executeCommand(this.commandObjects.getbit(str, j))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long setrange(String str, long j, String str2) {
        return ((Long) executeCommand(this.commandObjects.setrange(str, j, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getrange(String str, long j, long j2) {
        return (String) executeCommand(this.commandObjects.getrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public boolean setbit(byte[] bArr, long j, boolean z) {
        return ((Boolean) executeCommand(this.commandObjects.setbit(bArr, j, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public boolean getbit(byte[] bArr, long j) {
        return ((Boolean) executeCommand(this.commandObjects.getbit(bArr, j))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long setrange(byte[] bArr, long j, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.setrange(bArr, j, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getrange(byte[] bArr, long j, long j2) {
        return (byte[]) executeCommand(this.commandObjects.getrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getSet(String str, String str2) {
        return (String) executeCommand(this.commandObjects.getSet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long setnx(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.setnx(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String setex(String str, long j, String str2) {
        return (String) executeCommand(this.commandObjects.setex(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String psetex(String str, long j, String str2) {
        return (String) executeCommand(this.commandObjects.psetex(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getSet(byte[] bArr, byte[] bArr2) {
        return (byte[]) executeCommand(this.commandObjects.getSet(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long setnx(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.setnx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String setex(byte[] bArr, long j, byte[] bArr2) {
        return (String) executeCommand(this.commandObjects.setex(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String psetex(byte[] bArr, long j, byte[] bArr2) {
        return (String) executeCommand(this.commandObjects.psetex(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long incr(String str) {
        return ((Long) executeCommand(this.commandObjects.incr(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long incrBy(String str, long j) {
        return ((Long) executeCommand(this.commandObjects.incrBy(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public double incrByFloat(String str, double d) {
        return ((Double) executeCommand(this.commandObjects.incrByFloat(str, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long decr(String str) {
        return ((Long) executeCommand(this.commandObjects.decr(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long decrBy(String str, long j) {
        return ((Long) executeCommand(this.commandObjects.decrBy(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long incr(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.incr(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long incrBy(byte[] bArr, long j) {
        return ((Long) executeCommand(this.commandObjects.incrBy(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public double incrByFloat(byte[] bArr, double d) {
        return ((Double) executeCommand(this.commandObjects.incrByFloat(bArr, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long decr(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.decr(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long decrBy(byte[] bArr, long j) {
        return ((Long) executeCommand(this.commandObjects.decrBy(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public List<String> mget(String... strArr) {
        return (List) executeCommand(this.commandObjects.mget(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String mset(String... strArr) {
        return (String) executeCommand(this.commandObjects.mset(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long msetnx(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.msetnx(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public List<byte[]> mget(byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.mget(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String mset(byte[]... bArr) {
        return (String) executeCommand(this.commandObjects.mset(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long msetnx(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.msetnx(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long append(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.append(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String substr(String str, int i, int i2) {
        return (String) executeCommand(this.commandObjects.substr(str, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long strlen(String str) {
        return ((Long) executeCommand(this.commandObjects.strlen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long append(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.append(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] substr(byte[] bArr, int i, int i2) {
        return (byte[]) executeCommand(this.commandObjects.substr(bArr, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long strlen(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.strlen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitcount(String str) {
        return ((Long) executeCommand(this.commandObjects.bitcount(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitcount(String str, long j, long j2) {
        return ((Long) executeCommand(this.commandObjects.bitcount(str, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitcount(String str, long j, long j2, BitCountOption bitCountOption) {
        return ((Long) executeCommand(this.commandObjects.bitcount(str, j, j2, bitCountOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitpos(String str, boolean z) {
        return ((Long) executeCommand(this.commandObjects.bitpos(str, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitpos(String str, boolean z, BitPosParams bitPosParams) {
        return ((Long) executeCommand(this.commandObjects.bitpos(str, z, bitPosParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitcount(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.bitcount(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitcount(byte[] bArr, long j, long j2) {
        return ((Long) executeCommand(this.commandObjects.bitcount(bArr, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitcount(byte[] bArr, long j, long j2, BitCountOption bitCountOption) {
        return ((Long) executeCommand(this.commandObjects.bitcount(bArr, j, j2, bitCountOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitpos(byte[] bArr, boolean z) {
        return ((Long) executeCommand(this.commandObjects.bitpos(bArr, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitpos(byte[] bArr, boolean z, BitPosParams bitPosParams) {
        return ((Long) executeCommand(this.commandObjects.bitpos(bArr, z, bitPosParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public List<Long> bitfield(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.bitfield(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public List<Long> bitfieldReadonly(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.bitfieldReadonly(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public List<Long> bitfield(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.bitfield(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public List<Long> bitfieldReadonly(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.bitfieldReadonly(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitop(BitOP bitOP, String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.bitop(bitOP, str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.bitop(bitOP, bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public LCSMatchResult strAlgoLCSKeys(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        return (LCSMatchResult) executeCommand(this.commandObjects.strAlgoLCSKeys(str, str2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public LCSMatchResult strAlgoLCSKeys(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        return (LCSMatchResult) executeCommand(this.commandObjects.strAlgoLCSKeys(bArr, bArr2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public LCSMatchResult lcs(String str, String str2, LCSParams lCSParams) {
        return (LCSMatchResult) executeCommand(this.commandObjects.lcs(str, str2, lCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public LCSMatchResult lcs(byte[] bArr, byte[] bArr2, LCSParams lCSParams) {
        return (LCSMatchResult) executeCommand(this.commandObjects.lcs(bArr, bArr2, lCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long rpush(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.rpush(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long lpush(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.lpush(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long llen(String str) {
        return ((Long) executeCommand(this.commandObjects.llen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> lrange(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.lrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String ltrim(String str, long j, long j2) {
        return (String) executeCommand(this.commandObjects.ltrim(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lindex(String str, long j) {
        return (String) executeCommand(this.commandObjects.lindex(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long rpush(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.rpush(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long lpush(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.lpush(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long llen(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.llen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> lrange(byte[] bArr, long j, long j2) {
        return (List) executeCommand(this.commandObjects.lrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public String ltrim(byte[] bArr, long j, long j2) {
        return (String) executeCommand(this.commandObjects.ltrim(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] lindex(byte[] bArr, long j) {
        return (byte[]) executeCommand(this.commandObjects.lindex(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lset(String str, long j, String str2) {
        return (String) executeCommand(this.commandObjects.lset(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long lrem(String str, long j, String str2) {
        return ((Long) executeCommand(this.commandObjects.lrem(str, j, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lpop(String str) {
        return (String) executeCommand(this.commandObjects.lpop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> lpop(String str, int i) {
        return (List) executeCommand(this.commandObjects.lpop(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public String lset(byte[] bArr, long j, byte[] bArr2) {
        return (String) executeCommand(this.commandObjects.lset(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long lrem(byte[] bArr, long j, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.lrem(bArr, j, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] lpop(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.lpop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> lpop(byte[] bArr, int i) {
        return (List) executeCommand(this.commandObjects.lpop(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public Long lpos(String str, String str2) {
        return (Long) executeCommand(this.commandObjects.lpos(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public Long lpos(String str, String str2, LPosParams lPosParams) {
        return (Long) executeCommand(this.commandObjects.lpos(str, str2, lPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<Long> lpos(String str, String str2, LPosParams lPosParams, long j) {
        return (List) executeCommand(this.commandObjects.lpos(str, str2, lPosParams, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public Long lpos(byte[] bArr, byte[] bArr2) {
        return (Long) executeCommand(this.commandObjects.lpos(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public Long lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams) {
        return (Long) executeCommand(this.commandObjects.lpos(bArr, bArr2, lPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<Long> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams, long j) {
        return (List) executeCommand(this.commandObjects.lpos(bArr, bArr2, lPosParams, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String rpop(String str) {
        return (String) executeCommand(this.commandObjects.rpop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> rpop(String str, int i) {
        return (List) executeCommand(this.commandObjects.rpop(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] rpop(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.rpop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> rpop(byte[] bArr, int i) {
        return (List) executeCommand(this.commandObjects.rpop(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long linsert(String str, ListPosition listPosition, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.linsert(str, listPosition, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long lpushx(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.lpushx(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long rpushx(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.rpushx(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long linsert(byte[] bArr, ListPosition listPosition, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.linsert(bArr, listPosition, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long lpushx(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.lpushx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long rpushx(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.rpushx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> blpop(int i, String str) {
        return (List) executeCommand(this.commandObjects.blpop(i, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement blpop(double d, String str) {
        return (KeyedListElement) executeCommand(this.commandObjects.blpop(d, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> brpop(int i, String str) {
        return (List) executeCommand(this.commandObjects.brpop(i, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement brpop(double d, String str) {
        return (KeyedListElement) executeCommand(this.commandObjects.brpop(d, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> blpop(int i, String... strArr) {
        return (List) executeCommand(this.commandObjects.blpop(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement blpop(double d, String... strArr) {
        return (KeyedListElement) executeCommand(this.commandObjects.blpop(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> brpop(int i, String... strArr) {
        return (List) executeCommand(this.commandObjects.brpop(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement brpop(double d, String... strArr) {
        return (KeyedListElement) executeCommand(this.commandObjects.brpop(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> blpop(int i, byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.blpop(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> blpop(double d, byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.blpop(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> brpop(int i, byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.brpop(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> brpop(double d, byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.brpop(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String rpoplpush(String str, String str2) {
        return (String) executeCommand(this.commandObjects.rpoplpush(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String brpoplpush(String str, String str2, int i) {
        return (String) executeCommand(this.commandObjects.brpoplpush(str, str2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] rpoplpush(byte[] bArr, byte[] bArr2) {
        return (byte[]) executeCommand(this.commandObjects.rpoplpush(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] brpoplpush(byte[] bArr, byte[] bArr2, int i) {
        return (byte[]) executeCommand(this.commandObjects.brpoplpush(bArr, bArr2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2) {
        return (String) executeCommand(this.commandObjects.lmove(str, str2, listDirection, listDirection2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String blmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2, double d) {
        return (String) executeCommand(this.commandObjects.blmove(str, str2, listDirection, listDirection2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] lmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2) {
        return (byte[]) executeCommand(this.commandObjects.lmove(bArr, bArr2, listDirection, listDirection2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] blmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2, double d) {
        return (byte[]) executeCommand(this.commandObjects.blmove(bArr, bArr2, listDirection, listDirection2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> lmpop(ListDirection listDirection, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.lmpop(listDirection, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> lmpop(ListDirection listDirection, int i, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.lmpop(listDirection, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> blmpop(long j, ListDirection listDirection, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.blmpop(j, listDirection, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> blmpop(long j, ListDirection listDirection, int i, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.blmpop(j, listDirection, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> lmpop(ListDirection listDirection, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.lmpop(listDirection, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> lmpop(ListDirection listDirection, int i, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.lmpop(listDirection, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> blmpop(long j, ListDirection listDirection, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.blmpop(j, listDirection, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> blmpop(long j, ListDirection listDirection, int i, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.blmpop(j, listDirection, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hset(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.hset(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hset(String str, Map<String, String> map) {
        return ((Long) executeCommand(this.commandObjects.hset(str, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public String hget(String str, String str2) {
        return (String) executeCommand(this.commandObjects.hget(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hsetnx(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.hsetnx(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public String hmset(String str, Map<String, String> map) {
        return (String) executeCommand(this.commandObjects.hmset(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public List<String> hmget(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.hmget(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hset(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.hset(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hset(byte[] bArr, Map<byte[], byte[]> map) {
        return ((Long) executeCommand(this.commandObjects.hset(bArr, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public byte[] hget(byte[] bArr, byte[] bArr2) {
        return (byte[]) executeCommand(this.commandObjects.hget(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hsetnx(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.hsetnx(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public String hmset(byte[] bArr, Map<byte[], byte[]> map) {
        return (String) executeCommand(this.commandObjects.hmset(bArr, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public List<byte[]> hmget(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.hmget(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hincrBy(String str, String str2, long j) {
        return ((Long) executeCommand(this.commandObjects.hincrBy(str, str2, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public double hincrByFloat(String str, String str2, double d) {
        return ((Double) executeCommand(this.commandObjects.hincrByFloat(str, str2, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public boolean hexists(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.hexists(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hdel(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.hdel(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hlen(String str) {
        return ((Long) executeCommand(this.commandObjects.hlen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hincrBy(byte[] bArr, byte[] bArr2, long j) {
        return ((Long) executeCommand(this.commandObjects.hincrBy(bArr, bArr2, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public double hincrByFloat(byte[] bArr, byte[] bArr2, double d) {
        return ((Double) executeCommand(this.commandObjects.hincrByFloat(bArr, bArr2, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public boolean hexists(byte[] bArr, byte[] bArr2) {
        return ((Boolean) executeCommand(this.commandObjects.hexists(bArr, bArr2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hdel(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.hdel(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hlen(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.hlen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public Set<String> hkeys(String str) {
        return (Set) executeCommand(this.commandObjects.hkeys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public List<String> hvals(String str) {
        return (List) executeCommand(this.commandObjects.hvals(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public Map<String, String> hgetAll(String str) {
        return (Map) executeCommand(this.commandObjects.hgetAll(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public Set<byte[]> hkeys(byte[] bArr) {
        return (Set) executeCommand(this.commandObjects.hkeys(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public List<byte[]> hvals(byte[] bArr) {
        return (List) executeCommand(this.commandObjects.hvals(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public Map<byte[], byte[]> hgetAll(byte[] bArr) {
        return (Map) executeCommand(this.commandObjects.hgetAll(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public String hrandfield(String str) {
        return (String) executeCommand(this.commandObjects.hrandfield(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public List<String> hrandfield(String str, long j) {
        return (List) executeCommand(this.commandObjects.hrandfield(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public Map<String, String> hrandfieldWithValues(String str, long j) {
        return (Map) executeCommand(this.commandObjects.hrandfieldWithValues(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public ScanResult<Map.Entry<String, String>> hscan(String str, String str2, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.hscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hstrlen(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.hstrlen(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public byte[] hrandfield(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.hrandfield(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public List<byte[]> hrandfield(byte[] bArr, long j) {
        return (List) executeCommand(this.commandObjects.hrandfield(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public Map<byte[], byte[]> hrandfieldWithValues(byte[] bArr, long j) {
        return (Map) executeCommand(this.commandObjects.hrandfieldWithValues(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.hscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hstrlen(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.hstrlen(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sadd(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.sadd(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> smembers(String str) {
        return (Set) executeCommand(this.commandObjects.smembers(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long srem(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.srem(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public String spop(String str) {
        return (String) executeCommand(this.commandObjects.spop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> spop(String str, long j) {
        return (Set) executeCommand(this.commandObjects.spop(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long scard(String str) {
        return ((Long) executeCommand(this.commandObjects.scard(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public boolean sismember(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.sismember(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public List<Boolean> smismember(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.smismember(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sadd(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.sadd(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> smembers(byte[] bArr) {
        return (Set) executeCommand(this.commandObjects.smembers(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long srem(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.srem(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public byte[] spop(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.spop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> spop(byte[] bArr, long j) {
        return (Set) executeCommand(this.commandObjects.spop(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long scard(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.scard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public boolean sismember(byte[] bArr, byte[] bArr2) {
        return ((Boolean) executeCommand(this.commandObjects.sismember(bArr, bArr2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public List<Boolean> smismember(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.smismember(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public String srandmember(String str) {
        return (String) executeCommand(this.commandObjects.srandmember(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public List<String> srandmember(String str, int i) {
        return (List) executeCommand(this.commandObjects.srandmember(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public ScanResult<String> sscan(String str, String str2, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.sscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public byte[] srandmember(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.srandmember(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public List<byte[]> srandmember(byte[] bArr, int i) {
        return (List) executeCommand(this.commandObjects.srandmember(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public ScanResult<byte[]> sscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.sscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> sdiff(String... strArr) {
        return (Set) executeCommand(this.commandObjects.sdiff(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sdiffstore(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.sdiffstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> sinter(String... strArr) {
        return (Set) executeCommand(this.commandObjects.sinter(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sinterstore(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.sinterstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sintercard(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.sintercard(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sintercard(int i, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.sintercard(i, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> sunion(String... strArr) {
        return (Set) executeCommand(this.commandObjects.sunion(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sunionstore(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.sunionstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long smove(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.smove(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> sdiff(byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.sdiff(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sdiffstore(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.sdiffstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> sinter(byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.sinter(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sinterstore(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.sinterstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sintercard(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.sintercard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sintercard(int i, byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.sintercard(i, bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> sunion(byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.sunion(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sunionstore(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.sunionstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long smove(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.smove(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, double d, String str2) {
        return ((Long) executeCommand(this.commandObjects.zadd(str, d, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, double d, String str2, ZAddParams zAddParams) {
        return ((Long) executeCommand(this.commandObjects.zadd(str, d, str2, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, Map<String, Double> map) {
        return ((Long) executeCommand(this.commandObjects.zadd(str, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, Map<String, Double> map, ZAddParams zAddParams) {
        return ((Long) executeCommand(this.commandObjects.zadd(str, map, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Double zaddIncr(String str, double d, String str2, ZAddParams zAddParams) {
        return (Double) executeCommand(this.commandObjects.zaddIncr(str, d, str2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, double d, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.zadd(bArr, d, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        return ((Long) executeCommand(this.commandObjects.zadd(bArr, d, bArr2, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, Map<byte[], Double> map) {
        return ((Long) executeCommand(this.commandObjects.zadd(bArr, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, Map<byte[], Double> map, ZAddParams zAddParams) {
        return ((Long) executeCommand(this.commandObjects.zadd(bArr, map, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Double zaddIncr(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        return (Double) executeCommand(this.commandObjects.zaddIncr(bArr, d, bArr2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zrem(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zrem(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public double zincrby(String str, double d, String str2) {
        return ((Double) executeCommand(this.commandObjects.zincrby(str, d, str2))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Double zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams) {
        return (Double) executeCommand(this.commandObjects.zincrby(str, d, str2, zIncrByParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Long zrank(String str, String str2) {
        return (Long) executeCommand(this.commandObjects.zrank(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Long zrevrank(String str, String str2) {
        return (Long) executeCommand(this.commandObjects.zrevrank(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zrem(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.zrem(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public double zincrby(byte[] bArr, double d, byte[] bArr2) {
        return ((Double) executeCommand(this.commandObjects.zincrby(bArr, d, bArr2))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Double zincrby(byte[] bArr, double d, byte[] bArr2, ZIncrByParams zIncrByParams) {
        return (Double) executeCommand(this.commandObjects.zincrby(bArr, d, bArr2, zIncrByParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Long zrank(byte[] bArr, byte[] bArr2) {
        return (Long) executeCommand(this.commandObjects.zrank(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Long zrevrank(byte[] bArr, byte[] bArr2) {
        return (Long) executeCommand(this.commandObjects.zrevrank(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public String zrandmember(String str) {
        return (String) executeCommand(this.commandObjects.zrandmember(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrandmember(String str, long j) {
        return (List) executeCommand(this.commandObjects.zrandmember(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrandmemberWithScores(String str, long j) {
        return (List) executeCommand(this.commandObjects.zrandmemberWithScores(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zcard(String str) {
        return ((Long) executeCommand(this.commandObjects.zcard(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Double zscore(String str, String str2) {
        return (Double) executeCommand(this.commandObjects.zscore(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Double> zmscore(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.zmscore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public byte[] zrandmember(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.zrandmember(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrandmember(byte[] bArr, long j) {
        return (List) executeCommand(this.commandObjects.zrandmember(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrandmemberWithScores(byte[] bArr, long j) {
        return (List) executeCommand(this.commandObjects.zrandmemberWithScores(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zcard(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.zcard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Double zscore(byte[] bArr, byte[] bArr2) {
        return (Double) executeCommand(this.commandObjects.zscore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Double> zmscore(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.zmscore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Tuple zpopmax(String str) {
        return (Tuple) executeCommand(this.commandObjects.zpopmax(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zpopmax(String str, int i) {
        return (List) executeCommand(this.commandObjects.zpopmax(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Tuple zpopmin(String str) {
        return (Tuple) executeCommand(this.commandObjects.zpopmin(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zpopmin(String str, int i) {
        return (List) executeCommand(this.commandObjects.zpopmin(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zcount(String str, double d, double d2) {
        return ((Long) executeCommand(this.commandObjects.zcount(str, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zcount(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.zcount(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Tuple zpopmax(byte[] bArr) {
        return (Tuple) executeCommand(this.commandObjects.zpopmax(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zpopmax(byte[] bArr, int i) {
        return (List) executeCommand(this.commandObjects.zpopmax(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Tuple zpopmin(byte[] bArr) {
        return (Tuple) executeCommand(this.commandObjects.zpopmin(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zpopmin(byte[] bArr, int i) {
        return (List) executeCommand(this.commandObjects.zpopmin(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zcount(byte[] bArr, double d, double d2) {
        return ((Long) executeCommand(this.commandObjects.zcount(bArr, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.zcount(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrange(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrange(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrevrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeWithScores(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrangeWithScores(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeWithScores(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrevrangeWithScores(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrange(String str, ZRangeParams zRangeParams) {
        return (List) executeCommand(this.commandObjects.zrange(str, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeWithScores(String str, ZRangeParams zRangeParams) {
        return (List) executeCommand(this.commandObjects.zrangeWithScores(str, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zrangestore(String str, String str2, ZRangeParams zRangeParams) {
        return ((Long) executeCommand(this.commandObjects.zrangestore(str, str2, zRangeParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, String str2, String str3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, String str2, String str3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrange(byte[] bArr, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrange(byte[] bArr, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrevrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeWithScores(byte[] bArr, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrangeWithScores(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeWithScores(byte[] bArr, long j, long j2) {
        return (List) executeCommand(this.commandObjects.zrevrangeWithScores(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrange(byte[] bArr, ZRangeParams zRangeParams) {
        return (List) executeCommand(this.commandObjects.zrange(bArr, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeWithScores(byte[] bArr, ZRangeParams zRangeParams) {
        return (List) executeCommand(this.commandObjects.zrangeWithScores(bArr, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zrangestore(byte[] bArr, byte[] bArr2, ZRangeParams zRangeParams) {
        return ((Long) executeCommand(this.commandObjects.zrangestore(bArr, bArr2, zRangeParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScore(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScore(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByRank(String str, long j, long j2) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByRank(str, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByScore(String str, double d, double d2) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByScore(str, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByScore(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByScore(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByRank(byte[] bArr, long j, long j2) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByRank(bArr, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByScore(byte[] bArr, double d, double d2) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByScore(bArr, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByScore(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zlexcount(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.zlexcount(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByLex(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.zrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByLex(String str, String str2, String str3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByLex(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByLex(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.zrevrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByLex(String str, String str2, String str3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByLex(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByLex(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByLex(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zlexcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.zlexcount(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.zrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrangeByLex(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.zrevrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        return (List) executeCommand(this.commandObjects.zrevrangeByLex(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.zremrangeByLex(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public ScanResult<Tuple> zscan(String str, String str2, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.zscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public ScanResult<Tuple> zscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        return (ScanResult) executeCommand(this.commandObjects.zscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyedZSetElement bzpopmax(double d, String... strArr) {
        return (KeyedZSetElement) executeCommand(this.commandObjects.bzpopmax(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyedZSetElement bzpopmin(double d, String... strArr) {
        return (KeyedZSetElement) executeCommand(this.commandObjects.bzpopmin(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> bzpopmax(double d, byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.bzpopmax(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> bzpopmin(double d, byte[]... bArr) {
        return (List) executeCommand(this.commandObjects.bzpopmin(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<String> zdiff(String... strArr) {
        return (Set) executeCommand(this.commandObjects.zdiff(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<Tuple> zdiffWithScores(String... strArr) {
        return (Set) executeCommand(this.commandObjects.zdiffWithScores(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zdiffStore(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zdiffStore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<byte[]> zdiff(byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.zdiff(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<Tuple> zdiffWithScores(byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.zdiffWithScores(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zdiffStore(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.zdiffStore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zinterstore(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zinterstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zinterstore(String str, ZParams zParams, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zinterstore(str, zParams, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<String> zinter(ZParams zParams, String... strArr) {
        return (Set) executeCommand(this.commandObjects.zinter(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<Tuple> zinterWithScores(ZParams zParams, String... strArr) {
        return (Set) executeCommand(this.commandObjects.zinterWithScores(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zinterstore(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.zinterstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.zinterstore(bArr, zParams, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zintercard(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.zintercard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zintercard(long j, byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.zintercard(j, bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zintercard(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zintercard(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zintercard(long j, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zintercard(j, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<byte[]> zinter(ZParams zParams, byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.zinter(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<Tuple> zinterWithScores(ZParams zParams, byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.zinterWithScores(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<String> zunion(ZParams zParams, String... strArr) {
        return (Set) executeCommand(this.commandObjects.zunion(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<Tuple> zunionWithScores(ZParams zParams, String... strArr) {
        return (Set) executeCommand(this.commandObjects.zunionWithScores(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zunionstore(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zunionstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zunionstore(String str, ZParams zParams, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.zunionstore(str, zParams, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<byte[]> zunion(ZParams zParams, byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.zunion(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<Tuple> zunionWithScores(ZParams zParams, byte[]... bArr) {
        return (Set) executeCommand(this.commandObjects.zunionWithScores(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zunionstore(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.zunionstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.zunionstore(bArr, zParams, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.zmpop(sortedSetOption, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.zmpop(sortedSetOption, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, int i, String... strArr) {
        return (KeyValue) executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> zmpop(SortedSetOption sortedSetOption, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.zmpop(sortedSetOption, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.zmpop(sortedSetOption, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        return (KeyValue) executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geoadd(String str, double d, double d2, String str2) {
        return ((Long) executeCommand(this.commandObjects.geoadd(str, d, d2, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geoadd(String str, Map<String, GeoCoordinate> map) {
        return ((Long) executeCommand(this.commandObjects.geoadd(str, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geoadd(String str, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map) {
        return ((Long) executeCommand(this.commandObjects.geoadd(str, geoAddParams, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public Double geodist(String str, String str2, String str3) {
        return (Double) executeCommand(this.commandObjects.geodist(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public Double geodist(String str, String str2, String str3, GeoUnit geoUnit) {
        return (Double) executeCommand(this.commandObjects.geodist(str, str2, str3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<String> geohash(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.geohash(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoCoordinate> geopos(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.geopos(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geoadd(byte[] bArr, double d, double d2, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.geoadd(bArr, d, d2, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geoadd(byte[] bArr, Map<byte[], GeoCoordinate> map) {
        return ((Long) executeCommand(this.commandObjects.geoadd(bArr, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geoadd(byte[] bArr, GeoAddParams geoAddParams, Map<byte[], GeoCoordinate> map) {
        return ((Long) executeCommand(this.commandObjects.geoadd(bArr, geoAddParams, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public Double geodist(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (Double) executeCommand(this.commandObjects.geodist(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public Double geodist(byte[] bArr, byte[] bArr2, byte[] bArr3, GeoUnit geoUnit) {
        return (Double) executeCommand(this.commandObjects.geodist(bArr, bArr2, bArr3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<byte[]> geohash(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.geohash(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoCoordinate> geopos(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.geopos(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadius(str, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadiusReadonly(str, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadius(str, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadiusReadonly(str, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadiusByMember(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadiusByMemberReadonly(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadiusByMember(str, str2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadiusByMemberReadonly(str, str2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long georadiusStore(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return ((Long) executeCommand(this.commandObjects.georadiusStore(str, d, d2, d3, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long georadiusByMemberStore(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return ((Long) executeCommand(this.commandObjects.georadiusByMemberStore(str, str2, d, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, String str2, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(str, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, String str2, double d, double d2, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(str, str2, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(str, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, GeoSearchParam geoSearchParam) {
        return (List) executeCommand(this.commandObjects.geosearch(str, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, String str3, double d, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(str, str2, str3, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(str, str2, geoCoordinate, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, String str3, double d, double d2, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(str, str2, str3, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(str, str2, geoCoordinate, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, GeoSearchParam geoSearchParam) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(str, str2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStoreStoreDist(String str, String str2, GeoSearchParam geoSearchParam) {
        return ((Long) executeCommand(this.commandObjects.geosearchStoreStoreDist(str, str2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadius(bArr, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadiusReadonly(bArr, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadius(bArr, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadiusReadonly(bArr, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadiusByMember(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.georadiusByMemberReadonly(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadiusByMember(bArr, bArr2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return (List) executeCommand(this.commandObjects.georadiusByMemberReadonly(bArr, bArr2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long georadiusStore(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return ((Long) executeCommand(this.commandObjects.georadiusStore(bArr, d, d2, d3, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long georadiusByMemberStore(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return ((Long) executeCommand(this.commandObjects.georadiusByMemberStore(bArr, bArr2, d, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(bArr, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, byte[] bArr2, double d, double d2, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(bArr, bArr2, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return (List) executeCommand(this.commandObjects.geosearch(bArr, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, GeoSearchParam geoSearchParam) {
        return (List) executeCommand(this.commandObjects.geosearch(bArr, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, bArr3, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoCoordinate, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, double d2, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, bArr3, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoCoordinate, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        return ((Long) executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStoreStoreDist(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        return ((Long) executeCommand(this.commandObjects.geosearchStoreStoreDist(bArr, bArr2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public long pfadd(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.pfadd(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public String pfmerge(String str, String... strArr) {
        return (String) executeCommand(this.commandObjects.pfmerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public long pfcount(String str) {
        return ((Long) executeCommand(this.commandObjects.pfcount(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public long pfcount(String... strArr) {
        return ((Long) executeCommand(this.commandObjects.pfcount(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public long pfadd(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.pfadd(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public String pfmerge(byte[] bArr, byte[]... bArr2) {
        return (String) executeCommand(this.commandObjects.pfmerge(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public long pfcount(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.pfcount(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public long pfcount(byte[]... bArr) {
        return ((Long) executeCommand(this.commandObjects.pfcount(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamEntryID xadd(String str, StreamEntryID streamEntryID, Map<String, String> map) {
        return (StreamEntryID) executeCommand(this.commandObjects.xadd(str, streamEntryID, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamEntryID xadd(String str, XAddParams xAddParams, Map<String, String> map) {
        return (StreamEntryID) executeCommand(this.commandObjects.xadd(str, xAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xlen(String str) {
        return ((Long) executeCommand(this.commandObjects.xlen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        return (List) executeCommand(this.commandObjects.xrange(str, streamEntryID, streamEntryID2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return (List) executeCommand(this.commandObjects.xrange(str, streamEntryID, streamEntryID2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        return (List) executeCommand(this.commandObjects.xrevrange(str, streamEntryID, streamEntryID2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return (List) executeCommand(this.commandObjects.xrevrange(str, streamEntryID, streamEntryID2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.xrange(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, String str2, String str3, int i) {
        return (List) executeCommand(this.commandObjects.xrange(str, str2, str3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, String str2, String str3) {
        return (List) executeCommand(this.commandObjects.xrevrange(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, String str2, String str3, int i) {
        return (List) executeCommand(this.commandObjects.xrevrange(str, str2, str3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xack(String str, String str2, StreamEntryID... streamEntryIDArr) {
        return ((Long) executeCommand(this.commandObjects.xack(str, str2, streamEntryIDArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public String xgroupCreate(String str, String str2, StreamEntryID streamEntryID, boolean z) {
        return (String) executeCommand(this.commandObjects.xgroupCreate(str, str2, streamEntryID, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public String xgroupSetID(String str, String str2, StreamEntryID streamEntryID) {
        return (String) executeCommand(this.commandObjects.xgroupSetID(str, str2, streamEntryID));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xgroupDestroy(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.xgroupDestroy(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public boolean xgroupCreateConsumer(String str, String str2, String str3) {
        return ((Boolean) executeCommand(this.commandObjects.xgroupCreateConsumer(str, str2, str3))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xgroupDelConsumer(String str, String str2, String str3) {
        return ((Long) executeCommand(this.commandObjects.xgroupDelConsumer(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamPendingSummary xpending(String str, String str2) {
        return (StreamPendingSummary) executeCommand(this.commandObjects.xpending(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamPendingEntry> xpending(String str, String str2, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i, String str3) {
        return (List) executeCommand(this.commandObjects.xpending(str, str2, streamEntryID, streamEntryID2, i, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamPendingEntry> xpending(String str, String str2, XPendingParams xPendingParams) {
        return (List) executeCommand(this.commandObjects.xpending(str, str2, xPendingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xdel(String str, StreamEntryID... streamEntryIDArr) {
        return ((Long) executeCommand(this.commandObjects.xdel(str, streamEntryIDArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xtrim(String str, long j, boolean z) {
        return ((Long) executeCommand(this.commandObjects.xtrim(str, j, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xtrim(String str, XTrimParams xTrimParams) {
        return ((Long) executeCommand(this.commandObjects.xtrim(str, xTrimParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xclaim(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        return (List) executeCommand(this.commandObjects.xclaim(str, str2, str3, j, xClaimParams, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntryID> xclaimJustId(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        return (List) executeCommand(this.commandObjects.xclaimJustId(str, str2, str3, j, xClaimParams, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public Map.Entry<StreamEntryID, List<StreamEntry>> xautoclaim(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return (Map.Entry) executeCommand(this.commandObjects.xautoclaim(str, str2, str3, j, streamEntryID, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public Map.Entry<StreamEntryID, List<StreamEntryID>> xautoclaimJustId(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return (Map.Entry) executeCommand(this.commandObjects.xautoclaimJustId(str, str2, str3, j, streamEntryID, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamInfo xinfoStream(String str) {
        return (StreamInfo) executeCommand(this.commandObjects.xinfoStream(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamFullInfo xinfoStreamFull(String str) {
        return (StreamFullInfo) executeCommand(this.commandObjects.xinfoStreamFull(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamFullInfo xinfoStreamFull(String str, int i) {
        return (StreamFullInfo) executeCommand(this.commandObjects.xinfoStreamFull(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    @Deprecated
    public List<StreamGroupInfo> xinfoGroup(String str) {
        return (List) executeCommand(this.commandObjects.xinfoGroup(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamGroupInfo> xinfoGroups(String str) {
        return (List) executeCommand(this.commandObjects.xinfoGroups(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamConsumersInfo> xinfoConsumers(String str, String str2) {
        return (List) executeCommand(this.commandObjects.xinfoConsumers(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<Map.Entry<String, List<StreamEntry>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map) {
        return (List) executeCommand(this.commandObjects.xread(xReadParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<Map.Entry<String, List<StreamEntry>>> xreadGroup(String str, String str2, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map) {
        return (List) executeCommand(this.commandObjects.xreadGroup(str, str2, xReadGroupParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public byte[] xadd(byte[] bArr, XAddParams xAddParams, Map<byte[], byte[]> map) {
        return (byte[]) executeCommand(this.commandObjects.xadd(bArr, xAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xlen(byte[] bArr) {
        return ((Long) executeCommand(this.commandObjects.xlen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.xrange(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return (List) executeCommand(this.commandObjects.xrange(bArr, bArr2, bArr3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (List) executeCommand(this.commandObjects.xrevrange(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        return (List) executeCommand(this.commandObjects.xrevrange(bArr, bArr2, bArr3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xack(byte[] bArr, byte[] bArr2, byte[]... bArr3) {
        return ((Long) executeCommand(this.commandObjects.xack(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public String xgroupCreate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        return (String) executeCommand(this.commandObjects.xgroupCreate(bArr, bArr2, bArr3, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public String xgroupSetID(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return (String) executeCommand(this.commandObjects.xgroupSetID(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xgroupDestroy(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.xgroupDestroy(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public boolean xgroupCreateConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Boolean) executeCommand(this.commandObjects.xgroupCreateConsumer(bArr, bArr2, bArr3))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xgroupDelConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return ((Long) executeCommand(this.commandObjects.xgroupDelConsumer(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xdel(byte[] bArr, byte[]... bArr2) {
        return ((Long) executeCommand(this.commandObjects.xdel(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xtrim(byte[] bArr, long j, boolean z) {
        return ((Long) executeCommand(this.commandObjects.xtrim(bArr, j, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xtrim(byte[] bArr, XTrimParams xTrimParams) {
        return ((Long) executeCommand(this.commandObjects.xtrim(bArr, xTrimParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xpending(byte[] bArr, byte[] bArr2) {
        return executeCommand(this.commandObjects.xpending(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xpending(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) {
        return (List) executeCommand(this.commandObjects.xpending(bArr, bArr2, bArr3, bArr4, i, bArr5));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xpending(byte[] bArr, byte[] bArr2, XPendingParams xPendingParams) {
        return (List) executeCommand(this.commandObjects.xpending(bArr, bArr2, xPendingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        return (List) executeCommand(this.commandObjects.xclaim(bArr, bArr2, bArr3, j, xClaimParams, bArr4));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        return (List) executeCommand(this.commandObjects.xclaimJustId(bArr, bArr2, bArr3, j, xClaimParams, bArr4));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xautoclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        return (List) executeCommand(this.commandObjects.xautoclaim(bArr, bArr2, bArr3, j, bArr4, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xautoclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        return (List) executeCommand(this.commandObjects.xautoclaimJustId(bArr, bArr2, bArr3, j, bArr4, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xinfoStream(byte[] bArr) {
        return executeCommand(this.commandObjects.xinfoStream(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xinfoStreamFull(byte[] bArr) {
        return executeCommand(this.commandObjects.xinfoStreamFull(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xinfoStreamFull(byte[] bArr, int i) {
        return executeCommand(this.commandObjects.xinfoStreamFull(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    @Deprecated
    public List<Object> xinfoGroup(byte[] bArr) {
        return (List) executeCommand(this.commandObjects.xinfoGroup(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xinfoGroups(byte[] bArr) {
        return (List) executeCommand(this.commandObjects.xinfoGroups(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xinfoConsumers(byte[] bArr, byte[] bArr2) {
        return (List) executeCommand(this.commandObjects.xinfoConsumers(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xread(XReadParams xReadParams, Map.Entry<byte[], byte[]>... entryArr) {
        return (List) executeCommand(this.commandObjects.xread(xReadParams, entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xreadGroup(byte[] bArr, byte[] bArr2, XReadGroupParams xReadGroupParams, Map.Entry<byte[], byte[]>... entryArr) {
        return (List) executeCommand(this.commandObjects.xreadGroup(bArr, bArr2, xReadGroupParams, entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object eval(String str) {
        return executeCommand(this.commandObjects.eval(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object eval(String str, int i, String... strArr) {
        return executeCommand(this.commandObjects.eval(str, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object eval(String str, List<String> list, List<String> list2) {
        return executeCommand(this.commandObjects.eval(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalReadonly(String str, List<String> list, List<String> list2) {
        return executeCommand(this.commandObjects.evalReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalsha(String str) {
        return executeCommand(this.commandObjects.evalsha(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalsha(String str, int i, String... strArr) {
        return executeCommand(this.commandObjects.evalsha(str, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalsha(String str, List<String> list, List<String> list2) {
        return executeCommand(this.commandObjects.evalsha(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalshaReadonly(String str, List<String> list, List<String> list2) {
        return executeCommand(this.commandObjects.evalshaReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object eval(byte[] bArr) {
        return executeCommand(this.commandObjects.eval(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object eval(byte[] bArr, int i, byte[]... bArr2) {
        return executeCommand(this.commandObjects.eval(bArr, i, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object eval(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return executeCommand(this.commandObjects.eval(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return executeCommand(this.commandObjects.evalReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalsha(byte[] bArr) {
        return executeCommand(this.commandObjects.evalsha(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalsha(byte[] bArr, int i, byte[]... bArr2) {
        return executeCommand(this.commandObjects.evalsha(bArr, i, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return executeCommand(this.commandObjects.evalsha(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalshaReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return executeCommand(this.commandObjects.evalshaReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public Object fcall(String str, List<String> list, List<String> list2) {
        return executeCommand(this.commandObjects.fcall(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public Object fcallReadonly(String str, List<String> list, List<String> list2) {
        return executeCommand(this.commandObjects.fcallReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionDelete(String str) {
        return (String) executeCommand(this.commandObjects.functionDelete(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionFlush() {
        return (String) executeCommand(this.commandObjects.functionFlush());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionFlush(FlushMode flushMode) {
        return (String) executeCommand(this.commandObjects.functionFlush(flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionKill() {
        return (String) executeCommand(this.commandObjects.functionKill());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionList() {
        return (List) executeCommand(this.commandObjects.functionList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionList(String str) {
        return (List) executeCommand(this.commandObjects.functionList(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionListWithCode() {
        return (List) executeCommand(this.commandObjects.functionListWithCode());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionListWithCode(String str) {
        return (List) executeCommand(this.commandObjects.functionListWithCode(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionLoad(String str) {
        return (String) executeCommand(this.commandObjects.functionLoad(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionLoadReplace(String str) {
        return (String) executeCommand(this.commandObjects.functionLoadReplace(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public FunctionStats functionStats() {
        return (FunctionStats) executeCommand(this.commandObjects.functionStats());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public Object fcall(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return executeCommand(this.commandObjects.fcall(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public Object fcallReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        return executeCommand(this.commandObjects.fcallReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public String functionDelete(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.functionDelete(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public byte[] functionDump() {
        return (byte[]) executeCommand(this.commandObjects.functionDump());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionListBinary() {
        return (List) executeCommand(this.commandObjects.functionListBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionList(byte[] bArr) {
        return (List) executeCommand(this.commandObjects.functionList(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionListWithCodeBinary() {
        return (List) executeCommand(this.commandObjects.functionListWithCodeBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionListWithCode(byte[] bArr) {
        return (List) executeCommand(this.commandObjects.functionListWithCode(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public String functionLoad(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.functionLoad(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public String functionLoadReplace(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.functionLoadReplace(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionRestore(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.functionRestore(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy) {
        return (String) executeCommand(this.commandObjects.functionRestore(bArr, functionRestorePolicy));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public Object functionStatsBinary() {
        return executeCommand(this.commandObjects.functionStatsBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long objectRefcount(String str) {
        return (Long) executeCommand(this.commandObjects.objectRefcount(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String objectEncoding(String str) {
        return (String) executeCommand(this.commandObjects.objectEncoding(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long objectIdletime(String str) {
        return (Long) executeCommand(this.commandObjects.objectIdletime(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long objectFreq(String str) {
        return (Long) executeCommand(this.commandObjects.objectFreq(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long objectRefcount(byte[] bArr) {
        return (Long) executeCommand(this.commandObjects.objectRefcount(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public byte[] objectEncoding(byte[] bArr) {
        return (byte[]) executeCommand(this.commandObjects.objectEncoding(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long objectIdletime(byte[] bArr) {
        return (Long) executeCommand(this.commandObjects.objectIdletime(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long objectFreq(byte[] bArr) {
        return (Long) executeCommand(this.commandObjects.objectFreq(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String migrate(String str, int i, String str2, int i2) {
        return (String) executeCommand(this.commandObjects.migrate(str, i, str2, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String migrate(String str, int i, int i2, MigrateParams migrateParams, String... strArr) {
        return (String) executeCommand(this.commandObjects.migrate(str, i, i2, migrateParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String migrate(String str, int i, byte[] bArr, int i2) {
        return (String) executeCommand(this.commandObjects.migrate(str, i, bArr, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String migrate(String str, int i, int i2, MigrateParams migrateParams, byte[]... bArr) {
        return (String) executeCommand(this.commandObjects.migrate(str, i, i2, migrateParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public long waitReplicas(String str, int i, long j) {
        return ((Long) executeCommand(this.commandObjects.waitReplicas(str, i, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public long waitReplicas(byte[] bArr, int i, long j) {
        return ((Long) executeCommand(this.commandObjects.waitReplicas(bArr, i, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public Object eval(String str, String str2) {
        return executeCommand(this.commandObjects.eval(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public Object evalsha(String str, String str2) {
        return executeCommand(this.commandObjects.evalsha(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public Object eval(byte[] bArr, byte[] bArr2) {
        return executeCommand(this.commandObjects.eval(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public Object evalsha(byte[] bArr, byte[] bArr2) {
        return executeCommand(this.commandObjects.evalsha(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public Boolean scriptExists(String str, String str2) {
        return scriptExists(str2, str).get(0);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public List<Boolean> scriptExists(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.scriptExists(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public Boolean scriptExists(byte[] bArr, byte[] bArr2) {
        return scriptExists(bArr2, bArr).get(0);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public List<Boolean> scriptExists(byte[] bArr, byte[]... bArr2) {
        return (List) executeCommand(this.commandObjects.scriptExists(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public String scriptLoad(String str, String str2) {
        return (String) executeCommand(this.commandObjects.scriptLoad(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public String scriptFlush(String str) {
        return (String) executeCommand(this.commandObjects.scriptFlush(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public String scriptFlush(String str, FlushMode flushMode) {
        return (String) executeCommand(this.commandObjects.scriptFlush(str, flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleKeyedCommands
    public String scriptKill(String str) {
        return (String) executeCommand(this.commandObjects.scriptKill(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public byte[] scriptLoad(byte[] bArr, byte[] bArr2) {
        return (byte[]) executeCommand(this.commandObjects.scriptLoad(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public String scriptFlush(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.scriptFlush(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public String scriptFlush(byte[] bArr, FlushMode flushMode) {
        return (String) executeCommand(this.commandObjects.scriptFlush(bArr, flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SampleBinaryKeyedCommands
    public String scriptKill(byte[] bArr) {
        return (String) executeCommand(this.commandObjects.scriptKill(bArr));
    }

    public long publish(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.publish(str, str2))).longValue();
    }

    public long publish(byte[] bArr, byte[] bArr2) {
        return ((Long) executeCommand(this.commandObjects.publish(bArr, bArr2))).longValue();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void subscribe(me.module.multiserver.library.redis.jedis.JedisPubSub r5, java.lang.String... r6) {
        /*
            r4 = this;
            r0 = r4
            me.module.multiserver.library.redis.jedis.providers.ConnectionProvider r0 = r0.provider
            me.module.multiserver.library.redis.jedis.Connection r0 = r0.getConnection()
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r5
            r1 = r7
            r2 = r6
            r0.proceed(r1, r2)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L3f
            r0 = r7
            if (r0 == 0) goto L64
            r0 = r8
            if (r0 == 0) goto L2f
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L23
            goto L64
        L23:
            r9 = move-exception
            r0 = r8
            r1 = r9
            r0.addSuppressed(r1)
            goto L64
        L2f:
            r0 = r7
            r0.close()
            goto L64
        L36:
            r9 = move-exception
            r0 = r9
            r8 = r0
            r0 = r9
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r10 = move-exception
            r0 = r7
            if (r0 == 0) goto L61
            r0 = r8
            if (r0 == 0) goto L5d
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L51
            goto L61
        L51:
            r11 = move-exception
            r0 = r8
            r1 = r11
            r0.addSuppressed(r1)
            goto L61
        L5d:
            r0 = r7
            r0.close()
        L61:
            r0 = r10
            throw r0
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.module.multiserver.library.redis.jedis.UnifiedJedis.subscribe(me.module.multiserver.library.redis.jedis.JedisPubSub, java.lang.String[]):void");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void psubscribe(me.module.multiserver.library.redis.jedis.JedisPubSub r5, java.lang.String... r6) {
        /*
            r4 = this;
            r0 = r4
            me.module.multiserver.library.redis.jedis.providers.ConnectionProvider r0 = r0.provider
            me.module.multiserver.library.redis.jedis.Connection r0 = r0.getConnection()
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r5
            r1 = r7
            r2 = r6
            r0.proceedWithPatterns(r1, r2)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L3f
            r0 = r7
            if (r0 == 0) goto L64
            r0 = r8
            if (r0 == 0) goto L2f
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L23
            goto L64
        L23:
            r9 = move-exception
            r0 = r8
            r1 = r9
            r0.addSuppressed(r1)
            goto L64
        L2f:
            r0 = r7
            r0.close()
            goto L64
        L36:
            r9 = move-exception
            r0 = r9
            r8 = r0
            r0 = r9
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r10 = move-exception
            r0 = r7
            if (r0 == 0) goto L61
            r0 = r8
            if (r0 == 0) goto L5d
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L51
            goto L61
        L51:
            r11 = move-exception
            r0 = r8
            r1 = r11
            r0.addSuppressed(r1)
            goto L61
        L5d:
            r0 = r7
            r0.close()
        L61:
            r0 = r10
            throw r0
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.module.multiserver.library.redis.jedis.UnifiedJedis.psubscribe(me.module.multiserver.library.redis.jedis.JedisPubSub, java.lang.String[]):void");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void subscribe(me.module.multiserver.library.redis.jedis.BinaryJedisPubSub r5, byte[]... r6) {
        /*
            r4 = this;
            r0 = r4
            me.module.multiserver.library.redis.jedis.providers.ConnectionProvider r0 = r0.provider
            me.module.multiserver.library.redis.jedis.Connection r0 = r0.getConnection()
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r5
            r1 = r7
            r2 = r6
            r0.proceed(r1, r2)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L3f
            r0 = r7
            if (r0 == 0) goto L64
            r0 = r8
            if (r0 == 0) goto L2f
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L23
            goto L64
        L23:
            r9 = move-exception
            r0 = r8
            r1 = r9
            r0.addSuppressed(r1)
            goto L64
        L2f:
            r0 = r7
            r0.close()
            goto L64
        L36:
            r9 = move-exception
            r0 = r9
            r8 = r0
            r0 = r9
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r10 = move-exception
            r0 = r7
            if (r0 == 0) goto L61
            r0 = r8
            if (r0 == 0) goto L5d
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L51
            goto L61
        L51:
            r11 = move-exception
            r0 = r8
            r1 = r11
            r0.addSuppressed(r1)
            goto L61
        L5d:
            r0 = r7
            r0.close()
        L61:
            r0 = r10
            throw r0
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.module.multiserver.library.redis.jedis.UnifiedJedis.subscribe(me.module.multiserver.library.redis.jedis.BinaryJedisPubSub, byte[][]):void");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void psubscribe(me.module.multiserver.library.redis.jedis.BinaryJedisPubSub r5, byte[]... r6) {
        /*
            r4 = this;
            r0 = r4
            me.module.multiserver.library.redis.jedis.providers.ConnectionProvider r0 = r0.provider
            me.module.multiserver.library.redis.jedis.Connection r0 = r0.getConnection()
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r5
            r1 = r7
            r2 = r6
            r0.proceedWithPatterns(r1, r2)     // Catch: java.lang.Throwable -> L36 java.lang.Throwable -> L3f
            r0 = r7
            if (r0 == 0) goto L64
            r0 = r8
            if (r0 == 0) goto L2f
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L23
            goto L64
        L23:
            r9 = move-exception
            r0 = r8
            r1 = r9
            r0.addSuppressed(r1)
            goto L64
        L2f:
            r0 = r7
            r0.close()
            goto L64
        L36:
            r9 = move-exception
            r0 = r9
            r8 = r0
            r0 = r9
            throw r0     // Catch: java.lang.Throwable -> L3f
        L3f:
            r10 = move-exception
            r0 = r7
            if (r0 == 0) goto L61
            r0 = r8
            if (r0 == 0) goto L5d
            r0 = r7
            r0.close()     // Catch: java.lang.Throwable -> L51
            goto L61
        L51:
            r11 = move-exception
            r0 = r8
            r1 = r11
            r0.addSuppressed(r1)
            goto L61
        L5d:
            r0 = r7
            r0.close()
        L61:
            r0 = r10
            throw r0
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.module.multiserver.library.redis.jedis.UnifiedJedis.psubscribe(me.module.multiserver.library.redis.jedis.BinaryJedisPubSub, byte[][]):void");
    }

    public LCSMatchResult strAlgoLCSStrings(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        return (LCSMatchResult) executeCommand(this.commandObjects.strAlgoLCSStrings(str, str2, strAlgoLCSParams));
    }

    public LCSMatchResult strAlgoLCSStrings(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        return (LCSMatchResult) executeCommand(this.commandObjects.strAlgoLCSStrings(bArr, bArr2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftCreate(String str, IndexOptions indexOptions, Schema schema) {
        return (String) executeCommand(this.commandObjects.ftCreate(str, indexOptions, schema));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftCreate(String str, FTCreateParams fTCreateParams, Iterable<SchemaField> iterable) {
        return (String) executeCommand(this.commandObjects.ftCreate(str, fTCreateParams, iterable));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftAlter(String str, Schema schema) {
        return (String) executeCommand(this.commandObjects.ftAlter(str, schema));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftAlter(String str, Iterable<SchemaField> iterable) {
        return (String) executeCommand(this.commandObjects.ftAlter(str, iterable));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public SearchResult ftSearch(String str, String str2) {
        return (SearchResult) executeCommand(this.commandObjects.ftSearch(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public SearchResult ftSearch(String str, String str2, FTSearchParams fTSearchParams) {
        return (SearchResult) executeCommand(this.commandObjects.ftSearch(str, str2, fTSearchParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public SearchResult ftSearch(String str, Query query) {
        return (SearchResult) executeCommand(this.commandObjects.ftSearch(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public SearchResult ftSearch(byte[] bArr, Query query) {
        return (SearchResult) executeCommand(this.commandObjects.ftSearch(bArr, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftExplain(String str, Query query) {
        return (String) executeCommand(this.commandObjects.ftExplain(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public List<String> ftExplainCLI(String str, Query query) {
        return (List) executeCommand(this.commandObjects.ftExplainCLI(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public AggregationResult ftAggregate(String str, AggregationBuilder aggregationBuilder) {
        return (AggregationResult) executeCommand(this.commandObjects.ftAggregate(str, aggregationBuilder));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public AggregationResult ftCursorRead(String str, long j, int i) {
        return (AggregationResult) executeCommand(this.commandObjects.ftCursorRead(str, j, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftCursorDel(String str, long j) {
        return (String) executeCommand(this.commandObjects.ftCursorDel(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftDropIndex(String str) {
        return (String) executeCommand(this.commandObjects.ftDropIndex(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftDropIndexDD(String str) {
        return (String) executeCommand(this.commandObjects.ftDropIndexDD(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftSynUpdate(String str, String str2, String... strArr) {
        return (String) executeCommand(this.commandObjects.ftSynUpdate(str, str2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Map<String, List<String>> ftSynDump(String str) {
        return (Map) executeCommand(this.commandObjects.ftSynDump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftDictAdd(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.ftDictAdd(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftDictDel(String str, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.ftDictDel(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Set<String> ftDictDump(String str) {
        return (Set) executeCommand(this.commandObjects.ftDictDump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftDictAddBySampleKey(String str, String str2, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.ftDictAddBySampleKey(str, str2, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftDictDelBySampleKey(String str, String str2, String... strArr) {
        return ((Long) executeCommand(this.commandObjects.ftDictDelBySampleKey(str, str2, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Set<String> ftDictDumpBySampleKey(String str, String str2) {
        return (Set) executeCommand(this.commandObjects.ftDictDumpBySampleKey(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Map<String, Object> ftInfo(String str) {
        return (Map) executeCommand(this.commandObjects.ftInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Set<String> ftTagVals(String str, String str2) {
        return (Set) executeCommand(this.commandObjects.ftTagVals(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftAliasAdd(String str, String str2) {
        return (String) executeCommand(this.commandObjects.ftAliasAdd(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftAliasUpdate(String str, String str2) {
        return (String) executeCommand(this.commandObjects.ftAliasUpdate(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftAliasDel(String str) {
        return (String) executeCommand(this.commandObjects.ftAliasDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Map<String, String> ftConfigGet(String str) {
        return (Map) executeCommand(this.commandObjects.ftConfigGet(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public Map<String, String> ftConfigGet(String str, String str2) {
        return (Map) executeCommand(this.commandObjects.ftConfigGet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftConfigSet(String str, String str2) {
        return (String) executeCommand(this.commandObjects.ftConfigSet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public String ftConfigSet(String str, String str2, String str3) {
        return (String) executeCommand(this.commandObjects.ftConfigSet(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftSugAdd(String str, String str2, double d) {
        return ((Long) executeCommand(this.commandObjects.ftSugAdd(str, str2, d))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftSugAddIncr(String str, String str2, double d) {
        return ((Long) executeCommand(this.commandObjects.ftSugAddIncr(str, str2, d))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public List<String> ftSugGet(String str, String str2) {
        return (List) executeCommand(this.commandObjects.ftSugGet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public List<String> ftSugGet(String str, String str2, boolean z, int i) {
        return (List) executeCommand(this.commandObjects.ftSugGet(str, str2, z, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public List<Tuple> ftSugGetWithScores(String str, String str2) {
        return (List) executeCommand(this.commandObjects.ftSugGetWithScores(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public List<Tuple> ftSugGetWithScores(String str, String str2, boolean z, int i) {
        return (List) executeCommand(this.commandObjects.ftSugGetWithScores(str, str2, z, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public boolean ftSugDel(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.ftSugDel(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.RediSearchCommands
    public long ftSugLen(String str) {
        return ((Long) executeCommand(this.commandObjects.ftSugLen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSet(String str, Path2 path2, Object obj) {
        return (String) executeCommand(this.commandObjects.jsonSet(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSetWithEscape(String str, Path2 path2, Object obj) {
        return (String) executeCommand(this.commandObjects.jsonSetWithEscape(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSet(String str, Path path, Object obj) {
        return (String) executeCommand(this.commandObjects.jsonSet(str, path, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSetWithPlainString(String str, Path path, String str2) {
        return (String) executeCommand(this.commandObjects.jsonSetWithPlainString(str, path, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSet(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams) {
        return (String) executeCommand(this.commandObjects.jsonSet(str, path2, obj, jsonSetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSetWithEscape(String str, Path2 path2, Object obj, JsonSetParams jsonSetParams) {
        return (String) executeCommand(this.commandObjects.jsonSetWithEscape(str, path2, obj, jsonSetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonSet(String str, Path path, Object obj, JsonSetParams jsonSetParams) {
        return (String) executeCommand(this.commandObjects.jsonSet(str, path, obj, jsonSetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Object jsonGet(String str) {
        return executeCommand(this.commandObjects.jsonGet(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public <T> T jsonGet(String str, Class<T> cls) {
        return (T) executeCommand(this.commandObjects.jsonGet(str, cls));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Object jsonGet(String str, Path2... path2Arr) {
        return executeCommand(this.commandObjects.jsonGet(str, path2Arr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Object jsonGet(String str, Path... pathArr) {
        return executeCommand(this.commandObjects.jsonGet(str, pathArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonGetAsPlainString(String str, Path path) {
        return (String) executeCommand(this.commandObjects.jsonGetAsPlainString(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public <T> T jsonGet(String str, Class<T> cls, Path... pathArr) {
        return (T) executeCommand(this.commandObjects.jsonGet(str, cls, pathArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<JSONArray> jsonMGet(Path2 path2, String... strArr) {
        return (List) executeCommand(this.commandObjects.jsonMGet(path2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public <T> List<T> jsonMGet(Path path, Class<T> cls, String... strArr) {
        return (List) executeCommand(this.commandObjects.jsonMGet(path, cls, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonDel(String str) {
        return ((Long) executeCommand(this.commandObjects.jsonDel(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonDel(String str, Path2 path2) {
        return ((Long) executeCommand(this.commandObjects.jsonDel(str, path2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonDel(String str, Path path) {
        return ((Long) executeCommand(this.commandObjects.jsonDel(str, path))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonClear(String str) {
        return ((Long) executeCommand(this.commandObjects.jsonClear(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonClear(String str, Path2 path2) {
        return ((Long) executeCommand(this.commandObjects.jsonClear(str, path2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonClear(String str, Path path) {
        return ((Long) executeCommand(this.commandObjects.jsonClear(str, path))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Boolean> jsonToggle(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonToggle(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public String jsonToggle(String str, Path path) {
        return (String) executeCommand(this.commandObjects.jsonToggle(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Class<?> jsonType(String str) {
        return (Class) executeCommand(this.commandObjects.jsonType(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Class<?>> jsonType(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonType(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Class<?> jsonType(String str, Path path) {
        return (Class) executeCommand(this.commandObjects.jsonType(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonStrAppend(String str, Object obj) {
        return ((Long) executeCommand(this.commandObjects.jsonStrAppend(str, obj))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonStrAppend(String str, Path2 path2, Object obj) {
        return (List) executeCommand(this.commandObjects.jsonStrAppend(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonStrAppend(String str, Path path, Object obj) {
        return ((Long) executeCommand(this.commandObjects.jsonStrAppend(str, path, obj))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonStrLen(String str) {
        return (Long) executeCommand(this.commandObjects.jsonStrLen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonStrLen(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonStrLen(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonStrLen(String str, Path path) {
        return (Long) executeCommand(this.commandObjects.jsonStrLen(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public JSONArray jsonNumIncrBy(String str, Path2 path2, double d) {
        return (JSONArray) executeCommand(this.commandObjects.jsonNumIncrBy(str, path2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public double jsonNumIncrBy(String str, Path path, double d) {
        return ((Double) executeCommand(this.commandObjects.jsonNumIncrBy(str, path, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrAppend(String str, Path2 path2, Object... objArr) {
        return (List) executeCommand(this.commandObjects.jsonArrAppend(str, path2, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrAppendWithEscape(String str, Path2 path2, Object... objArr) {
        return (List) executeCommand(this.commandObjects.jsonArrAppendWithEscape(str, path2, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonArrAppend(String str, Path path, Object... objArr) {
        return (Long) executeCommand(this.commandObjects.jsonArrAppend(str, path, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrIndex(String str, Path2 path2, Object obj) {
        return (List) executeCommand(this.commandObjects.jsonArrIndex(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrIndexWithEscape(String str, Path2 path2, Object obj) {
        return (List) executeCommand(this.commandObjects.jsonArrIndexWithEscape(str, path2, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonArrIndex(String str, Path path, Object obj) {
        return ((Long) executeCommand(this.commandObjects.jsonArrIndex(str, path, obj))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrInsert(String str, Path2 path2, int i, Object... objArr) {
        return (List) executeCommand(this.commandObjects.jsonArrInsert(str, path2, i, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrInsertWithEscape(String str, Path2 path2, int i, Object... objArr) {
        return (List) executeCommand(this.commandObjects.jsonArrInsertWithEscape(str, path2, i, objArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonArrInsert(String str, Path path, int i, Object... objArr) {
        return ((Long) executeCommand(this.commandObjects.jsonArrInsert(str, path, i, objArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Object jsonArrPop(String str) {
        return executeCommand(this.commandObjects.jsonArrPop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public <T> T jsonArrPop(String str, Class<T> cls) {
        return (T) executeCommand(this.commandObjects.jsonArrPop(str, cls));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Object> jsonArrPop(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonArrPop(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Object jsonArrPop(String str, Path path) {
        return executeCommand(this.commandObjects.jsonArrPop(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public <T> T jsonArrPop(String str, Class<T> cls, Path path) {
        return (T) executeCommand(this.commandObjects.jsonArrPop(str, cls, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Object> jsonArrPop(String str, Path2 path2, int i) {
        return (List) executeCommand(this.commandObjects.jsonArrPop(str, path2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Object jsonArrPop(String str, Path path, int i) {
        return executeCommand(this.commandObjects.jsonArrPop(str, path, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public <T> T jsonArrPop(String str, Class<T> cls, Path path, int i) {
        return (T) executeCommand(this.commandObjects.jsonArrPop(str, cls, path, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonArrLen(String str) {
        return (Long) executeCommand(this.commandObjects.jsonArrLen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrLen(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonArrLen(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonArrLen(String str, Path path) {
        return (Long) executeCommand(this.commandObjects.jsonArrLen(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonArrTrim(String str, Path2 path2, int i, int i2) {
        return (List) executeCommand(this.commandObjects.jsonArrTrim(str, path2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonArrTrim(String str, Path path, int i, int i2) {
        return (Long) executeCommand(this.commandObjects.jsonArrTrim(str, path, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonObjLen(String str) {
        return (Long) executeCommand(this.commandObjects.jsonObjLen(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public Long jsonObjLen(String str, Path path) {
        return (Long) executeCommand(this.commandObjects.jsonObjLen(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonObjLen(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonObjLen(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<String> jsonObjKeys(String str) {
        return (List) executeCommand(this.commandObjects.jsonObjKeys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<String> jsonObjKeys(String str, Path path) {
        return (List) executeCommand(this.commandObjects.jsonObjKeys(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<List<String>> jsonObjKeys(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonObjKeys(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonDebugMemory(String str) {
        return ((Long) executeCommand(this.commandObjects.jsonDebugMemory(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public long jsonDebugMemory(String str, Path path) {
        return ((Long) executeCommand(this.commandObjects.jsonDebugMemory(str, path))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Long> jsonDebugMemory(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonDebugMemory(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Object> jsonResp(String str) {
        return (List) executeCommand(this.commandObjects.jsonResp(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<Object> jsonResp(String str, Path path) {
        return (List) executeCommand(this.commandObjects.jsonResp(str, path));
    }

    @Override // me.module.multiserver.library.redis.jedis.json.RedisJsonCommands
    public List<List<Object>> jsonResp(String str, Path2 path2) {
        return (List) executeCommand(this.commandObjects.jsonResp(str, path2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public String tsCreate(String str) {
        return (String) executeCommand(this.commandObjects.tsCreate(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public String tsCreate(String str, TSCreateParams tSCreateParams) {
        return (String) executeCommand(this.commandObjects.tsCreate(str, tSCreateParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsDel(String str, long j, long j2) {
        return ((Long) executeCommand(this.commandObjects.tsDel(str, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public String tsAlter(String str, TSAlterParams tSAlterParams) {
        return (String) executeCommand(this.commandObjects.tsAlter(str, tSAlterParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsAdd(String str, double d) {
        return ((Long) executeCommand(this.commandObjects.tsAdd(str, d))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsAdd(String str, long j, double d) {
        return ((Long) executeCommand(this.commandObjects.tsAdd(str, j, d))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsAdd(String str, long j, double d, TSCreateParams tSCreateParams) {
        return ((Long) executeCommand(this.commandObjects.tsAdd(str, j, d, tSCreateParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<Long> tsMAdd(Map.Entry<String, TSElement>... entryArr) {
        return (List) executeCommand(this.commandObjects.tsMAdd(entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsIncrBy(String str, double d) {
        return ((Long) executeCommand(this.commandObjects.tsIncrBy(str, d))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsIncrBy(String str, double d, long j) {
        return ((Long) executeCommand(this.commandObjects.tsIncrBy(str, d, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsDecrBy(String str, double d) {
        return ((Long) executeCommand(this.commandObjects.tsDecrBy(str, d))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public long tsDecrBy(String str, double d, long j) {
        return ((Long) executeCommand(this.commandObjects.tsDecrBy(str, d, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSElement> tsRange(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.tsRange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSElement> tsRange(String str, TSRangeParams tSRangeParams) {
        return (List) executeCommand(this.commandObjects.tsRange(str, tSRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSElement> tsRevRange(String str, long j, long j2) {
        return (List) executeCommand(this.commandObjects.tsRevRange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSElement> tsRevRange(String str, TSRangeParams tSRangeParams) {
        return (List) executeCommand(this.commandObjects.tsRevRange(str, tSRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSKeyedElements> tsMRange(long j, long j2, String... strArr) {
        return (List) executeCommand(this.commandObjects.tsMRange(j, j2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSKeyedElements> tsMRange(TSMRangeParams tSMRangeParams) {
        return (List) executeCommand(this.commandObjects.tsMRange(tSMRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSKeyedElements> tsMRevRange(long j, long j2, String... strArr) {
        return (List) executeCommand(this.commandObjects.tsMRevRange(j, j2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSKeyedElements> tsMRevRange(TSMRangeParams tSMRangeParams) {
        return (List) executeCommand(this.commandObjects.tsMRevRange(tSMRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public TSElement tsGet(String str) {
        return (TSElement) executeCommand(this.commandObjects.tsGet(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public TSElement tsGet(String str, TSGetParams tSGetParams) {
        return (TSElement) executeCommand(this.commandObjects.tsGet(str, tSGetParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<TSKeyValue<TSElement>> tsMGet(TSMGetParams tSMGetParams, String... strArr) {
        return (List) executeCommand(this.commandObjects.tsMGet(tSMGetParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public String tsCreateRule(String str, String str2, AggregationType aggregationType, long j) {
        return (String) executeCommand(this.commandObjects.tsCreateRule(str, str2, aggregationType, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public String tsCreateRule(String str, String str2, AggregationType aggregationType, long j, long j2) {
        return (String) executeCommand(this.commandObjects.tsCreateRule(str, str2, aggregationType, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public String tsDeleteRule(String str, String str2) {
        return (String) executeCommand(this.commandObjects.tsDeleteRule(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public List<String> tsQueryIndex(String... strArr) {
        return (List) executeCommand(this.commandObjects.tsQueryIndex(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public TSInfo tsInfo(String str) {
        return (TSInfo) this.executor.executeCommand(this.commandObjects.tsInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands
    public TSInfo tsInfoDebug(String str) {
        return (TSInfo) executeCommand(this.commandObjects.tsInfoDebug(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public String bfReserve(String str, double d, long j) {
        return (String) executeCommand(this.commandObjects.bfReserve(str, d, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public String bfReserve(String str, double d, long j, BFReserveParams bFReserveParams) {
        return (String) executeCommand(this.commandObjects.bfReserve(str, d, j, bFReserveParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public boolean bfAdd(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.bfAdd(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public List<Boolean> bfMAdd(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.bfMAdd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public List<Boolean> bfInsert(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.bfInsert(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public List<Boolean> bfInsert(String str, BFInsertParams bFInsertParams, String... strArr) {
        return (List) executeCommand(this.commandObjects.bfInsert(str, bFInsertParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public boolean bfExists(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.bfExists(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public List<Boolean> bfMExists(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.bfMExists(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public Map.Entry<Long, byte[]> bfScanDump(String str, long j) {
        return (Map.Entry) executeCommand(this.commandObjects.bfScanDump(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public String bfLoadChunk(String str, long j, byte[] bArr) {
        return (String) executeCommand(this.commandObjects.bfLoadChunk(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.BloomFilterCommands
    public Map<String, Object> bfInfo(String str) {
        return (Map) executeCommand(this.commandObjects.bfInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public String cfReserve(String str, long j) {
        return (String) executeCommand(this.commandObjects.cfReserve(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public String cfReserve(String str, long j, CFReserveParams cFReserveParams) {
        return (String) executeCommand(this.commandObjects.cfReserve(str, j, cFReserveParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public boolean cfAdd(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.cfAdd(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public boolean cfAddNx(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.cfAddNx(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public List<Boolean> cfInsert(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.cfInsert(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public List<Boolean> cfInsert(String str, CFInsertParams cFInsertParams, String... strArr) {
        return (List) executeCommand(this.commandObjects.cfInsert(str, cFInsertParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public List<Boolean> cfInsertNx(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.cfInsertNx(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public List<Boolean> cfInsertNx(String str, CFInsertParams cFInsertParams, String... strArr) {
        return (List) executeCommand(this.commandObjects.cfInsertNx(str, cFInsertParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public boolean cfExists(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.cfExists(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public List<Boolean> cfMExists(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.cfMExists(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public boolean cfDel(String str, String str2) {
        return ((Boolean) executeCommand(this.commandObjects.cfDel(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public long cfCount(String str, String str2) {
        return ((Long) executeCommand(this.commandObjects.cfCount(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public Map.Entry<Long, byte[]> cfScanDump(String str, long j) {
        return (Map.Entry) executeCommand(this.commandObjects.cfScanDump(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public String cfLoadChunk(String str, long j, byte[] bArr) {
        return (String) executeCommand(this.commandObjects.cfLoadChunk(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CuckooFilterCommands
    public Map<String, Object> cfInfo(String str) {
        return (Map) executeCommand(this.commandObjects.cfInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public String cmsInitByDim(String str, long j, long j2) {
        return (String) executeCommand(this.commandObjects.cmsInitByDim(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public String cmsInitByProb(String str, double d, double d2) {
        return (String) executeCommand(this.commandObjects.cmsInitByProb(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public List<Long> cmsIncrBy(String str, Map<String, Long> map) {
        return (List) executeCommand(this.commandObjects.cmsIncrBy(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public List<Long> cmsQuery(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.cmsQuery(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public String cmsMerge(String str, String... strArr) {
        return (String) executeCommand(this.commandObjects.cmsMerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public String cmsMerge(String str, Map<String, Long> map) {
        return (String) executeCommand(this.commandObjects.cmsMerge(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.CountMinSketchCommands
    public Map<String, Object> cmsInfo(String str) {
        return (Map) executeCommand(this.commandObjects.cmsInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public String topkReserve(String str, long j) {
        return (String) executeCommand(this.commandObjects.topkReserve(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public String topkReserve(String str, long j, long j2, long j3, double d) {
        return (String) executeCommand(this.commandObjects.topkReserve(str, j, j2, j3, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public List<String> topkAdd(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.topkAdd(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public List<String> topkIncrBy(String str, Map<String, Long> map) {
        return (List) executeCommand(this.commandObjects.topkIncrBy(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public List<Boolean> topkQuery(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.topkQuery(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public List<Long> topkCount(String str, String... strArr) {
        return (List) executeCommand(this.commandObjects.topkCount(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public List<String> topkList(String str) {
        return (List) executeCommand(this.commandObjects.topkList(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TopKFilterCommands
    public Map<String, Object> topkInfo(String str) {
        return (Map) executeCommand(this.commandObjects.topkInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public String tdigestCreate(String str) {
        return (String) executeCommand(this.commandObjects.tdigestCreate(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public String tdigestCreate(String str, int i) {
        return (String) executeCommand(this.commandObjects.tdigestCreate(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public String tdigestReset(String str) {
        return (String) executeCommand(this.commandObjects.tdigestReset(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public String tdigestMerge(String str, String... strArr) {
        return (String) executeCommand(this.commandObjects.tdigestMerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public String tdigestMerge(TDigestMergeParams tDigestMergeParams, String str, String... strArr) {
        return (String) executeCommand(this.commandObjects.tdigestMerge(tDigestMergeParams, str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public Map<String, Object> tdigestInfo(String str) {
        return (Map) executeCommand(this.commandObjects.tdigestInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public String tdigestAdd(String str, double... dArr) {
        return (String) executeCommand(this.commandObjects.tdigestAdd(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public List<Double> tdigestCDF(String str, double... dArr) {
        return (List) executeCommand(this.commandObjects.tdigestCDF(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public List<Double> tdigestQuantile(String str, double... dArr) {
        return (List) executeCommand(this.commandObjects.tdigestQuantile(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public double tdigestMin(String str) {
        return ((Double) executeCommand(this.commandObjects.tdigestMin(str))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public double tdigestMax(String str) {
        return ((Double) executeCommand(this.commandObjects.tdigestMax(str))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public double tdigestTrimmedMean(String str, double d, double d2) {
        return ((Double) executeCommand(this.commandObjects.tdigestTrimmedMean(str, d, d2))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public List<Long> tdigestRank(String str, double... dArr) {
        return (List) executeCommand(this.commandObjects.tdigestRank(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public List<Long> tdigestRevRank(String str, double... dArr) {
        return (List) executeCommand(this.commandObjects.tdigestRevRank(str, dArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public List<Double> tdigestByRank(String str, long... jArr) {
        return (List) executeCommand(this.commandObjects.tdigestByRank(str, jArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.bloom.commands.TDigestSketchCommands
    public List<Double> tdigestByRevRank(String str, long... jArr) {
        return (List) executeCommand(this.commandObjects.tdigestByRevRank(str, jArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphQuery(String str, String str2) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphQuery(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphReadonlyQuery(String str, String str2) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphQuery(String str, String str2, long j) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphQuery(str, str2, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphReadonlyQuery(String str, String str2, long j) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphQuery(String str, String str2, Map<String, Object> map) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphQuery(str, str2, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphReadonlyQuery(String str, String str2, Map<String, Object> map) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphQuery(String str, String str2, Map<String, Object> map, long j) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphQuery(str, str2, map, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public ResultSet graphReadonlyQuery(String str, String str2, Map<String, Object> map, long j) {
        return (ResultSet) executeCommand(this.graphCommandObjects.graphReadonlyQuery(str, str2, map, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public String graphDelete(String str) {
        return (String) executeCommand(this.graphCommandObjects.graphDelete(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public List<String> graphList() {
        return (List) executeCommand(this.commandObjects.graphList());
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public List<String> graphProfile(String str, String str2) {
        return (List) executeCommand(this.commandObjects.graphProfile(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public List<String> graphExplain(String str, String str2) {
        return (List) executeCommand(this.commandObjects.graphExplain(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public List<List<String>> graphSlowlog(String str) {
        return (List) executeCommand(this.commandObjects.graphSlowlog(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public String graphConfigSet(String str, Object obj) {
        return (String) executeCommand(this.commandObjects.graphConfigSet(str, obj));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands
    public Map<String, Object> graphConfigGet(String str) {
        return (Map) executeCommand(this.commandObjects.graphConfigGet(str));
    }

    public Object sendCommand(ProtocolCommand protocolCommand) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand));
    }

    public Object sendCommand(ProtocolCommand protocolCommand, byte[]... bArr) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(bArr));
    }

    public Object sendBlockingCommand(ProtocolCommand protocolCommand, byte[]... bArr) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(bArr).blocking());
    }

    public Object sendCommand(ProtocolCommand protocolCommand, String... strArr) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(strArr));
    }

    public Object sendBlockingCommand(ProtocolCommand protocolCommand, String... strArr) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(strArr).blocking());
    }

    public Object sendCommand(byte[] bArr, ProtocolCommand protocolCommand, byte[]... bArr2) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(bArr2).processKey(bArr));
    }

    public Object sendBlockingCommand(byte[] bArr, ProtocolCommand protocolCommand, byte[]... bArr2) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(bArr2).blocking().processKey(bArr));
    }

    public Object sendCommand(String str, ProtocolCommand protocolCommand, String... strArr) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(strArr).processKey(str));
    }

    public Object sendBlockingCommand(String str, ProtocolCommand protocolCommand, String... strArr) {
        return executeCommand(this.commandObjects.commandArguments(protocolCommand).addObjects(strArr).blocking().processKey(str));
    }

    public Object executeCommand(CommandArguments commandArguments) {
        return executeCommand(new CommandObject(commandArguments, BuilderFactory.RAW_OBJECT));
    }
}
