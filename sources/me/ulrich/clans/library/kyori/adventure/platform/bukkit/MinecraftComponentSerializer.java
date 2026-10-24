package me.ulrich.clans.library.kyori.adventure.platform.bukkit;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/bukkit/MinecraftComponentSerializer.class */
@ApiStatus.Experimental
public final class MinecraftComponentSerializer implements ComponentSerializer<Component, Component, Object> {
    private static final MinecraftComponentSerializer INSTANCE = new MinecraftComponentSerializer();

    @Nullable
    private static final Class<?> CLASS_JSON_DESERIALIZER = MinecraftReflection.findClass("com.goo".concat("gle.gson.JsonDeserializer"));

    @Nullable
    private static final Class<?> CLASS_JSON_ELEMENT = MinecraftReflection.findClass("com.goo".concat("gle.gson.JsonElement"));

    @Nullable
    private static final Class<?> CLASS_JSON_OPS = MinecraftReflection.findClass("com.mo".concat("jang.serialization.JsonOps"));

    @Nullable
    private static final Class<?> CLASS_JSON_PARSER = MinecraftReflection.findClass("com.goo".concat("gle.gson.JsonParser"));

    @Nullable
    private static final Class<?> CLASS_CHAT_COMPONENT = MinecraftReflection.findClass(MinecraftReflection.findNmsClassName("IChatBaseComponent"), MinecraftReflection.findMcClassName("network.chat.IChatBaseComponent"), MinecraftReflection.findMcClassName("network.chat.Component"));

    @Nullable
    private static final Class<?> CLASS_COMPONENT_SERIALIZATION = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("network.chat.ComponentSerialization"));

    @Nullable
    private static final Class<?> CLASS_CRAFT_REGISTRY = MinecraftReflection.findCraftClass("CraftRegistry");

    @Nullable
    private static final Class<?> CLASS_HOLDERLOOKUP_PROVIDER = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("core.HolderLookup$Provider"), MinecraftReflection.findMcClassName("core.HolderLookup$a"));

    @Nullable
    private static final Class<?> CLASS_REGISTRY_ACCESS = MinecraftReflection.findClass(MinecraftReflection.findMcClassName("core.IRegistryCustom"), MinecraftReflection.findMcClassName("core.RegistryAccess"));

    @Nullable
    private static final MethodHandle PARSE_JSON = MinecraftReflection.findMethod(CLASS_JSON_PARSER, "parse", CLASS_JSON_ELEMENT, (Class<?>[]) new Class[]{String.class});

    @Nullable
    private static final MethodHandle GET_REGISTRY = MinecraftReflection.findStaticMethod(CLASS_CRAFT_REGISTRY, "getMinecraftRegistry", CLASS_REGISTRY_ACCESS, (Class<?>[]) new Class[0]);
    private static final AtomicReference<RuntimeException> INITIALIZATION_ERROR = new AtomicReference<>(new UnsupportedOperationException());
    private static final Object JSON_OPS_INSTANCE;
    private static final Object JSON_PARSER_INSTANCE;
    private static final Object MC_TEXT_GSON;
    private static final Object REGISTRY_ACCESS;
    private static final MethodHandle TEXT_SERIALIZER_DESERIALIZE;
    private static final MethodHandle TEXT_SERIALIZER_SERIALIZE;
    private static final MethodHandle TEXT_SERIALIZER_DESERIALIZE_TREE;
    private static final MethodHandle TEXT_SERIALIZER_SERIALIZE_TREE;
    private static final MethodHandle COMPONENTSERIALIZATION_CODEC_ENCODE;
    private static final MethodHandle COMPONENTSERIALIZATION_CODEC_DECODE;
    private static final MethodHandle CREATE_SERIALIZATION_CONTEXT;
    private static final boolean SUPPORTED;

    public static boolean isSupported() {
        return SUPPORTED;
    }

    @NotNull
    public static MinecraftComponentSerializer get() {
        return INSTANCE;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public Component deserialize(@NotNull Object obj) {
        Object jsonTree;
        if (!SUPPORTED) {
            throw INITIALIZATION_ERROR.get();
        }
        try {
            if (TEXT_SERIALIZER_SERIALIZE_TREE != null) {
                jsonTree = (Object) TEXT_SERIALIZER_SERIALIZE_TREE.invoke(obj);
            } else {
                if (MC_TEXT_GSON == null) {
                    if (COMPONENTSERIALIZATION_CODEC_ENCODE == null || CREATE_SERIALIZATION_CONTEXT == null) {
                        return BukkitComponentSerializer.gson().deserialize((String) TEXT_SERIALIZER_SERIALIZE.invoke(obj));
                    }
                    Object objInvoke = (Object) COMPONENTSERIALIZATION_CODEC_ENCODE.invoke(obj, (Object) CREATE_SERIALIZATION_CONTEXT.bindTo(REGISTRY_ACCESS).invoke(JSON_OPS_INSTANCE), null);
                    return (Component) BukkitComponentSerializer.gson().serializer().fromJson(objInvoke.getClass().getMethod("getOrThrow", Function.class).invoke(objInvoke, RuntimeException::new).toString(), Component.class);
                }
                jsonTree = ((Gson) MC_TEXT_GSON).toJsonTree(obj);
            }
            return (Component) BukkitComponentSerializer.gson().serializer().fromJson(jsonTree.toString(), Component.class);
        } catch (Throwable th) {
            throw new UnsupportedOperationException(th);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public Object serialize(@NotNull Component component) {
        if (!SUPPORTED) {
            throw INITIALIZATION_ERROR.get();
        }
        if (TEXT_SERIALIZER_DESERIALIZE_TREE != null || MC_TEXT_GSON != null) {
            JsonElement jsonTree = BukkitComponentSerializer.gson().serializer().toJsonTree(component);
            try {
                return TEXT_SERIALIZER_DESERIALIZE_TREE != null ? (Object) TEXT_SERIALIZER_DESERIALIZE_TREE.invoke((Object) PARSE_JSON.invoke(JSON_PARSER_INSTANCE, jsonTree.toString())) : ((Gson) MC_TEXT_GSON).fromJson(jsonTree, CLASS_CHAT_COMPONENT);
            } catch (Throwable th) {
                throw new UnsupportedOperationException(th);
            }
        }
        try {
            if (COMPONENTSERIALIZATION_CODEC_DECODE == null || CREATE_SERIALIZATION_CONTEXT == null) {
                return (Object) TEXT_SERIALIZER_DESERIALIZE.invoke(BukkitComponentSerializer.gson().serialize(component));
            }
            Object objInvoke = (Object) COMPONENTSERIALIZATION_CODEC_DECODE.invoke((Object) CREATE_SERIALIZATION_CONTEXT.bindTo(REGISTRY_ACCESS).invoke(JSON_OPS_INSTANCE), BukkitComponentSerializer.gson().serializeToTree(component));
            Object objInvoke2 = objInvoke.getClass().getMethod("getOrThrow", Function.class).invoke(objInvoke, RuntimeException::new);
            return objInvoke2.getClass().getMethod("getFirst", new Class[0]).invoke(objInvoke2, new Object[0]);
        } catch (Throwable th2) {
            throw new UnsupportedOperationException(th2);
        }
    }

    static {
        Field field;
        Object obj = null;
        Object obj2 = null;
        Object objNewInstance = null;
        Object obj3 = null;
        MethodHandle methodHandleUnreflect = null;
        MethodHandle methodHandleUnreflect2 = null;
        MethodHandle methodHandleInsertArguments = null;
        MethodHandle methodHandleInsertArguments2 = null;
        MethodHandle methodHandleBindTo = null;
        MethodHandle methodHandleBindTo2 = null;
        MethodHandle methodHandleUnreflect3 = null;
        try {
            if (CLASS_JSON_OPS != null) {
                Field field2 = CLASS_JSON_OPS.getField("INSTANCE");
                field2.setAccessible(true);
                obj2 = field2.get(null);
            }
            objNewInstance = CLASS_JSON_PARSER != null ? CLASS_JSON_PARSER.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]) : null;
            if (CLASS_CHAT_COMPONENT != null) {
                Object objInvoke = GET_REGISTRY != null ? (Object) GET_REGISTRY.invoke() : null;
                obj3 = objInvoke;
                Class cls = (Class) Arrays.stream(CLASS_CHAT_COMPONENT.getClasses()).filter(cls2 -> {
                    if (CLASS_JSON_DESERIALIZER != null) {
                        return CLASS_JSON_DESERIALIZER.isAssignableFrom(cls2);
                    }
                    for (Class<?> cls2 : cls2.getInterfaces()) {
                        if (cls2.getSimpleName().equals("JsonDeserializer")) {
                            return true;
                        }
                    }
                    return false;
                }).findAny().orElse(MinecraftReflection.findNmsClass("ChatSerializer"));
                if (cls != null && (field = (Field) Arrays.stream(cls.getDeclaredFields()).filter(field3 -> {
                    return Modifier.isStatic(field3.getModifiers());
                }).filter(field4 -> {
                    return field4.getType().equals(Gson.class);
                }).findFirst().orElse(null)) != null) {
                    field.setAccessible(true);
                    obj = field.get(null);
                }
                ArrayList arrayList = new ArrayList();
                if (cls != null) {
                    arrayList.add(cls);
                }
                arrayList.addAll(Arrays.asList(CLASS_CHAT_COMPONENT.getClasses()));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Method[] declaredMethods = ((Class) it.next()).getDeclaredMethods();
                    Method method = (Method) Arrays.stream(declaredMethods).filter(method2 -> {
                        return Modifier.isStatic(method2.getModifiers());
                    }).filter(method3 -> {
                        return CLASS_CHAT_COMPONENT.isAssignableFrom(method3.getReturnType());
                    }).filter(method4 -> {
                        return method4.getParameterCount() == 1 && method4.getParameterTypes()[0].equals(String.class);
                    }).min(Comparator.comparing((v0) -> {
                        return v0.getName();
                    })).orElse(null);
                    Method method5 = (Method) Arrays.stream(declaredMethods).filter(method6 -> {
                        return Modifier.isStatic(method6.getModifiers());
                    }).filter(method7 -> {
                        return method7.getReturnType().equals(String.class);
                    }).filter(method8 -> {
                        return method8.getParameterCount() == 1 && CLASS_CHAT_COMPONENT.isAssignableFrom(method8.getParameterTypes()[0]);
                    }).findFirst().orElse(null);
                    Method method9 = (Method) Arrays.stream(declaredMethods).filter(method10 -> {
                        return Modifier.isStatic(method10.getModifiers());
                    }).filter(method11 -> {
                        return CLASS_CHAT_COMPONENT.isAssignableFrom(method11.getReturnType());
                    }).filter(method12 -> {
                        return method12.getParameterCount() == 1 && method12.getParameterTypes()[0].equals(CLASS_JSON_ELEMENT);
                    }).findFirst().orElse(null);
                    Method method13 = (Method) Arrays.stream(declaredMethods).filter(method14 -> {
                        return Modifier.isStatic(method14.getModifiers());
                    }).filter(method15 -> {
                        return method15.getReturnType().equals(CLASS_JSON_ELEMENT);
                    }).filter(method16 -> {
                        return method16.getParameterCount() == 1 && CLASS_CHAT_COMPONENT.isAssignableFrom(method16.getParameterTypes()[0]);
                    }).findFirst().orElse(null);
                    Method method17 = (Method) Arrays.stream(declaredMethods).filter(method18 -> {
                        return Modifier.isStatic(method18.getModifiers());
                    }).filter(method19 -> {
                        return CLASS_CHAT_COMPONENT.isAssignableFrom(method19.getReturnType());
                    }).filter(method20 -> {
                        return method20.getParameterCount() == 2;
                    }).filter(method21 -> {
                        return method21.getParameterTypes()[0].equals(CLASS_JSON_ELEMENT);
                    }).filter(method22 -> {
                        return method22.getParameterTypes()[1].isInstance(objInvoke);
                    }).findFirst().orElse(null);
                    Method method23 = (Method) Arrays.stream(declaredMethods).filter(method24 -> {
                        return Modifier.isStatic(method24.getModifiers());
                    }).filter(method25 -> {
                        return method25.getReturnType().equals(CLASS_JSON_ELEMENT);
                    }).filter(method26 -> {
                        return method26.getParameterCount() == 2;
                    }).filter(method27 -> {
                        return CLASS_CHAT_COMPONENT.isAssignableFrom(method27.getParameterTypes()[0]);
                    }).filter(method28 -> {
                        return method28.getParameterTypes()[1].isInstance(objInvoke);
                    }).findFirst().orElse(null);
                    if (method != null) {
                        methodHandleUnreflect = MinecraftReflection.lookup().unreflect(method);
                    }
                    if (method5 != null) {
                        methodHandleUnreflect2 = MinecraftReflection.lookup().unreflect(method5);
                    }
                    if (method9 != null) {
                        methodHandleInsertArguments = MinecraftReflection.lookup().unreflect(method9);
                    } else if (method17 != null) {
                        method17.setAccessible(true);
                        methodHandleInsertArguments = MethodHandles.insertArguments(MinecraftReflection.lookup().unreflect(method17), 1, objInvoke);
                    }
                    if (method13 != null) {
                        methodHandleInsertArguments2 = MinecraftReflection.lookup().unreflect(method13);
                    } else if (method23 != null) {
                        method23.setAccessible(true);
                        methodHandleInsertArguments2 = MethodHandles.insertArguments(MinecraftReflection.lookup().unreflect(method23), 1, objInvoke);
                    }
                }
                if (objInvoke != null && CLASS_HOLDERLOOKUP_PROVIDER != null) {
                    for (Method method29 : CLASS_HOLDERLOOKUP_PROVIDER.getDeclaredMethods()) {
                        method29.setAccessible(true);
                        if (method29.getParameterCount() == 1 && method29.getParameterTypes()[0].getSimpleName().equals("DynamicOps") && method29.getReturnType().getSimpleName().contains("RegistryOps")) {
                            methodHandleUnreflect3 = MinecraftReflection.lookup().unreflect(method29);
                            break;
                        }
                    }
                }
                if (CLASS_COMPONENT_SERIALIZATION != null) {
                    for (Field field5 : CLASS_COMPONENT_SERIALIZATION.getDeclaredFields()) {
                        if (Modifier.isStatic(field5.getModifiers()) && field5.getType().getSimpleName().equals("Codec")) {
                            field5.setAccessible(true);
                            Object obj4 = field5.get(null);
                            for (Method method30 : obj4.getClass().getDeclaredMethods()) {
                                if (method30.getName().equals("decode")) {
                                    methodHandleBindTo2 = MinecraftReflection.lookup().unreflect(method30).bindTo(obj4);
                                } else if (method30.getName().equals("encode")) {
                                    methodHandleBindTo = MinecraftReflection.lookup().unreflect(method30).bindTo(obj4);
                                }
                            }
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            INITIALIZATION_ERROR.set(new UnsupportedOperationException("Error occurred during initialization", th));
        }
        MC_TEXT_GSON = obj;
        JSON_OPS_INSTANCE = obj2;
        JSON_PARSER_INSTANCE = objNewInstance;
        TEXT_SERIALIZER_DESERIALIZE = methodHandleUnreflect;
        TEXT_SERIALIZER_SERIALIZE = methodHandleUnreflect2;
        TEXT_SERIALIZER_DESERIALIZE_TREE = methodHandleInsertArguments;
        TEXT_SERIALIZER_SERIALIZE_TREE = methodHandleInsertArguments2;
        COMPONENTSERIALIZATION_CODEC_ENCODE = methodHandleBindTo;
        COMPONENTSERIALIZATION_CODEC_DECODE = methodHandleBindTo2;
        CREATE_SERIALIZATION_CONTEXT = methodHandleUnreflect3;
        REGISTRY_ACCESS = obj3;
        SUPPORTED = (MC_TEXT_GSON == null && (TEXT_SERIALIZER_DESERIALIZE == null || TEXT_SERIALIZER_SERIALIZE == null) && ((TEXT_SERIALIZER_DESERIALIZE_TREE == null || TEXT_SERIALIZER_SERIALIZE_TREE == null) && (COMPONENTSERIALIZATION_CODEC_ENCODE == null || COMPONENTSERIALIZATION_CODEC_DECODE == null || CREATE_SERIALIZATION_CONTEXT == null || JSON_OPS_INSTANCE == null))) ? false : true;
    }
}
