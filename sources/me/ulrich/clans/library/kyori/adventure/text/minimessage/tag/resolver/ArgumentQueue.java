package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/ArgumentQueue.class */
@ApiStatus.NonExtendable
public interface ArgumentQueue {
    Tag.Argument pop();

    Tag.Argument popOr(@NotNull String str);

    Tag.Argument popOr(@NotNull Supplier<String> supplier);

    Tag.Argument peek();

    boolean hasNext();

    void reset();
}
