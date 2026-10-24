package me.module.multiserver.library.redis.jedis.timeseries;

import java.util.LinkedHashMap;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSCreateParams.class */
public class TSCreateParams implements IParams {
    private Long retentionPeriod;
    private boolean uncompressed;
    private boolean compressed;
    private Long chunkSize;
    private DuplicatePolicy duplicatePolicy;
    private Map<String, String> labels;

    public static TSCreateParams createParams() {
        return new TSCreateParams();
    }

    public TSCreateParams retention(long j) {
        this.retentionPeriod = Long.valueOf(j);
        return this;
    }

    public TSCreateParams uncompressed() {
        this.uncompressed = true;
        return this;
    }

    public TSCreateParams compressed() {
        this.compressed = true;
        return this;
    }

    public TSCreateParams chunkSize(long j) {
        this.chunkSize = Long.valueOf(j);
        return this;
    }

    public TSCreateParams duplicatePolicy(DuplicatePolicy duplicatePolicy) {
        this.duplicatePolicy = duplicatePolicy;
        return this;
    }

    public TSCreateParams labels(Map<String, String> map) {
        this.labels = map;
        return this;
    }

    public TSCreateParams label(String str, String str2) {
        if (this.labels == null) {
            this.labels = new LinkedHashMap();
        }
        this.labels.put(str, str2);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.retentionPeriod != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.RETENTION).add(Protocol.toByteArray(this.retentionPeriod.longValue()));
        }
        if (this.uncompressed) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.ENCODING).add(TimeSeriesProtocol.TimeSeriesKeyword.UNCOMPRESSED);
        } else if (this.compressed) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.ENCODING).add(TimeSeriesProtocol.TimeSeriesKeyword.COMPRESSED);
        }
        if (this.chunkSize != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.CHUNK_SIZE).add(Protocol.toByteArray(this.chunkSize.longValue()));
        }
        if (this.duplicatePolicy != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.DUPLICATE_POLICY).add(this.duplicatePolicy);
        }
        if (this.labels != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.LABELS);
            this.labels.entrySet().forEach(entry -> {
                commandArguments.add(entry.getKey()).add(entry.getValue());
            });
        }
    }
}
