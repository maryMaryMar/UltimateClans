package me.module.multiserver.library.redis.jedis.timeseries;

import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TimeSeriesProtocol.class */
public class TimeSeriesProtocol {
    public static final byte[] PLUS = SafeEncoder.encode(Marker.ANY_NON_NULL_MARKER);
    public static final byte[] MINUS = SafeEncoder.encode("-");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TimeSeriesProtocol$TimeSeriesCommand.class */
    public enum TimeSeriesCommand implements ProtocolCommand {
        CREATE("TS.CREATE"),
        RANGE("TS.RANGE"),
        REVRANGE("TS.REVRANGE"),
        MRANGE("TS.MRANGE"),
        MREVRANGE("TS.MREVRANGE"),
        CREATERULE("TS.CREATERULE"),
        DELETERULE("TS.DELETERULE"),
        ADD("TS.ADD"),
        MADD("TS.MADD"),
        DEL("TS.DEL"),
        INCRBY("TS.INCRBY"),
        DECRBY("TS.DECRBY"),
        INFO("TS.INFO"),
        GET("TS.GET"),
        MGET("TS.MGET"),
        ALTER("TS.ALTER"),
        QUERYINDEX("TS.QUERYINDEX");

        private final byte[] raw;

        TimeSeriesCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TimeSeriesProtocol$TimeSeriesKeyword.class */
    public enum TimeSeriesKeyword implements Rawable {
        RESET,
        FILTER,
        AGGREGATION,
        LABELS,
        RETENTION,
        TIMESTAMP,
        WITHLABELS,
        SELECTED_LABELS,
        COUNT,
        ENCODING,
        COMPRESSED,
        UNCOMPRESSED,
        CHUNK_SIZE,
        DUPLICATE_POLICY,
        ON_DUPLICATE,
        ALIGN,
        FILTER_BY_TS,
        FILTER_BY_VALUE,
        GROUPBY,
        REDUCE,
        DEBUG,
        LATEST,
        EMPTY,
        BUCKETTIMESTAMP;

        private final byte[] raw = SafeEncoder.encode(name());

        TimeSeriesKeyword() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }
}
