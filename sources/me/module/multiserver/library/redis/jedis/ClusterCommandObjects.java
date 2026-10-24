package me.module.multiserver.library.redis.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.search.IndexOptions;
import me.module.multiserver.library.redis.jedis.search.Query;
import me.module.multiserver.library.redis.jedis.search.Schema;
import me.module.multiserver.library.redis.jedis.search.SearchResult;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationBuilder;
import me.module.multiserver.library.redis.jedis.search.aggr.AggregationResult;
import me.module.multiserver.library.redis.jedis.util.JedisClusterHashTag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/ClusterCommandObjects.class */
public class ClusterCommandObjects extends CommandObjects {
    private static final String CLUSTER_UNSUPPORTED_MESSAGE = "Not supported in cluster mode.";
    private static final String KEYS_PATTERN_MESSAGE = "Cluster mode only supports KEYS command with pattern containing hash-tag ( curly-brackets enclosed string )";
    private static final String SCAN_PATTERN_MESSAGE = "Cluster mode only supports SCAN command with MATCH pattern containing hash-tag ( curly-brackets enclosed string )";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public ClusterCommandArguments commandArguments(ProtocolCommand protocolCommand) {
        return new ClusterCommandArguments(protocolCommand);
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<Long> dbSize() {
        throw new UnsupportedOperationException(CLUSTER_UNSUPPORTED_MESSAGE);
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
        throw new UnsupportedOperationException(CLUSTER_UNSUPPORTED_MESSAGE);
    }

    private <T> CommandObject<T> processSearchCommand(String str, CommandObject<T> commandObject) {
        commandObject.getArguments().processKey(str);
        return commandObject;
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<String> ftCreate(String str, IndexOptions indexOptions, Schema schema) {
        return processSearchCommand(str, super.ftCreate(str, indexOptions, schema));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<String> ftAlter(String str, Schema schema) {
        return processSearchCommand(str, super.ftAlter(str, schema));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<SearchResult> ftSearch(String str, Query query) {
        return processSearchCommand(str, super.ftSearch(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public final CommandObject<SearchResult> ftSearch(byte[] bArr, Query query) {
        CommandObject<SearchResult> commandObjectFtSearch = super.ftSearch(bArr, query);
        commandObjectFtSearch.getArguments().processKey(bArr);
        return commandObjectFtSearch;
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftExplain(String str, Query query) {
        return processSearchCommand(str, super.ftExplain(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<List<String>> ftExplainCLI(String str, Query query) {
        return processSearchCommand(str, super.ftExplainCLI(str, query));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<AggregationResult> ftAggregate(String str, AggregationBuilder aggregationBuilder) {
        return processSearchCommand(str, super.ftAggregate(str, aggregationBuilder));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<AggregationResult> ftCursorRead(String str, long j, int i) {
        return processSearchCommand(str, super.ftCursorRead(str, j, i));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftCursorDel(String str, long j) {
        return processSearchCommand(str, super.ftCursorDel(str, j));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftDropIndex(String str) {
        return processSearchCommand(str, super.ftDropIndex(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftDropIndexDD(String str) {
        return processSearchCommand(str, super.ftDropIndexDD(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftSynUpdate(String str, String str2, String... strArr) {
        return processSearchCommand(str, super.ftSynUpdate(str, str2, strArr));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<Map<String, List<String>>> ftSynDump(String str) {
        return processSearchCommand(str, super.ftSynDump(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<Map<String, Object>> ftInfo(String str) {
        return processSearchCommand(str, super.ftInfo(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<Set<String>> ftTagVals(String str, String str2) {
        return processSearchCommand(str, super.ftTagVals(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftAliasAdd(String str, String str2) {
        return processSearchCommand(str2, super.ftAliasAdd(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftAliasUpdate(String str, String str2) {
        return processSearchCommand(str2, super.ftAliasUpdate(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftAliasDel(String str) {
        return processSearchCommand(str, super.ftAliasDel(str));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<Map<String, String>> ftConfigGet(String str, String str2) {
        return processSearchCommand(str, super.ftConfigGet(str, str2));
    }

    @Override // me.module.multiserver.library.redis.jedis.CommandObjects
    public CommandObject<String> ftConfigSet(String str, String str2, String str3) {
        return processSearchCommand(str, super.ftConfigSet(str, str2, str3));
    }
}
