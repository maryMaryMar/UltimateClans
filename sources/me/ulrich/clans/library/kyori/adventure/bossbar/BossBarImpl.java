package me.ulrich.clans.library.kyori.adventure.bossbar;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBarImpl.class */
final class BossBarImpl extends HackyBossBarPlatformBridge implements BossBar {
    private final List<BossBar.Listener> listeners;
    private Component name;
    private float progress;
    private BossBar.Color color;
    private BossBar.Overlay overlay;
    private final Set<BossBar.Flag> flags;

    @Nullable
    BossBarImplementation implementation;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBarImpl$ImplementationAccessor.class */
    @ApiStatus.Internal
    static final class ImplementationAccessor {
        private static final Optional<BossBarImplementation.Provider> SERVICE = Services.service(BossBarImplementation.Provider.class);

        private ImplementationAccessor() {
        }

        @NotNull
        static <I extends BossBarImplementation> I get(@NotNull BossBar bossBar, @NotNull Class<I> cls) {
            BossBarImplementation bossBarImplementationCreate = ((BossBarImpl) bossBar).implementation;
            if (bossBarImplementationCreate == null) {
                bossBarImplementationCreate = SERVICE.get().create(bossBar);
                ((BossBarImpl) bossBar).implementation = bossBarImplementationCreate;
            }
            return cls.cast(bossBarImplementationCreate);
        }
    }

    BossBarImpl(@NotNull Component component, float f, @NotNull BossBar.Color color, @NotNull BossBar.Overlay overlay) {
        this.listeners = new CopyOnWriteArrayList();
        this.flags = EnumSet.noneOf(BossBar.Flag.class);
        this.name = (Component) Objects.requireNonNull(component, "name");
        this.progress = f;
        this.color = (BossBar.Color) Objects.requireNonNull(color, "color");
        this.overlay = (BossBar.Overlay) Objects.requireNonNull(overlay, "overlay");
    }

    BossBarImpl(@NotNull Component component, float f, @NotNull BossBar.Color color, @NotNull BossBar.Overlay overlay, @NotNull Set<BossBar.Flag> set) {
        this(component, f, color, overlay);
        this.flags.addAll(set);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public Component name() {
        return this.name;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar name(@NotNull Component component) {
        Objects.requireNonNull(component, "name");
        Component component2 = this.name;
        this.name = component;
        forEachListener(listener -> {
            listener.bossBarNameChanged(this, component2, component);
        });
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    public float progress() {
        return this.progress;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar progress(float f) {
        checkProgress(f);
        float f2 = this.progress;
        if (f != f2) {
            this.progress = f;
            forEachListener(listener -> {
                listener.bossBarProgressChanged(this, f2, f);
            });
        }
        return this;
    }

    static void checkProgress(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("progress must be between 0.0 and 1.0, was " + f);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar.Color color() {
        return this.color;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar color(@NotNull BossBar.Color color) {
        Objects.requireNonNull(color, "color");
        BossBar.Color color2 = this.color;
        if (color != color2) {
            this.color = color;
            forEachListener(listener -> {
                listener.bossBarColorChanged(this, color2, color);
            });
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar.Overlay overlay() {
        return this.overlay;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar overlay(@NotNull BossBar.Overlay overlay) {
        Objects.requireNonNull(overlay, "overlay");
        BossBar.Overlay overlay2 = this.overlay;
        if (overlay != overlay2) {
            this.overlay = overlay;
            forEachListener(listener -> {
                listener.bossBarOverlayChanged(this, overlay2, overlay);
            });
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public Set<BossBar.Flag> flags() {
        return Collections.unmodifiableSet(this.flags);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar flags(@NotNull Set<BossBar.Flag> set) {
        if (set.isEmpty() && !this.flags.isEmpty()) {
            EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) this.flags);
            this.flags.clear();
            forEachListener(listener -> {
                listener.bossBarFlagsChanged(this, Collections.emptySet(), enumSetCopyOf);
            });
        } else if (!this.flags.equals(set)) {
            EnumSet enumSetCopyOf2 = EnumSet.copyOf((Collection) this.flags);
            this.flags.clear();
            this.flags.addAll(set);
            EnumSet enumSetCopyOf3 = EnumSet.copyOf((Collection) set);
            Objects.requireNonNull(enumSetCopyOf2);
            enumSetCopyOf3.removeIf((v1) -> {
                return r1.contains(v1);
            });
            EnumSet enumSetCopyOf4 = EnumSet.copyOf((Collection) enumSetCopyOf2);
            Set<BossBar.Flag> set2 = this.flags;
            Objects.requireNonNull(set2);
            enumSetCopyOf4.removeIf((v1) -> {
                return r1.contains(v1);
            });
            forEachListener(listener2 -> {
                listener2.bossBarFlagsChanged(this, enumSetCopyOf3, enumSetCopyOf4);
            });
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    public boolean hasFlag(@NotNull BossBar.Flag flag) {
        return this.flags.contains(flag);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar addFlag(@NotNull BossBar.Flag flag) {
        return editFlags(flag, (v0, v1) -> {
            return v0.add(v1);
        }, BossBarImpl::onFlagsAdded);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar removeFlag(@NotNull BossBar.Flag flag) {
        return editFlags(flag, (v0, v1) -> {
            return v0.remove(v1);
        }, BossBarImpl::onFlagsRemoved);
    }

    @NotNull
    private BossBar editFlags(@NotNull BossBar.Flag flag, @NotNull BiPredicate<Set<BossBar.Flag>, BossBar.Flag> biPredicate, BiConsumer<BossBarImpl, Set<BossBar.Flag>> biConsumer) {
        if (biPredicate.test(this.flags, flag)) {
            biConsumer.accept(this, Collections.singleton(flag));
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar addFlags(@NotNull BossBar.Flag... flagArr) {
        return editFlags(flagArr, (v0, v1) -> {
            return v0.add(v1);
        }, BossBarImpl::onFlagsAdded);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar removeFlags(@NotNull BossBar.Flag... flagArr) {
        return editFlags(flagArr, (v0, v1) -> {
            return v0.remove(v1);
        }, BossBarImpl::onFlagsRemoved);
    }

    @NotNull
    private BossBar editFlags(BossBar.Flag[] flagArr, BiPredicate<Set<BossBar.Flag>, BossBar.Flag> biPredicate, BiConsumer<BossBarImpl, Set<BossBar.Flag>> biConsumer) {
        if (flagArr.length == 0) {
            return this;
        }
        EnumSet enumSetNoneOf = null;
        int length = flagArr.length;
        for (int i = 0; i < length; i++) {
            if (biPredicate.test(this.flags, flagArr[i])) {
                if (enumSetNoneOf == null) {
                    enumSetNoneOf = EnumSet.noneOf(BossBar.Flag.class);
                }
                enumSetNoneOf.add(flagArr[i]);
            }
        }
        if (enumSetNoneOf != null) {
            biConsumer.accept(this, enumSetNoneOf);
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar addFlags(@NotNull Iterable<BossBar.Flag> iterable) {
        return editFlags(iterable, (v0, v1) -> {
            return v0.add(v1);
        }, BossBarImpl::onFlagsAdded);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar removeFlags(@NotNull Iterable<BossBar.Flag> iterable) {
        return editFlags(iterable, (v0, v1) -> {
            return v0.remove(v1);
        }, BossBarImpl::onFlagsRemoved);
    }

    @NotNull
    private BossBar editFlags(Iterable<BossBar.Flag> iterable, BiPredicate<Set<BossBar.Flag>, BossBar.Flag> biPredicate, BiConsumer<BossBarImpl, Set<BossBar.Flag>> biConsumer) {
        EnumSet enumSetNoneOf = null;
        for (BossBar.Flag flag : iterable) {
            if (biPredicate.test(this.flags, flag)) {
                if (enumSetNoneOf == null) {
                    enumSetNoneOf = EnumSet.noneOf(BossBar.Flag.class);
                }
                enumSetNoneOf.add(flag);
            }
        }
        if (enumSetNoneOf != null) {
            biConsumer.accept(this, enumSetNoneOf);
        }
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar addListener(@NotNull BossBar.Listener listener) {
        this.listeners.add(listener);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public BossBar removeListener(@NotNull BossBar.Listener listener) {
        this.listeners.remove(listener);
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar
    @NotNull
    public Iterable<? extends BossBarViewer> viewers() {
        return this.implementation != null ? this.implementation.viewers() : Collections.emptyList();
    }

    private void forEachListener(@NotNull Consumer<BossBar.Listener> consumer) {
        Iterator<BossBar.Listener> it = this.listeners.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    private static void onFlagsAdded(BossBarImpl bossBarImpl, Set<BossBar.Flag> set) {
        bossBarImpl.forEachListener(listener -> {
            listener.bossBarFlagsChanged(bossBarImpl, set, Collections.emptySet());
        });
    }

    private static void onFlagsRemoved(BossBarImpl bossBarImpl, Set<BossBar.Flag> set) {
        bossBarImpl.forEachListener(listener -> {
            listener.bossBarFlagsChanged(bossBarImpl, Collections.emptySet(), set);
        });
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("name", this.name), ExaminableProperty.of("progress", this.progress), ExaminableProperty.of("color", this.color), ExaminableProperty.of("overlay", this.overlay), ExaminableProperty.of("flags", this.flags)});
    }

    public String toString() {
        return Internals.toString(this);
    }
}
