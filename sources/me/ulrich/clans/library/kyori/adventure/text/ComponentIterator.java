package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ComponentIterator.class */
final class ComponentIterator implements Iterator<Component> {
    private Component component;
    private final ComponentIteratorType type;
    private final Set<ComponentIteratorFlag> flags;
    private final Deque<Component> deque = new ArrayDeque();

    ComponentIterator(@NotNull Component component, @NotNull ComponentIteratorType componentIteratorType, @NotNull Set<ComponentIteratorFlag> set) {
        this.component = component;
        this.type = componentIteratorType;
        this.flags = set;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return (this.component == null && this.deque.isEmpty()) ? false : true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Component next() {
        if (this.component != null) {
            Component component = this.component;
            this.component = null;
            this.type.populate(component, this.deque, this.flags);
            return component;
        }
        if (this.deque.isEmpty()) {
            throw new NoSuchElementException();
        }
        this.component = this.deque.poll();
        return next();
    }
}
