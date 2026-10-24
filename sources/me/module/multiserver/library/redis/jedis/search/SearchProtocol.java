package me.module.multiserver.library.redis.jedis.search;

import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/SearchProtocol.class */
public class SearchProtocol {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/SearchProtocol$SearchCommand.class */
    public enum SearchCommand implements ProtocolCommand {
        CREATE("FT.CREATE"),
        ALTER("FT.ALTER"),
        INFO("FT.INFO"),
        SEARCH("FT.SEARCH"),
        EXPLAIN("FT.EXPLAIN"),
        EXPLAINCLI("FT.EXPLAINCLI"),
        AGGREGATE("FT.AGGREGATE"),
        CURSOR("FT.CURSOR"),
        CONFIG("FT.CONFIG"),
        ALIASADD("FT.ALIASADD"),
        ALIASUPDATE("FT.ALIASUPDATE"),
        ALIASDEL("FT.ALIASDEL"),
        SYNUPDATE("FT.SYNUPDATE"),
        SYNDUMP("FT.SYNDUMP"),
        SUGADD("FT.SUGADD"),
        SUGGET("FT.SUGGET"),
        SUGDEL("FT.SUGDEL"),
        SUGLEN("FT.SUGLEN"),
        DROPINDEX("FT.DROPINDEX"),
        DICTADD("FT.DICTADD"),
        DICTDEL("FT.DICTDEL"),
        DICTDUMP("FT.DICTDUMP"),
        TAGVALS("FT.TAGVALS");

        private final byte[] raw;

        SearchCommand(String str) {
            this.raw = SafeEncoder.encode(str);
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/SearchProtocol$SearchKeyword.class */
    public enum SearchKeyword implements Rawable {
        SCHEMA,
        TEXT,
        TAG,
        NUMERIC,
        GEO,
        VECTOR,
        VERBATIM,
        NOCONTENT,
        NOSTOPWORDS,
        WITHSCORES,
        LANGUAGE,
        INFIELDS,
        SORTBY,
        ASC,
        DESC,
        LIMIT,
        HIGHLIGHT,
        FIELDS,
        TAGS,
        SUMMARIZE,
        FRAGS,
        LEN,
        SEPARATOR,
        INKEYS,
        RETURN,
        FILTER,
        GEOFILTER,
        ADD,
        INCR,
        MAX,
        FUZZY,
        READ,
        DEL,
        DD,
        TEMPORARY,
        STOPWORDS,
        NOFREQS,
        NOFIELDS,
        NOOFFSETS,
        NOHL,
        SET,
        GET,
        ON,
        SORTABLE,
        UNF,
        PREFIX,
        LANGUAGE_FIELD,
        SCORE,
        SCORE_FIELD,
        SCORER,
        PARAMS,
        AS,
        DIALECT,
        SLOP,
        TIMEOUT,
        INORDER,
        EXPANDER,
        MAXTEXTFIELDS,
        SKIPINITIALSCAN,
        WITHSUFFIXTRIE,
        NOSTEM,
        NOINDEX,
        PHONETIC,
        WEIGHT,
        CASESENSITIVE,
        LOAD,
        APPLY,
        GROUPBY,
        MAXIDLE,
        WITHCURSOR,
        ASYNC,
        PAYLOAD_FIELD,
        WITHPAYLOADS,
        PAYLOAD,
        COUNT;

        private final byte[] raw = SafeEncoder.encode(name());

        SearchKeyword() {
        }

        @Override // me.module.multiserver.library.redis.jedis.args.Rawable
        public byte[] getRaw() {
            return this.raw;
        }
    }
}
