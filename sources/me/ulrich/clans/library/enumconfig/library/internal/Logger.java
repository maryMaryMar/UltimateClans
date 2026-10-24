package me.ulrich.clans.library.enumconfig.library.internal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/internal/Logger.class */
public class Logger {
    private final java.util.logging.Logger logger;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/internal/Logger$Level.class */
    public enum Level {
        WARNING(java.util.logging.Level.WARNING),
        DEBUG(java.util.logging.Level.FINE);

        private final java.util.logging.Level level;

        Level(java.util.logging.Level level) {
            this.level = level;
        }
    }

    private Logger(String str) {
        this.logger = java.util.logging.Logger.getLogger(str);
    }

    public static Logger getLogger(String str) {
        return new Logger(str);
    }

    public boolean isLoggable(Level level) {
        return this.logger.isLoggable(level.level);
    }

    public void warn(String str) {
        this.logger.log(Level.WARNING.level, str);
    }

    public void debug(String str) {
        this.logger.log(Level.DEBUG.level, str);
    }
}
