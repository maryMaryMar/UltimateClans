package me.ulrich.clans.manager;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Addon;
import me.ulrich.clans.data.AddonInfo;
import me.ulrich.clans.data.ChestSettingsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.ClanQuestInfoData;
import me.ulrich.clans.data.ClanRivalAlly;
import me.ulrich.clans.data.ClanStats;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.PlayerActions;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.RegroupInvite;
import me.ulrich.clans.data.SettingsData;
import me.ulrich.clans.events.ClanCreateEvent;
import me.ulrich.clans.events.ClanDeleteEvent;
import me.ulrich.clans.events.ClanExtraChestEvent;
import me.ulrich.clans.events.ClanFFChangeEvent;
import me.ulrich.clans.events.ClanGlobalFriendlyFire;
import me.ulrich.clans.events.ClanKDRChangeEvent;
import me.ulrich.clans.events.ClanLeaderChangeEvent;
import me.ulrich.clans.events.ClanModTagEvent;
import me.ulrich.clans.events.ClanPlayerBanEvent;
import me.ulrich.clans.events.ClanPlayerRoleChangeEvent;
import me.ulrich.clans.events.ClanPlayerUnbanEvent;
import me.ulrich.clans.events.ClanSettingsChangeEvent;
import me.ulrich.clans.events.ClanSoulsChangeEvent;
import me.ulrich.clans.events.ClanVerifyChangeEvent;
import me.ulrich.clans.interfaces.MoneyImplement;
import me.ulrich.clans.interfaces.MultiserverModuleAPI;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;
import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.Locals;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DQoauhaxduHZi.class */
public class DQoauhaxduHZi {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private static volatile String YM26MZ0ItAnUflq;
    private static String kHrxQ84reQZEwpI;
    private static String o2cfTO7EuHF3ydJ;
    private static String dNABVu56eyIxzSW4bLvN;
    private static String lyWM3w9k8PAjB4BqR3T;
    private static volatile String MRf2CCbjqPJ27g2y68HUb7;
    private static String QzbMEUkXjltGvTeX;
    private static volatile String zgZcnO1uLKPU74;
    private static String MCmb2rc9rJq9yCXW6ZgQLj;
    private static volatile String NAnwUchKcoISgkjp5p;
    private static volatile String i3FOWUXWRXglg6;
    private static volatile String XKozhSqHXZo1XiJ;
    private static volatile String z3fogohyrCTkj1SG53X;
    private static String HUJmZSN69kMkmy4F0lUl2h;
    private static volatile String zzWvGgNkSAI4vlACraCKXk;
    private static volatile String q2Nt0hBYWLhpxiAVw;
    private static String ZQ1bNJdFnrksPeoWMQAr;
    private static String TY9ax7Eyk2TuyM3q;
    private static volatile String SCXWL7ZWkeWdDS3q;
    private static String RpkrukgMUFZX4xpJTkl;
    private static volatile String hyiZF5Sp73SKsGoySd7Jm;
    private static String MtXl5h0gVNjqW0vXb0QywN;
    private static String Z4jIhMgJ1YuD89HKK0jvwL;
    private static volatile String rNz6ghBG256oZCq;
    private static volatile String qnpzwNtjsYtScX3eT4;
    private static String ykmDmmKSNwDa3YRkzkpI5I;
    private static String CiG6vLSVqI7P2bg4Xu;
    private static String d842AfbWpZDY8pbEX;
    private static String fSdQvvbBdfth7TSjis57V;
    private static String VeDa8ef7NmT9ytw;
    private static volatile String pjgxdUaw6dfoEYlxom8obC;
    private static String O5qbnQ0XkDJ4kJ7Xe;
    private static String CE4RvBDRJwB2zeADg;
    private static volatile String fdUN3o8Tq8rVbds;
    private static String PXGnwCHrj8mFkjxhM7lv;
    private static String ne35rWPdZQEJK91L;
    private static String R1IpG7vo9aPdSHv;
    private static String tB18fphNkUSuRSf;
    private static volatile String x6lHiagjsEj0Zkl18SAs;
    private static volatile String s72wAuDxRJh40Cd;
    private static String OhR9KWaX4HnZEQapk4EV;
    private static String JQWlPkKagxReEJL9I;
    private static String AOkM6YYxJARdqofEbA0isC;
    private static volatile String mHzssKxJ42r3GF8;
    private static volatile String JBiBox1EpphFcB0JHg;
    private static String Gz0dPCCj24yxW03sE;
    private static volatile String gxEttaiuATZiyx;
    private static String C41nIxwua2Fi6oQqW;
    private static volatile String WU3JLpFvvW5qhZK;
    private static volatile String TkdfJsdiLgD7wy7;
    private static volatile String x6go8iBUX7zWQaVHp;
    private static volatile String fasuswna2VHkbpXpKC;
    private static String q1ItgbG4C20HtFjFb;
    private static String tAOZ9aa8nkz45r;
    private static volatile String CMILwggKpz2dT3QRhkSDhn;
    private static String HKmjAqsjxs9RGCX;
    private static String jn42sSuatyY3F9EHw0w;
    private static String zbxAeomFYzXJ8Be;
    private static volatile String oqq6w1v0seoqAYKoiqIn55;
    private static volatile String VioZAS9X8rQBk4a0;
    private static volatile String NIwZUmonWy2PCvoP;
    private static volatile String hWiXFkTfwRsUousd945YPS;
    private static volatile String PHsMLwIskKRFIECHjCQk;
    private static volatile String AG4ReMBd0hVO5i0JL;
    private static volatile String H2qFlEkIzA368KND;
    private static String t3n7c3eL7vmWNuWKxMclY;
    private static String t7ecROpWlaXyBa;
    private static String fiq7eorVGBLBjNs;
    private static String kHfcVe1YXvMhXxHBLp;
    private static String VJcZZzSjbDAbqv1;
    private static String mNiEbfLAA1EW4Cx6CIVk;
    private static String DZ9VLUL4Uk8o6qL;
    private static volatile String OnWXoij91qc5CPC5;
    private static volatile String F4T3pswV3BvONZb4hM;
    private static volatile String dgbWRTq4mgfnRGf;
    private static final byte[] ZLLi98TazOhd2J6 = {(byte) 17, (byte) 102, (byte) 252, (byte) 67, (byte) 94, (byte) 168, (byte) 125, (byte) 22, (byte) 6, (byte) 127, (byte) 152, (byte) 157, (byte) 0, (byte) 161, (byte) 89, (byte) 201, (byte) 44, (byte) 14, (byte) 20, (byte) 82, (byte) 123, (byte) 224, (byte) 242, (byte) 236, (byte) 35, (byte) 173, (byte) 90, (byte) 113, (byte) 221, (byte) 230, (byte) 177, (byte) 64};
    private static final byte[] Tu1W7txvLo1Xs50eowOX = {(byte) 78, (byte) 24, (byte) 70, (byte) 198, (byte) 220, (byte) 107, (byte) 114, (byte) 42, (byte) 134, (byte) 167, (byte) 197, (byte) 8, (byte) 121, (byte) 74, (byte) 142, (byte) 84, (byte) 9, (byte) 100, (byte) 21, (byte) 46, (byte) 112, (byte) 243, (byte) 214, (byte) 5, (byte) 227, (byte) 150, (byte) 44, (byte) 177, (byte) 34, (byte) 243, (byte) 247, (byte) 38};
    private static final byte[] QiJKEpCraSlkrl2 = {(byte) 97, (byte) 102, (byte) 239, (byte) 32, (byte) 156, (byte) 174, (byte) 135, (byte) 26, (byte) 149, (byte) 25, (byte) 120, (byte) 179, (byte) 24, (byte) 137, (byte) 53, (byte) 191};
    private static final byte[] iRWenvHtSYOWhUJgehJX = {(byte) 39, (byte) 220, (byte) 2, (byte) 215, (byte) 156, (byte) 197, (byte) 184, (byte) 132, (byte) 164, (byte) 166, (byte) 213, (byte) 212, (byte) 251, (byte) 210, (byte) 179, (byte) 57};
    private static final byte[] XUB9wsX6xEDn0Aejo = {(byte) 176, (byte) 172, (byte) 94, (byte) 206, (byte) 202, (byte) 92, (byte) 66, (byte) 25, (byte) 212, (byte) 36, (byte) 218, (byte) 31, (byte) 16, (byte) 147, (byte) 214, (byte) 93};
    private static final byte[] lRt3UJbNwHva1ty41 = {(byte) 47, (byte) 115, (byte) 148, (byte) 199, (byte) 2, (byte) 123, (byte) 41, (byte) 21, (byte) 233, (byte) 33, (byte) 188, (byte) 255, (byte) 31, (byte) 27, (byte) 191, (byte) 130};
    private static final byte[] BSsrKCqT8u47rlV3Q = {(byte) 197, (byte) 85, (byte) 41, (byte) 224, (byte) 252, (byte) 70, (byte) 70, (byte) 123, (byte) 153, (byte) 154, (byte) 244, (byte) 244, (byte) 165, (byte) 47, (byte) 74, (byte) 5};
    private static final byte[] ZI1OZ25qm2JTXmjR0lv4D = {(byte) 40, (byte) 116, (byte) 49, (byte) 35, (byte) 206, (byte) 61, (byte) 206, (byte) 157, (byte) 142, (byte) 206, (byte) 62, (byte) 88, (byte) 113, (byte) 205, (byte) 248, (byte) 152, (byte) 9, (byte) 171, (byte) 198, (byte) 209, (byte) 189, (byte) 67, (byte) 154, (byte) 135, (byte) 149, (byte) 138, (byte) 163, (byte) 157, (byte) 202, (byte) 31, (byte) 152, (byte) 12};
    private static final byte[] S6kXYCvo4Lsy8wCh = {(byte) 106, (byte) 97, (byte) 0, (byte) 199, (byte) 46, (byte) 181, (byte) 24, (byte) 190, (byte) 130, (byte) 223, (byte) 23, (byte) 27, (byte) 3, (byte) 34, (byte) 232, (byte) 221, (byte) 55, (byte) 118, (byte) 129, (byte) 96, (byte) 155, (byte) 159, (byte) 12, (byte) 191, (byte) 57, (byte) 6, (byte) 207, (byte) 126, (byte) 121, (byte) 85, (byte) 140, (byte) 18};
    private static final byte[] Bydgs22rxwdscD = {(byte) 159, (byte) 59, (byte) 240, (byte) 60, (byte) 46, (byte) 131, (byte) 233, (byte) 110, (byte) 207, (byte) 49, (byte) 102, (byte) 249, (byte) 82, (byte) 12, (byte) 250, (byte) 209};
    private static final byte[] lDN2iokAQElkCy = {(byte) 2, (byte) 179, (byte) 185, (byte) 109, (byte) 40, (byte) 76, (byte) 52, (byte) 235, (byte) 230, (byte) 24, (byte) 79, (byte) 226, (byte) 140, (byte) 26, (byte) 197, (byte) 107};
    private static final byte[] Pwy5yFrawqPwJ92Cfo = {(byte) 71, (byte) 29, (byte) 44, (byte) 224, (byte) 219, (byte) 210, (byte) 199, (byte) 76, (byte) 93, (byte) 41, (byte) 160, (byte) 58, (byte) 26, (byte) 253, (byte) 19, (byte) 231};
    private static final byte[] rhmBepxOMUxE91ucl = {(byte) 139, (byte) 97, (byte) 107, (byte) 138, (byte) 255, (byte) 174, (byte) 128, (byte) 226, (byte) 201, (byte) 182, (byte) 70, (byte) 192, (byte) 31, (byte) 125, (byte) 231, (byte) 94};
    private static final byte[] J7STipQPR2TtqilhcKJ = {(byte) 25, (byte) 38, (byte) 135, (byte) 20, (byte) 165, (byte) 198, (byte) 37, (byte) 245, (byte) 108, (byte) 239, (byte) 253, (byte) 80, (byte) 180, (byte) 161, (byte) 79, (byte) 206, (byte) 94, (byte) 141, (byte) 98, (byte) 163, (byte) 56, (byte) 141, (byte) 235, (byte) 50, (byte) 229, (byte) 139, (byte) 200, (byte) 111, (byte) 205, (byte) 131, (byte) 94, (byte) 230};
    private static final byte[] WEyCukWXLj9xuanE = {(byte) 119, (byte) 237, (byte) 173, (byte) 62, (byte) 149, (byte) 242, (byte) 251, (byte) 138, (byte) 129, (byte) 78, (byte) 100, (byte) 212, (byte) 129, (byte) 221, (byte) 109, (byte) 171, (byte) 255, (byte) 13, (byte) 220, (byte) 35, (byte) 113, (byte) 77, (byte) 241, (byte) 129, (byte) 254, (byte) 36, (byte) 44, (byte) 79, (byte) 236, (byte) 34, (byte) 209, (byte) 174};
    private static final byte[] rBjX5p4mZKjfDwfuGa8 = {(byte) 2, (byte) 179, (byte) 185, (byte) 109, (byte) 40, (byte) 76, (byte) 52, (byte) 235, (byte) 230, (byte) 24, (byte) 79, (byte) 226, (byte) 140, (byte) 26, (byte) 197, (byte) 107};
    private static final byte[] qCQXCy2YebtjCOJcvgI = {(byte) 140, (byte) 14, (byte) 35, (byte) 22, (byte) 192, (byte) 98, (byte) 90, (byte) 96, (byte) 177, (byte) 102, (byte) 253, (byte) 74, (byte) 122, (byte) 195, (byte) 177, (byte) 241, (byte) 123, (byte) 195, (byte) 1, (byte) 89, (byte) 152, (byte) 197, (byte) 30, (byte) 159, (byte) 218, (byte) 23, (byte) 200, (byte) 96, (byte) 60, (byte) 132, (byte) 137, (byte) 127};
    private static final byte[] tTxmOWWbUM7Og7 = {(byte) 71, (byte) 29, (byte) 44, (byte) 224, (byte) 219, (byte) 210, (byte) 199, (byte) 76, (byte) 93, (byte) 41, (byte) 160, (byte) 58, (byte) 26, (byte) 253, (byte) 19, (byte) 231};
    private static final byte[] zGlNwmMZMI33L8 = {(byte) 158, (byte) 253, (byte) 156, (byte) 3, (byte) 212, (byte) 86, (byte) 159, (byte) 238, (byte) 122, (byte) 179, (byte) 46, (byte) 86, (byte) 82, (byte) 216, (byte) 128, (byte) 152, (byte) 182, (byte) 207, (byte) 147, (byte) 203, (byte) 135, (byte) 212, (byte) 230, (byte) 128, (byte) 64, (byte) 103, (byte) 17, (byte) 106, (byte) 37, (byte) 150, (byte) 231, (byte) 36};
    private static final byte[] dznaAoBtRiRSMO = {(byte) 65, (byte) 134, (byte) 167, (byte) 143, (byte) 225, (byte) 27, (byte) 26, (byte) 116, (byte) 127, (byte) 97, (byte) 80, (byte) 139, (byte) 211, (byte) 239, (byte) 224, (byte) 254, (byte) 194, (byte) 39, (byte) 8, (byte) 147, (byte) 57, (byte) 120, (byte) 231, (byte) 106, (byte) 151, (byte) 133, (byte) 155, (byte) 158, (byte) 27, (byte) 201, (byte) 86, (byte) 0};
    private static final byte[] X9enymPt1zo1Tb9OZ = {(byte) 104, (byte) 89, (byte) 232, (byte) 15, (byte) 52, (byte) 135, (byte) 210, (byte) 193, (byte) 239, (byte) 65, (byte) 26, (byte) 198, (byte) 222, (byte) 24, (byte) 23, (byte) 200, (byte) 32, (byte) 125, (byte) 67, (byte) 200, (byte) 224, (byte) 233, (byte) 24, (byte) 26, (byte) 135, (byte) 17, (byte) 243, (byte) 78, (byte) 40, (byte) 235, (byte) 9, (byte) 156};
    private static final byte[] wHMuDIjO8jGP5bvQuE = {(byte) 2, (byte) 179, (byte) 185, (byte) 109, (byte) 40, (byte) 76, (byte) 52, (byte) 235, (byte) 230, (byte) 24, (byte) 79, (byte) 226, (byte) 140, (byte) 26, (byte) 197, (byte) 107};
    private static final byte[] Tm8gecMApnF5KDRKgsRtZ = {(byte) 104, (byte) 89, (byte) 232, (byte) 15, (byte) 52, (byte) 135, (byte) 210, (byte) 193, (byte) 239, (byte) 65, (byte) 26, (byte) 198, (byte) 222, (byte) 24, (byte) 23, (byte) 200, (byte) 32, (byte) 125, (byte) 67, (byte) 200, (byte) 224, (byte) 233, (byte) 24, (byte) 26, (byte) 135, (byte) 17, (byte) 243, (byte) 78, (byte) 40, (byte) 235, (byte) 9, (byte) 156};
    private static final byte[] wDmYfvUyEJNPXZv29y5SzM = {(byte) 106, (byte) 97, (byte) 0, (byte) 199, (byte) 46, (byte) 181, (byte) 24, (byte) 190, (byte) 130, (byte) 223, (byte) 23, (byte) 27, (byte) 3, (byte) 34, (byte) 232, (byte) 221, (byte) 55, (byte) 118, (byte) 129, (byte) 96, (byte) 155, (byte) 159, (byte) 12, (byte) 191, (byte) 57, (byte) 6, (byte) 207, (byte) 126, (byte) 121, (byte) 85, (byte) 140, (byte) 18};
    private static final byte[] wOZzCEg40aYBeVK9hepx = {(byte) 133, (byte) 116, (byte) 16, (byte) 95, (byte) 35, (byte) 83, (byte) 83, (byte) 137, (byte) 109, (byte) 206, (byte) 159, (byte) 176, (byte) 54, (byte) 49, (byte) 176, (byte) 157};
    private static final byte[] AEF20rgZntFQQIjO7 = {(byte) 92, (byte) 73, (byte) 219, (byte) 193, (byte) 244, (byte) 219, (byte) 248, (byte) 234, (byte) 2, (byte) 78, (byte) 102, (byte) 70, (byte) 121, (byte) 121, (byte) 165, (byte) 99, (byte) 168, (byte) 23, (byte) 115, (byte) 5, (byte) 127, (byte) 193, (byte) 158, (byte) 224, (byte) 66, (byte) 197, (byte) 160, (byte) 22, (byte) 5, (byte) 55, (byte) 236, (byte) 191};
    private static final byte[] MyKYR37JJ5JaHqTNgTTq = {(byte) 106, (byte) 235, (byte) 165, (byte) 180, (byte) 224, (byte) 161, (byte) 242, (byte) 8, (byte) 66, (byte) 153, (byte) 81, (byte) 119, (byte) 113, (byte) 193, (byte) 32, (byte) 17};
    private static final byte[] RvvynXbeKcRfuYDfcaN = {(byte) 200, (byte) 240, (byte) 223, (byte) 248, (byte) 41, (byte) 55, (byte) 120, (byte) 56, (byte) 246, (byte) 60, (byte) 8, (byte) 5, (byte) 98, (byte) 207, (byte) 21, (byte) 238, (byte) 112, (byte) 63, (byte) 153, (byte) 96, (byte) 151, (byte) 137, (byte) 70, (byte) 224, (byte) 128, (byte) 167, (byte) 209, (byte) 242, (byte) 150, (byte) 252, (byte) 224, (byte) 204};
    private static final byte[] atfgSDducNxqTH7 = {(byte) 185, (byte) 78, (byte) 141, (byte) 214, (byte) 194, (byte) 28, (byte) 233, (byte) 170, (byte) 240, (byte) 79, (byte) 12, (byte) 222, (byte) 235, (byte) 117, (byte) 252, (byte) 217};
    private static final byte[] MQxp1WdrSMuTuDKq3SeVb = {(byte) 131, (byte) 24, (byte) 79, (byte) 25, (byte) 207, (byte) 23, (byte) 201, (byte) 139, (byte) 137, (byte) 175, (byte) 211, (byte) 101, (byte) 149, (byte) 252, (byte) 34, (byte) 11};
    private static final byte[] toBWthWXObQfAQhufr = {(byte) 41, (byte) 69, (byte) 26, (byte) 67, (byte) 163, (byte) 22, (byte) 179, (byte) 51, (byte) 194, (byte) 196, (byte) 184, (byte) 227, (byte) 239, (byte) 245, (byte) 214, (byte) 228};
    private static final byte[] stQIY9zRZk4nlP = {(byte) 116, (byte) 149, (byte) 8, (byte) 143, (byte) 178, (byte) 215, (byte) 80, (byte) 251, (byte) 193, (byte) 26, (byte) 217, (byte) 180, (byte) 206, (byte) 101, (byte) 131, (byte) 19, (byte) 174, (byte) 218, (byte) 206, (byte) 121, (byte) 108, (byte) 147, (byte) 165, (byte) 245, (byte) 145, (byte) 251, (byte) 2, (byte) 201, (byte) 16, (byte) 155, (byte) 217, (byte) 120};
    private static final byte[] BQXo1ALVgoeyPKy = {(byte) 237, (byte) 71, (byte) 120, (byte) 50, (byte) 205, (byte) 242, (byte) 196, (byte) 201, (byte) 127, (byte) 126, (byte) 14, (byte) 176, (byte) 37, (byte) 34, (byte) 87, (byte) 101, (byte) 91, (byte) 86, (byte) 181, (byte) 253, (byte) 182, (byte) 49, (byte) 64, (byte) 176, (byte) 97, (byte) 237, (byte) 233, (byte) 220, (byte) 236, (byte) 43, (byte) 174, (byte) 62, (byte) 238, (byte) 219, (byte) 150, (byte) 219, (byte) 68, (byte) 196, (byte) 246, (byte) 118, (byte) 241, (byte) 149, (byte) 146, (byte) 164, (byte) 110, (byte) 110, (byte) 212, (byte) 34};
    private static final byte[] ThfxzX0tlJbyEUUFnj = {(byte) 91, (byte) 181, (byte) 4, (byte) 222, (byte) 132, (byte) 38, (byte) 61, (byte) 41, (byte) 171, (byte) 80, (byte) 10, (byte) 142, (byte) 77, (byte) 228, (byte) 100, (byte) 75, (byte) 154, (byte) 252, (byte) 127, (byte) 120, (byte) 109, (byte) 62, (byte) 195, (byte) 13, (byte) 89, (byte) 18, (byte) 69, (byte) 160, (byte) 171, (byte) 253, (byte) 184, (byte) 145};
    private static final byte[] Gb9GuM2G8sLneA = {(byte) 43, (byte) 182, (byte) 216, (byte) 103, (byte) 81, (byte) 197, (byte) 62, (byte) 229, (byte) 73, (byte) 103, (byte) 165, (byte) 97, (byte) 150, (byte) 93, (byte) 115, (byte) 58, (byte) 65, (byte) 159, (byte) 189, (byte) 41, (byte) 193, (byte) 160, (byte) 243, (byte) 145, (byte) 222, (byte) 113, (byte) 107, (byte) 189, (byte) 244, (byte) 124, (byte) 241, (byte) 96, (byte) 40, (byte) 152, (byte) 108, (byte) 146, (byte) 103, (byte) 99, (byte) 222, (byte) 210, (byte) 66, (byte) 148, (byte) 148, (byte) 201, (byte) 58, (byte) 44, (byte) 75, (byte) 220};
    private static final Pattern CDW4Fj1iwdIXEOqWjiJSR = Pattern.compile(lWzZf9uEdayYxYtvt());
    private final Set<UUID> xtOheRiObl4QeAl = ConcurrentHashMap.newKeySet();
    private boolean zJnaNCVQSgEShq = false;
    private final ConcurrentHashMap<UUID, ClanData> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UUID, RegroupInvite> ZwrsrwOCXRUscW6Q = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, PlayerActions> iZTqZaRK5UGoe0Z = new ConcurrentHashMap<>();

    public DQoauhaxduHZi(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public void v8qP8fE86HMhvNuYPFjqY(ClanData clanData) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.zTcC5XsAfoa1Tc1.v8qP8fE86HMhvNuYPFjqY(clanData);
    }

    public void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    public void jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(uuid, false);
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY();
    }

    public void jBUuLP0sWwaPyPOmogdX7l(ClanData clanData) {
        v8qP8fE86HMhvNuYPFjqY(clanData);
    }

    public Optional<UUID> v8qP8fE86HMhvNuYPFjqY(String str) {
        HashMap<UUID, ClanData> map = new HashMap<>();
        map.putAll(CDW4Fj1iwdIXEOqWjiJSR());
        Supplier<Stream<Map.Entry<UUID, ClanData>>> supplier = () -> {
            return map.entrySet().stream().filter(entry -> {
                return ((ClanData) entry.getValue()).getTagNoColor().equals(str);
            });
        };
        return ((Stream) supplier.get()).findAny().isPresent() ? Optional.of((UUID) ((Map.Entry) ((Stream) supplier.get()).findAny().get()).getKey()) : Optional.empty();
    }

    public Optional<ClanData> jBUuLP0sWwaPyPOmogdX7l(String str) {
        return new HashMap<UUID, ClanData>(CDW4Fj1iwdIXEOqWjiJSR()).values().stream().filter(clanData -> {
            return clanData.getTagNoColor().equals(str);
        }).findAny();
    }

    public boolean ZwrsrwOCXRUscW6Q(String str) {
        return CDW4Fj1iwdIXEOqWjiJSR().values().stream().filter(clanData -> {
            return clanData.getTagNoColor().toLowerCase().equalsIgnoreCase(str);
        }).findAny().isPresent();
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid) {
        return uuid != null && CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid);
    }

    public Optional<ClanData> iZTqZaRK5UGoe0Z(UUID uuid) {
        return ZwrsrwOCXRUscW6Q(uuid) ? Optional.of(CDW4Fj1iwdIXEOqWjiJSR().get(uuid)) : Optional.empty();
    }

    public boolean xtOheRiObl4QeAl(UUID uuid) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        boolean z = !optionalIZTqZaRK5UGoe0Z.get().isVerified();
        optionalIZTqZaRK5UGoe0Z.get().setVerified(z);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        Bukkit.getPluginManager().callEvent(new ClanVerifyChangeEvent(uuid, z));
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2, Optional<ModerationData> optional) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent() || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().xtOheRiObl4QeAl(optionalIZTqZaRK5UGoe0Z.get().getId(), uuid2)) {
            return false;
        }
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get().getId(), optional);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        Bukkit.getPluginManager().callEvent(new ClanPlayerRoleChangeEvent(uuid2, optionalIZTqZaRK5UGoe0Z.get().getId(), ClanEnum.ClanActions.PROMOTEMEMBER));
        return true;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, UUID uuid2, Optional<ModerationData> optional) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent() || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().xtOheRiObl4QeAl(uuid, uuid2)) {
            return false;
        }
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return false;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get(), optional);
        Bukkit.getPluginManager().callEvent(new ClanPlayerRoleChangeEvent(uuid2, optionalIZTqZaRK5UGoe0Z.get().getId(), ClanEnum.ClanActions.DEMOTEMEMBER));
        return true;
    }

    public void v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.clanMessageSend(optionalIZTqZaRK5UGoe0Z.get(), str);
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2, UUID uuid3) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent() || optionalIZTqZaRK5UGoe0Z.get().getLeader().equals(uuid2)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (optionalIZTqZaRK5UGoe0Z.get().getBanned() != null) {
                arrayList.addAll(optionalIZTqZaRK5UGoe0Z.get().getBanned());
            }
        } catch (Exception e) {
        }
        if (arrayList.contains(uuid2)) {
            arrayList.remove(uuid2);
        }
        arrayList.add(uuid2);
        optionalIZTqZaRK5UGoe0Z.get().setBanned(arrayList);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        if (this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid2, uuid3)) {
            this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid2, ClanEnum.PlayerLeaveReaction.KICK);
        }
        Bukkit.getPluginManager().callEvent(new ClanPlayerBanEvent(uuid2, uuid, uuid3));
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent() || optionalIZTqZaRK5UGoe0Z.get().getBanned().size() <= 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList(optionalIZTqZaRK5UGoe0Z.get().getBanned());
        if (!optionalIZTqZaRK5UGoe0Z.get().getBanned().contains(uuid2)) {
            return false;
        }
        arrayList.remove(uuid2);
        optionalIZTqZaRK5UGoe0Z.get().setBanned(arrayList);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        Bukkit.getPluginManager().callEvent(new ClanPlayerUnbanEvent(uuid2, uuid));
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, Player player) {
        return jBUuLP0sWwaPyPOmogdX7l(uuid, player.getUniqueId());
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, UUID uuid2) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent() || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().xtOheRiObl4QeAl(uuid, uuid2) || this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid2)) {
            return false;
        }
        UUID leader = optionalIZTqZaRK5UGoe0Z.get().getLeader();
        boolean zV8qP8fE86HMhvNuYPFjqY = false;
        boolean zV8qP8fE86HMhvNuYPFjqY2 = false;
        Optional<ModerationData> optionalJBUuLP0sWwaPyPOmogdX7l = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().jBUuLP0sWwaPyPOmogdX7l();
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
        if (optionalP31abtwfBag2jhMH6K.isPresent() && optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            zV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get().getId(), optionalJBUuLP0sWwaPyPOmogdX7l);
        }
        Optional<ModerationData> optionalZwrsrwOCXRUscW6Q = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().ZwrsrwOCXRUscW6Q();
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(leader);
        if (optionalP31abtwfBag2jhMH6K2.isPresent() && optionalZwrsrwOCXRUscW6Q.isPresent()) {
            zV8qP8fE86HMhvNuYPFjqY2 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K2.get().getId(), optionalZwrsrwOCXRUscW6Q);
        }
        if (!zV8qP8fE86HMhvNuYPFjqY || !zV8qP8fE86HMhvNuYPFjqY2) {
            return false;
        }
        optionalIZTqZaRK5UGoe0Z.get().setLeader(uuid2);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        Bukkit.getPluginManager().callEvent(new ClanLeaderChangeEvent(optionalIZTqZaRK5UGoe0Z.get().getId(), leader, uuid2));
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(ClanData clanData, String str, Player player) {
        if (clanData == null) {
            return false;
        }
        clanData.setDesc(str);
        jBUuLP0sWwaPyPOmogdX7l(clanData);
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(ClanData clanData, ClanEnum.SettingsType settingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept) {
        boolean zIsAllyPvp = false;
        switch (jfN3Uc9ymXXFWVHj7Oor.v8qP8fE86HMhvNuYPFjqY[settingsType.ordinal()]) {
            case 1:
                boolean z = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z = !clanData.getSettings().isWarInvite();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z = false;
                }
                clanData.getSettings().setWarInvite(z);
                zIsAllyPvp = clanData.getSettings().isWarInvite();
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                break;
            case 2:
                boolean z2 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z2 = !clanData.getSettings().isAllySharedChat();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z2 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z2 = false;
                }
                clanData.getSettings().setAllySharedChat(z2);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isAllySharedChat();
                break;
            case 3:
                boolean z3 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z3 = !clanData.getSettings().isAllySharedHome();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z3 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z3 = false;
                }
                clanData.getSettings().setAllySharedHome(z3);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isAllySharedHome();
                break;
            case 4:
                boolean z4 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z4 = !clanData.getSettings().isJoinLeave();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z4 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z4 = false;
                }
                clanData.getSettings().setJoinLeave(z4);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isJoinLeave();
                break;
            case 5:
                boolean z5 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z5 = !clanData.getSettings().isOpened();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z5 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z5 = false;
                }
                clanData.getSettings().setOpened(z5);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isOpened();
                break;
            case 6:
                boolean z6 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z6 = !clanData.getSettings().isPublicHomes();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z6 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z6 = false;
                }
                clanData.getSettings().setPublicHomes(z6);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isPublicHomes();
                break;
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                boolean z7 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z7 = !clanData.getSettings().isReceveMailAllies();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z7 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z7 = false;
                }
                clanData.getSettings().setReceveMailAllies(z7);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isReceveMailAllies();
                break;
            case 8:
                boolean z8 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z8 = !clanData.getSettings().isReceiveMailAll();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z8 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z8 = false;
                }
                clanData.getSettings().setReceiveMailAll(z8);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isReceiveMailAll();
                break;
            case 9:
                boolean z9 = true;
                if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TOGGLE)) {
                    z9 = !clanData.getSettings().isAllyPvp();
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.TRUE)) {
                    z9 = true;
                } else if (settingsFlagsAccept.equals(ClanEnum.SettingsFlagsAccept.FALSE)) {
                    z9 = false;
                }
                clanData.getSettings().setAllyPvp(z9);
                jBUuLP0sWwaPyPOmogdX7l(clanData);
                zIsAllyPvp = clanData.getSettings().isAllyPvp();
                break;
        }
        Bukkit.getPluginManager().callEvent(new ClanSettingsChangeEvent(clanData.getId(), settingsType, settingsFlagsAccept));
        return zIsAllyPvp;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(ClanData clanData, String str) {
        return v8qP8fE86HMhvNuYPFjqY(clanData, str, Optional.empty());
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(ClanData clanData, String str, Player player) {
        return v8qP8fE86HMhvNuYPFjqY(clanData, str, Optional.of(player));
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(ClanData clanData, String str, Optional<Player> optional) {
        try {
            String strZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
            String tagNoColor = clanData.getTagNoColor();
            clanData.setTag(str);
            clanData.setTagNoColor(strZJnaNCVQSgEShq);
            clanData.getStats().setTagChanged(clanData.getStats().getTagChanged() + 1);
            jBUuLP0sWwaPyPOmogdX7l(clanData);
            if (optional.isPresent()) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(optional.get().getUniqueId());
                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                    new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions.MODTAG, Arrays.asList("%player%;" + optionalP31abtwfBag2jhMH6K.get().getName(), "%oldtag%;" + tagNoColor, "%newtag%;" + clanData.getTagNoColor()), optionalP31abtwfBag2jhMH6K.get().getId());
                }
            }
            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                Bukkit.getPluginManager().callEvent(new ClanModTagEvent(clanData.getId(), tagNoColor, optional.isPresent() ? ((Player) optional.get()).getUniqueId() : null));
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender) {
        try {
            this.zJnaNCVQSgEShq = !b4i2FbOkaKeg91LiAe6l();
            Bukkit.getPluginManager().callEvent(new ClanGlobalFriendlyFire(commandSender));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean ZwrsrwOCXRUscW6Q(ClanData clanData) {
        if (clanData == null) {
            return false;
        }
        boolean z = !clanData.isFf();
        clanData.setFf(z);
        jBUuLP0sWwaPyPOmogdX7l(clanData);
        Bukkit.getPluginManager().callEvent(new ClanFFChangeEvent(clanData.getId(), z));
        return true;
    }

    public boolean zJnaNCVQSgEShq(UUID uuid) {
        try {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
            if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
                return false;
            }
            Double bank = optionalIZTqZaRK5UGoe0Z.get().getBank();
            UUID leader = optionalIZTqZaRK5UGoe0Z.get().getLeader();
            new ArrayList<UUID>(optionalIZTqZaRK5UGoe0Z.get().getMembers()).iterator().forEachRemaining(uuid2 -> {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                    this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().VkPRYe34Awk6AdSxoUC(optionalP31abtwfBag2jhMH6K.get().getId());
                }
            });
            Optional<RivalAllyModuleAPI> optionalV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().v8qP8fE86HMhvNuYPFjqY();
            if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                try {
                    ArrayList arrayList = new ArrayList(optionalIZTqZaRK5UGoe0Z.get().getRivalAlly().getAlly());
                    if (!arrayList.isEmpty() && arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            optionalV8qP8fE86HMhvNuYPFjqY.get().allyRemove((UUID) it.next(), optionalIZTqZaRK5UGoe0Z.get().getId());
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    ArrayList arrayList2 = new ArrayList(optionalIZTqZaRK5UGoe0Z.get().getRivalAlly().getRival());
                    if (!arrayList2.isEmpty() && arrayList2 != null) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            optionalV8qP8fE86HMhvNuYPFjqY.get().rivalRemove((UUID) it2.next(), optionalIZTqZaRK5UGoe0Z.get().getId());
                        }
                    }
                } catch (Exception e2) {
                }
            }
            CDW4Fj1iwdIXEOqWjiJSR().remove(uuid);
            v8qP8fE86HMhvNuYPFjqY(uuid);
            this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().zJnaNCVQSgEShq(optionalIZTqZaRK5UGoe0Z.get().getId());
            this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().lGGwXL678c4Kv7skJb5NiE(optionalIZTqZaRK5UGoe0Z.get().getId());
            this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().lGGwXL678c4Kv7skJb5NiE(optionalIZTqZaRK5UGoe0Z.get().getId());
            Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                Bukkit.getPluginManager().callEvent(new ClanDeleteEvent(null, ((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getId(), ((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getTagNoColor()));
            });
            Optional<MoneyImplement> optionalIO1OGSMpoP1ZjOsbXi3a = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().IO1OGSMpoP1ZjOsbXi3a();
            if (!optionalIO1OGSMpoP1ZjOsbXi3a.isPresent() || bank.doubleValue() <= 0.0d) {
                return true;
            }
            Player player = null;
            try {
                player = Bukkit.getPlayer(leader);
            } catch (Exception e3) {
            }
            if (player == null) {
                return true;
            }
            Player player2 = player;
            double dDoubleValue = bank.doubleValue();
            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player2, () -> {
                ((MoneyImplement) optionalIO1OGSMpoP1ZjOsbXi3a.get()).addMoney(player2, dDoubleValue);
                MessageUtils.sendText((CommandSender) player2, jBUuLP0sWwaPyPOmogdX7l(leader, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player2.getUniqueId())).getString(Lang.PLAYER_DEPOSITED_MONEY, Arrays.asList("%amount%;" + String.valueOf(dDoubleValue)))));
            });
            return true;
        } catch (Exception e4) {
            return false;
        }
    }

    public boolean CDW4Fj1iwdIXEOqWjiJSR(UUID uuid) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return zJnaNCVQSgEShq(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
        }
        return false;
    }

    public Optional<ClanData> v8qP8fE86HMhvNuYPFjqY(Player player, String str, String str2, long j) {
        return v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), str, str2, j);
    }

    public Optional<ClanData> v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str, String str2, long j) {
        UUID uuidRandomUUID = UUID.randomUUID();
        ClanStats clanStats = new ClanStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        ClanRivalAlly clanRivalAlly = new ClanRivalAlly(new ArrayList(), new ArrayList());
        ArrayList arrayList = new ArrayList();
        arrayList.add(uuid);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(uuid);
        ClanData clanData = new ClanData(uuidRandomUUID, str, "", uuid, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(X4Kpcrqu2OaRoNeWuSre()), new ArrayList(), j, clanStats, arrayList, arrayList2, false, 0.0d, this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str), new ArrayList(), new ArrayList(), clanRivalAlly, Double.valueOf(0.0d), 0, new ClanQuestInfoData(0, 0), new SettingsData(Optional.empty(), true, false, true, false, false, true, true, true, false), new ChestSettingsData(0, Arrays.asList(new Integer[0])), null, 0, 0, szhrWdRKt1WSyW(), null, j);
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().Nz8xKv4RePC2a0f0iuYU(uuid);
        }
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            return Optional.empty();
        }
        CDW4Fj1iwdIXEOqWjiJSR().put(clanData.getId(), clanData);
        v8qP8fE86HMhvNuYPFjqY(clanData);
        new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions.CREATE, Arrays.asList("%player%;" + optionalP31abtwfBag2jhMH6K.get().getName(), "%clantag%;" + clanData.getTagNoColor()), optionalP31abtwfBag2jhMH6K.get().getId());
        this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalP31abtwfBag2jhMH6K.get(), clanData.getId(), this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().jBUuLP0sWwaPyPOmogdX7l());
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
            Bukkit.getPluginManager().callEvent(new ClanCreateEvent(uuid, clanData.getId(), clanData.getTagNoColor()));
        });
        return Optional.of(clanData);
    }

    public void v8qP8fE86HMhvNuYPFjqY(Player player, Optional<EncodedLocationData> optional, boolean z) {
        if (player == null) {
            return;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player, () -> {
            jBUuLP0sWwaPyPOmogdX7l(player, (Optional<EncodedLocationData>) optional, z);
        });
    }

    private void jBUuLP0sWwaPyPOmogdX7l(Player player, Optional<EncodedLocationData> optional, boolean z) {
        String string;
        if (player.isOnline()) {
            Location location = player.getLocation();
            if (z && (string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(A8MvxFFmEwkZU9())) != null && !string.isEmpty()) {
                if (player.hasPermission(string)) {
                    z = false;
                } else {
                    MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_TELEPORT_DONT_MOVE, Arrays.asList("%sec%;" + String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(q9lV0Oi7B1dBOxVgsQkn())))));
                }
            }
            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                if (player.isOnline()) {
                    Location location2 = player.getLocation();
                    if (location2.getWorld() != location.getWorld() || location2.getX() != location.getX() || location2.getY() != location.getY() || location2.getZ() != location.getZ()) {
                        MessageUtils.sendText((CommandSender) player, Un3NRLL6aWivTcbodkcK().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_TELEPORT_MOVED));
                        return;
                    }
                    if (optional != null) {
                        try {
                            if (optional.isPresent()) {
                                if (Un3NRLL6aWivTcbodkcK().getHooksManager().isInCombat(player)) {
                                    v8qP8fE86HMhvNuYPFjqY(player, false);
                                    return;
                                }
                                EncodedLocationData encodedLocationData = (EncodedLocationData) optional.get();
                                if (encodedLocationData.getServer().equals(Un3NRLL6aWivTcbodkcK().getServerName())) {
                                    Optional<Location> optionalMountLocal = new Locals().mountLocal(encodedLocationData);
                                    if (!optionalMountLocal.isPresent() || optionalMountLocal.get().getWorld() == null) {
                                        v8qP8fE86HMhvNuYPFjqY(player, false);
                                        return;
                                    }
                                    v8qP8fE86HMhvNuYPFjqY(player, optionalMountLocal.get()).whenComplete((bool, th) -> {
                                        if (th != null) {
                                            Un3NRLL6aWivTcbodkcK().getLogger().log(Level.WARNING, fbujpBgNxdsBjab1w5(), v8qP8fE86HMhvNuYPFjqY(th));
                                        }
                                        Un3NRLL6aWivTcbodkcK().getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player, () -> {
                                            if (player.isOnline()) {
                                                v8qP8fE86HMhvNuYPFjqY(player, th == null && Boolean.TRUE.equals(bool));
                                            }
                                        });
                                    });
                                } else {
                                    Optional<MultiserverModuleAPI> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().p31abtwfBag2jhMH6K();
                                    if (optionalP31abtwfBag2jhMH6K.isPresent() && optionalP31abtwfBag2jhMH6K.get().syncEnabled()) {
                                        optionalP31abtwfBag2jhMH6K.get().serverConnector(player, encodedLocationData.getServer());
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put(bD9MNPIwWWGgxttGY5I(), player.getUniqueId().toString());
                                        jSONObject.put(Mj5J219fusRhJmfE(), encodedLocationData.getServer());
                                        jSONObject.put(hSdooUsj6HY1aG1m9JYd6o(), encodedLocationData.getWorld());
                                        jSONObject.put(t7iNXfSkTWd9LJuQXUu5K(), encodedLocationData.getX());
                                        jSONObject.put(aP4S7apiOZRCcSyF9PHV2k(), encodedLocationData.getY());
                                        jSONObject.put(ta1F6qtd11idsM(), encodedLocationData.getZ());
                                        jSONObject.put(JqYF0uYpFvVDVEulD(), encodedLocationData.getYaw());
                                        jSONObject.put(zeqElaRZmsOFLamqV8hz(), encodedLocationData.getPitch());
                                        optionalP31abtwfBag2jhMH6K.get().sendSync(ClanEnum.RedisType.PLAYERTELEPORT.toString(), jSONObject.toString());
                                        v8qP8fE86HMhvNuYPFjqY(player, true);
                                    } else {
                                        v8qP8fE86HMhvNuYPFjqY(player, false);
                                    }
                                }
                                return;
                            }
                        } catch (Exception e) {
                            Un3NRLL6aWivTcbodkcK().getLogger().log(Level.WARNING, kAOwZmBIwYzejla9X8fTUf(), (Throwable) e);
                            v8qP8fE86HMhvNuYPFjqY(player, false);
                            return;
                        }
                    }
                    v8qP8fE86HMhvNuYPFjqY(player, false);
                }
            }, z ? Math.max(0L, ((long) this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(pdpK0aHZ17fWvRAIoO0P())) * 20) : 0L);
        }
    }

    private void v8qP8fE86HMhvNuYPFjqY(Player player, boolean z) {
        MessageUtils.sendText((CommandSender) player, Un3NRLL6aWivTcbodkcK().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(z ? Lang.PLAYER_TELEPORT_TRUE : Lang.PLAYER_TELEPORT_FALSE));
    }

    private CompletableFuture<Boolean> v8qP8fE86HMhvNuYPFjqY(Player player, Location location) {
        if (player == null || !player.isOnline() || location == null || location.getWorld() == null) {
            return CompletableFuture.completedFuture(false);
        }
        try {
            Object objInvoke = player.getClass().getMethod(oqHmPkKcU0WtQim(), Location.class).invoke(player, location.clone());
            if (!(objInvoke instanceof CompletionStage)) {
                return CompletableFuture.failedFuture(new IllegalStateException(v0EBMaJKLgYiIX3dZtaE3()));
            }
            Boolean bool = Boolean.TRUE;
            Objects.requireNonNull(bool);
            return ((CompletionStage) objInvoke).thenApply(bool::equals).toCompletableFuture();
        } catch (NoSuchMethodException e) {
            if (lGGwXL678c4Kv7skJb5NiE()) {
                return CompletableFuture.failedFuture(new IllegalStateException(HwfAdXCj8LrysOQtI(), e));
            }
            try {
                return CompletableFuture.completedFuture(Boolean.valueOf(player.teleport(location)));
            } catch (Exception e2) {
                return CompletableFuture.failedFuture(e2);
            }
        } catch (InvocationTargetException e3) {
            return CompletableFuture.failedFuture(v8qP8fE86HMhvNuYPFjqY(e3));
        } catch (Exception e4) {
            return CompletableFuture.failedFuture(e4);
        }
    }

    private Throwable v8qP8fE86HMhvNuYPFjqY(Throwable th) {
        Throwable th2;
        Throwable cause = th;
        while (true) {
            th2 = cause;
            if ((!(th2 instanceof InvocationTargetException) && !(th2 instanceof CompletionException)) || th2.getCause() == null) {
                break;
            }
            cause = th2.getCause();
        }
        return th2;
    }

    private boolean lGGwXL678c4Kv7skJb5NiE() {
        if (Un3NRLL6aWivTcbodkcK().getTaskManager().iZTqZaRK5UGoe0Z()) {
            return true;
        }
        String lowerCase = (Bukkit.getServer().getName() + " " + Bukkit.getVersion()).toLowerCase(Locale.ROOT);
        return lowerCase.contains(hLwH6JiiTdvQiGj45an8Pz()) || lowerCase.contains(Ew9rp83Z1VOwyOgvn8x());
    }

    public List<ClanData> jBUuLP0sWwaPyPOmogdX7l() {
        return new ArrayList<ClanData>(CDW4Fj1iwdIXEOqWjiJSR().values()).stream().filter(clanData -> {
            return clanData != null && (!(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(mzM9daMeSYhj8cHYD()) || clanData.isVerified()) || (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(kDtIkvT9cYd2IS5H3iG()) && (clanData.isVerified() || !clanData.isVerified())));
        }).collect(Collectors.toList());
    }

    public List<String> ZwrsrwOCXRUscW6Q() {
        ArrayList arrayList = new ArrayList();
        jBUuLP0sWwaPyPOmogdX7l().iterator().forEachRemaining(clanData -> {
            arrayList.add(clanData.getTagNoColor());
        });
        return arrayList;
    }

    public List<UUID> iZTqZaRK5UGoe0Z() {
        return new ArrayList(CDW4Fj1iwdIXEOqWjiJSR().keySet());
    }

    public double v8qP8fE86HMhvNuYPFjqY(int i, int i2) {
        double d = 0.0d;
        int i3 = i2;
        if (i > 0 || i3 > 0) {
            if (i3 == 0) {
                i3 = 1;
            }
            try {
                d = ((double) i) / ((double) i3);
            } catch (Exception e) {
            }
        }
        return d;
    }

    public double b4i2FbOkaKeg91LiAe6l(UUID uuid) {
        double dV8qP8fE86HMhvNuYPFjqY = 0.0d;
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            int kills = 0;
            int deaths = 0;
            Iterator<UUID> it = optionalIZTqZaRK5UGoe0Z.get().getMembers().iterator();
            while (it.hasNext()) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = Un3NRLL6aWivTcbodkcK().getPlayerManager().p31abtwfBag2jhMH6K(it.next());
                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                    kills += optionalP31abtwfBag2jhMH6K.get().getKills();
                }
            }
            Iterator<UUID> it2 = optionalIZTqZaRK5UGoe0Z.get().getMembers().iterator();
            while (it2.hasNext()) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = Un3NRLL6aWivTcbodkcK().getPlayerManager().p31abtwfBag2jhMH6K(it2.next());
                if (optionalP31abtwfBag2jhMH6K2.isPresent()) {
                    deaths += optionalP31abtwfBag2jhMH6K2.get().getDeaths();
                }
            }
            dV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(kills, deaths);
        }
        return dV8qP8fE86HMhvNuYPFjqY;
    }

    public boolean iZTqZaRK5UGoe0Z(ClanData clanData) {
        if (clanData != null) {
            return p31abtwfBag2jhMH6K(clanData.getId());
        }
        return false;
    }

    public boolean p31abtwfBag2jhMH6K(UUID uuid) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        Iterator<UUID> it = optionalIZTqZaRK5UGoe0Z.get().getMembers().iterator();
        while (it.hasNext()) {
            this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().QXoNfOxIPaPrSlQMNR(it.next());
        }
        Bukkit.getPluginManager().callEvent(new ClanKDRChangeEvent(optionalIZTqZaRK5UGoe0Z.get().getId(), 0.0d, 0, 0));
        return true;
    }

    public boolean xtOheRiObl4QeAl(ClanData clanData) {
        if (clanData != null) {
            return Un3NRLL6aWivTcbodkcK(clanData.getId());
        }
        return false;
    }

    public boolean Un3NRLL6aWivTcbodkcK(UUID uuid) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        Iterator<UUID> it = optionalIZTqZaRK5UGoe0Z.get().getMembers().iterator();
        while (it.hasNext()) {
            this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().V3DAV3orG0so43Del8NdO(it.next());
        }
        Bukkit.getPluginManager().callEvent(new ClanSoulsChangeEvent(optionalIZTqZaRK5UGoe0Z.get().getId(), ClanEnum.SoulsChangeType.RESET, 0));
        return true;
    }

    public int lGGwXL678c4Kv7skJb5NiE(UUID uuid) {
        int souls = 0;
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            Iterator<UUID> it = optionalIZTqZaRK5UGoe0Z.get().getMembers().iterator();
            while (it.hasNext()) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = Un3NRLL6aWivTcbodkcK().getPlayerManager().p31abtwfBag2jhMH6K(it.next());
                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                    souls = 0 + optionalP31abtwfBag2jhMH6K.get().getSouls();
                }
            }
        }
        return souls;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, int i, CommandSender commandSender) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        int extraChest = optionalIZTqZaRK5UGoe0Z.get().getChestSettings().getExtraChest() + i;
        optionalIZTqZaRK5UGoe0Z.get().getChestSettings().setExtraChest(extraChest);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        Bukkit.getPluginManager().callEvent(new ClanExtraChestEvent(optionalIZTqZaRK5UGoe0Z.get().getId(), extraChest, commandSender));
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(String str, int i, CommandSender commandSender) {
        Optional<UUID> optionalV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str);
        if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            return jBUuLP0sWwaPyPOmogdX7l(optionalV8qP8fE86HMhvNuYPFjqY.get(), i, commandSender);
        }
        return false;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(UUID uuid, int i, CommandSender commandSender) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        optionalIZTqZaRK5UGoe0Z.get().setExtraSlots(optionalIZTqZaRK5UGoe0Z.get().getExtraSlots() + i);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        return true;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(String str, int i, CommandSender commandSender) {
        Optional<UUID> optionalV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str);
        if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            return ZwrsrwOCXRUscW6Q(optionalV8qP8fE86HMhvNuYPFjqY.get(), i, commandSender);
        }
        return false;
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid, int i, CommandSender commandSender) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        int extraSlots = optionalIZTqZaRK5UGoe0Z.get().getExtraSlots() - i;
        if (extraSlots < 1) {
            extraSlots = 0;
        }
        optionalIZTqZaRK5UGoe0Z.get().setExtraSlots(extraSlots);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        return true;
    }

    public boolean ZwrsrwOCXRUscW6Q(String str, int i, CommandSender commandSender) {
        Optional<UUID> optionalV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str);
        if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            return iZTqZaRK5UGoe0Z(optionalV8qP8fE86HMhvNuYPFjqY.get(), i, commandSender);
        }
        return false;
    }

    public boolean iZTqZaRK5UGoe0Z(UUID uuid, int i, CommandSender commandSender) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return false;
        }
        optionalIZTqZaRK5UGoe0Z.get().setExtraSlots(i);
        jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
        return true;
    }

    public boolean o1VU1x4DAlrEtGKZ3jAdhE(UUID uuid) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            return optionalIZTqZaRK5UGoe0Z.get().getMembers().size() < zJnaNCVQSgEShq(optionalIZTqZaRK5UGoe0Z.get()) + optionalIZTqZaRK5UGoe0Z.get().getExtraSlots();
        }
        return false;
    }

    public int zJnaNCVQSgEShq(ClanData clanData) {
        if (clanData != null) {
            try {
                int i = 0;
                Iterator it = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(pq8kplcVqTJr39VPos03Sb()).iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = ((String) it.next()).split(jeHObNV1vLP0kIKAzlNyYE());
                    if (strArrSplit.length == 2) {
                        int iIntValue = Integer.valueOf(strArrSplit[0]).intValue();
                        if (clanData.getLevel() >= Integer.valueOf(strArrSplit[1]).intValue() && iIntValue > i) {
                            i = iIntValue;
                        }
                    }
                }
                if (i == 0) {
                    i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(Ke1vrFHXWgbcv6c());
                }
                return i;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(XAT7mXlCmJv8WA1());
    }

    @Deprecated
    public boolean vVo2VUvxrriklPdRxI(UUID uuid) {
        try {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                for (UUID uuid2 : optionalIZTqZaRK5UGoe0Z.get().getMembers()) {
                    try {
                        if (Bukkit.getPlayer(uuid2).isOnline() && (optionalIZTqZaRK5UGoe0Z.get().getMods().contains(uuid2) || this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(uuid2))) {
                            return true;
                        }
                    } catch (Exception e) {
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public String jBUuLP0sWwaPyPOmogdX7l(UUID uuid, String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (uuid != null) {
            try {
                str = str.replace(LyA9Kw0rbooBiGx(), uuid.toString()).replace(CJwfKVOn2VzdWAVx(), uuid.toString());
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        Matcher matcher = CDW4Fj1iwdIXEOqWjiJSR.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String strV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getClanPlaceholderAPI().v8qP8fE86HMhvNuYPFjqY(uuid, strGroup);
            if (strV8qP8fE86HMhvNuYPFjqY == null) {
                strV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getClanPlaceholderAPI().v8qP8fE86HMhvNuYPFjqY(uuid, zJnaNCVQSgEShq(strGroup));
            }
            if (strV8qP8fE86HMhvNuYPFjqY == null) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strGroup));
            } else {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strV8qP8fE86HMhvNuYPFjqY));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private String zJnaNCVQSgEShq(String str) {
        if (str.startsWith(q11rXo8E1uGa1QCpxhg()) && str.endsWith(oZsklZMoFXu466Ro6PS7())) {
            return str.substring(1, str.length() - 1);
        }
        return (str.startsWith(QYKF2KYxGP4I3bUj()) && str.endsWith(IVnCUMzwYtDxDpQfgvnv2d())) ? str.substring(1, str.length() - 1) : str;
    }

    public List<ClanData> Fc3p9FhCjSD1k5Ra4(UUID uuid) {
        ArrayList arrayList = new ArrayList();
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            optionalIZTqZaRK5UGoe0Z.get().getRivalAlly().getRival().iterator().forEachRemaining(uuid2 -> {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z2 = iZTqZaRK5UGoe0Z(uuid2);
                if (optionalIZTqZaRK5UGoe0Z2.isPresent()) {
                    arrayList.add(optionalIZTqZaRK5UGoe0Z2.get());
                }
            });
        }
        return arrayList;
    }

    public List<ClanData> Nz8xKv4RePC2a0f0iuYU(UUID uuid) {
        ArrayList arrayList = new ArrayList();
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
            optionalIZTqZaRK5UGoe0Z.get().getRivalAlly().getAlly().iterator().forEachRemaining(uuid2 -> {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z2 = iZTqZaRK5UGoe0Z(uuid2);
                if (optionalIZTqZaRK5UGoe0Z2.isPresent()) {
                    arrayList.add(optionalIZTqZaRK5UGoe0Z2.get());
                }
            });
        }
        return arrayList;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, String str) {
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, mGJNfPKedBUd5w1nPgmeE(), Xsjnl6ykrnuGHm4j(), true)) {
            return false;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return false;
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getColorManager().jBUuLP0sWwaPyPOmogdX7l(str)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        String strZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
        if (strZJnaNCVQSgEShq.length() >= 255 || strZJnaNCVQSgEShq.length() > this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(UnqrslWMVLp5Ck()) || strZJnaNCVQSgEShq.length() < this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(nA22MQNaV72X8zbvmNQxDv())) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_LENGTH).replace(pLSmkmdw2W3UQ9MU1ZxEP(), String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(l7dUGl9IMSim0MivPydrT()))).replace(xLfSwAdu9JRIzSPs(), String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(xh6eexaoPQHqCx1U()))));
            return false;
        }
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).lGGwXL678c4Kv7skJb5NiE(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTag().equals(str)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_TAG_EQUALS));
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getClanManager().ZwrsrwOCXRUscW6Q(strZJnaNCVQSgEShq) && !optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTagNoColor().equals(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_TAG_IN_USE));
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(LKxwXAm2Qk5q146()).stream().filter(str2 -> {
            return str2.equalsIgnoreCase(strZJnaNCVQSgEShq);
        }).findFirst().isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_TAG_BLACKLIST));
            return false;
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), XbWaec0nxWDGgB())) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(fNhlUoTZ2TijCJE33K7u4()).size() > 0) {
            str = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().v8qP8fE86HMhvNuYPFjqY(str, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(epR4ykvRX5kSdSo()));
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(AiW7XzjZuC1slSeTL4SmW()).isEmpty() && !player.hasPermission(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(uCSndKmKC3dELbtRSsWvwv()))) {
            str = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
        }
        if (str.length() >= 254) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        if (new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(RVzqAMqva1avwpr()).getValue()), true)) {
            return this.v8qP8fE86HMhvNuYPFjqY.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR.get(), str, Optional.of(player));
        }
        return false;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(Player player, String str) {
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, Sg7Ng72MJl0Tv8YWCsT(), CMbTIcKoYBmoXgrFeU(), true)) {
            return false;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            return false;
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getColorManager().jBUuLP0sWwaPyPOmogdX7l(str)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        String strZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str.toString());
        if (strZJnaNCVQSgEShq.length() >= 255 || strZJnaNCVQSgEShq.length() > this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(B71lq2rtsRhkWIXP2Q()) || strZJnaNCVQSgEShq.length() < this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(n9oefRdDyO0Jto8LcSNY())) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_LENGTH).replace(hw0Zk7WBLRWcGaGH(), String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(ubYjzZnl1vu5iAbZb00C()))).replace(Jn9wZva0KlY4HmB9(), String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(guKHAaLC2i7MRpWekbNpzI()))));
            return false;
        }
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).o1VU1x4DAlrEtGKZ3jAdhE(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        String string = str.toString();
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(alfjozuDb8Gm7o()).size() > 0) {
            string = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().v8qP8fE86HMhvNuYPFjqY(string, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(A8VLGMUyQLX8KSUU()));
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(TZ2QFpJoB9JTcFJvMj3NqF()).isEmpty() && !player.hasPermission(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(dfBkNkHum8ihYgk()))) {
            string = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(string);
        }
        if (string.length() >= 254) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        if (new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(aC9gKadTBdvughCWQ()).getValue()), true)) {
            return this.v8qP8fE86HMhvNuYPFjqY.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR.get(), string.trim(), player);
        }
        return false;
    }

    public boolean ZwrsrwOCXRUscW6Q(Player player, String str) {
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, n3TLkpL9jpYbQtNW7ra(), n4mfJNIaivP5CFJIBnk9(), true)) {
            return false;
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getColorManager().jBUuLP0sWwaPyPOmogdX7l(str)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        String strZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
        if (strZJnaNCVQSgEShq.length() >= 255 || strZJnaNCVQSgEShq.length() > this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(Av18gfap3yGl208kQZqz()) || strZJnaNCVQSgEShq.length() < this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(WFaBZYtRFDeC4162Z8aR())) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_LENGTH).replace(UrHEHx782K0WV0L69K(), String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(fn9XinGQNGuTVUviYdLyo()))).replace(rOjhZDsdIhHn2VeOWXadOl(), String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getInt(eTKZvgBdRgwwzr()))));
            return false;
        }
        if (!new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).lGGwXL678c4Kv7skJb5NiE(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        if (ZwrsrwOCXRUscW6Q(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_TAG_IN_USE));
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(ukEgIQAuXKdzdSC()).stream().filter(str2 -> {
            return str2.equalsIgnoreCase(strZJnaNCVQSgEShq);
        }).findFirst().isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_TAG_BLACKLIST));
            return false;
        }
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(VdnkLanEOTRATCzi()).size() > 0) {
            str = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().v8qP8fE86HMhvNuYPFjqY(str, this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getStringList(iRTNwWC2laJO9s()));
        }
        if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(UopupxiWYHN9mGxRl()).isEmpty() && !player.hasPermission(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(JkcYtPyNyhDYFXc()))) {
            str = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
        }
        if (str.length() >= 254) {
            MessageUtils.sendText((CommandSender) player, this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(uYQQ9ZAdUZ8ttWAj()).getValue()), true)) {
            return this.v8qP8fE86HMhvNuYPFjqY.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, str, (String) null, jCurrentTimeMillis).isPresent();
        }
        return false;
    }

    public boolean iZTqZaRK5UGoe0Z(String str) {
        try {
            for (Map.Entry<Addon, AddonInfo> entry : this.v8qP8fE86HMhvNuYPFjqY.getAddonEnabledList().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(str) && entry.getValue().isEnabled()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean xtOheRiObl4QeAl(String str) {
        try {
            for (Map.Entry<Extension, Boolean> entry : this.v8qP8fE86HMhvNuYPFjqY.getExtensionEnabledList().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(str) && entry.getValue().booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean HX3ZfRb1nSpNq57s7x5ui(UUID uuid) {
        return ZwrsrwOCXRUscW6Q(uuid) && zJnaNCVQSgEShq().containsKey(uuid);
    }

    public Optional<RegroupInvite> IO1OGSMpoP1ZjOsbXi3a(UUID uuid) {
        return HX3ZfRb1nSpNq57s7x5ui(uuid) ? Optional.of(zJnaNCVQSgEShq().get(uuid)) : Optional.empty();
    }

    public boolean ZwrsrwOCXRUscW6Q(UUID uuid, String str) {
        try {
            Optional<JSONObject> optionalV8qP8fE86HMhvNuYPFjqY = new me.ulrich.clans.qjkRaOgynIj1.RuVgd0Dnv0ddhdcWL().v8qP8fE86HMhvNuYPFjqY((Object) str).v8qP8fE86HMhvNuYPFjqY();
            if (!optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                return false;
            }
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
            if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
                return false;
            }
            optionalIZTqZaRK5UGoe0Z.get().getSettings().setJsonMeta(optionalV8qP8fE86HMhvNuYPFjqY);
            jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(UUID uuid, JSONObject jSONObject) {
        try {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
            if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
                return false;
            }
            optionalIZTqZaRK5UGoe0Z.get().getSettings().setJsonMeta(Optional.of(jSONObject));
            jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<String> VkPRYe34Awk6AdSxoUC(UUID uuid) {
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
        return (optionalIZTqZaRK5UGoe0Z.isPresent() && optionalIZTqZaRK5UGoe0Z.get().getSettings().getJsonMeta().isPresent()) ? Optional.of(optionalIZTqZaRK5UGoe0Z.get().getSettings().getJsonMeta().get().toString()) : Optional.empty();
    }

    public ConcurrentHashMap<String, PlayerActions> xtOheRiObl4QeAl() {
        return this.iZTqZaRK5UGoe0Z;
    }

    public void v8qP8fE86HMhvNuYPFjqY(ConcurrentHashMap<String, PlayerActions> concurrentHashMap) {
        this.iZTqZaRK5UGoe0Z = concurrentHashMap;
    }

    public ConcurrentHashMap<UUID, RegroupInvite> zJnaNCVQSgEShq() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public ConcurrentHashMap<UUID, ClanData> CDW4Fj1iwdIXEOqWjiJSR() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public boolean b4i2FbOkaKeg91LiAe6l() {
        return this.zJnaNCVQSgEShq;
    }

    public Set<UUID> p31abtwfBag2jhMH6K() {
        return this.xtOheRiObl4QeAl;
    }

    public Clans Un3NRLL6aWivTcbodkcK() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String tgiUdtkJAzIImw18G(byte[] bArr) {
        return "";
    }

    private static String szhrWdRKt1WSyW() {
        return "none";
    }

    private static String X4Kpcrqu2OaRoNeWuSre() {
        return "Clan.verify.always_verified";
    }

    private static String A8MvxFFmEwkZU9() {
        return "Config.special_permissions.bypass_teleport";
    }

    private static String q9lV0Oi7B1dBOxVgsQkn() {
        return "Config.teleport_delay";
    }

    private static String pdpK0aHZ17fWvRAIoO0P() {
        return "Config.teleport_delay";
    }

    private static String oqHmPkKcU0WtQim() {
        return "teleportAsync";
    }

    private static String v0EBMaJKLgYiIX3dZtaE3() {
        return "teleportAsync did not return a CompletionStage";
    }

    private static String HwfAdXCj8LrysOQtI() {
        return "Regionized server has no usable teleportAsync";
    }

    private static String hLwH6JiiTdvQiGj45an8Pz() {
        return "folia";
    }

    private static String Ew9rp83Z1VOwyOgvn8x() {
        return "canvas";
    }

    private static String pq8kplcVqTJr39VPos03Sb() {
        return "Clan.unlocker.slots";
    }

    private static String jeHObNV1vLP0kIKAzlNyYE() {
        return ":";
    }

    private static String Ke1vrFHXWgbcv6c() {
        return "Clan.slots.default";
    }

    private static String XAT7mXlCmJv8WA1() {
        return "Clan.slots.default";
    }

    private static String LyA9Kw0rbooBiGx() {
        return "%uclans_player_uuid%";
    }

    private static String CJwfKVOn2VzdWAVx() {
        return "{uclans_player_uuid}";
    }

    private static String q11rXo8E1uGa1QCpxhg() {
        return "%";
    }

    private static String oZsklZMoFXu466Ro6PS7() {
        return "%";
    }

    private static String QYKF2KYxGP4I3bUj() {
        return "{";
    }

    private static String IVnCUMzwYtDxDpQfgvnv2d() {
        return "}";
    }

    private static String mGJNfPKedBUd5w1nPgmeE() {
        return "modtag";
    }

    private static String Xsjnl6ykrnuGHm4j() {
        return "clan";
    }

    private static String UnqrslWMVLp5Ck() {
        return "Clan.tag.max_chars";
    }

    private static String nA22MQNaV72X8zbvmNQxDv() {
        return "Clan.tag.min_chars";
    }

    private static String pLSmkmdw2W3UQ9MU1ZxEP() {
        return "%min%";
    }

    private static String l7dUGl9IMSim0MivPydrT() {
        return "Clan.tag.min_chars";
    }

    private static String xLfSwAdu9JRIzSPs() {
        return "%max%";
    }

    private static String xh6eexaoPQHqCx1U() {
        return "Clan.tag.max_chars";
    }

    private static String LKxwXAm2Qk5q146() {
        return "Clan.tag.blacklist";
    }

    private static String XbWaec0nxWDGgB() {
        return "MODTAG";
    }

    private static String fNhlUoTZ2TijCJE33K7u4() {
        return "Clan.tag.disabled_decoration";
    }

    private static String epR4ykvRX5kSdSo() {
        return "Clan.tag.disabled_decoration";
    }

    private static String AiW7XzjZuC1slSeTL4SmW() {
        return "Clan.tag.color_permission";
    }

    private static String uCSndKmKC3dELbtRSsWvwv() {
        return "Clan.tag.color_permission";
    }

    private static String RVzqAMqva1avwpr() {
        return "modtag";
    }

    private static String Sg7Ng72MJl0Tv8YWCsT() {
        return "desc";
    }

    private static String CMbTIcKoYBmoXgrFeU() {
        return "clan";
    }

    private static String B71lq2rtsRhkWIXP2Q() {
        return "Clan.desc.max_chars";
    }

    private static String n9oefRdDyO0Jto8LcSNY() {
        return "Clan.desc.min_chars";
    }

    private static String hw0Zk7WBLRWcGaGH() {
        return "%min%";
    }

    private static String ubYjzZnl1vu5iAbZb00C() {
        return "Clan.desc.min_chars";
    }

    private static String Jn9wZva0KlY4HmB9() {
        return "%max%";
    }

    private static String guKHAaLC2i7MRpWekbNpzI() {
        return "Clan.desc.max_chars";
    }

    private static String alfjozuDb8Gm7o() {
        return "Clan.desc.disabled_decoration";
    }

    private static String A8VLGMUyQLX8KSUU() {
        return "Clan.desc.disabled_decoration";
    }

    private static String TZ2QFpJoB9JTcFJvMj3NqF() {
        return "Clan.desc.color_permission";
    }

    private static String dfBkNkHum8ihYgk() {
        return "Clan.desc.color_permission";
    }

    private static String aC9gKadTBdvughCWQ() {
        return "desc";
    }

    private static String n3TLkpL9jpYbQtNW7ra() {
        return "create";
    }

    private static String n4mfJNIaivP5CFJIBnk9() {
        return "clan";
    }

    private static String Av18gfap3yGl208kQZqz() {
        return "Clan.tag.max_chars";
    }

    private static String WFaBZYtRFDeC4162Z8aR() {
        return "Clan.tag.min_chars";
    }

    private static String UrHEHx782K0WV0L69K() {
        return "%min%";
    }

    private static String fn9XinGQNGuTVUviYdLyo() {
        return "Clan.tag.min_chars";
    }

    private static String rOjhZDsdIhHn2VeOWXadOl() {
        return "%max%";
    }

    private static String eTKZvgBdRgwwzr() {
        return "Clan.tag.max_chars";
    }

    private static String ukEgIQAuXKdzdSC() {
        return "Clan.tag.blacklist";
    }

    private static String VdnkLanEOTRATCzi() {
        return "Clan.tag.disabled_decoration";
    }

    private static String iRTNwWC2laJO9s() {
        return "Clan.tag.disabled_decoration";
    }

    private static String UopupxiWYHN9mGxRl() {
        return "Clan.tag.color_permission";
    }

    private static String JkcYtPyNyhDYFXc() {
        return "Clan.tag.color_permission";
    }

    private static String uYQQ9ZAdUZ8ttWAj() {
        return "create";
    }

    private static String mzM9daMeSYhj8cHYD() {
        return "Clan.verify.list_unverified";
    }

    private static String kDtIkvT9cYd2IS5H3iG() {
        return "Clan.verify.list_unverified";
    }

    private static String bD9MNPIwWWGgxttGY5I() {
        return "player";
    }

    private static String Mj5J219fusRhJmfE() {
        return "server";
    }

    private static String hSdooUsj6HY1aG1m9JYd6o() {
        return "world";
    }

    private static String t7iNXfSkTWd9LJuQXUu5K() {
        return "x";
    }

    private static String aP4S7apiOZRCcSyF9PHV2k() {
        return "y";
    }

    private static String ta1F6qtd11idsM() {
        return "z";
    }

    private static String JqYF0uYpFvVDVEulD() {
        return "yaw";
    }

    private static String zeqElaRZmsOFLamqV8hz() {
        return "pitch";
    }

    private static String kAOwZmBIwYzejla9X8fTUf() {
        return "Clan teleport setup failed";
    }

    private static String fbujpBgNxdsBjab1w5() {
        return "Clan teleport failed";
    }

    private static String lWzZf9uEdayYxYtvt() {
        return "(%uclans_.+?%|\\{uclans_.+?\\})";
    }
}
