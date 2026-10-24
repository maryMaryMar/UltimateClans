package org.slf4j.helpers;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/helpers/Slf4jEnvUtil.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/helpers/Slf4jEnvUtil.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/helpers/Slf4jEnvUtil.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/helpers/Slf4jEnvUtil.class */
public class Slf4jEnvUtil {
    public static String slf4jVersion() {
        Package r0 = Slf4jEnvUtil.class.getPackage();
        if (r0 == null) {
            return null;
        }
        return r0.getImplementationVersion();
    }
}
