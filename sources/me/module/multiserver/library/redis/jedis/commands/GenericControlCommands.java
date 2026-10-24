package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Module;
import me.module.multiserver.library.redis.jedis.params.FailoverParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/GenericControlCommands.class */
public interface GenericControlCommands extends ConfigCommands, ScriptingControlCommands, SlowlogCommands {
    String failover();

    String failover(FailoverParams failoverParams);

    String failoverAbort();

    List<Module> moduleList();
}
