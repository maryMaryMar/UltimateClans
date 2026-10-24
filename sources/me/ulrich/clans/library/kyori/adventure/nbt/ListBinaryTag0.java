package me.ulrich.clans.library.kyori.adventure.nbt;

import java.util.Collections;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/ListBinaryTag0.class */
final class ListBinaryTag0 {
    private static final String WRAPPER_KEY = "";

    private ListBinaryTag0() {
    }

    static BinaryTag unbox(CompoundBinaryTag compoundBinaryTag) {
        BinaryTag binaryTag;
        return (compoundBinaryTag.size() != 1 || (binaryTag = compoundBinaryTag.get("")) == null) ? compoundBinaryTag : binaryTag;
    }

    static CompoundBinaryTag box(BinaryTag binaryTag) {
        return binaryTag instanceof CompoundBinaryTag ? (CompoundBinaryTag) binaryTag : new CompoundBinaryTagImpl(Collections.singletonMap("", binaryTag));
    }
}
