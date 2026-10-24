package me.ulrich.clans.library.kyori.adventure.text.serializer.json;

import me.ulrich.clans.library.kyori.option.Option;
import me.ulrich.clans.library.kyori.option.OptionSchema;
import me.ulrich.clans.library.kyori.option.OptionState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONOptions.class */
public final class JSONOptions {
    private static final int VERSION_INITIAL = 0;
    private static final OptionSchema.Mutable UNSAFE_SCHEMA = OptionSchema.globalSchema();
    public static final Option<Boolean> EMIT_RGB = Option.booleanOption(key("emit/rgb"), true);
    public static final Option<HoverEventValueMode> EMIT_HOVER_EVENT_TYPE = UNSAFE_SCHEMA.enumOption(key("emit/hover_value_mode"), HoverEventValueMode.class, HoverEventValueMode.SNAKE_CASE);
    public static final Option<ClickEventValueMode> EMIT_CLICK_EVENT_TYPE = Option.enumOption(key("emit/click_value_mode"), ClickEventValueMode.class, ClickEventValueMode.SNAKE_CASE);
    public static final Option<Boolean> EMIT_COMPACT_TEXT_COMPONENT = UNSAFE_SCHEMA.booleanOption(key("emit/compact_text_component"), true);
    public static final Option<Boolean> EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY = UNSAFE_SCHEMA.booleanOption(key("emit/hover_show_entity_id_as_int_array"), true);
    public static final Option<Boolean> EMIT_HOVER_SHOW_ENTITY_KEY_AS_TYPE_AND_UUID_AS_ID = UNSAFE_SCHEMA.booleanOption(key("emit/hover_show_entity_key_as_type_and_uuid_as_id"), false);
    public static final Option<Boolean> VALIDATE_STRICT_EVENTS = UNSAFE_SCHEMA.booleanOption(key("validate/strict_events"), true);
    public static final Option<Boolean> EMIT_DEFAULT_ITEM_HOVER_QUANTITY = UNSAFE_SCHEMA.booleanOption(key("emit/default_item_hover_quantity"), true);
    public static final Option<ShowItemHoverDataMode> SHOW_ITEM_HOVER_DATA_MODE = UNSAFE_SCHEMA.enumOption(key("emit/show_item_hover_data"), ShowItemHoverDataMode.class, ShowItemHoverDataMode.EMIT_EITHER);
    public static final Option<ShadowColorEmitMode> SHADOW_COLOR_MODE = UNSAFE_SCHEMA.enumOption(key("emit/shadow_color"), ShadowColorEmitMode.class, ShadowColorEmitMode.EMIT_INTEGER);
    private static final OptionSchema SCHEMA = OptionSchema.childSchema(UNSAFE_SCHEMA).frozenView();
    private static final int VERSION_1_16 = 2526;
    private static final int VERSION_1_20_3 = 3679;
    private static final int VERSION_1_20_5 = 3819;
    private static final int VERSION_1_21_4 = 4174;
    private static final int VERSION_1_21_5 = 4298;
    private static final OptionState.Versioned BY_DATA_VERSION = SCHEMA.versionedStateBuilder().version(0, builder -> {
        builder.value(EMIT_HOVER_EVENT_TYPE, HoverEventValueMode.VALUE_FIELD).value(EMIT_CLICK_EVENT_TYPE, ClickEventValueMode.CAMEL_CASE).value(EMIT_RGB, false).value(EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY, false).value(EMIT_HOVER_SHOW_ENTITY_KEY_AS_TYPE_AND_UUID_AS_ID, true).value(VALIDATE_STRICT_EVENTS, false).value(EMIT_DEFAULT_ITEM_HOVER_QUANTITY, false).value(SHOW_ITEM_HOVER_DATA_MODE, ShowItemHoverDataMode.EMIT_LEGACY_NBT).value(SHADOW_COLOR_MODE, ShadowColorEmitMode.NONE);
    }).version(VERSION_1_16, builder2 -> {
        builder2.value(EMIT_HOVER_EVENT_TYPE, HoverEventValueMode.CAMEL_CASE).value(EMIT_RGB, true);
    }).version(VERSION_1_20_3, builder3 -> {
        builder3.value(EMIT_COMPACT_TEXT_COMPONENT, true).value(EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY, true).value(VALIDATE_STRICT_EVENTS, true);
    }).version(VERSION_1_20_5, builder4 -> {
        builder4.value(EMIT_DEFAULT_ITEM_HOVER_QUANTITY, true).value(SHOW_ITEM_HOVER_DATA_MODE, ShowItemHoverDataMode.EMIT_DATA_COMPONENTS);
    }).version(VERSION_1_21_4, builder5 -> {
        builder5.value(SHADOW_COLOR_MODE, ShadowColorEmitMode.EMIT_INTEGER);
    }).version(VERSION_1_21_5, builder6 -> {
        builder6.value(EMIT_HOVER_EVENT_TYPE, HoverEventValueMode.SNAKE_CASE).value(EMIT_CLICK_EVENT_TYPE, ClickEventValueMode.SNAKE_CASE).value(EMIT_HOVER_SHOW_ENTITY_KEY_AS_TYPE_AND_UUID_AS_ID, false);
    }).build();
    private static final OptionState MOST_COMPATIBLE = SCHEMA.stateBuilder().value(EMIT_HOVER_EVENT_TYPE, HoverEventValueMode.ALL).value(EMIT_CLICK_EVENT_TYPE, ClickEventValueMode.BOTH).value(EMIT_HOVER_SHOW_ENTITY_ID_AS_INT_ARRAY, false).value(EMIT_COMPACT_TEXT_COMPONENT, false).value(VALIDATE_STRICT_EVENTS, false).value(SHOW_ITEM_HOVER_DATA_MODE, ShowItemHoverDataMode.EMIT_EITHER).value(SHADOW_COLOR_MODE, ShadowColorEmitMode.EMIT_INTEGER).build();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONOptions$ClickEventValueMode.class */
    public enum ClickEventValueMode {
        SNAKE_CASE,
        CAMEL_CASE,
        BOTH
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONOptions$HoverEventValueMode.class */
    public enum HoverEventValueMode {
        SNAKE_CASE,
        CAMEL_CASE,
        VALUE_FIELD,
        ALL;


        @Deprecated
        public static final HoverEventValueMode MODERN_ONLY = CAMEL_CASE;

        @Deprecated
        public static final HoverEventValueMode LEGACY_ONLY = VALUE_FIELD;

        @Deprecated
        public static final HoverEventValueMode BOTH = ALL;
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONOptions$ShadowColorEmitMode.class */
    public enum ShadowColorEmitMode {
        NONE,
        EMIT_INTEGER,
        EMIT_ARRAY
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONOptions$ShowItemHoverDataMode.class */
    public enum ShowItemHoverDataMode {
        EMIT_LEGACY_NBT,
        EMIT_DATA_COMPONENTS,
        EMIT_EITHER
    }

    private JSONOptions() {
    }

    private static String key(String str) {
        return "adventure:json/" + str;
    }

    @NotNull
    public static OptionSchema schema() {
        return SCHEMA;
    }

    public static OptionState.Versioned byDataVersion() {
        return BY_DATA_VERSION;
    }

    @NotNull
    public static OptionState compatibility() {
        return MOST_COMPATIBLE;
    }
}
