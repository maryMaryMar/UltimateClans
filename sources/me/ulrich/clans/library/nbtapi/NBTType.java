package me.ulrich.clans.library.nbtapi;


/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTType.class */
public enum NBTType {
    NBTTagEnd(0, ""),
    NBTTagByte(1, "BYTE"),
    NBTTagShort(2, "SHORT"),
    NBTTagInt(3, "INT"),
    NBTTagLong(4, "LONG"),
    NBTTagFloat(5, "FLOAT"),
    NBTTagDouble(6, "DOUBLE"),
    NBTTagByteArray(7, "BYTE[]"),
    NBTTagString(8, "STRING"),
    NBTTagList(9, "LIST"),
    NBTTagCompound(10, "COMPOUND"),
    NBTTagIntArray(11, "INT[]"),
    NBTTagLongArray(12, "LONG[]");

    private final int id;
    private final String name;

    NBTType(int i, String str) {
        this.id = i;
        this.name = str;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static NBTType valueOf(int i) {
        for (NBTType nBTType : values()) {
            if (nBTType.getId() == i) {
                return nBTType;
            }
        }
        return NBTTagEnd;
    }

    public static NBTType fromName(String str) {
        for (NBTType nBTType : values()) {
            if (nBTType.getName().equals(str)) {
                return nBTType;
            }
        }
        return NBTTagEnd;
    }
}
