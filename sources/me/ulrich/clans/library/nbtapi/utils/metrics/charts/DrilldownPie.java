package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.Map;
import java.util.concurrent.Callable;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/DrilldownPie.class */
public class DrilldownPie extends CustomChart {
    private final Callable<Map<String, Map<String, Integer>>> callable;

    public DrilldownPie(String str, Callable<Map<String, Map<String, Integer>>> callable) {
        super(str);
        this.callable = callable;
    }

    @Override // me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart
    public JsonObjectBuilder.JsonObject getChartData() throws Exception {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        Map<String, Map<String, Integer>> mapCall = this.callable.call();
        if (mapCall == null || mapCall.isEmpty()) {
            return null;
        }
        boolean z = true;
        for (Map.Entry<String, Map<String, Integer>> entry : mapCall.entrySet()) {
            JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            boolean z2 = true;
            for (Map.Entry<String, Integer> entry2 : mapCall.get(entry.getKey()).entrySet()) {
                jsonObjectBuilder2.appendField(entry2.getKey(), entry2.getValue().intValue());
                z2 = false;
            }
            if (!z2) {
                z = false;
                jsonObjectBuilder.appendField(entry.getKey(), jsonObjectBuilder2.build());
            }
        }
        if (z) {
            return null;
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
