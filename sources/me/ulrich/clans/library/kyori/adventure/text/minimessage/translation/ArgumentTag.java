package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import java.util.List;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/ArgumentTag.class */
final class ArgumentTag implements TagResolver {
    private static final String NAME = "argument";
    private static final String NAME_1 = "arg";
    private final List<Tag> arguments;
    private final TagResolver tagResolver;

    ArgumentTag(@NotNull List<Tag> list, @NotNull TagResolver tagResolver) {
        this.arguments = list;
        this.tagResolver = tagResolver;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    @Nullable
    public Tag resolve(@NotNull String str, @NotNull ArgumentQueue argumentQueue, @NotNull Context context) throws Throwable {
        if (!str.equals(NAME) && !str.equals(NAME_1)) {
            return this.tagResolver.resolve(str, argumentQueue, context);
        }
        int iOrElseThrow = argumentQueue.popOr("No argument number provided").asInt().orElseThrow(() -> {
            return context.newException("Invalid argument number", argumentQueue);
        });
        if (iOrElseThrow < 0 || iOrElseThrow >= this.arguments.size()) {
            throw context.newException("Invalid argument number", argumentQueue);
        }
        return this.arguments.get(iOrElseThrow);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver
    public boolean has(@NotNull String str) {
        return str.equals(NAME) || str.equals(NAME_1) || this.tagResolver.has(str);
    }
}
