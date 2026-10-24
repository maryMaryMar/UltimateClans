package me.module.multiserver.library.redis.jedis.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/IndexOptions.class */
public class IndexOptions implements IParams {
    public static final int USE_TERM_OFFSETS = 1;
    public static final int KEEP_FIELD_FLAGS = 2;
    public static final int KEEP_TERM_FREQUENCIES = 8;
    public static final int DEFAULT_FLAGS = 11;
    private final int flags;
    private List<String> stopwords;
    private long expire = 0;
    private IndexDefinition definition;

    public IndexOptions(int i) {
        this.flags = i;
    }

    public static IndexOptions defaultOptions() {
        return new IndexOptions(11);
    }

    public IndexOptions setStopwords(String... strArr) {
        this.stopwords = Arrays.asList(strArr);
        return this;
    }

    public IndexOptions setNoStopwords() {
        this.stopwords = new ArrayList(0);
        return this;
    }

    public IndexOptions setTemporary(long j) {
        this.expire = j;
        return this;
    }

    public IndexDefinition getDefinition() {
        return this.definition;
    }

    public IndexOptions setDefinition(IndexDefinition indexDefinition) {
        this.definition = indexDefinition;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.definition != null) {
            this.definition.addParams(commandArguments);
        }
        if ((this.flags & 1) == 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOOFFSETS.name());
        }
        if ((this.flags & 2) == 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOFIELDS.name());
        }
        if ((this.flags & 8) == 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOFREQS.name());
        }
        if (this.expire > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.TEMPORARY.name());
            commandArguments.add(Long.toString(this.expire));
        }
        if (this.stopwords != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.STOPWORDS.name());
            commandArguments.add(Integer.toString(this.stopwords.size()));
            if (this.stopwords.isEmpty()) {
                return;
            }
            commandArguments.addObjects(this.stopwords);
        }
    }
}
