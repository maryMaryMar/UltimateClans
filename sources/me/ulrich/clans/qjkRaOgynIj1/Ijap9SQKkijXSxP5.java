package me.ulrich.clans.qjkRaOgynIj1;

import java.util.ArrayList;
import java.util.List;
import me.ulrich.clans.data.ClanData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    public List<ClanData> v8qP8fE86HMhvNuYPFjqY(List<ClanData> list, int i, int i2) {
        int i3 = (i - 1) * i2;
        return i3 >= list.size() ? new ArrayList() : list.subList(i3, Math.min(i3 + i2, list.size()));
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(List<ClanData> list, int i, int i2) {
        return i * i2 < list.size();
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(int i) {
        return i > 1;
    }

    public int ZwrsrwOCXRUscW6Q(List<ClanData> list, int i, int i2) {
        if (jBUuLP0sWwaPyPOmogdX7l(list, i, i2)) {
            return i + 1;
        }
        return -1;
    }

    public int jBUuLP0sWwaPyPOmogdX7l(int i) {
        if (v8qP8fE86HMhvNuYPFjqY(i)) {
            return i - 1;
        }
        return -1;
    }
}
