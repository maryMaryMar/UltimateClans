package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/PreProcessTagImpl.class */
final class PreProcessTagImpl extends AbstractTag implements PreProcess {
    private final String value;

    PreProcessTagImpl(String str) {
        this.value = str;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.PreProcess
    @NotNull
    public String value() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreProcessTagImpl) {
            return Objects.equals(this.value, ((PreProcessTagImpl) obj).value);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.value));
    }
}
