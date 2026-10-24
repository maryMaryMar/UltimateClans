package me.ulrich.clans.library.nbtapi.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/PathUtil.class */
public final class PathUtil {
    private static final Pattern pattern = Pattern.compile("[^\\\\](\\.)");
    private static final Pattern indexPattern = Pattern.compile(".*\\[(-?[0-9]+)\\]");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/PathUtil$PathSegment.class */
    public static class PathSegment {
        private final String path;
        private final Integer index;

        private PathSegment(String str) {
            Matcher matcher = PathUtil.indexPattern.matcher(str);
            if (matcher.find()) {
                this.path = str.substring(0, str.indexOf("["));
                this.index = Integer.valueOf(Integer.parseInt(matcher.group(1)));
            } else {
                this.path = str;
                this.index = null;
            }
        }

        public String getPath() {
            return this.path;
        }

        public int getIndex() {
            return this.index.intValue();
        }

        public boolean hasIndex() {
            return this.index != null;
        }

        public String toString() {
            return "PathSegment [path=" + this.path + ", index=" + this.index + "]";
        }
    }

    public static List<PathSegment> splitPath(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        int iEnd = 0;
        while (true) {
            int i = iEnd;
            if (!matcher.find(i)) {
                arrayList.add(new PathSegment(str.substring(i).replace("\\.", ".")));
                return arrayList;
            }
            arrayList.add(new PathSegment(str.substring(i, matcher.end() - 1).replace("\\.", ".")));
            iEnd = matcher.end();
        }
    }
}
