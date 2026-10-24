package me.ulrich.clans.DTKXb4fQF6nDgxzg;

import me.ulrich.clans.data.OnlineData;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements TabCompleter {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static String SujEKxMzCEQRR9v13yCTx;
    private static volatile String NAap9zlFdkpUvu;
    private static String ccOZwOmWcBMTyhTkL;
    private static String hT2nvZmleCdcnu8VoOk2;
    private static volatile String SyfcQdo5PXKAnZT;
    private static String sqnTMrKzXPxH3oTHzjz3;
    private static volatile String MiDO06e8OHb6i4U7;
    private static String PTxLgUdxiAHDI6OWAm;
    private static volatile String j4jmoBDduplW2KJL;
    private static volatile String NfaNwyCyYxEpje;
    private static String OmBSBY2ukbwBpg4Sos1;
    private static String CG4Lu5iT16BdOXNRi7mFP1;
    private static volatile String iyJcfUkO9JYuOsq;
    private static volatile String CttSYcCaEBnn0RUy2;
    private static String NB9XuhlMLnMwOXANtVqOU;
    private static String JsufQRMoXmSLeEgDmXgwYP;
    private static volatile String GfQ8iMsPuX4nq18vg;
    private static String TdKkhX2Vp4cQT8;
    private static volatile String N9UGaLVXwAdk7Y4k;
    private static String v7YcP2aS7G6YUlLIAXx;
    private static volatile String Yo19UOkus5Vgcsb;
    private static String Ed099xH3uEvgwAcA7z;
    private static String joBKIa7vW6ri1u;
    private static volatile String S2HpGujnMwMtBSpYC;
    private static volatile String ZNXrYkzpgBOHGi6bsLQ;
    private static volatile String XcNLgr2ruswbL0;
    private static volatile String csxhhdInZDLLpJtW41SFp;
    private static String rALEJvxGjte9LxkxA;
    private static String BhXmT8PURp4UrsrVePEN4a;
    private static volatile String md2kmmXUEVlMLd8X3QSI;
    private static String mc8tvv5ZCAmjVbmi;
    private static String JZ90mHUTdKTbuOIqR;
    private static volatile String DOyNgUAJM4TzgfgjMr6o4M;
    private static volatile String cVzhglVcOepXQIt;
    private static String GaGWGORobVs1du0PNVL;
    private static volatile String KikoxXFIwuEMXKOeBwH;
    private static volatile String xu9tFQvN5tuScomu;
    private static volatile String qFU8Nezs5c1DE7Kw92G0e;
    private static String cyj5n2zroovhCF;
    private static String UsVZiExR8nJdrm;
    private static String qStolUOs590jflD8ovTg;
    private static volatile String qjFQGzx0qFHWFUej5EKa0;
    private static volatile String iPFhJcR9aMLz2LHZnmOtF;
    private static String Aegr0oOH2ABj1Vb9WPLmPZ;
    private static String qQZnOsDFAtXnL9CtSOB8w;
    private static String OcM9m00dI0Euz5sKkY9;
    private static String zn1Ee9kDIwYp7SSJZUVJ;
    private static String uSa7TQB66OwWDKvw;
    private static volatile String tDacnZqvETlszaDT7I;
    private static volatile String ajkOHiA3rkLx2zesAn0qiP;
    private static String UblEjc9NIQqdk7xGyTfWTy;
    private static volatile String qn57YmquhrFDDI89;
    private static volatile String sSRARsIvbsN7hz;
    private static String rTuPLZXv2irzIouW;
    private static volatile String QuCsE9Rv9QKoH5s4yix5;
    private static volatile String oaLqmYUBelYCtAFyEoY;
    private static String VMG6xAxJVMhGCVVC;
    private static String MHThTucZSPnm4kAh6w8;
    private static volatile String HjiyXiLyMn5KSbqnA6h;
    private static volatile String W4Mndwg1x901U8Rz9QK1w;
    private static volatile String QAgM13MbpzovmW;
    private static String Cal6KlsLJiskXP;
    private static volatile String HXnMQMXdh2y19OITX5fw;
    private static String H05YpMKxo5nTZf6;
    private static String RQyOPKdSYpeOwFZ;
    private static volatile String s9EEhcH0bODtL02MR;
    private static String yyVgUEX2UTxcTud2CcyV;
    private static String rLkO0Jhv3H96J6Vk2;
    private static volatile String o3L0UGfHcYoXHvECl;
    private static String HTlg56RIPlWDxHCv2VA;
    private static String b3e5nhreq0FvA1lBq8eB1;
    private static String CJdcr9qkbqzJCqn3kOqQyG;
    private static String RHc6KzGFvoIYHHwMdbp;
    private static volatile String ZWe8jJX1KgsXhHslIsqP71;
    private static volatile String Pzd63SqNfZkPXz5ENHJs;
    private static String zTWgJaNiewBZlaJny72K9;
    private static volatile String LSqK4I6XdF07jjjd42CvZ;
    private static volatile String eIKeTDAnSxrDA0Ix35;
    private static volatile String H5YOEu1iCRvcs6y7x7f;
    private static String RDAU2OjhExXucO;
    private static volatile String meoZoc2SAYXej65qKA;
    private static volatile String GK7F8HZsrSALgkl;
    private static volatile String bUZdEWt8BirrTsXw;
    private static String HJTuGwe1Xz6a0u2F8x9p;
    private static String bjYEr6tpHyYwjC;
    private static String ijdmnjXfmLuCAf0tHYVc;
    private static String JdUAq0c7KdvCMMWTqi;
    private static String jUPYl9LKrcejlv9xL31Kz;
    private static String QVryxPBne3gkSXANSWcX;
    private static volatile String loBc6YnxpiJJtA0ZsbfME;
    private static String FYwiDhKKFmM5pSbzkPGO;
    private static volatile String BFPd9JUnkv2i9iVtA;
    private static String FkSR5RJa34zkAGsntZa;
    private static volatile String ii7JlVvKXswW5HAS;
    private static String qcDutFBXYq9EgY6L2LyM;
    private static String I5lgGT49Ou9XX6hx;
    private static volatile String ei2n8ogqQIfa6Wc;
    private static String kx09fy0nU5cBghTdVMj;
    private static String I0Nda4K3pDEt912IBNRu;
    private static volatile String CkgSj0DJePKpgGDIlN8COY;
    private static String R9YATSVLMK6W2z;
    private static String An1Vc5topK3tDn7izy4a;
    private static volatile String A5H5JwIyWlWSTGa8MXP2Em;
    private static volatile String eWkz4p14JxgQHkTezyU;
    private static String fHZYSINqQI4xbxW7TD;
    private static String Fmtiyafn7miuHYCe0;
    private static volatile String U9TSvqoqxsFLm9WmrNS3B;
    private static volatile String eSctIPtuUaSxYWKVYq3ui;
    private static volatile String uBHUruAgDnwE9bX4s;
    private static String AKZUKNjcOISknQI;
    private static String Fe4vwYwcPyaMf9;
    private static volatile String ofZ91Nc7ERn16vw7l0mK;
    private static String fIKFsy1vjpfxw64IsE;
    private static volatile String Gip5nTlibEKsW9K78tM4l;
    private static volatile String TBXovxtbG54w7SOAnb4;
    private static String nG0s5P5em2eJrM;
    private static String VC1YIEcT8Lg4aWyP;
    private static volatile String aTaFdmV4FwpUj5b7lweaH;
    private static String A1hSpNkqnLeYOyZ;
    private static String ScV0qXUpVGllIq;
    private static String pYTCOv66WfL15mvC3;
    private static String gATnuSqCvpAgTy20tS;
    private static volatile String rKy8x9MioZp9GlK;
    private static String pi2qG7Li4U6F2FAt;
    private static volatile String MGs4SMId4TBH0b7xdJQKa;
    private static volatile String JMRGTO96hWu1toet3k;
    private static volatile String vJ2FDEWpjqp2kAU4;
    private static String fKsZIKFBlhDkPG;
    private static String fICuZguPFtFU67Uom8bm;
    private static volatile String oN5TmVpxpxj6jWPRZDe;
    private static String j5vVhlYR9426Roe;
    private static volatile String B3eqjqAgiIxBkHtLncLpD;
    private static volatile String sY8zs52XdeaOi0lNXVZxS;
    private static volatile String rNDFsKfF9VyhzqT;
    private static String CSdmBmEYDDXK3mU;
    private static String nSsVnVIfy1MuZZutklyYSu;
    private static volatile String LDGVdr1J1hs1q69ezO;
    private static volatile String NQuQ1zza58kZvkNvy2OyP;
    private static volatile String jTu2VbuG3BAH5B;
    private static String XDqLVeBFSbsfyXUOMHU4bI;
    private static String pXr9IT7D9lys0oBON71JW;
    private static String El6puQ7WgfBTCOK8Pd;
    private static String ayuaWj3KFFrceI9;
    private static volatile String Tf8ZlFANtcoNXBDzYwI;
    private static volatile String ZUv6Ia1yb1t6nnFjBIQJ0U;
    private static String PLkBwQcOr5qYWV;
    private static String py7rw1D9ZM7rhO6;
    private static String yb2b2zebddpHLs2AbU7B;
    private static String aO2H69TSqq00MpxzsLav;
    private static volatile String alS76W3KU7arnTMBEpghW;
    private static final byte[] f2e1drtnxgR5eqy11c5Q = {(byte) 243, (byte) 153, (byte) 187, (byte) 174, (byte) 22, (byte) 159, (byte) 69, (byte) 211, (byte) 144, (byte) 8, (byte) 236, (byte) 76, (byte) 254, (byte) 15, (byte) 27, (byte) 204};
    private static final byte[] IPzFG1HgsKKnsjzU4Gqiv = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] oD016WXmVIVCbfAN3Y = {(byte) 76, (byte) 189, (byte) 173, (byte) 176, (byte) 218, (byte) 232, (byte) 170, (byte) 225, (byte) 81, (byte) 252, (byte) 98, (byte) 153, (byte) 100, (byte) 138, (byte) 1, (byte) 212};
    private static final byte[] yX6qqgnoTSgZuUVL4 = {(byte) 94, (byte) 83, (byte) 91, (byte) 253, (byte) 222, (byte) 183, (byte) 161, (byte) 214, (byte) 120, (byte) 77, (byte) 230, (byte) 220, (byte) 194, (byte) 68, (byte) 27, (byte) 186};
    private static final byte[] Du0t1r47a35hyL51K = {(byte) 72, (byte) 104, (byte) 102, (byte) 252, (byte) 101, (byte) 185, (byte) 237, (byte) 96, (byte) 69, (byte) 248, (byte) 119, (byte) 150, (byte) 214, (byte) 47, (byte) 56, (byte) 225};
    private static final byte[] pl1Veq4a4XvYsgBaCGj = {(byte) 206, (byte) 15, (byte) 160, (byte) 238, (byte) 138, (byte) 40, (byte) 12, (byte) 3, (byte) 196, (byte) 71, (byte) 42, (byte) 179, (byte) 62, (byte) 202, (byte) 73, (byte) 133};
    private static final byte[] CviuLfgxuD2tUl = {(byte) 231, (byte) 155, (byte) 53, (byte) 199, (byte) 192, (byte) 143, (byte) 69, (byte) 110, (byte) 40, (byte) 168, (byte) 99, (byte) 241, (byte) 123, (byte) 187, (byte) 90, (byte) 150};
    private static final byte[] vosdnHdis9gBAy = {(byte) 222, (byte) 186, (byte) 187, (byte) 157, (byte) 234, (byte) 220, (byte) 32, (byte) 113, (byte) 134, (byte) 168, (byte) 75, (byte) 174, (byte) 31, (byte) 216, (byte) 37, (byte) 75};
    private static final byte[] jrbtB0FLYETYYEgkuUwPf = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] p95WGkufKNxW4BEbMu = {(byte) 166, (byte) 224, (byte) 70, (byte) 103, (byte) 68, (byte) 209, (byte) 236, (byte) 12, (byte) 172, (byte) 95, (byte) 224, (byte) 161, (byte) 48, (byte) 112, (byte) 90, (byte) 216};
    private static final byte[] gMm8iJNdMY2rM09gfgtFW = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] eqeCEo8LxxWxrkj10SBVD = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] sPTyTxfP6HcDSgZFca = {(byte) 164, (byte) 132, (byte) 87, (byte) 118, (byte) 7, (byte) 24, (byte) 253, (byte) 30, (byte) 30, (byte) 14, (byte) 27, (byte) 185, (byte) 93, (byte) 44, (byte) 231, (byte) 93};
    private static final byte[] b6jyEItc0C2u0y = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] RsJviZbNHXsugZSw0 = {(byte) 206, (byte) 15, (byte) 160, (byte) 238, (byte) 138, (byte) 40, (byte) 12, (byte) 3, (byte) 196, (byte) 71, (byte) 42, (byte) 179, (byte) 62, (byte) 202, (byte) 73, (byte) 133};
    private static final byte[] xCcpqeMGdCg5NZsL = {(byte) 81, (byte) 13, (byte) 184, (byte) 244, (byte) 230, (byte) 147, (byte) 193, (byte) 1, (byte) 166, (byte) 92, (byte) 15, (byte) 13, (byte) 47, (byte) 1, (byte) 53, (byte) 41};
    private static final byte[] xOxyI0g89yEX66QXr = {(byte) 94, (byte) 83, (byte) 91, (byte) 253, (byte) 222, (byte) 183, (byte) 161, (byte) 214, (byte) 120, (byte) 77, (byte) 230, (byte) 220, (byte) 194, (byte) 68, (byte) 27, (byte) 186};
    private static final byte[] UCZLhocZAIEbUlFiDS31O = {(byte) 23, (byte) 5, (byte) 228, (byte) 156, (byte) 96, (byte) 141, (byte) 184, (byte) 214, (byte) 90, (byte) 255, (byte) 7, (byte) 152, (byte) 157, (byte) 12, (byte) 140, (byte) 46};
    private static final byte[] c6HtEEcmkZxpH1UG1A = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] pA1qq9c8jFsoce = {(byte) 219, (byte) 203, (byte) 123, (byte) 126, (byte) 57, (byte) 150, (byte) 243, (byte) 181, (byte) 15, (byte) 94, (byte) 162, (byte) 48, (byte) 76, (byte) 137, (byte) 154, (byte) 150};
    private static final byte[] jgfCR8Jq73OCFvT = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] p91HfjJEBauvZo = {(byte) 206, (byte) 15, (byte) 160, (byte) 238, (byte) 138, (byte) 40, (byte) 12, (byte) 3, (byte) 196, (byte) 71, (byte) 42, (byte) 179, (byte) 62, (byte) 202, (byte) 73, (byte) 133};
    private static final byte[] DhKhyzyIGc6J4o = {(byte) 220, (byte) 41, (byte) 239, (byte) 37, (byte) 163, (byte) 137, (byte) 159, (byte) 223, (byte) 12, (byte) 195, (byte) 173, (byte) 49, (byte) 63, (byte) 146, (byte) 50, (byte) 88};
    private static final byte[] Fusv8rawbkAYsK4BTkZ = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] kKHSkOhTKDNCW5Ov = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] ieXOKRQL2qZVsHM = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] dvadbOuov7FfIpnCKFt3g = {(byte) 132, (byte) 101, (byte) 220, (byte) 85, (byte) 233, (byte) 14, (byte) 59, (byte) 16, (byte) 88, (byte) 77, (byte) 3, (byte) 226, (byte) 28, (byte) 153, (byte) 174, (byte) 164};
    private static final byte[] Qi32hQB5rP08ANLe8 = {(byte) 23, (byte) 5, (byte) 228, (byte) 156, (byte) 96, (byte) 141, (byte) 184, (byte) 214, (byte) 90, (byte) 255, (byte) 7, (byte) 152, (byte) 157, (byte) 12, (byte) 140, (byte) 46};
    private static final byte[] LhnQ3MCFCgdCbf = {(byte) 88, (byte) 227, (byte) 2, (byte) 165, (byte) 71, (byte) 134, (byte) 107, (byte) 94, (byte) 201, (byte) 217, (byte) 199, (byte) 4, (byte) 9, (byte) 250, (byte) 227, (byte) 17};
    private static final byte[] LyXlwiUa3nURY3DK = {(byte) 81, (byte) 13, (byte) 184, (byte) 244, (byte) 230, (byte) 147, (byte) 193, (byte) 1, (byte) 166, (byte) 92, (byte) 15, (byte) 13, (byte) 47, (byte) 1, (byte) 53, (byte) 41};
    private static final byte[] EJZAUuvYs0bjHf0cr = {(byte) 141, (byte) 240, (byte) 195, (byte) 140, (byte) 7, (byte) 18, (byte) 73, (byte) 175, (byte) 243, (byte) 34, (byte) 236, (byte) 7, (byte) 193, (byte) 9, (byte) 187, (byte) 247};
    private static final byte[] q9uhaqwugGq51EyCHz9NON = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] hQJgKwHU4SuObta = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] y6UtVFu6gzhD81C6REk = {(byte) 123, (byte) 1, (byte) 11, (byte) 76, (byte) 22, (byte) 14, (byte) 33, (byte) 26, (byte) 114, (byte) 224, (byte) 105, (byte) 227, (byte) 31, (byte) 155, (byte) 252, (byte) 90};
    private static final byte[] mN31UfWkJnt0lkE = {(byte) 222, (byte) 186, (byte) 187, (byte) 157, (byte) 234, (byte) 220, (byte) 32, (byte) 113, (byte) 134, (byte) 168, (byte) 75, (byte) 174, (byte) 31, (byte) 216, (byte) 37, (byte) 75};
    private static final byte[] QTvlLXhPXGyziUp0uMdo = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] buNyZlnzsSzAHAu5gph = {(byte) 171, (byte) 208, (byte) 167, (byte) 102, (byte) 43, (byte) 48, (byte) 61, (byte) 13, (byte) 107, (byte) 166, (byte) 229, (byte) 96, (byte) 37, (byte) 84, (byte) 85, (byte) 57};
    private static final byte[] pm3JZig7XKePeM2 = {(byte) 118, (byte) 115, (byte) 87, (byte) 127, (byte) 252, (byte) 107, (byte) 144, (byte) 227, (byte) 6, (byte) 175, (byte) 48, (byte) 247, (byte) 166, (byte) 72, (byte) 218, (byte) 29};
    private static final byte[] tEo4TQgEbwtYWaV2S = {(byte) 206, (byte) 15, (byte) 160, (byte) 238, (byte) 138, (byte) 40, (byte) 12, (byte) 3, (byte) 196, (byte) 71, (byte) 42, (byte) 179, (byte) 62, (byte) 202, (byte) 73, (byte) 133};
    private static final byte[] TJ1jDfW2BUnecEG6aIKVW = {(byte) 91, (byte) 133, (byte) 62, (byte) 102, (byte) 122, (byte) 55, (byte) 151, (byte) 173, (byte) 252, (byte) 142, (byte) 247, (byte) 116, (byte) 213, (byte) 253, (byte) 30, (byte) 158};
    private static final byte[] bHb2FSogwwaLXKbLMcB2 = {(byte) 173, (byte) 44, (byte) 63, (byte) 183, (byte) 243, (byte) 211, (byte) 118, (byte) 20, (byte) 206, (byte) 119, (byte) 17, (byte) 60, (byte) 172, (byte) 77, (byte) 120, (byte) 76};
    private static final byte[] zoUSh8CfjHyvhlSNMwlQq = {(byte) 31, (byte) 235, (byte) 154, (byte) 73, (byte) 146, (byte) 134, (byte) 86, (byte) 109, (byte) 236, (byte) 163, (byte) 110, (byte) 189, (byte) 74, (byte) 123, (byte) 85, (byte) 187};
    private static final byte[] tT1k8nNkAz2aCe = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] l80OMRQTKG45yNnST3flrl = {(byte) 154, (byte) 148, (byte) 170, (byte) 37, (byte) 141, (byte) 139, (byte) 133, (byte) 124, (byte) 23, (byte) 22, (byte) 63, (byte) 190, (byte) 22, (byte) 77, (byte) 150, (byte) 14};
    private static final byte[] h08jDtypfr6XNW6Q7r9X = {(byte) 154, (byte) 148, (byte) 170, (byte) 37, (byte) 141, (byte) 139, (byte) 133, (byte) 124, (byte) 23, (byte) 22, (byte) 63, (byte) 190, (byte) 22, (byte) 77, (byte) 150, (byte) 14};
    private static final byte[] FVe45aU9EaDjxgD8w = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] wIP9R3iYO8seuvpC0Cl70v = {(byte) 154, (byte) 148, (byte) 170, (byte) 37, (byte) 141, (byte) 139, (byte) 133, (byte) 124, (byte) 23, (byte) 22, (byte) 63, (byte) 190, (byte) 22, (byte) 77, (byte) 150, (byte) 14};
    private static final byte[] Eb9ytLSdmumPGZ16HqvZl = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] P0aUuoDzWgdLsdfc6sA8r = {(byte) 154, (byte) 148, (byte) 170, (byte) 37, (byte) 141, (byte) 139, (byte) 133, (byte) 124, (byte) 23, (byte) 22, (byte) 63, (byte) 190, (byte) 22, (byte) 77, (byte) 150, (byte) 14};
    private static final byte[] mvP9G7c0cPkOOSsJnLD1AQ = {(byte) 206, (byte) 15, (byte) 160, (byte) 238, (byte) 138, (byte) 40, (byte) 12, (byte) 3, (byte) 196, (byte) 71, (byte) 42, (byte) 179, (byte) 62, (byte) 202, (byte) 73, (byte) 133};
    private static final byte[] wKQglgFsmU0Dfoxt7iOU = {(byte) 165, (byte) 30, (byte) 43, (byte) 179, (byte) 61, (byte) 81, (byte) 124, (byte) 137, (byte) 138, (byte) 28, (byte) 150, (byte) 22, (byte) 147, (byte) 161, (byte) 231, (byte) 212};
    private static final byte[] tIbZbivEJxkjJ05R5R8pe = {(byte) 240, (byte) 152, (byte) 127, (byte) 156, (byte) 237, (byte) 103, (byte) 62, (byte) 253, (byte) 120, (byte) 168, (byte) 175, (byte) 151, (byte) 217, (byte) 3, (byte) 102, (byte) 110};
    private static final byte[] uTRaY9dM653A5bcB2tz = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] ufQrQLJi3TNMd9HlVQCD = {(byte) 67, (byte) 164, (byte) 149, (byte) 59, (byte) 92, (byte) 7, (byte) 13, (byte) 205, (byte) 18, (byte) 253, (byte) 19, (byte) 216, (byte) 239, (byte) 61, (byte) 251, (byte) 42};
    private static final byte[] WS48bzXM9WdmaY9vw = {(byte) 206, (byte) 15, (byte) 160, (byte) 238, (byte) 138, (byte) 40, (byte) 12, (byte) 3, (byte) 196, (byte) 71, (byte) 42, (byte) 179, (byte) 62, (byte) 202, (byte) 73, (byte) 133};
    private static final byte[] Mz8cIOgypcfIeeDS = {(byte) 219, (byte) 203, (byte) 123, (byte) 126, (byte) 57, (byte) 150, (byte) 243, (byte) 181, (byte) 15, (byte) 94, (byte) 162, (byte) 48, (byte) 76, (byte) 137, (byte) 154, (byte) 150};
    private static final byte[] RCcOLyDgi3aEJ2HC0 = {(byte) 220, (byte) 41, (byte) 239, (byte) 37, (byte) 163, (byte) 137, (byte) 159, (byte) 223, (byte) 12, (byte) 195, (byte) 173, (byte) 49, (byte) 63, (byte) 146, (byte) 50, (byte) 88};
    private static final byte[] e4k1n5bmHTnzKO1X = {(byte) 134, (byte) 97, (byte) 162, (byte) 203, (byte) 137, (byte) 231, (byte) 220, (byte) 35, (byte) 182, (byte) 66, (byte) 165, (byte) 7, (byte) 92, (byte) 230, (byte) 236, (byte) 181};
    private static final byte[] dyy6Lf4KiLncat = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] K4QVci6hpVqV8x654 = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] gYiX8azi2xW18zkr = {(byte) 83, (byte) 49, (byte) 243, (byte) 44, (byte) 89, (byte) 73, (byte) 1, (byte) 147, (byte) 79, (byte) 60, (byte) 23, (byte) 42, (byte) 180, (byte) 18, (byte) 32, (byte) 19};
    private static final byte[] p08uxavoULCSEJgPY = {(byte) 60, (byte) 133, (byte) 46, (byte) 90, (byte) 218, (byte) 106, (byte) 4, (byte) 199, (byte) 9, (byte) 16, (byte) 33, (byte) 62, (byte) 156, (byte) 222, (byte) 48, (byte) 238, (byte) 185, (byte) 115, (byte) 19, (byte) 183, (byte) 14, (byte) 66, (byte) 91, (byte) 182, (byte) 143, (byte) 174, (byte) 207, (byte) 7, (byte) 126, (byte) 230, (byte) 148, (byte) 31, (byte) 31, (byte) 224, (byte) 197, (byte) 64, (byte) 207, (byte) 49, (byte) 57, (byte) 61, (byte) 153, (byte) 33, (byte) 211, (byte) 211, (byte) 148, (byte) 223, (byte) 137, (byte) 196};

    public Ijap9SQKkijXSxP5(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:440:0x1186. Please report as an issue. */
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        ArrayList<InviteData> arrayList;
        ArrayList<InviteData> arrayList2;
        boolean z = this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(vX20KtVYOYvcgPAW());
        if (!(commandSender instanceof Player)) {
            return new ArrayList();
        }
        Player player = (Player) commandSender;
        ArrayList<String> arrayList3 = new ArrayList<>();
        ArrayList<String> arrayList4 = new ArrayList<>();
        ArrayList<String> arrayList5 = new ArrayList<>();
        ArrayList<String> arrayList6 = new ArrayList<>();
        ArrayList<String> arrayList7 = new ArrayList<>();
        if (strArr.length == 1) {
            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                arrayList3.add(lYdrQSwBWjnpHUIs4u());
            }
            try {
                for (Map.Entry<String, CommandData> entry : v8qP8fE86HMhvNuYPFjqY().getCommandManager().ZwrsrwOCXRUscW6Q().entrySet()) {
                    if ((!entry.getValue().getPermission().isEmpty() && commandSender.hasPermission(entry.getValue().getPermission())) || entry.getValue().getPermission().isEmpty()) {
                        arrayList3.add(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q(entry.getValue().getId()));
                    }
                }
                return (List) arrayList3.stream().filter(str2 -> {
                    return str2 != null && str2.startsWith(strArr[0]);
                }).collect(Collectors.toList());
            } catch (Exception e) {
                return arrayList3;
            }
        }
        if (strArr.length == 2) {
            if (strArr[0] != null && !strArr[0].isEmpty()) {
                String strXtOheRiObl4QeAl = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[0]);
                if (strXtOheRiObl4QeAl != null && this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(strXtOheRiObl4QeAl)) {
                    CommandData commandData = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(strXtOheRiObl4QeAl);
                    Iterator<Map.Entry<String, CommandData_show>> it = commandData.getSubcommands().entrySet().iterator();
                    if (commandData.getSubcommands().size() > 0) {
                        while (it.hasNext()) {
                            arrayList4.add(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q(it.next().getKey()));
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(aff1Gex8mUkRAMzLw())) {
                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                            arrayList4.add(CAggZXoKaTLkyL());
                        }
                        this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator().forEachRemaining(clanData -> {
                            arrayList4.add(clanData.getTagNoColor());
                        });
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(Y71MFz8LmHa3AaET3())) {
                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                            arrayList4.add(FsgNhW98ranp8IsX3s());
                        }
                        Arrays.asList(ClanEnum.PlaceholderTop.values()).iterator().forEachRemaining(placeholderTop -> {
                            arrayList4.add(placeholderTop.toString());
                        });
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(NSF8qJxemRGgKkelEzFhdl())) {
                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                            arrayList4.add(q8nIbfV6LaMOcR());
                        }
                        Arrays.asList(ClanEnum.PlaceholderPlayerTop.values()).iterator().forEachRemaining(placeholderPlayerTop -> {
                            arrayList4.add(placeholderPlayerTop.toString());
                        });
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(FRBNWbLzED6SVso())) {
                        arrayList4.add(cSEmBRXhHlFi4u2VUVnQMb());
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(A02nXmiV6aqdACqHvq16Tr())) {
                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                        if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers() != null) {
                            ArrayList<OnlineData> arrayList8 = new ArrayList<>((List<OnlineData>) this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq().stream().filter(onlineData -> {
                                return !onlineData.getPlayerUUID().equals(player.getUniqueId());
                            }).collect(Collectors.toList()));
                            arrayList8.removeIf(onlineData2 -> {
                                return ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getMembers().contains(onlineData2.getPlayerUUID()) || onlineData2.getPlayerUUID().equals(player.getUniqueId()) || this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), onlineData2.getPlayerUUID()) || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData2.getPlayerUUID()) || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData2.getPlayerUUID()) || !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().b4i2FbOkaKeg91LiAe6l(onlineData2.getPlayerUUID()) || this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().isInvisible(onlineData2.getPlayerUUID());
                            });
                            arrayList8.iterator().forEachRemaining(onlineData3 -> {
                                arrayList4.add(onlineData3.getPlayerName());
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(pk0I9ewCnzVEkFyTJ())) {
                        List<InviteData> listIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().iZTqZaRK5UGoe0Z(player.getUniqueId());
                        if (listIZTqZaRK5UGoe0Z != null && (arrayList2 = new ArrayList(listIZTqZaRK5UGoe0Z)) != null) {
                            arrayList2.removeIf(inviteData -> {
                                return !this.v8qP8fE86HMhvNuYPFjqY.getClanManager().ZwrsrwOCXRUscW6Q(inviteData.getClanID());
                            });
                            arrayList2.iterator().forEachRemaining(inviteData2 -> {
                                this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(inviteData2.getClanID()).ifPresent(clanData2 -> {
                                    arrayList4.add(clanData2.getTagNoColor());
                                });
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(mNnpLbUrRQmz5ybl())) {
                        List<InviteData> listIZTqZaRK5UGoe0Z2 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerInviteManager().iZTqZaRK5UGoe0Z(player.getUniqueId());
                        if (listIZTqZaRK5UGoe0Z2 != null && (arrayList = new ArrayList(listIZTqZaRK5UGoe0Z2)) != null) {
                            arrayList.removeIf(inviteData3 -> {
                                return !this.v8qP8fE86HMhvNuYPFjqY.getClanManager().ZwrsrwOCXRUscW6Q(inviteData3.getClanID());
                            });
                            arrayList.iterator().forEachRemaining(inviteData4 -> {
                                this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(inviteData4.getClanID()).ifPresent(clanData2 -> {
                                    arrayList4.add(clanData2.getTagNoColor());
                                });
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(p3VlI73iA2wbmdJnl())) {
                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                        if (optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
                            optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getMembers().stream().filter(uuid -> {
                                return !player.getUniqueId().equals(uuid);
                            }).iterator().forEachRemaining(uuid2 -> {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
                                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                                    arrayList4.add(optionalP31abtwfBag2jhMH6K.get().getName());
                                }
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(RjC92kvPs2TW9dMbk33ID())) {
                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR3 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                        if (optionalCDW4Fj1iwdIXEOqWjiJSR3.isPresent()) {
                            optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getMembers().stream().filter(uuid3 -> {
                                return !player.getUniqueId().equals(uuid3);
                            }).iterator().forEachRemaining(uuid4 -> {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid4);
                                if (optionalP31abtwfBag2jhMH6K != null) {
                                    arrayList4.add(optionalP31abtwfBag2jhMH6K.get().getName());
                                }
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(dDWmF47IjCPDHRxI())) {
                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR4 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                        if (optionalCDW4Fj1iwdIXEOqWjiJSR4.isPresent()) {
                            Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                            ArrayList<Player> arrayList9 = new ArrayList<>(onlinePlayers);
                            if (optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getBanned() != null && optionalCDW4Fj1iwdIXEOqWjiJSR4.get().getBanned().size() > 0) {
                                arrayList9.removeIf(player2 -> {
                                    return ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR4.get()).getBanned().contains(player2.getUniqueId());
                                });
                            }
                            arrayList9.removeIf(player3 -> {
                                return player.getUniqueId().equals(player3.getUniqueId());
                            });
                            onlinePlayers.iterator().forEachRemaining(player4 -> {
                                arrayList4.add(player4.getName());
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(zCXfEDeenxPbFNISL3())) {
                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR5 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                        if (optionalCDW4Fj1iwdIXEOqWjiJSR5.isPresent()) {
                            ArrayList<UUID> arrayList10 = new ArrayList<>(optionalCDW4Fj1iwdIXEOqWjiJSR5.get().getBanned());
                            if (optionalCDW4Fj1iwdIXEOqWjiJSR5.get().getBanned() != null) {
                                arrayList10.removeIf(uuid5 -> {
                                    return player.getUniqueId().equals(uuid5);
                                });
                            }
                            arrayList10.iterator().forEachRemaining(uuid6 -> {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid6);
                                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                                    arrayList4.add(optionalP31abtwfBag2jhMH6K.get().getName());
                                }
                            });
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(cLFkjxUXVMtwkzgz())) {
                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR6 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                        if (optionalCDW4Fj1iwdIXEOqWjiJSR6.isPresent()) {
                            optionalCDW4Fj1iwdIXEOqWjiJSR6.get().getMembers().iterator().forEachRemaining(uuid7 -> {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid7);
                                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                                    arrayList4.add(optionalP31abtwfBag2jhMH6K.get().getName());
                                }
                            });
                        }
                    }
                }
                return (List) arrayList4.stream().filter(str3 -> {
                    return str3 != null && str3.toLowerCase().startsWith(strArr[1].toLowerCase());
                }).collect(Collectors.toList());
            }
        } else if (strArr.length == 3) {
            String strXtOheRiObl4QeAl2 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[0]);
            if (strXtOheRiObl4QeAl2 != null) {
                if (strArr[1] != null && !strArr[1].isEmpty() && this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(strXtOheRiObl4QeAl2)) {
                    String strXtOheRiObl4QeAl3 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[1]);
                    if (this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(strXtOheRiObl4QeAl2).getSubcommands().containsKey(strXtOheRiObl4QeAl3)) {
                        if (strXtOheRiObl4QeAl2.equalsIgnoreCase(wgwCrVKSrlJmLcPnpOFYfP())) {
                            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR7 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                            byte b = -1;
                            switch (strXtOheRiObl4QeAl3.hashCode()) {
                                case -934610812:
                                    if (strXtOheRiObl4QeAl3.equals(MSOM7HSWRMuIBsAI5jdV())) {
                                        b = 2;
                                    }
                                    break;
                                case 96417:
                                    if (strXtOheRiObl4QeAl3.equals(CBk0IaXDq0ITtx92UnpmC())) {
                                        b = 1;
                                    }
                                    break;
                                case 3322014:
                                    if (strXtOheRiObl4QeAl3.equals(tUhZ3JaYMy5e3DBCS())) {
                                        b = 0;
                                    }
                                    break;
                            }
                            switch (b) {
                                case 0:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList5.add(MXbNokFls1aWJ2z0l6K());
                                    }
                                    ConcurrentHashMap<UUID, ClanData> concurrentHashMapCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR();
                                    HashMap<UUID, ClanData> map = new HashMap<>();
                                    map.putAll(concurrentHashMapCDW4Fj1iwdIXEOqWjiJSR);
                                    map.values().iterator().forEachRemaining(clanData2 -> {
                                        arrayList5.add(clanData2.getTagNoColor());
                                    });
                                    break;
                                case 1:
                                    if (optionalCDW4Fj1iwdIXEOqWjiJSR7.isPresent()) {
                                        HashMap<UUID, ClanData> map2 = new HashMap<>(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR());
                                        map2.entrySet().removeIf(entry2 -> {
                                            return ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR7.get()).getRivalAlly().getAlly().contains(((ClanData) entry2.getValue()).getId());
                                        });
                                        map2.entrySet().iterator().forEachRemaining(entry3 -> {
                                            arrayList5.add(((ClanData) entry3.getValue()).getTagNoColor());
                                        });
                                    }
                                    break;
                                case 2:
                                    if (optionalCDW4Fj1iwdIXEOqWjiJSR7.isPresent()) {
                                        optionalCDW4Fj1iwdIXEOqWjiJSR7.get().getRivalAlly().getAlly().iterator().forEachRemaining(uuid8 -> {
                                            this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(uuid8).ifPresent(clanData3 -> {
                                                arrayList5.add(clanData3.getTagNoColor());
                                            });
                                        });
                                    }
                                    break;
                            }
                        } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(zdwCQmkDeeTWqLyaE6dhv())) {
                            byte b2 = -1;
                            switch (strXtOheRiObl4QeAl3.hashCode()) {
                                case 3322014:
                                    if (strXtOheRiObl4QeAl3.equals(wTZNzMwJBt7xy2K2TZmNa())) {
                                        b2 = 1;
                                    }
                                    break;
                                case 949444906:
                                    if (strXtOheRiObl4QeAl3.equals(au7eWyiOlaKSHo9HCNLgu())) {
                                        b2 = 0;
                                    }
                                    break;
                            }
                            switch (b2) {
                                case 0:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList5.add(mFqDR0d4E04rhDjagSTYA());
                                    }
                                    Optional<RewardsModuleAPI> optionalCDW4Fj1iwdIXEOqWjiJSR8 = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().CDW4Fj1iwdIXEOqWjiJSR();
                                    if (optionalCDW4Fj1iwdIXEOqWjiJSR8.isPresent()) {
                                        optionalCDW4Fj1iwdIXEOqWjiJSR8.get().getPlayerRewards(player.getUniqueId()).iterator().forEachRemaining(rewardsData -> {
                                            arrayList5.add(rewardsData.getId().toString());
                                        });
                                    }
                                    break;
                                case 1:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList5.add(QqDdpEHvCgxuKPBuzYr());
                                    }
                                    arrayList5.add(jnX4alnaU5xZvRz4yRmjOI());
                                    arrayList5.add(zl72XD0wm1qsgsW2iugl());
                                    break;
                            }
                        } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(G0w0RoK6I0l6tMAJuBi())) {
                            byte b3 = -1;
                            switch (strXtOheRiObl4QeAl3.hashCode()) {
                                case 113762:
                                    if (strXtOheRiObl4QeAl3.equals(PYYSEK7084yXfbTEwVPY())) {
                                        b3 = 0;
                                    }
                                    break;
                                case 3322014:
                                    if (strXtOheRiObl4QeAl3.equals(bKl2mzEg0eTuEnDoHi())) {
                                        b3 = 1;
                                    }
                                    break;
                                case 3619493:
                                    if (strXtOheRiObl4QeAl3.equals(MqyHHnk064KzP9C())) {
                                        b3 = 2;
                                    }
                                    break;
                            }
                            switch (b3) {
                                case 0:
                                    List<String> listHqTnbBoUmxDUXvki = this.v8qP8fE86HMhvNuYPFjqY.getFiles().hqTnbBoUmxDUXvki();
                                    Objects.requireNonNull(arrayList5);
                                    listHqTnbBoUmxDUXvki.forEach((v1) -> {
                                        arrayList5.add(v1);
                                    });
                                case 1:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList5.add(zdsqCisd9jMX41m82jYn());
                                        break;
                                    }
                                case 2:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList5.add(EcpXRoXWiZGq7J4Y());
                                    }
                                    break;
                            }
                        } else if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(l7GZTfx7EyUdYmzWoodp())) {
                            if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(m2SSNMnepxKodqAw2P())) {
                                if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(sBGfDEConVl2cTyjLPlIfA())) {
                                    if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(oF0F0X4Jzhsu7sn3())) {
                                        if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(Yn3u4XJgPH78hJd())) {
                                            if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(nF55yvHJWlkqhtn())) {
                                                if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(j5p1iZjG8kHBlrJDarhg())) {
                                                    if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(aWMrCvVI292C6s())) {
                                                        if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(sX2lUtpR0isks2AaP1QVUd())) {
                                                            if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(mI85WyCjPDOoZqbYIrJ())) {
                                                                if (strXtOheRiObl4QeAl2.equalsIgnoreCase(AdaprTPZ4zeiopZWL4I2())) {
                                                                    byte b4 = -1;
                                                                    switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                                        case -1396343010:
                                                                            if (strXtOheRiObl4QeAl3.equals(nBfWKolNaEymZVkMYFHU())) {
                                                                                b4 = 2;
                                                                            }
                                                                            break;
                                                                        case 113762:
                                                                            if (strXtOheRiObl4QeAl3.equals(GHQc9fGFUgNGW7())) {
                                                                                b4 = 1;
                                                                            }
                                                                            break;
                                                                        case 3619493:
                                                                            if (strXtOheRiObl4QeAl3.equals(PxJbRFy0bN9ip1y7c8t())) {
                                                                                b4 = 0;
                                                                            }
                                                                            break;
                                                                    }
                                                                    switch (b4) {
                                                                        case 0:
                                                                            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                                arrayList5.add(GpygNZz9cGaZM07Q());
                                                                            }
                                                                            break;
                                                                        case 1:
                                                                            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                                arrayList5.add(jubLfcLZE7rasAX2NQpJ());
                                                                            }
                                                                            Arrays.asList(ClanEnum.SettingsType.values()).iterator().forEachRemaining(settingsType -> {
                                                                                arrayList5.add(settingsType.toString());
                                                                            });
                                                                            break;
                                                                        case 2:
                                                                            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                                arrayList5.add(P7AV6b3kkKYf1TonQov());
                                                                            }
                                                                            break;
                                                                    }
                                                                }
                                                            } else {
                                                                Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR9 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                                                                byte b5 = -1;
                                                                switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                                    case -1423461112:
                                                                        if (strXtOheRiObl4QeAl3.equals(Okww3tcsNomaWtpc())) {
                                                                            b5 = 4;
                                                                        }
                                                                        break;
                                                                    case -934610812:
                                                                        if (strXtOheRiObl4QeAl3.equals(wHkbO9IyYDoU7oczrW6Q())) {
                                                                            b5 = 2;
                                                                        }
                                                                        break;
                                                                    case 96417:
                                                                        if (strXtOheRiObl4QeAl3.equals(ObN95dlXLcYuoLr())) {
                                                                            b5 = 1;
                                                                        }
                                                                        break;
                                                                    case 3079692:
                                                                        if (strXtOheRiObl4QeAl3.equals(tx7EIMQbtK45lMQwkyjHg())) {
                                                                            b5 = 3;
                                                                        }
                                                                        break;
                                                                    case 3322014:
                                                                        if (strXtOheRiObl4QeAl3.equals(KiR0vwmhx4HVtIDPsyb2O())) {
                                                                            b5 = 0;
                                                                        }
                                                                        break;
                                                                }
                                                                switch (b5) {
                                                                    case 0:
                                                                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                            arrayList5.add(hqcRuyL7oaW53HNN());
                                                                        }
                                                                        this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator().forEachRemaining(clanData3 -> {
                                                                            arrayList5.add(clanData3.getTagNoColor());
                                                                        });
                                                                        break;
                                                                    case 1:
                                                                        if (optionalCDW4Fj1iwdIXEOqWjiJSR9.isPresent()) {
                                                                            HashMap<UUID, ClanData> map3 = new HashMap<>(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR());
                                                                            map3.entrySet().removeIf(entry4 -> {
                                                                                return ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR9.get()).getRivalAlly().getRival().contains(((ClanData) entry4.getValue()).getId());
                                                                            });
                                                                            map3.entrySet().iterator().forEachRemaining(entry5 -> {
                                                                                arrayList5.add(((ClanData) entry5.getValue()).getTagNoColor());
                                                                            });
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        if (optionalCDW4Fj1iwdIXEOqWjiJSR9.isPresent()) {
                                                                            optionalCDW4Fj1iwdIXEOqWjiJSR9.get().getRivalAlly().getRival().iterator().forEachRemaining(uuid9 -> {
                                                                                this.v8qP8fE86HMhvNuYPFjqY.getClanManager().iZTqZaRK5UGoe0Z(uuid9).ifPresent(clanData4 -> {
                                                                                    arrayList5.add(clanData4.getTagNoColor());
                                                                                });
                                                                            });
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        } else {
                                                            byte b6 = -1;
                                                            switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                                case -1423461112:
                                                                    if (strXtOheRiObl4QeAl3.equals(zjzIbLuQfwFHPP())) {
                                                                        b6 = 2;
                                                                    }
                                                                    break;
                                                                case 3079692:
                                                                    if (strXtOheRiObl4QeAl3.equals(VNN0l86ci3ssgHWH())) {
                                                                        b6 = 0;
                                                                    }
                                                                    break;
                                                                case 3526536:
                                                                    if (strXtOheRiObl4QeAl3.equals(RaVAK9qJEbtYAO())) {
                                                                        b6 = 1;
                                                                    }
                                                                    break;
                                                            }
                                                            switch (b6) {
                                                            }
                                                        }
                                                    } else {
                                                        byte b7 = -1;
                                                        switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                            case -295005754:
                                                                if (strXtOheRiObl4QeAl3.equals(gDdxnzsL1yRilwTZ())) {
                                                                    b7 = 4;
                                                                }
                                                                break;
                                                            case 113762:
                                                                if (strXtOheRiObl4QeAl3.equals(cMdbNTuS305H7AFw())) {
                                                                    b7 = 2;
                                                                }
                                                                break;
                                                            case 3619493:
                                                                if (strXtOheRiObl4QeAl3.equals(i6jwjRcgUhyM36f())) {
                                                                    b7 = 0;
                                                                }
                                                                break;
                                                            case 1133704324:
                                                                if (strXtOheRiObl4QeAl3.equals(l3wFinLkrBalKHBqeOHwQ())) {
                                                                    b7 = 1;
                                                                }
                                                                break;
                                                            case 1960030858:
                                                                if (strXtOheRiObl4QeAl3.equals(UGUBSWE2pcbBHnZKZmQFMO())) {
                                                                    b7 = 3;
                                                                }
                                                                break;
                                                        }
                                                        switch (b7) {
                                                            case 0:
                                                            case 1:
                                                                if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                    arrayList5.add(EtGxEf4n6v8zqpFwZQ());
                                                                }
                                                                new ArrayList<Player>(Bukkit.getOnlinePlayers()).iterator().forEachRemaining(player5 -> {
                                                                    arrayList5.add(player5.getName());
                                                                });
                                                                break;
                                                            case 2:
                                                                Arrays.asList(ClanEnum.PlayerSettingsType.values()).iterator().forEachRemaining(playerSettingsType -> {
                                                                    arrayList5.add(playerSettingsType.toString());
                                                                });
                                                                break;
                                                            case 3:
                                                                if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                    arrayList5.add(KhCth8ahdFLBHVBLjIWC());
                                                                }
                                                                break;
                                                        }
                                                    }
                                                } else {
                                                    Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR10 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                                                    byte b8 = -1;
                                                    switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                        case -1183699191:
                                                            if (strXtOheRiObl4QeAl3.equals(GUqYR1K3DEPfPyr6KTg())) {
                                                                b8 = 2;
                                                            }
                                                            break;
                                                        case -906336856:
                                                            if (strXtOheRiObl4QeAl3.equals(GMh785F6c976D6WG8Me6A())) {
                                                                b8 = 0;
                                                            }
                                                            break;
                                                        case 3291718:
                                                            if (strXtOheRiObl4QeAl3.equals(VzB4IDOPM7mfpy3Ta())) {
                                                                b8 = 1;
                                                            }
                                                            break;
                                                        case 3322014:
                                                            if (strXtOheRiObl4QeAl3.equals(TogKLYPe8Jz0ZvezM7())) {
                                                                b8 = 3;
                                                            }
                                                            break;
                                                    }
                                                    switch (b8) {
                                                        case 1:
                                                            if (optionalCDW4Fj1iwdIXEOqWjiJSR10.isPresent()) {
                                                                optionalCDW4Fj1iwdIXEOqWjiJSR10.get().getMembers().iterator().forEachRemaining(uuid10 -> {
                                                                    this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid10).ifPresent(playerData -> {
                                                                        arrayList5.add(playerData.getName());
                                                                    });
                                                                });
                                                                break;
                                                            }
                                                        case 2:
                                                            if (optionalCDW4Fj1iwdIXEOqWjiJSR10.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR10.get().getMembers() != null) {
                                                                ArrayList<OnlineData> arrayList11 = new ArrayList<>((List<OnlineData>) this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().zJnaNCVQSgEShq().stream().filter(onlineData4 -> {
                                                                    return !onlineData4.getPlayerUUID().equals(player.getUniqueId());
                                                                }).collect(Collectors.toList()));
                                                                arrayList11.removeIf(onlineData5 -> {
                                                                    return ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR10.get()).getMembers().contains(onlineData5.getPlayerUUID());
                                                                });
                                                                arrayList11.iterator().forEachRemaining(onlineData6 -> {
                                                                    arrayList5.add(onlineData6.getPlayerName());
                                                                });
                                                            }
                                                            break;
                                                        case 3:
                                                            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                                arrayList5.add(ViOK74ao5MDIz8());
                                                            }
                                                            this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator().forEachRemaining(clanData4 -> {
                                                                arrayList5.add(clanData4.getTagNoColor());
                                                            });
                                                            break;
                                                    }
                                                }
                                            } else {
                                                byte b9 = -1;
                                                switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                    case -1360201941:
                                                        if (strXtOheRiObl4QeAl3.equals(lWESaIjCwzR7K8X())) {
                                                            b9 = 1;
                                                        }
                                                        break;
                                                    case -1352294148:
                                                        if (strXtOheRiObl4QeAl3.equals(CIXxXWad4HYe3HzrBrLsz())) {
                                                            b9 = 3;
                                                        }
                                                        break;
                                                    case -1335458389:
                                                        if (strXtOheRiObl4QeAl3.equals(bGQ055aPNiJkaocDh99e())) {
                                                            b9 = 2;
                                                        }
                                                        break;
                                                    case 3322014:
                                                        if (strXtOheRiObl4QeAl3.equals(cqFVyUZjsi2DNTwET())) {
                                                            b9 = 4;
                                                        }
                                                        break;
                                                    case 3619493:
                                                        if (strXtOheRiObl4QeAl3.equals(vxNmIvAA09oUiy())) {
                                                            b9 = 0;
                                                        }
                                                        break;
                                                }
                                                switch (b9) {
                                                    case 0:
                                                    case 1:
                                                    case 2:
                                                        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR11 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                                                        if (optionalCDW4Fj1iwdIXEOqWjiJSR11.isPresent() && optionalCDW4Fj1iwdIXEOqWjiJSR11.get().getHome() != null) {
                                                            optionalCDW4Fj1iwdIXEOqWjiJSR11.get().getHome().iterator().forEachRemaining(homesData -> {
                                                                arrayList5.add(homesData.getName());
                                                            });
                                                        }
                                                        break;
                                                    case 4:
                                                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                            arrayList5.add(WT4Euo6Aye4J08BCn7w());
                                                        }
                                                        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getBoolean(CkJYJ7NFvyN6iCSv())) {
                                                            this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator().forEachRemaining(clanData5 -> {
                                                                arrayList5.add(clanData5.getTagNoColor());
                                                            });
                                                        } else {
                                                            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR12 = v8qP8fE86HMhvNuYPFjqY().getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                                                            if (optionalCDW4Fj1iwdIXEOqWjiJSR12.isPresent()) {
                                                                arrayList5.add(optionalCDW4Fj1iwdIXEOqWjiJSR12.get().getTagNoColor());
                                                            }
                                                        }
                                                        break;
                                                }
                                            }
                                        } else {
                                            byte b10 = -1;
                                            switch (strXtOheRiObl4QeAl3.hashCode()) {
                                                case -1335458389:
                                                    if (strXtOheRiObl4QeAl3.equals(IoNhGxjlUp9NWdF())) {
                                                        b10 = 2;
                                                    }
                                                    break;
                                                case -838595071:
                                                    if (strXtOheRiObl4QeAl3.equals(Y5bCjtHRV3SO0X())) {
                                                        b10 = 1;
                                                    }
                                                    break;
                                                case 3619493:
                                                    if (strXtOheRiObl4QeAl3.equals(qg3opv4I51uYvPase2a())) {
                                                        b10 = 0;
                                                    }
                                                    break;
                                            }
                                            switch (b10) {
                                                case 0:
                                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                        arrayList5.add(IAzBIUr2mw8BwZe());
                                                    }
                                                    break;
                                                case 1:
                                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                        arrayList5.add(bl548h6QjeoL2z());
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        byte b11 = -1;
                                        switch (strXtOheRiObl4QeAl3.hashCode()) {
                                            case 113762:
                                                if (strXtOheRiObl4QeAl3.equals(wRo7GtKeq7KKQBfBWLnQy())) {
                                                    b11 = 1;
                                                }
                                                break;
                                            case 3619493:
                                                if (strXtOheRiObl4QeAl3.equals(CsrA7vx9r4LdxUZkUAm())) {
                                                    b11 = 0;
                                                }
                                                break;
                                        }
                                        switch (b11) {
                                            case 0:
                                                if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                    arrayList5.add(juoo3lkz1BV6vpG6Ab());
                                                }
                                                break;
                                            case 1:
                                                this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().zJnaNCVQSgEShq().keySet().iterator().forEachRemaining(str4 -> {
                                                    arrayList5.add(str4);
                                                });
                                                break;
                                        }
                                    }
                                } else {
                                    byte b12 = -1;
                                    switch (strXtOheRiObl4QeAl3.hashCode()) {
                                        case 3496342:
                                            if (strXtOheRiObl4QeAl3.equals(H0izXXirK2znfY7G())) {
                                                b12 = 0;
                                            }
                                            break;
                                        case 3526536:
                                            if (strXtOheRiObl4QeAl3.equals(PNsaTkU8FJhcBogvHm8O())) {
                                                b12 = 1;
                                            }
                                            break;
                                    }
                                    switch (b12) {
                                        case 0:
                                            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                arrayList5.add(SeBzQEnnBSDqi70litGfS());
                                            }
                                            Arrays.asList(ClanEnum.MailTime.values()).iterator().forEachRemaining(mailTime -> {
                                                arrayList5.add(mailTime.toString());
                                            });
                                            break;
                                        case 1:
                                            arrayList5.add(hBg4ZHIjMWRUEP());
                                            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR13 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                                            if (optionalCDW4Fj1iwdIXEOqWjiJSR13.isPresent()) {
                                                optionalCDW4Fj1iwdIXEOqWjiJSR13.get().getRivalAlly().getAlly().iterator().forEachRemaining(uuid11 -> {
                                                    Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR14 = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                                                    if (optionalCDW4Fj1iwdIXEOqWjiJSR14.isPresent()) {
                                                        arrayList5.add(optionalCDW4Fj1iwdIXEOqWjiJSR14.get().getTagNoColor());
                                                    }
                                                });
                                            } else {
                                                arrayList5.add(NzV0y0GtsF3P8eSm4L());
                                            }
                                            break;
                                    }
                                }
                            } else {
                                byte b13 = -1;
                                switch (strXtOheRiObl4QeAl3.hashCode()) {
                                    case 3619493:
                                        if (strXtOheRiObl4QeAl3.equals(hO3P0wVPZ381uOloX4())) {
                                            b13 = 0;
                                        }
                                        break;
                                }
                                switch (b13) {
                                    case 0:
                                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                            arrayList5.add(spXLHEa9PheNM4wRxCV());
                                        }
                                        Arrays.asList(ClanEnum.LoggerTime.values()).iterator().forEachRemaining(loggerTime -> {
                                            arrayList5.add(loggerTime.toString());
                                        });
                                        break;
                                }
                            }
                        } else if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                            arrayList5.add(xtMmFrdisBlCU5QV0());
                        }
                    } else if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(EPgzmjWay1MNs2()) || strArr[2].equalsIgnoreCase(WCf5J3zc75poiCaY83())) {
                        if (strXtOheRiObl4QeAl2.equalsIgnoreCase(xv0AUB2xZeWVRnfcT()) || strXtOheRiObl4QeAl2.equalsIgnoreCase(mpweld8uCYQia2P())) {
                            this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[1]).ifPresent(playerData -> {
                                this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().v8qP8fE86HMhvNuYPFjqY(playerData.getRole(), true).ifPresent(moderationData -> {
                                    List<String> listV8qP8fE86HMhvNuYPFjqY = strXtOheRiObl4QeAl2.equalsIgnoreCase(SSbLtEmOWQs8Vpb()) ? this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().v8qP8fE86HMhvNuYPFjqY(true, moderationData.getPriority()) : this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().jBUuLP0sWwaPyPOmogdX7l(true, moderationData.getPriority());
                                    if (listV8qP8fE86HMhvNuYPFjqY != null) {
                                        arrayList5.addAll(listV8qP8fE86HMhvNuYPFjqY);
                                    }
                                });
                            });
                        } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(kYdWrMo7wVJyfZvy7k()) && !strArr[2].equalsIgnoreCase(SEvw9LDrCt5kM0m()) && this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                            arrayList5.add(T5YXBloPU9s8GCZk0sE5Su());
                        }
                    } else if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                        arrayList5.add(onSvFUuO1EA70EF7Zerfm());
                    }
                }
                return (List) arrayList5.stream().filter(str5 -> {
                    return str5.startsWith(strArr[2]);
                }).collect(Collectors.toList());
            }
        } else {
            if (strArr.length == 4) {
                String strXtOheRiObl4QeAl4 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[0]);
                if (strXtOheRiObl4QeAl4 != null && strArr[1] != null && !strArr[1].isEmpty() && this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(strXtOheRiObl4QeAl4)) {
                    String strXtOheRiObl4QeAl5 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[1]);
                    if (this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(strXtOheRiObl4QeAl4).getSubcommands().containsKey(strXtOheRiObl4QeAl5)) {
                        if (strXtOheRiObl4QeAl4.equalsIgnoreCase(TPknhO6AxvQFmROCfRX())) {
                            if (strXtOheRiObl4QeAl5.equals(Pa0ld5UlNij7eHzDAO()) && this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                arrayList6.add(QN2XvmK1NY1PbCPKfqeM9i());
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(gk1CzNVvQT0lY0k())) {
                            if (strXtOheRiObl4QeAl5.equals(FT38F6H2jxfVRBy2SB2R())) {
                                if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                    arrayList6.add(y6w4upobPLWKRT2yAP0xXF());
                                }
                                if (this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().zJnaNCVQSgEShq().containsKey(strArr[2])) {
                                    this.v8qP8fE86HMhvNuYPFjqY.getModerationManager().zJnaNCVQSgEShq().get(strArr[2]).getPermissionList().keySet().iterator().forEachRemaining(str6 -> {
                                        arrayList6.add(str6);
                                    });
                                }
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(MmCQqhVEgvsDrLV())) {
                            byte b14 = -1;
                            switch (strXtOheRiObl4QeAl5.hashCode()) {
                                case 3619493:
                                    if (strXtOheRiObl4QeAl5.equals(A27m3pPtZhYaVo85zlK2PU())) {
                                        b14 = 0;
                                    }
                                    break;
                            }
                            switch (b14) {
                                case 0:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList6.add(U6k02tb6As2veKsD());
                                    }
                                    Arrays.asList(ClanEnum.LoggerTime.values()).iterator().forEachRemaining(loggerTime2 -> {
                                        arrayList6.add(en05BqSjPYQyD8KNqe());
                                    });
                                    break;
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(rVTxffN3xC0EJBk8mRmlA())) {
                            byte b15 = -1;
                            switch (strXtOheRiObl4QeAl5.hashCode()) {
                                case 3496342:
                                    if (strXtOheRiObl4QeAl5.equals(eG6BoBGKsWtEGuMt())) {
                                        b15 = 0;
                                    }
                                    break;
                            }
                            switch (b15) {
                                case 0:
                                    if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                        arrayList6.add(UqRiLLw03FkuLgtz6mTT());
                                    }
                                    Arrays.asList(ClanEnum.MailTime.values()).iterator().forEachRemaining(mailTime2 -> {
                                        arrayList6.add(NpZT16zifoW7wP());
                                    });
                                    break;
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(ihKgeZuxBfsFI1ZwfUr2())) {
                            if (strXtOheRiObl4QeAl5.equals(nIoILbAxLV2LvMr()) && this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                arrayList6.add(lFIPTJ543EjIzqxoZZ2());
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(kqJbX2BdMPOSShtAM())) {
                            if (strXtOheRiObl4QeAl5.equals(h0Yz4eCZ0bkRTe7SxFAq()) && this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                arrayList6.add(fQhBblSkFkJPp2Tg());
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(NJnbn9Tgo6imXKSb6fCkM())) {
                            if (strXtOheRiObl4QeAl5.equals(gVnusS9UOLarnBP8uNYhD())) {
                                if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                    arrayList6.add(n87c7kUUf38s0TN());
                                }
                            } else if (strXtOheRiObl4QeAl5.equals(v2CMBzsIENWdp6c()) && this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                arrayList6.add(riieATMyNLQa4gYbVGeb());
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(E26126dH42ZuYwPZgLec())) {
                            if (strXtOheRiObl4QeAl5.equals(ruezNo6xZ957Vl()) || strXtOheRiObl4QeAl5.equals(kCFbT0xSaaoh7KyT6oClw())) {
                                if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                    arrayList6.add(oZvQX9rowQ7zFl4HuK());
                                }
                            } else if (strXtOheRiObl4QeAl5.equals(DzTMyHLZcJgwt7PSja0I4h())) {
                                Arrays.asList(ClanEnum.SettingsFlagsAccept.values()).iterator().forEachRemaining(settingsFlagsAccept -> {
                                    arrayList6.add(settingsFlagsAccept.toString());
                                });
                            }
                        } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(exAkaomqoiG7908DE1R()) && strXtOheRiObl4QeAl5.equals(bfCJUtKUyzy4Spo4())) {
                            Arrays.asList(ClanEnum.SettingsFlagsAccept.values()).iterator().forEachRemaining(settingsFlagsAccept2 -> {
                                arrayList6.add(settingsFlagsAccept2.toString());
                            });
                        }
                    } else if (strXtOheRiObl4QeAl4.equalsIgnoreCase(x1zKmYp5uO16jJVzYN4z())) {
                    }
                }
                return (List) arrayList6.stream().filter(str7 -> {
                    return str7.startsWith(strArr[3]);
                }).collect(Collectors.toList());
            }
            if (strArr.length == 5) {
                String strXtOheRiObl4QeAl6 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[0]);
                if (strXtOheRiObl4QeAl6 != null && strArr[1] != null && !strArr[1].isEmpty() && this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(strXtOheRiObl4QeAl6)) {
                    String strXtOheRiObl4QeAl7 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[1]);
                    if (this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(strXtOheRiObl4QeAl6).getSubcommands().containsKey(strXtOheRiObl4QeAl7)) {
                        if (!strXtOheRiObl4QeAl6.equalsIgnoreCase(fmmtP9HagFvaxOGcv())) {
                            if (!strXtOheRiObl4QeAl6.equalsIgnoreCase(i2w7dgBaSMQYpW0RXQ())) {
                                if (strXtOheRiObl4QeAl6.equalsIgnoreCase(O6UO6m4T60rf9Ca())) {
                                    byte b16 = -1;
                                    switch (strXtOheRiObl4QeAl7.hashCode()) {
                                        case 3496342:
                                            if (strXtOheRiObl4QeAl7.equals(aefYEAfbAHpZJTJAB5UQ9Y())) {
                                                b16 = 0;
                                            }
                                            break;
                                    }
                                    switch (b16) {
                                        case 0:
                                            if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                                arrayList7.add(VgjRGXxEZfkJbnDRIN());
                                            }
                                            break;
                                    }
                                }
                            } else {
                                byte b17 = -1;
                                switch (strXtOheRiObl4QeAl7.hashCode()) {
                                    case 3619493:
                                        if (strXtOheRiObl4QeAl7.equals(FQGCj2QCZtFHbCd5())) {
                                            b17 = 0;
                                        }
                                        break;
                                }
                                switch (b17) {
                                    case 0:
                                        if (this.v8qP8fE86HMhvNuYPFjqY.isUseGUI() && z) {
                                            arrayList7.add(vu7OlFUFNd7SKMqJL7IB());
                                        }
                                        break;
                                }
                            }
                        } else if (strXtOheRiObl4QeAl7.equals(GRSTbrMByjtFmqbB()) && !strArr[3].equalsIgnoreCase(bSgimrADWfi8pATZrb())) {
                            arrayList7.add(uTTp0snb2jIGOG());
                            arrayList7.add(hK0SnWyb7iZYgD());
                        }
                    }
                }
                return (List) arrayList7.stream().filter(str8 -> {
                    return str8.startsWith(strArr[4]);
                }).collect(Collectors.toList());
            }
        }
        return arrayList3;
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String lGm4dBD9zbESwgmJ(byte[] bArr) {
        return "";
    }

    private static String vX20KtVYOYvcgPAW() {
        return "Config.gui.suggestion_in_tabcomplete";
    }

    private static String lYdrQSwBWjnpHUIs4u() {
        return "-gui";
    }

    private static String aff1Gex8mUkRAMzLw() {
        return "info";
    }

    private static String CAggZXoKaTLkyL() {
        return "-gui";
    }

    private static String Y71MFz8LmHa3AaET3() {
        return "list";
    }

    private static String FsgNhW98ranp8IsX3s() {
        return "-gui";
    }

    private static String NSF8qJxemRGgKkelEzFhdl() {
        return "players";
    }

    private static String q8nIbfV6LaMOcR() {
        return "-gui";
    }

    private static String FRBNWbLzED6SVso() {
        return "nickname";
    }

    private static String cSEmBRXhHlFi4u2VUVnQMb() {
        return "-reset";
    }

    private static String A02nXmiV6aqdACqHvq16Tr() {
        return "invite";
    }

    private static String pk0I9ewCnzVEkFyTJ() {
        return "join";
    }

    private static String mNnpLbUrRQmz5ybl() {
        return "deny";
    }

    private static String p3VlI73iA2wbmdJnl() {
        return "promote";
    }

    private static String RjC92kvPs2TW9dMbk33ID() {
        return "demote";
    }

    private static String dDWmF47IjCPDHRxI() {
        return "ban";
    }

    private static String zCXfEDeenxPbFNISL3() {
        return "unban";
    }

    private static String cLFkjxUXVMtwkzgz() {
        return "changeleader";
    }

    private static String wgwCrVKSrlJmLcPnpOFYfP() {
        return "ally";
    }

    private static String tUhZ3JaYMy5e3DBCS() {
        return "list";
    }

    private static String CBk0IaXDq0ITtx92UnpmC() {
        return "add";
    }

    private static String MSOM7HSWRMuIBsAI5jdV() {
        return "remove";
    }

    private static String MXbNokFls1aWJ2z0l6K() {
        return "-gui";
    }

    private static String zdwCQmkDeeTWqLyaE6dhv() {
        return "rewards";
    }

    private static String au7eWyiOlaKSHo9HCNLgu() {
        return "collect";
    }

    private static String wTZNzMwJBt7xy2K2TZmNa() {
        return "list";
    }

    private static String mFqDR0d4E04rhDjagSTYA() {
        return "-gui";
    }

    private static String QqDdpEHvCgxuKPBuzYr() {
        return "-gui";
    }

    private static String jnX4alnaU5xZvRz4yRmjOI() {
        return "1";
    }

    private static String zl72XD0wm1qsgsW2iugl() {
        return "2";
    }

    private static String G0w0RoK6I0l6tMAJuBi() {
        return "language";
    }

    private static String PYYSEK7084yXfbTEwVPY() {
        return "set";
    }

    private static String bKl2mzEg0eTuEnDoHi() {
        return "list";
    }

    private static String MqyHHnk064KzP9C() {
        return "view";
    }

    private static String zdsqCisd9jMX41m82jYn() {
        return "-gui";
    }

    private static String EcpXRoXWiZGq7J4Y() {
        return "-gui";
    }

    private static String l7GZTfx7EyUdYmzWoodp() {
        return "level";
    }

    private static String xtMmFrdisBlCU5QV0() {
        return "-gui";
    }

    private static String m2SSNMnepxKodqAw2P() {
        return "logger";
    }

    private static String hO3P0wVPZ381uOloX4() {
        return "view";
    }

    private static String spXLHEa9PheNM4wRxCV() {
        return "-gui";
    }

    private static String sBGfDEConVl2cTyjLPlIfA() {
        return "mail";
    }

    private static String H0izXXirK2znfY7G() {
        return "read";
    }

    private static String PNsaTkU8FJhcBogvHm8O() {
        return "send";
    }

    private static String SeBzQEnnBSDqi70litGfS() {
        return "-gui";
    }

    private static String hBg4ZHIjMWRUEP() {
        return "me";
    }

    private static String NzV0y0GtsF3P8eSm4L() {
        return "allies..";
    }

    private static String oF0F0X4Jzhsu7sn3() {
        return "role";
    }

    private static String CsrA7vx9r4LdxUZkUAm() {
        return "view";
    }

    private static String wRo7GtKeq7KKQBfBWLnQy() {
        return "set";
    }

    private static String juoo3lkz1BV6vpG6Ab() {
        return "-gui";
    }

    private static String Yn3u4XJgPH78hJd() {
        return "banner";
    }

    private static String qg3opv4I51uYvPase2a() {
        return "view";
    }

    private static String Y5bCjtHRV3SO0X() {
        return "upload";
    }

    private static String IoNhGxjlUp9NWdF() {
        return "delete";
    }

    private static String IAzBIUr2mw8BwZe() {
        return "-gui";
    }

    private static String bl548h6QjeoL2z() {
        return "-gui";
    }

    private static String nF55yvHJWlkqhtn() {
        return "home";
    }

    private static String vxNmIvAA09oUiy() {
        return "view";
    }

    private static String lWESaIjCwzR7K8X() {
        return "teleport";
    }

    private static String bGQ055aPNiJkaocDh99e() {
        return "delete";
    }

    private static String CIXxXWad4HYe3HzrBrLsz() {
        return "create";
    }

    private static String cqFVyUZjsi2DNTwET() {
        return "list";
    }

    private static String WT4Euo6Aye4J08BCn7w() {
        return "-gui";
    }

    private static String CkJYJ7NFvyN6iCSv() {
        return "Home.public";
    }

    private static String j5p1iZjG8kHBlrJDarhg() {
        return "member";
    }

    private static String GMh785F6c976D6WG8Me6A() {
        return "search";
    }

    private static String VzB4IDOPM7mfpy3Ta() {
        return "kick";
    }

    private static String GUqYR1K3DEPfPyr6KTg() {
        return "invite";
    }

    private static String TogKLYPe8Jz0ZvezM7() {
        return "list";
    }

    private static String ViOK74ao5MDIz8() {
        return "-gui";
    }

    private static String aWMrCvVI292C6s() {
        return "profile";
    }

    private static String i6jwjRcgUhyM36f() {
        return "view";
    }

    private static String l3wFinLkrBalKHBqeOHwQ() {
        return "permissions";
    }

    private static String cMdbNTuS305H7AFw() {
        return "set";
    }

    private static String UGUBSWE2pcbBHnZKZmQFMO() {
        return "invites";
    }

    private static String gDdxnzsL1yRilwTZ() {
        return "updateskin";
    }

    private static String EtGxEf4n6v8zqpFwZQ() {
        return "-gui";
    }

    private static String KhCth8ahdFLBHVBLjIWC() {
        return "-gui";
    }

    private static String sX2lUtpR0isks2AaP1QVUd() {
        return "regroup";
    }

    private static String VNN0l86ci3ssgHWH() {
        return "deny";
    }

    private static String RaVAK9qJEbtYAO() {
        return "send";
    }

    private static String zjzIbLuQfwFHPP() {
        return "accept";
    }

    private static String mI85WyCjPDOoZqbYIrJ() {
        return "rival";
    }

    private static String KiR0vwmhx4HVtIDPsyb2O() {
        return "list";
    }

    private static String ObN95dlXLcYuoLr() {
        return "add";
    }

    private static String wHkbO9IyYDoU7oczrW6Q() {
        return "remove";
    }

    private static String tx7EIMQbtK45lMQwkyjHg() {
        return "deny";
    }

    private static String Okww3tcsNomaWtpc() {
        return "accept";
    }

    private static String hqcRuyL7oaW53HNN() {
        return "-gui";
    }

    private static String AdaprTPZ4zeiopZWL4I2() {
        return "settings";
    }

    private static String PxJbRFy0bN9ip1y7c8t() {
        return "view";
    }

    private static String GHQc9fGFUgNGW7() {
        return "set";
    }

    private static String nBfWKolNaEymZVkMYFHU() {
        return "banned";
    }

    private static String GpygNZz9cGaZM07Q() {
        return "-gui";
    }

    private static String jubLfcLZE7rasAX2NQpJ() {
        return "-gui";
    }

    private static String P7AV6b3kkKYf1TonQov() {
        return "-gui";
    }

    private static String EPgzmjWay1MNs2() {
        return "info";
    }

    private static String WCf5J3zc75poiCaY83() {
        return "-gui";
    }

    private static String onSvFUuO1EA70EF7Zerfm() {
        return "-gui";
    }

    private static String xv0AUB2xZeWVRnfcT() {
        return "promote";
    }

    private static String mpweld8uCYQia2P() {
        return "demote";
    }

    private static String kYdWrMo7wVJyfZvy7k() {
        return "list";
    }

    private static String SEvw9LDrCt5kM0m() {
        return "-gui";
    }

    private static String T5YXBloPU9s8GCZk0sE5Su() {
        return "-gui";
    }

    private static String TPknhO6AxvQFmROCfRX() {
        return "ally";
    }

    private static String Pa0ld5UlNij7eHzDAO() {
        return "list";
    }

    private static String QN2XvmK1NY1PbCPKfqeM9i() {
        return "-gui";
    }

    private static String gk1CzNVvQT0lY0k() {
        return "role";
    }

    private static String FT38F6H2jxfVRBy2SB2R() {
        return "set";
    }

    private static String y6w4upobPLWKRT2yAP0xXF() {
        return "-gui";
    }

    private static String MmCQqhVEgvsDrLV() {
        return "logger";
    }

    private static String A27m3pPtZhYaVo85zlK2PU() {
        return "view";
    }

    private static String U6k02tb6As2veKsD() {
        return "-gui";
    }

    private static String rVTxffN3xC0EJBk8mRmlA() {
        return "mail";
    }

    private static String eG6BoBGKsWtEGuMt() {
        return "read";
    }

    private static String UqRiLLw03FkuLgtz6mTT() {
        return "-gui";
    }

    private static String ihKgeZuxBfsFI1ZwfUr2() {
        return "rival";
    }

    private static String nIoILbAxLV2LvMr() {
        return "list";
    }

    private static String lFIPTJ543EjIzqxoZZ2() {
        return "-gui";
    }

    private static String kqJbX2BdMPOSShtAM() {
        return "home";
    }

    private static String h0Yz4eCZ0bkRTe7SxFAq() {
        return "list";
    }

    private static String fQhBblSkFkJPp2Tg() {
        return "-gui";
    }

    private static String NJnbn9Tgo6imXKSb6fCkM() {
        return "member";
    }

    private static String gVnusS9UOLarnBP8uNYhD() {
        return "list";
    }

    private static String n87c7kUUf38s0TN() {
        return "-gui";
    }

    private static String v2CMBzsIENWdp6c() {
        return "search";
    }

    private static String riieATMyNLQa4gYbVGeb() {
        return "-gui";
    }

    private static String E26126dH42ZuYwPZgLec() {
        return "profile";
    }

    private static String ruezNo6xZ957Vl() {
        return "view";
    }

    private static String kCFbT0xSaaoh7KyT6oClw() {
        return "permissions";
    }

    private static String oZvQX9rowQ7zFl4HuK() {
        return "-gui";
    }

    private static String DzTMyHLZcJgwt7PSja0I4h() {
        return "set";
    }

    private static String exAkaomqoiG7908DE1R() {
        return "settings";
    }

    private static String bfCJUtKUyzy4Spo4() {
        return "set";
    }

    private static String x1zKmYp5uO16jJVzYN4z() {
        return "list";
    }

    private static String fmmtP9HagFvaxOGcv() {
        return "role";
    }

    private static String GRSTbrMByjtFmqbB() {
        return "set";
    }

    private static String bSgimrADWfi8pATZrb() {
        return "-gui";
    }

    private static String uTTp0snb2jIGOG() {
        return "true";
    }

    private static String hK0SnWyb7iZYgD() {
        return "false";
    }

    private static String i2w7dgBaSMQYpW0RXQ() {
        return "logger";
    }

    private static String FQGCj2QCZtFHbCd5() {
        return "view";
    }

    private static String vu7OlFUFNd7SKMqJL7IB() {
        return "-gui";
    }

    private static String O6UO6m4T60rf9Ca() {
        return "mail";
    }

    private static String aefYEAfbAHpZJTJAB5UQ9Y() {
        return "read";
    }

    private static String VgjRGXxEZfkJbnDRIN() {
        return "-gui";
    }

    private static String NpZT16zifoW7wP() {
        return "1";
    }

    private static String en05BqSjPYQyD8KNqe() {
        return "1";
    }

    private static String SSbLtEmOWQs8Vpb() {
        return "promote";
    }
}
