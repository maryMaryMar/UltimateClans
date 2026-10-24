package org.slf4j.event;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/event/Level.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/event/Level.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/event/Level.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/event/Level.class */
public enum Level {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private final int levelInt;
    private final String levelStr;

    Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    public int toInt() {
        return this.levelInt;
    }

    public static Level intToLevel(int i) {
        switch (i) {
            case 0:
                return TRACE;
            case 10:
                return DEBUG;
            case 20:
                return INFO;
            case 30:
                return WARN;
            case 40:
                return ERROR;
            default:
                throw new IllegalArgumentException("Level integer [" + i + "] not recognized.");
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
