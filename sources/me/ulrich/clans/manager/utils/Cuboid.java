package me.ulrich.clans.manager.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Cuboid.class */
public class Cuboid implements Cloneable, Iterable<Block>, ConfigurationSerializable {
    protected final String worldName;
    protected final int x1;
    protected final int y1;
    protected final int z1;
    protected final int x2;
    protected final int y2;
    protected final int z2;
    private static volatile String QU8symENOgxvVZsUB;
    private static String s4fLJ55C7Cs2H6O5l0;
    private static volatile String Vy62mMDpT3hPSPYinxA;
    private static volatile String glyZA8swppK3BQF8;
    private static String wTpEFTbBUa36x5gEREZ63;
    private static volatile String yZC9PgItMHsMPdtd7AdPjJ;
    private static volatile String HgD6qxesU2tRmPL;
    private static String E4RAeYfJdkF31ILH;
    private static String AUVXTcwDGTnA19tydsj5;
    private static String NepfnGnHgFMFmhG0fT7;
    private static volatile String wQT35HffgBhApPZYGc5tmJ;
    private static volatile String qFpQFa2f3T2Byuypx0q;
    private static String RqYSfJW2LdcicRnHe;
    private static String icmOJtqDLLaAUDQ;
    private static volatile String y9G0tsWd1ux9yIJehZ;
    private static final byte[] BW1sJsqMKH3UwJW2 = {(byte) 126, (byte) 50, (byte) 48, (byte) 141, (byte) 12, (byte) 105, (byte) 184, (byte) 104, (byte) 46, (byte) 154, (byte) 199, (byte) 162, (byte) 61, (byte) 102, (byte) 98, (byte) 9};
    private static final byte[] avLiHSmMW0URIm4 = {(byte) 167, (byte) 224, (byte) 232, (byte) 42, (byte) 169, (byte) 249, (byte) 231, (byte) 42, (byte) 172, (byte) 100, (byte) 196, (byte) 202, (byte) 187, (byte) 239, (byte) 108, (byte) 222};
    private static final byte[] Z7sY18zCImoBGME = {(byte) 201, (byte) 89, (byte) 136, (byte) 252, (byte) 200, (byte) 9, (byte) 4, (byte) 202, (byte) 228, (byte) 248, (byte) 177, (byte) 241, (byte) 128, (byte) 255, (byte) 80, (byte) 168};
    private static final byte[] V06p4Fyxpl461Y = {(byte) 102, (byte) 154, (byte) 157, (byte) 80, (byte) 38, (byte) 146, (byte) 230, (byte) 237, (byte) 136, (byte) 189, (byte) 113, (byte) 79, (byte) 243, (byte) 202, (byte) 41, (byte) 118};
    private static final byte[] mOcmTdhB3HPrY5YrMo = {(byte) 124, (byte) 86, (byte) 8, (byte) 104, (byte) 162, (byte) 124, (byte) 103, (byte) 95, (byte) 194, (byte) 13, (byte) 2, (byte) 194, (byte) 174, (byte) 219, (byte) 219, (byte) 115};
    private static final byte[] c686n3FcB82QYH = {(byte) 77, (byte) 45, (byte) 238, (byte) 101, (byte) 120, (byte) 65, (byte) 136, (byte) 126, (byte) 5, (byte) 214, (byte) 140, (byte) 37, (byte) 193, (byte) 49, (byte) 128, (byte) 133, (byte) 174, (byte) 36, (byte) 145, (byte) 191, (byte) 216, (byte) 91, (byte) 158, (byte) 68, (byte) 185, (byte) 35, (byte) 237, (byte) 17, (byte) 229, (byte) 86, (byte) 6, (byte) 164, (byte) 55, (byte) 132, (byte) 83, (byte) 136, (byte) 216, (byte) 168, (byte) 174, (byte) 63, (byte) 194, (byte) 220, (byte) 87, (byte) 85, (byte) 98, (byte) 167, (byte) 59, (byte) 40};
    private static final byte[] u321FBF31Xdx6B = {(byte) 190, (byte) 34, (byte) 89, (byte) 190, (byte) 131, (byte) 154, (byte) 164, (byte) 90, (byte) 140, (byte) 95, (byte) 56, (byte) 211, (byte) 73, (byte) 140, (byte) 22, (byte) 227, (byte) 115, (byte) 223, (byte) 253, (byte) 101, (byte) 129, (byte) 25, (byte) 58, (byte) 37, (byte) 248, (byte) 59, (byte) 80, (byte) 94, (byte) 49, (byte) 14, (byte) 68, (byte) 173, (byte) 188, (byte) 194, (byte) 9, (byte) 23, (byte) 83, (byte) 217, (byte) 41, (byte) 46, (byte) 211, (byte) 130, (byte) 13, (byte) 216, (byte) 205, (byte) 234, (byte) 172, (byte) 55};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Cuboid$CuboidDirection.class */
    public enum CuboidDirection {
        North,
        East,
        South,
        West,
        Up,
        Down,
        Horizontal,
        Vertical,
        Both,
        Unknown;

        private static volatile String tSe6bxqSBRhxtPrFYwna6;
        private static volatile String WVC42jsYjycdB2;
        private static volatile String eZYlUGPRnP1ZKwMgZiXg;
        private static String kq9fLppypUaUtDVtlqoCi;
        private static volatile String cN2NDjEd3OGH3Fcn;
        private static volatile String InzAxcyUXidRI5bR8g6;
        private static volatile String Fe48vu0MKTdjHfWBXzas;
        private static String NjLV1W1KC2tPotF3K;
        private static volatile String uqYtsHAHC4xXmvYR1Ufa;
        private static volatile String lIHfvhm8noFT0UIjCs8;
        private static final byte[] iEohvvNk0fcvZyx55Y7qRM = {(byte) 94, (byte) 58, (byte) 76, (byte) 163, (byte) 255, (byte) 227, (byte) 196, (byte) 190, (byte) 10, (byte) 87, (byte) 108, (byte) 201, (byte) 204, (byte) 166, (byte) 2, (byte) 242};
        private static final byte[] sqBV9x8FqwTmMNkVijJj = {(byte) 57, (byte) 49, (byte) 3, (byte) 10, (byte) 31, (byte) 139, (byte) 252, (byte) 73, (byte) 166, (byte) 13, (byte) 62, (byte) 42, (byte) 221, (byte) 198, (byte) 229, (byte) 105};
        private static final byte[] Ii9DssiMfTuVCM = {(byte) 126, (byte) 242, (byte) 114, (byte) 109, (byte) 63, (byte) 92, (byte) 94, (byte) 176, (byte) 45, (byte) 75, (byte) 101, (byte) 245, (byte) 85, (byte) 216, (byte) 141, (byte) 152};
        private static final byte[] dyyzWx5RfWysGXqibFkKdG = {(byte) 112, (byte) 239, (byte) 224, (byte) 43, (byte) 172, (byte) 193, (byte) 175, (byte) 234, (byte) 144, (byte) 119, (byte) 2, (byte) 251, (byte) 228, (byte) 227, (byte) 205, (byte) 183};
        private static final byte[] XQUZnr7SRPGpjAoYrIOS = {(byte) 72, (byte) 253, (byte) 18, (byte) 52, (byte) 54, (byte) 168, (byte) 254, (byte) 160, (byte) 214, (byte) 58, (byte) 239, (byte) 218, (byte) 19, (byte) 226, (byte) 240, (byte) 222};
        private static final byte[] EWfpfITwC0z3j3xeP = {(byte) 204, (byte) 124, (byte) 139, (byte) 61, (byte) 201, (byte) 18, (byte) 63, (byte) 46, (byte) 209, (byte) 15, (byte) 233, (byte) 219, (byte) 84, (byte) 159, (byte) 217, (byte) 3, (byte) 193, (byte) 72, (byte) 149, (byte) 26, (byte) 199, (byte) 39, (byte) 253, (byte) 59, (byte) 55, (byte) 157, (byte) 17, (byte) 45, (byte) 143, (byte) 152, (byte) 105, (byte) 115};
        private static final byte[] q5BBC8EJYkSZtTUre4MUX = {(byte) 29, (byte) 253, (byte) 188, (byte) 157, (byte) 68, (byte) 32, (byte) 185, (byte) 112, (byte) 66, (byte) 73, (byte) 18, (byte) 51, (byte) 251, (byte) 51, (byte) 22, (byte) 135};

        public CuboidDirection opposite() {
            switch (ordinal()) {
                case 0:
                    return South;
                case 1:
                    return West;
                case 2:
                    return North;
                case 3:
                    return East;
                case 4:
                    return Down;
                case 5:
                    return Up;
                case 6:
                    return Vertical;
                case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                    return Horizontal;
                case 8:
                    return Both;
                default:
                    return Unknown;
            }
        }

        private static String WYx4NVKIqyrHMvN9bo6Iae() {
        return "North";
    }

        private static String ui80m7FaMmUd3TNI5Di() {
        return "East";
    }

        private static String Rz5YYVwtZIaKeA() {
        return "South";
    }

        private static String GchOdIWyhHWa6P() {
        return "West";
    }

        private static String sBHdjNu46YfWEenaRE0() {
        return "Up";
    }

        private static String Cn1K0N22ZSbtPaiw() {
        return "Down";
    }

        private static String peoC7eol5txQ46lDtdH() {
        return "Horizontal";
    }

        private static String DixAD7tCzLeCNCOUC() {
        return "Vertical";
    }

        private static String sji21KfdOpWPnvTZm() {
        return "Both";
    }

        private static String WWUVsSKxHJcMihDCMOco() {
        return "Unknown";
    }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Cuboid$CuboidIterator.class */
    public class CuboidIterator implements Iterator<Block> {
        private World w;
        private int baseX;
        private int baseY;
        private int baseZ;
        private int sizeX;
        private int sizeY;
        private int sizeZ;
        private int z = 0;
        private int y = 0;
        private int x = 0;

        public CuboidIterator(World world, int i, int i2, int i3, int i4, int i5, int i6) {
            this.w = world;
            this.baseX = i;
            this.baseY = i2;
            this.baseZ = i3;
            this.sizeX = Math.abs(i4 - i) + 1;
            this.sizeY = Math.abs(i5 - i2) + 1;
            this.sizeZ = Math.abs(i6 - i3) + 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.x < this.sizeX && this.y < this.sizeY && this.z < this.sizeZ;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Block next() {
            Block blockAt = this.w.getBlockAt(this.baseX + this.x, this.baseY + this.y, this.baseZ + this.z);
            int i = this.x + 1;
            this.x = i;
            if (i >= this.sizeX) {
                this.x = 0;
                int i2 = this.y + 1;
                this.y = i2;
                if (i2 >= this.sizeY) {
                    this.y = 0;
                    this.z++;
                }
            }
            return blockAt;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    public Cuboid(Location location, Location location2) {
        if (!location.getWorld().equals(location2.getWorld())) {
            throw new IllegalArgumentException(GjirwM0q0di8Ka());
        }
        this.worldName = location.getWorld().getName();
        this.x1 = Math.min(location.getBlockX(), location2.getBlockX());
        this.y1 = Math.min(location.getBlockY(), location2.getBlockY());
        this.z1 = Math.min(location.getBlockZ(), location2.getBlockZ());
        this.x2 = Math.max(location.getBlockX(), location2.getBlockX());
        this.y2 = Math.max(location.getBlockY(), location2.getBlockY());
        this.z2 = Math.max(location.getBlockZ(), location2.getBlockZ());
    }

    public Cuboid(Location location) {
        this(location, location);
    }

    public Cuboid(Cuboid cuboid) {
        this(cuboid.getWorld().getName(), cuboid.x1, cuboid.y1, cuboid.z1, cuboid.x2, cuboid.y2, cuboid.z2);
    }

    public Cuboid(World world, int i, int i2, int i3, int i4, int i5, int i6) {
        this.worldName = world.getName();
        this.x1 = Math.min(i, i4);
        this.x2 = Math.max(i, i4);
        this.y1 = Math.min(i2, i5);
        this.y2 = Math.max(i2, i5);
        this.z1 = Math.min(i3, i6);
        this.z2 = Math.max(i3, i6);
    }

    private Cuboid(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        this.worldName = str;
        this.x1 = Math.min(i, i4);
        this.x2 = Math.max(i, i4);
        this.y1 = Math.min(i2, i5);
        this.y2 = Math.max(i2, i5);
        this.z1 = Math.min(i3, i6);
        this.z2 = Math.max(i3, i6);
    }

    public Cuboid(Map<String, Object> map) {
        this.worldName = (String) map.get(y9bQxF40EYSuE7DG7());
        this.x1 = ((Integer) map.get(yuY15rdhPAPbeI0fLUWAl())).intValue();
        this.x2 = ((Integer) map.get(tC8yJif5vWO1eGSNk14())).intValue();
        this.y1 = ((Integer) map.get(sfLkWtr9fkrhW2dgt())).intValue();
        this.y2 = ((Integer) map.get(tgde49YbIyCFGiGqvy())).intValue();
        this.z1 = ((Integer) map.get(UFRRuNf3zrk2C1CBfnImPe())).intValue();
        this.z2 = ((Integer) map.get(YlWAs6Bw2f67pyowIlxF1())).intValue();
    }

    public Map<String, Object> serialize() {
        HashMap map = new HashMap();
        map.put(Agq1vAPIQkAhZps(), this.worldName);
        map.put(NCpAuv571k7zHkI2AmQw2W(), Integer.valueOf(this.x1));
        map.put(nOAAy72P5qou9Nh(), Integer.valueOf(this.y1));
        map.put(qHO0osahz6wnpRBXzbPG(), Integer.valueOf(this.z1));
        map.put(PBBX93Z0pwkeml(), Integer.valueOf(this.x2));
        map.put(EKAOd21PMkdzjBGEF(), Integer.valueOf(this.y2));
        map.put(lwry61iP7fe2DBPvoKRtt(), Integer.valueOf(this.z2));
        return map;
    }

    public Location getLowerNE() {
        return new Location(getWorld(), this.x1, this.y1, this.z1);
    }

    public Location getUpperSW() {
        return new Location(getWorld(), this.x2, this.y2, this.z2);
    }

    public List<Block> getBlocks() {
        Iterator<Block> it = iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public Location getCenter() {
        return new Location(getWorld(), ((double) getLowerX()) + (((double) ((getUpperX() + 1) - getLowerX())) / 2.0d), ((double) getLowerY()) + (((double) ((getUpperY() + 1) - getLowerY())) / 2.0d), ((double) getLowerZ()) + (((double) ((getUpperZ() + 1) - getLowerZ())) / 2.0d));
    }

    public World getWorld() {
        World world = Bukkit.getWorld(this.worldName);
        if (world == null) {
            throw new IllegalStateException("World '" + this.worldName + "' is not loaded");
        }
        return world;
    }

    public int getSizeX() {
        return (this.x2 - this.x1) + 1;
    }

    public int getSizeY() {
        return (this.y2 - this.y1) + 1;
    }

    public int getSizeZ() {
        return (this.z2 - this.z1) + 1;
    }

    public int getLowerX() {
        return this.x1;
    }

    public int getLowerY() {
        return this.y1;
    }

    public int getLowerZ() {
        return this.z1;
    }

    public int getUpperX() {
        return this.x2;
    }

    public int getUpperY() {
        return this.y2;
    }

    public int getUpperZ() {
        return this.z2;
    }

    public Block[] corners() {
        World world = getWorld();
        return new Block[]{world.getBlockAt(this.x1, this.y1, this.z1), world.getBlockAt(this.x1, this.y1, this.z2), world.getBlockAt(this.x1, this.y2, this.z1), world.getBlockAt(this.x1, this.y2, this.z2), world.getBlockAt(this.x2, this.y1, this.z1), world.getBlockAt(this.x2, this.y1, this.z2), world.getBlockAt(this.x2, this.y2, this.z1), world.getBlockAt(this.x2, this.y2, this.z2)};
    }

    public Cuboid expand(CuboidDirection cuboidDirection, int i) {
        switch (cuboidDirection) {
            case North:
                return new Cuboid(this.worldName, this.x1 - i, this.y1, this.z1, this.x2, this.y2, this.z2);
            case East:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1 - i, this.x2, this.y2, this.z2);
            case South:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2 + i, this.y2, this.z2);
            case West:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2, this.y2, this.z2 + i);
            case Up:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2, this.y2 + i, this.z2);
            case Down:
                return new Cuboid(this.worldName, this.x1, this.y1 - i, this.z1, this.x2, this.y2, this.z2);
            default:
                throw new IllegalArgumentException("Invalid direction " + String.valueOf(cuboidDirection));
        }
    }

    public Cuboid shift(CuboidDirection cuboidDirection, int i) {
        return expand(cuboidDirection, i).expand(cuboidDirection.opposite(), -i);
    }

    public Cuboid outset(CuboidDirection cuboidDirection, int i) {
        Cuboid cuboidOutset;
        switch (cuboidDirection.ordinal()) {
            case 6:
                cuboidOutset = expand(CuboidDirection.North, i).expand(CuboidDirection.South, i).expand(CuboidDirection.East, i).expand(CuboidDirection.West, i);
                break;
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                cuboidOutset = expand(CuboidDirection.Down, i).expand(CuboidDirection.Up, i);
                break;
            case 8:
                cuboidOutset = outset(CuboidDirection.Horizontal, i).outset(CuboidDirection.Vertical, i);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction " + String.valueOf(cuboidDirection));
        }
        return cuboidOutset;
    }

    public Cuboid inset(CuboidDirection cuboidDirection, int i) {
        return outset(cuboidDirection, -i);
    }

    public boolean contains(int i, int i2, int i3) {
        return i >= this.x1 && i <= this.x2 && i2 >= this.y1 && i2 <= this.y2 && i3 >= this.z1 && i3 <= this.z2;
    }

    public boolean contains(Block block) {
        return contains(block.getLocation());
    }

    public boolean contains(Location location) {
        if (this.worldName.equals(location.getWorld().getName())) {
            return contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        }
        return false;
    }

    public int getVolume() {
        return getSizeX() * getSizeY() * getSizeZ();
    }

    public byte getAverageLightLevel() {
        long lightLevel = 0;
        int i = 0;
        for (Block block : this) {
            if (block.isEmpty()) {
                lightLevel += (long) block.getLightLevel();
                i++;
            }
        }
        if (i > 0) {
            return (byte) (lightLevel / ((long) i));
        }
        return (byte) 0;
    }

    public Cuboid contract() {
        return contract(CuboidDirection.Down).contract(CuboidDirection.South).contract(CuboidDirection.East).contract(CuboidDirection.Up).contract(CuboidDirection.North).contract(CuboidDirection.West);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Cuboid contract(CuboidDirection cuboidDirection) {
        Cuboid face = getFace(cuboidDirection.opposite());
        switch (cuboidDirection) {
            case North:
                while (face.containsOnly(Material.AIR) && face.getLowerX() > getLowerX()) {
                    face = face.shift(CuboidDirection.North, 1);
                }
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, face.getUpperX(), this.y2, this.z2);
            case East:
                while (face.containsOnly(Material.AIR) && face.getLowerZ() > getLowerZ()) {
                    face = face.shift(CuboidDirection.East, 1);
                }
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2, this.y2, face.getUpperZ());
            case South:
                while (face.containsOnly(Material.AIR) && face.getUpperX() < getUpperX()) {
                    face = face.shift(CuboidDirection.South, 1);
                }
                return new Cuboid(this.worldName, face.getLowerX(), this.y1, this.z1, this.x2, this.y2, this.z2);
            case West:
                while (face.containsOnly(Material.AIR) && face.getUpperZ() < getUpperZ()) {
                    face = face.shift(CuboidDirection.West, 1);
                }
                return new Cuboid(this.worldName, this.x1, this.y1, face.getLowerZ(), this.x2, this.y2, this.z2);
            case Up:
                while (face.containsOnly(Material.AIR) && face.getUpperY() < getUpperY()) {
                    face = face.shift(CuboidDirection.Up, 1);
                }
                return new Cuboid(this.worldName, this.x1, face.getLowerY(), this.z1, this.x2, this.y2, this.z2);
            case Down:
                while (face.containsOnly(Material.AIR) && face.getLowerY() > getLowerY()) {
                    face = face.shift(CuboidDirection.Down, 1);
                }
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2, face.getUpperY(), this.z2);
            default:
                throw new IllegalArgumentException("Invalid direction " + String.valueOf(cuboidDirection));
        }
    }

    public Cuboid getFace(CuboidDirection cuboidDirection) {
        switch (cuboidDirection) {
            case North:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x1, this.y2, this.z2);
            case East:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2, this.y2, this.z1);
            case South:
                return new Cuboid(this.worldName, this.x2, this.y1, this.z1, this.x2, this.y2, this.z2);
            case West:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z2, this.x2, this.y2, this.z2);
            case Up:
                return new Cuboid(this.worldName, this.x1, this.y2, this.z1, this.x2, this.y2, this.z2);
            case Down:
                return new Cuboid(this.worldName, this.x1, this.y1, this.z1, this.x2, this.y1, this.z2);
            default:
                throw new IllegalArgumentException("Invalid direction " + String.valueOf(cuboidDirection));
        }
    }

    public boolean containsOnly(Material material) {
        Iterator<Block> it = iterator();
        while (it.hasNext()) {
            if (it.next().getType() != material) {
                return false;
            }
        }
        return true;
    }

    public Cuboid getBoundingCuboid(Cuboid cuboid) {
        if (cuboid == null) {
            return this;
        }
        return new Cuboid(this.worldName, Math.min(getLowerX(), cuboid.getLowerX()), Math.min(getLowerY(), cuboid.getLowerY()), Math.min(getLowerZ(), cuboid.getLowerZ()), Math.max(getUpperX(), cuboid.getUpperX()), Math.max(getUpperY(), cuboid.getUpperY()), Math.max(getUpperZ(), cuboid.getUpperZ()));
    }

    public Block getRelativeBlock(int i, int i2, int i3) {
        return getWorld().getBlockAt(this.x1 + i, this.y1 + i2, this.z1 + i3);
    }

    public Block getRelativeBlock(World world, int i, int i2, int i3) {
        return world.getBlockAt(this.x1 + i, this.y1 + i2, this.z1 + i3);
    }

    public List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        World world = getWorld();
        int lowerX = getLowerX() & (-16);
        int upperX = getUpperX() & (-16);
        int lowerZ = getLowerZ() & (-16);
        int upperZ = getUpperZ() & (-16);
        for (int i = lowerX; i <= upperX; i += 16) {
            for (int i2 = lowerZ; i2 <= upperZ; i2 += 16) {
                arrayList.add(world.getChunkAt(i >> 4, i2 >> 4));
            }
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public Iterator<Block> iterator() {
        return new CuboidIterator(getWorld(), this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Cuboid m968clone() {
        return new Cuboid(this);
    }

    public String toString() {
        return new String("Cuboid: " + this.worldName + "," + this.x1 + "," + this.y1 + "," + this.z1 + "=>" + this.x2 + "," + this.y2 + "," + this.z2);
    }

    private static String HKJvWusuZNVVT2rFLQxLPB(byte[] bArr) {
        return "";
    }

    private static String GjirwM0q0di8Ka() {
        return "Locations must be on the same world";
    }

    private static String y9bQxF40EYSuE7DG7() {
        return "worldName";
    }

    private static String yuY15rdhPAPbeI0fLUWAl() {
        return "x1";
    }

    private static String tC8yJif5vWO1eGSNk14() {
        return "x2";
    }

    private static String sfLkWtr9fkrhW2dgt() {
        return "y1";
    }

    private static String tgde49YbIyCFGiGqvy() {
        return "y2";
    }

    private static String UFRRuNf3zrk2C1CBfnImPe() {
        return "z1";
    }

    private static String YlWAs6Bw2f67pyowIlxF1() {
        return "z2";
    }

    private static String Agq1vAPIQkAhZps() {
        return "worldName";
    }

    private static String NCpAuv571k7zHkI2AmQw2W() {
        return "x1";
    }

    private static String nOAAy72P5qou9Nh() {
        return "y1";
    }

    private static String qHO0osahz6wnpRBXzbPG() {
        return "z1";
    }

    private static String PBBX93Z0pwkeml() {
        return "x2";
    }

    private static String EKAOd21PMkdzjBGEF() {
        return "y2";
    }

    private static String lwry61iP7fe2DBPvoKRtt() {
        return "z2";
    }
}
