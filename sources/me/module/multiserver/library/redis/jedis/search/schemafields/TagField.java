package me.module.multiserver.library.redis.jedis.search.schemafields;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.search.FieldName;
import me.module.multiserver.library.redis.jedis.search.SearchProtocol;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/TagField.class */
public class TagField extends SchemaField {
    private boolean sortable;
    private boolean sortableUNF;
    private boolean noIndex;
    private byte[] separator;
    private boolean caseSensitive;
    private boolean withSuffixTrie;

    public TagField(String str) {
        super(str);
    }

    public TagField(FieldName fieldName) {
        super(fieldName);
    }

    public static TagField of(String str) {
        return new TagField(str);
    }

    public static TagField of(FieldName fieldName) {
        return new TagField(fieldName);
    }

    @Override // me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField
    public TagField as(String str) {
        super.as(str);
        return this;
    }

    public TagField sortable() {
        this.sortable = true;
        return this;
    }

    public TagField sortableUNF() {
        this.sortableUNF = true;
        return this;
    }

    public TagField sortableUnNormalizedForm() {
        return sortableUNF();
    }

    public TagField noIndex() {
        this.noIndex = true;
        return this;
    }

    public TagField separator(char c) {
        if (c < 128) {
            this.separator = new byte[]{(byte) c};
        } else {
            this.separator = SafeEncoder.encode(String.valueOf(c));
        }
        return this;
    }

    public TagField caseSensitive() {
        this.caseSensitive = true;
        return this;
    }

    public TagField withSuffixTrie() {
        this.withSuffixTrie = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.addParams(this.fieldName);
        commandArguments.add(SearchProtocol.SearchKeyword.TAG);
        if (this.separator != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SEPARATOR).add(this.separator);
        }
        if (this.sortableUNF) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTABLE).add(SearchProtocol.SearchKeyword.UNF);
        } else if (this.sortable) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTABLE);
        }
        if (this.noIndex) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOINDEX);
        }
        if (this.caseSensitive) {
            commandArguments.add(SearchProtocol.SearchKeyword.CASESENSITIVE);
        }
        if (this.withSuffixTrie) {
            commandArguments.add(SearchProtocol.SearchKeyword.WITHSUFFIXTRIE);
        }
    }
}
