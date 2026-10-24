package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg;

import java.util.UUID;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/kSFM3X0M9q2n7XFSS/DTKXb4fQF6nDgxzg/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().run(uuid, () -> {
            switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
                case MYSQL:
                case SQLITE:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(uuid);
                    break;
                case YAML:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.Ijap9SQKkijXSxP5.jBUuLP0sWwaPyPOmogdX7l(uuid);
                    break;
            }
        });
    }
}
