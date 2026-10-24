package me.ulrich.clans.library.scoreboardlibrary.api.objective;

import com.google.common.base.Preconditions;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ScoreFormat.class */
@ApiStatus.NonExtendable
public interface ScoreFormat {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ScoreFormat$Blank.class */
    public static class Blank implements ScoreFormat {
        private static final Blank INSTANCE = new Blank();

        private Blank() {
        }

        public String toString() {
            return "Blank";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ScoreFormat$Fixed.class */
    public static class Fixed implements ScoreFormat {
        private final Component content;

        public Fixed(@NotNull Component component) {
            this.content = component;
        }

        @NotNull
        public Component content() {
            return this.content;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.content.equals(((Fixed) obj).content);
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        public String toString() {
            return "Fixed{content=" + this.content + "}";
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ScoreFormat$Styled.class */
    public static class Styled implements ScoreFormat {
        private final Style style;

        public Styled(@NotNull Style style) {
            this.style = style;
        }

        @NotNull
        public Style style() {
            return this.style;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.style.equals(((Styled) obj).style);
        }

        public int hashCode() {
            return this.style.hashCode();
        }

        public String toString() {
            return "Styled{style=" + this.style + "}";
        }
    }

    @NotNull
    static Blank blank() {
        return Blank.INSTANCE;
    }

    @NotNull
    static Fixed fixed(@NotNull ComponentLike componentLike) {
        Preconditions.checkNotNull(componentLike);
        return new Fixed(componentLike.asComponent());
    }

    @NotNull
    static Styled styled(@NotNull Style style) {
        Preconditions.checkNotNull(style);
        return new Styled(style);
    }

    @NotNull
    static Styled styled(@NotNull StyleBuilderApplicable... styleBuilderApplicableArr) {
        Preconditions.checkNotNull(styleBuilderApplicableArr);
        return new Styled(Style.style(styleBuilderApplicableArr));
    }
}
