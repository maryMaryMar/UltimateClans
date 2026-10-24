package me.module.multiserver.library.redis.jedis.search.schemafields;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.search.FieldName;
import me.module.multiserver.library.redis.jedis.search.SearchProtocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/schemafields/TextField.class */
public class TextField extends SchemaField {
    private boolean sortable;
    private boolean sortableUNF;
    private boolean noStem;
    private boolean noIndex;
    private String phoneticMatcher;
    private Double weight;
    private boolean withSuffixTrie;

    public TextField(String str) {
        super(str);
    }

    public TextField(FieldName fieldName) {
        super(fieldName);
    }

    public static TextField of(String str) {
        return new TextField(str);
    }

    public static TextField of(FieldName fieldName) {
        return new TextField(fieldName);
    }

    @Override // me.module.multiserver.library.redis.jedis.search.schemafields.SchemaField
    public TextField as(String str) {
        super.as(str);
        return this;
    }

    public TextField sortable() {
        this.sortable = true;
        return this;
    }

    public TextField sortableUNF() {
        this.sortableUNF = true;
        return this;
    }

    public TextField sortableUnNormalizedForm() {
        return sortableUNF();
    }

    public TextField noStem() {
        this.noStem = true;
        return this;
    }

    public TextField noIndex() {
        this.noIndex = true;
        return this;
    }

    public TextField phonetic(String str) {
        this.phoneticMatcher = str;
        return this;
    }

    public TextField weight(double d) {
        this.weight = Double.valueOf(d);
        return this;
    }

    public TextField withSuffixTrie() {
        this.withSuffixTrie = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.addParams(this.fieldName);
        commandArguments.add(SearchProtocol.SearchKeyword.TEXT);
        if (this.sortableUNF) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTABLE).add(SearchProtocol.SearchKeyword.UNF);
        } else if (this.sortable) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTABLE);
        }
        if (this.noStem) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOSTEM);
        }
        if (this.noIndex) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOINDEX);
        }
        if (this.phoneticMatcher != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.PHONETIC).add(this.phoneticMatcher);
        }
        if (this.weight != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.WEIGHT).add(this.weight);
        }
        if (this.withSuffixTrie) {
            commandArguments.add(SearchProtocol.SearchKeyword.WITHSUFFIXTRIE);
        }
    }
}
