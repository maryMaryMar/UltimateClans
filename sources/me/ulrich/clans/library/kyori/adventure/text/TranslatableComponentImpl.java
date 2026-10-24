package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslatableComponentImpl.class */
final class TranslatableComponentImpl extends AbstractComponent implements TranslatableComponent {
    private final String key;

    @Nullable
    private final String fallback;
    private final List<TranslationArgument> args;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslatableComponentImpl$BuilderImpl.class */
    static final class BuilderImpl extends AbstractComponentBuilder<TranslatableComponent, TranslatableComponent.Builder> implements TranslatableComponent.Builder {

        @Nullable
        private String key;

        @Nullable
        private String fallback;
        private List<TranslationArgument> args;

        BuilderImpl() {
            this.args = Collections.emptyList();
        }

        BuilderImpl(@NotNull TranslatableComponent translatableComponent) {
            super(translatableComponent);
            this.args = Collections.emptyList();
            this.key = translatableComponent.key();
            this.args = translatableComponent.arguments();
            this.fallback = translatableComponent.fallback();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent.Builder
        @NotNull
        public TranslatableComponent.Builder key(@NotNull String str) {
            this.key = str;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent.Builder
        @NotNull
        public TranslatableComponent.Builder arguments(@NotNull ComponentLike... componentLikeArr) {
            Objects.requireNonNull(componentLikeArr, "args");
            return componentLikeArr.length == 0 ? arguments(Collections.emptyList()) : arguments(Arrays.asList(componentLikeArr));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent.Builder
        @NotNull
        public TranslatableComponent.Builder arguments(@NotNull List<? extends ComponentLike> list) {
            this.args = TranslatableComponentImpl.asArguments((List) Objects.requireNonNull(list, "args"));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent.Builder
        @NotNull
        public TranslatableComponent.Builder fallback(@Nullable String str) {
            this.fallback = str;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public TranslatableComponent build2() {
            if (this.key == null) {
                throw new IllegalStateException("key must be set");
            }
            return TranslatableComponentImpl.create(this.children, buildStyle(), this.key, this.fallback, this.args);
        }
    }

    static TranslatableComponent create(@NotNull List<Component> list, @NotNull Style style, @NotNull String str, @Nullable String str2, @NotNull ComponentLike[] componentLikeArr) {
        Objects.requireNonNull(componentLikeArr, "args");
        return create(list, style, str, str2, (List<? extends ComponentLike>) Arrays.asList(componentLikeArr));
    }

    static TranslatableComponent create(@NotNull List<? extends ComponentLike> list, @NotNull Style style, @NotNull String str, @Nullable String str2, @NotNull List<? extends ComponentLike> list2) {
        return new TranslatableComponentImpl(ComponentLike.asComponents(list, IS_NOT_EMPTY), (Style) Objects.requireNonNull(style, "style"), (String) Objects.requireNonNull(str, KeybindTag.KEYBIND), str2, asArguments(list2));
    }

    TranslatableComponentImpl(@NotNull List<Component> list, @NotNull Style style, @NotNull String str, @Nullable String str2, @NotNull List<TranslationArgument> list2) {
        super(list, style);
        this.key = str;
        this.fallback = str2;
        this.args = list2;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @NotNull
    public String key() {
        return this.key;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @NotNull
    public TranslatableComponent key(@NotNull String str) {
        return Objects.equals(this.key, str) ? this : create(this.children, this.style, str, this.fallback, this.args);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @Deprecated
    @NotNull
    public List<Component> args() {
        return ComponentLike.asComponents(this.args);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @NotNull
    public List<TranslationArgument> arguments() {
        return this.args;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @NotNull
    public TranslatableComponent arguments(@NotNull ComponentLike... componentLikeArr) {
        return create(this.children, this.style, this.key, this.fallback, componentLikeArr);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @NotNull
    public TranslatableComponent arguments(@NotNull List<? extends ComponentLike> list) {
        return create(this.children, this.style, this.key, this.fallback, list);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @Nullable
    public String fallback() {
        return this.fallback;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent
    @NotNull
    public TranslatableComponent fallback(@Nullable String str) {
        return create(this.children, this.style, this.key, str, this.args);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public TranslatableComponent children(@NotNull List<? extends ComponentLike> list) {
        return create(list, this.style, this.key, this.fallback, this.args);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public TranslatableComponent style(@NotNull Style style) {
        return create(this.children, style, this.key, this.fallback, this.args);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslatableComponent) || !super.equals(obj)) {
            return false;
        }
        TranslatableComponent translatableComponent = (TranslatableComponent) obj;
        return Objects.equals(this.key, translatableComponent.key()) && Objects.equals(this.fallback, translatableComponent.fallback()) && Objects.equals(this.args, translatableComponent.arguments());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * ((31 * ((31 * super.hashCode()) + this.key.hashCode())) + Objects.hashCode(this.fallback))) + this.args.hashCode();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public TranslatableComponent.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }

    static List<TranslationArgument> asArguments(@NotNull List<? extends ComponentLike> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ComponentLike componentLike = list.get(i);
            if (componentLike == null) {
                throw new NullPointerException("likes[" + i + "]");
            }
            if (componentLike instanceof TranslationArgument) {
                arrayList.add((TranslationArgument) componentLike);
            } else if (componentLike instanceof TranslationArgumentLike) {
                arrayList.add((TranslationArgument) Objects.requireNonNull(((TranslationArgumentLike) componentLike).asTranslationArgument(), "likes[" + i + "].asTranslationArgument()"));
            } else {
                arrayList.add(TranslationArgument.component(componentLike));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.Component, me.ulrich.clans.library.kyori.adventure.text.ScopedComponent
    @NotNull
    public /* bridge */ /* synthetic */ Component children(@NotNull List list) {
        return children((List<? extends ComponentLike>) list);
    }
}
