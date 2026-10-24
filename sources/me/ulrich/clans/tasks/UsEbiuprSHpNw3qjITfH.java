package me.ulrich.clans.tasks;

import com.google.common.base.Stopwatch;
import java.util.HashMap;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private MyScheduledTask ZwrsrwOCXRUscW6Q;
    private final Stopwatch b4i2FbOkaKeg91LiAe6l;
    private final int p31abtwfBag2jhMH6K;
    private final boolean Un3NRLL6aWivTcbodkcK;
    private final boolean lGGwXL678c4Kv7skJb5NiE;
    private final boolean o1VU1x4DAlrEtGKZ3jAdhE;
    private final boolean vVo2VUvxrriklPdRxI;
    private final boolean Fc3p9FhCjSD1k5Ra4;
    private final boolean Nz8xKv4RePC2a0f0iuYU;
    private final boolean HX3ZfRb1nSpNq57s7x5ui;
    private static volatile String S7WaCwkxxMecZyr;
    private static volatile String i5dQnFW4agqfvV;
    private static final byte[] IQ1Tp0vhBFejFonn6 = {(byte) 249, (byte) 159, (byte) 49, (byte) 128, (byte) 181, (byte) 94, (byte) 11, (byte) 105, (byte) 77, (byte) 65, (byte) 211, (byte) 238, (byte) 73, (byte) 58, (byte) 193, (byte) 131, (byte) 48, (byte) 241, (byte) 249, (byte) 61, (byte) 65, (byte) 142, (byte) 102, (byte) 114, (byte) 22, (byte) 115, (byte) 8, (byte) 71, (byte) 156, (byte) 207, (byte) 113, (byte) 113, (byte) 48, (byte) 152, (byte) 204, (byte) 53, (byte) 159, (byte) 143, (byte) 99, (byte) 235, (byte) 96, (byte) 30, (byte) 239, (byte) 68, (byte) 36, (byte) 54, (byte) 101, (byte) 54};
    private static final byte[] I3gndZhO6RtCPbOoWCvlt = {(byte) 122, (byte) 4, (byte) 161, (byte) 55, (byte) 26, (byte) 24, (byte) 92, (byte) 172, (byte) 143, (byte) 189, (byte) 186, (byte) 56, (byte) 217, (byte) 211, (byte) 226, (byte) 104, (byte) 143, (byte) 84, (byte) 106, (byte) 251, (byte) 137, (byte) 80, (byte) 33, (byte) 24, (byte) 181, (byte) 195, (byte) 62, (byte) 11, (byte) 36, (byte) 141, (byte) 169, (byte) 212};
    private static final byte[] ipaGQMRblEKBZ8sBr = {(byte) 92, (byte) 145, (byte) 234, (byte) 227, (byte) 98, (byte) 96, (byte) 140, (byte) 216, (byte) 58, (byte) 71, (byte) 192, (byte) 100, (byte) 158, (byte) 13, (byte) 91, (byte) 153};
    private int jBUuLP0sWwaPyPOmogdX7l = -1;
    private HashMap<UUID, ClanData> iZTqZaRK5UGoe0Z = new HashMap<>();
    private int xtOheRiObl4QeAl = 0;
    private int zJnaNCVQSgEShq = 0;
    private int CDW4Fj1iwdIXEOqWjiJSR = 0;

    public UsEbiuprSHpNw3qjITfH(Clans clans, Stopwatch stopwatch, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.p31abtwfBag2jhMH6K = i;
        this.b4i2FbOkaKeg91LiAe6l = stopwatch;
        this.Un3NRLL6aWivTcbodkcK = z;
        this.lGGwXL678c4Kv7skJb5NiE = z2;
        this.o1VU1x4DAlrEtGKZ3jAdhE = z3;
        this.vVo2VUvxrriklPdRxI = z4;
        this.Fc3p9FhCjSD1k5Ra4 = z5;
        this.Nz8xKv4RePC2a0f0iuYU = z6;
        this.HX3ZfRb1nSpNq57s7x5ui = z7;
        this.iZTqZaRK5UGoe0Z.putAll(clans.getClanManager().CDW4Fj1iwdIXEOqWjiJSR());
        HX3ZfRb1nSpNq57s7x5ui();
    }

    private void HX3ZfRb1nSpNq57s7x5ui() {
        this.ZwrsrwOCXRUscW6Q = v8qP8fE86HMhvNuYPFjqY().getTaskManager().xtOheRiObl4QeAl().runTaskTimer(new ZRp1tak21UvNaOVCtFx(this), 20L, 40L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    void IO1OGSMpoP1ZjOsbXi3a() {
        b4i2FbOkaKeg91LiAe6l().stop();
        if (this.ZwrsrwOCXRUscW6Q != null) {
            this.ZwrsrwOCXRUscW6Q.cancel();
            this.ZwrsrwOCXRUscW6Q = null;
        }
        v8qP8fE86HMhvNuYPFjqY().getLogger().info(vN1e2IWhmUFCfQwstK());
        v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Total clean clans: " + zJnaNCVQSgEShq());
        v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Total errors: " + xtOheRiObl4QeAl());
        v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Total affected and fixed: +" + CDW4Fj1iwdIXEOqWjiJSR());
        v8qP8fE86HMhvNuYPFjqY().getLogger().info(" - Total Elapsed time: " + String.valueOf(b4i2FbOkaKeg91LiAe6l()));
        v8qP8fE86HMhvNuYPFjqY().getLogger().info(OlRiL5kbppjLNZRos8s1m());
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public int jBUuLP0sWwaPyPOmogdX7l() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public void v8qP8fE86HMhvNuYPFjqY(int i) {
        this.jBUuLP0sWwaPyPOmogdX7l = i;
    }

    public HashMap<UUID, ClanData> ZwrsrwOCXRUscW6Q() {
        return this.iZTqZaRK5UGoe0Z;
    }

    public void v8qP8fE86HMhvNuYPFjqY(HashMap<UUID, ClanData> map) {
        this.iZTqZaRK5UGoe0Z = map;
    }

    public int iZTqZaRK5UGoe0Z() {
        return this.p31abtwfBag2jhMH6K;
    }

    public int xtOheRiObl4QeAl() {
        return this.xtOheRiObl4QeAl;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(int i) {
        this.xtOheRiObl4QeAl = i;
    }

    public int zJnaNCVQSgEShq() {
        return this.zJnaNCVQSgEShq;
    }

    public void ZwrsrwOCXRUscW6Q(int i) {
        this.zJnaNCVQSgEShq = i;
    }

    public int CDW4Fj1iwdIXEOqWjiJSR() {
        return this.CDW4Fj1iwdIXEOqWjiJSR;
    }

    public void iZTqZaRK5UGoe0Z(int i) {
        this.CDW4Fj1iwdIXEOqWjiJSR = i;
    }

    public Stopwatch b4i2FbOkaKeg91LiAe6l() {
        return this.b4i2FbOkaKeg91LiAe6l;
    }

    public boolean p31abtwfBag2jhMH6K() {
        return this.Un3NRLL6aWivTcbodkcK;
    }

    public boolean Un3NRLL6aWivTcbodkcK() {
        return this.lGGwXL678c4Kv7skJb5NiE;
    }

    public boolean lGGwXL678c4Kv7skJb5NiE() {
        return this.o1VU1x4DAlrEtGKZ3jAdhE;
    }

    public boolean o1VU1x4DAlrEtGKZ3jAdhE() {
        return this.vVo2VUvxrriklPdRxI;
    }

    public boolean vVo2VUvxrriklPdRxI() {
        return this.Fc3p9FhCjSD1k5Ra4;
    }

    public boolean Fc3p9FhCjSD1k5Ra4() {
        return this.Nz8xKv4RePC2a0f0iuYU;
    }

    public boolean Nz8xKv4RePC2a0f0iuYU() {
        return this.HX3ZfRb1nSpNq57s7x5ui;
    }

    private static String vN1e2IWhmUFCfQwstK() {
        return "Cleaning is over, see final results.";
    }

    private static String OlRiL5kbppjLNZRos8s1m() {
        return "---------------------------------------------";
    }
}
