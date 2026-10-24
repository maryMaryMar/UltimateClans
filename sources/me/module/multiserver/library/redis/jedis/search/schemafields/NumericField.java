package me.module.multiserver.library.redis.jedis.search.schemafields;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.search.FieldName;
import me.module.multiserver.library.redis.jedis.search.SearchProtocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/NumericField.class */
public class NumericField extends SchemaField {
    private boolean sortable;
    private boolean noIndex;

    public NumericField(String str) {
        super(str);
    }

    public NumericField(FieldName fieldName) {
        super(fieldName);
    }

    public static NumericField of(String str) {
        return new NumericField(str);
    }

    public static NumericField of(FieldName fieldName) {
        return new NumericField(fieldName);
    }

    @Override // me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField
    public NumericField as(String str) {
        super.as(str);
        return this;
    }

    public NumericField sortable() {
        this.sortable = true;
        return this;
    }

    public NumericField noIndex() {
        this.noIndex = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.addParams(this.fieldName);
        commandArguments.add(SearchProtocol.SearchKeyword.NUMERIC);
        if (this.sortable) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTABLE);
        }
        if (this.noIndex) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOINDEX);
        }
    }
}
