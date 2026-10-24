package me.ulrich.clans.tasks;

import java.util.UUID;
import me.ulrich.clans.data.ClanData;

import com.google.common.collect.Iterables;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/ZRp1tak21UvNaOVCtFx.class */
class ZRp1tak21UvNaOVCtFx implements Runnable {
    private int jBUuLP0sWwaPyPOmogdX7l = 0;
    private int ZwrsrwOCXRUscW6Q = 0;
    private int iZTqZaRK5UGoe0Z = 0;
    final /* synthetic */ UsEbiuprSHpNw3qjITfH v8qP8fE86HMhvNuYPFjqY;
    private static volatile String snIYkfWDtEnQinVqi;
    private static String AEwQNBBdv5KZ6I3y6oWiK;
    private static volatile String P4B3gHjoVYs1OiHQ;
    private static final byte[] gilL7F4t5xVx5N = {(byte) 83, (byte) 148, (byte) 52, (byte) 127, (byte) 142, (byte) 134, (byte) 195, (byte) 42, (byte) 160, (byte) 226, (byte) 231, (byte) 162, (byte) 239, (byte) 245, (byte) 95, (byte) 185, (byte) 245, (byte) 243, (byte) 53, (byte) 137, (byte) 212, (byte) 51, (byte) 182, (byte) 226, (byte) 108, (byte) 117, (byte) 127, (byte) 253, (byte) 246, (byte) 217, (byte) 32, (byte) 131};
    private static final byte[] eNq1Sk7P37JyLWy = {(byte) 10, (byte) 85, (byte) 74, (byte) 137, (byte) 18, (byte) 195, (byte) 51, (byte) 178, (byte) 2, (byte) 26, (byte) 183, (byte) 94, (byte) 75, (byte) 243, (byte) 199, (byte) 204, (byte) 53, (byte) 212, (byte) 107, (byte) 168, (byte) 154, (byte) 149, (byte) 214, (byte) 138, (byte) 248, (byte) 11, (byte) 87, (byte) 122, (byte) 33, (byte) 209, (byte) 43, (byte) 188};
    private static final byte[] nY21YpukKib7cPLNJFEw3v = {(byte) 184, (byte) 36, (byte) 59, (byte) 60, (byte) 167, (byte) 226, (byte) 34, (byte) 204, (byte) 98, (byte) 101, (byte) 236, (byte) 72, (byte) 27, (byte) 204, (byte) 249, (byte) 121};

    ZRp1tak21UvNaOVCtFx(UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfH) {
        this.v8qP8fE86HMhvNuYPFjqY = usEbiuprSHpNw3qjITfH;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.iZTqZaRK5UGoe0Z();
        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().info(V4kNcKhYZb3A50());
        try {
            if (this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q().size() > 0) {
                if (this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q().size() <= iIZTqZaRK5UGoe0Z && this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q().size() > 0) {
                    iIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q().size();
                }
                if (iIZTqZaRK5UGoe0Z > 0) {
                    Iterator<ClanData> it = Iterables.limit(this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q().values(), iIZTqZaRK5UGoe0Z).iterator();
                    it.forEachRemaining(clanData -> {
                        if (this.v8qP8fE86HMhvNuYPFjqY.Un3NRLL6aWivTcbodkcK()) {
                            ((List<UUID>) new ArrayList<UUID>(clanData.getMembers()).stream().filter(uuid -> {
                                return !uuid.equals(clanData.getLeader());
                            }).collect(Collectors.toList())).iterator().forEachRemaining(uuid2 -> {
                                this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getPlayerManager().o1VU1x4DAlrEtGKZ3jAdhE(uuid2);
                            });
                        }
                        if (this.v8qP8fE86HMhvNuYPFjqY.p31abtwfBag2jhMH6K()) {
                            clanData.setBank(Double.valueOf(0.0d));
                        }
                        if (this.v8qP8fE86HMhvNuYPFjqY.Nz8xKv4RePC2a0f0iuYU()) {
                            clanData.getQuest().setPoints(0);
                            clanData.setLevel(0);
                            clanData.setMaxlevel(0);
                        }
                        if (this.v8qP8fE86HMhvNuYPFjqY.o1VU1x4DAlrEtGKZ3jAdhE()) {
                            clanData.setHome(null);
                        }
                        if (this.v8qP8fE86HMhvNuYPFjqY.lGGwXL678c4Kv7skJb5NiE()) {
                            clanData.getStats().setDeaths(0);
                            clanData.getStats().setKills(0);
                            clanData.getStats().setMemberJoined(0);
                            clanData.getStats().setMemberKicked(0);
                            clanData.getStats().setMemberLeft(0);
                            clanData.getStats().setSouls(0);
                            clanData.getStats().setTagChanged(0);
                            clanData.getStats().setWarLose(0);
                            clanData.getStats().setWarWin(0);
                        }
                        Optional<RivalAllyModuleAPI> optionalV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY();
                        if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                            if (this.v8qP8fE86HMhvNuYPFjqY.Fc3p9FhCjSD1k5Ra4()) {
                                clanData.getRivalAlly().getAlly().iterator().forEachRemaining(uuid3 -> {
                                    ((RivalAllyModuleAPI) optionalV8qP8fE86HMhvNuYPFjqY.get()).allyRemove(clanData.getId(), uuid3);
                                });
                            }
                            if (this.v8qP8fE86HMhvNuYPFjqY.vVo2VUvxrriklPdRxI()) {
                                clanData.getRivalAlly().getRival().iterator().forEachRemaining(uuid4 -> {
                                    ((RivalAllyModuleAPI) optionalV8qP8fE86HMhvNuYPFjqY.get()).rivalRemove(clanData.getId(), uuid4);
                                });
                            }
                        }
                        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanData);
                        it.remove();
                        this.jBUuLP0sWwaPyPOmogdX7l++;
                        this.iZTqZaRK5UGoe0Z++;
                    });
                }
            }
        } catch (Exception e) {
            this.ZwrsrwOCXRUscW6Q++;
            this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().warning(Gg9wghGxixJI5g());
            e.printStackTrace();
        }
        if (this.jBUuLP0sWwaPyPOmogdX7l == 0) {
            this.v8qP8fE86HMhvNuYPFjqY.IO1OGSMpoP1ZjOsbXi3a();
            return;
        }
        this.v8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l(this.v8qP8fE86HMhvNuYPFjqY.xtOheRiObl4QeAl() + this.ZwrsrwOCXRUscW6Q);
        this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q(this.v8qP8fE86HMhvNuYPFjqY.zJnaNCVQSgEShq() + this.jBUuLP0sWwaPyPOmogdX7l);
        this.v8qP8fE86HMhvNuYPFjqY.iZTqZaRK5UGoe0Z(this.v8qP8fE86HMhvNuYPFjqY.CDW4Fj1iwdIXEOqWjiJSR() + this.iZTqZaRK5UGoe0Z);
        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().info(aDJVfMtylvQN5VbPiAoHVJ());
        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Resume =  Bank: " + this.v8qP8fE86HMhvNuYPFjqY.p31abtwfBag2jhMH6K() + ", KickAll: " + this.v8qP8fE86HMhvNuYPFjqY.Un3NRLL6aWivTcbodkcK() + ", Stats: " + this.v8qP8fE86HMhvNuYPFjqY.lGGwXL678c4Kv7skJb5NiE() + ", Homes: " + this.v8qP8fE86HMhvNuYPFjqY.o1VU1x4DAlrEtGKZ3jAdhE() + ", Rival: " + this.v8qP8fE86HMhvNuYPFjqY.vVo2VUvxrriklPdRxI() + ", Ally: " + this.v8qP8fE86HMhvNuYPFjqY.Fc3p9FhCjSD1k5Ra4() + ", Points: " + this.v8qP8fE86HMhvNuYPFjqY.Nz8xKv4RePC2a0f0iuYU());
        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Clans Consumer: +" + this.jBUuLP0sWwaPyPOmogdX7l + " (remain " + (this.v8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q().size() - this.jBUuLP0sWwaPyPOmogdX7l) + " clans)");
        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Affected and clean: +" + this.iZTqZaRK5UGoe0Z);
        this.v8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Elapsed time: " + String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.b4i2FbOkaKeg91LiAe6l()) + "...");
        this.jBUuLP0sWwaPyPOmogdX7l = 0;
    }

    private static String nVEoE8Z4OJoSvcTNA(byte[] bArr) {
        return "";
    }

    private static String V4kNcKhYZb3A50() {
        return "---------------------------------------------";
    }

    private static String Gg9wghGxixJI5g() {
        return "An error occurred while clean CLAN data.";
    }

    private static String aDJVfMtylvQN5VbPiAoHVJ() {
        return "Cleaning in progress...";
    }
}
