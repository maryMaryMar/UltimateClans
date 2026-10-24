package me.ulrich.clans.manager;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.interfaces.AnvilModuleAPI;
import me.ulrich.clans.interfaces.BankAddonAPI;
import me.ulrich.clans.interfaces.BannerModuleAPI;
import me.ulrich.clans.interfaces.ChestAddonAPI;
import me.ulrich.clans.interfaces.ClaimImplement;
import me.ulrich.clans.interfaces.DiscordModuleAPI;
import me.ulrich.clans.interfaces.EventImplement;
import me.ulrich.clans.interfaces.FarmCoinsAddonAPI;
import me.ulrich.clans.interfaces.GladiatorAddonAPI;
import me.ulrich.clans.interfaces.HologramImplement;
import me.ulrich.clans.interfaces.HomeModuleAPI;
import me.ulrich.clans.interfaces.ItemParseImplement;
import me.ulrich.clans.interfaces.LandAddonAPI;
import me.ulrich.clans.interfaces.LeaderboardAddonAPI;
import me.ulrich.clans.interfaces.LeagueAddonAPI;
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import me.ulrich.clans.interfaces.LoggerModuleAPI;
import me.ulrich.clans.interfaces.MailModuleAPI;
import me.ulrich.clans.interfaces.MapImplement;
import me.ulrich.clans.interfaces.MoneyImplement;
import me.ulrich.clans.interfaces.MultiserverModuleAPI;
import me.ulrich.clans.interfaces.NexusAddonAPI;
import me.ulrich.clans.interfaces.QuestAddonAPI;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;
import me.ulrich.clans.interfaces.ScoreboardImplement;
import me.ulrich.clans.interfaces.WarAddonAPI;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/TT1XiyOqwowi4.class */
public class TT1XiyOqwowi4 {
    private MailModuleAPI v8qP8fE86HMhvNuYPFjqY;
    private BannerModuleAPI jBUuLP0sWwaPyPOmogdX7l;
    private RivalAllyModuleAPI ZwrsrwOCXRUscW6Q;
    private LoggerModuleAPI iZTqZaRK5UGoe0Z;
    private LevelupModuleAPI xtOheRiObl4QeAl;
    private HomeModuleAPI zJnaNCVQSgEShq;
    private DiscordModuleAPI CDW4Fj1iwdIXEOqWjiJSR;
    private Optional<String> b4i2FbOkaKeg91LiAe6l;
    private RewardsModuleAPI p31abtwfBag2jhMH6K;
    private MultiserverModuleAPI Un3NRLL6aWivTcbodkcK;
    private AnvilModuleAPI o1VU1x4DAlrEtGKZ3jAdhE;
    private BankAddonAPI vVo2VUvxrriklPdRxI;
    private ChestAddonAPI Fc3p9FhCjSD1k5Ra4;
    private FarmCoinsAddonAPI Nz8xKv4RePC2a0f0iuYU;
    private LandAddonAPI HX3ZfRb1nSpNq57s7x5ui;
    private LeaderboardAddonAPI IO1OGSMpoP1ZjOsbXi3a;
    private LeagueAddonAPI VkPRYe34Awk6AdSxoUC;
    private NexusAddonAPI QXoNfOxIPaPrSlQMNR;
    private QuestAddonAPI V3DAV3orG0so43Del8NdO;
    private WarAddonAPI Y9J1Kd6E1T8FcF;
    private GladiatorAddonAPI MoSLgFbw3mkSoqkObMHJ4;
    private static volatile String mybsgqSrPtVfCjIgLqWo;
    private static volatile String QgoeGOHI1q915nKI71Fzr;
    private static volatile String b4w3IlsQMKepAMwn;
    private static volatile String Hwj7s4ZJr13ALfnqxfQ;
    private static volatile String bjGdC6aDrMcPuB4;
    private static volatile String RsFSYsMljY8TJqx5ymA;
    private static String VGflXA0vtYJzONxDTv;
    private static volatile String GstSq5Ma8PYnpg;
    private static volatile String tkaM6oP1zPhM60y2P;
    private static String KW0NuCNEBSgcWR1H6;
    private static String f80zEcOWzQqakc;
    private static String u5UJH8f7sg36TO7qK1l;
    private static volatile String CwdzUVkxPx5d8A;
    private static String BT1KihF5iS4MwMv24Nv;
    private static String dvZvnbhod8xO9uKL;
    private static String xag2KCR2uOCNHPNgL5;
    private static String sB5CRapkIuOMSGjgH;
    private static volatile String ZX7l9LzLSpxgxhVPoNBf;
    private static volatile String qNkaEarslQybXnB83zO;
    private static String CNsY0G2Ft4EDdPhuPwt;
    private static String JFyQG33ttZh9IEOsGGBgQ;
    private static volatile String FMmMHluRenOWGUMkS4Y4;
    private static String bPOenDoGhLeh143Wj6Et;
    private static String ogrTKsQEuEX1TkwlJTGl;
    private static String qBEH78Holfv9EZ9U;
    private static volatile String J2DOZAzOKG1mfLLyC8;
    private static String TBu30guFdb2o98xG;
    private static String KKWMRVSCuqqCvEJ8wH3EUJ;
    private static volatile String YyZibP7jzcxj0dxK8;
    private static String uc3zVJMOV9wsCBCo;
    private static String ktwsXA10Jq1BJUWs1SOQ;
    private static String bAnbh4KT05aHd9WUJH;
    private static volatile String ZUJCxCKMecjzd28S0XUGbX;
    private static volatile String fM07cdLR2S1eSCou5;
    private static String enlmm2eOVUGNoGDa0Hjz28;
    private static volatile String BQDWDiiLNtjCcF;
    private static String vQQj08NrrUMm2MXZEeH7;
    private static String LiwWBD5iwWITyJ3YXrAX7;
    private static String EfZSpicYS1cSTmoeOVKWt;
    private static volatile String x06LylFZV3LVGX86x;
    private static volatile String V5V9Xk4KzZKtr8;
    private static String WARkyxtpAa3D3mF;
    private static volatile String brCWxeQ9jDfeg2fwCzD;
    private static volatile String lohspz6QyoFoG7y9jOv;
    private static volatile String Sg4bOEKem42tLcbZ9X3iIQ;
    private static volatile String WaOmy3oz1Nk8aMd2Pu;
    private static volatile String L23g1HQNdz20OzQzxVC;
    private static String Zfc7ThTelcGoB1g1;
    private static final byte[] VzquJ3PqUHBhVPRMRmW = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 27, (byte) 195, (byte) 98, (byte) 166, (byte) 129, (byte) 85, (byte) 178, (byte) 245, (byte) 62, (byte) 40, (byte) 211, (byte) 92, (byte) 236, (byte) 205, (byte) 100, (byte) 206};
    private static final byte[] AHfv1QqT5LRhzJbQ3RD7 = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 15, (byte) 106, (byte) 202, (byte) 84, (byte) 138, (byte) 52, (byte) 23, (byte) 70, (byte) 200, (byte) 31, (byte) 139, (byte) 86, (byte) 0, (byte) 87, (byte) 208, (byte) 88};
    private static final byte[] yWg2kBdz4i6AXn = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 17, (byte) 216, (byte) 110, (byte) 159, (byte) 150, (byte) 82, (byte) 146, (byte) 121, (byte) 220, (byte) 2, (byte) 25, (byte) 115, (byte) 51, (byte) 20, (byte) 226, (byte) 60};
    private static final byte[] nfxGs3dcUiMpJXrl = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 150, (byte) 243, (byte) 32, (byte) 69, (byte) 62, (byte) 26, (byte) 0, (byte) 17, (byte) 64, (byte) 24, (byte) 197, (byte) 64, (byte) 38, (byte) 218, (byte) 203, (byte) 171};
    private static final byte[] KASDSKF4Ban66CM1t8Xl = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 215, (byte) 57, (byte) 190, (byte) 169, (byte) 49, (byte) 236, (byte) 214, (byte) 129, (byte) 81, (byte) 95, (byte) 163, (byte) 254, (byte) 108, (byte) 194, (byte) 244, (byte) 177};
    private static final byte[] JFTfSmOtoTq0Do = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 164, (byte) 217, (byte) 39, (byte) 49, (byte) 127, (byte) 135, (byte) 24, (byte) 147, (byte) 103, (byte) 28, (byte) 43, (byte) 97, (byte) 95, (byte) 42, (byte) 228, (byte) 70};
    private static final byte[] UBaNcO2QN6C6mn3z = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 141, (byte) 202, (byte) 101, (byte) 158, (byte) 249, (byte) 133, (byte) 188, (byte) 90, (byte) 143, (byte) 167, (byte) 34, (byte) 135, (byte) 254, (byte) 123, (byte) 197, (byte) 225};
    private static final byte[] HE1rYYO0WK2JhPU = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 30, (byte) 116, (byte) 219, (byte) 214, (byte) 190, (byte) 76, (byte) 56, (byte) 170, (byte) 154, (byte) 26, (byte) 185, (byte) 185, (byte) 165, (byte) 142, (byte) 65, (byte) 39, (byte) 179, (byte) 54, (byte) 142, (byte) 138, (byte) 222, (byte) 191, (byte) 197, (byte) 207, (byte) 229, (byte) 153, (byte) 112, (byte) 249, (byte) 238, (byte) 70, (byte) 239, (byte) 117};
    private static final byte[] ZciPcGq3yrrYRzPFS5HBCk = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 127, (byte) 29, (byte) 45, (byte) 218, (byte) 168, (byte) 105, (byte) 27, (byte) 39, (byte) 77, (byte) 147, (byte) 142, (byte) 171, (byte) 228, (byte) 244, (byte) 160, (byte) 124};
    private static final byte[] AKsCuEv04DHJKsna5oF = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 228, (byte) 191, (byte) 15, (byte) 191, (byte) 253, (byte) 120, (byte) 22, (byte) 40, (byte) 205, (byte) 181, (byte) 40, (byte) 6, (byte) 176, (byte) 33, (byte) 122, (byte) 65};
    private static final byte[] o90JHjLof2WRZwimmCvt = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 138, (byte) 33, (byte) 46, (byte) 195, (byte) 32, (byte) 116, (byte) 36, (byte) 42, (byte) 1, (byte) 134, (byte) 205, (byte) 6, (byte) 213, (byte) 136, (byte) 206, (byte) 187};
    private static final byte[] ukUQRZQSNt1DjeIbqTlYa = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 96, (byte) 27, (byte) 129, (byte) 118, (byte) 128, (byte) 124, (byte) 87, (byte) 64, (byte) 236, (byte) 140, (byte) 199, (byte) 137, (byte) 106, (byte) 55, (byte) 210, (byte) 32};
    private static final byte[] EO7qewrbZa0OMHdgZ = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 121, (byte) 25, (byte) 53, (byte) 229, (byte) 89, (byte) 188, (byte) 38, (byte) 77, (byte) 157, (byte) 253, (byte) 5, (byte) 144, (byte) 135, (byte) 101, (byte) 141, (byte) 195};
    private static final byte[] FAW5Dvc39rz80DV = {(byte) 102, (byte) 177, (byte) 137, (byte) 178, (byte) 29, (byte) 20, (byte) 56, (byte) 13, (byte) 51, (byte) 25, (byte) 112, (byte) 14, (byte) 131, (byte) 242, (byte) 242, (byte) 54, (byte) 162, (byte) 77, (byte) 83, (byte) 19, (byte) 51, (byte) 27, (byte) 200, (byte) 61, (byte) 203, (byte) 31, (byte) 170, (byte) 194, (byte) 1, (byte) 178, (byte) 160, (byte) 143};
    private static final byte[] LNriPQpMjKOEIb1mdz = {(byte) 102, (byte) 177, (byte) 137, (byte) 178, (byte) 29, (byte) 20, (byte) 56, (byte) 13, (byte) 51, (byte) 25, (byte) 112, (byte) 14, (byte) 131, (byte) 242, (byte) 242, (byte) 54, (byte) 156, (byte) 253, (byte) 225, (byte) 173, (byte) 68, (byte) 195, (byte) 1, (byte) 232, (byte) 102, (byte) 80, (byte) 225, (byte) 237, (byte) 254, (byte) 207, (byte) 125, (byte) 118, (byte) 244, (byte) 188, (byte) 119, (byte) 190, (byte) 9, (byte) 122, (byte) 158, (byte) 205, (byte) 19, (byte) 42, (byte) 203, (byte) 136, (byte) 244, (byte) 29, (byte) 227, (byte) 139};
    private static final byte[] krixG5FCDcIzwI6Wa2IDcu = {(byte) 102, (byte) 177, (byte) 137, (byte) 178, (byte) 29, (byte) 20, (byte) 56, (byte) 13, (byte) 51, (byte) 25, (byte) 112, (byte) 14, (byte) 131, (byte) 242, (byte) 242, (byte) 54, (byte) 109, (byte) 204, (byte) 24, (byte) 135, (byte) 119, (byte) 118, (byte) 20, (byte) 47, (byte) 211, (byte) 210, (byte) 110, (byte) 199, (byte) 248, (byte) 94, (byte) 70, (byte) 123, (byte) 232, (byte) 213, (byte) 79, (byte) 170, (byte) 237, (byte) 118, (byte) 184, (byte) 0, (byte) 51, (byte) 206, (byte) 5, (byte) 253, (byte) 43, (byte) 242, (byte) 40, (byte) 182};
    private static final byte[] SNQKEe8A4stk6t70qlHW = {(byte) 102, (byte) 177, (byte) 137, (byte) 178, (byte) 29, (byte) 20, (byte) 56, (byte) 13, (byte) 51, (byte) 25, (byte) 112, (byte) 14, (byte) 131, (byte) 242, (byte) 242, (byte) 54, (byte) 196, (byte) 116, (byte) 171, (byte) 24, (byte) 179, (byte) 138, (byte) 141, (byte) 14, (byte) 242, (byte) 43, (byte) 99, (byte) 20, (byte) 220, (byte) 87, (byte) 204, (byte) 20, (byte) 93, (byte) 229, (byte) 249, (byte) 145, (byte) 18, (byte) 174, (byte) 98, (byte) 107, (byte) 175, (byte) 95, (byte) 190, (byte) 103, (byte) 140, (byte) 41, (byte) 68, (byte) 14};
    private static final byte[] kHzpFEe8laikAcAdVPGg = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 227, (byte) 60, (byte) 27, (byte) 20, (byte) 204, (byte) 31, (byte) 86, (byte) 132, (byte) 96, (byte) 106, (byte) 38, (byte) 135, (byte) 231, (byte) 139, (byte) 27, (byte) 61};
    private static final byte[] nSuzl3W18j3FWT = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 200, (byte) 52, (byte) 240, (byte) 95, (byte) 135, (byte) 118, (byte) 139, (byte) 86, (byte) 78, (byte) 160, (byte) 171, (byte) 157, (byte) 87, (byte) 20, (byte) 49, (byte) 165};
    private static final byte[] KNT1gs2X5wFtXd5SZo4 = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 253, (byte) 215, (byte) 79, (byte) 167, (byte) 198, (byte) 63, (byte) 169, (byte) 40, (byte) 58, (byte) 203, (byte) 182, (byte) 232, (byte) 221, (byte) 139, (byte) 113, (byte) 107};
    private static final byte[] JkmeSktPm9zmmWt5JPVz = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 127, (byte) 144, (byte) 220, (byte) 226, (byte) 81, (byte) 131, (byte) 135, (byte) 214, (byte) 123, (byte) 20, (byte) 196, (byte) 173, (byte) 123, (byte) 99, (byte) 13, (byte) 11};
    private static final byte[] RSLPpnWbLU9agJBWsPagHU = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 232, (byte) 120, (byte) 64, (byte) 11, (byte) 16, (byte) 151, (byte) 231, (byte) 197, (byte) 194, (byte) 116, (byte) 142, (byte) 43, (byte) 166, (byte) 105, (byte) 248, (byte) 6};
    private static final byte[] bN1UX4lJy9ReHL1P = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 85, (byte) 59, (byte) 250, (byte) 227, (byte) 177, (byte) 80, (byte) 166, (byte) 173, (byte) 222, (byte) 141, (byte) 48, (byte) 109, (byte) 93, (byte) 191, (byte) 129, (byte) 201};
    private static final byte[] vskrwcgfZdMiTqhamDyBZ = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 227, (byte) 245, (byte) 20, (byte) 238, (byte) 33, (byte) 5, (byte) 213, (byte) 21, (byte) 159, (byte) 110, (byte) 141, (byte) 11, (byte) 147, (byte) 180, (byte) 17, (byte) 164};
    private static final byte[] O3jg9pIMerJcbpR = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 131, (byte) 166, (byte) 34, (byte) 82, (byte) 148, (byte) 113, (byte) 162, (byte) 42, (byte) 129, (byte) 112, (byte) 207, (byte) 61, (byte) 188, (byte) 152, (byte) 83, (byte) 107, (byte) 209, (byte) 160, (byte) 198, (byte) 216, (byte) 14, (byte) 199, (byte) 163, (byte) 111, (byte) 6, (byte) 99, (byte) 1, (byte) 73, (byte) 71, (byte) 99, (byte) 137, (byte) 221};
    private static final byte[] ZqKwf9Q7OBngjmgVCiv = {(byte) 179, (byte) 112, (byte) 163, (byte) 27, (byte) 93, (byte) 153, (byte) 170, (byte) 204, (byte) 18, (byte) 42, (byte) 104, (byte) 73, (byte) 47, (byte) 230, (byte) 145, (byte) 204, (byte) 170, (byte) 46, (byte) 120, (byte) 114, (byte) 44, (byte) 40, (byte) 90, (byte) 244, (byte) 51, (byte) 198, (byte) 226, (byte) 30, (byte) 216, (byte) 162, (byte) 53, (byte) 238};
    private static final byte[] NYKTfm4bE5w5cWG = {(byte) 180, (byte) 221, (byte) 138, (byte) 22, (byte) 191, (byte) 136, (byte) 187, (byte) 84, (byte) 136, (byte) 208, (byte) 10, (byte) 232, (byte) 65, (byte) 163, (byte) 44, (byte) 131, (byte) 229, (byte) 2, (byte) 205, (byte) 129, (byte) 224, (byte) 55, (byte) 61, (byte) 225, (byte) 109, (byte) 152, (byte) 251, (byte) 174, (byte) 169, (byte) 71, (byte) 69, (byte) 7};
    private static final byte[] qOxWMlVKfL8beoz = {(byte) 198, (byte) 164, (byte) 49, (byte) 253, (byte) 79, (byte) 151, (byte) 183, (byte) 80, (byte) 91, (byte) 151, (byte) 7, (byte) 79, (byte) 102, (byte) 104, (byte) 253, (byte) 168, (byte) 97, (byte) 93, (byte) 187, (byte) 106, (byte) 124, (byte) 210, (byte) 233, (byte) 31, (byte) 211, (byte) 225, (byte) 157, (byte) 227, (byte) 143, (byte) 158, (byte) 65, (byte) 213, (byte) 45, (byte) 10, (byte) 222, (byte) 44, (byte) 233, (byte) 88, (byte) 83, (byte) 189, (byte) 77, (byte) 167, (byte) 72, (byte) 180, (byte) 123, (byte) 136, (byte) 254, (byte) 149};
    private Map<String, ItemParseImplement> lGGwXL678c4Kv7skJb5NiE = new HashMap();
    private Map<String, ScoreboardImplement> GDU5Y0ildSLo4mliJ = new HashMap();
    private Map<String, RegionImplement> hqTnbBoUmxDUXvki = new HashMap();
    private Map<String, MoneyImplement> gvy0NoTzHY6bC7eAY = new HashMap();
    private Map<String, MapImplement> nXcEVQOWhfaKT423a = new HashMap();
    private Map<String, HologramImplement> qCr0jwvuDANuhNNe9InzM1 = new HashMap();
    private Map<String, EventImplement> OfIpR1Ys0fObQiw0avrIMa = new HashMap();
    private Map<String, ClaimImplement> oUXqAhcQIZ2jOE02XWODqg = new HashMap();
    private List<String> eHlgwCjkRE7V5J3Bm3h = new ArrayList();
    private List<String> ZPBcFhvCehdDEalmo = new ArrayList();
    private List<String> E7x2l2kafA964cPe8qfFo0 = new ArrayList();
    private List<String> CWb4JhFYFus65YSN0yyKo = new ArrayList();
    private List<String> G4EmzIhpLZ0GRSPdNzU = new ArrayList();
    private List<String> WUeqGu2ELfCLdVBJJ = new ArrayList();
    private List<String> miwp9Pt3qIxSD9wX61ayb9 = new ArrayList();
    private List<String> st5XUrot9Vw9XYPvBQ0 = new ArrayList();

    public TT1XiyOqwowi4() {
        E7x2l2kafA964cPe8qfFo0();
    }

    public void v8qP8fE86HMhvNuYPFjqY(AnvilModuleAPI anvilModuleAPI) {
        this.o1VU1x4DAlrEtGKZ3jAdhE = anvilModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(AnvilModuleAPI anvilModuleAPI) {
        if (this.o1VU1x4DAlrEtGKZ3jAdhE == null || !this.o1VU1x4DAlrEtGKZ3jAdhE.equals(anvilModuleAPI)) {
            Clans.getClanCore().getLogger().warning(GWGkhJOXgDevc75hqpI());
        } else {
            this.o1VU1x4DAlrEtGKZ3jAdhE = null;
            Clans.getClanCore().getLogger().info(HnYq7AqjAMlI3xiN7g());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(MultiserverModuleAPI multiserverModuleAPI) {
        this.Un3NRLL6aWivTcbodkcK = multiserverModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(MultiserverModuleAPI multiserverModuleAPI) {
        if (this.Un3NRLL6aWivTcbodkcK == null || !this.Un3NRLL6aWivTcbodkcK.equals(multiserverModuleAPI)) {
            Clans.getClanCore().getLogger().warning(mnTtBl2W0vsd2q1());
        } else {
            this.Un3NRLL6aWivTcbodkcK = null;
            Clans.getClanCore().getLogger().info(uV0RqCLnDMOaAzumuh());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(RewardsModuleAPI rewardsModuleAPI) {
        this.p31abtwfBag2jhMH6K = rewardsModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(RewardsModuleAPI rewardsModuleAPI) {
        if (this.p31abtwfBag2jhMH6K == null || !this.p31abtwfBag2jhMH6K.equals(rewardsModuleAPI)) {
            Clans.getClanCore().getLogger().warning(c9VTzOdHkA6Ny9YY1XFox());
        } else {
            this.p31abtwfBag2jhMH6K = null;
            Clans.getClanCore().getLogger().info(ukhPxMhAMYCnxp3());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(DiscordModuleAPI discordModuleAPI) {
        this.CDW4Fj1iwdIXEOqWjiJSR = discordModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(DiscordModuleAPI discordModuleAPI) {
        if (this.CDW4Fj1iwdIXEOqWjiJSR == null || !this.CDW4Fj1iwdIXEOqWjiJSR.equals(discordModuleAPI)) {
            Clans.getClanCore().getLogger().warning(OehGNlclRAubtZEhzmU2AX());
        } else {
            this.CDW4Fj1iwdIXEOqWjiJSR = null;
            Clans.getClanCore().getLogger().info(rCK4BSR3uvJmtZ42k3dm());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(MailModuleAPI mailModuleAPI) {
        this.v8qP8fE86HMhvNuYPFjqY = mailModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(MailModuleAPI mailModuleAPI) {
        if (this.v8qP8fE86HMhvNuYPFjqY == null || !this.v8qP8fE86HMhvNuYPFjqY.equals(mailModuleAPI)) {
            Clans.getClanCore().getLogger().warning(CtOJe9XhyWWvaXXJkmG3y());
        } else {
            this.v8qP8fE86HMhvNuYPFjqY = null;
            Clans.getClanCore().getLogger().info(LGLvCw37EIbh1nPg2AT());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(BannerModuleAPI bannerModuleAPI) {
        this.jBUuLP0sWwaPyPOmogdX7l = bannerModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(BannerModuleAPI bannerModuleAPI) {
        if (this.jBUuLP0sWwaPyPOmogdX7l == null || !this.jBUuLP0sWwaPyPOmogdX7l.equals(bannerModuleAPI)) {
            Clans.getClanCore().getLogger().warning(XJrlZCTuTlgtoqhwmJk());
        } else {
            this.jBUuLP0sWwaPyPOmogdX7l = null;
            Clans.getClanCore().getLogger().info(b6k9UsJMv9zEYhivsBB());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(RivalAllyModuleAPI rivalAllyModuleAPI) {
        this.ZwrsrwOCXRUscW6Q = rivalAllyModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(RivalAllyModuleAPI rivalAllyModuleAPI) {
        if (this.ZwrsrwOCXRUscW6Q == null || !this.ZwrsrwOCXRUscW6Q.equals(rivalAllyModuleAPI)) {
            Clans.getClanCore().getLogger().warning(pwL7Tc8DMMEUZO());
        } else {
            this.ZwrsrwOCXRUscW6Q = null;
            Clans.getClanCore().getLogger().info(pHqCaTzx9sK5lqrQ1ou9b());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(LoggerModuleAPI loggerModuleAPI) {
        this.iZTqZaRK5UGoe0Z = loggerModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(LoggerModuleAPI loggerModuleAPI) {
        if (this.iZTqZaRK5UGoe0Z == null || !this.iZTqZaRK5UGoe0Z.equals(loggerModuleAPI)) {
            Clans.getClanCore().getLogger().warning(ilSOCzZ6Be98vCfLEwM());
        } else {
            this.iZTqZaRK5UGoe0Z = null;
            Clans.getClanCore().getLogger().info(LPOxUlHwqIyQupMtJMaJMX());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(LevelupModuleAPI levelupModuleAPI) {
        this.xtOheRiObl4QeAl = levelupModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(LevelupModuleAPI levelupModuleAPI) {
        if (this.xtOheRiObl4QeAl == null || !this.xtOheRiObl4QeAl.equals(levelupModuleAPI)) {
            Clans.getClanCore().getLogger().warning(empcmyalOncJv0ushbY0());
        } else {
            this.xtOheRiObl4QeAl = null;
            Clans.getClanCore().getLogger().info(Y3lRovJoLd4uLF());
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(HomeModuleAPI homeModuleAPI) {
        this.zJnaNCVQSgEShq = homeModuleAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(HomeModuleAPI homeModuleAPI) {
        if (this.zJnaNCVQSgEShq == null || !this.zJnaNCVQSgEShq.equals(homeModuleAPI)) {
            Clans.getClanCore().getLogger().warning(awFVefrHcTMa8vLhz9Lmbo());
        } else {
            this.zJnaNCVQSgEShq = null;
            Clans.getClanCore().getLogger().info(A5NcB7emYsE0lKBI9T4v());
        }
    }

    public String v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str) {
        String text;
        String text2;
        String text3;
        String text4;
        String text5;
        String text6;
        String text7;
        String text8;
        String text9;
        if (MoSLgFbw3mkSoqkObMHJ4().isPresent() && (text9 = MoSLgFbw3mkSoqkObMHJ4().get().parseText(uuid, str)) != null && !text9.equals(str) && !text9.equals("")) {
            return text9;
        }
        if (GDU5Y0ildSLo4mliJ().isPresent() && (text8 = GDU5Y0ildSLo4mliJ().get().parseText(uuid, str)) != null && !text8.equals(str) && !text8.equals("")) {
            return text8;
        }
        if (hqTnbBoUmxDUXvki().isPresent() && (text7 = hqTnbBoUmxDUXvki().get().parseText(uuid, str)) != null && !text7.equals(str) && !text7.equals("")) {
            return text7;
        }
        if (gvy0NoTzHY6bC7eAY().isPresent() && (text6 = gvy0NoTzHY6bC7eAY().get().parseText(uuid, str)) != null && !text6.equals(str) && !text6.equals("")) {
            return text6;
        }
        if (nXcEVQOWhfaKT423a().isPresent() && (text5 = nXcEVQOWhfaKT423a().get().parseText(uuid, str)) != null && !text5.equals(str) && !text5.equals("")) {
            return text5;
        }
        if (qCr0jwvuDANuhNNe9InzM1().isPresent() && (text4 = qCr0jwvuDANuhNNe9InzM1().get().parseText(uuid, str)) != null && !text4.equals(str) && !text4.equals("")) {
            return text4;
        }
        if (OfIpR1Ys0fObQiw0avrIMa().isPresent() && (text3 = OfIpR1Ys0fObQiw0avrIMa().get().parseText(uuid, str)) != null && !text3.equals(str) && !text3.equals("")) {
            return text3;
        }
        if (oUXqAhcQIZ2jOE02XWODqg().isPresent() && (text2 = oUXqAhcQIZ2jOE02XWODqg().get().parseText(uuid, str)) != null && !text2.equals(str) && !text2.equals("")) {
            return text2;
        }
        if (!eHlgwCjkRE7V5J3Bm3h().isPresent() || (text = eHlgwCjkRE7V5J3Bm3h().get().parseText(uuid, str)) == null || text.equals(str) || text.equals("")) {
            return null;
        }
        return text;
    }

    public String jBUuLP0sWwaPyPOmogdX7l(UUID uuid, String str) {
        String text;
        String text2;
        String text3;
        String text4;
        String text5;
        String text6;
        String text7;
        if (v8qP8fE86HMhvNuYPFjqY().isPresent() && (text7 = v8qP8fE86HMhvNuYPFjqY().get().parseText(uuid, str)) != null && !text7.equals(str) && !text7.equals("")) {
            return text7;
        }
        if (xtOheRiObl4QeAl().isPresent() && (text6 = xtOheRiObl4QeAl().get().parseText(uuid, str)) != null && !text6.equals(str) && !text6.equals("")) {
            return text6;
        }
        if (jBUuLP0sWwaPyPOmogdX7l().isPresent() && (text5 = jBUuLP0sWwaPyPOmogdX7l().get().parseText(uuid, str)) != null && !text5.equals(str) && !text5.equals("")) {
            return text5;
        }
        if (ZwrsrwOCXRUscW6Q().isPresent() && (text4 = ZwrsrwOCXRUscW6Q().get().parseText(uuid, str)) != null && !text4.equals(str) && !text4.equals("")) {
            return text4;
        }
        if (iZTqZaRK5UGoe0Z().isPresent() && (text3 = iZTqZaRK5UGoe0Z().get().parseText(uuid, str)) != null && !text3.equals(str) && !text3.equals("")) {
            return text3;
        }
        if (CDW4Fj1iwdIXEOqWjiJSR().isPresent() && (text2 = CDW4Fj1iwdIXEOqWjiJSR().get().parseText(uuid, str)) != null && !text2.equals(str) && !text2.equals("")) {
            return text2;
        }
        if (!b4i2FbOkaKeg91LiAe6l().isPresent() || (text = b4i2FbOkaKeg91LiAe6l().get().parseText(uuid, str)) == null || text.equals(str) || text.equals("")) {
            return null;
        }
        return text;
    }

    public Optional<RivalAllyModuleAPI> v8qP8fE86HMhvNuYPFjqY() {
        return Optional.ofNullable(this.ZwrsrwOCXRUscW6Q);
    }

    public Optional<LoggerModuleAPI> jBUuLP0sWwaPyPOmogdX7l() {
        return Optional.ofNullable(this.iZTqZaRK5UGoe0Z);
    }

    public Optional<LevelupModuleAPI> ZwrsrwOCXRUscW6Q() {
        return Optional.ofNullable(this.xtOheRiObl4QeAl);
    }

    public Optional<HomeModuleAPI> iZTqZaRK5UGoe0Z() {
        return Optional.ofNullable(this.zJnaNCVQSgEShq);
    }

    public Optional<MailModuleAPI> xtOheRiObl4QeAl() {
        return Optional.ofNullable(this.v8qP8fE86HMhvNuYPFjqY);
    }

    public Optional<BannerModuleAPI> zJnaNCVQSgEShq() {
        return Optional.ofNullable(this.jBUuLP0sWwaPyPOmogdX7l);
    }

    public Optional<RewardsModuleAPI> CDW4Fj1iwdIXEOqWjiJSR() {
        return Optional.ofNullable(this.p31abtwfBag2jhMH6K);
    }

    public Optional<DiscordModuleAPI> b4i2FbOkaKeg91LiAe6l() {
        return Optional.ofNullable(this.CDW4Fj1iwdIXEOqWjiJSR);
    }

    public Optional<MultiserverModuleAPI> p31abtwfBag2jhMH6K() {
        return Optional.ofNullable(this.Un3NRLL6aWivTcbodkcK);
    }

    public Optional<AnvilModuleAPI> Un3NRLL6aWivTcbodkcK() {
        return Optional.ofNullable(this.o1VU1x4DAlrEtGKZ3jAdhE);
    }

    public Optional<String> lGGwXL678c4Kv7skJb5NiE() {
        return this.b4i2FbOkaKeg91LiAe6l;
    }

    private void E7x2l2kafA964cPe8qfFo0() {
        zJnaNCVQSgEShq(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(X3hyxLgAEKduYgzWHdkf4()));
        ZwrsrwOCXRUscW6Q(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(KTeMfyWnfeA07c()));
        iZTqZaRK5UGoe0Z(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(mSQKbD2ndH8sykN()));
        xtOheRiObl4QeAl(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(fUqDkiba2QKW508rG()));
        jBUuLP0sWwaPyPOmogdX7l(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(WUjM7NZx123Leusqfw()));
        CDW4Fj1iwdIXEOqWjiJSR(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(sPcdCuwFACLqZMFF()));
        b4i2FbOkaKeg91LiAe6l(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(x2pRp6oCwVz3s3eh7()));
        v8qP8fE86HMhvNuYPFjqY(Clans.getClanCore().getFiles().MoSLgFbw3mkSoqkObMHJ4().getStringList(JqsMsoSpXnVplCEIGDk7l()));
    }

    private void v8qP8fE86HMhvNuYPFjqY(List<String> list) {
        this.st5XUrot9Vw9XYPvBQ0 = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, ItemParseImplement itemParseImplement) {
        this.lGGwXL678c4Kv7skJb5NiE.put(str.toUpperCase(), itemParseImplement);
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str) {
        if (this.lGGwXL678c4Kv7skJb5NiE.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: ItemParse (" + str + ")");
        }
    }

    public Optional<ItemParseImplement> jBUuLP0sWwaPyPOmogdX7l(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.lGGwXL678c4Kv7skJb5NiE.get(str.toUpperCase()));
    }

    public Optional<ItemParseImplement> o1VU1x4DAlrEtGKZ3jAdhE() {
        Iterator<String> it = this.st5XUrot9Vw9XYPvBQ0.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.lGGwXL678c4Kv7skJb5NiE.containsKey(upperCase)) {
                return Optional.of(this.lGGwXL678c4Kv7skJb5NiE.get(upperCase));
            }
        }
        return !this.lGGwXL678c4Kv7skJb5NiE.isEmpty() ? Optional.of(this.lGGwXL678c4Kv7skJb5NiE.values().iterator().next()) : Optional.empty();
    }

    public List<ItemParseImplement> vVo2VUvxrriklPdRxI() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.st5XUrot9Vw9XYPvBQ0.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            ItemParseImplement itemParseImplement = this.lGGwXL678c4Kv7skJb5NiE.get(upperCase);
            if (itemParseImplement != null) {
                arrayList.add(itemParseImplement);
                hashSet.add(upperCase);
            }
        }
        for (Map.Entry<String, ItemParseImplement> entry : this.lGGwXL678c4Kv7skJb5NiE.entrySet()) {
            if (!hashSet.contains(entry.getKey())) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public Map<String, ItemParseImplement> Fc3p9FhCjSD1k5Ra4() {
        return this.lGGwXL678c4Kv7skJb5NiE;
    }

    private void jBUuLP0sWwaPyPOmogdX7l(List<String> list) {
        this.ZPBcFhvCehdDEalmo = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, ScoreboardImplement scoreboardImplement) {
        this.GDU5Y0ildSLo4mliJ.put(str.toUpperCase(), scoreboardImplement);
    }

    public void ZwrsrwOCXRUscW6Q(String str) {
        if (this.GDU5Y0ildSLo4mliJ.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Scoreboard (" + str + ")");
        }
    }

    public Optional<ScoreboardImplement> iZTqZaRK5UGoe0Z(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.GDU5Y0ildSLo4mliJ.get(str.toUpperCase()));
    }

    public Optional<ScoreboardImplement> Nz8xKv4RePC2a0f0iuYU() {
        Iterator<String> it = this.ZPBcFhvCehdDEalmo.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.GDU5Y0ildSLo4mliJ.containsKey(upperCase)) {
                return Optional.of(this.GDU5Y0ildSLo4mliJ.get(upperCase));
            }
        }
        return !this.GDU5Y0ildSLo4mliJ.isEmpty() ? Optional.of(this.GDU5Y0ildSLo4mliJ.values().iterator().next()) : Optional.empty();
    }

    private void ZwrsrwOCXRUscW6Q(List<String> list) {
        this.E7x2l2kafA964cPe8qfFo0 = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, RegionImplement regionImplement) {
        this.hqTnbBoUmxDUXvki.put(str.toUpperCase(), regionImplement);
    }

    public void xtOheRiObl4QeAl(String str) {
        if (this.hqTnbBoUmxDUXvki.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Region (" + str + ")");
        }
    }

    public Optional<RegionImplement> zJnaNCVQSgEShq(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.hqTnbBoUmxDUXvki.get(str.toUpperCase()));
    }

    public Optional<RegionImplement> HX3ZfRb1nSpNq57s7x5ui() {
        Iterator<String> it = this.E7x2l2kafA964cPe8qfFo0.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.hqTnbBoUmxDUXvki.containsKey(upperCase)) {
                return Optional.of(this.hqTnbBoUmxDUXvki.get(upperCase));
            }
        }
        return !this.hqTnbBoUmxDUXvki.isEmpty() ? Optional.of(this.hqTnbBoUmxDUXvki.values().iterator().next()) : Optional.empty();
    }

    private void iZTqZaRK5UGoe0Z(List<String> list) {
        this.eHlgwCjkRE7V5J3Bm3h = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, MoneyImplement moneyImplement) {
        this.gvy0NoTzHY6bC7eAY.put(str.toUpperCase(), moneyImplement);
    }

    public void CDW4Fj1iwdIXEOqWjiJSR(String str) {
        if (this.gvy0NoTzHY6bC7eAY.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Money (" + str + ")");
        }
    }

    public Optional<MoneyImplement> b4i2FbOkaKeg91LiAe6l(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.gvy0NoTzHY6bC7eAY.get(str.toUpperCase()));
    }

    public Optional<MoneyImplement> IO1OGSMpoP1ZjOsbXi3a() {
        Iterator<String> it = this.eHlgwCjkRE7V5J3Bm3h.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.gvy0NoTzHY6bC7eAY.containsKey(upperCase)) {
                return Optional.of(this.gvy0NoTzHY6bC7eAY.get(upperCase));
            }
        }
        return !this.gvy0NoTzHY6bC7eAY.isEmpty() ? Optional.of(this.gvy0NoTzHY6bC7eAY.values().iterator().next()) : Optional.empty();
    }

    private void xtOheRiObl4QeAl(List<String> list) {
        this.CWb4JhFYFus65YSN0yyKo = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, MapImplement mapImplement) {
        this.nXcEVQOWhfaKT423a.put(str.toUpperCase(), mapImplement);
    }

    public void p31abtwfBag2jhMH6K(String str) {
        if (this.nXcEVQOWhfaKT423a.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Map (" + str + ")");
        }
    }

    public Optional<MapImplement> Un3NRLL6aWivTcbodkcK(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.nXcEVQOWhfaKT423a.get(str.toUpperCase()));
    }

    public Optional<MapImplement> VkPRYe34Awk6AdSxoUC() {
        Iterator<String> it = this.CWb4JhFYFus65YSN0yyKo.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.nXcEVQOWhfaKT423a.containsKey(upperCase)) {
                return Optional.of(this.nXcEVQOWhfaKT423a.get(upperCase));
            }
        }
        return !this.nXcEVQOWhfaKT423a.isEmpty() ? Optional.of(this.nXcEVQOWhfaKT423a.values().iterator().next()) : Optional.empty();
    }

    private void zJnaNCVQSgEShq(List<String> list) {
        this.G4EmzIhpLZ0GRSPdNzU = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, HologramImplement hologramImplement) {
        this.qCr0jwvuDANuhNNe9InzM1.put(str.toUpperCase(), hologramImplement);
    }

    public void lGGwXL678c4Kv7skJb5NiE(String str) {
        if (this.qCr0jwvuDANuhNNe9InzM1.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Hologram (" + str + ")");
        }
    }

    public Optional<HologramImplement> o1VU1x4DAlrEtGKZ3jAdhE(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.qCr0jwvuDANuhNNe9InzM1.get(str.toUpperCase()));
    }

    public Optional<HologramImplement> QXoNfOxIPaPrSlQMNR() {
        Iterator<String> it = this.G4EmzIhpLZ0GRSPdNzU.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.qCr0jwvuDANuhNNe9InzM1.containsKey(upperCase)) {
                return Optional.of(this.qCr0jwvuDANuhNNe9InzM1.get(upperCase));
            }
        }
        return !this.qCr0jwvuDANuhNNe9InzM1.isEmpty() ? Optional.of(this.qCr0jwvuDANuhNNe9InzM1.values().iterator().next()) : Optional.empty();
    }

    private void CDW4Fj1iwdIXEOqWjiJSR(List<String> list) {
        this.WUeqGu2ELfCLdVBJJ = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, EventImplement eventImplement) {
        this.OfIpR1Ys0fObQiw0avrIMa.put(str.toUpperCase(), eventImplement);
    }

    public void vVo2VUvxrriklPdRxI(String str) {
        if (this.OfIpR1Ys0fObQiw0avrIMa.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Event (" + str + ")");
        }
    }

    public Optional<EventImplement> Fc3p9FhCjSD1k5Ra4(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.OfIpR1Ys0fObQiw0avrIMa.get(str.toUpperCase()));
    }

    public Optional<EventImplement> V3DAV3orG0so43Del8NdO() {
        Iterator<String> it = this.WUeqGu2ELfCLdVBJJ.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.OfIpR1Ys0fObQiw0avrIMa.containsKey(upperCase)) {
                return Optional.of(this.OfIpR1Ys0fObQiw0avrIMa.get(upperCase));
            }
        }
        return !this.OfIpR1Ys0fObQiw0avrIMa.isEmpty() ? Optional.of(this.OfIpR1Ys0fObQiw0avrIMa.values().iterator().next()) : Optional.empty();
    }

    private void b4i2FbOkaKeg91LiAe6l(List<String> list) {
        this.miwp9Pt3qIxSD9wX61ayb9 = list;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, ClaimImplement claimImplement) {
        this.oUXqAhcQIZ2jOE02XWODqg.put(str.toUpperCase(), claimImplement);
    }

    public void Nz8xKv4RePC2a0f0iuYU(String str) {
        if (this.oUXqAhcQIZ2jOE02XWODqg.remove(str.toUpperCase()) != null) {
            Clans.getClanCore().getLogger().info(" - API Unlinked: Claim (" + str + ")");
        }
    }

    public Optional<ClaimImplement> HX3ZfRb1nSpNq57s7x5ui(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(this.oUXqAhcQIZ2jOE02XWODqg.get(str.toUpperCase()));
    }

    public Optional<ClaimImplement> Y9J1Kd6E1T8FcF() {
        Iterator<String> it = this.miwp9Pt3qIxSD9wX61ayb9.iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (this.oUXqAhcQIZ2jOE02XWODqg.containsKey(upperCase)) {
                return Optional.of(this.oUXqAhcQIZ2jOE02XWODqg.get(upperCase));
            }
        }
        return !this.oUXqAhcQIZ2jOE02XWODqg.isEmpty() ? Optional.of(this.oUXqAhcQIZ2jOE02XWODqg.values().iterator().next()) : Optional.empty();
    }

    public void v8qP8fE86HMhvNuYPFjqY(BankAddonAPI bankAddonAPI) {
        this.vVo2VUvxrriklPdRxI = bankAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(BankAddonAPI bankAddonAPI) {
        if (this.vVo2VUvxrriklPdRxI == null || !this.vVo2VUvxrriklPdRxI.equals(bankAddonAPI)) {
            Clans.getClanCore().getLogger().warning(xm6RWtjIO9Zmo1());
        } else {
            this.vVo2VUvxrriklPdRxI = null;
            Clans.getClanCore().getLogger().info(TV71MrzykqLoSy());
        }
    }

    public Optional<BankAddonAPI> MoSLgFbw3mkSoqkObMHJ4() {
        return Optional.ofNullable(this.vVo2VUvxrriklPdRxI);
    }

    public void v8qP8fE86HMhvNuYPFjqY(ChestAddonAPI chestAddonAPI) {
        this.Fc3p9FhCjSD1k5Ra4 = chestAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(ChestAddonAPI chestAddonAPI) {
        if (this.Fc3p9FhCjSD1k5Ra4 == null || !this.Fc3p9FhCjSD1k5Ra4.equals(chestAddonAPI)) {
            Clans.getClanCore().getLogger().warning(SCetytUVQW0fCnsmRopW9q());
        } else {
            this.Fc3p9FhCjSD1k5Ra4 = null;
            Clans.getClanCore().getLogger().info(H35KptUqcDlJPLjb());
        }
    }

    public Optional<ChestAddonAPI> GDU5Y0ildSLo4mliJ() {
        return Optional.ofNullable(this.Fc3p9FhCjSD1k5Ra4);
    }

    public void v8qP8fE86HMhvNuYPFjqY(FarmCoinsAddonAPI farmCoinsAddonAPI) {
        this.Nz8xKv4RePC2a0f0iuYU = farmCoinsAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(FarmCoinsAddonAPI farmCoinsAddonAPI) {
        if (this.Nz8xKv4RePC2a0f0iuYU == null || !this.Nz8xKv4RePC2a0f0iuYU.equals(farmCoinsAddonAPI)) {
            Clans.getClanCore().getLogger().warning(Q7aFP8HadR5qRZ0qm());
        } else {
            this.Nz8xKv4RePC2a0f0iuYU = null;
            Clans.getClanCore().getLogger().info(KVGZ0t2UHuEglhCXa1O());
        }
    }

    public Optional<FarmCoinsAddonAPI> hqTnbBoUmxDUXvki() {
        return Optional.ofNullable(this.Nz8xKv4RePC2a0f0iuYU);
    }

    public void v8qP8fE86HMhvNuYPFjqY(LandAddonAPI landAddonAPI) {
        this.HX3ZfRb1nSpNq57s7x5ui = landAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(LandAddonAPI landAddonAPI) {
        if (this.HX3ZfRb1nSpNq57s7x5ui == null || !this.HX3ZfRb1nSpNq57s7x5ui.equals(landAddonAPI)) {
            Clans.getClanCore().getLogger().warning(qBcbfFAPCYxkxAWaOUqwZE());
        } else {
            this.HX3ZfRb1nSpNq57s7x5ui = null;
            Clans.getClanCore().getLogger().info(qUi7SNacL5kh3KPkZR());
        }
    }

    public Optional<LandAddonAPI> gvy0NoTzHY6bC7eAY() {
        return Optional.ofNullable(this.HX3ZfRb1nSpNq57s7x5ui);
    }

    public void v8qP8fE86HMhvNuYPFjqY(LeaderboardAddonAPI leaderboardAddonAPI) {
        this.IO1OGSMpoP1ZjOsbXi3a = leaderboardAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(LeaderboardAddonAPI leaderboardAddonAPI) {
        if (this.IO1OGSMpoP1ZjOsbXi3a == null || !this.IO1OGSMpoP1ZjOsbXi3a.equals(leaderboardAddonAPI)) {
            Clans.getClanCore().getLogger().warning(D6cY6aSvVC4UaC());
        } else {
            this.IO1OGSMpoP1ZjOsbXi3a = null;
            Clans.getClanCore().getLogger().info(nIhInFZQmEnIfi5veqZx());
        }
    }

    public Optional<LeaderboardAddonAPI> nXcEVQOWhfaKT423a() {
        return Optional.ofNullable(this.IO1OGSMpoP1ZjOsbXi3a);
    }

    public void v8qP8fE86HMhvNuYPFjqY(LeagueAddonAPI leagueAddonAPI) {
        this.VkPRYe34Awk6AdSxoUC = leagueAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(LeagueAddonAPI leagueAddonAPI) {
        if (this.VkPRYe34Awk6AdSxoUC == null || !this.VkPRYe34Awk6AdSxoUC.equals(leagueAddonAPI)) {
            Clans.getClanCore().getLogger().warning(PX5Dkj1WyPBE5Ldn());
        } else {
            this.VkPRYe34Awk6AdSxoUC = null;
            Clans.getClanCore().getLogger().info(VdBa8Kdn7uFf3IzKr());
        }
    }

    public Optional<LeagueAddonAPI> qCr0jwvuDANuhNNe9InzM1() {
        return Optional.ofNullable(this.VkPRYe34Awk6AdSxoUC);
    }

    public void v8qP8fE86HMhvNuYPFjqY(NexusAddonAPI nexusAddonAPI) {
        this.QXoNfOxIPaPrSlQMNR = nexusAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(NexusAddonAPI nexusAddonAPI) {
        if (this.QXoNfOxIPaPrSlQMNR == null || !this.QXoNfOxIPaPrSlQMNR.equals(nexusAddonAPI)) {
            Clans.getClanCore().getLogger().warning(sDtZx9uce2jeCrPwwDt661());
        } else {
            this.QXoNfOxIPaPrSlQMNR = null;
            Clans.getClanCore().getLogger().info(L62MnBj5PPNUNNZoaMGgr());
        }
    }

    public Optional<NexusAddonAPI> OfIpR1Ys0fObQiw0avrIMa() {
        return Optional.ofNullable(this.QXoNfOxIPaPrSlQMNR);
    }

    public void v8qP8fE86HMhvNuYPFjqY(QuestAddonAPI questAddonAPI) {
        this.V3DAV3orG0so43Del8NdO = questAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(QuestAddonAPI questAddonAPI) {
        if (this.V3DAV3orG0so43Del8NdO == null || !this.V3DAV3orG0so43Del8NdO.equals(questAddonAPI)) {
            Clans.getClanCore().getLogger().warning(uLxEgiMCjx0REL8mG0fO());
        } else {
            this.V3DAV3orG0so43Del8NdO = null;
            Clans.getClanCore().getLogger().info(VHUhPCVAKwjsuCzukiGOJ());
        }
    }

    public Optional<QuestAddonAPI> oUXqAhcQIZ2jOE02XWODqg() {
        return Optional.ofNullable(this.V3DAV3orG0so43Del8NdO);
    }

    public void v8qP8fE86HMhvNuYPFjqY(WarAddonAPI warAddonAPI) {
        this.Y9J1Kd6E1T8FcF = warAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(WarAddonAPI warAddonAPI) {
        if (this.Y9J1Kd6E1T8FcF == null || !this.Y9J1Kd6E1T8FcF.equals(warAddonAPI)) {
            Clans.getClanCore().getLogger().warning(w4ZE7HWKvN93tMUgmBp());
        } else {
            this.Y9J1Kd6E1T8FcF = null;
            Clans.getClanCore().getLogger().info(wi1tGPFvkn4Hno7Q());
        }
    }

    public Optional<WarAddonAPI> eHlgwCjkRE7V5J3Bm3h() {
        return Optional.ofNullable(this.Y9J1Kd6E1T8FcF);
    }

    public void v8qP8fE86HMhvNuYPFjqY(GladiatorAddonAPI gladiatorAddonAPI) {
        this.MoSLgFbw3mkSoqkObMHJ4 = gladiatorAddonAPI;
    }

    public void jBUuLP0sWwaPyPOmogdX7l(GladiatorAddonAPI gladiatorAddonAPI) {
        if (this.MoSLgFbw3mkSoqkObMHJ4 == null || !this.MoSLgFbw3mkSoqkObMHJ4.equals(gladiatorAddonAPI)) {
            Clans.getClanCore().getLogger().warning(lUFc777kzb93Y6aQ8S1L());
        } else {
            this.MoSLgFbw3mkSoqkObMHJ4 = null;
            Clans.getClanCore().getLogger().info(C8r5LXhtZ9oa8C9P());
        }
    }

    public Optional<GladiatorAddonAPI> ZPBcFhvCehdDEalmo() {
        return Optional.ofNullable(this.MoSLgFbw3mkSoqkObMHJ4);
    }

    private static String uU6bY3TTcdpCE4c58rXwZ(byte[] bArr) {
        return "";
    }

    private static String HnYq7AqjAMlI3xiN7g() {
        return " - API Unlinked: Anvil";
    }

    private static String GWGkhJOXgDevc75hqpI() {
        return " - API Unlink Error: Anvil";
    }

    private static String uV0RqCLnDMOaAzumuh() {
        return " - API Unlinked: Multiserver";
    }

    private static String mnTtBl2W0vsd2q1() {
        return " - API Unlink Error: Multiserver";
    }

    private static String ukhPxMhAMYCnxp3() {
        return " - API Unlinked: Rewards";
    }

    private static String c9VTzOdHkA6Ny9YY1XFox() {
        return " - API Unlink Error: Rewards";
    }

    private static String rCK4BSR3uvJmtZ42k3dm() {
        return " - API Unlinked: Discord";
    }

    private static String OehGNlclRAubtZEhzmU2AX() {
        return " - API Unlink Error: Discord";
    }

    private static String LGLvCw37EIbh1nPg2AT() {
        return " - API Unlinked: Mail";
    }

    private static String CtOJe9XhyWWvaXXJkmG3y() {
        return " - API Unlink Error: Mail";
    }

    private static String b6k9UsJMv9zEYhivsBB() {
        return " - API Unlinked: Banner";
    }

    private static String XJrlZCTuTlgtoqhwmJk() {
        return " - API Unlink Error: Banner";
    }

    private static String pHqCaTzx9sK5lqrQ1ou9b() {
        return " - API Unlinked: RivalAlly";
    }

    private static String pwL7Tc8DMMEUZO() {
        return " - API Unlink Error: RivalAlly";
    }

    private static String LPOxUlHwqIyQupMtJMaJMX() {
        return " - API Unlinked: Logger";
    }

    private static String ilSOCzZ6Be98vCfLEwM() {
        return " - API Unlink Error: Logger";
    }

    private static String Y3lRovJoLd4uLF() {
        return " - API Unlinked: Levelup";
    }

    private static String empcmyalOncJv0ushbY0() {
        return " - API Unlink Error: Levelup";
    }

    private static String A5NcB7emYsE0lKBI9T4v() {
        return " - API Unlinked: Home";
    }

    private static String awFVefrHcTMa8vLhz9Lmbo() {
        return " - API Unlink Error: Home";
    }

    private static String X3hyxLgAEKduYgzWHdkf4() {
        return "Config.modules.preferences.holograms";
    }

    private static String KTeMfyWnfeA07c() {
        return "Config.modules.preferences.regions";
    }

    private static String mSQKbD2ndH8sykN() {
        return "Config.modules.preferences.money";
    }

    private static String fUqDkiba2QKW508rG() {
        return "Config.modules.preferences.map";
    }

    private static String WUjM7NZx123Leusqfw() {
        return "Config.modules.preferences.scoreboard";
    }

    private static String sPcdCuwFACLqZMFF() {
        return "Config.modules.preferences.event";
    }

    private static String x2pRp6oCwVz3s3eh7() {
        return "Config.modules.preferences.claim";
    }

    private static String JqsMsoSpXnVplCEIGDk7l() {
        return "Config.modules.preferences.item";
    }

    private static String TV71MrzykqLoSy() {
        return " - API Unlinked: Bank";
    }

    private static String xm6RWtjIO9Zmo1() {
        return " - API Unlink Error: Bank";
    }

    private static String H35KptUqcDlJPLjb() {
        return " - API Unlinked: Chest";
    }

    private static String SCetytUVQW0fCnsmRopW9q() {
        return " - API Unlink Error: Chest";
    }

    private static String KVGZ0t2UHuEglhCXa1O() {
        return " - API Unlinked: FarmCoins";
    }

    private static String Q7aFP8HadR5qRZ0qm() {
        return " - API Unlink Error: FarmCoins";
    }

    private static String qUi7SNacL5kh3KPkZR() {
        return " - API Unlinked: Land";
    }

    private static String qBcbfFAPCYxkxAWaOUqwZE() {
        return " - API Unlink Error: Land";
    }

    private static String nIhInFZQmEnIfi5veqZx() {
        return " - API Unlinked: Leaderboard";
    }

    private static String D6cY6aSvVC4UaC() {
        return " - API Unlink Error: Leaderboard";
    }

    private static String VdBa8Kdn7uFf3IzKr() {
        return " - API Unlinked: League";
    }

    private static String PX5Dkj1WyPBE5Ldn() {
        return " - API Unlink Error: League";
    }

    private static String L62MnBj5PPNUNNZoaMGgr() {
        return " - API Unlinked: Nexus";
    }

    private static String sDtZx9uce2jeCrPwwDt661() {
        return " - API Unlink Error: Nexus";
    }

    private static String VHUhPCVAKwjsuCzukiGOJ() {
        return " - API Unlinked: Quest";
    }

    private static String uLxEgiMCjx0REL8mG0fO() {
        return " - API Unlink Error: Quest";
    }

    private static String wi1tGPFvkn4Hno7Q() {
        return " - API Unlinked: War";
    }

    private static String w4ZE7HWKvN93tMUgmBp() {
        return " - API Unlink Error: War";
    }

    private static String C8r5LXhtZ9oa8C9P() {
        return " - API Unlinked: Gladiator";
    }

    private static String lUFc777kzb93Y6aQ8S1L() {
        return " - API Unlink Error: Gladiator";
    }
}
