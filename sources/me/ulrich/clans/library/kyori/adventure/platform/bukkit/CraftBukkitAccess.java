package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Optional;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.platform.facet.Knob;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitAccess.class */
final class CraftBukkitAccess {

    @Nullable
    static final Class<?> CLASS_CHAT_COMPONENT = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("IChatBaseComponent"), MinecraftReflection.findMcClassName("network.chat.IChatBaseComponent"), MinecraftReflection.findMcClassName("network.chat.Component"));

    @Nullable
    static final Class<?> CLASS_REGISTRY = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("IRegistry"), MinecraftReflection.findMcClassName("core.IRegistry"), MinecraftReflection.findMcClassName("core.Registry"));

    @Nullable
    static final Class<?> CLASS_SERVER_LEVEL = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("server.level.WorldServer"), MinecraftReflection.findMcClassName("server.level.ServerLevel"));

    @Nullable
    static final Class<?> CLASS_LEVEL = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("world.level.World"), MinecraftReflection.findMcClassName("world.level.Level"));

    @Nullable
    static final Class<?> CLASS_REGISTRY_ACCESS = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("core.IRegistryCustom"), MinecraftReflection.findMcClassName("core.RegistryAccess"));

    @Nullable
    static final Class<?> CLASS_RESOURCE_KEY = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("resources.ResourceKey"));

    @Nullable
    static final Class<?> CLASS_RESOURCE_LOCATION = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("MinecraftKey"), MinecraftReflection.findMcClassName("resources.MinecraftKey"), MinecraftReflection.findMcClassName("resources.ResourceLocation"));

    @Nullable
    static final Class<?> CLASS_NMS_ENTITY = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("Entity"), MinecraftReflection.findMcClassName("world.entity.Entity"));

    @Nullable
    static final Class<?> CLASS_BUILT_IN_REGISTRIES = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("core.registries.BuiltInRegistries"));

    @Nullable
    static final Class<?> CLASS_HOLDER = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("core.Holder"));

    @Nullable
    static final Class<?> CLASS_WRITABLE_REGISTRY = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("IRegistryWritable"), MinecraftReflection.findMcClassName("core.IRegistryWritable"), MinecraftReflection.findMcClassName("core.WritableRegistry"));

    @Nullable
    static final MethodHandle NEW_RESOURCE_LOCATION;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitAccess$Book_1_20_5.class */
    static final class Book_1_20_5 {
        static final Object WRITTEN_BOOK_COMPONENT_TYPE;
        static final Class<?> CLASS_CRAFT_ITEMSTACK = MinecraftReflection.findCraftClass("inventory.CraftItemStack");
        static final Class<?> CLASS_MC_ITEMSTACK = MinecraftReflection.findMcClass("world.item.ItemStack");
        static final Class<?> CLASS_MC_DATA_COMPONENT_TYPE = MinecraftReflection.findMcClass("core.component.DataComponentType");
        static final Class<?> CLASS_MC_BOOK_CONTENT = MinecraftReflection.findMcClass("world.item.component.WrittenBookContent");
        static final Class<?> CLASS_MC_FILTERABLE = MinecraftReflection.findMcClass("server.network.Filterable");
        static final Class<?> CLASS_CRAFT_REGISTRY = MinecraftReflection.findCraftClass("CraftRegistry");
        static final MethodHandle CREATE_FILTERABLE = MinecraftReflection.searchMethod(CLASS_MC_FILTERABLE, (Integer) 9, "passThrough", CLASS_MC_FILTERABLE, (Class<?>[]) new Class[]{Object.class});
        static final MethodHandle GET_REGISTRY = MinecraftReflection.findStaticMethod(CLASS_CRAFT_REGISTRY, "getMinecraftRegistry", CraftBukkitAccess.CLASS_REGISTRY, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_KEY});
        static final MethodHandle CREATE_REGISTRY_KEY = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_RESOURCE_KEY, (Integer) 9, "createRegistryKey", CraftBukkitAccess.CLASS_RESOURCE_KEY, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});
        static final MethodHandle NEW_BOOK_CONTENT = MinecraftReflection.findConstructor(CLASS_MC_BOOK_CONTENT, CLASS_MC_FILTERABLE, String.class, Integer.TYPE, List.class, Boolean.TYPE);
        static final MethodHandle REGISTRY_GET_OPTIONAL = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "getOptional", (Class<?>) Optional.class, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});
        static final Class<?> CLASS_ENUM_HAND = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("EnumHand"), MinecraftReflection.findMcClassName("world.EnumHand"), MinecraftReflection.findMcClassName("world.InteractionHand"));
        static final Object HAND_MAIN = MinecraftReflection.findEnum(CLASS_ENUM_HAND, "MAIN_HAND", 0);
        static final MethodHandle MC_ITEMSTACK_SET = MinecraftReflection.searchMethod(CLASS_MC_ITEMSTACK, (Integer) 1, "set", (Class<?>) Object.class, (Class<?>[]) new Class[]{CLASS_MC_DATA_COMPONENT_TYPE, Object.class});
        static final MethodHandle CRAFT_ITEMSTACK_NMS_COPY = MinecraftReflection.findStaticMethod(CLASS_CRAFT_ITEMSTACK, "asNMSCopy", CLASS_MC_ITEMSTACK, (Class<?>[]) new Class[]{ItemStack.class});
        static final MethodHandle CRAFT_ITEMSTACK_CRAFT_MIRROR = MinecraftReflection.findStaticMethod(CLASS_CRAFT_ITEMSTACK, "asCraftMirror", CLASS_CRAFT_ITEMSTACK, (Class<?>[]) new Class[]{CLASS_MC_ITEMSTACK});
        static final Class<?> PACKET_OPEN_BOOK = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutOpenBook"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundOpenBookPacket"));
        static final MethodHandle NEW_PACKET_OPEN_BOOK = MinecraftReflection.findConstructor(PACKET_OPEN_BOOK, CLASS_ENUM_HAND);

        Book_1_20_5() {
        }

        static boolean isSupported() {
            return (WRITTEN_BOOK_COMPONENT_TYPE == null || CREATE_FILTERABLE == null || NEW_BOOK_CONTENT == null || CRAFT_ITEMSTACK_NMS_COPY == null || MC_ITEMSTACK_SET == null || CRAFT_ITEMSTACK_CRAFT_MIRROR == null || NEW_PACKET_OPEN_BOOK == null || HAND_MAIN == null) ? false : true;
        }

        static {
            Object objInvoke = null;
            Object objOrElse = null;
            try {
                if (GET_REGISTRY != null && CREATE_REGISTRY_KEY != null && CraftBukkitAccess.NEW_RESOURCE_LOCATION != null && REGISTRY_GET_OPTIONAL != null) {
                    try {
                        objInvoke = (Object) GET_REGISTRY.invoke((Object) CREATE_REGISTRY_KEY.invoke((Object) CraftBukkitAccess.NEW_RESOURCE_LOCATION.invoke(Key.MINECRAFT_NAMESPACE, "data_component_type")));
                    } catch (Exception e) {
                    }
                    if (objInvoke != null) {
                        objOrElse = (Optional) REGISTRY_GET_OPTIONAL.invoke(objInvoke, (Object) CraftBukkitAccess.NEW_RESOURCE_LOCATION.invoke(Key.MINECRAFT_NAMESPACE, "written_book_content")).orElse(null);
                    }
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to initialize Book_1_20_5 CraftBukkit facet", new Object[0]);
            }
            WRITTEN_BOOK_COMPONENT_TYPE = objOrElse;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitAccess$Chat1_19_3.class */
    static final class Chat1_19_3 {

        @Nullable
        static final MethodHandle RESOURCE_KEY_CREATE = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_RESOURCE_KEY, (Integer) 9, "create", CraftBukkitAccess.CLASS_RESOURCE_KEY, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_KEY, CraftBukkitAccess.CLASS_RESOURCE_LOCATION});

        @Nullable
        static final MethodHandle SERVER_PLAYER_GET_LEVEL = MinecraftReflection.searchMethod(CraftBukkitFacet.CRAFT_PLAYER_GET_HANDLE.type().returnType(), (Integer) 1, "getLevel", CraftBukkitAccess.CLASS_SERVER_LEVEL, (Class<?>[]) new Class[0]);

        @Nullable
        static final MethodHandle SERVER_LEVEL_GET_REGISTRY_ACCESS = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_SERVER_LEVEL, (Integer) 1, "registryAccess", CraftBukkitAccess.CLASS_REGISTRY_ACCESS, (Class<?>[]) new Class[0]);

        @Nullable
        static final MethodHandle LEVEL_GET_REGISTRY_ACCESS = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_LEVEL, (Integer) 1, "registryAccess", CraftBukkitAccess.CLASS_REGISTRY_ACCESS, (Class<?>[]) new Class[0]);

        @Nullable
        static final MethodHandle ACTUAL_GET_REGISTRY_ACCESS;

        @Nullable
        static final MethodHandle REGISTRY_ACCESS_GET_REGISTRY_OPTIONAL;

        @Nullable
        static final MethodHandle REGISTRY_GET_OPTIONAL;

        @Nullable
        static final MethodHandle REGISTRY_GET_HOLDER;

        @Nullable
        static final MethodHandle REGISTRY_GET_ID;

        @Nullable
        static final MethodHandle DISGUISED_CHAT_PACKET_CONSTRUCTOR;

        @Nullable
        static final MethodHandle CHAT_TYPE_BOUND_NETWORK_CONSTRUCTOR;

        @Nullable
        static final MethodHandle CHAT_TYPE_BOUND_CONSTRUCTOR;
        static final Object CHAT_TYPE_RESOURCE_KEY;

        private Chat1_19_3() {
        }

        static boolean isSupported() {
            return (ACTUAL_GET_REGISTRY_ACCESS == null || REGISTRY_ACCESS_GET_REGISTRY_OPTIONAL == null || REGISTRY_GET_OPTIONAL == null || (CHAT_TYPE_BOUND_NETWORK_CONSTRUCTOR == null && CHAT_TYPE_BOUND_CONSTRUCTOR == null) || DISGUISED_CHAT_PACKET_CONSTRUCTOR == null || CHAT_TYPE_RESOURCE_KEY == null) ? false : true;
        }

        static {
            MethodHandle methodHandleSearchMethod;
            Class<?> clsFindClass;
            Class<?> clsFindClass2;
            ACTUAL_GET_REGISTRY_ACCESS = SERVER_LEVEL_GET_REGISTRY_ACCESS == null ? LEVEL_GET_REGISTRY_ACCESS : SERVER_LEVEL_GET_REGISTRY_ACCESS;
            REGISTRY_ACCESS_GET_REGISTRY_OPTIONAL = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY_ACCESS, (Integer) 1, "registry", (Class<?>) Optional.class, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_KEY});
            REGISTRY_GET_OPTIONAL = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "getOptional", (Class<?>) Optional.class, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});
            REGISTRY_GET_HOLDER = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "getHolder", (Class<?>) Optional.class, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});
            REGISTRY_GET_ID = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "getId", (Class<?>) Integer.TYPE, (Class<?>[]) new Class[]{Object.class});
            MethodHandle methodHandleFindConstructor = null;
            MethodHandle methodHandleFindConstructor2 = null;
            MethodHandle methodHandleFindConstructor3 = null;
            Object objInvoke = null;
            try {
                Class<?> clsFindClass3 = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.chat.ChatType$BoundNetwork"));
                if (clsFindClass3 == null && (clsFindClass2 = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.chat.ChatMessageType"))) != null) {
                    for (Class<?> cls : clsFindClass2.getClasses()) {
                        methodHandleFindConstructor = MinecraftReflection.findConstructor(cls, Integer.TYPE, CraftBukkitAccess.CLASS_CHAT_COMPONENT, CraftBukkitAccess.CLASS_CHAT_COMPONENT);
                        if (methodHandleFindConstructor != null) {
                            clsFindClass3 = cls;
                            break;
                        }
                    }
                }
                Class<?> clsFindClass4 = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.chat.ChatType$BoundNetwork"));
                if (clsFindClass4 == null && (clsFindClass = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.chat.ChatMessageType"))) != null) {
                    for (Class<?> cls2 : clsFindClass.getClasses()) {
                        methodHandleFindConstructor2 = MinecraftReflection.findConstructor(cls2, CraftBukkitAccess.CLASS_HOLDER, CraftBukkitAccess.CLASS_CHAT_COMPONENT, Optional.class);
                        if (methodHandleFindConstructor2 != null) {
                            clsFindClass4 = cls2;
                            break;
                        }
                    }
                }
                Class<?> clsFindClass5 = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.protocol.game.ClientboundDisguisedChatPacket"));
                if (clsFindClass5 != null) {
                    if (clsFindClass3 != null) {
                        methodHandleFindConstructor3 = MinecraftReflection.findConstructor(clsFindClass5, CraftBukkitAccess.CLASS_CHAT_COMPONENT, clsFindClass3);
                    } else if (clsFindClass4 != null) {
                        methodHandleFindConstructor3 = MinecraftReflection.findConstructor(clsFindClass5, CraftBukkitAccess.CLASS_CHAT_COMPONENT, clsFindClass4);
                    }
                }
                if (CraftBukkitAccess.NEW_RESOURCE_LOCATION != null && RESOURCE_KEY_CREATE != null && (methodHandleSearchMethod = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_RESOURCE_KEY, (Integer) 9, "createRegistryKey", CraftBukkitAccess.CLASS_RESOURCE_KEY, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION})) != null) {
                    objInvoke = (Object) methodHandleSearchMethod.invoke((Object) CraftBukkitAccess.NEW_RESOURCE_LOCATION.invoke(Key.MINECRAFT_NAMESPACE, "chat_type"));
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to initialize 1.19.3 chat support", new Object[0]);
            }
            DISGUISED_CHAT_PACKET_CONSTRUCTOR = methodHandleFindConstructor3;
            CHAT_TYPE_BOUND_NETWORK_CONSTRUCTOR = methodHandleFindConstructor;
            CHAT_TYPE_BOUND_CONSTRUCTOR = methodHandleFindConstructor2;
            CHAT_TYPE_RESOURCE_KEY = objInvoke;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitAccess$EntitySound.class */
    static final class EntitySound {

        @Nullable
        static final Class<?> CLASS_CLIENTBOUND_ENTITY_SOUND = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("PacketPlayOutEntitySound"), MinecraftReflection.findMcClassName("network.protocol.game.PacketPlayOutEntitySound"), MinecraftReflection.findMcClassName("network.protocol.game.ClientboundSoundEntityPacket"));

        @Nullable
        static final Class<?> CLASS_SOUND_SOURCE = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("SoundCategory"), MinecraftReflection.findMcClassName("sounds.SoundCategory"), MinecraftReflection.findMcClassName("sounds.SoundSource"));

        @Nullable
        static final Class<?> CLASS_SOUND_EVENT = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("SoundEffect"), MinecraftReflection.findMcClassName("sounds.SoundEffect"), MinecraftReflection.findMcClassName("sounds.SoundEvent"));

        @Nullable
        static final MethodHandle SOUND_SOURCE_GET_NAME;

        private EntitySound() {
        }

        static boolean isSupported() {
            return SOUND_SOURCE_GET_NAME != null;
        }

        static {
            MethodHandle methodHandleUnreflect = null;
            if (CLASS_SOUND_SOURCE != null) {
                for (Method method : CLASS_SOUND_SOURCE.getDeclaredMethods()) {
                    if (method.getReturnType().equals(String.class) && method.getParameterCount() == 0 && !"name".equals(method.getName()) && Modifier.isPublic(method.getModifiers())) {
                        try {
                            methodHandleUnreflect = MinecraftReflection.lookup().unreflect(method);
                            break;
                        } catch (IllegalAccessException e) {
                        }
                    }
                }
            }
            SOUND_SOURCE_GET_NAME = methodHandleUnreflect;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/CraftBukkitAccess$EntitySound_1_19_3.class */
    static final class EntitySound_1_19_3 {

        @Nullable
        static final MethodHandle REGISTRY_GET_OPTIONAL = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "getOptional", (Class<?>) Optional.class, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});

        @Nullable
        static final MethodHandle REGISTRY_WRAP_AS_HOLDER = MinecraftReflection.searchMethod(CraftBukkitAccess.CLASS_REGISTRY, (Integer) 1, "wrapAsHolder", CraftBukkitAccess.CLASS_HOLDER, (Class<?>[]) new Class[]{Object.class});

        @Nullable
        static final MethodHandle SOUND_EVENT_CREATE_VARIABLE_RANGE = MinecraftReflection.searchMethod(EntitySound.CLASS_SOUND_EVENT, (Integer) 9, "createVariableRangeEvent", EntitySound.CLASS_SOUND_EVENT, (Class<?>[]) new Class[]{CraftBukkitAccess.CLASS_RESOURCE_LOCATION});

        @Nullable
        static final MethodHandle NEW_CLIENTBOUND_ENTITY_SOUND = MinecraftReflection.findConstructor(EntitySound.CLASS_CLIENTBOUND_ENTITY_SOUND, CraftBukkitAccess.CLASS_HOLDER, EntitySound.CLASS_SOUND_SOURCE, CraftBukkitAccess.CLASS_NMS_ENTITY, Float.TYPE, Float.TYPE, Long.TYPE);

        @Nullable
        static final Object SOUND_EVENT_REGISTRY;

        private EntitySound_1_19_3() {
        }

        static boolean isSupported() {
            return (NEW_CLIENTBOUND_ENTITY_SOUND == null || SOUND_EVENT_REGISTRY == null || CraftBukkitAccess.NEW_RESOURCE_LOCATION == null || REGISTRY_GET_OPTIONAL == null || REGISTRY_WRAP_AS_HOLDER == null || SOUND_EVENT_CREATE_VARIABLE_RANGE == null) ? false : true;
        }

        static {
            Object objOrElse = null;
            try {
                Field fieldFindField = MinecraftReflection.findField(CraftBukkitAccess.CLASS_BUILT_IN_REGISTRIES, CraftBukkitAccess.CLASS_REGISTRY, "SOUND_EVENT");
                if (fieldFindField != null) {
                    objOrElse = fieldFindField.get(null);
                } else if (CraftBukkitAccess.CLASS_BUILT_IN_REGISTRIES != null && REGISTRY_GET_OPTIONAL != null && CraftBukkitAccess.NEW_RESOURCE_LOCATION != null) {
                    Object obj = null;
                    for (Field field : CraftBukkitAccess.CLASS_BUILT_IN_REGISTRIES.getDeclaredFields()) {
                        if ((field.getModifiers() & 26) == 26 && field.getType().equals(CraftBukkitAccess.CLASS_WRITABLE_REGISTRY)) {
                            field.setAccessible(true);
                            obj = field.get(null);
                            break;
                        }
                    }
                    if (obj != null) {
                        objOrElse = (Optional) REGISTRY_GET_OPTIONAL.invoke(obj, (Object) CraftBukkitAccess.NEW_RESOURCE_LOCATION.invoke(Key.MINECRAFT_NAMESPACE, "sound_event")).orElse(null);
                    }
                }
            } catch (Throwable th) {
                Knob.logError(th, "Failed to initialize EntitySound_1_19_3 CraftBukkit facet", new Object[0]);
            }
            SOUND_EVENT_REGISTRY = objOrElse;
        }
    }

    private CraftBukkitAccess() {
    }

    static {
        MethodHandle methodHandleFindConstructor = MinecraftReflection.findConstructor(CLASS_RESOURCE_LOCATION, String.class, String.class);
        if (methodHandleFindConstructor == null) {
            methodHandleFindConstructor = MinecraftReflection.searchMethod(CLASS_RESOURCE_LOCATION, (Integer) 9, "fromNamespaceAndPath", CLASS_RESOURCE_LOCATION, (Class<?>[]) new Class[]{String.class, String.class});
        }
        NEW_RESOURCE_LOCATION = methodHandleFindConstructor;
    }
}
