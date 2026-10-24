package me.ulrich.clans.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.function.Consumer;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/Qk09tA47G6CbKTZ.class */
public class Qk09tA47G6CbKTZ {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private aKbPiHspMivN0z046nNK jBUuLP0sWwaPyPOmogdX7l;
    private ClanEnum.ClanStorage ZwrsrwOCXRUscW6Q = ClanEnum.ClanStorage.YAML;
    private String iZTqZaRK5UGoe0Z = NaQsVRMQEPUeGZsHJ9();
    private static volatile String T7FWQkiuEDe83NcR;
    private static String Jg7s7qLpn0pucgkSJ9kQbg;
    private static String jb5r9Y6NnPNlY1qQ52;
    private static String HShTdhSYv9uEaC;
    private static String e21jgfyP878dxWrFG9Ovow;
    private static volatile String cCYUYGo0fjmGaNDb3tb7j;
    private static String MsWKmo0qEqQUA6g5J;
    private static String iPLyadL8ND73kSz;
    private static volatile String hJ0pWBjZcJRh8z8fGR;
    private static volatile String z05J4yL4Kv06qpYWluz5;
    private static String cDhGFDKdpXqq4Y;
    private static String lSjaPdkKod5Zz8T2;
    private static volatile String xrBM8vXNKs0Lti5uS4hp;
    private static volatile String OqtKiPa0RbKl3UnL;
    private static volatile String T4GtRPXJZlS6bbNBaeVn;
    private static String AmYWIJOZbj2hNN;
    private static String ElLAW5qRyoFLeOtuYkir;
    private static String krXuvbJJqmqcWNCPSuVs;
    private static volatile String fVKie6aUNgbcixuGQP28Ny;
    private static volatile String kK00vAdfzObPDcGp;
    private static String WJj6BON44NXEZSV;
    private static volatile String VFeTmqs6JESUVW;
    private static String iR4VHm13x5YPTBvTd;
    private static String OIzN254lA0KhwuaKYE0U6J;
    private static volatile String M29XrshC70MqTiqiFb86;
    private static String bQDFgk7nd7h6QN76w5v;
    private static final byte[] Hb38D2kK7LPLz5L = {(byte) 135, (byte) 64, (byte) 150, (byte) 98, (byte) 181, (byte) 35, (byte) 61, (byte) 63, (byte) 104, (byte) 154, (byte) 32, (byte) 11, (byte) 39, (byte) 225, (byte) 188, (byte) 110, (byte) 167, (byte) 3, (byte) 64, (byte) 197, (byte) 76, (byte) 105, (byte) 73, (byte) 199, (byte) 161, (byte) 146, (byte) 141, (byte) 75, (byte) 218, (byte) 102, (byte) 197, (byte) 145};
    private static final byte[] p60JcGRC3V0KGx = {(byte) 183, (byte) 223, (byte) 114, (byte) 245, (byte) 135, (byte) 181, (byte) 178, (byte) 187, (byte) 234, (byte) 33, (byte) 198, (byte) 58, (byte) 90, (byte) 202, (byte) 203, (byte) 114, (byte) 99, (byte) 70, (byte) 98, (byte) 117, (byte) 32, (byte) 131, (byte) 205, (byte) 250, (byte) 195, (byte) 7, (byte) 242, (byte) 88, (byte) 88, (byte) 166, (byte) 52, (byte) 123};
    private static final byte[] XuheS0GwtEX1rkbJN = {(byte) 221, (byte) 80, (byte) 146, (byte) 154, (byte) 116, (byte) 26, (byte) 245, (byte) 139, (byte) 35, (byte) 28, (byte) 217, (byte) 205, (byte) 223, (byte) 172, (byte) 106, (byte) 156, (byte) 140, (byte) 64, (byte) 20, (byte) 61, (byte) 115, (byte) 253, (byte) 244, (byte) 45, (byte) 232, (byte) 88, (byte) 131, (byte) 186, (byte) 42, (byte) 222, (byte) 233, (byte) 82};
    private static final byte[] Nwhzozne3cW06Rdd24KkBY = {(byte) 118, (byte) 235, (byte) 148, (byte) 50, (byte) 41, (byte) 224, (byte) 42, (byte) 121, (byte) 55, (byte) 88, (byte) 167, (byte) 59, (byte) 248, (byte) 134, (byte) 237, (byte) 61, (byte) 186, (byte) 57, (byte) 93, (byte) 61, (byte) 242, (byte) 150, (byte) 212, (byte) 46, (byte) 174, (byte) 253, (byte) 88, (byte) 170, (byte) 54, (byte) 17, (byte) 252, (byte) 43, (byte) 163, (byte) 111, (byte) 223, (byte) 159, (byte) 153, (byte) 215, (byte) 103, (byte) 123, (byte) 222, (byte) 86, (byte) 146, (byte) 99, (byte) 119, (byte) 31, (byte) 235, (byte) 113, (byte) 184, (byte) 14, (byte) 59, (byte) 154, (byte) 76, (byte) 7, (byte) 118, (byte) 27, (byte) 183, (byte) 176, (byte) 122, (byte) 224, (byte) 230, (byte) 158, (byte) 49, (byte) 53};
    private static final byte[] hOhdo7zC0b8va0Tq = {(byte) 165, (byte) 11, (byte) 236, (byte) 86, (byte) 7, (byte) 188, (byte) 60, (byte) 24, (byte) 50, (byte) 240, (byte) 175, (byte) 227, (byte) 160, (byte) 128, (byte) 242, (byte) 49, (byte) 121, (byte) 107, (byte) 219, (byte) 96, (byte) 132, (byte) 41, (byte) 96, (byte) 223, (byte) 141, (byte) 169, (byte) 1, (byte) 95, (byte) 54, (byte) 165, (byte) 179, (byte) 200};
    private static final byte[] g5cXbaeRGX6f40FqxO = {(byte) 20, (byte) 8, (byte) 166, (byte) 173, (byte) 26, (byte) 52, (byte) 219, (byte) 214, (byte) 110, (byte) 143, (byte) 6, (byte) 44, (byte) 65, (byte) 142, (byte) 26, (byte) 133, (byte) 130, (byte) 253, (byte) 171, (byte) 170, (byte) 51, (byte) 155, (byte) 78, (byte) 39, (byte) 247, (byte) 255, (byte) 59, (byte) 231, (byte) 149, (byte) 28, (byte) 147, (byte) 208, (byte) 5, (byte) 7, (byte) 150, (byte) 37, (byte) 128, (byte) 159, (byte) 122, (byte) 104, (byte) 108, (byte) 93, (byte) 174, (byte) 212, (byte) 105, (byte) 47, (byte) 165, (byte) 148};
    private static final byte[] MssCL5XEvrjDdIhmxY = {(byte) 20, (byte) 8, (byte) 166, (byte) 173, (byte) 26, (byte) 52, (byte) 219, (byte) 214, (byte) 110, (byte) 143, (byte) 6, (byte) 44, (byte) 65, (byte) 142, (byte) 26, (byte) 133, (byte) 142, (byte) 60, (byte) 233, (byte) 174, (byte) 197, (byte) 24, (byte) 149, (byte) 145, (byte) 155, (byte) 209, (byte) 223, (byte) 90, (byte) 209, (byte) 19, (byte) 56, (byte) 254};
    private static final byte[] gyUnAQ7FibWjqEXjayXfhF = {(byte) 184, (byte) 192, (byte) 16, (byte) 7, (byte) 243, (byte) 234, (byte) 222, (byte) 36, (byte) 106, (byte) 25, (byte) 105, (byte) 130, (byte) 182, (byte) 20, (byte) 150, (byte) 111};
    private static final byte[] UMgsHh3NSmOQQoN7f2 = {(byte) 4, (byte) 175, (byte) 223, (byte) 199, (byte) 190, (byte) 217, (byte) 25, (byte) 230, (byte) 124, (byte) 233, (byte) 154, (byte) 11, (byte) 244, (byte) 45, (byte) 146, (byte) 24};
    private static final byte[] AARnKyfxOVLroy = {(byte) 88, (byte) 67, (byte) 116, (byte) 157, (byte) 208, (byte) 170, (byte) 168, (byte) 203, (byte) 34, (byte) 112, (byte) 114, (byte) 153, (byte) 33, (byte) 235, (byte) 31, (byte) 108};
    private static final byte[] DBipw67ZfmwzNns6fZ0Qd = {(byte) 76, (byte) 214, (byte) 134, (byte) 52, (byte) 188, (byte) 15, (byte) 176, (byte) 183, (byte) 181, (byte) 19, (byte) 20, (byte) 177, (byte) 21, (byte) 130, (byte) 162, (byte) 40, (byte) 26, (byte) 139, (byte) 214, (byte) 135, (byte) 111, (byte) 45, (byte) 14, (byte) 150, (byte) 119, (byte) 89, (byte) 72, (byte) 249, (byte) 116, (byte) 93, (byte) 172, (byte) 222};
    private static final byte[] HYzod5lULoMw8OB20M2R = {(byte) 209, (byte) 58, (byte) 84, (byte) 16, (byte) 248, (byte) 56, (byte) 222, (byte) 230, (byte) 147, (byte) 106, (byte) 135, (byte) 5, (byte) 182, (byte) 110, (byte) 129, (byte) 154, (byte) 201, (byte) 191, (byte) 147, (byte) 253, (byte) 222, (byte) 199, (byte) 86, (byte) 113, (byte) 9, (byte) 194, (byte) 135, (byte) 210, (byte) 47, (byte) 110, (byte) 203, (byte) 215};
    private static final byte[] B2jdbjBSSmAsbjHx = {(byte) 107, (byte) 2, (byte) 90, (byte) 116, (byte) 70, (byte) 84, (byte) 114, (byte) 233, (byte) 209, (byte) 7, (byte) 105, (byte) 25, (byte) 99, (byte) 68, (byte) 245, (byte) 100, (byte) 124, (byte) 255, (byte) 5, (byte) 47, (byte) 0, (byte) 129, (byte) 46, (byte) 1, (byte) 65, (byte) 161, (byte) 158, (byte) 161, (byte) 165, (byte) 123, (byte) 174, (byte) 75};
    private static final byte[] KBnO4TKveSS3YT1c9D9f = {(byte) 23, (byte) 188, (byte) 56, (byte) 54, (byte) 254, (byte) 253, (byte) 6, (byte) 71, (byte) 123, (byte) 228, (byte) 128, (byte) 75, (byte) 75, (byte) 68, (byte) 210, (byte) 206};
    private static final byte[] YK3qmhEBILRwbbP0Z3Za = {(byte) 188, (byte) 231, (byte) 16, (byte) 69, (byte) 243, (byte) 63, (byte) 35, (byte) 157, (byte) 95, (byte) 169, (byte) 76, (byte) 125, (byte) 8, (byte) 191, (byte) 11, (byte) 77, (byte) 229, (byte) 181, (byte) 82, (byte) 125, (byte) 217, (byte) 253, (byte) 234, (byte) 40, (byte) 112, (byte) 139, (byte) 218, (byte) 124, (byte) 103, (byte) 237, (byte) 55, (byte) 112};
    private static final byte[] oyYV5xnIaBkZv7c = {(byte) 183, (byte) 6, (byte) 186, (byte) 84, (byte) 240, (byte) 139, (byte) 105, (byte) 10, (byte) 37, (byte) 162, (byte) 54, (byte) 209, (byte) 141, (byte) 117, (byte) 91, (byte) 93};
    private static final byte[] m1roZMS7DyKM8Z = {(byte) 112, (byte) 32, (byte) 226, (byte) 35, (byte) 86, (byte) 112, (byte) 150, (byte) 154, (byte) 11, (byte) 53, (byte) 24, (byte) 235, (byte) 47, (byte) 227, (byte) 74, (byte) 63, (byte) 5, (byte) 9, (byte) 251, (byte) 138, (byte) 38, (byte) 159, (byte) 75, (byte) 199, (byte) 20, (byte) 170, (byte) 119, (byte) 50, (byte) 17, (byte) 172, (byte) 102, (byte) 125};
    private static final byte[] Rd2QX96TISJILDW = {(byte) 178, (byte) 167, (byte) 63, (byte) 239, (byte) 102, (byte) 213, (byte) 253, (byte) 238, (byte) 255, (byte) 230, (byte) 195, (byte) 189, (byte) 194, (byte) 236, (byte) 120, (byte) 19, (byte) 241, (byte) 63, (byte) 205, (byte) 31, (byte) 231, (byte) 34, (byte) 154, (byte) 234, (byte) 60, (byte) 105, (byte) 109, (byte) 251, (byte) 29, (byte) 185, (byte) 144, (byte) 204};
    private static final byte[] mAfhRZ8Cvufd0YKB6P8QC = {(byte) 197, (byte) 203, (byte) 4, (byte) 194, (byte) 43, (byte) 86, (byte) 103, (byte) 220, (byte) 48, (byte) 128, (byte) 97, (byte) 128, (byte) 123, (byte) 12, (byte) 106, (byte) 60};

    public Qk09tA47G6CbKTZ(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        v8qP8fE86HMhvNuYPFjqY();
        zJnaNCVQSgEShq();
    }

    private void zJnaNCVQSgEShq() {
        StringBuilder sb = new StringBuilder();
        sb.append(i9OVRczRu4XYtsb60GLr());
        String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(MUKCVwqA0GntcBqlh());
        ClanEnum.ClanStorage clanStorageValueOf = ClanEnum.ClanStorage.YAML;
        try {
            clanStorageValueOf = ClanEnum.ClanStorage.valueOf(string.toUpperCase());
            this.ZwrsrwOCXRUscW6Q = clanStorageValueOf;
            this.v8qP8fE86HMhvNuYPFjqY.setDatabaseType(clanStorageValueOf);
        } catch (Exception e) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().info(" - Invalid type found in configuration (" + string.toUpperCase() + "), using default...");
        }
        sb.append(clanStorageValueOf.toString() + " ");
        String string2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(DMWyJ2PJD3joJfT2CID());
        String string3 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(SXUdO1ZPsLA0WyL7());
        String string4 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(RHnQ3rHOSj8rtpeW());
        int i = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getInt(NtyLb5XiwgjGdZPzSted4());
        int i2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getInt(tteG7gPJ56Iuf5());
        String string5 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(vsv0Ju8PlfjvBu());
        boolean z = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getBoolean(Vdh9cR4By7CeNkff());
        String string6 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(edb45zOWod9kxhTB());
        String string7 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(yXXMVFM30S2inUH1t13q());
        this.v8qP8fE86HMhvNuYPFjqY.getFiles().iZTqZaRK5UGoe0Z(this.v8qP8fE86HMhvNuYPFjqY.getDataFolder().getAbsolutePath() + "/storage/");
        switch (ua6rk884OvNUdJs7.v8qP8fE86HMhvNuYPFjqY[clanStorageValueOf.ordinal()]) {
            case 1:
                sb.append(rUoC1irq1yZSZJXokanF());
                this.v8qP8fE86HMhvNuYPFjqY.setPluginStorage(ClanEnum.ClanStorage.MYSQL);
                this.jBUuLP0sWwaPyPOmogdX7l = new aKbPiHspMivN0z046nNK(ClanEnum.ClanStorage.MYSQL, string6 + string2 + ":" + i + "/" + string5 + (z ? "?useSSL=" + String.valueOf(z) : ""), string3, string4, i2, this.v8qP8fE86HMhvNuYPFjqY);
                break;
            case 2:
                sb.append(s1lOHGsmiFoAJwpnYq());
                this.v8qP8fE86HMhvNuYPFjqY.setPluginStorage(ClanEnum.ClanStorage.SQLITE);
                String str = this.v8qP8fE86HMhvNuYPFjqY.getDataFolder().getAbsolutePath() + "/storage/sqlite/";
                if (this.v8qP8fE86HMhvNuYPFjqY.getFiles().iZTqZaRK5UGoe0Z(str)) {
                    this.jBUuLP0sWwaPyPOmogdX7l = new aKbPiHspMivN0z046nNK(ClanEnum.ClanStorage.SQLITE, string7 + str + "clans.db", "", "", i2, this.v8qP8fE86HMhvNuYPFjqY);
                }
                break;
            case 3:
                sb.append(y9hQAmqJ7Z4TSszcpaGn());
                this.v8qP8fE86HMhvNuYPFjqY.setPluginStorage(ClanEnum.ClanStorage.YAML);
                break;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getLogger().info(sb.toString());
        v8qP8fE86HMhvNuYPFjqY(jBUuLP0sWwaPyPOmogdX7l() != null ? jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z() : null);
    }

    public void v8qP8fE86HMhvNuYPFjqY(Connection connection) {
        if (!this.ZwrsrwOCXRUscW6Q.equals(ClanEnum.ClanStorage.YAML) && connection == null) {
            return;
        }
        String string = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(s2SaEmqiD9qFvq4W());
        String string2 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(xU3RUMWroV6pXFqE4());
        String string3 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(vfmCrJQNMjk8eSLgV());
        String string4 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(n1Tez72fJg8aYMaHSMJOi());
        String string5 = this.v8qP8fE86HMhvNuYPFjqY.getFiles().VkPRYe34Awk6AdSxoUC().getString(gS27ptCc9mpUb8vs());
        if (!this.ZwrsrwOCXRUscW6Q.equals(ClanEnum.ClanStorage.MYSQL) && !this.ZwrsrwOCXRUscW6Q.equals(ClanEnum.ClanStorage.SQLITE)) {
            if (this.ZwrsrwOCXRUscW6Q.equals(ClanEnum.ClanStorage.YAML)) {
                this.v8qP8fE86HMhvNuYPFjqY.getFiles().ZwrsrwOCXRUscW6Q();
                return;
            }
            return;
        }
        if (!jBUuLP0sWwaPyPOmogdX7l().xtOheRiObl4QeAl()) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().warning(T8DFQq7CTPDuFWE9OMcRS());
            return;
        }
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `" + string + "` ( `id` VARCHAR(36) NOT NULL, `leader` varchar(36) DEFAULT NULL, `members` TEXT, `tag` varchar(255) DEFAULT NULL, `tag_raw` varchar(255) DEFAULT NULL, `desc` varchar(255) DEFAULT NULL, `home` TEXT, `mods` TEXT, `banned` TEXT, `rival` TEXT, `ally` TEXT, `json_meta` TEXT, `banner` TEXT DEFAULT NULL,`locked_pages_chest` TEXT DEFAULT NULL, `creation_date` VARCHAR(11) NOT NULL, `verified` tinyint(1) DEFAULT '0', `kills` int(11) NOT NULL, `deaths` int(11) NOT NULL, `souls` VARCHAR(255) DEFAULT '0', `kdr` float DEFAULT '0', `ff` tinyint(1) DEFAULT '0', `quest_points` int(11) NOT NULL DEFAULT '0', `quest_finished` int(11) NOT NULL DEFAULT '0', `member_joined` int(11) NOT NULL DEFAULT '0', `member_left` int(11) NOT NULL DEFAULT '0', `war_win` int(11) NOT NULL DEFAULT '0', `war_lose` int(11) NOT NULL DEFAULT '0', `glad_win` int(11) NOT NULL DEFAULT '0', `glad_lose` int(11) NOT NULL DEFAULT '0', `league_win` int(11) NOT NULL DEFAULT '0', `league_lose` int(11) NOT NULL DEFAULT '0', `tag_changed` int(11) NOT NULL DEFAULT '0', `member_kicked` int(11) NOT NULL DEFAULT '0', `war_invite` int(11) NOT NULL DEFAULT '1', `ally_shared_chat` int(11) NOT NULL DEFAULT '1', `receive_mail_allies` int(11) NOT NULL DEFAULT '1', `extra_chest` int(11) NOT NULL DEFAULT '0', `join_leave` int(11) NOT NULL DEFAULT '1', `ally_shared_home` int(11) NOT NULL DEFAULT '1', `maxlevel` int(11) NOT NULL DEFAULT '0', `bank` VARCHAR(255) NOT NULL DEFAULT '0', `level` VARCHAR(255) NOT NULL DEFAULT '0', `extra_slots` VARCHAR(11) NOT NULL DEFAULT '0', `public_homes` int(11) NOT NULL DEFAULT '1', `opened` tinyint(1) DEFAULT '0', `patent` varchar(255) DEFAULT NULL, `webhook` varchar(255) DEFAULT NULL, `receive_mail_all` int(11) NOT NULL DEFAULT '1', `allypvp` int(11) NOT NULL DEFAULT '0' , UNIQUE(id), PRIMARY KEY (id) );")) {
            ps.execute();
            ct1kWLSHmXmhxc();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `opened` tinyint(1) DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `banned` TEXT")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `public_homes` int(11) NOT NULL DEFAULT '1'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `patent` varchar(255) DEFAULT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `webhook` varchar(255) DEFAULT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `receive_mail_allies` int(11) NOT NULL DEFAULT '1'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `receive_mail_all` int(11) NOT NULL DEFAULT '1'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `json_meta` TEXT")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `allypvp` int(11) NOT NULL DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `glad_win` int(11) NOT NULL DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `glad_lose` int(11) NOT NULL DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `league_win` int(11) NOT NULL DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` ADD `league_lose` int(11) NOT NULL DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        if (this.ZwrsrwOCXRUscW6Q.equals(ClanEnum.ClanStorage.MYSQL)) {
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string + "` CONVERT TO CHARACTER SET " + string5 + ";")) {
            ps.execute();
        } catch (Throwable ignored) {}
        }
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `" + string2 + "` (`id` VARCHAR(36) NOT NULL, `name` varchar(255) DEFAULT NULL, `uuid` varchar(36) DEFAULT NULL, `clan_id` VARCHAR(36) DEFAULT NULL, `kills` int(11) DEFAULT '0', `deaths` int(11) DEFAULT '0' , `souls` int(11) DEFAULT '0', `kdr` float DEFAULT '0', `join_date` BIGINT(11) DEFAULT NULL, `last_seen` BIGINT(11) DEFAULT NULL, `cache` TEXT DEFAULT NULL, `nickname` VARCHAR(255) DEFAULT NULL, `custom_skin` VARCHAR(255) DEFAULT NULL, `settings.invitations` int(11) DEFAULT '1',`settings.lang` VARCHAR(36) DEFAULT NULL, UNIQUE(id, uuid), PRIMARY KEY (id) );")) {
            ps.execute();
            JFzozkDLNC02oIgufcV();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ADD `nickname` VARCHAR(255) DEFAULT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ADD `custom_skin` VARCHAR(255) DEFAULT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ADD `settings.invitations` int(11) DEFAULT '1'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ADD `settings.clan_role` VARCHAR(255) DEFAULT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ADD `settings.locked_chat` int(11) DEFAULT '0'")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ADD `settings.lang` VARCHAR(255) DEFAULT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` CHANGE `cache` `cache` TEXT NULL")) {
            ps.execute();
        } catch (Throwable ignored) {}
        if (this.ZwrsrwOCXRUscW6Q.equals(ClanEnum.ClanStorage.MYSQL)) {
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` CONVERT TO CHARACTER SET " + string5)) {
            ps.execute();
        } catch (Throwable ignored) {}
        }
        try (PreparedStatement ps = connection.prepareStatement("ALTER TABLE `" + string2 + "` ALTER `cache` TYPE TEXT")) {
            ps.execute();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `" + string3 + "` (`id` VARCHAR(36) NOT NULL, `player` varchar(255) DEFAULT NULL, `inviter` varchar(36) DEFAULT NULL, `clan_id` VARCHAR(36) DEFAULT NULL, `date` BIGINT(11) DEFAULT NULL , UNIQUE(id), PRIMARY KEY (id));")) {
            ps.execute();
            cCCyuxUTsfhbb21erx();
        } catch (Throwable ignored) {}
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `" + string4 + "` (`id` VARCHAR(36) NOT NULL, `value` longtext DEFAULT NULL , UNIQUE(id), PRIMARY KEY (id));")) {
            ps.execute();
            BJ8ARZck23VWaZf874();
        } catch (Throwable ignored) {}
        try { if (connection != null && !connection.isClosed()) connection.close(); } catch (Throwable ignored) {}
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        if (this.jBUuLP0sWwaPyPOmogdX7l != null) {
            this.v8qP8fE86HMhvNuYPFjqY.getLogger().info(N8WxD3tqkixEZB());
            this.jBUuLP0sWwaPyPOmogdX7l.ZwrsrwOCXRUscW6Q();
        }
    }

    public aKbPiHspMivN0z046nNK jBUuLP0sWwaPyPOmogdX7l() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public ClanEnum.ClanStorage ZwrsrwOCXRUscW6Q() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public boolean iZTqZaRK5UGoe0Z() {
        if (ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.YAML)) {
            return true;
        }
        try {
            java.sql.Connection conn = jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            if (conn == null) {
                return false;
            }
            conn.close();
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public String xtOheRiObl4QeAl() {
        return this.iZTqZaRK5UGoe0Z;
    }

    public void v8qP8fE86HMhvNuYPFjqY(String str) {
        this.iZTqZaRK5UGoe0Z = str;
    }

    public void v8qP8fE86HMhvNuYPFjqY(Consumer<ResultSet> consumer, String str) {
        try {
            Connection connectionIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    consumer.accept(preparedStatementPrepareStatement.executeQuery());
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionIZTqZaRK5UGoe0Z != null) {
                    try {
                        connectionIZTqZaRK5UGoe0Z.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jBUuLP0sWwaPyPOmogdX7l(Consumer<ResultSet> consumer, String str) {
        try {
            Connection connectionIZTqZaRK5UGoe0Z = this.v8qP8fE86HMhvNuYPFjqY.getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    consumer.accept(preparedStatementPrepareStatement.executeQuery());
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionIZTqZaRK5UGoe0Z != null) {
                    try {
                        connectionIZTqZaRK5UGoe0Z.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String NaQsVRMQEPUeGZsHJ9() {
        return "success";
    }

    private static String i9OVRczRu4XYtsb60GLr() {
        return "Setup database: ";
    }

    private static String MUKCVwqA0GntcBqlh() {
        return "Storage.type";
    }

    private static String DMWyJ2PJD3joJfT2CID() {
        return "Storage.mysql.host";
    }

    private static String SXUdO1ZPsLA0WyL7() {
        return "Storage.user";
    }

    private static String RHnQ3rHOSj8rtpeW() {
        return "Storage.pass";
    }

    private static String NtyLb5XiwgjGdZPzSted4() {
        return "Storage.mysql.port";
    }

    private static String tteG7gPJ56Iuf5() {
        return "Storage.mysql.maximumPoolSize";
    }

    private static String vsv0Ju8PlfjvBu() {
        return "Storage.mysql.base";
    }

    private static String Vdh9cR4By7CeNkff() {
        return "Storage.mysql.useSSL";
    }

    private static String edb45zOWod9kxhTB() {
        return "Storage.datasource.mysql";
    }

    private static String yXXMVFM30S2inUH1t13q() {
        return "Storage.datasource.sqlite";
    }

    private static String rUoC1irq1yZSZJXokanF() {
        return "(Fast)";
    }

    private static String s1lOHGsmiFoAJwpnYq() {
        return "(Medium)";
    }

    private static String y9hQAmqJ7Z4TSszcpaGn() {
        return "(System - Low)";
    }

    private static String s2SaEmqiD9qFvq4W() {
        return "Storage.databases.clan_table";
    }

    private static String xU3RUMWroV6pXFqE4() {
        return "Storage.databases.player_table";
    }

    private static String vfmCrJQNMjk8eSLgV() {
        return "Storage.databases.invite_table";
    }

    private static String n1Tez72fJg8aYMaHSMJOi() {
        return "Storage.databases.moderation_table";
    }

    private static String gS27ptCc9mpUb8vs() {
        return "Storage.mysql.charset";
    }

    private static String T8DFQq7CTPDuFWE9OMcRS() {
        return "The database is not connected, check the fields...";
    }

    private static String ct1kWLSHmXmhxc() {
        return " - Clan database [OK]";
    }

    private static String JFzozkDLNC02oIgufcV() {
        return " - Player database [OK]";
    }

    private static String cCCyuxUTsfhbb21erx() {
        return " - Invite database [OK]";
    }

    private static String BJ8ARZck23VWaZf874() {
        return " - Moderation database [OK]";
    }

    private static String N8WxD3tqkixEZB() {
        return " - Disconnecting...";
    }
}
