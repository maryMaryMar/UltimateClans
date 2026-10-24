package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.util.Index;
import me.ulrich.clans.library.kyori.adventure.util.TriState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/TextDecoration.class */
public enum TextDecoration implements StyleBuilderApplicable, TextFormat {
    OBFUSCATED("obfuscated"),
    BOLD("bold"),
    STRIKETHROUGH("strikethrough"),
    UNDERLINED("underlined"),
    ITALIC("italic");

    public static final Index<String, TextDecoration> NAMES = Index.create(TextDecoration.class, textDecoration -> {
        return textDecoration.name;
    });
    private final String name;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/TextDecoration$State.class */
    public enum State {
        NOT_SET("not_set"),
        FALSE("false"),
        TRUE("true");

        private final String name;

        State(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        @NotNull
        public static State byBoolean(boolean z) {
            return z ? TRUE : FALSE;
        }

        @NotNull
        public static State byBoolean(@Nullable Boolean bool) {
            return bool == null ? NOT_SET : byBoolean(bool.booleanValue());
        }

        @NotNull
        public static State byTriState(@NotNull TriState triState) {
            Objects.requireNonNull(triState);
            switch (triState) {
                case TRUE:
                    return TRUE;
                case FALSE:
                    return FALSE;
                case NOT_SET:
                    return NOT_SET;
                default:
                    throw new IllegalArgumentException("Unable to turn TriState: " + triState + " into a TextDecoration.State");
            }
        }
    }

    TextDecoration(String str) {
        this.name = str;
    }

    @Deprecated
    @NotNull
    public final TextDecorationAndState as(boolean z) {
        return withState(z);
    }

    @Deprecated
    @NotNull
    public final TextDecorationAndState as(@NotNull State state) {
        return withState(state);
    }

    @NotNull
    public final TextDecorationAndState withState(boolean z) {
        return new TextDecorationAndStateImpl(this, State.byBoolean(z));
    }

    @NotNull
    public final TextDecorationAndState withState(@NotNull State state) {
        return new TextDecorationAndStateImpl(this, state);
    }

    @NotNull
    public final TextDecorationAndState withState(@NotNull TriState triState) {
        return new TextDecorationAndStateImpl(this, State.byTriState(triState));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable
    public void styleApply(Style.Builder builder) {
        builder.decorate(this);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.name;
    }
}
