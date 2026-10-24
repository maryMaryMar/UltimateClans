package me.module.multiserver.library.redis.jedis;

import java.util.Set;
import java.util.regex.Pattern;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.util.Hashing;
import me.module.multiserver.library.redis.jedis.util.JedisClusterHashTag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ShardedCommandObjects.class */
public class ShardedCommandObjects extends CommandObjects {
    private final Hashing algo;
    private final Pattern tagPattern;
    private static final String KEYS_PATTERN_MESSAGE = "Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )";
    private static final String SCAN_PATTERN_MESSAGE = "Cluster mode only supports SCAN command with MATCH pattern containing hash-tag ( curly-brackets enclosed string )";

    public ShardedCommandObjects(Hashing hashing) {
        this(hashing, null);
    }

    public ShardedCommandObjects(Hashing hashing, Pattern pattern) {
        this.algo = hashing;
        this.tagPattern = pattern;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public ShardedCommandArguments commandArguments(ProtocolCommand protocolCommand) {
        return new ShardedCommandArguments(this.algo, this.tagPattern, protocolCommand);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<Long> dbSize() {
        throw new UnsupportedOperationException();
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<Set<String>> keys(String str) {
        if (JedisClusterHashTag.isClusterCompliantMatchPattern(str)) {
            return new CommandObject<>(commandArguments((ProtocolCommand) Protocol.Command.KEYS).key(str).processKey(str), BuilderFactory.STRING_SET);
        }
        throw new IllegalArgumentException(KEYS_PATTERN_MESSAGE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<Set<byte[]>> keys(byte[] bArr) {
        if (JedisClusterHashTag.isClusterCompliantMatchPattern(bArr)) {
            return new CommandObject<>(commandArguments((ProtocolCommand) Protocol.Command.KEYS).key(bArr).processKey(bArr), BuilderFactory.BINARY_SET);
        }
        throw new IllegalArgumentException(KEYS_PATTERN_MESSAGE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<ScanResult<String>> scan(String str) {
        throw new IllegalArgumentException(SCAN_PATTERN_MESSAGE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<ScanResult<String>> scan(String str, ScanParams scanParams) {
        String strMatch = scanParams.match();
        if (strMatch == null || !JedisClusterHashTag.isClusterCompliantMatchPattern(strMatch)) {
            throw new IllegalArgumentException(SCAN_PATTERN_MESSAGE);
        }
        return new CommandObject<>(commandArguments((ProtocolCommand) Protocol.Command.SCAN).add(str).addParams(scanParams).processKey(strMatch), BuilderFactory.SCAN_RESPONSE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<ScanResult<String>> scan(String str, ScanParams scanParams, String str2) {
        String strMatch = scanParams.match();
        if (strMatch == null || !JedisClusterHashTag.isClusterCompliantMatchPattern(strMatch)) {
            throw new IllegalArgumentException(SCAN_PATTERN_MESSAGE);
        }
        return new CommandObject<>(commandArguments((ProtocolCommand) Protocol.Command.SCAN).add(str).addParams(scanParams).processKey(strMatch).add(Protocol.Keyword.TYPE).add(str2), BuilderFactory.SCAN_RESPONSE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<ScanResult<byte[]>> scan(byte[] bArr) {
        throw new IllegalArgumentException(SCAN_PATTERN_MESSAGE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams) {
        byte[] bArrBinaryMatch = scanParams.binaryMatch();
        if (bArrBinaryMatch == null || !JedisClusterHashTag.isClusterCompliantMatchPattern(bArrBinaryMatch)) {
            throw new IllegalArgumentException(SCAN_PATTERN_MESSAGE);
        }
        return new CommandObject<>(commandArguments((ProtocolCommand) Protocol.Command.SCAN).add(bArr).addParams(scanParams).processKey(bArrBinaryMatch), BuilderFactory.SCAN_BINARY_RESPONSE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2) {
        byte[] bArrBinaryMatch = scanParams.binaryMatch();
        if (bArrBinaryMatch == null || !JedisClusterHashTag.isClusterCompliantMatchPattern(bArrBinaryMatch)) {
            throw new IllegalArgumentException(SCAN_PATTERN_MESSAGE);
        }
        return new CommandObject<>(commandArguments((ProtocolCommand) Protocol.Command.SCAN).add(bArr).addParams(scanParams).processKey(bArrBinaryMatch).add(Protocol.Keyword.TYPE).add(bArr2), BuilderFactory.SCAN_BINARY_RESPONSE);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<Long> waitReplicas(int i, long j) {
        throw new UnsupportedOperationException();
    }
}
