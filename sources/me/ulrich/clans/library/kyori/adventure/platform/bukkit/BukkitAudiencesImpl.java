package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import com.google.common.collect.ImmutableList;
import com.google.common.graph.MutableGraph;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Level;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudienceProvider;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import me.ulrich.clans.library.kyori.adventure.pointer.Pointered;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.renderer.ComponentRenderer;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitAudiencesImpl.class */
final class BukkitAudiencesImpl extends FacetAudienceProvider<CommandSender, BukkitAudience> implements BukkitAudiences, Listener {
    private static final Map<String, BukkitAudiences> INSTANCES;
    private final Plugin plugin;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/BukkitAudiencesImpl$Builder.class */
    static final class Builder implements BukkitAudiences.Builder {

        @NotNull
        private final Plugin plugin;
        private ComponentRenderer<Pointered> componentRenderer;

        Builder(@NotNull Plugin plugin) {
            this.plugin = (Plugin) Objects.requireNonNull(plugin, "plugin");
            componentRenderer(pointered -> {
                return (Locale) pointered.getOrDefault(Identity.LOCALE, BukkitAudiencesImpl.DEFAULT_LOCALE);
            }, GlobalTranslator.renderer());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider.Builder
        @NotNull
        public Builder componentRenderer(@NotNull ComponentRenderer<Pointered> componentRenderer) {
            this.componentRenderer = (ComponentRenderer) Objects.requireNonNull(componentRenderer, "component renderer");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider.Builder
        public BukkitAudiences.Builder partition(@NotNull Function<Pointered, ?> function) {
            Objects.requireNonNull(function, "partitionFunction");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider.Builder
        @NotNull
        public BukkitAudiences build() {
            return (BukkitAudiences) BukkitAudiencesImpl.INSTANCES.computeIfAbsent(this.plugin.getName(), str -> {
                softDepend("ViaVersion");
                return new BukkitAudiencesImpl(this.plugin, this.componentRenderer);
            });
        }

        private void softDepend(@NotNull String str) {
            PluginDescriptionFile description = this.plugin.getDescription();
            if (description.getName().equals(str)) {
                return;
            }
            try {
                Field fieldNeedField = MinecraftReflection.needField(description.getClass(), "softDepend");
                List list = (List) fieldNeedField.get(description);
                if (!list.contains(str)) {
                    fieldNeedField.set(description, ImmutableList.builder().addAll(list).add(str).build());
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to inject softDepend in plugin.yml: %s %s", this.plugin, str);
            }
            try {
                PluginManager pluginManager = this.plugin.getServer().getPluginManager();
                ((MutableGraph) MinecraftReflection.needField(pluginManager.getClass(), "dependencyGraph").get(pluginManager)).putEdge(description.getName(), str);
            } catch (Throwable th2) {
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider.Builder
        public /* bridge */ /* synthetic */ AudienceProvider.Builder partition(@NotNull Function function) {
            return partition((Function<Pointered, ?>) function);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider.Builder
        @NotNull
        public /* bridge */ /* synthetic */ AudienceProvider.Builder componentRenderer(@NotNull ComponentRenderer componentRenderer) {
            return componentRenderer((ComponentRenderer<Pointered>) componentRenderer);
        }
    }

    static Builder builder(@NotNull Plugin plugin) {
        return new Builder(plugin);
    }

    static BukkitAudiences instanceFor(@NotNull Plugin plugin) {
        return builder(plugin).build();
    }

    BukkitAudiencesImpl(@NotNull Plugin plugin, @NotNull ComponentRenderer<Pointered> componentRenderer) {
        super(componentRenderer);
        this.plugin = (Plugin) Objects.requireNonNull(plugin, "plugin");
        addViewer(this.plugin.getServer().getConsoleSender());
        Iterator it = this.plugin.getServer().getOnlinePlayers().iterator();
        while (it.hasNext()) {
            addViewer((Player) it.next());
        }
        registerEvent(PlayerJoinEvent.class, EventPriority.LOWEST, playerJoinEvent -> {
            addViewer(playerJoinEvent.getPlayer());
        });
        registerEvent(PlayerQuitEvent.class, EventPriority.MONITOR, playerQuitEvent -> {
            removeViewer(playerQuitEvent.getPlayer());
        });
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitAudiences
    @NotNull
    public Audience sender(@NotNull CommandSender commandSender) {
        if (commandSender instanceof Player) {
            return player((Player) commandSender);
        }
        if (commandSender instanceof ConsoleCommandSender) {
            return console();
        }
        if (commandSender instanceof ProxiedCommandSender) {
            return sender(((ProxiedCommandSender) commandSender).getCallee());
        }
        return ((commandSender instanceof Entity) || (commandSender instanceof Block)) ? Audience.empty() : createAudience((Collection<CommandSender>) Collections.singletonList(commandSender));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.BukkitAudiences
    @NotNull
    public Audience player(@NotNull Player player) {
        return super.player(player.getUniqueId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudienceProvider
    @NotNull
    public BukkitAudience createAudience(@NotNull Collection<CommandSender> collection) {
        return new BukkitAudience(this.plugin, this, collection);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetAudienceProvider, me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider, java.lang.AutoCloseable
    public void close() {
        INSTANCES.remove(this.plugin.getName());
        super.close();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.AudienceProvider
    @NotNull
    public ComponentFlattener flattener() {
        return BukkitComponentSerializer.FLATTENER;
    }

    private <T extends Event> void registerEvent(@NotNull Class<T> cls, @NotNull EventPriority eventPriority, @NotNull Consumer<T> consumer) {
        Objects.requireNonNull(consumer, "callback");
        this.plugin.getServer().getPluginManager().registerEvent(cls, this, eventPriority, (listener, event) -> {
            consumer.accept(event);
        }, this.plugin, true);
    }

    static {
        Knob.OUT = str -> {
            Bukkit.getLogger().log(Level.INFO, str);
        };
        Knob.ERR = (str2, th) -> {
            Bukkit.getLogger().log(Level.WARNING, str2, th);
        };
        INSTANCES = Collections.synchronizedMap(new HashMap(4));
    }
}
