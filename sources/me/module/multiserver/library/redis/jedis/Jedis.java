package me.module.multiserver.library.redis.jedis;

import java.io.Closeable;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import me.module.multiserver.library.redis.jedis.args.BitCountOption;
import me.module.multiserver.library.redis.jedis.args.BitOP;
import me.module.multiserver.library.redis.jedis.args.ClientPauseMode;
import me.module.multiserver.library.redis.jedis.args.ClientType;
import me.module.multiserver.library.redis.jedis.args.ClusterFailoverOption;
import me.module.multiserver.library.redis.jedis.args.ClusterResetType;
import me.module.multiserver.library.redis.jedis.args.ExpiryOption;
import me.module.multiserver.library.redis.jedis.args.FlushMode;
import me.module.multiserver.library.redis.jedis.args.FunctionRestorePolicy;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;
import me.module.multiserver.library.redis.jedis.args.ListDirection;
import me.module.multiserver.library.redis.jedis.args.ListPosition;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.args.SaveMode;
import me.module.multiserver.library.redis.jedis.args.SortedSetOption;
import me.module.multiserver.library.redis.jedis.args.UnblockType;
import me.module.multiserver.library.redis.jedis.commands.ClusterCommands;
import me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands;
import me.module.multiserver.library.redis.jedis.commands.ControlCommands;
import me.module.multiserver.library.redis.jedis.commands.DatabaseCommands;
import me.module.multiserver.library.redis.jedis.commands.GenericControlCommands;
import me.module.multiserver.library.redis.jedis.commands.JedisBinaryCommands;
import me.module.multiserver.library.redis.jedis.commands.JedisCommands;
import me.module.multiserver.library.redis.jedis.commands.ModuleCommands;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.commands.SentinelCommands;
import me.module.multiserver.library.redis.jedis.commands.ServerCommands;
import me.module.multiserver.library.redis.jedis.exceptions.InvalidURIException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.params.BitPosParams;
import me.module.multiserver.library.redis.jedis.params.ClientKillParams;
import me.module.multiserver.library.redis.jedis.params.CommandListFilterByParams;
import me.module.multiserver.library.redis.jedis.params.FailoverParams;
import me.module.multiserver.library.redis.jedis.params.GeoAddParams;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusParam;
import me.module.multiserver.library.redis.jedis.params.GeoRadiusStoreParam;
import me.module.multiserver.library.redis.jedis.params.GeoSearchParam;
import me.module.multiserver.library.redis.jedis.params.GetExParams;
import me.module.multiserver.library.redis.jedis.params.LCSParams;
import me.module.multiserver.library.redis.jedis.params.LPosParams;
import me.module.multiserver.library.redis.jedis.params.LolwutParams;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;
import me.module.multiserver.library.redis.jedis.params.RestoreParams;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.params.SetParams;
import me.module.multiserver.library.redis.jedis.params.ShutdownParams;
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
import me.module.multiserver.library.redis.jedis.resps.AccessControlLogEntry;
import me.module.multiserver.library.redis.jedis.resps.AccessControlUser;
import me.module.multiserver.library.redis.jedis.resps.CommandDocument;
import me.module.multiserver.library.redis.jedis.resps.CommandInfo;
import me.module.multiserver.library.redis.jedis.resps.FunctionStats;
import me.module.multiserver.library.redis.jedis.resps.GeoRadiusResponse;
import me.module.multiserver.library.redis.jedis.resps.KeyedListElement;
import me.module.multiserver.library.redis.jedis.resps.KeyedZSetElement;
import me.module.multiserver.library.redis.jedis.resps.LCSMatchResult;
import me.module.multiserver.library.redis.jedis.resps.LibraryInfo;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.resps.Slowlog;
import me.module.multiserver.library.redis.jedis.resps.StreamConsumersInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamFullInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamGroupInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingSummary;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.util.JedisURIHelper;
import me.module.multiserver.library.redis.jedis.util.KeyValue;
import me.module.multiserver.library.redis.jedis.util.Pool;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Jedis.class */
public class Jedis implements Closeable, ClusterCommands, ControlBinaryCommands, ControlCommands, DatabaseCommands, GenericControlCommands, JedisBinaryCommands, JedisCommands, ModuleCommands, SentinelCommands, ServerCommands {
    protected final Connection connection;
    private final CommandObjects commandObjects;
    private int db;
    private Transaction transaction;
    private boolean isInMulti;
    private boolean isInWatch;
    private Pipeline pipeline;
    protected static final byte[][] DUMMY_ARRAY = new byte[0][];
    private Pool<Jedis> dataSource;

    public Jedis() {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = new Connection();
    }

    public Jedis(String str) {
        this(URI.create(str));
    }

    public Jedis(HostAndPort hostAndPort) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = new Connection(hostAndPort);
    }

    public Jedis(String str, int i) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = new Connection(str, i);
    }

    public Jedis(String str, int i, JedisClientConfig jedisClientConfig) {
        this(new HostAndPort(str, i), jedisClientConfig);
    }

    public Jedis(HostAndPort hostAndPort, JedisClientConfig jedisClientConfig) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = new Connection(hostAndPort, jedisClientConfig);
    }

    public Jedis(String str, int i, boolean z) {
        this(str, i, DefaultJedisClientConfig.builder().ssl(z).build());
    }

    public Jedis(String str, int i, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(str, i, DefaultJedisClientConfig.builder().ssl(z).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    public Jedis(String str, int i, int i2) {
        this(str, i, i2, i2);
    }

    public Jedis(String str, int i, int i2, boolean z) {
        this(str, i, i2, i2, z);
    }

    public Jedis(String str, int i, int i2, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(str, i, i2, i2, z, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public Jedis(String str, int i, int i2, int i3) {
        this(str, i, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i2).socketTimeoutMillis(i3).build());
    }

    public Jedis(String str, int i, int i2, int i3, int i4) {
        this(str, i, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i2).socketTimeoutMillis(i3).blockingSocketTimeoutMillis(i4).build());
    }

    public Jedis(String str, int i, int i2, int i3, boolean z) {
        this(str, i, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i2).socketTimeoutMillis(i3).ssl(z).build());
    }

    public Jedis(String str, int i, int i2, int i3, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(str, i, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i2).socketTimeoutMillis(i3).ssl(z).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    public Jedis(String str, int i, int i2, int i3, int i4, boolean z, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(str, i, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i2).socketTimeoutMillis(i3).blockingSocketTimeoutMillis(i4).ssl(z).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    public Jedis(URI uri) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        if (!JedisURIHelper.isValid(uri)) {
            throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI \"%s\".", uri.toString()));
        }
        this.connection = new Connection(new HostAndPort(uri.getHost(), uri.getPort()), DefaultJedisClientConfig.builder().user(JedisURIHelper.getUser(uri)).password(JedisURIHelper.getPassword(uri)).database(JedisURIHelper.getDBIndex(uri)).ssl(JedisURIHelper.isRedisSSLScheme(uri)).build());
    }

    public Jedis(URI uri, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(uri, DefaultJedisClientConfig.builder().sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    public Jedis(URI uri, int i) {
        this(uri, i, i);
    }

    public Jedis(URI uri, int i, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(uri, i, i, sSLSocketFactory, sSLParameters, hostnameVerifier);
    }

    public Jedis(URI uri, int i, int i2) {
        this(uri, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).build());
    }

    public Jedis(URI uri, int i, int i2, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(uri, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    public Jedis(URI uri, int i, int i2, int i3, SSLSocketFactory sSLSocketFactory, SSLParameters sSLParameters, HostnameVerifier hostnameVerifier) {
        this(uri, DefaultJedisClientConfig.builder().connectionTimeoutMillis(i).socketTimeoutMillis(i2).blockingSocketTimeoutMillis(i3).sslSocketFactory(sSLSocketFactory).sslParameters(sSLParameters).hostnameVerifier(hostnameVerifier).build());
    }

    public Jedis(URI uri, JedisClientConfig jedisClientConfig) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        if (!JedisURIHelper.isValid(uri)) {
            throw new InvalidURIException(String.format("Cannot open Redis connection due invalid URI \"%s\".", uri.toString()));
        }
        this.connection = new Connection(new HostAndPort(uri.getHost(), uri.getPort()), DefaultJedisClientConfig.builder().connectionTimeoutMillis(jedisClientConfig.getConnectionTimeoutMillis()).socketTimeoutMillis(jedisClientConfig.getSocketTimeoutMillis()).blockingSocketTimeoutMillis(jedisClientConfig.getBlockingSocketTimeoutMillis()).user(JedisURIHelper.getUser(uri)).password(JedisURIHelper.getPassword(uri)).database(JedisURIHelper.getDBIndex(uri)).clientName(jedisClientConfig.getClientName()).ssl(JedisURIHelper.isRedisSSLScheme(uri)).sslSocketFactory(jedisClientConfig.getSslSocketFactory()).sslParameters(jedisClientConfig.getSslParameters()).hostnameVerifier(jedisClientConfig.getHostnameVerifier()).build());
    }

    public Jedis(JedisSocketFactory jedisSocketFactory) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = new Connection(jedisSocketFactory);
    }

    public Jedis(JedisSocketFactory jedisSocketFactory, JedisClientConfig jedisClientConfig) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = new Connection(jedisSocketFactory, jedisClientConfig);
    }

    public Jedis(Connection connection) {
        this.commandObjects = new CommandObjects();
        this.db = 0;
        this.transaction = null;
        this.isInMulti = false;
        this.isInWatch = false;
        this.pipeline = null;
        this.dataSource = null;
        this.connection = connection;
    }

    public String toString() {
        return "Jedis{" + this.connection + '}';
    }

    public Connection getClient() {
        return getConnection();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void connect() {
        this.connection.connect();
    }

    public void disconnect() {
        this.connection.disconnect();
    }

    public boolean isConnected() {
        return this.connection.isConnected();
    }

    public boolean isBroken() {
        return this.connection.isBroken();
    }

    public void resetState() {
        if (isConnected()) {
            if (this.transaction != null) {
                this.transaction.close();
            }
            if (this.pipeline != null) {
                this.pipeline.close();
            }
            if (this.isInWatch) {
                this.connection.sendCommand(Protocol.Command.UNWATCH);
                this.connection.getStatusCodeReply();
                this.isInWatch = false;
            }
        }
        this.transaction = null;
        this.pipeline = null;
    }

    protected void setDataSource(Pool<Jedis> pool) {
        this.dataSource = pool;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.dataSource == null) {
            this.connection.close();
            return;
        }
        Pool<Jedis> pool = this.dataSource;
        this.dataSource = null;
        if (isBroken()) {
            pool.returnBrokenResource(this);
        } else {
            pool.returnResource(this);
        }
    }

    public Transaction multi() {
        this.transaction = new Transaction(this);
        return this.transaction;
    }

    public Pipeline pipelined() {
        this.pipeline = new Pipeline(this);
        return this.pipeline;
    }

    protected void checkIsInMultiOrPipeline() {
        if (this.transaction != null) {
            throw new IllegalStateException("Cannot use Jedis when in Multi. Please use Transaction or reset jedis state.");
        }
        if (this.pipeline != null && this.pipeline.hasPipelinedResponse()) {
            throw new IllegalStateException("Cannot use Jedis when in Pipeline. Please use Pipeline or reset jedis state.");
        }
    }

    public int getDB() {
        return this.db;
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public boolean copy(byte[] bArr, byte[] bArr2, int i, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.copy(bArr, bArr2, i, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public boolean copy(byte[] bArr, byte[] bArr2, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.copy(bArr, bArr2, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String ping() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PING);
        return this.connection.getStatusCodeReply();
    }

    public byte[] ping(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PING, bArr);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String set(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.set(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String set(byte[] bArr, byte[] bArr2, SetParams setParams) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.set(bArr, bArr2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] get(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.get(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] setGet(byte[] bArr, byte[] bArr2, SetParams setParams) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.setGet(bArr, bArr2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getDel(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.getDel(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getEx(byte[] bArr, GetExParams getExParams) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.getEx(bArr, getExParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String quit() {
        checkIsInMultiOrPipeline();
        return this.connection.quit();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long exists(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.exists(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public boolean exists(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.exists(bArr))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long del(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.del(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long del(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.del(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long unlink(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.unlink(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long unlink(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.unlink(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String type(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.type(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String flushDB() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.FLUSHDB);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String flushDB(FlushMode flushMode) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.FLUSHDB, flushMode.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Set<byte[]> keys(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.keys(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public byte[] randomBinaryKey() {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.randomBinaryKey());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String rename(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.rename(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long renamenx(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.renamenx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public long dbSize() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.DBSIZE);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expire(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expire(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expire(byte[] bArr, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expire(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpire(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpire(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpire(byte[] bArr, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpire(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expireTime(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expireTime(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpireTime(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpireTime(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expireAt(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expireAt(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long expireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expireAt(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpireAt(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpireAt(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pexpireAt(byte[] bArr, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpireAt(bArr, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long ttl(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.ttl(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long touch(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.touch(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long touch(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.touch(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String select(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.SELECT, Protocol.toByteArray(i));
        String statusCodeReply = this.connection.getStatusCodeReply();
        this.db = i;
        return statusCodeReply;
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String swapDB(int i, int i2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.SWAPDB, Protocol.toByteArray(i), Protocol.toByteArray(i2));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public long move(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MOVE, bArr, Protocol.toByteArray(i));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String flushAll() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.FLUSHALL);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String flushAll(FlushMode flushMode) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.FLUSHALL, flushMode.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getSet(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.getSet(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public List<byte[]> mget(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.mget(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long setnx(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.setnx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String setex(byte[] bArr, long j, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.setex(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String mset(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.mset(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long msetnx(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.msetnx(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long decrBy(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.decrBy(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long decr(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.decr(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long incrBy(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.incrBy(bArr, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public double incrByFloat(byte[] bArr, double d) {
        checkIsInMultiOrPipeline();
        return ((Double) this.connection.executeCommand(this.commandObjects.incrByFloat(bArr, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long incr(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.incr(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long append(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.append(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] substr(byte[] bArr, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.substr(bArr, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hset(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hset(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hset(byte[] bArr, Map<byte[], byte[]> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hset(bArr, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public byte[] hget(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.hget(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hsetnx(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hsetnx(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public String hmset(byte[] bArr, Map<byte[], byte[]> map) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.hmset(bArr, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public List<byte[]> hmget(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.hmget(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hincrBy(byte[] bArr, byte[] bArr2, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hincrBy(bArr, bArr2, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public double hincrByFloat(byte[] bArr, byte[] bArr2, double d) {
        checkIsInMultiOrPipeline();
        return ((Double) this.connection.executeCommand(this.commandObjects.hincrByFloat(bArr, bArr2, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public boolean hexists(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.hexists(bArr, bArr2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hdel(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hdel(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hlen(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hlen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public Set<byte[]> hkeys(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.hkeys(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public List<byte[]> hvals(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.hvals(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public Map<byte[], byte[]> hgetAll(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (Map) this.connection.executeCommand(this.commandObjects.hgetAll(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public byte[] hrandfield(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.hrandfield(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public List<byte[]> hrandfield(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.hrandfield(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public Map<byte[], byte[]> hrandfieldWithValues(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return (Map) this.connection.executeCommand(this.commandObjects.hrandfieldWithValues(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long rpush(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.rpush(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long lpush(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.lpush(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long llen(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.llen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> lrange(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.lrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public String ltrim(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.ltrim(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] lindex(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.lindex(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public String lset(byte[] bArr, long j, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.lset(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long lrem(byte[] bArr, long j, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.lrem(bArr, j, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] lpop(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.lpop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> lpop(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.lpop(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public Long lpos(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.lpos(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public Long lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.lpos(bArr, bArr2, lPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<Long> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.lpos(bArr, bArr2, lPosParams, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] rpop(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.rpop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> rpop(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.rpop(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] rpoplpush(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.rpoplpush(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sadd(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sadd(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> smembers(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.smembers(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long srem(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.srem(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public byte[] spop(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.spop(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> spop(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.spop(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long smove(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.smove(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long scard(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.scard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public boolean sismember(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.sismember(bArr, bArr2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public List<Boolean> smismember(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.smismember(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> sinter(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.sinter(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sinterstore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sinterstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sintercard(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sintercard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sintercard(int i, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sintercard(i, bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> sunion(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.sunion(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sunionstore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sunionstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public Set<byte[]> sdiff(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.sdiff(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public long sdiffstore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sdiffstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public byte[] srandmember(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.srandmember(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public List<byte[]> srandmember(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.srandmember(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, double d, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(bArr, d, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(bArr, d, bArr2, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, Map<byte[], Double> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(bArr, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zadd(byte[] bArr, Map<byte[], Double> map, ZAddParams zAddParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(bArr, map, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Double zaddIncr(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.zaddIncr(bArr, d, bArr2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrange(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zrem(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zrem(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public double zincrby(byte[] bArr, double d, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Double) this.connection.executeCommand(this.commandObjects.zincrby(bArr, d, bArr2))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Double zincrby(byte[] bArr, double d, byte[] bArr2, ZIncrByParams zIncrByParams) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.zincrby(bArr, d, bArr2, zIncrByParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Long zrank(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.zrank(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Long zrevrank(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.zrevrank(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrange(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrange(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeWithScores(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeWithScores(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeWithScores(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeWithScores(bArr, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrange(byte[] bArr, ZRangeParams zRangeParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrange(bArr, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeWithScores(byte[] bArr, ZRangeParams zRangeParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeWithScores(bArr, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zrangestore(byte[] bArr, byte[] bArr2, ZRangeParams zRangeParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zrangestore(bArr, bArr2, zRangeParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public byte[] zrandmember(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.zrandmember(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrandmember(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrandmember(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrandmemberWithScores(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrandmemberWithScores(bArr, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zcard(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zcard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Double zscore(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.zscore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Double> zmscore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zmscore(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Tuple zpopmax(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (Tuple) this.connection.executeCommand(this.commandObjects.zpopmax(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zpopmax(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zpopmax(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Tuple zpopmin(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (Tuple) this.connection.executeCommand(this.commandObjects.zpopmin(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zpopmin(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zpopmin(bArr, i));
    }

    public String watch(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.WATCH, bArr);
        String statusCodeReply = this.connection.getStatusCodeReply();
        this.isInWatch = true;
        return statusCodeReply;
    }

    public String unwatch() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.UNWATCH);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public List<byte[]> sort(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.sort(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public List<byte[]> sort(byte[] bArr, SortingParams sortingParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.sort(bArr, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sort(bArr, sortingParams, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long sort(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sort(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public List<byte[]> sortReadonly(byte[] bArr, SortingParams sortingParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.sortReadonly(bArr, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] lmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.lmove(bArr, bArr2, listDirection, listDirection2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] blmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2, double d) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.blmove(bArr, bArr2, listDirection, listDirection2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> blpop(int i, byte[]... bArr) {
        return (List) this.connection.executeCommand(this.commandObjects.blpop(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> blpop(double d, byte[]... bArr) {
        return (List) this.connection.executeCommand(this.commandObjects.blpop(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> brpop(int i, byte[]... bArr) {
        return (List) this.connection.executeCommand(this.commandObjects.brpop(i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public List<byte[]> brpop(double d, byte[]... bArr) {
        return (List) this.connection.executeCommand(this.commandObjects.brpop(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> lmpop(ListDirection listDirection, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.lmpop(listDirection, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> lmpop(ListDirection listDirection, int i, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.lmpop(listDirection, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> blmpop(long j, ListDirection listDirection, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.blmpop(j, listDirection, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public KeyValue<byte[], List<byte[]>> blmpop(long j, ListDirection listDirection, int i, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.blmpop(j, listDirection, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> bzpopmax(double d, byte[]... bArr) {
        return (List) this.connection.executeCommand(this.commandObjects.bzpopmax(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> bzpopmin(double d, byte[]... bArr) {
        return (List) this.connection.executeCommand(this.commandObjects.bzpopmin(d, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String auth(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.AUTH, str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String auth(String str, String str2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.AUTH, str, str2);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zcount(byte[] bArr, double d, double d2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zcount(bArr, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zcount(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<byte[]> zdiff(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zdiff(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<Tuple> zdiffWithScores(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zdiffWithScores(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zdiffStore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zdiffStore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByRank(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByRank(bArr, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByScore(byte[] bArr, double d, double d2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByScore(bArr, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByScore(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<byte[]> zunion(ZParams zParams, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zunion(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<Tuple> zunionWithScores(ZParams zParams, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zunionWithScores(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zunionstore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zunionstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zunionstore(bArr, zParams, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<byte[]> zinter(ZParams zParams, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zinter(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public Set<Tuple> zinterWithScores(ZParams zParams, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zinterWithScores(zParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zinterstore(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zinterstore(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zinterstore(bArr, zParams, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zintercard(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zintercard(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zintercard(long j, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zintercard(j, bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zlexcount(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zlexcount(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByLex(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByLex(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public List<byte[]> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByLex(bArr, bArr2, bArr3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public long zremrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByLex(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> zmpop(SortedSetOption sortedSetOption, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.zmpop(sortedSetOption, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.zmpop(sortedSetOption, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public KeyValue<byte[], List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, int i, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, i, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String save() {
        this.connection.sendCommand(Protocol.Command.SAVE);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String bgsave() {
        this.connection.sendCommand(Protocol.Command.BGSAVE);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String bgsaveSchedule() {
        this.connection.sendCommand(Protocol.Command.BGSAVE, Protocol.Keyword.SCHEDULE);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String bgrewriteaof() {
        this.connection.sendCommand(Protocol.Command.BGREWRITEAOF);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public long lastsave() {
        this.connection.sendCommand(Protocol.Command.LASTSAVE);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public void shutdown() {
        this.connection.sendCommand(Protocol.Command.SHUTDOWN);
        try {
            throw new JedisException(this.connection.getStatusCodeReply());
        } catch (JedisConnectionException e) {
            this.connection.setBroken();
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    @Deprecated
    public void shutdown(SaveMode saveMode) {
        this.connection.sendCommand(Protocol.Command.SHUTDOWN, saveMode.getRaw());
        try {
            throw new JedisException(this.connection.getStatusCodeReply());
        } catch (JedisConnectionException e) {
            this.connection.setBroken();
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public void shutdown(ShutdownParams shutdownParams) {
        this.connection.sendCommand(new CommandArguments(Protocol.Command.SHUTDOWN).addParams(shutdownParams));
        try {
            throw new JedisException(this.connection.getStatusCodeReply());
        } catch (JedisConnectionException e) {
            this.connection.setBroken();
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String shutdownAbort() {
        this.connection.sendCommand(Protocol.Command.SHUTDOWN, Protocol.Keyword.ABORT);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String info() {
        this.connection.sendCommand(Protocol.Command.INFO);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String info(String str) {
        this.connection.sendCommand(Protocol.Command.INFO, str);
        return this.connection.getBulkReply();
    }

    public void monitor(JedisMonitor jedisMonitor) {
        this.connection.sendCommand(Protocol.Command.MONITOR);
        this.connection.getStatusCodeReply();
        jedisMonitor.proceed(this.connection);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    @Deprecated
    public String slaveof(String str, int i) {
        this.connection.sendCommand(Protocol.Command.SLAVEOF, SafeEncoder.encode(str), Protocol.toByteArray(i));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    @Deprecated
    public String slaveofNoOne() {
        this.connection.sendCommand(Protocol.Command.SLAVEOF, Protocol.Keyword.NO.getRaw(), Protocol.Keyword.ONE.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String replicaof(String str, int i) {
        this.connection.sendCommand(Protocol.Command.REPLICAOF, SafeEncoder.encode(str), Protocol.toByteArray(i));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String replicaofNoOne() {
        this.connection.sendCommand(Protocol.Command.REPLICAOF, Protocol.Keyword.NO.getRaw(), Protocol.Keyword.ONE.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands
    public List<Object> roleBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ROLE);
        return BuilderFactory.RAW_OBJECT_LIST.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public List<byte[]> configGet(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, Protocol.Keyword.GET.getRaw(), bArr);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public List<byte[]> configGet(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, joinParameters(Protocol.Keyword.GET.getRaw(), bArr));
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public String configResetStat() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, Protocol.Keyword.RESETSTAT);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public String configRewrite() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, Protocol.Keyword.REWRITE);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public String configSet(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, Protocol.Keyword.SET.getRaw(), bArr, bArr2);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public String configSet(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, joinParameters(Protocol.Keyword.SET.getRaw(), bArr));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long strlen(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.strlen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    @Deprecated
    public LCSMatchResult strAlgoLCSKeys(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        checkIsInMultiOrPipeline();
        return (LCSMatchResult) this.connection.executeCommand(this.commandObjects.strAlgoLCSKeys(bArr, bArr2, strAlgoLCSParams));
    }

    @Deprecated
    public LCSMatchResult strAlgoLCSStrings(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams) {
        checkIsInMultiOrPipeline();
        return (LCSMatchResult) this.connection.executeCommand(this.commandObjects.strAlgoLCSStrings(bArr, bArr2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public LCSMatchResult lcs(byte[] bArr, byte[] bArr2, LCSParams lCSParams) {
        checkIsInMultiOrPipeline();
        return (LCSMatchResult) this.connection.executeCommand(this.commandObjects.lcs(bArr, bArr2, lCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long lpushx(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.lpushx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long persist(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.persist(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long rpushx(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.rpushx(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public byte[] echo(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ECHO, bArr);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public long linsert(byte[] bArr, ListPosition listPosition, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.linsert(bArr, listPosition, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListBinaryCommands
    public byte[] brpoplpush(byte[] bArr, byte[] bArr2, int i) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.brpoplpush(bArr, bArr2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public boolean setbit(byte[] bArr, long j, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.setbit(bArr, j, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public boolean getbit(byte[] bArr, long j) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.getbit(bArr, j))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitpos(byte[] bArr, boolean z) {
        return bitpos(bArr, z, new BitPosParams());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitpos(byte[] bArr, boolean z, BitPosParams bitPosParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitpos(bArr, z, bitPosParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long setrange(byte[] bArr, long j, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.setrange(bArr, j, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public byte[] getrange(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.getrange(bArr, j, j2));
    }

    public long publish(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.publish(bArr, bArr2))).longValue();
    }

    public void subscribe(BinaryJedisPubSub binaryJedisPubSub, byte[]... bArr) {
        binaryJedisPubSub.proceed(this.connection, bArr);
    }

    public void psubscribe(BinaryJedisPubSub binaryJedisPubSub, byte[]... bArr) {
        binaryJedisPubSub.proceedWithPatterns(this.connection, bArr);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object eval(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.eval(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalReadonly(bArr, list, list2));
    }

    protected static byte[][] getParamsWithBinary(List<byte[]> list, List<byte[]> list2) {
        int size = list.size();
        int size2 = list2.size();
        byte[][] bArr = new byte[size + size2][];
        for (int i = 0; i < size; i++) {
            bArr[i] = list.get(i);
        }
        for (int i2 = 0; i2 < size2; i2++) {
            bArr[size + i2] = list2.get(i2);
        }
        return bArr;
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object eval(byte[] bArr, int i, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.eval(bArr, i, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object eval(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.eval(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalsha(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalsha(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalsha(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalsha(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalshaReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalshaReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyBinaryCommands
    public Object evalsha(byte[] bArr, int i, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalsha(bArr, i, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public String scriptFlush() {
        this.connection.sendCommand(Protocol.Command.SCRIPT, Protocol.Keyword.FLUSH);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public String scriptFlush(FlushMode flushMode) {
        this.connection.sendCommand(Protocol.Command.SCRIPT, Protocol.Keyword.FLUSH.getRaw(), flushMode.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public Boolean scriptExists(byte[] bArr) {
        return scriptExists(bArr).get(0);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public List<Boolean> scriptExists(byte[]... bArr) {
        this.connection.sendCommand(Protocol.Command.SCRIPT, joinParameters(Protocol.Keyword.EXISTS.getRaw(), bArr));
        return BuilderFactory.BOOLEAN_LIST.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public byte[] scriptLoad(byte[] bArr) {
        this.connection.sendCommand(Protocol.Command.SCRIPT, Protocol.Keyword.LOAD.getRaw(), bArr);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public String scriptKill() {
        this.connection.sendCommand(Protocol.Command.SCRIPT, Protocol.Keyword.KILL);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SlowlogCommands
    public String slowlogReset() {
        this.connection.sendCommand(Protocol.Command.SLOWLOG, Protocol.Keyword.RESET);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SlowlogCommands
    public long slowlogLen() {
        this.connection.sendCommand(Protocol.Command.SLOWLOG, Protocol.Keyword.LEN);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SlowlogCommands
    public List<Object> slowlogGetBinary() {
        this.connection.sendCommand(Protocol.Command.SLOWLOG, Protocol.Keyword.GET);
        return this.connection.getObjectMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SlowlogCommands
    public List<Object> slowlogGetBinary(long j) {
        this.connection.sendCommand(Protocol.Command.SLOWLOG, Protocol.Keyword.GET.getRaw(), Protocol.toByteArray(j));
        return this.connection.getObjectMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands, me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long objectRefcount(byte[] bArr) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.REFCOUNT.getRaw(), bArr);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands, me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public byte[] objectEncoding(byte[] bArr) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.ENCODING.getRaw(), bArr);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands, me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long objectIdletime(byte[] bArr) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.IDLETIME.getRaw(), bArr);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands
    public List<byte[]> objectHelpBinary() {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.HELP);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands, me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long objectFreq(byte[] bArr) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.FREQ.getRaw(), bArr);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitcount(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitcount(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitcount(byte[] bArr, long j, long j2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitcount(bArr, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitcount(byte[] bArr, long j, long j2, BitCountOption bitCountOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitcount(bArr, j, j2, bitCountOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public long bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitop(bitOP, bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public byte[] dump(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.dump(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String restore(byte[] bArr, long j, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.restore(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String restore(byte[] bArr, long j, byte[] bArr2, RestoreParams restoreParams) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.restore(bArr, j, bArr2, restoreParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public long pttl(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pttl(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public String psetex(byte[] bArr, long j, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.psetex(bArr, j, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands
    public byte[] memoryDoctorBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.DOCTOR);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands, me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long memoryUsage(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.USAGE.getRaw(), bArr);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlBinaryCommands, me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public Long memoryUsage(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.USAGE.getRaw(), bArr, Protocol.Keyword.SAMPLES.getRaw(), Protocol.toByteArray(i));
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GenericControlCommands
    public String failover() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.FAILOVER);
        this.connection.setTimeoutInfinite();
        try {
            return this.connection.getStatusCodeReply();
        } finally {
            this.connection.rollbackTimeout();
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GenericControlCommands
    public String failover(FailoverParams failoverParams) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(new ClusterCommandArguments(Protocol.Command.FAILOVER).addParams(failoverParams));
        this.connection.setTimeoutInfinite();
        try {
            return this.connection.getStatusCodeReply();
        } finally {
            this.connection.rollbackTimeout();
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GenericControlCommands
    public String failoverAbort() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.FAILOVER, Protocol.Keyword.ABORT);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public byte[] aclWhoAmIBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.WHOAMI);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public byte[] aclGenPassBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.GENPASS);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public byte[] aclGenPassBinary(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.GENPASS.getRaw(), Protocol.toByteArray(i));
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public List<byte[]> aclListBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LIST);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public List<byte[]> aclUsersBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.USERS);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public AccessControlUser aclGetUser(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.GETUSER.getRaw(), bArr);
        return BuilderFactory.ACCESS_CONTROL_USER.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public String aclSetUser(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.SETUSER.getRaw(), bArr);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public String aclSetUser(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, joinParameters(Protocol.Keyword.SETUSER.getRaw(), bArr, bArr2));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public long aclDelUser(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.DELUSER.getRaw(), bArr);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public long aclDelUser(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, joinParameters(Protocol.Keyword.DELUSER.getRaw(), bArr, bArr2));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public List<byte[]> aclCatBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.CAT);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public List<byte[]> aclCat(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.CAT.getRaw(), bArr);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public List<byte[]> aclLogBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LOG);
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public List<byte[]> aclLogBinary(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LOG.getRaw(), Protocol.toByteArray(i));
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands, me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclLogReset() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LOG.getRaw(), Protocol.Keyword.RESET.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public String clientKill(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.KILL.getRaw(), bArr);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientKill(String str, int i) {
        return clientKill(str + ':' + i);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public long clientKill(ClientKillParams clientKillParams) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, joinParameters(Protocol.Keyword.KILL.getRaw(), clientKillParams.getByteParams()));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public byte[] clientGetnameBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.GETNAME);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public byte[] clientListBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.LIST);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public byte[] clientListBinary(ClientType clientType) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.LIST.getRaw(), clientType.getRaw());
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public byte[] clientListBinary(long... jArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, clientListParams(jArr));
        return this.connection.getBinaryBulkReply();
    }

    private byte[][] clientListParams(long... jArr) {
        byte[][] bArr = new byte[2 + jArr.length][];
        int i = 0 + 1;
        bArr[0] = Protocol.Keyword.LIST.getRaw();
        int i2 = i + 1;
        bArr[i] = Protocol.Keyword.ID.getRaw();
        for (long j : jArr) {
            int i3 = i2;
            i2++;
            bArr[i3] = Protocol.toByteArray(j);
        }
        return bArr;
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public byte[] clientInfoBinary() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.INFO);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands
    public String clientSetname(byte[] bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.SETNAME.getRaw(), bArr);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public long clientId() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.ID);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public long clientUnblock(long j) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.UNBLOCK.getRaw(), Protocol.toByteArray(j));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public long clientUnblock(long j, UnblockType unblockType) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.UNBLOCK.getRaw(), Protocol.toByteArray(j), unblockType.getRaw());
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientPause(long j) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.PAUSE.getRaw(), Protocol.toByteArray(j));
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientPause(long j, ClientPauseMode clientPauseMode) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.PAUSE.getRaw(), Protocol.toByteArray(j), clientPauseMode.getRaw());
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientNoEvictOn() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, "NO-EVICT", "ON");
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientBinaryCommands, me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientNoEvictOff() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, "NO-EVICT", "OFF");
        return this.connection.getBulkReply();
    }

    public List<String> time() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.TIME);
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String migrate(String str, int i, byte[] bArr, int i2, int i3) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, bArr, i2, i3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, i2, i3, migrateParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String migrate(String str, int i, byte[] bArr, int i2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, bArr, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public String migrate(String str, int i, int i2, MigrateParams migrateParams, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, i2, migrateParams, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public long waitReplicas(int i, long j) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.WAIT, Protocol.toByteArray(i), Protocol.toByteArray(j));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public long pfadd(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pfadd(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public long pfcount(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pfcount(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public String pfmerge(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.pfmerge(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogBinaryCommands
    public long pfcount(byte[]... bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pfcount(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public ScanResult<byte[]> scan(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.scan(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public ScanResult<byte[]> scan(byte[] bArr, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.scan(bArr, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyBinaryCommands
    public ScanResult<byte[]> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.scan(bArr, scanParams, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] bArr, byte[] bArr2) {
        return hscan(bArr, bArr2, new ScanParams());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.hscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public ScanResult<byte[]> sscan(byte[] bArr, byte[] bArr2) {
        return sscan(bArr, bArr2, new ScanParams());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetBinaryCommands
    public ScanResult<byte[]> sscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.sscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public ScanResult<Tuple> zscan(byte[] bArr, byte[] bArr2) {
        return zscan(bArr, bArr2, new ScanParams());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetBinaryCommands
    public ScanResult<Tuple> zscan(byte[] bArr, byte[] bArr2, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.zscan(bArr, bArr2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geoadd(byte[] bArr, double d, double d2, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geoadd(bArr, d, d2, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geoadd(byte[] bArr, Map<byte[], GeoCoordinate> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geoadd(bArr, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geoadd(byte[] bArr, GeoAddParams geoAddParams, Map<byte[], GeoCoordinate> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geoadd(bArr, geoAddParams, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public Double geodist(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.geodist(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public Double geodist(byte[] bArr, byte[] bArr2, byte[] bArr3, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.geodist(bArr, bArr2, bArr3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<byte[]> geohash(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geohash(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoCoordinate> geopos(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geopos(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadius(bArr, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusReadonly(bArr, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadius(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadius(bArr, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long georadiusStore(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.georadiusStore(bArr, d, d2, d3, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusReadonly(byte[] bArr, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusReadonly(bArr, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMember(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMemberReadonly(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMember(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMember(bArr, bArr2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long georadiusByMemberStore(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.georadiusByMemberStore(bArr, bArr2, d, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(bArr, bArr2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(bArr, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, byte[] bArr2, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(bArr, bArr2, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(bArr, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> geosearch(byte[] bArr, GeoSearchParam geoSearchParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(bArr, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, bArr3, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoCoordinate, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, byte[] bArr3, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, bArr3, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoCoordinate, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStore(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(bArr, bArr2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public long geosearchStoreStoreDist(byte[] bArr, byte[] bArr2, GeoSearchParam geoSearchParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStoreStoreDist(bArr, bArr2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoBinaryCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(byte[] bArr, byte[] bArr2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMemberReadonly(bArr, bArr2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public List<Long> bitfield(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.bitfield(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringBinaryCommands
    public List<Long> bitfieldReadonly(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.bitfieldReadonly(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashBinaryCommands
    public long hstrlen(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hstrlen(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xread(XReadParams xReadParams, Map.Entry<byte[], byte[]>... entryArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xread(xReadParams, entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xreadGroup(byte[] bArr, byte[] bArr2, XReadGroupParams xReadGroupParams, Map.Entry<byte[], byte[]>... entryArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xreadGroup(bArr, bArr2, xReadGroupParams, entryArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public byte[] xadd(byte[] bArr, XAddParams xAddParams, Map<byte[], byte[]> map) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.xadd(bArr, xAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xlen(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xlen(bArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrange(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrange(bArr, bArr2, bArr3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrevrange(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrevrange(bArr, bArr2, bArr3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xack(byte[] bArr, byte[] bArr2, byte[]... bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xack(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public String xgroupCreate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.xgroupCreate(bArr, bArr2, bArr3, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public String xgroupSetID(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.xgroupSetID(bArr, bArr2, bArr3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xgroupDestroy(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xgroupDestroy(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public boolean xgroupCreateConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.xgroupCreateConsumer(bArr, bArr2, bArr3))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xgroupDelConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xgroupDelConsumer(bArr, bArr2, bArr3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xdel(byte[] bArr, byte[]... bArr2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xdel(bArr, bArr2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xtrim(byte[] bArr, long j, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xtrim(bArr, j, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public long xtrim(byte[] bArr, XTrimParams xTrimParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xtrim(bArr, xTrimParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    @Deprecated
    public List<Object> xpending(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xpending(bArr, bArr2, bArr3, bArr4, i, bArr5));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xpending(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.xpending(bArr, bArr2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xpending(byte[] bArr, byte[] bArr2, XPendingParams xPendingParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xpending(bArr, bArr2, xPendingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xclaim(bArr, bArr2, bArr3, j, xClaimParams, bArr4));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<byte[]> xclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xclaimJustId(bArr, bArr2, bArr3, j, xClaimParams, bArr4));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xautoclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xautoclaim(bArr, bArr2, bArr3, j, bArr4, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xautoclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xautoclaimJustId(bArr, bArr2, bArr3, j, bArr4, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xinfoStream(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.xinfoStream(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xinfoStreamFull(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.xinfoStreamFull(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public Object xinfoStreamFull(byte[] bArr, int i) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.xinfoStreamFull(bArr, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    @Deprecated
    public List<Object> xinfoGroup(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xinfoGroup(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xinfoGroups(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xinfoGroups(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamBinaryCommands
    public List<Object> xinfoConsumers(byte[] bArr, byte[] bArr2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xinfoConsumers(bArr, bArr2));
    }

    public Object sendCommand(ProtocolCommand protocolCommand, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(protocolCommand, bArr);
        return this.connection.getOne();
    }

    public Object sendBlockingCommand(ProtocolCommand protocolCommand, byte[]... bArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(protocolCommand, bArr);
        this.connection.setTimeoutInfinite();
        try {
            return this.connection.getOne();
        } finally {
            this.connection.rollbackTimeout();
        }
    }

    public Object sendCommand(ProtocolCommand protocolCommand) {
        return sendCommand(protocolCommand, DUMMY_ARRAY);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public boolean copy(String str, String str2, int i, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.copy(str, str2, i, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public boolean copy(String str, String str2, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.copy(str, str2, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String ping(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PING, str);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String set(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.set(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String set(String str, String str2, SetParams setParams) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.set(str, str2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String get(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.get(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String setGet(String str, String str2, SetParams setParams) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.setGet(str, str2, setParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getDel(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.getDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getEx(String str, GetExParams getExParams) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.getEx(str, getExParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long exists(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.exists(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public boolean exists(String str) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.exists(str))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long del(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.del(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long del(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.del(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long unlink(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.unlink(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long unlink(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.unlink(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String type(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.type(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Set<String> keys(String str) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.keys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String randomKey() {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.randomKey());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String rename(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.rename(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long renamenx(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.renamenx(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expire(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expire(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expire(String str, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expire(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpire(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpire(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpire(String str, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpire(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expireTime(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expireTime(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpireTime(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpireTime(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expireAt(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expireAt(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long expireAt(String str, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.expireAt(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpireAt(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpireAt(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pexpireAt(String str, long j, ExpiryOption expiryOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pexpireAt(str, j, expiryOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long ttl(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.ttl(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long touch(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.touch(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long touch(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.touch(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public long move(String str, int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MOVE, SafeEncoder.encode(str), Protocol.toByteArray(i));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getSet(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.getSet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public List<String> mget(String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.mget(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long setnx(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.setnx(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String setex(String str, long j, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.setex(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String mset(String... strArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.mset(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long msetnx(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.msetnx(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long decrBy(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.decrBy(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long decr(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.decr(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long incrBy(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.incrBy(str, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public double incrByFloat(String str, double d) {
        checkIsInMultiOrPipeline();
        return ((Double) this.connection.executeCommand(this.commandObjects.incrByFloat(str, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long incr(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.incr(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long append(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.append(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String substr(String str, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.substr(str, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hset(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hset(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hset(String str, Map<String, String> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hset(str, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public String hget(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.hget(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hsetnx(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hsetnx(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public String hmset(String str, Map<String, String> map) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.hmset(str, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public List<String> hmget(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.hmget(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hincrBy(String str, String str2, long j) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hincrBy(str, str2, j))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public double hincrByFloat(String str, String str2, double d) {
        checkIsInMultiOrPipeline();
        return ((Double) this.connection.executeCommand(this.commandObjects.hincrByFloat(str, str2, d))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public boolean hexists(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.hexists(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hdel(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hdel(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hlen(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hlen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public Set<String> hkeys(String str) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.hkeys(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public List<String> hvals(String str) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.hvals(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public Map<String, String> hgetAll(String str) {
        checkIsInMultiOrPipeline();
        return (Map) this.connection.executeCommand(this.commandObjects.hgetAll(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public String hrandfield(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.hrandfield(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public List<String> hrandfield(String str, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.hrandfield(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public Map<String, String> hrandfieldWithValues(String str, long j) {
        checkIsInMultiOrPipeline();
        return (Map) this.connection.executeCommand(this.commandObjects.hrandfieldWithValues(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long rpush(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.rpush(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long lpush(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.lpush(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long llen(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.llen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> lrange(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.lrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String ltrim(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.ltrim(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lindex(String str, long j) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.lindex(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lset(String str, long j, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.lset(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long lrem(String str, long j, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.lrem(str, j, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lpop(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.lpop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> lpop(String str, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.lpop(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public Long lpos(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.lpos(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public Long lpos(String str, String str2, LPosParams lPosParams) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.lpos(str, str2, lPosParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<Long> lpos(String str, String str2, LPosParams lPosParams, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.lpos(str, str2, lPosParams, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String rpop(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.rpop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> rpop(String str, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.rpop(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String rpoplpush(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.rpoplpush(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sadd(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sadd(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> smembers(String str) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.smembers(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long srem(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.srem(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public String spop(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.spop(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> spop(String str, long j) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.spop(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long smove(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.smove(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long scard(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.scard(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public boolean sismember(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.sismember(str, str2))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public List<Boolean> smismember(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.smismember(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> sinter(String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.sinter(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sinterstore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sinterstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sintercard(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sintercard(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sintercard(int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sintercard(i, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> sunion(String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.sunion(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sunionstore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sunionstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public Set<String> sdiff(String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.sdiff(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public long sdiffstore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sdiffstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public String srandmember(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.srandmember(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public List<String> srandmember(String str, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.srandmember(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, double d, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(str, d, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, double d, String str2, ZAddParams zAddParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(str, d, str2, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, Map<String, Double> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(str, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zadd(String str, Map<String, Double> map, ZAddParams zAddParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zadd(str, map, zAddParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Double zaddIncr(String str, double d, String str2, ZAddParams zAddParams) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.zaddIncr(str, d, str2, zAddParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<String> zdiff(String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zdiff(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<Tuple> zdiffWithScores(String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zdiffWithScores(strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zdiffStore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zdiffStore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrange(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zrem(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zrem(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public double zincrby(String str, double d, String str2) {
        checkIsInMultiOrPipeline();
        return ((Double) this.connection.executeCommand(this.commandObjects.zincrby(str, d, str2))).doubleValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Double zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.zincrby(str, d, str2, zIncrByParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Long zrank(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.zrank(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Long zrevrank(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (Long) this.connection.executeCommand(this.commandObjects.zrevrank(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrange(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeWithScores(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeWithScores(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeWithScores(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeWithScores(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrange(String str, ZRangeParams zRangeParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrange(str, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeWithScores(String str, ZRangeParams zRangeParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeWithScores(str, zRangeParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zrangestore(String str, String str2, ZRangeParams zRangeParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zrangestore(str, str2, zRangeParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public String zrandmember(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.zrandmember(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrandmember(String str, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrandmember(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrandmemberWithScores(String str, long j) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrandmemberWithScores(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zcard(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zcard(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Double zscore(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.zscore(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Double> zmscore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zmscore(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Tuple zpopmax(String str) {
        checkIsInMultiOrPipeline();
        return (Tuple) this.connection.executeCommand(this.commandObjects.zpopmax(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zpopmax(String str, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zpopmax(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Tuple zpopmin(String str) {
        checkIsInMultiOrPipeline();
        return (Tuple) this.connection.executeCommand(this.commandObjects.zpopmin(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zpopmin(String str, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zpopmin(str, i));
    }

    public String watch(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.WATCH, strArr);
        String statusCodeReply = this.connection.getStatusCodeReply();
        this.isInWatch = true;
        return statusCodeReply;
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public List<String> sort(String str) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.sort(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public List<String> sort(String str, SortingParams sortingParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.sort(str, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long sort(String str, SortingParams sortingParams, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sort(str, sortingParams, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public List<String> sortReadonly(String str, SortingParams sortingParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.sortReadonly(str, sortingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long sort(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.sort(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String lmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.lmove(str, str2, listDirection, listDirection2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String blmove(String str, String str2, ListDirection listDirection, ListDirection listDirection2, double d) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.blmove(str, str2, listDirection, listDirection2, d));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> blpop(int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.blpop(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement blpop(double d, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyedListElement) this.connection.executeCommand(this.commandObjects.blpop(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> brpop(int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.brpop(i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement brpop(double d, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyedListElement) this.connection.executeCommand(this.commandObjects.brpop(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> lmpop(ListDirection listDirection, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.lmpop(listDirection, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> lmpop(ListDirection listDirection, int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.lmpop(listDirection, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> blmpop(long j, ListDirection listDirection, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.blmpop(j, listDirection, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyValue<String, List<String>> blmpop(long j, ListDirection listDirection, int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.blmpop(j, listDirection, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyedZSetElement bzpopmax(double d, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyedZSetElement) this.connection.executeCommand(this.commandObjects.bzpopmax(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyedZSetElement bzpopmin(double d, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyedZSetElement) this.connection.executeCommand(this.commandObjects.bzpopmin(d, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> blpop(int i, String str) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.blpop(i, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement blpop(double d, String str) {
        checkIsInMultiOrPipeline();
        return (KeyedListElement) this.connection.executeCommand(this.commandObjects.blpop(d, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public List<String> brpop(int i, String str) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.brpop(i, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public KeyedListElement brpop(double d, String str) {
        checkIsInMultiOrPipeline();
        return (KeyedListElement) this.connection.executeCommand(this.commandObjects.brpop(d, str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zcount(String str, double d, double d2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zcount(str, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zcount(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zcount(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByScore(String str, String str2, String str3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScore(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByScoreWithScores(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, d, d2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, d, d2, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByScore(String str, String str2, String str3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScore(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByScoreWithScores(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByRank(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByRank(str, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByScore(String str, double d, double d2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByScore(str, d, d2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByScore(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByScore(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<String> zunion(ZParams zParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zunion(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<Tuple> zunionWithScores(ZParams zParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zunionWithScores(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zunionstore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zunionstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zunionstore(String str, ZParams zParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zunionstore(str, zParams, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<String> zinter(ZParams zParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zinter(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public Set<Tuple> zinterWithScores(ZParams zParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return (Set) this.connection.executeCommand(this.commandObjects.zinterWithScores(zParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zintercard(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zintercard(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zintercard(long j, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zintercard(j, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zinterstore(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zinterstore(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zinterstore(String str, ZParams zParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zinterstore(str, zParams, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zlexcount(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zlexcount(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByLex(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrangeByLex(String str, String str2, String str3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrangeByLex(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByLex(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByLex(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public List<String> zrevrangeByLex(String str, String str2, String str3, int i, int i2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.zrevrangeByLex(str, str2, str3, i, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public long zremrangeByLex(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.zremrangeByLex(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.zmpop(sortedSetOption, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.zmpop(sortedSetOption, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public KeyValue<String, List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return (KeyValue) this.connection.executeCommand(this.commandObjects.bzmpop(j, sortedSetOption, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long strlen(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.strlen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    @Deprecated
    public LCSMatchResult strAlgoLCSKeys(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        checkIsInMultiOrPipeline();
        return (LCSMatchResult) this.connection.executeCommand(this.commandObjects.strAlgoLCSKeys(str, str2, strAlgoLCSParams));
    }

    @Deprecated
    public LCSMatchResult strAlgoLCSStrings(String str, String str2, StrAlgoLCSParams strAlgoLCSParams) {
        checkIsInMultiOrPipeline();
        return (LCSMatchResult) this.connection.executeCommand(this.commandObjects.strAlgoLCSStrings(str, str2, strAlgoLCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public LCSMatchResult lcs(String str, String str2, LCSParams lCSParams) {
        checkIsInMultiOrPipeline();
        return (LCSMatchResult) this.connection.executeCommand(this.commandObjects.lcs(str, str2, lCSParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long lpushx(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.lpushx(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long persist(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.persist(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long rpushx(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.rpushx(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String echo(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ECHO, str);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public long linsert(String str, ListPosition listPosition, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.linsert(str, listPosition, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ListCommands
    public String brpoplpush(String str, String str2, int i) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.brpoplpush(str, str2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public boolean setbit(String str, long j, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.setbit(str, j, z))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public boolean getbit(String str, long j) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.getbit(str, j))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long setrange(String str, long j, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.setrange(str, j, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String getrange(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.getrange(str, j, j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitpos(String str, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitpos(str, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitpos(String str, boolean z, BitPosParams bitPosParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitpos(str, z, bitPosParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands
    public List<Object> role() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ROLE);
        return BuilderFactory.ENCODED_OBJECT_LIST.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public List<String> configGet(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, Protocol.Keyword.GET.name(), str);
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public List<String> configGet(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, joinParameters(Protocol.Keyword.GET.name(), strArr));
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public String configSet(String str, String str2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, Protocol.Keyword.SET.name(), str, str2);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ConfigCommands
    public String configSet(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CONFIG, joinParameters(Protocol.Keyword.SET.name(), strArr));
        return this.connection.getStatusCodeReply();
    }

    public long publish(String str, String str2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PUBLISH, str, str2);
        return this.connection.getIntegerReply().longValue();
    }

    public void subscribe(JedisPubSub jedisPubSub, String... strArr) {
        jedisPubSub.proceed(this.connection, strArr);
    }

    public void psubscribe(JedisPubSub jedisPubSub, String... strArr) {
        jedisPubSub.proceedWithPatterns(this.connection, strArr);
    }

    public List<String> pubsubChannels() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PUBSUB, Protocol.Keyword.CHANNELS);
        return this.connection.getMultiBulkReply();
    }

    public List<String> pubsubChannels(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PUBSUB, Protocol.Keyword.CHANNELS.name(), str);
        return this.connection.getMultiBulkReply();
    }

    public Long pubsubNumPat() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PUBSUB, Protocol.Keyword.NUMPAT);
        return this.connection.getIntegerReply();
    }

    public Map<String, Long> pubsubNumSub(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.PUBSUB, joinParameters(Protocol.Keyword.NUMSUB.name(), strArr));
        return BuilderFactory.PUBSUB_NUMSUB_MAP.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object eval(String str, int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.eval(str, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object eval(String str, List<String> list, List<String> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.eval(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalReadonly(String str, List<String> list, List<String> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object eval(String str) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.eval(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalsha(String str) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalsha(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalsha(String str, List<String> list, List<String> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalsha(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalshaReadonly(String str, List<String> list, List<String> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalshaReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingKeyCommands
    public Object evalsha(String str, int i, String... strArr) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.evalsha(str, i, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public Boolean scriptExists(String str) {
        return scriptExists(str).get(0);
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public List<Boolean> scriptExists(String... strArr) {
        this.connection.sendCommand(Protocol.Command.SCRIPT, joinParameters(Protocol.Keyword.EXISTS.name(), strArr));
        return BuilderFactory.BOOLEAN_LIST.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ScriptingControlCommands
    public String scriptLoad(String str) {
        this.connection.sendCommand(Protocol.Command.SCRIPT, Protocol.Keyword.LOAD.name(), str);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SlowlogCommands
    public List<Slowlog> slowlogGet() {
        this.connection.sendCommand(Protocol.Command.SLOWLOG, Protocol.Keyword.GET);
        return Slowlog.from(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SlowlogCommands
    public List<Slowlog> slowlogGet(long j) {
        this.connection.sendCommand(Protocol.Command.SLOWLOG, Protocol.Keyword.GET.getRaw(), Protocol.toByteArray(j));
        return Slowlog.from(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands, me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long objectRefcount(String str) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.REFCOUNT.name(), str);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands, me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String objectEncoding(String str) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.ENCODING.name(), str);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands, me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long objectIdletime(String str) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.IDLETIME.name(), str);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands
    public List<String> objectHelp() {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.HELP);
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands, me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long objectFreq(String str) {
        this.connection.sendCommand(Protocol.Command.OBJECT, Protocol.Keyword.FREQ.name(), str);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitcount(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitcount(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitcount(String str, long j, long j2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitcount(str, j, j2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitcount(String str, long j, long j2, BitCountOption bitCountOption) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitcount(str, j, j2, bitCountOption))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public long bitop(BitOP bitOP, String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.bitop(bitOP, str, strArr))).longValue();
    }

    public long commandCount() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.COMMAND, Protocol.Keyword.COUNT);
        return this.connection.getIntegerReply().longValue();
    }

    public Map<String, CommandDocument> commandDocs(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.COMMAND, joinParameters(Protocol.Keyword.DOCS.name(), strArr));
        return BuilderFactory.COMMAND_DOCS_RESPONSE.build(this.connection.getOne());
    }

    public List<String> commandGetKeys(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.COMMAND, joinParameters(Protocol.Keyword.GETKEYS.name(), strArr));
        return BuilderFactory.STRING_LIST.build(this.connection.getOne());
    }

    public List<KeyValue<String, List<String>>> commandGetKeysAndFlags(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.COMMAND, joinParameters(Protocol.Keyword.GETKEYSANDFLAGS.name(), strArr));
        return BuilderFactory.KEYED_STRING_LIST_LIST.build(this.connection.getOne());
    }

    public Map<String, CommandInfo> commandInfo(String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.COMMAND, joinParameters(Protocol.Keyword.INFO.name(), strArr));
        return BuilderFactory.COMMAND_INFO_RESPONSE.build(this.connection.getOne());
    }

    public List<String> commandList() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.COMMAND, Protocol.Keyword.LIST);
        return BuilderFactory.STRING_LIST.build(this.connection.getOne());
    }

    public List<String> commandListFilterBy(CommandListFilterByParams commandListFilterByParams) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(new CommandArguments(Protocol.Command.COMMAND).add(Protocol.Keyword.LIST).addParams(commandListFilterByParams));
        return BuilderFactory.STRING_LIST.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public String sentinelMyId() {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.MYID);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public List<Map<String, String>> sentinelMasters() {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.MASTERS);
        Stream<Object> stream = this.connection.getObjectMultiBulkReply().stream();
        Builder<Map<String, String>> builder = BuilderFactory.STRING_MAP;
        builder.getClass();
        return (List) stream.map(builder::build).collect(Collectors.toList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public Map<String, String> sentinelMaster(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.MASTER.name(), str);
        return BuilderFactory.STRING_MAP.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public List<Map<String, String>> sentinelSentinels(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.SENTINELS.name(), str);
        Stream<Object> stream = this.connection.getObjectMultiBulkReply().stream();
        Builder<Map<String, String>> builder = BuilderFactory.STRING_MAP;
        builder.getClass();
        return (List) stream.map(builder::build).collect(Collectors.toList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public List<String> sentinelGetMasterAddrByName(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.GET_MASTER_ADDR_BY_NAME.getRaw(), SafeEncoder.encode(str));
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public Long sentinelReset(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.RESET.name(), str);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    @Deprecated
    public List<Map<String, String>> sentinelSlaves(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.SLAVES.name(), str);
        Stream<Object> stream = this.connection.getObjectMultiBulkReply().stream();
        Builder<Map<String, String>> builder = BuilderFactory.STRING_MAP;
        builder.getClass();
        return (List) stream.map(builder::build).collect(Collectors.toList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public List<Map<String, String>> sentinelReplicas(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.REPLICAS.name(), str);
        Stream<Object> stream = this.connection.getObjectMultiBulkReply().stream();
        Builder<Map<String, String>> builder = BuilderFactory.STRING_MAP;
        builder.getClass();
        return (List) stream.map(builder::build).collect(Collectors.toList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public String sentinelFailover(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.FAILOVER.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public String sentinelMonitor(String str, String str2, int i, int i2) {
        this.connection.sendCommand(new CommandArguments(Protocol.Command.SENTINEL).add(Protocol.SentinelKeyword.MONITOR).add(str).add(str2).add(Integer.valueOf(i)).add(Integer.valueOf(i2)));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public String sentinelRemove(String str) {
        this.connection.sendCommand(Protocol.Command.SENTINEL, Protocol.SentinelKeyword.REMOVE.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SentinelCommands
    public String sentinelSet(String str, Map<String, String> map) {
        CommandArguments commandArgumentsAdd = new CommandArguments(Protocol.Command.SENTINEL).add(Protocol.SentinelKeyword.SET).add(str);
        map.entrySet().forEach(entry -> {
            commandArgumentsAdd.add(entry.getKey()).add(entry.getValue());
        });
        this.connection.sendCommand(commandArgumentsAdd);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public byte[] dump(String str) {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.dump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String restore(String str, long j, byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.restore(str, j, bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String restore(String str, long j, byte[] bArr, RestoreParams restoreParams) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.restore(str, j, bArr, restoreParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public long pttl(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pttl(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public String psetex(String str, long j, String str2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.psetex(str, j, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclSetUser(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.SETUSER.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclSetUser(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, joinParameters(Protocol.Keyword.SETUSER.name(), str, strArr));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public long aclDelUser(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.DELUSER.name(), str);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public long aclDelUser(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, joinParameters(Protocol.Keyword.DELUSER.name(), str, strArr));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public AccessControlUser aclGetUser(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.GETUSER.name(), str);
        return BuilderFactory.ACCESS_CONTROL_USER.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public List<String> aclUsers() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.USERS);
        return BuilderFactory.STRING_LIST.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public List<String> aclList() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LIST);
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclWhoAmI() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.WHOAMI);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public List<String> aclCat() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.CAT);
        return BuilderFactory.STRING_LIST.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public List<String> aclCat(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.CAT.name(), str);
        return BuilderFactory.STRING_LIST.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public List<AccessControlLogEntry> aclLog() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LOG);
        return BuilderFactory.ACCESS_CONTROL_LOG_ENTRY_LIST.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public List<AccessControlLogEntry> aclLog(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LOG.getRaw(), Protocol.toByteArray(i));
        return BuilderFactory.ACCESS_CONTROL_LOG_ENTRY_LIST.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands, me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclLoad() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.LOAD);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands, me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclSave() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.SAVE);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclGenPass() {
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.GENPASS);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclGenPass(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ACL, Protocol.Keyword.GENPASS.getRaw(), Protocol.toByteArray(i));
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclDryRun(String str, String str2, String... strArr) {
        checkIsInMultiOrPipeline();
        String[] strArr2 = new String[3 + strArr.length];
        strArr2[0] = Protocol.Keyword.DRYRUN.name();
        strArr2[1] = str;
        strArr2[2] = str2;
        System.arraycopy(strArr, 0, strArr2, 3, strArr.length);
        this.connection.sendCommand(Protocol.Command.ACL, strArr2);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogCommands
    public String aclDryRun(String str, CommandArguments commandArguments) {
        checkIsInMultiOrPipeline();
        CommandArguments commandArgumentsAdd = new CommandArguments(Protocol.Command.ACL).add(Protocol.Keyword.DRYRUN).add(str);
        Iterator<Rawable> it = commandArguments.iterator();
        while (it.hasNext()) {
            commandArgumentsAdd.add(it.next());
        }
        this.connection.sendCommand(commandArgumentsAdd);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public byte[] aclDryRunBinary(byte[] bArr, byte[] bArr2, byte[]... bArr3) {
        checkIsInMultiOrPipeline();
        byte[][] bArr4 = new byte[3 + bArr3.length][];
        bArr4[0] = Protocol.Keyword.DRYRUN.getRaw();
        bArr4[1] = bArr;
        bArr4[2] = bArr2;
        System.arraycopy(bArr3, 0, bArr4, 3, bArr3.length);
        this.connection.sendCommand(Protocol.Command.ACL, bArr4);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.AccessControlLogBinaryCommands
    public byte[] aclDryRunBinary(byte[] bArr, CommandArguments commandArguments) {
        checkIsInMultiOrPipeline();
        CommandArguments commandArgumentsAdd = new CommandArguments(Protocol.Command.ACL).add(Protocol.Keyword.DRYRUN).add(bArr);
        Iterator<Rawable> it = commandArguments.iterator();
        while (it.hasNext()) {
            commandArgumentsAdd.add(it.next());
        }
        this.connection.sendCommand(commandArgumentsAdd);
        return this.connection.getBinaryBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientKill(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.KILL.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientGetname() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.GETNAME);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientList() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.LIST);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientList(ClientType clientType) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.LIST.getRaw(), Protocol.Keyword.TYPE.getRaw(), clientType.getRaw());
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientList(long... jArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, clientListParams(jArr));
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientInfo() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.INFO);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClientCommands
    public String clientSetname(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLIENT, Protocol.Keyword.SETNAME.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String migrate(String str, int i, String str2, int i2, int i3) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, str2, i2, i3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.DatabaseCommands
    public String migrate(String str, int i, int i2, int i3, MigrateParams migrateParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, i2, i3, migrateParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String migrate(String str, int i, String str2, int i2) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, str2, i2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public String migrate(String str, int i, int i2, MigrateParams migrateParams, String... strArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.migrate(str, i, i2, migrateParams, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public ScanResult<String> scan(String str) {
        return (ScanResult) this.connection.executeCommand(this.commandObjects.scan(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public ScanResult<String> scan(String str, ScanParams scanParams) {
        return (ScanResult) this.connection.executeCommand(this.commandObjects.scan(str, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public ScanResult<String> scan(String str, ScanParams scanParams, String str2) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.scan(str, scanParams, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public ScanResult<Map.Entry<String, String>> hscan(String str, String str2, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.hscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SetCommands
    public ScanResult<String> sscan(String str, String str2, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.sscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.SortedSetCommands
    public ScanResult<Tuple> zscan(String str, String str2, ScanParams scanParams) {
        checkIsInMultiOrPipeline();
        return (ScanResult) this.connection.executeCommand(this.commandObjects.zscan(str, str2, scanParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String readonly() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.READONLY);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String readwrite() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.READWRITE);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterNodes() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.NODES);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterMeet(String str, int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.MEET.name(), str, Integer.toString(i));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterReset() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.RESET);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterReset(ClusterResetType clusterResetType) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.RESET.getRaw(), clusterResetType.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterAddSlots(int... iArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, joinParameters(Protocol.ClusterKeyword.ADDSLOTS.getRaw(), joinParameters(iArr)));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterDelSlots(int... iArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, joinParameters(Protocol.ClusterKeyword.DELSLOTS.getRaw(), joinParameters(iArr)));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterInfo() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.INFO);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public List<String> clusterGetKeysInSlot(int i, int i2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.GETKEYSINSLOT.getRaw(), Protocol.toByteArray(i), Protocol.toByteArray(i2));
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public List<byte[]> clusterGetKeysInSlotBinary(int i, int i2) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.GETKEYSINSLOT.getRaw(), Protocol.toByteArray(i), Protocol.toByteArray(i2));
        return this.connection.getBinaryMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterSetSlotNode(int i, String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SETSLOT.getRaw(), Protocol.toByteArray(i), Protocol.ClusterKeyword.NODE.getRaw(), SafeEncoder.encode(str));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterSetSlotMigrating(int i, String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SETSLOT.getRaw(), Protocol.toByteArray(i), Protocol.ClusterKeyword.MIGRATING.getRaw(), SafeEncoder.encode(str));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterSetSlotImporting(int i, String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SETSLOT.getRaw(), Protocol.toByteArray(i), Protocol.ClusterKeyword.IMPORTING.getRaw(), SafeEncoder.encode(str));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterSetSlotStable(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SETSLOT.getRaw(), Protocol.toByteArray(i), Protocol.ClusterKeyword.STABLE.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterForget(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.FORGET.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterFlushSlots() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.FLUSHSLOTS);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public long clusterKeySlot(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.KEYSLOT.name(), str);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public long clusterCountFailureReports(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, "COUNT-FAILURE-REPORTS", str);
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public long clusterCountKeysInSlot(int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.COUNTKEYSINSLOT.getRaw(), Protocol.toByteArray(i));
        return this.connection.getIntegerReply().longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterSaveConfig() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SAVECONFIG);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterSetConfigEpoch(long j) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, "SET-CONFIG-EPOCH", Long.toString(j));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterBumpEpoch() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.BUMPEPOCH);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterReplicate(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.REPLICATE.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    @Deprecated
    public List<String> clusterSlaves(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SLAVES.name(), str);
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public List<String> clusterReplicas(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.REPLICAS.name(), str);
        return this.connection.getMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterFailover() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.FAILOVER);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterFailover(ClusterFailoverOption clusterFailoverOption) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.FAILOVER.getRaw(), clusterFailoverOption.getRaw());
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public List<Object> clusterSlots() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.SLOTS);
        return this.connection.getObjectMultiBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterMyId() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.MYID);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public List<Map<String, Object>> clusterLinks() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, Protocol.ClusterKeyword.LINKS);
        Stream<Object> stream = this.connection.getObjectMultiBulkReply().stream();
        Builder<Map<String, Object>> builder = BuilderFactory.ENCODED_OBJECT_MAP;
        builder.getClass();
        return (List) stream.map(builder::build).collect(Collectors.toList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterAddSlotsRange(int... iArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, joinParameters(Protocol.ClusterKeyword.ADDSLOTSRANGE.getRaw(), joinParameters(iArr)));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String clusterDelSlotsRange(int... iArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.CLUSTER, joinParameters(Protocol.ClusterKeyword.DELSLOTSRANGE.getRaw(), joinParameters(iArr)));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ClusterCommands
    public String asking() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.ASKING);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public long pfadd(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pfadd(str, strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public long pfcount(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pfcount(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public long pfcount(String... strArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.pfcount(strArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HyperLogLogCommands
    public String pfmerge(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.pfmerge(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public Object fcall(String str, List<String> list, List<String> list2) {
        return this.connection.executeCommand(this.commandObjects.fcall(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public Object fcallReadonly(String str, List<String> list, List<String> list2) {
        return this.connection.executeCommand(this.commandObjects.fcallReadonly(str, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionDelete(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionDelete(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionLoad(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionLoad(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionLoadReplace(String str) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionLoadReplace(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public FunctionStats functionStats() {
        checkIsInMultiOrPipeline();
        return (FunctionStats) this.connection.executeCommand(this.commandObjects.functionStats());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionFlush() {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionFlush());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionFlush(FlushMode flushMode) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionFlush(flushMode));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionKill() {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionKill());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionList() {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionList());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionList(String str) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionList(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionListWithCode() {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionListWithCode());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public List<LibraryInfo> functionListWithCode(String str) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionListWithCode(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geoadd(String str, double d, double d2, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geoadd(str, d, d2, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geoadd(String str, Map<String, GeoCoordinate> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geoadd(str, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geoadd(String str, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geoadd(str, geoAddParams, map))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public Double geodist(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.geodist(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public Double geodist(String str, String str2, String str3, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (Double) this.connection.executeCommand(this.commandObjects.geodist(str, str2, str3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<String> geohash(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geohash(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoCoordinate> geopos(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geopos(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadius(str, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusReadonly(str, d, d2, d3, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadius(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadius(str, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long georadiusStore(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.georadiusStore(str, d, d2, d3, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusReadonly(String str, double d, double d2, double d3, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusReadonly(str, d, d2, d3, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMember(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMemberReadonly(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMember(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMember(str, str2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long georadiusByMemberStore(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.georadiusByMemberStore(str, str2, d, geoUnit, geoRadiusParam, geoRadiusStoreParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> georadiusByMemberReadonly(String str, String str2, double d, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.georadiusByMemberReadonly(str, str2, d, geoUnit, geoRadiusParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, String str2, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(str, str2, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(str, geoCoordinate, d, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, String str2, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(str, str2, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(str, geoCoordinate, d, d2, geoUnit));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public List<GeoRadiusResponse> geosearch(String str, GeoSearchParam geoSearchParam) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.geosearch(str, geoSearchParam));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, String str3, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(str, str2, str3, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(str, str2, geoCoordinate, d, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, String str3, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(str, str2, str3, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, GeoCoordinate geoCoordinate, double d, double d2, GeoUnit geoUnit) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(str, str2, geoCoordinate, d, d2, geoUnit))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStore(String str, String str2, GeoSearchParam geoSearchParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStore(str, str2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GeoCommands
    public long geosearchStoreStoreDist(String str, String str2, GeoSearchParam geoSearchParam) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.geosearchStoreStoreDist(str, str2, geoSearchParam))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ModuleCommands
    public String moduleLoad(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MODULE, Protocol.Keyword.LOAD.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ModuleCommands
    public String moduleLoad(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MODULE, joinParameters(Protocol.Keyword.LOAD.name(), str, strArr));
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ModuleCommands
    public String moduleUnload(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MODULE, Protocol.Keyword.UNLOAD.name(), str);
        return this.connection.getStatusCodeReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.GenericControlCommands, me.module.multiserver.library.redis.jedis.commands.ModuleCommands
    public List<Module> moduleList() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MODULE, Protocol.Keyword.LIST);
        return BuilderFactory.MODULE_LIST.build(this.connection.getObjectMultiBulkReply());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public List<Long> bitfield(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.bitfield(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StringCommands
    public List<Long> bitfieldReadonly(String str, String... strArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.bitfieldReadonly(str, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.HashCommands
    public long hstrlen(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.hstrlen(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands
    public String memoryDoctor() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.DOCTOR);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands, me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long memoryUsage(String str) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.USAGE.name(), str);
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands, me.module.multiserver.library.redis.jedis.commands.KeyCommands
    public Long memoryUsage(String str, int i) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.USAGE.getRaw(), SafeEncoder.encode(str), Protocol.Keyword.SAMPLES.getRaw(), Protocol.toByteArray(i));
        return this.connection.getIntegerReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands
    public String memoryPurge() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.PURGE);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ControlCommands
    public Map<String, Object> memoryStats() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.MEMORY, Protocol.Keyword.STATS);
        return BuilderFactory.ENCODED_OBJECT_MAP.build(this.connection.getOne());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String lolwut() {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(Protocol.Command.LOLWUT);
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.ServerCommands
    public String lolwut(LolwutParams lolwutParams) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(new CommandArguments(Protocol.Command.LOLWUT).addParams(lolwutParams));
        return this.connection.getBulkReply();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamEntryID xadd(String str, StreamEntryID streamEntryID, Map<String, String> map) {
        checkIsInMultiOrPipeline();
        return (StreamEntryID) this.connection.executeCommand(this.commandObjects.xadd(str, streamEntryID, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamEntryID xadd(String str, XAddParams xAddParams, Map<String, String> map) {
        checkIsInMultiOrPipeline();
        return (StreamEntryID) this.connection.executeCommand(this.commandObjects.xadd(str, xAddParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xlen(String str) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xlen(str))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrange(str, streamEntryID, streamEntryID2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrange(str, streamEntryID, streamEntryID2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrevrange(str, streamEntryID, streamEntryID2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrevrange(str, streamEntryID, streamEntryID2, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrange(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrange(String str, String str2, String str3, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrange(str, str2, str3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrevrange(str, str2, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xrevrange(String str, String str2, String str3, int i) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xrevrange(str, str2, str3, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<Map.Entry<String, List<StreamEntry>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xread(xReadParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xack(String str, String str2, StreamEntryID... streamEntryIDArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xack(str, str2, streamEntryIDArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public String xgroupCreate(String str, String str2, StreamEntryID streamEntryID, boolean z) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.xgroupCreate(str, str2, streamEntryID, z));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public String xgroupSetID(String str, String str2, StreamEntryID streamEntryID) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.xgroupSetID(str, str2, streamEntryID));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xgroupDestroy(String str, String str2) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xgroupDestroy(str, str2))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public boolean xgroupCreateConsumer(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Boolean) this.connection.executeCommand(this.commandObjects.xgroupCreateConsumer(str, str2, str3))).booleanValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xgroupDelConsumer(String str, String str2, String str3) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xgroupDelConsumer(str, str2, str3))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xdel(String str, StreamEntryID... streamEntryIDArr) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xdel(str, streamEntryIDArr))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xtrim(String str, long j, boolean z) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xtrim(str, j, z))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public long xtrim(String str, XTrimParams xTrimParams) {
        checkIsInMultiOrPipeline();
        return ((Long) this.connection.executeCommand(this.commandObjects.xtrim(str, xTrimParams))).longValue();
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<Map.Entry<String, List<StreamEntry>>> xreadGroup(String str, String str2, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xreadGroup(str, str2, xReadGroupParams, map));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamPendingSummary xpending(String str, String str2) {
        checkIsInMultiOrPipeline();
        return (StreamPendingSummary) this.connection.executeCommand(this.commandObjects.xpending(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    @Deprecated
    public List<StreamPendingEntry> xpending(String str, String str2, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i, String str3) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xpending(str, str2, streamEntryID, streamEntryID2, i, str3));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamPendingEntry> xpending(String str, String str2, XPendingParams xPendingParams) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xpending(str, str2, xPendingParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntry> xclaim(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xclaim(str, str2, str3, j, xClaimParams, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamEntryID> xclaimJustId(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.xclaimJustId(str, str2, str3, j, xClaimParams, streamEntryIDArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public Map.Entry<StreamEntryID, List<StreamEntry>> xautoclaim(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        checkIsInMultiOrPipeline();
        return (Map.Entry) this.connection.executeCommand(this.commandObjects.xautoclaim(str, str2, str3, j, streamEntryID, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public Map.Entry<StreamEntryID, List<StreamEntryID>> xautoclaimJustId(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        checkIsInMultiOrPipeline();
        return (Map.Entry) this.connection.executeCommand(this.commandObjects.xautoclaimJustId(str, str2, str3, j, streamEntryID, xAutoClaimParams));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamInfo xinfoStream(String str) {
        return (StreamInfo) this.connection.executeCommand(this.commandObjects.xinfoStream(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamFullInfo xinfoStreamFull(String str) {
        checkIsInMultiOrPipeline();
        return (StreamFullInfo) this.connection.executeCommand(this.commandObjects.xinfoStreamFull(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public StreamFullInfo xinfoStreamFull(String str, int i) {
        checkIsInMultiOrPipeline();
        return (StreamFullInfo) this.connection.executeCommand(this.commandObjects.xinfoStreamFull(str, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    @Deprecated
    public List<StreamGroupInfo> xinfoGroup(String str) {
        return (List) this.connection.executeCommand(this.commandObjects.xinfoGroup(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamGroupInfo> xinfoGroups(String str) {
        return (List) this.connection.executeCommand(this.commandObjects.xinfoGroups(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.StreamCommands
    public List<StreamConsumersInfo> xinfoConsumers(String str, String str2) {
        return (List) this.connection.executeCommand(this.commandObjects.xinfoConsumers(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public Object fcall(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.fcall(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public Object fcallReadonly(byte[] bArr, List<byte[]> list, List<byte[]> list2) {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.fcallReadonly(bArr, list, list2));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public String functionDelete(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionDelete(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public byte[] functionDump() {
        checkIsInMultiOrPipeline();
        return (byte[]) this.connection.executeCommand(this.commandObjects.functionDump());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionListBinary() {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionListBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionList(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionList(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionListWithCodeBinary() {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionListWithCodeBinary());
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public List<Object> functionListWithCode(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (List) this.connection.executeCommand(this.commandObjects.functionListWithCode(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public String functionLoad(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionLoad(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public String functionLoadReplace(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionLoadReplace(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionRestore(byte[] bArr) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionRestore(bArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands, me.module.multiserver.library.redis.jedis.commands.FunctionCommands
    public String functionRestore(byte[] bArr, FunctionRestorePolicy functionRestorePolicy) {
        checkIsInMultiOrPipeline();
        return (String) this.connection.executeCommand(this.commandObjects.functionRestore(bArr, functionRestorePolicy));
    }

    @Override // me.module.multiserver.library.redis.jedis.commands.FunctionBinaryCommands
    public Object functionStatsBinary() {
        checkIsInMultiOrPipeline();
        return this.connection.executeCommand(this.commandObjects.functionStatsBinary());
    }

    public Object sendCommand(ProtocolCommand protocolCommand, String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(protocolCommand, strArr);
        return this.connection.getOne();
    }

    public Object sendBlockingCommand(ProtocolCommand protocolCommand, String... strArr) {
        checkIsInMultiOrPipeline();
        this.connection.sendCommand(protocolCommand, strArr);
        this.connection.setTimeoutInfinite();
        try {
            return this.connection.getOne();
        } finally {
            this.connection.rollbackTimeout();
        }
    }

    private static byte[][] joinParameters(int... iArr) {
        byte[][] bArr = new byte[iArr.length][];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = Protocol.toByteArray(iArr[i]);
        }
        return bArr;
    }

    private static byte[][] joinParameters(byte[] bArr, byte[][] bArr2) {
        byte[][] bArr3 = new byte[bArr2.length + 1][];
        bArr3[0] = bArr;
        System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
        return bArr3;
    }

    private static byte[][] joinParameters(byte[] bArr, byte[] bArr2, byte[][] bArr3) {
        byte[][] bArr4 = new byte[bArr3.length + 2][];
        bArr4[0] = bArr;
        bArr4[1] = bArr2;
        System.arraycopy(bArr3, 0, bArr4, 2, bArr3.length);
        return bArr4;
    }

    private static String[] joinParameters(String str, String[] strArr) {
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    private static String[] joinParameters(String str, String str2, String[] strArr) {
        String[] strArr2 = new String[strArr.length + 2];
        strArr2[0] = str;
        strArr2[1] = str2;
        System.arraycopy(strArr, 0, strArr2, 2, strArr.length);
        return strArr2;
    }
}
