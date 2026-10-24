package me.ulrich.clans.library.scoreboardlibrary.implementation.commons;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Locale;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.translation.Translator;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/commons/LocaleProvider.class */
public final class LocaleProvider {
    private static final Locale DEFAULT_LOCALE = Locale.US;
    private static final Function<Player, Locale> PROVIDER = get();

    private LocaleProvider() {
    }

    @NotNull
    public static Locale locale(Player player) {
        return PROVIDER.apply(player);
    }

    @NotNull
    private static Function<Player, Locale> get() {
        MethodHandles.Lookup lookupPublicLookup = MethodHandles.publicLookup();
        try {
            MethodHandle methodHandleFindVirtual = lookupPublicLookup.findVirtual(Player.class, "locale", MethodType.methodType(Locale.class));
            return player -> {
                try {
                    return (Locale) methodHandleFindVirtual.invokeExact(player);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            };
        } catch (IllegalAccessException | NoSuchMethodException e) {
            MethodType methodType = MethodType.methodType(String.class);
            try {
                MethodHandle methodHandleFindVirtual2 = lookupPublicLookup.findVirtual(Player.Spigot.class, "getLocale", methodType);
                return player2 -> {
                    try {
                        Locale locale = Translator.parseLocale((String) methodHandleFindVirtual2.invokeExact(player2.spigot()));
                        return locale == null ? DEFAULT_LOCALE : locale;
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                };
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                try {
                    MethodHandle methodHandleFindVirtual3 = lookupPublicLookup.findVirtual(Player.class, "getLocale", methodType);
                    return player3 -> {
                        try {
                            Locale locale = Translator.parseLocale((String) methodHandleFindVirtual3.invokeExact(player3));
                            return locale == null ? DEFAULT_LOCALE : locale;
                        } catch (Throwable th) {
                            throw new RuntimeException(th);
                        }
                    };
                } catch (IllegalAccessException | NoSuchMethodException e3) {
                    throw new RuntimeException("No way to get players locale found");
                }
            }
        }
    }
}
