package me.ulrich.clans.library.kyori.adventure.text.event;

import me.ulrich.clans.library.kyori.adventure.nbt.api.BinaryTagHolder;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValue.class */
public interface DataComponentValue extends Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValue$Removed.class */
    public interface Removed extends DataComponentValue {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/event/DataComponentValue$TagSerializable.class */
    public interface TagSerializable extends DataComponentValue {
        @NotNull
        BinaryTagHolder asBinaryTag();
    }

    static Removed removed() {
        return RemovedDataComponentValueImpl.REMOVED;
    }
}
