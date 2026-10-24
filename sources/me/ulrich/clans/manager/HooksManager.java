package me.ulrich.clans.manager;

import com.Zrips.CMI.CMI;
import de.myzelyam.api.vanish.VanishAPI;
import java.util.UUID;
import me.chancesd.pvpmanager.player.CombatPlayer;
import me.chancesd.pvpmanager.player.UntagReason;
import me.clip.placeholderapi.PlaceholderAPI;
import me.ulrich.clans.Clans;
import me.ulrich.clans.PlaceholderHook;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import net.skinsrestorer.api.SkinsRestorer;
import net.skinsrestorer.api.SkinsRestorerProvider;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/HooksManager.class */
public class HooksManager {
    private Clans plugin;
    private boolean combatlogx = false;
    private boolean pvpManager = false;
    private boolean newDuels = false;
    private boolean floodgate = false;
    private boolean placeholderapi = false;
    private boolean nbtAPI = false;
    private boolean skinsRestorer = false;
    private PlaceholderHook placeholderHook = null;
    private SkinsRestorer skinsRestorerAPI = null;
    private boolean supervanish = false;
    private boolean premiumvanish = false;
    private boolean cmi = false;
    private boolean essentials = false;
    private boolean essentialsChat = false;
    private boolean plugmanx = false;
    private boolean redischat = false;
    private boolean huskClaims;
    private static String emUA7ix23ZiulpnPsFkA;
    private static String kxOFXnunAro5GSGR;
    private static String XN2SoOlzlbS2aseapqXa;
    private static String oc60ikOQkFdszfWW;
    private static String NMt4EqAC1DOXBhwB;
    private static volatile String SUIUQayVZ9rqmKUo;
    private static volatile String FO8cJuj7utWrR5A;
    private static String M0QLJXzOX9iJnbfyORQzA;
    private static volatile String NX0z1b2IWQ8FRZ5Cn7sf;
    private static volatile String xDyl0hucjhy7hZkkm1;
    private static String Rtof69Q8vnzJRjp;
    private static String hagVJWhFlI2PnEV;
    private static String LTGWR3m2b7tSiDaS1R7T;
    private static volatile String KvUeglSRepDI4Q;
    private static volatile String KboY4kqeQzRC29beh;
    private static volatile String N5xZEAbn27gcnr49MUOsdC;
    private static String id9d5tHJl0jHHmsqQBRU;
    private static String pc7EkfOt2wy9Fk46Wc;
    private static String VkW46s97fXG1tPIN;
    private static volatile String YSQj445o9tMr6J;
    private static volatile String u7B9XbRNNuFxpSVkiHJqZ;
    private static volatile String dgXNZnytKzp0Q1D;
    private static volatile String HHIz1hIynQ4BXtwUzqa0x6;
    private static volatile String kQ4AwTgVFLNu0qmm;
    private static volatile String uHBXsaqBpqBgd5ECWmnv0;
    private static volatile String bWYhZxDy7WNrSQlqDB2q;
    private static String TKdPwcJJz2bZzjp9E;
    private static String VtNySMWu41akBTjFY5lI;
    private static volatile String daCEhF9IQ5PPyX7qq7XM;
    private static String KdRIyefAOXaxa8d67;
    private static String MgOeh5uUdzD3XgfrHvcGIZ;
    private static String aBpU7Ek429moxh3Rs;
    private static String elUS5Lq3YwxdChFZLjgQ4;
    private static String rJW0MxUOyinIvFNm94m;
    private static String bnmLyBTMnvgjLNJ;
    private static volatile String nv4ZvJpbIGsc3lJsmmnD;
    private static String q1J9ZXYdBWEkPn;
    private static String gp1teda5L5aJA51tU5Hn;
    private static String IGBsHlQSCjJX5jDQLEII;
    private static volatile String Ze6AWaSJpOeTLRXmrWF;
    private static volatile String EXzmW4HytKnykTF;
    private static String ynf8dw2ErNJVz9k3mirn;
    private static String kqbKIjP5diMofYE;
    private static String xvd0REwPSEdNag6T;
    private static String qVE2Iu64ZG7XPevYBEX2rC;
    private static volatile String MGdbAUL8levrzGQcFQ;
    private static volatile String C3yFE6eTVO0ng1IBMoV;
    private static String gBuYsh4SibmoyYUG;
    private static volatile String F3MmyL0vrSFCG8dlElTZ5p;
    private static String EtYJGOOS5M7D3r8H947;
    private static String CWkdjVT5FTWVbjppCRSJ81;
    private static volatile String vsSRmjvhG7J1W0rxVReogh;
    private static String gYIrKGiQ0Ep2jf;
    private static String y2JMi9YQXX9Q9pFk2Y8V1w;
    private static final byte[] AKhuPSf1FchUsC = {(byte) 90, (byte) 105, (byte) 150, (byte) 45, (byte) 60, (byte) 13, (byte) 248, (byte) 122, (byte) 115, (byte) 128, (byte) 90, (byte) 4, (byte) 78, (byte) 50, (byte) 148, (byte) 202};
    private static final byte[] iOgZKHOoyL64Ahu5mP1C = {(byte) 85, (byte) 242, (byte) 105, (byte) 141, (byte) 135, (byte) 201, (byte) 86, (byte) 188, (byte) 71, (byte) 76, (byte) 92, (byte) 122, (byte) 252, (byte) 214, (byte) 63, (byte) 4};
    private static final byte[] quXDCYJtxVbHOc = {(byte) 238, (byte) 206, (byte) 141, (byte) 200, (byte) 123, (byte) 215, (byte) 223, (byte) 218, (byte) 44, (byte) 4, (byte) 183, (byte) 219, (byte) 174, (byte) 181, (byte) 192, (byte) 18, (byte) 245, (byte) 57, (byte) 156, (byte) 230, (byte) 57, (byte) 82, (byte) 128, (byte) 61, (byte) 61, (byte) 90, (byte) 130, (byte) 25, (byte) 110, (byte) 166, (byte) 30, (byte) 0};
    private static final byte[] KmZPG2se8AxO4ar9 = {(byte) 199, (byte) 186, (byte) 234, (byte) 45, (byte) 224, (byte) 204, (byte) 79, (byte) 17, (byte) 185, (byte) 41, (byte) 190, (byte) 172, (byte) 61, (byte) 210, (byte) 91, (byte) 225, (byte) 175, (byte) 27, (byte) 95, (byte) 210, (byte) 72, (byte) 134, (byte) 58, (byte) 208, (byte) 29, (byte) 51, (byte) 52, (byte) 238, (byte) 58, (byte) 6, (byte) 111, (byte) 151, (byte) 77, (byte) 37, (byte) 176, (byte) 232, (byte) 208, (byte) 177, (byte) 172, (byte) 125, (byte) 102, (byte) 0, (byte) 78, (byte) 249, (byte) 151, (byte) 230, (byte) 244, (byte) 231};
    private static final byte[] hDDxxvMN0QMArTxFOdFc0F = {(byte) 204, (byte) 223, (byte) 163, (byte) 194, (byte) 177, (byte) 164, (byte) 11, (byte) 210, (byte) 188, (byte) 123, (byte) 103, (byte) 196, (byte) 145, (byte) 138, (byte) 123, (byte) 126};
    private static final byte[] yCyAVlbCd8JB3lorYh63lB = {(byte) 0, (byte) 191, (byte) 45, (byte) 57, (byte) 228, (byte) 212, (byte) 55, (byte) 102, (byte) 159, (byte) 69, (byte) 1, (byte) 245, (byte) 209, (byte) 192, (byte) 28, (byte) 137};
    private static final byte[] Y88p8ooYD1ghRa = {(byte) 45, (byte) 146, (byte) 125, (byte) 79, (byte) 167, (byte) 219, (byte) 109, (byte) 146, (byte) 199, (byte) 168, (byte) 175, (byte) 170, (byte) 84, (byte) 45, (byte) 154, (byte) 79};
    private static final byte[] cGK3eYSFXf0WsP0QC = {(byte) 76, (byte) 248, (byte) 201, (byte) 154, (byte) 200, (byte) 147, (byte) 130, (byte) 166, (byte) 133, (byte) 142, (byte) 220, (byte) 254, (byte) 73, (byte) 225, (byte) 229, (byte) 223, (byte) 111, (byte) 68, (byte) 67, (byte) 205, (byte) 243, (byte) 199, (byte) 83, (byte) 222, (byte) 56, (byte) 134, (byte) 146, (byte) 164, (byte) 22, (byte) 206, (byte) 165, (byte) 94};
    private static final byte[] Zxk5EATEwPz2XKHU = {(byte) 51, (byte) 239, (byte) 133, (byte) 168, (byte) 251, (byte) 21, (byte) 135, (byte) 32, (byte) 54, (byte) 219, (byte) 151, (byte) 110, (byte) 18, (byte) 63, (byte) 190, (byte) 169};
    private static final byte[] Wqqzp7cMSdI9qVcHw = {(byte) 76, (byte) 248, (byte) 201, (byte) 154, (byte) 200, (byte) 147, (byte) 130, (byte) 166, (byte) 133, (byte) 142, (byte) 220, (byte) 254, (byte) 73, (byte) 225, (byte) 229, (byte) 223, (byte) 111, (byte) 68, (byte) 67, (byte) 205, (byte) 243, (byte) 199, (byte) 83, (byte) 222, (byte) 56, (byte) 134, (byte) 146, (byte) 164, (byte) 22, (byte) 206, (byte) 165, (byte) 94};
    private static final byte[] yMvKWHebKpTHkbwX1Z4B = {(byte) 15, (byte) 201, (byte) 126, (byte) 57, (byte) 206, (byte) 106, (byte) 231, (byte) 194, (byte) 163, (byte) 11, (byte) 70, (byte) 215, (byte) 5, (byte) 208, (byte) 188, (byte) 119};
    private static final byte[] QoeBOYudgtregkfyUoO3 = {(byte) 71, (byte) 44, (byte) 119, (byte) 179, (byte) 133, (byte) 58, (byte) 197, (byte) 175, (byte) 173, (byte) 117, (byte) 188, (byte) 206, (byte) 227, (byte) 161, (byte) 151, (byte) 139, (byte) 206, (byte) 158, (byte) 75, (byte) 131, (byte) 20, (byte) 36, (byte) 151, (byte) 172, (byte) 131, (byte) 149, (byte) 188, (byte) 25, (byte) 198, (byte) 124, (byte) 154, (byte) 87};
    private static final byte[] FsKUljyTNvMv2BD = {(byte) 0, (byte) 5, (byte) 157, (byte) 253, (byte) 199, (byte) 65, (byte) 182, (byte) 73, (byte) 134, (byte) 209, (byte) 103, (byte) 198, (byte) 191, (byte) 216, (byte) 72, (byte) 205};
    private static final byte[] hMXUqw71pHdnjqeH8b9ss = {(byte) 196, (byte) 20, (byte) 109, (byte) 106, (byte) 164, (byte) 51, (byte) 206, (byte) 47, (byte) 52, (byte) 175, (byte) 161, (byte) 251, (byte) 235, (byte) 4, (byte) 170, (byte) 225, (byte) 177, (byte) 183, (byte) 90, (byte) 195, (byte) 42, (byte) 127, (byte) 100, (byte) 189, (byte) 253, (byte) 50, (byte) 190, (byte) 233, (byte) 113, (byte) 49, (byte) 55, (byte) 224};
    private static final byte[] NfsB0E5LHZ1vgt2bVm = {(byte) 188, (byte) 59, (byte) 10, (byte) 151, (byte) 183, (byte) 140, (byte) 79, (byte) 215, (byte) 153, (byte) 188, (byte) 216, (byte) 188, (byte) 92, (byte) 53, (byte) 154, (byte) 254};
    private static final byte[] LjJpxuRM1TihJ1V9fY = {(byte) 236, (byte) 110, (byte) 71, (byte) 83, (byte) 218, (byte) 61, (byte) 76, (byte) 188, (byte) 17, (byte) 171, (byte) 169, (byte) 8, (byte) 172, (byte) 139, (byte) 188, (byte) 204, (byte) 237, (byte) 40, (byte) 39, (byte) 90, (byte) 17, (byte) 92, (byte) 91, (byte) 145, (byte) 252, (byte) 22, (byte) 130, (byte) 168, (byte) 225, (byte) 248, (byte) 7, (byte) 169};
    private static final byte[] GFntoeNxhfszBHFwf = {(byte) 34, (byte) 98, (byte) 205, (byte) 79, (byte) 185, (byte) 33, (byte) 233, (byte) 251, (byte) 151, (byte) 155, (byte) 225, (byte) 203, (byte) 248, (byte) 139, (byte) 154, (byte) 87};
    private static final byte[] o913qe1NIA4kcXBm = {(byte) 160, (byte) 84, (byte) 249, (byte) 239, (byte) 203, (byte) 109, (byte) 177, (byte) 0, (byte) 182, (byte) 103, (byte) 200, (byte) 181, (byte) 197, (byte) 151, (byte) 43, (byte) 23};
    private static final byte[] PJ2u0LBSq6Gi3gqEX = {(byte) 190, (byte) 69, (byte) 142, (byte) 72, (byte) 73, (byte) 189, (byte) 122, (byte) 230, (byte) 224, (byte) 184, (byte) 66, (byte) 102, (byte) 6, (byte) 134, (byte) 54, (byte) 161};
    private static final byte[] xK1ssevgIHWHasX5Vp = {(byte) 68, (byte) 51, (byte) 63, (byte) 185, (byte) 67, (byte) 37, (byte) 140, (byte) 207, (byte) 140, (byte) 74, (byte) 98, (byte) 26, (byte) 14, (byte) 51, (byte) 58, (byte) 5, (byte) 237, (byte) 158, (byte) 133, (byte) 221, (byte) 193, (byte) 101, (byte) 165, (byte) 15, (byte) 253, (byte) 176, (byte) 107, (byte) 179, (byte) 44, (byte) 166, (byte) 108, (byte) 139, (byte) 0, (byte) 83, (byte) 173, (byte) 188, (byte) 35, (byte) 117, (byte) 102, (byte) 192, (byte) 241, (byte) 36, (byte) 99, (byte) 142, (byte) 48, (byte) 127, (byte) 178, (byte) 238};
    private static final byte[] T3DpXYFuSVh6Ffs = {(byte) 93, (byte) 157, (byte) 51, (byte) 158, (byte) 212, (byte) 62, (byte) 232, (byte) 69, (byte) 63, (byte) 175, (byte) 118, (byte) 215, (byte) 104, (byte) 248, (byte) 159, (byte) 137};
    private static final byte[] ci825xISu7pcaSl = {(byte) 104, (byte) 32, (byte) 168, (byte) 147, (byte) 135, (byte) 129, (byte) 125, (byte) 78, (byte) 105, (byte) 44, (byte) 214, (byte) 239, (byte) 55, (byte) 246, (byte) 179, (byte) 38};
    private static final byte[] bFzxMHSeEsWpCiISojO = {(byte) 161, (byte) 204, (byte) 58, (byte) 10, (byte) 39, (byte) 182, (byte) 240, (byte) 17, (byte) 91, (byte) 133, (byte) 29, (byte) 254, (byte) 42, (byte) 157, (byte) 177, (byte) 243};
    private static final byte[] SDO2A6xjGz5XUdt = {(byte) 177, (byte) 221, (byte) 59, (byte) 248, (byte) 31, (byte) 252, (byte) 76, (byte) 40, (byte) 216, (byte) 154, (byte) 246, (byte) 107, (byte) 209, (byte) 208, (byte) 243, (byte) 118, (byte) 223, (byte) 200, (byte) 221, (byte) 23, (byte) 182, (byte) 201, (byte) 15, (byte) 90, (byte) 234, (byte) 94, (byte) 1, (byte) 113, (byte) 119, (byte) 15, (byte) 73, (byte) 152};
    private static final byte[] shbZ1hhiBSW5AG0IA = {(byte) 194, (byte) 96, (byte) 19, (byte) 94, (byte) 137, (byte) 4, (byte) 191, (byte) 166, (byte) 99, (byte) 55, (byte) 46, (byte) 206, (byte) 60, (byte) 125, (byte) 9, (byte) 224, (byte) 213, (byte) 24, (byte) 36, (byte) 129, (byte) 64, (byte) 54, (byte) 1, (byte) 53, (byte) 134, (byte) 133, (byte) 207, (byte) 237, (byte) 130, (byte) 242, (byte) 227, (byte) 226};
    private static final byte[] uU4Xm4Wd5X45udmvxM = {(byte) 61, (byte) 249, (byte) 7, (byte) 12, (byte) 219, (byte) 211, (byte) 88, (byte) 95, (byte) 227, (byte) 101, (byte) 173, (byte) 17, (byte) 150, (byte) 223, (byte) 70, (byte) 84};

    public HooksManager(Clans clans) {
        this.plugin = clans;
        setupHooks();
        setupBedrockHook();
    }

    public Clans getPlugin() {
        return this.plugin;
    }

    private boolean tryHookEssChat() {
        try {
            Class.forName(kxeN0Eif7D4YyAzmT3());
            Bukkit.getPluginManager().registerEvents(new me.ulrich.clans.tjCyMSV004ze7Mc.tjCyMSV004ze7Mc.UsEbiuprSHpNw3qjITfH(), this.plugin);
            this.plugin.getLogger().info(Opwntlr5dN5oqgbu());
            return true;
        } catch (ClassNotFoundException e) {
            this.plugin.getLogger().warning(a4QS620sTI639so9());
            return false;
        }
    }

    private boolean tryHookBukkitChat() {
        Bukkit.getPluginManager().registerEvents(new me.ulrich.clans.tjCyMSV004ze7Mc.tjCyMSV004ze7Mc.Ijap9SQKkijXSxP5(), this.plugin);
        this.plugin.getLogger().info(lsO20bQRfopsfS1YcZJDnz());
        return true;
    }

    public void loadBefore() {
        this.plugin.getLogger().info(aMu5ulWNawUZzS());
        if (this.essentialsChat && this.placeholderapi) {
            this.plugin.getLogger().info(bBM5iJp87fTsQIcld8());
            if (!tryHookEssChat() && tryHookBukkitChat()) {
            }
        }
    }

    private void setupHooks() {
        this.plugin.getLogger().info(zQnODwKKfa0xyKQDwdq());
        if (Bukkit.getPluginManager().isPluginEnabled(DlXu7ZLJuIGXsFG84KwnKa())) {
            this.placeholderapi = true;
            this.plugin.getLogger().info(Kf4EJQzPPfxOJo0());
        }
        if (Bukkit.getPluginManager().isPluginEnabled(SPZdFcFaoj60XLYME()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(AouWQEflkc9CKg())) {
            this.redischat = true;
            this.plugin.getLogger().info(mGtbwZ6TiLgXcATStZZa());
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(m9mSjONPkbFGoXCxCvIw4m()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(k6Ij7DH0J5q7EigoQ())) {
                try {
                    Class.forName(PLPAYkfym2lrhGrY());
                    this.plugin.getLogger().warning(gpIdbSo53RzKcSb6v());
                } catch (Exception e) {
                }
                try {
                    Class.forName(gi96dJDZOcayoRI());
                    this.newDuels = false;
                    this.plugin.getLogger().info(Dg3gLGacXGZtF3kPH());
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
        }
        if (Bukkit.getPluginManager().isPluginEnabled(sc4m3xYvc2UBDzE14sGE4()) && this.plugin.isEntity()) {
            this.plugmanx = true;
            this.plugin.getLogger().info(efMuEFERC5zFljw());
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(isSZl5puWwsMj6Tjny()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(S8SY5KiRI6X0S6zzOx())) {
                this.supervanish = true;
                this.plugin.getLogger().info(atz1QihD3WewIpLZeKkx());
            }
        } catch (Exception e4) {
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(CCp95SKrDaV8eU1ZPxWO()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(sn2Cr6RC4nb0JORUm5xOTu())) {
                this.premiumvanish = true;
                this.plugin.getLogger().info(a0Sk8w7QQQ9aX5gHn());
            }
        } catch (Exception e5) {
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(JwA1knwzw1Fkhp7()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(FNKv6fsh3LLDuajJ1())) {
                this.cmi = true;
                this.plugin.getLogger().info(qwDskGxDgz71YFVSg());
            }
        } catch (Exception e6) {
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(jpGyzCzRXmsphIQ0yCZ()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(KqDzzGMHVfTcD6Lr7Hb())) {
                this.essentials = true;
                this.plugin.getLogger().info(dnTPUNFqML5jsdDy0U());
            }
        } catch (Exception e7) {
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(ijwayVlLQPAUqG5pL()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(aLDl6hqavWFkB0vjxnm5())) {
                this.essentialsChat = true;
                this.plugin.getLogger().info(qaloYM41b8Dm6wk9ieQo3p());
            }
        } catch (Exception e8) {
        }
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(IkBxlscobDgNiMQ8()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(g57ILtjm65dbXAg())) {
                this.nbtAPI = true;
                this.plugin.getLogger().info(qs9TwcnwXX8mlngn8e7wL());
            }
        } catch (Exception e9) {
        }
        if (Bukkit.getPluginManager().isPluginEnabled(rir9IRKN7oOrGCzVX()) && this.plugin.getFiles().MoSLgFbw3mkSoqkObMHJ4().getBoolean(nJtCkRIzGRv8MuMV())) {
            if (Bukkit.getPluginManager().getPlugin(UYzKAu9PSXwC9sXXNn4()) != null) {
                this.pvpManager = true;
                this.plugin.getLogger().info(oikQTHwBh0fO1eWAQ());
            } else {
                this.plugin.getLogger().warning(zhIfr6pH2p9rOeQekKKzU());
            }
        }
        if (Bukkit.getPluginManager().isPluginEnabled(b72G6HK2efLUflpVlV6i())) {
            try {
                if (this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean(zamweDDTdMW6Q31coleK())) {
                    try {
                        try {
                            this.skinsRestorer = true;
                            this.skinsRestorerAPI = SkinsRestorerProvider.get();
                            this.plugin.getLogger().info(E4ENvKRPN2ZGTqcb());
                        } catch (NoClassDefFoundError e10) {
                            this.plugin.getLogger().warning(tDQRqD9zz5PGId5dhJ1());
                        }
                    } catch (Exception e11) {
                        this.plugin.getLogger().warning(oPvdAuWgGIfyPNno1S0());
                    }
                }
            } catch (NoClassDefFoundError e12) {
                this.plugin.getLogger().warning(oup7Dmv9SyjyI8());
            }
        }
        if (isPlaceholderapi()) {
            PlaceholderHook placeholderHook = new PlaceholderHook(this.plugin);
            this.placeholderHook = placeholderHook;
            placeholderHook.register();
        }
    }

    private void setupBedrockHook() {
        this.plugin.getLogger().info(TODpW8n5lthvD19T());
        try {
            if (Bukkit.getPluginManager().isPluginEnabled(FHL31nNXAbf5sCy2())) {
                this.floodgate = true;
                this.plugin.getLogger().info(TxhzOUJwVOxAKxPB());
            } else {
                this.plugin.getLogger().info(tPlSzYn70c4QJxkg3aSg());
            }
        } catch (Exception e) {
        }
    }

    public String parsePapi(Player player, String str) {
        try {
            if (isPlaceholderapi()) {
                str = PlaceholderAPI.setPlaceholders(player, str);
            }
        } catch (Exception e) {
        }
        return str;
    }

    public String parsePapi(UUID uuid, String str) {
        try {
            if (isPlaceholderapi() && uuid != null) {
                OfflinePlayer player = Bukkit.getPlayer(uuid);
                str = PlaceholderAPI.setPlaceholders(player != null ? player : Bukkit.getOfflinePlayer(uuid), str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getPlayerName(Player player) {
        FloodgateApi floodgateApi;
        try {
            if (isFloodgate() && (floodgateApi = FloodgateApi.getInstance()) != null) {
                return floodgateApi.isFloodgatePlayer(player.getUniqueId()) ? floodgateApi.getPlayer(player.getUniqueId()).getUsername() : player.getName();
            }
        } catch (Exception e) {
        }
        return player.getName();
    }

    public boolean isInDuel(Player player) {
        try {
            if (isNewDuels()) {
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Player getEnemyCombat(Player player) {
        try {
            if (isCombatlogx()) {
            }
        } catch (Exception e) {
        }
        try {
            if (!isPvpManager()) {
                return null;
            }
            CombatPlayer combatPlayer = CombatPlayer.get(player);
            if (!combatPlayer.isInCombat()) {
                return null;
            }
            try {
                return Bukkit.getPlayer(combatPlayer.getEnemy().getUUID());
            } catch (Exception e2) {
                return null;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    public boolean removeCombat(Player player) {
        try {
            if (isCombatlogx()) {
            }
        } catch (Exception e) {
        }
        try {
            if (isPvpManager()) {
                CombatPlayer combatPlayer = CombatPlayer.get(player);
                if (combatPlayer.isInCombat()) {
                    combatPlayer.untag(UntagReason.PLUGIN_API);
                }
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public boolean isInCombat(Player player) {
        try {
            if (isCombatlogx()) {
            }
        } catch (Exception e) {
        }
        try {
            if (isPvpManager()) {
                return CombatPlayer.get(player).isInCombat();
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public boolean isInvisible(Player player) {
        return isInvisible(player.getUniqueId());
    }

    public boolean isInvisible(UUID uuid) {
        try {
            if (isSupervanish() || isPremiumvanish()) {
                return VanishAPI.isInvisibleOffline(uuid);
            }
        } catch (Exception | NoClassDefFoundError e) {
        }
        try {
            if (isCmi()) {
                return CMI.getInstance().getVanishManager().getAllVanished().contains(uuid);
            }
        } catch (Exception | NoClassDefFoundError e2) {
        }
        try {
            if (isEssentials()) {
                return ((com.earth2me.essentials.Essentials) Bukkit.getPluginManager().getPlugin(O85yAmIGZHzXhXfJb4fuGb())).getUser(uuid).isVanished();
            }
            return false;
        } catch (Exception | NoClassDefFoundError e3) {
            return false;
        }
    }

    public boolean isCombatlogx() {
        return this.combatlogx;
    }

    public boolean isPvpManager() {
        return this.pvpManager;
    }

    public boolean isFloodgate() {
        return this.floodgate;
    }

    public boolean isPlaceholderapi() {
        return this.placeholderapi;
    }

    public boolean isSkinsRestorer() {
        return this.skinsRestorer;
    }

    public boolean isNbtAPI() {
        return this.nbtAPI;
    }

    public PlaceholderHook getPlaceholderHook() {
        return this.placeholderHook;
    }

    public SkinsRestorer getSkinsRestorerAPI() {
        return this.skinsRestorerAPI;
    }

    public boolean isSupervanish() {
        return this.supervanish;
    }

    public boolean isCmi() {
        return this.cmi;
    }

    public boolean isEssentials() {
        return this.essentials;
    }

    public boolean isPremiumvanish() {
        return this.premiumvanish;
    }

    public boolean isNewDuels() {
        return this.newDuels;
    }

    public boolean isPlugmanx() {
        return this.plugmanx;
    }

    public boolean isRedischat() {
        return this.redischat;
    }

    public boolean isHuskClaims() {
        return this.huskClaims;
    }

    public boolean isEssentialsChat() {
        return this.essentialsChat;
    }

    private static String kxeN0Eif7D4YyAzmT3() {
        return "net.essentialsx.api.v2.events.chat.GlobalChatEvent";
    }

    private static String a4QS620sTI639so9() {
        return " ! Unsupported version.";
    }

    private static String Opwntlr5dN5oqgbu() {
        return " - Hooked EssentialsX Chat.";
    }

    private static String lsO20bQRfopsfS1YcZJDnz() {
        return " - Hooked legacy Bukkit events.";
    }

    private static String aMu5ulWNawUZzS() {
        return "Additional hooks...";
    }

    private static String bBM5iJp87fTsQIcld8() {
        return "...Trying to connect to essentials";
    }

    private static String zQnODwKKfa0xyKQDwdq() {
        return "Setup hooks...";
    }

    private static String DlXu7ZLJuIGXsFG84KwnKa() {
        return "PlaceholderAPI";
    }

    private static String Kf4EJQzPPfxOJo0() {
        return " - PlaceholderAPI";
    }

    private static String SPZdFcFaoj60XLYME() {
        return "RedisChat";
    }

    private static String AouWQEflkc9CKg() {
        return "Config.hooks.redischat";
    }

    private static String mGtbwZ6TiLgXcATStZZa() {
        return " - RedisChat";
    }

    private static String m9mSjONPkbFGoXCxCvIw4m() {
        return "Duels";
    }

    private static String k6Ij7DH0J5q7EigoQ() {
        return "Config.hooks.duels";
    }

    private static String PLPAYkfym2lrhGrY() {
        return "me.realized.duels.api.Duels";
    }

    private static String gpIdbSo53RzKcSb6v() {
        return " - ! Use: Duels Optimized";
    }

    private static String gi96dJDZOcayoRI() {
        return "com.meteordevelopments.duels.api.Duels";
    }

    private static String Dg3gLGacXGZtF3kPH() {
        return " - ! Disabled: Hook disabled";
    }

    private static String sc4m3xYvc2UBDzE14sGE4() {
        return "PlugManX";
    }

    private static String efMuEFERC5zFljw() {
        return " - PlugManX";
    }

    private static String isSZl5puWwsMj6Tjny() {
        return "SuperVanish";
    }

    private static String S8SY5KiRI6X0S6zzOx() {
        return "Config.hooks.supervanish";
    }

    private static String atz1QihD3WewIpLZeKkx() {
        return " - SuperVanish";
    }

    private static String CCp95SKrDaV8eU1ZPxWO() {
        return "PremiumVanish";
    }

    private static String sn2Cr6RC4nb0JORUm5xOTu() {
        return "Config.hooks.premiumvanish";
    }

    private static String a0Sk8w7QQQ9aX5gHn() {
        return " - PremiumVanish";
    }

    private static String JwA1knwzw1Fkhp7() {
        return "CMI";
    }

    private static String FNKv6fsh3LLDuajJ1() {
        return "Config.hooks.cmi";
    }

    private static String qwDskGxDgz71YFVSg() {
        return " - CMI (Vanish)";
    }

    private static String jpGyzCzRXmsphIQ0yCZ() {
        return "Essentials";
    }

    private static String KqDzzGMHVfTcD6Lr7Hb() {
        return "Config.hooks.essentials";
    }

    private static String dnTPUNFqML5jsdDy0U() {
        return " - Essentials (Vanish)";
    }

    private static String ijwayVlLQPAUqG5pL() {
        return "EssentialsChat";
    }

    private static String aLDl6hqavWFkB0vjxnm5() {
        return "Config.hooks.essentials";
    }

    private static String qaloYM41b8Dm6wk9ieQo3p() {
        return " - EssentialsChat";
    }

    private static String IkBxlscobDgNiMQ8() {
        return "NBTAPI";
    }

    private static String g57ILtjm65dbXAg() {
        return "Config.hooks.nbtapi";
    }

    private static String qs9TwcnwXX8mlngn8e7wL() {
        return " - NBTAPI";
    }

    private static String rir9IRKN7oOrGCzVX() {
        return "PvPManager";
    }

    private static String nJtCkRIzGRv8MuMV() {
        return "Config.hooks.pvpmanager";
    }

    private static String UYzKAu9PSXwC9sXXNn4() {
        return "PvPManager";
    }

    private static String oikQTHwBh0fO1eWAQ() {
        return " - PvPManager";
    }

    private static String zhIfr6pH2p9rOeQekKKzU() {
        return " - PvPManager - Error";
    }

    private static String b72G6HK2efLUflpVlV6i() {
        return "SkinsRestorer";
    }

    private static String zamweDDTdMW6Q31coleK() {
        return "Config.player.skin.hooks.skinsrestorer.enabled";
    }

    private static String E4ENvKRPN2ZGTqcb() {
        return " - SkinsRestorer";
    }

    private static String tDQRqD9zz5PGId5dhJ1() {
        return " - !SkinsRestorer (API error)";
    }

    private static String oPvdAuWgGIfyPNno1S0() {
        return " - !SkinsRestorer (Initialization error)";
    }

    private static String oup7Dmv9SyjyI8() {
        return " - !SkinsRestorer (API error)";
    }

    private static String TODpW8n5lthvD19T() {
        return "Setup bedrock hook...";
    }

    private static String FHL31nNXAbf5sCy2() {
        return "floodgate";
    }

    private static String TxhzOUJwVOxAKxPB() {
        return " - floodgate";
    }

    private static String tPlSzYn70c4QJxkg3aSg() {
        return " - Not found.";
    }

    private static String O85yAmIGZHzXhXfJb4fuGb() {
        return "Essentials";
    }
}
