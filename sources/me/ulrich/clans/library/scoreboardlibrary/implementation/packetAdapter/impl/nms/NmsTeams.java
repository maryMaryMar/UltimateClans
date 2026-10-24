package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import java.util.Collection;
import java.util.Optional;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.ImmutableTeamProperties;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ConstructorAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.FieldAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsTeams.class */
public final class NmsTeams {
    public static final ConstructorAccessor<?> PARAMETERS_CONSTRUCTOR;
    public static final ConstructorAccessor<?> TEAM_PACKET_CONSTRUCTOR;
    public static final FieldAccessor<Object, String> TEAM_NAME_FIELD;
    public static final FieldAccessor<Object, Integer> TEAM_MODE_FIELD;
    public static final FieldAccessor<Object, Collection<String>> TEAM_ENTRIES_FIELD;
    public static final FieldAccessor<Object, Object> DISPLAY_NAME_FIELD;
    public static final FieldAccessor<Object, Object> PREFIX_FIELD;
    public static final FieldAccessor<Object, Object> SUFFIX_FIELD;
    public static final FieldAccessor<Object, Object> NAME_TAG_VISIBILITY_FIELD;
    public static final FieldAccessor<Object, Object> COLLISION_RULE_FIELD;
    public static final FieldAccessor<Object, Object> COLOR_FIELD;
    public static final FieldAccessor<Object, Integer> OPTIONS_FIELD;
    static final /* synthetic */ boolean $assertionsDisabled;

    private NmsTeams() {
    }

    public static Object createTeamParameters(Object obj, Object obj2, Object obj3, ImmutableTeamProperties<?> immutableTeamProperties) {
        if (!NmsClasses.IS_26_2_OR_ABOVE) {
            Object objInvoke = PARAMETERS_CONSTRUCTOR.invoke(new Object[0]);
            setupOldTeamPropertiesFields(objInvoke, obj, obj2, obj3, immutableTeamProperties);
            return objInvoke;
        }
        Enum<?> r10 = null;
        if (immutableTeamProperties.playerColor() != null) {
            r10 = NmsEnums.ADVENTURE_TO_NMS_CHAT_FORMATTING.get(immutableTeamProperties.playerColor());
        }
        return PARAMETERS_CONSTRUCTOR.invoke(obj, obj2, obj3, NmsEnums.nameTagVisibility(immutableTeamProperties.nameTagVisibility()), NmsEnums.collisionRule(immutableTeamProperties.collisionRule()), Optional.ofNullable(r10), Byte.valueOf((byte) immutableTeamProperties.packOptions()));
    }

    public static void setupOldTeamPropertiesFields(Object obj, Object obj2, Object obj3, Object obj4, ImmutableTeamProperties<?> immutableTeamProperties) {
        Object objKey;
        Object objKey2;
        if (NmsClasses.IS_1_21_5_OR_ABOVE) {
            objKey = NmsEnums.nameTagVisibility(immutableTeamProperties.nameTagVisibility());
            objKey2 = NmsEnums.collisionRule(immutableTeamProperties.collisionRule());
        } else {
            objKey = immutableTeamProperties.nameTagVisibility().key();
            objKey2 = immutableTeamProperties.collisionRule().key();
        }
        Enum<?> r0 = NmsEnums.ADVENTURE_TO_NMS_CHAT_FORMATTING.get(immutableTeamProperties.playerColor() != null ? immutableTeamProperties.playerColor() : NamedTextColor.WHITE);
        DISPLAY_NAME_FIELD.set(obj, obj2);
        PREFIX_FIELD.set(obj, obj3);
        SUFFIX_FIELD.set(obj, obj4);
        NAME_TAG_VISIBILITY_FIELD.set(obj, objKey);
        COLLISION_RULE_FIELD.set(obj, objKey2);
        COLOR_FIELD.set(obj, r0);
        OPTIONS_FIELD.set(obj, Integer.valueOf(immutableTeamProperties.packOptions()));
    }

    static {
        $assertionsDisabled = !NmsTeams.class.desiredAssertionStatus();
        if (NmsClasses.IS_26_2_OR_ABOVE) {
            PARAMETERS_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, NmsClasses.COMPONENT_CLASS, NmsClasses.COMPONENT_CLASS, NmsClasses.COMPONENT_CLASS, NmsClasses.TEAM_VISIBILITY_CLASS, NmsClasses.TEAM_COLLISION_RULE_CLASS, Optional.class, Byte.TYPE);
            TEAM_PACKET_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, String.class, Integer.TYPE, Optional.class, Collection.class);
            TEAM_NAME_FIELD = null;
            TEAM_MODE_FIELD = null;
            TEAM_ENTRIES_FIELD = null;
        } else if (!NmsClasses.IS_1_17_OR_ABOVE) {
            PARAMETERS_CONSTRUCTOR = null;
            TEAM_PACKET_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, new Class[0]);
            TEAM_NAME_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 0, String.class);
            TEAM_MODE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 0, Integer.TYPE);
            TEAM_ENTRIES_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 0, Collection.class);
        } else {
            if (!$assertionsDisabled && NmsClasses.TEAM_PARAMETERS_PKT_CLASS == null) {
                throw new AssertionError();
            }
            PARAMETERS_CONSTRUCTOR = ReflectUtil.getEmptyConstructor(NmsClasses.TEAM_PARAMETERS_PKT_CLASS);
            TEAM_PACKET_CONSTRUCTOR = ReflectUtil.findConstructor(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, String.class, Integer.TYPE, Optional.class, Collection.class);
            TEAM_NAME_FIELD = null;
            TEAM_MODE_FIELD = null;
            TEAM_ENTRIES_FIELD = null;
        }
        if (NmsClasses.IS_26_2_OR_ABOVE) {
            DISPLAY_NAME_FIELD = null;
            PREFIX_FIELD = null;
            SUFFIX_FIELD = null;
            NAME_TAG_VISIBILITY_FIELD = null;
            COLLISION_RULE_FIELD = null;
            COLOR_FIELD = null;
            OPTIONS_FIELD = null;
            return;
        }
        if (NmsClasses.IS_1_17_OR_ABOVE) {
            DISPLAY_NAME_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 0, NmsClasses.COMPONENT_CLASS);
            PREFIX_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 1, NmsClasses.COMPONENT_CLASS);
            SUFFIX_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 2, NmsClasses.COMPONENT_CLASS);
            if (NmsClasses.IS_1_21_5_OR_ABOVE) {
                NAME_TAG_VISIBILITY_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 0, NmsClasses.TEAM_VISIBILITY_CLASS);
                COLLISION_RULE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 0, NmsClasses.TEAM_COLLISION_RULE_CLASS);
            } else {
                NAME_TAG_VISIBILITY_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 0, String.class);
                COLLISION_RULE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 1, String.class);
            }
            COLOR_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 0, NmsClasses.TEAM_COLOR_OR_CHAT_FORMATTING_CLASS);
            OPTIONS_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_PARAMETERS_PKT_CLASS, 0, Integer.TYPE);
            return;
        }
        if (NmsClasses.IS_1_13_OR_ABOVE) {
            DISPLAY_NAME_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 0, NmsClasses.COMPONENT_CLASS);
            PREFIX_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 1, NmsClasses.COMPONENT_CLASS);
            SUFFIX_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 2, NmsClasses.COMPONENT_CLASS);
            NAME_TAG_VISIBILITY_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 1, String.class);
            COLLISION_RULE_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 2, String.class);
            COLOR_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 0, NmsClasses.TEAM_COLOR_OR_CHAT_FORMATTING_CLASS);
            OPTIONS_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 1, Integer.TYPE);
            return;
        }
        DISPLAY_NAME_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 1, String.class);
        PREFIX_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 2, String.class);
        SUFFIX_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 3, String.class);
        NAME_TAG_VISIBILITY_FIELD = NmsClasses.IS_1_8_OR_ABOVE ? ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 4, String.class) : null;
        COLLISION_RULE_FIELD = NmsClasses.IS_1_9_OR_ABOVE ? ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 5, String.class) : null;
        COLOR_FIELD = NmsClasses.IS_1_8_OR_ABOVE ? ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, 0, Integer.TYPE) : null;
        OPTIONS_FIELD = ReflectUtil.findFieldUnchecked(NmsClasses.SET_PLAYER_TEAM_PKT_CLASS, NmsClasses.IS_1_8_OR_ABOVE ? 2 : 1, Integer.TYPE);
    }
}
