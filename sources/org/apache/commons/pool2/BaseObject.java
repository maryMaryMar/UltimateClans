package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/BaseObject.class */
public abstract class BaseObject {
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        toStringAppendFields(sb);
        sb.append("]");
        return sb.toString();
    }

    protected void toStringAppendFields(StringBuilder sb) {
    }
}
