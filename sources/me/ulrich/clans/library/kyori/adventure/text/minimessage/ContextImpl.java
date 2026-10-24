package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.ParsingExceptionImpl;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.Token;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.node.TagPart;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/ContextImpl.class */
class ContextImpl implements Context {
    private static final Token[] EMPTY_TOKEN_ARRAY = new Token[0];
    private final boolean strict;
    private final boolean emitVirtuals;
    private final Consumer<String> debugOutput;
    private String message;
    private final MiniMessage miniMessage;

    @Nullable
    private final Pointered target;
    private final TagResolver tagResolver;
    private final UnaryOperator<String> preProcessor;
    private final UnaryOperator<Component> postProcessor;

    ContextImpl(boolean z, boolean z2, Consumer<String> consumer, String str, MiniMessage miniMessage, @Nullable Pointered pointered, @Nullable TagResolver tagResolver, @Nullable UnaryOperator<String> unaryOperator, @Nullable UnaryOperator<Component> unaryOperator2) {
        this.strict = z;
        this.emitVirtuals = z2;
        this.debugOutput = consumer;
        this.message = str;
        this.miniMessage = miniMessage;
        this.target = pointered;
        this.tagResolver = tagResolver == null ? TagResolver.empty() : tagResolver;
        this.preProcessor = unaryOperator == null ? UnaryOperator.identity() : unaryOperator;
        this.postProcessor = unaryOperator2 == null ? UnaryOperator.identity() : unaryOperator2;
    }

    public boolean strict() {
        return this.strict;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    public boolean emitVirtuals() {
        return this.emitVirtuals;
    }

    public Consumer<String> debugOutput() {
        return this.debugOutput;
    }

    @NotNull
    public String message() {
        return this.message;
    }

    void message(@NotNull String str) {
        this.message = str;
    }

    @NotNull
    public TagResolver extraTags() {
        return this.tagResolver;
    }

    public UnaryOperator<Component> postProcessor() {
        return this.postProcessor;
    }

    public UnaryOperator<String> preProcessor() {
        return this.preProcessor;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @Nullable
    public Pointered target() {
        return this.target;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public Pointered targetOrThrow() {
        if (this.target == null) {
            throw newException("A target is required for this deserialization attempt");
        }
        return this.target;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public <T extends Pointered> T targetAsType(@NotNull Class<T> cls) {
        if (((Class) Objects.requireNonNull(cls, "targetClass")).isInstance(this.target)) {
            return cls.cast(this.target);
        }
        throw newException("A target with type " + cls.getSimpleName() + " is required for this deserialization attempt");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public Component deserialize(@NotNull String str) {
        return deserializeWithOptionalTarget((String) Objects.requireNonNull(str, "message"), this.tagResolver);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public Component deserialize(@NotNull String str, @NotNull TagResolver tagResolver) {
        Objects.requireNonNull(str, "message");
        return deserializeWithOptionalTarget(str, TagResolver.builder().resolver(this.tagResolver).resolver(tagResolver).build());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public Component deserialize(@NotNull String str, @NotNull TagResolver... tagResolverArr) {
        Objects.requireNonNull(str, "message");
        return deserializeWithOptionalTarget(str, TagResolver.builder().resolver(this.tagResolver).resolvers(tagResolverArr).build());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public ParsingException newException(@NotNull String str) {
        return new ParsingExceptionImpl(str, this.message, null, false, EMPTY_TOKEN_ARRAY);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public ParsingException newException(@NotNull String str, @NotNull ArgumentQueue argumentQueue) {
        return new ParsingExceptionImpl(str, this.message, null, false, tagsToTokens(((ArgumentQueueImpl) argumentQueue).args));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.Context
    @NotNull
    public ParsingException newException(@NotNull String str, @Nullable Throwable th, @NotNull ArgumentQueue argumentQueue) {
        return new ParsingExceptionImpl(str, this.message, th, false, tagsToTokens(((ArgumentQueueImpl) argumentQueue).args));
    }

    @NotNull
    private Component deserializeWithOptionalTarget(@NotNull String str, @NotNull TagResolver tagResolver) {
        return this.target != null ? this.miniMessage.deserialize(str, this.target, tagResolver) : this.miniMessage.deserialize(str, tagResolver);
    }

    private static Token[] tagsToTokens(List<? extends Tag.Argument> list) {
        Token[] tokenArr = new Token[list.size()];
        int length = tokenArr.length;
        for (int i = 0; i < length; i++) {
            tokenArr[i] = ((TagPart) list.get(i)).token();
        }
        return tokenArr;
    }
}
