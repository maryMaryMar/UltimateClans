package me.module.multiserver.library.redis.jedis.params;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/BitPosParams.class */
public class BitPosParams implements IParams {
    private List<byte[]> params;

    public BitPosParams() {
        this.params = new ArrayList();
    }

    public BitPosParams(long j) {
        this.params = new ArrayList();
        this.params.add(Protocol.toByteArray(j));
    }

    public BitPosParams(long j, long j2) {
        this(j);
        this.params.add(Protocol.toByteArray(j2));
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        Iterator<byte[]> it = this.params.iterator();
        while (it.hasNext()) {
            commandArguments.add(it.next());
        }
    }
}
