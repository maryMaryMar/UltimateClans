package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl;

import com.google.gson.JsonElement;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.MethodAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/RelocatedGson.class */
public final class RelocatedGson {
    public static final String SERVER_GSON_PKG;
    public static final boolean IS_GSON_RELOCATED;
    public static final Object JSON_PARSER;
    public static final MethodAccessor PARSE_STRING_METHOD;
    static final /* synthetic */ boolean $assertionsDisabled;

    private RelocatedGson() {
    }

    public static Object convertToServerGson(JsonElement jsonElement) {
        if (!IS_GSON_RELOCATED) {
            return jsonElement;
        }
        if ($assertionsDisabled || PARSE_STRING_METHOD != null) {
            return PARSE_STRING_METHOD.invoke(JSON_PARSER, jsonElement.toString());
        }
        throw new AssertionError();
    }

    static {
        $assertionsDisabled = !RelocatedGson.class.desiredAssertionStatus();
        SERVER_GSON_PKG = "com.go".concat("ogle.gson");
        IS_GSON_RELOCATED = !JsonElement.class.getName().equals(new StringBuilder().append(SERVER_GSON_PKG).append(".JsonElement").toString());
        if (!IS_GSON_RELOCATED) {
            JSON_PARSER = null;
            PARSE_STRING_METHOD = null;
            return;
        }
        try {
            Class<?> cls = Class.forName(SERVER_GSON_PKG + ".JsonElement");
            Class<?> cls2 = Class.forName(SERVER_GSON_PKG + ".JsonParser");
            JSON_PARSER = cls2.getConstructors()[0].newInstance(new Object[0]);
            PARSE_STRING_METHOD = ReflectUtil.findMethod(cls2, false, MethodType.methodType(cls, (Class<?>) String.class), "parse");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
