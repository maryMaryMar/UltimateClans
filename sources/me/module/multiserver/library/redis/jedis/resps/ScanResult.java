package me.module.multiserver.library.redis.jedis.resps;

import java.util.List;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/ScanResult.class */
public class ScanResult<T> {
    private byte[] cursor;
    private List<T> results;

    public ScanResult(String str, List<T> list) {
        this(SafeEncoder.encode(str), list);
    }

    public ScanResult(byte[] bArr, List<T> list) {
        this.cursor = bArr;
        this.results = list;
    }

    public String getCursor() {
        return SafeEncoder.encode(this.cursor);
    }

    public boolean isCompleteIteration() {
        return ScanParams.SCAN_POINTER_START.equals(getCursor());
    }

    public byte[] getCursorAsBytes() {
        return this.cursor;
    }

    public List<T> getResult() {
        return this.results;
    }
}
