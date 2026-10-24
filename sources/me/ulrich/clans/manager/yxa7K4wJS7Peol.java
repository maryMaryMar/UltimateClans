package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.TopData;
import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/yxa7K4wJS7Peol.class */
public class yxa7K4wJS7Peol {
    private ConcurrentHashMap<ClanEnum.PlaceholderTop, HashMap<UUID, Float>> v8qP8fE86HMhvNuYPFjqY = new ConcurrentHashMap<>();
    private ConcurrentHashMap<ClanEnum.PlaceholderPlayerTop, HashMap<UUID, Float>> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private Clans ZwrsrwOCXRUscW6Q;
    private static String D6QG1L4ubdvqTWodsi9iY;
    private static String VGfggSldJXsvuYD;
    private static String haxEaWrtA7hgcMR0IX5;
    private static final byte[] hsqV6n1HGyIyc5 = {(byte) 93, (byte) 121, (byte) 220, (byte) 66, (byte) 11, (byte) 2, (byte) 212, (byte) 74, (byte) 199, (byte) 252, (byte) 212, (byte) 250, (byte) 222, (byte) 182, (byte) 66, (byte) 187, (byte) 76, (byte) 40, (byte) 171, (byte) 224, (byte) 129, (byte) 247, (byte) 164, (byte) 127, (byte) 120, (byte) 219, (byte) 8, (byte) 52, (byte) 45, (byte) 204, (byte) 157, (byte) 79};
    private static final byte[] JoBewyhq30WgxHqlwWcNs = {(byte) 93, (byte) 121, (byte) 220, (byte) 66, (byte) 11, (byte) 2, (byte) 212, (byte) 74, (byte) 199, (byte) 252, (byte) 212, (byte) 250, (byte) 222, (byte) 182, (byte) 66, (byte) 187, (byte) 76, (byte) 40, (byte) 171, (byte) 224, (byte) 129, (byte) 247, (byte) 164, (byte) 127, (byte) 120, (byte) 219, (byte) 8, (byte) 52, (byte) 45, (byte) 204, (byte) 157, (byte) 79};
    private static final byte[] ggYuxa8dhv9a7Jaqyv = {(byte) 168, (byte) 120, (byte) 45, (byte) 4, (byte) 52, (byte) 63, (byte) 181, (byte) 182, (byte) 100, (byte) 80, (byte) 5, (byte) 2, (byte) 118, (byte) 94, (byte) 168, (byte) 251, (byte) 96, (byte) 140, (byte) 11, (byte) 209, (byte) 244, (byte) 243, (byte) 175, (byte) 39, (byte) 193, (byte) 195, (byte) 181, (byte) 101, (byte) 68, (byte) 138, (byte) 125, (byte) 67};
    private static final byte[] lFx2f1oiSobmhpZx = {(byte) 191, (byte) 14, (byte) 132, (byte) 128, (byte) 97, (byte) 75, (byte) 6, (byte) 105, (byte) 62, (byte) 85, (byte) 181, (byte) 147, (byte) 21, (byte) 244, (byte) 91, (byte) 34};

    public yxa7K4wJS7Peol(Clans clans) {
        this.ZwrsrwOCXRUscW6Q = clans;
    }

    public void v8qP8fE86HMhvNuYPFjqY(List<ClanEnum.PlaceholderTop> list) {
        if (list.isEmpty()) {
            list = Arrays.asList(ClanEnum.PlaceholderTop.values());
        }
        if (list.isEmpty()) {
            return;
        }
        for (ClanEnum.PlaceholderTop placeholderTop : list) {
            HashMap<UUID, Float> mapIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(placeholderTop);
            HashMap<UUID, Float> map = new HashMap<>();
            mapIZTqZaRK5UGoe0Z.forEach((uuid, f) -> {
                map.merge(uuid, f, (v0, v1) -> {
                    return Float.max(v0, v1);
                });
            });
            this.v8qP8fE86HMhvNuYPFjqY.put(placeholderTop, (LinkedHashMap) map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap((v0) -> {
                return v0.getKey();
            }, (v0) -> {
                return v0.getValue();
            }, (f2, f3) -> {
                return f2;
            }, LinkedHashMap::new)));
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(ClanEnum.PlaceholderTop placeholderTop) {
        return v8qP8fE86HMhvNuYPFjqY().containsKey(placeholderTop);
    }

    public HashMap<UUID, Float> jBUuLP0sWwaPyPOmogdX7l(ClanEnum.PlaceholderTop placeholderTop) {
        HashMap<UUID, Float> map;
        if (this.ZwrsrwOCXRUscW6Q.getFiles().p31abtwfBag2jhMH6K().getBoolean(NhzbbNHg2db3Ncxw())) {
            v8qP8fE86HMhvNuYPFjqY(Collections.singletonList(placeholderTop));
        }
        return (!v8qP8fE86HMhvNuYPFjqY(placeholderTop) || (map = v8qP8fE86HMhvNuYPFjqY().get(placeholderTop)) == null) ? new LinkedHashMap() : (HashMap) map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        }, (f, f2) -> {
            return f;
        }, LinkedHashMap::new));
    }

    public List<Map.Entry<UUID, Float>> v8qP8fE86HMhvNuYPFjqY(ClanEnum.PlaceholderTop placeholderTop, int i) {
        ArrayList arrayList = new ArrayList(jBUuLP0sWwaPyPOmogdX7l(placeholderTop).entrySet());
        return arrayList.subList(0, Math.min(arrayList.size(), i));
    }

    public Optional<TopData> jBUuLP0sWwaPyPOmogdX7l(ClanEnum.PlaceholderTop placeholderTop, int i) {
        if (v8qP8fE86HMhvNuYPFjqY(placeholderTop)) {
            ArrayList arrayList = new ArrayList(jBUuLP0sWwaPyPOmogdX7l(placeholderTop).entrySet());
            int i2 = i - 1;
            if (i2 >= 0 && i2 < arrayList.size()) {
                Map.Entry entry = (Map.Entry) arrayList.get(i2);
                return Optional.of(new TopData((UUID) entry.getKey(), (Float) entry.getValue()));
            }
        }
        return Optional.empty();
    }

    @Deprecated
    public List<ClanData> ZwrsrwOCXRUscW6Q(ClanEnum.PlaceholderTop placeholderTop) {
        ArrayList arrayList = new ArrayList();
        jBUuLP0sWwaPyPOmogdX7l(placeholderTop).entrySet().iterator().forEachRemaining(entry -> {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.ZwrsrwOCXRUscW6Q.getClanManager().iZTqZaRK5UGoe0Z((UUID) entry.getKey());
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                arrayList.add(optionalIZTqZaRK5UGoe0Z.get());
            }
        });
        return arrayList;
    }

    private HashMap<UUID, Float> iZTqZaRK5UGoe0Z(ClanEnum.PlaceholderTop placeholderTop) {
        LinkedHashMap<UUID, Float> linkedHashMap = new LinkedHashMap<>();
        for (ClanData clanData : new ArrayList<ClanData>(this.ZwrsrwOCXRUscW6Q.getClanManager().jBUuLP0sWwaPyPOmogdX7l())) {
            switch (trT8B9VBzCREM.v8qP8fE86HMhvNuYPFjqY[placeholderTop.ordinal()]) {
                case 1:
                    linkedHashMap.put(clanData.getId(), Float.valueOf((float) this.ZwrsrwOCXRUscW6Q.getClanManager().b4i2FbOkaKeg91LiAe6l(clanData.getId())));
                    break;
                case 2:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(this.ZwrsrwOCXRUscW6Q.getClanManager().lGGwXL678c4Kv7skJb5NiE(clanData.getId())));
                    break;
                case 3:
                    int kills = 0;
                    Iterator<UUID> it = clanData.getMembers().iterator();
                    while (it.hasNext()) {
                        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = jBUuLP0sWwaPyPOmogdX7l().getPlayerManager().p31abtwfBag2jhMH6K(it.next());
                        if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                            kills += optionalP31abtwfBag2jhMH6K.get().getKills();
                        }
                    }
                    linkedHashMap.put(clanData.getId(), Float.valueOf(kills));
                    break;
                case 4:
                    int deaths = 0;
                    Iterator<UUID> it2 = clanData.getMembers().iterator();
                    while (it2.hasNext()) {
                        Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = jBUuLP0sWwaPyPOmogdX7l().getPlayerManager().p31abtwfBag2jhMH6K(it2.next());
                        if (optionalP31abtwfBag2jhMH6K2.isPresent()) {
                            deaths += optionalP31abtwfBag2jhMH6K2.get().getDeaths();
                        }
                    }
                    linkedHashMap.put(clanData.getId(), Float.valueOf(deaths));
                    break;
                case 5:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(clanData.getCreationDate()));
                    break;
                case 6:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(clanData.getBank().floatValue()));
                    break;
                case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                case 8:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(clanData.getLevel()));
                    break;
                case 9:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(clanData.getMembers().size()));
                    break;
                case 10:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(clanData.getStats().getWarWin()));
                    break;
                case 11:
                    linkedHashMap.put(clanData.getId(), Float.valueOf(clanData.getQuest().getPoints()));
                    break;
            }
        }
        Map<UUID, Float> map = (Map<UUID, Float>) linkedHashMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        }, (f, f2) -> {
            return f2;
        }, LinkedHashMap::new));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        map.entrySet().iterator().forEachRemaining(entry -> {
            if (!linkedHashMap2.containsKey(entry.getKey())) {
            }
            linkedHashMap2.putIfAbsent((UUID) entry.getKey(), (Float) entry.getValue());
        });
        return linkedHashMap2;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(List<ClanEnum.PlaceholderPlayerTop> list) {
        if (list.size() == 0) {
            list = Arrays.asList(ClanEnum.PlaceholderPlayerTop.values());
        }
        if (list.size() > 0) {
            list.iterator().forEachRemaining(placeholderPlayerTop -> {
                this.jBUuLP0sWwaPyPOmogdX7l.put(placeholderPlayerTop, ZwrsrwOCXRUscW6Q(placeholderPlayerTop));
            });
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(ClanEnum.PlaceholderPlayerTop placeholderPlayerTop) {
        return ZwrsrwOCXRUscW6Q().containsKey(placeholderPlayerTop);
    }

    public HashMap<UUID, Float> jBUuLP0sWwaPyPOmogdX7l(ClanEnum.PlaceholderPlayerTop placeholderPlayerTop) {
        HashMap<UUID, Float> map;
        if (this.ZwrsrwOCXRUscW6Q.getFiles().p31abtwfBag2jhMH6K().getBoolean(FZ8OzYemVOuofhysBGtXiB())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(placeholderPlayerTop);
            jBUuLP0sWwaPyPOmogdX7l(arrayList);
        }
        return (!v8qP8fE86HMhvNuYPFjqY(placeholderPlayerTop) || (map = ZwrsrwOCXRUscW6Q().get(placeholderPlayerTop)) == null) ? new HashMap<>() : map;
    }

    public List<Map.Entry<UUID, Float>> v8qP8fE86HMhvNuYPFjqY(ClanEnum.PlaceholderPlayerTop placeholderPlayerTop, int i) {
        ArrayList arrayList = new ArrayList(jBUuLP0sWwaPyPOmogdX7l(placeholderPlayerTop).entrySet());
        return arrayList.subList(0, Math.min(arrayList.size(), i));
    }

    public Optional<TopData> jBUuLP0sWwaPyPOmogdX7l(ClanEnum.PlaceholderPlayerTop placeholderPlayerTop, int i) {
        if (v8qP8fE86HMhvNuYPFjqY(placeholderPlayerTop)) {
            ArrayList arrayList = new ArrayList(jBUuLP0sWwaPyPOmogdX7l(placeholderPlayerTop).entrySet());
            int i2 = i - 1;
            if (i2 >= 0 && i2 < arrayList.size()) {
                Map.Entry entry = (Map.Entry) arrayList.get(i2);
                return Optional.of(new TopData((UUID) entry.getKey(), (Float) entry.getValue()));
            }
        }
        return Optional.empty();
    }

    private HashMap<UUID, Float> ZwrsrwOCXRUscW6Q(ClanEnum.PlaceholderPlayerTop placeholderPlayerTop) {
        LinkedHashMap<UUID, Float> linkedHashMap = new LinkedHashMap<>();
        long j = ((long) this.ZwrsrwOCXRUscW6Q.getFiles().p31abtwfBag2jhMH6K().getInt(hOKzywOn0NoNMj3())) * 24 * 60 * 60;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (PlayerData playerData : (List<PlayerData>) this.ZwrsrwOCXRUscW6Q.getPlayerManager().xtOheRiObl4QeAl().values().stream().filter(playerData2 -> {
            return jCurrentTimeMillis - playerData2.getLastSeen() <= j;
        }).collect(Collectors.toList())) {
            switch (placeholderPlayerTop) {
                case KDR:
                    double kdr = playerData.getKdr();
                    if (Double.isNaN(kdr) || kdr < 0.0d) {
                        kdr = 0.0d;
                    }
                    linkedHashMap.put(playerData.getId(), Float.valueOf((float) kdr));
                    break;
                case SOULS:
                    linkedHashMap.put(playerData.getId(), Float.valueOf(0));
                    break;
                case ALL:
                    linkedHashMap.put(playerData.getId(), Float.valueOf(playerData.getLastSeen()));
                    break;
            }
        }
        Map<UUID, Float> map = (Map<UUID, Float>) linkedHashMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        }, (f, f2) -> {
            return f2;
        }, LinkedHashMap::new));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        map.entrySet().iterator().forEachRemaining(entry -> {
            if (!linkedHashMap2.containsKey(entry.getKey())) {
            }
            linkedHashMap2.putIfAbsent((UUID) entry.getKey(), (Float) entry.getValue());
        });
        return linkedHashMap2;
    }

    public ConcurrentHashMap<ClanEnum.PlaceholderTop, HashMap<UUID, Float>> v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public Clans jBUuLP0sWwaPyPOmogdX7l() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public ConcurrentHashMap<ClanEnum.PlaceholderPlayerTop, HashMap<UUID, Float>> ZwrsrwOCXRUscW6Q() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    @Deprecated
    public void v8qP8fE86HMhvNuYPFjqY(List<ClanData> list, ClanEnum.PlaceholderTop placeholderTop) {
    }

    private static String NhzbbNHg2db3Ncxw() {
        return "Config.top.realtime";
    }

    private static String FZ8OzYemVOuofhysBGtXiB() {
        return "Config.top.realtime";
    }

    private static String hOKzywOn0NoNMj3() {
        return "Config.top.players_days_filter";
    }
}
