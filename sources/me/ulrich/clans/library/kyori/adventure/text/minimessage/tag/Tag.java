package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/Tag.class */
public interface Tag {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/Tag$Argument.class */
    @ApiStatus.NonExtendable
    public interface Argument {
        @NotNull
        String value();

        @NotNull
        default String lowerValue() {
            return value().toLowerCase(Locale.ROOT);
        }

        default boolean isTrue() {
            return "true".equals(value()) || "on".equals(value());
        }

        default boolean isFalse() {
            return "false".equals(value()) || "off".equals(value());
        }

        @NotNull
        default OptionalInt asInt() {
            try {
                return OptionalInt.of(Integer.parseInt(value()));
            } catch (NumberFormatException e) {
                return OptionalInt.empty();
            }
        }

        @NotNull
        default OptionalDouble asDouble() {
            try {
                return OptionalDouble.of(Double.parseDouble(value()));
            } catch (NumberFormatException e) {
                return OptionalDouble.empty();
            }
        }
    }

    @NotNull
    static PreProcess preProcessParsed(@NotNull String str) {
        return new PreProcessTagImpl((String) Objects.requireNonNull(str, "content"));
    }

    @NotNull
    static Tag inserting(@NotNull Component component) {
        return new InsertingImpl(true, (Component) Objects.requireNonNull(component, "content must not be null"));
    }

    @NotNull
    static Tag inserting(@NotNull ComponentLike componentLike) {
        return inserting(((ComponentLike) Objects.requireNonNull(componentLike, "value")).asComponent());
    }

    @NotNull
    static Tag selfClosingInserting(@NotNull Component component) {
        return new InsertingImpl(false, (Component) Objects.requireNonNull(component, "content must not be null"));
    }

    @NotNull
    static Tag selfClosingInserting(@NotNull ComponentLike componentLike) {
        return selfClosingInserting(((ComponentLike) Objects.requireNonNull(componentLike, "value")).asComponent());
    }

    @NotNull
    static Tag styling(Consumer<Style.Builder> consumer) {
        return new CallbackStylingTagImpl(consumer);
    }

    @NotNull
    static Tag styling(@NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        Objects.requireNonNull(styleBuilderApplicableArr, "actions");
        int length = styleBuilderApplicableArr.length;
        for (int i = 0; i < length; i++) {
            if (styleBuilderApplicableArr[i] == null) {
                throw new NullPointerException("actions[" + i + "]");
            }
        }
        return new StylingTagImpl((StyleBuilderApplicable[]) Arrays.copyOf(styleBuilderApplicableArr, styleBuilderApplicableArr.length));
    }
}
