package me.module.levelup.manager.b;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.module.levelup.Levelup;
import me.module.levelup.manager.EnumFiles.Lang;
import me.ulrich.clans.data.RequerimentData_Return;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.parser.TokenParser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/b/c.class */
public class c {
    private static String __s_cache_CgriLBHE_0;
    private static String __s_cache_7E3rQv6C_1;
    private static String __s_cache_2BajOCNx_2;
    private static String __s_cache_h7zeUztM_3;
    private static String __s_cache_mKzf7aOc_4;
    private static String __s_cache_hvQmrDVc_5;
    private static String __s_cache_qEEnBpYq_6;
    private static String __s_cache_KEinLDbr_7;
    private static String __s_cache_RlbaE2Wr_8;
    private static String __s_cache_JxENuQNZ_9;
    private static String __s_cache_vhoFD3fP_10;
    private static String __s_cache_umf32YWt_11;
    private static String __s_cache_fOTsIMcF_12;
    private static String __s_cache_v8sjUnYX_13;
    private static String __s_cache_MRkBcbEF_14;
    private static String __s_cache_ayTzLAU0_15;
    private static String __s_cache_alCyX38Q_16;
    private static String __s_cache_NXa514KY_17;
    private static String __s_cache_qrmkXyCe_18;
    private static String __s_cache_Z5eg10Em_19;
    private static String __s_cache_UgCSItU4_20;
    private static String __s_cache_xYkDaI76_21;
    private static String __s_cache_rBIVduCz_22;
    private static String __s_cache_m7OV6sCS_23;
    private static String __s_cache_ok37zC1U_24;
    private static String __s_cache_rzUCmTBW_25;
    private static String __s_cache_jEZvb0ol_26;
    private static String __s_cache_cu2oYBE5_27;
    private static String __s_cache_6gqGVwxT_28;
    private static String __s_cache_LZ1VIGuV_29;
    private static String __s_cache_LscYyVat_30;
    private static String __s_cache_suyJwZUE_31;
    private static byte[] __aes_key_QEDKQiq9 = {(byte) 223, (byte) 223, (byte) 232, (byte) 134, (byte) 198, (byte) 231, (byte) 142, (byte) 122, (byte) 233, (byte) 50, (byte) 97, (byte) 215, (byte) 133, (byte) 132, (byte) 86, (byte) 190, (byte) 63, (byte) 110, (byte) 6, (byte) 97, (byte) 208, (byte) 24, (byte) 59, (byte) 118, (byte) 205, (byte) 250, (byte) 42, (byte) 192, (byte) 226, (byte) 87, (byte) 123, (byte) 178};
    private static byte[] __aes_iv_RAq5kCAS = {(byte) 207, (byte) 73, (byte) 129, (byte) 27, (byte) 59, (byte) 150, (byte) 240, (byte) 242, (byte) 179, (byte) 62, (byte) 97, (byte) 195, (byte) 122, (byte) 98, (byte) 79, (byte) 162};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f118a = Pattern.compile("(%[^%]+%)\\s*(==|!=|>=|<=|<|>)\\s*(.+)");

    public static List<String> a(List<RequerimentData_Return> list) {
        ArrayList arrayList = new ArrayList();
        for (RequerimentData_Return requerimentData_Return : list) {
            if (requerimentData_Return.getFalseMessage().isPresent()) {
                arrayList.add(requerimentData_Return.getFalseMessage().get().replace("%value%", requerimentData_Return.getRequiredValue()));
            } else if (requerimentData_Return.getTrueMessage().isPresent()) {
                arrayList.add(requerimentData_Return.getTrueMessage().get().replace("%value%", requerimentData_Return.getRequiredValue()));
            }
        }
        return arrayList;
    }

    public List<RequerimentData_Return> a(UUID uuid, List<String> list) {
        return a(uuid, list, Optional.ofNullable(uuid));
    }

    public List<RequerimentData_Return> a(UUID uuid, List<String> list, Optional<UUID> optional) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (String str : list) {
            if (str != null && !str.trim().isEmpty()) {
                String[] strArrB = b(str);
                String str2 = strArrB[0];
                String string = strArrB[1].isEmpty() ? Levelup.getModuleCore().c().b(optional).getString(Lang.REQUIRES_DEFAULT_FALSE) : strArrB[1];
                String string2 = strArrB[2].isEmpty() ? Levelup.getModuleCore().c().b(optional).getString(Lang.REQUIRES_DEFAULT_TRUE) : strArrB[2];
                String strA = a(uuid, str2);
                RequerimentData_Return requerimentData_Return = new RequerimentData_Return(strA != null ? strA : c(str2), Optional.empty(), Optional.empty());
                if (strA != null) {
                    requerimentData_Return.setFalseMessage(Optional.of(string));
                } else {
                    requerimentData_Return.setTrueMessage(Optional.of(string2));
                }
                arrayList.add(requerimentData_Return);
            }
        }
        return arrayList;
    }

    private String[] b(String str) {
        String strTrim = str;
        String strTrim2 = "";
        String strTrim3 = "";
        Matcher matcher = Pattern.compile("(.+?)(;false=(.*?))?(;true=(.*))?$").matcher(str);
        if (matcher.find()) {
            strTrim = matcher.group(1).trim();
            strTrim2 = matcher.group(3) != null ? matcher.group(3).trim() : "";
            strTrim3 = matcher.group(5) != null ? matcher.group(5).trim() : "";
        }
        return new String[]{strTrim, strTrim2, strTrim3};
    }

    public boolean b(UUID uuid, List<String> list) {
        if (list == null) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (a(uuid, b(it.next())[0]) != null) {
                return false;
            }
        }
        return true;
    }

    public String a(UUID uuid, String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("CHECKITEM:")) {
            return b(uuid, strTrim).orElse(null);
        }
        Matcher matcher = f118a.matcher(strTrim);
        if (!matcher.matches()) {
            return strTrim;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strTrim2 = matcher.group(3).trim();
        String text = Levelup.a().getClanAPI().parseText(uuid, Levelup.a().getHooksAPI().parsePapi(uuid, strGroup));
        String strA = a(strTrim2);
        String strA2 = a(text);
        try {
            if (a(new BigDecimal(strA2), new BigDecimal(strA), strGroup2)) {
                return null;
            }
            return strTrim2;
        } catch (NumberFormatException e) {
            if (e(strA2) && e(strA)) {
                if (a(Boolean.parseBoolean(strA2), Boolean.parseBoolean(strA), strGroup2)) {
                    return null;
                }
                return strTrim2;
            }
            if (a(strA2, strA, strGroup2)) {
                return null;
            }
            return strTrim2;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return "0";
        }
        String strReplace = str.trim().replace(" ", "");
        if (strReplace.isEmpty()) {
            return "0";
        }
        if (!strReplace.matches("[+-]?\\d[\\d.,]*")) {
            return strReplace;
        }
        int iB = b(strReplace, '.');
        int iB2 = b(strReplace, ',');
        if (iB > 0 && iB2 > 0) {
            return strReplace.lastIndexOf(44) > strReplace.lastIndexOf(46) ? strReplace.replace(".", "").replace(',', '.') : strReplace.replace(",", "");
        }
        if (iB > 0) {
            return a(strReplace, '.');
        }
        return iB2 > 0 ? a(strReplace, ',') : strReplace;
    }

    private static String a(String str, char c) {
        int iB = b(str, c);
        String[] strArrSplit = str.split(Pattern.quote(String.valueOf(c)), -1);
        if (iB <= 1) {
            if ((str.length() - str.indexOf(c)) - 1 == 3) {
                return str.replace(String.valueOf(c), "");
            }
            return c == ',' ? str.replace(',', '.') : str;
        }
        boolean z = true;
        for (int i = 1; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() != 3) {
                z = false;
                break;
            }
        }
        if (z) {
            return str.replace(String.valueOf(c), "");
        }
        int iLastIndexOf = str.lastIndexOf(c);
        return str.substring(0, iLastIndexOf).replace(String.valueOf(c), "") + "." + str.substring(iLastIndexOf + 1);
    }

    private static int b(String str, char c) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c) {
                i++;
            }
        }
        return i;
    }

    private String c(String str) {
        if (str.startsWith("CHECKITEM:")) {
            return a(d(str));
        }
        Matcher matcher = f118a.matcher(str);
        return matcher.matches() ? matcher.group(3).trim() : str;
    }

    private Optional<String> b(UUID uuid, String str) {
        Map<String, Integer> mapD = d(str);
        if (mapD.isEmpty()) {
            return Optional.of(str.replace("CHECKITEM:", "").replace("[", "").replace("]", "").trim());
        }
        Player player = uuid == null ? null : Bukkit.getPlayer(uuid);
        if (player == null) {
            return Optional.of(a(mapD));
        }
        for (Map.Entry<String, Integer> entry : mapD.entrySet()) {
            Material materialMatchMaterial = Material.matchMaterial(entry.getKey());
            int iIntValue = entry.getValue().intValue();
            if (materialMatchMaterial == null) {
                return Optional.of("Invalid " + entry.getKey());
            }
            if (!a(player, materialMatchMaterial, iIntValue)) {
                return Optional.of(entry.getKey() + " (X" + iIntValue + ")");
            }
        }
        return Optional.empty();
    }

    private Map<String, Integer> d(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strTrim = str.replace("CHECKITEM:", "").replace("[", "").replace("]", "").trim();
        if (strTrim.isEmpty()) {
            return linkedHashMap;
        }
        for (String str2 : strTrim.split(",")) {
            String[] strArrSplit = str2.trim().split(":", 2);
            if (strArrSplit.length == 2) {
                try {
                    int i = Integer.parseInt(strArrSplit[1].trim());
                    if (i > 0) {
                        linkedHashMap.merge(strArrSplit[0].trim().toUpperCase(), Integer.valueOf(i), (v0, v1) -> {
                            return Integer.sum(v0, v1);
                        });
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return linkedHashMap;
    }

    private String a(Map<String, Integer> map) {
        return (String) map.entrySet().stream().map(entry -> {
            return ((String) entry.getKey()) + " (X" + String.valueOf(entry.getValue()) + ")";
        }).collect(Collectors.joining(", "));
    }

    private boolean a(Player player, Material material, int i) {
        int amount = 0;
        ListIterator it = player.getInventory().iterator();
        while (it.hasNext()) {
            ItemStack itemStack = (ItemStack) it.next();
            if (itemStack != null && itemStack.getType() == material) {
                amount += itemStack.getAmount();
            }
            if (amount >= i) {
                return true;
            }
        }
        return amount >= i;
    }

    private boolean a(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str) {
        byte b = -1;
        switch (str.hashCode()) {
            case 60:
                if (str.equals("<")) {
                    b = 5;
                }
                break;
            case TokenParser.TAG_END /* 62 */:
                if (str.equals(">")) {
                    b = 4;
                }
                break;
            case 1084:
                if (str.equals("!=")) {
                    b = 1;
                }
                break;
            case 1921:
                if (str.equals("<=")) {
                    b = 3;
                }
                break;
            case 1952:
                if (str.equals("==")) {
                    b = 0;
                }
                break;
            case 1983:
                if (str.equals(">=")) {
                    b = 2;
                }
                break;
        }
        switch (b) {
            case 0:
                return bigDecimal.compareTo(bigDecimal2) == 0;
            case 1:
                return bigDecimal.compareTo(bigDecimal2) != 0;
            case 2:
                return bigDecimal.compareTo(bigDecimal2) >= 0;
            case 3:
                return bigDecimal.compareTo(bigDecimal2) <= 0;
            case 4:
                return bigDecimal.compareTo(bigDecimal2) > 0;
            case 5:
                return bigDecimal.compareTo(bigDecimal2) < 0;
            default:
                return false;
        }
    }

    private boolean a(boolean z, boolean z2, String str) {
        byte b = -1;
        switch (str.hashCode()) {
            case 1084:
                if (str.equals("!=")) {
                    b = 1;
                }
                break;
            case 1952:
                if (str.equals("==")) {
                    b = 0;
                }
                break;
        }
        switch (b) {
            case 0:
                return z == z2;
            case 1:
                return z != z2;
            default:
                return false;
        }
    }

    private boolean a(String str, String str2, String str3) {
        byte b = -1;
        switch (str3.hashCode()) {
            case 1084:
                if (str3.equals("!=")) {
                    b = 1;
                }
                break;
            case 1952:
                if (str3.equals("==")) {
                    b = 0;
                }
                break;
        }
        switch (b) {
            case 0:
                return str.equals(str2);
            case 1:
                return !str.equals(str2);
            default:
                return false;
        }
    }

    private boolean e(String str) {
        return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str);
    }

    private static String __unused_965() {
        return "%value%";
    }

    private static String __unused_966() {
        return "%value%";
    }

    private static String __unused_967() {
        return "(.+?)(;false=(.*?))?(;true=(.*))?$";
    }

    private static String __unused_968() {
        return "CHECKITEM:";
    }

    private static String __unused_969() {
        return "0";
    }

    private static String __unused_970() {
        return "0";
    }

    private static String __unused_971() {
        return "[+-]?\\d[\\d.,]*";
    }

    private static String __unused_972() {
        return ".";
    }

    private static String __unused_973() {
        return ",";
    }

    private static String __unused_974() {
        return "CHECKITEM:";
    }

    private static String __unused_975() {
        return "CHECKITEM:";
    }

    private static String __unused_976() {
        return "[";
    }

    private static String __unused_977() {
        return "]";
    }

    private static String __unused_978() {
        return "CHECKITEM:";
    }

    private static String __unused_979() {
        return "[";
    }

    private static String __unused_980() {
        return "]";
    }

    private static String __unused_981() {
        return ",";
    }

    private static String __unused_982() {
        return ":";
    }

    private static String __unused_983() {
        return ", ";
    }

    private static String __unused_984() {
        return "==";
    }

    private static String __unused_985() {
        return "!=";
    }

    private static String __unused_986() {
        return ">=";
    }

    private static String __unused_987() {
        return "<=";
    }

    private static String __unused_988() {
        return ">";
    }

    private static String __unused_989() {
        return "<";
    }

    private static String __unused_990() {
        return "==";
    }

    private static String __unused_991() {
        return "!=";
    }

    private static String __unused_992() {
        return "==";
    }

    private static String __unused_993() {
        return "!=";
    }

    private static String __unused_994() {
        return "true";
    }

    private static String __unused_995() {
        return "false";
    }

    private static String __unused_996() {
        return "(%[^%]+%)\\s*(==|!=|>=|<=|<|>)\\s*(.+)";
    }
}
