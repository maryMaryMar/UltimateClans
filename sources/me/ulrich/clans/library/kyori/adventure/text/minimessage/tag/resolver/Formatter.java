package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.BiFunction;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.JoinConfiguration;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.TagPattern;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/resolver/Formatter.class */
public final class Formatter {
    private Formatter() {
    }

    @NotNull
    public static TagResolver number(@TagPattern @NotNull String str, @NotNull Number number) {
        return TagResolver.resolver(str, (BiFunction<ArgumentQueue, Context, Tag>) (argumentQueue, context) -> {
            NumberFormat decimalFormat;
            if (argumentQueue.hasNext()) {
                String strValue = argumentQueue.pop().value();
                if (argumentQueue.hasNext()) {
                    decimalFormat = new DecimalFormat(argumentQueue.pop().value(), new DecimalFormatSymbols(Locale.forLanguageTag(strValue)));
                } else {
                    decimalFormat = strValue.contains(".") ? new DecimalFormat(strValue, DecimalFormatSymbols.getInstance()) : DecimalFormat.getInstance(Locale.forLanguageTag(strValue));
                }
            } else {
                decimalFormat = DecimalFormat.getInstance();
            }
            return Tag.inserting(context.deserialize(decimalFormat.format(number)));
        });
    }

    @NotNull
    public static TagResolver date(@TagPattern @NotNull String str, @NotNull TemporalAccessor temporalAccessor) {
        return TagResolver.resolver(str, (BiFunction<ArgumentQueue, Context, Tag>) (argumentQueue, context) -> {
            return Tag.inserting(context.deserialize(DateTimeFormatter.ofPattern(argumentQueue.popOr("Format expected.").value()).format(temporalAccessor)));
        });
    }

    @NotNull
    public static TagResolver choice(@TagPattern @NotNull String str, Number number) {
        return TagResolver.resolver(str, (BiFunction<ArgumentQueue, Context, Tag>) (argumentQueue, context) -> {
            return Tag.inserting(context.deserialize(new ChoiceFormat(argumentQueue.popOr("Format expected.").value()).format(number)));
        });
    }

    public static TagResolver booleanChoice(@TagPattern @NotNull String str, boolean z) {
        return TagResolver.resolver(str, (BiFunction<ArgumentQueue, Context, Tag>) (argumentQueue, context) -> {
            return Tag.inserting(context.deserialize(z ? argumentQueue.popOr("True format expected.").value() : argumentQueue.popOr("False format expected.").value()));
        });
    }

    public static TagResolver joining(@TagPattern @NotNull String str, @NotNull Iterable<? extends ComponentLike> iterable) {
        return TagResolver.resolver(str, (BiFunction<ArgumentQueue, Context, Tag>) (argumentQueue, context) -> {
            if (!argumentQueue.hasNext()) {
                return Tag.inserting(Component.join(JoinConfiguration.noSeparators(), (Iterable<? extends ComponentLike>) iterable));
            }
            JoinConfiguration.Builder builderSeparator = JoinConfiguration.builder().separator(context.deserialize(argumentQueue.pop().value()));
            if (argumentQueue.hasNext()) {
                builderSeparator.lastSeparator(context.deserialize(argumentQueue.pop().value()));
            }
            if (argumentQueue.hasNext()) {
                builderSeparator.lastSeparatorIfSerial(context.deserialize(argumentQueue.pop().value()));
            }
            return Tag.inserting(Component.join(builderSeparator.build2(), (Iterable<? extends ComponentLike>) iterable));
        });
    }

    public static TagResolver joining(@TagPattern @NotNull String str, @NotNull ComponentLike... componentLikeArr) {
        return joining(str, Arrays.asList(componentLikeArr));
    }
}
