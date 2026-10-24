package me.module.multiserver.library.redis.jedis.util;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/JedisClusterHashTag.class */
public final class JedisClusterHashTag {
    private JedisClusterHashTag() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static String getHashTag(String str) {
        return extractHashTag(str, true);
    }

    public static boolean isClusterCompliantMatchPattern(byte[] bArr) {
        return isClusterCompliantMatchPattern(SafeEncoder.encode(bArr));
    }

    public static boolean isClusterCompliantMatchPattern(String str) {
        String strExtractHashTag = extractHashTag(str, false);
        return (strExtractHashTag == null || strExtractHashTag.isEmpty()) ? false : true;
    }

    private static String extractHashTag(String str, boolean z) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf("{");
        if (iIndexOf2 > -1 && (iIndexOf = str.indexOf("}", iIndexOf2 + 1)) > -1 && iIndexOf != iIndexOf2 + 1) {
            return str.substring(iIndexOf2 + 1, iIndexOf);
        }
        if (z) {
            return str;
        }
        return null;
    }
}
