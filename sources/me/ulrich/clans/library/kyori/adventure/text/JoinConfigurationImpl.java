package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/JoinConfigurationImpl.class */
final class JoinConfigurationImpl implements JoinConfiguration {
    static final Function<ComponentLike, Component> DEFAULT_CONVERTOR = (v0) -> {
        return v0.asComponent();
    };
    static final Predicate<ComponentLike> DEFAULT_PREDICATE = componentLike -> {
        return true;
    };
    static final JoinConfigurationImpl NULL = new JoinConfigurationImpl();
    static final JoinConfiguration STANDARD_NEW_LINES = JoinConfiguration.separator(Component.newline());
    static final JoinConfiguration STANDARD_SPACES = JoinConfiguration.separator(Component.space());
    static final JoinConfiguration STANDARD_COMMA_SEPARATED = JoinConfiguration.separator(Component.text(","));
    static final JoinConfiguration STANDARD_COMMA_SPACE_SEPARATED = JoinConfiguration.separator(Component.text(", "));
    static final JoinConfiguration STANDARD_ARRAY_LIKE = JoinConfiguration.builder().separator(Component.text(", ")).prefix(Component.text("[")).suffix(Component.text("]")).build2();
    private final Component prefix;
    private final Component suffix;
    private final Component separator;
    private final Component lastSeparator;
    private final Component lastSeparatorIfSerial;
    private final Function<ComponentLike, Component> convertor;
    private final Predicate<ComponentLike> predicate;
    private final Style rootStyle;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/JoinConfigurationImpl$BuilderImpl.class */
    static final class BuilderImpl implements JoinConfiguration.Builder {
        private ComponentLike prefix;
        private ComponentLike suffix;
        private ComponentLike separator;
        private ComponentLike lastSeparator;
        private ComponentLike lastSeparatorIfSerial;
        private Function<ComponentLike, Component> convertor;
        private Predicate<ComponentLike> predicate;
        private Style rootStyle;

        BuilderImpl() {
            this(JoinConfigurationImpl.NULL);
        }

        private BuilderImpl(@NotNull JoinConfigurationImpl joinConfigurationImpl) {
            this.separator = joinConfigurationImpl.separator;
            this.lastSeparator = joinConfigurationImpl.lastSeparator;
            this.prefix = joinConfigurationImpl.prefix;
            this.suffix = joinConfigurationImpl.suffix;
            this.convertor = joinConfigurationImpl.convertor;
            this.lastSeparatorIfSerial = joinConfigurationImpl.lastSeparatorIfSerial;
            this.predicate = joinConfigurationImpl.predicate;
            this.rootStyle = joinConfigurationImpl.rootStyle;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder prefix(@Nullable ComponentLike componentLike) {
            this.prefix = componentLike;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder suffix(@Nullable ComponentLike componentLike) {
            this.suffix = componentLike;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder separator(@Nullable ComponentLike componentLike) {
            this.separator = componentLike;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder lastSeparator(@Nullable ComponentLike componentLike) {
            this.lastSeparator = componentLike;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder lastSeparatorIfSerial(@Nullable ComponentLike componentLike) {
            this.lastSeparatorIfSerial = componentLike;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder convertor(@NotNull Function<ComponentLike, Component> function) {
            this.convertor = (Function) Objects.requireNonNull(function, "convertor");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder predicate(@NotNull Predicate<ComponentLike> predicate) {
            this.predicate = (Predicate) Objects.requireNonNull(predicate, "predicate");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration.Builder
        @NotNull
        public JoinConfiguration.Builder parentStyle(@NotNull Style style) {
            this.rootStyle = (Style) Objects.requireNonNull(style, "rootStyle");
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public JoinConfiguration build2() {
            return new JoinConfigurationImpl(this);
        }
    }

    private JoinConfigurationImpl() {
        this.prefix = null;
        this.suffix = null;
        this.separator = null;
        this.lastSeparator = null;
        this.lastSeparatorIfSerial = null;
        this.convertor = DEFAULT_CONVERTOR;
        this.predicate = DEFAULT_PREDICATE;
        this.rootStyle = Style.empty();
    }

    private JoinConfigurationImpl(@NotNull BuilderImpl builderImpl) {
        this.prefix = ComponentLike.unbox(builderImpl.prefix);
        this.suffix = ComponentLike.unbox(builderImpl.suffix);
        this.separator = ComponentLike.unbox(builderImpl.separator);
        this.lastSeparator = ComponentLike.unbox(builderImpl.lastSeparator);
        this.lastSeparatorIfSerial = ComponentLike.unbox(builderImpl.lastSeparatorIfSerial);
        this.convertor = builderImpl.convertor;
        this.predicate = builderImpl.predicate;
        this.rootStyle = builderImpl.rootStyle;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @Nullable
    public Component prefix() {
        return this.prefix;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @Nullable
    public Component suffix() {
        return this.suffix;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @Nullable
    public Component separator() {
        return this.separator;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @Nullable
    public Component lastSeparator() {
        return this.lastSeparator;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @Nullable
    public Component lastSeparatorIfSerial() {
        return this.lastSeparatorIfSerial;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @NotNull
    public Function<ComponentLike, Component> convertor() {
        return this.convertor;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @NotNull
    public Predicate<ComponentLike> predicate() {
        return this.predicate;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration
    @NotNull
    public Style parentStyle() {
        return this.rootStyle;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    /* JADX INFO: renamed from: toBuilder */
    public JoinConfiguration.Builder mo683toBuilder() {
        return new BuilderImpl();
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("prefix", this.prefix), ExaminableProperty.of("suffix", this.suffix), ExaminableProperty.of("separator", this.separator), ExaminableProperty.of("lastSeparator", this.lastSeparator), ExaminableProperty.of("lastSeparatorIfSerial", this.lastSeparatorIfSerial), ExaminableProperty.of("convertor", this.convertor), ExaminableProperty.of("predicate", this.predicate), ExaminableProperty.of("rootStyle", this.rootStyle)});
    }

    public String toString() {
        return Internals.toString(this);
    }

    @Contract(pure = true)
    @NotNull
    static Component join(@NotNull JoinConfiguration joinConfiguration, @NotNull Iterable<? extends ComponentLike> iterable) {
        Objects.requireNonNull(joinConfiguration, "config");
        Objects.requireNonNull(iterable, "components");
        Iterator<? extends ComponentLike> it = iterable.iterator();
        if (!it.hasNext()) {
            return singleElementJoin(joinConfiguration, null);
        }
        ComponentLike next = (ComponentLike) Objects.requireNonNull(it.next(), "Null elements in \"components\" are not allowed");
        int i = 0;
        if (!it.hasNext()) {
            return singleElementJoin(joinConfiguration, next);
        }
        Component componentPrefix = joinConfiguration.prefix();
        Component componentSuffix = joinConfiguration.suffix();
        Function<ComponentLike, Component> functionConvertor = joinConfiguration.convertor();
        Predicate<ComponentLike> predicate = joinConfiguration.predicate();
        Style styleParentStyle = joinConfiguration.parentStyle();
        boolean z = styleParentStyle != Style.empty();
        Component componentSeparator = joinConfiguration.separator();
        boolean z2 = componentSeparator != null;
        TextComponent.Builder builderStyle = z ? Component.text().style(styleParentStyle) : Component.text();
        if (componentPrefix != null) {
            builderStyle.append(componentPrefix);
        }
        while (next != null) {
            if (!predicate.test(next)) {
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            } else {
                builderStyle.append((Component) Objects.requireNonNull(functionConvertor.apply(next), "Null output from \"convertor\" is not allowed"));
                i++;
                if (it.hasNext()) {
                    next = (ComponentLike) Objects.requireNonNull(it.next(), "Null elements in \"components\" are not allowed");
                    if (!it.hasNext()) {
                        Component componentSeparator2 = null;
                        if (i > 1) {
                            componentSeparator2 = joinConfiguration.lastSeparatorIfSerial();
                        }
                        if (componentSeparator2 == null) {
                            componentSeparator2 = joinConfiguration.lastSeparator();
                        }
                        if (componentSeparator2 == null) {
                            componentSeparator2 = joinConfiguration.separator();
                        }
                        if (componentSeparator2 != null) {
                            builderStyle.append(componentSeparator2);
                        }
                    } else if (z2) {
                        builderStyle.append(componentSeparator);
                    }
                } else {
                    next = null;
                }
            }
        }
        if (componentSuffix != null) {
            builderStyle.append(componentSuffix);
        }
        return builderStyle.build2();
    }

    @NotNull
    static Component singleElementJoin(@NotNull JoinConfiguration joinConfiguration, @Nullable ComponentLike componentLike) {
        Component componentPrefix = joinConfiguration.prefix();
        Component componentSuffix = joinConfiguration.suffix();
        Function<ComponentLike, Component> functionConvertor = joinConfiguration.convertor();
        Predicate<ComponentLike> predicate = joinConfiguration.predicate();
        Style styleParentStyle = joinConfiguration.parentStyle();
        boolean z = styleParentStyle != Style.empty();
        if (componentPrefix == null && componentSuffix == null) {
            Component componentEmpty = (componentLike == null || !predicate.test(componentLike)) ? Component.empty() : functionConvertor.apply(componentLike);
            return z ? Component.text().style(styleParentStyle).append(componentEmpty).build2() : componentEmpty;
        }
        TextComponent.Builder builderText = Component.text();
        if (componentPrefix != null) {
            builderText.append(componentPrefix);
        }
        if (componentLike != null && predicate.test(componentLike)) {
            builderText.append(functionConvertor.apply(componentLike));
        }
        if (componentSuffix != null) {
            builderText.append(componentSuffix);
        }
        return z ? Component.text().style(styleParentStyle).append((ComponentBuilder<?, ?>) builderText).build2() : builderText.build2();
    }
}
