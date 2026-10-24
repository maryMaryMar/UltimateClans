package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import java.util.Objects;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/InsertingImpl.class */
final class InsertingImpl extends AbstractTag implements Inserting {
    private final boolean allowsChildren;
    private final Component value;

    InsertingImpl(boolean z, Component component) {
        this.allowsChildren = z;
        this.value = component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting
    public boolean allowsChildren() {
        return this.allowsChildren;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting
    @NotNull
    public Component value() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.allowsChildren), this.value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsertingImpl)) {
            return false;
        }
        InsertingImpl insertingImpl = (InsertingImpl) obj;
        return this.allowsChildren == insertingImpl.allowsChildren && Objects.equals(this.value, insertingImpl.value);
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("allowsChildren", this.allowsChildren), ExaminableProperty.of("value", this.value)});
    }
}
