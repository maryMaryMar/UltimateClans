package me.module.multiserver.library.redis.jedis.resps;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/LCSMatchResult.class */
public class LCSMatchResult {
    private String matchString;
    private List<MatchedPosition> matches;
    private long len;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/LCSMatchResult$MatchedPosition.class */
    public static class MatchedPosition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Position f143a;
        private final Position b;
        private final long matchLen;

        public MatchedPosition(Position position, Position position2, long j) {
            this.f143a = position;
            this.b = position2;
            this.matchLen = j;
        }

        public Position getA() {
            return this.f143a;
        }

        public Position getB() {
            return this.b;
        }

        public long getMatchLen() {
            return this.matchLen;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/LCSMatchResult$Position.class */
    public static class Position {
        private final long start;
        private final long end;

        public Position(long j, long j2) {
            this.start = j;
            this.end = j2;
        }

        public long getStart() {
            return this.start;
        }

        public long getEnd() {
            return this.end;
        }
    }

    public LCSMatchResult(String str) {
        this.matchString = str;
    }

    public LCSMatchResult(long j) {
        this.len = j;
    }

    public LCSMatchResult(List<MatchedPosition> list, long j) {
        this.matches = list;
        this.len = j;
    }

    public LCSMatchResult(String str, List<MatchedPosition> list, long j) {
        this.matchString = str;
        this.matches = Collections.unmodifiableList(list);
        this.len = j;
    }

    public String getMatchString() {
        return this.matchString;
    }

    public List<MatchedPosition> getMatches() {
        return this.matches;
    }

    public long getLen() {
        return this.len;
    }
}
