package org.slf4j.helpers;

import org.slf4j.event.LoggingEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/helpers/NormalizedParameters.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/helpers/NormalizedParameters.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/helpers/NormalizedParameters.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/helpers/NormalizedParameters.class */
public class NormalizedParameters {
    final String message;
    final Object[] arguments;
    final Throwable throwable;

    public NormalizedParameters(String str, Object[] objArr, Throwable th) {
        this.message = str;
        this.arguments = objArr;
        this.throwable = th;
    }

    public NormalizedParameters(String str, Object[] objArr) {
        this(str, objArr, null);
    }

    public String getMessage() {
        return this.message;
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public static Throwable getThrowableCandidate(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static Object[] trimmedCopy(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        return objArr2;
    }

    public static NormalizedParameters normalize(String str, Object[] objArr, Throwable th) {
        if (th != null) {
            return new NormalizedParameters(str, objArr, th);
        }
        if (objArr == null || objArr.length == 0) {
            return new NormalizedParameters(str, objArr, th);
        }
        Throwable throwableCandidate = getThrowableCandidate(objArr);
        return throwableCandidate != null ? new NormalizedParameters(str, MessageFormatter.trimmedCopy(objArr), throwableCandidate) : new NormalizedParameters(str, objArr);
    }

    public static NormalizedParameters normalize(LoggingEvent loggingEvent) {
        return normalize(loggingEvent.getMessage(), loggingEvent.getArgumentArray(), loggingEvent.getThrowable());
    }
}
