package me.ulrich.clans.library.kyori.adventure.text;

import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.StyleBuilderApplicable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/LinearComponents.class */
public final class LinearComponents {
    private LinearComponents() {
    }

    @NotNull
    public static Component linear(@NotNull ComponentBuilderApplicable... componentBuilderApplicableArr) {
        int length = componentBuilderApplicableArr.length;
        if (length == 0) {
            return Component.empty();
        }
        if (length == 1) {
            ComponentBuilderApplicable componentBuilderApplicable = componentBuilderApplicableArr[0];
            if (componentBuilderApplicable instanceof ComponentLike) {
                return ((ComponentLike) componentBuilderApplicable).asComponent();
            }
            throw nothingComponentLike();
        }
        TextComponentImpl.BuilderImpl builderImpl = new TextComponentImpl.BuilderImpl();
        Style.Builder builderStyle = null;
        for (ComponentBuilderApplicable componentBuilderApplicable2 : componentBuilderApplicableArr) {
            if (componentBuilderApplicable2 instanceof StyleBuilderApplicable) {
                if (builderStyle == null) {
                    builderStyle = Style.style();
                }
                builderStyle.apply((StyleBuilderApplicable) componentBuilderApplicable2);
            } else if (builderStyle == null || !(componentBuilderApplicable2 instanceof ComponentLike)) {
                builderImpl.applicableApply(componentBuilderApplicable2);
            } else {
                builderImpl.applicableApply(((ComponentLike) componentBuilderApplicable2).asComponent().style(builderStyle));
            }
        }
        int size = builderImpl.children.size();
        if (size == 0) {
            throw nothingComponentLike();
        }
        return (size != 1 || builderImpl.hasStyle()) ? builderImpl.build2() : builderImpl.children.get(0);
    }

    private static IllegalStateException nothingComponentLike() {
        return new IllegalStateException("Cannot build component linearly - nothing component-like was given");
    }
}
