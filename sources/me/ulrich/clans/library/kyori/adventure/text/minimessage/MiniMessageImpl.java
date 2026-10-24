package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tree.Node;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageImpl.class */
final class MiniMessageImpl implements MiniMessage {
    private static final Optional<MiniMessage.Provider> SERVICE = Services.service(MiniMessage.Provider.class);
    static final Consumer<MiniMessage.Builder> BUILDER = (Consumer) SERVICE.map((v0) -> {
        return v0.builder();
    }).orElseGet(() -> {
        return builder -> {
        };
    });
    static final UnaryOperator<String> DEFAULT_NO_OP = UnaryOperator.identity();
    static final UnaryOperator<Component> DEFAULT_COMPACTING_METHOD = (v0) -> {
        return v0.compact();
    };
    private final boolean strict;
    private final boolean emitVirtuals;

    @Nullable
    private final Consumer<String> debugOutput;
    private final UnaryOperator<Component> postProcessor;
    private final UnaryOperator<String> preProcessor;
    final MiniMessageParser parser;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageImpl$BuilderImpl.class */
    static final class BuilderImpl implements MiniMessage.Builder {
        private TagResolver tagResolver;
        private boolean strict;
        private boolean emitVirtuals;
        private Consumer<String> debug;
        private UnaryOperator<Component> postProcessor;
        private UnaryOperator<String> preProcessor;

        BuilderImpl() {
            this.tagResolver = TagResolver.standard();
            this.strict = false;
            this.emitVirtuals = true;
            this.debug = null;
            this.postProcessor = MiniMessageImpl.DEFAULT_COMPACTING_METHOD;
            this.preProcessor = MiniMessageImpl.DEFAULT_NO_OP;
            MiniMessageImpl.BUILDER.accept(this);
        }

        BuilderImpl(MiniMessageImpl miniMessageImpl) {
            this();
            this.tagResolver = miniMessageImpl.parser.tagResolver;
            this.strict = miniMessageImpl.strict;
            this.debug = miniMessageImpl.debugOutput;
            this.postProcessor = miniMessageImpl.postProcessor;
            this.preProcessor = miniMessageImpl.preProcessor;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder tags(@NotNull TagResolver tagResolver) {
            this.tagResolver = (TagResolver) Objects.requireNonNull(tagResolver, "tags");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder editTags(@NotNull Consumer<TagResolver.Builder> consumer) {
            Objects.requireNonNull(consumer, "adder");
            TagResolver.Builder builderResolver = TagResolver.builder().resolver(this.tagResolver);
            consumer.accept(builderResolver);
            this.tagResolver = builderResolver.build();
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder strict(boolean z) {
            this.strict = z;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder emitVirtuals(boolean z) {
            this.emitVirtuals = z;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder debug(@Nullable Consumer<String> consumer) {
            this.debug = consumer;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder postProcessor(@NotNull UnaryOperator<Component> unaryOperator) {
            this.postProcessor = (UnaryOperator) Objects.requireNonNull(unaryOperator, "postProcessor");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder
        @NotNull
        public MiniMessage.Builder preProcessor(@NotNull UnaryOperator<String> unaryOperator) {
            this.preProcessor = (UnaryOperator) Objects.requireNonNull(unaryOperator, "preProcessor");
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage.Builder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public MiniMessage build2() {
            return new MiniMessageImpl(this.tagResolver, this.strict, this.emitVirtuals, this.debug, this.preProcessor, this.postProcessor);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageImpl$Instances.class */
    static final class Instances {
        static final MiniMessage INSTANCE = (MiniMessage) MiniMessageImpl.SERVICE.map((v0) -> {
            return v0.miniMessage();
        }).orElseGet(() -> {
            return new MiniMessageImpl(TagResolver.standard(), false, true, null, MiniMessageImpl.DEFAULT_NO_OP, MiniMessageImpl.DEFAULT_COMPACTING_METHOD);
        });

        Instances() {
        }
    }

    MiniMessageImpl(@NotNull TagResolver tagResolver, boolean z, boolean z2, @Nullable Consumer<String> consumer, @NotNull UnaryOperator<String> unaryOperator, @NotNull UnaryOperator<Component> unaryOperator2) {
        this.parser = new MiniMessageParser(tagResolver);
        this.strict = z;
        this.emitVirtuals = z2;
        this.debugOutput = consumer;
        this.preProcessor = unaryOperator;
        this.postProcessor = unaryOperator2;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public Component deserialize(@NotNull String str) {
        return this.parser.parseFormat(newContext(str, null, null));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public Component deserialize(@NotNull String str, @NotNull Pointered pointered) {
        return this.parser.parseFormat(newContext(str, (Pointered) Objects.requireNonNull(pointered, "target"), null));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public Component deserialize(@NotNull String str, @NotNull TagResolver tagResolver) {
        return this.parser.parseFormat(newContext(str, null, (TagResolver) Objects.requireNonNull(tagResolver, "tagResolver")));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public Component deserialize(@NotNull String str, @NotNull Pointered pointered, @NotNull TagResolver tagResolver) {
        return this.parser.parseFormat(newContext(str, (Pointered) Objects.requireNonNull(pointered, "target"), (TagResolver) Objects.requireNonNull(tagResolver, "tagResolver")));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    public Node.Root deserializeToTree(@NotNull String str) {
        return this.parser.parseToTree(newContext(str, null, null));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    public Node.Root deserializeToTree(@NotNull String str, @NotNull Pointered pointered) {
        return this.parser.parseToTree(newContext(str, (Pointered) Objects.requireNonNull(pointered, "target"), null));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    public Node.Root deserializeToTree(@NotNull String str, @NotNull TagResolver tagResolver) {
        return this.parser.parseToTree(newContext(str, null, (TagResolver) Objects.requireNonNull(tagResolver, "tagResolver")));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    public Node.Root deserializeToTree(@NotNull String str, @NotNull Pointered pointered, @NotNull TagResolver tagResolver) {
        return this.parser.parseToTree(newContext(str, (Pointered) Objects.requireNonNull(pointered, "target"), (TagResolver) Objects.requireNonNull(tagResolver, "tagResolver")));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public String serialize(@NotNull Component component) {
        return MiniMessageSerializer.serialize(component, serialResolver(null), this.strict);
    }

    private SerializableResolver serialResolver(@Nullable TagResolver tagResolver) {
        if (tagResolver != null) {
            TagResolver tagResolverResolver = TagResolver.resolver(this.parser.tagResolver, tagResolver);
            if (tagResolverResolver instanceof SerializableResolver) {
                return (SerializableResolver) tagResolverResolver;
            }
        } else if (this.parser.tagResolver instanceof SerializableResolver) {
            return (SerializableResolver) this.parser.tagResolver;
        }
        return (SerializableResolver) TagResolver.empty();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public String escapeTags(@NotNull String str) {
        return this.parser.escapeTokens(newContext(str, null, null));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public String escapeTags(@NotNull String str, @NotNull TagResolver tagResolver) {
        return this.parser.escapeTokens(newContext(str, null, tagResolver));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public String stripTags(@NotNull String str) {
        return this.parser.stripTokens(newContext(str, null, null));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public String stripTags(@NotNull String str, @NotNull TagResolver tagResolver) {
        return this.parser.stripTokens(newContext(str, null, tagResolver));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    public boolean strict() {
        return this.strict;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage
    @NotNull
    public TagResolver tags() {
        return this.parser.tagResolver;
    }

    @NotNull
    private ContextImpl newContext(@NotNull String str, @Nullable Pointered pointered, @Nullable TagResolver tagResolver) {
        Objects.requireNonNull(str, "input");
        return new ContextImpl(this.strict, this.emitVirtuals, this.debugOutput, str, this, pointered, tagResolver, this.preProcessor, this.postProcessor);
    }
}
