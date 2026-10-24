package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.args.ClusterFailoverOption;
import me.module.multiserver.library.redis.jedis.args.ClusterResetType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ClusterCommands.class */
public interface ClusterCommands {
    String asking();

    String readonly();

    String readwrite();

    String clusterNodes();

    String clusterMeet(String str, int i);

    String clusterAddSlots(int... iArr);

    String clusterDelSlots(int... iArr);

    String clusterInfo();

    List<String> clusterGetKeysInSlot(int i, int i2);

    List<byte[]> clusterGetKeysInSlotBinary(int i, int i2);

    String clusterSetSlotNode(int i, String str);

    String clusterSetSlotMigrating(int i, String str);

    String clusterSetSlotImporting(int i, String str);

    String clusterSetSlotStable(int i);

    String clusterForget(String str);

    String clusterFlushSlots();

    long clusterKeySlot(String str);

    long clusterCountFailureReports(String str);

    long clusterCountKeysInSlot(int i);

    String clusterSaveConfig();

    String clusterSetConfigEpoch(long j);

    String clusterBumpEpoch();

    String clusterReplicate(String str);

    @Deprecated
    List<String> clusterSlaves(String str);

    List<String> clusterReplicas(String str);

    String clusterFailover();

    String clusterFailover(ClusterFailoverOption clusterFailoverOption);

    List<Object> clusterSlots();

    String clusterReset();

    String clusterReset(ClusterResetType clusterResetType);

    String clusterMyId();

    List<Map<String, Object>> clusterLinks();

    String clusterAddSlotsRange(int... iArr);

    String clusterDelSlotsRange(int... iArr);
}
