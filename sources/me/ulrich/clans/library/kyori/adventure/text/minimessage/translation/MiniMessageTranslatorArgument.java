package me.ulrich.clans.library.kyori.adventure.text.minimessage.translation;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.TagPattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/translation/MiniMessageTranslatorArgument.class */
final class MiniMessageTranslatorArgument<T> implements VirtualComponentRenderer<Void> {

    @NotNull
    private final String name;

    @NotNull
    private final T data;

    MiniMessageTranslatorArgument(@TagPattern @NotNull String str, @NotNull T t) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(t, "data");
        TagInternals.assertValidTagName(str);
        this.name = str;
        this.data = t;
    }

    @NotNull
    public String name() {
        return this.name;
    }

    @NotNull
    public T data() {
        return this.data;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.VirtualComponentRenderer
    public ComponentLike apply(@NotNull Void r3) {
        if (this.data instanceof ComponentLike) {
            return (ComponentLike) this.data;
        }
        return null;
    }
}
