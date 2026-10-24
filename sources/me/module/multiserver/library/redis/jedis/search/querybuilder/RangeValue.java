package me.module.multiserver.library.redis.jedis.search.querybuilder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/RangeValue.class */
public abstract class RangeValue extends Value {
    private boolean inclusiveMin = true;
    private boolean inclusiveMax = true;

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
    public boolean isCombinable() {
        return false;
    }

    protected abstract void appendFrom(StringBuilder sb, boolean z);

    protected abstract void appendTo(StringBuilder sb, boolean z);

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        appendFrom(sb, this.inclusiveMin);
        sb.append(' ');
        appendTo(sb, this.inclusiveMax);
        sb.append(']');
        return sb.toString();
    }

    public RangeValue inclusiveMin(boolean z) {
        this.inclusiveMin = z;
        return this;
    }

    public RangeValue inclusiveMax(boolean z) {
        this.inclusiveMax = z;
        return this;
    }
}
