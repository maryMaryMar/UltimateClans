package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.Map;
import java.util.concurrent.Callable;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/AdvancedBarChart.class */
public class AdvancedBarChart extends CustomChart {
    private final Callable<Map<String, int[]>> callable;

    public AdvancedBarChart(String str, Callable<Map<String, int[]>> callable) {
        super(str);
        this.callable = callable;
    }

    @Override // me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        Map<String, int[]> mapCall = this.callable.call();
        if (mapCall == null || mapCall.isEmpty()) {
            return null;
        }
        boolean z = true;
        for (Map.Entry<String, int[]> entry : mapCall.entrySet()) {
            if (entry.getValue().length != 0) {
                z = false;
                jsonObjectBuilder.appendField(entry.getKey(), entry.getValue());
            }
        }
        if (z) {
            return null;
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
