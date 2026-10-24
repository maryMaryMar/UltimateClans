package org.slf4j.spi;

import org.slf4j.Logger;
import org.slf4j.Marker;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/spi/LocationAwareLogger.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/spi/LocationAwareLogger.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/LocationAwareLogger.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/LocationAwareLogger.class */
public interface LocationAwareLogger extends Logger {
    public static final int TRACE_INT = 0;
    public static final int DEBUG_INT = 10;
    public static final int INFO_INT = 20;
    public static final int WARN_INT = 30;
    public static final int ERROR_INT = 40;

    void log(Marker marker, String str, int i, String str2, Object[] objArr, Throwable th);
}
