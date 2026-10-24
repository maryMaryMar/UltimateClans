package me.ulrich.clans.library.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.adventure.text.event.DataComponentValue;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonDataComponentValueImpl.class */
class GsonDataComponentValueImpl implements GsonDataComponentValue {
    private final JsonElement element;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/gson/GsonDataComponentValueImpl$RemovedGsonComponentValueImpl.class */
    static final class RemovedGsonComponentValueImpl extends GsonDataComponentValueImpl implements DataComponentValue.Removed {
        static final RemovedGsonComponentValueImpl INSTANCE = new RemovedGsonComponentValueImpl();

        private RemovedGsonComponentValueImpl() {
            super(JsonNull.INSTANCE);
        }
    }

    GsonDataComponentValueImpl(@NotNull JsonElement jsonElement) {
        this.element = jsonElement;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.gson.GsonDataComponentValue
    @NotNull
    public JsonElement element() {
        return this.element;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("element", this.element));
    }

    public String toString() {
        return Internals.toString(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.element, ((GsonDataComponentValueImpl) obj).element);
    }

    public int hashCode() {
        return Objects.hashCode(this.element);
    }
}
