package me.module.multiserver.library.redis.jedis.resps;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamEntry.class */
public class StreamEntry implements Serializable {
    private static final long serialVersionUID = 1;
    private StreamEntryID id;
    private Map<String, String> fields;

    public StreamEntry(StreamEntryID streamEntryID, Map<String, String> map) {
        this.id = streamEntryID;
        this.fields = map;
    }

    public StreamEntryID getID() {
        return this.id;
    }

    public Map<String, String> getFields() {
        return this.fields;
    }

    public String toString() {
        return this.id + " " + this.fields;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUnshared(this.id);
        objectOutputStream.writeUnshared(this.fields);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.id = (StreamEntryID) objectInputStream.readUnshared();
        this.fields = (Map) objectInputStream.readUnshared();
    }
}
