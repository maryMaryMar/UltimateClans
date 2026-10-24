package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/StorageNBTComponent.class */
public interface StorageNBTComponent extends NBTComponent<StorageNBTComponent, Builder>, ScopedComponent<StorageNBTComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/StorageNBTComponent$Builder.class */
    public interface Builder extends NBTComponentBuilder<StorageNBTComponent, Builder> {
        @Contract("_ -> this")
        @NotNull
        Builder storage(@NotNull Key key);
    }

    @NotNull
    Key storage();

    @Contract(pure = true)
    @NotNull
    StorageNBTComponent storage(@NotNull Key key);

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent, me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("storage", storage())), super.examinableProperties());
    }
}
