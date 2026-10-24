package me.module.multiserver.library.redis.jedis.search.schemafields;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.search.FieldName;
import me.module.multiserver.library.redis.jedis.search.SearchProtocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/GeoField.class */
public class GeoField extends SchemaField {
    public GeoField(String str) {
        super(str);
    }

    public GeoField(FieldName fieldName) {
        super(fieldName);
    }

    public static GeoField of(String str) {
        return new GeoField(str);
    }

    public static GeoField of(FieldName fieldName) {
        return new GeoField(fieldName);
    }

    @Override // me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField
    public GeoField as(String str) {
        super.as(str);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.addParams(this.fieldName);
        commandArguments.add(SearchProtocol.SearchKeyword.GEO);
    }
}
