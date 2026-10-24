package me.ulrich.clans.library.kyori.adventure.text;

import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.object.ObjectContents;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ObjectComponent.class */
public interface ObjectComponent extends BuildableComponent<ObjectComponent, Builder>, ScopedComponent<ObjectComponent> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ObjectComponent$Builder.class */
    public interface Builder extends ComponentBuilder<ObjectComponent, Builder> {
        @NotNull
        Builder contents(@NotNull ObjectContents objectContents);
    }

    @NotNull
    ObjectContents contents();

    @NotNull
    ObjectComponent contents(@NotNull ObjectContents objectContents);

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(Stream.of(ExaminableProperty.of("contents", contents())), super.examinableProperties());
    }
}
