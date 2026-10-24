package me.module.multiserver.library.redis.jedis.resps;

import java.util.ArrayList;
import java.util.List;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/CommandDocument.class */
public class CommandDocument {
    private final String summary;
    private final String since;
    private final String group;
    private final String complexity;
    private final List<String> history;
    public static final Builder<CommandDocument> COMMAND_DOCUMENT_BUILDER = new Builder<CommandDocument>() { // from class: me.module.multiserver.library.redis.jedis.resps.CommandDocument.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public CommandDocument build(Object obj) {
            List list = (List) obj;
            String strBuild = BuilderFactory.STRING.build(list.get(1));
            String strBuild2 = BuilderFactory.STRING.build(list.get(3));
            String strBuild3 = BuilderFactory.STRING.build(list.get(5));
            String strBuild4 = BuilderFactory.STRING.build(list.get(7));
            ArrayList arrayList = null;
            if (BuilderFactory.STRING.build(list.get(8)).equals("history")) {
                List<List> list2 = (List) list.get(9);
                arrayList = new ArrayList(list2.size());
                for (List list3 : list2) {
                    arrayList.add(BuilderFactory.STRING.build(list3.get(0)) + ": " + BuilderFactory.STRING.build(list3.get(1)));
                }
            }
            return new CommandDocument(strBuild, strBuild2, strBuild3, strBuild4, arrayList);
        }
    };

    public CommandDocument(String str, String str2, String str3, String str4, List<String> list) {
        this.summary = str;
        this.since = str2;
        this.group = str3;
        this.complexity = str4;
        this.history = list;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getSince() {
        return this.since;
    }

    public String getGroup() {
        return this.group;
    }

    public String getComplexity() {
        return this.complexity;
    }

    public List<String> getHistory() {
        return this.history;
    }
}
