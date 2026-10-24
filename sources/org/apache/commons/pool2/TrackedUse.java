package org.apache.commons.pool2;

import java.time.Instant;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/TrackedUse.class */
public interface TrackedUse {
    @Deprecated
    long getLastUsed();

    default Instant getLastUsedInstant() {
        return Instant.ofEpochMilli(getLastUsed());
    }
}
