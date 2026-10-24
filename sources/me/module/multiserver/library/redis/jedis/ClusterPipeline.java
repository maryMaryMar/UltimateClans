package me.module.multiserver.library.redis.jedis;

import java.util.Set;
import me.module.multiserver.library.redis.jedis.providers.ClusterConnectionProvider;
import me.module.multiserver.library.redis.jedis.util.IOUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ClusterPipeline.class */
public class ClusterPipeline extends MultiNodePipelineBase {
    private final ClusterConnectionProvider provider;
    private AutoCloseable closeable;

    public ClusterPipeline(Set<HostAndPort> set, JedisClientConfig jedisClientConfig) {
        this(new ClusterConnectionProvider(set, jedisClientConfig));
        this.closeable = this.provider;
    }

    public ClusterPipeline(Set<HostAndPort> set, JedisClientConfig jedisClientConfig, GenericObjectPoolConfig<Connection> genericObjectPoolConfig) {
        this(new ClusterConnectionProvider(set, jedisClientConfig, genericObjectPoolConfig));
        this.closeable = this.provider;
    }

    public ClusterPipeline(ClusterConnectionProvider clusterConnectionProvider) {
        super(new ClusterCommandObjects());
        this.closeable = null;
        this.provider = clusterConnectionProvider;
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
        return this.provider.getNode(((ClusterCommandArguments) commandArguments).getCommandHashSlot());
    }

    @Override // me.module.multiserver.library.redis.jedis.MultiNodePipelineBase
    protected Connection getConnection(HostAndPort hostAndPort) {
        return this.provider.getConnection(hostAndPort);
    }

    public void prepareGraphCommands() {
        super.prepareGraphCommands(this.provider);
    }
}
