package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/XTrimParams.class */
public class XTrimParams implements IParams {
    private Long maxLen;
    private boolean approximateTrimming;
    private boolean exactTrimming;
    private String minId;
    private Long limit;

    public static XTrimParams xTrimParams() {
        return new XTrimParams();
    }

    public XTrimParams maxLen(long j) {
        this.maxLen = Long.valueOf(j);
        return this;
    }

    public XTrimParams minId(String str) {
        this.minId = str;
        return this;
    }

    public XTrimParams approximateTrimming() {
        this.approximateTrimming = true;
        return this;
    }

    public XTrimParams exactTrimming() {
        this.exactTrimming = true;
        return this;
    }

    public XTrimParams limit(long j) {
        this.limit = Long.valueOf(j);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.maxLen != null) {
            commandArguments.add(Protocol.Keyword.MAXLEN.getRaw());
            if (this.approximateTrimming) {
                commandArguments.add(Protocol.BYTES_TILDE);
            } else if (this.exactTrimming) {
                commandArguments.add(Protocol.BYTES_EQUAL);
            }
            commandArguments.add(Protocol.toByteArray(this.maxLen.longValue()));
        } else if (this.minId != null) {
            commandArguments.add(Protocol.Keyword.MINID.getRaw());
            if (this.approximateTrimming) {
                commandArguments.add(Protocol.BYTES_TILDE);
            } else if (this.exactTrimming) {
                commandArguments.add(Protocol.BYTES_EQUAL);
            }
            commandArguments.add(SafeEncoder.encode(this.minId));
        }
        if (this.limit != null) {
            commandArguments.add(Protocol.Keyword.LIMIT.getRaw());
            commandArguments.add(Protocol.toByteArray(this.limit.longValue()));
        }
    }
}
