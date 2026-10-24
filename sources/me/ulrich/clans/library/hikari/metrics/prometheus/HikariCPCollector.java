package me.ulrich.clans.library.hikari.metrics.prometheus;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import me.ulrich.clans.library.hikari.metrics.PoolStats;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/metrics/prometheus/HikariCPCollector.class */
class HikariCPCollector extends Collector {
    private static final List<String> LABEL_NAMES = Collections.singletonList(BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX);
    private final Map<String, PoolStats> poolStatsMap = new ConcurrentHashMap();

    HikariCPCollector() {
    }

    public List<Collector.MetricFamilySamples> collect() {
        return Arrays.asList(createGauge("hikaricp_active_connections", "Active connections", (v0) -> {
            return v0.getActiveConnections();
        }), createGauge("hikaricp_idle_connections", "Idle connections", (v0) -> {
            return v0.getIdleConnections();
        }), createGauge("hikaricp_pending_threads", "Pending threads", (v0) -> {
            return v0.getPendingThreads();
        }), createGauge("hikaricp_connections", "The number of current connections", (v0) -> {
            return v0.getTotalConnections();
        }), createGauge("hikaricp_max_connections", "Max connections", (v0) -> {
            return v0.getMaxConnections();
        }), createGauge("hikaricp_min_connections", "Min connections", (v0) -> {
            return v0.getMinConnections();
        }));
    }

    void add(String str, PoolStats poolStats) {
        this.poolStatsMap.put(str, poolStats);
    }

    void remove(String str) {
        this.poolStatsMap.remove(str);
    }

    private GaugeMetricFamily createGauge(String str, String str2, Function<PoolStats, Integer> function) {
        GaugeMetricFamily gaugeMetricFamily = new GaugeMetricFamily(str, str2, LABEL_NAMES);
        this.poolStatsMap.forEach((str3, poolStats) -> {
            gaugeMetricFamily.addMetric(Collections.singletonList(str3), ((Integer) function.apply(poolStats)).intValue());
        });
        return gaugeMetricFamily;
    }
}
