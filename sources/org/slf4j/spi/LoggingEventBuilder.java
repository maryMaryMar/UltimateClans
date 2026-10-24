package org.slf4j.spi;

import java.util.function.Supplier;
import org.slf4j.Marker;
import org.slf4j.helpers.CheckReturnValue;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/spi/LoggingEventBuilder.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/spi/LoggingEventBuilder.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/LoggingEventBuilder.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/LoggingEventBuilder.class */
public interface LoggingEventBuilder {
    @CheckReturnValue
    LoggingEventBuilder setCause(Throwable th);

    @CheckReturnValue
    LoggingEventBuilder addMarker(Marker marker);

    @CheckReturnValue
    LoggingEventBuilder addArgument(Object obj);

    @CheckReturnValue
    LoggingEventBuilder addArgument(Supplier<?> supplier);

    @CheckReturnValue
    LoggingEventBuilder addKeyValue(String str, Object obj);

    @CheckReturnValue
    LoggingEventBuilder addKeyValue(String str, Supplier<Object> supplier);

    @CheckReturnValue
    LoggingEventBuilder setMessage(String str);

    @CheckReturnValue
    LoggingEventBuilder setMessage(Supplier<String> supplier);

    void log();

    void log(String str);

    void log(String str, Object obj);

    void log(String str, Object obj, Object obj2);

    void log(String str, Object... objArr);

    void log(Supplier<String> supplier);
}
