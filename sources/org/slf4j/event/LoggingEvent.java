package org.slf4j.event;

import java.util.List;
import org.slf4j.Marker;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/event/LoggingEvent.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/event/LoggingEvent.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/event/LoggingEvent.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/event/LoggingEvent.class */
public interface LoggingEvent {
    Level getLevel();

    String getLoggerName();

    String getMessage();

    List<Object> getArguments();

    Object[] getArgumentArray();

    List<Marker> getMarkers();

    List<KeyValuePair> getKeyValuePairs();

    Throwable getThrowable();

    long getTimeStamp();

    String getThreadName();

    default String getCallerBoundary() {
        return null;
    }
}
