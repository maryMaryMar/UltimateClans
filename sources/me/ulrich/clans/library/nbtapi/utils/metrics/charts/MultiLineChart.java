package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.Map;
import java.util.concurrent.Callable;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/MultiLineChart.class */
public class MultiLineChart extends CustomChart {
    private final Callable<Map<String, Integer>> callable;

    public MultiLineChart(String str, Callable<Map<String, Integer>> callable) {
        super(str);
        this.callable = callable;
    }

    @Override // me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        Map<String, Integer> mapCall = this.callable.call();
        if (mapCall == null || mapCall.isEmpty()) {
            return null;
        }
        boolean z = true;
        for (Map.Entry<String, Integer> entry : mapCall.entrySet()) {
            if (entry.getValue().intValue() != 0) {
                z = false;
                jsonObjectBuilder.appendField(entry.getKey(), entry.getValue().intValue());
            }
        }
        if (z) {
            return null;
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
