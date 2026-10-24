package me.module.multiserver.library.redis.jedis;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/StreamEntryID.class */
public class StreamEntryID implements Serializable, Comparable<StreamEntryID> {
    private static final long serialVersionUID = 1;
    private long time;
    private long sequence;
    public static final StreamEntryID NEW_ENTRY = new StreamEntryID() { // from class: me.module.multiserver.library.redis.jedis.StreamEntryID.1
        private static final long serialVersionUID = 1;

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID
        public String toString() {
            return Marker.ANY_MARKER;
        }

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(StreamEntryID streamEntryID) {
            return super.compareTo(streamEntryID);
        }
    };
    public static final StreamEntryID LAST_ENTRY = new StreamEntryID() { // from class: me.module.multiserver.library.redis.jedis.StreamEntryID.2
        private static final long serialVersionUID = 1;

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID
        public String toString() {
            return "$";
        }

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(StreamEntryID streamEntryID) {
            return super.compareTo(streamEntryID);
        }
    };
    public static final StreamEntryID UNRECEIVED_ENTRY = new StreamEntryID() { // from class: me.module.multiserver.library.redis.jedis.StreamEntryID.3
        private static final long serialVersionUID = 1;

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID
        public String toString() {
            return ">";
        }

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(StreamEntryID streamEntryID) {
            return super.compareTo(streamEntryID);
        }
    };
    public static final StreamEntryID MINIMUM_ID = new StreamEntryID() { // from class: me.module.multiserver.library.redis.jedis.StreamEntryID.4
        private static final long serialVersionUID = 1;

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID
        public String toString() {
            return "-";
        }

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(StreamEntryID streamEntryID) {
            return super.compareTo(streamEntryID);
        }
    };
    public static final StreamEntryID MAXIMUM_ID = new StreamEntryID() { // from class: me.module.multiserver.library.redis.jedis.StreamEntryID.5
        private static final long serialVersionUID = 1;

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID
        public String toString() {
            return Marker.ANY_NON_NULL_MARKER;
        }

        @Override // me.module.multiserver.library.redis.jedis.StreamEntryID, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(StreamEntryID streamEntryID) {
            return super.compareTo(streamEntryID);
        }
    };

    public StreamEntryID() {
        this(0L, 0L);
    }

    public StreamEntryID(byte[] bArr) {
        this(SafeEncoder.encode(bArr));
    }

    public StreamEntryID(String str) {
        String[] strArrSplit = str.split("-");
        this.time = Long.parseLong(strArrSplit[0]);
        this.sequence = Long.parseLong(strArrSplit[1]);
    }

    public StreamEntryID(long j) {
        this(j, 0L);
    }

    public StreamEntryID(long j, long j2) {
        this.time = j;
        this.sequence = j2;
    }

    public String toString() {
        return this.time + "-" + this.sequence;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StreamEntryID streamEntryID = (StreamEntryID) obj;
        return this.time == streamEntryID.time && this.sequence == streamEntryID.sequence;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(StreamEntryID streamEntryID) {
        int iCompare = Long.compare(this.time, streamEntryID.time);
        return iCompare != 0 ? iCompare : Long.compare(this.sequence, streamEntryID.sequence);
    }

    public long getTime() {
        return this.time;
    }

    public long getSequence() {
        return this.sequence;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeLong(this.time);
        objectOutputStream.writeLong(this.sequence);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.time = objectInputStream.readLong();
        this.sequence = objectInputStream.readLong();
    }
}
