package me.module.multiserver.library.redis.jedis.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Query.class */
public class Query implements IParams {
    private final List<Filter> _filters;
    private final String _queryString;
    private final Paging _paging;
    private boolean _verbatim;
    private boolean _noContent;
    private boolean _noStopwords;
    private boolean _withScores;
    private boolean _withPayloads;
    private String _language;
    private String[] _fields;
    private String[] _keys;
    private String[] _returnFields;
    private FieldName[] returnFieldNames;
    private String[] highlightFields;
    private String[] summarizeFields;
    private String[] highlightTags;
    private String summarizeSeparator;
    private int summarizeNumFragments;
    private int summarizeFragmentLen;
    private byte[] _payload;
    private String _sortBy;
    private boolean _sortAsc;
    private boolean wantsHighlight;
    private boolean wantsSummarize;
    private String _scorer;
    private Map<String, Object> _params;
    private int _dialect;
    private int _slop;
    private long _timeout;
    private boolean _inOrder;
    private String _expander;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Query$Filter.class */
    public static abstract class Filter implements IParams {
        public final String property;

        public Filter(String str) {
            this.property = str;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Query$GeoFilter.class */
    public static class GeoFilter extends Filter {
        public static final String KILOMETERS = "km";
        public static final String METERS = "m";
        public static final String FEET = "ft";
        public static final String MILES = "mi";
        private final double lon;
        private final double lat;
        private final double radius;
        private final String unit;

        public GeoFilter(String str, double d, double d2, double d3, String str2) {
            super(str);
            this.lon = d;
            this.lat = d2;
            this.radius = d3;
            this.unit = str2;
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public void addParams(CommandArguments commandArguments) {
            commandArguments.add(SearchProtocol.SearchKeyword.GEOFILTER.getRaw());
            commandArguments.add(SafeEncoder.encode(this.property));
            commandArguments.add(Protocol.toByteArray(this.lon));
            commandArguments.add(Protocol.toByteArray(this.lat));
            commandArguments.add(Protocol.toByteArray(this.radius));
            commandArguments.add(SafeEncoder.encode(this.unit));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Query$HighlightTags.class */
    public static class HighlightTags {
        private final String open;
        private final String close;

        public HighlightTags(String str, String str2) {
            this.open = str;
            this.close = str2;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Query$NumericFilter.class */
    public static class NumericFilter extends Filter {
        private final double min;
        private final boolean exclusiveMin;
        private final double max;
        private final boolean exclusiveMax;

        public NumericFilter(String str, double d, boolean z, double d2, boolean z2) {
            super(str);
            this.min = d;
            this.max = d2;
            this.exclusiveMax = z2;
            this.exclusiveMin = z;
        }

        public NumericFilter(String str, double d, double d2) {
            this(str, d, false, d2, false);
        }

        private byte[] formatNum(double d, boolean z) {
            return z ? SafeEncoder.encode("(" + d) : Protocol.toByteArray(d);
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public void addParams(CommandArguments commandArguments) {
            commandArguments.add(SearchProtocol.SearchKeyword.FILTER.getRaw());
            commandArguments.add(SafeEncoder.encode(this.property));
            commandArguments.add(formatNum(this.min, this.exclusiveMin));
            commandArguments.add(formatNum(this.max, this.exclusiveMax));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/Query$Paging.class */
    public static class Paging {
        int offset;
        int num;

        public Paging(int i, int i2) {
            this.offset = i;
            this.num = i2;
        }
    }

    public Query() {
        this(Marker.ANY_MARKER);
    }

    public Query(String str) {
        this._filters = new LinkedList();
        this._paging = new Paging(0, 10);
        this._verbatim = false;
        this._noContent = false;
        this._noStopwords = false;
        this._withScores = false;
        this._withPayloads = false;
        this._language = null;
        this._fields = null;
        this._keys = null;
        this._returnFields = null;
        this.returnFieldNames = null;
        this.highlightFields = null;
        this.summarizeFields = null;
        this.highlightTags = null;
        this.summarizeSeparator = null;
        this.summarizeNumFragments = -1;
        this.summarizeFragmentLen = -1;
        this._payload = null;
        this._sortBy = null;
        this._sortAsc = true;
        this.wantsHighlight = false;
        this.wantsSummarize = false;
        this._scorer = null;
        this._params = null;
        this._dialect = 0;
        this._slop = -1;
        this._timeout = -1L;
        this._inOrder = false;
        this._expander = null;
        this._queryString = str;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.add(SafeEncoder.encode(this._queryString));
        if (this._verbatim) {
            commandArguments.add(SearchProtocol.SearchKeyword.VERBATIM.getRaw());
        }
        if (this._noContent) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOCONTENT.getRaw());
        }
        if (this._noStopwords) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOSTOPWORDS.getRaw());
        }
        if (this._withScores) {
            commandArguments.add(SearchProtocol.SearchKeyword.WITHSCORES.getRaw());
        }
        if (this._withPayloads) {
            commandArguments.add(SearchProtocol.SearchKeyword.WITHPAYLOADS.getRaw());
        }
        if (this._language != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LANGUAGE.getRaw());
            commandArguments.add(SafeEncoder.encode(this._language));
        }
        if (this._scorer != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SCORER.getRaw());
            commandArguments.add(SafeEncoder.encode(this._scorer));
        }
        if (this._fields != null && this._fields.length > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.INFIELDS.getRaw());
            commandArguments.add(Protocol.toByteArray(this._fields.length));
            for (String str : this._fields) {
                commandArguments.add(SafeEncoder.encode(str));
            }
        }
        if (this._sortBy != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTBY.getRaw());
            commandArguments.add(SafeEncoder.encode(this._sortBy));
            commandArguments.add((this._sortAsc ? SearchProtocol.SearchKeyword.ASC : SearchProtocol.SearchKeyword.DESC).getRaw());
        }
        if (this._payload != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.PAYLOAD.getRaw());
            commandArguments.add(this._payload);
        }
        if (this._paging.offset != 0 || this._paging.num != 10) {
            commandArguments.add(SearchProtocol.SearchKeyword.LIMIT.getRaw()).add(Protocol.toByteArray(this._paging.offset)).add(Protocol.toByteArray(this._paging.num));
        }
        if (!this._filters.isEmpty()) {
            this._filters.forEach(filter -> {
                filter.addParams(commandArguments);
            });
        }
        if (this.wantsHighlight) {
            commandArguments.add(SearchProtocol.SearchKeyword.HIGHLIGHT.getRaw());
            if (this.highlightFields != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.FIELDS.getRaw());
                commandArguments.add(Protocol.toByteArray(this.highlightFields.length));
                for (String str2 : this.highlightFields) {
                    commandArguments.add(SafeEncoder.encode(str2));
                }
            }
            if (this.highlightTags != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.TAGS.getRaw());
                for (String str3 : this.highlightTags) {
                    commandArguments.add(SafeEncoder.encode(str3));
                }
            }
        }
        if (this.wantsSummarize) {
            commandArguments.add(SearchProtocol.SearchKeyword.SUMMARIZE.getRaw());
            if (this.summarizeFields != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.FIELDS.getRaw());
                commandArguments.add(Protocol.toByteArray(this.summarizeFields.length));
                for (String str4 : this.summarizeFields) {
                    commandArguments.add(SafeEncoder.encode(str4));
                }
            }
            if (this.summarizeNumFragments != -1) {
                commandArguments.add(SearchProtocol.SearchKeyword.FRAGS.getRaw());
                commandArguments.add(Protocol.toByteArray(this.summarizeNumFragments));
            }
            if (this.summarizeFragmentLen != -1) {
                commandArguments.add(SearchProtocol.SearchKeyword.LEN.getRaw());
                commandArguments.add(Protocol.toByteArray(this.summarizeFragmentLen));
            }
            if (this.summarizeSeparator != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.SEPARATOR.getRaw());
                commandArguments.add(SafeEncoder.encode(this.summarizeSeparator));
            }
        }
        if (this._keys != null && this._keys.length > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.INKEYS.getRaw());
            commandArguments.add(Protocol.toByteArray(this._keys.length));
            for (String str5 : this._keys) {
                commandArguments.add(SafeEncoder.encode(str5));
            }
        }
        if (this._returnFields != null && this._returnFields.length > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.RETURN.getRaw());
            commandArguments.add(Protocol.toByteArray(this._returnFields.length));
            for (String str6 : this._returnFields) {
                commandArguments.add(SafeEncoder.encode(str6));
            }
        } else if (this.returnFieldNames != null && this.returnFieldNames.length > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.RETURN.getRaw());
            LazyRawable lazyRawable = new LazyRawable();
            commandArguments.add(lazyRawable);
            int iAddCommandArguments = 0;
            for (FieldName fieldName : this.returnFieldNames) {
                iAddCommandArguments += fieldName.addCommandArguments(commandArguments);
            }
            lazyRawable.setRaw(Protocol.toByteArray(iAddCommandArguments));
        }
        if (this._params != null && this._params.size() > 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.PARAMS.getRaw());
            commandArguments.add(Integer.valueOf(this._params.size() * 2));
            for (Map.Entry<String, Object> entry : this._params.entrySet()) {
                commandArguments.add(entry.getKey());
                commandArguments.add(entry.getValue());
            }
        }
        if (this._dialect != 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.DIALECT.getRaw());
            commandArguments.add(Integer.valueOf(this._dialect));
        }
        if (this._slop >= 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.SLOP.getRaw());
            commandArguments.add(Integer.valueOf(this._slop));
        }
        if (this._timeout >= 0) {
            commandArguments.add(SearchProtocol.SearchKeyword.TIMEOUT.getRaw());
            commandArguments.add(Long.valueOf(this._timeout));
        }
        if (this._inOrder) {
            commandArguments.add(SearchProtocol.SearchKeyword.INORDER.getRaw());
        }
        if (this._expander != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.EXPANDER.getRaw());
            commandArguments.add(SafeEncoder.encode(this._expander));
        }
    }

    public Query limit(Integer num, Integer num2) {
        this._paging.offset = num.intValue();
        this._paging.num = num2.intValue();
        return this;
    }

    public Query addFilter(Filter filter) {
        this._filters.add(filter);
        return this;
    }

    @Deprecated
    public Query setPayload(byte[] bArr) {
        this._payload = bArr;
        return this;
    }

    public Query setVerbatim() {
        this._verbatim = true;
        return this;
    }

    public boolean getNoContent() {
        return this._noContent;
    }

    public Query setNoContent() {
        this._noContent = true;
        return this;
    }

    public Query setNoStopwords() {
        this._noStopwords = true;
        return this;
    }

    public boolean getWithScores() {
        return this._withScores;
    }

    public Query setWithScores() {
        this._withScores = true;
        return this;
    }

    public boolean getWithPayloads() {
        return this._withPayloads;
    }

    @Deprecated
    public Query setWithPayload() {
        this._withPayloads = true;
        return this;
    }

    public Query setLanguage(String str) {
        this._language = str;
        return this;
    }

    public Query setScorer(String str) {
        this._scorer = str;
        return this;
    }

    public Query limitFields(String... strArr) {
        this._fields = strArr;
        return this;
    }

    public Query limitKeys(String... strArr) {
        this._keys = strArr;
        return this;
    }

    public Query returnFields(String... strArr) {
        this._returnFields = strArr;
        this.returnFieldNames = null;
        return this;
    }

    public Query returnFields(FieldName... fieldNameArr) {
        this.returnFieldNames = fieldNameArr;
        this._returnFields = null;
        return this;
    }

    public Query highlightFields(HighlightTags highlightTags, String... strArr) {
        if (strArr == null || strArr.length > 0) {
            this.highlightFields = strArr;
        }
        if (highlightTags != null) {
            this.highlightTags = new String[]{highlightTags.open, highlightTags.close};
        } else {
            this.highlightTags = null;
        }
        this.wantsHighlight = true;
        return this;
    }

    public Query highlightFields(String... strArr) {
        return highlightFields(null, strArr);
    }

    public Query summarizeFields(int i, int i2, String str, String... strArr) {
        if (strArr == null || strArr.length > 0) {
            this.summarizeFields = strArr;
        }
        this.summarizeFragmentLen = i;
        this.summarizeNumFragments = i2;
        this.summarizeSeparator = str;
        this.wantsSummarize = true;
        return this;
    }

    public Query summarizeFields(String... strArr) {
        return summarizeFields(-1, -1, null, strArr);
    }

    public Query setSortBy(String str, boolean z) {
        this._sortBy = str;
        this._sortAsc = z;
        return this;
    }

    public Query addParam(String str, Object obj) {
        if (this._params == null) {
            this._params = new HashMap();
        }
        this._params.put(str, obj);
        return this;
    }

    public Query dialect(int i) {
        this._dialect = i;
        return this;
    }

    public Query slop(int i) {
        this._slop = i;
        return this;
    }

    public Query timeout(long j) {
        this._timeout = j;
        return this;
    }

    public Query setInOrder() {
        this._inOrder = true;
        return this;
    }

    public Query setExpander(String str) {
        this._expander = str;
        return this;
    }
}
