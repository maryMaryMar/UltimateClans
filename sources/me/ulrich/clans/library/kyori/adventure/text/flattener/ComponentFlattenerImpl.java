package me.ulrich.clans.library.kyori.adventure.text.flattener;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.internal.properties.AdventureProperties;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.KeybindComponent;
import me.ulrich.clans.library.kyori.adventure.text.ObjectComponent;
import me.ulrich.clans.library.kyori.adventure.text.ScoreComponent;
import me.ulrich.clans.library.kyori.adventure.text.SelectorComponent;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.object.ObjectContents;
import me.ulrich.clans.library.kyori.adventure.text.object.PlayerHeadObjectContents;
import me.ulrich.clans.library.kyori.adventure.text.object.SpriteObjectContents;
import me.ulrich.clans.library.kyori.adventure.util.InheritanceAwareMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/ComponentFlattenerImpl.class */
final class ComponentFlattenerImpl implements ComponentFlattener {
    static final ComponentFlattener BASIC = new BuilderImpl().mapper(KeybindComponent.class, keybindComponent -> {
        return keybindComponent.keybind();
    }).mapper(ScoreComponent.class, scoreComponent -> {
        String strValue = scoreComponent.value();
        return strValue != null ? strValue : "";
    }).mapper(SelectorComponent.class, (v0) -> {
        return v0.pattern();
    }).mapper(TextComponent.class, (v0) -> {
        return v0.content();
    }).mapper(TranslatableComponent.class, translatableComponent -> {
        String strFallback = translatableComponent.fallback();
        return strFallback != null ? strFallback : translatableComponent.key();
    }).mapper(ObjectComponent.class, objectComponent -> {
        ObjectContents objectContentsContents = objectComponent.contents();
        if (objectContentsContents instanceof SpriteObjectContents) {
            SpriteObjectContents spriteObjectContents = (SpriteObjectContents) objectContentsContents;
            Key keyAtlas = spriteObjectContents.atlas();
            return "[" + spriteObjectContents.sprite().asMinimalString() + (!keyAtlas.equals(SpriteObjectContents.DEFAULT_ATLAS) ? "@" + keyAtlas.asMinimalString() : "") + "]";
        }
        if (!(objectContentsContents instanceof PlayerHeadObjectContents)) {
            return "";
        }
        PlayerHeadObjectContents playerHeadObjectContents = (PlayerHeadObjectContents) objectContentsContents;
        return "[" + (playerHeadObjectContents.name() != null ? playerHeadObjectContents.name() : "unknown player") + " head]";
    }).build2();
    static final ComponentFlattener TEXT_ONLY = new BuilderImpl().mapper(TextComponent.class, (v0) -> {
        return v0.content();
    }).build2();
    private static final int MAX_DEPTH = 512;
    private final InheritanceAwareMap<Component, Handler> flatteners;
    private final Function<Component, String> unknownHandler;
    private final int maxNestedDepth;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/ComponentFlattenerImpl$BuilderImpl.class */
    static final class BuilderImpl implements ComponentFlattener.Builder {
        private final InheritanceAwareMap.Builder<Component, Handler> flatteners;

        @Nullable
        private Function<Component, String> unknownHandler;
        private int maxNestedDepth;

        BuilderImpl() {
            this.maxNestedDepth = AdventureProperties.DEFAULT_FLATTENER_NESTING_LIMIT.valueOr(-1).intValue();
            this.flatteners = InheritanceAwareMap.builder().strict(true);
        }

        BuilderImpl(InheritanceAwareMap<Component, Handler> inheritanceAwareMap, @Nullable Function<Component, String> function, int i) {
            this.maxNestedDepth = AdventureProperties.DEFAULT_FLATTENER_NESTING_LIMIT.valueOr(-1).intValue();
            this.flatteners = InheritanceAwareMap.builder(inheritanceAwareMap).strict(true);
            this.unknownHandler = function;
            this.maxNestedDepth = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public ComponentFlattener build2() {
            return new ComponentFlattenerImpl(this.flatteners.build2(), this.unknownHandler, this.maxNestedDepth);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener.Builder
        public <T extends Component> ComponentFlattener.Builder mapper(@NotNull Class<T> cls, @NotNull Function<T, String> function) {
            this.flatteners.put(cls, (componentFlattenerImpl, component, flattenerListener, i, i2) -> {
                flattenerListener.component((String) function.apply(component));
            });
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener.Builder
        public <T extends Component> ComponentFlattener.Builder complexMapper(@NotNull Class<T> cls, @NotNull BiConsumer<T, Consumer<Component>> biConsumer) {
            this.flatteners.put(cls, (componentFlattenerImpl, component, flattenerListener, i, i2) -> {
                biConsumer.accept(component, component -> {
                    componentFlattenerImpl.flatten0(component, flattenerListener, i, i2 + 1);
                });
            });
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener.Builder
        public ComponentFlattener.Builder unknownMapper(@Nullable Function<Component, String> function) {
            this.unknownHandler = function;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener.Builder
        @NotNull
        public ComponentFlattener.Builder nestingLimit(int i) {
            if (i != -1 && i < 1) {
                throw new IllegalArgumentException("limit must be positive or ComponentFlattener.NO_NESTING_LIMIT");
            }
            this.maxNestedDepth = i;
            return this;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/ComponentFlattenerImpl$Handler.class */
    @FunctionalInterface
    interface Handler {
        void handle(ComponentFlattenerImpl componentFlattenerImpl, Component component, FlattenerListener flattenerListener, int i, int i2);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/ComponentFlattenerImpl$StackEntry.class */
    private static final class StackEntry {
        final Component component;
        final int depth;
        final int stylesToPop;

        StackEntry(Component component, int i, int i2) {
            this.component = component;
            this.depth = i;
            this.stylesToPop = i2;
        }
    }

    ComponentFlattenerImpl(InheritanceAwareMap<Component, Handler> inheritanceAwareMap, @Nullable Function<Component, String> function, int i) {
        this.flatteners = inheritanceAwareMap;
        this.unknownHandler = function;
        this.maxNestedDepth = i;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener
    public void flatten(@NotNull Component component, @NotNull FlattenerListener flattenerListener) {
        flatten0(component, flattenerListener, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flatten0(@NotNull Component component, @NotNull FlattenerListener flattenerListener, int i, int i2) {
        Objects.requireNonNull(component, "input");
        Objects.requireNonNull(flattenerListener, "listener");
        if (component == Component.empty()) {
            return;
        }
        if (this.maxNestedDepth != -1 && i2 > this.maxNestedDepth) {
            throw new IllegalStateException("Exceeded maximum nesting depth of " + this.maxNestedDepth + " while attempting to flatten components!");
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        arrayDeque.push(new StackEntry(component, i, 1));
        while (!arrayDeque.isEmpty()) {
            StackEntry stackEntry = (StackEntry) arrayDeque.pop();
            int i3 = stackEntry.depth;
            if (i3 > 512) {
                throw new IllegalStateException("Exceeded maximum depth of 512 while attempting to flatten components!");
            }
            Component component2 = stackEntry.component;
            Handler handlerFlattener = flattener(component2);
            Style style = component2.style();
            flattenerListener.pushStyle(style);
            arrayDeque2.push(style);
            if (handlerFlattener != null) {
                handlerFlattener.handle(this, component2, flattenerListener, i3, i2);
            }
            if (component2.children().isEmpty() || !flattenerListener.shouldContinue()) {
                for (int i4 = stackEntry.stylesToPop; i4 > 0; i4--) {
                    flattenerListener.popStyle((Style) arrayDeque2.pop());
                }
            } else {
                List<Component> listChildren = component2.children();
                for (int size = listChildren.size() - 1; size >= 0; size--) {
                    if (size == listChildren.size() - 1) {
                        arrayDeque.push(new StackEntry(listChildren.get(size), i3 + 1, stackEntry.stylesToPop + 1));
                    } else {
                        arrayDeque.push(new StackEntry(listChildren.get(size), i3 + 1, 1));
                    }
                }
            }
        }
        while (!arrayDeque2.isEmpty()) {
            flattenerListener.popStyle((Style) arrayDeque2.pop());
        }
    }

    @Nullable
    private <T extends Component> Handler flattener(T t) {
        Handler handler = this.flatteners.get((Class<? extends Component>) t.getClass());
        return (handler != null || this.unknownHandler == null) ? handler : (componentFlattenerImpl, component, flattenerListener, i, i2) -> {
            flattenerListener.component(this.unknownHandler.apply(component));
        };
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public ComponentFlattener.Builder mo683toBuilder() {
        return new BuilderImpl(this.flatteners, this.unknownHandler, this.maxNestedDepth);
    }
}
