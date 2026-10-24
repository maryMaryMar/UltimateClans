package me.ulrich.clans.manager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Addon;
import me.ulrich.clans.data.AddonInfo;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/sePx9kYBAc4ZOPKCkj.class */
public class sePx9kYBAc4ZOPKCkj {
    private static Clans v8qP8fE86HMhvNuYPFjqY;
    private static volatile String xGg3CYT5LrAFve2IoXk;
    private static volatile String unTcAHLMA0ODNe4zHWKI;
    private static String lbgu3ISQoU6cdCZk;
    private static String isytAl3QHAs35pbsSUta;
    private static String rdAngzxFkEsgD30s3;
    private static String zzK5xeSPmnX9O4Iy9g;
    private static volatile String vt07VWlRbqoP8xKRuFvbQ0;
    private static volatile String O6PnKxkZViNsy3OIL;
    private static volatile String V0i8ZRYjDzIyrhtlwFluY;
    private static String ldZA55ei10OQgxdKj;
    private static String DD6C5wEqrPAG6Q1uDRZVh;
    private static volatile String X6emqUEkX0CrNe;
    private static String poNcOEDOENrkGlk5T;
    private static String Eznrln3qs4GBwb3FE;
    private static String qtnXriKZgZDwYJPUN;
    private static String nA8j9HlWkrxC3Xu4;
    private static String OJJdwOq9mVdRbM3vZb;
    private static String ENnBTVQiZzu0X0gPAxcj;
    private static volatile String pWx6No2jNPKKTSM2fWXi;
    private static volatile String UpRV4P4HDTrCs1dRljH1r2;
    private static volatile String baA6SiCoEwOBKLzFZFdon;
    private static volatile String gU3Xx4gXAW2GsLvz;
    private static volatile String zNiJhZ1SPUeJVJ0yO;
    private static volatile String Ui3CmSDEnk2eXpaWFa;
    private static String BehG2Opsn0lLurHoJzVtu1;
    private static String ra18rZGG1hYJ3lOQ99ms;
    private static volatile String kxzohhSJaUrJNngZ;
    private static volatile String cGTLW1g5v4mlnt;
    private static volatile String DF9H0XiEKER6u62WjwZc;
    private static volatile String VTARJR3EQAjBb9bokv;
    private static String QvJBccU63k3IvT24ACwGq1;
    private static String SZcilTAcl44Ahxj4;
    private static String LhDKYILSqeotwVlbsj7a9K;
    private static volatile String vFuCiTes35TGdK5;
    private static volatile String hcB3uuWfjI9QeZ;
    private static final byte[] KZBZDXkr4PAzmB = {(byte) 156, (byte) 0, (byte) 209, (byte) 218, (byte) 34, (byte) 93, (byte) 31, (byte) 99, (byte) 50, (byte) 19, (byte) 221, (byte) 198, (byte) 198, (byte) 81, (byte) 105, (byte) 238};
    private static final byte[] f5LpusoudXdOkb85O = {(byte) 106, (byte) 240, (byte) 224, (byte) 36, (byte) 85, (byte) 63, (byte) 162, (byte) 192, (byte) 236, (byte) 108, (byte) 31, (byte) 250, (byte) 135, (byte) 1, (byte) 79, (byte) 2};
    private static final byte[] fPY85U7zvTjnwsT9pnWUY = {(byte) 249, (byte) 215, (byte) 237, (byte) 178, (byte) 101, (byte) 136, (byte) 172, (byte) 96, (byte) 187, (byte) 130, (byte) 82, (byte) 58, (byte) 39, (byte) 126, (byte) 91, (byte) 52};
    private static final byte[] INsu3UmCunlgepdwtQo = {(byte) 3, (byte) 68, (byte) 158, (byte) 159, (byte) 78, (byte) 45, (byte) 119, (byte) 89, (byte) 31, (byte) 116, (byte) 197, (byte) 197, (byte) 224, (byte) 214, (byte) 131, (byte) 130};
    private static final byte[] en9WXsrxLGcz6jnqMmUn = {(byte) 109, (byte) 212, (byte) 114, (byte) 116, (byte) 199, (byte) 85, (byte) 6, (byte) 65, (byte) 167, (byte) 103, (byte) 63, (byte) 10, (byte) 254, (byte) 167, (byte) 67, (byte) 48};
    private static final byte[] kDXvDd4Ji2BVaqSnP = {(byte) 33, (byte) 249, (byte) 153, (byte) 150, (byte) 132, (byte) 18, (byte) 2, (byte) 163, (byte) 146, (byte) 109, (byte) 209, (byte) 153, (byte) 177, (byte) 237, (byte) 219, (byte) 170, (byte) 238, (byte) 193, (byte) 8, (byte) 159, (byte) 225, (byte) 20, (byte) 213, (byte) 22, (byte) 46, (byte) 231, (byte) 19, (byte) 115, (byte) 8, (byte) 220, (byte) 115, (byte) 219};
    private static final byte[] XqFXLOUJ43kBGwwO = {(byte) 12, (byte) 25, (byte) 163, (byte) 121, (byte) 110, (byte) 189, (byte) 65, (byte) 60, (byte) 186, (byte) 85, (byte) 44, (byte) 204, (byte) 30, (byte) 209, (byte) 176, (byte) 191};
    private static final byte[] hjLk0iv2xk0Wcg = {(byte) 229, (byte) 115, (byte) 232, (byte) 26, (byte) 190, (byte) 157, (byte) 104, (byte) 55, (byte) 38, (byte) 204, (byte) 70, (byte) 15, (byte) 31, (byte) 186, (byte) 168, (byte) 220};
    private static final byte[] bSSkwzSqNh4YMvhf = {(byte) 217, (byte) 197, (byte) 105, (byte) 39, (byte) 45, (byte) 162, (byte) 41, (byte) 45, (byte) 168, (byte) 203, (byte) 192, (byte) 112, (byte) 23, (byte) 155, (byte) 171, (byte) 140};
    private static final byte[] AAopvsGzoUaLqOTWqL = {(byte) 110, (byte) 188, (byte) 233, (byte) 83, (byte) 222, (byte) 101, (byte) 156, (byte) 152, (byte) 201, (byte) 4, (byte) 111, (byte) 187, (byte) 87, (byte) 57, (byte) 221, (byte) 141};
    private static final byte[] dBtT0Sx78GomwgakQ = {(byte) 124, (byte) 170, (byte) 92, (byte) 121, (byte) 118, (byte) 241, (byte) 152, (byte) 199, (byte) 174, (byte) 102, (byte) 239, (byte) 220, (byte) 8, (byte) 238, (byte) 62, (byte) 57};
    private static final byte[] ZCenlNuOr9WSrqS3GHDzXC = {(byte) 219, (byte) 61, (byte) 97, (byte) 21, (byte) 60, (byte) 44, (byte) 74, (byte) 146, (byte) 151, (byte) 144, (byte) 184, (byte) 77, (byte) 198, (byte) 17, (byte) 27, (byte) 254};
    private static final byte[] FG6mL5vIViWl1J2M5g2i = {(byte) 89, (byte) 117, (byte) 14, (byte) 141, (byte) 62, (byte) 207, (byte) 71, (byte) 168, (byte) 133, (byte) 225, (byte) 135, (byte) 118, (byte) 49, (byte) 3, (byte) 162, (byte) 169};
    private static final byte[] NAoXJ1pemdNAFNslWYDx = {(byte) 229, (byte) 66, (byte) 206, (byte) 120, (byte) 97, (byte) 249, (byte) 83, (byte) 209, (byte) 149, (byte) 102, (byte) 52, (byte) 217, (byte) 57, (byte) 3, (byte) 151, (byte) 244};
    private static final byte[] PSxQWiysBceTOZun = {(byte) 190, (byte) 236, (byte) 38, (byte) 145, (byte) 164, (byte) 16, (byte) 40, (byte) 65, (byte) 90, (byte) 51, (byte) 204, (byte) 125, (byte) 198, (byte) 16, (byte) 22, (byte) 225};
    private static final byte[] ho4nCoTPXvtmt5wG = {(byte) 252, (byte) 162, (byte) 246, (byte) 212, (byte) 60, (byte) 254, (byte) 211, (byte) 66, (byte) 24, (byte) 124, (byte) 28, (byte) 173, (byte) 212, (byte) 90, (byte) 39, (byte) 176};
    private static final byte[] yQOlCqR3GaX0aeRy = {(byte) 40, (byte) 132, (byte) 74, (byte) 214, (byte) 131, (byte) 82, (byte) 137, (byte) 76, (byte) 249, (byte) 0, (byte) 134, (byte) 207, (byte) 191, (byte) 221, (byte) 84, (byte) 182, (byte) 231, (byte) 104, (byte) 27, (byte) 111, (byte) 101, (byte) 83, (byte) 195, (byte) 115, (byte) 169, (byte) 60, (byte) 190, (byte) 97, (byte) 234, (byte) 146, (byte) 94, (byte) 83};
    private static final byte[] Q14JcH6TroAiaRe5CtI0E = {(byte) 40, (byte) 39, (byte) 143, (byte) 92, (byte) 188, (byte) 29, (byte) 25, (byte) 162, (byte) 45, (byte) 179, (byte) 147, (byte) 11, (byte) 238, (byte) 151, (byte) 11, (byte) 18, (byte) 74, (byte) 166, (byte) 40, (byte) 131, (byte) 176, (byte) 214, (byte) 244, (byte) 212, (byte) 28, (byte) 176, (byte) 62, (byte) 19, (byte) 164, (byte) 84, (byte) 34, (byte) 186};
    private static final byte[] qtXoDwylUKkPum2Qe1 = {(byte) 211, (byte) 35, (byte) 67, (byte) 48, (byte) 184, (byte) 213, (byte) 76, (byte) 1, (byte) 71, (byte) 51, (byte) 180, (byte) 175, (byte) 239, (byte) 164, (byte) 208, (byte) 31};

    public sePx9kYBAc4ZOPKCkj(Clans clans, TaskScheduler taskScheduler) {
        if (clans == null) {
            throw new IllegalArgumentException(xmCaFjRFcadzEM());
        }
        v8qP8fE86HMhvNuYPFjqY = clans;
        boolean z = false;
        Iterator it = Bukkit.getServicesManager().getKnownServices().iterator();
        while (it.hasNext()) {
            try {
                ((Class) it.next()).getField(ltk68MKNergn0f());
                z = true;
                break;
            } catch (NoSuchFieldException e) {
            }
        }
        Bukkit.getServicesManager().register(sePx9kYBAc4ZOPKCkj.class, this, v8qP8fE86HMhvNuYPFjqY, ServicePriority.Normal);
        // Telemetria desactivada
    }

    public static Clans v8qP8fE86HMhvNuYPFjqY() {
        return v8qP8fE86HMhvNuYPFjqY;
    }

    private void iZTqZaRK5UGoe0Z() {
        xtOheRiObl4QeAl();
    }

    public InetAddress jBUuLP0sWwaPyPOmogdX7l() {
        try {
            InetAddress inetAddress = null;
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        if (inetAddressNextElement.isSiteLocalAddress()) {
                            return inetAddressNextElement;
                        }
                        if (inetAddress == null) {
                            inetAddress = inetAddressNextElement;
                        }
                    }
                }
            }
            if (inetAddress != null) {
                return inetAddress;
            }
            InetAddress localHost = InetAddress.getLocalHost();
            if (localHost == null) {
                return null;
            }
            return localHost;
        } catch (Exception e) {
            return null;
        }
    }

    public JsonObject ZwrsrwOCXRUscW6Q() {
        JsonObject jsonObject = new JsonObject();
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
        }
        if (localHost != null) {
            jsonObject.addProperty(JTpgPNurVwcus8P1DXZQ(), localHost.getHostAddress() + ":" + Bukkit.getServer().getPort());
        }
        String strNXcEVQOWhfaKT423a = v8qP8fE86HMhvNuYPFjqY().getFiles().nXcEVQOWhfaKT423a();
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY("632059", strNXcEVQOWhfaKT423a);
        String strV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY("1792770161", String.valueOf(System.currentTimeMillis() / 1000));
        String strV8qP8fE86HMhvNuYPFjqY3 = v8qP8fE86HMhvNuYPFjqY("8168b57912b8c70c506e3c72b5d1cd65", Integer.toUnsignedString(strNXcEVQOWhfaKT423a.hashCode()));
        jsonObject.addProperty(eLSPR0D168PA8p4DIFLhO(), strV8qP8fE86HMhvNuYPFjqY);
        jsonObject.addProperty(h5QD2Mal8QGePZE(), strV8qP8fE86HMhvNuYPFjqY2);
        jsonObject.addProperty(b5Ds0lrDarLFEDmg8(), strV8qP8fE86HMhvNuYPFjqY3);
        jsonObject.addProperty(lpjA5X3p7z3KbJH30st(), v8qP8fE86HMhvNuYPFjqY().getDescription().getName().toLowerCase());
        jsonObject.addProperty(ozOdnTD4UYFJl9(), v8qP8fE86HMhvNuYPFjqY().getDescription().getVersion());
        jsonObject.addProperty(duXZbiKAYq4yz2doO9dQOP(), UsEbiuprSHpNw3qjITfH.jBUuLP0sWwaPyPOmogdX7l().toString());
        JsonArray jsonArray = new JsonArray();
        for (Map.Entry<Addon, AddonInfo> entry : v8qP8fE86HMhvNuYPFjqY().getAddonEnabledList().entrySet()) {
            Addon key = entry.getKey();
            AddonInfo value = entry.getValue();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(iK8EXvq7xJ4FZmGG(), key.getName());
            jsonObject2.addProperty(O8TQZVHUqoWJwgEsYKmQ(), value.getData());
            jsonArray.add(jsonObject2);
        }
        jsonObject.add(i8R6XDHUQa2A2JPi(), jsonArray);
        return jsonObject;
    }

    private void xtOheRiObl4QeAl() {
        // Telemetria desactivada
    }

    private static void v8qP8fE86HMhvNuYPFjqY(Clans clans, JsonObject jsonObject) throws Exception {
        // Telemetria desactivada
    }

    private static String v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        if (str == null || str.isBlank()) {
            return str2;
        }
        String strTrim = str.trim();
        return (strTrim.startsWith(vPTDGPssND3IBvUoW()) && strTrim.endsWith(YEczEcVHsMIJoAyzhb5q5x())) ? str2 : str;
    }

    private static byte[] v8qP8fE86HMhvNuYPFjqY(String str) throws java.io.IOException {
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                gZIPOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String wu9Vvk4bpJFjEb(byte[] bArr) {
        return "";
    }

    private static String xmCaFjRFcadzEM() {
        return "Plugin cannot be null!";
    }

    private static String ltk68MKNergn0f() {
        return "U_STATS";
    }

    private static String JTpgPNurVwcus8P1DXZQ() {
        return "ip";
    }

    private static String eLSPR0D168PA8p4DIFLhO() {
        return "uuid";
    }

    private static String h5QD2Mal8QGePZE() {
        return "timestamp";
    }

    private static String b5Ds0lrDarLFEDmg8() {
        return "nonce";
    }

    private static String lpjA5X3p7z3KbJH30st() {
        return "plugin";
    }

    private static String ozOdnTD4UYFJl9() {
        return "version";
    }

    private static String duXZbiKAYq4yz2doO9dQOP() {
        return "agent";
    }

    private static String iK8EXvq7xJ4FZmGG() {
        return "name";
    }

    private static String O8TQZVHUqoWJwgEsYKmQ() {
        return "version";
    }

    private static String i8R6XDHUQa2A2JPi() {
        return "addons";
    }

    private static String ZTgZMKATe1zwHv() {
        return "U_STATS";
    }

    private static String jeIevTxRjGkJxC() {
        return "getPluginData";
    }

    private static String u2mdCzMRZZAO0lxs8fYZxB() {
        return "org.json.simple.JSONObject";
    }

    private static String FLiNddPGyewin8K() {
        return "toJSONString";
    }

    private static String WZKekZzburuVBLSeMA() {
        return "plugins";
    }

    private static String KKpElDp8Fq1bASaE4GznQZ() {
        return "Data cannot be null!";
    }

    private static String a6TeCVBY6hn7LplXzfc8() {
        return "This method must not be called from the main thread!";
    }

    private static String VD6JVmzbtcmBvrXjxSz() {
        return "https://painel.tribecraft.com.br/data_receive.php";
    }

    private static String KxJ1kTPwK0s4VATtDpyd() {
        return "POST";
    }

    private static String mm19WM3AHSBgo8g() {
        return "Accept";
    }

    private static String I9SPSmJ1iVTu8WtI() {
        return "application/json";
    }

    private static String IMtORzp7XCxe83h() {
        return "Connection";
    }

    private static String YRrHdg4biBFeghDF() {
        return "close";
    }

    private static String fG5TsAgHg2bOsLklS() {
        return "Content-Encoding";
    }

    private static String l5Q1EBzKM34H5SeGyF() {
        return "gzip";
    }

    private static String wXPJ8QW9KwRfuD() {
        return "Content-Length";
    }

    private static String NSi2hTC1itlplMLJo7CW() {
        return "Content-Type";
    }

    private static String pgax7lbR9NvPg2wU() {
        return "application/json";
    }

    private static String fnDZUeW2CHBz76wvn() {
        return "User-Agent";
    }

    private static String dheb3Gb1CsBK6U() {
        return "ULRICHCRAFT-MC/2.0";
    }

    private static String QhZQ6Em64SQPA57FbyxHsj() {
        return "X-Plugin-Reason";
    }

    private static String vPTDGPssND3IBvUoW() {
        return "%%__";
    }

    private static String YEczEcVHsMIJoAyzhb5q5x() {
        return "__%%";
    }
}
