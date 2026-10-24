package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/Reducers.class */
public class Reducers {
    public static Reducer count() {
        return new Reducer() { // from class: me.module.multiserver.library.redis.jedis.search.aggr.Reducers.1
            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            public String getName() {
                return "COUNT";
            }
        };
    }

    private static Reducer singleFieldReducer(final String str, String str2) {
        return new Reducer(str2) { // from class: me.module.multiserver.library.redis.jedis.search.aggr.Reducers.2
            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            public String getName() {
                return str;
            }
        };
    }

    public static Reducer count_distinct(String str) {
        return singleFieldReducer("COUNT_DISTINCT", str);
    }

    public static Reducer count_distinctish(String str) {
        return singleFieldReducer("COUNT_DISTINCTISH", str);
    }

    public static Reducer sum(String str) {
        return singleFieldReducer("SUM", str);
    }

    public static Reducer min(String str) {
        return singleFieldReducer("MIN", str);
    }

    public static Reducer max(String str) {
        return singleFieldReducer("MAX", str);
    }

    public static Reducer avg(String str) {
        return singleFieldReducer("AVG", str);
    }

    public static Reducer stddev(String str) {
        return singleFieldReducer("STDDEV", str);
    }

    public static Reducer quantile(String str, final double d) {
        return new Reducer(str) { // from class: me.module.multiserver.library.redis.jedis.search.aggr.Reducers.3
            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            public String getName() {
                return "QUANTILE";
            }

            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            protected List<String> getOwnArgs() {
                List<String> ownArgs = super.getOwnArgs();
                ownArgs.add(Double.toString(d));
                return ownArgs;
            }
        };
    }

    public static Reducer first_value(String str, final SortedField sortedField) {
        return new Reducer(str) { // from class: me.module.multiserver.library.redis.jedis.search.aggr.Reducers.4
            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            public String getName() {
                return "FIRST_VALUE";
            }

            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            protected List<String> getOwnArgs() {
                List<String> ownArgs = super.getOwnArgs();
                if (sortedField != null) {
                    ownArgs.add("BY");
                    ownArgs.add(sortedField.getField());
                    ownArgs.add(sortedField.getOrder());
                }
                return ownArgs;
            }
        };
    }

    public static Reducer first_value(String str) {
        return first_value(str, null);
    }

    public static Reducer to_list(String str) {
        return singleFieldReducer("TOLIST", str);
    }

    public static Reducer random_sample(String str, final int i) {
        return new Reducer(str) { // from class: me.module.multiserver.library.redis.jedis.search.aggr.Reducers.5
            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            public String getName() {
                return "RANDOM_SAMPLE";
            }

            @Override // me.module.multiserver.library.redis.jedis.search.aggr.Reducer
            protected List<String> getOwnArgs() {
                List<String> ownArgs = super.getOwnArgs();
                ownArgs.add(Integer.toString(i));
                return ownArgs;
            }
        };
    }
}
