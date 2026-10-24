package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.bloom.commands.RedisBloomCommands;
import me.module.multiserver.library.redis.jedis.graph.RedisGraphCommands;
import me.module.multiserver.library.redis.jedis.json.RedisJsonCommands;
import me.module.multiserver.library.redis.jedis.search.RediSearchCommands;
import me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesCommands;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/RedisModuleCommands.class */
public interface RedisModuleCommands extends RedisBloomCommands, RedisGraphCommands, RedisJsonCommands, RediSearchCommands, RedisTimeSeriesCommands {
}
