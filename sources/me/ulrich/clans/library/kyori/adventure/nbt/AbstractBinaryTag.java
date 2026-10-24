package me.ulrich.clans.library.kyori.adventure.nbt;

import me.ulrich.clans.library.kyori.examination.string.StringExaminer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/nbt/AbstractBinaryTag.class */
abstract class AbstractBinaryTag implements BinaryTag {
    AbstractBinaryTag() {
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public final String examinableName() {
        return type().toString();
    }

    public final String toString() {
        return (String) examine(StringExaminer.simpleEscaping());
    }
}
