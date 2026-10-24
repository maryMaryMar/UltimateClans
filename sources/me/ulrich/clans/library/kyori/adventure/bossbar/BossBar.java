package me.ulrich.clans.library.kyori.adventure.bossbar;

import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.util.Index;
import me.ulrich.clans.library.kyori.examination.Examinable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBar.class */
@ApiStatus.NonExtendable
public interface BossBar extends Examinable {
    public static final float MIN_PROGRESS = 0.0f;
    public static final float MAX_PROGRESS = 1.0f;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final float MIN_PERCENT = 0.0f;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final float MAX_PERCENT = 1.0f;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBar$Color.class */
    public enum Color {
        PINK("pink"),
        BLUE("blue"),
        RED("red"),
        GREEN("green"),
        YELLOW("yellow"),
        PURPLE("purple"),
        WHITE("white");

        public static final Index<String, Color> NAMES = Index.create(Color.class, color -> {
            return color.name;
        });
        private final String name;

        Color(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBar$Flag.class */
    public enum Flag {
        DARKEN_SCREEN("darken_screen"),
        PLAY_BOSS_MUSIC("play_boss_music"),
        CREATE_WORLD_FOG("create_world_fog");

        public static final Index<String, Flag> NAMES = Index.create(Flag.class, flag -> {
            return flag.name;
        });
        private final String name;

        Flag(String str) {
            this.name = str;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBar$Listener.class */
    @ApiStatus.OverrideOnly
    public interface Listener {
        default void bossBarNameChanged(@NotNull BossBar bossBar, @NotNull Component component, @NotNull Component component2) {
        }

        default void bossBarProgressChanged(@NotNull BossBar bossBar, float f, float f2) {
            bossBarPercentChanged(bossBar, f, f2);
        }

        @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
        @Deprecated
        default void bossBarPercentChanged(@NotNull BossBar bossBar, float f, float f2) {
        }

        default void bossBarColorChanged(@NotNull BossBar bossBar, @NotNull Color color, @NotNull Color color2) {
        }

        default void bossBarOverlayChanged(@NotNull BossBar bossBar, @NotNull Overlay overlay, @NotNull Overlay overlay2) {
        }

        default void bossBarFlagsChanged(@NotNull BossBar bossBar, @NotNull Set<Flag> set, @NotNull Set<Flag> set2) {
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/bossbar/BossBar$Overlay.class */
    public enum Overlay {
        PROGRESS("progress"),
        NOTCHED_6("notched_6"),
        NOTCHED_10("notched_10"),
        NOTCHED_12("notched_12"),
        NOTCHED_20("notched_20");

        public static final Index<String, Overlay> NAMES = Index.create(Overlay.class, overlay -> {
            return overlay.name;
        });
        private final String name;

        Overlay(String str) {
            this.name = str;
        }
    }

    @NotNull
    static BossBar bossBar(@NotNull ComponentLike componentLike, float f, @NotNull Color color, @NotNull Overlay overlay) {
        BossBarImpl.checkProgress(f);
        return bossBar(componentLike.asComponent(), f, color, overlay);
    }

    @NotNull
    static BossBar bossBar(@NotNull Component component, float f, @NotNull Color color, @NotNull Overlay overlay) {
        BossBarImpl.checkProgress(f);
        return new BossBarImpl(component, f, color, overlay);
    }

    @NotNull
    static BossBar bossBar(@NotNull ComponentLike componentLike, float f, @NotNull Color color, @NotNull Overlay overlay, @NotNull Set<Flag> set) {
        BossBarImpl.checkProgress(f);
        return bossBar(componentLike.asComponent(), f, color, overlay, set);
    }

    @NotNull
    static BossBar bossBar(@NotNull Component component, float f, @NotNull Color color, @NotNull Overlay overlay, @NotNull Set<Flag> set) {
        BossBarImpl.checkProgress(f);
        return new BossBarImpl(component, f, color, overlay, set);
    }

    @NotNull
    Component name();

    @Contract("_ -> this")
    @NotNull
    default BossBar name(@NotNull ComponentLike componentLike) {
        return name(componentLike.asComponent());
    }

    @Contract("_ -> this")
    @NotNull
    BossBar name(@NotNull Component component);

    float progress();

    @Contract("_ -> this")
    @NotNull
    BossBar progress(float f);

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    default float percent() {
        return progress();
    }

    @Contract("_ -> this")
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    default BossBar percent(float f) {
        return progress(f);
    }

    @NotNull
    Color color();

    @Contract("_ -> this")
    @NotNull
    BossBar color(@NotNull Color color);

    @NotNull
    Overlay overlay();

    @Contract("_ -> this")
    @NotNull
    BossBar overlay(@NotNull Overlay overlay);

    @NotNull
    Set<Flag> flags();

    @Contract("_ -> this")
    @NotNull
    BossBar flags(@NotNull Set<Flag> set);

    boolean hasFlag(@NotNull Flag flag);

    @Contract("_ -> this")
    @NotNull
    BossBar addFlag(@NotNull Flag flag);

    @Contract("_ -> this")
    @NotNull
    BossBar removeFlag(@NotNull Flag flag);

    @Contract("_ -> this")
    @NotNull
    BossBar addFlags(@NotNull Flag... flagArr);

    @Contract("_ -> this")
    @NotNull
    BossBar removeFlags(@NotNull Flag... flagArr);

    @Contract("_ -> this")
    @NotNull
    BossBar addFlags(@NotNull Iterable<Flag> iterable);

    @Contract("_ -> this")
    @NotNull
    BossBar removeFlags(@NotNull Iterable<Flag> iterable);

    @Contract("_ -> this")
    @NotNull
    BossBar addListener(@NotNull Listener listener);

    @Contract("_ -> this")
    @NotNull
    BossBar removeListener(@NotNull Listener listener);

    @NotNull
    Iterable<? extends BossBarViewer> viewers();

    @NotNull
    default BossBar addViewer(@NotNull Audience audience) {
        audience.showBossBar(this);
        return this;
    }

    @NotNull
    default BossBar removeViewer(@NotNull Audience audience) {
        audience.hideBossBar(this);
        return this;
    }
}
