package me.ulrich.clans.manager;

import com.google.common.base.Stopwatch;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import javax.net.ssl.HttpsURLConnection;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ExtEvent;
import me.ulrich.clans.events.ModuleEvent;
import me.ulrich.clans.library.enumconfig.EnumConfiguration;
import me.ulrich.clans.library.enumconfig.EnumConfigurationBuilder;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.AdminGui;
import me.ulrich.clans.manager.EnumFiles.Chat;
import me.ulrich.clans.manager.EnumFiles.Commands;
import me.ulrich.clans.manager.EnumFiles.Config;
import me.ulrich.clans.manager.EnumFiles.Gui;
import me.ulrich.clans.manager.EnumFiles.Gui_Lang;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.EnumFiles.Moderation;
import me.ulrich.clans.manager.EnumFiles.Modules;
import me.ulrich.clans.manager.EnumFiles.Storage;
import me.ulrich.clans.manager.utils.FileDownloader;
import me.ulrich.clans.manager.utils.Files;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.VersionComparer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/KG0dzbdBSFtZuuPbyPn.class */
public class KG0dzbdBSFtZuuPbyPn {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private final ConcurrentHashMap<String, Files> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, EnumConfiguration> ZwrsrwOCXRUscW6Q = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, HashMap<String, EnumConfiguration>> iZTqZaRK5UGoe0Z = new ConcurrentHashMap<>();
    private static String vuqw41paayz4CE6nfaGu;
    private static String A2XsryTQ6V8h14;
    private static String ztUXTdFuS6e6Tm2j3py;
    private static volatile String JEcbc8kvGgScPNXD0JZ;
    private static String wmTw52FDpUTDYadQ2MfT9M;
    private static String aOD6iM8VS8ADVxh2AW;
    private static String xpceyacY5MWI8kRVJrp;
    private static String Tqxyzlt0AFRvhzxYIvux;
    private static volatile String BgssOtcdiB2YLU6e4gJquI;
    private static volatile String qVnFYy5zX6vD9Rt25r;
    private static String Xgm2DX22NhM216WXjJ6;
    private static volatile String WWYrHm64slH6VTDZ3svWY;
    private static String ADPztf54B7JyR4YMHYN7;
    private static volatile String GY7dEEFyrHpJq4;
    private static String KoWImDi0Ic8ah9;
    private static volatile String UKZghX2LYeoiuROWF4Lzw;
    private static String CGpaEF6yPvL08IRYgLt;
    private static volatile String f00HVP5FtYMhDUfyfvdy;
    private static String QnJcB8DCnrarVcHFgvb0;
    private static String ITH3ZpZWorTiU6Bm3s;
    private static volatile String Iw4sLqnhKdUQamCZC;
    private static String fjLFZaoAfiYbGXQkfC;
    private static volatile String Ndx2tKH48dyWU3pp;
    private static volatile String sALK1l1gP5FnnpCmnX;
    private static String XcR8oTG6hyIFZX0hGm;
    private static String f2QzOwgTXsPrxdWGQ;
    private static volatile String IX4pOZjiDf5e6K6;
    private static String uLpUaOgmcQMXR9EfAMXE3;
    private static String zI7APgiBaCf1Tj;
    private static volatile String DfupzJW1JrKauZR2v0;
    private static volatile String gawMO1Fl5uUEVtfJE7Ge;
    private static String cidtXrhHnuaoDmDds2a9ED;
    private static volatile String ZuRv4yMViLUpxgNoGbIHI9;
    private static volatile String hcTJymv32s4PZN8X5;
    private static volatile String ifkOseUvD6Ud7IRG0o2;
    private static volatile String Xa8ijQLZZo8KoUYiE;
    private static volatile String tnGbdGSjv4uWLPClKo;
    private static String YpI0WVFNg5eC3Tjhc6pEv;
    private static String Z0am0PaEBT9AZrwSitvY40;
    private static String iHr2cMedqksYX3ad;
    private static String s2T46aLtI6pACewIjrjyd6;
    private static volatile String AMnKVE9m3pB4VFSZj;
    private static String dLq2vmMbi9nOCcDLq7;
    private static String jVpr7LiZfxJfiU;
    private static String kc62YJDnmBxzeqNApoS;
    private static volatile String EAwhRutBY9Orve;
    private static String uwY7xTTw3zeGoRD;
    private static volatile String aICb8tsBKcNvpMDxv;
    private static volatile String ioBaYUZOHZxAeJSuWsm9F7;
    private static volatile String LN51jnOdOfVrdHlvIioQq9;
    private static String y6iU7oxk7YBWgQ5r;
    private static String vtPFlhcn9EzlS5t;
    private static String hcgLQYAyKkZRBXxqN3KT;
    private static String VWq4bj1PkRUu2nw2K2;
    private static String DEaCLcIw9X6It2fsc;
    private static volatile String WR08EISISLhHWd9iu6Z;
    private static volatile String bnts05mRuGHjWht;
    private static volatile String qCoKoJvtf6DQeHm0hr9bd;
    private static volatile String ue1X9dpKvU5cwV;
    private static volatile String QyQIPENO9dk6v36r;
    private static volatile String TIvEeG50mk00bc0lRNjQ;
    private static volatile String VLqAvEdaqoZIJMn;
    private static String oCKTz3r47KKmODdKDCg7;
    private static String EfW1aKoekgZtm4tuL1;
    private static volatile String h8N28Bq8VFjVW7MkPQ4;
    private static volatile String ocylVkhUVOuiyQdxU8;
    private static String bKrZ7fZkHuUOk3FYbLL9k8;
    private static volatile String ZWAiOFNvZGxKx1;
    private static String gL9oZaTYTYuYeAEhxP58;
    private static String c85niQT5nBB7SSwyCJxpI0;
    private static String POdB4daBgAIXqX3fD;
    private static volatile String DLs4LJrc1uIe95aewf;
    private static String U5cXBCpnpQjLZ8CWmPDA;
    private static String iGQgIFoGiLmSACiRkGHPih;
    private static volatile String FWyiNqpztiCONdBDlH;
    private static volatile String TEbAj3xY0RIAcWClupLy8H;
    private static volatile String h1TK1MYG7jeQ6ePLxXAJP;
    private static String gaIlW8jXB6yOSdn;
    private static String vATuz3JQlZjECxif;
    private static volatile String xVCjeSaAkyEjxD8wha;
    private static volatile String K0iHWjA9k51TpEk;
    private static String PSAgD8NFLwiZNxZghC;
    private static volatile String QjPaq0AXzaRjGkyyabwrQ;
    private static volatile String kD6phifwNKtWw8;
    private static String chC8wUkc3dLCkeWfjR;
    private static String Q7OuWZD9l0Jo3iaUR6Pv9N;
    private static String h8KOsVombCe2m6lXHZ;
    private static String alqUN3QFqdgs8Y;
    private static volatile String fBwaiDkwbCM4KCNBFg;
    private static String hTUVIgcodZczFPzV1NDcWo;
    private static String XAATGMs8DAWQAK57ojtFW9;
    private static volatile String kOmEbMwpBfnlg89t3NoP6;
    private static String vhupjo50b3oxs2FXJ6X;
    private static volatile String wLp0wLqAGH69ElNPEIm;
    private static String IS8UgysMUcIKkx2Sv8p;
    private static String tCaUDJx58jDrer2;
    private static volatile String YWJF2RfSEh0wdoyKZHD;
    private static String mwFWajhnZMj017;
    private static String Ji6WZ7cdZcJhRGxcY;
    private static String Qc62ZAxNrtvlOz2hDarMa;
    private static String HIGXskQeQ9U1ST;
    private static volatile String HwM3A06tQrOhJYa;
    private static volatile String ofkeswOsse4eo6OUA;
    private static String R3UT4w2AWeNO6Hf8ZBiNU0;
    private static volatile String if71cQMShhMwVbb8WK;
    private static final byte[] K3bwz7ofrUnGXrW1RL = {(byte) 218, (byte) 136, (byte) 232, (byte) 147, (byte) 106, (byte) 136, (byte) 164, (byte) 26, (byte) 105, (byte) 134, (byte) 220, (byte) 181, (byte) 84, (byte) 103, (byte) 204, (byte) 242};
    private static final byte[] qJSYtcac69YKL2Hen = {(byte) 88, (byte) 131, (byte) 252, (byte) 214, (byte) 72, (byte) 2, (byte) 149, (byte) 68, (byte) 177, (byte) 130, (byte) 3, (byte) 57, (byte) 184, (byte) 36, (byte) 203, (byte) 50};
    private static final byte[] z6IqJlMw82ogVp4zYrMoBh = {(byte) 108, (byte) 127, (byte) 3, (byte) 172, (byte) 133, (byte) 150, (byte) 92, (byte) 176, (byte) 230, (byte) 42, (byte) 141, (byte) 87, (byte) 31, (byte) 112, (byte) 192, (byte) 125};
    private static final byte[] GTdRSS0IJaXmfSS0oF = {(byte) 227, (byte) 241, (byte) 12, (byte) 32, (byte) 230, (byte) 228, (byte) 126, (byte) 180, (byte) 109, (byte) 128, (byte) 73, (byte) 135, (byte) 98, (byte) 80, (byte) 67, (byte) 0};
    private static final byte[] plYxWdwHr7Pa2Z95su8c6L = {(byte) 68, (byte) 254, (byte) 20, (byte) 98, (byte) 152, (byte) 207, (byte) 248, (byte) 224, (byte) 80, (byte) 63, (byte) 96, (byte) 84, (byte) 254, (byte) 249, (byte) 200, (byte) 253};
    private static final byte[] jdssSJB2x4uwvhayrOvN = {(byte) 224, (byte) 123, (byte) 182, (byte) 130, (byte) 157, (byte) 42, (byte) 182, (byte) 245, (byte) 89, (byte) 58, (byte) 240, (byte) 137, (byte) 23, (byte) 188, (byte) 167, (byte) 87};
    private static final byte[] oacA2kNwA3n1WT1Z = {(byte) 23, (byte) 176, (byte) 111, (byte) 197, (byte) 21, (byte) 109, (byte) 13, (byte) 112, (byte) 18, (byte) 137, (byte) 38, (byte) 158, (byte) 118, (byte) 134, (byte) 207, (byte) 94};
    private static final byte[] Qcx7OsQft7Foci50U = {(byte) 106, (byte) 239, (byte) 171, (byte) 29, (byte) 17, (byte) 87, (byte) 227, (byte) 132, (byte) 220, (byte) 20, (byte) 13, (byte) 197, (byte) 234, (byte) 56, (byte) 253, (byte) 227};
    private static final byte[] znigzgez7aPpOPGGcF = {(byte) 106, (byte) 239, (byte) 171, (byte) 29, (byte) 17, (byte) 87, (byte) 227, (byte) 132, (byte) 220, (byte) 20, (byte) 13, (byte) 197, (byte) 234, (byte) 56, (byte) 253, (byte) 227};
    private static final byte[] scWde0rqImFtCwDEuP = {(byte) 224, (byte) 123, (byte) 182, (byte) 130, (byte) 157, (byte) 42, (byte) 182, (byte) 245, (byte) 89, (byte) 58, (byte) 240, (byte) 137, (byte) 23, (byte) 188, (byte) 167, (byte) 87};
    private static final byte[] uqS35P1SrHfSQ1 = {(byte) 253, (byte) 47, (byte) 10, (byte) 96, (byte) 98, (byte) 125, (byte) 131, (byte) 97, (byte) 4, (byte) 139, (byte) 177, (byte) 225, (byte) 214, (byte) 36, (byte) 151, (byte) 242};
    private static final byte[] LMWEBOCptUqQfZvVN4w = {(byte) 3, (byte) 142, (byte) 233, (byte) 255, (byte) 95, (byte) 34, (byte) 248, (byte) 168, (byte) 200, (byte) 24, (byte) 11, (byte) 67, (byte) 238, (byte) 88, (byte) 107, (byte) 232};
    private static final byte[] kbhNZ9WQ7lv7g3bwvoz = {(byte) 226, (byte) 165, (byte) 8, (byte) 153, (byte) 57, (byte) 115, (byte) 205, (byte) 212, (byte) 250, (byte) 80, (byte) 109, (byte) 76, (byte) 172, (byte) 130, (byte) 25, (byte) 43};
    private static final byte[] iwpnnSpkGLKCsm2UU = {(byte) 31, (byte) 213, (byte) 98, (byte) 28, (byte) 144, (byte) 229, (byte) 35, (byte) 180, (byte) 154, (byte) 209, (byte) 248, (byte) 102, (byte) 252, (byte) 252, (byte) 160, (byte) 77, (byte) 212, (byte) 212, (byte) 165, (byte) 114, (byte) 132, (byte) 114, (byte) 207, (byte) 146, (byte) 88, (byte) 211, (byte) 142, (byte) 201, (byte) 20, (byte) 162, (byte) 172, (byte) 215};
    private static final byte[] zqlxeOLPrefenb6nAR1It = {(byte) 63, (byte) 170, (byte) 64, (byte) 100, (byte) 62, (byte) 51, (byte) 199, (byte) 106, (byte) 196, (byte) 118, (byte) 162, (byte) 228, (byte) 225, (byte) 67, (byte) 182, (byte) 192, (byte) 137, (byte) 91, (byte) 71, (byte) 0, (byte) 70, (byte) 120, (byte) 54, (byte) 181, (byte) 181, (byte) 153, (byte) 154, (byte) 140, (byte) 217, (byte) 41, (byte) 21, (byte) 180};
    private static final byte[] tX7atWTUX3GR5OdGPLir = {(byte) 63, (byte) 170, (byte) 64, (byte) 100, (byte) 62, (byte) 51, (byte) 199, (byte) 106, (byte) 196, (byte) 118, (byte) 162, (byte) 228, (byte) 225, (byte) 67, (byte) 182, (byte) 192, (byte) 137, (byte) 91, (byte) 71, (byte) 0, (byte) 70, (byte) 120, (byte) 54, (byte) 181, (byte) 181, (byte) 153, (byte) 154, (byte) 140, (byte) 217, (byte) 41, (byte) 21, (byte) 180};
    private static final byte[] h2k6PkhxxMSehh2nn = {(byte) 224, (byte) 123, (byte) 182, (byte) 130, (byte) 157, (byte) 42, (byte) 182, (byte) 245, (byte) 89, (byte) 58, (byte) 240, (byte) 137, (byte) 23, (byte) 188, (byte) 167, (byte) 87};
    private static final byte[] yyPi3ZzMZEe2HzI6ETR = {(byte) 230, (byte) 135, (byte) 234, (byte) 13, (byte) 159, (byte) 175, (byte) 172, (byte) 149, (byte) 236, (byte) 116, (byte) 208, (byte) 1, (byte) 179, (byte) 229, (byte) 249, (byte) 71};
    private static final byte[] xqfxHDOh9kpOy3a4bud09 = {(byte) 214, (byte) 114, (byte) 253, (byte) 187, (byte) 110, (byte) 2, (byte) 73, (byte) 78, (byte) 45, (byte) 212, (byte) 78, (byte) 245, (byte) 96, (byte) 51, (byte) 70, (byte) 244};
    private static final byte[] VznJaSl6lwHc2BO5B = {(byte) 168, (byte) 103, (byte) 20, (byte) 59, (byte) 18, (byte) 177, (byte) 147, (byte) 17, (byte) 129, (byte) 138, (byte) 234, (byte) 56, (byte) 157, (byte) 0, (byte) 78, (byte) 245};
    private static final byte[] jjMybZgVhdacjhWIUcP = {(byte) 15, (byte) 229, (byte) 161, (byte) 107, (byte) 12, (byte) 131, (byte) 168, (byte) 222, (byte) 26, (byte) 170, (byte) 51, (byte) 131, (byte) 92, (byte) 172, (byte) 241, (byte) 98};
    private static final byte[] Ephhl0Fat7Ei7taAf4X = {(byte) 106, (byte) 144, (byte) 147, (byte) 211, (byte) 140, (byte) 6, (byte) 45, (byte) 229, (byte) 93, (byte) 57, (byte) 109, (byte) 79, (byte) 115, (byte) 62, (byte) 67, (byte) 14};
    private static final byte[] OlgSB3nKXsM0UYcGspErLQ = {(byte) 152, (byte) 7, (byte) 197, (byte) 87, (byte) 149, (byte) 43, (byte) 153, (byte) 248, (byte) 144, (byte) 218, (byte) 2, (byte) 254, (byte) 176, (byte) 110, (byte) 26, (byte) 125};
    private static final byte[] FWoyQ43ONvn8FTIwX7 = {(byte) 167, (byte) 132, (byte) 37, (byte) 196, (byte) 102, (byte) 108, (byte) 124, (byte) 168, (byte) 173, (byte) 59, (byte) 28, (byte) 67, (byte) 136, (byte) 145, (byte) 10, (byte) 181};
    private static final byte[] SW3CzxTKTaQg3x = {(byte) 56, (byte) 85, (byte) 136, (byte) 210, (byte) 49, (byte) 69, (byte) 187, (byte) 137, (byte) 32, (byte) 80, (byte) 6, (byte) 211, (byte) 197, (byte) 237, (byte) 38, (byte) 226};
    private static final byte[] M6jiZbej765qch4 = {(byte) 226, (byte) 165, (byte) 8, (byte) 153, (byte) 57, (byte) 115, (byte) 205, (byte) 212, (byte) 250, (byte) 80, (byte) 109, (byte) 76, (byte) 172, (byte) 130, (byte) 25, (byte) 43};
    private static final byte[] O0RvflHJvbPfdmAzFE8 = {(byte) 226, (byte) 165, (byte) 8, (byte) 153, (byte) 57, (byte) 115, (byte) 205, (byte) 212, (byte) 250, (byte) 80, (byte) 109, (byte) 76, (byte) 172, (byte) 130, (byte) 25, (byte) 43};
    private static final byte[] ofhWrFfiEyqjjZjxg = {(byte) 205, (byte) 99, (byte) 148, (byte) 80, (byte) 156, (byte) 141, (byte) 123, (byte) 32, (byte) 229, (byte) 231, (byte) 254, (byte) 167, (byte) 178, (byte) 105, (byte) 190, (byte) 28};
    private static final byte[] lFmVfvXE7tsHaRkewy6 = {(byte) 224, (byte) 123, (byte) 182, (byte) 130, (byte) 157, (byte) 42, (byte) 182, (byte) 245, (byte) 89, (byte) 58, (byte) 240, (byte) 137, (byte) 23, (byte) 188, (byte) 167, (byte) 87};
    private static final byte[] mAfKNxzKkCWaQy0m2ylG = {(byte) 68, (byte) 203, (byte) 111, (byte) 17, (byte) 221, (byte) 132, (byte) 168, (byte) 7, (byte) 73, (byte) 133, (byte) 8, (byte) 61, (byte) 203, (byte) 132, (byte) 36, (byte) 99, (byte) 104, (byte) 190, (byte) 101, (byte) 73, (byte) 212, (byte) 169, (byte) 122, (byte) 51, (byte) 11, (byte) 243, (byte) 22, (byte) 212, (byte) 224, (byte) 232, (byte) 119, (byte) 40, (byte) 66, (byte) 48, (byte) 79, (byte) 95, (byte) 225, (byte) 47, (byte) 133, (byte) 205, (byte) 86, (byte) 157, (byte) 152, (byte) 211, (byte) 66, (byte) 218, (byte) 5, (byte) 183};
    private static final byte[] Uc9ep1ZuRdZv5sz = {(byte) 68, (byte) 203, (byte) 111, (byte) 17, (byte) 221, (byte) 132, (byte) 168, (byte) 7, (byte) 73, (byte) 133, (byte) 8, (byte) 61, (byte) 203, (byte) 132, (byte) 36, (byte) 99, (byte) 104, (byte) 190, (byte) 101, (byte) 73, (byte) 212, (byte) 169, (byte) 122, (byte) 51, (byte) 11, (byte) 243, (byte) 22, (byte) 212, (byte) 224, (byte) 232, (byte) 119, (byte) 40, (byte) 190, (byte) 53, (byte) 224, (byte) 61, (byte) 96, (byte) 19, (byte) 95, (byte) 45, (byte) 159, (byte) 49, (byte) 87, (byte) 93, (byte) 168, (byte) 104, (byte) 164, (byte) 13};
    private static final byte[] PtICBoauYf8d0ev = {(byte) 114, (byte) 121, (byte) 239, (byte) 93, (byte) 19, (byte) 126, (byte) 120, (byte) 197, (byte) 68, (byte) 87, (byte) 221, (byte) 89, (byte) 63, (byte) 1, (byte) 61, (byte) 251};
    private static final byte[] bowhkiazzS9hDI57w = {(byte) 205, (byte) 99, (byte) 148, (byte) 80, (byte) 156, (byte) 141, (byte) 123, (byte) 32, (byte) 229, (byte) 231, (byte) 254, (byte) 167, (byte) 178, (byte) 105, (byte) 190, (byte) 28};
    private static final byte[] VnlZ86S7YF60PgRj6nMXn = {(byte) 114, (byte) 121, (byte) 239, (byte) 93, (byte) 19, (byte) 126, (byte) 120, (byte) 197, (byte) 68, (byte) 87, (byte) 221, (byte) 89, (byte) 63, (byte) 1, (byte) 61, (byte) 251};
    private static final byte[] C0YDRcN8UUgJKb6vAuwVZ = {(byte) 114, (byte) 121, (byte) 239, (byte) 93, (byte) 19, (byte) 126, (byte) 120, (byte) 197, (byte) 68, (byte) 87, (byte) 221, (byte) 89, (byte) 63, (byte) 1, (byte) 61, (byte) 251};
    private static final byte[] NpXqEmv91nsv68W7 = {(byte) 193, (byte) 156, (byte) 86, (byte) 186, (byte) 147, (byte) 195, (byte) 115, (byte) 45, (byte) 218, (byte) 203, (byte) 237, (byte) 242, (byte) 121, (byte) 45, (byte) 170, (byte) 198};
    private static final byte[] JJ7opsEYB0H9vEf07 = {(byte) 3, (byte) 185, (byte) 168, (byte) 89, (byte) 179, (byte) 65, (byte) 217, (byte) 201, (byte) 220, (byte) 83, (byte) 202, (byte) 242, (byte) 93, (byte) 173, (byte) 172, (byte) 159};
    private static final byte[] gltnKnoqaK6Xy21 = {(byte) 33, (byte) 248, (byte) 64, (byte) 228, (byte) 141, (byte) 14, (byte) 66, (byte) 129, (byte) 66, (byte) 50, (byte) 166, (byte) 87, (byte) 99, (byte) 171, (byte) 115, (byte) 101};
    private static final byte[] FCcJaaUpS5CSVcjuMNK = {(byte) 100, (byte) 123, (byte) 97, (byte) 229, (byte) 133, (byte) 185, (byte) 117, (byte) 46, (byte) 94, (byte) 196, (byte) 27, (byte) 94, (byte) 159, (byte) 206, (byte) 34, (byte) 18};
    private static final byte[] n7lrPuwsjJ9axwG5ro29 = {(byte) 10, (byte) 75, (byte) 147, (byte) 55, (byte) 40, (byte) 69, (byte) 181, (byte) 211, (byte) 66, (byte) 120, (byte) 233, (byte) 157, (byte) 179, (byte) 161, (byte) 78, (byte) 254};
    private static final byte[] JqkJaV5gaa8ivnhMTk5leO = {(byte) 168, (byte) 103, (byte) 20, (byte) 59, (byte) 18, (byte) 177, (byte) 147, (byte) 17, (byte) 129, (byte) 138, (byte) 234, (byte) 56, (byte) 157, (byte) 0, (byte) 78, (byte) 245};
    private static final byte[] BmggJyrIOVAGjkDm0jyh = {(byte) 9, (byte) 142, (byte) 184, (byte) 135, (byte) 137, (byte) 173, (byte) 129, (byte) 236, (byte) 193, (byte) 168, (byte) 49, (byte) 192, (byte) 28, (byte) 185, (byte) 99, (byte) 1};
    private static final byte[] Au9yHQLN701G8pbkqb = {(byte) 117, (byte) 49, (byte) 131, (byte) 210, (byte) 192, (byte) 65, (byte) 7, (byte) 151, (byte) 185, (byte) 238, (byte) 246, (byte) 103, (byte) 190, (byte) 63, (byte) 236, (byte) 62};
    private static final byte[] L82AyAma4EgDJNecRgIlV = {(byte) 117, (byte) 49, (byte) 131, (byte) 210, (byte) 192, (byte) 65, (byte) 7, (byte) 151, (byte) 185, (byte) 238, (byte) 246, (byte) 103, (byte) 190, (byte) 63, (byte) 236, (byte) 62};
    private static final byte[] xY3fhwg2cqrmtmrTT16MA3 = {(byte) 117, (byte) 49, (byte) 131, (byte) 210, (byte) 192, (byte) 65, (byte) 7, (byte) 151, (byte) 185, (byte) 238, (byte) 246, (byte) 103, (byte) 190, (byte) 63, (byte) 236, (byte) 62};
    private static final byte[] xfMwJceBQhadg7FPe = {(byte) 224, (byte) 123, (byte) 182, (byte) 130, (byte) 157, (byte) 42, (byte) 182, (byte) 245, (byte) 89, (byte) 58, (byte) 240, (byte) 137, (byte) 23, (byte) 188, (byte) 167, (byte) 87};
    private static final byte[] YPAjQrkf6vE5Y0C3BuHU = {(byte) 214, (byte) 114, (byte) 253, (byte) 187, (byte) 110, (byte) 2, (byte) 73, (byte) 78, (byte) 45, (byte) 212, (byte) 78, (byte) 245, (byte) 96, (byte) 51, (byte) 70, (byte) 244};
    private static final byte[] iAqistR3yGVrbrILPjeq = {(byte) 9, (byte) 142, (byte) 184, (byte) 135, (byte) 137, (byte) 173, (byte) 129, (byte) 236, (byte) 193, (byte) 168, (byte) 49, (byte) 192, (byte) 28, (byte) 185, (byte) 99, (byte) 1};
    private static final byte[] qN6bT0dvW254alE = {(byte) 34, (byte) 245, (byte) 160, (byte) 36, (byte) 150, (byte) 16, (byte) 27, (byte) 24, (byte) 192, (byte) 0, (byte) 215, (byte) 235, (byte) 159, (byte) 32, (byte) 149, (byte) 196};
    private static final byte[] sd4gGLfObt0JFzI6E9GOGx = {(byte) 148, (byte) 72, (byte) 101, (byte) 2, (byte) 206, (byte) 51, (byte) 103, (byte) 33, (byte) 168, (byte) 35, (byte) 184, (byte) 133, (byte) 250, (byte) 0, (byte) 55, (byte) 92};
    private static final byte[] IMOdji6udlRW6B5WxB = {(byte) 62, (byte) 57, (byte) 45, (byte) 107, (byte) 150, (byte) 164, (byte) 224, (byte) 205, (byte) 149, (byte) 215, (byte) 153, (byte) 160, (byte) 28, (byte) 169, (byte) 20, (byte) 211, (byte) 13, (byte) 191, (byte) 162, (byte) 128, (byte) 205, (byte) 46, (byte) 135, (byte) 245, (byte) 156, (byte) 98, (byte) 50, (byte) 172, (byte) 139, (byte) 41, (byte) 231, (byte) 17, (byte) 127, (byte) 150, (byte) 61, (byte) 41, (byte) 53, (byte) 249, (byte) 10, (byte) 96, (byte) 40, (byte) 51, (byte) 22, (byte) 211, (byte) 88, (byte) 217, (byte) 86, (byte) 221, (byte) 31, (byte) 16, (byte) 137, (byte) 46, (byte) 55, (byte) 105, (byte) 129, (byte) 49, (byte) 162, (byte) 136, (byte) 32, (byte) 117, (byte) 162, (byte) 170, (byte) 250, (byte) 236, (byte) 11, (byte) 172, (byte) 200, (byte) 85, (byte) 123, (byte) 112, (byte) 20, (byte) 26, (byte) 198, (byte) 171, (byte) 166, (byte) 123, (byte) 74, (byte) 228, (byte) 117, (byte) 30};
    private static final byte[] HmR1wdBnM7k41mxNPRB = {(byte) 228, (byte) 242, (byte) 48, (byte) 108, (byte) 120, (byte) 159, (byte) 93, (byte) 5, (byte) 212, (byte) 247, (byte) 59, (byte) 143, (byte) 83, (byte) 28, (byte) 192, (byte) 222};
    private static final byte[] S3UPg3UvGmVIpRFqHa = {(byte) 153, (byte) 46, (byte) 45, (byte) 215, (byte) 143, (byte) 10, (byte) 91, (byte) 36, (byte) 202, (byte) 23, (byte) 138, (byte) 229, (byte) 164, (byte) 41, (byte) 210, (byte) 61};
    private static final byte[] E8ThBNkUFiM8Uy0Qo0u = {(byte) 51, (byte) 53, (byte) 151, (byte) 26, (byte) 76, (byte) 15, (byte) 4, (byte) 226, (byte) 213, (byte) 7, (byte) 211, (byte) 246, (byte) 230, (byte) 211, (byte) 0, (byte) 232, (byte) 196, (byte) 25, (byte) 190, (byte) 64, (byte) 99, (byte) 109, (byte) 189, (byte) 145, (byte) 212, (byte) 68, (byte) 32, (byte) 155, (byte) 73, (byte) 113, (byte) 58, (byte) 60};
    private static final byte[] HJbi97zp8OMJAJs4J = {(byte) 23, (byte) 121, (byte) 238, (byte) 236, (byte) 228, (byte) 89, (byte) 195, (byte) 113, (byte) 117, (byte) 51, (byte) 252, (byte) 113, (byte) 8, (byte) 191, (byte) 73, (byte) 90};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/KG0dzbdBSFtZuuPbyPn$Ijap9SQKkijXSxP5.class */
    private interface Ijap9SQKkijXSxP5 {
        Event create(CommandSender commandSender, ClanEnum.RepoReturn repoReturn, Stopwatch stopwatch, Object obj);
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/KG0dzbdBSFtZuuPbyPn$UsEbiuprSHpNw3qjITfH.class */
    public class UsEbiuprSHpNw3qjITfH {
        private String jBUuLP0sWwaPyPOmogdX7l;
        private EnumConfiguration ZwrsrwOCXRUscW6Q;
        private boolean iZTqZaRK5UGoe0Z;

        public UsEbiuprSHpNw3qjITfH(String str, EnumConfiguration enumConfiguration, boolean z) {
            v8qP8fE86HMhvNuYPFjqY(str);
            v8qP8fE86HMhvNuYPFjqY(enumConfiguration);
            v8qP8fE86HMhvNuYPFjqY(z);
        }

        public String v8qP8fE86HMhvNuYPFjqY() {
            return this.jBUuLP0sWwaPyPOmogdX7l;
        }

        public void v8qP8fE86HMhvNuYPFjqY(String str) {
            this.jBUuLP0sWwaPyPOmogdX7l = str;
        }

        public EnumConfiguration jBUuLP0sWwaPyPOmogdX7l() {
            return this.ZwrsrwOCXRUscW6Q;
        }

        public void v8qP8fE86HMhvNuYPFjqY(EnumConfiguration enumConfiguration) {
            this.ZwrsrwOCXRUscW6Q = enumConfiguration;
        }

        public boolean ZwrsrwOCXRUscW6Q() {
            return this.iZTqZaRK5UGoe0Z;
        }

        public void v8qP8fE86HMhvNuYPFjqY(boolean z) {
            this.iZTqZaRK5UGoe0Z = z;
        }
    }

    public KG0dzbdBSFtZuuPbyPn(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        v8qP8fE86HMhvNuYPFjqY();
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        this.jBUuLP0sWwaPyPOmogdX7l.clear();
        this.ZwrsrwOCXRUscW6Q.clear();
        this.iZTqZaRK5UGoe0Z.clear();
        ZPBcFhvCehdDEalmo();
        eHlgwCjkRE7V5J3Bm3h();
        OfIpR1Ys0fObQiw0avrIMa();
        oUXqAhcQIZ2jOE02XWODqg();
        jBUuLP0sWwaPyPOmogdX7l();
        ZwrsrwOCXRUscW6Q();
        iZTqZaRK5UGoe0Z();
    }

    private void OfIpR1Ys0fObQiw0avrIMa() {
        YamlConfiguration yamlConfigurationLoadConfiguration;
        ConfigurationSection configurationSection;
        File file = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), "gui.yml");
        File file2 = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), "admin_gui.yml");
        if (!file.exists() || file2.exists() || (configurationSection = (yamlConfigurationLoadConfiguration = YamlConfiguration.loadConfiguration(file)).getConfigurationSection(PXC8IUXrNFXRLxiYHjEwdr())) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : configurationSection.getKeys(false)) {
            if (str.toLowerCase(Locale.ROOT).startsWith(ItfQ4JI0lOsC6dbA())) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = "General." + ((String) it.next());
            ConfigurationSection configurationSection2 = yamlConfigurationLoadConfiguration.getConfigurationSection(str2);
            if (configurationSection2 != null) {
                for (String str3 : configurationSection2.getKeys(true)) {
                    if (!configurationSection2.isConfigurationSection(str3)) {
                        yamlConfiguration.set(str2 + "." + str3, configurationSection2.get(str3));
                    }
                }
            }
        }
        try {
            file2.getParentFile().mkdirs();
            yamlConfiguration.save(file2);
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().info(ef0haA0mujkqJdC());
        } catch (IOException e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning(nF27obVtSbHZYJ());
            e.printStackTrace();
        }
    }

    private void oUXqAhcQIZ2jOE02XWODqg() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(x6eUvJgMN4l6IFL(), Config.class);
        linkedHashMap.put(CONmpexuBc6iTsGCzqGoa(), Storage.class);
        linkedHashMap.put(G6gcHA4KkZ2Xv8BO3(), Commands.class);
        linkedHashMap.put(PHuTDfTalcyF0rdO(), Chat.class);
        linkedHashMap.put(JdC8drUTLgsUwY(), Moderation.class);
        linkedHashMap.put(AiPNrCZM44XaFMQ(), Gui.class);
        linkedHashMap.put(sxh1BHjT8dDs8Bw5(), AdminGui.class);
        linkedHashMap.put(HNmfKCBN2BmooXS97(), Modules.class);
        for (Map.Entry entry : (java.util.Set<Map.Entry>) linkedHashMap.entrySet()) {
            v8qP8fE86HMhvNuYPFjqY((String) entry.getKey(), (Class) entry.getValue());
        }
        this.v8qP8fE86HMhvNuYPFjqY.setTagpl(this.ZwrsrwOCXRUscW6Q.get(AxzzWm7qcEK5m7KA8Zp2rN()).getString(Config.CONFIG_tag));
        this.v8qP8fE86HMhvNuYPFjqY.setLanguage(this.ZwrsrwOCXRUscW6Q.get(dDkjhdbuxcBNUB896s1wG()).getString(Config.CONFIG_language));
        this.v8qP8fE86HMhvNuYPFjqY.setTimeZone(this.ZwrsrwOCXRUscW6Q.get(eTEYxD8Fmy62GkeiGoVw()).getString(Config.CONFIG_timezone));
    }

    private void v8qP8fE86HMhvNuYPFjqY(String str, Class cls) {
        this.ZwrsrwOCXRUscW6Q.put(str, new EnumConfigurationBuilder(new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), str + ".yml"), cls).build(this.v8qP8fE86HMhvNuYPFjqY.getTagpl()));
    }

    public void jBUuLP0sWwaPyPOmogdX7l() {
        for (String str : new String[]{lBmEO7UFazyAgvYhVc(), eResDi2l2li2ii(), GgPURIK5AeHMDY(), r8WsYArVgU61dxt(), OuAlxNHor1qdq0M(), DtxCCsQFb5bJqDcnXE(), Q588RnWlMiLVk0rkeu(), dP6wmYd34F1Ofz3WiDaxGz()}) {
            this.jBUuLP0sWwaPyPOmogdX7l.put(str, new Files(this.v8qP8fE86HMhvNuYPFjqY, this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), "", str, str, "yml"));
        }
    }

    public void ZwrsrwOCXRUscW6Q() {
        for (String str : new String[]{tVkESCCYmXWWaYYkpIiE(), joKuqaUxHJqkiPc6pH5O5b(), yalXUqyvGhiiykJhQ(), VBZTgeqXqt76cRnR(), venzPBfhRG1U0vjJXyx2(), cGpAUw9eMFluA7()}) {
            this.jBUuLP0sWwaPyPOmogdX7l.put(str, new Files(this.v8qP8fE86HMhvNuYPFjqY, this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), XdtFsJ5CUk9WMLDYfFUR(), str, "storage/yaml/" + str, "yml"));
        }
    }

    public void iZTqZaRK5UGoe0Z() {
        for (ClanEnum.ClanLangs clanLangs : ClanEnum.ClanLangs.values()) {
            for (String str : new String[]{GlX7I2InHByfZeA(), eUgCPj5yRLSE1UCb()}) {
                if (!new File(String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder()) + File.separator + "language", str + String.valueOf(clanLangs) + ".yml").exists()) {
                    new Files(this.v8qP8fE86HMhvNuYPFjqY, this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), pcW80AZxpsqnj4UXKLB(), str + String.valueOf(clanLangs), "language/" + str + String.valueOf(clanLangs), "yml");
                }
            }
        }
        File file = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), K97AoMymNEdL4V8HJG1());
        if (file.exists()) {
            HashMap<String, EnumConfiguration> map = new HashMap<>();
            HashMap<String, EnumConfiguration> map2 = new HashMap<>();
            File[] fileArrListFiles = file.listFiles((file2, str2) -> {
                return str2.endsWith(".yml");
            });
            if (fileArrListFiles != null) {
                for (File file3 : fileArrListFiles) {
                    if (file3.getName().startsWith(Mi0yemCets75oX())) {
                        map.put(file3.getName().replace(ihS3UJgdoRKdZ8sSPjaIwz(), "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Lang.class).build(this.v8qP8fE86HMhvNuYPFjqY.getTagpl()));
                    } else if (file3.getName().startsWith(jGMD1YodFkEcGjMfvv())) {
                        map2.put(file3.getName().replace(P1F98uPZ1YWpDM(), "").replace(".yml", "").toUpperCase(), new EnumConfigurationBuilder(file3, Gui_Lang.class).build(this.v8qP8fE86HMhvNuYPFjqY.getTagpl()));
                    }
                }
            }
            this.iZTqZaRK5UGoe0Z.put(PpECEY6emLQMieN2za(), map);
            this.iZTqZaRK5UGoe0Z.put(Tazv5WN1jyZDUfIMAZ033b(), map2);
            TreeSet<String> treeSet = new TreeSet();
            treeSet.addAll(map.keySet());
            treeSet.addAll(map2.keySet());
            for (String str3 : treeSet) {
                boolean zContainsKey = map.containsKey(str3);
                if (zContainsKey != map2.containsKey(str3)) {
                    this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Language '" + str3 + "' is incomplete and will not be available. Missing " + (zContainsKey ? yfjReVEMv5LizDn2() : oUhAyTmBuqmYBoZNtHMA()) + str3 + ".yml.");
                }
            }
            List<String> listHqTnbBoUmxDUXvki = hqTnbBoUmxDUXvki();
            String language = this.v8qP8fE86HMhvNuYPFjqY.getLanguage();
            String upperCase = language != null ? language.trim().toUpperCase(Locale.ROOT) : "";
            if (listHqTnbBoUmxDUXvki.contains(upperCase)) {
                this.v8qP8fE86HMhvNuYPFjqY.setLanguage(upperCase);
                this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Using default: " + upperCase);
            } else {
                String string = listHqTnbBoUmxDUXvki.contains(ClanEnum.ClanLangs.EN.toString()) ? ClanEnum.ClanLangs.EN.toString() : listHqTnbBoUmxDUXvki.stream().findFirst().orElse(ClanEnum.ClanLangs.EN.toString());
                this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("The language '" + language + "' set in config.yml is not fully loaded. Using '" + string + "'.");
                this.v8qP8fE86HMhvNuYPFjqY.setLanguage(string);
            }
        }
    }

    public CompletableFuture<Boolean> v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender, ClanEnum.ClansExtensions clansExtensions, boolean z, boolean z2) {
        if (Bukkit.getPluginManager().isPluginEnabled(clansExtensions.getPluginName())) {
            return v8qP8fE86HMhvNuYPFjqY(commandSender, clansExtensions.getPluginName(), clansExtensions.toString(), WUbHdHulSkjtVMVeG3pt(), AmyYSfFCw4pZrON7nj(), (commandSender2, repoReturn, stopwatch, obj) -> {
                return new ExtEvent(commandSender2, repoReturn, stopwatch, (ClanEnum.ClansExtensions) obj);
            }, z, z2, clansExtensions);
        }
        MessageUtils.sendText(commandSender, v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REPO_MISSING_DEPENDENCY, Arrays.asList("{plugin};" + clansExtensions.getPluginName())));
        return CompletableFuture.completedFuture(false);
    }

    public CompletableFuture<Boolean> v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender, ClanEnum.ClansModules clansModules, boolean z, boolean z2) {
        return v8qP8fE86HMhvNuYPFjqY(commandSender, clansModules.getPluginName(), clansModules.toString(), ovf9qoAUR3B6Zizl(), UALo4jaWcTjSaYmzxFb(), (commandSender2, repoReturn, stopwatch, obj) -> {
            return new ModuleEvent(commandSender2, repoReturn, stopwatch, (ClanEnum.ClansModules) obj);
        }, z, z2, clansModules);
    }

    private CompletableFuture<Boolean> v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender, String str, String str2, String str3, String str4, Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5, boolean z, boolean z2, Object obj) {
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
            String str5;
            Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
            File file = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), str4);
            File file2 = new File(file, str2 + ".jar");
            try {
                String resourceUid = Clans.getClanCore().getResourceUid();
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                String strJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(resourceUid + ":" + jCurrentTimeMillis + "uclans_v9_8f3a2c91d4e7f6b1_internal_secure_key");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str3 + "/latest.php?repo=ultimateclans&id=" + str2.toLowerCase()).openConnection();
                httpsURLConnection.setRequestMethod(M1RxjV0CCbSpT28qv18l());
                httpsURLConnection.setRequestProperty(cipkYVFzTDtL7MIcmLwd(), "UltimateClans/" + this.v8qP8fE86HMhvNuYPFjqY.getDescription().getVersion());
                httpsURLConnection.setRequestProperty(H1mIf5HmpsP1vfgp(), resourceUid);
                httpsURLConnection.setRequestProperty(g69OO7YxRDuNeA6LK8(), String.valueOf(jCurrentTimeMillis));
                httpsURLConnection.setRequestProperty(c0mpn4QQMJ0uGkS3pe(), strJBUuLP0sWwaPyPOmogdX7l);
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.setDoInput(true);
                int responseCode = -1;
                int i = 0;
                while (i < 2 && responseCode == -1) {
                    try {
                        responseCode = httpsURLConnection.getResponseCode();
                    } catch (SocketTimeoutException e) {
                        i++;
                        if (i >= 2) {
                            throw e;
                        }
                        Thread.sleep(1000L);
                    }
                }
                if (responseCode != 200) {
                    Clans.getClanCore().getLogger().warning(str + " returned: " + responseCode);
                    v8qP8fE86HMhvNuYPFjqY(() -> {
                        Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.ERROR_REPO, stopwatchCreateStarted, null));
                    });
                    completableFuture.complete(false);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                    v8qP8fE86HMhvNuYPFjqY(() -> {
                        Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.GENERAL_ERROR, stopwatchCreateStarted, null));
                    });
                    completableFuture.complete(false);
                }
                bufferedReader.close();
                JSONObject jSONObject = new JSONObject(sb.toString());
                pGGdmcr5DM7xU9lcJ();
                if (str4.equalsIgnoreCase(OqqUVQeBtJwOM3TJh())) {
                    str5 = (String) Optional.ofNullable(new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(str2)).map(entry -> {
                        return ((Extension) entry.getKey()).getVersion();
                    }).orElse(AbXWOh8cZxZ2IFuT());
                } else {
                    if (!str4.equalsIgnoreCase(gEq8xeLgYzY8plS1hzHi())) {
                        v8qP8fE86HMhvNuYPFjqY(() -> {
                            Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.GENERAL_ERROR, stopwatchCreateStarted, null));
                        });
                        completableFuture.complete(false);
                        return;
                    }
                    str5 = (String) Optional.ofNullable(new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).iZTqZaRK5UGoe0Z(str2)).map(entry2 -> {
                        return ((Module) entry2.getKey()).getVersion();
                    }).orElse(QelFO96M6CFTO5O());
                }
                if (new VersionComparer(jSONObject.getString(Pdz1yPCRMWuYZ0G3w())).compareTo(new VersionComparer(str5)) > 0 || z) {
                    File file3 = new File(file, jSONObject.optString(ScOJoDOOjSOgJEfCX50(), str2.toLowerCase() + ".jar"));
                    new FileDownloader().onSuccess(() -> {
                        try {
                            v8qP8fE86HMhvNuYPFjqY(file3, file2);
                            file3.delete();
                            if (z2) {
                                v8qP8fE86HMhvNuYPFjqY(() -> {
                                    Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.SUCCESS_DOWNLOAD, stopwatchCreateStarted, obj));
                                });
                            } else {
                                v8qP8fE86HMhvNuYPFjqY(() -> {
                                    Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.SUCCESS_DOWNLOAD_RELOAD, stopwatchCreateStarted, obj));
                                });
                            }
                            completableFuture.complete(true);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            completableFuture.complete(false);
                        }
                    }).onFailure(() -> {
                        v8qP8fE86HMhvNuYPFjqY(() -> {
                            Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.ERROR_DOWNLOAD, stopwatchCreateStarted, obj));
                        });
                        completableFuture.complete(false);
                    }).downloadUsingLocale(this.v8qP8fE86HMhvNuYPFjqY, str3 + "/download.php?token=" + jSONObject.getString(Ed9XnuCTtypGpYpZKs0QBQ()), file3.getPath());
                } else {
                    if (!z2) {
                        v8qP8fE86HMhvNuYPFjqY(() -> {
                            Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.ALREADY_UPDATED, stopwatchCreateStarted, null));
                        });
                    }
                    completableFuture.complete(false);
                }
            } catch (Exception e2) {
                v8qP8fE86HMhvNuYPFjqY(() -> {
                    Bukkit.getPluginManager().callEvent(ijap9SQKkijXSxP5.create(commandSender, ClanEnum.RepoReturn.GENERAL_ERROR, stopwatchCreateStarted, null));
                });
                completableFuture.complete(false);
            }
        });
        return completableFuture;
    }

    public FileConfiguration v8qP8fE86HMhvNuYPFjqY(String str) {
        if (this.jBUuLP0sWwaPyPOmogdX7l.containsKey(str)) {
            return this.jBUuLP0sWwaPyPOmogdX7l.get(str).get();
        }
        return null;
    }

    public EnumConfiguration v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender) {
        return commandSender instanceof Player ? jBUuLP0sWwaPyPOmogdX7l(Optional.of(((Player) commandSender).getUniqueId())) : jBUuLP0sWwaPyPOmogdX7l(Optional.empty());
    }

    public EnumConfiguration xtOheRiObl4QeAl() {
        return jBUuLP0sWwaPyPOmogdX7l(Optional.empty());
    }

    public String v8qP8fE86HMhvNuYPFjqY(Optional<UUID> optional) {
        return v8qP8fE86HMhvNuYPFjqY(optional, hqTnbBoUmxDUXvki());
    }

    public EnumConfiguration jBUuLP0sWwaPyPOmogdX7l(Optional<UUID> optional) {
        HashMap<String, EnumConfiguration> map = this.iZTqZaRK5UGoe0Z.get(VYQZQyxzpFUisQbL());
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(v8qP8fE86HMhvNuYPFjqY(optional, hqTnbBoUmxDUXvki()));
    }

    private String v8qP8fE86HMhvNuYPFjqY(Optional<UUID> optional, Collection<String> collection) {
        String language = this.v8qP8fE86HMhvNuYPFjqY.getLanguage();
        if (language == null || language.trim().isEmpty()) {
            language = ClanEnum.ClanLangs.EN.toString();
        }
        String lang = language;
        if (optional != null && optional.isPresent()) {
            try {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(optional.get());
                if (optionalP31abtwfBag2jhMH6K.isPresent() && optionalP31abtwfBag2jhMH6K.get().getLang() != null && !optionalP31abtwfBag2jhMH6K.get().getLang().trim().isEmpty()) {
                    lang = optionalP31abtwfBag2jhMH6K.get().getLang();
                }
            } catch (Exception e) {
            }
        }
        String upperCase = lang.toUpperCase(Locale.ROOT);
        if (collection.contains(upperCase)) {
            return upperCase;
        }
        String upperCase2 = language.toUpperCase(Locale.ROOT);
        if (collection.contains(upperCase2)) {
            return upperCase2;
        }
        return collection.contains(Cls5urNuK3jgTpmL()) ? F8tKEsgMvOsQaE6Jx56E() : collection.stream().findFirst().orElse(upperCase2);
    }

    private void v8qP8fE86HMhvNuYPFjqY(Runnable runnable) {
        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(runnable);
    }

    public static String jBUuLP0sWwaPyPOmogdX7l(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(D8LcxTXIcSlDdkHwJ7pUGY()).digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format(CUHImPEUaMxgdA657f1Zt(), Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void v8qP8fE86HMhvNuYPFjqY(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileInputStream.transferTo(fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileInputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public KG0dzbdBSFtZuuPbyPn zJnaNCVQSgEShq() {
        return this;
    }

    public ConcurrentHashMap<String, EnumConfiguration> CDW4Fj1iwdIXEOqWjiJSR() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public ConcurrentHashMap<String, Files> b4i2FbOkaKeg91LiAe6l() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public FileConfiguration p31abtwfBag2jhMH6K() {
        return b4i2FbOkaKeg91LiAe6l().get(vCTRHgbVXuNOnNkg8Woz()).get();
    }

    public FileConfiguration Un3NRLL6aWivTcbodkcK() {
        return b4i2FbOkaKeg91LiAe6l().get(KMGz5Tre6cXfVty()).get();
    }

    public FileConfiguration lGGwXL678c4Kv7skJb5NiE() {
        return b4i2FbOkaKeg91LiAe6l().get(CGrSUUHdUNPcyM7G()).get();
    }

    public FileConfiguration o1VU1x4DAlrEtGKZ3jAdhE() {
        return b4i2FbOkaKeg91LiAe6l().get(lGCrAQwLmTcamYdPD7ZONf()).get();
    }

    public FileConfiguration vVo2VUvxrriklPdRxI() {
        return b4i2FbOkaKeg91LiAe6l().get(XyYTVwffUnhyP7Hr()).get();
    }

    public FileConfiguration Fc3p9FhCjSD1k5Ra4() {
        return b4i2FbOkaKeg91LiAe6l().get(xA5YwkjswslUMnqafay9()).get();
    }

    public FileConfiguration Nz8xKv4RePC2a0f0iuYU() {
        return b4i2FbOkaKeg91LiAe6l().get(E7AQj1pJs7UIX2YZ9O()).get();
    }

    public FileConfiguration HX3ZfRb1nSpNq57s7x5ui() {
        return b4i2FbOkaKeg91LiAe6l().get(P5DKhfsJ236GPw7qVxLesb()).get();
    }

    public FileConfiguration IO1OGSMpoP1ZjOsbXi3a() {
        return b4i2FbOkaKeg91LiAe6l().get(kMiYM4qyWrIUxbzToRE()).get();
    }

    public FileConfiguration VkPRYe34Awk6AdSxoUC() {
        return b4i2FbOkaKeg91LiAe6l().get(UkmK6ioQ3KXhAS()).get();
    }

    public FileConfiguration QXoNfOxIPaPrSlQMNR() {
        return b4i2FbOkaKeg91LiAe6l().get(QERRSqZq9SMJppPbkA8f3Y()).get();
    }

    public FileConfiguration V3DAV3orG0so43Del8NdO() {
        return b4i2FbOkaKeg91LiAe6l().get(lbcMsqftgLkfGKmp()).get();
    }

    public FileConfiguration Y9J1Kd6E1T8FcF() {
        return b4i2FbOkaKeg91LiAe6l().get(JJeV7qEAzEkhpmg()).get();
    }

    public FileConfiguration MoSLgFbw3mkSoqkObMHJ4() {
        return b4i2FbOkaKeg91LiAe6l().get(ilxUNWbYK1mAuaXRuSR0aI()).get();
    }

    public ConcurrentHashMap<String, HashMap<String, EnumConfiguration>> GDU5Y0ildSLo4mliJ() {
        return this.iZTqZaRK5UGoe0Z;
    }

    public List<String> hqTnbBoUmxDUXvki() {
        HashMap<String, EnumConfiguration> map = this.iZTqZaRK5UGoe0Z.get(iTu0zstoPiaL4TVcSiq6());
        HashMap<String, EnumConfiguration> map2 = this.iZTqZaRK5UGoe0Z.get(vJOJdq4bXlPuf4wmykx());
        if (map == null || map2 == null || map.isEmpty() || map2.isEmpty()) {
            return Collections.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ClanEnum.ClanLangs clanLangs : ClanEnum.ClanLangs.values()) {
            String upperCase = clanLangs.toString().toUpperCase(Locale.ROOT);
            if (map.containsKey(upperCase) && map2.containsKey(upperCase)) {
                linkedHashSet.add(upperCase);
            }
        }
        TreeSet treeSet = new TreeSet();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String upperCase2 = it.next().toUpperCase(Locale.ROOT);
            if (map2.containsKey(upperCase2) && !linkedHashSet.contains(upperCase2)) {
                treeSet.add(upperCase2);
            }
        }
        linkedHashSet.addAll(treeSet);
        return new ArrayList(linkedHashSet);
    }

    public HashMap<String, GuiData> v8qP8fE86HMhvNuYPFjqY(Player player) {
        ConcurrentHashMap<String, HashMap<String, GuiData>> concurrentHashMapNz8xKv4RePC2a0f0iuYU = this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().Nz8xKv4RePC2a0f0iuYU();
        if (concurrentHashMapNz8xKv4RePC2a0f0iuYU == null || concurrentHashMapNz8xKv4RePC2a0f0iuYU.isEmpty()) {
            return new HashMap<>();
        }
        HashMap<String, GuiData> map = concurrentHashMapNz8xKv4RePC2a0f0iuYU.get(v8qP8fE86HMhvNuYPFjqY(player != null ? Optional.of(player.getUniqueId()) : Optional.empty(), concurrentHashMapNz8xKv4RePC2a0f0iuYU.keySet()));
        if (map != null) {
            return map;
        }
        HashMap<String, GuiData> map2 = concurrentHashMapNz8xKv4RePC2a0f0iuYU.get(FuqxILWZU5i8FU());
        return map2 != null ? map2 : concurrentHashMapNz8xKv4RePC2a0f0iuYU.values().stream().findFirst().orElseGet(HashMap::new);
    }

    public UsEbiuprSHpNw3qjITfH ZwrsrwOCXRUscW6Q(String str) {
        HashMap<String, EnumConfiguration> map = this.iZTqZaRK5UGoe0Z.get(KHvrq6RTXiaCJQ7OLj6());
        if (map == null || map.isEmpty()) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning(PeMtxCfrYZ4DcYRf());
            return new UsEbiuprSHpNw3qjITfH(Wkg4gG7AdW2q3A3t(), null, false);
        }
        String upperCase = str.toUpperCase();
        boolean zContainsKey = map.containsKey(upperCase);
        return new UsEbiuprSHpNw3qjITfH(zContainsKey ? upperCase : ae4cDFQ5acUO6J2R9x(), map.getOrDefault(upperCase, map.get(GVdFbpXvNxTmDTBp7mo1r())), zContainsKey);
    }

    public static File gvy0NoTzHY6bC7eAY() {
        File file = new File(JavaPlugin.getProvidingPlugin(KG0dzbdBSFtZuuPbyPn.class).getDataFolder(), KucbHHDKcQaKNXy());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void eHlgwCjkRE7V5J3Bm3h() {
        File file = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), hndkOD5KSxDyHp5());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            JarFile jarFile = new JarFile(new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()));
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    String name = jarEntryNextElement.getName();
                    if (name.startsWith(jycZuTy9eifhOEOsW4p4rt()) && name.endsWith(sULVrDKfKtgX04Ikl()) && !jarEntryNextElement.isDirectory()) {
                        String strSubstring = name.substring(name.lastIndexOf(47) + 1);
                        File file2 = new File(file, strSubstring);
                        if (file2.exists()) {
                            String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(jarFile, jarEntryNextElement);
                            String strV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(file2);
                            if (strV8qP8fE86HMhvNuYPFjqY == null) {
                                this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Unable to read bundled extension version: " + strSubstring);
                            } else if (strV8qP8fE86HMhvNuYPFjqY2 == null) {
                                InputStream inputStream = jarFile.getInputStream(jarEntryNextElement);
                                try {
                                    java.nio.file.Files.copy(inputStream, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                    this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Extension repaired/updated: " + strSubstring + " -> " + strV8qP8fE86HMhvNuYPFjqY);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Throwable th) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } else if (v8qP8fE86HMhvNuYPFjqY(strV8qP8fE86HMhvNuYPFjqY, strV8qP8fE86HMhvNuYPFjqY2) > 0) {
                                InputStream inputStream2 = jarFile.getInputStream(jarEntryNextElement);
                                try {
                                    java.nio.file.Files.copy(inputStream2, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                    this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Extension updated: " + strSubstring + " (" + strV8qP8fE86HMhvNuYPFjqY2 + " -> " + strV8qP8fE86HMhvNuYPFjqY + ")");
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                } catch (Throwable th3) {
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                        }
                                    }
                                    throw th3;
                                }
                            }
                        } else {
                            InputStream inputStream3 = jarFile.getInputStream(jarEntryNextElement);
                            try {
                                java.nio.file.Files.copy(inputStream3, file2.toPath(), new CopyOption[0]);
                                this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Extension extracted: " + strSubstring);
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                }
                            } catch (Throwable th5) {
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable th6) {
                                        th5.addSuppressed(th6);
                                    }
                                }
                                throw th5;
                            }
                        }
                    }
                }
                jarFile.close();
            } catch (Throwable th7) {
                try {
                    jarFile.close();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
                throw th7;
            }
        } catch (Exception e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning(A8JU8HQxylIpJZ0umqX());
            e.printStackTrace();
        }
    }

    private void ZPBcFhvCehdDEalmo() {
        File file = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), JYKne08K7ZFXyjFRl());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            JarFile jarFile = new JarFile(new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()));
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    String name = jarEntryNextElement.getName();
                    if (name.startsWith(uzaK80zLbRHzEweYextLmT()) && name.endsWith(Ov4HOemudY3sEarO6B54()) && !jarEntryNextElement.isDirectory()) {
                        String strSubstring = name.substring(name.lastIndexOf(47) + 1);
                        File file2 = new File(file, strSubstring);
                        if (file2.exists()) {
                            String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(jarFile, jarEntryNextElement);
                            String strV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(file2);
                            if (strV8qP8fE86HMhvNuYPFjqY == null) {
                                this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Unable to read bundled module version: " + strSubstring);
                            } else if (strV8qP8fE86HMhvNuYPFjqY2 == null) {
                                InputStream inputStream = jarFile.getInputStream(jarEntryNextElement);
                                try {
                                    java.nio.file.Files.copy(inputStream, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                    this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Module repaired/updated: " + strSubstring + " -> " + strV8qP8fE86HMhvNuYPFjqY);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Throwable th) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } else if (v8qP8fE86HMhvNuYPFjqY(strV8qP8fE86HMhvNuYPFjqY, strV8qP8fE86HMhvNuYPFjqY2) > 0) {
                                InputStream inputStream2 = jarFile.getInputStream(jarEntryNextElement);
                                try {
                                    java.nio.file.Files.copy(inputStream2, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                    this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Module updated: " + strSubstring + " (" + strV8qP8fE86HMhvNuYPFjqY2 + " -> " + strV8qP8fE86HMhvNuYPFjqY + ")");
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                } catch (Throwable th3) {
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                        }
                                    }
                                    throw th3;
                                }
                            }
                        } else {
                            InputStream inputStream3 = jarFile.getInputStream(jarEntryNextElement);
                            try {
                                java.nio.file.Files.copy(inputStream3, file2.toPath(), new CopyOption[0]);
                                this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Module extracted: " + strSubstring);
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                }
                            } catch (Throwable th5) {
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Throwable th6) {
                                        th5.addSuppressed(th6);
                                    }
                                }
                                throw th5;
                            }
                        }
                    }
                }
                jarFile.close();
            } catch (Throwable th7) {
                try {
                    jarFile.close();
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                }
                throw th7;
            }
        } catch (Exception e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning(J9c3PkS4DYng1vkk7());
            e.printStackTrace();
        }
    }

    private String v8qP8fE86HMhvNuYPFjqY(JarFile jarFile, JarEntry jarEntry) {
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            try {
                JarInputStream jarInputStream = new JarInputStream(inputStream);
                while (true) {
                    try {
                        JarEntry nextJarEntry = jarInputStream.getNextJarEntry();
                        if (nextJarEntry == null) {
                            jarInputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return null;
                        }
                        if (!nextJarEntry.isDirectory() && nextJarEntry.getName().equalsIgnoreCase("Plugin.properties")) {
                            Properties properties = new Properties();
                            properties.load(jarInputStream);
                            String property = properties.getProperty(KeIMkvWSGQ50NKruDPmR());
                            String strTrim = property != null ? property.trim() : null;
                            jarInputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return strTrim;
                        }
                    } catch (Throwable th) {
                        try {
                            jarInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Unable to read bundled module properties: " + jarEntry.getName());
            return null;
        }
    }

    private String v8qP8fE86HMhvNuYPFjqY(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    if (!jarEntryNextElement.isDirectory() && jarEntryNextElement.getName().equalsIgnoreCase("Plugin.properties")) {
                        Properties properties = new Properties();
                        InputStream inputStream = jarFile.getInputStream(jarEntryNextElement);
                        try {
                            properties.load(inputStream);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            String property = properties.getProperty(E1m0u9KWLIcr6Lo());
                            String strTrim = property != null ? property.trim() : null;
                            jarFile.close();
                            return strTrim;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    }
                }
                jarFile.close();
                return null;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Unable to read installed module/extension properties: " + file.getName());
            return null;
        }
    }

    private int v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        String[] strArrSplit = str.trim().split(ZY5sg69FkzlfYlDl());
        String[] strArrSplit2 = str2.trim().split(EVDSjCZgO8R8Vbdg());
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (i < iMax) {
            int iXtOheRiObl4QeAl = i < strArrSplit.length ? xtOheRiObl4QeAl(strArrSplit[i]) : 0;
            int iXtOheRiObl4QeAl2 = i < strArrSplit2.length ? xtOheRiObl4QeAl(strArrSplit2[i]) : 0;
            if (iXtOheRiObl4QeAl != iXtOheRiObl4QeAl2) {
                return Integer.compare(iXtOheRiObl4QeAl, iXtOheRiObl4QeAl2);
            }
            i++;
        }
        return 0;
    }

    private int xtOheRiObl4QeAl(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void E7x2l2kafA964cPe8qfFo0() {
        File file = new File(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder(), CjqpcgkZdcVmEma());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            JarFile jarFile = new JarFile(new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()));
            try {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    String name = jarEntryNextElement.getName();
                    if (name.startsWith(jJtaAMXKInRzlMVaD()) && name.endsWith(cIoMPM0nigvU9VldM()) && !jarEntryNextElement.isDirectory()) {
                        String strSubstring = name.substring(name.lastIndexOf(47) + 1);
                        File file2 = new File(file, strSubstring);
                        if (file2.exists()) {
                            continue;
                        } else {
                            InputStream inputStream = jarFile.getInputStream(jarEntryNextElement);
                            try {
                                java.nio.file.Files.copy(inputStream, file2.toPath(), new CopyOption[0]);
                                this.v8qP8fE86HMhvNuYPFjqY.getLogger().info("Module extracted: " + strSubstring);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Throwable th) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                jarFile.close();
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (Exception e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning(yPE4rCVdDjFYAVodVQP());
            e.printStackTrace();
        }
    }

    public String nXcEVQOWhfaKT423a() {
        File file = new File(gvy0NoTzHY6bC7eAY(), TrK7YAP19xEPTW8MG9mv());
        try {
            if (file.exists()) {
                return java.nio.file.Files.readString(file.toPath()).trim();
            }
            String string = UUID.randomUUID().toString();
            java.nio.file.Files.writeString(file.toPath(), string, new OpenOption[0]);
            return string;
        } catch (IOException e) {
            throw new RuntimeException(wzsNflPG0HnaXZ(), e);
        }
    }

    public boolean iZTqZaRK5UGoe0Z(String str) {
        File file = new File(str);
        return file.exists() || file.mkdir();
    }

    public void qCr0jwvuDANuhNNe9InzM1() {
        try {
            this.jBUuLP0sWwaPyPOmogdX7l.clear();
            this.ZwrsrwOCXRUscW6Q.clear();
            this.iZTqZaRK5UGoe0Z.clear();
        } catch (Exception e) {
        }
    }

    public File v8qP8fE86HMhvNuYPFjqY(File[] fileArr, String str) {
        try {
            for (File file : fileArr) {
                if (file.isFile() && file.getName().equals(str)) {
                    return file;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String PXC8IUXrNFXRLxiYHjEwdr() {
        return "General";
    }

    private static String ItfQ4JI0lOsC6dbA() {
        return "admin_";
    }

    private static String ef0haA0mujkqJdC() {
        return "Copied legacy administrative GUI settings from gui.yml to admin_gui.yml.";
    }

    private static String nF27obVtSbHZYJ() {
        return "Could not copy legacy administrative GUI settings to admin_gui.yml.";
    }

    private static String x6eUvJgMN4l6IFL() {
        return "config";
    }

    private static String CONmpexuBc6iTsGCzqGoa() {
        return "storage";
    }

    private static String G6gcHA4KkZ2Xv8BO3() {
        return "commands";
    }

    private static String PHuTDfTalcyF0rdO() {
        return "chat";
    }

    private static String JdC8drUTLgsUwY() {
        return "moderation";
    }

    private static String AiPNrCZM44XaFMQ() {
        return "gui";
    }

    private static String sxh1BHjT8dDs8Bw5() {
        return "admin_gui";
    }

    private static String HNmfKCBN2BmooXS97() {
        return "modules";
    }

    private static String AxzzWm7qcEK5m7KA8Zp2rN() {
        return "config";
    }

    private static String dDkjhdbuxcBNUB896s1wG() {
        return "config";
    }

    private static String eTEYxD8Fmy62GkeiGoVw() {
        return "config";
    }

    private static String lBmEO7UFazyAgvYhVc() {
        return "config";
    }

    private static String eResDi2l2li2ii() {
        return "commands";
    }

    private static String GgPURIK5AeHMDY() {
        return "storage";
    }

    private static String r8WsYArVgU61dxt() {
        return "chat";
    }

    private static String OuAlxNHor1qdq0M() {
        return "moderation";
    }

    private static String DtxCCsQFb5bJqDcnXE() {
        return "modules";
    }

    private static String Q588RnWlMiLVk0rkeu() {
        return "gui";
    }

    private static String dP6wmYd34F1Ofz3WiDaxGz() {
        return "admin_gui";
    }

    private static String tVkESCCYmXWWaYYkpIiE() {
        return "clans";
    }

    private static String joKuqaUxHJqkiPc6pH5O5b() {
        return "players";
    }

    private static String yalXUqyvGhiiykJhQ() {
        return "invite";
    }

    private static String VBZTgeqXqt76cRnR() {
        return "logger";
    }

    private static String venzPBfhRG1U0vjJXyx2() {
        return "permissions";
    }

    private static String cGpAUw9eMFluA7() {
        return "mail";
    }

    private static String XdtFsJ5CUk9WMLDYfFUR() {
        return "/storage/yaml/";
    }

    private static String GlX7I2InHByfZeA() {
        return "Lang_";
    }

    private static String eUgCPj5yRLSE1UCb() {
        return "Gui_Lang_";
    }

    private static String pcW80AZxpsqnj4UXKLB() {
        return "/language/";
    }

    private static String K97AoMymNEdL4V8HJG1() {
        return "language";
    }

    private static String Mi0yemCets75oX() {
        return "Lang_";
    }

    private static String ihS3UJgdoRKdZ8sSPjaIwz() {
        return "Lang_";
    }

    private static String jGMD1YodFkEcGjMfvv() {
        return "Gui_Lang_";
    }

    private static String P1F98uPZ1YWpDM() {
        return "Gui_Lang_";
    }

    private static String PpECEY6emLQMieN2za() {
        return "lang_configs";
    }

    private static String Tazv5WN1jyZDUfIMAZ033b() {
        return "gui_lang_configs";
    }

    private static String yfjReVEMv5LizDn2() {
        return "Gui_Lang_";
    }

    private static String oUhAyTmBuqmYBoZNtHMA() {
        return "Lang_";
    }

    private static String WUbHdHulSkjtVMVeG3pt() {
        return "https://api.tribecraft.com.br/cloud/extension";
    }

    private static String AmyYSfFCw4pZrON7nj() {
        return "extensions";
    }

    private static String ovf9qoAUR3B6Zizl() {
        return "https://api.tribecraft.com.br/cloud/modules";
    }

    private static String UALo4jaWcTjSaYmzxFb() {
        return "modules";
    }

    private static String VYQZQyxzpFUisQbL() {
        return "lang_configs";
    }

    private static String Cls5urNuK3jgTpmL() {
        return "EN";
    }

    private static String F8tKEsgMvOsQaE6Jx56E() {
        return "EN";
    }

    private static String D8LcxTXIcSlDdkHwJ7pUGY() {
        return "SHA-256";
    }

    private static String CUHImPEUaMxgdA657f1Zt() {
        return "%02x";
    }

    private static String vCTRHgbVXuNOnNkg8Woz() {
        return "config";
    }

    private static String KMGz5Tre6cXfVty() {
        return "commands";
    }

    private static String CGrSUUHdUNPcyM7G() {
        return "clans";
    }

    private static String lGCrAQwLmTcamYdPD7ZONf() {
        return "players";
    }

    private static String XyYTVwffUnhyP7Hr() {
        return "invite";
    }

    private static String xA5YwkjswslUMnqafay9() {
        return "logger";
    }

    private static String E7AQj1pJs7UIX2YZ9O() {
        return "mail";
    }

    private static String P5DKhfsJ236GPw7qVxLesb() {
        return "permissions";
    }

    private static String kMiYM4qyWrIUxbzToRE() {
        return "moderation";
    }

    private static String UkmK6ioQ3KXhAS() {
        return "storage";
    }

    private static String QERRSqZq9SMJppPbkA8f3Y() {
        return "chat";
    }

    private static String lbcMsqftgLkfGKmp() {
        return "gui";
    }

    private static String JJeV7qEAzEkhpmg() {
        return "admin_gui";
    }

    private static String ilxUNWbYK1mAuaXRuSR0aI() {
        return "modules";
    }

    private static String iTu0zstoPiaL4TVcSiq6() {
        return "lang_configs";
    }

    private static String vJOJdq4bXlPuf4wmykx() {
        return "gui_lang_configs";
    }

    private static String FuqxILWZU5i8FU() {
        return "EN";
    }

    private static String KHvrq6RTXiaCJQ7OLj6() {
        return "gui_lang_configs";
    }

    private static String PeMtxCfrYZ4DcYRf() {
        return "No GUI language files loaded!";
    }

    private static String Wkg4gG7AdW2q3A3t() {
        return "EN";
    }

    private static String GVdFbpXvNxTmDTBp7mo1r() {
        return "EN";
    }

    private static String ae4cDFQ5acUO6J2R9x() {
        return "EN";
    }

    private static String KucbHHDKcQaKNXy() {
        return "lib/server";
    }

    private static String hndkOD5KSxDyHp5() {
        return "extensions";
    }

    private static String jycZuTy9eifhOEOsW4p4rt() {
        return "extensions/";
    }

    private static String sULVrDKfKtgX04Ikl() {
        return ".jar";
    }

    private static String A8JU8HQxylIpJZ0umqX() {
        return "[UltimateClans] Error while extracting/updating default extensions!";
    }

    private static String JYKne08K7ZFXyjFRl() {
        return "modules";
    }

    private static String uzaK80zLbRHzEweYextLmT() {
        return "modules/";
    }

    private static String Ov4HOemudY3sEarO6B54() {
        return ".jar";
    }

    private static String J9c3PkS4DYng1vkk7() {
        return "[UltimateClans] Error while extracting/updating default modules!";
    }

    private static String KeIMkvWSGQ50NKruDPmR() {
        return "version";
    }

    private static String E1m0u9KWLIcr6Lo() {
        return "version";
    }

    private static String ZY5sg69FkzlfYlDl() {
        return "\\.";
    }

    private static String EVDSjCZgO8R8Vbdg() {
        return "\\.";
    }

    private static String CjqpcgkZdcVmEma() {
        return "modules";
    }

    private static String jJtaAMXKInRzlMVaD() {
        return "modules/";
    }

    private static String cIoMPM0nigvU9VldM() {
        return ".jar";
    }

    private static String yPE4rCVdDjFYAVodVQP() {
        return "[UltimateClans] Erro ao tentar extrair os m\u00f3dulos padr\u00e3o do jar!";
    }

    private static String TrK7YAP19xEPTW8MG9mv() {
        return "server.id";
    }

    private static String wzsNflPG0HnaXZ() {
        return "Cannot create serverId";
    }

    private static String M1RxjV0CCbSpT28qv18l() {
        return "GET";
    }

    private static String cipkYVFzTDtL7MIcmLwd() {
        return "User-Agent";
    }

    private static String H1mIf5HmpsP1vfgp() {
        return "X-User-ID";
    }

    private static String g69OO7YxRDuNeA6LK8() {
        return "X-Timestamp";
    }

    private static String c0mpn4QQMJ0uGkS3pe() {
        return "X-Signature";
    }

    private static String pGGdmcr5DM7xU9lcJ() {
        return "0.0";
    }

    private static String OqqUVQeBtJwOM3TJh() {
        return "extensions";
    }

    private static String AbXWOh8cZxZ2IFuT() {
        return "0.0";
    }

    private static String gEq8xeLgYzY8plS1hzHi() {
        return "modules";
    }

    private static String QelFO96M6CFTO5O() {
        return "0.0";
    }

    private static String Pdz1yPCRMWuYZ0G3w() {
        return "latest";
    }

    private static String ScOJoDOOjSOgJEfCX50() {
        return "file_name";
    }

    private static String Ed9XnuCTtypGpYpZKs0QBQ() {
        return "download_token";
    }
}
