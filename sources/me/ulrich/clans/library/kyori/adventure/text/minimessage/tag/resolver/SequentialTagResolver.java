package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.Arrays;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.ParsingException;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/SequentialTagResolver.class */
final class SequentialTagResolver implements SerializableResolver, TagResolver {
    final TagResolver[] resolvers;

    SequentialTagResolver(@NotNull TagResolver[] tagResolverArr) {
        this.resolvers = tagResolverArr;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    @Nullable
    public Tag resolve(@NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) {
        Tag tagResolve;
        ParsingException parsingException = null;
        for (TagResolver tagResolver : this.resolvers) {
            try {
                if (tagResolver.has(str) && (tagResolve = tagResolver.resolve(str, argumentQueue, context)) != null) {
                    return tagResolve;
                }
            } catch (ParsingException e) {
                argumentQueue.reset();
                if (parsingException == null) {
                    parsingException = e;
                } else {
                    parsingException.addSuppressed(e);
                }
            } catch (Exception e2) {
                argumentQueue.reset();
                ParsingException parsingExceptionNewException = context.newException("Exception thrown while parsing <" + str + ">", e2, argumentQueue);
                if (parsingException == null) {
                    parsingException = parsingExceptionNewException;
                } else {
                    parsingException.addSuppressed(parsingExceptionNewException);
                }
            }
        }
        if (parsingException != null) {
            throw parsingException;
        }
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        for (TagResolver tagResolver : this.resolvers) {
            if (tagResolver.has(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver
    public void handle(@NotNull Component component, @NotNull ClaimConsumer claimConsumer) {
        for (TagResolver tagResolver : this.resolvers) {
            if (tagResolver instanceof SerializableResolver) {
                ((SerializableResolver) tagResolver).handle(component, claimConsumer);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SequentialTagResolver) {
            return Arrays.equals(this.resolvers, ((SequentialTagResolver) obj).resolvers);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.resolvers);
    }
}
