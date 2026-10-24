package me.module.multiserver.library.redis.jedis.resps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import me.module.multiserver.library.redis.jedis.Builder;
import me.module.multiserver.library.redis.jedis.BuilderFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/LibraryInfo.class */
public class LibraryInfo {
    private final String libraryName;
    private final String engine;
    private final List<Map<String, Object>> functions;
    private final String libraryCode;
    public static final Builder<LibraryInfo> LIBRARY_BUILDER = new Builder<LibraryInfo>() { // from class: me.module.multiserver.library.redis.jedis.resps.LibraryInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.module.multiserver.library.redis.jedis.Builder
        public LibraryInfo build(Object obj) {
            List list = (List) obj;
            String strBuild = BuilderFactory.STRING.build(list.get(1));
            String strBuild2 = BuilderFactory.STRING.build(list.get(3));
            List list2 = (List) ((List) list.get(5)).stream().map(obj2 -> {
                return BuilderFactory.ENCODED_OBJECT_MAP.build(obj2);
            }).collect(Collectors.toList());
            return list.size() <= 6 ? new LibraryInfo(strBuild, strBuild2, list2) : new LibraryInfo(strBuild, strBuild2, list2, BuilderFactory.STRING.build(list.get(7)));
        }
    };

    public LibraryInfo(String str, String str2, List<Map<String, Object>> list) {
        this(str, str2, list, null);
    }

    public LibraryInfo(String str, String str2, List<Map<String, Object>> list, String str3) {
        this.libraryName = str;
        this.engine = str2;
        this.functions = list;
        this.libraryCode = str3;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getEngine() {
        return this.engine;
    }

    public List<Map<String, Object>> getFunctions() {
        return this.functions;
    }

    public String getLibraryCode() {
        return this.libraryCode;
    }
}
