package me.module.multiserver.library.redis.jedis.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/JedisByteHashMap.class */
public class JedisByteHashMap implements Serializable, Cloneable, Map<byte[], byte[]> {
    private static final long serialVersionUID = -6971431362627219416L;
    private final Map<ByteArrayWrapper, byte[]> internalMap = new HashMap();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/JedisByteHashMap$ByteArrayWrapper.class */
    private static final class ByteArrayWrapper implements Serializable {
        private final byte[] data;

        public ByteArrayWrapper(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.data = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof ByteArrayWrapper) {
                return Arrays.equals(this.data, ((ByteArrayWrapper) obj).data);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.data);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/JedisByteHashMap$JedisByteEntry.class */
    private static final class JedisByteEntry implements Map.Entry<byte[], byte[]> {
        private byte[] value;
        private byte[] key;

        public JedisByteEntry(byte[] bArr, byte[] bArr2) {
            this.key = bArr;
            this.value = bArr2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public byte[] getKey() {
            return this.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Map.Entry
        public byte[] getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public byte[] setValue(byte[] bArr) {
            this.value = bArr;
            return bArr;
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.internalMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return obj instanceof byte[] ? this.internalMap.containsKey(new ByteArrayWrapper((byte[]) obj)) : this.internalMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.internalMap.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<byte[], byte[]>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<ByteArrayWrapper, byte[]> entry : this.internalMap.entrySet()) {
            hashSet.add(new JedisByteEntry(entry.getKey().data, entry.getValue()));
        }
        return hashSet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public byte[] get(Object obj) {
        return obj instanceof byte[] ? this.internalMap.get(new ByteArrayWrapper((byte[]) obj)) : this.internalMap.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.internalMap.isEmpty();
    }

    @Override // java.util.Map
    public Set<byte[]> keySet() {
        HashSet hashSet = new HashSet();
        Iterator<ByteArrayWrapper> it = this.internalMap.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().data);
        }
        return hashSet;
    }

    @Override // java.util.Map
    public byte[] put(byte[] bArr, byte[] bArr2) {
        return this.internalMap.put(new ByteArrayWrapper(bArr), bArr2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends byte[], ? extends byte[]> map) {
        for (Map.Entry<? extends byte[], ? extends byte[]> entry : map.entrySet()) {
            this.internalMap.put(new ByteArrayWrapper(entry.getKey()), entry.getValue());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public byte[] remove(Object obj) {
        return obj instanceof byte[] ? this.internalMap.remove(new ByteArrayWrapper((byte[]) obj)) : this.internalMap.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.internalMap.size();
    }

    @Override // java.util.Map
    public Collection<byte[]> values() {
        return this.internalMap.values();
    }
}
