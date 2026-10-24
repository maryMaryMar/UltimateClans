package me.ulrich.clans.library.nbtapi.utils;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/UUIDUtil.class */
public class UUIDUtil {
    public static UUID uuidFromIntArray(int[] iArr) {
        return new UUID((((long) iArr[0]) << 32) | (((long) iArr[1]) & 4294967295L), (((long) iArr[2]) << 32) | (((long) iArr[3]) & 4294967295L));
    }

    public static int[] uuidToIntArray(UUID uuid) {
        return leastMostToIntArray(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    private static int[] leastMostToIntArray(long j, long j2) {
        return new int[]{(int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2};
    }
}
