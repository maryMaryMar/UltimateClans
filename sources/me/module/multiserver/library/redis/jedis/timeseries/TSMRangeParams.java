package me.module.multiserver.library.redis.jedis.timeseries;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSMRangeParams.class */
public class TSMRangeParams implements IParams {
    private Long fromTimestamp;
    private Long toTimestamp;
    private boolean latest;
    private long[] filterByTimestamps;
    private double[] filterByValues;
    private boolean withLabels;
    private String[] selectedLabels;
    private Integer count;
    private byte[] align;
    private AggregationType aggregationType;
    private long bucketDuration;
    private byte[] bucketTimestamp;
    private boolean empty;
    private String[] filters;
    private String groupByLabel;
    private String groupByReduce;

    public TSMRangeParams(long j, long j2) {
        this.fromTimestamp = Long.valueOf(j);
        this.toTimestamp = Long.valueOf(j2);
    }

    public static TSMRangeParams multiRangeParams(long j, long j2) {
        return new TSMRangeParams(j, j2);
    }

    public TSMRangeParams() {
    }

    public static TSMRangeParams multiRangeParams() {
        return new TSMRangeParams();
    }

    public TSMRangeParams fromTimestamp(long j) {
        this.fromTimestamp = Long.valueOf(j);
        return this;
    }

    public TSMRangeParams toTimestamp(long j) {
        this.toTimestamp = Long.valueOf(j);
        return this;
    }

    public TSMRangeParams latest() {
        this.latest = true;
        return this;
    }

    public TSMRangeParams filterByTS(long... jArr) {
        this.filterByTimestamps = jArr;
        return this;
    }

    public TSMRangeParams filterByValues(double d, double d2) {
        this.filterByValues = new double[]{d, d2};
        return this;
    }

    public TSMRangeParams withLabels(boolean z) {
        this.withLabels = z;
        return this;
    }

    public TSMRangeParams withLabels() {
        return withLabels(true);
    }

    public TSMRangeParams selectedLabels(String... strArr) {
        this.selectedLabels = strArr;
        return this;
    }

    public TSMRangeParams count(int i) {
        this.count = Integer.valueOf(i);
        return this;
    }

    private TSMRangeParams align(byte[] bArr) {
        this.align = bArr;
        return this;
    }

    public TSMRangeParams align(long j) {
        return align(Protocol.toByteArray(j));
    }

    public TSMRangeParams alignStart() {
        return align(TimeSeriesProtocol.MINUS);
    }

    public TSMRangeParams alignEnd() {
        return align(TimeSeriesProtocol.PLUS);
    }

    public TSMRangeParams aggregation(AggregationType aggregationType, long j) {
        this.aggregationType = aggregationType;
        this.bucketDuration = j;
        return this;
    }

    public TSMRangeParams bucketTimestamp(String str) {
        this.bucketTimestamp = SafeEncoder.encode(str);
        return this;
    }

    public TSMRangeParams bucketTimestampLow() {
        this.bucketTimestamp = TimeSeriesProtocol.MINUS;
        return this;
    }

    public TSMRangeParams bucketTimestampHigh() {
        this.bucketTimestamp = TimeSeriesProtocol.PLUS;
        return this;
    }

    public TSMRangeParams bucketTimestampMid() {
        this.bucketTimestamp = Protocol.BYTES_TILDE;
        return this;
    }

    public TSMRangeParams empty() {
        this.empty = true;
        return this;
    }

    public TSMRangeParams filter(String... strArr) {
        this.filters = strArr;
        return this;
    }

    public TSMRangeParams groupBy(String str, String str2) {
        this.groupByLabel = str;
        this.groupByReduce = str2;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.filters == null) {
            throw new IllegalArgumentException("FILTER arguments must be set.");
        }
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
        if (this.withLabels) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.WITHLABELS);
        } else if (this.selectedLabels != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.SELECTED_LABELS);
            for (String str : this.selectedLabels) {
                commandArguments.add(str);
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
        commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.FILTER);
        for (String str2 : this.filters) {
            commandArguments.add(str2);
        }
        if (this.groupByLabel == null || this.groupByReduce == null) {
            return;
        }
        commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.GROUPBY).add(this.groupByLabel).add(TimeSeriesProtocol.TimeSeriesKeyword.REDUCE).add(this.groupByReduce);
    }
}
