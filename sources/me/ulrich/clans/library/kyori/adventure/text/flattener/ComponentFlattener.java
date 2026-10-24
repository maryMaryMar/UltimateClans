package me.ulrich.clans.library.kyori.adventure.text.flattener;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.util.Buildable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/ComponentFlattener.class */
@ApiStatus.NonExtendable
public interface ComponentFlattener extends Buildable<ComponentFlattener, Builder> {
    public static final int NO_NESTING_LIMIT = -1;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/flattener/ComponentFlattener$Builder.class */
    @ApiStatus.NonExtendable
    public interface Builder extends AbstractBuilder<ComponentFlattener>, Buildable.Builder<ComponentFlattener> {
        @NotNull
        <T extends Component> Builder mapper(@NotNull Class<T> cls, @NotNull Function<T, String> function);

        @NotNull
        <T extends Component> Builder complexMapper(@NotNull Class<T> cls, @NotNull BiConsumer<T, Consumer<Component>> biConsumer);

        @NotNull
        Builder unknownMapper(@Nullable Function<Component, String> function);

        @NotNull
        Builder nestingLimit(int i);
    }

    @NotNull
    static Builder builder() {
        return new ComponentFlattenerImpl.BuilderImpl();
    }

    @NotNull
    static ComponentFlattener basic() {
        return ComponentFlattenerImpl.BASIC;
    }

    @NotNull
    static ComponentFlattener textOnly() {
        return ComponentFlattenerImpl.TEXT_ONLY;
    }

    void flatten(@NotNull Component component, @NotNull FlattenerListener flattenerListener);
}
