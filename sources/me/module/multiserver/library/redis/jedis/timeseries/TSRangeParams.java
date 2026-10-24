package me.module.multiserver.library.redis.jedis.timeseries;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSRangeParams.class */
public class TSRangeParams implements IParams {
    private Long fromTimestamp;
    private Long toTimestamp;
    private boolean latest;
    private long[] filterByTimestamps;
    private double[] filterByValues;
    private Integer count;
    private byte[] align;
    private AggregationType aggregationType;
    private long bucketDuration;
    private byte[] bucketTimestamp;
    private boolean empty;

    public TSRangeParams(long j, long j2) {
        this.fromTimestamp = Long.valueOf(j);
        this.toTimestamp = Long.valueOf(j2);
    }

    public static TSRangeParams rangeParams(long j, long j2) {
        return new TSRangeParams(j, j2);
    }

    public TSRangeParams() {
    }

    public static TSRangeParams rangeParams() {
        return new TSRangeParams();
    }

    public TSRangeParams fromTimestamp(long j) {
        this.fromTimestamp = Long.valueOf(j);
        return this;
    }

    public TSRangeParams toTimestamp(long j) {
        this.toTimestamp = Long.valueOf(j);
        return this;
    }

    public TSRangeParams latest() {
        this.latest = true;
        return this;
    }

    public TSRangeParams filterByTS(long... jArr) {
        this.filterByTimestamps = jArr;
        return this;
    }

    public TSRangeParams filterByValues(double d, double d2) {
        this.filterByValues = new double[]{d, d2};
        return this;
    }

    public TSRangeParams count(int i) {
        this.count = Integer.valueOf(i);
        return this;
    }

    private TSRangeParams align(byte[] bArr) {
        this.align = bArr;
        return this;
    }

    public TSRangeParams align(long j) {
        return align(Protocol.toByteArray(j));
    }

    public TSRangeParams alignStart() {
        return align(TimeSeriesProtocol.MINUS);
    }

    public TSRangeParams alignEnd() {
        return align(TimeSeriesProtocol.PLUS);
    }

    public TSRangeParams aggregation(AggregationType aggregationType, long j) {
        this.aggregationType = aggregationType;
        this.bucketDuration = j;
        return this;
    }

    public TSRangeParams bucketTimestamp(String str) {
        this.bucketTimestamp = SafeEncoder.encode(str);
        return this;
    }

    public TSRangeParams bucketTimestampLow() {
        this.bucketTimestamp = TimeSeriesProtocol.MINUS;
        return this;
    }

    public TSRangeParams bucketTimestampHigh() {
        this.bucketTimestamp = TimeSeriesProtocol.PLUS;
        return this;
    }

    public TSRangeParams bucketTimestampMid() {
        this.bucketTimestamp = Protocol.BYTES_TILDE;
        return this;
    }

    public TSRangeParams empty() {
        this.empty = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.fromTimestamp == null) {
            commandArguments.add(TimeSeriesProtocol.MINUS);
        } else {
            commandArguments.add(Protocol.toByteArray(this.fromTimestamp.longValue()));
        }
        if (this.toTimestamp == null) {
            commandArguments.add(TimeSeriesProtocol.PLUS);
        } else {
            commandArguments.add(Protocol.toByteArray(this.toTimestamp.longValue()));
        }
        if (this.latest) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.LATEST);
        }
        if (this.filterByTimestamps != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.FILTER_BY_TS);
            for (long j : this.filterByTimestamps) {
                commandArguments.add(Protocol.toByteArray(j));
            }
        }
        if (this.filterByValues != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.FILTER_BY_VALUE);
            for (double d : this.filterByValues) {
                commandArguments.add(Protocol.toByteArray(d));
            }
        }
        if (this.count != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.COUNT).add(Protocol.toByteArray(this.count.intValue()));
        }
        if (this.aggregationType != null) {
            if (this.align != null) {
                commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.ALIGN).add(this.align);
            }
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.AGGREGATION).add(this.aggregationType).add(Protocol.toByteArray(this.bucketDuration));
            if (this.bucketTimestamp != null) {
                commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.BUCKETTIMESTAMP).add(this.bucketTimestamp);
            }
            if (this.empty) {
                commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.EMPTY);
            }
        }
    }
}
