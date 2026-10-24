package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/CallbackStylingTagImpl.class */
final class CallbackStylingTagImpl extends AbstractTag implements Inserting {
    private final Consumer<Style.Builder> styles;

    CallbackStylingTagImpl(Consumer<Style.Builder> consumer) {
        this.styles = consumer;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting
    @NotNull
    public Component value() {
        return Component.text("", Style.style(this.styles));
    }

    public int hashCode() {
        return Objects.hash(this.styles);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallbackStylingTagImpl) {
            return Objects.equals(this.styles, ((CallbackStylingTagImpl) obj).styles);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("styles", this.styles));
    }
}
