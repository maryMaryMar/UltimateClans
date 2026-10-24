package me.ulrich.clans.library.kyori.adventure.text.serializer.legacy;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyFormat.class */
public final class LegacyFormat implements Examinable {
    static final LegacyFormat RESET = new LegacyFormat(true);

    @Nullable
    private final NamedTextColor color;

    @Nullable
    private final TextDecoration decoration;
    private final boolean reset;

    LegacyFormat(@Nullable NamedTextColor namedTextColor) {
        this.color = namedTextColor;
        this.decoration = null;
        this.reset = false;
    }

    LegacyFormat(@Nullable TextDecoration textDecoration) {
        this.color = null;
        this.decoration = textDecoration;
        this.reset = false;
    }

    private LegacyFormat(boolean z) {
        this.color = null;
        this.decoration = null;
        this.reset = z;
    }

    @Nullable
    public TextColor color() {
        return this.color;
    }

    @Nullable
    public TextDecoration decoration() {
        return this.decoration;
    }

    public boolean reset() {
        return this.reset;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LegacyFormat legacyFormat = (LegacyFormat) obj;
        return this.color == legacyFormat.color && this.decoration == legacyFormat.decoration && this.reset == legacyFormat.reset;
    }

    public int hashCode() {
        return (31 * ((31 * Objects.hashCode(this.color)) + Objects.hashCode(this.decoration))) + Boolean.hashCode(this.reset);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("color", this.color), ExaminableProperty.of("decoration", this.decoration), ExaminableProperty.of("reset", this.reset)});
    }
}
