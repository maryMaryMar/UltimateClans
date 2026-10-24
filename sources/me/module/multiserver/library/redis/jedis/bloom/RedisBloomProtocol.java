package me.module.multiserver.library.redis.jedis.bloom;

import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol.class */
public class RedisBloomProtocol {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol$BloomFilterCommand.class */
    public enum BloomFilterCommand implements ProtocolCommand {
        RESERVE("BF.RESERVE"),
        ADD("BF.ADD"),
        MADD("BF.MADD"),
        EXISTS("BF.EXISTS"),
        MEXISTS("BF.MEXISTS"),
        INSERT("BF.INSERT"),
        SCANDUMP("BF.SCANDUMP"),
        LOADCHUNK("BF.LOADCHUNK"),
        INFO("BF.INFO");

        private final byte[] raw;

        BloomFilterCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol$CountMinSketchCommand.class */
    public enum CountMinSketchCommand implements ProtocolCommand {
        INITBYDIM("CMS.INITBYDIM"),
        INITBYPROB("CMS.INITBYPROB"),
        INCRBY("CMS.INCRBY"),
        QUERY("CMS.QUERY"),
        MERGE("CMS.MERGE"),
        INFO("CMS.INFO");

        private final byte[] raw;

        CountMinSketchCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol$CuckooFilterCommand.class */
    public enum CuckooFilterCommand implements ProtocolCommand {
        RESERVE("CF.RESERVE"),
        ADD("CF.ADD"),
        ADDNX("CF.ADDNX"),
        INSERT("CF.INSERT"),
        INSERTNX("CF.INSERTNX"),
        EXISTS("CF.EXISTS"),
        MEXISTS("CF.MEXISTS"),
        DEL("CF.DEL"),
        COUNT("CF.COUNT"),
        SCANDUMP("CF.SCANDUMP"),
        LOADCHUNK("CF.LOADCHUNK"),
        INFO("CF.INFO");

        private final byte[] raw;

        CuckooFilterCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol$RedisBloomKeyword.class */
    public enum RedisBloomKeyword implements Rawable {
        CAPACITY,
        ERROR,
        NOCREATE,
        EXPANSION,
        NONSCALING,
        BUCKETSIZE,
        MAXITERATIONS,
        ITEMS,
        WEIGHTS,
        COMPRESSION,
        OVERRIDE;

        private final byte[] raw = SafeEncoder.encode(name());

        RedisBloomKeyword() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol$TDigestCommand.class */
    public enum TDigestCommand implements ProtocolCommand {
        CREATE,
        INFO,
        ADD,
        RESET,
        MERGE,
        CDF,
        QUANTILE,
        MIN,
        MAX,
        TRIMMED_MEAN,
        RANK,
        REVRANK,
        BYRANK,
        BYREVRANK;

        private final byte[] raw = SafeEncoder.encode("TDIGEST." + name());

        TDigestCommand() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/RedisBloomProtocol$TopKCommand.class */
    public enum TopKCommand implements ProtocolCommand {
        RESERVE("TOPK.RESERVE"),
        ADD("TOPK.ADD"),
        INCRBY("TOPK.INCRBY"),
        QUERY("TOPK.QUERY"),
        COUNT("TOPK.COUNT"),
        LIST("TOPK.LIST"),
        INFO("TOPK.INFO");

        private final byte[] raw;

        TopKCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }
}
