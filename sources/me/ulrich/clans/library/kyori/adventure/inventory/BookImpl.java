package me.ulrich.clans.library.kyori.adventure.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.commons.ComponentTreeConstants;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/inventory/BookImpl.class */
final class BookImpl implements Book {
    private final Component title;
    private final Component author;
    private final List<Component> pages;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/inventory/BookImpl$BuilderImpl.class */
    static final class BuilderImpl implements Book.Builder {
        private Component title = Component.empty();
        private Component author = Component.empty();
        private final List<Component> pages = new ArrayList();

        BuilderImpl() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book.Builder
        @NotNull
        public Book.Builder title(@NotNull Component component) {
            this.title = (Component) Objects.requireNonNull(component, "title");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book.Builder
        @NotNull
        public Book.Builder author(@NotNull Component component) {
            this.author = (Component) Objects.requireNonNull(component, "author");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book.Builder
        @NotNull
        public Book.Builder addPage(@NotNull Component component) {
            this.pages.add((Component) Objects.requireNonNull(component, ComponentTreeConstants.CLICK_EVENT_PAGE));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book.Builder
        @NotNull
        public Book.Builder pages(@NotNull Collection<Component> collection) {
            this.pages.addAll((Collection) Objects.requireNonNull(collection, "pages"));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book.Builder
        @NotNull
        public Book.Builder pages(@NotNull Component... componentArr) {
            Collections.addAll(this.pages, componentArr);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book.Builder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public Book build2() {
            return new BookImpl(this.title, this.author, new ArrayList(this.pages));
        }
    }

    BookImpl(@NotNull Component component, @NotNull Component component2, @NotNull List<Component> list) {
        this.title = (Component) Objects.requireNonNull(component, "title");
        this.author = (Component) Objects.requireNonNull(component2, "author");
        this.pages = Collections.unmodifiableList((List) Objects.requireNonNull(list, "pages"));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book
    @NotNull
    public Component title() {
        return this.title;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book
    @NotNull
    public Book title(@NotNull Component component) {
        return new BookImpl((Component) Objects.requireNonNull(component, "title"), this.author, this.pages);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book
    @NotNull
    public Component author() {
        return this.author;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book
    @NotNull
    public Book author(@NotNull Component component) {
        return new BookImpl(this.title, (Component) Objects.requireNonNull(component, "author"), this.pages);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book
    @NotNull
    public List<Component> pages() {
        return this.pages;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.inventory.Book
    @NotNull
    public Book pages(@NotNull List<Component> list) {
        return new BookImpl(this.title, this.author, new ArrayList((Collection) Objects.requireNonNull(list, "pages")));
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("title", this.title), ExaminableProperty.of("author", this.author), ExaminableProperty.of("pages", this.pages)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookImpl)) {
            return false;
        }
        BookImpl bookImpl = (BookImpl) obj;
        return this.title.equals(bookImpl.title) && this.author.equals(bookImpl.author) && this.pages.equals(bookImpl.pages);
    }

    public int hashCode() {
        return (31 * ((31 * this.title.hashCode()) + this.author.hashCode())) + this.pages.hashCode();
    }

    public String toString() {
        return Internals.toString(this);
    }
}
