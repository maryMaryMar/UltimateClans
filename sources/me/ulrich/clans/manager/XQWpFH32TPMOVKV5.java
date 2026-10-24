package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.AddonInfo;
import me.ulrich.clans.data.AddonList;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.TopData;
import me.ulrich.clans.interfaces.BannerModuleAPI;
import me.ulrich.clans.interfaces.MoneyImplement;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.Formatter;
import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.Serialize;
import me.ulrich.clans.manager.utils.Times;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/XQWpFH32TPMOVKV5.class */
public class XQWpFH32TPMOVKV5 {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private static volatile String PCSi20Kc4wmnJuCe12D;
    private static String q3SS6kynj7uYy0y0pRbJAV;
    private static volatile String wf9fHv5sOpMnaSQ7;
    private static volatile String kEwcfOHUugeVj3BVsN;
    private static String t7OFjbXgo9HnhH61MLco0m;
    private static volatile String bBgvpnRkmxUVuzBjrDOCd;
    private static volatile String mLhvR3vVJNneM9WamTbBeW;
    private static volatile String JHRxMlmOjzY9LXDqbcYQ;
    private static volatile String WIs15L7CiqWNRaDGZGRdu;
    private static String BvjzTVUPHnR4CqbV3g28;
    private static String VxaOqGhDWGXzxqlMFH;
    private static volatile String vm6BGGgkl0ojYZ;
    private static volatile String VtovqxWase9sQ34V;
    private static volatile String CySIpFg3mBWnLk;
    private static String YKN4173GTTksT9n;
    private static String irP50MLd88SYsPJxXAc;
    private static String mjsMAp78SIk7Kjt;
    private static volatile String H7h4XO78Mb5bFk;
    private static String rifyQPdCOFmV47pURdv;
    private static volatile String o5ij9NSxLnZx9HAewU;
    private static String xZGUJwWYxhIEJR1;
    private static String olLNXoO1qT3pXy3LNus;
    private static String nR8wFInfsm5IPFx;
    private static volatile String xvFq3xmQGEIey4R6;
    private static volatile String FPiIZMSeFjLfP5qRpyTH;
    private static volatile String EPi6NYTtShlL9KO;
    private static String KNyAAdfh6rcihv8ol;
    private static String NNTNVsWHLNGPMKHBPU;
    private static volatile String iWX4lirAdBzmcrohDw4;
    private static volatile String yGkWp42YaXGupxFLCwr;
    private static String j6HghMQ7ZoZXV7vfQgDyM;
    private static String yB0A7ngpKskD2m7;
    private static String tsrpaFtQ9v75o53CTv;
    private static volatile String B0i3mBDvi8bDdc;
    private static volatile String K3rWABaZPvhNuxhh7g;
    private static String fubtxpoT7ZWU2Y6fC5J;
    private static String Yaaxi6DjtgPaJJwijS;
    private static String y8nHbGJAkud2ZeqUX6hy;
    private static String P0KBKosLws7IiVpaTUWMK;
    private static String i8gfVonHzkcp1uOkb;
    private static String d2qlRc1ytuFrsRRppWybnh;
    private static String PyGwm7HY9CMVYD2gk7ct1M;
    private static volatile String VA2JKbIevxqoCZAjgD;
    private static String MzxOZ3N4LY0WsFB5xggeC;
    private static volatile String TktzWPGjxcGaMMGbRm13;
    private static volatile String EFi8nddUbujFhTTgN1Qe;
    private static volatile String rYNzLGkGssCORZj7D0Dy1;
    private static String DFrx5jQh2H6EgV;
    private static String SNohZwgELT13zHhiVIvOY;
    private static String TtKpAuMl3FoA1veG8k0ov;
    private static volatile String kHVflWcYfTng9Sdc;
    private static volatile String q2a7h4HzKYzW64l;
    private static String uwnRwPqxuTocse0gp2t;
    private static String UJp6SJhRBXf1rEpS;
    private static String PIidAw8LXf2SwltBw;
    private static volatile String yeOoV1ZoQfTwbTXtaJ;
    private static String cyam6Jg9Pr8i1tmo8;
    private static volatile String T1tOhr8XbRvEfZWDz;
    private static volatile String NhWNM2nCqgDeKUAk;
    private static volatile String AbgP97pOHshXpTsPRBi;
    private static volatile String nE9Nf2x2ys1xkQAnAeMD5S;
    private static String BKzQVGSIRLdUlfyeFu;
    private static volatile String QjafZgt1WlOEmncj8yfp;
    private static String lGRjOjefoLyboPu;
    private static String JVwUpkf8wiYYBlvNvCZHgA;
    private static volatile String Yl2OFhq2j9pBLTymQFx;
    private static volatile String fLdwposgEVfkxXJK1;
    private static volatile String BWHsHSCIolbkqi;
    private static String LIl5HnKWr3Ql6xUhFv2oH;
    private static volatile String kP3T6UBg30gMruBBa;
    private static volatile String ZQOeJvH8DaXN5i4KHs;
    private static volatile String qCyQbrwRYvpPpdB4XEc;
    private static volatile String yz20OdheKU168n4gj;
    private static volatile String XNPWdSGqhOGtQOEWu;
    private static volatile String IDP1b9f8O7kNZMMy2;
    private static volatile String fYFBTEnx7aAdnWTWD;
    private static volatile String qvNrgFPmEar4kAb1F;
    private static volatile String HTrKP01HFPzwXSIWLpXgN;
    private static String Vl3ZreKSUuBw8mZEYVa;
    private static volatile String uYoWEsixgKu4MqUvnS5jOj;
    private static volatile String SzipJHvwpX9dgEx4;
    private static String sGRHjuPGXSi0JQs95;
    private static String B8BOdB6p5iEGmVNIn0y;
    private static String MaNUaQiWMo5lPi;
    private static volatile String HwQDbGkaCqSgu6DP4M;
    private static String Ch8AFYUS6u0rCaCuB;
    private static volatile String LYBu1kt5UDAfKwNiad0Pi;
    private static volatile String JdB5Wku6wQAeBCc;
    private static volatile String QKpkJcutW90reyB6;
    private static volatile String XlqJk4lkEl1Kbh1Mr;
    private static String p7OPQL9AfuKgwM6v;
    private static String I69W2zZpthiXolMgyTvVln;
    private static String zl65D5ZNbhCCfggHxy;
    private static String WVhT8a1D4PkbQVh;
    private static String KvrL6mT9lhYMGgaR3g;
    private static String Hu9FavdNSW6WPYimOR;
    private static volatile String t5HwQWTJhb5gn0ynKH;
    private static String SjfWq8cbt3X4dPOsATz;
    private static volatile String QJgGCL9PhxU396;
    private static volatile String x48m7BC7r2Efbyf5dC4am;
    private static String xu6w4SpnpFb3U17E3;
    private static volatile String fHj29x9Ec2s2UQ;
    private static volatile String BI4RfZB4kzvEhQCZGzs;
    private static String XF55YhygiKz9fOsx10FT7;
    private static volatile String Ant3yHpSRyNNGhAL;
    private static String kMAFDYv3CirrI5atdn97mO;
    private static volatile String QM7NBqn6OQonM8OC6;
    private static volatile String bDoAWVhTrOVQCDY;
    private static String ZuuLgAPcaa9riw97kh5B;
    private static String bFe5mpLaCg67S0GgMHLJ;
    private static String Fn0NnHAt1yiqzBI6X9nj;
    private static volatile String GIsURZICi5iq7AM8NOT;
    private static String Bpaj2iRMjLU7qR7CWJfj;
    private static String LxqDBk0BXvY1eCE;
    private static String StfgqvrIV0xWXyt;
    private static String BUnvws6HhQkmdB9TEY;
    private static volatile String k9KrLEvHJTmrKfa;
    private static volatile String GxowK51jAsbJAHo0bXvs0;
    private static String ed2Pg1wY9BfQnqcOyc3ua;
    private static volatile String Arro6NEIX45vsNsu;
    private static String p1fT4N1jrxnhyy;
    private static volatile String e5oqowRTyLn9v9dTxkfy;
    private static volatile String Svpmm2UzR2hIM2BubOeJ1y;
    private static String ihmL0od54QmA6Vn8RkU5E;
    private static volatile String JtowqE1hFSXY5K4YWXW8;
    private static volatile String kVj0yPEHhSHwDc6tQFi;
    private static volatile String NJSFqx1Sm05NQgJN;
    private static volatile String WuGJM01yqD7QwhZwi4eRzu;
    private static volatile String lVfF7x48DJ79bjP7a;
    private static String St3l6tKr1SoK1ogic;
    private static String L6qLA2cFUY0sj9mnYIZ;
    private static volatile String KzLGNUi3pALcazveccDdN;
    private static volatile String ifJf1xtYw0MqYuC;
    private static String zesewkr6Aco4W81;
    private static String TdENhh0Ayt87O8Qyk5;
    private static String qw7SgjCUbIE4IdBOe0;
    private static volatile String IuBgyrmGqfHdGWLy7d7Cp;
    private static String Zse8CAB9KYtawx;
    private static volatile String gCH3YEdfsKVugfkFJ40;
    private static volatile String LF4POHtyxI2CcRwd;
    private static volatile String fhL4DUz0tBePuE7HqmnrB;
    private static volatile String rc4EZn7sfoSE7Yq8;
    private static volatile String lUcdzzePxkaykN6;
    private static volatile String kcewMUE5Pawy7cGtA;
    private static volatile String Q0LtajrkCSQNIAi4pJOwp;
    private static volatile String NHd7u5vTPHBKzf;
    private static String Ca2JKdHFzo4e9dUS;
    private static volatile String Z2l0LPGR5JCL4790en;
    private static String k91jt8SBosgR6IS;
    private static volatile String fxi1SwCrXn70Owa1;
    private static volatile String HB9hNtWrUJGYYtW3Wh;
    private static volatile String t8UxW3hOIP1CGUhewtQ;
    private static String SFjX6fbmHKHr38e16R;
    private static String Ek48zQ1acIEnXYar1umrkH;
    private static volatile String vRvkVABCeroEc5Z;
    private static volatile String WpsMjLhebEN9Rte;
    private static String Gf04k7nwM6l3JLk;
    private static volatile String hPS00qb84yVkEV7iQ;
    private static String wBXSyzORX4GlHo89nH;
    private static String qYAToxrToCSMoOo8Fv;
    private static String ZATuXZl9pcCWWsVBu;
    private static String nQmiJWNbN2SmpBxQ46SGW1;
    private static volatile String xYk9mOKIfXDAcCoTC7p4j;
    private static volatile String TB5MYvL7bYuuI23oiV;
    private static volatile String bOy9vbRO7mxkdf;
    private static volatile String mNlEHVv02ziDSOY2;
    private static volatile String Altjf0Do07oBfhO1UXb;
    private static String IfIHeCgVmOsmNvsTY;
    private static volatile String VDMJrHwmc2QQ3Yr4Q;
    private static String HgXkltNhv6TvsUAXM;
    private static String pE01qQgkpimnuzL0;
    private static volatile String nUJRve3IphQveyOH;
    private static String t07A5YQRNpNmt0U0LqEnC;
    private static String CJz9MSlPA7qRI3S7iEN5Fu;
    private static volatile String CWHjsUls0qkd5jRGFDpf;
    private static String jEBwlaZD51y0JSPaPKR;
    private static String rH96DuUBS7DJVDtr;
    private static String CoGcRMunwroZf9Vdx5vbx;
    private static volatile String r7DcOZ6WPCLhZEVCLyHt;
    private static String tgKhejBSqDlLXy;
    private static volatile String zWAFkmlYvfEsei;
    private static String FUlFcfTP4BuwjZ;
    private static volatile String W5eXNGTRrSxFPsIFSleO;
    private static volatile String Gorm2AjsaD6rIW;
    private static volatile String vmrnmyx1ZXfzMOhOB0pwf;
    private static volatile String unWcNMUbxuZQeGKijzWc;
    private static String Bw851uGewAFu1j;
    private static String BWNaiVvhPI3nuSe;
    private static volatile String GiklhsoPLrKnuGpiN3;
    private static String C8VEsGP2JT6VfDcRL;
    private static String HS9pK4rmA1J60ORtmRfX;
    private static String orOM6pwVrPT9BAonD4;
    private static volatile String gwUJC8piLHhtsmQH8L;
    private static String NnK0dPn4vsn1cqp9mqe98;
    private static String ft01TiodlvvSFOqGel;
    private static volatile String uwzd9sq3SHpP3VR;
    private static volatile String GD9lx4n7jR7RMMrnq;
    private static volatile String Hb7toQOPRA1Fo52;
    private static volatile String gBcjqrr3PhzPK4Q;
    private static String l2M4BcJIaT7fbgXPSu8u;
    private static volatile String LkZNqIL0mbBG1XOs3bDXK;
    private static String d6qxq9mmFnfO346g;
    private static volatile String bjvPJCxsYU56MC;
    private static String CKLYpvscFMM01e9jg;
    private static volatile String ncfmUBx45zSzZm0x;
    private static volatile String bEObiLvps5yxbKL7s5Maf;
    private static String uneuorQ07vFWi7D;
    private static String tkfZwEwOZZMwA0vSHA;
    private static volatile String QixUKWMeBj2D7dOOJW;
    private static String LcUkhdfYh69Eehtl;
    private static volatile String gRLWxMHPQ3CQa5N6GxMo;
    private static volatile String Ubavt8bFchXcTTvreZ;
    private static volatile String qVSnwWFjxebiol9q3I4c;
    private static String nsfDfSM0PcWdZAJgBIwB;
    private static String yEBX0yqJby9Cus;
    private static volatile String Gu1t1n3NnoetGWE;
    private static String hmI1QrzDSUWb072;
    private static volatile String WmMZFQJ4nODhve9;
    private static String L8vhAymLWP17TRg4gC8En;
    private static String SMBionX1Zh4O5aL4TAxb;
    private static volatile String SF8B7TAbQyaDtpQN3;
    private static String FFWnrlcRXkKApx;
    private static volatile String kj7rXENsJxoxGGgHiEYpqi;
    private static volatile String EZnZlIS4NlDNLiWfcDAPc;
    private static volatile String IiU5p1ViEw26joT;
    private static volatile String VrZtVROVSAztBO;
    private static volatile String dYGrZ4uw9Gk303onTmVqtc;
    private static String ZStZ7jh246mGa1S4bOa;
    private static volatile String NEJvaSTXgB0kKYAPwWI;
    private static String ShCuYHtXAo8MYxo;
    private static volatile String XQw1STnqlxT47aCJ2v;
    private static String IG4lyo0sQUWtqJW;
    private static String OrSqefMtWTcHE2dfREvv;
    private static volatile String bSUxlKN7HyCF3zyVPuNZ;
    private static String W5saG0Qwmh3bBlUHjCr;
    private static volatile String PVluPvZ5xTstiw;
    private static volatile String WsVq77ckYDl4v90RSNZQKw;
    private static volatile String a4QdCXXGhVr2WV3V;
    private static String YWwroQYnjeTUAmGo1X;
    private static volatile String Il7H6tacN99dvllkTQ1mo;
    private static volatile String j05x319Ho1Mq18l70O;
    private static volatile String MLL7sfsSHBE76csyA45h;
    private static volatile String peUFLc1nLYvHbqiwxynJ;
    private static String dVWGWfnwLgTGdP9t48;
    private static String BPOOe9ViwenKhRIAeoOX;
    private static String xDh2NyeBcvuErUpVhCCnAF;
    private static volatile String WTY3vVTXyKmiGmke6;
    private static String yJaTDe9JvMWRE1Wx3qx;
    private static String wP9TdYnWZFCTGCEF7X1;
    private static String s0o0bWArYfIuBi;
    private static String kKnILgheS2mDnJyBX56;
    private static volatile String AcgMcS2pkiLh02a8PhP2;
    private static volatile String zLVQrIid7Qq0Wqbq5TUaC;
    private static String WjSdQzRKk0VRwdL;
    private static String aJPJt7eyNunVIw;
    private static volatile String N8DzvnXwycKa9Mqyr;
    private static String cwyaJ8YTFpymiBiE;
    private static String RPf8euCLOxtbQF0ksI07;
    private static volatile String l95T0Pxakp2Ju5U81UvN;
    private static String HkA78t8QoWEmacSagxH8Sp;
    private static volatile String bA2gnzAUJioAICJrkI6zSC;
    private static String vr7XTyceF7VsdyP41;
    private static volatile String VSKXIwFrdMdRec0p2fcAMt;
    private static volatile String wTUzMoPbuBjweED3TnW;
    private static String BpdK5XreljpL989P8bc;
    private static String RiMR7NKbTVU2M7hUS4anCg;
    private static String duWzGJgNrDcFXbwf;
    private static String IxFmewfTxGVwduPHJZ;
    private static volatile String qa6HijMad3NGZjwqkE;
    private static volatile String psoJAPcV335PtvvME;
    private static volatile String CUTxFLGsxpe0iLEzVrmO;
    private static String SvgF4WJUCXVTuukaZ6c;
    private static String D9463Nqk28ABkTaKRCNvhx;
    private static volatile String smOm7IOX5FtTaM6x5qNBa;
    private static String KNrrvtL5UFtBCc7qi;
    private static String zqphmid0dcPLhgh;
    private static volatile String o9tGbxVQRgEEOSeQmUtcoH;
    private static String ujpUMtLtJ6i1Ky8c;
    private static volatile String Ffo3x7P66996PqUh1bL;
    private static volatile String ctmOldBrSHxisw5xQZqVI;
    private static String jsgLC4GM9DuJVTHaVe64;
    private static String H4lTLZ7lD2W7ENsvr;
    private static String dJIchAjZMym7ztO;
    private static volatile String ztkdKyoYaPJ9vPBLdbA7X;
    private static String vSTpEMIhWRksCCPhlo7Xd;
    private static volatile String gtPTsfwt3efy6C2cdwYfum;
    private static String fdUB5zKAz5MvcOMeqkj;
    private static volatile String FpTWJZiqkFOviTYLv;
    private static volatile String IdHQPVQ0HafyzxN2R7Nmi;
    private static volatile String dC0iFAhr3tRDbRJLfA42;
    private static volatile String O6K4jssmlrTNlF;
    private static volatile String FsuwnXE8CJDu5udHWfpKEJ;
    private static String COUaPcwpjoOldQ4VNsjFw;
    private static volatile String KrrMLkSZkeIiOnA;
    private static String xT4QB7nnyn8kwL17JEE;
    private static volatile String XiqAXTCDkMtaumLK4Q31D;
    private static String XH2buo3lLu0TV28f9tYUnQ;
    private static volatile String qQAYMfvAXMQiAxJf4;
    private static String Ro36vAt54aXMCp;
    private static volatile String UkSVNTW5XzRIUoVq5rHR;
    private static final byte[] NqyEBaCjzGLxg67BLkj = {(byte) 151, (byte) 249, (byte) 86, (byte) 207, (byte) 145, (byte) 235, (byte) 212, (byte) 84, (byte) 202, (byte) 118, (byte) 11, (byte) 220, (byte) 37, (byte) 87, (byte) 46, (byte) 213};
    private static final byte[] lpN8yzcOh2Dq0naZrWp0 = {(byte) 96, (byte) 17, (byte) 233, (byte) 1, (byte) 103, (byte) 33, (byte) 237, (byte) 189, (byte) 182, (byte) 66, (byte) 226, (byte) 149, (byte) 21, (byte) 29, (byte) 153, (byte) 220};
    private static final byte[] qvFJnqD0QmpSDuYGJ = {(byte) 26, (byte) 159, (byte) 16, (byte) 201, (byte) 101, (byte) 121, (byte) 66, (byte) 249, (byte) 149, (byte) 30, (byte) 224, (byte) 246, (byte) 29, (byte) 48, (byte) 97, (byte) 88, (byte) 52, (byte) 200, (byte) 99, (byte) 155, (byte) 227, (byte) 55, (byte) 123, (byte) 144, (byte) 113, (byte) 134, (byte) 167, (byte) 230, (byte) 153, (byte) 172, (byte) 214, (byte) 128};
    private static final byte[] VKfYLDhI3YQW6ONpkfjxja = {(byte) 151, (byte) 249, (byte) 86, (byte) 207, (byte) 145, (byte) 235, (byte) 212, (byte) 84, (byte) 202, (byte) 118, (byte) 11, (byte) 220, (byte) 37, (byte) 87, (byte) 46, (byte) 213};
    private static final byte[] N8eagSrLUCPNeDmSLc = {(byte) 97, (byte) 212, (byte) 109, (byte) 16, (byte) 27, (byte) 137, (byte) 23, (byte) 136, (byte) 244, (byte) 65, (byte) 100, (byte) 76, (byte) 91, (byte) 65, (byte) 222, (byte) 196};
    private static final byte[] a7vB5DMwDS6p9hNO = {(byte) 232, (byte) 114, (byte) 114, (byte) 88, (byte) 28, (byte) 80, (byte) 193, (byte) 238, (byte) 105, (byte) 113, (byte) 247, (byte) 6, (byte) 44, (byte) 153, (byte) 89, (byte) 112};
    private static final byte[] t2VBa61RaqGiv9ntcgo8f = {(byte) 151, (byte) 249, (byte) 86, (byte) 207, (byte) 145, (byte) 235, (byte) 212, (byte) 84, (byte) 202, (byte) 118, (byte) 11, (byte) 220, (byte) 37, (byte) 87, (byte) 46, (byte) 213};
    private static final byte[] k5DIOvH2UVAxRvRTlSagA = {(byte) 113, (byte) 118, (byte) 20, (byte) 230, (byte) 47, (byte) 177, (byte) 60, (byte) 245, (byte) 233, (byte) 191, (byte) 130, (byte) 81, (byte) 109, (byte) 209, (byte) 237, (byte) 220, (byte) 214, (byte) 8, (byte) 88, (byte) 144, (byte) 148, (byte) 77, (byte) 163, (byte) 191, (byte) 167, (byte) 196, (byte) 126, (byte) 204, (byte) 111, (byte) 66, (byte) 208, (byte) 146};
    private static final byte[] Wp7E7Y6eeslAGxCT6dRx = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] OKRPQYm1ZiV96i0i = {(byte) 151, (byte) 249, (byte) 86, (byte) 207, (byte) 145, (byte) 235, (byte) 212, (byte) 84, (byte) 202, (byte) 118, (byte) 11, (byte) 220, (byte) 37, (byte) 87, (byte) 46, (byte) 213};
    private static final byte[] Ucx17eYiazO1sjSE2s = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] uOofz8335Z9bCRMA = {(byte) 30, (byte) 181, (byte) 88, (byte) 92, (byte) 50, (byte) 64, (byte) 48, (byte) 30, (byte) 245, (byte) 242, (byte) 227, (byte) 186, (byte) 176, (byte) 56, (byte) 108, (byte) 84};
    private static final byte[] pYAsXSa1voocyN3b9wFB6G = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] E3JBUfanLTCrnmcFut14 = {(byte) 89, (byte) 238, (byte) 254, (byte) 131, (byte) 55, (byte) 13, (byte) 249, (byte) 176, (byte) 41, (byte) 44, (byte) 85, (byte) 218, (byte) 109, (byte) 159, (byte) 185, (byte) 174};
    private static final byte[] SrNkoRMdFAQwkJH9 = {(byte) 100, (byte) 77, (byte) 191, (byte) 143, (byte) 215, (byte) 72, (byte) 143, (byte) 94, (byte) 194, (byte) 78, (byte) 57, (byte) 44, (byte) 216, (byte) 184, (byte) 59, (byte) 3};
    private static final byte[] PUPfXy6Va5tRF8GClRbV = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] yWLhTuWZS4EIbOOIE = {(byte) 120, (byte) 174, (byte) 74, (byte) 59, (byte) 167, (byte) 110, (byte) 106, (byte) 254, (byte) 118, (byte) 173, (byte) 6, (byte) 41, (byte) 10, (byte) 183, (byte) 251, (byte) 253};
    private static final byte[] lMFnJWjI8TmiiN6Ik = {(byte) 183, (byte) 23, (byte) 47, (byte) 52, (byte) 75, (byte) 155, (byte) 254, (byte) 100, (byte) 157, (byte) 238, (byte) 92, (byte) 129, (byte) 21, (byte) 159, (byte) 94, (byte) 193};
    private static final byte[] RAeLwHKDIsubsIT = {(byte) 78, (byte) 100, (byte) 98, (byte) 124, (byte) 199, (byte) 76, (byte) 38, (byte) 12, (byte) 100, (byte) 200, (byte) 192, (byte) 222, (byte) 238, (byte) 8, (byte) 103, (byte) 146, (byte) 106, (byte) 184, (byte) 232, (byte) 36, (byte) 146, (byte) 216, (byte) 72, (byte) 188, (byte) 17, (byte) 136, (byte) 222, (byte) 236, (byte) 166, (byte) 93, (byte) 239, (byte) 191};
    private static final byte[] D2cDyQqBAfBmqoFI1 = {(byte) 78, (byte) 100, (byte) 98, (byte) 124, (byte) 199, (byte) 76, (byte) 38, (byte) 12, (byte) 100, (byte) 200, (byte) 192, (byte) 222, (byte) 238, (byte) 8, (byte) 103, (byte) 146, (byte) 15, (byte) 230, (byte) 163, (byte) 219, (byte) 42, (byte) 57, (byte) 111, (byte) 181, (byte) 238, (byte) 21, (byte) 88, (byte) 78, (byte) 73, (byte) 241, (byte) 166, (byte) 177};
    private static final byte[] ccn6INvNt1gxxR9 = {(byte) 14, (byte) 202, (byte) 200, (byte) 18, (byte) 50, (byte) 166, (byte) 127, (byte) 226, (byte) 214, (byte) 76, (byte) 191, (byte) 153, (byte) 234, (byte) 143, (byte) 211, (byte) 228, (byte) 177, (byte) 109, (byte) 30, (byte) 8, (byte) 3, (byte) 138, (byte) 61, (byte) 60, (byte) 81, (byte) 57, (byte) 163, (byte) 154, (byte) 162, (byte) 235, (byte) 39, (byte) 102};
    private static final byte[] Ouaryh4CEoYDuzW306P0 = {(byte) 97, (byte) 154, (byte) 1, (byte) 72, (byte) 253, (byte) 164, (byte) 23, (byte) 142, (byte) 228, (byte) 47, (byte) 160, (byte) 21, (byte) 218, (byte) 203, (byte) 105, (byte) 84, (byte) 109, (byte) 78, (byte) 200, (byte) 232, (byte) 121, (byte) 195, (byte) 190, (byte) 233, (byte) 228, (byte) 14, (byte) 145, (byte) 201, (byte) 31, (byte) 178, (byte) 14, (byte) 184};
    private static final byte[] nJ4LnZC4ZHk4n5zyR04l = {(byte) 222, (byte) 67, (byte) 35, (byte) 23, (byte) 69, (byte) 57, (byte) 136, (byte) 148, (byte) 236, (byte) 246, (byte) 67, (byte) 84, (byte) 181, (byte) 221, (byte) 58, (byte) 103, (byte) 38, (byte) 132, (byte) 140, (byte) 175, (byte) 207, (byte) 53, (byte) 131, (byte) 68, (byte) 198, (byte) 107, (byte) 31, (byte) 205, (byte) 193, (byte) 68, (byte) 136, (byte) 78};
    private static final byte[] DXzleQAVA6IbEVR = {(byte) 0, (byte) 193, (byte) 82, (byte) 231, (byte) 152, (byte) 191, (byte) 121, (byte) 154, (byte) 57, (byte) 241, (byte) 66, (byte) 179, (byte) 88, (byte) 179, (byte) 107, (byte) 248};
    private static final byte[] pUbiKiseE4VAfXZINs = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] rIG4c9Bt3eIiLelg = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] B7pnm8ag1eMxs3l = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] YVlUhR5SeQ0Qyv2ejmv = {(byte) 106, (byte) 125, (byte) 243, (byte) 148, (byte) 159, (byte) 51, (byte) 54, (byte) 253, (byte) 179, (byte) 193, (byte) 96, (byte) 223, (byte) 47, (byte) 107, (byte) 39, (byte) 49, (byte) 129, (byte) 255, (byte) 49, (byte) 205, (byte) 6, (byte) 245, (byte) 10, (byte) 163, (byte) 86, (byte) 88, (byte) 98, (byte) 3, (byte) 253, (byte) 204, (byte) 194, (byte) 80};
    private static final byte[] UBFaJxtwos32SAj0 = {(byte) 220, (byte) 3, (byte) 44, (byte) 9, (byte) 144, (byte) 176, (byte) 246, (byte) 213, (byte) 43, (byte) 208, (byte) 45, (byte) 82, (byte) 175, (byte) 93, (byte) 7, (byte) 213};
    private static final byte[] r2eHUFItWOIroEp5 = {(byte) 172, (byte) 151, (byte) 170, (byte) 85, (byte) 188, (byte) 211, (byte) 213, (byte) 90, (byte) 192, (byte) 6, (byte) 105, (byte) 19, (byte) 82, (byte) 23, (byte) 133, (byte) 125};
    private static final byte[] bMvrhsYNmoVkNZZUlqD = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] YkfcQdFYXYjlMBb0k7nAHO = {(byte) 37, (byte) 25, (byte) 94, (byte) 72, (byte) 97, (byte) 201, (byte) 93, (byte) 111, (byte) 234, (byte) 88, (byte) 61, (byte) 24, (byte) 201, (byte) 254, (byte) 175, (byte) 212};
    private static final byte[] DgMKtso5ecwXIUuTe = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] vhwfLgwcRmFSjnZ = {(byte) 113, (byte) 64, (byte) 170, (byte) 138, (byte) 37, (byte) 152, (byte) 60, (byte) 129, (byte) 249, (byte) 212, (byte) 69, (byte) 170, (byte) 32, (byte) 102, (byte) 73, (byte) 231};
    private static final byte[] aApMc0w7vdclKOXaY9YY = {(byte) 89, (byte) 238, (byte) 254, (byte) 131, (byte) 55, (byte) 13, (byte) 249, (byte) 176, (byte) 41, (byte) 44, (byte) 85, (byte) 218, (byte) 109, (byte) 159, (byte) 185, (byte) 174};
    private static final byte[] mRwDkFp3gAaiUkyM = {(byte) 32, (byte) 148, (byte) 178, (byte) 54, (byte) 218, (byte) 2, (byte) 136, (byte) 91, (byte) 147, (byte) 44, (byte) 139, (byte) 200, (byte) 218, (byte) 212, (byte) 1, (byte) 84};
    private static final byte[] xHf7z5SxkbquKq = {(byte) 38, (byte) 189, (byte) 79, (byte) 33, (byte) 105, (byte) 156, (byte) 251, (byte) 193, (byte) 236, (byte) 185, (byte) 75, (byte) 93, (byte) 78, (byte) 153, (byte) 88, (byte) 162};
    private static final byte[] jPZOYuQ21opYJOj = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] oAchjiWJGjK8TeRG0YtHB = {(byte) 70, (byte) 0, (byte) 214, (byte) 222, (byte) 77, (byte) 94, (byte) 17, (byte) 33, (byte) 125, (byte) 224, (byte) 245, (byte) 111, (byte) 217, (byte) 237, (byte) 9, (byte) 125, (byte) 251, (byte) 51, (byte) 119, (byte) 114, (byte) 157, (byte) 107, (byte) 186, (byte) 4, (byte) 227, (byte) 64, (byte) 177, (byte) 33, (byte) 41, (byte) 124, (byte) 167, (byte) 13};
    private static final byte[] bJBbZLZDfiiCDIqHR3h2 = {(byte) 78, (byte) 248, (byte) 169, (byte) 111, (byte) 44, (byte) 192, (byte) 156, (byte) 203, (byte) 10, (byte) 203, (byte) 166, (byte) 158, (byte) 194, (byte) 238, (byte) 229, (byte) 255};
    private static final byte[] Whe3NfW13lZPrq = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] Q7D5d1nbqxqxELikH = {(byte) 149, (byte) 25, (byte) 154, (byte) 2, (byte) 36, (byte) 177, (byte) 6, (byte) 209, (byte) 1, (byte) 163, (byte) 52, (byte) 250, (byte) 157, (byte) 81, (byte) 83, (byte) 208};
    private static final byte[] Lo49gf3aenIupqV4n = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] ByXj74545tgEbaiqMQ93k = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] w1SXfiyQaZrkX8q6y = {(byte) 0, (byte) 103, (byte) 225, (byte) 127, (byte) 106, (byte) 115, (byte) 181, (byte) 87, (byte) 113, (byte) 174, (byte) 48, (byte) 29, (byte) 49, (byte) 177, (byte) 177, (byte) 105};
    private static final byte[] eUT1d4CwOinz7g5x = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] gxe3TN5T2lXSrrQyl = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] wl0oDR7wbYyIQE = {(byte) 85, (byte) 40, (byte) 184, (byte) 200, (byte) 208, (byte) 215, (byte) 32, (byte) 67, (byte) 199, (byte) 36, (byte) 109, (byte) 36, (byte) 108, (byte) 107, (byte) 82, (byte) 108, (byte) 216, (byte) 120, (byte) 153, (byte) 33, (byte) 206, (byte) 189, (byte) 161, (byte) 21, (byte) 7, (byte) 48, (byte) 144, (byte) 25, (byte) 131, (byte) 77, (byte) 61, (byte) 181};
    private static final byte[] jXmRNmBCBuCHcP3 = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] dY7Omku0FUXFjHtqfdSh = {(byte) 111, (byte) 203, (byte) 176, (byte) 167, (byte) 13, (byte) 192, (byte) 224, (byte) 214, (byte) 14, (byte) 63, (byte) 127, (byte) 209, (byte) 115, (byte) 245, (byte) 74, (byte) 191, (byte) 50, (byte) 201, (byte) 88, (byte) 226, (byte) 111, (byte) 11, (byte) 67, (byte) 213, (byte) 67, (byte) 207, (byte) 29, (byte) 249, (byte) 227, (byte) 184, (byte) 12, (byte) 219};
    private static final byte[] ojoFGZSAW3adAlj = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] B9y8YJ8B9KtrMt1WUg = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] VUOnKUQ0uLY4eOVW1R44F = {(byte) 116, (byte) 161, (byte) 11, (byte) 103, (byte) 227, (byte) 148, (byte) 131, (byte) 191, (byte) 77, (byte) 177, (byte) 86, (byte) 62, (byte) 149, (byte) 164, (byte) 242, (byte) 216};
    private static final byte[] xtTJVY92JJScJiOvjq1Gw = {(byte) 96, (byte) 59, (byte) 170, (byte) 210, (byte) 4, (byte) 195, (byte) 212, (byte) 163, (byte) 134, (byte) 64, (byte) 57, (byte) 236, (byte) 252, (byte) 153, (byte) 170, (byte) 211};
    private static final byte[] XY7QSxJsENVzCXvAc6a = {(byte) 78, (byte) 16, (byte) 32, (byte) 111, (byte) 103, (byte) 85, (byte) 101, (byte) 164, (byte) 253, (byte) 14, (byte) 183, (byte) 224, (byte) 238, (byte) 195, (byte) 1, (byte) 248};
    private static final byte[] nVy9BL4cTzXvCIcKY = {(byte) 141, (byte) 64, (byte) 203, (byte) 137, (byte) 122, (byte) 100, (byte) 89, (byte) 235, (byte) 39, (byte) 94, (byte) 235, (byte) 72, (byte) 80, (byte) 115, (byte) 237, (byte) 137};
    private static final byte[] HesnHQ74hnoHTCw = {(byte) 102, (byte) 86, (byte) 31, (byte) 105, (byte) 209, (byte) 0, (byte) 193, (byte) 225, (byte) 22, (byte) 123, (byte) 57, (byte) 16, (byte) 28, (byte) 94, (byte) 15, (byte) 87, (byte) 153, (byte) 195, (byte) 191, (byte) 46, (byte) 119, (byte) 83, (byte) 162, (byte) 189, (byte) 29, (byte) 99, (byte) 57, (byte) 144, (byte) 238, (byte) 180, (byte) 79, (byte) 106};
    private static final byte[] MTEn9wHtg9t2Zbh1Ch = {(byte) 141, (byte) 64, (byte) 203, (byte) 137, (byte) 122, (byte) 100, (byte) 89, (byte) 235, (byte) 39, (byte) 94, (byte) 235, (byte) 72, (byte) 80, (byte) 115, (byte) 237, (byte) 137};
    private static final byte[] fLqzHJ5U9EZAyS = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] BeGWDxgJIQrxFi = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] Gb1ea2jvZ2vOlu2gP37K = {(byte) 154, (byte) 231, (byte) 25, (byte) 31, (byte) 39, (byte) 166, (byte) 52, (byte) 123, (byte) 243, (byte) 197, (byte) 69, (byte) 82, (byte) 162, (byte) 160, (byte) 98, (byte) 245, (byte) 62, (byte) 169, (byte) 46, (byte) 26, (byte) 196, (byte) 131, (byte) 61, (byte) 85, (byte) 183, (byte) 98, (byte) 48, (byte) 118, (byte) 16, (byte) 146, (byte) 40, (byte) 222};
    private static final byte[] xelM6jmx1iTU6ADsu = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] xakga9lkToHg5WTeN = {(byte) 227, (byte) 135, (byte) 93, (byte) 10, (byte) 181, (byte) 133, (byte) 203, (byte) 176, (byte) 64, (byte) 58, (byte) 57, (byte) 160, (byte) 31, (byte) 98, (byte) 163, (byte) 230};
    private static final byte[] ZTJw6bgkUrUy9OwV = {(byte) 216, (byte) 161, (byte) 116, (byte) 97, (byte) 115, (byte) 53, (byte) 242, (byte) 118, (byte) 32, (byte) 110, (byte) 58, (byte) 131, (byte) 95, (byte) 201, (byte) 144, (byte) 200, (byte) 66, (byte) 241, (byte) 115, (byte) 36, (byte) 193, (byte) 49, (byte) 65, (byte) 142, (byte) 73, (byte) 109, (byte) 92, (byte) 90, (byte) 128, (byte) 173, (byte) 59, (byte) 177};
    private static final byte[] pYUc76yrqQi9bHHbJTdnp4 = {(byte) 36, (byte) 224, (byte) 109, (byte) 59, (byte) 167, (byte) 74, (byte) 137, (byte) 180, (byte) 117, (byte) 109, (byte) 141, (byte) 49, (byte) 132, (byte) 58, (byte) 39, (byte) 226, (byte) 4, (byte) 17, (byte) 38, (byte) 220, (byte) 7, (byte) 202, (byte) 108, (byte) 155, (byte) 85, (byte) 216, (byte) 217, (byte) 154, (byte) 40, (byte) 190, (byte) 96, (byte) 22};
    private static final byte[] rWouCumYKvceeTEjX3mN = {(byte) 24, (byte) 132, (byte) 154, (byte) 80, (byte) 76, (byte) 14, (byte) 170, (byte) 223, (byte) 88, (byte) 150, (byte) 100, (byte) 33, (byte) 252, (byte) 190, (byte) 252, (byte) 14};
    private static final byte[] SQRSSedcADosw11 = {(byte) 158, (byte) 55, (byte) 238, (byte) 212, (byte) 194, (byte) 16, (byte) 150, (byte) 66, (byte) 254, (byte) 102, (byte) 3, (byte) 9, (byte) 165, (byte) 25, (byte) 161, (byte) 174};
    private static final byte[] agrl5KbFBktpy31WP = {(byte) 232, (byte) 114, (byte) 114, (byte) 88, (byte) 28, (byte) 80, (byte) 193, (byte) 238, (byte) 105, (byte) 113, (byte) 247, (byte) 6, (byte) 44, (byte) 153, (byte) 89, (byte) 112};
    private static final byte[] SEwHgVvoYfa1vbdKZl = {(byte) 21, (byte) 78, (byte) 155, (byte) 82, (byte) 1, (byte) 192, (byte) 13, (byte) 155, (byte) 195, (byte) 197, (byte) 7, (byte) 175, (byte) 61, (byte) 20, (byte) 55, (byte) 91};
    private static final byte[] lFDP6V6TFG0Rkbkn6RyC4 = {(byte) 58, (byte) 76, (byte) 120, (byte) 69, (byte) 156, (byte) 128, (byte) 228, (byte) 68, (byte) 80, (byte) 82, (byte) 3, (byte) 1, (byte) 14, (byte) 9, (byte) 34, (byte) 241, (byte) 22, (byte) 127, (byte) 68, (byte) 23, (byte) 53, (byte) 81, (byte) 46, (byte) 210, (byte) 98, (byte) 62, (byte) 29, (byte) 35, (byte) 31, (byte) 95, (byte) 203, (byte) 168, (byte) 134, (byte) 16, (byte) 108, (byte) 57, (byte) 199, (byte) 7, (byte) 144, (byte) 161, (byte) 248, (byte) 116, (byte) 177, (byte) 213, (byte) 113, (byte) 193, (byte) 177, (byte) 94};
    private static final byte[] gEdCjHPWReMsKiLxS9Pv = {(byte) 241, (byte) 148, (byte) 200, (byte) 202, (byte) 238, (byte) 68, (byte) 117, (byte) 37, (byte) 140, (byte) 230, (byte) 203, (byte) 242, (byte) 6, (byte) 188, (byte) 75, (byte) 178};
    private static final byte[] JJE0ndtcpmxPKtutS = {(byte) 187, (byte) 42, (byte) 24, (byte) 238, (byte) 180, (byte) 200, (byte) 224, (byte) 112, (byte) 100, (byte) 71, (byte) 30, (byte) 49, (byte) 251, (byte) 75, (byte) 16, (byte) 114};
    private static final byte[] UYXj8QZUNdqnPNWTir7F3 = {(byte) 188, (byte) 30, (byte) 78, (byte) 72, (byte) 52, (byte) 214, (byte) 118, (byte) 202, (byte) 95, (byte) 22, (byte) 244, (byte) 67, (byte) 52, (byte) 128, (byte) 64, (byte) 213};
    private static final byte[] TxpskLqLIn5gXTS3m = {(byte) 162, (byte) 6, (byte) 13, (byte) 197, (byte) 74, (byte) 169, (byte) 153, (byte) 202, (byte) 119, (byte) 52, (byte) 165, (byte) 197, (byte) 254, (byte) 125, (byte) 17, (byte) 64};
    private static final byte[] bLWCzYqp2h1GGWH0 = {(byte) 28, (byte) 125, (byte) 25, (byte) 213, (byte) 96, (byte) 64, (byte) 192, (byte) 30, (byte) 21, (byte) 30, (byte) 219, (byte) 156, (byte) 216, (byte) 249, (byte) 175, (byte) 18};
    private static final byte[] AkDndb6kRFp3n8 = {(byte) 116, (byte) 114, (byte) 81, (byte) 167, (byte) 183, (byte) 200, (byte) 158, (byte) 162, (byte) 205, (byte) 26, (byte) 254, (byte) 239, (byte) 121, (byte) 27, (byte) 224, (byte) 74};
    private static final byte[] VrcAQI2M7myFyUs87QZe = {(byte) 183, (byte) 23, (byte) 47, (byte) 52, (byte) 75, (byte) 155, (byte) 254, (byte) 100, (byte) 157, (byte) 238, (byte) 92, (byte) 129, (byte) 21, (byte) 159, (byte) 94, (byte) 193};
    private static final byte[] fShphNHKMSDUxwHKiw = {(byte) 9, (byte) 223, (byte) 227, (byte) 102, (byte) 152, (byte) 239, (byte) 227, (byte) 21, (byte) 223, (byte) 139, (byte) 142, (byte) 130, (byte) 113, (byte) 84, (byte) 216, (byte) 125, (byte) 16, (byte) 107, (byte) 185, (byte) 105, (byte) 136, (byte) 64, (byte) 131, (byte) 127, (byte) 16, (byte) 103, (byte) 230, (byte) 94, (byte) 139, (byte) 250, (byte) 142, (byte) 34};
    private static final byte[] K2SiWX37Wl3f9gM = {(byte) 193, (byte) 116, (byte) 162, (byte) 199, (byte) 145, (byte) 73, (byte) 23, (byte) 172, (byte) 15, (byte) 172, (byte) 138, (byte) 53, (byte) 166, (byte) 231, (byte) 136, (byte) 46};
    private static final byte[] GoXUKMsASFtlMjCJOx = {(byte) 187, (byte) 42, (byte) 24, (byte) 238, (byte) 180, (byte) 200, (byte) 224, (byte) 112, (byte) 100, (byte) 71, (byte) 30, (byte) 49, (byte) 251, (byte) 75, (byte) 16, (byte) 114};
    private static final byte[] SdTzsS02sgmBTdxliH = {(byte) 68, (byte) 242, (byte) 170, (byte) 178, (byte) 201, (byte) 108, (byte) 223, (byte) 76, (byte) 223, (byte) 141, (byte) 37, (byte) 16, (byte) 246, (byte) 180, (byte) 183, (byte) 110, (byte) 113, (byte) 220, (byte) 213, (byte) 35, (byte) 91, (byte) 41, (byte) 70, (byte) 131, (byte) 160, (byte) 128, (byte) 85, (byte) 61, (byte) 129, (byte) 131, (byte) 47, (byte) 125};
    private static final byte[] OHK1tNgwRUmNSvm59zqkro = {(byte) 243, (byte) 93, (byte) 177, (byte) 48, (byte) 125, (byte) 228, (byte) 39, (byte) 46, (byte) 97, (byte) 25, (byte) 50, (byte) 120, (byte) 23, (byte) 169, (byte) 71, (byte) 232};
    private static final byte[] bxPmlDMSOgGImlWpW8 = {(byte) 210, (byte) 26, (byte) 244, (byte) 208, (byte) 128, (byte) 247, (byte) 70, (byte) 42, (byte) 150, (byte) 53, (byte) 252, (byte) 223, (byte) 172, (byte) 96, (byte) 215, (byte) 140};
    private static final byte[] SG25nzAO3WbgWuz6 = {(byte) 111, (byte) 220, (byte) 35, (byte) 104, (byte) 56, (byte) 254, (byte) 225, (byte) 174, (byte) 38, (byte) 73, (byte) 185, (byte) 43, (byte) 74, (byte) 67, (byte) 110, (byte) 140, (byte) 151, (byte) 194, (byte) 127, (byte) 177, (byte) 204, (byte) 236, (byte) 81, (byte) 76, (byte) 234, (byte) 162, (byte) 79, (byte) 166, (byte) 51, (byte) 210, (byte) 168, (byte) 210};
    private static final byte[] oncZTYiPn9aauxER6n4 = {(byte) 231, (byte) 173, (byte) 139, (byte) 72, (byte) 144, (byte) 162, (byte) 108, (byte) 242, (byte) 63, (byte) 194, (byte) 106, (byte) 219, (byte) 239, (byte) 31, (byte) 204, (byte) 128};
    private static final byte[] yBbLCW0rTgRuzzWVWCz = {(byte) 241, (byte) 148, (byte) 200, (byte) 202, (byte) 238, (byte) 68, (byte) 117, (byte) 37, (byte) 140, (byte) 230, (byte) 203, (byte) 242, (byte) 6, (byte) 188, (byte) 75, (byte) 178};
    private static final byte[] wTBWQy26EF58pbHNEEKnr = {(byte) 187, (byte) 42, (byte) 24, (byte) 238, (byte) 180, (byte) 200, (byte) 224, (byte) 112, (byte) 100, (byte) 71, (byte) 30, (byte) 49, (byte) 251, (byte) 75, (byte) 16, (byte) 114};
    private static final byte[] HBYJASofwAm2yQzY = {(byte) 211, (byte) 122, (byte) 216, (byte) 218, (byte) 64, (byte) 19, (byte) 174, (byte) 13, (byte) 192, (byte) 3, (byte) 211, (byte) 36, (byte) 121, (byte) 207, (byte) 243, (byte) 120, (byte) 123, (byte) 239, (byte) 215, (byte) 201, (byte) 118, (byte) 202, (byte) 125, (byte) 146, (byte) 206, (byte) 240, (byte) 179, (byte) 100, (byte) 210, (byte) 58, (byte) 36, (byte) 253};
    private static final byte[] X9hMwErqA102erfQju4ce = {(byte) 169, (byte) 110, (byte) 3, (byte) 99, (byte) 255, (byte) 85, (byte) 38, (byte) 56, (byte) 17, (byte) 230, (byte) 9, (byte) 161, (byte) 223, (byte) 18, (byte) 193, (byte) 183, (byte) 171, (byte) 92, (byte) 160, (byte) 165, (byte) 220, (byte) 8, (byte) 2, (byte) 9, (byte) 223, (byte) 213, (byte) 4, (byte) 182, (byte) 42, (byte) 236, (byte) 108, (byte) 75};
    private static final byte[] U7nGzNqCTQO0l8 = {(byte) 211, (byte) 122, (byte) 216, (byte) 218, (byte) 64, (byte) 19, (byte) 174, (byte) 13, (byte) 192, (byte) 3, (byte) 211, (byte) 36, (byte) 121, (byte) 207, (byte) 243, (byte) 120, (byte) 123, (byte) 239, (byte) 215, (byte) 201, (byte) 118, (byte) 202, (byte) 125, (byte) 146, (byte) 206, (byte) 240, (byte) 179, (byte) 100, (byte) 210, (byte) 58, (byte) 36, (byte) 253};
    private static final byte[] gm1XRUk88du1jZEfOazvx = {(byte) 211, (byte) 122, (byte) 216, (byte) 218, (byte) 64, (byte) 19, (byte) 174, (byte) 13, (byte) 192, (byte) 3, (byte) 211, (byte) 36, (byte) 121, (byte) 207, (byte) 243, (byte) 120, (byte) 123, (byte) 239, (byte) 215, (byte) 201, (byte) 118, (byte) 202, (byte) 125, (byte) 146, (byte) 206, (byte) 240, (byte) 179, (byte) 100, (byte) 210, (byte) 58, (byte) 36, (byte) 253};
    private static final byte[] LioTaWd0YQeEfepclzB = {(byte) 69, (byte) 237, (byte) 8, (byte) 17, (byte) 132, (byte) 63, (byte) 152, (byte) 223, (byte) 168, (byte) 149, (byte) 61, (byte) 18, (byte) 138, (byte) 234, (byte) 227, (byte) 185, (byte) 154, (byte) 132, (byte) 94, (byte) 128, (byte) 67, (byte) 67, (byte) 101, (byte) 123, (byte) 189, (byte) 90, (byte) 2, (byte) 57, (byte) 153, (byte) 26, (byte) 11, (byte) 195};
    private static final byte[] Xx6wn21xRc3XDV2 = {(byte) 4, (byte) 52, (byte) 84, (byte) 155, (byte) 82, (byte) 127, (byte) 205, (byte) 103, (byte) 163, (byte) 30, (byte) 189, (byte) 234, (byte) 206, (byte) 176, (byte) 156, (byte) 207};
    private static final byte[] FCIQm6ag1KxYXvQ8n888D = {(byte) 69, (byte) 237, (byte) 8, (byte) 17, (byte) 132, (byte) 63, (byte) 152, (byte) 223, (byte) 168, (byte) 149, (byte) 61, (byte) 18, (byte) 138, (byte) 234, (byte) 227, (byte) 185, (byte) 154, (byte) 132, (byte) 94, (byte) 128, (byte) 67, (byte) 67, (byte) 101, (byte) 123, (byte) 189, (byte) 90, (byte) 2, (byte) 57, (byte) 153, (byte) 26, (byte) 11, (byte) 195};
    private static final byte[] rWqitTMd4iZcyj4jdcUG = {(byte) 229, (byte) 148, (byte) 232, (byte) 80, (byte) 141, (byte) 59, (byte) 0, (byte) 201, (byte) 12, (byte) 82, (byte) 33, (byte) 23, (byte) 201, (byte) 79, (byte) 76, (byte) 227, (byte) 92, (byte) 231, (byte) 31, (byte) 20, (byte) 244, (byte) 56, (byte) 2, (byte) 118, (byte) 241, (byte) 138, (byte) 129, (byte) 182, (byte) 24, (byte) 4, (byte) 96, (byte) 184};
    private static final byte[] WHTngAIYgRx5pU = {(byte) 69, (byte) 237, (byte) 8, (byte) 17, (byte) 132, (byte) 63, (byte) 152, (byte) 223, (byte) 168, (byte) 149, (byte) 61, (byte) 18, (byte) 138, (byte) 234, (byte) 227, (byte) 185, (byte) 154, (byte) 132, (byte) 94, (byte) 128, (byte) 67, (byte) 67, (byte) 101, (byte) 123, (byte) 189, (byte) 90, (byte) 2, (byte) 57, (byte) 153, (byte) 26, (byte) 11, (byte) 195};
    private static final byte[] ODW03iJ6r1WMfcUKTxCXAQ = {(byte) 196, (byte) 120, (byte) 153, (byte) 19, (byte) 137, (byte) 21, (byte) 100, (byte) 118, (byte) 109, (byte) 68, (byte) 15, (byte) 189, (byte) 70, (byte) 7, (byte) 205, (byte) 72, (byte) 184, (byte) 25, (byte) 242, (byte) 98, (byte) 69, (byte) 101, (byte) 127, (byte) 211, (byte) 162, (byte) 220, (byte) 52, (byte) 255, (byte) 246, (byte) 36, (byte) 247, (byte) 65};
    private static final byte[] MAtd5FzD6VD7LrnBvs = {(byte) 196, (byte) 120, (byte) 153, (byte) 19, (byte) 137, (byte) 21, (byte) 100, (byte) 118, (byte) 109, (byte) 68, (byte) 15, (byte) 189, (byte) 70, (byte) 7, (byte) 205, (byte) 72, (byte) 191, (byte) 191, (byte) 58, (byte) 34, (byte) 43, (byte) 26, (byte) 122, (byte) 16, (byte) 107, (byte) 142, (byte) 97, (byte) 154, (byte) 130, (byte) 35, (byte) 186, (byte) 118};
    private static final byte[] Qv8a3ULtUImW3QRfocd = {(byte) 186, (byte) 75, (byte) 227, (byte) 248, (byte) 75, (byte) 216, (byte) 13, (byte) 84, (byte) 170, (byte) 55, (byte) 230, (byte) 232, (byte) 213, (byte) 55, (byte) 249, (byte) 147};
    private static final byte[] HVrJNSWXyaWYNymDqRW5 = {(byte) 58, (byte) 76, (byte) 120, (byte) 69, (byte) 156, (byte) 128, (byte) 228, (byte) 68, (byte) 80, (byte) 82, (byte) 3, (byte) 1, (byte) 14, (byte) 9, (byte) 34, (byte) 241, (byte) 22, (byte) 127, (byte) 68, (byte) 23, (byte) 53, (byte) 81, (byte) 46, (byte) 210, (byte) 98, (byte) 62, (byte) 29, (byte) 35, (byte) 31, (byte) 95, (byte) 203, (byte) 168, (byte) 134, (byte) 16, (byte) 108, (byte) 57, (byte) 199, (byte) 7, (byte) 144, (byte) 161, (byte) 248, (byte) 116, (byte) 177, (byte) 213, (byte) 113, (byte) 193, (byte) 177, (byte) 94};
    private static final byte[] a9DnFj8VTti2syw26 = {(byte) 122, (byte) 123, (byte) 168, (byte) 81, (byte) 61, (byte) 145, (byte) 221, (byte) 100, (byte) 79, (byte) 22, (byte) 89, (byte) 53, (byte) 26, (byte) 151, (byte) 34, (byte) 116};
    private static final byte[] amiPXUNoorxf6dCs = {(byte) 2, (byte) 120, (byte) 33, (byte) 235, (byte) 121, (byte) 166, (byte) 29, (byte) 233, (byte) 200, (byte) 99, (byte) 69, (byte) 8, (byte) 255, (byte) 177, (byte) 92, (byte) 86};
    private static final byte[] O0ZO2XJ3STY3rv = {(byte) 132, (byte) 81, (byte) 75, (byte) 129, (byte) 190, (byte) 41, (byte) 67, (byte) 148, (byte) 117, (byte) 159, (byte) 110, (byte) 242, (byte) 150, (byte) 59, (byte) 135, (byte) 69};
    private static final byte[] AJJn4STOWDRjGyJMKFyN = {(byte) 253, (byte) 150, (byte) 226, (byte) 3, (byte) 63, (byte) 198, (byte) 47, (byte) 131, (byte) 106, (byte) 190, (byte) 110, (byte) 126, (byte) 151, (byte) 60, (byte) 141, (byte) 185, (byte) 231, (byte) 254, (byte) 84, (byte) 71, (byte) 249, (byte) 217, (byte) 90, (byte) 190, (byte) 150, (byte) 124, (byte) 95, (byte) 223, (byte) 198, (byte) 53, (byte) 78, (byte) 118};
    private static final byte[] rtUyYima6zM4wTuwYMqfuI = {(byte) 106, (byte) 125, (byte) 243, (byte) 148, (byte) 159, (byte) 51, (byte) 54, (byte) 253, (byte) 179, (byte) 193, (byte) 96, (byte) 223, (byte) 47, (byte) 107, (byte) 39, (byte) 49, (byte) 129, (byte) 255, (byte) 49, (byte) 205, (byte) 6, (byte) 245, (byte) 10, (byte) 163, (byte) 86, (byte) 88, (byte) 98, (byte) 3, (byte) 253, (byte) 204, (byte) 194, (byte) 80};
    private static final byte[] LVOFnRBHf3tAocjGxJr = {(byte) 132, (byte) 81, (byte) 75, (byte) 129, (byte) 190, (byte) 41, (byte) 67, (byte) 148, (byte) 117, (byte) 159, (byte) 110, (byte) 242, (byte) 150, (byte) 59, (byte) 135, (byte) 69};
    private static final byte[] ZPeIW9rUziobW3M1L7mIP = {(byte) 2, (byte) 120, (byte) 33, (byte) 235, (byte) 121, (byte) 166, (byte) 29, (byte) 233, (byte) 200, (byte) 99, (byte) 69, (byte) 8, (byte) 255, (byte) 177, (byte) 92, (byte) 86};
    private static final byte[] WNOUubX4PbgoO14Ori = {(byte) 240, (byte) 114, (byte) 54, (byte) 218, (byte) 61, (byte) 1, (byte) 12, (byte) 61, (byte) 152, (byte) 215, (byte) 183, (byte) 199, (byte) 208, (byte) 113, (byte) 239, (byte) 59, (byte) 17, (byte) 107, (byte) 182, (byte) 38, (byte) 47, (byte) 15, (byte) 151, (byte) 220, (byte) 19, (byte) 23, (byte) 144, (byte) 217, (byte) 30, (byte) 165, (byte) 239, (byte) 231};
    private static final byte[] ZWBLBKjRl5XGzUFrZLbb3 = {(byte) 106, (byte) 125, (byte) 243, (byte) 148, (byte) 159, (byte) 51, (byte) 54, (byte) 253, (byte) 179, (byte) 193, (byte) 96, (byte) 223, (byte) 47, (byte) 107, (byte) 39, (byte) 49, (byte) 129, (byte) 255, (byte) 49, (byte) 205, (byte) 6, (byte) 245, (byte) 10, (byte) 163, (byte) 86, (byte) 88, (byte) 98, (byte) 3, (byte) 253, (byte) 204, (byte) 194, (byte) 80};
    private static final byte[] Zk0KtdQi5AYGOXLVEY = {(byte) 240, (byte) 114, (byte) 54, (byte) 218, (byte) 61, (byte) 1, (byte) 12, (byte) 61, (byte) 152, (byte) 215, (byte) 183, (byte) 199, (byte) 208, (byte) 113, (byte) 239, (byte) 59, (byte) 126, (byte) 133, (byte) 13, (byte) 10, (byte) 62, (byte) 253, (byte) 226, (byte) 233, (byte) 128, (byte) 243, (byte) 103, (byte) 234, (byte) 57, (byte) 104, (byte) 191, (byte) 69};
    private static final byte[] Aem1FdDpSZ1r0ej9bOTPk = {(byte) 106, (byte) 125, (byte) 243, (byte) 148, (byte) 159, (byte) 51, (byte) 54, (byte) 253, (byte) 179, (byte) 193, (byte) 96, (byte) 223, (byte) 47, (byte) 107, (byte) 39, (byte) 49, (byte) 129, (byte) 255, (byte) 49, (byte) 205, (byte) 6, (byte) 245, (byte) 10, (byte) 163, (byte) 86, (byte) 88, (byte) 98, (byte) 3, (byte) 253, (byte) 204, (byte) 194, (byte) 80};
    private static final byte[] NWh0H1M8OQLCvVKcf = {(byte) 218, (byte) 198, (byte) 224, (byte) 19, (byte) 230, (byte) 239, (byte) 203, (byte) 93, (byte) 98, (byte) 47, (byte) 34, (byte) 6, (byte) 189, (byte) 249, (byte) 158, (byte) 83};
    private static final byte[] yJebirf20QbIVOD7KJ8 = {(byte) 73, (byte) 87, (byte) 22, (byte) 183, (byte) 0, (byte) 81, (byte) 134, (byte) 203, (byte) 126, (byte) 146, (byte) 168, (byte) 24, (byte) 34, (byte) 103, (byte) 23, (byte) 27, (byte) 26, (byte) 175, (byte) 189, (byte) 0, (byte) 38, (byte) 139, (byte) 142, (byte) 253, (byte) 225, (byte) 25, (byte) 129, (byte) 247, (byte) 224, (byte) 76, (byte) 6, (byte) 119};
    private static final byte[] UBKweOMX98K24AxGX4v = {(byte) 53, (byte) 193, (byte) 215, (byte) 245, (byte) 163, (byte) 94, (byte) 170, (byte) 43, (byte) 153, (byte) 84, (byte) 98, (byte) 200, (byte) 192, (byte) 240, (byte) 16, (byte) 191, (byte) 246, (byte) 213, (byte) 250, (byte) 193, (byte) 15, (byte) 231, (byte) 126, (byte) 26, (byte) 49, (byte) 159, (byte) 21, (byte) 110, (byte) 73, (byte) 23, (byte) 147, (byte) 153};
    private static final byte[] pGa1BTNi0PLtny2Xw = {(byte) 53, (byte) 193, (byte) 215, (byte) 245, (byte) 163, (byte) 94, (byte) 170, (byte) 43, (byte) 153, (byte) 84, (byte) 98, (byte) 200, (byte) 192, (byte) 240, (byte) 16, (byte) 191, (byte) 246, (byte) 213, (byte) 250, (byte) 193, (byte) 15, (byte) 231, (byte) 126, (byte) 26, (byte) 49, (byte) 159, (byte) 21, (byte) 110, (byte) 73, (byte) 23, (byte) 147, (byte) 153};
    private static final byte[] sxsGSe7IpJMkmYHZ2cM = {(byte) 73, (byte) 87, (byte) 22, (byte) 183, (byte) 0, (byte) 81, (byte) 134, (byte) 203, (byte) 126, (byte) 146, (byte) 168, (byte) 24, (byte) 34, (byte) 103, (byte) 23, (byte) 27, (byte) 208, (byte) 76, (byte) 40, (byte) 96, (byte) 150, (byte) 9, (byte) 98, (byte) 38, (byte) 83, (byte) 185, (byte) 3, (byte) 14, (byte) 143, (byte) 120, (byte) 206, (byte) 62};
    private static final byte[] gTa5JXyaq2htfIgHJ5 = {(byte) 111, (byte) 40, (byte) 18, (byte) 83, (byte) 62, (byte) 201, (byte) 249, (byte) 69, (byte) 101, (byte) 67, (byte) 62, (byte) 111, (byte) 122, (byte) 94, (byte) 158, (byte) 188};
    private static final byte[] PVWeQzki8Nvm1eDQUx = {(byte) 232, (byte) 114, (byte) 114, (byte) 88, (byte) 28, (byte) 80, (byte) 193, (byte) 238, (byte) 105, (byte) 113, (byte) 247, (byte) 6, (byte) 44, (byte) 153, (byte) 89, (byte) 112};
    private static final byte[] aYQMTHQSZgmNxmIKed = {(byte) 232, (byte) 114, (byte) 114, (byte) 88, (byte) 28, (byte) 80, (byte) 193, (byte) 238, (byte) 105, (byte) 113, (byte) 247, (byte) 6, (byte) 44, (byte) 153, (byte) 89, (byte) 112};
    private static final byte[] yPqWO7Pn5UNJJwKVVGtIV = {(byte) 232, (byte) 114, (byte) 114, (byte) 88, (byte) 28, (byte) 80, (byte) 193, (byte) 238, (byte) 105, (byte) 113, (byte) 247, (byte) 6, (byte) 44, (byte) 153, (byte) 89, (byte) 112};
    private static final byte[] e9h3qy2iw2ArlN743iol7n = {(byte) 232, (byte) 114, (byte) 114, (byte) 88, (byte) 28, (byte) 80, (byte) 193, (byte) 238, (byte) 105, (byte) 113, (byte) 247, (byte) 6, (byte) 44, (byte) 153, (byte) 89, (byte) 112};
    private static final byte[] OVV3o2O1d1XfOHcHWvzRbl = {(byte) 246, (byte) 32, (byte) 146, (byte) 222, (byte) 193, (byte) 2, (byte) 36, (byte) 221, (byte) 162, (byte) 251, (byte) 170, (byte) 164, (byte) 172, (byte) 155, (byte) 157, (byte) 112};
    private static final byte[] Vh50xEH69yYoUH8Ddeb = {(byte) 221, (byte) 245, (byte) 40, (byte) 197, (byte) 244, (byte) 222, (byte) 121, (byte) 173, (byte) 90, (byte) 38, (byte) 27, (byte) 26, (byte) 213, (byte) 108, (byte) 166, (byte) 37};
    private static final byte[] Ov5K7k22qyqY4tdUM = {(byte) 220, (byte) 223, (byte) 209, (byte) 219, (byte) 159, (byte) 32, (byte) 2, (byte) 157, (byte) 38, (byte) 45, (byte) 171, (byte) 130, (byte) 32, (byte) 28, (byte) 32, (byte) 133};
    private static final byte[] Yl1l25YZrcCkbEin8pN = {(byte) 151, (byte) 249, (byte) 86, (byte) 207, (byte) 145, (byte) 235, (byte) 212, (byte) 84, (byte) 202, (byte) 118, (byte) 11, (byte) 220, (byte) 37, (byte) 87, (byte) 46, (byte) 213};
    private static final byte[] sETeKqgC8cvzj2pln9kpz = {(byte) 93, (byte) 46, (byte) 168, (byte) 115, (byte) 14, (byte) 96, (byte) 153, (byte) 254, (byte) 211, (byte) 175, (byte) 171, (byte) 42, (byte) 155, (byte) 68, (byte) 28, (byte) 95};
    private static final byte[] r3OuBwc1Q3bsoZGY5gOx = {(byte) 151, (byte) 249, (byte) 86, (byte) 207, (byte) 145, (byte) 235, (byte) 212, (byte) 84, (byte) 202, (byte) 118, (byte) 11, (byte) 220, (byte) 37, (byte) 87, (byte) 46, (byte) 213};
    private static final byte[] FqwseOFAMfqeqN = {(byte) 221, (byte) 245, (byte) 40, (byte) 197, (byte) 244, (byte) 222, (byte) 121, (byte) 173, (byte) 90, (byte) 38, (byte) 27, (byte) 26, (byte) 213, (byte) 108, (byte) 166, (byte) 37};
    private static final byte[] SL8qyzH4fiwy452w = {(byte) 33, (byte) 133, (byte) 213, (byte) 237, (byte) 101, (byte) 5, (byte) 241, (byte) 48, (byte) 129, (byte) 244, (byte) 7, (byte) 95, (byte) 128, (byte) 90, (byte) 209, (byte) 70};
    private static final byte[] XiPqPejnIxD6aHi = {(byte) 0, (byte) 86, (byte) 91, (byte) 36, (byte) 55, (byte) 149, (byte) 51, (byte) 110, (byte) 250, (byte) 235, (byte) 131, (byte) 92, (byte) 40, (byte) 93, (byte) 119, (byte) 43};
    private static final byte[] hPV2sVaZby8amemTc23GPh = {(byte) 74, (byte) 220, (byte) 200, (byte) 199, (byte) 41, (byte) 194, (byte) 97, (byte) 169, (byte) 21, (byte) 53, (byte) 63, (byte) 132, (byte) 77, (byte) 105, (byte) 51, (byte) 144};
    private static final byte[] c9PtQpkKN0902ODCrA = {(byte) 6, (byte) 55, (byte) 164, (byte) 100, (byte) 12, (byte) 62, (byte) 227, (byte) 42, (byte) 155, (byte) 136, (byte) 236, (byte) 160, (byte) 193, (byte) 7, (byte) 222, (byte) 52};
    private static final byte[] OsVz8E91gZHuaLjvd2 = {(byte) 241, (byte) 103, (byte) 70, (byte) 116, (byte) 6, (byte) 173, (byte) 59, (byte) 66, (byte) 75, (byte) 226, (byte) 13, (byte) 205, (byte) 96, (byte) 50, (byte) 52, (byte) 57, (byte) 91, (byte) 232, (byte) 145, (byte) 21, (byte) 240, (byte) 69, (byte) 29, (byte) 171, (byte) 143, (byte) 16, (byte) 24, (byte) 137, (byte) 122, (byte) 90, (byte) 174, (byte) 242};
    private static final byte[] PHp5cddN8Pv2nDLs = {(byte) 244, (byte) 224, (byte) 197, (byte) 209, (byte) 171, (byte) 132, (byte) 3, (byte) 109, (byte) 179, (byte) 154, (byte) 197, (byte) 220, (byte) 197, (byte) 152, (byte) 15, (byte) 198, (byte) 146, (byte) 203, (byte) 1, (byte) 179, (byte) 217, (byte) 99, (byte) 250, (byte) 8, (byte) 69, (byte) 3, (byte) 254, (byte) 82, (byte) 224, (byte) 210, (byte) 182, (byte) 60};
    private static final byte[] sRxeB20obqtqZWad = {(byte) 15, (byte) 127, (byte) 198, (byte) 251, (byte) 234, (byte) 203, (byte) 10, (byte) 134, (byte) 176, (byte) 161, (byte) 255, (byte) 144, (byte) 32, (byte) 189, (byte) 77, (byte) 179};
    private static final byte[] ywi9aotF5GNHC44zQ = {(byte) 122, (byte) 114, (byte) 205, (byte) 66, (byte) 78, (byte) 240, (byte) 140, (byte) 60, (byte) 184, (byte) 103, (byte) 33, (byte) 71, (byte) 140, (byte) 122, (byte) 200, (byte) 84, (byte) 152, (byte) 192, (byte) 123, (byte) 68, (byte) 118, (byte) 104, (byte) 88, (byte) 104, (byte) 250, (byte) 107, (byte) 254, (byte) 21, (byte) 37, (byte) 40, (byte) 193, (byte) 102};
    private static final byte[] fBkP0URqQphPX8ngk = {(byte) 228, (byte) 214, (byte) 201, (byte) 42, (byte) 196, (byte) 77, (byte) 62, (byte) 177, (byte) 219, (byte) 73, (byte) 237, (byte) 161, (byte) 231, (byte) 156, (byte) 218, (byte) 210};
    private static final byte[] DGYinLB8anssd7xi7xqy = {(byte) 144, (byte) 231, (byte) 135, (byte) 20, (byte) 24, (byte) 169, (byte) 120, (byte) 129, (byte) 38, (byte) 218, (byte) 1, (byte) 27, (byte) 193, (byte) 166, (byte) 235, (byte) 17};
    private static final byte[] CKyj05tTVEZbaaE = {(byte) 14, (byte) 131, (byte) 226, (byte) 204, (byte) 88, (byte) 84, (byte) 59, (byte) 215, (byte) 87, (byte) 178, (byte) 244, (byte) 188, (byte) 242, (byte) 217, (byte) 14, (byte) 93};
    private static final byte[] CioVVj8ZFqQ9iXZ = {(byte) 216, (byte) 104, (byte) 24, (byte) 164, (byte) 132, (byte) 157, (byte) 101, (byte) 236, (byte) 188, (byte) 116, (byte) 231, (byte) 214, (byte) 224, (byte) 25, (byte) 253, (byte) 231};
    private static final byte[] X85rJap109UbolQ7VB = {(byte) 194, (byte) 91, (byte) 19, (byte) 236, (byte) 129, (byte) 107, (byte) 66, (byte) 102, (byte) 211, (byte) 108, (byte) 48, (byte) 41, (byte) 103, (byte) 244, (byte) 186, (byte) 234};
    private static final byte[] c35D9beX3vBRp25oXDNEOC = {(byte) 2, (byte) 206, (byte) 13, (byte) 109, (byte) 213, (byte) 197, (byte) 185, (byte) 119, (byte) 68, (byte) 48, (byte) 21, (byte) 171, (byte) 173, (byte) 56, (byte) 84, (byte) 110, (byte) 239, (byte) 133, (byte) 65, (byte) 131, (byte) 37, (byte) 207, (byte) 31, (byte) 39, (byte) 160, (byte) 182, (byte) 221, (byte) 34, (byte) 248, (byte) 120, (byte) 137, (byte) 222};
    private static final byte[] SrwUGEpL5SkkTk = {(byte) 140, (byte) 106, (byte) 116, (byte) 43, (byte) 225, (byte) 96, (byte) 247, (byte) 156, (byte) 247, (byte) 212, (byte) 81, (byte) 234, (byte) 59, (byte) 214, (byte) 146, (byte) 226};

    public XQWpFH32TPMOVKV5(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public String v8qP8fE86HMhvNuYPFjqY(OfflinePlayer offlinePlayer, String str) {
        return offlinePlayer == null ? v8qP8fE86HMhvNuYPFjqY((UUID) null, str) : v8qP8fE86HMhvNuYPFjqY(offlinePlayer.getUniqueId(), str);
    }

    public String v8qP8fE86HMhvNuYPFjqY(Player player, String str) {
        return player == null ? v8qP8fE86HMhvNuYPFjqY((UUID) null, str) : v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), str);
    }

    /* JADX WARN: Code duplicated, block: B:1511:0x31f5  */
    /* JADX WARN: Code duplicated, block: B:1513:0x31f8  */
    /* JADX WARN: Code duplicated, block: B:1515:0x320b  */
    /* JADX WARN: Code duplicated, block: B:1517:0x320e A[RETURN] */
    public String v8qP8fE86HMhvNuYPFjqY(UUID uuid, String str) {
        String strJBUuLP0sWwaPyPOmogdX7l;
        String strV8qP8fE86HMhvNuYPFjqY;
        List<UUID> onlineMembers;
        if (str.startsWith(q7vnd8H0INlzlViN1Hb0F()) || str.endsWith(R3U8b33OGuDCHHAZq())) {
            str = str.replace(D0GzMLQingV7pu7m5(), "");
        }
        if (str.startsWith(YkO4mLIOiRqoo4wvJtWj())) {
            str = str.replace(eSVjz8UyuC0qAsGeXJJv(), "").replace(KkFIcB8lqyfPOnRUOIBM(), "");
        }
        if (str.startsWith(g1hp0tY1eHSjm9v())) {
            str = str.substring(xOwbg7tM6RRZOeHLp4i().length());
        }
        if (str.equals(NAZzuTC9Tl446SKS2pHKkh())) {
            return v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(vXEr26FvLaNJaM1HbYV());
        }
        if (str.equals(kzosaoDuW8WQe0OiUXL())) {
            return String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().b4i2FbOkaKeg91LiAe6l());
        }
        if (str.startsWith(lOzpP0T8ymIBJY8i())) {
            String[] strArrSplit = str.split(LbfbX6ueleuODYot());
            if (strArrSplit.length != 2) {
                return "";
            }
            String str2 = strArrSplit[1];
            Optional.empty();
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().iZTqZaRK5UGoe0Z(str2);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                return optionalIZTqZaRK5UGoe0Z.get().getTagNoColor();
            }
            try {
                Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(UUID.fromString(str2));
                return optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() ? optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTagNoColor() : "";
            } catch (Exception e) {
                return "";
            }
        }
        if (str.equals(LaifL1a6Ex417J())) {
            return String.valueOf(((List) this.v8qP8fE86HMhvNuYPFjqY.getExtensionEnabledList().entrySet().stream().filter(entry -> {
                return ((Boolean) entry.getValue()).booleanValue();
            }).collect(Collectors.toList())).size());
        }
        if (str.equals(LVP3Y9eo25hTGoPp())) {
            return String.valueOf(ClanEnum.ClansExtensions.values().length);
        }
        if (str.equals(euGOfARDZME9aoNrKVGqn())) {
            return String.valueOf(((List) this.v8qP8fE86HMhvNuYPFjqY.getAddonEnabledList().entrySet().stream().filter(entry2 -> {
                return ((AddonInfo) entry2.getValue()).isEnabled();
            }).collect(Collectors.toList())).size());
        }
        if (str.equals(mnKC6MIfbcyu8RfyGumwTd())) {
            return String.valueOf(AddonList.values().length);
        }
        if (str.equals(uR4O4xbtcifarRuzIHFgl())) {
            return this.v8qP8fE86HMhvNuYPFjqY.isEntity() ? v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_YES) : v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO);
        }
        if (str.equals(qf1JilT9nwj8lMrwSX())) {
            return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.ofNullable(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().b4i2FbOkaKeg91LiAe6l()).toUpperCase()));
        }
        if (str.equals(p91di2CWE0xdw7j())) {
            Optional<MoneyImplement> optionalIO1OGSMpoP1ZjOsbXi3a = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().IO1OGSMpoP1ZjOsbXi3a();
            if (optionalIO1OGSMpoP1ZjOsbXi3a.isPresent()) {
                if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(b7PFMQENkSKfHHq()).isEmpty()) {
                    return this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(yKaJyvqrQTl9cpTR4uxcK());
                }
                if (optionalIO1OGSMpoP1ZjOsbXi3a.isPresent() && optionalIO1OGSMpoP1ZjOsbXi3a.get().getPluginName().isPresent()) {
                    return optionalIO1OGSMpoP1ZjOsbXi3a.get().getPluginName().get();
                }
            }
            return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NONE);
        }
        if (str.equals(YNhgCBdKI1sPOAs14JI())) {
            Optional<MoneyImplement> optionalIO1OGSMpoP1ZjOsbXi3a2 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().IO1OGSMpoP1ZjOsbXi3a();
            if (optionalIO1OGSMpoP1ZjOsbXi3a2.isPresent()) {
                if (!this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(BPO8ziYrSgB8K7K2kwCR()).isEmpty()) {
                    return this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(bnF3sui8kmV5c38UNg());
                }
                if (optionalIO1OGSMpoP1ZjOsbXi3a2.isPresent() && optionalIO1OGSMpoP1ZjOsbXi3a2.get().getPluginName().isPresent()) {
                    return optionalIO1OGSMpoP1ZjOsbXi3a2.get().getPluginName().get();
                }
            }
            return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NONE);
        }
        if (str.startsWith(N9e4HeOrCAlsSY46cNo())) {
            String[] strArrSplit2 = str.split(L8avgfq2InSZqRvC7kg());
            if (strArrSplit2.length == 4) {
                String upperCase = strArrSplit2[1].toUpperCase();
                String str3 = strArrSplit2[2];
                int iIntValue = 0;
                try {
                    iIntValue = Integer.valueOf(strArrSplit2[3].toUpperCase()).intValue();
                } catch (Exception e2) {
                }
                try {
                    if (ClanEnum.PlaceholderTop.valueOf(upperCase) != null) {
                        ClanEnum.PlaceholderTop placeholderTopValueOf = ClanEnum.PlaceholderTop.valueOf(upperCase);
                        if (iIntValue < 1) {
                            iIntValue = 1;
                        }
                        Optional<TopData> optionalJBUuLP0sWwaPyPOmogdX7l = v8qP8fE86HMhvNuYPFjqY().getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderTopValueOf, iIntValue);
                        if (optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
                            Optional<ClanData> optionalIZTqZaRK5UGoe0Z2 = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(optionalJBUuLP0sWwaPyPOmogdX7l.get().getUuid());
                            if (optionalIZTqZaRK5UGoe0Z2.isPresent()) {
                                if (str3.equalsIgnoreCase(hVGGxcKMjtU7vbhT7P())) {
                                    return String.valueOf(iIntValue);
                                }
                                if (str3.equalsIgnoreCase(X9Q8vwDfeA5f8vY())) {
                                    return me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalIZTqZaRK5UGoe0Z2.get().getTag());
                                }
                                if (str3.equalsIgnoreCase(VY7ihdnA4FcqF7nc())) {
                                    Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(optionalIZTqZaRK5UGoe0Z2.get().getLeader());
                                    if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                                        return optionalP31abtwfBag2jhMH6K.get().getName();
                                    }
                                } else {
                                    if (str3.equalsIgnoreCase(NHcji71ffp0kMGOn())) {
                                        switch (E0Zb3L2jgpdfCu9HPY.v8qP8fE86HMhvNuYPFjqY[placeholderTopValueOf.ordinal()]) {
                                            case 1:
                                                return String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize("<bank:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(Z1sH438KrmvTwonT5c1()) + "'>", Formatter.number(gzGpQyMTHlKdZoJeQSZ(), optionalJBUuLP0sWwaPyPOmogdX7l.get().getValue()))));
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                                            case 8:
                                            case 9:
                                            case 10:
                                            case 11:
                                                return String.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l.get().getValue());
                                        }
                                    }
                                    if (str3.equalsIgnoreCase(ozGY9czn8LxDOGx())) {
                                        return placeholderTopValueOf.toString();
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                }
            }
        } else if (str.startsWith(h8aNa6xURCP6e7k5Ro())) {
            String[] strArrSplit3 = str.split(OFMpwWoA8Fus6HX4KoP());
            if (strArrSplit3.length == 3) {
                String upperCase2 = strArrSplit3[1].toUpperCase();
                int iIntValue2 = 0;
                try {
                    iIntValue2 = Integer.valueOf(strArrSplit3[2].toUpperCase()).intValue();
                } catch (Exception e4) {
                }
                try {
                    if (ClanEnum.PlaceholderTop.valueOf(upperCase2) != null) {
                        ClanEnum.PlaceholderTop placeholderTopValueOf2 = ClanEnum.PlaceholderTop.valueOf(upperCase2);
                        if (iIntValue2 < 1) {
                            iIntValue2 = 1;
                        }
                        Optional<TopData> optionalJBUuLP0sWwaPyPOmogdX7l2 = v8qP8fE86HMhvNuYPFjqY().getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderTopValueOf2, iIntValue2);
                        if (optionalJBUuLP0sWwaPyPOmogdX7l2.isPresent()) {
                            Optional<ClanData> optionalIZTqZaRK5UGoe0Z3 = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(optionalJBUuLP0sWwaPyPOmogdX7l2.get().getUuid());
                            if (optionalIZTqZaRK5UGoe0Z3.isPresent()) {
                                return v8qP8fE86HMhvNuYPFjqY().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z3.get().getLeader(), v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("TOP_" + placeholderTopValueOf2.toString() + "_FORMAT")).replace(HrDr7tk6A4a8S6aV(), String.valueOf(iIntValue2)));
                            }
                        }
                    }
                } catch (Exception e5) {
                }
            }
        } else if (str.startsWith(WBG7XGykpsIepqktcp8eB())) {
            String[] strArrSplit4 = str.split(HNpVp4bJoiTqEroEPpaL());
            if (strArrSplit4.length == 3) {
                String upperCase3 = strArrSplit4[1].toUpperCase();
                int iIntValue3 = 0;
                try {
                    iIntValue3 = Integer.valueOf(strArrSplit4[2].toUpperCase()).intValue();
                } catch (Exception e6) {
                }
                try {
                    if (ClanEnum.PlaceholderPlayerTop.valueOf(upperCase3) != null) {
                        ClanEnum.PlaceholderPlayerTop placeholderPlayerTopValueOf = ClanEnum.PlaceholderPlayerTop.valueOf(upperCase3);
                        if (iIntValue3 < 1) {
                            iIntValue3 = 1;
                        }
                        Optional<TopData> optionalJBUuLP0sWwaPyPOmogdX7l3 = v8qP8fE86HMhvNuYPFjqY().getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderPlayerTopValueOf, iIntValue3);
                        if (optionalJBUuLP0sWwaPyPOmogdX7l3.isPresent()) {
                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K2 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(optionalJBUuLP0sWwaPyPOmogdX7l3.get().getUuid());
                            if (optionalP31abtwfBag2jhMH6K2.isPresent()) {
                                return v8qP8fE86HMhvNuYPFjqY().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalP31abtwfBag2jhMH6K2.get().getId(), v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("TOP_PLAYER_" + placeholderPlayerTopValueOf.toString() + "_FORMAT")).replace(n69lZVRJhaPbgf5DQ(), String.valueOf(iIntValue3)));
                            }
                        }
                    }
                } catch (Exception e7) {
                }
            }
        } else if (str.startsWith(yro4hLMKBjU09dg5ISA())) {
            String[] strArrSplit5 = str.split(VTLEjyTDTp8AFoZruU());
            if (strArrSplit5.length == 4) {
                String upperCase4 = strArrSplit5[1].toUpperCase();
                String str4 = strArrSplit5[2];
                int iIntValue4 = 0;
                try {
                    iIntValue4 = Integer.valueOf(strArrSplit5[3].toUpperCase()).intValue();
                } catch (Exception e8) {
                }
                try {
                    if (ClanEnum.PlaceholderTop.valueOf(upperCase4) != null) {
                        ClanEnum.PlaceholderPlayerTop placeholderPlayerTopValueOf2 = ClanEnum.PlaceholderPlayerTop.valueOf(upperCase4);
                        if (iIntValue4 < 1) {
                            iIntValue4 = 1;
                        }
                        Optional<TopData> optionalJBUuLP0sWwaPyPOmogdX7l4 = v8qP8fE86HMhvNuYPFjqY().getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderPlayerTopValueOf2, iIntValue4);
                        if (optionalJBUuLP0sWwaPyPOmogdX7l4.isPresent()) {
                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K3 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(optionalJBUuLP0sWwaPyPOmogdX7l4.get().getUuid());
                            if (optionalP31abtwfBag2jhMH6K3.isPresent()) {
                                if (str4.equalsIgnoreCase(bUiA6uxV6fEaXsz())) {
                                    return String.valueOf(iIntValue4);
                                }
                                if (str4.equalsIgnoreCase(tp5fTEwTC1PY1b88w8D())) {
                                    return optionalP31abtwfBag2jhMH6K3.get().getName();
                                }
                                if (str4.equalsIgnoreCase(GNXMeoRfrEmzmPm())) {
                                    switch (E0Zb3L2jgpdfCu9HPY.jBUuLP0sWwaPyPOmogdX7l[placeholderPlayerTopValueOf2.ordinal()]) {
                                        case 1:
                                        case 2:
                                        case 3:
                                            return String.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l4.get().getValue());
                                    }
                                }
                                if (str4.equalsIgnoreCase(zqAr3DHyCNRJQE9xTw())) {
                                    return placeholderPlayerTopValueOf2.toString();
                                }
                            }
                        }
                    }
                } catch (Exception e9) {
                }
            }
        }
        Optional<ClanData> optionalEmpty = Optional.empty();
        if (uuid != null) {
            optionalEmpty = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
        }
        Matcher matcher = Pattern.compile(SuoXJtWOGTBn4RD()).matcher(str);
        if (matcher.find()) {
            optionalEmpty = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(matcher.group(1));
            if (optionalEmpty.isPresent()) {
                str = str.replace(matcher.group(0), "");
            }
        }
        String strReplaceAll = str.trim().replaceAll(TaiuzCixttZcz4LYMXhJr(), "");
        try {
            if (strReplaceAll.equals(XNz2NGM5fLm4G1sOg4HH())) {
                return optionalEmpty.isPresent() ? Jf3pIxRmVp96PY() : WvJGgRoIqruFz30sTk5Uh();
            }
            if (strReplaceAll.equals(WTeRQaFwnkRNaY())) {
                if (optionalEmpty.isPresent()) {
                    return (optionalEmpty.get().getBanner() == null || optionalEmpty.get().getBanner().isEmpty()) ? zrlqRwTSgoJN8rWT() : wgV69BUy0lhPnq5KiyadWx();
                }
                return v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO);
            }
            if (strReplaceAll.equals(WgTBhIrxOH0VdVKH())) {
                if (optionalEmpty.isPresent()) {
                    return (optionalEmpty.get().getBanner() == null || optionalEmpty.get().getBanner().isEmpty()) ? v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO) : v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_YES);
                }
                return v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO);
            }
            if (strReplaceAll.equals(zszyPmJvQczZhWZ0No())) {
                if (optionalEmpty.isPresent()) {
                    return optionalEmpty.get().getSettings().isOpened() ? z3xGYIxWJW9Jbdp() : i414vxS1378yCO4dSIv5iU();
                }
                return us7qyPKZtdT6GuXwNz4GXY();
            }
            if (strReplaceAll.equals(rdPtGb3Wzt8Uwt())) {
                if (optionalEmpty.isPresent()) {
                    return optionalEmpty.get().getSettings().isOpened() ? v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_YES) : v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO);
                }
                return stVoHdPHNvI8rBnNJofQ7();
            }
            if (strReplaceAll.equals(mJk1WSzGTupQ5PCsBg())) {
                return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().isFf()) : String.valueOf(bgX8j2JVxMMc2zuv7());
            }
            if (strReplaceAll.equals(NBzDOxBVZYZ1OMG())) {
                if (optionalEmpty.isPresent() && optionalEmpty.get().isFf()) {
                    return v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_YES);
                }
                return v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO);
            }
            if (strReplaceAll.equals(KXOma0L0mnrRzsvPho())) {
                return optionalEmpty.isPresent() ? optionalEmpty.get().getTag() : v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(yOnIT5ZesMgkAc27dh());
            }
            if (strReplaceAll.equals(yBDlzqB4PV6C1NgmxUM())) {
                return optionalEmpty.isPresent() ? optionalEmpty.get().getTagNoColor() : v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(fi0QTlXEjKwqGY());
            }
            if (strReplaceAll.equals(FUZxjMFb6eKT3BeWIm())) {
                return optionalEmpty.isPresent() ? optionalEmpty.get().getTag() + new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).CDW4Fj1iwdIXEOqWjiJSR(String.valueOf(optionalEmpty.get().getLevel())) : v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(PnIr012yTo3Fl7e());
            }
            if (strReplaceAll.equals(vZo7efgioRYJTq37xB6())) {
                return optionalEmpty.isPresent() ? optionalEmpty.get().getTag() + new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).b4i2FbOkaKeg91LiAe6l(String.valueOf(optionalEmpty.get().getLevel())) : v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(SKFBMonb9icjBZXt2O());
            }
            if (strReplaceAll.equals(MgqMaNPNvTQP79YOSD3LKQ())) {
                return optionalEmpty.isPresent() ? optionalEmpty.get().getTagNoColor() : "";
            }
            if (strReplaceAll.equals(sVA6xj8m6eY1AWeh5OnPH())) {
                return optionalEmpty.isPresent() ? me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(hpFxyBHpavT5UD724MA0X()) + optionalEmpty.get().getTag()) : "";
            }
            if (strReplaceAll.equals(hnq7wEt7yuHHbOsgwYL())) {
                return optionalEmpty.isPresent() ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(TjxhX5HrD2UzlGxqkIL53q()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()) + new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).CDW4Fj1iwdIXEOqWjiJSR(String.valueOf(optionalEmpty.get().getLevel())) : "";
            }
            if (strReplaceAll.equals(bC46RSV7z1EGxSsCYyL7M())) {
                return optionalEmpty.isPresent() ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(cC7MdTQj4rYjyWLloFLNEq()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()) + new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).b4i2FbOkaKeg91LiAe6l(String.valueOf(optionalEmpty.get().getLevel())) : "";
            }
            if (strReplaceAll.equals(FxU1cHUT3kVu0CH7s())) {
                return optionalEmpty.isPresent() ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(PkO8bg7yORMEQ3jBEz3()) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(mOq8CvgKnfLaaL()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()).trim() + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(YfzfThAnGLT4B9T92S()) : "";
            }
            if (strReplaceAll.equals(XA2YbgNmqJuQCUesTAIEl())) {
                return optionalEmpty.isPresent() ? this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(EnEEpX2HH1fJhzHj()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()).trim() + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(lLBi4lF1AITjmUQrN())) : "";
            }
            if (strReplaceAll.equals(BMgmkEFPgp171eGQYT())) {
                return optionalEmpty.isPresent() ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(fAkyK0vMnuxizN4li87()) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(nh4XQ3cc8UXF9a1WS8j3JT()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()) + new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).CDW4Fj1iwdIXEOqWjiJSR(String.valueOf(optionalEmpty.get().getLevel())) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(iwVilAqtPLs8GFt()) : "";
            }
            if (strReplaceAll.equals(wPFAOIFkVUZE1ADHsj0cBd())) {
                return optionalEmpty.isPresent() ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(c5WIZ2UfpWIYm33R7()) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(Z5ScvQAIHNKeaX1ErTbT()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()) + new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).b4i2FbOkaKeg91LiAe6l(String.valueOf(optionalEmpty.get().getLevel())) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(i7u4r5u50NpXXOXq()) : "";
            }
            if (strReplaceAll.equals(GYx4pzylR8PAZWBr())) {
                return optionalEmpty.isPresent() ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(WDt4xLce5xCGwrV()) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(yAlgeLfZbpiCEC()) + me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(l2jZxFd17ZqXkAwLC()) : "";
            }
            if (strReplaceAll.equals(y4n4IhwKoT3wdG8u3())) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K4 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K4.isPresent()) {
                    return (optionalP31abtwfBag2jhMH6K4.get().getNickname() == null || optionalP31abtwfBag2jhMH6K4.get().getNickname().isEmpty() || optionalP31abtwfBag2jhMH6K4.get().getNickname().equalsIgnoreCase(xlZlV96yfwfn7vxsft()) || !this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(fkxQdHEMruDLCQ7ol())) ? optionalP31abtwfBag2jhMH6K4.get().getName() : this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(qTG0f6KaOkEKPeHf1q8fzh()) + optionalP31abtwfBag2jhMH6K4.get().getNickname();
                }
                try {
                    return Bukkit.getPlayer(uuid).getName();
                } catch (Exception e10) {
                    return "";
                }
            }
            if (strReplaceAll.equals(GdMqS0TePhjFOXb())) {
                return this.v8qP8fE86HMhvNuYPFjqY.getLanguage().toUpperCase();
            }
            if (strReplaceAll.equals(NfTnRZFyPKtDFXLnGP()) || strReplaceAll.equals(Wulrfoam5LT98Mdz())) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K5 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                return optionalP31abtwfBag2jhMH6K5.isPresent() ? optionalP31abtwfBag2jhMH6K5.get().getLang() : this.v8qP8fE86HMhvNuYPFjqY.getLanguage().toUpperCase();
            }
            if (strReplaceAll.equals(jcSWIF0S4cW8mLu4cJa9px())) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K6 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                String upperCase5 = this.v8qP8fE86HMhvNuYPFjqY.getLanguage().toUpperCase();
                if (optionalP31abtwfBag2jhMH6K6.isPresent()) {
                    upperCase5 = optionalP31abtwfBag2jhMH6K6.get().getLang().toUpperCase();
                }
                String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(ySlfalqjwZ9o1k());
                if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().contains("Config.language_flags." + upperCase5)) {
                    string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString("Config.language_flags." + upperCase5);
                }
                return "base64:" + string;
            }
            if (strReplaceAll.equals(cSqefGhKShVhpItODa())) {
                String upperCase6 = this.v8qP8fE86HMhvNuYPFjqY.getLanguage().toUpperCase();
                String string2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(TEJGKXtYkeIzsB4());
                if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().contains("Config.language_flags." + upperCase6)) {
                    string2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString("Config.language_flags." + upperCase6);
                }
                return "base64:" + string2;
            }
            if (strReplaceAll.startsWith(qZusWm6iTs2HNjaVMup())) {
                String[] strArrSplit6 = strReplaceAll.split(Y4PVUXxherqBtFQZIymEKe());
                String string3 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(qkO0vc57fipczi0S2());
                if (strArrSplit6.length == 2) {
                    String upperCase7 = strArrSplit6[1].toUpperCase();
                    if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().contains("Config.language_flags." + upperCase7)) {
                        string3 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString("Config.language_flags." + upperCase7);
                    }
                }
                return "base64:" + string3;
            }
            if (strReplaceAll.equals(JIHMrGDmdVGHQKLH9tc6q())) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K7 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                String string4 = v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(ep1LwjepY8oOJ2nCKPqRZ());
                try {
                    if (optionalP31abtwfBag2jhMH6K7.isPresent() && optionalP31abtwfBag2jhMH6K7.get().getCache() != null && !optionalP31abtwfBag2jhMH6K7.get().getCache().isEmpty()) {
                        string4 = optionalP31abtwfBag2jhMH6K7.get().getCache();
                    }
                    return "base64:" + string4;
                } catch (Exception e11) {
                    return "base64:" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(MwZW2r08mXv1REUPW());
                }
            }
            if (strReplaceAll.equals(oPLzzVxuUonb3B())) {
                if (!optionalEmpty.isPresent()) {
                    return "base64:" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(nDXvJNzPZ7BpUnJW());
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K8 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(optionalEmpty.get().getLeader());
                String string5 = v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(SuysgcsCrsQBksC9());
                try {
                    if (optionalP31abtwfBag2jhMH6K8.isPresent()) {
                        if (optionalP31abtwfBag2jhMH6K8.get().getCustomSkin() != null && !optionalP31abtwfBag2jhMH6K8.get().getCustomSkin().isEmpty() && this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(bGD0RgxIEfxGh94bMQ())) {
                            string5 = optionalP31abtwfBag2jhMH6K8.get().getCustomSkin();
                        } else if (optionalP31abtwfBag2jhMH6K8.get().getCache() != null && !optionalP31abtwfBag2jhMH6K8.get().getCache().isEmpty()) {
                            string5 = optionalP31abtwfBag2jhMH6K8.get().getCache();
                        }
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
                return "base64:" + string5;
            }
            if (strReplaceAll.equals(yvMvp4auA7JvNen())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    try {
                        return Bukkit.getPlayer(uuid).getName();
                    } catch (Exception e13) {
                        return "";
                    }
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K9 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K9.isPresent()) {
                    return (optionalP31abtwfBag2jhMH6K9.get().getNickname() == null || optionalP31abtwfBag2jhMH6K9.get().getNickname().isEmpty() || optionalP31abtwfBag2jhMH6K9.get().getNickname().equalsIgnoreCase(GLmGwXmQDzMCTiUMi()) || !this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(AsFi0HWJUtDoxGNf6Pml())) ? optionalP31abtwfBag2jhMH6K9.get().getName() : this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(tmHB2osVfDRDnh()) + v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid).get().getNickname();
                }
            } else if (strReplaceAll.equals(qsMoXj3UPk4uiB2yOgEst())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    try {
                        return Bukkit.getPlayer(uuid).getName();
                    } catch (Exception e14) {
                        return "";
                    }
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K10 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K10.isPresent()) {
                    return optionalP31abtwfBag2jhMH6K10.get().getName();
                }
            } else if (strReplaceAll.equals(NPfZy5yLI7YeH7JDZ6Sz())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    try {
                        return Bukkit.getPlayer(uuid).getName();
                    } catch (Exception e15) {
                        return "";
                    }
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K11 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K11.isPresent()) {
                    return (optionalP31abtwfBag2jhMH6K11.get().getNickname() == null || optionalP31abtwfBag2jhMH6K11.get().getNickname().isEmpty() || optionalP31abtwfBag2jhMH6K11.get().getNickname().equalsIgnoreCase(eVHpAYoe1W3QLv6()) || !this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(QmbR9DBFno4Uow8ptc())) ? optionalP31abtwfBag2jhMH6K11.get().getName() : this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(NhBSAh2YVsZI9Cef()) + optionalP31abtwfBag2jhMH6K11.get().getNickname();
                }
            } else if (strReplaceAll.equals(NnW035alHkpY4cCxFJq())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    return WkXkd6CaskpvddK();
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K12 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K12.isPresent()) {
                    return String.valueOf(optionalP31abtwfBag2jhMH6K12.get().getJoinDate());
                }
            } else if (strReplaceAll.equals(DNlSsdsjGERpYeXHwAcDhi())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    return dlzlNWtPVUWPM1h();
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K13 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K13.isPresent()) {
                    return String.valueOf(new Times().unixToDate(Long.valueOf(optionalP31abtwfBag2jhMH6K13.get().getJoinDate() * 1000), v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(ZrNM4ZSA2sDl0CeEcD())));
                }
            } else if (strReplaceAll.equals(RrwT6IXyfODn18PNmL())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    return M2vw2Na8s6iSKHd8();
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K14 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K14.isPresent()) {
                    return String.valueOf(optionalP31abtwfBag2jhMH6K14.get().getLastSeen());
                }
            } else if (strReplaceAll.equals(LKsUtTNJNZaHl9kNMkuAIs())) {
                if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                    return sPFQIdTjjBMUvmozHdZGWG();
                }
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K15 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                if (optionalP31abtwfBag2jhMH6K15.isPresent()) {
                    return String.valueOf(new Times().unixToDate(Long.valueOf(optionalP31abtwfBag2jhMH6K15.get().getLastSeen() * 1000), v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(MRHKWZ8UE3dL2Hl2Jw())));
                }
            } else {
                if (strReplaceAll.equals(FkZ4QIC5CMzTyWrr())) {
                    if (optionalEmpty.isPresent()) {
                        return (optionalEmpty.get().getBanner() == null || optionalEmpty.get().getBanner().isEmpty() || optionalEmpty.get().getBanner().equalsIgnoreCase(VNP4V4YaW4aYCBKxCvi5rY())) ? "material:" + v8qP8fE86HMhvNuYPFjqY().getLibManager().ZwrsrwOCXRUscW6Q() : "serialized:" + optionalEmpty.get().getBanner();
                    }
                    return "material:" + v8qP8fE86HMhvNuYPFjqY().getLibManager().ZwrsrwOCXRUscW6Q();
                }
                if (!strReplaceAll.equals(C7QpiPyk82WwlIUhlLpL1i())) {
                    if (strReplaceAll.equals(BVK60bemuKhorQPd())) {
                        if (optionalEmpty.isPresent()) {
                            Optional<BannerModuleAPI> optionalZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().zJnaNCVQSgEShq();
                            if (optionalZJnaNCVQSgEShq.isPresent()) {
                                List<Material> allBannerEnabledListDistict = optionalZJnaNCVQSgEShq.get().getAllBannerEnabledListDistict(optionalEmpty.get().getId());
                                if (allBannerEnabledListDistict.size() > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    int size = allBannerEnabledListDistict.size();
                                    if (allBannerEnabledListDistict.size() > 25) {
                                        size = 25;
                                    }
                                    for (int i = 0; i < size; i++) {
                                        if (i % 2 == 0) {
                                            sb.append("&b" + this.v8qP8fE86HMhvNuYPFjqY.getLibManager().v8qP8fE86HMhvNuYPFjqY(ClanEnum.TranslatableKey.block, allBannerEnabledListDistict.get(i).name().toString(), new String[0]));
                                        } else {
                                            sb.append("&7" + this.v8qP8fE86HMhvNuYPFjqY.getLibManager().v8qP8fE86HMhvNuYPFjqY(ClanEnum.TranslatableKey.block, allBannerEnabledListDistict.get(i).name().toString(), new String[0]));
                                        }
                                        if (i + 1 < allBannerEnabledListDistict.size()) {
                                            sb.append(MMEe4bpkmf1ULv());
                                        } else {
                                            sb.append(QJbsyVt0GpYVxFRQf());
                                        }
                                    }
                                    if (allBannerEnabledListDistict.size() > 15) {
                                        sb.append(TyOpbuGHmFbX4Iw());
                                    }
                                    return sb.toString();
                                }
                            }
                        }
                        return v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.HELP_INFO_EMPTY);
                    }
                    if (strReplaceAll.equals(s3UWEFloutXSXvAiWSGK())) {
                        try {
                            Optional<MoneyImplement> optionalIO1OGSMpoP1ZjOsbXi3a3 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().IO1OGSMpoP1ZjOsbXi3a();
                            if (optionalIO1OGSMpoP1ZjOsbXi3a3.isPresent() && optionalIO1OGSMpoP1ZjOsbXi3a3.isPresent()) {
                                Player player = null;
                                try {
                                    if (Bukkit.getPlayer(uuid).isOnline()) {
                                        player = Bukkit.getPlayer(uuid);
                                    }
                                } catch (Exception e16) {
                                }
                                return player != null ? String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize("<money:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(xHHHEYRcKZItamRx0TIe()) + "'>", Formatter.number(QXTBveF0WkCL2Pu(), Double.valueOf(optionalIO1OGSMpoP1ZjOsbXi3a3.get().getMoney(player, true)))))) : String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize("<money:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(bSeb8gn8LPf7wesDd15i()) + "'>", Formatter.number(JKUKCXBeP4gua89dHc(), 0))));
                            }
                        } catch (Exception e17) {
                        }
                    } else if (strReplaceAll.equals(OtIVRQGpS5RosGKM0())) {
                        if (optionalEmpty.isPresent()) {
                            String desc = optionalEmpty.get().getDesc();
                            if (desc.isEmpty() || desc == null) {
                                desc = v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(UyLwQFPHNZL1M4Kr9rLg());
                            }
                            return this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(desc.trim());
                        }
                    } else if (strReplaceAll.equals(NFoYtan5aZOx0g())) {
                        if (optionalEmpty.isPresent()) {
                            String desc2 = optionalEmpty.get().getDesc();
                            if (desc2.isEmpty() || desc2 == null) {
                                desc2 = v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(LEQIgNlzLQdpshe9FQkjTN());
                            }
                            return v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(DuoyHKeg6mb2beO()) + desc2.trim();
                        }
                    } else if (!strReplaceAll.equals(SdJylBUbOvQfbFu())) {
                        if (strReplaceAll.equals(z9syY4k6K3YnPqGUm8z())) {
                            if (optionalEmpty.isPresent()) {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K16 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(optionalEmpty.get().getLeader());
                                if (optionalP31abtwfBag2jhMH6K16.isPresent()) {
                                    return (optionalP31abtwfBag2jhMH6K16.get().getNickname() == null || optionalP31abtwfBag2jhMH6K16.get().getNickname().isEmpty() || optionalP31abtwfBag2jhMH6K16.get().getNickname().equalsIgnoreCase(YHaDfNPSldehBPuzLMar()) || !this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(ZEuiWSGK59PW8wNMMsNV9z())) ? optionalP31abtwfBag2jhMH6K16.get().getName() : this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(rNF3zNUtb065SsnC()) + optionalP31abtwfBag2jhMH6K16.get().getNickname();
                                }
                            }
                            return v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NO);
                        }
                        if (strReplaceAll.equals(EjHyiZoAO2rrUklmW())) {
                            if (v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K17 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                                if (optionalP31abtwfBag2jhMH6K17.isPresent()) {
                                    return String.valueOf(optionalP31abtwfBag2jhMH6K17.get().isLockedChat());
                                }
                            }
                            return wX3vXyHCC5ELJPEiUv3cpA();
                        }
                        if (strReplaceAll.equals(bMCp4jMjk3yL1K8())) {
                            return optionalEmpty.isPresent() ? Long.toString(optionalEmpty.get().getCreationDate()) : yyzfVn5xMz9F4a3();
                        }
                        if (strReplaceAll.equals(d9FtfJ87pJRzejGPUGG())) {
                            return optionalEmpty.isPresent() ? new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getCreationDate()) : GaA29O1SzsOu7NQFXT9r();
                        }
                        if (strReplaceAll.equals(sJg8Z6ylQkj16OxoYJvQB1())) {
                            return optionalEmpty.isPresent() ? new Times().unixToDate(Long.valueOf(optionalEmpty.get().getCreationDate() * 1000), v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(LFpHFZZy6mNYVHIhudl())) : jXjVjqQAowVvy2YFbpRfWG();
                        }
                        if (strReplaceAll.equals(ytVkI8K4GcuyoBWri())) {
                            return optionalEmpty.isPresent() ? String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize(UqNNvGuyXrfpay(), Formatter.number(dfDABvblcpJjsdi5hRoc(), Integer.valueOf(optionalEmpty.get().getQuest().getPoints()))))) : lVmnMxHBwYwpCs();
                        }
                        if (strReplaceAll.equals(DwMVxIGYUNWYFDN7CiTkV())) {
                            return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getQuest().getPoints()) : OQTBM5YgJqvcEzC6();
                        }
                        if (strReplaceAll.equals(jhOarEOJ8027BOfNwyx())) {
                            return optionalEmpty.isPresent() ? String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize(UMG03tHZNlZubxzsTt(), Formatter.number(U2ywNnYRAihusCvlQF6ncT(), Integer.valueOf(optionalEmpty.get().getQuest().getFinished()))))) : XWZMXEaRrjZQ6FcRds();
                        }
                        if (strReplaceAll.equals(qskJTuj7XvtHXLVf())) {
                            return optionalEmpty.isPresent() ? String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize(nTVt8JgqIai0aDZlXO2x8(), Formatter.number(RGDEad540sy7rM(), Integer.valueOf(optionalEmpty.get().getLevel()))))) : KldvcFRo6P4HZtCen();
                        }
                        if (strReplaceAll.equals(VMQuiTHLDf35Zkw7ENMRd())) {
                            if (optionalEmpty.isPresent()) {
                                Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
                                if (optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
                                    return String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize(HyjQAVzME2bRlhI(), Formatter.number(PGckaxcIYwJl62YznMVTJ2(), Integer.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getMaxlevel())))));
                                }
                            }
                            return tmhULk1sxdjhBp2();
                        }
                        if (strReplaceAll.equals(iIc5ReCFtDv7KcjqTpsKxO())) {
                            if (optionalEmpty.isPresent()) {
                                return new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).CDW4Fj1iwdIXEOqWjiJSR(String.valueOf(optionalEmpty.get().getLevel()));
                            }
                        } else if (!strReplaceAll.equals(pxwGxHqAJsMsXNELKy())) {
                            if (strReplaceAll.equals(O4eAv3pmHAaRAGW1NYW())) {
                                return optionalEmpty.isPresent() ? String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize("<bank:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(dL13M1h9DmESuD()) + "'>", Formatter.number(sPvgWMccieo9qmjCtAT(), optionalEmpty.get().getBank())))) : OSh9DzVTXlYIr6Z();
                            }
                            if (strReplaceAll.equals(cJUtJ94jLsMPmxZjydnK())) {
                                return optionalEmpty.isPresent() ? String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize("<bank:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(vkIzk53sKKHrRoBJl()) + "'>", Formatter.number(EyBp0AwaWfnhGGsxwRZ(), optionalEmpty.get().getBank())))) : hcsxYcaEa14sEtc();
                            }
                            if (!strReplaceAll.equals(MgdFbOz3UOZAE4OeRT())) {
                                if (strReplaceAll.equals(kHZJS5KnwIdaJP1Vk2jz())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getMemberJoined()) : Nz1xD7rtD1WAog10B();
                                }
                                if (strReplaceAll.equals(pFLXoY6vUGl6ru5EFQX2M())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getMemberLeft()) : v5TUtkIEfEJKFi05Y();
                                }
                                if (strReplaceAll.equals(PiuerSWabUaBSjJi50iC0Z())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getMemberKicked()) : va8GaQO7XRURL30ay1();
                                }
                                if (strReplaceAll.equals(zyoPebd4ydntiTp())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getWarWin()) : LUr72SFFwgZqd6vr();
                                }
                                if (strReplaceAll.equals(vS0XBwG3ko1QJAh())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getWarLose()) : QDmHzkNnV70fEcX6();
                                }
                                if (strReplaceAll.equals(JH31PepD2Qmxp9b())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getWarWin() + optionalEmpty.get().getStats().getWarLose()) : EyGPk5Fossiq1sKe();
                                }
                                if (strReplaceAll.equals(aVrhmcg1T3QeyJy())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getGladWin()) : teF3tz75CQyYNXqUlR();
                                }
                                if (strReplaceAll.equals(S7I22oTzMQMMhlZra())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getGladLose()) : AdKGb6FW8HLs1xjvoqA();
                                }
                                if (strReplaceAll.equals(d0mlmS3WU0zWFH0DDi1())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getGladWin() + optionalEmpty.get().getStats().getGladLose()) : jzZ5BDq9plxIrXqYr();
                                }
                                if (strReplaceAll.equals(OG0Y2h5H7RXwJzMl())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getLeagueWin()) : UdF8is8bfMIptSX();
                                }
                                if (strReplaceAll.equals(hu6xa0c4B0LU9sN())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getLeagueLose()) : DoasfIpZIho6eik10();
                                }
                                if (strReplaceAll.equals(VNCRHOd8KuMUBz())) {
                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getStats().getLeagueWin() + optionalEmpty.get().getStats().getLeagueLose()) : u6Lnh90sY9mwVISP();
                                }
                                if (strReplaceAll.equals(f766tGmoEYT5CGu())) {
                                    if (!optionalEmpty.isPresent()) {
                                        return cZ9JG2l4aXgt4Nz66();
                                    }
                                    Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR3 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
                                    if (optionalCDW4Fj1iwdIXEOqWjiJSR3.isPresent()) {
                                        return String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getStats().getTagChanged());
                                    }
                                } else {
                                    if (strReplaceAll.equals(PmA61vE7LHDk0t3ctVEU())) {
                                        return optionalEmpty.isPresent() ? String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().lGGwXL678c4Kv7skJb5NiE(optionalEmpty.get().getId())) : Iynv0rvCvPzwHjGr2YZsb0();
                                    }
                                    if (strReplaceAll.equals(FDq7fXgutkD9SfqnI())) {
                                        return optionalEmpty.isPresent() ? String.format(VjMBk7Kqd9xM77kSAwo(), Double.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().b4i2FbOkaKeg91LiAe6l(optionalEmpty.get().getId()))) : KBHGAtGrW6qcnw1IHctxu();
                                    }
                                    if (strReplaceAll.equals(EMOObIpeBBWyqPivv3S6())) {
                                        if (!optionalEmpty.isPresent()) {
                                            return oOINhqLKtY7C9Zx3YN9();
                                        }
                                        int deaths = 0;
                                        Iterator<UUID> it = optionalEmpty.get().getMembers().iterator();
                                        while (it.hasNext()) {
                                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K18 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(it.next());
                                            if (optionalP31abtwfBag2jhMH6K18.isPresent()) {
                                                deaths += optionalP31abtwfBag2jhMH6K18.get().getDeaths();
                                            }
                                        }
                                        return String.valueOf(deaths);
                                    }
                                    if (strReplaceAll.equals(lTtTVXHn2PEvbMSZXJ())) {
                                        if (!optionalEmpty.isPresent()) {
                                            return ScOwziK1KHhDhQ3();
                                        }
                                        int kills = 0;
                                        Iterator<UUID> it2 = optionalEmpty.get().getMembers().iterator();
                                        while (it2.hasNext()) {
                                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K19 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(it2.next());
                                            if (optionalP31abtwfBag2jhMH6K19.isPresent()) {
                                                kills += optionalP31abtwfBag2jhMH6K19.get().getKills();
                                            }
                                        }
                                        return String.valueOf(kills);
                                    }
                                    if (strReplaceAll.equals(zRwWj985YC1h0jux())) {
                                        if (optionalEmpty.isPresent()) {
                                            return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf(optionalEmpty.get().isVerified()).toUpperCase()));
                                        }
                                    } else if (!strReplaceAll.equals(PrzXPTk9z82jXoY())) {
                                        if (strReplaceAll.equals(jdPOCK7oX9ZJ3c())) {
                                            return (optionalEmpty.isPresent() && optionalEmpty.get().isVerified()) ? me.ulrich.clans.qjkRaOgynIj1.DQoauhaxduHZi.v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getTag()) : "";
                                        }
                                        if (strReplaceAll.equals(YK1SLEH0NxIbQj())) {
                                            return (optionalEmpty.isPresent() && optionalEmpty.get().isVerified()) ? v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(WnZHuNkMPQoaewKihuZx6a()) + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(X6vrYNBaQw2nkRH()) + optionalEmpty.get().getTag().trim() + v8qP8fE86HMhvNuYPFjqY().getFiles().p31abtwfBag2jhMH6K().getString(nf8qYWro9MaaViVNbCR()) : "";
                                        }
                                        if (strReplaceAll.equals(mwG4dqnM4Ey7fHCkg6Ne5())) {
                                            if (!optionalEmpty.isPresent()) {
                                                return NcFPTUYlbYKccJWeOJpRMR();
                                            }
                                            int size2 = optionalEmpty.get().getMembers().size();
                                            if (size2 < 1) {
                                                size2 = 0;
                                            }
                                            return String.valueOf(size2);
                                        }
                                        if (strReplaceAll.equals(bcGY6au4nVqnfMwFsc56X())) {
                                            if (!optionalEmpty.isPresent()) {
                                                return wa9BZBoP2BdrsEiHf();
                                            }
                                            try {
                                                return String.valueOf(optionalEmpty.get().getOnlineMembers().size());
                                            } catch (Exception e18) {
                                                return PavsdmoQ3r0A6Rp9s9ELvr();
                                            }
                                        }
                                        if (strReplaceAll.equals(Dvvs2QXItoASe1LMHA())) {
                                            return optionalEmpty.isPresent() ? SnBdSMCJy446EAftIR() : uNBDoicNBITKHfuNGZ();
                                        }
                                        if (!strReplaceAll.equals(poJQ5cQx6xUHntCRq())) {
                                            if (strReplaceAll.equals(aWyfr7dMT0nDfowOPggE())) {
                                                if (optionalEmpty.isPresent()) {
                                                    return optionalEmpty.get().getBanned() != null ? String.valueOf(optionalEmpty.get().getBanned().size()) : dSzW6SYBXXA3jBtvTm();
                                                }
                                                return E2yVmsN95karEL68rJdft();
                                            }
                                            if (!strReplaceAll.equals(Bq8fosuC9C4wP7())) {
                                                if (strReplaceAll.equals(oKedfkVgcduh1ARYhZGW())) {
                                                    if (!optionalEmpty.isPresent() || (onlineMembers = optionalEmpty.get().getOnlineMembers()) == null) {
                                                        return "";
                                                    }
                                                    String string6 = "";
                                                    try {
                                                        int i2 = 1;
                                                        if (onlineMembers.size() > 0) {
                                                            Iterator<UUID> it3 = onlineMembers.iterator();
                                                            while (it3.hasNext()) {
                                                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K20 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(it3.next());
                                                                if (optionalP31abtwfBag2jhMH6K20.isPresent()) {
                                                                    String str5 = string6 + optionalP31abtwfBag2jhMH6K20.get().getName();
                                                                    string6 = i2 >= onlineMembers.size() ? str5 + "." : str5 + ", ";
                                                                }
                                                                i2++;
                                                            }
                                                        } else {
                                                            string6 = v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.NOTHING_HERE);
                                                        }
                                                    } catch (Exception e19) {
                                                    }
                                                    return string6;
                                                }
                                                if (strReplaceAll.equals(MWQmVsIa3WHMcV())) {
                                                    return v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid) ? String.valueOf(v8qP8fE86HMhvNuYPFjqY().getPlayerManager().xtOheRiObl4QeAl().get(uuid).getKills()) : aBZUGxTRxNo2AHO();
                                                }
                                                if (strReplaceAll.equals(aD7vFm0mF2GX9EoWnjsBu())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = v8qP8fE86HMhvNuYPFjqY().getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid);
                                                    return optionalB4i2FbOkaKeg91LiAe6l.isPresent() ? optionalB4i2FbOkaKeg91LiAe6l.get().getId() : v8qP8fE86HMhvNuYPFjqY().getModerationManager().ZwrsrwOCXRUscW6Q().get().getId();
                                                }
                                                if (strReplaceAll.equals(QnHRbprfVoZ1TNWAG())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l2 = v8qP8fE86HMhvNuYPFjqY().getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid);
                                                    return optionalB4i2FbOkaKeg91LiAe6l2.isPresent() ? optionalB4i2FbOkaKeg91LiAe6l2.get().getName() : v8qP8fE86HMhvNuYPFjqY().getModerationManager().ZwrsrwOCXRUscW6Q().get().getName();
                                                }
                                                if (strReplaceAll.equals(MSSFRHd21RgAkymC())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    Optional<ModerationData> optionalP31abtwfBag2jhMH6K21 = v8qP8fE86HMhvNuYPFjqY().getModerationManager().p31abtwfBag2jhMH6K(uuid);
                                                    return optionalP31abtwfBag2jhMH6K21.isPresent() ? optionalP31abtwfBag2jhMH6K21.get().getId() : v8qP8fE86HMhvNuYPFjqY().getModerationManager().ZwrsrwOCXRUscW6Q().get().getId();
                                                }
                                                if (strReplaceAll.equals(YnpPJKaxfBvpXW())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    Optional<ModerationData> optionalP31abtwfBag2jhMH6K22 = v8qP8fE86HMhvNuYPFjqY().getModerationManager().p31abtwfBag2jhMH6K(uuid);
                                                    return optionalP31abtwfBag2jhMH6K22.isPresent() ? optionalP31abtwfBag2jhMH6K22.get().getName() : v8qP8fE86HMhvNuYPFjqY().getModerationManager().ZwrsrwOCXRUscW6Q().get().getName();
                                                }
                                                if (strReplaceAll.equals(n9JuOyrf6qnF5j())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    Optional<ModerationData> optionalUn3NRLL6aWivTcbodkcK = v8qP8fE86HMhvNuYPFjqY().getModerationManager().Un3NRLL6aWivTcbodkcK(uuid);
                                                    return optionalUn3NRLL6aWivTcbodkcK.isPresent() ? optionalUn3NRLL6aWivTcbodkcK.get().getId() : v8qP8fE86HMhvNuYPFjqY().getModerationManager().ZwrsrwOCXRUscW6Q().get().getId();
                                                }
                                                if (strReplaceAll.equals(EgHPIxEagWNGARb())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    Optional<ModerationData> optionalUn3NRLL6aWivTcbodkcK2 = v8qP8fE86HMhvNuYPFjqY().getModerationManager().Un3NRLL6aWivTcbodkcK(uuid);
                                                    return optionalUn3NRLL6aWivTcbodkcK2.isPresent() ? optionalUn3NRLL6aWivTcbodkcK2.get().getName() : v8qP8fE86HMhvNuYPFjqY().getModerationManager().ZwrsrwOCXRUscW6Q().get().getName();
                                                }
                                                if (strReplaceAll.equals(XBsF9QQXS4ScF6R2uY())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return String.valueOf(0);
                                                    }
                                                    Stream<Boolean> stream = v8qP8fE86HMhvNuYPFjqY().getModerationManager().zJnaNCVQSgEShq(uuid).values().stream();
                                                    Boolean bool = Boolean.TRUE;
                                                    Objects.requireNonNull(bool);
                                                    return String.valueOf(stream.filter((v1) -> {
                                                        return bool.equals(v1);
                                                    }).count());
                                                }
                                                if (strReplaceAll.equals(qZuqF0ZsoAI0NP())) {
                                                    if (!optionalEmpty.isPresent()) {
                                                        return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NOCLAN);
                                                    }
                                                    HashMap<String, Boolean> mapZJnaNCVQSgEShq = v8qP8fE86HMhvNuYPFjqY().getModerationManager().zJnaNCVQSgEShq(uuid);
                                                    StringBuilder sb2 = new StringBuilder();
                                                    ArrayList<String> arrayList = new ArrayList<>(mapZJnaNCVQSgEShq.keySet());
                                                    arrayList.sort((v0, v1) -> {
                                                        return v0.compareToIgnoreCase(v1);
                                                    });
                                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                                        String str6 = (String) arrayList.get(i3);
                                                        if (!mapZJnaNCVQSgEShq.get(str6).booleanValue()) {
                                                            sb2.append("&c").append(str6);
                                                        } else if (i3 % 2 == 0) {
                                                            sb2.append("&b").append(str6);
                                                        } else {
                                                            sb2.append("&7").append(str6);
                                                        }
                                                        if (i3 + 1 < arrayList.size()) {
                                                            sb2.append(BVIypTwwLYEL5NKI());
                                                        } else {
                                                            sb2.append(uQeupYwIhCuVqW());
                                                        }
                                                    }
                                                    return sb2.toString();
                                                }
                                                if (strReplaceAll.equals(p1k80FvMib7eV0FdbWuaAE())) {
                                                    return v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid) ? String.valueOf(v8qP8fE86HMhvNuYPFjqY().getPlayerManager().xtOheRiObl4QeAl().get(uuid).getDeaths()) : Vv3yxp5UFWRFSiDqQz9();
                                                }
                                                if (strReplaceAll.equals(V578A0VQ4KRFGjoYgMJ())) {
                                                    return v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid) ? String.valueOf(v8qP8fE86HMhvNuYPFjqY().getPlayerManager().xtOheRiObl4QeAl().get(uuid).getSouls()) : wq1RaUlW658Vg41Cn();
                                                }
                                                if (strReplaceAll.equals(F6UhSFSag7bzZWyQDKJeC4())) {
                                                    return v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid) ? String.format(nhXpBGkrgX2Stl9IJ1(), Double.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().Fc3p9FhCjSD1k5Ra4(uuid))) : jYve28AVmci7k6nhGBFq();
                                                }
                                                if (strReplaceAll.equals(tvNagvMRy8Uq5XsP7())) {
                                                    return optionalEmpty.isPresent() ? String.valueOf(optionalEmpty.get().getExtraSlots()) : aY75Uddy7nSqe3t3TT();
                                                }
                                                if (strReplaceAll.equals(UIrZlSfMvtWhwdfe05b())) {
                                                    return optionalEmpty.isPresent() ? String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().zJnaNCVQSgEShq(optionalEmpty.get())) : Ii34zkxpfO5Ptup2s4();
                                                }
                                                if (strReplaceAll.equals(VigRWZJzMblt01R())) {
                                                    return optionalEmpty.isPresent() ? String.valueOf(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().zJnaNCVQSgEShq(optionalEmpty.get()) + optionalEmpty.get().getExtraSlots()) : Pr9IJMHXZzaqElImIUVtrG();
                                                }
                                                if (strReplaceAll.startsWith(jlBeHTLXJXYLdMPJgo())) {
                                                    String[] strArrSplit7 = strReplaceAll.split(zzriCfosK0OkizICO4lIY());
                                                    if (optionalEmpty.isPresent() && strArrSplit7.length == 2) {
                                                        try {
                                                            ArrayList arrayList2 = new ArrayList(this.v8qP8fE86HMhvNuYPFjqY.getTopManager().jBUuLP0sWwaPyPOmogdX7l(ClanEnum.PlaceholderTop.valueOf(strArrSplit7[1].toUpperCase())).keySet());
                                                            UUID id = optionalEmpty.get().getId();
                                                            if (arrayList2.contains(id)) {
                                                                return String.valueOf(arrayList2.indexOf(id) + 1);
                                                            }
                                                        } catch (Exception e20) {
                                                        }
                                                    }
                                                    return UVT3ine2npdDFnMVEG3oqi();
                                                }
                                                if (strReplaceAll.startsWith(s0RApguhXJXgPq3CsftYVU())) {
                                                    if (optionalEmpty.isPresent()) {
                                                        String[] strArrSplit8 = strReplaceAll.split(WtxMKVmW1CKsYLrDSGjdl());
                                                        if (strArrSplit8.length == 2) {
                                                            Optional<ModerationData> optionalV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().v8qP8fE86HMhvNuYPFjqY(strArrSplit8[1], false);
                                                            if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                                                                ArrayList arrayList3 = new ArrayList();
                                                                optionalEmpty.get().getMembers().iterator().forEachRemaining(uuid2 -> {
                                                                    Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l3 = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid2);
                                                                    if (optionalB4i2FbOkaKeg91LiAe6l3.isPresent() && optionalB4i2FbOkaKeg91LiAe6l3.get().getId().equals(((ModerationData) optionalV8qP8fE86HMhvNuYPFjqY.get()).getId())) {
                                                                        Optional<PlayerData> optionalP31abtwfBag2jhMH6K23 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
                                                                        if (optionalP31abtwfBag2jhMH6K23.isPresent()) {
                                                                            arrayList3.add(optionalP31abtwfBag2jhMH6K23.get().getName());
                                                                        }
                                                                    }
                                                                });
                                                                return new jBWyXxi9EyWxcPiz(this.v8qP8fE86HMhvNuYPFjqY).v8qP8fE86HMhvNuYPFjqY(arrayList3);
                                                            }
                                                        }
                                                    }
                                                    return this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.TRANSLACTION_NONE);
                                                }
                                                if (strReplaceAll.startsWith(UfghxoiwHFlTQvIrh7PN6())) {
                                                    if (optionalEmpty.isPresent()) {
                                                        String[] strArrSplit9 = strReplaceAll.split(lvDmAnVJJ9dAjdWub9());
                                                        if (strArrSplit9.length == 2) {
                                                            Optional<ModerationData> optionalV8qP8fE86HMhvNuYPFjqY2 = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().v8qP8fE86HMhvNuYPFjqY(strArrSplit9[1], false);
                                                            if (optionalV8qP8fE86HMhvNuYPFjqY2.isPresent()) {
                                                                ArrayList arrayList4 = new ArrayList();
                                                                optionalEmpty.get().getMembers().iterator().forEachRemaining(uuid3 -> {
                                                                    Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l3 = this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid3);
                                                                    if (optionalB4i2FbOkaKeg91LiAe6l3.isPresent() && optionalB4i2FbOkaKeg91LiAe6l3.get().getId().equals(((ModerationData) optionalV8qP8fE86HMhvNuYPFjqY2.get()).getId())) {
                                                                        Optional<PlayerData> optionalP31abtwfBag2jhMH6K23 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid3);
                                                                        if (optionalP31abtwfBag2jhMH6K23.isPresent()) {
                                                                            arrayList4.add(optionalP31abtwfBag2jhMH6K23.get().getName());
                                                                        }
                                                                    }
                                                                });
                                                                return String.valueOf(arrayList4.size());
                                                            }
                                                        }
                                                    }
                                                    return spelcpPwTPTcZ3();
                                                }
                                                if (strReplaceAll.startsWith(yXhmFNDguMv14eRlf())) {
                                                    String[] strArrSplit10 = strReplaceAll.split(PE6VKO0DthweMxvv3Z());
                                                    if (strArrSplit10.length == 2) {
                                                        String upperCase8 = strArrSplit10[1].toUpperCase();
                                                        if (ClanEnum.SettingsType.valueOf(upperCase8.toUpperCase()) != null && optionalEmpty.isPresent()) {
                                                            switch (E0Zb3L2jgpdfCu9HPY.ZwrsrwOCXRUscW6Q[ClanEnum.SettingsType.valueOf(upperCase8.toUpperCase()).ordinal()]) {
                                                                case 1:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isWarInvite());
                                                                case 2:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isAllySharedChat());
                                                                case 3:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isAllySharedHome());
                                                                case 4:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isJoinLeave());
                                                                case 5:
                                                                    return String.valueOf(optionalEmpty.get().isFf());
                                                                case 6:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isOpened());
                                                                case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isPublicHomes());
                                                                case 8:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isReceveMailAllies());
                                                                case 9:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isReceiveMailAll());
                                                                case 10:
                                                                    return String.valueOf(optionalEmpty.get().getSettings().isAllyPvp());
                                                            }
                                                        }
                                                    }
                                                } else if (strReplaceAll.startsWith(Ahi8Px3jNOoQoVW())) {
                                                    String[] strArrSplit11 = strReplaceAll.split(REn8F2olnZowIkOJD());
                                                    if (strArrSplit11.length == 2) {
                                                        String upperCase9 = strArrSplit11[1].toUpperCase();
                                                        if (ClanEnum.PlayerSettingsType.valueOf(upperCase9.toUpperCase()) != null) {
                                                            if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                                                                return String.valueOf(V3pWD6Y9S09a8inz6iz());
                                                            }
                                                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K23 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                                                            if (optionalP31abtwfBag2jhMH6K23.isPresent()) {
                                                                switch (E0Zb3L2jgpdfCu9HPY.iZTqZaRK5UGoe0Z[ClanEnum.PlayerSettingsType.valueOf(upperCase9.toUpperCase()).ordinal()]) {
                                                                    case 1:
                                                                        return String.valueOf(optionalP31abtwfBag2jhMH6K23.get().getSettings().isInvitations());
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (strReplaceAll.startsWith(AtXCSyuXBFX8kyyArd5wZ())) {
                                                    String[] strArrSplit12 = strReplaceAll.split(MUyMZKtSHZP89wR1SWgn7y());
                                                    if (strArrSplit12.length == 2) {
                                                        String upperCase10 = strArrSplit12[1].toUpperCase();
                                                        if (ClanEnum.SettingsType.valueOf(upperCase10.toUpperCase()) != null && optionalEmpty.isPresent()) {
                                                            switch (E0Zb3L2jgpdfCu9HPY.ZwrsrwOCXRUscW6Q[ClanEnum.SettingsType.valueOf(upperCase10.toUpperCase()).ordinal()]) {
                                                                case 1:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isWarInvite()).toUpperCase())));
                                                                case 2:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isAllySharedChat()).toUpperCase())));
                                                                case 3:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isAllySharedHome()).toUpperCase())));
                                                                case 4:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isJoinLeave()).toUpperCase())));
                                                                case 5:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().isFf()).toUpperCase())));
                                                                case 6:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isOpened()).toUpperCase())));
                                                                case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isPublicHomes()).toUpperCase())));
                                                                case 8:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isReceveMailAllies()).toUpperCase())));
                                                                case 9:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isReceiveMailAll()).toUpperCase())));
                                                                case 10:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isAllyPvp()).toUpperCase())));
                                                            }
                                                        }
                                                    }
                                                } else if (strReplaceAll.startsWith(l7BGHT3Bjo9fx9im())) {
                                                    String[] strArrSplit13 = strReplaceAll.split(kMXRtWn8OwNY4Q7());
                                                    if (strArrSplit13.length == 2) {
                                                        String upperCase11 = strArrSplit13[1].toUpperCase();
                                                        if (ClanEnum.PlayerSettingsType.valueOf(upperCase11.toUpperCase()) != null) {
                                                            if (!v8qP8fE86HMhvNuYPFjqY().getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid)) {
                                                                return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(Ro4QsmS9zHKDrMychtNB()).toUpperCase())));
                                                            }
                                                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K24 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                                                            if (optionalP31abtwfBag2jhMH6K24.isPresent()) {
                                                                switch (E0Zb3L2jgpdfCu9HPY.iZTqZaRK5UGoe0Z[ClanEnum.PlayerSettingsType.valueOf(upperCase11.toUpperCase()).ordinal()]) {
                                                                    case 1:
                                                                        return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalP31abtwfBag2jhMH6K24.get().getSettings().isInvitations()).toUpperCase())));
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (strReplaceAll.startsWith(bxP0pIrUSJRD7pdGW())) {
                                                    String[] strArrSplit14 = strReplaceAll.split(EOODUejvPzEsBMqvpn7WdI());
                                                    if (strArrSplit14.length == 2) {
                                                        String upperCase12 = strArrSplit14[1].toUpperCase();
                                                        if (ClanEnum.SettingsType.valueOf(upperCase12.toUpperCase()) != null && optionalEmpty.isPresent()) {
                                                            switch (E0Zb3L2jgpdfCu9HPY.ZwrsrwOCXRUscW6Q[ClanEnum.SettingsType.valueOf(upperCase12.toUpperCase()).ordinal()]) {
                                                                case 1:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isWarInvite()).toUpperCase())));
                                                                case 2:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isAllySharedChat()).toUpperCase())));
                                                                case 3:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isAllySharedHome()).toUpperCase())));
                                                                case 4:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isJoinLeave()).toUpperCase())));
                                                                case 5:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().isFf()).toUpperCase())));
                                                                case 6:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isOpened()).toUpperCase())));
                                                                case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isPublicHomes()).toUpperCase())));
                                                                case 8:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isReceveMailAllies()).toUpperCase())));
                                                                case 9:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isReceiveMailAll()).toUpperCase())));
                                                                case 10:
                                                                    return String.valueOf(v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.valueOf("STATE_" + String.valueOf(optionalEmpty.get().getSettings().isAllyPvp()).toUpperCase())));
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (optionalEmpty.isPresent()) {
                                                List<UUID> members = optionalEmpty.get().getMembers();
                                                if (members == null) {
                                                    return "";
                                                }
                                                String string7 = "";
                                                try {
                                                    int i4 = 1;
                                                    if (members.size() > 0) {
                                                        for (UUID uuid4 : members) {
                                                            if (!uuid4.equals(optionalEmpty.get().getLeader())) {
                                                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K25 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(uuid4);
                                                                if (optionalP31abtwfBag2jhMH6K25.isPresent()) {
                                                                    String str7 = string7 + optionalP31abtwfBag2jhMH6K25.get().getName();
                                                                    string7 = i4 >= members.size() ? str7 + "." : str7 + ", ";
                                                                }
                                                                i4++;
                                                            }
                                                        }
                                                    } else {
                                                        string7 = v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.NOTHING_HERE);
                                                    }
                                                } catch (Exception e21) {
                                                }
                                                return string7;
                                            }
                                        } else if (optionalEmpty.isPresent()) {
                                            List<UUID> banned = optionalEmpty.get().getBanned();
                                            if (banned == null) {
                                                return "";
                                            }
                                            String string8 = "";
                                            try {
                                                int i5 = 1;
                                                if (banned.size() > 0) {
                                                    Iterator<UUID> it4 = banned.iterator();
                                                    while (it4.hasNext()) {
                                                        Optional<PlayerData> optionalP31abtwfBag2jhMH6K26 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(it4.next());
                                                        if (optionalP31abtwfBag2jhMH6K26.isPresent()) {
                                                            String str8 = string8 + optionalP31abtwfBag2jhMH6K26.get().getName();
                                                            string8 = i5 >= banned.size() ? str8 + "." : str8 + ", ";
                                                        }
                                                        i5++;
                                                    }
                                                } else {
                                                    string8 = v8qP8fE86HMhvNuYPFjqY().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(uuid)).getString(Lang.NOTHING_HERE);
                                                }
                                            } catch (Exception e22) {
                                            }
                                            return string8;
                                        }
                                    } else if (optionalEmpty.isPresent()) {
                                        return String.valueOf(optionalEmpty.get().isVerified());
                                    }
                                }
                            } else if (optionalEmpty.isPresent()) {
                                return optionalEmpty.get().getId().toString();
                            }
                        } else if (optionalEmpty.isPresent()) {
                            return new jBWyXxi9EyWxcPiz(v8qP8fE86HMhvNuYPFjqY()).b4i2FbOkaKeg91LiAe6l(String.valueOf(optionalEmpty.get().getLevel()));
                        }
                    } else if (optionalEmpty.isPresent()) {
                        Optional<PlayerData> optionalP31abtwfBag2jhMH6K27 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().p31abtwfBag2jhMH6K(optionalEmpty.get().getLeader());
                        if (optionalP31abtwfBag2jhMH6K27.isPresent()) {
                            return optionalP31abtwfBag2jhMH6K27.get().getName();
                        }
                    }
                } else if (optionalEmpty.isPresent()) {
                    if (optionalEmpty.get().getBanner() != null && !optionalEmpty.get().getBanner().isEmpty() && !optionalEmpty.get().getBanner().equalsIgnoreCase(SzDBLjkF4Rotr1fTH())) {
                        ItemStack itemStackItemStackFromBase64 = new Serialize().itemStackFromBase64(optionalEmpty.get().getBanner());
                        return itemStackItemStackFromBase64 == null ? this.v8qP8fE86HMhvNuYPFjqY.getLibManager().v8qP8fE86HMhvNuYPFjqY(ClanEnum.TranslatableKey.item, Clans.getClanCore().getLibManager().ZwrsrwOCXRUscW6Q(), new String[0]) : this.v8qP8fE86HMhvNuYPFjqY.getLibManager().v8qP8fE86HMhvNuYPFjqY(ClanEnum.TranslatableKey.item, itemStackItemStackFromBase64.getType().toString(), new String[0]);
                    }
                    if (Material.valueOf(v8qP8fE86HMhvNuYPFjqY().getLibManager().ZwrsrwOCXRUscW6Q()) != null) {
                        return this.v8qP8fE86HMhvNuYPFjqY.getLibManager().v8qP8fE86HMhvNuYPFjqY(ClanEnum.TranslatableKey.item, v8qP8fE86HMhvNuYPFjqY().getLibManager().ZwrsrwOCXRUscW6Q(), new String[0]);
                    }
                }
            }
            strJBUuLP0sWwaPyPOmogdX7l = v8qP8fE86HMhvNuYPFjqY().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(uuid, strReplaceAll);
            if (strJBUuLP0sWwaPyPOmogdX7l != null) {
                return strJBUuLP0sWwaPyPOmogdX7l;
            }
            strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY().getIntegrationManager().v8qP8fE86HMhvNuYPFjqY(uuid, strReplaceAll);
            if (strV8qP8fE86HMhvNuYPFjqY != null) {
                return strV8qP8fE86HMhvNuYPFjqY;
            }
            return "";
        } catch (Exception e23) {
        }
        return null;
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String q7vnd8H0INlzlViN1Hb0F() {
        return "%uclans_";
    }

    private static String R3U8b33OGuDCHHAZq() {
        return "%";
    }

    private static String D0GzMLQingV7pu7m5() {
        return "%";
    }

    private static String YkO4mLIOiRqoo4wvJtWj() {
        return "{uclans_";
    }

    private static String eSVjz8UyuC0qAsGeXJJv() {
        return "{";
    }

    private static String KkFIcB8lqyfPOnRUOIBM() {
        return "}";
    }

    private static String g1hp0tY1eHSjm9v() {
        return "uclans_";
    }

    private static String xOwbg7tM6RRZOeHLp4i() {
        return "uclans_";
    }

    private static String NAZzuTC9Tl446SKS2pHKkh() {
        return "money_currency";
    }

    private static String vXEr26FvLaNJaM1HbYV() {
        return "Config.money.currency";
    }

    private static String kzosaoDuW8WQe0OiUXL() {
        return "global_ff";
    }

    private static String lOzpP0T8ymIBJY8i() {
        return "search_player_clan";
    }

    private static String LbfbX6ueleuODYot() {
        return ":";
    }

    private static String LaifL1a6Ex417J() {
        return "extensions_all_instaled";
    }

    private static String LVP3Y9eo25hTGoPp() {
        return "extensions_all_oficial";
    }

    private static String euGOfARDZME9aoNrKVGqn() {
        return "addons_all_instaled";
    }

    private static String mnKC6MIfbcyu8RfyGumwTd() {
        return "addons_all_oficial";
    }

    private static String uR4O4xbtcifarRuzIHFgl() {
        return "wizard_enabled";
    }

    private static String qf1JilT9nwj8lMrwSX() {
        return "global_ff_formated";
    }

    private static String p91di2CWE0xdw7j() {
        return "money_current";
    }

    private static String b7PFMQENkSKfHHq() {
        return "Config.money.name";
    }

    private static String yKaJyvqrQTl9cpTR4uxcK() {
        return "Config.money.name";
    }

    private static String YNhgCBdKI1sPOAs14JI() {
        return "money_current_formated";
    }

    private static String BPO8ziYrSgB8K7K2kwCR() {
        return "Config.money.name";
    }

    private static String bnF3sui8kmV5c38UNg() {
        return "Config.money.name";
    }

    private static String N9e4HeOrCAlsSY46cNo() {
        return "unformated_top:";
    }

    private static String L8avgfq2InSZqRvC7kg() {
        return ":";
    }

    private static String hVGGxcKMjtU7vbhT7P() {
        return "position";
    }

    private static String X9Q8vwDfeA5f8vY() {
        return "tag";
    }

    private static String VY7ihdnA4FcqF7nc() {
        return "leader";
    }

    private static String NHcji71ffp0kMGOn() {
        return "value";
    }

    private static String Z1sH438KrmvTwonT5c1() {
        return "Config.money.format";
    }

    private static String gzGpQyMTHlKdZoJeQSZ() {
        return "bank";
    }

    private static String ozGY9czn8LxDOGx() {
        return "find";
    }

    private static String h8aNa6xURCP6e7k5Ro() {
        return "top:";
    }

    private static String OFMpwWoA8Fus6HX4KoP() {
        return ":";
    }

    private static String HrDr7tk6A4a8S6aV() {
        return "%num%";
    }

    private static String WBG7XGykpsIepqktcp8eB() {
        return "player_top:";
    }

    private static String HNpVp4bJoiTqEroEPpaL() {
        return ":";
    }

    private static String n69lZVRJhaPbgf5DQ() {
        return "%num%";
    }

    private static String yro4hLMKBjU09dg5ISA() {
        return "unformated_player_top:";
    }

    private static String VTLEjyTDTp8AFoZruU() {
        return ":";
    }

    private static String bUiA6uxV6fEaXsz() {
        return "position";
    }

    private static String tp5fTEwTC1PY1b88w8D() {
        return "name";
    }

    private static String GNXMeoRfrEmzmPm() {
        return "value";
    }

    private static String zqAr3DHyCNRJQE9xTw() {
        return "find";
    }

    private static String SuoXJtWOGTBn4RD() {
        return "\\{([^}]*)\\}_";
    }

    private static String TaiuzCixttZcz4LYMXhJr() {
        return "\\s+";
    }

    private static String XNz2NGM5fLm4G1sOg4HH() {
        return "hasclan";
    }

    private static String Jf3pIxRmVp96PY() {
        return "true";
    }

    private static String WvJGgRoIqruFz30sTk5Uh() {
        return "false";
    }

    private static String WTeRQaFwnkRNaY() {
        return "hasbanner";
    }

    private static String wgV69BUy0lhPnq5KiyadWx() {
        return "true";
    }

    private static String zrlqRwTSgoJN8rWT() {
        return "false";
    }

    private static String WgTBhIrxOH0VdVKH() {
        return "hasbanner_formated";
    }

    private static String zszyPmJvQczZhWZ0No() {
        return "isopen";
    }

    private static String z3xGYIxWJW9Jbdp() {
        return "true";
    }

    private static String i414vxS1378yCO4dSIv5iU() {
        return "false";
    }

    private static String us7qyPKZtdT6GuXwNz4GXY() {
        return "false";
    }

    private static String rdPtGb3Wzt8Uwt() {
        return "isopen_formated";
    }

    private static String stVoHdPHNvI8rBnNJofQ7() {
        return "false";
    }

    private static String mJk1WSzGTupQ5PCsBg() {
        return "is_ff";
    }

    private static String bgX8j2JVxMMc2zuv7() {
        return "false";
    }

    private static String NBzDOxBVZYZ1OMG() {
        return "is_ff_formated";
    }

    private static String KXOma0L0mnrRzsvPho() {
        return "hasclan_formated";
    }

    private static String yOnIT5ZesMgkAc27dh() {
        return "Clan.tag.noclan_formated";
    }

    private static String yBDlzqB4PV6C1NgmxUM() {
        return "hasclan_formated_nocolor";
    }

    private static String fi0QTlXEjKwqGY() {
        return "Clan.tag.noclan_formated";
    }

    private static String FUZxjMFb6eKT3BeWIm() {
        return "hasclan_formated_levelsup";
    }

    private static String PnIr012yTo3Fl7e() {
        return "Clan.tag.noclan_formated";
    }

    private static String vZo7efgioRYJTq37xB6() {
        return "hasclan_formated_levelsub";
    }

    private static String SKFBMonb9icjBZXt2O() {
        return "Clan.tag.noclan_formated";
    }

    private static String MgqMaNPNvTQP79YOSD3LKQ() {
        return "tag_nocolor";
    }

    private static String sVA6xj8m6eY1AWeh5OnPH() {
        return "tag_color";
    }

    private static String hpFxyBHpavT5UD724MA0X() {
        return "Clan.tag.default_color";
    }

    private static String hnq7wEt7yuHHbOsgwYL() {
        return "tag_color_levelsup";
    }

    private static String TjxhX5HrD2UzlGxqkIL53q() {
        return "Clan.tag.default_color";
    }

    private static String bC46RSV7z1EGxSsCYyL7M() {
        return "tag_color_levelsub";
    }

    private static String cC7MdTQj4rYjyWLloFLNEq() {
        return "Clan.tag.default_color";
    }

    private static String FxU1cHUT3kVu0CH7s() {
        return "tag_formated";
    }

    private static String PkO8bg7yORMEQ3jBEz3() {
        return "Clan.tag.start";
    }

    private static String mOq8CvgKnfLaaL() {
        return "Clan.tag.default_color";
    }

    private static String YfzfThAnGLT4B9T92S() {
        return "Clan.tag.end";
    }

    private static String XA2YbgNmqJuQCUesTAIEl() {
        return "tag_formated_nocolor";
    }

    private static String EnEEpX2HH1fJhzHj() {
        return "Clan.tag.start";
    }

    private static String lLBi4lF1AITjmUQrN() {
        return "Clan.tag.end";
    }

    private static String BMgmkEFPgp171eGQYT() {
        return "tag_formated_levelsup";
    }

    private static String fAkyK0vMnuxizN4li87() {
        return "Clan.tag.start";
    }

    private static String nh4XQ3cc8UXF9a1WS8j3JT() {
        return "Clan.tag.default_color";
    }

    private static String iwVilAqtPLs8GFt() {
        return "Clan.tag.end";
    }

    private static String wPFAOIFkVUZE1ADHsj0cBd() {
        return "tag_formated_levelsub";
    }

    private static String c5WIZ2UfpWIYm33R7() {
        return "Clan.tag.start";
    }

    private static String Z5ScvQAIHNKeaX1ErTbT() {
        return "Clan.tag.default_color";
    }

    private static String i7u4r5u50NpXXOXq() {
        return "Clan.tag.end";
    }

    private static String GYx4pzylR8PAZWBr() {
        return "tag_formated_level";
    }

    private static String WDt4xLce5xCGwrV() {
        return "Clan.tag.start";
    }

    private static String yAlgeLfZbpiCEC() {
        return "Clan.tag.default_color";
    }

    private static String l2jZxFd17ZqXkAwLC() {
        return "Clan.tag.end";
    }

    private static String y4n4IhwKoT3wdG8u3() {
        return "player";
    }

    private static String xlZlV96yfwfn7vxsft() {
        return "null";
    }

    private static String fkxQdHEMruDLCQ7ol() {
        return "nickname";
    }

    private static String qTG0f6KaOkEKPeHf1q8fzh() {
        return "Config.player.nickname.custom_char";
    }

    private static String GdMqS0TePhjFOXb() {
        return "current_lang";
    }

    private static String NfTnRZFyPKtDFXLnGP() {
        return "player_lang";
    }

    private static String Wulrfoam5LT98Mdz() {
        return "current_player_lang";
    }

    private static String jcSWIF0S4cW8mLu4cJa9px() {
        return "current_player_lang_head";
    }

    private static String ySlfalqjwZ9o1k() {
        return "Config.language_flags.default";
    }

    private static String cSqefGhKShVhpItODa() {
        return "current_lang_head";
    }

    private static String TEJGKXtYkeIzsB4() {
        return "Config.language_flags.default";
    }

    private static String qZusWm6iTs2HNjaVMup() {
        return "lang_head:";
    }

    private static String Y4PVUXxherqBtFQZIymEKe() {
        return ":";
    }

    private static String qkO0vc57fipczi0S2() {
        return "Config.language_flags.default";
    }

    private static String JIHMrGDmdVGHQKLH9tc6q() {
        return "player_head";
    }

    private static String ep1LwjepY8oOJ2nCKPqRZ() {
        return "Config.player.skin.on_empty";
    }

    private static String MwZW2r08mXv1REUPW() {
        return "Config.player.skin.on_empty";
    }

    private static String oPLzzVxuUonb3B() {
        return "leader_head";
    }

    private static String SuysgcsCrsQBksC9() {
        return "Config.player.skin.on_empty";
    }

    private static String bGD0RgxIEfxGh94bMQ() {
        return "Skins.cache.enable_custom";
    }

    private static String nDXvJNzPZ7BpUnJW() {
        return "Config.player.skin.on_empty";
    }

    private static String yvMvp4auA7JvNen() {
        return "player_name";
    }

    private static String GLmGwXmQDzMCTiUMi() {
        return "null";
    }

    private static String AsFi0HWJUtDoxGNf6Pml() {
        return "nickname";
    }

    private static String tmHB2osVfDRDnh() {
        return "Config.player.nickname.custom_char";
    }

    private static String qsMoXj3UPk4uiB2yOgEst() {
        return "player_realname";
    }

    private static String NPfZy5yLI7YeH7JDZ6Sz() {
        return "player_nickname";
    }

    private static String eVHpAYoe1W3QLv6() {
        return "null";
    }

    private static String QmbR9DBFno4Uow8ptc() {
        return "nickname";
    }

    private static String NhBSAh2YVsZI9Cef() {
        return "Config.player.nickname.custom_char";
    }

    private static String NnW035alHkpY4cCxFJq() {
        return "player_joindate";
    }

    private static String WkXkd6CaskpvddK() {
        return "0";
    }

    private static String DNlSsdsjGERpYeXHwAcDhi() {
        return "player_joindate_formated";
    }

    private static String ZrNM4ZSA2sDl0CeEcD() {
        return "Config.date_format_short";
    }

    private static String dlzlNWtPVUWPM1h() {
        return "0";
    }

    private static String RrwT6IXyfODn18PNmL() {
        return "player_lastsee";
    }

    private static String M2vw2Na8s6iSKHd8() {
        return "0";
    }

    private static String LKsUtTNJNZaHl9kNMkuAIs() {
        return "player_lastsee_formated";
    }

    private static String MRHKWZ8UE3dL2Hl2Jw() {
        return "Config.date_format_short";
    }

    private static String sPFQIdTjjBMUvmozHdZGWG() {
        return "0";
    }

    private static String FkZ4QIC5CMzTyWrr() {
        return "banner";
    }

    private static String VNP4V4YaW4aYCBKxCvi5rY() {
        return "null";
    }

    private static String C7QpiPyk82WwlIUhlLpL1i() {
        return "banner_material";
    }

    private static String SzDBLjkF4Rotr1fTH() {
        return "null";
    }

    private static String BVK60bemuKhorQPd() {
        return "banner_upload_acceptable";
    }

    private static String MMEe4bpkmf1ULv() {
        return "&8, ";
    }

    private static String QJbsyVt0GpYVxFRQf() {
        return "&8.";
    }

    private static String TyOpbuGHmFbX4Iw() {
        return "...";
    }

    private static String s3UWEFloutXSXvAiWSGK() {
        return "money_player";
    }

    private static String xHHHEYRcKZItamRx0TIe() {
        return "Config.money.format";
    }

    private static String QXTBveF0WkCL2Pu() {
        return "money";
    }

    private static String bSeb8gn8LPf7wesDd15i() {
        return "Config.money.format";
    }

    private static String JKUKCXBeP4gua89dHc() {
        return "money";
    }

    private static String OtIVRQGpS5RosGKM0() {
        return "desc_nocolor";
    }

    private static String UyLwQFPHNZL1M4Kr9rLg() {
        return "Clan.desc.nodesc_formated";
    }

    private static String NFoYtan5aZOx0g() {
        return "desc_color";
    }

    private static String LEQIgNlzLQdpshe9FQkjTN() {
        return "Clan.desc.nodesc_formated";
    }

    private static String DuoyHKeg6mb2beO() {
        return "Clan.desc.default_color";
    }

    private static String SdJylBUbOvQfbFu() {
        return "leader";
    }

    private static String z9syY4k6K3YnPqGUm8z() {
        return "leader_formated";
    }

    private static String YHaDfNPSldehBPuzLMar() {
        return "null";
    }

    private static String ZEuiWSGK59PW8wNMMsNV9z() {
        return "nickname";
    }

    private static String rNF3zNUtb065SsnC() {
        return "Config.player.nickname.custom_char";
    }

    private static String EjHyiZoAO2rrUklmW() {
        return "chat_active";
    }

    private static String wX3vXyHCC5ELJPEiUv3cpA() {
        return "false";
    }

    private static String bMCp4jMjk3yL1K8() {
        return "creation_date";
    }

    private static String yyzfVn5xMz9F4a3() {
        return "0";
    }

    private static String d9FtfJ87pJRzejGPUGG() {
        return "creation_hours";
    }

    private static String GaA29O1SzsOu7NQFXT9r() {
        return "0";
    }

    private static String sJg8Z6ylQkj16OxoYJvQB1() {
        return "creation_date_formated";
    }

    private static String LFpHFZZy6mNYVHIhudl() {
        return "Config.date_format_short";
    }

    private static String jXjVjqQAowVvy2YFbpRfWG() {
        return "0";
    }

    private static String ytVkI8K4GcuyoBWri() {
        return "points";
    }

    private static String UqNNvGuyXrfpay() {
        return "<points>";
    }

    private static String dfDABvblcpJjsdi5hRoc() {
        return "points";
    }

    private static String lVmnMxHBwYwpCs() {
        return "0";
    }

    private static String DwMVxIGYUNWYFDN7CiTkV() {
        return "points_unformated";
    }

    private static String OQTBM5YgJqvcEzC6() {
        return "0";
    }

    private static String jhOarEOJ8027BOfNwyx() {
        return "quest_finished";
    }

    private static String UMG03tHZNlZubxzsTt() {
        return "<points>";
    }

    private static String U2ywNnYRAihusCvlQF6ncT() {
        return "points";
    }

    private static String XWZMXEaRrjZQ6FcRds() {
        return "0";
    }

    private static String qskJTuj7XvtHXLVf() {
        return "level";
    }

    private static String nTVt8JgqIai0aDZlXO2x8() {
        return "<level>";
    }

    private static String RGDEad540sy7rM() {
        return "level";
    }

    private static String KldvcFRo6P4HZtCen() {
        return "0";
    }

    private static String VMQuiTHLDf35Zkw7ENMRd() {
        return "max_level_reached";
    }

    private static String HyjQAVzME2bRlhI() {
        return "<level>";
    }

    private static String PGckaxcIYwJl62YznMVTJ2() {
        return "level";
    }

    private static String tmhULk1sxdjhBp2() {
        return "0";
    }

    private static String iIc5ReCFtDv7KcjqTpsKxO() {
        return "levelsup";
    }

    private static String pxwGxHqAJsMsXNELKy() {
        return "levelsub";
    }

    private static String O4eAv3pmHAaRAGW1NYW() {
        return "bank_balance";
    }

    private static String dL13M1h9DmESuD() {
        return "Config.money.format";
    }

    private static String sPvgWMccieo9qmjCtAT() {
        return "bank";
    }

    private static String OSh9DzVTXlYIr6Z() {
        return "0";
    }

    private static String cJUtJ94jLsMPmxZjydnK() {
        return "bank_balance_formated";
    }

    private static String vkIzk53sKKHrRoBJl() {
        return "Config.money.format";
    }

    private static String EyBp0AwaWfnhGGsxwRZ() {
        return "bank";
    }

    private static String hcsxYcaEa14sEtc() {
        return "0";
    }

    private static String MgdFbOz3UOZAE4OeRT() {
        return "clanid";
    }

    private static String kHZJS5KnwIdaJP1Vk2jz() {
        return "clan_member_joined";
    }

    private static String Nz1xD7rtD1WAog10B() {
        return "0";
    }

    private static String pFLXoY6vUGl6ru5EFQX2M() {
        return "clan_member_leave";
    }

    private static String v5TUtkIEfEJKFi05Y() {
        return "0";
    }

    private static String PiuerSWabUaBSjJi50iC0Z() {
        return "clan_member_kicked";
    }

    private static String va8GaQO7XRURL30ay1() {
        return "0";
    }

    private static String zyoPebd4ydntiTp() {
        return "clan_war_win";
    }

    private static String LUr72SFFwgZqd6vr() {
        return "0";
    }

    private static String vS0XBwG3ko1QJAh() {
        return "clan_war_lose";
    }

    private static String QDmHzkNnV70fEcX6() {
        return "0";
    }

    private static String JH31PepD2Qmxp9b() {
        return "clan_war_total";
    }

    private static String EyGPk5Fossiq1sKe() {
        return "0";
    }

    private static String aVrhmcg1T3QeyJy() {
        return "clan_glad_win";
    }

    private static String teF3tz75CQyYNXqUlR() {
        return "0";
    }

    private static String S7I22oTzMQMMhlZra() {
        return "clan_glad_lose";
    }

    private static String AdKGb6FW8HLs1xjvoqA() {
        return "0";
    }

    private static String d0mlmS3WU0zWFH0DDi1() {
        return "clan_glad_total";
    }

    private static String jzZ5BDq9plxIrXqYr() {
        return "0";
    }

    private static String OG0Y2h5H7RXwJzMl() {
        return "clan_league_win";
    }

    private static String UdF8is8bfMIptSX() {
        return "0";
    }

    private static String hu6xa0c4B0LU9sN() {
        return "clan_league_lose";
    }

    private static String DoasfIpZIho6eik10() {
        return "0";
    }

    private static String VNCRHOd8KuMUBz() {
        return "clan_league_total";
    }

    private static String u6Lnh90sY9mwVISP() {
        return "0";
    }

    private static String f766tGmoEYT5CGu() {
        return "clan_tag_changed";
    }

    private static String cZ9JG2l4aXgt4Nz66() {
        return "0";
    }

    private static String PmA61vE7LHDk0t3ctVEU() {
        return "clan_souls";
    }

    private static String Iynv0rvCvPzwHjGr2YZsb0() {
        return "0";
    }

    private static String FDq7fXgutkD9SfqnI() {
        return "clan_kdr";
    }

    private static String VjMBk7Kqd9xM77kSAwo() {
        return "%.2f";
    }

    private static String KBHGAtGrW6qcnw1IHctxu() {
        return "0.0";
    }

    private static String EMOObIpeBBWyqPivv3S6() {
        return "clan_deaths";
    }

    private static String oOINhqLKtY7C9Zx3YN9() {
        return "0";
    }

    private static String lTtTVXHn2PEvbMSZXJ() {
        return "clan_kills";
    }

    private static String ScOwziK1KHhDhQ3() {
        return "0";
    }

    private static String zRwWj985YC1h0jux() {
        return "verified";
    }

    private static String PrzXPTk9z82jXoY() {
        return "verified_raw";
    }

    private static String jdPOCK7oX9ZJ3c() {
        return "verified_tag";
    }

    private static String YK1SLEH0NxIbQj() {
        return "verified_tag_formated";
    }

    private static String WnZHuNkMPQoaewKihuZx6a() {
        return "Clan.tag.start";
    }

    private static String X6vrYNBaQw2nkRH() {
        return "Clan.tag.default_color";
    }

    private static String nf8qYWro9MaaViVNbCR() {
        return "Clan.tag.end";
    }

    private static String mwG4dqnM4Ey7fHCkg6Ne5() {
        return "count_members";
    }

    private static String NcFPTUYlbYKccJWeOJpRMR() {
        return "0";
    }

    private static String bcGY6au4nVqnfMwFsc56X() {
        return "count_onlinemembers";
    }

    private static String PavsdmoQ3r0A6Rp9s9ELvr() {
        return "0";
    }

    private static String wa9BZBoP2BdrsEiHf() {
        return "0";
    }

    private static String Dvvs2QXItoASe1LMHA() {
        return "limit_chest";
    }

    private static String SnBdSMCJy446EAftIR() {
        return "--";
    }

    private static String uNBDoicNBITKHfuNGZ() {
        return "0";
    }

    private static String poJQ5cQx6xUHntCRq() {
        return "banned";
    }

    private static String aWyfr7dMT0nDfowOPggE() {
        return "count_banned";
    }

    private static String dSzW6SYBXXA3jBtvTm() {
        return "0";
    }

    private static String E2yVmsN95karEL68rJdft() {
        return "0";
    }

    private static String Bq8fosuC9C4wP7() {
        return "clan_members";
    }

    private static String oKedfkVgcduh1ARYhZGW() {
        return "clan_onlinemembers";
    }

    private static String MWQmVsIa3WHMcV() {
        return "player_kills";
    }

    private static String aBZUGxTRxNo2AHO() {
        return "0";
    }

    private static String aD7vFm0mF2GX9EoWnjsBu() {
        return "player_role_name";
    }

    private static String QnHRbprfVoZ1TNWAG() {
        return "player_role_formated";
    }

    private static String MSSFRHd21RgAkymC() {
        return "player_next_role_name";
    }

    private static String YnpPJKaxfBvpXW() {
        return "player_next_role_formated";
    }

    private static String n9JuOyrf6qnF5j() {
        return "player_prev_role_name";
    }

    private static String EgHPIxEagWNGARb() {
        return "player_prev_role_formated";
    }

    private static String XBsF9QQXS4ScF6R2uY() {
        return "player_permissions_amount";
    }

    private static String qZuqF0ZsoAI0NP() {
        return "player_permissions";
    }

    private static String BVIypTwwLYEL5NKI() {
        return "&8, ";
    }

    private static String uQeupYwIhCuVqW() {
        return "&8.";
    }

    private static String p1k80FvMib7eV0FdbWuaAE() {
        return "player_deaths";
    }

    private static String Vv3yxp5UFWRFSiDqQz9() {
        return "0";
    }

    private static String V578A0VQ4KRFGjoYgMJ() {
        return "player_souls";
    }

    private static String wq1RaUlW658Vg41Cn() {
        return "0";
    }

    private static String F6UhSFSag7bzZWyQDKJeC4() {
        return "player_kdr";
    }

    private static String nhXpBGkrgX2Stl9IJ1() {
        return "%.2f";
    }

    private static String jYve28AVmci7k6nhGBFq() {
        return "0.0";
    }

    private static String tvNagvMRy8Uq5XsP7() {
        return "slots_extra";
    }

    private static String aY75Uddy7nSqe3t3TT() {
        return "0";
    }

    private static String UIrZlSfMvtWhwdfe05b() {
        return "slots";
    }

    private static String Ii34zkxpfO5Ptup2s4() {
        return "0";
    }

    private static String VigRWZJzMblt01R() {
        return "slots_total";
    }

    private static String Pr9IJMHXZzaqElImIUVtrG() {
        return "0";
    }

    private static String jlBeHTLXJXYLdMPJgo() {
        return "current_position:";
    }

    private static String zzriCfosK0OkizICO4lIY() {
        return ":";
    }

    private static String UVT3ine2npdDFnMVEG3oqi() {
        return "0";
    }

    private static String s0RApguhXJXgPq3CsftYVU() {
        return "clan_role_members_list:";
    }

    private static String WtxMKVmW1CKsYLrDSGjdl() {
        return ":";
    }

    private static String UfghxoiwHFlTQvIrh7PN6() {
        return "clan_role_members_amount:";
    }

    private static String lvDmAnVJJ9dAjdWub9() {
        return ":";
    }

    private static String spelcpPwTPTcZ3() {
        return "0";
    }

    private static String yXhmFNDguMv14eRlf() {
        return "settings:";
    }

    private static String PE6VKO0DthweMxvv3Z() {
        return ":";
    }

    private static String Ahi8Px3jNOoQoVW() {
        return "player_settings:";
    }

    private static String REn8F2olnZowIkOJD() {
        return ":";
    }

    private static String V3pWD6Y9S09a8inz6iz() {
        return "false";
    }

    private static String AtXCSyuXBFX8kyyArd5wZ() {
        return "settings_state:";
    }

    private static String MUyMZKtSHZP89wR1SWgn7y() {
        return ":";
    }

    private static String l7BGHT3Bjo9fx9im() {
        return "player_settings_state:";
    }

    private static String kMXRtWn8OwNY4Q7() {
        return ":";
    }

    private static String Ro4QsmS9zHKDrMychtNB() {
        return "FALSE";
    }

    private static String bxP0pIrUSJRD7pdGW() {
        return "actions_state:";
    }

    private static String EOODUejvPzEsBMqvpn7WdI() {
        return ":";
    }
}
