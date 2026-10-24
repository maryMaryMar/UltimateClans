package me.module.multiserver.library.redis.jedis.search.querybuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/LongRangeValue.class */
public class LongRangeValue extends RangeValue {
    private final long from;
    private final long to;

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.RangeValue, me.module.multiserver.library.redis.jedis.search.querybuilder.Value
    public boolean isCombinable() {
        return false;
    }

    private static void appendNum(StringBuilder sb, long j, boolean z) {
        if (!z) {
            sb.append("(");
        }
        if (j == Long.MIN_VALUE) {
            sb.append("-inf");
        } else if (j == Long.MAX_VALUE) {
            sb.append("inf");
        } else {
            sb.append(Long.toString(j));
        }
    }

    public LongRangeValue(long j, long j2) {
        this.from = j;
        this.to = j2;
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.RangeValue
    protected void appendFrom(StringBuilder sb, boolean z) {
        appendNum(sb, this.from, z);
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.RangeValue
    protected void appendTo(StringBuilder sb, boolean z) {
        appendNum(sb, this.to, z);
    }
}
