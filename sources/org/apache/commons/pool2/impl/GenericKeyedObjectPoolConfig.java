package org.apache.commons.pool2.impl;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericKeyedObjectPoolConfig.class */
public class GenericKeyedObjectPoolConfig<T> extends BaseObjectPoolConfig<T> {
    public static final int DEFAULT_MAX_TOTAL_PER_KEY = 8;
    public static final int DEFAULT_MAX_TOTAL = -1;
    public static final int DEFAULT_MIN_IDLE_PER_KEY = 0;
    public static final int DEFAULT_MAX_IDLE_PER_KEY = 8;
    private int minIdlePerKey = 0;
    private int maxIdlePerKey = 8;
    private int maxTotalPerKey = 8;
    private int maxTotal = -1;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GenericKeyedObjectPoolConfig<T> m1014clone() {
        try {
            return (GenericKeyedObjectPoolConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int getMaxIdlePerKey() {
        return this.maxIdlePerKey;
    }

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public int getMaxTotalPerKey() {
        return this.maxTotalPerKey;
    }

    public int getMinIdlePerKey() {
        return this.minIdlePerKey;
    }

    public void setMaxIdlePerKey(int i) {
        this.maxIdlePerKey = i;
    }

    public void setMaxTotal(int i) {
        this.maxTotal = i;
    }

    public void setMaxTotalPerKey(int i) {
        this.maxTotalPerKey = i;
    }

    public void setMinIdlePerKey(int i) {
        this.minIdlePerKey = i;
    }

    @Override // org.apache.commons.pool2.impl.BaseObjectPoolConfig, org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        super.toStringAppendFields(sb);
        sb.append(", minIdlePerKey=");
        sb.append(this.minIdlePerKey);
        sb.append(", maxIdlePerKey=");
        sb.append(this.maxIdlePerKey);
        sb.append(", maxTotalPerKey=");
        sb.append(this.maxTotalPerKey);
        sb.append(", maxTotal=");
        sb.append(this.maxTotal);
    }
}
