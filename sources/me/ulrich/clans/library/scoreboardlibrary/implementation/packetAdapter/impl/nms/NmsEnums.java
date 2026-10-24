package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms;

import java.util.HashMap;
import java.util.Map;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.CollisionRule;
import me.ulrich.clans.library.scoreboardlibrary.api.team.enums.NameTagVisibility;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.FieldAccessor;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ReflectUtil;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/nms/NmsEnums.class */
public final class NmsEnums {
    public static final Object SCORE_ACTION_CHANGE;
    public static final Object SCORE_ACTION_REMOVE;
    public static final Map<NamedTextColor, Enum<?>> ADVENTURE_TO_NMS_CHAT_FORMATTING;
    public static final Object NAME_TAG_VISIBILITY_ALWAYS;
    public static final Object NAME_TAG_VISIBILITY_NEVER;
    public static final Object NAME_TAG_VISIBILITY_HIDE_FOR_OTHER_TEAMS;
    public static final Object NAME_TAG_VISIBILITY_HIDE_FOR_OWN_TEAM;
    public static final Object COLLISION_RULE_ALWAYS;
    public static final Object COLLISION_RULE_NEVER;
    public static final Object COLLISION_RULE_PUSH_OTHER_TEAMS;
    public static final Object COLLISION_RULE_PUSH_OWN_TEAM;
    public static final Object RENDER_TYPE_INTEGER;
    public static final Object RENDER_TYPE_HEARTS;
    public static final Object[] DISPLAY_SLOT_VALUES;

    private NmsEnums() {
    }

    public static Object nameTagVisibility(NameTagVisibility nameTagVisibility) {
        switch (nameTagVisibility) {
            case NEVER:
                return NAME_TAG_VISIBILITY_NEVER;
            case ALWAYS:
                return NAME_TAG_VISIBILITY_ALWAYS;
            case HIDE_FOR_OTHER_TEAMS:
                return NAME_TAG_VISIBILITY_HIDE_FOR_OTHER_TEAMS;
            case HIDE_FOR_OWN_TEAM:
                return NAME_TAG_VISIBILITY_HIDE_FOR_OWN_TEAM;
            default:
                throw new IllegalStateException("unknown name tag visibility " + nameTagVisibility.name());
        }
    }

    public static Object collisionRule(CollisionRule collisionRule) {
        switch (collisionRule) {
            case NEVER:
                return COLLISION_RULE_NEVER;
            case ALWAYS:
                return COLLISION_RULE_ALWAYS;
            case PUSH_OTHER_TEAMS:
                return COLLISION_RULE_PUSH_OTHER_TEAMS;
            case PUSH_OWN_TEAM:
                return COLLISION_RULE_PUSH_OWN_TEAM;
            default:
                throw new IllegalStateException("unknown collision rule " + collisionRule.name());
        }
    }

    public static Object renderType(ObjectiveRenderType objectiveRenderType) {
        switch (objectiveRenderType) {
            case INTEGER:
                return RENDER_TYPE_INTEGER;
            case HEARTS:
                return RENDER_TYPE_HEARTS;
            default:
                throw new IllegalStateException("unknown render type " + objectiveRenderType);
        }
    }

    static {
        Object obj;
        if (!NmsClasses.IS_1_8_OR_ABOVE || NmsClasses.IS_1_20_3_OR_ABOVE) {
            SCORE_ACTION_CHANGE = null;
            SCORE_ACTION_REMOVE = null;
        } else {
            SCORE_ACTION_CHANGE = ReflectUtil.getEnumInstance(NmsClasses.SCORE_ACTION_CLASS, "CHANGE", "a");
            SCORE_ACTION_REMOVE = ReflectUtil.getEnumInstance(NmsClasses.SCORE_ACTION_CLASS, "REMOVE", "b");
        }
        ADVENTURE_TO_NMS_CHAT_FORMATTING = new HashMap();
        Object[] enumConstants = NmsClasses.TEAM_COLOR_OR_CHAT_FORMATTING_CLASS.getEnumConstants();
        FieldAccessor fieldAccessorFindFieldUnchecked = ReflectUtil.findFieldUnchecked(NmsClasses.TEAM_COLOR_OR_CHAT_FORMATTING_CLASS, 0, String.class);
        for (NamedTextColor namedTextColor : NamedTextColor.NAMES.values()) {
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    throw new RuntimeException("No chat formatting enum constant found for " + namedTextColor.toString());
                }
                obj = enumConstants[i];
                if (namedTextColor.toString().equalsIgnoreCase((String) fieldAccessorFindFieldUnchecked.get(obj))) {
                    break;
                } else {
                    i++;
                }
            }
            ADVENTURE_TO_NMS_CHAT_FORMATTING.put(namedTextColor, (Enum) obj);
        }
        NAME_TAG_VISIBILITY_ALWAYS = ReflectUtil.getEnumInstance(NmsClasses.TEAM_VISIBILITY_CLASS, "ALWAYS");
        NAME_TAG_VISIBILITY_NEVER = ReflectUtil.getEnumInstance(NmsClasses.TEAM_VISIBILITY_CLASS, "NEVER");
        NAME_TAG_VISIBILITY_HIDE_FOR_OTHER_TEAMS = ReflectUtil.getEnumInstance(NmsClasses.TEAM_VISIBILITY_CLASS, "HIDE_FOR_OTHER_TEAMS");
        NAME_TAG_VISIBILITY_HIDE_FOR_OWN_TEAM = ReflectUtil.getEnumInstance(NmsClasses.TEAM_VISIBILITY_CLASS, "HIDE_FOR_OWN_TEAM");
        if (NmsClasses.TEAM_COLLISION_RULE_CLASS != null) {
            COLLISION_RULE_ALWAYS = ReflectUtil.getEnumInstance(NmsClasses.TEAM_COLLISION_RULE_CLASS, "ALWAYS");
            COLLISION_RULE_NEVER = ReflectUtil.getEnumInstance(NmsClasses.TEAM_COLLISION_RULE_CLASS, "NEVER");
            COLLISION_RULE_PUSH_OTHER_TEAMS = ReflectUtil.getEnumInstance(NmsClasses.TEAM_COLLISION_RULE_CLASS, "PUSH_OTHER_TEAMS", "HIDE_FOR_OTHER_TEAMS");
            COLLISION_RULE_PUSH_OWN_TEAM = ReflectUtil.getEnumInstance(NmsClasses.TEAM_COLLISION_RULE_CLASS, "PUSH_OWN_TEAM", "HIDE_FOR_OWN_TEAM");
        } else {
            COLLISION_RULE_ALWAYS = null;
            COLLISION_RULE_NEVER = null;
            COLLISION_RULE_PUSH_OTHER_TEAMS = null;
            COLLISION_RULE_PUSH_OWN_TEAM = null;
        }
        RENDER_TYPE_INTEGER = ReflectUtil.getEnumInstance(NmsClasses.OBJECTIVE_CRITERIA_RENDER_TYPE_CLASS, "INTEGER");
        RENDER_TYPE_HEARTS = ReflectUtil.getEnumInstance(NmsClasses.OBJECTIVE_CRITERIA_RENDER_TYPE_CLASS, "HEARTS");
        DISPLAY_SLOT_VALUES = NmsClasses.DISPLAY_SLOT_CLASS == null ? null : NmsClasses.DISPLAY_SLOT_CLASS.getEnumConstants();
    }
}
