package me.module.multiserver.library.redis.jedis.search.querybuilder;

import java.util.StringJoiner;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/ValueNode.class */
public class ValueNode implements Node {
    private final Value[] values;
    private final String field;
    private final String joinString;

    public ValueNode(String str, String str2, Value... valueArr) {
        this.field = str;
        this.values = valueArr;
        this.joinString = str2;
    }

    private static Value[] fromStrings(String[] strArr) {
        Value[] valueArr = new Value[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            valueArr[i] = Values.value(strArr[i]);
        }
        return valueArr;
    }

    public ValueNode(String str, String str2, String... strArr) {
        this(str, str2, fromStrings(strArr));
    }

    private String formatField() {
        return (this.field == null || this.field.isEmpty()) ? "" : '@' + this.field + ':';
    }

    private String toStringCombinable(Node.Parenthesize parenthesize) {
        StringBuilder sb = new StringBuilder(formatField());
        if (this.values.length > 1 || parenthesize == Node.Parenthesize.ALWAYS) {
            sb.append('(');
        }
        StringJoiner stringJoiner = new StringJoiner(this.joinString);
        for (Value value : this.values) {
            stringJoiner.add(value.toString());
        }
        sb.append(stringJoiner.toString());
        if (this.values.length > 1 || parenthesize == Node.Parenthesize.ALWAYS) {
            sb.append(')');
        }
        return sb.toString();
    }

    private String toStringDefault(Node.Parenthesize parenthesize) {
        boolean z = parenthesize == Node.Parenthesize.ALWAYS;
        if (!z) {
            z = parenthesize != Node.Parenthesize.NEVER && this.values.length > 1;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('(');
        }
        StringJoiner stringJoiner = new StringJoiner(this.joinString);
        for (Value value : this.values) {
            stringJoiner.add(formatField() + value.toString());
        }
        sb.append(stringJoiner.toString());
        if (z) {
            sb.append(')');
        }
        return sb.toString();
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Node
    public String toString(Node.Parenthesize parenthesize) {
        return this.values[0].isCombinable() ? toStringCombinable(parenthesize) : toStringDefault(parenthesize);
    }
}
