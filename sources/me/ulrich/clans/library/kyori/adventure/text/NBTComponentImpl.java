package me.ulrich.clans.library.kyori.adventure.text;

import java.util.List;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/NBTComponentImpl.class */
abstract class NBTComponentImpl<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends AbstractComponent implements NBTComponent<C, B> {
    static final boolean INTERPRET_DEFAULT = false;
    final String nbtPath;
    final boolean interpret;

    @Nullable
    final Component separator;

    NBTComponentImpl(@NotNull List<Component> list, @NotNull Style style, String str, boolean z, @Nullable Component component) {
        super(list, style);
        this.nbtPath = str;
        this.interpret = z;
        this.separator = component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    @NotNull
    public String nbtPath() {
        return this.nbtPath;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponent
    public boolean interpret() {
        return this.interpret;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.BuildableComponent, me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public abstract B mo683toBuilder();

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBTComponent) || !super.equals(obj)) {
            return false;
        }
        NBTComponent nBTComponent = (NBTComponent) obj;
        return Objects.equals(this.nbtPath, nBTComponent.nbtPath()) && this.interpret == nBTComponent.interpret() && Objects.equals(this.separator, nBTComponent.separator());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.AbstractComponent
    public int hashCode() {
        return (31 * ((31 * ((31 * super.hashCode()) + this.nbtPath.hashCode())) + Boolean.hashCode(this.interpret))) + Objects.hashCode(this.separator);
    }
}
