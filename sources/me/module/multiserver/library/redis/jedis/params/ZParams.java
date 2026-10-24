package me.module.multiserver.library.redis.jedis.params;

import java.util.ArrayList;
import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ZParams.class */
public class ZParams implements IParams {
    private final List<Object> params = new ArrayList();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ZParams$Aggregate.class */
    public enum Aggregate implements Rawable {
        SUM,
        MIN,
        MAX;

        private final byte[] raw = SafeEncoder.encode(name());

        Aggregate() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    public ZParams weights(double... dArr) {
        this.params.add(Protocol.Keyword.WEIGHTS);
        for (double d : dArr) {
            this.params.add(Double.valueOf(d));
        }
        return this;
    }

    public ZParams aggregate(Aggregate aggregate) {
        this.params.add(Protocol.Keyword.AGGREGATE);
        this.params.add(aggregate);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        this.params.forEach(obj -> {
            commandArguments.add(obj);
        });
    }
}
