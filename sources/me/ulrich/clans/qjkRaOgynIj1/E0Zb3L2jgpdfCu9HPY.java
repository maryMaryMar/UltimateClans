package me.ulrich.clans.qjkRaOgynIj1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.function.Consumer;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/E0Zb3L2jgpdfCu9HPY.class */
public class E0Zb3L2jgpdfCu9HPY {
    private final String v8qP8fE86HMhvNuYPFjqY;
    private final String jBUuLP0sWwaPyPOmogdX7l;
    private final String ZwrsrwOCXRUscW6Q = gW7FPZiDRpt79A();
    private final String iZTqZaRK5UGoe0Z = W9iX93t8TUeTlXHMXd();
    private static String aGmm4tmzsJFG93E3l0pXq;
    private static volatile String sjtZ6McGzvRatATq0o3OpS;
    private static volatile String S9S7sjvJeE3NkEv11q;
    private static String PxJEOcGCohLSKDC;
    private static volatile String SBEm85J7FLqlpr5NUl1v;
    private static String cCvuaDK6wNTVxI86n;
    private static String q99w2wVgovDK4c;
    private static volatile String rUfBZCq4zbfBJQvzwchVQl;
    private static String ywjTydfKqs88wZQbpPe5W;
    private static String nBEwTIMnyXlkDcyLZrlSG;
    private static volatile String eUeK526u8uiIcF4RjviRad;
    private static volatile String h6Wur7gbXdOk5FAfCo;
    private static String p39yXCuFrobkIWv4Arq;
    private static String MjETQZRun1Ci70rOg;
    private static String XKETcoo7udCbPa1BiB;
    private static volatile String qqrHxjbxOinDsDfpCAx;
    private static volatile String vKo3uxw4z0mjWfWz;
    private static volatile String dn424Sykgla6WC;
    private static String S2pTXSZ9FB1NzzTSewodYE;
    private static final byte[] IjpReAQ2zSoCE4c3 = {(byte) 211, (byte) 113, (byte) 1, (byte) 25, (byte) 63, (byte) 204, (byte) 224, (byte) 206, (byte) 102, (byte) 166, (byte) 175, (byte) 17, (byte) 113, (byte) 213, (byte) 32, (byte) 165, (byte) 118, (byte) 25, (byte) 5, (byte) 191, (byte) 149, (byte) 242, (byte) 85, (byte) 3, (byte) 115, (byte) 251, (byte) 35, (byte) 77, (byte) 156, (byte) 241, (byte) 201, (byte) 89, (byte) 58, (byte) 90, (byte) 102, (byte) 58, (byte) 250, (byte) 13, (byte) 220, (byte) 51, (byte) 203, (byte) 93, (byte) 158, (byte) 69, (byte) 57, (byte) 154, (byte) 235, (byte) 248};
    private static final byte[] wVs7rdH4uZnDXk9hSuU = {(byte) 92, (byte) 212, (byte) 254, (byte) 58, (byte) 234, (byte) 143, (byte) 122, (byte) 76, (byte) 61, (byte) 19, (byte) 109, (byte) 154, (byte) 190, (byte) 146, (byte) 137, (byte) 185, (byte) 230, (byte) 227, (byte) 86, (byte) 163, (byte) 215, (byte) 2, (byte) 246, (byte) 212, (byte) 159, (byte) 210, (byte) 79, (byte) 161, (byte) 22, (byte) 182, (byte) 93, (byte) 233};
    private static final byte[] SLKr2yXv5GVnk28l = {(byte) 216, (byte) 165, (byte) 116, (byte) 12, (byte) 33, (byte) 24, (byte) 141, (byte) 19, (byte) 173, (byte) 186, (byte) 21, (byte) 253, (byte) 193, (byte) 132, (byte) 181, (byte) 52};
    private static final byte[] iLkyT3W2cyyi8FHkS9Tyv2 = {(byte) 42, (byte) 120, (byte) 128, (byte) 90, (byte) 121, (byte) 248, (byte) 204, (byte) 6, (byte) 151, (byte) 74, (byte) 56, (byte) 33, (byte) 111, (byte) 42, (byte) 167, (byte) 100};
    private static final byte[] Bw4U1XCkt772OVuabmc06 = {(byte) 200, (byte) 89, (byte) 244, (byte) 192, (byte) 141, (byte) 247, (byte) 163, (byte) 170, (byte) 46, (byte) 194, (byte) 53, (byte) 109, (byte) 193, (byte) 192, (byte) 163, (byte) 196};
    private static final byte[] CARZrpSnVuVhhV = {(byte) 203, (byte) 127, (byte) 19, (byte) 152, (byte) 156, (byte) 166, (byte) 62, (byte) 151, (byte) 120, (byte) 116, (byte) 176, (byte) 10, (byte) 137, (byte) 20, (byte) 254, (byte) 164, (byte) 29, (byte) 141, (byte) 34, (byte) 132, (byte) 46, (byte) 13, (byte) 203, (byte) 26, (byte) 91, (byte) 192, (byte) 164, (byte) 31, (byte) 5, (byte) 235, (byte) 42, (byte) 138, (byte) 233, (byte) 26, (byte) 146, (byte) 67, (byte) 115, (byte) 109, (byte) 29, (byte) 92, (byte) 223, (byte) 13, (byte) 12, (byte) 192, (byte) 201, (byte) 45, (byte) 238, (byte) 35};
    private static final byte[] zRtyAeSERhFYLU = {(byte) 150, (byte) 104, (byte) 95, (byte) 31, (byte) 223, (byte) 54, (byte) 11, (byte) 71, (byte) 91, (byte) 39, (byte) 126, (byte) 36, (byte) 64, (byte) 223, (byte) 198, (byte) 34};
    private static final byte[] z3vAbGNM043FrgcB5fRk = {(byte) 150, (byte) 104, (byte) 95, (byte) 31, (byte) 223, (byte) 54, (byte) 11, (byte) 71, (byte) 91, (byte) 39, (byte) 126, (byte) 36, (byte) 64, (byte) 223, (byte) 198, (byte) 34};
    private static final byte[] WF6a4acnC0MOQfr207s4f = {(byte) 79, (byte) 28, (byte) 216, (byte) 223, (byte) 204, (byte) 139, (byte) 223, (byte) 77, (byte) 241, (byte) 206, (byte) 27, (byte) 64, (byte) 201, (byte) 180, (byte) 126, (byte) 2};
    private static final byte[] V68o5L9e34h6OFGIDDtx = {(byte) 42, (byte) 107, (byte) 1, (byte) 36, (byte) 244, (byte) 152, (byte) 78, (byte) 57, (byte) 103, (byte) 4, (byte) 19, (byte) 46, (byte) 173, (byte) 32, (byte) 130, (byte) 165, (byte) 248, (byte) 241, (byte) 93, (byte) 156, (byte) 55, (byte) 52, (byte) 60, (byte) 199, (byte) 75, (byte) 94, (byte) 5, (byte) 152, (byte) 142, (byte) 182, (byte) 35, (byte) 46};
    private static final byte[] X3Q8VL7X1t5BQQ = {(byte) 246, (byte) 178, (byte) 99, (byte) 225, (byte) 56, (byte) 45, (byte) 66, (byte) 14, (byte) 140, (byte) 31, (byte) 154, (byte) 115, (byte) 85, (byte) 143, (byte) 223, (byte) 176};

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/E0Zb3L2jgpdfCu9HPY$Ijap9SQKkijXSxP5.class */
    public static class Ijap9SQKkijXSxP5 {
        private final boolean v8qP8fE86HMhvNuYPFjqY;
        private final String jBUuLP0sWwaPyPOmogdX7l;
        private final String ZwrsrwOCXRUscW6Q;
        private final String iZTqZaRK5UGoe0Z;

        public Ijap9SQKkijXSxP5(boolean z, String str, String str2, String str3) {
            this.v8qP8fE86HMhvNuYPFjqY = z;
            this.jBUuLP0sWwaPyPOmogdX7l = str;
            this.ZwrsrwOCXRUscW6Q = str2;
            this.iZTqZaRK5UGoe0Z = str3;
        }

        public boolean v8qP8fE86HMhvNuYPFjqY() {
            return this.iZTqZaRK5UGoe0Z != null;
        }

        public boolean jBUuLP0sWwaPyPOmogdX7l() {
            return this.v8qP8fE86HMhvNuYPFjqY;
        }

        public String ZwrsrwOCXRUscW6Q() {
            return this.jBUuLP0sWwaPyPOmogdX7l;
        }

        public String iZTqZaRK5UGoe0Z() {
            return this.ZwrsrwOCXRUscW6Q;
        }

        public String xtOheRiObl4QeAl() {
            return this.iZTqZaRK5UGoe0Z;
        }
    }

    public E0Zb3L2jgpdfCu9HPY(JavaPlugin javaPlugin, String str, String str2) {
        this.v8qP8fE86HMhvNuYPFjqY = str.toLowerCase().trim();
        this.jBUuLP0sWwaPyPOmogdX7l = str2 != null ? str2.trim() : NsYuIk6Ds90B8zxgpdvIVf();
    }

    public static void v8qP8fE86HMhvNuYPFjqY() {
        // Telemetria y actualizador remoto de Tribecraft desactivados
    }

    public void v8qP8fE86HMhvNuYPFjqY(Consumer<Ijap9SQKkijXSxP5> consumer) {
        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
            try {
                String strValueOf = String.valueOf(System.currentTimeMillis() / 1000);
                String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(this.v8qP8fE86HMhvNuYPFjqY + ":main:" + strValueOf, A6Z3TMoIZP3nYKDUr7gm5A());
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.tribecraft.com.br/cloud/check_update.php?repo=" + this.v8qP8fE86HMhvNuYPFjqY + "&id=main&version=" + this.jBUuLP0sWwaPyPOmogdX7l).openConnection();
                httpURLConnection.setRequestMethod(q0Ybdb46P1aGNUWdWw());
                httpURLConnection.setRequestProperty(eH8Wu4SqqNtRHDMFHoEH(), "Tribecraft-Updater/" + this.jBUuLP0sWwaPyPOmogdX7l);
                httpURLConnection.setRequestProperty(AcqMNLPfznOCxjZSxRkd(), strValueOf);
                httpURLConnection.setRequestProperty(NWNiTa1uZfePxhjd(), strV8qP8fE86HMhvNuYPFjqY);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() != 200) {
                    consumer.accept(new Ijap9SQKkijXSxP5(false, this.jBUuLP0sWwaPyPOmogdX7l, this.jBUuLP0sWwaPyPOmogdX7l, "Erro HTTP: " + httpURLConnection.getResponseCode()));
                    return;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line);
                    }
                }
                bufferedReader.close();
                JSONObject jSONObject = new JSONObject(sb.toString());
                if (jSONObject.has(QajqqCUYTEQ721()) && jSONObject.getBoolean(aAwx9gxzFRxKV5mvuI())) {
                    consumer.accept(new Ijap9SQKkijXSxP5(jSONObject.getBoolean(lxCPF3x3LJNIZIBpOU9()), this.jBUuLP0sWwaPyPOmogdX7l, jSONObject.getString(ZTHlTUsIEayxNU5tTSfd()), null));
                } else {
                    consumer.accept(new Ijap9SQKkijXSxP5(false, this.jBUuLP0sWwaPyPOmogdX7l, this.jBUuLP0sWwaPyPOmogdX7l, jSONObject.has(cI5rgNm3JZWeTy()) ? jSONObject.getString(qEmDk3owI04iN5X3Vv()) : HGbD8grLOnCKKY3CnAVp()));
                }
            } catch (Exception e) {
                consumer.accept(new Ijap9SQKkijXSxP5(false, this.jBUuLP0sWwaPyPOmogdX7l, this.jBUuLP0sWwaPyPOmogdX7l, "Falha: " + e.getMessage()));
            }
        });
    }

    private String v8qP8fE86HMhvNuYPFjqY(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(kBSNTopMNbMjZijJMKHzE());
        mac.init(new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), IVo0fVlULKWl06GDtv0f()));
        byte[] bArrDoFinal = mac.doFinal(str.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDoFinal) {
            String hexString = Integer.toHexString(255 & b);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static String gW7FPZiDRpt79A() {
        return "https://api.tribecraft.com.br/cloud/check_update.php";
    }

    private static String W9iX93t8TUeTlXHMXd() {
        return "uclans_updater_secret_secure_key_2026";
    }

    private static String NsYuIk6Ds90B8zxgpdvIVf() {
        return "0.0";
    }

    private static String tkSOjM33WEbIMz() {
        return "Plugin.check_for_updates";
    }

    private static String kBSNTopMNbMjZijJMKHzE() {
        return "HmacSHA256";
    }

    private static String IVo0fVlULKWl06GDtv0f() {
        return "HmacSHA256";
    }

    private static String A6Z3TMoIZP3nYKDUr7gm5A() {
        return "uclans_updater_secret_secure_key_2026";
    }

    private static String q0Ybdb46P1aGNUWdWw() {
        return "GET";
    }

    private static String eH8Wu4SqqNtRHDMFHoEH() {
        return "User-Agent";
    }

    private static String AcqMNLPfznOCxjZSxRkd() {
        return "X-Timestamp";
    }

    private static String NWNiTa1uZfePxhjd() {
        return "X-Signature";
    }

    private static String QajqqCUYTEQ721() {
        return "success";
    }

    private static String aAwx9gxzFRxKV5mvuI() {
        return "success";
    }

    private static String lxCPF3x3LJNIZIBpOU9() {
        return "need_update";
    }

    private static String ZTHlTUsIEayxNU5tTSfd() {
        return "latest";
    }

    private static String cI5rgNm3JZWeTy() {
        return "error";
    }

    private static String qEmDk3owI04iN5X3Vv() {
        return "error";
    }

    private static String HGbD8grLOnCKKY3CnAVp() {
        return "Erro desconhecido";
    }

    private static String qWaO7XGyGua7L5KF4ZbePy() {
        return "The plugin is in its latest version.";
    }
}
