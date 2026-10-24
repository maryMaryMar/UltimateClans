package org.apache.commons.pool2.impl;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericObjectPoolConfig.class */
public class GenericObjectPoolConfig<T> extends BaseObjectPoolConfig<T> {
    public static final int DEFAULT_MAX_TOTAL = 8;
    public static final int DEFAULT_MAX_IDLE = 8;
    public static final int DEFAULT_MIN_IDLE = 0;
    private int maxTotal = 8;
    private int maxIdle = 8;
    private int minIdle = 0;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GenericObjectPoolConfig<T> m1015clone() {
        try {
            return (GenericObjectPoolConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int getMaxIdle() {
        return this.maxIdle;
    }

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public int getMinIdle() {
        return this.minIdle;
    }

    public void setMaxIdle(int i) {
        this.maxIdle = i;
    }

    public void setMaxTotal(int i) {
        this.maxTotal = i;
    }

    public void setMinIdle(int i) {
        this.minIdle = i;
    }

    @Override // org.apache.commons.pool2.impl.BaseObjectPoolConfig, org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        super.toStringAppendFields(sb);
        sb.append(", maxTotal=");
        sb.append(this.maxTotal);
        sb.append(", maxIdle=");
        sb.append(this.maxIdle);
        sb.append(", minIdle=");
        sb.append(this.minIdle);
    }
}
