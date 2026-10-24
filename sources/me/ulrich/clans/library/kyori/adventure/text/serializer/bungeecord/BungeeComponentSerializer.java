package me.ulrich.clans.library.kyori.adventure.text.serializer.bungeecord;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/bungeecord/BungeeComponentSerializer.class */
public final class BungeeComponentSerializer implements ComponentSerializer<Component, Component, BaseComponent[]> {
    private static boolean SUPPORTED = true;
    private static final BungeeComponentSerializer MODERN;
    private static final BungeeComponentSerializer PRE_1_16;
    private final GsonComponentSerializer serializer;
    private final LegacyComponentSerializer legacySerializer;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/bungeecord/BungeeComponentSerializer$AdapterComponent.class */
    class AdapterComponent extends BaseComponent implements SelfSerializable {
        private final Component component;
        private volatile String legacy;

        AdapterComponent(Component component) {
            this.component = component;
        }

        public String toLegacyText() {
            if (this.legacy == null) {
                this.legacy = BungeeComponentSerializer.this.legacySerializer.serialize(this.component);
            }
            return this.legacy;
        }

        @NotNull
        public BaseComponent duplicate() {
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.bungeecord.SelfSerializable
        public void write(JsonWriter jsonWriter) {
            BungeeComponentSerializer.this.serializer.serializer().getAdapter(Component.class).write(jsonWriter, this.component);
        }
    }

    public static boolean isNative() {
        return SUPPORTED;
    }

    public static BungeeComponentSerializer get() {
        return MODERN;
    }

    public static BungeeComponentSerializer legacy() {
        return PRE_1_16;
    }

    public static BungeeComponentSerializer of(GsonComponentSerializer gsonComponentSerializer, LegacyComponentSerializer legacyComponentSerializer) {
        if (gsonComponentSerializer == null || legacyComponentSerializer == null) {
            return null;
        }
        return new BungeeComponentSerializer(gsonComponentSerializer, legacyComponentSerializer);
    }

    public static boolean inject(Gson gson) {
        boolean zInjectGson = GsonInjections.injectGson((Gson) Objects.requireNonNull(gson, "existing"), gsonBuilder -> {
            GsonComponentSerializer.gson().populator().apply(gsonBuilder);
            gsonBuilder.registerTypeAdapterFactory(new SelfSerializable.AdapterFactory());
        });
        SUPPORTED &= zInjectGson;
        return zInjectGson;
    }

    private BungeeComponentSerializer(GsonComponentSerializer gsonComponentSerializer, LegacyComponentSerializer legacyComponentSerializer) {
        this.serializer = gsonComponentSerializer;
        this.legacySerializer = legacyComponentSerializer;
    }

    private static void bind() {
        try {
            inject((Gson) GsonInjections.field(net.md_5.bungee.chat.ComponentSerializer.class, "gson").get(null));
        } catch (Throwable th) {
            SUPPORTED = false;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public Component deserialize(@NotNull BaseComponent[] baseComponentArr) {
        Objects.requireNonNull(baseComponentArr, "input");
        return (baseComponentArr.length == 1 && (baseComponentArr[0] instanceof AdapterComponent)) ? ((AdapterComponent) baseComponentArr[0]).component : this.serializer.deserialize(net.md_5.bungee.chat.ComponentSerializer.toString(baseComponentArr));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public BaseComponent[] serialize(@NotNull Component component) {
        Objects.requireNonNull(component, "component");
        return SUPPORTED ? new BaseComponent[]{new AdapterComponent(component)} : net.md_5.bungee.chat.ComponentSerializer.parse(this.serializer.serialize(component));
    }

    static {
        bind();
        MODERN = new BungeeComponentSerializer(GsonComponentSerializer.gson(), LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().build2());
        PRE_1_16 = new BungeeComponentSerializer(GsonComponentSerializer.builder().downsampleColors().emitLegacyHoverEvent().build2(), LegacyComponentSerializer.legacySection());
    }
}
