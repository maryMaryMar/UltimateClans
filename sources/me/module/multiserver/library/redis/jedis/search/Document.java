package me.module.multiserver.library.redis.jedis.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Document.class */
public class Document implements Serializable {
    private static final long serialVersionUID = 4884173545291367373L;
    private final String id;
    private double score;
    private byte[] payload;
    private final Map<String, Object> properties;

    public Document(String str, double d) {
        this(str, new HashMap(), d);
    }

    public Document(String str) {
        this(str, 1.0d);
    }

    public Document(String str, Map<String, Object> map) {
        this(str, map, 1.0d);
    }

    public Document(String str, Map<String, Object> map, double d) {
        this(str, map, d, null);
    }

    public Document(String str, Map<String, Object> map, double d, byte[] bArr) {
        this.id = str;
        this.properties = new HashMap(map);
        this.score = d;
        this.payload = bArr;
    }

    public Iterable<Map.Entry<String, Object>> getProperties() {
        return this.properties.entrySet();
    }

    public static Document load(String str, double d, byte[] bArr, List<byte[]> list) {
        return load(str, d, bArr, list, true);
    }

    public static Document load(String str, double d, byte[] bArr, List<byte[]> list, boolean z) {
        Document document = new Document(str, d);
        document.payload = bArr;
        if (list != null) {
            for (int i = 0; i < list.size(); i += 2) {
                byte[] bArr2 = list.get(i);
                byte[] bArr3 = list.get(i + 1);
                document.set(SafeEncoder.encode(bArr2), bArr3 == null ? null : z ? SafeEncoder.encode(bArr3) : bArr3);
            }
        }
        return document;
    }

    public Document set(String str, Object obj) {
        this.properties.put(str, obj);
        return this;
    }

    public Object get(String str) {
        return this.properties.get(str);
    }

    public String getString(String str) {
        Object obj = this.properties.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof byte[] ? SafeEncoder.encode((byte[]) obj) : obj.toString();
    }

    public double getScore() {
        return this.score;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public Document setScore(float f) {
        this.score = f;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public boolean hasProperty(String str) {
        return this.properties.containsKey(str);
    }

    public String toString() {
        return "id:" + getId() + ", score: " + getScore() + ", payload:" + (getPayload() == null ? "null" : SafeEncoder.encode(getPayload())) + ", properties:" + getProperties();
    }
}
