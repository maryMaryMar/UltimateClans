package me.module.banner.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.bukkit.block.banner.PatternType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/utils/PatternTypeMapper.class */
public class PatternTypeMapper {
    private static final Map<String, PatternType> PATTERN_MAP = new HashMap();

    public PatternTypeMapper() {
        try {
            PATTERN_MAP.put("BASE", PatternType.BASE);
        } catch (Exception | NoSuchFieldError e) {
        }
        try {
            PATTERN_MAP.put("SQUARE_BOTTOM_LEFT", PatternType.SQUARE_BOTTOM_LEFT);
        } catch (Exception | NoSuchFieldError e2) {
        }
        try {
            PATTERN_MAP.put("SQUARE_BOTTOM_RIGHT", PatternType.SQUARE_BOTTOM_RIGHT);
        } catch (Exception | NoSuchFieldError e3) {
        }
        try {
            PATTERN_MAP.put("SQUARE_TOP_LEFT", PatternType.SQUARE_TOP_LEFT);
        } catch (Exception | NoSuchFieldError e4) {
        }
        try {
            PATTERN_MAP.put("SQUARE_TOP_RIGHT", PatternType.SQUARE_TOP_RIGHT);
        } catch (Exception | NoSuchFieldError e5) {
        }
        try {
            PATTERN_MAP.put("STRIPE_BOTTOM", PatternType.STRIPE_BOTTOM);
        } catch (Exception | NoSuchFieldError e6) {
        }
        try {
            PATTERN_MAP.put("STRIPE_TOP", PatternType.STRIPE_TOP);
        } catch (Exception | NoSuchFieldError e7) {
        }
        try {
            PATTERN_MAP.put("STRIPE_LEFT", PatternType.STRIPE_LEFT);
        } catch (Exception | NoSuchFieldError e8) {
        }
        try {
            PATTERN_MAP.put("STRIPE_RIGHT", PatternType.STRIPE_RIGHT);
        } catch (Exception | NoSuchFieldError e9) {
        }
        try {
            PATTERN_MAP.put("STRIPE_CENTER", PatternType.STRIPE_CENTER);
        } catch (Exception | NoSuchFieldError e10) {
        }
        try {
            PATTERN_MAP.put("STRIPE_MIDDLE", PatternType.STRIPE_MIDDLE);
        } catch (Exception | NoSuchFieldError e11) {
        }
        try {
            PATTERN_MAP.put("STRIPE_DOWNRIGHT", PatternType.STRIPE_DOWNRIGHT);
        } catch (Exception | NoSuchFieldError e12) {
        }
        try {
            PATTERN_MAP.put("STRIPE_DOWNLEFT", PatternType.STRIPE_DOWNLEFT);
        } catch (Exception | NoSuchFieldError e13) {
        }
        try {
            PATTERN_MAP.put("SMALL_STRIPES", PatternType.SMALL_STRIPES);
        } catch (Exception | NoSuchFieldError e14) {
        }
        try {
            PATTERN_MAP.put("CROSS", PatternType.CROSS);
        } catch (Exception | NoSuchFieldError e15) {
        }
        try {
            PATTERN_MAP.put("STRAIGHT_CROSS", PatternType.STRAIGHT_CROSS);
        } catch (Exception | NoSuchFieldError e16) {
        }
        try {
            PATTERN_MAP.put("TRIANGLE_BOTTOM", PatternType.TRIANGLE_BOTTOM);
        } catch (Exception | NoSuchFieldError e17) {
        }
        try {
            PATTERN_MAP.put("TRIANGLE_TOP", PatternType.TRIANGLE_TOP);
        } catch (Exception | NoSuchFieldError e18) {
        }
        try {
            PATTERN_MAP.put("TRIANGLES_BOTTOM", PatternType.TRIANGLES_BOTTOM);
        } catch (Exception | NoSuchFieldError e19) {
        }
        try {
            PATTERN_MAP.put("TRIANGLES_TOP", PatternType.TRIANGLES_TOP);
        } catch (Exception | NoSuchFieldError e20) {
        }
        try {
            PATTERN_MAP.put("DIAGONAL_LEFT", PatternType.DIAGONAL_LEFT);
        } catch (Exception | NoSuchFieldError e21) {
        }
        try {
            PATTERN_MAP.put("DIAGONAL_UP_RIGHT", PatternType.DIAGONAL_UP_RIGHT);
        } catch (Exception | NoSuchFieldError e22) {
        }
        try {
            PATTERN_MAP.put("DIAGONAL_UP_LEFT", PatternType.DIAGONAL_UP_LEFT);
        } catch (Exception | NoSuchFieldError e23) {
        }
        try {
            PATTERN_MAP.put("DIAGONAL_RIGHT", PatternType.DIAGONAL_RIGHT);
        } catch (Exception | NoSuchFieldError e24) {
        }
        try {
            PATTERN_MAP.put("CIRCLE", PatternType.CIRCLE);
        } catch (Exception | NoSuchFieldError e25) {
        }
        try {
            PATTERN_MAP.put("RHOMBUS", PatternType.RHOMBUS);
        } catch (Exception | NoSuchFieldError e26) {
        }
        try {
            PATTERN_MAP.put("HALF_VERTICAL", PatternType.HALF_VERTICAL);
        } catch (Exception | NoSuchFieldError e27) {
        }
        try {
            PATTERN_MAP.put("HALF_HORIZONTAL", PatternType.HALF_HORIZONTAL);
        } catch (Exception | NoSuchFieldError e28) {
        }
        try {
            PATTERN_MAP.put("HALF_VERTICAL_RIGHT", PatternType.HALF_VERTICAL_RIGHT);
        } catch (Exception | NoSuchFieldError e29) {
        }
        try {
            PATTERN_MAP.put("HALF_HORIZONTAL_BOTTOM", PatternType.HALF_HORIZONTAL_BOTTOM);
        } catch (Exception | NoSuchFieldError e30) {
        }
        try {
            PATTERN_MAP.put("BORDER", PatternType.BORDER);
        } catch (Exception | NoSuchFieldError e31) {
        }
        try {
            PATTERN_MAP.put("CURLY_BORDER", PatternType.CURLY_BORDER);
        } catch (Exception | NoSuchFieldError e32) {
        }
        try {
            PATTERN_MAP.put("CREEPER", PatternType.CREEPER);
        } catch (Exception | NoSuchFieldError e33) {
        }
        try {
            PATTERN_MAP.put("GRADIENT", PatternType.GRADIENT);
        } catch (Exception | NoSuchFieldError e34) {
        }
        try {
            PATTERN_MAP.put("GRADIENT_UP", PatternType.GRADIENT_UP);
        } catch (Exception | NoSuchFieldError e35) {
        }
        try {
            PATTERN_MAP.put("BRICKS", PatternType.BRICKS);
        } catch (Exception | NoSuchFieldError e36) {
        }
        try {
            PATTERN_MAP.put("SKULL", PatternType.SKULL);
        } catch (Exception | NoSuchFieldError e37) {
        }
        try {
            PATTERN_MAP.put("FLOWER", PatternType.FLOWER);
        } catch (Exception | NoSuchFieldError e38) {
        }
        try {
            PATTERN_MAP.put("MOJANG", PatternType.MOJANG);
        } catch (Exception | NoSuchFieldError e39) {
        }
        try {
            PATTERN_MAP.put("GLOBE", PatternType.GLOBE);
        } catch (Exception | NoSuchFieldError e40) {
        }
        try {
            PATTERN_MAP.put("PIGLIN", PatternType.PIGLIN);
        } catch (Exception | NoSuchFieldError e41) {
        }
        try {
            PATTERN_MAP.put("FLOW", PatternType.FLOW);
        } catch (Exception | NoSuchFieldError e42) {
        }
        try {
            PATTERN_MAP.put("GUSTER", PatternType.GUSTER);
        } catch (Exception | NoSuchFieldError e43) {
        }
    }

    public Optional<PatternType> getPatternType(String str) {
        try {
            PatternType patternType = PATTERN_MAP.get(str.toUpperCase());
            return patternType == null ? Optional.empty() : Optional.of(patternType);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
