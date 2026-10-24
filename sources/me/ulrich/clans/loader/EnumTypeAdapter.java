package me.ulrich.clans.loader;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.Enum;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/EnumTypeAdapter.class */
public final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
    public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();
    private final Map<String, T> nameToConstant = new HashMap();
    private final Map<T, String> constantToName = new HashMap();

    public EnumTypeAdapter(Class<T> cls) {
        try {
            for (T t : cls.getEnumConstants()) {
                String strName = t.name();
                SerializedName annotation = cls.getField(strName).getAnnotation(SerializedName.class);
                if (annotation != null) {
                    strName = annotation.value();
                }
                this.nameToConstant.put(strName, t);
                this.constantToName.put(t, strName);
            }
        } catch (NoSuchFieldException e) {
        }
    }

    public static <TT> TypeAdapterFactory newEnumTypeHierarchyFactory() {
        return new TypeAdapterFactory() { // from class: me.ulrich.clans.loader.EnumTypeAdapter.1
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
    public T read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return this.nameToConstant.get(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        jsonWriter.value(t == null ? null : this.constantToName.get(t));
    }
}
