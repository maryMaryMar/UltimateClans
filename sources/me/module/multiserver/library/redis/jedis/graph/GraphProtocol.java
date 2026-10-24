package me.module.multiserver.library.redis.jedis.graph;

import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphProtocol.class */
public class GraphProtocol {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphProtocol$GraphCommand.class */
    public enum GraphCommand implements ProtocolCommand {
        QUERY,
        RO_QUERY,
        DELETE,
        LIST,
        PROFILE,
        EXPLAIN,
        SLOWLOG,
        CONFIG;

        private final byte[] raw = SafeEncoder.encode("GRAPH." + name());

        GraphCommand() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/GraphProtocol$GraphKeyword.class */
    public enum GraphKeyword implements Rawable {
        CYPHER,
        TIMEOUT,
        SET,
        GET,
        __COMPACT(RedisGraphQueryUtil.COMPACT_STRING);

        private final byte[] raw;

        GraphKeyword() {
            this.raw = SafeEncoder.encode(name());
        }

        GraphKeyword(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }
}
