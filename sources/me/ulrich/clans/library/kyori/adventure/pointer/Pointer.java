package me.ulrich.clans.library.kyori.adventure.pointer;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/pointer/Pointer.class */
@ApiStatus.NonExtendable
public interface Pointer<V> extends Examinable {
    @NotNull
    static <V> Pointer<V> pointer(@NotNull Class<V> cls, @NotNull Key key) {
        return new PointerImpl(cls, key);
    }

    @NotNull
    Class<V> type();

    @NotNull
    Key key();

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("type", type()), ExaminableProperty.of(KeybindTag.KEYBIND, key())});
    }
}
