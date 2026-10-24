package me.module.multiserver.library.redis.jedis.resps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.module.multiserver.library.redis.jedis.HostAndPort;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/Slowlog.class */
public class Slowlog {
    private final long id;
    private final long timeStamp;
    private final long executionTime;
    private final List<String> args;
    private HostAndPort clientIpPort;
    private String clientName;
    private static final String COMMA = ",";

    private Slowlog(List<Object> list) {
        this.id = ((Long) list.get(0)).longValue();
        this.timeStamp = ((Long) list.get(1)).longValue();
        this.executionTime = ((Long) list.get(2)).longValue();
        List list2 = (List) list.get(3);
        this.args = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            this.args.add(SafeEncoder.encode((byte[]) it.next()));
        }
        if (list.size() == 4) {
            return;
        }
        this.clientIpPort = HostAndPort.from(SafeEncoder.encode((byte[]) list.get(4)));
        this.clientName = SafeEncoder.encode((byte[]) list.get(5));
    }

    public static List<Slowlog> from(List<Object> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Slowlog((List) it.next()));
        }
        return arrayList;
    }

    public long getId() {
        return this.id;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public long getExecutionTime() {
        return this.executionTime;
    }

    public List<String> getArgs() {
        return this.args;
    }

    public HostAndPort getClientIpPort() {
        return this.clientIpPort;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String toString() {
        return this.id + COMMA + this.timeStamp + COMMA + this.executionTime + COMMA + this.args;
    }
}
