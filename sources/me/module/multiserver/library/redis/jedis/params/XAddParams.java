package me.module.multiserver.library.redis.jedis.params;

import java.util.Arrays;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.StreamEntryID;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/XAddParams.class */
public class XAddParams implements IParams {
    private static final byte[] NEW_ENTRY = SafeEncoder.encode(StreamEntryID.NEW_ENTRY.toString());
    private byte[] id;
    private Long maxLen;
    private boolean approximateTrimming;
    private boolean exactTrimming;
    private boolean nomkstream;
    private String minId;
    private Long limit;

    public static XAddParams xAddParams() {
        return new XAddParams();
    }

    public XAddParams noMkStream() {
        this.nomkstream = true;
        return this;
    }

    public XAddParams id(byte[] bArr) {
        this.id = Arrays.copyOf(bArr, bArr.length);
        return this;
    }

    public XAddParams id(String str) {
        this.id = SafeEncoder.encode(str);
        return this;
    }

    public XAddParams id(StreamEntryID streamEntryID) {
        return id(streamEntryID.toString());
    }

    public XAddParams id(long j, long j2) {
        return id(j + "-" + j2);
    }

    public XAddParams id(long j) {
        return id(j + "-*");
    }

    public XAddParams maxLen(long j) {
        this.maxLen = Long.valueOf(j);
        return this;
    }

    public XAddParams minId(String str) {
        this.minId = str;
        return this;
    }

    public XAddParams approximateTrimming() {
        this.approximateTrimming = true;
        return this;
    }

    public XAddParams exactTrimming() {
        this.exactTrimming = true;
        return this;
    }

    public XAddParams limit(long j) {
        this.limit = Long.valueOf(j);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.nomkstream) {
            commandArguments.add(Protocol.Keyword.NOMKSTREAM.getRaw());
        }
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
        commandArguments.add(this.id != null ? this.id : NEW_ENTRY);
    }
}
