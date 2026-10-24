package me.module.multiserver.library.redis.jedis;

import java.util.List;
import java.util.regex.Pattern;
import me.module.multiserver.library.redis.jedis.providers.ShardedConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.Hashing;
import me.module.multiserver.library.redis.jedis.util.IOUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ShardedPipeline.class */
public class ShardedPipeline extends MultiNodePipelineBase {
    private final ShardedConnectionProvider provider;
    private AutoCloseable closeable;

    public ShardedPipeline(List<HostAndPort> list, JedisClientConfig jedisClientConfig) {
        this(new ShardedConnectionProvider(list, jedisClientConfig));
        this.closeable = this.provider;
    }

    public ShardedPipeline(ShardedConnectionProvider shardedConnectionProvider) {
        super(new ShardedCommandObjects(shardedConnectionProvider.getHashingAlgo()));
        this.closeable = null;
        this.provider = shardedConnectionProvider;
    }

    public ShardedPipeline(List<HostAndPort> list, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig, Hashing hashing, Pattern pattern) {
        this(new ShardedConnectionProvider(list, jedisClientConfig, genericObjectPoolConfig, hashing), pattern);
        this.closeable = this.provider;
    }

    public ShardedPipeline(ShardedConnectionProvider shardedConnectionProvider, Pattern pattern) {
        super(new ShardedCommandObjects(shardedConnectionProvider.getHashingAlgo(), pattern));
        this.closeable = null;
        this.provider = shardedConnectionProvider;
    }

    @Override // me.module.multiserver.library.redis.jedis.MultiNodePipelineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } finally {
            IOUtils.closeQuietly(this.closeable);
        }
    }

    @Override // me.module.multiserver.library.redis.jedis.MultiNodePipelineBase
    protected HostAndPort getNodeKey(CommandArguments commandArguments) {
        return this.provider.getNode(((ShardedCommandArguments) commandArguments).getKeyHash());
    }

    @Override // me.module.multiserver.library.redis.jedis.MultiNodePipelineBase
    protected Connection getConnection(HostAndPort hostAndPort) {
        return this.provider.getConnection(hostAndPort);
    }

    public void prepareGraphCommands() {
        super.prepareGraphCommands(this.provider);
    }
}
