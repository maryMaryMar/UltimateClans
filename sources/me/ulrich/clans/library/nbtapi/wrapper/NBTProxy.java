package me.ulrich.clans.library.nbtapi.wrapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import me.ulrich.clans.library.nbtapi.iface.NBTHandler;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/NBTProxy.class */
public interface NBTProxy {
    public static final Map<Class<?>, NBTHandler<Object>> handlers = new HashMap();

    default void init() {
    }

    default Casing getCasing() {
        return Casing.PascalCase;
    }

    default <T> NBTHandler<T> getHandler(Class<T> cls) {
        return (NBTHandler) handlers.get(cls);
    }

    default Collection<NBTHandler<Object>> getHandlers() {
        return handlers.values();
    }

    default <T> void registerHandler(Class<T> cls, NBTHandler<T> nBTHandler) {
        handlers.put(cls, nBTHandler);
    }
}
