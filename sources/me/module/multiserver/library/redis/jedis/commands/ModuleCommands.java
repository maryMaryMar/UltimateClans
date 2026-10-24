package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Module;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ModuleCommands.class */
public interface ModuleCommands {
    String moduleLoad(String str);

    String moduleLoad(String str, String... strArr);

    String moduleUnload(String str);

    List<Module> moduleList();
}
