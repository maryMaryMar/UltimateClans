package me.ulrich.clans.manager.utils;

import java.util.Optional;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Locals.class */
public class Locals {
    private static volatile String i9fSfrLItHqvfNI;
    private static volatile String viJarIun0aSYjs;
    private static volatile String kumIWFk7cpl2rFvc;
    private static String dtF1eDDibZMMFno4skzHx;
    private static volatile String kSqaV3KgP6Ksj4;
    private static String z7MS7FpV00lRRnLIMQKWgH;
    private static String BNJJbrSAST8lCeN2;
    private static volatile String FVBbdUzgz8fReo;
    private static volatile String dQYJt9pkaEyfQZTbu572Xe;
    private static String D9nTjWaA1NjK8DPlG;
    private static volatile String xK0euA8IWVsmAzifVM;
    private static volatile String SMOtopqZutxPJm7f9J;
    private static String TphcwSf5XCqcok3G;
    private static String zJcxW67Gt19JLuOtzY;
    private static String Jn4YAEHAAIRd5jPv3ac8;
    private static String Z10ZwNQv3r3Ov36gZSR8d;
    private static String M7vhgojBHyLSkGkce29;
    private static String HvPVzpXTEoYiISchnTACtz;
    private static String nW1K7w6YvEg1yhn;
    private static volatile String J1Uc2LPqKJjqhkT5P;
    private static String WCX0ezH4xq03euAC;
    private static String XHs2RvNVt39Od0oa;
    private static String YSxlzi19DlgaT1WDlxWT;
    private static volatile String E1XJoHWLsZuXzu5FZENrap;
    private static volatile String lBcBE6AYQoYTt8L;
    private static volatile String ynVPJHYwqaqx7CEn;
    private static String XyuEHnvdmLF6OKH;
    private static String Szrs9fxN3kj69nWx0X;
    private static String GJl3ilUji9POSSzNN2j;
    private static String Rmmc8zcrbp8v7N8a;
    private static String ajInIJmJ9P65tHqMYfX;
    private static String MoL3eGovyBgoe6TLAU;
    private static volatile String gXiViCBXXIk7KqeR81zUz;
    private static String ZORUJvowzuzsUAZq;
    private static String Cj0TozSnxaqiRes0;
    private static volatile String DNy9SWgsg8u9LvG4WoE;
    private static String ZXwdE4CAu2agdLC;
    private static volatile String ifD8jUHMvBc1gL090PB26;
    private static String mTaonKZkk4Q9hz5p;
    private static String WexhB3c3ZpJAwblQX3LzJ;
    private static volatile String oDC1EEYsmVcCFsG;
    private static volatile String E0PqtHpqPPHo0BBIr;
    private static volatile String RVuxzmkTOC9TdecuS;
    private static String d4tMjlXrzkYhAYOVCO3O;
    private static volatile String WmpQXMHMUOyaWBNfdFX72X;
    private static volatile String WPy4LSkjNgnGwFvNZ1B;
    private static String QEO8ASQcSAjdB2VVP9;
    private static String LHrt0NfRRVWxOtat;
    private static final byte[] OgrykBNgL8dUPZhx = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] W5ICSoyM7ZRCqjui = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] lD79htARvpaN8WDX = {(byte) 21, (byte) 131, (byte) 200, (byte) 233, (byte) 157, (byte) 60, (byte) 244, (byte) 142, (byte) 108, (byte) 107, (byte) 32, (byte) 236, (byte) 17, (byte) 130, (byte) 140, (byte) 182};
    private static final byte[] vLXsv55GZeAjOlzwq = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] XC4Xqd0Dh0hl0Ji = {(byte) 201, (byte) 123, (byte) 190, (byte) 53, (byte) 47, (byte) 84, (byte) 205, (byte) 245, (byte) 162, (byte) 169, (byte) 83, (byte) 26, (byte) 27, (byte) 68, (byte) 4, (byte) 11};
    private static final byte[] PFGzsTZZ4KkdRzrDZIanDS = {(byte) 139, (byte) 235, (byte) 229, (byte) 216, (byte) 211, (byte) 227, (byte) 248, (byte) 171, (byte) 216, (byte) 88, (byte) 93, (byte) 88, (byte) 76, (byte) 64, (byte) 106, (byte) 157};
    private static final byte[] cr5Dad4UzWoXMf = {(byte) 33, (byte) 117, (byte) 254, (byte) 86, (byte) 141, (byte) 195, (byte) 116, (byte) 29, (byte) 113, (byte) 1, (byte) 97, (byte) 172, (byte) 52, (byte) 231, (byte) 192, (byte) 170};
    private static final byte[] FrQ7SUYUHvNKi10PwhwBD7 = {(byte) 246, (byte) 117, (byte) 81, (byte) 76, (byte) 138, (byte) 242, (byte) 156, (byte) 76, (byte) 178, (byte) 202, (byte) 187, (byte) 197, (byte) 116, (byte) 76, (byte) 105, (byte) 113};
    private static final byte[] Zvz1a4phK5i5bo0PpIOpP = {(byte) 148, (byte) 244, (byte) 176, (byte) 179, (byte) 22, (byte) 193, (byte) 2, (byte) 24, (byte) 130, (byte) 8, (byte) 201, (byte) 229, (byte) 251, (byte) 90, (byte) 209, (byte) 39};
    private static final byte[] b1deRx3E3gTG800j3B = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] kJAL156CCyNQGSod6RWYG = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] mS9NlV1wqGq17q7guC78kS = {(byte) 21, (byte) 131, (byte) 200, (byte) 233, (byte) 157, (byte) 60, (byte) 244, (byte) 142, (byte) 108, (byte) 107, (byte) 32, (byte) 236, (byte) 17, (byte) 130, (byte) 140, (byte) 182};
    private static final byte[] DlPKS5JCe2KkXgcEeeJ = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] TYbaBl7eOuVGzvaiQh = {(byte) 104, (byte) 245, (byte) 230, (byte) 195, (byte) 59, (byte) 62, (byte) 135, (byte) 1, (byte) 77, (byte) 241, (byte) 143, (byte) 110, (byte) 128, (byte) 215, (byte) 184, (byte) 124};
    private static final byte[] XIUekKvXowa1MkrbVVno = {(byte) 86, (byte) 239, (byte) 105, (byte) 100, (byte) 85, (byte) 50, (byte) 203, (byte) 195, (byte) 56, (byte) 145, (byte) 194, (byte) 195, (byte) 189, (byte) 9, (byte) 187, (byte) 240};
    private static final byte[] En9htMbk6kiXVcOHAa = {(byte) 86, (byte) 239, (byte) 105, (byte) 100, (byte) 85, (byte) 50, (byte) 203, (byte) 195, (byte) 56, (byte) 145, (byte) 194, (byte) 195, (byte) 189, (byte) 9, (byte) 187, (byte) 240};
    private static final byte[] S9zDxKAUmX2YUFE = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] Fg2u0BK0eZZNNBr7 = {(byte) 104, (byte) 245, (byte) 230, (byte) 195, (byte) 59, (byte) 62, (byte) 135, (byte) 1, (byte) 77, (byte) 241, (byte) 143, (byte) 110, (byte) 128, (byte) 215, (byte) 184, (byte) 124};
    private static final byte[] RggNoELQ84Tf0x0a0o = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] mkI8T0u0ZZpy2hre1iY7N = {(byte) 104, (byte) 245, (byte) 230, (byte) 195, (byte) 59, (byte) 62, (byte) 135, (byte) 1, (byte) 77, (byte) 241, (byte) 143, (byte) 110, (byte) 128, (byte) 215, (byte) 184, (byte) 124};
    private static final byte[] fub1K3n2XrpLHR7xY9R2i2 = {(byte) 222, (byte) 100, (byte) 143, (byte) 125, (byte) 189, (byte) 35, (byte) 59, (byte) 92, (byte) 6, (byte) 172, (byte) 174, (byte) 113, (byte) 108, (byte) 184, (byte) 166, (byte) 47};
    private static final byte[] LM7LBa3VzGBjdWMSbQtrz6 = {(byte) 231, (byte) 16, (byte) 115, (byte) 37, (byte) 213, (byte) 6, (byte) 92, (byte) 11, (byte) 61, (byte) 208, (byte) 100, (byte) 151, (byte) 31, (byte) 7, (byte) 142, (byte) 58};
    private static final byte[] ChI3lqcXaTAUioJR8aaPwZ = {(byte) 91, (byte) 112, (byte) 127, (byte) 40, (byte) 212, (byte) 226, (byte) 152, (byte) 187, (byte) 227, (byte) 191, (byte) 105, (byte) 219, (byte) 130, (byte) 95, (byte) 71, (byte) 101};
    private static final byte[] oZrL5Sx6YPWRIq02S0SKq = {(byte) 157, (byte) 15, (byte) 74, (byte) 177, (byte) 38, (byte) 79, (byte) 10, (byte) 178, (byte) 135, (byte) 117, (byte) 156, (byte) 174, (byte) 99, (byte) 50, (byte) 245, (byte) 61};
    private static final byte[] ewxWkSYkMfb72Umn2b = {(byte) 231, (byte) 16, (byte) 115, (byte) 37, (byte) 213, (byte) 6, (byte) 92, (byte) 11, (byte) 61, (byte) 208, (byte) 100, (byte) 151, (byte) 31, (byte) 7, (byte) 142, (byte) 58};
    private static final byte[] cUspVwxYe39c9Pe = {(byte) 157, (byte) 15, (byte) 74, (byte) 177, (byte) 38, (byte) 79, (byte) 10, (byte) 178, (byte) 135, (byte) 117, (byte) 156, (byte) 174, (byte) 99, (byte) 50, (byte) 245, (byte) 61};
    private static final byte[] eDECPDNRVoVGlWcvf6s4 = {(byte) 216, (byte) 79, (byte) 23, (byte) 133, (byte) 39, (byte) 175, (byte) 198, (byte) 189, (byte) 88, (byte) 49, (byte) 48, (byte) 144, (byte) 185, (byte) 174, (byte) 177, (byte) 154, (byte) 105, (byte) 141, (byte) 72, (byte) 77, (byte) 18, (byte) 188, (byte) 80, (byte) 253, (byte) 136, (byte) 83, (byte) 208, (byte) 66, (byte) 89, (byte) 186, (byte) 109, (byte) 143};
    private static final byte[] QAg6OSOwyVw5l6oJkdzV = {(byte) 250, (byte) 168, (byte) 223, (byte) 249, (byte) 151, (byte) 240, (byte) 76, (byte) 14, (byte) 7, (byte) 216, (byte) 99, (byte) 237, (byte) 35, (byte) 242, (byte) 204, (byte) 35};

    public String encodeChunk(Chunk chunk) {
        try {
            return chunk.getWorld().getName() + "|" + String.valueOf(chunk.getX()).replace(kc5eY8X6MXmBMVV(), eRCydUyH1Evgpi8RNB75w7()) + "|" + String.valueOf(chunk.getZ()).replace(tKTQ82UO18a2xx4h00STxA(), T8zRdyFeu6JnuWaXmhFP());
        } catch (Exception e) {
            return null;
        }
    }

    public Chunk decodeChunk(String str) {
        try {
            String[] strArrSplit = str.split(Je6q0vKXpTFB4JJt());
            Chunk chunkAt = Bukkit.getWorld(strArrSplit[0]).getChunkAt((int) Double.valueOf(strArrSplit[1].replace(SWGDMxJgZxwvvJi2(), UGunKf9R7vxYtt())).doubleValue(), (int) Double.valueOf(strArrSplit[2].replace(seP2gysF50JNwb(), eAootzXUhzM219Rz9OG4f())).doubleValue());
            if (chunkAt != null) {
                return chunkAt;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String encodeLocation(Location location) {
        try {
            String name = location.getWorld().getName();
            double x = location.getX();
            double y = location.getY();
            double z = location.getZ();
            location.getPitch();
            location.getYaw();
            return name + "|" + x + "|" + name + "|" + y + "|" + name + "|" + z;
        } catch (Exception e) {
            return null;
        }
    }

    public Location decodeLocation(String str) {
        try {
            String[] strArrSplit = str.split(Bh251gHLMA0UZnoXyDkb());
            Location location = new Location(Bukkit.getWorld(strArrSplit[0]), Double.valueOf(strArrSplit[1]).doubleValue(), Double.valueOf(strArrSplit[2]).doubleValue(), Double.valueOf(strArrSplit[3]).doubleValue(), Float.valueOf(strArrSplit[5]).floatValue(), Float.valueOf(strArrSplit[4]).floatValue());
            if (location != null) {
                return location;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<Location> mountLocal(EncodedLocationData encodedLocationData) {
        try {
            Location location = new Location(Bukkit.getWorld(encodedLocationData.getWorld()), encodedLocationData.getX(), encodedLocationData.getY(), encodedLocationData.getZ(), encodedLocationData.getYaw(), encodedLocationData.getPitch());
            if (location != null) {
                return Optional.of(location);
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    public Optional<EncodedLocationData> decodeLocation(String str, String str2) {
        try {
            String[] strArrSplit = str2.split(j2VJjSZlRUzC0sWR5E8T9e());
            return Optional.of(new EncodedLocationData(str, strArrSplit[0], Double.valueOf(strArrSplit[1]).doubleValue(), Double.valueOf(strArrSplit[2]).doubleValue(), Double.valueOf(strArrSplit[3]).doubleValue(), Float.valueOf(strArrSplit[5]).floatValue(), Float.valueOf(strArrSplit[4]).floatValue()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public final Block getTargetBlock(Player player, int i) {
        BlockIterator blockIterator = new BlockIterator(player, i);
        Block next = blockIterator.next();
        while (blockIterator.hasNext()) {
            next = blockIterator.next();
            if (next.getType() != Material.AIR) {
                break;
            }
        }
        return next;
    }

    public String getDirection(Player player) {
        float yaw = player.getLocation().getYaw();
        if (yaw < 0.0f) {
            yaw += 360.0f;
        }
        if (yaw >= 315.0f || yaw < 45.0f) {
            return cCUqaDh97lXtZ4hc4Bzr();
        }
        if (yaw < 135.0f) {
            return f6FtzZ8ir2SScqKigfEEFc();
        }
        if (yaw < 225.0f) {
            return qRquM4MV4FW7UDuLvIuH();
        }
        return yaw < 315.0f ? vMoAUBTtiEWKt5EiiqFkqc() : QJZtOvV9vu0VKDMs1g();
    }

    public String getDirection(ArmorStand armorStand) {
        float yaw = armorStand.getLocation().getYaw();
        if (yaw < 0.0f) {
            yaw += 360.0f;
        }
        if (yaw >= 315.0f || yaw < 45.0f) {
            return uPe0lyaPJ3Rca7xR();
        }
        if (yaw < 135.0f) {
            return EDmFAiHtu8z2L7aieUBE39();
        }
        if (yaw < 225.0f) {
            return r4akuYDfTPxL0a();
        }
        return yaw < 315.0f ? dmxP65SGaeUggT1zGbh() : hiw8aDNJ0zpEMaP();
    }

    public String getInvertedDirection(Player player) {
        String direction = getDirection(player);
        switch (direction.hashCode()) {
            case 2120701:
                if (direction.equals(ZHXsTSYkTU7Sb6z8Hqq())) {
                    return LKzyAI1lNtHOhQq();
                }
                break;
            case 2660783:
                if (direction.equals(PT6mSqy69qoIFOerkZ())) {
                    return TBMKIfSpgXtQjIz();
                }
                break;
            case 74469605:
                if (direction.equals(w7SXJY7z2j8aKpe())) {
                    return HZbUEy1u4DHXgdx();
                }
                break;
            case 79090093:
                if (direction.equals(KhU9CbhbvMfQak0Y())) {
                    return ECnreJDNTKtLnsRGjk();
                }
                break;
        }
        return hsyfNiumWndm3IanYo();
    }

    public String getCardinalDirection(Player player) {
        double yaw = (player.getLocation().getYaw() - 90.0f) % 360.0f;
        if (yaw < 0.0d) {
            yaw += 360.0d;
        }
        if (0.0d <= yaw && yaw < 22.5d) {
            return Y41UUKakM5WISi();
        }
        if (22.5d <= yaw && yaw < 67.5d) {
            return UXVqi1ICEn6IUWVluQlIt();
        }
        if (67.5d <= yaw && yaw < 112.5d) {
            return rHWSK09xxerAhB();
        }
        if (112.5d <= yaw && yaw < 157.5d) {
            return cdfIEUu5JRh3cu();
        }
        if (157.5d <= yaw && yaw < 202.5d) {
            return WhcBGw5KbE1e4lr();
        }
        if (202.5d <= yaw && yaw < 247.5d) {
            return sX7YbhK4oInUcwVYQLP();
        }
        if (247.5d <= yaw && yaw < 292.5d) {
            return WXjIgulEiNqo7J();
        }
        if (292.5d <= yaw && yaw < 337.5d) {
            return ypQB1K6ibDeZUIou();
        }
        if (337.5d > yaw || yaw >= 360.0d) {
            return null;
        }
        return mhJHdvKuqPrxiRD();
    }

    public String getInvertedDirection(ArmorStand armorStand) {
        String direction = getDirection(armorStand);
        switch (direction.hashCode()) {
            case 2120701:
                if (direction.equals(nE43B8iggG4Y7HZEM())) {
                    return DlJWiAH78Y2COaK();
                }
                break;
            case 2660783:
                if (direction.equals(dr9CxK28S4ahqFP())) {
                    return LYl9bc4r3EyywB7NP();
                }
                break;
            case 74469605:
                if (direction.equals(YFNLn1oHPrwWW63f())) {
                    return n4W0SpxxyocawLMPst();
                }
                break;
            case 79090093:
                if (direction.equals(xk0F70POgqEhsGy())) {
                    return exUK2UWoXmLfeqYVh3Hk();
                }
                break;
        }
        return kEHs8EFIXOSD4xFLE1iBo();
    }

    public Location getCircle(Location location, double d, double d2) {
        double x = location.getX() + (d * Math.cos(d2));
        double z = location.getZ() + (d * Math.sin(d2));
        Location location2 = new Location(location.getWorld(), x, location.getY(), z);
        location2.setDirection(location.toVector().clone().subtract(location2.toVector()));
        return location2;
    }

    private static String kc5eY8X6MXmBMVV() {
        return ".";
    }

    private static String eRCydUyH1Evgpi8RNB75w7() {
        return "_";
    }

    private static String tKTQ82UO18a2xx4h00STxA() {
        return ".";
    }

    private static String T8zRdyFeu6JnuWaXmhFP() {
        return "_";
    }

    private static String Je6q0vKXpTFB4JJt() {
        return "\\|";
    }

    private static String SWGDMxJgZxwvvJi2() {
        return "_";
    }

    private static String UGunKf9R7vxYtt() {
        return ".";
    }

    private static String seP2gysF50JNwb() {
        return "_";
    }

    private static String eAootzXUhzM219Rz9OG4f() {
        return ".";
    }

    private static String Bh251gHLMA0UZnoXyDkb() {
        return "\\|";
    }

    private static String j2VJjSZlRUzC0sWR5E8T9e() {
        return "\\|";
    }

    private static String f6FtzZ8ir2SScqKigfEEFc() {
        return "WEST";
    }

    private static String qRquM4MV4FW7UDuLvIuH() {
        return "NORTH";
    }

    private static String vMoAUBTtiEWKt5EiiqFkqc() {
        return "EAST";
    }

    private static String QJZtOvV9vu0VKDMs1g() {
        return "NORTH";
    }

    private static String cCUqaDh97lXtZ4hc4Bzr() {
        return "SOUTH";
    }

    private static String EDmFAiHtu8z2L7aieUBE39() {
        return "WEST";
    }

    private static String r4akuYDfTPxL0a() {
        return "NORTH";
    }

    private static String dmxP65SGaeUggT1zGbh() {
        return "EAST";
    }

    private static String hiw8aDNJ0zpEMaP() {
        return "NORTH";
    }

    private static String uPe0lyaPJ3Rca7xR() {
        return "SOUTH";
    }

    private static String ZHXsTSYkTU7Sb6z8Hqq() {
        return "EAST";
    }

    private static String LKzyAI1lNtHOhQq() {
        return "WEST";
    }

    private static String PT6mSqy69qoIFOerkZ() {
        return "WEST";
    }

    private static String TBMKIfSpgXtQjIz() {
        return "EAST";
    }

    private static String w7SXJY7z2j8aKpe() {
        return "NORTH";
    }

    private static String HZbUEy1u4DHXgdx() {
        return "SOUTH";
    }

    private static String KhU9CbhbvMfQak0Y() {
        return "SOUTH";
    }

    private static String ECnreJDNTKtLnsRGjk() {
        return "NORTH";
    }

    private static String hsyfNiumWndm3IanYo() {
        return "NORTH";
    }

    private static String Y41UUKakM5WISi() {
        return "N";
    }

    private static String UXVqi1ICEn6IUWVluQlIt() {
        return "NE";
    }

    private static String rHWSK09xxerAhB() {
        return "E";
    }

    private static String cdfIEUu5JRh3cu() {
        return "SE";
    }

    private static String WhcBGw5KbE1e4lr() {
        return "S";
    }

    private static String sX7YbhK4oInUcwVYQLP() {
        return "SW";
    }

    private static String WXjIgulEiNqo7J() {
        return "W";
    }

    private static String ypQB1K6ibDeZUIou() {
        return "NW";
    }

    private static String mhJHdvKuqPrxiRD() {
        return "N";
    }

    private static String nE43B8iggG4Y7HZEM() {
        return "EAST";
    }

    private static String DlJWiAH78Y2COaK() {
        return "WEST";
    }

    private static String dr9CxK28S4ahqFP() {
        return "WEST";
    }

    private static String LYl9bc4r3EyywB7NP() {
        return "EAST";
    }

    private static String YFNLn1oHPrwWW63f() {
        return "NORTH";
    }

    private static String n4W0SpxxyocawLMPst() {
        return "SOUTH";
    }

    private static String xk0F70POgqEhsGy() {
        return "SOUTH";
    }

    private static String exUK2UWoXmLfeqYVh3Hk() {
        return "NORTH";
    }

    private static String kEHs8EFIXOSD4xFLE1iBo() {
        return "NORTH";
    }
}
