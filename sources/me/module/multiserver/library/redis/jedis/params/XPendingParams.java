package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.StreamEntryID;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.args.RawableFactory;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/XPendingParams.class */
public class XPendingParams implements IParams {
    private boolean legacy;
    private Long idle;
    private Rawable start;
    private Rawable end;
    private int count;
    private Rawable consumer;

    @Deprecated
    public XPendingParams() {
        this.legacy = true;
        this.count = Integer.MIN_VALUE;
    }

    @Deprecated
    public static XPendingParams xPendingParams() {
        return new XPendingParams();
    }

    public XPendingParams(StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        this(streamEntryID.toString(), streamEntryID2.toString(), i);
    }

    public XPendingParams(String str, String str2, int i) {
        this(RawableFactory.from(str), RawableFactory.from(str2), i);
    }

    public XPendingParams(byte[] bArr, byte[] bArr2, int i) {
        this(RawableFactory.from(bArr), RawableFactory.from(bArr2), i);
    }

    private XPendingParams(Rawable rawable, Rawable rawable2, int i) {
        this.legacy = true;
        this.count = Integer.MIN_VALUE;
        this.legacy = false;
        this.start = rawable;
        this.end = rawable2;
        this.count = i;
    }

    public static XPendingParams xPendingParams(StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i) {
        return new XPendingParams(streamEntryID, streamEntryID2, i);
    }

    public static XPendingParams xPendingParams(String str, String str2, int i) {
        return new XPendingParams(str, str2, i);
    }

    public static XPendingParams xPendingParams(byte[] bArr, byte[] bArr2, int i) {
        return new XPendingParams(bArr, bArr2, i);
    }

    public XPendingParams idle(long j) {
        this.idle = Long.valueOf(j);
        return this;
    }

    @Deprecated
    public XPendingParams start(StreamEntryID streamEntryID) {
        this.start = RawableFactory.from(streamEntryID.toString());
        return this;
    }

    @Deprecated
    public XPendingParams end(StreamEntryID streamEntryID) {
        this.end = RawableFactory.from(streamEntryID.toString());
        return this;
    }

    public XPendingParams count(int i) {
        this.count = i;
        return this;
    }

    public XPendingParams consumer(String str) {
        this.consumer = RawableFactory.from(str);
        return this;
    }

    public XPendingParams consumer(byte[] bArr) {
        this.consumer = RawableFactory.from(bArr);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.idle != null) {
            commandArguments.add(Protocol.Keyword.IDLE).add(Protocol.toByteArray(this.idle.longValue()));
        }
        if (this.legacy) {
            if (this.start == null) {
                commandArguments.add("-");
            } else {
                commandArguments.add(this.start);
            }
            if (this.end == null) {
                commandArguments.add(Marker.ANY_NON_NULL_MARKER);
            } else {
                commandArguments.add(this.end);
            }
            if (this.count != Integer.MIN_VALUE) {
                commandArguments.add(Protocol.toByteArray(this.count));
            }
        } else {
            commandArguments.add(this.start).add(this.end).add(Protocol.toByteArray(this.count));
        }
        if (this.consumer != null) {
            commandArguments.add(this.consumer);
        }
    }
}
