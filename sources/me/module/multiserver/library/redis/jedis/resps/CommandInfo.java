package me.module.multiserver.library.redis.jedis.resps;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/CommandInfo.class */
public class CommandInfo {
    private final long arity;
    private final List<String> flags;
    private final long firstKey;
    private final long lastKey;
    private final long step;
    private final List<String> aclCategories;
    private final List<String> tips;
    private final List<String> subcommands;
    public static final Builder<CommandInfo> COMMAND_INFO_BUILDER = new Builder<CommandInfo>() { // from class: me.module.multiserver.library.redis.jedis.resps.CommandInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public CommandInfo build(Object obj) {
            List list = (List) obj;
            return new CommandInfo(BuilderFactory.LONG.build(list.get(1)).longValue(), BuilderFactory.STRING_LIST.build(list.get(2)), BuilderFactory.LONG.build(list.get(3)).longValue(), BuilderFactory.LONG.build(list.get(4)).longValue(), BuilderFactory.LONG.build(list.get(5)).longValue(), BuilderFactory.STRING_LIST.build(list.get(6)), BuilderFactory.STRING_LIST.build(list.get(7)), BuilderFactory.STRING_LIST.build(list.get(9)));
        }
    };

    public CommandInfo(long j, List<String> list, long j2, long j3, long j4, List<String> list2, List<String> list3, List<String> list4) {
        this.arity = j;
        this.flags = list;
        this.firstKey = j2;
        this.lastKey = j3;
        this.step = j4;
        this.aclCategories = list2;
        this.tips = list3;
        this.subcommands = list4;
    }

    public long getArity() {
        return this.arity;
    }

    public List<String> getFlags() {
        return this.flags;
    }

    public long getFirstKey() {
        return this.firstKey;
    }

    public long getLastKey() {
        return this.lastKey;
    }

    public long getStep() {
        return this.step;
    }

    public List<String> getAclCategories() {
        return this.aclCategories;
    }

    public List<String> getTips() {
        return this.tips;
    }

    public List<String> getSubcommands() {
        return this.subcommands;
    }
}
