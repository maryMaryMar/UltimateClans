package me.ulrich.clans.tasks;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private static String Vo18mMOE7RFM1W4tL;
    private static String tP4AJRGQt2grRqo;
    private static volatile String TvtBKPeOEScVplPxvj3S3;
    private static String ggDOelquSffaX5ahiQWIJg;
    private static volatile String K7Fh8FGcbAT49YJ;
    private static String VglK4uMZylHaMiW;
    private static volatile String w4D8NB18N8rSKFb6YwXGw;
    private static volatile String F6JEU4zzu8IxxYia;
    private static final byte[] bdTNPGbr1C6EH8vi6l = {(byte) 244, (byte) 103, (byte) 16, (byte) 1, (byte) 96, (byte) 95, (byte) 215, (byte) 253, (byte) 26, (byte) 200, (byte) 40, (byte) 39, (byte) 170, (byte) 214, (byte) 176, (byte) 101, (byte) 230, (byte) 90, (byte) 166, (byte) 81, (byte) 63, (byte) 24, (byte) 214, (byte) 247, (byte) 25, (byte) 1, (byte) 103, (byte) 106, (byte) 133, (byte) 148, (byte) 223, (byte) 185};
    private static final byte[] hA9q0mOkEk02mzE = {(byte) 233, (byte) 104, (byte) 60, (byte) 93, (byte) 102, (byte) 14, (byte) 166, (byte) 133, (byte) 74, (byte) 40, (byte) 226, (byte) 119, (byte) 92, (byte) 254, (byte) 0, (byte) 158, (byte) 198, (byte) 89, (byte) 244, (byte) 237, (byte) 148, (byte) 11, (byte) 28, (byte) 154, (byte) 244, (byte) 229, (byte) 22, (byte) 136, (byte) 216, (byte) 90, (byte) 214, (byte) 56, (byte) 153, (byte) 35, (byte) 80, (byte) 162, (byte) 247, (byte) 198, (byte) 231, (byte) 87, (byte) 7, (byte) 61, (byte) 92, (byte) 176, (byte) 209, (byte) 185, (byte) 93, (byte) 175};
    private static final byte[] xUCrLXU9CoNwUYJQD = {(byte) 19, (byte) 203, (byte) 61, (byte) 57, (byte) 90, (byte) 53, (byte) 250, (byte) 140, (byte) 96, (byte) 87, (byte) 57, (byte) 67, (byte) 150, (byte) 100, (byte) 109, (byte) 106, (byte) 199, (byte) 180, (byte) 162, (byte) 65, (byte) 236, (byte) 70, (byte) 247, (byte) 216, (byte) 9, (byte) 161, (byte) 56, (byte) 195, (byte) 86, (byte) 160, (byte) 18, (byte) 35, (byte) 3, (byte) 171, (byte) 190, (byte) 122, (byte) 38, (byte) 185, (byte) 156, (byte) 93, (byte) 197, (byte) 236, (byte) 55, (byte) 158, (byte) 254, (byte) 211, (byte) 62, (byte) 20};

    public Ijap9SQKkijXSxP5(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
            v8qP8fE86HMhvNuYPFjqY();
        });
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        if (jBUuLP0sWwaPyPOmogdX7l().getFiles().p31abtwfBag2jhMH6K().getBoolean(Cs8LjsO4hX8K6Kp8dD2Hy()) && jBUuLP0sWwaPyPOmogdX7l().getFiles().p31abtwfBag2jhMH6K().getBoolean(NlqnvnXYUsxmkpN()) && jBUuLP0sWwaPyPOmogdX7l().getClanManager().CDW4Fj1iwdIXEOqWjiJSR().size() > 0) {
            ArrayList<ClanData> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            int i = jBUuLP0sWwaPyPOmogdX7l().getFiles().p31abtwfBag2jhMH6K().getInt(M9Z8zJCl0s3zHQNYzUMdw());
            long j = jCurrentTimeMillis - ((long) (86400 * i));
            for (Map.Entry<UUID, ClanData> entry : new HashMap<UUID, ClanData>(jBUuLP0sWwaPyPOmogdX7l().getClanManager().CDW4Fj1iwdIXEOqWjiJSR()).entrySet()) {
                if (j > ((ClanData) entry.getValue()).getCreationDate()) {
                    Optional<PlayerData> optionalP31abtwfBag2jhMH6K = jBUuLP0sWwaPyPOmogdX7l().getPlayerManager().p31abtwfBag2jhMH6K(((ClanData) entry.getValue()).getLeader());
                    if (optionalP31abtwfBag2jhMH6K.isPresent() && j > optionalP31abtwfBag2jhMH6K.get().getLastSeen()) {
                        if (jBUuLP0sWwaPyPOmogdX7l().getFiles().p31abtwfBag2jhMH6K().getBoolean(xmRN5L667Yp3gwm()) && ((ClanData) entry.getValue()).getMembers().size() > 1) {
                            Map<UUID, Integer> mapZwrsrwOCXRUscW6Q = jBUuLP0sWwaPyPOmogdX7l().getModerationManager().ZwrsrwOCXRUscW6Q(((ClanData) entry.getValue()).getId(), false);
                            if (mapZwrsrwOCXRUscW6Q.size() > 0) {
                                Optional<Map.Entry<UUID, Integer>> optionalFindFirst = mapZwrsrwOCXRUscW6Q.entrySet().stream().findFirst();
                                if (optionalFindFirst.isPresent()) {
                                    UUID key = optionalFindFirst.get().getKey();
                                    Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = jBUuLP0sWwaPyPOmogdX7l().getPlayerManager().p31abtwfBag2jhMH6K(key);
                                    if (optionalP31abtwfBag2jhMH6K2.isPresent() && j < optionalP31abtwfBag2jhMH6K2.get().getLastSeen()) {
                                        jBUuLP0sWwaPyPOmogdX7l().getClanManager().jBUuLP0sWwaPyPOmogdX7l(((ClanData) entry.getValue()).getId(), key);
                                        arrayList2.add("Clan " + ((ClanData) entry.getValue()).getTagNoColor() + " had its leader changed to " + key.toString() + " due to inactivity");
                                    }
                                }
                            }
                        }
                        arrayList.add((ClanData) entry.getValue());
                    }
                }
            }
            if (arrayList2.size() > 0) {
                if (jBUuLP0sWwaPyPOmogdX7l().getFiles().p31abtwfBag2jhMH6K().getBoolean(gwhBDmp0xVjR4p())) {
                    new jBWyXxi9EyWxcPiz(jBUuLP0sWwaPyPOmogdX7l()).v8qP8fE86HMhvNuYPFjqY(arrayList2, StmZXLbVfEFmpiy());
                }
                jBUuLP0sWwaPyPOmogdX7l().getLogger().warning(arrayList2.size() + " Clans had their leaders changed due to inactivity!");
            }
            if (arrayList.size() > 0) {
                arrayList.forEach(clanData -> {
                    jBUuLP0sWwaPyPOmogdX7l().getClanManager().zJnaNCVQSgEShq(clanData.getId());
                    if (jBUuLP0sWwaPyPOmogdX7l().getFiles().p31abtwfBag2jhMH6K().getBoolean(pfddPG0Mki0ONvmu4ezRU())) {
                        new jBWyXxi9EyWxcPiz(jBUuLP0sWwaPyPOmogdX7l()).v8qP8fE86HMhvNuYPFjqY("Clan " + clanData.getTagNoColor() + " has been deleted due to inactivity for more than " + i + " days", RdK7JTPN9Nevvw2l8Z9G());
                    }
                });
                jBUuLP0sWwaPyPOmogdX7l().getLogger().warning(arrayList.size() + " Clans were deleted due to inactivity!");
            }
        }
    }

    public Clans jBUuLP0sWwaPyPOmogdX7l() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String lbbkYpbZRJOIXY3mT(byte[] bArr) {
        return "";
    }

    private static String Cs8LjsO4hX8K6Kp8dD2Hy() {
        return "Clan.inactivity.enabled";
    }

    private static String NlqnvnXYUsxmkpN() {
        return "Clan.inactivity.confirm_deletion";
    }

    private static String M9Z8zJCl0s3zHQNYzUMdw() {
        return "Clan.inactivity.delete_after";
    }

    private static String xmRN5L667Yp3gwm() {
        return "Clan.inactivity.leader_another_member";
    }

    private static String gwhBDmp0xVjR4p() {
        return "Clan.inactivity.activity_log";
    }

    private static String StmZXLbVfEFmpiy() {
        return "CHANGELEADER_DUE_TO_INACTIVITY";
    }

    private static String pfddPG0Mki0ONvmu4ezRU() {
        return "Clan.inactivity.activity_log";
    }

    private static String RdK7JTPN9Nevvw2l8Z9G() {
        return "DELETED_DUE_TO_INACTIVITY";
    }
}
