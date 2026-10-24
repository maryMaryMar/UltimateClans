package me.module.multiserver.library.redis.jedis.resps;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamPendingEntry.class */
public class StreamPendingEntry implements Serializable {
    private static final long serialVersionUID = 1;
    private StreamEntryID id;
    private String consumerName;
    private long idleTime;
    private long deliveredTimes;

    public StreamPendingEntry(StreamEntryID streamEntryID, String str, long j, long j2) {
        this.id = streamEntryID;
        this.consumerName = str;
        this.idleTime = j;
        this.deliveredTimes = j2;
    }

    public StreamEntryID getID() {
        return this.id;
    }

    public long getIdleTime() {
        return this.idleTime;
    }

    public long getDeliveredTimes() {
        return this.deliveredTimes;
    }

    public String getConsumerName() {
        return this.consumerName;
    }

    public String toString() {
        return this.id + " " + this.consumerName + " idle:" + this.idleTime + " times:" + this.deliveredTimes;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUnshared(this.id);
        objectOutputStream.writeUTF(this.consumerName);
        objectOutputStream.writeLong(this.idleTime);
        objectOutputStream.writeLong(this.deliveredTimes);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.id = (StreamEntryID) objectInputStream.readUnshared();
        this.consumerName = objectInputStream.readUTF();
        this.idleTime = objectInputStream.readLong();
        this.deliveredTimes = objectInputStream.readLong();
    }
}
