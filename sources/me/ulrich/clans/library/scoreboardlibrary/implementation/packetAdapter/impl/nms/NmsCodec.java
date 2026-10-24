package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import java.lang.invoke.MethodType;
import java.util.Optional;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.MethodAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsCodec.class */
public final class NmsCodec {
    public static final MethodAccessor RESULT_UNWRAP_METHOD;
    public static final Object JSON_OPS;
    public static final MethodAccessor CODEC_PARSE;

    private NmsCodec() {
    }

    static {
        if (NmsClasses.DATA_RESULT_CLASS == null) {
            RESULT_UNWRAP_METHOD = null;
            JSON_OPS = null;
            CODEC_PARSE = null;
        } else {
            RESULT_UNWRAP_METHOD = ReflectUtil.findMethod(NmsClasses.DATA_RESULT_CLASS, false, MethodType.methodType(Optional.class), "result");
            try {
                JSON_OPS = NmsClasses.JSON_OPS_CLASS.getField("INSTANCE").get(null);
                CODEC_PARSE = ReflectUtil.findMethod(NmsClasses.CODEC_CLASS, false, MethodType.methodType(NmsClasses.DATA_RESULT_CLASS, NmsClasses.DYNAMIC_OPS_CLASS, Object.class), "parse");
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
