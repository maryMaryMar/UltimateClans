package me.module.multiserver.library.redis.jedis.util;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/DoublePrecision.class */
public final class DoublePrecision {
    private DoublePrecision() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static Double parseFloatingPointNumber(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            switch (str) {
                case "inf":
                case "+inf":
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                case "-inf":
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                case "nan":
                    return Double.valueOf(Double.NaN);
                default:
                    throw e;
            }
        }
    }
}
