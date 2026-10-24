package me.module.multiserver.library.redis.jedis.params;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.SortingOrder;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/SortingParams.class */
public class SortingParams implements IParams {
    private final List<byte[]> params = new ArrayList();

    public SortingParams by(String str) {
        return by(SafeEncoder.encode(str));
    }

    public SortingParams by(byte[] bArr) {
        this.params.add(Protocol.Keyword.BY.getRaw());
        this.params.add(bArr);
        return this;
    }

    public SortingParams nosort() {
        this.params.add(Protocol.Keyword.BY.getRaw());
        this.params.add(Protocol.Keyword.NOSORT.getRaw());
        return this;
    }

    public Collection<byte[]> getParams() {
        return Collections.unmodifiableCollection(this.params);
    }

    public SortingParams desc() {
        return sortingOrder(SortingOrder.DESC);
    }

    public SortingParams asc() {
        return sortingOrder(SortingOrder.ASC);
    }

    public SortingParams sortingOrder(SortingOrder sortingOrder) {
        this.params.add(sortingOrder.getRaw());
        return this;
    }

    public SortingParams limit(int i, int i2) {
        this.params.add(Protocol.Keyword.LIMIT.getRaw());
        this.params.add(Protocol.toByteArray(i));
        this.params.add(Protocol.toByteArray(i2));
        return this;
    }

    public SortingParams alpha() {
        this.params.add(Protocol.Keyword.ALPHA.getRaw());
        return this;
    }

    public SortingParams get(String... strArr) {
        for (String str : strArr) {
            this.params.add(Protocol.Keyword.GET.getRaw());
            this.params.add(SafeEncoder.encode(str));
        }
        return this;
    }

    public SortingParams get(byte[]... bArr) {
        for (byte[] bArr2 : bArr) {
            this.params.add(Protocol.Keyword.GET.getRaw());
            this.params.add(bArr2);
        }
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        Iterator<byte[]> it = this.params.iterator();
        while (it.hasNext()) {
            commandArguments.add(it.next());
        }
    }
}
