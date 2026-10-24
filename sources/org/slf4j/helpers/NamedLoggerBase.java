package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/helpers/NamedLoggerBase.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/helpers/NamedLoggerBase.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/helpers/NamedLoggerBase.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/helpers/NamedLoggerBase.class */
abstract class NamedLoggerBase implements Serializable, Logger {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    NamedLoggerBase() {
    }

    public String getName() {
        return this.name;
    }

    protected Object readResolve() {
        return LoggerFactory.getLogger(getName());
    }
}
