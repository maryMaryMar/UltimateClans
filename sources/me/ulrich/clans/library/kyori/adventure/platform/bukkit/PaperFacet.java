package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Facet;
import me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/PaperFacet.class */
class PaperFacet<V extends CommandSender> extends FacetBase<V> {
    private static final boolean SUPPORTED = Knob.isEnabled("paper", true);
    static final Class<?> NATIVE_COMPONENT_CLASS = MinecraftReflection.findClass(String.join(".", "net", "kyori", Adventure.NAMESPACE, "text", "Component"));
    private static final MethodHandle PAPER_ADVENTURE_AS_VANILLA = findAsVanillaMethod();
    private static final Class<?> NATIVE_GSON_COMPONENT_SERIALIZER_CLASS = MinecraftReflection.findClass(String.join(".", "net", "kyori", Adventure.NAMESPACE, "text", "serializer", "gson", "GsonComponentSerializer"));
    private static final Class<?> NATIVE_GSON_COMPONENT_SERIALIZER_IMPL_CLASS = MinecraftReflection.findClass(String.join(".", "net", "kyori", Adventure.NAMESPACE, "text", "serializer", "gson", "GsonComponentSerializerImpl"));
    private static final MethodHandle NATIVE_GSON_COMPONENT_SERIALIZER_GSON_GETTER = MinecraftReflection.findStaticMethod(NATIVE_GSON_COMPONENT_SERIALIZER_CLASS, "gson", NATIVE_GSON_COMPONENT_SERIALIZER_CLASS, (Class<?>[]) new Class[0]);
    private static final MethodHandle NATIVE_GSON_COMPONENT_SERIALIZER_DESERIALIZE_METHOD = findNativeDeserializeMethod();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/PaperFacet$TabList.class */
    static class TabList extends CraftBukkitFacet.TabList {
        private static final boolean SUPPORTED;
        private static final MethodHandle NATIVE_GSON_COMPONENT_SERIALIZER_DESERIALIZE_METHOD_BOUND;

        TabList() {
        }

        @Nullable
        private static MethodHandle createBoundNativeDeserializeMethodHandle() {
            if (!SUPPORTED) {
                return null;
            }
            try {
                return PaperFacet.NATIVE_GSON_COMPONENT_SERIALIZER_DESERIALIZE_METHOD.bindTo((Object) PaperFacet.NATIVE_GSON_COMPONENT_SERIALIZER_GSON_GETTER.invoke());
            } catch (Throwable th) {
                Knob.logError(th, "Failed to access native GsonComponentSerializer", new Object[0]);
                return null;
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.TabList, me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return SUPPORTED && super.isSupported() && !((CLIENTBOUND_TAB_LIST_PACKET_SET_HEADER == null || CLIENTBOUND_TAB_LIST_PACKET_SET_FOOTER == null) && PaperFacet.PAPER_ADVENTURE_AS_VANILLA == null);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.TabList
        protected Object create117Packet(Player player, @Nullable Object obj, @Nullable Object obj2) {
            if (CLIENTBOUND_TAB_LIST_PACKET_SET_FOOTER == null && CLIENTBOUND_TAB_LIST_PACKET_SET_HEADER == null) {
                return (Object) CLIENTBOUND_TAB_LIST_PACKET_CTOR.invoke((Object) PaperFacet.PAPER_ADVENTURE_AS_VANILLA.invoke(obj == null ? createMessage(player, (Component) Component.empty()) : obj), (Object) PaperFacet.PAPER_ADVENTURE_AS_VANILLA.invoke(obj2 == null ? createMessage(player, (Component) Component.empty()) : obj2));
            }
            Object objInvoke = (Object) CLIENTBOUND_TAB_LIST_PACKET_CTOR.invoke(null, null);
            CLIENTBOUND_TAB_LIST_PACKET_SET_HEADER.invoke(objInvoke, obj == null ? createMessage(player, (Component) Component.empty()) : obj);
            CLIENTBOUND_TAB_LIST_PACKET_SET_FOOTER.invoke(objInvoke, obj2 == null ? createMessage(player, (Component) Component.empty()) : obj2);
            return objInvoke;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.CraftBukkitFacet.PacketFacet
        @Nullable
        public Object createMessage(@NotNull Player player, @NotNull Component component) {
            try {
                return (Object) NATIVE_GSON_COMPONENT_SERIALIZER_DESERIALIZE_METHOD_BOUND.invoke(GsonComponentSerializer.gson().serialize(component));
            } catch (Throwable th) {
                Knob.logError(th, "Failed to create native Component message", new Object[0]);
                return null;
            }
        }

        static {
            SUPPORTED = MinecraftReflection.hasField(CLASS_CRAFT_PLAYER, PaperFacet.NATIVE_COMPONENT_CLASS, "playerListHeader") && MinecraftReflection.hasField(CLASS_CRAFT_PLAYER, PaperFacet.NATIVE_COMPONENT_CLASS, "playerListFooter");
            NATIVE_GSON_COMPONENT_SERIALIZER_DESERIALIZE_METHOD_BOUND = createBoundNativeDeserializeMethodHandle();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/PaperFacet$Title.class */
    static class Title extends SpigotFacet.Message<Player> implements Facet.Title<Player, BaseComponent[], com.destroystokyo.paper.Title.Builder, com.destroystokyo.paper.Title> {
        private static final boolean SUPPORTED = MinecraftReflection.hasClass("com.destroystokyo.paper.Title");

        protected Title() {
            super(Player.class);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.bukkit.SpigotFacet, me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
        public boolean isSupported() {
            return super.isSupported() && SUPPORTED;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public com.destroystokyo.paper.Title.Builder createTitleCollection() {
            return com.destroystokyo.paper.Title.builder();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTitle(com.destroystokyo.paper.Title.Builder builder, BaseComponent[] baseComponentArr) {
            builder.title(baseComponentArr);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeSubtitle(com.destroystokyo.paper.Title.Builder builder, BaseComponent[] baseComponentArr) {
            builder.subtitle(baseComponentArr);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void contributeTimes(com.destroystokyo.paper.Title.Builder builder, int i, int i2, int i3) {
            if (i > -1) {
                builder.fadeIn(i);
            }
            if (i2 > -1) {
                builder.stay(i2);
            }
            if (i3 > -1) {
                builder.fadeOut(i3);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        @Nullable
        public com.destroystokyo.paper.Title completeTitle(com.destroystokyo.paper.Title.Builder builder) {
            return builder.build();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void showTitle(@NotNull Player player, com.destroystokyo.paper.Title title) {
            player.sendTitle(title);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void clearTitle(@NotNull Player player) {
            player.hideTitle();
        }

        @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.Facet.Title
        public void resetTitle(@NotNull Player player) {
            player.resetTitle();
        }
    }

    @Nullable
    private static MethodHandle findAsVanillaMethod() {
        try {
            return MinecraftReflection.lookup().unreflect(MinecraftReflection.findClass("io.papermc.paper.adventure.PaperAdventure").getDeclaredMethod("asVanilla", NATIVE_COMPONENT_CLASS));
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException e) {
            return null;
        }
    }

    @Nullable
    private static MethodHandle findNativeDeserializeMethod() {
        try {
            Method declaredMethod = NATIVE_GSON_COMPONENT_SERIALIZER_IMPL_CLASS.getDeclaredMethod("deserialize", String.class);
            declaredMethod.setAccessible(true);
            return MinecraftReflection.lookup().unreflect(declaredMethod);
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException e) {
            return null;
        }
    }

    protected PaperFacet(@Nullable Class<? extends V> cls) {
        super(cls);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.platform.facet.FacetBase, me.ulrich.clans.library.kyori.adventure.platform.facet.Facet
    public boolean isSupported() {
        return super.isSupported() && SUPPORTED;
    }
}
