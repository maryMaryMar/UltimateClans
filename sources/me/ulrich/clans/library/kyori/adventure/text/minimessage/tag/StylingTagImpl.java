package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import java.util.Arrays;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/StylingTagImpl.class */
final class StylingTagImpl extends AbstractTag implements Inserting {
    private final StyleBuilderApplicable[] styles;

    StylingTagImpl(StyleBuilderApplicable[] styleBuilderApplicableArr) {
        this.styles = styleBuilderApplicableArr;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting
    @NotNull
    public Component value() {
        return Component.text("", Style.style(this.styles));
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.styles);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StylingTagImpl) {
            return Arrays.equals(this.styles, ((StylingTagImpl) obj).styles);
        }
        return false;
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("styles", this.styles));
    }
}
