package me.ulrich.clans.library.kyori.adventure.text.serializer.json;

import java.util.Optional;
import java.util.function.Supplier;
import me.ulrich.clans.library.kyori.adventure.util.Services;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONComponentSerializerAccessor.class */
final class JSONComponentSerializerAccessor {
    private static final Optional<JSONComponentSerializer.Provider> SERVICE = Services.serviceWithFallback(JSONComponentSerializer.Provider.class);

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/json/JSONComponentSerializerAccessor$Instances.class */
    static final class Instances {
        static final JSONComponentSerializer INSTANCE = (JSONComponentSerializer) JSONComponentSerializerAccessor.SERVICE.map((v0) -> {
            return v0.instance();
        }).orElse(DummyJSONComponentSerializer.INSTANCE);
        static final Supplier<JSONComponentSerializer.Builder> BUILDER_SUPPLIER = (Supplier) JSONComponentSerializerAccessor.SERVICE.map((v0) -> {
            return v0.builder();
        }).orElse(DummyJSONComponentSerializer.BuilderImpl::new);

        Instances() {
        }
    }

    private JSONComponentSerializerAccessor() {
    }
}
