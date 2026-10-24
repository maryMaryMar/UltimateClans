package me.module.multiserver.library.redis.jedis.search;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/IndexDefinition.class */
public class IndexDefinition implements IParams {
    private final Type type;
    private boolean async;
    private String[] prefixes;
    private String filter;
    private String languageField;
    private String language;
    private String scoreFiled;
    private double score;
    private String payloadField;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/IndexDefinition$Type.class */
    public enum Type {
        HASH,
        JSON
    }

    public IndexDefinition() {
        this(null);
    }

    public IndexDefinition(Type type) {
        this.async = false;
        this.score = 1.0d;
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isAsync() {
        return this.async;
    }

    public IndexDefinition setAsync(boolean z) {
        this.async = z;
        return this;
    }

    public String[] getPrefixes() {
        return this.prefixes;
    }

    public IndexDefinition setPrefixes(String... strArr) {
        this.prefixes = strArr;
        return this;
    }

    public String getFilter() {
        return this.filter;
    }

    public IndexDefinition setFilter(String str) {
        this.filter = str;
        return this;
    }

    public String getLanguageField() {
        return this.languageField;
    }

    public IndexDefinition setLanguageField(String str) {
        this.languageField = str;
        return this;
    }

    public String getLanguage() {
        return this.language;
    }

    public IndexDefinition setLanguage(String str) {
        this.language = str;
        return this;
    }

    public String getScoreFiled() {
        return this.scoreFiled;
    }

    public IndexDefinition setScoreFiled(String str) {
        this.scoreFiled = str;
        return this;
    }

    public double getScore() {
        return this.score;
    }

    public IndexDefinition setScore(double d) {
        this.score = d;
        return this;
    }

    public String getPayloadField() {
        return this.payloadField;
    }

    @Deprecated
    public IndexDefinition setPayloadField(String str) {
        this.payloadField = str;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.type != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.ON.name());
            commandArguments.add(this.type.name());
        }
        if (this.async) {
            commandArguments.add(SearchProtocol.SearchKeyword.ASYNC.name());
        }
        if (this.prefixes != null && this.prefixes.length > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.PREFIX.name());
            commandArguments.add(Integer.toString(this.prefixes.length));
            commandArguments.addObjects(this.prefixes);
        }
        if (this.filter != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.FILTER.name());
            commandArguments.add(this.filter);
        }
        if (this.languageField != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LANGUAGE_FIELD.name());
            commandArguments.add(this.languageField);
        }
        if (this.language != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LANGUAGE.name());
            commandArguments.add(this.language);
        }
        if (this.scoreFiled != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SCORE_FIELD.name());
            commandArguments.add(this.scoreFiled);
        }
        if (this.score != 1.0d) {
            commandArguments.add(SearchProtocol.SearchKeyword.SCORE.name());
            commandArguments.add(Double.toString(this.score));
        }
        if (this.payloadField != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.PAYLOAD_FIELD.name());
            commandArguments.add(this.payloadField);
        }
    }
}
