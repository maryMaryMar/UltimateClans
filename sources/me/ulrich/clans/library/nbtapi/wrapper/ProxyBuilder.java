package me.ulrich.clans.library.nbtapi.wrapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import me.ulrich.clans.library.nbtapi.NBTType;
import me.ulrich.clans.library.nbtapi.NbtApiException;
import me.ulrich.clans.library.nbtapi.iface.NBTHandler;
import me.ulrich.clans.library.nbtapi.iface.ReadWriteNBT;
import me.ulrich.clans.library.nbtapi.wrapper.NBTProxy;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/ProxyBuilder.class */
public class ProxyBuilder<T extends NBTProxy> implements InvocationHandler {
    private static final Map<Method, Function<Arguments, Object>> METHOD_CACHE = new ConcurrentHashMap();
    private final Class<T> target;
    private final ReadWriteNBT nbt;
    private boolean readOnly;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/ProxyBuilder$Arguments.class */
    private static class Arguments {
        Class<?> target;
        NBTProxy proxy;
        ReadWriteNBT nbt;
        Object[] args;
        boolean readOnly;

        public Arguments(Class<?> cls, NBTProxy nBTProxy, boolean z, ReadWriteNBT readWriteNBT, Object[] objArr) {
            this.target = cls;
            this.proxy = nBTProxy;
            this.nbt = readWriteNBT;
            this.args = objArr;
            this.readOnly = z;
        }
    }

    public ProxyBuilder(ReadWriteNBT readWriteNBT, Class<T> cls) {
        if (!cls.isInterface()) {
            throw new NbtApiException("A proxy can only be built from an interface! Check the wiki for examples.");
        }
        this.target = cls;
        this.nbt = readWriteNBT;
    }

    public ProxyBuilder<T> readOnly() {
        this.readOnly = true;
        return this;
    }

    public T build() {
        T t = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.target}, this);
        t.init();
        return t;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        METHOD_CACHE.computeIfAbsent(method, method2 -> {
            return createFunction((NBTProxy) obj, method2);
        });
        return METHOD_CACHE.get(method).apply(new Arguments(this.target, (NBTProxy) obj, this.readOnly, this.nbt, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Function<Arguments, Object> createFunction(NBTProxy nBTProxy, Method method) {
        Class cls;
        if ("toString".equals(method.getName()) && method.getParameterCount() == 0 && method.getReturnType() == String.class) {
            return arguments -> {
                return arguments.nbt.toString();
            };
        }
        if (method.isDefault()) {
            return arguments2 -> {
                return DefaultMethodInvoker.invokeDefault(arguments2.target, arguments2.proxy, method, arguments2.args);
            };
        }
        NBTTarget.Type action = getAction(method);
        if (action == NBTTarget.Type.SET) {
            String nBTName = getNBTName(nBTProxy.getCasing(), method);
            return arguments3 -> {
                if (arguments3.readOnly) {
                    throw new NbtApiException("Tried calling a set method on a read only object.");
                }
                return setNBT(arguments3.nbt, arguments3.proxy, nBTName, arguments3.args[0]);
            };
        }
        if (action != NBTTarget.Type.GET) {
            if (action != NBTTarget.Type.HAS) {
                throw new IllegalArgumentException("The method '" + method.getName() + "' in '" + method.getDeclaringClass().getName() + "' can not be handled by the NBT-API. Please check the Wiki for examples!");
            }
            String nBTName2 = getNBTName(nBTProxy.getCasing(), method);
            return arguments4 -> {
                return Boolean.valueOf(arguments4.nbt.hasTag(nBTName2));
            };
        }
        Class<?> returnType = method.getReturnType();
        String nBTName3 = getNBTName(nBTProxy.getCasing(), method);
        if (returnType.isInterface() && NBTProxy.class.isAssignableFrom(returnType)) {
            return arguments5 -> {
                if (!arguments5.nbt.hasTag(nBTName3) || arguments5.nbt.getType(nBTName3) == NBTType.NBTTagCompound) {
                    return new ProxyBuilder(arguments5.nbt.getOrCreateCompound(nBTName3), returnType).build();
                }
                throw new NbtApiException("Tried getting a '" + returnType + "' proxy from the field '" + nBTName3 + "', but it's not a TagCompound!");
            };
        }
        if (returnType == ProxyList.class && (cls = (Class) ((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments()[0]) != null && cls.isInterface() && NBTProxy.class.isAssignableFrom(cls)) {
            return arguments6 -> {
                return new ProxiedList(arguments6.nbt.getCompoundList(nBTName3), cls);
            };
        }
        NBTHandler handler = nBTProxy.getHandler(returnType);
        return handler != null ? arguments7 -> {
            return handler.get(arguments7.nbt, nBTName3);
        } : arguments8 -> {
            return arguments8.nbt.getOrNull(nBTName3, returnType);
        };
    }

    private static NBTTarget.Type getAction(Method method) {
        NBTTarget nBTTarget = (NBTTarget) method.getAnnotation(NBTTarget.class);
        if (nBTTarget != null) {
            if (nBTTarget.type() == NBTTarget.Type.HAS && method.getParameterCount() == 0 && method.getReturnType() == Boolean.TYPE) {
                return NBTTarget.Type.HAS;
            }
            if (nBTTarget.type() == NBTTarget.Type.GET && method.getParameterCount() == 0) {
                return NBTTarget.Type.GET;
            }
            if (nBTTarget.type() == NBTTarget.Type.SET && method.getParameterCount() == 1) {
                return NBTTarget.Type.SET;
            }
        }
        if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
            return NBTTarget.Type.SET;
        }
        if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
            return NBTTarget.Type.GET;
        }
        if (method.getName().startsWith("has") && method.getParameterCount() == 0 && method.getReturnType() == Boolean.TYPE) {
            return NBTTarget.Type.HAS;
        }
        return null;
    }

    private static String getNBTName(Casing casing, Method method) {
        NBTTarget nBTTarget = (NBTTarget) method.getAnnotation(NBTTarget.class);
        return nBTTarget != null ? nBTTarget.value() : casing.convertString(method.getName().substring(3));
    }

    private static Object setNBT(ReadWriteNBT readWriteNBT, NBTProxy nBTProxy, String str, Object obj) {
        if (obj == null) {
            readWriteNBT.removeKey(str);
            return null;
        }
        if (obj instanceof Boolean) {
            readWriteNBT.setBoolean(str, (Boolean) obj);
            return null;
        }
        if (obj instanceof Byte) {
            readWriteNBT.setByte(str, (Byte) obj);
            return null;
        }
        if (obj instanceof Short) {
            readWriteNBT.setShort(str, (Short) obj);
            return null;
        }
        if (obj instanceof Integer) {
            readWriteNBT.setInteger(str, (Integer) obj);
            return null;
        }
        if (obj instanceof Long) {
            readWriteNBT.setLong(str, (Long) obj);
            return null;
        }
        if (obj instanceof Float) {
            readWriteNBT.setFloat(str, (Float) obj);
            return null;
        }
        if (obj instanceof Double) {
            readWriteNBT.setDouble(str, (Double) obj);
            return null;
        }
        if (obj instanceof byte[]) {
            readWriteNBT.setByteArray(str, (byte[]) obj);
            return null;
        }
        if (obj instanceof int[]) {
            readWriteNBT.setIntArray(str, (int[]) obj);
            return null;
        }
        if (obj instanceof long[]) {
            readWriteNBT.setLongArray(str, (long[]) obj);
            return null;
        }
        if (obj instanceof String) {
            readWriteNBT.setString(str, (String) obj);
            return null;
        }
        if (obj instanceof UUID) {
            readWriteNBT.setUUID(str, (UUID) obj);
            return null;
        }
        if (obj.getClass().isEnum()) {
            readWriteNBT.setEnum(str, (Enum) obj);
            return null;
        }
        NBTHandler handler = nBTProxy.getHandler(obj.getClass());
        if (handler != null) {
            handler.set(readWriteNBT, str, obj);
            return null;
        }
        for (NBTHandler<Object> nBTHandler : nBTProxy.getHandlers()) {
            if (nBTHandler.fuzzyMatch(obj)) {
                nBTHandler.set(readWriteNBT, str, obj);
                return null;
            }
        }
        throw new IllegalArgumentException("Tried setting an object of type '" + obj.getClass().getName() + "'. This is not a supported NBT value. Please check the Wiki for examples!");
    }
}
