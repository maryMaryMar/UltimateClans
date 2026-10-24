package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import java.util.Locale;
import java.util.Optional;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.RelocatedGson;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ConstructorAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsScoreFormat.class */
public final class NmsScoreFormat {
    private static final Object STYLE_CODEC;
    private static final Object BLANK;
    private static final ConstructorAccessor<?> STYLED_CONSTRUCTOR;
    private static final ConstructorAccessor<?> FIXED_CONSTRUCTOR;

    private NmsScoreFormat() {
    }

    @Nullable
    public static Object convert(@Nullable Locale locale, @Nullable ScoreFormat scoreFormat) {
        if (scoreFormat == null || !NmsClasses.IS_1_20_3_OR_ABOVE) {
            return null;
        }
        if (scoreFormat == ScoreFormat.blank()) {
            return BLANK;
        }
        if (scoreFormat instanceof ScoreFormat.Styled) {
            return STYLED_CONSTRUCTOR.invoke(((Optional) NmsCodec.RESULT_UNWRAP_METHOD.invoke(NmsCodec.CODEC_PARSE.invoke(STYLE_CODEC, NmsCodec.JSON_OPS, RelocatedGson.convertToServerGson(GsonComponentSerializer.gson().serializer().toJsonTree(((ScoreFormat.Styled) scoreFormat).style()))))).get());
        }
        if (scoreFormat instanceof ScoreFormat.Fixed) {
            return FIXED_CONSTRUCTOR.invoke(NmsComponent.fromAdventure(((ScoreFormat.Fixed) scoreFormat).content(), locale));
        }
        throw new IllegalArgumentException("Invalid score format: " + scoreFormat);
    }

    static {
        if (!NmsClasses.IS_1_20_3_OR_ABOVE) {
            STYLE_CODEC = null;
            BLANK = null;
            STYLED_CONSTRUCTOR = null;
            FIXED_CONSTRUCTOR = null;
            return;
        }
        STYLE_CODEC = ReflectUtil.findFieldUnchecked(NmsClasses.STYLE_SERIALIZER_CLASS, 0, NmsClasses.CODEC_CLASS, true).get(null);
        Class<?> classOrThrow = ReflectUtil.getClassOrThrow("net.minecraft.network.chat.numbers.BlankFormat");
        BLANK = ReflectUtil.findFieldUnchecked(classOrThrow, 0, classOrThrow, true).get(null);
        STYLED_CONSTRUCTOR = ReflectUtil.findConstructor(ReflectUtil.getClassOrThrow("net.minecraft.network.chat.numbers.StyledFormat"), NmsClasses.STYLE_CLASS);
        FIXED_CONSTRUCTOR = ReflectUtil.findConstructor(ReflectUtil.getClassOrThrow("net.minecraft.network.chat.numbers.FixedFormat"), NmsClasses.COMPONENT_CLASS);
    }
}
