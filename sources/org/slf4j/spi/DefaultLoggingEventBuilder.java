package org.slf4j.spi;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.DefaultLoggingEvent;
import org.slf4j.event.KeyValuePair;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/spi/DefaultLoggingEventBuilder.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/spi/DefaultLoggingEventBuilder.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/DefaultLoggingEventBuilder.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/DefaultLoggingEventBuilder.class */
public class DefaultLoggingEventBuilder implements CallerBoundaryAware, LoggingEventBuilder {
    static String DLEB_FQCN = DefaultLoggingEventBuilder.class.getName();
    protected DefaultLoggingEvent loggingEvent;
    protected Logger logger;

    public DefaultLoggingEventBuilder(Logger logger, Level level) {
        this.logger = logger;
        this.loggingEvent = new DefaultLoggingEvent(level, logger);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addMarker(Marker marker) {
        this.loggingEvent.addMarker(marker);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder setCause(Throwable th) {
        this.loggingEvent.setThrowable(th);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addArgument(Object obj) {
        this.loggingEvent.addArgument(obj);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addArgument(Supplier<?> supplier) {
        this.loggingEvent.addArgument(supplier.get());
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addKeyValue(String str, Object obj) {
        this.loggingEvent.addKeyValue(str, obj);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addKeyValue(String str, Supplier<Object> supplier) {
        this.loggingEvent.addKeyValue(str, supplier.get());
        return this;
    }

    @Override // org.slf4j.spi.CallerBoundaryAware
    public void setCallerBoundary(String str) {
        this.loggingEvent.setCallerBoundary(str);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log() {
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder setMessage(String str) {
        this.loggingEvent.setMessage(str);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder setMessage(Supplier<String> supplier) {
        this.loggingEvent.setMessage(supplier.get());
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str) {
        this.loggingEvent.setMessage(str);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str, Object obj) {
        this.loggingEvent.setMessage(str);
        this.loggingEvent.addArgument(obj);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str, Object obj, Object obj2) {
        this.loggingEvent.setMessage(str);
        this.loggingEvent.addArgument(obj);
        this.loggingEvent.addArgument(obj2);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str, Object... objArr) {
        this.loggingEvent.setMessage(str);
        this.loggingEvent.addArguments(objArr);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(Supplier<String> supplier) {
        if (supplier == null) {
            log((String) null);
        } else {
            log(supplier.get());
        }
    }

    protected void log(LoggingEvent loggingEvent) {
        if (loggingEvent.getCallerBoundary() == null) {
            setCallerBoundary(DLEB_FQCN);
        }
        if (this.logger instanceof LoggingEventAware) {
            ((LoggingEventAware) this.logger).log(loggingEvent);
        } else if (this.logger instanceof LocationAwareLogger) {
            logViaLocationAwareLoggerAPI((LocationAwareLogger) this.logger, loggingEvent);
        } else {
            logViaPublicSLF4JLoggerAPI(loggingEvent);
        }
    }

    private void logViaLocationAwareLoggerAPI(LocationAwareLogger locationAwareLogger, LoggingEvent loggingEvent) {
        loggingEvent.getMessage();
        loggingEvent.getMarkers();
        locationAwareLogger.log(null, loggingEvent.getCallerBoundary(), loggingEvent.getLevel().toInt(), mergeMarkersAndKeyValuePairsAndMessage(loggingEvent), loggingEvent.getArgumentArray(), loggingEvent.getThrowable());
    }

    private void logViaPublicSLF4JLoggerAPI(LoggingEvent loggingEvent) {
        Object[] argumentArray = loggingEvent.getArgumentArray();
        int length = argumentArray == null ? 0 : argumentArray.length;
        Throwable throwable = loggingEvent.getThrowable();
        Object[] objArr = new Object[length + (throwable == null ? 0 : 1)];
        if (argumentArray != null) {
            System.arraycopy(argumentArray, 0, objArr, 0, length);
        }
        if (throwable != null) {
            objArr[length] = throwable;
        }
        String strMergeMarkersAndKeyValuePairsAndMessage = mergeMarkersAndKeyValuePairsAndMessage(loggingEvent);
        switch (loggingEvent.getLevel()) {
            case TRACE:
                this.logger.trace(strMergeMarkersAndKeyValuePairsAndMessage, objArr);
                break;
            case DEBUG:
                this.logger.debug(strMergeMarkersAndKeyValuePairsAndMessage, objArr);
                break;
            case INFO:
                this.logger.info(strMergeMarkersAndKeyValuePairsAndMessage, objArr);
                break;
            case WARN:
                this.logger.warn(strMergeMarkersAndKeyValuePairsAndMessage, objArr);
                break;
            case ERROR:
                this.logger.error(strMergeMarkersAndKeyValuePairsAndMessage, objArr);
                break;
        }
    }

    private String mergeMarkersAndKeyValuePairsAndMessage(LoggingEvent loggingEvent) {
        return mergeMessage(loggingEvent.getMessage(), mergeKeyValuePairs(loggingEvent.getKeyValuePairs(), mergeMarkers(loggingEvent.getMarkers(), null)));
    }

    private StringBuilder mergeMarkers(List<Marker> list, StringBuilder sb) {
        if (list == null || list.isEmpty()) {
            return sb;
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        Iterator<Marker> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(' ');
        }
        return sb;
    }

    private StringBuilder mergeKeyValuePairs(List<KeyValuePair> list, StringBuilder sb) {
        if (list == null || list.isEmpty()) {
            return sb;
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        for (KeyValuePair keyValuePair : list) {
            sb.append(keyValuePair.key);
            sb.append('=');
            sb.append(keyValuePair.value);
            sb.append(' ');
        }
        return sb;
    }

    private String mergeMessage(String str, StringBuilder sb) {
        if (sb == null) {
            return str;
        }
        sb.append(str);
        return sb.toString();
    }
}
