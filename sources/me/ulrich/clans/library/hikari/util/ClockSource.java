package me.ulrich.clans.library.hikari.util;

import java.util.concurrent.TimeUnit;
import me.module.multiserver.library.redis.jedis.search.Query;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ClockSource.class */
public interface ClockSource {
    public static final ClockSource CLOCK = Factory.create();
    public static final TimeUnit[] TIMEUNITS_DESCENDING = {TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS, TimeUnit.MILLISECONDS, TimeUnit.MICROSECONDS, TimeUnit.NANOSECONDS};
    public static final String[] TIMEUNIT_DISPLAY_VALUES = {"ns", "µs", "ms", "s", Query.GeoFilter.METERS, "h", "d"};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ClockSource$Factory.class */
    public static class Factory {
        private static ClockSource create() {
            return "Mac OS X".equals(System.getProperty("os.name")) ? new MillisecondClockSource() : new NanosecondClockSource();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ClockSource$MillisecondClockSource.class */
    public static final class MillisecondClockSource implements ClockSource {
        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long currentTime0() {
            return System.currentTimeMillis();
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedMillis0(long j) {
            return System.currentTimeMillis() - j;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedMillis0(long j, long j2) {
            return j2 - j;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedNanos0(long j) {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis() - j);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedNanos0(long j, long j2) {
            return TimeUnit.MILLISECONDS.toNanos(j2 - j);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long toMillis0(long j) {
            return j;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long toNanos0(long j) {
            return TimeUnit.MILLISECONDS.toNanos(j);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long plusMillis0(long j, long j2) {
            return j + j2;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public TimeUnit getSourceTimeUnit0() {
            return TimeUnit.MILLISECONDS;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/ClockSource$NanosecondClockSource.class */
    public static class NanosecondClockSource implements ClockSource {
        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long currentTime0() {
            return System.nanoTime();
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long toMillis0(long j) {
            return TimeUnit.NANOSECONDS.toMillis(j);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long toNanos0(long j) {
            return j;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedMillis0(long j) {
            return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedMillis0(long j, long j2) {
            return TimeUnit.NANOSECONDS.toMillis(j2 - j);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedNanos0(long j) {
            return System.nanoTime() - j;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long elapsedNanos0(long j, long j2) {
            return j2 - j;
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public long plusMillis0(long j, long j2) {
            return j + TimeUnit.MILLISECONDS.toNanos(j2);
        }

        @Override // me.ulrich.clans.library.hikari.util.ClockSource
        public TimeUnit getSourceTimeUnit0() {
            return TimeUnit.NANOSECONDS;
        }
    }

    static long currentTime() {
        return CLOCK.currentTime0();
    }

    long currentTime0();

    static long toMillis(long j) {
        return CLOCK.toMillis0(j);
    }

    long toMillis0(long j);

    static long toNanos(long j) {
        return CLOCK.toNanos0(j);
    }

    long toNanos0(long j);

    static long elapsedMillis(long j) {
        return CLOCK.elapsedMillis0(j);
    }

    long elapsedMillis0(long j);

    static long elapsedMillis(long j, long j2) {
        return CLOCK.elapsedMillis0(j, j2);
    }

    long elapsedMillis0(long j, long j2);

    static long elapsedNanos(long j) {
        return CLOCK.elapsedNanos0(j);
    }

    long elapsedNanos0(long j);

    static long elapsedNanos(long j, long j2) {
        return CLOCK.elapsedNanos0(j, j2);
    }

    long elapsedNanos0(long j, long j2);

    static long plusMillis(long j, long j2) {
        return CLOCK.plusMillis0(j, j2);
    }

    long plusMillis0(long j, long j2);

    static TimeUnit getSourceTimeUnit() {
        return CLOCK.getSourceTimeUnit0();
    }

    TimeUnit getSourceTimeUnit0();

    static String elapsedDisplayString(long j, long j2) {
        return CLOCK.elapsedDisplayString0(j, j2);
    }

    default String elapsedDisplayString0(long j, long j2) {
        long jElapsedNanos0 = elapsedNanos0(j, j2);
        StringBuilder sb = new StringBuilder(jElapsedNanos0 < 0 ? "-" : "");
        long jAbs = Math.abs(jElapsedNanos0);
        for (TimeUnit timeUnit : TIMEUNITS_DESCENDING) {
            long jConvert = timeUnit.convert(jAbs, TimeUnit.NANOSECONDS);
            if (jConvert > 0) {
                sb.append(jConvert).append(TIMEUNIT_DISPLAY_VALUES[timeUnit.ordinal()]);
                jAbs -= TimeUnit.NANOSECONDS.convert(jConvert, timeUnit);
            }
        }
        return sb.toString();
    }
}
