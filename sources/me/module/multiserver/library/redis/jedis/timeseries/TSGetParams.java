package me.module.multiserver.library.redis.jedis.timeseries;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSGetParams.class */
public class TSGetParams implements IParams {
    private boolean latest;

    public static TSGetParams getParams() {
        return new TSGetParams();
    }

    public TSGetParams latest() {
        this.latest = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.latest) {
            commandArguments.add(TimeSeriesProtocol.TimeSeriesKeyword.LATEST);
        }
    }
}
