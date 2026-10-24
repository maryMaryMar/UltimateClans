package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.BuildableComponent;
import me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/AbstractComponentBuilder.class */
abstract class AbstractComponentBuilder<C extends BuildableComponent<C, B>, B extends ComponentBuilder<C, B>> implements ComponentBuilder<C, B> {
    protected List<Component> children;

    @Nullable
    private Style style;
    private Style.Builder styleBuilder;

    protected AbstractComponentBuilder() {
        this.children = Collections.emptyList();
    }

    protected AbstractComponentBuilder(@NotNull C c) {
        this.children = Collections.emptyList();
        List<Component> listChildren = c.children();
        if (!listChildren.isEmpty()) {
            this.children = new ArrayList(listChildren);
        }
        if (c.hasStyling()) {
            this.style = c.style();
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B append(@NotNull Component component) {
        if (component == Component.empty()) {
            return this;
        }
        prepareChildren();
        this.children.add((Component) Objects.requireNonNull(component, "component"));
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B append(@NotNull Component... componentArr) {
        return (B) append((ComponentLike[]) componentArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B append(@NotNull ComponentLike... componentLikeArr) {
        Objects.requireNonNull(componentLikeArr, "components");
        boolean z = false;
        for (ComponentLike componentLike : componentLikeArr) {
            Component componentAsComponent = ((ComponentLike) Objects.requireNonNull(componentLike, "components[?]")).asComponent();
            if (componentAsComponent != Component.empty()) {
                if (!z) {
                    prepareChildren();
                    z = true;
                }
                this.children.add((Component) Objects.requireNonNull(componentAsComponent, "components[?]"));
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B append(@NotNull Iterable<? extends ComponentLike> iterable) {
        Objects.requireNonNull(iterable, "components");
        boolean z = false;
        Iterator<? extends ComponentLike> it = iterable.iterator();
        while (it.hasNext()) {
            Component componentAsComponent = ((ComponentLike) Objects.requireNonNull(it.next(), "components[?]")).asComponent();
            if (componentAsComponent != Component.empty()) {
                if (!z) {
                    prepareChildren();
                    z = true;
                }
                this.children.add((Component) Objects.requireNonNull(componentAsComponent, "components[?]"));
            }
        }
        return this;
    }

    private void prepareChildren() {
        if (this.children == Collections.emptyList()) {
            this.children = new ArrayList();
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B applyDeep(@NotNull Consumer<? super ComponentBuilder<?, ?>> consumer) {
        apply(consumer);
        if (this.children == Collections.emptyList()) {
            return this;
        }
        ListIterator<Component> listIterator = this.children.listIterator();
        while (listIterator.hasNext()) {
            Component next = listIterator.next();
            if (next instanceof BuildableComponent) {
                ComponentBuilder componentBuilderMo683toBuilder = ((BuildableComponent) next).mo683toBuilder();
                componentBuilderMo683toBuilder.applyDeep(consumer);
                listIterator.set(componentBuilderMo683toBuilder.build2());
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B mapChildren(@NotNull Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> function) {
        BuildableComponent buildableComponent;
        if (this.children == Collections.emptyList()) {
            return this;
        }
        ListIterator<Component> listIterator = this.children.listIterator();
        while (listIterator.hasNext()) {
            Component next = listIterator.next();
            if ((next instanceof BuildableComponent) && next != (buildableComponent = (BuildableComponent) Objects.requireNonNull(function.apply((BuildableComponent) next), "mappedChild"))) {
                listIterator.set(buildableComponent);
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B mapChildrenDeep(@NotNull Function<BuildableComponent<?, ?>, ? extends BuildableComponent<?, ?>> function) {
        if (this.children == Collections.emptyList()) {
            return this;
        }
        ListIterator<Component> listIterator = this.children.listIterator();
        while (listIterator.hasNext()) {
            Component next = listIterator.next();
            if (next instanceof BuildableComponent) {
                BuildableComponent buildableComponent = (BuildableComponent) Objects.requireNonNull(function.apply((BuildableComponent) next), "mappedChild");
                if (!buildableComponent.children().isEmpty()) {
                    ComponentBuilder componentBuilderMo683toBuilder = buildableComponent.mo683toBuilder();
                    componentBuilderMo683toBuilder.mapChildrenDeep(function);
                    listIterator.set(componentBuilderMo683toBuilder.build2());
                } else if (next != buildableComponent) {
                    listIterator.set(buildableComponent);
                }
            }
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public List<Component> children() {
        return Collections.unmodifiableList(this.children);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B style(@NotNull Style style) {
        this.style = style;
        this.styleBuilder = null;
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B style(@NotNull Consumer<Style.Builder> consumer) {
        consumer.accept(styleBuilder());
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B font(@Nullable Key key) {
        styleBuilder().font(key);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B color(@Nullable TextColor textColor) {
        styleBuilder().color(textColor);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B colorIfAbsent(@Nullable TextColor textColor) {
        styleBuilder().colorIfAbsent(textColor);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B shadowColor(@Nullable ARGBLike aRGBLike) {
        styleBuilder().shadowColor(aRGBLike);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B shadowColorIfAbsent(@Nullable ARGBLike aRGBLike) {
        styleBuilder().shadowColorIfAbsent(aRGBLike);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        styleBuilder().decoration(textDecoration, state);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        styleBuilder().decorationIfAbsent(textDecoration, state);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B clickEvent(@Nullable ClickEvent clickEvent) {
        styleBuilder().clickEvent(clickEvent);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B hoverEvent(@Nullable HoverEventSource<?> hoverEventSource) {
        styleBuilder().hoverEvent(hoverEventSource);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public B insertion(@Nullable String str) {
        styleBuilder().insertion(str);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B mergeStyle(@NotNull Component component, @NotNull Set<Style.Merge> set) {
        Style style = ((Component) Objects.requireNonNull(component, "that")).style();
        if (style.isEmpty() && set.isEmpty()) {
            return this;
        }
        styleBuilder().merge(style, set);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder
    @NotNull
    public B resetStyle() {
        this.style = null;
        this.styleBuilder = null;
        return this;
    }

    private Style.Builder styleBuilder() {
        if (this.styleBuilder == null) {
            if (this.style != null) {
                this.styleBuilder = this.style.mo683toBuilder();
                this.style = null;
            } else {
                this.styleBuilder = Style.style();
            }
        }
        return this.styleBuilder;
    }

    protected final boolean hasStyle() {
        return (this.styleBuilder == null && this.style == null) ? false : true;
    }

    @NotNull
    protected Style buildStyle() {
        if (this.styleBuilder != null) {
            return this.styleBuilder.build2();
        }
        return this.style != null ? this.style : Style.empty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    public /* bridge */ /* synthetic */ StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
        return hoverEvent((HoverEventSource<?>) hoverEventSource);
    }
}
