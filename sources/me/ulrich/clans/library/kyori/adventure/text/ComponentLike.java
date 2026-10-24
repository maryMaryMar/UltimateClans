package me.ulrich.clans.library.kyori.adventure.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/ComponentLike.class */
@FunctionalInterface
public interface ComponentLike {
    @NotNull
    static List<Component> asComponents(@NotNull List<? extends ComponentLike> list) {
        return asComponents(list, null);
    }

    @NotNull
    static List<Component> asComponents(@NotNull List<? extends ComponentLike> list, @Nullable Predicate<? super Component> predicate) {
        Objects.requireNonNull(list, "likes");
        int size = list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ComponentLike componentLike = list.get(i);
            if (componentLike == null) {
                throw new NullPointerException("likes[" + i + "]");
            }
            Component componentAsComponent = componentLike.asComponent();
            if (predicate == null || predicate.test(componentAsComponent)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(size);
                }
                arrayList.add(componentAsComponent);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        arrayList.trimToSize();
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    static Component unbox(@Nullable ComponentLike componentLike) {
        if (componentLike != null) {
            return componentLike.asComponent();
        }
        return null;
    }

    @Contract(pure = true)
    @NotNull
    Component asComponent();
}
