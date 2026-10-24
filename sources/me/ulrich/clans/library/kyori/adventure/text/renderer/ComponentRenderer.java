package me.ulrich.clans.library.kyori.adventure.text.renderer;

import java.util.function.Function;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/renderer/ComponentRenderer.class */
public interface ComponentRenderer<C> {
    @NotNull
    Component render(@NotNull Component component, @NotNull C c);

    default <T> ComponentRenderer<T> mapContext(Function<T, C> function) {
        return (component, obj) -> {
            return render(component, function.apply(obj));
        };
    }
}
