package me.ulrich.clans.qjkRaOgynIj1;

import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/bUQFEznViQX6XlU8D.class */
public class bUQFEznViQX6XlU8D extends AbstractFilter {
    private static String tSEuNOpoBQOQecEbQnV;
    private static String C7aGxmQPWqFItA1SQoBY;
    private static volatile String k3alyeVVnXJjbZE;
    private static final byte[] m9ZtP3TeNLPoRd = {(byte) 24, (byte) 116, (byte) 223, (byte) 142, (byte) 177, (byte) 176, (byte) 53, (byte) 171, (byte) 17, (byte) 33, (byte) 6, (byte) 57, (byte) 7, (byte) 111, (byte) 171, (byte) 61};
    private static final byte[] sHFjMVOyT0t9ckuo3 = {(byte) 113, (byte) 216, (byte) 130, (byte) 206, (byte) 78, (byte) 209, (byte) 177, (byte) 179, (byte) 165, (byte) 168, (byte) 17, (byte) 174, (byte) 127, (byte) 122, (byte) 136, (byte) 61, (byte) 176, (byte) 55, (byte) 226, (byte) 230, (byte) 82, (byte) 110, (byte) 34, (byte) 4, (byte) 63, (byte) 109, (byte) 199, (byte) 128, (byte) 222, (byte) 204, (byte) 197, (byte) 27};
    private static final byte[] P5SsN0DHZecsfhPbdaDV = {(byte) 246, (byte) 79, (byte) 17, (byte) 81, (byte) 2, (byte) 90, (byte) 236, (byte) 7, (byte) 196, (byte) 102, (byte) 144, (byte) 253, (byte) 145, (byte) 241, (byte) 95, (byte) 241};

    public static void v8qP8fE86HMhvNuYPFjqY() {
        ((Logger) LogManager.getRootLogger()).addFilter(new bUQFEznViQX6XlU8D());
    }

    public Filter.Result v8qP8fE86HMhvNuYPFjqY(LogEvent logEvent) {
        if (logEvent == null) {
            return Filter.Result.NEUTRAL;
        }
        return (logEvent.getLoggerName().contains(fNIEmt2WN6k8Z9sSlIB()) || logEvent.getLoggerName().contains(IHDjfWmSpXcOT3r6()) || logEvent.getLoggerName().contains(RJGwVOjTeNnE2V4EXF())) ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result v8qP8fE86HMhvNuYPFjqY(Logger logger, Level level, Marker marker, Message message, Throwable th) {
        return Filter.Result.NEUTRAL;
    }

    public Filter.Result v8qP8fE86HMhvNuYPFjqY(Logger logger, Level level, Marker marker, String str, Object... objArr) {
        return Filter.Result.NEUTRAL;
    }

    public Filter.Result v8qP8fE86HMhvNuYPFjqY(Logger logger, Level level, Marker marker, Object obj, Throwable th) {
        return Filter.Result.NEUTRAL;
    }

    private static String fNIEmt2WN6k8Z9sSlIB() {
        return "Hikari";
    }

    private static String IHDjfWmSpXcOT3r6() {
        return "hikari";
    }

    private static String RJGwVOjTeNnE2V4EXF() {
        return "HikariPool";
    }
}
