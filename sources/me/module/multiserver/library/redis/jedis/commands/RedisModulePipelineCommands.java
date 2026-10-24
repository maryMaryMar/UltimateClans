package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.bloom.commands.RedisBloomPipelineCommands;
import me.module.multiserver.library.redis.jedis.graph.RedisGraphPipelineCommands;
import me.module.multiserver.library.redis.jedis.json.RedisJsonPipelineCommands;
import me.module.multiserver.library.redis.jedis.search.RediSearchPipelineCommands;
import me.module.multiserver.library.redis.jedis.timeseries.RedisTimeSeriesPipelineCommands;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/RedisModulePipelineCommands.class */
public interface RedisModulePipelineCommands extends RedisBloomPipelineCommands, RedisGraphPipelineCommands, RedisJsonPipelineCommands, RediSearchPipelineCommands, RedisTimeSeriesPipelineCommands {
}
