package org.slf4j;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/LoggerFactoryFriend.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/LoggerFactoryFriend.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/LoggerFactoryFriend.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/LoggerFactoryFriend.class */
public class LoggerFactoryFriend {
    public static void reset() {
        LoggerFactory.reset();
    }

    public static void setDetectLoggerNameMismatch(boolean z) {
        LoggerFactory.DETECT_LOGGER_NAME_MISMATCH = z;
    }
}
