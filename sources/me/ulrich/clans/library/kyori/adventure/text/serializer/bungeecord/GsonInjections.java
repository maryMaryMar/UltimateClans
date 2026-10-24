package me.ulrich.clans.library.kyori.adventure.text.serializer.bungeecord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Excluder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/bungeecord/GsonInjections.class */
final class GsonInjections {
    private GsonInjections() {
    }

    public static Field field(@NotNull Class<?> cls, @NotNull String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField;
    }

    public static boolean injectGson(@NotNull Gson gson, @NotNull Consumer<GsonBuilder> consumer) {
        try {
            Field field = field(Gson.class, "factories");
            Field field2 = field(GsonBuilder.class, "factories");
            Field field3 = field(GsonBuilder.class, "hierarchyFactories");
            GsonBuilder gsonBuilder = new GsonBuilder();
            consumer.accept(gsonBuilder);
            List list = (List) field.get(gson);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) field2.get(gsonBuilder));
            Collections.reverse(arrayList);
            arrayList.addAll((List) field3.get(gsonBuilder));
            ArrayList arrayList2 = new ArrayList(list);
            int iFindExcluderIndex = findExcluderIndex(arrayList2);
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(iFindExcluderIndex, (TypeAdapterFactory) it.next());
            }
            field.set(gson, arrayList2);
            return true;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    private static int findExcluderIndex(@NotNull List<TypeAdapterFactory> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof Excluder) {
                return i + 1;
            }
        }
        return 0;
    }
}
