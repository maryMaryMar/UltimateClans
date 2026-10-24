package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ScriptingKeyPipelineCommands.class */
public interface ScriptingKeyPipelineCommands {
    Response<Object> eval(String str);

    Response<Object> eval(String str, int i, String... strArr);

    Response<Object> eval(String str, List<String> list, List<String> list2);

    Response<Object> evalReadonly(String str, List<String> list, List<String> list2);

    Response<Object> evalsha(String str);

    Response<Object> evalsha(String str, int i, String... strArr);

    Response<Object> evalsha(String str, List<String> list, List<String> list2);

    Response<Object> evalshaReadonly(String str, List<String> list, List<String> list2);
}
