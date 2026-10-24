package me.ulrich.clans.library.kyori.adventure.platform.facet;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.permission.PermissionChecker;
import me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudience;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointers;
import me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetAudienceProvider.class */
@ApiStatus.Internal
public abstract class FacetAudienceProvider<V, A extends FacetAudience<V>> implements ForwardingAudience, AudienceProvider {
    protected static final Locale DEFAULT_LOCALE = Locale.US;
    protected final ComponentRenderer<Pointered> componentRenderer;
    private A empty;
    protected final Map<V, A> viewers = new ConcurrentHashMap();
    private final Map<UUID, A> players = new ConcurrentHashMap();
    private final Set<A> consoles = new CopyOnWriteArraySet();
    private final Audience console = new ForwardingAudience() { // from class: me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudienceProvider.1
        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience
        @NotNull
        public Iterable<? extends Audience> audiences() {
            return FacetAudienceProvider.this.consoles;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience, me.ulrich.clans.library.kyori.adventure.pointer.Pointered
        @NotNull
        public Pointers pointers() {
            return FacetAudienceProvider.this.consoles.size() == 1 ? ((FacetAudience) FacetAudienceProvider.this.consoles.iterator().next()).pointers() : Pointers.empty();
        }
    };
    private final Audience player = Audience.audience(this.players.values());
    private volatile boolean closed = false;

    protected FacetAudienceProvider(@NotNull ComponentRenderer<Pointered> componentRenderer) {
        this.componentRenderer = (ComponentRenderer) Objects.requireNonNull(componentRenderer, "component renderer");
    }

    public void addViewer(@NotNull V v) {
        if (this.closed) {
            return;
        }
        A aComputeIfAbsent = this.viewers.computeIfAbsent((V) Objects.requireNonNull(v, "viewer"), obj -> {
            return createAudience(Collections.singletonList(obj));
        });
        FacetPointers.Type type = (FacetPointers.Type) aComputeIfAbsent.getOrDefault(FacetPointers.TYPE, FacetPointers.Type.OTHER);
        if (type != FacetPointers.Type.PLAYER) {
            if (type == FacetPointers.Type.CONSOLE) {
                this.consoles.add(aComputeIfAbsent);
            }
        } else {
            UUID uuid = (UUID) aComputeIfAbsent.getOrDefault(Identity.UUID, null);
            if (uuid != null) {
                this.players.putIfAbsent(uuid, aComputeIfAbsent);
            }
        }
    }

    public void removeViewer(@NotNull V v) {
        A aRemove = this.viewers.remove(v);
        if (aRemove == null) {
            return;
        }
        FacetPointers.Type type = (FacetPointers.Type) aRemove.getOrDefault(FacetPointers.TYPE, FacetPointers.Type.OTHER);
        if (type == FacetPointers.Type.PLAYER) {
            UUID uuid = (UUID) aRemove.getOrDefault(Identity.UUID, null);
            if (uuid != null) {
                this.players.remove(uuid);
            }
        } else if (type == FacetPointers.Type.CONSOLE) {
            this.consoles.remove(aRemove);
        }
        aRemove.close();
    }

    public void refreshViewer(@NotNull V v) {
        A a2 = this.viewers.get(v);
        if (a2 != null) {
            a2.refresh();
        }
    }

    @NotNull
    protected abstract A createAudience(@NotNull Collection<V> collection);

    @Override // me.ulrich.clans.library.kyori.adventure.audience.ForwardingAudience
    @NotNull
    public Iterable<? extends Audience> audiences() {
        return this.viewers.values();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience all() {
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience console() {
        return this.console;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience players() {
        return this.player;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience player(@NotNull UUID uuid) {
        return this.players.getOrDefault(uuid, (A) empty());
    }

    @NotNull
    private A empty() {
        if (this.empty == null) {
            this.empty = (A) createAudience(Collections.emptyList());
        }
        return this.empty;
    }

    @NotNull
    public Audience filter(@NotNull Predicate<V> predicate) {
        return Audience.audience((Iterable<? extends Audience>) filter(this.viewers.entrySet(), entry -> {
            return predicate.test(entry.getKey());
        }, (v0) -> {
            return v0.getValue();
        }));
    }

    @NotNull
    private Audience filterPointers(@NotNull Predicate<Pointered> predicate) {
        return Audience.audience((Iterable<? extends Audience>) filter(this.viewers.entrySet(), entry -> {
            return predicate.test((Pointered) entry.getValue());
        }, (v0) -> {
            return v0.getValue();
        }));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience permission(@NotNull String str) {
        return filterPointers(pointered -> {
            return ((PermissionChecker) pointered.get(PermissionChecker.POINTER).orElse(PermissionChecker.always(TriState.FALSE))).test(str);
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience world(@NotNull Key key) {
        return filterPointers(pointered -> {
            return key.equals(pointered.getOrDefault(FacetPointers.WORLD, null));
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public Audience server(@NotNull String str) {
        return filterPointers(pointered -> {
            return str.equals(pointered.getOrDefault(FacetPointers.SERVER, null));
        });
    }

    public void close() {
        this.closed = true;
        Iterator<V> it = this.viewers.keySet().iterator();
        while (it.hasNext()) {
            removeViewer(it.next());
        }
    }

    @NotNull
    private static <T, V> Iterable<V> filter(@NotNull final Iterable<T> iterable, @NotNull final Predicate<T> predicate, @NotNull final Function<T, V> function) {
        return new Iterable<V>() { // from class: me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudienceProvider.2
            @Override // java.lang.Iterable
            @NotNull
            public Iterator<V> iterator() {
                return new Iterator<V>() { // from class: me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudienceProvider.2.1
                    private final Iterator<T> parent;
                    private V next;

                    {
                        this.parent = iterable.iterator();
                        populate();
                    }

                    private void populate() {
                        this.next = null;
                        while (this.parent.hasNext()) {
                            Object next = this.parent.next();
                            if (predicate.test(next)) {
                                this.next = (V) function.apply(next);
                                return;
                            }
                        }
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.next != null;
                    }

                    @Override // java.util.Iterator
                    public V next() {
                        if (this.next == null) {
                            throw new NoSuchElementException();
                        }
                        V v = this.next;
                        populate();
                        return v;
                    }
                };
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super V> consumer) {
                for (Object obj : iterable) {
                    if (predicate.test(obj)) {
                        consumer.accept((Object) function.apply(obj));
                    }
                }
            }
        };
    }
}
