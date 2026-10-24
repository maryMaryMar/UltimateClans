package me.module.multiserver.library.redis.jedis.search;

import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FieldName.class */
public class FieldName implements IParams {
    private static final String AS_ENCODED = "AS";
    private static final byte[] AS_BINARY = SafeEncoder.encode(AS_ENCODED);
    private static final byte[] AS = SafeEncoder.encode(AS_ENCODED);
    private final String name;
    private String attribute;

    public FieldName(String str) {
        this.name = str;
    }

    public FieldName(String str, String str2) {
        this.name = str;
        this.attribute = str2;
    }

    public FieldName as(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Setting null as field attribute is not allowed.");
        }
        if (this.attribute != null) {
            throw new IllegalStateException("Attribute for this field is already set.");
        }
        this.attribute = str;
        return this;
    }

    public int addCommandEncodedArguments(List<String> list) {
        list.add(this.name);
        if (this.attribute == null) {
            return 1;
        }
        list.add(AS_ENCODED);
        list.add(this.attribute);
        return 3;
    }

    public int addCommandBinaryArguments(List<byte[]> list) {
        list.add(SafeEncoder.encode(this.name));
        if (this.attribute == null) {
            return 1;
        }
        list.add(AS_BINARY);
        list.add(SafeEncoder.encode(this.attribute));
        return 3;
    }

    public int addCommandArguments(CommandArguments commandArguments) {
        commandArguments.add(SafeEncoder.encode(this.name));
        if (this.attribute == null) {
            return 1;
        }
        commandArguments.add(AS);
        commandArguments.add(SafeEncoder.encode(this.attribute));
        return 3;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        addCommandArguments(commandArguments);
    }

    @Deprecated
    String getName() {
        return this.name;
    }

    public String toString() {
        return this.attribute == null ? this.name : this.name + " AS " + this.attribute;
    }

    public static FieldName of(String str) {
        return new FieldName(str);
    }

    public static FieldName[] convert(String... strArr) {
        if (strArr == null) {
            return null;
        }
        FieldName[] fieldNameArr = new FieldName[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fieldNameArr[i] = of(strArr[i]);
        }
        return fieldNameArr;
    }
}
