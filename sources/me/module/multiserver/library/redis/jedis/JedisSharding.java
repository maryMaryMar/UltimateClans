package me.module.multiserver.library.redis.jedis;

import java.util.List;
import java.util.regex.Pattern;
import me.module.multiserver.library.redis.jedis.providers.ShardedConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.Hashing;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/JedisSharding.class */
public class JedisSharding extends UnifiedJedis {
    public static final Pattern DEFAULT_KEY_TAG_PATTERN = Pattern.compile("\\{(.+?)\\}");

    public JedisSharding(List<HostAndPort> list) {
        this(new ShardedConnectionProvider(list));
    }

    public JedisSharding(List<HostAndPort> list, JedisClientConfig jedisClientConfig) {
        this(new ShardedConnectionProvider(list, jedisClientConfig));
    }

    public JedisSharding(List<HostAndPort> list, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new ShardedConnectionProvider(list, jedisClientConfig, genericObjectPoolConfig));
    }

    public JedisSharding(List<HostAndPort> list, JedisClientConfig jedisClientConfig, Hashing hashing) {
        this(new ShardedConnectionProvider(list, jedisClientConfig, hashing));
    }

    public JedisSharding(List<HostAndPort> list, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, Hashing hashing) {
        this(new ShardedConnectionProvider(list, jedisClientConfig, genericObjectPoolConfig, hashing));
    }

    public JedisSharding(ShardedConnectionProvider shardedConnectionProvider) {
        super(shardedConnectionProvider);
    }

    public JedisSharding(ShardedConnectionProvider shardedConnectionProvider, Pattern pattern) {
        super(shardedConnectionProvider, pattern);
    }
}
