package me.ulrich.clans.library.kyori.adventure.text;

import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponent;
import me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/AbstractNBTComponentBuilder.class */
abstract class AbstractNBTComponentBuilder<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends AbstractComponentBuilder<C, B> implements NBTComponentBuilder<C, B> {

    @Nullable
    protected String nbtPath;
    protected boolean interpret;

    @Nullable
    protected Component separator;

    AbstractNBTComponentBuilder() {
        this.interpret = false;
    }

    AbstractNBTComponentBuilder(@NotNull C c) {
        super(c);
        this.interpret = false;
        this.nbtPath = c.nbtPath();
        this.interpret = c.interpret();
        this.separator = c.separator();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder
    @NotNull
    public B nbtPath(@NotNull String str) {
        this.nbtPath = (String) Objects.requireNonNull(str, "nbtPath");
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder
    @NotNull
    public B interpret(boolean z) {
        this.interpret = z;
        return this;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.NBTComponentBuilder
    @NotNull
    public B separator(@Nullable ComponentLike componentLike) {
        this.separator = ComponentLike.unbox(componentLike);
        return this;
    }
}
