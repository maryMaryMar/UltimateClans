package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEvent;
import me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource;
import me.ulrich.clans.library.kyori.adventure.text.format.ShadowColor;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.KeybindTag;
import me.ulrich.clans.library.kyori.adventure.text.object.ObjectContents;
import me.ulrich.clans.library.kyori.adventure.translation.Translatable;
import me.ulrich.clans.library.kyori.adventure.util.ARGBLike;
import me.ulrich.clans.library.kyori.adventure.util.ForwardingIterator;
import me.ulrich.clans.library.kyori.adventure.util.IntFunction2;
import me.ulrich.clans.library.kyori.adventure.util.MonkeyBars;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/Component.class */
@ApiStatus.NonExtendable
public interface Component extends ComponentBuilderApplicable, ComponentLike, HoverEventSource<Component>, StyleGetter, StyleSetter<Component>, Examinable {
    public static final BiPredicate<? super Component, ? super Component> EQUALS = (v0, v1) -> {
        return Objects.equals(v0, v1);
    };
    public static final BiPredicate<? super Component, ? super Component> EQUALS_IDENTITY = (component, component2) -> {
        return component == component2;
    };
    public static final Predicate<? super Component> IS_NOT_EMPTY = component -> {
        return component != empty();
    };

    @NotNull
    static TextComponent empty() {
        return TextComponentImpl.EMPTY;
    }

    @NotNull
    static TextComponent newline() {
        return TextComponentImpl.NEWLINE;
    }

    @NotNull
    static TextComponent space() {
        return TextComponentImpl.SPACE;
    }

    @Contract(value = "_, _ -> new", pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    static TextComponent join(@NotNull ComponentLike componentLike, @NotNull ComponentLike... componentLikeArr) {
        return join(componentLike, Arrays.asList(componentLikeArr));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    static TextComponent join(@NotNull ComponentLike componentLike, Iterable<? extends ComponentLike> iterable) {
        Component componentJoin = join(JoinConfiguration.separator(componentLike), iterable);
        return componentJoin instanceof TextComponent ? (TextComponent) componentJoin : text().append(componentJoin).build2();
    }

    @Contract(pure = true)
    @NotNull
    static Component join(JoinConfiguration.Builder builder, @NotNull ComponentLike... componentLikeArr) {
        return join(builder, Arrays.asList(componentLikeArr));
    }

    @Contract(pure = true)
    @NotNull
    static Component join(JoinConfiguration.Builder builder, @NotNull Iterable<? extends ComponentLike> iterable) {
        return JoinConfigurationImpl.join(builder.build2(), iterable);
    }

    @Contract(pure = true)
    @NotNull
    static Component join(@NotNull JoinConfiguration joinConfiguration, @NotNull ComponentLike... componentLikeArr) {
        return join(joinConfiguration, Arrays.asList(componentLikeArr));
    }

    @Contract(pure = true)
    @NotNull
    static Component join(@NotNull JoinConfiguration joinConfiguration, @NotNull Iterable<? extends ComponentLike> iterable) {
        return JoinConfigurationImpl.join(joinConfiguration, iterable);
    }

    @NotNull
    static Collector<Component, ? extends ComponentBuilder<?, ?>, Component> toComponent() {
        return toComponent(empty());
    }

    @NotNull
    static Collector<Component, ? extends ComponentBuilder<?, ?>, Component> toComponent(@NotNull Component component) {
        return Collector.of(Component::text, (builder, component2) -> {
            if (component != empty() && !builder.children().isEmpty()) {
                builder.append(component);
            }
            builder.append(component2);
        }, (builder2, builder3) -> {
            List<Component> listChildren = builder2.children();
            TextComponent.Builder builderAppend = text().append(listChildren);
            if (!listChildren.isEmpty()) {
                builderAppend.append(component);
            }
            builderAppend.append(builder3.children());
            return builderAppend;
        }, (v0) -> {
            return v0.build2();
        }, new Collector.Characteristics[0]);
    }

    @Contract(pure = true)
    static BlockNBTComponent.Builder blockNBT() {
        return new BlockNBTComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static BlockNBTComponent blockNBT(@NotNull Consumer<? super BlockNBTComponent.Builder> consumer) {
        return (BlockNBTComponent) AbstractBuilder.configureAndBuild(blockNBT(), consumer);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static BlockNBTComponent blockNBT(@NotNull String str, BlockNBTComponent.Pos pos) {
        return blockNBT(str, false, pos);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static BlockNBTComponent blockNBT(@NotNull String str, boolean z, BlockNBTComponent.Pos pos) {
        return blockNBT(str, z, null, pos);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static BlockNBTComponent blockNBT(@NotNull String str, boolean z, @Nullable ComponentLike componentLike, BlockNBTComponent.Pos pos) {
        return BlockNBTComponentImpl.create(Collections.emptyList(), Style.empty(), str, z, componentLike, pos);
    }

    @Contract(pure = true)
    static EntityNBTComponent.Builder entityNBT() {
        return new EntityNBTComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static EntityNBTComponent entityNBT(@NotNull Consumer<? super EntityNBTComponent.Builder> consumer) {
        return (EntityNBTComponent) AbstractBuilder.configureAndBuild(entityNBT(), consumer);
    }

    @Contract("_, _ -> new")
    @NotNull
    static EntityNBTComponent entityNBT(@NotNull String str, @NotNull String str2) {
        return (EntityNBTComponent) entityNBT().nbtPath(str).selector(str2).build2();
    }

    @Contract(pure = true)
    static KeybindComponent.Builder keybind() {
        return new KeybindComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static KeybindComponent keybind(@NotNull Consumer<? super KeybindComponent.Builder> consumer) {
        return (KeybindComponent) AbstractBuilder.configureAndBuild(keybind(), consumer);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(@NotNull String str) {
        return keybind(str, Style.empty());
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(KeybindComponent.KeybindLike keybindLike) {
        return keybind(((KeybindComponent.KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind(), Style.empty());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(@NotNull String str, @NotNull Style style) {
        return KeybindComponentImpl.create(Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(KeybindComponent.KeybindLike keybindLike, @NotNull Style style) {
        return KeybindComponentImpl.create(Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), ((KeybindComponent.KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(@NotNull String str, @Nullable TextColor textColor) {
        return keybind(str, Style.style(textColor));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(KeybindComponent.KeybindLike keybindLike, @Nullable TextColor textColor) {
        return keybind(((KeybindComponent.KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind(), Style.style(textColor));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(@NotNull String str, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return keybind(str, Style.style(textColor, textDecorationArr));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(KeybindComponent.KeybindLike keybindLike, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return keybind(((KeybindComponent.KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind(), Style.style(textColor, textDecorationArr));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(@NotNull String str, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return keybind(str, Style.style(textColor, set));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static KeybindComponent keybind(KeybindComponent.KeybindLike keybindLike, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return keybind(((KeybindComponent.KeybindLike) Objects.requireNonNull(keybindLike, "keybind")).asKeybind(), Style.style(textColor, set));
    }

    @Contract(pure = true)
    static ObjectComponent.Builder object() {
        return new ObjectComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static ObjectComponent object(@NotNull Consumer<? super ObjectComponent.Builder> consumer) {
        return (ObjectComponent) AbstractBuilder.configureAndBuild(object(), consumer);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static ObjectComponent object(@NotNull ObjectContents objectContents) {
        return ObjectComponentImpl.create(Collections.emptyList(), Style.empty(), objectContents);
    }

    @Contract(pure = true)
    static ScoreComponent.Builder score() {
        return new ScoreComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static ScoreComponent score(@NotNull Consumer<? super ScoreComponent.Builder> consumer) {
        return (ScoreComponent) AbstractBuilder.configureAndBuild(score(), consumer);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static ScoreComponent score(@NotNull String str, @NotNull String str2) {
        return score(str, str2, null);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @Deprecated
    @NotNull
    static ScoreComponent score(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        return ScoreComponentImpl.create(Collections.emptyList(), Style.empty(), str, str2, str3);
    }

    @Contract(pure = true)
    static SelectorComponent.Builder selector() {
        return new SelectorComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static SelectorComponent selector(@NotNull Consumer<? super SelectorComponent.Builder> consumer) {
        return (SelectorComponent) AbstractBuilder.configureAndBuild(selector(), consumer);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static SelectorComponent selector(@NotNull String str) {
        return selector(str, null);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static SelectorComponent selector(@NotNull String str, @Nullable ComponentLike componentLike) {
        return SelectorComponentImpl.create(Collections.emptyList(), Style.empty(), str, componentLike);
    }

    @Contract(pure = true)
    static StorageNBTComponent.Builder storageNBT() {
        return new StorageNBTComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static StorageNBTComponent storageNBT(@NotNull Consumer<? super StorageNBTComponent.Builder> consumer) {
        return (StorageNBTComponent) AbstractBuilder.configureAndBuild(storageNBT(), consumer);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static StorageNBTComponent storageNBT(@NotNull String str, @NotNull Key key) {
        return storageNBT(str, false, key);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static StorageNBTComponent storageNBT(@NotNull String str, boolean z, @NotNull Key key) {
        return storageNBT(str, z, null, key);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static StorageNBTComponent storageNBT(@NotNull String str, boolean z, @Nullable ComponentLike componentLike, @NotNull Key key) {
        return StorageNBTComponentImpl.create(Collections.emptyList(), Style.empty(), str, z, componentLike, key);
    }

    @Contract(pure = true)
    static TextComponent.Builder text() {
        return new TextComponentImpl.BuilderImpl();
    }

    @NotNull
    static TextComponent textOfChildren(@NotNull ComponentLike... componentLikeArr) {
        return componentLikeArr.length == 0 ? empty() : TextComponentImpl.create(Arrays.asList(componentLikeArr), Style.empty(), "");
    }

    @Contract("_ -> new")
    @NotNull
    static TextComponent text(@NotNull Consumer<? super TextComponent.Builder> consumer) {
        return (TextComponent) AbstractBuilder.configureAndBuild(text(), consumer);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TextComponent text(@NotNull String str) {
        return str.isEmpty() ? empty() : text(str, Style.empty());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(@NotNull String str, @NotNull Style style) {
        return TextComponentImpl.create(Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(@NotNull String str, @Nullable TextColor textColor) {
        return text(str, Style.style(textColor));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(@NotNull String str, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(str, Style.style(textColor, textDecorationArr));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(@NotNull String str, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(str, Style.style(textColor, set));
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TextComponent text(boolean z) {
        return text(String.valueOf(z));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(boolean z, @NotNull Style style) {
        return text(String.valueOf(z), style);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(boolean z, @Nullable TextColor textColor) {
        return text(String.valueOf(z), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(boolean z, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(String.valueOf(z), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(boolean z, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(String.valueOf(z), textColor, set);
    }

    @Contract(pure = true)
    @NotNull
    static TextComponent text(char c) {
        if (c == '\n') {
            return newline();
        }
        return c == ' ' ? space() : text(String.valueOf(c));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(char c, @NotNull Style style) {
        return text(String.valueOf(c), style);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(char c, @Nullable TextColor textColor) {
        return text(String.valueOf(c), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(char c, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(String.valueOf(c), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(char c, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(String.valueOf(c), textColor, set);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TextComponent text(double d) {
        return text(String.valueOf(d));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(double d, @NotNull Style style) {
        return text(String.valueOf(d), style);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(double d, @Nullable TextColor textColor) {
        return text(String.valueOf(d), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(double d, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(String.valueOf(d), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(double d, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(String.valueOf(d), textColor, set);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TextComponent text(float f) {
        return text(String.valueOf(f));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(float f, @NotNull Style style) {
        return text(String.valueOf(f), style);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(float f, @Nullable TextColor textColor) {
        return text(String.valueOf(f), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(float f, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(String.valueOf(f), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(float f, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(String.valueOf(f), textColor, set);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TextComponent text(int i) {
        return text(String.valueOf(i));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(int i, @NotNull Style style) {
        return text(String.valueOf(i), style);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(int i, @Nullable TextColor textColor) {
        return text(String.valueOf(i), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(int i, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(String.valueOf(i), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(int i, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(String.valueOf(i), textColor, set);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TextComponent text(long j) {
        return text(String.valueOf(j));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(long j, @NotNull Style style) {
        return text(String.valueOf(j), style);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TextComponent text(long j, @Nullable TextColor textColor) {
        return text(String.valueOf(j), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(long j, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return text(String.valueOf(j), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TextComponent text(long j, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return text(String.valueOf(j), textColor, set);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static <C> VirtualComponent virtual(@NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer) {
        Objects.requireNonNull(cls, "context type");
        Objects.requireNonNull(virtualComponentRenderer, "renderer");
        return VirtualComponentImpl.createVirtual(cls, virtualComponentRenderer);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static <C> VirtualComponent virtual(@NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer, @NotNull Style style) {
        Objects.requireNonNull(cls, "context type");
        Objects.requireNonNull(virtualComponentRenderer, "renderer");
        return VirtualComponentImpl.createVirtual(cls, virtualComponentRenderer, Collections.emptyList(), style);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static <C> VirtualComponent virtual(@NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer, @NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        Objects.requireNonNull(cls, "context type");
        Objects.requireNonNull(virtualComponentRenderer, "renderer");
        return VirtualComponentImpl.createVirtual(cls, virtualComponentRenderer, Collections.emptyList(), Style.style(styleBuilderApplicableArr));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static <C> VirtualComponent virtual(@NotNull Class<C> cls, @NotNull VirtualComponentRenderer<C> virtualComponentRenderer, @NotNull Iterable<StyleBuilderApplicable> iterable) {
        Objects.requireNonNull(cls, "context type");
        Objects.requireNonNull(virtualComponentRenderer, "renderer");
        return VirtualComponentImpl.createVirtual(cls, virtualComponentRenderer, Collections.emptyList(), Style.style(iterable));
    }

    @Contract(pure = true)
    static TranslatableComponent.Builder translatable() {
        return new TranslatableComponentImpl.BuilderImpl();
    }

    @Contract("_ -> new")
    @NotNull
    static TranslatableComponent translatable(@NotNull Consumer<? super TranslatableComponent.Builder> consumer) {
        return (TranslatableComponent) AbstractBuilder.configureAndBuild(translatable(), consumer);
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str) {
        return translatable(str, Style.empty());
    }

    @Contract(value = "_ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), Style.empty());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2) {
        return translatable(str, str2, Style.empty());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, Style.empty());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @NotNull Style style) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str, (String) null, (List<? extends ComponentLike>) Collections.emptyList());
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @NotNull Style style) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), style);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull Style style) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str, str2, (List<? extends ComponentLike>) Collections.emptyList());
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull Style style) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, style);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        return translatable((String) Objects.requireNonNull(str, KeybindTag.KEYBIND), str2, Style.style(styleBuilderApplicableArr));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull Iterable<StyleBuilderApplicable> iterable) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, Style.style(iterable));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull ComponentLike... componentLikeArr) {
        return translatable(str, str2, Style.empty(), componentLikeArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull ComponentLike... componentLikeArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, componentLikeArr);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull Style style, @NotNull ComponentLike... componentLikeArr) {
        return TranslatableComponentImpl.create((List<Component>) Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str, str2, (ComponentLike[]) Objects.requireNonNull(componentLikeArr, "args"));
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull Style style, @NotNull ComponentLike... componentLikeArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, style, componentLikeArr);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull Style style, @NotNull List<? extends ComponentLike> list) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), style, str, str2, (List<? extends ComponentLike>) Objects.requireNonNull(list, "args"));
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull Style style, @NotNull List<? extends ComponentLike> list) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, style, list);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull List<? extends ComponentLike> list, @NotNull Iterable<StyleBuilderApplicable> iterable) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), Style.style(iterable), str, str2, (List<? extends ComponentLike>) Objects.requireNonNull(list, "args"));
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull List<? extends ComponentLike> list, @NotNull Iterable<StyleBuilderApplicable> iterable) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, list, iterable);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable String str2, @NotNull List<? extends ComponentLike> list, @NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), Style.style(styleBuilderApplicableArr), str, str2, (List<? extends ComponentLike>) Objects.requireNonNull(list, "args"));
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable String str, @NotNull List<? extends ComponentLike> list, @NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), str, list, styleBuilderApplicableArr);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor) {
        return translatable(str, Style.style(textColor));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return translatable(str, Style.style(textColor, textDecorationArr));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor, TextDecoration... textDecorationArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor, textDecorationArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return translatable(str, Style.style(textColor, set));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor, set);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @NotNull ComponentLike... componentLikeArr) {
        return translatable(str, Style.empty(), componentLikeArr);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @NotNull ComponentLike... componentLikeArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), componentLikeArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @NotNull Style style, @NotNull ComponentLike... componentLikeArr) {
        return TranslatableComponentImpl.create((List<Component>) Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str, (String) null, (ComponentLike[]) Objects.requireNonNull(componentLikeArr, "args"));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @NotNull Style style, @NotNull ComponentLike... componentLikeArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), style, componentLikeArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor, @NotNull ComponentLike... componentLikeArr) {
        return translatable(str, Style.style(textColor), componentLikeArr);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor, @NotNull ComponentLike... componentLikeArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor, componentLikeArr);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set, @NotNull ComponentLike... componentLikeArr) {
        return translatable(str, Style.style(textColor, set), componentLikeArr);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set, @NotNull ComponentLike... componentLikeArr) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor, set, componentLikeArr);
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @NotNull List<? extends ComponentLike> list) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), Style.empty(), str, (String) null, (List<? extends ComponentLike>) Objects.requireNonNull(list, "args"));
    }

    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @NotNull List<? extends ComponentLike> list) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), list);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @NotNull Style style, @NotNull List<? extends ComponentLike> list) {
        return TranslatableComponentImpl.create((List<? extends ComponentLike>) Collections.emptyList(), (Style) Objects.requireNonNull(style, "style"), str, (String) null, (List<? extends ComponentLike>) Objects.requireNonNull(list, "args"));
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @NotNull Style style, @NotNull List<? extends ComponentLike> list) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), style, list);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor, @NotNull List<? extends ComponentLike> list) {
        return translatable(str, Style.style(textColor), list);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor, @NotNull List<? extends ComponentLike> list) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor, list);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull String str, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set, @NotNull List<? extends ComponentLike> list) {
        return translatable(str, Style.style(textColor, set), list);
    }

    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    static TranslatableComponent translatable(@NotNull Translatable translatable, @Nullable TextColor textColor, @NotNull Set<TextDecoration> set, @NotNull List<? extends ComponentLike> list) {
        return translatable(((Translatable) Objects.requireNonNull(translatable, "translatable")).translationKey(), textColor, set, list);
    }

    @NotNull
    List<Component> children();

    @Contract(pure = true)
    @NotNull
    Component children(@NotNull List<? extends ComponentLike> list);

    default boolean contains(@NotNull Component component) {
        return contains(component, EQUALS_IDENTITY);
    }

    default boolean contains(@NotNull Component component, @NotNull BiPredicate<? super Component, ? super Component> biPredicate) {
        if (biPredicate.test(this, component)) {
            return true;
        }
        Iterator<Component> it = children().iterator();
        while (it.hasNext()) {
            if (it.next().contains(component, biPredicate)) {
                return true;
            }
        }
        HoverEvent<?> hoverEvent = hoverEvent();
        if (hoverEvent == null) {
            return false;
        }
        Object objValue = hoverEvent.value();
        Component componentName = null;
        if (objValue instanceof Component) {
            componentName = (Component) hoverEvent.value();
        } else if (objValue instanceof HoverEvent.ShowEntity) {
            componentName = ((HoverEvent.ShowEntity) objValue).name();
        }
        if (componentName == null) {
            return false;
        }
        if (biPredicate.test(component, componentName)) {
            return true;
        }
        Iterator<Component> it2 = componentName.children().iterator();
        while (it2.hasNext()) {
            if (it2.next().contains(component, biPredicate)) {
                return true;
            }
        }
        return false;
    }

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    default void detectCycle(@NotNull Component component) {
        if (component.contains(this)) {
            throw new IllegalStateException("Component cycle detected between " + this + " and " + component);
        }
    }

    @Contract(pure = true)
    @NotNull
    default Component append(@NotNull Component component) {
        return append((ComponentLike) component);
    }

    @NotNull
    default Component append(@NotNull ComponentLike componentLike) {
        Objects.requireNonNull(componentLike, "like");
        Component componentAsComponent = componentLike.asComponent();
        Objects.requireNonNull(componentAsComponent, "component");
        return componentAsComponent == empty() ? this : children(MonkeyBars.addOne(children(), componentAsComponent));
    }

    @Contract(pure = true)
    @NotNull
    default Component append(@NotNull ComponentBuilder<?, ?> componentBuilder) {
        return append((Component) componentBuilder.build2());
    }

    @Contract(pure = true)
    @NotNull
    default Component appendNewline() {
        return append((Component) newline());
    }

    @Contract(pure = true)
    @NotNull
    default Component appendSpace() {
        return append((Component) space());
    }

    @Contract(pure = true)
    @NotNull
    default Component append(@NotNull ComponentLike... componentLikeArr) {
        if (componentLikeArr.length == 0) {
            return this;
        }
        ArrayList arrayList = new ArrayList(componentLikeArr.length + children().size());
        arrayList.addAll(children());
        Collections.addAll(arrayList, componentLikeArr);
        return children(arrayList);
    }

    @Contract(pure = true)
    @NotNull
    default Component append(@NotNull List<? extends ComponentLike> list) {
        if (list.isEmpty()) {
            return this;
        }
        if (children().isEmpty()) {
            return children(list);
        }
        ArrayList arrayList = new ArrayList(list.size() + children().size());
        arrayList.addAll(children());
        arrayList.addAll(list);
        return children(arrayList);
    }

    @Contract(pure = true)
    @NotNull
    default Component applyFallbackStyle(@NotNull Style style) {
        Objects.requireNonNull(style, "style");
        return style(style().merge(style, Style.Merge.Strategy.IF_ABSENT_ON_TARGET));
    }

    @Contract(pure = true)
    @NotNull
    default Component applyFallbackStyle(@NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        return applyFallbackStyle(Style.style(styleBuilderApplicableArr));
    }

    @NotNull
    Style style();

    @Contract(pure = true)
    @NotNull
    Component style(@NotNull Style style);

    @Contract(pure = true)
    @NotNull
    default Component style(@NotNull Consumer<Style.Builder> consumer) {
        return style(style().edit(consumer));
    }

    @Contract(pure = true)
    @NotNull
    default Component style(@NotNull Consumer<Style.Builder> consumer, Style.Merge.Strategy strategy) {
        return style(style().edit(consumer, strategy));
    }

    @Contract(pure = true)
    @NotNull
    default Component style(Style.Builder builder) {
        return style(builder.build2());
    }

    @Contract(pure = true)
    @NotNull
    default Component mergeStyle(@NotNull Component component) {
        return mergeStyle(component, Style.Merge.all());
    }

    @Contract(pure = true)
    @NotNull
    default Component mergeStyle(@NotNull Component component, Style.Merge... mergeArr) {
        return mergeStyle(component, Style.Merge.merges(mergeArr));
    }

    @Contract(pure = true)
    @NotNull
    default Component mergeStyle(@NotNull Component component, @NotNull Set<Style.Merge> set) {
        return style(style().merge(component.style(), set));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    default Key font() {
        return style().font();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default Component font(@Nullable Key key) {
        return style(style().font(key));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    default TextColor color() {
        return style().color();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    default ShadowColor shadowColor() {
        return style().shadowColor();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component color(@Nullable TextColor textColor) {
        return style(style().color(textColor));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component colorIfAbsent(@Nullable TextColor textColor) {
        return color() == null ? color(textColor) : this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component shadowColor(@Nullable ARGBLike aRGBLike) {
        return style(style().shadowColor(aRGBLike));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component shadowColorIfAbsent(@Nullable ARGBLike aRGBLike) {
        return shadowColor() == null ? shadowColor(aRGBLike) : this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    default boolean hasDecoration(@NotNull TextDecoration textDecoration) {
        return super.hasDecoration(textDecoration);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component decorate(@NotNull TextDecoration textDecoration) {
        return (Component) super.decorate(textDecoration);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    default TextDecoration.State decoration(@NotNull TextDecoration textDecoration) {
        return style().decoration(textDecoration);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component decoration(@NotNull TextDecoration textDecoration, boolean z) {
        return (Component) super.decoration(textDecoration, z);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component decoration(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        return style(style().decoration(textDecoration, state));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @NotNull
    default Component decorationIfAbsent(@NotNull TextDecoration textDecoration, TextDecoration.State state) {
        Objects.requireNonNull(state, "state");
        return decoration(textDecoration) == TextDecoration.State.NOT_SET ? style(style().decoration(textDecoration, state)) : this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @NotNull
    default Map<TextDecoration, TextDecoration.State> decorations() {
        return style().decorations();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component decorations(@NotNull Map<TextDecoration, TextDecoration.State> map) {
        return style(style().decorations(map));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    default ClickEvent clickEvent() {
        return style().clickEvent();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component clickEvent(@Nullable ClickEvent clickEvent) {
        return style(style().clickEvent(clickEvent));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    default HoverEvent<?> hoverEvent() {
        return style().hoverEvent();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component hoverEvent(@Nullable HoverEventSource<?> hoverEventSource) {
        return style(style().hoverEvent(hoverEventSource));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleGetter
    @Nullable
    default String insertion() {
        return style().insertion();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    default Component insertion(@Nullable String str) {
        return style(style().insertion(str));
    }

    default boolean hasStyling() {
        return !style().isEmpty();
    }

    @Contract(pure = true)
    @ScopedComponentOverrideNotRequired
    @NotNull
    default Component replaceText(@NotNull Consumer<TextReplacementConfig.Builder> consumer) {
        Objects.requireNonNull(consumer, "configurer");
        return replaceText((TextReplacementConfig) AbstractBuilder.configureAndBuild(TextReplacementConfig.builder(), consumer));
    }

    @Contract(pure = true)
    @ScopedComponentOverrideNotRequired
    @NotNull
    default Component replaceText(@NotNull TextReplacementConfig textReplacementConfig) {
        Objects.requireNonNull(textReplacementConfig, "replacement");
        if (textReplacementConfig instanceof TextReplacementConfigImpl) {
            return TextReplacementRenderer.INSTANCE.render(this, ((TextReplacementConfigImpl) textReplacementConfig).createState());
        }
        throw new IllegalArgumentException("Provided replacement was a custom TextReplacementConfig implementation, which is not supported.");
    }

    @ScopedComponentOverrideNotRequired
    @NotNull
    default Component compact() {
        return compact(null);
    }

    @ScopedComponentOverrideNotRequired
    @NotNull
    default Component compact(@Nullable Style style) {
        return ComponentCompaction.compact(this, style);
    }

    @NotNull
    default Iterable<Component> iterable(@NotNull ComponentIteratorType componentIteratorType, @NotNull ComponentIteratorFlag... componentIteratorFlagArr) {
        return iterable(componentIteratorType, componentIteratorFlagArr == null ? Collections.emptySet() : MonkeyBars.enumSet(ComponentIteratorFlag.class, componentIteratorFlagArr));
    }

    @NotNull
    default Iterable<Component> iterable(@NotNull ComponentIteratorType componentIteratorType, @NotNull Set<ComponentIteratorFlag> set) {
        Objects.requireNonNull(componentIteratorType, "type");
        Objects.requireNonNull(set, "flags");
        return new ForwardingIterator(() -> {
            return iterator(componentIteratorType, (Set<ComponentIteratorFlag>) set);
        }, () -> {
            return spliterator(componentIteratorType, (Set<ComponentIteratorFlag>) set);
        });
    }

    @NotNull
    default Iterator<Component> iterator(@NotNull ComponentIteratorType componentIteratorType, @NotNull ComponentIteratorFlag... componentIteratorFlagArr) {
        return iterator(componentIteratorType, componentIteratorFlagArr == null ? Collections.emptySet() : MonkeyBars.enumSet(ComponentIteratorFlag.class, componentIteratorFlagArr));
    }

    @NotNull
    default Iterator<Component> iterator(@NotNull ComponentIteratorType componentIteratorType, @NotNull Set<ComponentIteratorFlag> set) {
        return new ComponentIterator(this, (ComponentIteratorType) Objects.requireNonNull(componentIteratorType, "type"), (Set) Objects.requireNonNull(set, "flags"));
    }

    @NotNull
    default Spliterator<Component> spliterator(@NotNull ComponentIteratorType componentIteratorType, @NotNull ComponentIteratorFlag... componentIteratorFlagArr) {
        return spliterator(componentIteratorType, componentIteratorFlagArr == null ? Collections.emptySet() : MonkeyBars.enumSet(ComponentIteratorFlag.class, componentIteratorFlagArr));
    }

    @NotNull
    default Spliterator<Component> spliterator(@NotNull ComponentIteratorType componentIteratorType, @NotNull Set<ComponentIteratorFlag> set) {
        return Spliterators.spliteratorUnknownSize(iterator(componentIteratorType, set), 1296);
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceText(@NotNull String str, @Nullable ComponentLike componentLike) {
        return replaceText(builder -> {
            builder.matchLiteral(str).replacement(componentLike);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceText(@NotNull Pattern pattern, @NotNull Function<TextComponent.Builder, ComponentLike> function) {
        return replaceText(builder -> {
            builder.match(pattern).replacement((Function<TextComponent.Builder, ComponentLike>) function);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceFirstText(@NotNull String str, @Nullable ComponentLike componentLike) {
        return replaceText(builder -> {
            builder.matchLiteral(str).once().replacement(componentLike);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceFirstText(@NotNull Pattern pattern, @NotNull Function<TextComponent.Builder, ComponentLike> function) {
        return replaceText(builder -> {
            builder.match(pattern).once().replacement((Function<TextComponent.Builder, ComponentLike>) function);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceText(@NotNull String str, @Nullable ComponentLike componentLike, int i) {
        return replaceText(builder -> {
            builder.matchLiteral(str).times(i).replacement(componentLike);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceText(@NotNull Pattern pattern, @NotNull Function<TextComponent.Builder, ComponentLike> function, int i) {
        return replaceText(builder -> {
            builder.match(pattern).times(i).replacement((Function<TextComponent.Builder, ComponentLike>) function);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceText(@NotNull String str, @Nullable ComponentLike componentLike, @NotNull IntFunction2<PatternReplacementResult> intFunction2) {
        return replaceText(builder -> {
            builder.matchLiteral(str).replacement(componentLike).condition((IntFunction2<PatternReplacementResult>) intFunction2);
        });
    }

    @Contract(pure = true)
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default Component replaceText(@NotNull Pattern pattern, @NotNull Function<TextComponent.Builder, ComponentLike> function, @NotNull IntFunction2<PatternReplacementResult> intFunction2) {
        return replaceText(builder -> {
            builder.match(pattern).replacement((Function<TextComponent.Builder, ComponentLike>) function).condition((IntFunction2<PatternReplacementResult>) intFunction2);
        });
    }

    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    ComponentBuilder<?, ?> mo683toBuilder();

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentBuilderApplicable
    default void componentBuilderApply(@NotNull ComponentBuilder<?, ?> componentBuilder) {
        componentBuilder.append(this);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.ComponentLike
    @NotNull
    default Component asComponent() {
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.HoverEventSource
    @NotNull
    default HoverEvent<Component> asHoverEvent(@NotNull UnaryOperator<Component> unaryOperator) {
        return HoverEvent.showText((Component) unaryOperator.apply(this));
    }

    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("style", style()), ExaminableProperty.of("children", children())});
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter hoverEvent(@Nullable HoverEventSource hoverEventSource) {
        return hoverEvent((HoverEventSource<?>) hoverEventSource);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleSetter
    @Contract(pure = true)
    @NotNull
    /* bridge */ /* synthetic */ default StyleSetter decorations(@NotNull Map map) {
        return decorations((Map<TextDecoration, TextDecoration.State>) map);
    }
}
