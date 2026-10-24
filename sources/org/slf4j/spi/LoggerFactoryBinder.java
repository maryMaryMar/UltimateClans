package org.slf4j.spi;

import org.slf4j.ILoggerFactory;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/spi/LoggerFactoryBinder.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/spi/LoggerFactoryBinder.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/LoggerFactoryBinder.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/LoggerFactoryBinder.class */
public interface LoggerFactoryBinder {
    ILoggerFactory getLoggerFactory();

    String getLoggerFactoryClassStr();
}
