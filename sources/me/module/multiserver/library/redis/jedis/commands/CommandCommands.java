package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.params.CommandListFilterByParams;
import me.module.multiserver.library.redis.jedis.resps.CommandDocument;
import me.module.multiserver.library.redis.jedis.resps.CommandInfo;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/CommandCommands.class */
public interface CommandCommands {
    long commandCount();

    Map<String, CommandDocument> commandDocs(String... strArr);

    List<String> commandGetKeys(String... strArr);

    List<KeyValue<String, List<String>>> commandGetKeysAndFlags(String... strArr);

    Map<String, CommandInfo> commandInfo(String... strArr);

    List<String> commandList();

    List<String> commandListFilterBy(CommandListFilterByParams commandListFilterByParams);
}
