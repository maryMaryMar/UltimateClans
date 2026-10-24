package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/AccessControlLogEntry.class */
public class AccessControlLogEntry implements Serializable {
    private static final long serialVersionUID = 1;
    public static final String COUNT = "count";
    public static final String REASON = "reason";
    public static final String CONTEXT = "context";
    public static final String OBJECT = "object";
    public static final String USERNAME = "username";
    public static final String AGE_SECONDS = "age-seconds";
    public static final String CLIENT_INFO = "client-info";
    private long count;
    private final String reason;
    private final String context;
    private final String object;
    private final String username;
    private final String ageSeconds;
    private final Map<String, String> clientInfo;
    private final Map<String, Object> logEntry;

    public AccessControlLogEntry(Map<String, Object> map) {
        this.count = ((Long) map.get("count")).longValue();
        this.reason = (String) map.get(REASON);
        this.context = (String) map.get(CONTEXT);
        this.object = (String) map.get(OBJECT);
        this.username = (String) map.get(USERNAME);
        this.ageSeconds = (String) map.get(AGE_SECONDS);
        this.clientInfo = getMapFromRawClientInfo((String) map.get(CLIENT_INFO));
        this.logEntry = map;
    }

    public long getCount() {
        return this.count;
    }

    public String getReason() {
        return this.reason;
    }

    public String getContext() {
        return this.context;
    }

    public String getObject() {
        return this.object;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAgeSeconds() {
        return this.ageSeconds;
    }

    public Map<String, String> getClientInfo() {
        return this.clientInfo;
    }

    public Map<String, Object> getlogEntry() {
        return this.logEntry;
    }

    private Map<String, String> getMapFromRawClientInfo(String str) {
        String[] strArrSplit = str.split(" ");
        LinkedHashMap linkedHashMap = new LinkedHashMap(strArrSplit.length);
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("=");
            linkedHashMap.put(strArrSplit2[0], strArrSplit2.length == 2 ? strArrSplit2[1] : "");
        }
        return linkedHashMap;
    }

    public String toString() {
        return "AccessControlLogEntry{count=" + this.count + ", reason='" + this.reason + "', context='" + this.context + "', object='" + this.object + "', username='" + this.username + "', ageSeconds='" + this.ageSeconds + "', clientInfo=" + this.clientInfo + '}';
    }
}
