package me.module.multiserver.library.redis.jedis.search;

import java.util.ArrayList;
import java.util.List;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/SearchResult.class */
public class SearchResult {
    private final long totalResults;
    private final List<Document> documents;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/SearchResult$SearchResultBuilder.class */
    public static class SearchResultBuilder extends Builder<SearchResult> {
        private final boolean hasContent;
        private final boolean hasScores;
        private final boolean hasPayloads;
        private final boolean decode;

        public SearchResultBuilder(boolean z, boolean z2, boolean z3, boolean z4) {
            this.hasContent = z;
            this.hasScores = z2;
            this.hasPayloads = z3;
            this.decode = z4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public SearchResult build(Object obj) {
            List list = (List) obj;
            int i = 1;
            int i2 = 0;
            int i3 = 1;
            int i4 = 0;
            if (this.hasScores) {
                i = 1 + 1;
                i2 = 1;
                i3 = 1 + 1;
            }
            if (this.hasContent) {
                i++;
                if (this.hasPayloads) {
                    i4 = i2 + 1;
                    i++;
                    i3++;
                }
            }
            long jLongValue = ((Long) list.get(0)).longValue();
            ArrayList arrayList = new ArrayList(list.size() - 1);
            int i5 = 1;
            while (true) {
                int i6 = i5;
                if (i6 >= list.size()) {
                    return new SearchResult(jLongValue, arrayList);
                }
                arrayList.add(Document.load(BuilderFactory.STRING.build(list.get(i6)), this.hasScores ? BuilderFactory.DOUBLE.build(list.get(i6 + i2)).doubleValue() : 1.0d, this.hasPayloads ? (byte[]) list.get(i6 + i4) : null, this.hasContent ? (List) list.get(i6 + i3) : null, this.decode));
                i5 = i6 + i;
            }
        }
    }

    private SearchResult(long j, List<Document> list) {
        this.totalResults = j;
        this.documents = list;
    }

    public long getTotalResults() {
        return this.totalResults;
    }

    public List<Document> getDocuments() {
        return this.documents;
    }
}
