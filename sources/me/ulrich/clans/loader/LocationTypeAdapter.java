package me.ulrich.clans.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/loader/LocationTypeAdapter.class */
public class LocationTypeAdapter implements JsonDeserializer<Location>, JsonSerializer<Location> {
    public JsonElement serialize(Location location, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.add("x", new JsonPrimitive(Double.valueOf(location.getX())));
            jsonObject.add("y", new JsonPrimitive(Double.valueOf(location.getY())));
            jsonObject.add("z", new JsonPrimitive(Double.valueOf(location.getZ())));
            jsonObject.add("world", new JsonPrimitive(location.getWorld().getName()));
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jsonObject;
        }
    }

    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public Location deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        try {
            return new Location(Bukkit.getWorld(asJsonObject.get("world").getAsString()), asJsonObject.get("x").getAsDouble(), asJsonObject.get("y").getAsDouble(), asJsonObject.get("z").getAsDouble());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
