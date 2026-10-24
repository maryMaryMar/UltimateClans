package me.ulrich.clans.library.kyori.adventure.text.serializer.gson.impl;

import com.google.auto.service.AutoService;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/impl/JSONComponentSerializerProviderImpl.class */
@ApiStatus.Internal
@AutoService({JSONComponentSerializer.Provider.class})
public final class JSONComponentSerializerProviderImpl implements JSONComponentSerializer.Provider, Services.Fallback {
    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Provider
    @NotNull
    public JSONComponentSerializer instance() {
        return GsonComponentSerializer.gson();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.json.JSONComponentSerializer.Provider
    @NotNull
    public Supplier<JSONComponentSerializer.Builder> builder() {
        return GsonComponentSerializer::builder;
    }

    public String toString() {
        return "JSONComponentSerializerProviderImpl[GsonComponentSerializer]";
    }
}
