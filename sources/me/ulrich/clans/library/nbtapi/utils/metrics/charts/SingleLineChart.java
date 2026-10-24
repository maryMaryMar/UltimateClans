package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.concurrent.Callable;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/SingleLineChart.class */
public class SingleLineChart extends CustomChart {
    private final Callable<Integer> callable;

    public SingleLineChart(String str, Callable<Integer> callable) {
        super(str);
        this.callable = callable;
    }

    @Override // me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart
    protected JsonObjectBuilder.JsonObject getChartData() {
        int iIntValue = this.callable.call().intValue();
        if (iIntValue == 0) {
            return null;
        }
        return new JsonObjectBuilder().appendField("value", iIntValue).build();
    }
}
