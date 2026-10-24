package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/TranslationArgumentImpl.class */
final class TranslationArgumentImpl implements TranslationArgument {
    private static final Component TRUE = Component.text("true");
    private static final Component FALSE = Component.text("false");
    private final Object value;

    TranslationArgumentImpl(Object obj) {
        this.value = obj;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslationArgument
    @NotNull
    public Object value() {
        return this.value;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.TranslationArgumentLike, me.ulrich.clans.library.kyori.adventure.text.ComponentLike
    @NotNull
    public Component asComponent() {
        if (this.value instanceof Component) {
            return (Component) this.value;
        }
        if (this.value instanceof Boolean) {
            return ((Boolean) this.value).booleanValue() ? TRUE : FALSE;
        }
        return Component.text(String.valueOf(this.value));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.value, ((TranslationArgumentImpl) obj).value);
    }

    public int hashCode() {
        return Objects.hash(this.value);
    }

    public String toString() {
        return Internals.toString(this);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}
