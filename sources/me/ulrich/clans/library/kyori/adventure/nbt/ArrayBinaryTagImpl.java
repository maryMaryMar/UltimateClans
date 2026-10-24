package me.ulrich.clans.library.kyori.adventure.nbt;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ArrayBinaryTagImpl.class */
abstract class ArrayBinaryTagImpl extends AbstractBinaryTag implements ArrayBinaryTag {
    ArrayBinaryTagImpl() {
    }

    static void checkIndex(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        }
    }
}
