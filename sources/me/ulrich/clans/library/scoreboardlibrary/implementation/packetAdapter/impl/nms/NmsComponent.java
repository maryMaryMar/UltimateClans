package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.RelocatedGson;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ConstructorAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsComponent.class */
public final class NmsComponent {
    public static final boolean IS_NATIVE_ADVENTURE;
    private static final Object MINECRAFT_REGISTRY;
    private static final Object CODEC;
    private static final MethodHandle FROM_JSON_METHOD;
    private static final ConstructorAccessor<?> ADVENTURE_COMPONENT_CONSTRUCTOR;

    private NmsComponent() {
    }

    @NotNull
    public static Object fromAdventure(@NotNull Component component, @Nullable Locale locale) {
        if (IS_NATIVE_ADVENTURE) {
            return fromAdventureComponent(component);
        }
        Component componentRender = component;
        if (locale != null) {
            componentRender = GlobalTranslator.render(component, locale);
        }
        Object objConvertToServerGson = RelocatedGson.convertToServerGson(GsonComponentSerializer.gson().serializeToTree(componentRender));
        if (FROM_JSON_METHOD == null) {
            return ((Optional) NmsCodec.RESULT_UNWRAP_METHOD.invoke(NmsCodec.CODEC_PARSE.invoke(CODEC, NmsCodec.JSON_OPS, objConvertToServerGson))).get();
        }
        try {
            return FROM_JSON_METHOD.invokeWithArguments(MINECRAFT_REGISTRY != null ? new Object[]{objConvertToServerGson, MINECRAFT_REGISTRY} : new Object[]{objConvertToServerGson});
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static Object fromAdventureComponent(Component component) {
        return ((ConstructorAccessor) Objects.requireNonNull(ADVENTURE_COMPONENT_CONSTRUCTOR)).invoke(component);
    }

    static {
        ADVENTURE_COMPONENT_CONSTRUCTOR = NmsClasses.ADVENTURE_COMPONENT_CLASS != null ? ReflectUtil.findOptionalConstructor(NmsClasses.ADVENTURE_COMPONENT_CLASS, Component.class) : null;
        IS_NATIVE_ADVENTURE = NmsClasses.ADVENTURE_COMPONENT_CLASS != null && Component.class.getPackage().getName().equals("net.ky".concat("ori.adventure.text"));
        if (NmsClasses.IS_1_20_5_OR_ABOVE) {
            try {
                MINECRAFT_REGISTRY = NmsClasses.CRAFT_REGISTRY_CLASS.getMethod("getMinecraftRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else {
            MINECRAFT_REGISTRY = null;
        }
        if (NmsClasses.IS_1_21_6_OR_ABOVE) {
            CODEC = ReflectUtil.findFieldUnchecked(NmsClasses.COMPONENT_SERIALIZATION_CLASS, 0, NmsClasses.CODEC_CLASS, true).get(null);
            FROM_JSON_METHOD = null;
            return;
        }
        MethodHandle methodHandleUnreflect = null;
        for (Method method : NmsClasses.CHAT_SERIALIZER_CLASS.getMethods()) {
            if (method.getParameterCount() >= 1 && method.getParameterCount() <= 2 && method.getParameterTypes()[0].getName().equals(RelocatedGson.SERVER_GSON_PKG + ".JsonElement")) {
                try {
                    methodHandleUnreflect = MethodHandles.lookup().unreflect(method);
                    break;
                } catch (IllegalAccessException e2) {
                    throw new ExceptionInInitializerError(e2);
                }
            }
        }
        if (methodHandleUnreflect == null) {
            throw new ExceptionInInitializerError("failed to find chat component fromJson method");
        }
        FROM_JSON_METHOD = methodHandleUnreflect;
        CODEC = null;
    }
}
