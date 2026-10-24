package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import java.util.Optional;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ConstructorAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.FieldAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsObjectives.class */
public final class NmsObjectives {
    public static final ConstructorAccessor<?> RESET_SCORE_CONSTRUCTOR;
    public static final ConstructorAccessor<?> SCORE_CONSTRUCTOR;
    public static final FieldAccessor<Object, String> SCORE_OBJECTIVE_NAME_FIELD;
    public static final FieldAccessor<Object, Integer> SCORE_VALUE_FIELD;
    public static final FieldAccessor<Object, Object> SCORE_ACTION_FIELD;
    public static final ConstructorAccessor<?> OBJECTIVE_PACKET_CONSTRUCTOR;
    public static final FieldAccessor<Object, String> OBJECTIVE_NAME_FIELD;
    public static final FieldAccessor<Object, Object> OBJECTIVE_VALUE_FIELD;
    public static final FieldAccessor<Object, Object> OBJECTIVE_RENDER_TYPE_FIELD;
    public static final FieldAccessor<Object, Object> OBJECTIVE_NUMBER_FORMAT_FIELD;
    public static final FieldAccessor<Object, Integer> OBJECTIVE_MODE_FIELD;
    public static final ConstructorAccessor<?> DISPLAY_CONSTRUCTOR;
    public static final FieldAccessor<Object, String> DISPLAY_OBJECTIVE_NAME;
    public static final FieldAccessor<Object, Object> DISPLAY_SLOT;
    static final /* synthetic */ boolean $assertionsDisabled;

    private NmsObjectives() {
    }

    static {
        $assertionsDisabled = !NmsObjectives.class.desiredAssertionStatus();
        if (NmsClasses.IS_1_20_3_OR_ABOVE) {
            RESET_SCORE_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.RESET_SCORE_PKT_CLASS, String.class, String.class);
        } else {
            RESET_SCORE_CONSTRUCTOR = null;
        }
        if (NmsClasses.IS_1_20_5_OR_ABOVE) {
            SCORE_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_SCORE_PKT_CLASS, String.class, String.class, Integer.TYPE, Optional.class, Optional.class);
        } else if (NmsClasses.IS_1_20_3_OR_ABOVE) {
            if (!$assertionsDisabled && NmsClasses.NUMBER_FORMAT_CLASS == null) {
                throw new AssertionError();
            }
            SCORE_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_SCORE_PKT_CLASS, String.class, String.class, Integer.TYPE, NmsClasses.COMPONENT_CLASS, NmsClasses.NUMBER_FORMAT_CLASS);
        } else if (NmsClasses.IS_1_13_OR_ABOVE) {
            SCORE_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_SCORE_PKT_CLASS, NmsClasses.SCORE_ACTION_CLASS, String.class, String.class, Integer.TYPE);
        } else {
            SCORE_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_SCORE_PKT_CLASS, String.class);
        }
        if (NmsClasses.IS_1_13_OR_ABOVE) {
            SCORE_OBJECTIVE_NAME_FIELD = null;
            SCORE_VALUE_FIELD = null;
            SCORE_ACTION_FIELD = null;
        } else {
            SCORE_OBJECTIVE_NAME_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_SCORE_PKT_CLASS, 1, String.class);
            SCORE_VALUE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_SCORE_PKT_CLASS, 0, Integer.TYPE);
            if (NmsClasses.IS_1_8_OR_ABOVE) {
                SCORE_ACTION_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_SCORE_PKT_CLASS, 0, NmsClasses.SCORE_ACTION_CLASS);
            } else {
                SCORE_ACTION_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_SCORE_PKT_CLASS, 1, Integer.TYPE);
            }
        }
        OBJECTIVE_PACKET_CONSTRUCTOR = ReflectUtil.getEmptyConstructor(NmsClasses.SET_OBJECTIVE_PKT_CLASS);
        OBJECTIVE_NAME_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_OBJECTIVE_PKT_CLASS, 0, String.class);
        OBJECTIVE_VALUE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_OBJECTIVE_PKT_CLASS, NmsClasses.IS_1_13_OR_ABOVE ? 0 : 1, NmsClasses.IS_1_13_OR_ABOVE ? NmsClasses.COMPONENT_CLASS : String.class);
        if (NmsClasses.IS_1_8_OR_ABOVE) {
            OBJECTIVE_RENDER_TYPE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_OBJECTIVE_PKT_CLASS, 0, NmsClasses.OBJECTIVE_CRITERIA_RENDER_TYPE_CLASS);
        } else {
            OBJECTIVE_RENDER_TYPE_FIELD = null;
        }
        if (NmsClasses.IS_1_20_5_OR_ABOVE) {
            OBJECTIVE_NUMBER_FORMAT_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_OBJECTIVE_PKT_CLASS, 0, Optional.class);
        } else if (NmsClasses.IS_1_20_3_OR_ABOVE) {
            OBJECTIVE_NUMBER_FORMAT_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_OBJECTIVE_PKT_CLASS, 0, NmsClasses.NUMBER_FORMAT_CLASS);
        } else {
            OBJECTIVE_NUMBER_FORMAT_FIELD = null;
        }
        OBJECTIVE_MODE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_OBJECTIVE_PKT_CLASS, 0, Integer.TYPE);
        if (NmsClasses.IS_1_20_2_OR_ABOVE) {
            DISPLAY_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_DISPLAY_OBJECTIVE_PKT_CLASS, NmsClasses.DISPLAY_SLOT_CLASS, NmsClasses.OBJECTIVE_CLASS);
        } else if (NmsClasses.IS_1_17_OR_ABOVE) {
            DISPLAY_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_DISPLAY_OBJECTIVE_PKT_CLASS, Integer.TYPE, NmsClasses.OBJECTIVE_CLASS);
        } else {
            DISPLAY_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_DISPLAY_OBJECTIVE_PKT_CLASS, new Class[0]);
        }
        DISPLAY_OBJECTIVE_NAME = ReflectUtil.findFieldUnchecked(NmsClasses.SET_DISPLAY_OBJECTIVE_PKT_CLASS, 0, String.class);
        if (NmsClasses.IS_1_17_OR_ABOVE) {
            DISPLAY_SLOT = null;
        } else {
            DISPLAY_SLOT = ReflectUtil.findFieldUnchecked(NmsClasses.SET_DISPLAY_OBJECTIVE_PKT_CLASS, 0, Integer.TYPE);
        }
    }
}
