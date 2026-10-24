package org.apache.commons.pool2.impl;

import java.security.AccessControlException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/CallStackUtils.class */
public final class CallStackUtils {
    private static boolean canCreateSecurityManager() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            return true;
        }
        try {
            securityManager.checkPermission(new RuntimePermission("createSecurityManager"));
            return true;
        } catch (AccessControlException e) {
            return false;
        }
    }

    @Deprecated
    public static CallStack newCallStack(String str, boolean z) {
        return newCallStack(str, z, false);
    }

    public static CallStack newCallStack(String str, boolean z, boolean z2) {
        return (!canCreateSecurityManager() || z2) ? new ThrowableCallStack(str, z) : new SecurityManagerCallStack(str, z);
    }

    private CallStackUtils() {
    }
}
