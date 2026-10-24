package me.ulrich.clans.library.nbtapi.utils.metrics.charts;

import java.util.function.BiConsumer;
import me.ulrich.clans.library.nbtapi.utils.metrics.json.JsonObjectBuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/metrics/charts/CustomChart.class */
public abstract class CustomChart {
    private final String chartId;

    protected CustomChart(String str) {
        if (str == null) {
            throw new IllegalArgumentException("chartId must not be null");
        }
        this.chartId = str;
    }

    public JsonObjectBuilder.JsonObject getRequestJsonObject(BiConsumer<String, Throwable> biConsumer, boolean z) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.appendField("chartId", this.chartId);
        try {
            JsonObjectBuilder.JsonObject chartData = getChartData();
            if (chartData == null) {
                return null;
            }
            jsonObjectBuilder.appendField("data", chartData);
            return jsonObjectBuilder.build();
        } catch (Throwable th) {
            if (!z) {
                return null;
            }
            biConsumer.accept("Failed to get data for custom chart with id " + this.chartId, th);
            return null;
        }
    }

    protected abstract JsonObjectBuilder.JsonObject getChartData();
}
