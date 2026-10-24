package me.module.multiserver.library.redis.jedis.search.querybuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/DoubleRangeValue.class */
public class DoubleRangeValue extends RangeValue {
    private final double from;
    private final double to;

    private static void appendNum(StringBuilder sb, double d, boolean z) {
        if (!z) {
            sb.append("(");
        }
        if (d == Double.NEGATIVE_INFINITY) {
            sb.append("-inf");
        } else if (d == Double.POSITIVE_INFINITY) {
            sb.append("inf");
        } else {
            sb.append(d);
        }
    }

    public DoubleRangeValue(double d, double d2) {
        this.from = d;
        this.to = d2;
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
