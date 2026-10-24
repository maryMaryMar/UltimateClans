package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.Map;
import java.util.concurrent.Callable;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/SimpleBarChart.class */
public class SimpleBarChart extends CustomChart {
    private final Callable<Map<String, Integer>> callable;

    public SimpleBarChart(String str, Callable<Map<String, Integer>> callable) {
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
        for (Map.Entry<String, Integer> entry : mapCall.entrySet()) {
            jsonObjectBuilder.appendField(entry.getKey(), new int[]{entry.getValue().intValue()});
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
