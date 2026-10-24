package me.ulrich.clans.library.kyori.adventure.text.serializer.gson.impl;

import com.google.auto.service.AutoService;
import com.google.gson.JsonNull;
import java.util.Collections;
import me.ulrich.clans.library.kyori.adventure.Adventure;
import me.ulrich.clans.library.kyori.adventure.key.Key;
import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue;
import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValueConverterRegistry;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonDataComponentValue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/impl/GsonDataComponentValueConverterProvider.class */
@ApiStatus.Internal
@AutoService({DataComponentValueConverterRegistry.Provider.class})
public final class GsonDataComponentValueConverterProvider implements DataComponentValueConverterRegistry.Provider {
    private static final Key ID = Key.key(Adventure.NAMESPACE, "serializer/gson");

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValueConverterRegistry.Provider
    @NotNull
    public Key id() {
        return ID;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValueConverterRegistry.Provider
    @NotNull
    public Iterable<DataComponentValueConverterRegistry.Conversion<?, ?>> conversions() {
        return Collections.singletonList(DataComponentValueConverterRegistry.Conversion.convert(DataComponentValue.Removed.class, GsonDataComponentValue.class, (key, removed) -> {
            return GsonDataComponentValue.gsonDataComponentValue(JsonNull.INSTANCE);
        }));
    }
}
