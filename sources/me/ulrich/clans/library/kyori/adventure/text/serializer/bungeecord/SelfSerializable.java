package me.ulrich.clans.library.kyori.adventure.text.serializer.bungeecord;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/bungeecord/SelfSerializable.class */
interface SelfSerializable {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/bungeecord/SelfSerializable$AdapterFactory.class */
    public static class AdapterFactory implements TypeAdapterFactory {

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/bungeecord/SelfSerializable$AdapterFactory$SelfSerializableTypeAdapter.class */
        static class SelfSerializableTypeAdapter<T> extends TypeAdapter<T> {
            private final TypeToken<T> type;

            SelfSerializableTypeAdapter(TypeToken<T> typeToken) {
                this.type = typeToken;
            }

            public void write(JsonWriter jsonWriter, T t) {
                ((SelfSerializable) t).write(jsonWriter);
            }

            public T read(JsonReader jsonReader) {
                throw new UnsupportedOperationException("Cannot load values of type " + this.type.getType().getTypeName());
            }
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (SelfSerializable.class.isAssignableFrom(typeToken.getRawType())) {
                return new SelfSerializableTypeAdapter(typeToken);
            }
            return null;
        }

        static {
            SelfSerializableTypeAdapter.class.getName();
        }
    }

    void write(JsonWriter jsonWriter);
}
