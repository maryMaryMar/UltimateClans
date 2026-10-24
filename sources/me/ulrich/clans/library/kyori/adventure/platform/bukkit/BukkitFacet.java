package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import java.lang.invoke.MethodHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.permission.PermissionChecker;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Facet;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetPointers;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointer;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointers;
import me.ulrich.clans.library.kyori.adventure.sound.SoundStop;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.translation.Translator;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.bukkit.Bukkit;
import org.bukkit.SoundCategory;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet.class */
class BukkitFacet<V extends CommandSender> extends FacetBase<V> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$BossBar.class */
    static class BossBar extends Message<Player> implements Facet.BossBar<Player> {
        protected final org.bukkit.boss.BossBar bar;

        protected BossBar(@NotNull Collection<Player> collection) {
            super(Player.class);
            this.bar = Bukkit.createBossBar("", BarColor.PINK, BarStyle.SOLID, new BarFlag[0]);
            this.bar.setVisible(false);
            Iterator<Player> it = collection.iterator();
            while (it.hasNext()) {
                this.bar.addPlayer(it.next());
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void bossBarInitialized(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar) {
            super.bossBarInitialized(bossBar);
            this.bar.setVisible(true);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarNameChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, @NotNull Component component, @NotNull Component component2) {
            if (this.bar.getPlayers().isEmpty()) {
                return;
            }
            this.bar.setTitle(createMessage((Player) this.bar.getPlayers().get(0), component2));
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarProgressChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, float f, float f2) {
            this.bar.setProgress(f2);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarColorChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color color, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color color2) {
            BarColor barColorColor = color(color2);
            if (barColorColor != null) {
                this.bar.setColor(barColorColor);
            }
        }

        @Nullable
        private BarColor color(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color color) {
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.PINK) {
                return BarColor.PINK;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.BLUE) {
                return BarColor.BLUE;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.RED) {
                return BarColor.RED;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.GREEN) {
                return BarColor.GREEN;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.YELLOW) {
                return BarColor.YELLOW;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.PURPLE) {
                return BarColor.PURPLE;
            }
            if (color == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Color.WHITE) {
                return BarColor.WHITE;
            }
            Knob.logUnsupported(this, color);
            return null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarOverlayChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay overlay, me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay overlay2) {
            BarStyle barStyleStyle = style(overlay2);
            if (barStyleStyle != null) {
                this.bar.setStyle(barStyleStyle);
            }
        }

        @Nullable
        private BarStyle style(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay overlay) {
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.PROGRESS) {
                return BarStyle.SOLID;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_6) {
                return BarStyle.SEGMENTED_6;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_10) {
                return BarStyle.SEGMENTED_10;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_12) {
                return BarStyle.SEGMENTED_12;
            }
            if (overlay == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Overlay.NOTCHED_20) {
                return BarStyle.SEGMENTED_20;
            }
            Knob.logUnsupported(this, overlay);
            return null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Listener
        public void bossBarFlagsChanged(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar bossBar, @NotNull Set<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> set, @NotNull Set<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> set2) {
            Iterator<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> it = set2.iterator();
            while (it.hasNext()) {
                BarFlag barFlagFlag = flag(it.next());
                if (barFlagFlag != null) {
                    this.bar.removeFlag(barFlagFlag);
                }
            }
            Iterator<me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag> it2 = set.iterator();
            while (it2.hasNext()) {
                BarFlag barFlagFlag2 = flag(it2.next());
                if (barFlagFlag2 != null) {
                    this.bar.addFlag(barFlagFlag2);
                }
            }
        }

        @Nullable
        private BarFlag flag(me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag flag) {
            if (flag == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.DARKEN_SCREEN) {
                return BarFlag.DARKEN_SKY;
            }
            if (flag == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.PLAY_BOSS_MUSIC) {
                return BarFlag.PLAY_BOSS_MUSIC;
            }
            if (flag == me.ulrich.clans.library.kyori.adventure.bossbar.BossBar.Flag.CREATE_WORLD_FOG) {
                return BarFlag.CREATE_FOG;
            }
            Knob.logUnsupported(this, flag);
            return null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void addViewer(@NotNull Player player) {
            this.bar.addPlayer(player);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public void removeViewer(@NotNull Player player) {
            this.bar.removePlayer(player);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar
        public boolean isEmpty() {
            return !this.bar.isVisible() || this.bar.getPlayers().isEmpty();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.bar.removeAll();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$BossBarBuilder.class */
    static class BossBarBuilder extends BukkitFacet<Player> implements Facet.BossBar.Builder<Player, BossBar> {
        private static final boolean SUPPORTED = MinecraftReflection.hasClass("org.bukkit.boss.BossBar");

        protected BossBarBuilder() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.BossBar.Builder
        public BossBar createBossBar(@NotNull Collection<Player> collection) {
            return new BossBar(collection);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$Chat.class */
    static class Chat extends Message<CommandSender> implements Facet.Chat<CommandSender, String> {
        protected Chat() {
            super(CommandSender.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Chat
        public void sendMessage(@NotNull CommandSender commandSender, @NotNull Identity identity, @NotNull String str, @NotNull Object obj) {
            commandSender.sendMessage(str);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$CommandSenderPointers.class */
    static final class CommandSenderPointers extends BukkitFacet<CommandSender> implements Facet.Pointers<CommandSender> {
        CommandSenderPointers() {
            super(CommandSender.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Pointers
        public void contributePointers(CommandSender commandSender, Pointers.Builder builder) {
            Pointer<String> pointer = Identity.NAME;
            Objects.requireNonNull(commandSender);
            builder.withDynamic(pointer, commandSender::getName);
            builder.withStatic(PermissionChecker.POINTER, str -> {
                if (commandSender.isPermissionSet(str)) {
                    return commandSender.hasPermission(str) ? TriState.TRUE : TriState.FALSE;
                }
                return TriState.NOT_SET;
            });
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$ConsoleCommandSenderPointers.class */
    static final class ConsoleCommandSenderPointers extends BukkitFacet<ConsoleCommandSender> implements Facet.Pointers<ConsoleCommandSender> {
        ConsoleCommandSenderPointers() {
            super(ConsoleCommandSender.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Pointers
        public void contributePointers(ConsoleCommandSender consoleCommandSender, Pointers.Builder builder) {
            builder.withStatic(FacetPointers.TYPE, FacetPointers.Type.CONSOLE);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$Message.class */
    static class Message<V extends CommandSender> extends BukkitFacet<V> implements Facet.Message<V, String> {
        protected Message(@Nullable Class<? extends V> cls) {
            super(cls);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Message
        @NotNull
        public String createMessage(@NotNull V v, @NotNull Component component) {
            return BukkitComponentSerializer.legacy().serialize(component);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$PlayerPointers.class */
    static final class PlayerPointers extends BukkitFacet<Player> implements Facet.Pointers<Player> {
        private static final MethodHandle LOCALE_SUPPORTED;

        PlayerPointers() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Pointers
        public void contributePointers(Player player, Pointers.Builder builder) {
            Pointer<UUID> pointer = Identity.UUID;
            Objects.requireNonNull(player);
            builder.withDynamic(pointer, player::getUniqueId);
            builder.withDynamic(Identity.DISPLAY_NAME, () -> {
                return BukkitComponentSerializer.legacy().deserializeOrNull(player.getDisplayName());
            });
            builder.withDynamic(Identity.LOCALE, () -> {
                if (LOCALE_SUPPORTED != null) {
                    try {
                        Object objInvoke = (Object) LOCALE_SUPPORTED.invoke(player);
                        return objInvoke instanceof Locale ? (Locale) objInvoke : Translator.parseLocale((String) objInvoke);
                    } catch (Throwable th) {
                        Knob.logError(th, "Failed to call getLocale() for %s", player);
                    }
                }
                return Locale.getDefault();
            });
            builder.withStatic(FacetPointers.TYPE, FacetPointers.Type.PLAYER);
            builder.withDynamic(FacetPointers.WORLD, () -> {
                return Key.key(player.getWorld().getName());
            });
        }

        static {
            MethodHandle methodHandleFindMethod = MinecraftReflection.findMethod((Class<?>) Player.class, "getLocale", (Class<?>) Locale.class, (Class<?>[]) new Class[0]);
            LOCALE_SUPPORTED = methodHandleFindMethod != null ? methodHandleFindMethod : MinecraftReflection.findMethod((Class<?>) Player.class, "getLocale", (Class<?>) String.class, (Class<?>[]) new Class[0]);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$Position.class */
    static class Position extends BukkitFacet<Player> implements Facet.Position<Player, Vector> {
        protected Position() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Position
        @NotNull
        public Vector createPosition(@NotNull Player player) {
            return player.getLocation().toVector();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Position
        @NotNull
        public Vector createPosition(double d, double d2, double d3) {
            return new Vector(d, d2, d3);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$Sound.class */
    static class Sound extends Position implements Facet.Sound<Player, Vector> {
        private static final boolean KEY_SUPPORTED = MinecraftReflection.hasClass("org.bukkit.NamespacedKey");
        private static final boolean STOP_SUPPORTED = MinecraftReflection.hasMethod((Class<?>) Player.class, "stopSound", (Class<?>[]) new Class[]{String.class});
        private static final MethodHandle STOP_ALL_SUPPORTED = MinecraftReflection.findMethod((Class<?>) Player.class, "stopAllSounds", (Class<?>) Void.TYPE, (Class<?>[]) new Class[0]);

        Sound() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Sound
        public void playSound(@NotNull Player player, me.ulrich.clans.library.kyori.adventure.sound.Sound sound, @NotNull Vector vector) {
            player.playSound(vector.toLocation(player.getWorld()), name(sound.name()), sound.volume(), sound.pitch());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Sound
        public void stopSound(@NotNull Player player, @NotNull SoundStop soundStop) {
            if (STOP_SUPPORTED) {
                String strName = name(soundStop.sound());
                if (!strName.isEmpty() || STOP_ALL_SUPPORTED == null) {
                    player.stopSound(strName);
                    return;
                }
                try {
                    STOP_ALL_SUPPORTED.invoke(player);
                } catch (Throwable th) {
                    Knob.logError(th, "Could not invoke stopAllSounds on %s", player);
                }
            }
        }

        @NotNull
        protected static String name(@Nullable Key key) {
            if (key == null) {
                return "";
            }
            return KEY_SUPPORTED ? key.asString() : key.value();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$SoundWithCategory.class */
    static class SoundWithCategory extends Sound {
        private static final boolean SUPPORTED = MinecraftReflection.hasMethod((Class<?>) Player.class, "stopSound", (Class<?>[]) new Class[]{String.class, MinecraftReflection.findClass("org.bukkit.SoundCategory")});

        SoundWithCategory() {
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitFacet.Sound, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Sound
        public void playSound(@NotNull Player player, me.ulrich.clans.library.kyori.adventure.sound.Sound sound, @NotNull Vector vector) {
            SoundCategory soundCategoryCategory = category(sound.source());
            if (soundCategoryCategory == null) {
                super.playSound(player, sound, vector);
            } else {
                player.playSound(vector.toLocation(player.getWorld()), name(sound.name()), soundCategoryCategory, sound.volume(), sound.pitch());
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitFacet.Sound, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Sound
        public void stopSound(@NotNull Player player, @NotNull SoundStop soundStop) {
            SoundCategory soundCategoryCategory = category(soundStop.source());
            if (soundCategoryCategory == null) {
                super.stopSound(player, soundStop);
            } else {
                player.stopSound(name(soundStop.sound()), soundCategoryCategory);
            }
        }

        @Nullable
        private SoundCategory category(me.ulrich.clans.library.kyori.adventure.sound.Sound.Source source) {
            if (source == null) {
                return null;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.MASTER) {
                return SoundCategory.MASTER;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.MUSIC) {
                return SoundCategory.MUSIC;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.RECORD) {
                return SoundCategory.RECORDS;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.WEATHER) {
                return SoundCategory.WEATHER;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.BLOCK) {
                return SoundCategory.BLOCKS;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.HOSTILE) {
                return SoundCategory.HOSTILE;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.NEUTRAL) {
                return SoundCategory.NEUTRAL;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.PLAYER) {
                return SoundCategory.PLAYERS;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.AMBIENT) {
                return SoundCategory.AMBIENT;
            }
            if (source == me.ulrich.clans.library.kyori.adventure.sound.Sound.Source.VOICE) {
                return SoundCategory.VOICE;
            }
            Knob.logUnsupported(this, source);
            return null;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$TabList.class */
    static final class TabList extends Message<Player> implements Facet.TabList<Player, String> {
        private static final boolean SUPPORTED = MinecraftReflection.hasMethod((Class<?>) Player.class, "setPlayerListHeader", (Class<?>[]) new Class[]{String.class});

        TabList() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return SUPPORTED && super.isSupported();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.TabList
        public void send(Player player, @Nullable String str, @Nullable String str2) {
            if (str != null && str2 != null) {
                player.setPlayerListHeaderFooter(str, str2);
            } else if (str != null) {
                player.setPlayerListHeader(str);
            } else if (str2 != null) {
                player.setPlayerListFooter(str2);
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitFacet$ViaHook.class */
    static final class ViaHook implements Function<Player, UserConnection> {
        ViaHook() {
        }

        @Override // java.util.function.Function
        public UserConnection apply(@NotNull Player player) {
            return Via.getManager().getConnectionManager().getConnectedClient(player.getUniqueId());
        }
    }

    protected BukkitFacet(@Nullable Class<? extends V> cls) {
        super(cls);
    }
}
