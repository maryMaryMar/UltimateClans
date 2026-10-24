package me.module.multiserver.library.redis.jedis.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FTCreateParams.class */
public class FTCreateParams implements IParams {
    private IndexDataType dataType;
    private Collection<String> prefix;
    private String filter;
    private String language;
    private String languageField;
    private Double score;
    private String scoreField;
    private boolean maxTextFields;
    private boolean noOffsets;
    private Long temporary;
    private boolean noHL;
    private boolean noFields;
    private boolean noFreqs;
    private Collection<String> stopwords;
    private boolean skipInitialScan;

    public static FTCreateParams createParams() {
        return new FTCreateParams();
    }

    public FTCreateParams on(IndexDataType indexDataType) {
        this.dataType = indexDataType;
        return this;
    }

    public FTCreateParams prefix(String... strArr) {
        if (this.prefix == null) {
            this.prefix = new ArrayList(strArr.length);
        }
        Arrays.stream(strArr).forEach(str -> {
            this.prefix.add(str);
        });
        return this;
    }

    public FTCreateParams addPrefix(String str) {
        if (this.prefix == null) {
            this.prefix = new ArrayList();
        }
        this.prefix.add(str);
        return this;
    }

    public FTCreateParams filter(String str) {
        this.filter = str;
        return this;
    }

    public FTCreateParams language(String str) {
        this.language = str;
        return this;
    }

    public FTCreateParams languageField(String str) {
        this.languageField = str;
        return this;
    }

    public FTCreateParams score(double d) {
        this.score = Double.valueOf(d);
        return this;
    }

    public FTCreateParams scoreField(String str) {
        this.scoreField = str;
        return this;
    }

    public FTCreateParams maxTextFields() {
        this.maxTextFields = true;
        return this;
    }

    public FTCreateParams noOffsets() {
        this.noOffsets = true;
        return this;
    }

    public FTCreateParams temporary(long j) {
        this.temporary = Long.valueOf(j);
        return this;
    }

    public FTCreateParams noHL() {
        this.noHL = true;
        return this;
    }

    public FTCreateParams noHighlights() {
        return noHL();
    }

    public FTCreateParams noFields() {
        this.noFields = true;
        return this;
    }

    public FTCreateParams noFreqs() {
        this.noFreqs = true;
        return this;
    }

    public FTCreateParams stopwords(String... strArr) {
        this.stopwords = Arrays.asList(strArr);
        return this;
    }

    public FTCreateParams noStopwords() {
        this.stopwords = Collections.emptyList();
        return this;
    }

    public FTCreateParams skipInitialScan() {
        this.skipInitialScan = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.dataType != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.ON).add(this.dataType);
        }
        if (this.prefix != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.PREFIX).add(Integer.valueOf(this.prefix.size())).addObjects(this.prefix);
        }
        if (this.filter != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.FILTER).add(this.filter);
        }
        if (this.language != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LANGUAGE).add(this.language);
        }
        if (this.languageField != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LANGUAGE_FIELD).add(this.languageField);
        }
        if (this.score != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SCORE).add(this.score);
        }
        if (this.scoreField != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SCORE_FIELD).add(this.scoreField);
        }
        if (this.maxTextFields) {
            commandArguments.add(SearchProtocol.SearchKeyword.MAXTEXTFIELDS);
        }
        if (this.noOffsets) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOOFFSETS);
        }
        if (this.temporary != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.TEMPORARY).add(this.temporary);
        }
        if (this.noHL) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOHL);
        }
        if (this.noFields) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOFIELDS);
        }
        if (this.noFreqs) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOFREQS);
        }
        if (this.stopwords != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.STOPWORDS).add(Integer.valueOf(this.stopwords.size()));
            this.stopwords.forEach(str -> {
                commandArguments.add(str);
            });
        }
        if (this.skipInitialScan) {
            commandArguments.add(SearchProtocol.SearchKeyword.SKIPINITIALSCAN);
        }
    }
}
