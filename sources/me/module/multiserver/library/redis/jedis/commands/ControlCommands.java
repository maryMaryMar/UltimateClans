package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ControlCommands.class */
public interface ControlCommands extends AccessControlLogCommands, ClientCommands {
    List<Object> role();

    Long objectRefcount(String str);

    String objectEncoding(String str);

    Long objectIdletime(String str);

    List<String> objectHelp();

    Long objectFreq(String str);

    String memoryDoctor();

    Long memoryUsage(String str);

    Long memoryUsage(String str, int i);

    String memoryPurge();

    Map<String, Object> memoryStats();
}
