package me.ulrich.clans.library.enumconfig.library.util;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/PlatformFeatureDetector.class */
public class PlatformFeatureDetector {
    private Boolean isRunningOnAndroid = null;

    public boolean isIntrospectionAvailable() {
        if (isRunningOnAndroid()) {
            return false;
        }
        try {
            Class.forName("java.beans.Introspector");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public boolean isRunningOnAndroid() {
        if (this.isRunningOnAndroid == null) {
            String property = System.getProperty("java.runtime.name");
            this.isRunningOnAndroid = Boolean.valueOf(property != null && property.startsWith("Android Runtime"));
        }
        return this.isRunningOnAndroid.booleanValue();
    }
}
