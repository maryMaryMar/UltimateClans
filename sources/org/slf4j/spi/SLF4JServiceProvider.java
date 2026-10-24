package org.slf4j.spi;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/spi/SLF4JServiceProvider.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/spi/SLF4JServiceProvider.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/SLF4JServiceProvider.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/SLF4JServiceProvider.class */
public interface SLF4JServiceProvider {
    ILoggerFactory getLoggerFactory();

    IMarkerFactory getMarkerFactory();

    MDCAdapter getMDCAdapter();

    String getRequestedApiVersion();

    void initialize();
}
