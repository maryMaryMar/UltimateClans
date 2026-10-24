package me.ulrich.clans.manager;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/TZTjwgGMwzxVd5AxjtP.class */
public class TZTjwgGMwzxVd5AxjtP {
    private Clans jBUuLP0sWwaPyPOmogdX7l;
    public final LegacyComponentSerializer v8qP8fE86HMhvNuYPFjqY = LegacyComponentSerializer.builder().hexColors().useUnusualXRepeatedCharacterHexFormat().build();
    private static volatile String caMVJkcSeufpXPBQpFio;
    private static volatile String u9QfGyScAKxrNmlvnW6;
    private static String unEmmeirgDQiXL;
    private static volatile String P7M2jOmeOdInIdVEl5er32;
    private static volatile String ZOn4rcBZ5W4T7VN;
    private static volatile String fWOBsN54r2e2BPLZ;
    private static String VEOMOupXnPeztPlEczPE;
    private static volatile String IsnX4cpjC9J1UNhQ;
    private static volatile String Z5q4nlcUnR0ZB19OwzdJL2;
    private static volatile String tY8AR158F63AOFkbCQf;
    private static String UPobgO0gjuoO194ZL;
    private static volatile String obhOmAoLJupeq1f;
    private static volatile String qE1cU97zLJlMXO41ht;
    private static volatile String gp433kUAAEtVVm;
    private static String mOonKvCoSXENEM8;
    private static String zhoZJSrDPUvoQfEBsk37ju;
    private static String SjEvj3z4wV2SIyYY1Z;
    private static String DqcgQ6PrZplMGdg4ev4uS;
    private static volatile String ZTwDai991b45at4p;
    private static volatile String NGCQziZoJLhhOFA0PN8aQ;
    private static volatile String zuE72Pjgi27Jo0S;
    private static String s2waidRoYpF7dsubR;
    private static String ofKN51E0uMxng6aWGbtc0;
    private static volatile String DM4iOoji4qKFgvpheDgPTf;
    private static String GLz2riiyjTxL9W6;
    private static volatile String MuztCqxyxPHEL5A9;
    private static volatile String Zsz5tBawkeI3J50P;
    private static String cygTYR1XJpUWbEEnDhLV9;
    private static String cVCLD8rXFFxRUWor;
    private static String H3Xs6r2lP0vIrl;
    private static String mVsAG3KdzZkqirRmXM76;
    private static volatile String hRYQqggCmwACVFD2;
    private static String IPWqXpWpObJZx1l2;
    private static volatile String xlUJRnzuAGwscetZF;
    private static volatile String x2KOWrkhGDrMRXWozjw0;
    private static volatile String GxeBAJvSkmUc6v7CPfbNW;
    private static volatile String I7DEUUxuAptAIAQ2;
    private static String daUL4AH6B0b7XGxGkxmzw;
    private static String fFcPcJwyzC2ix6vcnsI;
    private static volatile String FIcO3Kx9ykPwkJBn;
    private static String bn7s6R5u1A28p1f0UwOSLW;
    private static String r7B8Jd3XUtack0B8qgYv;
    private static String A9BDjmEoBnxaz3zFKUGjo;
    private static String oJTCxWg4XL27LBtavYu4Pe;
    private static volatile String BX1H8J6Q0dAEifyCoUNr;
    private static volatile String Bk1b86hZOTGk7MQ;
    private static String cUrRj6E14qoz9vR;
    private static String Oip8fWKxUZ6LFg;
    private static volatile String lC5liYpfnpGWEd8;
    private static String Nd0AMwKaSHwIbt44jiQ;
    private static String xyIvKgWiZtoUEYj;
    private static volatile String ed2LMTMwymJnriljVN;
    private static String ICLQUiDRah8yij8;
    private static String HIkutCIhPkUfZBpQRCEY;
    private static volatile String nD2ExtVX5OCQIzu1EA;
    private static volatile String mOxXnT3GK9LbiZR;
    private static String DZyrWP9xbxcxsDlFcS;
    private static volatile String hGIjx88hV2Eyr748;
    private static volatile String L8y9Ha2WgO9wVco;
    private static volatile String gJoEGBca1zxokAgc;
    private static String nQmWUJDLOCWQBSkuSS;
    private static volatile String pBxMHTPUgnzMPkgpx6gC;
    private static volatile String uGIuBLf1nLNA1DJTK;
    private static volatile String R0biwcCVEWeFrC;
    private static String wFWkfpspjST2sijbpQyhL;
    private static String IeiUbEBqnaxCZYK;
    private static volatile String TCLhoBjJnOsxt6a;
    private static String mzmun2pp7Y5rJZB;
    private static String sWkKg8dJ1jtnpufwYq;
    private static volatile String gj5rnBH6ai0P6HSZCiD;
    private static volatile String rk0wPBnvMAD3M55jTlf;
    private static String OzNQBESovKcbmsN5aT;
    private static String ud3SsAryGZAqfM05AYm;
    private static String HA99L38IGXETYB209AlN;
    private static String VTYutXxX9BgSEXt;
    private static volatile String hbpnWXcbOVyjKWY9;
    private static String h4E1bhZpEwiCdh;
    private static String nnEhtnlWwye7ECCIB;
    private static volatile String yr9F6stonXcvehyziNiA;
    private static volatile String MwwYPeuZiN0Fnzq9;
    private static String fpgNGFKRvlq2Xo4PWAk;
    private static String qoohZV4J8m8HVxK6aMBar;
    private static volatile String U9chV9g8Jyt4RNIM8u;
    private static String NLmxNiZLA72aRi3Y;
    private static volatile String DUYEKlqZCh5pf7Hzkyc;
    private static volatile String JzUWGurJrfS7OcL;
    private static volatile String BpXXgnrrSY2LMp;
    private static String UiVKXuWJDiFPcTb576FNg6;
    private static volatile String hcwBG3vHyFtfJq9lhku6;
    private static String cWCRkBxbJ11XRA;
    private static String LlYrYcsqlJ62dLYf;
    private static String kxf4IxjwwMz5tbxDfrG;
    private static volatile String jiLA2ivokCFqP0SG;
    private static volatile String uHo6MHC6U0WMdnOYL9;
    private static String Ubf8tPWfpoffXx;
    private static volatile String auLfXdwhdjdIxC3rzBa;
    private static String A1QAJlEWNl8eyVGWQv68;
    private static volatile String bdG7LSID9ZBVJ1yPRvjt;
    private static volatile String JrJI9hXI2jElRVVLRjR;
    private static String j8oeHrAlXirVSB;
    private static volatile String X0s9PRxlqM0vhR9TKq;
    private static String dCF3kfZKscS4I30;
    private static volatile String gaEWypHDreirJAAtP;
    private static volatile String gyVa2jbKtqyxGg1Cx;
    private static String oMcqhBs9sUskj9wyCBG4i5;
    private static volatile String IxbxRy7NLFUAUqD;
    private static volatile String j84LGJLSsXRMQ0ALhl;
    private static String HAK0w1bD3LS421Qfig;
    private static String OxYzTOtSMXdDLfkNqs;
    private static volatile String DTjXR8Vi2euEWiwKcI;
    private static volatile String iOukeuimvohvqd4cjSxMd;
    private static String WVHRQLcduyivR21mp3C;
    private static volatile String t7qAZ4WHU6rxaEA;
    private static volatile String CDOFyvdm2QYrmXYKIPXX;
    private static String Gh9YPwayeyq4AePOAbxIg;
    private static String bQ5S4zzkUDQ3Ggzy9sr;
    private static volatile String xR6AmmwIFnELYyt;
    private static volatile String JZpXLOzRW04CFuP5twHD;
    private static volatile String TxTBh5I0MjIzolTSjdY;
    private static volatile String j7WLNdvU17i2qjaEl9Mx;
    private static String vNrKdwopPFZqjLqz;
    private static String OBQvcFmfJEbqPzwoncEvo;
    private static String M9nM1YKhlbWeMc;
    private static String xJQfD88zDthz9DJ;
    private static volatile String NRD8XKg93VyKCiHbu341;
    private static volatile String UbYobzxj6XeXV2EoZCu5F;
    private static String SIcO0Xg67kUZnBxdTLIx;
    private static String SrNyQOoW1TB7rjLXhUC;
    private static String AeMehLLFkeLMZSaITOsSXr;
    private static volatile String sgMhmyVJTGcl35;
    private static volatile String e0IYpFlKUihViVCtM;
    private static String VPu06MKt0ptmDA8jte;
    private static String VeXyRuIpiBAtvJTcGAG;
    private static volatile String wzRmesYpfYRi7GAYg2;
    private static volatile String yKHc3nmtrQnfgTwFY;
    private static String SmKeGN0KNVmTQLR;
    private static volatile String L1Ipr02FbS3DcMS3OUV8c;
    private static String OOTo3KTUZm4tYb;
    private static String U2pUzThhKTXoFGZRB;
    private static volatile String hSw2cJQXF5CFSSVV;
    private static String EAKizZviqHkvKeTZ5e;
    private static String oihyZgbsIQXxGJBU2x;
    private static final byte[] iMHboWsy6FFGaViyJ = {(byte) 99, (byte) 66, (byte) 60, (byte) 131, (byte) 251, (byte) 16, (byte) 183, (byte) 39, (byte) 139, (byte) 88, (byte) 136, (byte) 213, (byte) 168, (byte) 83, (byte) 252, (byte) 87};
    private static final byte[] wo0SnjJFULBNcUbd1 = {(byte) 63, (byte) 88, (byte) 197, (byte) 225, (byte) 54, (byte) 99, (byte) 75, (byte) 31, (byte) 244, (byte) 130, (byte) 37, (byte) 189, (byte) 255, (byte) 194, (byte) 106, (byte) 28};
    private static final byte[] PyFZXgbR3OjumoB = {(byte) 219, (byte) 37, (byte) 215, (byte) 116, (byte) 161, (byte) 209, (byte) 207, (byte) 105, (byte) 237, (byte) 211, (byte) 36, (byte) 195, (byte) 247, (byte) 33, (byte) 33, (byte) 170};
    private static final byte[] v4Z0iN1r9bssqG1 = {(byte) 124, (byte) 196, (byte) 65, (byte) 236, (byte) 184, (byte) 238, (byte) 105, (byte) 232, (byte) 195, (byte) 164, (byte) 252, (byte) 22, (byte) 1, (byte) 17, (byte) 142, (byte) 121};
    private static final byte[] M6y3duJsUsSwINTiMEl = {(byte) 9, (byte) 162, (byte) 108, (byte) 198, (byte) 31, (byte) 183, (byte) 165, (byte) 103, (byte) 42, (byte) 229, (byte) 140, (byte) 183, (byte) 185, (byte) 94, (byte) 41, (byte) 196};
    private static final byte[] vVkI1kRD3F402AK = {(byte) 18, (byte) 251, (byte) 8, (byte) 26, (byte) 129, (byte) 130, (byte) 47, (byte) 253, (byte) 4, (byte) 48, (byte) 131, (byte) 6, (byte) 82, (byte) 135, (byte) 134, (byte) 59};
    private static final byte[] Dwb99HXIGtfM4DU = {(byte) 90, (byte) 38, (byte) 104, (byte) 39, (byte) 162, (byte) 65, (byte) 27, (byte) 192, (byte) 13, (byte) 66, (byte) 19, (byte) 180, (byte) 194, (byte) 138, (byte) 51, (byte) 46};
    private static final byte[] lxYUQlKTzCiFrmRAwIIkiE = {(byte) 199, (byte) 249, (byte) 172, (byte) 25, (byte) 9, (byte) 159, (byte) 154, (byte) 204, (byte) 63, (byte) 177, (byte) 206, (byte) 151, (byte) 75, (byte) 188, (byte) 223, (byte) 45};
    private static final byte[] a2Ue8zoWcEXSpIMCKNEBlk = {(byte) 105, (byte) 121, (byte) 76, (byte) 83, (byte) 164, (byte) 136, (byte) 204, (byte) 220, (byte) 221, (byte) 148, (byte) 50, (byte) 57, (byte) 181, (byte) 89, (byte) 139, (byte) 19};
    private static final byte[] nIrK67trDmsIFy = {(byte) 176, (byte) 218, (byte) 135, (byte) 41, (byte) 44, (byte) 186, (byte) 114, (byte) 81, (byte) 211, (byte) 76, (byte) 139, (byte) 47, (byte) 196, (byte) 172, (byte) 253, (byte) 7};
    private static final byte[] yGT1sq5TiOuz3H2pB = {(byte) 73, (byte) 166, (byte) 104, (byte) 57, (byte) 40, (byte) 110, (byte) 86, (byte) 204, (byte) 180, (byte) 157, (byte) 248, (byte) 142, (byte) 38, (byte) 227, (byte) 103, (byte) 64};
    private static final byte[] kBZcXrN6mfP05AbVIOG9 = {(byte) 127, (byte) 185, (byte) 233, (byte) 220, (byte) 155, (byte) 243, (byte) 117, (byte) 219, (byte) 2, (byte) 109, (byte) 6, (byte) 235, (byte) 75, (byte) 186, (byte) 229, (byte) 33};
    private static final byte[] JjCAsvAfgxMTgtnf = {(byte) 250, (byte) 0, (byte) 150, (byte) 236, (byte) 235, (byte) 237, (byte) 109, (byte) 19, (byte) 170, (byte) 130, (byte) 77, (byte) 91, (byte) 35, (byte) 21, (byte) 5, (byte) 22};
    private static final byte[] w0FaK7mwyht4Lp94OKBG = {(byte) 249, (byte) 153, (byte) 14, (byte) 199, (byte) 242, (byte) 231, (byte) 63, (byte) 89, (byte) 67, (byte) 164, (byte) 93, (byte) 89, (byte) 196, (byte) 166, (byte) 150, (byte) 128};
    private static final byte[] JRORSpqW6pApa83Kdfvd3 = {(byte) 69, (byte) 15, (byte) 190, (byte) 84, (byte) 74, (byte) 230, (byte) 172, (byte) 187, (byte) 125, (byte) 137, (byte) 250, (byte) 36, (byte) 1, (byte) 51, (byte) 25, (byte) 75};
    private static final byte[] rOLVrFLLUW4V1jSbpCnQ = {(byte) 123, (byte) 194, (byte) 1, (byte) 60, (byte) 143, (byte) 241, (byte) 83, (byte) 95, (byte) 18, (byte) 6, (byte) 116, (byte) 227, (byte) 141, (byte) 144, (byte) 251, (byte) 31};
    private static final byte[] xG1ffMysgsDZ4kjS8PQ = {(byte) 135, (byte) 123, (byte) 129, (byte) 158, (byte) 83, (byte) 0, (byte) 237, (byte) 13, (byte) 191, (byte) 163, (byte) 246, (byte) 79, (byte) 157, (byte) 23, (byte) 214, (byte) 161};
    private static final byte[] PDh0x1j4ZaT7gG9 = {(byte) 17, (byte) 98, (byte) 218, (byte) 135, (byte) 122, (byte) 159, (byte) 85, (byte) 51, (byte) 64, (byte) 52, (byte) 132, (byte) 146, (byte) 32, (byte) 87, (byte) 130, (byte) 209};
    private static final byte[] FLzNb1nEPK9tEXJl = {(byte) 201, (byte) 140, (byte) 223, (byte) 57, (byte) 16, (byte) 225, (byte) 76, (byte) 167, (byte) 63, (byte) 133, (byte) 45, (byte) 197, (byte) 128, (byte) 5, (byte) 225, (byte) 40};
    private static final byte[] wEb7cfI186wQVQ = {(byte) 172, (byte) 69, (byte) 234, (byte) 3, (byte) 117, (byte) 15, (byte) 245, (byte) 187, (byte) 67, (byte) 218, (byte) 112, (byte) 43, (byte) 114, (byte) 88, (byte) 58, (byte) 97};
    private static final byte[] fDh6CFPtShS3CvD2Wjs5U = {(byte) 194, (byte) 181, (byte) 236, (byte) 254, (byte) 186, (byte) 212, (byte) 81, (byte) 86, (byte) 31, (byte) 136, (byte) 64, (byte) 200, (byte) 246, (byte) 59, (byte) 98, (byte) 148};
    private static final byte[] oXA0DHcdqvWik9PBTM = {(byte) 57, (byte) 78, (byte) 0, (byte) 66, (byte) 183, (byte) 239, (byte) 166, (byte) 113, (byte) 155, (byte) 16, (byte) 86, (byte) 86, (byte) 174, (byte) 205, (byte) 206, (byte) 231};
    private static final byte[] IGVg8tUXIKhAwF6T4WD = {(byte) 125, (byte) 18, (byte) 148, (byte) 181, (byte) 105, (byte) 94, (byte) 30, (byte) 64, (byte) 74, (byte) 127, (byte) 204, (byte) 131, (byte) 232, (byte) 242, (byte) 154, (byte) 247};
    private static final byte[] sjqvUHB2mv2OjFPY71pJw = {(byte) 47, (byte) 153, (byte) 122, (byte) 16, (byte) 234, (byte) 14, (byte) 119, (byte) 15, (byte) 113, (byte) 134, (byte) 154, (byte) 243, (byte) 158, (byte) 44, (byte) 101, (byte) 148};
    private static final byte[] Hk0IFVmJCX0sr772Rg = {(byte) 70, (byte) 201, (byte) 65, (byte) 11, (byte) 67, (byte) 210, (byte) 14, (byte) 239, (byte) 228, (byte) 107, (byte) 28, (byte) 186, (byte) 142, (byte) 138, (byte) 227, (byte) 255};
    private static final byte[] Fle4DHdK8a7MTA = {(byte) 58, (byte) 127, (byte) 79, (byte) 142, (byte) 128, (byte) 183, (byte) 239, (byte) 37, (byte) 42, (byte) 43, (byte) 95, (byte) 236, (byte) 3, (byte) 255, (byte) 244, (byte) 240};
    private static final byte[] uTVvtjM4nKrXp8iRgV = {(byte) 17, (byte) 98, (byte) 218, (byte) 135, (byte) 122, (byte) 159, (byte) 85, (byte) 51, (byte) 64, (byte) 52, (byte) 132, (byte) 146, (byte) 32, (byte) 87, (byte) 130, (byte) 209};
    private static final byte[] OSx6Kd350umhPfY65x = {(byte) 98, (byte) 15, (byte) 5, (byte) 47, (byte) 10, (byte) 14, (byte) 164, (byte) 237, (byte) 40, (byte) 178, (byte) 110, (byte) 15, (byte) 230, (byte) 31, (byte) 47, (byte) 250};
    private static final byte[] NCpydEAq1Pv2Yioxlg8 = {(byte) 224, (byte) 21, (byte) 210, (byte) 240, (byte) 62, (byte) 115, (byte) 132, (byte) 191, (byte) 203, (byte) 66, (byte) 157, (byte) 191, (byte) 125, (byte) 33, (byte) 195, (byte) 136};
    private static final byte[] pAVyS1hSUy9jUK47C7CHH = {(byte) 82, (byte) 2, (byte) 117, (byte) 252, (byte) 164, (byte) 42, (byte) 246, (byte) 227, (byte) 95, (byte) 225, (byte) 141, (byte) 91, (byte) 11, (byte) 159, (byte) 108, (byte) 173};
    private static final byte[] m8K5CIBisSZpaK00n = {(byte) 221, (byte) 33, (byte) 11, (byte) 201, (byte) 74, (byte) 89, (byte) 255, (byte) 129, (byte) 65, (byte) 209, (byte) 254, (byte) 159, (byte) 181, (byte) 188, (byte) 198, (byte) 5};
    private static final byte[] PmTADwAHbFRHK368eVZUa = {(byte) 201, (byte) 140, (byte) 223, (byte) 57, (byte) 16, (byte) 225, (byte) 76, (byte) 167, (byte) 63, (byte) 133, (byte) 45, (byte) 197, (byte) 128, (byte) 5, (byte) 225, (byte) 40};
    private static final byte[] FWjMc1S4mFMQn1wwcpJom = {(byte) 172, (byte) 69, (byte) 234, (byte) 3, (byte) 117, (byte) 15, (byte) 245, (byte) 187, (byte) 67, (byte) 218, (byte) 112, (byte) 43, (byte) 114, (byte) 88, (byte) 58, (byte) 97};
    private static final byte[] Ve8Ihp5v4NiYsYtfaFPSIh = {(byte) 105, (byte) 159, (byte) 184, (byte) 204, (byte) 163, (byte) 94, (byte) 212, (byte) 81, (byte) 36, (byte) 115, (byte) 239, (byte) 89, (byte) 167, (byte) 171, (byte) 188, (byte) 193};
    private static final byte[] EQm9NLfMHsTW9AJw6rxFF = {(byte) 67, (byte) 54, (byte) 157, (byte) 2, (byte) 34, (byte) 251, (byte) 138, (byte) 192, (byte) 193, (byte) 56, (byte) 185, (byte) 131, (byte) 74, (byte) 154, (byte) 214, (byte) 142};
    private static final byte[] pZY8CkGOsFhzPEdr = {(byte) 67, (byte) 54, (byte) 157, (byte) 2, (byte) 34, (byte) 251, (byte) 138, (byte) 192, (byte) 193, (byte) 56, (byte) 185, (byte) 131, (byte) 74, (byte) 154, (byte) 214, (byte) 142};
    private static final byte[] Xhywu0jsvLaBlRmMKO9MqV = {(byte) 57, (byte) 78, (byte) 0, (byte) 66, (byte) 183, (byte) 239, (byte) 166, (byte) 113, (byte) 155, (byte) 16, (byte) 86, (byte) 86, (byte) 174, (byte) 205, (byte) 206, (byte) 231};
    private static final byte[] ztGvJvP87dLKys3jKXux = {(byte) 57, (byte) 78, (byte) 0, (byte) 66, (byte) 183, (byte) 239, (byte) 166, (byte) 113, (byte) 155, (byte) 16, (byte) 86, (byte) 86, (byte) 174, (byte) 205, (byte) 206, (byte) 231};
    private static final byte[] oPdQZqbYnEV1LcCHLtr5 = {(byte) 125, (byte) 18, (byte) 148, (byte) 181, (byte) 105, (byte) 94, (byte) 30, (byte) 64, (byte) 74, (byte) 127, (byte) 204, (byte) 131, (byte) 232, (byte) 242, (byte) 154, (byte) 247};
    private static final byte[] aHBnF3Tx23oab8dig = {(byte) 193, (byte) 226, (byte) 46, (byte) 40, (byte) 223, (byte) 163, (byte) 74, (byte) 174, (byte) 38, (byte) 109, (byte) 239, (byte) 179, (byte) 164, (byte) 179, (byte) 16, (byte) 233};
    private static final byte[] f5UknQqGxzbqaiFSGvWWcL = {(byte) 47, (byte) 153, (byte) 122, (byte) 16, (byte) 234, (byte) 14, (byte) 119, (byte) 15, (byte) 113, (byte) 134, (byte) 154, (byte) 243, (byte) 158, (byte) 44, (byte) 101, (byte) 148};
    private static final byte[] KosU2q0FmD97NCn4JTL = {(byte) 70, (byte) 201, (byte) 65, (byte) 11, (byte) 67, (byte) 210, (byte) 14, (byte) 239, (byte) 228, (byte) 107, (byte) 28, (byte) 186, (byte) 142, (byte) 138, (byte) 227, (byte) 255};
    private static final byte[] Aan82BWa86l21fjZh = {(byte) 62, (byte) 146, (byte) 162, (byte) 129, (byte) 209, (byte) 208, (byte) 0, (byte) 11, (byte) 162, (byte) 24, (byte) 214, (byte) 181, (byte) 227, (byte) 172, (byte) 11, (byte) 12};
    private static final byte[] ZF9Bdqh7qy3uqPQ = {(byte) 17, (byte) 98, (byte) 218, (byte) 135, (byte) 122, (byte) 159, (byte) 85, (byte) 51, (byte) 64, (byte) 52, (byte) 132, (byte) 146, (byte) 32, (byte) 87, (byte) 130, (byte) 209};
    private static final byte[] cLwVTYflww93FCh1Y = {(byte) 224, (byte) 21, (byte) 210, (byte) 240, (byte) 62, (byte) 115, (byte) 132, (byte) 191, (byte) 203, (byte) 66, (byte) 157, (byte) 191, (byte) 125, (byte) 33, (byte) 195, (byte) 136};
    private static final byte[] SOuePjHFpS8AL3L8Ik = {(byte) 221, (byte) 33, (byte) 11, (byte) 201, (byte) 74, (byte) 89, (byte) 255, (byte) 129, (byte) 65, (byte) 209, (byte) 254, (byte) 159, (byte) 181, (byte) 188, (byte) 198, (byte) 5};
    private static final byte[] GwUFFYI6EyVLQ03l = {(byte) 221, (byte) 33, (byte) 11, (byte) 201, (byte) 74, (byte) 89, (byte) 255, (byte) 129, (byte) 65, (byte) 209, (byte) 254, (byte) 159, (byte) 181, (byte) 188, (byte) 198, (byte) 5};
    private static final byte[] jmjaKVFqg4BaZKmpj = {(byte) 201, (byte) 140, (byte) 223, (byte) 57, (byte) 16, (byte) 225, (byte) 76, (byte) 167, (byte) 63, (byte) 133, (byte) 45, (byte) 197, (byte) 128, (byte) 5, (byte) 225, (byte) 40};
    private static final byte[] Jkm5yVZHy9fh7T1PaVU6XE = {(byte) 172, (byte) 69, (byte) 234, (byte) 3, (byte) 117, (byte) 15, (byte) 245, (byte) 187, (byte) 67, (byte) 218, (byte) 112, (byte) 43, (byte) 114, (byte) 88, (byte) 58, (byte) 97};
    private static final byte[] IJoMlgvnpqlq1uT = {(byte) 172, (byte) 69, (byte) 234, (byte) 3, (byte) 117, (byte) 15, (byte) 245, (byte) 187, (byte) 67, (byte) 218, (byte) 112, (byte) 43, (byte) 114, (byte) 88, (byte) 58, (byte) 97};
    private static final byte[] emRAnDRE6UOTf0L = {(byte) 105, (byte) 159, (byte) 184, (byte) 204, (byte) 163, (byte) 94, (byte) 212, (byte) 81, (byte) 36, (byte) 115, (byte) 239, (byte) 89, (byte) 167, (byte) 171, (byte) 188, (byte) 193};
    private static final byte[] abd6l6GGVsrcx0uKpm7D1 = {(byte) 67, (byte) 54, (byte) 157, (byte) 2, (byte) 34, (byte) 251, (byte) 138, (byte) 192, (byte) 193, (byte) 56, (byte) 185, (byte) 131, (byte) 74, (byte) 154, (byte) 214, (byte) 142};
    private static final byte[] W7cNCbtKDGrEYkblI7VFV = {(byte) 194, (byte) 181, (byte) 236, (byte) 254, (byte) 186, (byte) 212, (byte) 81, (byte) 86, (byte) 31, (byte) 136, (byte) 64, (byte) 200, (byte) 246, (byte) 59, (byte) 98, (byte) 148};
    private static final byte[] w4vWB0YNMLyR8FmK = {(byte) 194, (byte) 181, (byte) 236, (byte) 254, (byte) 186, (byte) 212, (byte) 81, (byte) 86, (byte) 31, (byte) 136, (byte) 64, (byte) 200, (byte) 246, (byte) 59, (byte) 98, (byte) 148};
    private static final byte[] tipPCtm5PIX7gVb79mKm5 = {(byte) 57, (byte) 78, (byte) 0, (byte) 66, (byte) 183, (byte) 239, (byte) 166, (byte) 113, (byte) 155, (byte) 16, (byte) 86, (byte) 86, (byte) 174, (byte) 205, (byte) 206, (byte) 231};
    private static final byte[] JP0bRaXJ6HUaAsgF = {(byte) 57, (byte) 78, (byte) 0, (byte) 66, (byte) 183, (byte) 239, (byte) 166, (byte) 113, (byte) 155, (byte) 16, (byte) 86, (byte) 86, (byte) 174, (byte) 205, (byte) 206, (byte) 231};
    private static final byte[] kajpoeMOe6aRH8q14 = {(byte) 70, (byte) 201, (byte) 65, (byte) 11, (byte) 67, (byte) 210, (byte) 14, (byte) 239, (byte) 228, (byte) 107, (byte) 28, (byte) 186, (byte) 142, (byte) 138, (byte) 227, (byte) 255};
    private static final byte[] wk7vJp7Lf53CsoiDnJFUeO = {(byte) 75, (byte) 4, (byte) 96, (byte) 152, (byte) 251, (byte) 24, (byte) 27, (byte) 163, (byte) 160, (byte) 81, (byte) 208, (byte) 191, (byte) 146, (byte) 225, (byte) 66, (byte) 32};
    private static final byte[] XR46eDHUZZIoyhelQWHog = {(byte) 8, (byte) 152, (byte) 29, (byte) 109, (byte) 132, (byte) 100, (byte) 208, (byte) 186, (byte) 132, (byte) 221, (byte) 77, (byte) 176, (byte) 18, (byte) 43, (byte) 4, (byte) 12};
    private static final byte[] NzSOrcjsgLKDk5UGTnoj = {(byte) 83, (byte) 197, (byte) 29, (byte) 204, (byte) 91, (byte) 32, (byte) 89, (byte) 108, (byte) 0, (byte) 102, (byte) 121, (byte) 201, (byte) 222, (byte) 124, (byte) 230, (byte) 200};
    private static final byte[] baT3L8UitmA35V4YmEXZL = {(byte) 76, (byte) 100, (byte) 218, (byte) 27, (byte) 158, (byte) 95, (byte) 179, (byte) 79, (byte) 12, (byte) 23, (byte) 52, (byte) 234, (byte) 195, (byte) 166, (byte) 190, (byte) 85, (byte) 140, (byte) 64, (byte) 151, (byte) 225, (byte) 205, (byte) 111, (byte) 84, (byte) 89, (byte) 156, (byte) 101, (byte) 210, (byte) 212, (byte) 159, (byte) 234, (byte) 23, (byte) 131, (byte) 75, (byte) 3, (byte) 238, (byte) 57, (byte) 20, (byte) 56, (byte) 36, (byte) 154, (byte) 159, (byte) 6, (byte) 235, (byte) 105, (byte) 117, (byte) 226, (byte) 20, (byte) 80};
    private static final byte[] K2FBRKjE82IHGxBixyQ = {(byte) 228, (byte) 58, (byte) 164, (byte) 244, (byte) 210, (byte) 189, (byte) 113, (byte) 139, (byte) 248, (byte) 216, (byte) 159, (byte) 150, (byte) 212, (byte) 203, (byte) 117, (byte) 170};
    private static final byte[] PrJbTLJhwpV2ZjvZuEG6 = {(byte) 63, (byte) 88, (byte) 197, (byte) 225, (byte) 54, (byte) 99, (byte) 75, (byte) 31, (byte) 244, (byte) 130, (byte) 37, (byte) 189, (byte) 255, (byte) 194, (byte) 106, (byte) 28};
    private static final byte[] v7H2UX0JjdkK7ffO = {(byte) 162, (byte) 172, (byte) 43, (byte) 12, (byte) 121, (byte) 249, (byte) 13, (byte) 250, (byte) 111, (byte) 30, (byte) 18, (byte) 143, (byte) 70, (byte) 197, (byte) 91, (byte) 86};
    private static final byte[] FwVnR98ziYElojBh9 = {(byte) 52, (byte) 24, (byte) 246, (byte) 93, (byte) 138, (byte) 44, (byte) 13, (byte) 46, (byte) 70, (byte) 249, (byte) 137, (byte) 128, (byte) 110, (byte) 235, (byte) 249, (byte) 83};
    private static final byte[] GbP8FY3evcExzdrBG = {(byte) 91, (byte) 170, (byte) 165, (byte) 35, (byte) 145, (byte) 96, (byte) 11, (byte) 24, (byte) 223, (byte) 162, (byte) 222, (byte) 32, (byte) 0, (byte) 212, (byte) 32, (byte) 70};
    private static final byte[] GmTEDAcWMLhOcHRfbokz = {(byte) 47, (byte) 237, (byte) 60, (byte) 66, (byte) 142, (byte) 237, (byte) 247, (byte) 38, (byte) 238, (byte) 216, (byte) 225, (byte) 14, (byte) 255, (byte) 244, (byte) 38, (byte) 73};
    private static final byte[] vIdDq1bQJtyvhCR6Gb8 = {(byte) 228, (byte) 162, (byte) 212, (byte) 56, (byte) 166, (byte) 93, (byte) 48, (byte) 166, (byte) 1, (byte) 78, (byte) 181, (byte) 90, (byte) 183, (byte) 42, (byte) 188, (byte) 69, (byte) 241, (byte) 114, (byte) 192, (byte) 25, (byte) 177, (byte) 58, (byte) 114, (byte) 255, (byte) 24, (byte) 83, (byte) 127, (byte) 146, (byte) 16, (byte) 152, (byte) 139, (byte) 255, (byte) 238, (byte) 110, (byte) 90, (byte) 43, (byte) 94, (byte) 11, (byte) 122, (byte) 232, (byte) 81, (byte) 151, (byte) 222, (byte) 169, (byte) 251, (byte) 208, (byte) 236, (byte) 49};
    private static final Set<String> ZwrsrwOCXRUscW6Q = Set.of(new String[]{R5PPOW2waOh8necg(), nRZpbEMxLQOBdv(), NoQH7Tg27S96aQ0B(), eEakG4pXTbASeYYi(), H6G9ZWSSBymoE49p(), Rkq8iBAJzFp8VR(), IypUchPYvYGlcNY(), Frmwo8fw2cTZVA6eDiX(), Cys4BvS7XkCz23DnWeC8Yc(), aRVm9swiuOQK7Lh23vzjA(), aYApwg5fdqrfyxl(), vSPqx70UUyhrYg6v(), AE4dnTOrij8ZCGRv(), QR9hfQlTC1zQANrLyQ(), Yv0wQK0pi1dU7gk(), hpCJnD3snmNFHSY(), i1XYf2DdkEwfPiB(), Dpgs0tMZlZJYo39qVG9FG(), FjSA0iJXVlRkYcyHS5(), DuaECYLM0KRuBzrn01b7IA(), NwyXCJtgKujYnL7aNFv(), DTsG0fgikoZbIyE28cO(), KFKFxjUZgaWmsTJBY(), sksXYaybORBsypMRkxM(), f363GLpU3UIZF55(), ngPCM0mbBCyUkOJ(), U9zAYuqFM3ahLiU6m(), i5Oump9JXEZSAE(), XAsh18TWEQtf78PAC6(), VOfnw7sNnfYMLRKSfM9QJ5(), wHbSzTz4jXHnsnpRcetJkN(), NLYpA1wo4bZE9hcwKS(), Iz2XsMgrmHg02z9(), cu0WEQuHD1KIW88b7x(), JeblIzPzSI7DEn5dVZl0H()});
    private static final Pattern iZTqZaRK5UGoe0Z = Pattern.compile(rp04dDyP9YkNJrKkck5n());

    public TZTjwgGMwzxVd5AxjtP(Clans clans) {
        this.jBUuLP0sWwaPyPOmogdX7l = clans;
    }

    public String v8qP8fE86HMhvNuYPFjqY(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public String v8qP8fE86HMhvNuYPFjqY(String str, List<String> list) {
        if (str == null || str.isEmpty() || list == null || list.isEmpty()) {
            return str;
        }
        String strCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(str);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                TextDecoration textDecorationValueOf = TextDecoration.valueOf(it.next().toUpperCase(Locale.ROOT));
                if (textDecorationValueOf.equals(TextDecoration.BOLD)) {
                    strCDW4Fj1iwdIXEOqWjiJSR = v8qP8fE86HMhvNuYPFjqY(strCDW4Fj1iwdIXEOqWjiJSR, mzc7qyC3CCOZvBTryrIL(), DZCuucRrQS2kaLR2Vd49f());
                } else if (textDecorationValueOf.equals(TextDecoration.ITALIC)) {
                    strCDW4Fj1iwdIXEOqWjiJSR = v8qP8fE86HMhvNuYPFjqY(strCDW4Fj1iwdIXEOqWjiJSR, IuqXRyzOSl1c8sTUJtBx(), FGT48dK95Ul3joP(), MlG07uGv2X7eI6p29L());
                } else if (textDecorationValueOf.equals(TextDecoration.OBFUSCATED)) {
                    strCDW4Fj1iwdIXEOqWjiJSR = v8qP8fE86HMhvNuYPFjqY(strCDW4Fj1iwdIXEOqWjiJSR, W4EVUsbAs4sHJwhbjLGVhO(), CDi62H3BuXO2Qu());
                } else if (textDecorationValueOf.equals(TextDecoration.STRIKETHROUGH)) {
                    strCDW4Fj1iwdIXEOqWjiJSR = v8qP8fE86HMhvNuYPFjqY(strCDW4Fj1iwdIXEOqWjiJSR, aV8GsikuDHUlAR(), gT5dgU1e85rijZ0Vhz());
                } else if (textDecorationValueOf.equals(TextDecoration.UNDERLINED)) {
                    strCDW4Fj1iwdIXEOqWjiJSR = v8qP8fE86HMhvNuYPFjqY(strCDW4Fj1iwdIXEOqWjiJSR, di7MurOgbKOwtXRciCGLT(), lg9dwmtoYjIQrobCKPfV22());
                }
            } catch (Exception e) {
            }
        }
        return strCDW4Fj1iwdIXEOqWjiJSR;
    }

    private String v8qP8fE86HMhvNuYPFjqY(String str, String... strArr) {
        for (String str2 : strArr) {
            String strQuote = Pattern.quote(str2);
            str = str.replaceAll("(?i)<\\s*/?\\s*" + strQuote + "(?::(?:true|false))?\\s*>", "").replaceAll("(?i)<\\s*!\\s*" + strQuote + "\\s*>", "");
        }
        return str;
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        String strCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(str);
        int i = 0;
        while (true) {
            int iIndexOf = strCDW4Fj1iwdIXEOqWjiJSR.indexOf(60, i);
            if (iIndexOf < 0) {
                return true;
            }
            int iIndexOf2 = strCDW4Fj1iwdIXEOqWjiJSR.indexOf(62, iIndexOf + 1);
            if (iIndexOf2 < 0) {
                return false;
            }
            String strTrim = strCDW4Fj1iwdIXEOqWjiJSR.substring(iIndexOf + 1, iIndexOf2).trim();
            if (strTrim.isEmpty()) {
                return false;
            }
            if (strTrim.endsWith(VHdK0PL42aNnMsN0AxVIO())) {
                strTrim = strTrim.substring(0, strTrim.length() - 1).trim();
            }
            if (strTrim.startsWith(bMPMlPqLnCJFSJ6uMoDq()) || strTrim.startsWith(Xzhruqgq9CTr4qd4HoXEtU())) {
                strTrim = strTrim.substring(1).trim();
            }
            if (strTrim.isEmpty()) {
                return false;
            }
            int iIndexOf3 = strTrim.indexOf(58);
            String lowerCase = (iIndexOf3 >= 0 ? strTrim.substring(0, iIndexOf3) : strTrim).trim().toLowerCase(Locale.ROOT);
            if (!iZTqZaRK5UGoe0Z.matcher(lowerCase).matches() && !ZwrsrwOCXRUscW6Q.contains(lowerCase)) {
                return false;
            }
            i = iIndexOf2 + 1;
        }
    }

    public String v8qP8fE86HMhvNuYPFjqY(String str, TextDecoration textDecoration) {
        return str;
    }

    public Component ZwrsrwOCXRUscW6Q(String str) {
        String strCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(str.replace(Qaa9ceNLnhpeylONo(), this.jBUuLP0sWwaPyPOmogdX7l.getTagpl()));
        MiniMessage miniMessage = MiniMessage.miniMessage();
        if (miniMessage != null) {
            return miniMessage.deserialize(strCDW4Fj1iwdIXEOqWjiJSR).applyFallbackStyle(Style.style().decoration(TextDecoration.ITALIC, false).build());
        }
        TextComponent textComponentText = Component.text(strCDW4Fj1iwdIXEOqWjiJSR);
        textComponentText.decoration(TextDecoration.ITALIC, false);
        return textComponentText;
    }

    public Component v8qP8fE86HMhvNuYPFjqY(String str, boolean z) {
        String strCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(str.replace(QvH1b7k36x7J1PNzZhOO(), this.jBUuLP0sWwaPyPOmogdX7l.getTagpl()));
        if (z) {
            int i = this.jBUuLP0sWwaPyPOmogdX7l.getFiles().p31abtwfBag2jhMH6K().getInt(t4nj35hximN9tpIK8L());
            if (zJnaNCVQSgEShq(strCDW4Fj1iwdIXEOqWjiJSR).length() >= i) {
                strCDW4Fj1iwdIXEOqWjiJSR = Legacy.SERIALIZER.serialize(ZwrsrwOCXRUscW6Q(strCDW4Fj1iwdIXEOqWjiJSR)).substring(0, i - 2) + this.jBUuLP0sWwaPyPOmogdX7l.getFiles().p31abtwfBag2jhMH6K().getString(YSxQIlxfqkS5j3());
            }
            strCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR(strCDW4Fj1iwdIXEOqWjiJSR);
        }
        MiniMessage miniMessage = MiniMessage.miniMessage();
        if (miniMessage != null) {
            return miniMessage.deserialize(strCDW4Fj1iwdIXEOqWjiJSR).applyFallbackStyle(Style.style().decoration(TextDecoration.ITALIC, false).build());
        }
        TextComponent textComponentText = Component.text(strCDW4Fj1iwdIXEOqWjiJSR);
        textComponentText.decoration(TextDecoration.ITALIC, false);
        return textComponentText;
    }

    public String iZTqZaRK5UGoe0Z(String str) {
        return Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize(str.replace(HPLyY3oHDWFih5VLPd6g(), this.jBUuLP0sWwaPyPOmogdX7l.getTagpl()).toString()));
    }

    public String xtOheRiObl4QeAl(String str) {
        return CDW4Fj1iwdIXEOqWjiJSR(str.replace(mhDoaJwMAW7UD7SYcBVO(), this.jBUuLP0sWwaPyPOmogdX7l.getTagpl()));
    }

    public String zJnaNCVQSgEShq(String str) {
        return ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', this.v8qP8fE86HMhvNuYPFjqY.serialize(MiniMessage.miniMessage().deserialize(str))));
    }

    public String CDW4Fj1iwdIXEOqWjiJSR(String str) {
        return (str.contains("&") || str.contains("§")) ? str.toString().replace("&0", TQbXgOUMCesU3pVZMX7()).replace("&1", fWrYITPxGlQRF8e()).replace("&2", CAG1DvQ9EG5zjt()).replace("&3", Ck0AUmqgFdZpAQ75HGHi9y()).replace("&4", O8bUnr7JGodPaqCWYq()).replace("&5", TQB9nN2nVY2duM1IyxmKre()).replace("&6", muptwGuciYduEk()).replace("&7", MV6aYBrRrPZiBGquQpJX()).replace("&8", nokFw5pVSGHtnTYJMSU8q9()).replace("&9", QNJS6PHn9uEG4TMrzHEk65()).replace("&a", m9wOQBfGboPBhu0Xw3EVxv()).replace("&A", VRhCTGQBOutmLWv()).replace("&b", rKRDm6dJI5pwoIAZmyI9e()).replace("&B", oIJ03d6ti0dQ3wxjMf()).replace("&c", NMWV22BvKBD00J3d()).replace("&C", rNAFY5wNuk2OLeAde84R()).replace("&d", sxIfmc6TqWYd1jMZwC0()).replace("&D", HqUzQaPEypQ174w()).replace("&e", znKO5s88jDnhT3p35xeH()).replace("&E", AISXASfvei8AdRz7je()).replace("&f", smFb4o65YH9UafYz()).replace("&F", yPazfjeRINuq43L5nB()).replace("&k", gEBz9RHHMV3ObjFR8Cqfq()).replace("&K", QHGAzU09xNHEseE0j()).replace("&l", bowo0evhnHBjBp()).replace("&L", iVUXO2ODo68ScmaQbl()).replace("&m", G9p5oWLTQmblbCWeuWylY()).replace("&M", QiXuUuo6waBSa0rqepH()).replace("&n", v1fBonweWTyWfOL()).replace("&N", fBNZ3G4nqejttJyeQ()).replace("&o", rnOSG8yZmkf3pBjO7dkp()).replace("&O", Kb4t3HxvIxHeZC8hRWg9()).replace("&r", "").replace("&R", "").replace("&X", "").replace("&x", "").replace("§0", vdakin3T7V1Lne()).replace("§1", ZDnIXQgx8XNr8CSd3()).replace("§2", L0uaFK1dkZZTV13d2u50()).replace("§3", S5om7Cg7mH9Ui7oo8lOaj()).replace("§4", Nyxe0lgz1OVwZAmbsdVCAs()).replace("§5", OkAZjrdbaa0wmafut()).replace("§6", z89K6lgU8f25wCSVgX()).replace("§7", IHiGhZMrTE784tPmOHSROQ()).replace("§8", LTbkzdO4aCjGiT6()).replace("§9", UvPI9HIMJL91wAKt7VIf()).replace("§a", QmoyMupNm06oCYncp3Bo3Q()).replace("§A", JABf5kLpLfds6t3pCDM0()).replace("§b", MyYgbp9a6NZihg5qk()).replace("§B", n4FpHVqCQJdzo9z()).replace("§c", K4lhuyTeS8AQ21()).replace("§C", t3zfjt1I8Jdws5WK()).replace("§d", l2FtNVA8Se2shoINfoRR6()).replace("§D", nKbKsqa46OjHMf8iwB0WQ()).replace("§e", ZEip2OuYRhwuapeY()).replace("§E", ctKuFQG0z9VKm1V1aQ2()).replace("§f", X3XzT0l0yqTXRY4LXRBIM()).replace("§F", NMoB7AVZbYOMvCHkuGSq()).replace("§k", Y8pkzbNxFrSjQBk()).replace("§K", LznTtTJj2xNv3NzNkcvVZ()).replace("§l", DZlsfk5uYicFdZPP6()).replace("§L", q47OCKI3Gr6Ga6acr2p7()).replace("§m", Y3oVGjmPQRv2S1()).replace("§M", YNEBMYfEdPkIoE5KcIYxo4()).replace("§n", TgZbkqYDncqMM8X()).replace("§N", YuPwKzJoUh1bca()).replace("§o", AHsfSLpqyqrwpppLZC()).replace("§O", svyOp6CfIvL9sHDk6CqMtH()).replace("§r", "").replace("§R", "") : str;
    }

    public String b4i2FbOkaKeg91LiAe6l(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replace(p4bgdXrclCI7pe4Ix(), "§0").replace(q32vBMdxb6sh113oMt(), "§1").replace(mvVhM7eiDBdWck(), "§2").replace(JKlRvaPnSjF6orqe(), "§3").replace(BxlkEsAguqD48P(), "§4").replace(FFIb0t31FfpL20YXp(), "§5").replace(GDivJquNseW0bNyorimU(), "§6").replace(DVbYwccYvGR9vnHxA(), "§7").replace(enT4dF0hGMfBthwF15u(), "§8").replace(CN78NS95aFMo5e(), "§9").replace(rzRN0Ctjdio3il(), "§a").replace(RUM7b2zc8wL5hQq7mb(), "§b").replace(LcAXyn6vLWnIisG2Eaa(), "§c").replace(F51TsP16yfSYHkXS4X7LEd(), "§d").replace(FGrQvY4dNdbFkC3pn(), "§e").replace(FbrGs6AupbG2ff4uCq3N2e(), "§f").replace(jOahiDJ9X7Q4RQhUB(), "§k").replace(NU6zOGebWAIqbUzXCrqjc(), "§l").replace(wwZCcIHGviPJjjoLDc0xaL(), "§m").replace(K9PLHWQWd9r3eZEcc(), "§n").replace(SZbPpFpjPqvclWEOV3(), "§o").replace(PJnvCRIaoGTByOtF(), "§r");
    }

    private static String AHJlIRUbZIQAdOMo0(byte[] bArr) {
        return "";
    }

    private static String mzc7qyC3CCOZvBTryrIL() {
        return "bold";
    }

    private static String DZCuucRrQS2kaLR2Vd49f() {
        return "b";
    }

    private static String IuqXRyzOSl1c8sTUJtBx() {
        return "italic";
    }

    private static String FGT48dK95Ul3joP() {
        return "i";
    }

    private static String MlG07uGv2X7eI6p29L() {
        return "em";
    }

    private static String W4EVUsbAs4sHJwhbjLGVhO() {
        return "obfuscated";
    }

    private static String CDi62H3BuXO2Qu() {
        return "obf";
    }

    private static String aV8GsikuDHUlAR() {
        return "strikethrough";
    }

    private static String gT5dgU1e85rijZ0Vhz() {
        return "st";
    }

    private static String di7MurOgbKOwtXRciCGLT() {
        return "underlined";
    }

    private static String lg9dwmtoYjIQrobCKPfV22() {
        return "u";
    }

    private static String VHdK0PL42aNnMsN0AxVIO() {
        return "/";
    }

    private static String bMPMlPqLnCJFSJ6uMoDq() {
        return "/";
    }

    private static String Xzhruqgq9CTr4qd4HoXEtU() {
        return "!";
    }

    private static String Qaa9ceNLnhpeylONo() {
        return "%tag%";
    }

    private static String QvH1b7k36x7J1PNzZhOO() {
        return "%tag%";
    }

    private static String t4nj35hximN9tpIK8L() {
        return "Config.gui.titles.max_characters";
    }

    private static String YSxQIlxfqkS5j3() {
        return "Config.gui.titles.ellipsis";
    }

    private static String HPLyY3oHDWFih5VLPd6g() {
        return "%tag%";
    }

    private static String mhDoaJwMAW7UD7SYcBVO() {
        return "%tag%";
    }

    private static String TQbXgOUMCesU3pVZMX7() {
        return "<black>";
    }

    private static String fWrYITPxGlQRF8e() {
        return "<dark_blue>";
    }

    private static String CAG1DvQ9EG5zjt() {
        return "<dark_green>";
    }

    private static String Ck0AUmqgFdZpAQ75HGHi9y() {
        return "<dark_aqua>";
    }

    private static String O8bUnr7JGodPaqCWYq() {
        return "<dark_red>";
    }

    private static String TQB9nN2nVY2duM1IyxmKre() {
        return "<dark_purple>";
    }

    private static String muptwGuciYduEk() {
        return "<gold>";
    }

    private static String MV6aYBrRrPZiBGquQpJX() {
        return "<gray>";
    }

    private static String nokFw5pVSGHtnTYJMSU8q9() {
        return "<dark_gray>";
    }

    private static String QNJS6PHn9uEG4TMrzHEk65() {
        return "<blue>";
    }

    private static String m9wOQBfGboPBhu0Xw3EVxv() {
        return "<green>";
    }

    private static String VRhCTGQBOutmLWv() {
        return "<green>";
    }

    private static String rKRDm6dJI5pwoIAZmyI9e() {
        return "<aqua>";
    }

    private static String oIJ03d6ti0dQ3wxjMf() {
        return "<aqua>";
    }

    private static String NMWV22BvKBD00J3d() {
        return "<red>";
    }

    private static String rNAFY5wNuk2OLeAde84R() {
        return "<red>";
    }

    private static String sxIfmc6TqWYd1jMZwC0() {
        return "<light_purple>";
    }

    private static String HqUzQaPEypQ174w() {
        return "<light_purple>";
    }

    private static String znKO5s88jDnhT3p35xeH() {
        return "<yellow>";
    }

    private static String AISXASfvei8AdRz7je() {
        return "<yellow>";
    }

    private static String smFb4o65YH9UafYz() {
        return "<white>";
    }

    private static String yPazfjeRINuq43L5nB() {
        return "<white>";
    }

    private static String gEBz9RHHMV3ObjFR8Cqfq() {
        return "<obfuscated>";
    }

    private static String QHGAzU09xNHEseE0j() {
        return "<obfuscated>";
    }

    private static String bowo0evhnHBjBp() {
        return "<bold>";
    }

    private static String iVUXO2ODo68ScmaQbl() {
        return "<bold>";
    }

    private static String G9p5oWLTQmblbCWeuWylY() {
        return "<strikethrough>";
    }

    private static String QiXuUuo6waBSa0rqepH() {
        return "<strikethrough>";
    }

    private static String v1fBonweWTyWfOL() {
        return "<underlined>";
    }

    private static String fBNZ3G4nqejttJyeQ() {
        return "<underlined>";
    }

    private static String rnOSG8yZmkf3pBjO7dkp() {
        return "<italic>";
    }

    private static String Kb4t3HxvIxHeZC8hRWg9() {
        return "<italic>";
    }

    private static String vdakin3T7V1Lne() {
        return "<black>";
    }

    private static String ZDnIXQgx8XNr8CSd3() {
        return "<dark_blue>";
    }

    private static String L0uaFK1dkZZTV13d2u50() {
        return "<dark_green>";
    }

    private static String S5om7Cg7mH9Ui7oo8lOaj() {
        return "<dark_aqua>";
    }

    private static String Nyxe0lgz1OVwZAmbsdVCAs() {
        return "<dark_red>";
    }

    private static String OkAZjrdbaa0wmafut() {
        return "<dark_purple>";
    }

    private static String z89K6lgU8f25wCSVgX() {
        return "<gold>";
    }

    private static String IHiGhZMrTE784tPmOHSROQ() {
        return "<gray>";
    }

    private static String LTbkzdO4aCjGiT6() {
        return "<dark_gray>";
    }

    private static String UvPI9HIMJL91wAKt7VIf() {
        return "<blue>";
    }

    private static String QmoyMupNm06oCYncp3Bo3Q() {
        return "<green>";
    }

    private static String JABf5kLpLfds6t3pCDM0() {
        return "<green>";
    }

    private static String MyYgbp9a6NZihg5qk() {
        return "<aqua>";
    }

    private static String n4FpHVqCQJdzo9z() {
        return "<aqua>";
    }

    private static String K4lhuyTeS8AQ21() {
        return "<red>";
    }

    private static String t3zfjt1I8Jdws5WK() {
        return "<red>";
    }

    private static String l2FtNVA8Se2shoINfoRR6() {
        return "<light_purple>";
    }

    private static String nKbKsqa46OjHMf8iwB0WQ() {
        return "<light_purple>";
    }

    private static String ZEip2OuYRhwuapeY() {
        return "<yellow>";
    }

    private static String ctKuFQG0z9VKm1V1aQ2() {
        return "<yellow>";
    }

    private static String X3XzT0l0yqTXRY4LXRBIM() {
        return "<white>";
    }

    private static String NMoB7AVZbYOMvCHkuGSq() {
        return "<white>";
    }

    private static String Y8pkzbNxFrSjQBk() {
        return "<obfuscated>";
    }

    private static String LznTtTJj2xNv3NzNkcvVZ() {
        return "<obfuscated>";
    }

    private static String DZlsfk5uYicFdZPP6() {
        return "<bold>";
    }

    private static String q47OCKI3Gr6Ga6acr2p7() {
        return "<bold>";
    }

    private static String Y3oVGjmPQRv2S1() {
        return "<strikethrough>";
    }

    private static String YNEBMYfEdPkIoE5KcIYxo4() {
        return "<strikethrough>";
    }

    private static String TgZbkqYDncqMM8X() {
        return "<underlined>";
    }

    private static String YuPwKzJoUh1bca() {
        return "<underlined>";
    }

    private static String AHsfSLpqyqrwpppLZC() {
        return "<italic>";
    }

    private static String svyOp6CfIvL9sHDk6CqMtH() {
        return "<italic>";
    }

    private static String p4bgdXrclCI7pe4Ix() {
        return "<black>";
    }

    private static String q32vBMdxb6sh113oMt() {
        return "<dark_blue>";
    }

    private static String mvVhM7eiDBdWck() {
        return "<dark_green>";
    }

    private static String JKlRvaPnSjF6orqe() {
        return "<dark_aqua>";
    }

    private static String BxlkEsAguqD48P() {
        return "<dark_red>";
    }

    private static String FFIb0t31FfpL20YXp() {
        return "<dark_purple>";
    }

    private static String GDivJquNseW0bNyorimU() {
        return "<gold>";
    }

    private static String DVbYwccYvGR9vnHxA() {
        return "<gray>";
    }

    private static String enT4dF0hGMfBthwF15u() {
        return "<dark_gray>";
    }

    private static String CN78NS95aFMo5e() {
        return "<blue>";
    }

    private static String rzRN0Ctjdio3il() {
        return "<green>";
    }

    private static String RUM7b2zc8wL5hQq7mb() {
        return "<aqua>";
    }

    private static String LcAXyn6vLWnIisG2Eaa() {
        return "<red>";
    }

    private static String F51TsP16yfSYHkXS4X7LEd() {
        return "<light_purple>";
    }

    private static String FGrQvY4dNdbFkC3pn() {
        return "<yellow>";
    }

    private static String FbrGs6AupbG2ff4uCq3N2e() {
        return "<white>";
    }

    private static String jOahiDJ9X7Q4RQhUB() {
        return "<obfuscated>";
    }

    private static String NU6zOGebWAIqbUzXCrqjc() {
        return "<bold>";
    }

    private static String wwZCcIHGviPJjjoLDc0xaL() {
        return "<strikethrough>";
    }

    private static String K9PLHWQWd9r3eZEcc() {
        return "<underlined>";
    }

    private static String SZbPpFpjPqvclWEOV3() {
        return "<italic>";
    }

    private static String PJnvCRIaoGTByOtF() {
        return "<reset>";
    }

    private static String R5PPOW2waOh8necg() {
        return "black";
    }

    private static String nRZpbEMxLQOBdv() {
        return "dark_blue";
    }

    private static String NoQH7Tg27S96aQ0B() {
        return "dark_green";
    }

    private static String eEakG4pXTbASeYYi() {
        return "dark_aqua";
    }

    private static String H6G9ZWSSBymoE49p() {
        return "dark_red";
    }

    private static String Rkq8iBAJzFp8VR() {
        return "dark_purple";
    }

    private static String IypUchPYvYGlcNY() {
        return "gold";
    }

    private static String Frmwo8fw2cTZVA6eDiX() {
        return "gray";
    }

    private static String Cys4BvS7XkCz23DnWeC8Yc() {
        return "grey";
    }

    private static String aRVm9swiuOQK7Lh23vzjA() {
        return "dark_gray";
    }

    private static String aYApwg5fdqrfyxl() {
        return "dark_grey";
    }

    private static String vSPqx70UUyhrYg6v() {
        return "blue";
    }

    private static String AE4dnTOrij8ZCGRv() {
        return "green";
    }

    private static String QR9hfQlTC1zQANrLyQ() {
        return "aqua";
    }

    private static String Yv0wQK0pi1dU7gk() {
        return "red";
    }

    private static String hpCJnD3snmNFHSY() {
        return "light_purple";
    }

    private static String i1XYf2DdkEwfPiB() {
        return "yellow";
    }

    private static String Dpgs0tMZlZJYo39qVG9FG() {
        return "white";
    }

    private static String FjSA0iJXVlRkYcyHS5() {
        return "color";
    }

    private static String DuaECYLM0KRuBzrn01b7IA() {
        return "colour";
    }

    private static String NwyXCJtgKujYnL7aNFv() {
        return "c";
    }

    private static String DTsG0fgikoZbIyE28cO() {
        return "gradient";
    }

    private static String KFKFxjUZgaWmsTJBY() {
        return "rainbow";
    }

    private static String sksXYaybORBsypMRkxM() {
        return "reset";
    }

    private static String f363GLpU3UIZF55() {
        return "bold";
    }

    private static String ngPCM0mbBCyUkOJ() {
        return "b";
    }

    private static String U9zAYuqFM3ahLiU6m() {
        return "italic";
    }

    private static String i5Oump9JXEZSAE() {
        return "i";
    }

    private static String XAsh18TWEQtf78PAC6() {
        return "em";
    }

    private static String VOfnw7sNnfYMLRKSfM9QJ5() {
        return "underlined";
    }

    private static String wHbSzTz4jXHnsnpRcetJkN() {
        return "u";
    }

    private static String NLYpA1wo4bZE9hcwKS() {
        return "strikethrough";
    }

    private static String Iz2XsMgrmHg02z9() {
        return "st";
    }

    private static String cu0WEQuHD1KIW88b7x() {
        return "obfuscated";
    }

    private static String JeblIzPzSI7DEn5dVZl0H() {
        return "obf";
    }

    private static String rp04dDyP9YkNJrKkck5n() {
        return "#[0-9a-fA-F]{6}";
    }
}
