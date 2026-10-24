package me.ulrich.clans.library.kyori.adventure.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/inventory/Book.class */
@ApiStatus.NonExtendable
public interface Book extends Buildable<Book, Builder>, Examinable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/inventory/Book$Builder.class */
    public interface Builder extends AbstractBuilder<Book>, Buildable.Builder<Book> {
        @Contract("_ -> this")
        @NotNull
        Builder title(@NotNull Component component);

        @Contract("_ -> this")
        @NotNull
        Builder author(@NotNull Component component);

        @Contract("_ -> this")
        @NotNull
        Builder addPage(@NotNull Component component);

        @Contract("_ -> this")
        @NotNull
        Builder pages(@NotNull Component... componentArr);

        @Contract("_ -> this")
        @NotNull
        Builder pages(@NotNull Collection<Component> collection);

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        Book build2();
    }

    @NotNull
    static Book book(@NotNull Component component, @NotNull Component component2, @NotNull Collection<Component> collection) {
        return new BookImpl(component, component2, new ArrayList(collection));
    }

    @NotNull
    static Book book(@NotNull Component component, @NotNull Component component2, @NotNull Component... componentArr) {
        return book(component, component2, Arrays.asList(componentArr));
    }

    @NotNull
    static Builder builder() {
        return new BookImpl.BuilderImpl();
    }

    @NotNull
    Component title();

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    Book title(@NotNull Component component);

    @NotNull
    Component author();

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    Book author(@NotNull Component component);

    @NotNull
    List<Component> pages();

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    default Book pages(@NotNull Component... componentArr) {
        return pages(Arrays.asList(componentArr));
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    Book pages(@NotNull List<Component> list);

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    default Builder mo683toBuilder() {
        return builder().title(title()).author(author()).pages(pages());
    }
}
