package me.module.multiserver.library.redis.jedis.search.schemafields;

import me.module.multiserver.library.redis.jedis.params.IParams;
import me.module.multiserver.library.redis.jedis.search.FieldName;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/SchemaField.class */
public abstract class SchemaField implements IParams {
    protected final FieldName fieldName;

    public SchemaField(String str) {
        this.fieldName = new FieldName(str);
    }

    public SchemaField(FieldName fieldName) {
        this.fieldName = fieldName;
    }

    public SchemaField as(String str) {
        this.fieldName.as(str);
        return this;
    }
}
