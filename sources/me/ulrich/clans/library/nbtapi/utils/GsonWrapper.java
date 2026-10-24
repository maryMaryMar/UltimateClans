package me.ulrich.clans.library.nbtapi.utils;

import com.google.gson.Gson;
import me.ulrich.clans.library.nbtapi.NbtApiException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/utils/GsonWrapper.class */
@Deprecated
public class GsonWrapper {
    private static Gson gson = new Gson();

    private GsonWrapper() {
    }

    public static String getString(Object obj) {
        return gson.toJson(obj);
    }

    public static void overwriteGsonInstance(Gson gson2) {
        gson = gson2;
    }

    public static <T> T deserializeJson(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            return cls.cast(gson.fromJson(str, cls));
        } catch (Exception e) {
            throw new NbtApiException("Error while converting json to " + cls.getName(), e);
        }
    }
}
