package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/EntityNBTComponent.class */
public interface EntityNBTComponent extends NBTComponent<EntityNBTComponent, Builder>, ScopedComponent<EntityNBTComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/EntityNBTComponent$Builder.class */
    public interface Builder extends NBTComponentBuilder<EntityNBTComponent, Builder> {
        @Contract("_ -> this")
        @NotNull
        Builder selector(@NotNull String str);
    }

    @NotNull
    String selector();

    @Contract(pure = true)
    @NotNull
    EntityNBTComponent selector(@NotNull String str);

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent, me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("selector", selector())), super.examinableProperties());
    }
}
