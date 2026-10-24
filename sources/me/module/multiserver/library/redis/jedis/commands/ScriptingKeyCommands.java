package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ScriptingKeyCommands.class */
public interface ScriptingKeyCommands {
    Object eval(String str);

    Object eval(String str, int i, String... strArr);

    Object eval(String str, List<String> list, List<String> list2);

    Object evalReadonly(String str, List<String> list, List<String> list2);

    Object evalsha(String str);

    Object evalsha(String str, int i, String... strArr);

    Object evalsha(String str, List<String> list, List<String> list2);

    Object evalshaReadonly(String str, List<String> list, List<String> list2);
}
