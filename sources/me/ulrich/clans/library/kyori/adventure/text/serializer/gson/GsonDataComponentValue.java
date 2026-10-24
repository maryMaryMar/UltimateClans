package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonDataComponentValue.class */
@ApiStatus.NonExtendable
public interface GsonDataComponentValue extends DataComponentValue {
    static GsonDataComponentValue gsonDataComponentValue(@NotNull JsonElement jsonElement) {
        return jsonElement instanceof JsonNull ? GsonDataComponentValueImpl.RemovedGsonComponentValueImpl.INSTANCE : new GsonDataComponentValueImpl((JsonElement) Objects.requireNonNull(jsonElement, "data"));
    }

    @NotNull
    JsonElement element();
}
