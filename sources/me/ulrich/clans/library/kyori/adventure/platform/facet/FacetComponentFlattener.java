package me.ulrich.clans.library.kyori.adventure.platform.facet;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TranslatableComponent;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import me.ulrich.clans.library.kyori.adventure.translation.TranslationRegistry;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetComponentFlattener.class */
@ApiStatus.Internal
public final class FacetComponentFlattener {
    private static final Pattern LOCALIZATION_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?s");

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/platform/facet/FacetComponentFlattener$Translator.class */
    public interface Translator<V> extends Facet<V> {
        @NotNull
        String valueOrDefault(@NotNull V v, @NotNull String str);
    }

    private FacetComponentFlattener() {
    }

    public static <V> ComponentFlattener get(V v, Collection<? extends Translator<V>> collection) {
        Translator translator = (Translator) Facet.of(collection, v);
        ComponentFlattener.Builder builder = ComponentFlattener.basic().mo683toBuilder();
        builder.complexMapper(TranslatableComponent.class, (translatableComponent, consumer) -> {
            String strKey = translatableComponent.key();
            for (me.ulrich.clans.library.kyori.adventure.translation.Translator translator2 : GlobalTranslator.translator().sources()) {
                if ((translator2 instanceof TranslationRegistry) && ((TranslationRegistry) translator2).contains(strKey)) {
                    consumer.accept(GlobalTranslator.render(translatableComponent, Locale.getDefault()));
                    return;
                }
            }
            String strValueOrDefault = translator == null ? strKey : translator.valueOrDefault(v, strKey);
            Matcher matcher = LOCALIZATION_PATTERN.matcher(strValueOrDefault);
            List<Component> listArgs = translatableComponent.args();
            int i = 0;
            int iEnd = 0;
            while (matcher.find()) {
                if (iEnd < matcher.start()) {
                    consumer.accept(Component.text(strValueOrDefault.substring(iEnd, matcher.start())));
                }
                iEnd = matcher.end();
                String strGroup = matcher.group(1);
                if (strGroup != null) {
                    try {
                        int i2 = Integer.parseInt(strGroup) - 1;
                        if (i2 < listArgs.size()) {
                            consumer.accept(listArgs.get(i2));
                        }
                    } catch (NumberFormatException e) {
                    }
                } else {
                    int i3 = i;
                    i++;
                    if (i3 < listArgs.size()) {
                        consumer.accept(listArgs.get(i3));
                    }
                }
            }
            if (iEnd < strValueOrDefault.length()) {
                consumer.accept(Component.text(strValueOrDefault.substring(iEnd)));
            }
        });
        return builder.build2();
    }
}
