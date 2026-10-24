package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SentinelCommands.class */
public interface SentinelCommands {
    String sentinelMyId();

    List<Map<String, String>> sentinelMasters();

    Map<String, String> sentinelMaster(String str);

    List<Map<String, String>> sentinelSentinels(String str);

    List<String> sentinelGetMasterAddrByName(String str);

    Long sentinelReset(String str);

    @Deprecated
    List<Map<String, String>> sentinelSlaves(String str);

    List<Map<String, String>> sentinelReplicas(String str);

    String sentinelFailover(String str);

    String sentinelMonitor(String str, String str2, int i, int i2);

    String sentinelRemove(String str);

    String sentinelSet(String str, Map<String, String> map);
}
