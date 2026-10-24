package me.module.multiserver.library.redis.jedis.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/Params.class */
public abstract class Params {
    private Map<String, Object> params;

    public <T> T getParam(String str) {
        if (this.params == null) {
            return null;
        }
        return (T) this.params.get(str);
    }

    public byte[][] getByteParams() {
        if (this.params == null) {
            return new byte[0][];
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : this.params.entrySet()) {
            arrayList.add(SafeEncoder.encode(entry.getKey()));
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof byte[]) {
                    arrayList.add((byte[]) value);
                } else if (value instanceof Rawable) {
                    arrayList.add(((Rawable) value).getRaw());
                } else if (value instanceof Boolean) {
                    arrayList.add(Protocol.toByteArray(((Boolean) value).booleanValue()));
                } else if (value instanceof Integer) {
                    arrayList.add(Protocol.toByteArray(((Integer) value).intValue()));
                } else if (value instanceof Long) {
                    arrayList.add(Protocol.toByteArray(((Long) value).longValue()));
                } else if (value instanceof Double) {
                    arrayList.add(Protocol.toByteArray(((Double) value).doubleValue()));
                } else {
                    arrayList.add(SafeEncoder.encode(String.valueOf(value)));
                }
            }
        }
        return (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
    }

    protected boolean contains(String str) {
        if (this.params == null) {
            return false;
        }
        return this.params.containsKey(str);
    }

    protected void addParam(String str, Object obj) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(str, obj);
    }

    protected void addParam(String str) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(str, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.params != null) {
            for (Map.Entry<String, Object> entry : this.params.entrySet()) {
                arrayList.add(entry.getKey());
                Object value = entry.getValue();
                if (value != null) {
                    arrayList.add(SafeEncoder.encodeObject(value));
                }
            }
        }
        return arrayList.toString();
    }
}
