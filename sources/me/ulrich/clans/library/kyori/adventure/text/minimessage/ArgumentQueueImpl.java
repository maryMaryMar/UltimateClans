package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag.Argument;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/ArgumentQueueImpl.class */
final class ArgumentQueueImpl<T extends Tag.Argument> implements ArgumentQueue {
    private final Context context;
    final List<T> args;
    private int ptr = 0;

    ArgumentQueueImpl(Context context, List<T> list) {
        this.context = context;
        this.args = list;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue
    @NotNull
    public T pop() {
        if (!hasNext()) {
            throw this.context.newException("Missing argument for this tag!", this);
        }
        List<T> list = this.args;
        int i = this.ptr;
        this.ptr = i + 1;
        return list.get(i);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue
    @NotNull
    public T popOr(@NotNull String str) {
        Objects.requireNonNull(str, "errorMessage");
        if (!hasNext()) {
            throw this.context.newException(str, this);
        }
        List<T> list = this.args;
        int i = this.ptr;
        this.ptr = i + 1;
        return list.get(i);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue
    @NotNull
    public T popOr(@NotNull Supplier<String> supplier) {
        Objects.requireNonNull(supplier, "errorMessage");
        if (!hasNext()) {
            throw this.context.newException((String) Objects.requireNonNull(supplier.get(), "errorMessage.get()"), this);
        }
        List<T> list = this.args;
        int i = this.ptr;
        this.ptr = i + 1;
        return list.get(i);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue
    @Nullable
    public T peek() {
        if (hasNext()) {
            return this.args.get(this.ptr);
        }
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue
    public boolean hasNext() {
        return this.ptr < this.args.size();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue
    public void reset() {
        this.ptr = 0;
    }

    public String toString() {
        return this.args.toString();
    }
}
