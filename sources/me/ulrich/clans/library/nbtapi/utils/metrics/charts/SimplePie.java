package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.concurrent.Callable;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/SimplePie.class */
public class SimplePie extends CustomChart {
    private final Callable<String> callable;

    public SimplePie(String str, Callable<String> callable) {
        super(str);
        this.callable = callable;
    }

    @Override // me.ulrich.clans.library.nbtapi.utils.metrics.charts.CustomChart
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        String strCall = this.callable.call();
        if (strCall == null || strCall.isEmpty()) {
            return null;
        }
        return new JsonObjectBuilder().appendField("value", strCall).build();
    }
}
