package me.module.multiserver.library.redis.jedis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import me.module.multiserver.library.redis.jedis.util.Hashing;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ShardedCommandArguments.class */
public class ShardedCommandArguments extends CommandArguments {
    private final Hashing algo;
    private final Pattern tagPattern;
    private Long keyHash;

    public ShardedCommandArguments(Hashing hashing, ProtocolCommand protocolCommand) {
        this(hashing, null, protocolCommand);
    }

    public ShardedCommandArguments(Hashing hashing, Pattern pattern, ProtocolCommand protocolCommand) {
        super(protocolCommand);
        this.keyHash = null;
        this.algo = hashing;
        this.tagPattern = pattern;
    }

    public Long getKeyHash() {
        return this.keyHash;
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandArguments
    protected CommandArguments processKey(byte[] bArr) {
        long jHash = this.algo.hash(bArr);
        if (this.keyHash == null) {
            this.keyHash = Long.valueOf(jHash);
        } else if (this.keyHash.longValue() != jHash) {
            throw new JedisException("Keys must generate same hash.");
        }
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandArguments
    protected CommandArguments processKey(String str) {
        long jHash = this.algo.hash(getKeyTag(str));
        if (this.keyHash == null) {
            this.keyHash = Long.valueOf(jHash);
        } else if (this.keyHash.longValue() != jHash) {
            throw new JedisException("Keys must generate same hash.");
        }
        return this;
    }

    private String getKeyTag(String str) {
        if (this.tagPattern != null) {
            Matcher matcher = this.tagPattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return str;
    }
}
