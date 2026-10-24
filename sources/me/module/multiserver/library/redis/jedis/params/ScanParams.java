package me.module.multiserver.library.redis.jedis.params;

import java.nio.ByteBuffer;
import java.util.EnumMap;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ScanParams.class */
public class ScanParams implements IParams {
    private final Map<Protocol.Keyword, ByteBuffer> params = new EnumMap(Protocol.Keyword.class);
    public static final String SCAN_POINTER_START = String.valueOf(0);
    public static final byte[] SCAN_POINTER_START_BINARY = SafeEncoder.encode(SCAN_POINTER_START);

    public ScanParams match(byte[] bArr) {
        this.params.put(Protocol.Keyword.MATCH, ByteBuffer.wrap(bArr));
        return this;
    }

    public ScanParams match(String str) {
        this.params.put(Protocol.Keyword.MATCH, ByteBuffer.wrap(SafeEncoder.encode(str)));
        return this;
    }

    public ScanParams count(Integer num) {
        this.params.put(Protocol.Keyword.COUNT, ByteBuffer.wrap(Protocol.toByteArray(num.intValue())));
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        for (Map.Entry<Protocol.Keyword, ByteBuffer> entry : this.params.entrySet()) {
            commandArguments.add(entry.getKey());
            commandArguments.add(entry.getValue().array());
        }
    }

    public byte[] binaryMatch() {
        if (this.params.containsKey(Protocol.Keyword.MATCH)) {
            return this.params.get(Protocol.Keyword.MATCH).array();
        }
        return null;
    }

    public String match() {
        if (this.params.containsKey(Protocol.Keyword.MATCH)) {
            return new String(this.params.get(Protocol.Keyword.MATCH).array());
        }
        return null;
    }
}
