package me.ulrich.clans.library.kyori.adventure.platform.facet;

import java.io.Closeable;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.audience.MessageType;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.sound.SoundStop;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet.class */
@ApiStatus.Internal
public interface Facet<V> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$ActionBar.class */
    public interface ActionBar<V, M> extends Message<V, M> {
        void sendMessage(@NotNull V v, @NotNull M m);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Book.class */
    public interface Book<V, M, B> extends Message<V, M> {
        @Nullable
        B createBook(@NotNull String str, @NotNull String str2, @NotNull Iterable<M> iterable);

        void openBook(@NotNull V v, @NotNull B b);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$BossBar.class */
    public interface BossBar<V> extends Closeable, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener {
        public static final int PROTOCOL_BOSS_BAR = 356;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$BossBar$Builder.class */
        @FunctionalInterface
        public interface Builder<V, B extends BossBar<V>> extends Facet<V> {
            @NotNull
            B createBossBar(@NotNull Collection<V> collection);
        }

        default void bossBarInitialized(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar) {
            bossBarNameChanged(bossBar, bossBar.name(), bossBar.name());
            bossBarColorChanged(bossBar, bossBar.color(), bossBar.color());
            bossBarProgressChanged(bossBar, bossBar.progress(), bossBar.progress());
            bossBarFlagsChanged(bossBar, bossBar.flags(), Collections.emptySet());
            bossBarOverlayChanged(bossBar, bossBar.overlay(), bossBar.overlay());
        }

        void addViewer(@NotNull V v);

        void removeViewer(@NotNull V v);

        boolean isEmpty();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$BossBarEntity.class */
    public interface BossBarEntity<V, P> extends BossBar<V>, FakeEntity<V, P> {
        public static final int OFFSET_PITCH = 30;
        public static final int OFFSET_YAW = 0;
        public static final int OFFSET_MAGNITUDE = 40;
        public static final int INVULNERABLE_KEY = 20;
        public static final int INVULNERABLE_TICKS = 890;

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        default void bossBarProgressChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, float f, float f2) {
            health(f2);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        default void bossBarNameChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, @NotNull Component component, @NotNull Component component2) {
            name(component2);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        default void addViewer(@NotNull V v) {
            teleport(v, createPosition(v));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        default void removeViewer(@NotNull V v) {
            teleport(v, null);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$BossBarPacket.class */
    public interface BossBarPacket<V> extends BossBar<V> {
        public static final int ACTION_ADD = 0;
        public static final int ACTION_REMOVE = 1;
        public static final int ACTION_HEALTH = 2;
        public static final int ACTION_TITLE = 3;
        public static final int ACTION_STYLE = 4;
        public static final int ACTION_FLAG = 5;

        default int createColor(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color color) {
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.PURPLE) {
                return 5;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.PINK) {
                return 0;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.BLUE) {
                return 1;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.RED) {
                return 2;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.GREEN) {
                return 3;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.YELLOW) {
                return 4;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.WHITE) {
                return 6;
            }
            Knob.logUnsupported(this, color);
            return 5;
        }

        default int createOverlay(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay overlay) {
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.PROGRESS) {
                return 0;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_6) {
                return 1;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_10) {
                return 2;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_12) {
                return 3;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_20) {
                return 4;
            }
            Knob.logUnsupported(this, overlay);
            return 0;
        }

        default byte createFlag(byte b, @NotNull Set<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> set, @NotNull Set<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> set2) {
            byte b2 = b;
            for (me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag flag : set) {
                if (flag == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.DARKEN_SCREEN) {
                    b2 = (byte) (b2 | 1);
                } else if (flag == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.PLAY_BOSS_MUSIC) {
                    b2 = (byte) (b2 | 2);
                } else if (flag == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.CREATE_WORLD_FOG) {
                    b2 = (byte) (b2 | 4);
                } else {
                    Knob.logUnsupported(this, flag);
                }
            }
            for (me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag flag2 : set2) {
                if (flag2 == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.DARKEN_SCREEN) {
                    b2 = (byte) (b2 & (-2));
                } else if (flag2 == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.PLAY_BOSS_MUSIC) {
                    b2 = (byte) (b2 & (-3));
                } else if (flag2 == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.CREATE_WORLD_FOG) {
                    b2 = (byte) (b2 & (-5));
                } else {
                    Knob.logUnsupported(this, flag2);
                }
            }
            return b2;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Chat.class */
    public interface Chat<V, M> extends Message<V, M> {
        void sendMessage(@NotNull V v, @NotNull Identity identity, @NotNull M m, @NotNull Object obj);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$ChatPacket.class */
    public interface ChatPacket<V, M> extends Chat<V, M> {
        public static final byte TYPE_CHAT = 0;
        public static final byte TYPE_SYSTEM = 1;
        public static final byte TYPE_ACTION_BAR = 2;

        default byte createMessageType(@NotNull MessageType messageType) {
            if (messageType == MessageType.CHAT) {
                return (byte) 0;
            }
            if (messageType == MessageType.SYSTEM) {
                return (byte) 1;
            }
            Knob.logUnsupported(this, messageType);
            return (byte) 0;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$EntitySound.class */
    public interface EntitySound<V, M> extends Facet<V> {
        M createForSelf(V v, me.ulrich.clans.library.kyori.adventure.sound.Sound sound);

        M createForEmitter(me.ulrich.clans.library.kyori.adventure.sound.Sound sound, me.ulrich.clans.library.kyori.adventure.sound.Sound.Emitter emitter);

        void playSound(@NotNull V v, M m);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$FakeEntity.class */
    public interface FakeEntity<V, P> extends Closeable, Position<V, P> {
        void teleport(@NotNull V v, @Nullable P p);

        void metadata(int i, @NotNull Object obj);

        void invisible(boolean z);

        void health(float f);

        void name(@NotNull Component component);

        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Message.class */
    public interface Message<V, M> extends Facet<V> {
        public static final int PROTOCOL_HEX_COLOR = 713;
        public static final int PROTOCOL_JSON = 5;

        @Nullable
        M createMessage(@NotNull V v, @NotNull Component component);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Pointers.class */
    public interface Pointers<V> extends Facet<V> {
        void contributePointers(V v, me.ulrich.clans.library.kyori.adventure.pointer.Pointers.Builder builder);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Position.class */
    public interface Position<V, P> extends Facet<V> {
        @Nullable
        P createPosition(@NotNull V v);

        @NotNull
        P createPosition(double d, double d2, double d3);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Sound.class */
    public interface Sound<V, P> extends Position<V, P> {
        void playSound(@NotNull V v, me.ulrich.clans.library.kyori.adventure.sound.Sound sound, @NotNull P p);

        void stopSound(@NotNull V v, @NotNull SoundStop soundStop);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$TabList.class */
    public interface TabList<V, M> extends Message<V, M> {
        void send(V v, @Nullable M m, @Nullable M m2);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$Title.class */
    public interface Title<V, M, C, T> extends Message<V, M> {
        public static final int PROTOCOL_ACTION_BAR = 310;
        public static final long MAX_SECONDS = 461168601842738790L;

        @NotNull
        C createTitleCollection();

        void contributeTitle(@NotNull C c, @NotNull M m);

        void contributeSubtitle(@NotNull C c, @NotNull M m);

        void contributeTimes(@NotNull C c, int i, int i2, int i3);

        @Nullable
        T completeTitle(@NotNull C c);

        void showTitle(@NotNull V v, @NotNull T t);

        void clearTitle(@NotNull V v);

        void resetTitle(@NotNull V v);

        default int toTicks(@Nullable Duration duration) {
            if (duration == null || duration.isNegative()) {
                return -1;
            }
            if (duration.getSeconds() > MAX_SECONDS) {
                return Integer.MAX_VALUE;
            }
            return (int) ((duration.getSeconds() * 20) + ((long) (duration.getNano() / 50000000)));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/Facet$TitlePacket.class */
    public interface TitlePacket<V, M, C, T> extends Title<V, M, C, T> {
        public static final int ACTION_TITLE = 0;
        public static final int ACTION_SUBTITLE = 1;
        public static final int ACTION_ACTIONBAR = 2;
        public static final int ACTION_TIMES = 3;
        public static final int ACTION_CLEAR = 4;
        public static final int ACTION_RESET = 5;
    }

    @SafeVarargs
    @NotNull
    static <V, F extends Facet<? extends V>> Collection<F> of(@NotNull Supplier<F>... supplierArr) {
        LinkedList linkedList = new LinkedList();
        for (Supplier<F> supplier : supplierArr) {
            try {
                F f = supplier.get();
                if (f.isSupported()) {
                    linkedList.add(f);
                    Knob.logMessage("Added facet: %s", f);
                } else {
                    Knob.logMessage("Skipped facet: %s", f);
                }
            } catch (NoClassDefFoundError e) {
                Knob.logMessage("Skipped facet: %s", supplier.getClass().getName());
            } catch (Throwable th) {
                Knob.logError(th, "Failed facet: %s", supplier);
            }
        }
        return linkedList;
    }

    @Nullable
    static <V, F extends Facet<V>> F of(@Nullable Collection<F> collection, @Nullable V v) {
        if (collection == null || v == null) {
            return null;
        }
        for (F f : collection) {
            try {
                if (f.isApplicable(v)) {
                    Knob.logMessage("Selected facet: %s for %s", f, v);
                    return f;
                }
                if (Knob.DEBUG) {
                    Knob.logMessage("Not selecting %s for %s", f, v);
                }
            } catch (ClassCastException e) {
                if (Knob.DEBUG) {
                    Knob.logMessage("Exception while getting facet %s for %s: %s", f, v, e.getMessage());
                }
            }
        }
        return null;
    }

    default boolean isSupported() {
        return true;
    }

    default boolean isApplicable(@NotNull V v) {
        return true;
    }
}
