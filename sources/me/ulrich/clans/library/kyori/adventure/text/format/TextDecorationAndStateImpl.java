package me.ulrich.clans.library.kyori.adventure.text.format;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.internal.Internals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/format/TextDecorationAndStateImpl.class */
final class TextDecorationAndStateImpl implements TextDecorationAndState {
    private final TextDecoration decoration;
    private final TextDecoration.State state;

    TextDecorationAndStateImpl(TextDecoration textDecoration, TextDecoration.State state) {
        this.decoration = textDecoration;
        this.state = (TextDecoration.State) Objects.requireNonNull(state, "state");
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.TextDecorationAndState
    @NotNull
    public TextDecoration decoration() {
        return this.decoration;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.format.TextDecorationAndState
    public TextDecoration.State state() {
        return this.state;
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
        TextDecorationAndStateImpl textDecorationAndStateImpl = (TextDecorationAndStateImpl) obj;
        return this.decoration == textDecorationAndStateImpl.decoration && this.state == textDecorationAndStateImpl.state;
    }

    public int hashCode() {
        return (31 * this.decoration.hashCode()) + this.state.hashCode();
    }
}
