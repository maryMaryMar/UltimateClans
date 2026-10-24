package me.ulrich.clans.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.interfaces.MoneyImplement;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.Formatter;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.FormatNumber;
import me.ulrich.clans.manager.utils.MessageUtils;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/jBWyXxi9EyWxcPiz.class */
public class jBWyXxi9EyWxcPiz {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private final File jBUuLP0sWwaPyPOmogdX7l;
    private static String PE6Mjn689Q5YnB;
    private static String KslfgxQuh34Ur1yW1B;
    private static volatile String MU5iwwGB1HCm4l0a;
    private static volatile String XR3ZTTBohSqMuqvmSg;
    private static volatile String RGu5Cd7MXAMdnQHkbmiDCB;
    private static volatile String Z624qfXu828ZaQ;
    private static String Pm8X7esTDJRJMccmRZ1jhI;
    private static volatile String iaCZX2Dklp9rMK7xaplKUg;
    private static String T15hWcx0QBvsiWWQ2bf;
    private static volatile String BFJ0G5EFEb5ioT;
    private static String tH1g9UY3VjhYBYdHx;
    private static volatile String xBdzuiqGrwpGBCUTv;
    private static volatile String atTE1xBV76ocjoFIFM;
    private static volatile String rqg2abPqMTDO5GQaHeS;
    private static volatile String NnJpHKbNqlNAOOYzo;
    private static String O1ulQpTjkavybWzDqgAI;
    private static String fC2RpRYQOzHM6Ad1x;
    private static volatile String ecx0gMNdXVobpHRB5BJYP;
    private static String xgpGDaXeN1tqDaX4;
    private static String D658izgiPJmhhIwDV51WO4;
    private static volatile String fzhujKJI1YsA1RrstT13Y;
    private static volatile String syzJtPwXbXWotMl;
    private static volatile String SipRsPZ3je4N7mk;
    private static String QHKJZpfPRC78Hw;
    private static volatile String shAAEZnAfNyNkE6C;
    private static String E3KUsqxPMUmqGXPz;
    private static String U6hOikAOxp5hzcndTZKyI;
    private static String VyzssYJbsE9XcY0gUnGpl;
    private static volatile String yIuXKyC9SlSlKX3;
    private static volatile String AzoZeZnHTPGUJtgYcfF5w;
    private static volatile String t3W1zvQPsS1Qo7lVInEx;
    private static String IM8VNiDI2WhUYSD;
    private static volatile String D6vgQREm2lq8q9Qmzlj9M;
    private static String OmC6r3OxKADBlTZNTI;
    private static volatile String sgFGvKHDjwtAiiVt;
    private static volatile String IznvMYIg0B6Psp;
    private static String vAvdfFR8kjwkI3CO8;
    private static volatile String g9uc2F79hdzIPaOhc0;
    private static volatile String IAVbbNvMrbDvird4MzY;
    private static String xdGFvTIMBH4qjOSlGN;
    private static String g6AUFx81muM9wQ67pVVHgA;
    private static String bfz4wdNdIpIsZVq;
    private static String Zb6OSQct3f5wx73Rv;
    private static volatile String kDGBVjSkAfXwkLGOuL9VUS;
    private static String gWmtDmpOvuzn85bLn;
    private static volatile String uU1pV1GKT7NbEs;
    private static volatile String kwbNzdXYLHssIUnot;
    private static String IcsXVfXGUd6UwCk;
    private static volatile String WBlgA4jxXsjxazG2EBHaab;
    private static volatile String knnJSVUN7T3xqoi2;
    private static String z45VnGBEj7rr8QygM;
    private static String liHhg8kqZut0cji8My59Y;
    private static String zQTpl0jIWvIlBF2;
    private static volatile String bgiC7yB9FHZFUZpSLkFK9;
    private static String t8WWT1IRuk3hUm;
    private static volatile String WuqkU1l5gCwNC9uXs0Kn;
    private static volatile String wE5nV67lnGPwAQFdvvg;
    private static String ymFHaZ7Mq9XortUqp;
    private static volatile String lhtIjahKehUb32nOKd;
    private static volatile String fP96VYGl2JOlKUKs6;
    private static volatile String dYGC31t74TTDW7vhBa;
    private static String byc4FpvPRbtDqy1YD0B;
    private static volatile String ld4G4JHQo7D51z3nzVW;
    private static volatile String X9pB6nJqtJyBZzOUF;
    private static String otofSHNmOjFQdT;
    private static volatile String C8GUYaEUl9WaMmBC;
    private static volatile String LEBMxs8iEx7AnbV1WM8sV;
    private static String X351an1lvXlcrl;
    private static volatile String HJsWat8N2BOez4bXMj;
    private static String VuLK9s7ahZZi14222NQ1B;
    private static volatile String vP5CDr1ID09c1dD;
    private static String j7efEhpCl4s6RI;
    private static String lBjn70LSV4yTRXvCROL94Z;
    private static String g2opKX9RnxPs2qPkbO15yi;
    private static String yiCteaQ43lmgciEb;
    private static String Qa4ArwRMIiT99cpMATH8Mb;
    private static String EFRZSKUGrTem9Oydcf;
    private static volatile String zDu2CPjh8EA6bjzzFYXW35;
    private static String NtPQXszoI7ituR39l;
    private static volatile String oqZEbweGhl9uo2nvDgMJq;
    private static String o8ZfBsPM8RtuyeexzyB;
    private static volatile String igad2MFIBiOwGe;
    private static String ENdZF5YTkNIy45Pwz;
    private static String fABEATDTAKzOIUj;
    private static volatile String bOcXrS04AnDxYk5ed5;
    private static final byte[] U0PJYNh9f5iuSHP4Id = {(byte) 169, (byte) 53, (byte) 64, (byte) 215, (byte) 123, (byte) 196, (byte) 118, (byte) 13, (byte) 66, (byte) 147, (byte) 209, (byte) 132, (byte) 54, (byte) 247, (byte) 133, (byte) 151, (byte) 14, (byte) 129, (byte) 33, (byte) 104, (byte) 215, (byte) 18, (byte) 192, (byte) 166, (byte) 78, (byte) 26, (byte) 82, (byte) 31, (byte) 170, (byte) 100, (byte) 160, (byte) 162, (byte) 174, (byte) 204, (byte) 190, (byte) 100, (byte) 129, (byte) 243, (byte) 181, (byte) 255, (byte) 151, (byte) 25, (byte) 89, (byte) 113, (byte) 218, (byte) 108, (byte) 184, (byte) 165};
    private static final byte[] sP7qPVCRDkWkiQOsL0 = {(byte) 135, (byte) 6, (byte) 98, (byte) 67, (byte) 167, (byte) 83, (byte) 111, (byte) 147, (byte) 135, (byte) 217, (byte) 128, (byte) 100, (byte) 9, (byte) 211, (byte) 239, (byte) 45};
    private static final byte[] jVVOAGjr0ZpseaOp3vjSqG = {(byte) 86, (byte) 179, (byte) 112, (byte) 237, (byte) 130, (byte) 41, (byte) 105, (byte) 91, (byte) 107, (byte) 131, (byte) 125, (byte) 122, (byte) 254, (byte) 100, (byte) 180, (byte) 222, (byte) 232, (byte) 23, (byte) 135, (byte) 117, (byte) 36, (byte) 189, (byte) 151, (byte) 18, (byte) 157, (byte) 38, (byte) 211, (byte) 101, (byte) 164, (byte) 55, (byte) 216, (byte) 187};
    private static final byte[] VTWKG3nwXKgGu22V = {(byte) 90, (byte) 178, (byte) 163, (byte) 155, (byte) 7, (byte) 17, (byte) 7, (byte) 38, (byte) 63, (byte) 195, (byte) 240, (byte) 175, (byte) 222, (byte) 96, (byte) 247, (byte) 174, (byte) 200, (byte) 137, (byte) 95, (byte) 4, (byte) 64, (byte) 183, (byte) 62, (byte) 201, (byte) 207, (byte) 18, (byte) 112, (byte) 189, (byte) 220, (byte) 47, (byte) 100, (byte) 4};
    private static final byte[] gFTYvgapYeDLIdv = {(byte) 37, (byte) 195, (byte) 0, (byte) 16, (byte) 82, (byte) 231, (byte) 18, (byte) 43, (byte) 90, (byte) 170, (byte) 168, (byte) 69, (byte) 15, (byte) 29, (byte) 103, (byte) 77, (byte) 245, (byte) 35, (byte) 141, (byte) 28, (byte) 202, (byte) 123, (byte) 13, (byte) 93, (byte) 252, (byte) 131, (byte) 49, (byte) 253, (byte) 125, (byte) 193, (byte) 220, (byte) 139};
    private static final byte[] Wf0uRhaBYVswLpn = {(byte) 37, (byte) 195, (byte) 0, (byte) 16, (byte) 82, (byte) 231, (byte) 18, (byte) 43, (byte) 90, (byte) 170, (byte) 168, (byte) 69, (byte) 15, (byte) 29, (byte) 103, (byte) 77, (byte) 245, (byte) 35, (byte) 141, (byte) 28, (byte) 202, (byte) 123, (byte) 13, (byte) 93, (byte) 252, (byte) 131, (byte) 49, (byte) 253, (byte) 125, (byte) 193, (byte) 220, (byte) 139};
    private static final byte[] pO2yuzz0BbVIMFuxb = {(byte) 37, (byte) 195, (byte) 0, (byte) 16, (byte) 82, (byte) 231, (byte) 18, (byte) 43, (byte) 90, (byte) 170, (byte) 168, (byte) 69, (byte) 15, (byte) 29, (byte) 103, (byte) 77, (byte) 245, (byte) 35, (byte) 141, (byte) 28, (byte) 202, (byte) 123, (byte) 13, (byte) 93, (byte) 252, (byte) 131, (byte) 49, (byte) 253, (byte) 125, (byte) 193, (byte) 220, (byte) 139};
    private static final byte[] KuoskPiFUx9UWifj = {(byte) 138, (byte) 83, (byte) 128, (byte) 39, (byte) 82, (byte) 204, (byte) 177, (byte) 141, (byte) 180, (byte) 148, (byte) 61, (byte) 70, (byte) 106, (byte) 217, (byte) 112, (byte) 217, (byte) 4, (byte) 201, (byte) 114, (byte) 67, (byte) 84, (byte) 99, (byte) 128, (byte) 69, (byte) 124, (byte) 125, (byte) 148, (byte) 165, (byte) 250, (byte) 218, (byte) 51, (byte) 60};
    private static final byte[] mgnnEGMAM533nWONxc = {(byte) 58, (byte) 84, (byte) 55, (byte) 141, (byte) 251, (byte) 197, (byte) 45, (byte) 129, (byte) 152, (byte) 92, (byte) 190, (byte) 154, (byte) 91, (byte) 194, (byte) 124, (byte) 50, (byte) 166, (byte) 110, (byte) 143, (byte) 82, (byte) 174, (byte) 192, (byte) 233, (byte) 15, (byte) 199, (byte) 77, (byte) 238, (byte) 69, (byte) 118, (byte) 247, (byte) 120, (byte) 176};
    private static final byte[] XPcLEhFcX2HDiFoGZC = {(byte) 60, (byte) 205, (byte) 106, (byte) 85, (byte) 158, (byte) 12, (byte) 230, (byte) 1, (byte) 22, (byte) 106, (byte) 162, (byte) 217, (byte) 204, (byte) 111, (byte) 142, (byte) 252, (byte) 209, (byte) 131, (byte) 29, (byte) 139, (byte) 132, (byte) 92, (byte) 13, (byte) 176, (byte) 85, (byte) 65, (byte) 226, (byte) 173, (byte) 6, (byte) 107, (byte) 121, (byte) 241, (byte) 57, (byte) 144, (byte) 239, (byte) 6, (byte) 244, (byte) 187, (byte) 92, (byte) 26, (byte) 208, (byte) 151, (byte) 147, (byte) 35, (byte) 0, (byte) 41, (byte) 45, (byte) 115};
    private static final byte[] h2dq9UURCs5Cc7GShA = {(byte) 221, (byte) 60, (byte) 184, (byte) 15, (byte) 169, (byte) 109, (byte) 106, (byte) 74, (byte) 6, (byte) 213, (byte) 121, (byte) 143, (byte) 152, (byte) 172, (byte) 215, (byte) 252};
    private static final byte[] CXdIwz9ofwUZGdKJNA = {(byte) 196, (byte) 125, (byte) 165, (byte) 11, (byte) 25, (byte) 116, (byte) 171, (byte) 79, (byte) 187, (byte) 97, (byte) 89, (byte) 167, (byte) 253, (byte) 102, (byte) 64, (byte) 67, (byte) 137, (byte) 75, (byte) 35, (byte) 31, (byte) 47, (byte) 216, (byte) 23, (byte) 154, (byte) 211, (byte) 59, (byte) 29, (byte) 37, (byte) 215, (byte) 203, (byte) 107, (byte) 125, (byte) 212, (byte) 35, (byte) 33, (byte) 154, (byte) 200, (byte) 106, (byte) 237, (byte) 87, (byte) 74, (byte) 236, (byte) 97, (byte) 207, (byte) 124, (byte) 224, (byte) 210, (byte) 75, (byte) 206, (byte) 178, (byte) 167, (byte) 118, (byte) 85, (byte) 34, (byte) 154, (byte) 131, (byte) 244, (byte) 37, (byte) 19, (byte) 43, (byte) 154, (byte) 55, (byte) 94, (byte) 22};
    private static final byte[] ngw91Vsi5ScXQfSYPVy = {(byte) 26, (byte) 42, (byte) 87, (byte) 83, (byte) 5, (byte) 130, (byte) 231, (byte) 76, (byte) 140, (byte) 110, (byte) 222, (byte) 51, (byte) 227, (byte) 32, (byte) 80, (byte) 172};
    private static final byte[] ur0Q4M7v8EsNMj = {(byte) 109, (byte) 149, (byte) 34, (byte) 105, (byte) 114, (byte) 143, (byte) 215, (byte) 241, (byte) 165, (byte) 83, (byte) 192, (byte) 247, (byte) 232, (byte) 70, (byte) 6, (byte) 248};
    private static final byte[] IENcbCd1VB4NbDmM = {(byte) 41, (byte) 28, (byte) 111, (byte) 213, (byte) 107, (byte) 64, (byte) 161, (byte) 212, (byte) 41, (byte) 110, (byte) 103, (byte) 25, (byte) 157, (byte) 96, (byte) 93, (byte) 203};
    private static final byte[] iJ6QYmoy75Lkm5jKM3n7Be = {(byte) 58, (byte) 196, (byte) 129, (byte) 103, (byte) 223, (byte) 138, (byte) 54, (byte) 230, (byte) 178, (byte) 135, (byte) 110, (byte) 98, (byte) 28, (byte) 140, (byte) 74, (byte) 200};
    private static final byte[] KODh3vcSgb8n7RJB = {(byte) 31, (byte) 125, (byte) 197, (byte) 182, (byte) 156, (byte) 99, (byte) 90, (byte) 233, (byte) 254, (byte) 181, (byte) 223, (byte) 25, (byte) 11, (byte) 228, (byte) 152, (byte) 34};
    private static final byte[] kp1VAoNtFj8Zd3vTN = {(byte) 113, (byte) 51, (byte) 74, (byte) 74, (byte) 121, (byte) 91, (byte) 184, (byte) 235, (byte) 44, (byte) 208, (byte) 72, (byte) 59, (byte) 118, (byte) 116, (byte) 193, (byte) 163};
    private static final byte[] m9qLgJzHGI5Nim = {(byte) 121, (byte) 29, (byte) 31, (byte) 14, (byte) 22, (byte) 48, (byte) 8, (byte) 88, (byte) 219, (byte) 31, (byte) 166, (byte) 150, (byte) 223, (byte) 48, (byte) 22, (byte) 0};
    private static final byte[] hApET3KHxctBY5W = {(byte) 233, (byte) 224, (byte) 147, (byte) 10, (byte) 56, (byte) 227, (byte) 88, (byte) 70, (byte) 30, (byte) 61, (byte) 106, (byte) 81, (byte) 211, (byte) 170, (byte) 15, (byte) 211};
    private static final byte[] yTXDcedG6X5smIM = {(byte) 169, (byte) 144, (byte) 128, (byte) 109, (byte) 42, (byte) 32, (byte) 114, (byte) 19, (byte) 13, (byte) 153, (byte) 250, (byte) 103, (byte) 27, (byte) 162, (byte) 168, (byte) 80};
    private static final byte[] GDLr7CleWDepuiWo = {(byte) 87, (byte) 32, (byte) 136, (byte) 162, (byte) 54, (byte) 193, (byte) 74, (byte) 92, (byte) 54, (byte) 227, (byte) 10, (byte) 204, (byte) 190, (byte) 23, (byte) 1, (byte) 79};
    private static final byte[] YekdmHgFnWyRH9Cjm = {(byte) 26, (byte) 42, (byte) 87, (byte) 83, (byte) 5, (byte) 130, (byte) 231, (byte) 76, (byte) 140, (byte) 110, (byte) 222, (byte) 51, (byte) 227, (byte) 32, (byte) 80, (byte) 172};
    private static final byte[] AMUv3uJjNdqFbgcYfq = {(byte) 234, (byte) 122, (byte) 152, (byte) 223, (byte) 158, (byte) 195, (byte) 51, (byte) 219, (byte) 120, (byte) 210, (byte) 156, (byte) 198, (byte) 81, (byte) 111, (byte) 121, (byte) 139};
    private static final byte[] XP9ERitmRIBkQBh = {(byte) 250, (byte) 140, (byte) 55, (byte) 218, (byte) 207, (byte) 143, (byte) 14, (byte) 46, (byte) 110, (byte) 168, (byte) 95, (byte) 178, (byte) 148, (byte) 226, (byte) 46, (byte) 102};
    private static final byte[] yfQZl1kcJQJy2nnwG45RY = {(byte) 160, (byte) 144, (byte) 146, (byte) 52, (byte) 10, (byte) 157, (byte) 56, (byte) 75, (byte) 79, (byte) 130, (byte) 17, (byte) 103, (byte) 57, (byte) 61, (byte) 191, (byte) 248};
    private static final byte[] eZpfg7cfDiD8vM8vTYB = {(byte) 106, (byte) 35, (byte) 193, (byte) 94, (byte) 244, (byte) 128, (byte) 201, (byte) 127, (byte) 65, (byte) 99, (byte) 50, (byte) 250, (byte) 97, (byte) 229, (byte) 157, (byte) 9};
    private static final byte[] mCbp6KpgwSispeQ = {(byte) 52, (byte) 144, (byte) 225, (byte) 80, (byte) 26, (byte) 14, (byte) 182, (byte) 253, (byte) 145, (byte) 255, (byte) 165, (byte) 206, (byte) 49, (byte) 155, (byte) 237, (byte) 233, (byte) 81, (byte) 82, (byte) 133, (byte) 189, (byte) 108, (byte) 120, (byte) 23, (byte) 235, (byte) 205, (byte) 173, (byte) 51, (byte) 167, (byte) 23, (byte) 91, (byte) 89, (byte) 196};
    private static final byte[] uJ6eF5g7nX7fDw7A3NSPg = {(byte) 31, (byte) 157, (byte) 38, (byte) 181, (byte) 117, (byte) 87, (byte) 237, (byte) 16, (byte) 235, (byte) 113, (byte) 61, (byte) 91, (byte) 175, (byte) 193, (byte) 187, (byte) 182, (byte) 60, (byte) 71, (byte) 179, (byte) 206, (byte) 235, (byte) 255, (byte) 76, (byte) 167, (byte) 245, (byte) 114, (byte) 147, (byte) 84, (byte) 173, (byte) 67, (byte) 64, (byte) 76};
    private static final byte[] qrOb3YASQREZuQF0rsnQ9 = {(byte) 47, (byte) 70, (byte) 148, (byte) 75, (byte) 123, (byte) 211, (byte) 120, (byte) 244, (byte) 202, (byte) 120, (byte) 16, (byte) 253, (byte) 136, (byte) 159, (byte) 160, (byte) 0};
    private static final byte[] hHhoRndPZBJKYLPy5 = {(byte) 203, (byte) 182, (byte) 119, (byte) 125, (byte) 99, (byte) 167, (byte) 2, (byte) 190, (byte) 75, (byte) 146, (byte) 223, (byte) 192, (byte) 222, (byte) 19, (byte) 217, (byte) 39};
    private static final byte[] FX1hNGlKiOdnuTBbu = {(byte) 10, (byte) 50, (byte) 69, (byte) 216, (byte) 49, (byte) 6, (byte) 186, (byte) 83, (byte) 183, (byte) 61, (byte) 147, (byte) 246, (byte) 188, (byte) 189, (byte) 3, (byte) 65, (byte) 43, (byte) 173, (byte) 76, (byte) 107, (byte) 34, (byte) 62, (byte) 39, (byte) 32, (byte) 32, (byte) 227, (byte) 18, (byte) 237, (byte) 37, (byte) 78, (byte) 200, (byte) 96, (byte) 220, (byte) 194, (byte) 243, (byte) 188, (byte) 197, (byte) 204, (byte) 31, (byte) 53, (byte) 146, (byte) 174, (byte) 58, (byte) 234, (byte) 36, (byte) 112, (byte) 33, (byte) 214};

    public jBWyXxi9EyWxcPiz(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.jBUuLP0sWwaPyPOmogdX7l = new File(clans.getDataFolder(), Vt9fMjlHgV5KMZjPEJK());
        if (this.jBUuLP0sWwaPyPOmogdX7l.exists()) {
            return;
        }
        this.jBUuLP0sWwaPyPOmogdX7l.mkdirs();
    }

    public static String v8qP8fE86HMhvNuYPFjqY() {
        return "632059";
    }

    public String v8qP8fE86HMhvNuYPFjqY(List<String> list) {
        String string = "";
        int i = 1;
        if (list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String str = string + it.next();
                string = i >= list.size() ? str + "." : str + ", ";
                i++;
            }
        } else {
            string = ZwrsrwOCXRUscW6Q().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.NOTHING_HERE);
        }
        return string;
    }

    public String v8qP8fE86HMhvNuYPFjqY(long j) {
        return String.valueOf(Duration.between(Instant.ofEpochMilli(j * 1000), Instant.now()).toHours());
    }

    public String jBUuLP0sWwaPyPOmogdX7l(long j) {
        int days = (int) TimeUnit.SECONDS.toDays(j);
        long hours = TimeUnit.SECONDS.toHours(j) - ((long) (days * 24));
        long minutes = TimeUnit.SECONDS.toMinutes(j) - (TimeUnit.SECONDS.toHours(j) * 60);
        long seconds = TimeUnit.SECONDS.toSeconds(j) - (TimeUnit.SECONDS.toMinutes(j) * 60);
        StringBuilder sb = new StringBuilder();
        if (days > 0) {
            if (days >= 7) {
                return LQyMZfJaa35xkAXoey();
            }
            sb.append(String.format(f4dCIrztSHt5kl1onB9yL(), Integer.valueOf(days)) + "d ");
        }
        if (hours > 0) {
            sb.append(String.format(KCAm4RHeZAE1eUXCjL(), Long.valueOf(hours)) + ":");
        }
        return sb.toString() + String.format(WqXcm6RMojO7ril9GcpCav(), Long.valueOf(minutes)) + ":" + String.format(vD0uPlrsC4CKMrdl3DWTG(), Long.valueOf(seconds));
    }

    public Map.Entry<Extension, Boolean> v8qP8fE86HMhvNuYPFjqY(String str) {
        try {
            for (Map.Entry<Extension, Boolean> entry : ZwrsrwOCXRUscW6Q().getExtensionEnabledList().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(str)) {
                    return entry;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(String str) {
        try {
            for (Map.Entry<Extension, Boolean> entry : ZwrsrwOCXRUscW6Q().getExtensionEnabledList().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(str) && entry.getValue().booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean ZwrsrwOCXRUscW6Q(String str) {
        try {
            Iterator<Map.Entry<Extension, Boolean>> it = ZwrsrwOCXRUscW6Q().getExtensionEnabledList().entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().getName().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Map.Entry<Module, Boolean> iZTqZaRK5UGoe0Z(String str) {
        try {
            for (Map.Entry<Module, Boolean> entry : ZwrsrwOCXRUscW6Q().getModuleEnabledList().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(str)) {
                    return entry;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean xtOheRiObl4QeAl(String str) {
        try {
            for (Map.Entry<Module, Boolean> entry : ZwrsrwOCXRUscW6Q().getModuleEnabledList().entrySet()) {
                if (entry.getKey().getName().equalsIgnoreCase(str) && entry.getValue().booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean zJnaNCVQSgEShq(String str) {
        try {
            Iterator<Map.Entry<Module, Boolean>> it = ZwrsrwOCXRUscW6Q().getModuleEnabledList().entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().getName().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l() {
        try {
            if (!ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getBoolean(vNR82ZxYJGVqOyWet2())) {
                return true;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(py3PS8VaLbKkVM()).openConnection();
            httpURLConnection.setRequestMethod(xc1blyl8lOJW8DaGY5g4zV());
            httpURLConnection.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line.trim());
            }
            bufferedReader.close();
            httpURLConnection.disconnect();
            JSONObject jSONObject = new JSONObject(stringBuffer.toString());
            return jSONObject != null && jSONObject.has(xuZmDcMiTPrAQi9Af()) && jSONObject.getString(c6Ipsk6nxw0q0ftTYZTh()).equals(xLBnIIIsYbejtb87k());
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e2) {
            return false;
        } catch (IllegalStateException e3) {
            return false;
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        v8qP8fE86HMhvNuYPFjqY(List.of(str), str2);
    }

    public void v8qP8fE86HMhvNuYPFjqY(List<String> list, String str) {
        if (this.v8qP8fE86HMhvNuYPFjqY.getFiles() == null || this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K() == null) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Attempt to log (" + str + "): " + String.valueOf(list));
            return;
        }
        String str2 = new SimpleDateFormat(this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(rY4EpzWJXQPPOuMGy7wX())).format(new Date());
        File file = new File(this.jBUuLP0sWwaPyPOmogdX7l, str + ".log");
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        bufferedWriter.write("[" + str2 + "] " + ((String) it.next()));
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Failed to write log: " + e.getMessage());
            }
        });
    }

    public void jBUuLP0sWwaPyPOmogdX7l(String str, String str2) {
        File file = new File(this.jBUuLP0sWwaPyPOmogdX7l, str2 + ".log");
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.close();
                } catch (Throwable th) {
                    try {
                        bufferedWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning("Failed to write pure log: " + e.getMessage());
            }
        });
    }

    public String v8qP8fE86HMhvNuYPFjqY(String str, List<String> list) {
        if (list != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(PI3ioCCkcd6H66());
                    str = str.replace(strArrSplit[0], strArrSplit[1]);
                }
                return str;
            } catch (Exception e) {
            }
        }
        return str;
    }

    public String CDW4Fj1iwdIXEOqWjiJSR(String str) {
        return str.replaceAll(xMn3nU4htw6Ri3X0J4dd(), fZApsYHBHbXnmtN6n()).replaceAll(ijxflIBKCO3Icq(), YXpNXI2JD4FoqipU()).replaceAll(pEqqtTti1kM31GU47(), DTSU0E5hsiWlbmZR1c()).replaceAll(CsVEqTni8dqo2X5(), adWd1SoCQ3luq8JKu()).replaceAll(oXSc0lO7iybTEwqevRr5(), WaZmvLdNa2wbAeWWEE3LlF()).replaceAll(h24mt0upi9sO50oTJ(), YnHOzmLmRM3jLK94X()).replaceAll(rhHYfZZwIx5SF2dyESl(), NiYwBh8MQJPVJhcqhCbAgP()).replaceAll(UHrtwNsnPhgIrsH(), MrP1ylHdeuTJ49Jq()).replaceAll(s3BMGtVE9JAVvPuNrYL(), zqA6abXXyd8140O8e2R3NB()).replaceAll(J57OdJI46jHsJA1(), rPUbYTHHyMIUfzigy());
    }

    public String b4i2FbOkaKeg91LiAe6l(String str) {
        return str.replaceAll(s6cirvpMRVRA3sKjMPJZUD(), la0Tf1I3J2eEx93ok7z5()).replaceAll(ewgMfu0oJzoXc2vJgJJw(), eYgsGeLe4JMYulI9s()).replaceAll(PJXwLsVE515PmOM(), Cag7Vxjyr2cuSejkdcv()).replaceAll(xtn71eusAP2khFhGfQ1Q(), KtXV0xNO1HBSpcSrzCHG()).replaceAll(XHyIwYoFuwN5seFdbNH(), kaIVJb7HpAoAUzUXv0eyk()).replaceAll(BIeN4JMkppOzVHnDK6TH(), KupYVU2eCPDdR33U()).replaceAll(obTRUtfTp3kRbxAt(), PznOv7n6ImHAyBqjbPm()).replaceAll(sD9GtAL3Aysnh2GdHgcqm(), XjA47Nb5uUttWVWIHC9()).replaceAll(CYuuiDAIWPC0IlaArDu(), XtA0Z8X3FDBMIDAaf4Bs()).replaceAll(eezhs0v0nNHo6CuZ4zcyK(), WIslfw8iR0XW3S());
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender, String str, String str2) {
        try {
            if (!(commandSender instanceof Player)) {
                return true;
            }
            Player player = (Player) commandSender;
            if (!ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(PIgN9DhrzfChm3()).isEmpty() && player.hasPermission(ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(JLiRZm3XbAiWa1Mg7B()))) {
                return true;
            }
            ConcurrentHashMap<String, CommandData> concurrentHashMapIZTqZaRK5UGoe0Z = null;
            String strXtOheRiObl4QeAl = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(str2);
            if (str.equalsIgnoreCase(OXainyc9ICwqNeYAiCH())) {
                concurrentHashMapIZTqZaRK5UGoe0Z = ZwrsrwOCXRUscW6Q().getCommandManager().ZwrsrwOCXRUscW6Q();
            } else if (str.equalsIgnoreCase(Yrvtqn0nmA0TOPq0KOFeCI())) {
                concurrentHashMapIZTqZaRK5UGoe0Z = ZwrsrwOCXRUscW6Q().getCommandManager().iZTqZaRK5UGoe0Z();
            }
            if (concurrentHashMapIZTqZaRK5UGoe0Z == null || !concurrentHashMapIZTqZaRK5UGoe0Z.containsKey(strXtOheRiObl4QeAl)) {
                return true;
            }
            CommandData commandData = concurrentHashMapIZTqZaRK5UGoe0Z.get(strXtOheRiObl4QeAl);
            if (commandData.getCooldown() <= 0) {
                return true;
            }
            if (CooldownAPI.isInCooldown(player.getUniqueId(), strXtOheRiObl4QeAl + str + ".cmd_cooldown")) {
                MessageUtils.sendText(commandSender, ZwrsrwOCXRUscW6Q().getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_IN_COOLDOWN).replace(gyvhVJ8YfElnhnrkPbt2(), FormatNumber.format(CooldownAPI.getTimeLeft(player.getUniqueId(), strXtOheRiObl4QeAl + str + ".cmd_cooldown"))));
                return false;
            }
            new CooldownAPI(player.getUniqueId(), strXtOheRiObl4QeAl + str + ".cmd_cooldown", commandData.getCooldown()).start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender, String str, String str2, boolean z) {
        try {
            ConcurrentHashMap<String, CommandData> concurrentHashMapIZTqZaRK5UGoe0Z = null;
            String strXtOheRiObl4QeAl = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(str);
            if (strXtOheRiObl4QeAl != null) {
                str = strXtOheRiObl4QeAl;
            }
            if (str2.equalsIgnoreCase(FqtOeIk1M8JF2Vu())) {
                concurrentHashMapIZTqZaRK5UGoe0Z = ZwrsrwOCXRUscW6Q().getCommandManager().ZwrsrwOCXRUscW6Q();
            } else if (str2.equalsIgnoreCase(Wld1EnwWUFASTW())) {
                concurrentHashMapIZTqZaRK5UGoe0Z = ZwrsrwOCXRUscW6Q().getCommandManager().iZTqZaRK5UGoe0Z();
            }
            if (concurrentHashMapIZTqZaRK5UGoe0Z == null || !concurrentHashMapIZTqZaRK5UGoe0Z.containsKey(str)) {
                return true;
            }
            CommandData commandData = concurrentHashMapIZTqZaRK5UGoe0Z.get(str);
            if (commandData.getPermission() == null || commandData.getPermission().isEmpty() || commandSender.hasPermission(commandData.getPermission())) {
                return true;
            }
            if (!z) {
                return false;
            }
            MessageUtils.sendText(commandSender, ZwrsrwOCXRUscW6Q().getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.NO_PERMISSION));
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public List<String> p31abtwfBag2jhMH6K(String str) {
        List<String> listAsList = Arrays.asList("", "", "", "");
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            listAsList.set(i2, str.substring(i, Math.min(i + 16, str.length())));
            i += 16;
            i2++;
        }
        return listAsList;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player) {
        return this.v8qP8fE86HMhvNuYPFjqY.getHooksManager().getPlayerName(player).matches(ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(wQyukSowcmbsVDk5()));
    }

    public boolean Un3NRLL6aWivTcbodkcK(String str) {
        return str.matches(ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(tYE9Iklgbx6FdUffndT7()));
    }

    public boolean lGGwXL678c4Kv7skJb5NiE(String str) {
        String strZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
        if (strZJnaNCVQSgEShq.length() < 1 || strZJnaNCVQSgEShq.length() > ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getInt(xeIGylz3HKxjDV()) || strZJnaNCVQSgEShq.length() < ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getInt(ICv1uAmhEONZHybe())) {
            return false;
        }
        new StringBuilder();
        StringBuilder sb = new StringBuilder();
        try {
            List stringList = ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getStringList(mUX6D2vqCudS1BrT());
            if (stringList.size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb = new StringBuilder();
                for (int i = 0; i < strZJnaNCVQSgEShq.length(); i++) {
                    Iterator it = stringList.iterator();
                    while (it.hasNext()) {
                        if (Character.UnicodeBlock.of(strZJnaNCVQSgEShq.charAt(i)).equals(Character.UnicodeBlock.forName((String) it.next()))) {
                            sb2.append(strZJnaNCVQSgEShq.charAt(i));
                        } else {
                            sb.append(strZJnaNCVQSgEShq.charAt(i));
                        }
                    }
                }
            } else {
                sb.append(strZJnaNCVQSgEShq);
            }
        } catch (Exception e) {
            sb.append(strZJnaNCVQSgEShq);
        }
        return !ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().contains(Xh3S7iLXnarKW5LYqjC2()) || ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(dFIo9ep7SmtY2gAgkNH6()).isEmpty() || sb.toString().matches(ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(XjZww5gGRieTgK3vMZJN()));
    }

    public boolean o1VU1x4DAlrEtGKZ3jAdhE(String str) {
        String strZJnaNCVQSgEShq = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str);
        if (strZJnaNCVQSgEShq.length() < 1 || strZJnaNCVQSgEShq.length() >= ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getInt(vLvHKtHCOtqBhsbRmKcBPk()) || strZJnaNCVQSgEShq.length() < ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getInt(AYKgreTTGJDKfVL())) {
            return false;
        }
        new StringBuilder();
        StringBuilder sb = new StringBuilder();
        try {
            String string = ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(UabChN2zr8ZpMZ3());
            if (string == null || string.isEmpty()) {
                sb.append(strZJnaNCVQSgEShq);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb = new StringBuilder();
                for (int i = 0; i < strZJnaNCVQSgEShq.length(); i++) {
                    if (Character.UnicodeBlock.of(strZJnaNCVQSgEShq.charAt(i)).equals(Character.UnicodeBlock.forName(string))) {
                        sb2.append(strZJnaNCVQSgEShq.charAt(i));
                    } else {
                        sb.append(strZJnaNCVQSgEShq.charAt(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            sb.append(strZJnaNCVQSgEShq);
        }
        return !ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().contains(Qikhy3DwgENYzv6sG()) || ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(Imy8VSgEesOFfAXF()).isEmpty() || sb.toString().matches(ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getString(SNroNPVLtRSUJriK()));
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, Double d, boolean z) {
        Optional<MoneyImplement> optionalIO1OGSMpoP1ZjOsbXi3a = this.v8qP8fE86HMhvNuYPFjqY.getIntegrationManager().IO1OGSMpoP1ZjOsbXi3a();
        if (!optionalIO1OGSMpoP1ZjOsbXi3a.isPresent() || d.doubleValue() <= 0.0d) {
            return true;
        }
        int iDoubleValue = (int) d.doubleValue();
        if (!optionalIO1OGSMpoP1ZjOsbXi3a.get().hasMoney(player, iDoubleValue)) {
            if (!z) {
                return false;
            }
            MessageUtils.sendText((CommandSender) player, MiniMessage.miniMessage().deserialize(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), ZwrsrwOCXRUscW6Q().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_MONEY).replace(cgXnkJSHp9JyNAzD0I3axB(), "<amount:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(A22ZEmj7TihC0e()) + "'>")), Formatter.number(xbYuHILEVkdpHHJ(), Integer.valueOf(iDoubleValue))));
            return false;
        }
        optionalIO1OGSMpoP1ZjOsbXi3a.get().withdrawMoney(player, iDoubleValue);
        if (!z) {
            return true;
        }
        MessageUtils.sendText((CommandSender) player, MiniMessage.miniMessage().deserialize(this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), ZwrsrwOCXRUscW6Q().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DEBITED_MONEY).replace(B1fgRkJa67qA5X(), "<amount:'" + this.v8qP8fE86HMhvNuYPFjqY.getFiles().p31abtwfBag2jhMH6K().getString(CuYDLLKXs3TU38oNrJf()) + "'>")), Formatter.number(kF0adLV0DHFJGQc3h5b(), Integer.valueOf(iDoubleValue))));
        return true;
    }

    public String vVo2VUvxrriklPdRxI(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        int iZwrsrwOCXRUscW6Q = 0;
        boolean z = false;
        boolean z2 = false;
        char[] charArray = this.v8qP8fE86HMhvNuYPFjqY.getColorManager().zJnaNCVQSgEShq(str).toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == 167) {
                z = true;
            } else if (z) {
                z = false;
                z2 = c == 'l' || c == 'L';
            } else {
                me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY = me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(c);
                iZwrsrwOCXRUscW6Q = iZwrsrwOCXRUscW6Q + (z2 ? usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q() : usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l()) + 1;
            }
        }
        int i2 = 154 - (iZwrsrwOCXRUscW6Q / 2);
        int iJBUuLP0sWwaPyPOmogdX7l = me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.FS8nw7CdxwHVFsO.jBUuLP0sWwaPyPOmogdX7l() + 1;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3 += iJBUuLP0sWwaPyPOmogdX7l) {
            sb.append(" ");
        }
        return sb.toString() + str;
    }

    public TextComponent v8qP8fE86HMhvNuYPFjqY(TextComponent textComponent) {
        int iZwrsrwOCXRUscW6Q = 0;
        boolean z = false;
        boolean z2 = false;
        char[] charArray = textComponent.getText().toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == 167) {
                z = true;
            } else if (z) {
                z = false;
                z2 = c == 'l' || c == 'L';
            } else {
                me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY = me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(c);
                iZwrsrwOCXRUscW6Q = iZwrsrwOCXRUscW6Q + (z2 ? usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q() : usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l()) + 1;
            }
        }
        int length2 = (154 - (iZwrsrwOCXRUscW6Q / 2)) - textComponent.getText().length();
        int iJBUuLP0sWwaPyPOmogdX7l = me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.FS8nw7CdxwHVFsO.jBUuLP0sWwaPyPOmogdX7l() + 1;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length2; i2 += iJBUuLP0sWwaPyPOmogdX7l) {
            sb.append(" ");
        }
        return new TextComponent(sb.toString());
    }

    public String v8qP8fE86HMhvNuYPFjqY(StringBuilder sb) {
        String string = sb.toString();
        if (string == null || string.equals("")) {
            return "";
        }
        int iZwrsrwOCXRUscW6Q = 0;
        boolean z = false;
        boolean z2 = false;
        char[] charArray = string.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == 167) {
                z = true;
            } else if (z) {
                z = false;
                z2 = c == 'l' || c == 'L';
            } else {
                me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY = me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(c);
                iZwrsrwOCXRUscW6Q = iZwrsrwOCXRUscW6Q + (z2 ? usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q() : usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l()) + 1;
            }
        }
        int i2 = 154 - (iZwrsrwOCXRUscW6Q / 2);
        int iJBUuLP0sWwaPyPOmogdX7l = me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.FS8nw7CdxwHVFsO.jBUuLP0sWwaPyPOmogdX7l() + 1;
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3 += iJBUuLP0sWwaPyPOmogdX7l) {
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public Clans ZwrsrwOCXRUscW6Q() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public void v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions clanCommandActions, List<String> list, UUID uuid) {
        try {
            if (ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getBoolean(NYBIpGCesXC0zB())) {
                this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
                    List stringList;
                    try {
                        if (ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().contains("Clan.command_actions." + clanCommandActions.toString().toLowerCase() + "_clan_commands") && (stringList = ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getStringList("Clan.command_actions." + clanCommandActions.toString().toLowerCase() + "_clan_commands")) != null && stringList.size() > 0) {
                            Iterator it = stringList.iterator();
                            while (it.hasNext()) {
                                String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY((String) it.next(), (List<String>) list);
                                strV8qP8fE86HMhvNuYPFjqY.replace(ju7iuiIJqlmMuy6eE2OJ(), "");
                                String strTrim = strV8qP8fE86HMhvNuYPFjqY.trim();
                                if (uuid != null) {
                                    strTrim = ZwrsrwOCXRUscW6Q().getHooksManager().parsePapi(uuid, ZwrsrwOCXRUscW6Q().getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, strTrim));
                                }
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), strTrim);
                            }
                        }
                    } catch (Exception e) {
                    }
                }, ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getInt(ozP3wyzqh0FhLyjwYBX()) > 0 ? ((long) ZwrsrwOCXRUscW6Q().getFiles().p31abtwfBag2jhMH6K().getInt(fIg36klMqC1xvAsQG99Vzl())) * 20 : 20L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String uCnA6NRf0r0JiByYnNy4zk(byte[] bArr) {
        return "";
    }

    private static String Vt9fMjlHgV5KMZjPEJK() {
        return "logs";
    }

    private static String LQyMZfJaa35xkAXoey() {
        return "week+";
    }

    private static String f4dCIrztSHt5kl1onB9yL() {
        return "%02d";
    }

    private static String KCAm4RHeZAE1eUXCjL() {
        return "%02d";
    }

    private static String WqXcm6RMojO7ril9GcpCav() {
        return "%02d";
    }

    private static String vD0uPlrsC4CKMrdl3DWTG() {
        return "%02d";
    }

    private static String vNR82ZxYJGVqOyWet2() {
        return "Config.player.skin.mojang";
    }

    private static String py3PS8VaLbKkVM() {
        return "https://api.mojang.com";
    }

    private static String xc1blyl8lOJW8DaGY5g4zV() {
        return "GET";
    }

    private static String xuZmDcMiTPrAQi9Af() {
        return "Status";
    }

    private static String c6Ipsk6nxw0q0ftTYZTh() {
        return "Status";
    }

    private static String xLBnIIIsYbejtb87k() {
        return "OK";
    }

    private static String rY4EpzWJXQPPOuMGy7wX() {
        return "Config.date_format";
    }

    private static String PI3ioCCkcd6H66() {
        return ";";
    }

    private static String xMn3nU4htw6Ri3X0J4dd() {
        return "0";
    }

    private static String fZApsYHBHbXnmtN6n() {
        return "\u2080";
    }

    private static String ijxflIBKCO3Icq() {
        return "1";
    }

    private static String YXpNXI2JD4FoqipU() {
        return "\u00b9";
    }

    private static String pEqqtTti1kM31GU47() {
        return "2";
    }

    private static String DTSU0E5hsiWlbmZR1c() {
        return "\u00b2";
    }

    private static String CsVEqTni8dqo2X5() {
        return "3";
    }

    private static String adWd1SoCQ3luq8JKu() {
        return "\u00b3";
    }

    private static String oXSc0lO7iybTEwqevRr5() {
        return "4";
    }

    private static String WaZmvLdNa2wbAeWWEE3LlF() {
        return "\u2084";
    }

    private static String h24mt0upi9sO50oTJ() {
        return "5";
    }

    private static String YnHOzmLmRM3jLK94X() {
        return "\u2085";
    }

    private static String rhHYfZZwIx5SF2dyESl() {
        return "6";
    }

    private static String NiYwBh8MQJPVJhcqhCbAgP() {
        return "\u2086";
    }

    private static String UHrtwNsnPhgIrsH() {
        return "7";
    }

    private static String MrP1ylHdeuTJ49Jq() {
        return "\u2087";
    }

    private static String s3BMGtVE9JAVvPuNrYL() {
        return "8";
    }

    private static String zqA6abXXyd8140O8e2R3NB() {
        return "\u2088";
    }

    private static String J57OdJI46jHsJA1() {
        return "9";
    }

    private static String rPUbYTHHyMIUfzigy() {
        return "\u2089";
    }

    private static String s6cirvpMRVRA3sKjMPJZUD() {
        return "0";
    }

    private static String la0Tf1I3J2eEx93ok7z5() {
        return "\u2080";
    }

    private static String ewgMfu0oJzoXc2vJgJJw() {
        return "1";
    }

    private static String eYgsGeLe4JMYulI9s() {
        return "\u00b9";
    }

    private static String PJXwLsVE515PmOM() {
        return "2";
    }

    private static String Cag7Vxjyr2cuSejkdcv() {
        return "\u2082";
    }

    private static String xtn71eusAP2khFhGfQ1Q() {
        return "3";
    }

    private static String KtXV0xNO1HBSpcSrzCHG() {
        return "\u2083";
    }

    private static String XHyIwYoFuwN5seFdbNH() {
        return "4";
    }

    private static String kaIVJb7HpAoAUzUXv0eyk() {
        return "\u2084";
    }

    private static String BIeN4JMkppOzVHnDK6TH() {
        return "5";
    }

    private static String KupYVU2eCPDdR33U() {
        return "\u2085";
    }

    private static String obTRUtfTp3kRbxAt() {
        return "6";
    }

    private static String PznOv7n6ImHAyBqjbPm() {
        return "\u2086";
    }

    private static String sD9GtAL3Aysnh2GdHgcqm() {
        return "7";
    }

    private static String XjA47Nb5uUttWVWIHC9() {
        return "\u2087";
    }

    private static String CYuuiDAIWPC0IlaArDu() {
        return "8";
    }

    private static String XtA0Z8X3FDBMIDAaf4Bs() {
        return "\u2088";
    }

    private static String eezhs0v0nNHo6CuZ4zcyK() {
        return "9";
    }

    private static String WIslfw8iR0XW3S() {
        return "\u2089";
    }

    private static String PIgN9DhrzfChm3() {
        return "Config.special_permissions.bypass_command_cooldown";
    }

    private static String JLiRZm3XbAiWa1Mg7B() {
        return "Config.special_permissions.bypass_command_cooldown";
    }

    private static String OXainyc9ICwqNeYAiCH() {
        return "clan";
    }

    private static String Yrvtqn0nmA0TOPq0KOFeCI() {
        return "uclan";
    }

    private static String gyvhVJ8YfElnhnrkPbt2() {
        return "%sec%";
    }

    private static String FqtOeIk1M8JF2Vu() {
        return "clan";
    }

    private static String Wld1EnwWUFASTW() {
        return "uclan";
    }

    private static String wQyukSowcmbsVDk5() {
        return "Clan.invite.allowed_chars";
    }

    private static String tYE9Iklgbx6FdUffndT7() {
        return "Config.player.nickname.allowed_chars";
    }

    private static String xeIGylz3HKxjDV() {
        return "Clan.tag.max_chars";
    }

    private static String ICv1uAmhEONZHybe() {
        return "Clan.tag.min_chars";
    }

    private static String mUX6D2vqCudS1BrT() {
        return "Clan.tag.unicodeblock";
    }

    private static String Xh3S7iLXnarKW5LYqjC2() {
        return "Clan.tag.allowed_chars";
    }

    private static String dFIo9ep7SmtY2gAgkNH6() {
        return "Clan.tag.allowed_chars";
    }

    private static String XjZww5gGRieTgK3vMZJN() {
        return "Clan.tag.allowed_chars";
    }

    private static String vLvHKtHCOtqBhsbRmKcBPk() {
        return "Clan.desc.max_chars";
    }

    private static String AYKgreTTGJDKfVL() {
        return "Clan.desc.min_chars";
    }

    private static String UabChN2zr8ZpMZ3() {
        return "Clan.desc.unicodeblock";
    }

    private static String Qikhy3DwgENYzv6sG() {
        return "Clan.desc.allowed_chars";
    }

    private static String Imy8VSgEesOFfAXF() {
        return "Clan.desc.allowed_chars";
    }

    private static String SNroNPVLtRSUJriK() {
        return "Clan.desc.allowed_chars";
    }

    private static String cgXnkJSHp9JyNAzD0I3axB() {
        return "%amount%";
    }

    private static String A22ZEmj7TihC0e() {
        return "Config.money.format";
    }

    private static String xbYuHILEVkdpHHJ() {
        return "amount";
    }

    private static String B1fgRkJa67qA5X() {
        return "%amount%";
    }

    private static String CuYDLLKXs3TU38oNrJf() {
        return "Config.money.format";
    }

    private static String kF0adLV0DHFJGQc3h5b() {
        return "amount";
    }

    private static String NYBIpGCesXC0zB() {
        return "Clan.command_actions.enabled";
    }

    private static String ozP3wyzqh0FhLyjwYBX() {
        return "Clan.command_actions.execute_delay";
    }

    private static String fIg36klMqC1xvAsQG99Vzl() {
        return "Clan.command_actions.execute_delay";
    }

    private static String ju7iuiIJqlmMuy6eE2OJ() {
        return "/";
    }
}
