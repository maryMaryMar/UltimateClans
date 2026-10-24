package me.module.multiserver.library.redis.jedis.timeseries;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSMGetParams.class */
public class TSMGetParams implements IParams {
    private boolean latest;
    private boolean withLabels;
    private String[] selectedLabels;

    public static TSMGetParams multiGetParams() {
        return new TSMGetParams();
    }

    public TSMGetParams latest() {
        this.latest = true;
        return this;
    }

    public TSMGetParams withLabels(boolean z) {
        this.withLabels = z;
        return this;
    }

    public TSMGetParams withLabels() {
        return withLabels(true);
    }

    public TSMGetParams selectedLabels(String... strArr) {
        this.selectedLabels = strArr;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.latest) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.LATEST);
        }
        if (this.withLabels) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.WITHLABELS);
            return;
        }
        if (this.selectedLabels != null) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.SELECTED_LABELS);
            for (String str : this.selectedLabels) {
                commandArguments.add(str);
            }
        }
    }
}
