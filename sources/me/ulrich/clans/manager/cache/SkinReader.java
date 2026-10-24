package me.ulrich.clans.manager.cache;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.UUID;

public class SkinReader {
    public String[] getFromUUID(UUID uuid) {
        try {
            JsonObject asJsonObject;
            JsonObject asJsonObject2;
            InputStreamReader inputStreamReader = new InputStreamReader(new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + String.valueOf(uuid) + "?unsigned=false").openStream());
            if (inputStreamReader == null || (asJsonObject = new JsonParser().parse(inputStreamReader).getAsJsonObject()) == null || (asJsonObject2 = asJsonObject.get("properties").getAsJsonArray().get(0).getAsJsonObject()) == null) {
                return null;
            }
            String asString = asJsonObject2.get("value").getAsString();
            String asString2 = asJsonObject2.get("signature").getAsString();
            if (asString == null || asString2 == null) {
                return null;
            }
            return new String[]{asString, asString2};
        } catch (Exception e) {
            return null;
        }
    }

    public String[] getFromName(String str) {
        try {
            JsonObject asJsonObject = new JsonParser().parse(new InputStreamReader(new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + new JsonParser().parse(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + str).openStream())).getAsJsonObject().get("id").getAsString() + "?unsigned=false").openStream())).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
            return new String[]{asJsonObject.get("value").getAsString(), asJsonObject.get("signature").getAsString()};
        } catch (Exception e) {
            return null;
        }
    }
}
