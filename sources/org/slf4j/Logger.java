package org.slf4j;

import org.slf4j.event.Level;
import org.slf4j.helpers.CheckReturnValue;
import org.slf4j.spi.DefaultLoggingEventBuilder;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.spi.NOPLoggingEventBuilder;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/Logger.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/Logger.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/Logger.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/Logger.class */
public interface Logger {
    public static final String ROOT_LOGGER_NAME = "ROOT";

    String getName();

    default LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return new DefaultLoggingEventBuilder(this, level);
    }

    @CheckReturnValue
    default LoggingEventBuilder atLevel(Level level) {
        return isEnabledForLevel(level) ? makeLoggingEventBuilder(level) : NOPLoggingEventBuilder.singleton();
    }

    default boolean isEnabledForLevel(Level level) {
        switch (level.toInt()) {
            case 0:
                return isTraceEnabled();
            case 10:
                return isDebugEnabled();
            case 20:
                return isInfoEnabled();
            case 30:
                return isWarnEnabled();
            case 40:
                return isErrorEnabled();
            default:
                throw new IllegalArgumentException("Level [" + level + "] not recognized.");
        }
    }

    boolean isTraceEnabled();

    void trace(String str);

    void trace(String str, Object obj);

    void trace(String str, Object obj, Object obj2);

    void trace(String str, Object... objArr);

    void trace(String str, Throwable th);

    boolean isTraceEnabled(Marker marker);

    @CheckReturnValue
    default LoggingEventBuilder atTrace() {
        return isTraceEnabled() ? makeLoggingEventBuilder(Level.TRACE) : NOPLoggingEventBuilder.singleton();
    }

    void trace(Marker marker, String str);

    void trace(Marker marker, String str, Object obj);

    void trace(Marker marker, String str, Object obj, Object obj2);

    void trace(Marker marker, String str, Object... objArr);

    void trace(Marker marker, String str, Throwable th);

    boolean isDebugEnabled();

    void debug(String str);

    void debug(String str, Object obj);

    void debug(String str, Object obj, Object obj2);

    void debug(String str, Object... objArr);

    void debug(String str, Throwable th);

    boolean isDebugEnabled(Marker marker);

    void debug(Marker marker, String str);

    void debug(Marker marker, String str, Object obj);

    void debug(Marker marker, String str, Object obj, Object obj2);

    void debug(Marker marker, String str, Object... objArr);

    void debug(Marker marker, String str, Throwable th);

    @CheckReturnValue
    default LoggingEventBuilder atDebug() {
        return isDebugEnabled() ? makeLoggingEventBuilder(Level.DEBUG) : NOPLoggingEventBuilder.singleton();
    }

    boolean isInfoEnabled();

    void info(String str);

    void info(String str, Object obj);

    void info(String str, Object obj, Object obj2);

    void info(String str, Object... objArr);

    void info(String str, Throwable th);

    boolean isInfoEnabled(Marker marker);

    void info(Marker marker, String str);

    void info(Marker marker, String str, Object obj);

    void info(Marker marker, String str, Object obj, Object obj2);

    void info(Marker marker, String str, Object... objArr);

    void info(Marker marker, String str, Throwable th);

    @CheckReturnValue
    default LoggingEventBuilder atInfo() {
        return isInfoEnabled() ? makeLoggingEventBuilder(Level.INFO) : NOPLoggingEventBuilder.singleton();
    }

    boolean isWarnEnabled();

    void warn(String str);

    void warn(String str, Object obj);

    void warn(String str, Object... objArr);

    void warn(String str, Object obj, Object obj2);

    void warn(String str, Throwable th);

    boolean isWarnEnabled(Marker marker);

    void warn(Marker marker, String str);

    void warn(Marker marker, String str, Object obj);

    void warn(Marker marker, String str, Object obj, Object obj2);

    void warn(Marker marker, String str, Object... objArr);

    void warn(Marker marker, String str, Throwable th);

    @CheckReturnValue
    default LoggingEventBuilder atWarn() {
        return isWarnEnabled() ? makeLoggingEventBuilder(Level.WARN) : NOPLoggingEventBuilder.singleton();
    }

    boolean isErrorEnabled();

    void error(String str);

    void error(String str, Object obj);

    void error(String str, Object obj, Object obj2);

    void error(String str, Object... objArr);

    void error(String str, Throwable th);

    boolean isErrorEnabled(Marker marker);

    void error(Marker marker, String str);

    void error(Marker marker, String str, Object obj);

    void error(Marker marker, String str, Object obj, Object obj2);

    void error(Marker marker, String str, Object... objArr);

    void error(Marker marker, String str, Throwable th);

    @CheckReturnValue
    default LoggingEventBuilder atError() {
        return isErrorEnabled() ? makeLoggingEventBuilder(Level.ERROR) : NOPLoggingEventBuilder.singleton();
    }
}
