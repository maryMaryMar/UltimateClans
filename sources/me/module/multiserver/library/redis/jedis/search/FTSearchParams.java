package me.module.multiserver.library.redis.jedis.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;
import me.module.multiserver.library.redis.jedis.args.SortingOrder;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FTSearchParams.class */
public class FTSearchParams implements IParams {
    private boolean noContent = false;
    private boolean verbatim = false;
    private boolean noStopwords = false;
    private boolean withScores = false;
    private final List<IParams> filters = new LinkedList();
    private Collection<String> inKeys;
    private Collection<String> inFields;
    private Collection<String> returnFields;
    private Collection<FieldName> returnFieldNames;
    private boolean summarize;
    private SummarizeParams summarizeParams;
    private boolean highlight;
    private HighlightParams highlightParams;
    private Integer slop;
    private Long timeout;
    private boolean inOrder;
    private String language;
    private String expander;
    private String scorer;
    private String sortBy;
    private SortingOrder sortOrder;
    private int[] limit;
    private Map<String, Object> params;
    private Integer dialect;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FTSearchParams$GeoFilter.class */
    public static class GeoFilter implements IParams {
        private final String field;
        private final double lon;
        private final double lat;
        private final double radius;
        private final GeoUnit unit;

        public GeoFilter(String str, double d, double d2, double d3, GeoUnit geoUnit) {
            this.field = str;
            this.lon = d;
            this.lat = d2;
            this.radius = d3;
            this.unit = geoUnit;
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public void addParams(CommandArguments commandArguments) {
            commandArguments.add(SearchProtocol.SearchKeyword.GEOFILTER).add(this.field).add(Double.valueOf(this.lon)).add(Double.valueOf(this.lat)).add(Double.valueOf(this.radius)).add(this.unit);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FTSearchParams$HighlightParams.class */
    public static class HighlightParams implements IParams {
        private Collection<String> fields;
        private String[] tags;

        public HighlightParams fields(String str) {
            return fields(Arrays.asList(str));
        }

        public HighlightParams fields(Collection<String> collection) {
            this.fields = collection;
            return this;
        }

        public HighlightParams tags(String str, String str2) {
            this.tags = new String[]{str, str2};
            return this;
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public void addParams(CommandArguments commandArguments) {
            commandArguments.add(SearchProtocol.SearchKeyword.HIGHLIGHT);
            if (this.fields != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.FIELDS).add(Integer.valueOf(this.fields.size())).addObjects(this.fields);
            }
            if (this.tags != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.TAGS).add(this.tags[0]).add(this.tags[1]);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FTSearchParams$NumericFilter.class */
    public static class NumericFilter implements IParams {
        private final String field;
        private final double min;
        private final boolean exclusiveMin;
        private final double max;
        private final boolean exclusiveMax;

        public NumericFilter(String str, double d, double d2) {
            this(str, d, false, d2, false);
        }

        public NumericFilter(String str, double d, boolean z, double d2, boolean z2) {
            this.field = str;
            this.min = d;
            this.max = d2;
            this.exclusiveMax = z2;
            this.exclusiveMin = z;
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public void addParams(CommandArguments commandArguments) {
            commandArguments.add(SearchProtocol.SearchKeyword.FILTER).add(this.field).add(formatNum(this.min, this.exclusiveMin)).add(formatNum(this.max, this.exclusiveMax));
        }

        private Object formatNum(double d, boolean z) {
            return z ? "(" + d : Protocol.toByteArray(d);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/FTSearchParams$SummarizeParams.class */
    public static class SummarizeParams implements IParams {
        private Collection<String> fields;
        private Integer fragsNum;
        private Integer fragSize;
        private String separator;

        public SummarizeParams fields(String... strArr) {
            return fields(Arrays.asList(strArr));
        }

        public SummarizeParams fields(Collection<String> collection) {
            this.fields = collection;
            return this;
        }

        public SummarizeParams fragsNum(int i) {
            this.fragsNum = Integer.valueOf(i);
            return this;
        }

        public SummarizeParams fragSize(int i) {
            this.fragSize = Integer.valueOf(i);
            return this;
        }

        public SummarizeParams separator(String str) {
            this.separator = str;
            return this;
        }

        @Override // me.module.multiserver.library.redis.jedis.params.IParams
        public void addParams(CommandArguments commandArguments) {
            commandArguments.add(SearchProtocol.SearchKeyword.SUMMARIZE);
            if (this.fields != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.FIELDS).add(Integer.valueOf(this.fields.size())).addObjects(this.fields);
            }
            if (this.fragsNum != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.FRAGS).add(this.fragsNum);
            }
            if (this.fragSize != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.LEN).add(this.fragSize);
            }
            if (this.separator != null) {
                commandArguments.add(SearchProtocol.SearchKeyword.SEPARATOR).add(this.separator);
            }
        }
    }

    public static FTSearchParams searchParams() {
        return new FTSearchParams();
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.noContent) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOCONTENT);
        }
        if (this.verbatim) {
            commandArguments.add(SearchProtocol.SearchKeyword.VERBATIM);
        }
        if (this.noStopwords) {
            commandArguments.add(SearchProtocol.SearchKeyword.NOSTOPWORDS);
        }
        if (this.withScores) {
            commandArguments.add(SearchProtocol.SearchKeyword.WITHSCORES);
        }
        if (!this.filters.isEmpty()) {
            this.filters.forEach(iParams -> {
                iParams.addParams(commandArguments);
            });
        }
        if (this.inKeys != null && !this.inKeys.isEmpty()) {
            commandArguments.add(SearchProtocol.SearchKeyword.INKEYS).add(Integer.valueOf(this.inKeys.size())).addObjects(this.inKeys);
        }
        if (this.inFields != null && !this.inFields.isEmpty()) {
            commandArguments.add(SearchProtocol.SearchKeyword.INFIELDS).add(Integer.valueOf(this.inFields.size())).addObjects(this.inFields);
        }
        if (this.returnFieldNames != null && !this.returnFieldNames.isEmpty()) {
            commandArguments.add(SearchProtocol.SearchKeyword.RETURN);
            LazyRawable lazyRawable = new LazyRawable();
            commandArguments.add(lazyRawable);
            int iAddCommandArguments = 0;
            Iterator<FieldName> it = this.returnFieldNames.iterator();
            while (it.hasNext()) {
                iAddCommandArguments += it.next().addCommandArguments(commandArguments);
            }
            lazyRawable.setRaw(Protocol.toByteArray(iAddCommandArguments));
        } else if (this.returnFields != null && !this.returnFields.isEmpty()) {
            commandArguments.add(SearchProtocol.SearchKeyword.RETURN).add(Integer.valueOf(this.returnFields.size())).addObjects(this.returnFields);
        }
        if (this.summarizeParams != null) {
            commandArguments.addParams(this.summarizeParams);
        } else if (this.summarize) {
            commandArguments.add(SearchProtocol.SearchKeyword.SUMMARIZE);
        }
        if (this.highlightParams != null) {
            commandArguments.addParams(this.highlightParams);
        } else if (this.highlight) {
            commandArguments.add(SearchProtocol.SearchKeyword.HIGHLIGHT);
        }
        if (this.slop != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SLOP).add(this.slop);
        }
        if (this.timeout != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.TIMEOUT).add(this.timeout);
        }
        if (this.inOrder) {
            commandArguments.add(SearchProtocol.SearchKeyword.INORDER);
        }
        if (this.language != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LANGUAGE).add(this.language);
        }
        if (this.expander != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.EXPANDER).add(this.expander);
        }
        if (this.scorer != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SCORER).add(this.scorer);
        }
        if (this.sortBy != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.SORTBY).add(this.sortBy);
            if (this.sortOrder != null) {
                commandArguments.add(this.sortOrder);
            }
        }
        if (this.limit != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.LIMIT).add(Integer.valueOf(this.limit[0])).add(Integer.valueOf(this.limit[1]));
        }
        if (this.params != null && !this.params.isEmpty()) {
            commandArguments.add(SearchProtocol.SearchKeyword.PARAMS).add(Integer.valueOf(this.params.size() * 2));
            this.params.entrySet().forEach(entry -> {
                commandArguments.add(entry.getKey()).add(entry.getValue());
            });
        }
        if (this.dialect != null) {
            commandArguments.add(SearchProtocol.SearchKeyword.DIALECT).add(this.dialect);
        }
    }

    public FTSearchParams noContent() {
        this.noContent = true;
        return this;
    }

    public FTSearchParams verbatim() {
        this.verbatim = true;
        return this;
    }

    public FTSearchParams noStopwords() {
        this.noStopwords = true;
        return this;
    }

    public FTSearchParams withScores() {
        this.withScores = true;
        return this;
    }

    public FTSearchParams filter(String str, double d, double d2) {
        return filter(new NumericFilter(str, d, d2));
    }

    public FTSearchParams filter(String str, double d, boolean z, double d2, boolean z2) {
        return filter(new NumericFilter(str, d, z, d2, z2));
    }

    public FTSearchParams filter(NumericFilter numericFilter) {
        this.filters.add(numericFilter);
        return this;
    }

    public FTSearchParams geoFilter(String str, double d, double d2, double d3, GeoUnit geoUnit) {
        return geoFilter(new GeoFilter(str, d, d2, d3, geoUnit));
    }

    public FTSearchParams geoFilter(GeoFilter geoFilter) {
        this.filters.add(geoFilter);
        return this;
    }

    public FTSearchParams inKeys(String... strArr) {
        return inKeys(Arrays.asList(strArr));
    }

    public FTSearchParams inKeys(Collection<String> collection) {
        this.inKeys = collection;
        return this;
    }

    public FTSearchParams inFields(String... strArr) {
        return inFields(Arrays.asList(strArr));
    }

    public FTSearchParams inFields(Collection<String> collection) {
        if (this.inFields == null) {
            this.inFields = new ArrayList(collection);
        } else {
            this.inFields.addAll(collection);
        }
        return this;
    }

    public FTSearchParams returnFields(String... strArr) {
        if (this.returnFieldNames != null) {
            Arrays.stream(strArr).forEach(str -> {
                this.returnFieldNames.add(FieldName.of(str));
            });
        } else {
            if (this.returnFields == null) {
                this.returnFields = new ArrayList();
            }
            Arrays.stream(strArr).forEach(str2 -> {
                this.returnFields.add(str2);
            });
        }
        return this;
    }

    public FTSearchParams returnField(FieldName fieldName) {
        initReturnFieldNames();
        this.returnFieldNames.add(fieldName);
        return this;
    }

    public FTSearchParams returnFields(FieldName... fieldNameArr) {
        return returnFields(Arrays.asList(fieldNameArr));
    }

    public FTSearchParams returnFields(Collection<FieldName> collection) {
        initReturnFieldNames();
        this.returnFieldNames.addAll(collection);
        return this;
    }

    private void initReturnFieldNames() {
        if (this.returnFieldNames == null) {
            this.returnFieldNames = new ArrayList();
        }
        if (this.returnFields != null) {
            this.returnFields.forEach(str -> {
                this.returnFieldNames.add(FieldName.of(str));
            });
            this.returnFields = null;
        }
    }

    public FTSearchParams summarize() {
        this.summarize = true;
        return this;
    }

    public FTSearchParams summarize(SummarizeParams summarizeParams) {
        this.summarizeParams = summarizeParams;
        return this;
    }

    public FTSearchParams highlight() {
        this.highlight = true;
        return this;
    }

    public FTSearchParams highlight(HighlightParams highlightParams) {
        this.highlightParams = highlightParams;
        return this;
    }

    public FTSearchParams scorer(String str) {
        this.scorer = str;
        return this;
    }

    public FTSearchParams slop(int i) {
        this.slop = Integer.valueOf(i);
        return this;
    }

    public FTSearchParams timeout(long j) {
        this.timeout = Long.valueOf(j);
        return this;
    }

    public FTSearchParams inOrder() {
        this.inOrder = true;
        return this;
    }

    public FTSearchParams language(String str) {
        this.language = str;
        return this;
    }

    public FTSearchParams sortBy(String str, SortingOrder sortingOrder) {
        this.sortBy = str;
        this.sortOrder = sortingOrder;
        return this;
    }

    public FTSearchParams limit(int i, int i2) {
        this.limit = new int[]{i, i2};
        return this;
    }

    public FTSearchParams addParam(String str, Object obj) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(str, obj);
        return this;
    }

    public FTSearchParams params(Map<String, Object> map) {
        if (this.params == null) {
            this.params = new HashMap(map);
        } else {
            this.params.putAll(this.params);
        }
        return this;
    }

    public FTSearchParams dialect(int i) {
        this.dialect = Integer.valueOf(i);
        return this;
    }

    public boolean getNoContent() {
        return this.noContent;
    }

    public boolean getWithScores() {
        return this.withScores;
    }

    public static SummarizeParams summarizeParams() {
        return new SummarizeParams();
    }

    public static HighlightParams highlightParams() {
        return new HighlightParams();
    }
}
