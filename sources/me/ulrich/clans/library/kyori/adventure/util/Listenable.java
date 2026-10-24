package me.ulrich.clans.library.kyori.adventure.util;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/util/Listenable.class */
public abstract class Listenable<L> {
    private final List<L> listeners = new CopyOnWriteArrayList();

    protected final void forEachListener(@NotNull Consumer<L> consumer) {
        Iterator<L> it = this.listeners.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    protected final void addListener0(@NotNull L l) {
        this.listeners.add(l);
    }

    protected final void removeListener0(@NotNull L l) {
        this.listeners.remove(l);
    }
}
