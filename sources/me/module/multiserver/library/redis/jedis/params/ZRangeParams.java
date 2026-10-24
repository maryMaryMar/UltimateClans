package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.args.RawableFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ZRangeParams.class */
public class ZRangeParams implements IParams {
    private final Protocol.Keyword by;
    private final Rawable min;
    private final Rawable max;
    private boolean rev;
    private boolean limit;
    private int offset;
    private int count;

    private ZRangeParams() {
        this.rev = false;
        this.limit = false;
        throw new InstantiationError("Empty constructor must not be called.");
    }

    public ZRangeParams(int i, int i2) {
        this.rev = false;
        this.limit = false;
        this.by = null;
        this.min = RawableFactory.from(i);
        this.max = RawableFactory.from(i2);
    }

    public static ZRangeParams zrangeParams(int i, int i2) {
        return new ZRangeParams(i, i2);
    }

    public ZRangeParams(double d, double d2) {
        this.rev = false;
        this.limit = false;
        this.by = Protocol.Keyword.BYSCORE;
        this.min = RawableFactory.from(d);
        this.max = RawableFactory.from(d2);
    }

    public static ZRangeParams zrangeByScoreParams(double d, double d2) {
        return new ZRangeParams(d, d2);
    }

    private ZRangeParams(Protocol.Keyword keyword, Rawable rawable, Rawable rawable2) {
        this.rev = false;
        this.limit = false;
        if (keyword != null && keyword != Protocol.Keyword.BYSCORE && keyword != Protocol.Keyword.BYLEX) {
            throw new IllegalArgumentException(keyword.name() + " is not a valid ZRANGE type argument.");
        }
        this.by = keyword;
        this.min = rawable;
        this.max = rawable2;
    }

    public ZRangeParams(Protocol.Keyword keyword, String str, String str2) {
        this(keyword, RawableFactory.from(str), RawableFactory.from(str2));
    }

    public ZRangeParams(Protocol.Keyword keyword, byte[] bArr, byte[] bArr2) {
        this(keyword, RawableFactory.from(bArr), RawableFactory.from(bArr2));
    }

    public static ZRangeParams zrangeByLexParams(String str, String str2) {
        return new ZRangeParams(Protocol.Keyword.BYLEX, str, str2);
    }

    public static ZRangeParams zrangeByLexParams(byte[] bArr, byte[] bArr2) {
        return new ZRangeParams(Protocol.Keyword.BYLEX, bArr, bArr2);
    }

    public ZRangeParams rev() {
        this.rev = true;
        return this;
    }

    public ZRangeParams limit(int i, int i2) {
        this.limit = true;
        this.offset = i;
        this.count = i2;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.add(this.min).add(this.max);
        if (this.by != null) {
            commandArguments.add(this.by);
        }
        if (this.rev) {
            commandArguments.add(Protocol.Keyword.REV);
        }
        if (this.limit) {
            commandArguments.add(Protocol.Keyword.LIMIT).add(Integer.valueOf(this.offset)).add(Integer.valueOf(this.count));
        }
    }
}
