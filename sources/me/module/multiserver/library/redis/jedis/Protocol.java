package me.module.multiserver.library.redis.jedis;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.exceptions.JedisAccessControlException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisAskDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisBusyException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisClusterException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisConnectionException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisMovedDataException;
import me.module.multiserver.library.redis.jedis.exceptions.JedisNoScriptException;
import me.module.multiserver.library.redis.jedis.util.RedisInputStream;
import me.module.multiserver.library.redis.jedis.util.RedisOutputStream;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Protocol.class */
public final class Protocol {
    public static final String DEFAULT_HOST = "127.0.0.1";
    public static final int DEFAULT_PORT = 6379;
    public static final int DEFAULT_SENTINEL_PORT = 26379;
    public static final int DEFAULT_TIMEOUT = 2000;
    public static final int DEFAULT_DATABASE = 0;
    public static final int CLUSTER_HASHSLOTS = 16384;
    public static final byte DOLLAR_BYTE = 36;
    public static final byte ASTERISK_BYTE = 42;
    public static final byte PLUS_BYTE = 43;
    public static final byte MINUS_BYTE = 45;
    public static final byte COLON_BYTE = 58;
    private static final String ASK_PREFIX = "ASK ";
    private static final String MOVED_PREFIX = "MOVED ";
    private static final String CLUSTERDOWN_PREFIX = "CLUSTERDOWN ";
    private static final String BUSY_PREFIX = "BUSY ";
    private static final String NOSCRIPT_PREFIX = "NOSCRIPT ";
    private static final String WRONGPASS_PREFIX = "WRONGPASS";
    private static final String NOPERM_PREFIX = "NOPERM";
    public static final Charset CHARSET = StandardCharsets.UTF_8;
    public static final byte[] BYTES_TRUE = toByteArray(1);
    public static final byte[] BYTES_FALSE = toByteArray(0);
    public static final byte[] BYTES_TILDE = SafeEncoder.encode("~");
    public static final byte[] BYTES_EQUAL = SafeEncoder.encode("=");
    public static final byte[] BYTES_ASTERISK = SafeEncoder.encode(Marker.ANY_MARKER);
    public static final byte[] POSITIVE_INFINITY_BYTES = "+inf".getBytes();
    public static final byte[] NEGATIVE_INFINITY_BYTES = "-inf".getBytes();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Protocol$ClusterKeyword.class */
    public enum ClusterKeyword implements Rawable {
        MEET,
        RESET,
        INFO,
        FAILOVER,
        SLOTS,
        NODES,
        REPLICAS,
        SLAVES,
        MYID,
        ADDSLOTS,
        DELSLOTS,
        GETKEYSINSLOT,
        SETSLOT,
        NODE,
        MIGRATING,
        IMPORTING,
        STABLE,
        FORGET,
        FLUSHSLOTS,
        KEYSLOT,
        COUNTKEYSINSLOT,
        SAVECONFIG,
        REPLICATE,
        LINKS,
        ADDSLOTSRANGE,
        DELSLOTSRANGE,
        BUMPEPOCH;

        private final byte[] raw = SafeEncoder.encode(name());

        ClusterKeyword() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Protocol$Command.class */
    public enum Command implements ProtocolCommand {
        PING,
        SET,
        GET,
        GETDEL,
        GETEX,
        QUIT,
        EXISTS,
        DEL,
        UNLINK,
        TYPE,
        FLUSHDB,
        KEYS,
        RANDOMKEY,
        MOVE,
        RENAME,
        RENAMENX,
        DBSIZE,
        EXPIRE,
        EXPIREAT,
        TTL,
        SELECT,
        FLUSHALL,
        GETSET,
        MGET,
        SETNX,
        SETEX,
        MSET,
        MSETNX,
        DECRBY,
        DECR,
        INCRBY,
        INCR,
        APPEND,
        SUBSTR,
        HSET,
        HGET,
        HSETNX,
        HMSET,
        HMGET,
        HINCRBY,
        HEXISTS,
        HDEL,
        HLEN,
        HKEYS,
        HVALS,
        HGETALL,
        HRANDFIELD,
        HINCRBYFLOAT,
        HSTRLEN,
        MIGRATE,
        RPUSH,
        LPUSH,
        LLEN,
        LRANGE,
        LTRIM,
        LINDEX,
        LSET,
        LREM,
        LPOP,
        RPOP,
        BLPOP,
        BRPOP,
        LINSERT,
        LPOS,
        RPOPLPUSH,
        BRPOPLPUSH,
        BLMOVE,
        LMOVE,
        SADD,
        SMEMBERS,
        SREM,
        SPOP,
        SMOVE,
        SCARD,
        SRANDMEMBER,
        SINTER,
        SINTERSTORE,
        SUNION,
        SUNIONSTORE,
        SDIFF,
        SDIFFSTORE,
        SISMEMBER,
        SMISMEMBER,
        SINTERCARD,
        MULTI,
        DISCARD,
        EXEC,
        WATCH,
        UNWATCH,
        SORT,
        SORT_RO,
        AUTH,
        INFO,
        SHUTDOWN,
        MONITOR,
        CONFIG,
        LCS,
        SUBSCRIBE,
        PUBLISH,
        UNSUBSCRIBE,
        PSUBSCRIBE,
        PUNSUBSCRIBE,
        PUBSUB,
        STRLEN,
        LPUSHX,
        RPUSHX,
        ECHO,
        ZADD,
        ZDIFF,
        ZDIFFSTORE,
        ZRANGE,
        ZREM,
        ZINCRBY,
        ZRANK,
        ZREVRANK,
        ZREVRANGE,
        ZRANDMEMBER,
        ZCARD,
        ZSCORE,
        ZPOPMAX,
        ZPOPMIN,
        ZCOUNT,
        ZUNION,
        ZUNIONSTORE,
        ZINTER,
        ZINTERSTORE,
        ZRANGEBYSCORE,
        ZREVRANGEBYSCORE,
        ZREMRANGEBYRANK,
        ZREMRANGEBYSCORE,
        ZLEXCOUNT,
        ZRANGEBYLEX,
        ZREVRANGEBYLEX,
        ZREMRANGEBYLEX,
        ZMSCORE,
        ZRANGESTORE,
        ZINTERCARD,
        SAVE,
        BGSAVE,
        BGREWRITEAOF,
        LASTSAVE,
        PERSIST,
        SETBIT,
        GETBIT,
        BITPOS,
        SETRANGE,
        GETRANGE,
        EVAL,
        EVALSHA,
        SCRIPT,
        SLOWLOG,
        OBJECT,
        BITCOUNT,
        BITOP,
        SENTINEL,
        DUMP,
        RESTORE,
        PEXPIRE,
        PEXPIREAT,
        PTTL,
        INCRBYFLOAT,
        PSETEX,
        CLIENT,
        TIME,
        SCAN,
        HSCAN,
        SSCAN,
        ZSCAN,
        WAIT,
        CLUSTER,
        ASKING,
        READONLY,
        READWRITE,
        SLAVEOF,
        REPLICAOF,
        COPY,
        PFADD,
        PFCOUNT,
        PFMERGE,
        MODULE,
        ACL,
        GEOADD,
        GEODIST,
        GEOHASH,
        GEOPOS,
        GEORADIUS,
        GEORADIUS_RO,
        GEORADIUSBYMEMBER,
        GEORADIUSBYMEMBER_RO,
        BITFIELD,
        TOUCH,
        SWAPDB,
        MEMORY,
        BZPOPMIN,
        BZPOPMAX,
        XADD,
        XLEN,
        XDEL,
        XTRIM,
        XRANGE,
        XREVRANGE,
        XREAD,
        XACK,
        XGROUP,
        XREADGROUP,
        XPENDING,
        XCLAIM,
        XAUTOCLAIM,
        XINFO,
        BITFIELD_RO,
        ROLE,
        FAILOVER,
        GEOSEARCH,
        GEOSEARCHSTORE,
        EVAL_RO,
        EVALSHA_RO,
        LOLWUT,
        EXPIRETIME,
        PEXPIRETIME,
        FUNCTION,
        FCALL,
        FCALL_RO,
        LMPOP,
        BLMPOP,
        ZMPOP,
        BZMPOP,
        COMMAND,
        STRALGO;

        private final byte[] raw = SafeEncoder.encode(name());

        Command() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Protocol$Keyword.class */
    public enum Keyword implements Rawable {
        AGGREGATE,
        ALPHA,
        BY,
        GET,
        LIMIT,
        NO,
        NOSORT,
        ONE,
        SET,
        STORE,
        WEIGHTS,
        WITHSCORES,
        RESETSTAT,
        REWRITE,
        RESET,
        FLUSH,
        EXISTS,
        LOAD,
        LEN,
        HELP,
        SCHEDULE,
        MATCH,
        COUNT,
        TYPE,
        KEYS,
        REFCOUNT,
        ENCODING,
        IDLETIME,
        FREQ,
        REPLACE,
        GETNAME,
        SETNAME,
        LIST,
        ID,
        KILL,
        PAUSE,
        UNBLOCK,
        STREAMS,
        CREATE,
        MKSTREAM,
        SETID,
        DESTROY,
        DELCONSUMER,
        MAXLEN,
        GROUP,
        IDLE,
        TIME,
        BLOCK,
        NOACK,
        RETRYCOUNT,
        STREAM,
        GROUPS,
        CONSUMERS,
        JUSTID,
        WITHVALUES,
        NOMKSTREAM,
        MINID,
        CREATECONSUMER,
        SETUSER,
        GETUSER,
        DELUSER,
        WHOAMI,
        USERS,
        CAT,
        GENPASS,
        LOG,
        SAVE,
        DRYRUN,
        COPY,
        AUTH,
        AUTH2,
        NX,
        XX,
        EX,
        PX,
        EXAT,
        PXAT,
        CH,
        ABSTTL,
        KEEPTTL,
        INCR,
        INFO,
        CHANNELS,
        NUMPAT,
        NUMSUB,
        NOW,
        REV,
        WITHCOORD,
        WITHDIST,
        WITHHASH,
        ANY,
        FROMMEMBER,
        FROMLONLAT,
        BYRADIUS,
        BYBOX,
        BYLEX,
        BYSCORE,
        STOREDIST,
        TO,
        FORCE,
        TIMEOUT,
        DB,
        UNLOAD,
        ABORT,
        IDX,
        MINMATCHLEN,
        WITHMATCHLEN,
        FULL,
        DELETE,
        LIBRARYNAME,
        WITHCODE,
        DESCRIPTION,
        GETKEYS,
        GETKEYSANDFLAGS,
        DOCS,
        FILTERBY,
        DUMP,
        MODULE,
        ACLCAT,
        PATTERN,
        DOCTOR,
        USAGE,
        SAMPLES,
        PURGE,
        STATS,
        ASC,
        DESC,
        LCS,
        STRINGS;

        private final byte[] raw = SafeEncoder.encode(name());

        Keyword() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Protocol$ResponseKeyword.class */
    public enum ResponseKeyword implements Rawable {
        SUBSCRIBE,
        PSUBSCRIBE,
        UNSUBSCRIBE,
        PUNSUBSCRIBE,
        MESSAGE,
        PMESSAGE,
        PONG;

        private final byte[] raw = SafeEncoder.encode(name().toLowerCase(Locale.ENGLISH));

        ResponseKeyword() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Protocol$SentinelKeyword.class */
    public enum SentinelKeyword implements Rawable {
        MYID,
        MASTERS,
        MASTER,
        SENTINELS,
        SLAVES,
        REPLICAS,
        RESET,
        FAILOVER,
        REMOVE,
        SET,
        MONITOR,
        GET_MASTER_ADDR_BY_NAME("GET-MASTER-ADDR-BY-NAME");

        private final byte[] raw;

        SentinelKeyword() {
            this.raw = SafeEncoder.encode(name());
        }

        SentinelKeyword(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    private Protocol() {
    }

    public static void sendCommand(RedisOutputStream redisOutputStream, CommandArguments commandArguments) {
        try {
            redisOutputStream.write((byte) 42);
            redisOutputStream.writeIntCrLf(commandArguments.size());
            for (Rawable rawable : commandArguments) {
                redisOutputStream.write((byte) 36);
                byte[] raw = rawable.getRaw();
                redisOutputStream.writeIntCrLf(raw.length);
                redisOutputStream.write(raw);
                redisOutputStream.writeCrLf();
            }
        } catch (IOException e) {
            throw new JedisConnectionException(e);
        }
    }

    private static void processError(RedisInputStream redisInputStream) {
        String line = redisInputStream.readLine();
        if (line.startsWith(MOVED_PREFIX)) {
            String[] targetHostAndSlot = parseTargetHostAndSlot(line);
            throw new JedisMovedDataException(line, HostAndPort.from(targetHostAndSlot[1]), Integer.parseInt(targetHostAndSlot[0]));
        }
        if (line.startsWith(ASK_PREFIX)) {
            String[] targetHostAndSlot2 = parseTargetHostAndSlot(line);
            throw new JedisAskDataException(line, HostAndPort.from(targetHostAndSlot2[1]), Integer.parseInt(targetHostAndSlot2[0]));
        }
        if (line.startsWith(CLUSTERDOWN_PREFIX)) {
            throw new JedisClusterException(line);
        }
        if (line.startsWith(BUSY_PREFIX)) {
            throw new JedisBusyException(line);
        }
        if (line.startsWith(NOSCRIPT_PREFIX)) {
            throw new JedisNoScriptException(line);
        }
        if (line.startsWith(WRONGPASS_PREFIX)) {
            throw new JedisAccessControlException(line);
        }
        if (!line.startsWith(NOPERM_PREFIX)) {
            throw new JedisDataException(line);
        }
        throw new JedisAccessControlException(line);
    }

    public static String readErrorLineIfPossible(RedisInputStream redisInputStream) {
        if (redisInputStream.readByte() != 45) {
            return null;
        }
        return redisInputStream.readLine();
    }

    private static String[] parseTargetHostAndSlot(String str) {
        String[] strArrSplit = str.split(" ");
        return new String[]{strArrSplit[1], strArrSplit[2]};
    }

    private static Object process(RedisInputStream redisInputStream) {
        byte b = redisInputStream.readByte();
        switch (b) {
            case DOLLAR_BYTE /* 36 */:
                return processBulkReply(redisInputStream);
            case ASTERISK_BYTE /* 42 */:
                return processMultiBulkReply(redisInputStream);
            case PLUS_BYTE /* 43 */:
                return processStatusCodeReply(redisInputStream);
            case MINUS_BYTE /* 45 */:
                processError(redisInputStream);
                return null;
            case 58:
                return processInteger(redisInputStream);
            default:
                throw new JedisConnectionException("Unknown reply: " + ((char) b));
        }
    }

    private static byte[] processStatusCodeReply(RedisInputStream redisInputStream) {
        return redisInputStream.readLineBytes();
    }

    private static byte[] processBulkReply(RedisInputStream redisInputStream) {
        int intCrLf = redisInputStream.readIntCrLf();
        if (intCrLf == -1) {
            return null;
        }
        byte[] bArr = new byte[intCrLf];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= intCrLf) {
                redisInputStream.readByte();
                redisInputStream.readByte();
                return bArr;
            }
            int i3 = redisInputStream.read(bArr, i2, intCrLf - i2);
            if (i3 == -1) {
                throw new JedisConnectionException("It seems like server has closed the connection.");
            }
            i = i2 + i3;
        }
    }

    private static Long processInteger(RedisInputStream redisInputStream) {
        return Long.valueOf(redisInputStream.readLongCrLf());
    }

    private static List<Object> processMultiBulkReply(RedisInputStream redisInputStream) {
        int intCrLf = redisInputStream.readIntCrLf();
        if (intCrLf == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(intCrLf);
        for (int i = 0; i < intCrLf; i++) {
            try {
                arrayList.add(process(redisInputStream));
            } catch (JedisDataException e) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static Object read(RedisInputStream redisInputStream) {
        return process(redisInputStream);
    }

    public static final byte[] toByteArray(boolean z) {
        return z ? BYTES_TRUE : BYTES_FALSE;
    }

    public static final byte[] toByteArray(int i) {
        return SafeEncoder.encode(String.valueOf(i));
    }

    public static final byte[] toByteArray(long j) {
        return SafeEncoder.encode(String.valueOf(j));
    }

    public static final byte[] toByteArray(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return POSITIVE_INFINITY_BYTES;
        }
        return d == Double.NEGATIVE_INFINITY ? NEGATIVE_INFINITY_BYTES : SafeEncoder.encode(String.valueOf(d));
    }
}
