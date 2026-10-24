package me.ulrich.clans.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalTime;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/LocalTimeTypeAdapter.class */
public class LocalTimeTypeAdapter implements JsonDeserializer<LocalTime>, JsonSerializer<LocalTime> {
    public JsonElement serialize(LocalTime localTime, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.add("hour", new JsonPrimitive(Integer.valueOf(localTime.getHour())));
            jsonObject.add("minute", new JsonPrimitive(Integer.valueOf(localTime.getMinute())));
            jsonObject.add("second", new JsonPrimitive(Integer.valueOf(localTime.getSecond())));
            jsonObject.add("nano", new JsonPrimitive(Integer.valueOf(localTime.getNano())));
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jsonObject;
        }
    }

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public LocalTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        try {
            return LocalTime.of(asJsonObject.get("hour").getAsInt(), asJsonObject.get("minute").getAsInt(), asJsonObject.get("second").getAsInt(), asJsonObject.get("nano").getAsInt());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
