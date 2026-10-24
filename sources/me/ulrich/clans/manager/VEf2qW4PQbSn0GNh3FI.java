package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_sound;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/VEf2qW4PQbSn0GNh3FI.class */
public class VEf2qW4PQbSn0GNh3FI {
    private ConcurrentHashMap<String, CommandData> v8qP8fE86HMhvNuYPFjqY = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CommandData> jBUuLP0sWwaPyPOmogdX7l = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> ZwrsrwOCXRUscW6Q = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> iZTqZaRK5UGoe0Z = new ConcurrentHashMap<>();
    private Clans xtOheRiObl4QeAl;
    private me.ulrich.clans.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL zJnaNCVQSgEShq;
    private me.ulrich.clans.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH CDW4Fj1iwdIXEOqWjiJSR;
    private static volatile String vLWh7lfG0ygeTLjbDokAb;
    private static String QrAzY91bs5eJx67m7;
    private static volatile String lfCrmFlnzqTgqFhS;
    private static String PwgjvdxP7Pq5p6jZH;
    private static volatile String u9IV56VOEcJIT60TIq8Q;
    private static volatile String j33vd4ZijGy7P5KnV0;
    private static String clEaCoLZQEe2adonKvq;
    private static volatile String WJqPkpDU9EtHJ2kfHlyrR;
    private static volatile String rwEtCZLNkZJF1J;
    private static volatile String dZ9Wk7OC1xLzaj;
    private static volatile String Yq68CtKw8ZpevD5cimd;
    private static String khGYRnfN2f4xQOSPslH;
    private static volatile String ms2xHKlhx0Ozfpds;
    private static volatile String qsgQhDf1ROhvTqY;
    private static volatile String nCBO4tWc8PDFXi4HRWK;
    private static volatile String qc0k58lkyIDQitRrEC;
    private static volatile String r1csed904V6LhM0qeArI;
    private static String SVbpQjqKaPaWahI;
    private static volatile String WngBNmOrbdHvAeZs2X;
    private static volatile String oLenUbuZGohz94DKAyyBi;
    private static String PP9mZOyWir7fsGwaIOQ;
    private static volatile String Y2LBxzEjHmzWeV;
    private static volatile String Bo71PlrmBAh2kUGqX;
    private static volatile String K0wiaLSAr5IFdpj1UuLrJ;
    private static String ytVj1yypDHovXJ8B;
    private static volatile String bGOrqh8hvC2BCGh0Yt;
    private static String WHavZmWA86SRRbP;
    private static String iA3Ywgg32WZa22uKx;
    private static volatile String RzfQBl73JnUZ3niYT;
    private static String ot3twvsaRl1RdQGVR;
    private static final byte[] c0IotJtSH36sPRv7JBxO = {(byte) 40, (byte) 34, (byte) 101, (byte) 123, (byte) 167, (byte) 157, (byte) 197, (byte) 116, (byte) 103, (byte) 238, (byte) 64, (byte) 121, (byte) 220, (byte) 222, (byte) 244, (byte) 182};
    private static final byte[] J3xtw40BDEvOlHG = {(byte) 40, (byte) 34, (byte) 101, (byte) 123, (byte) 167, (byte) 157, (byte) 197, (byte) 116, (byte) 103, (byte) 238, (byte) 64, (byte) 121, (byte) 220, (byte) 222, (byte) 244, (byte) 182};
    private static final byte[] mH2rAK2NRaZ05x = {(byte) 40, (byte) 34, (byte) 101, (byte) 123, (byte) 167, (byte) 157, (byte) 197, (byte) 116, (byte) 103, (byte) 238, (byte) 64, (byte) 121, (byte) 220, (byte) 222, (byte) 244, (byte) 182};
    private static final byte[] E2FHJC17wkAmuH6NFmE1 = {(byte) 58, (byte) 26, (byte) 150, (byte) 191, (byte) 72, (byte) 169, (byte) 252, (byte) 170, (byte) 140, (byte) 127, (byte) 194, (byte) 100, (byte) 74, (byte) 207, (byte) 147, (byte) 1, (byte) 150, (byte) 196, (byte) 105, (byte) 71, (byte) 218, (byte) 118, (byte) 48, (byte) 209, (byte) 144, (byte) 18, (byte) 147, (byte) 78, (byte) 71, (byte) 37, (byte) 142, (byte) 41, (byte) 98, (byte) 78, (byte) 16, (byte) 172, (byte) 20, (byte) 226, (byte) 79, (byte) 38, (byte) 65, (byte) 220, (byte) 36, (byte) 114, (byte) 31, (byte) 157, (byte) 46, (byte) 168, (byte) 238, (byte) 158, (byte) 147, (byte) 207, (byte) 15, (byte) 44, (byte) 250, (byte) 2, (byte) 64, (byte) 210, (byte) 119, (byte) 178, (byte) 25, (byte) 167, (byte) 240, (byte) 89};
    private static final byte[] UyhqB1YfyooYET3Zbd = {(byte) 12, (byte) 205, (byte) 159, (byte) 1, (byte) 229, (byte) 158, (byte) 171, (byte) 88, (byte) 228, (byte) 211, (byte) 86, (byte) 69, (byte) 234, (byte) 157, (byte) 58, (byte) 215, (byte) 69, (byte) 77, (byte) 102, (byte) 181, (byte) 110, (byte) 225, (byte) 136, (byte) 77, (byte) 66, (byte) 184, (byte) 114, (byte) 177, (byte) 164, (byte) 23, (byte) 30, (byte) 67, (byte) 163, (byte) 199, (byte) 106, (byte) 197, (byte) 237, (byte) 203, (byte) 116, (byte) 17, (byte) 208, (byte) 197, (byte) 22, (byte) 70, (byte) 91, (byte) 179, (byte) 84, (byte) 235};
    private static final byte[] yPjIs3SJoe7IOqlvDnYRc = {(byte) 182, (byte) 4, (byte) 69, (byte) 191, (byte) 6, (byte) 44, (byte) 17, (byte) 115, (byte) 246, (byte) 84, (byte) 65, (byte) 40, (byte) 6, (byte) 190, (byte) 146, (byte) 71};
    private static final byte[] h2LRypLKCzJ7reUIu3 = {(byte) 182, (byte) 4, (byte) 69, (byte) 191, (byte) 6, (byte) 44, (byte) 17, (byte) 115, (byte) 246, (byte) 84, (byte) 65, (byte) 40, (byte) 6, (byte) 190, (byte) 146, (byte) 71};
    private static final byte[] PTnT3lhYsOSHeLc2CxNjS = {(byte) 40, (byte) 34, (byte) 101, (byte) 123, (byte) 167, (byte) 157, (byte) 197, (byte) 116, (byte) 103, (byte) 238, (byte) 64, (byte) 121, (byte) 220, (byte) 222, (byte) 244, (byte) 182};
    private static final byte[] dbLIO9y9btnhfG = {(byte) 33, (byte) 171, (byte) 248, (byte) 131, (byte) 91, (byte) 22, (byte) 214, (byte) 171, (byte) 73, (byte) 196, (byte) 102, (byte) 230, (byte) 223, (byte) 105, (byte) 179, (byte) 86};
    private static final byte[] efc7oBhPNhT3xDQYjqQ = {(byte) 40, (byte) 34, (byte) 101, (byte) 123, (byte) 167, (byte) 157, (byte) 197, (byte) 116, (byte) 103, (byte) 238, (byte) 64, (byte) 121, (byte) 220, (byte) 222, (byte) 244, (byte) 182};
    private static final byte[] XIVq9m9l78J0jw5ndJ = {(byte) 40, (byte) 34, (byte) 101, (byte) 123, (byte) 167, (byte) 157, (byte) 197, (byte) 116, (byte) 103, (byte) 238, (byte) 64, (byte) 121, (byte) 220, (byte) 222, (byte) 244, (byte) 182};
    private static final byte[] dbhYAsAcnS7dr8Njo7jb4 = {(byte) 33, (byte) 171, (byte) 248, (byte) 131, (byte) 91, (byte) 22, (byte) 214, (byte) 171, (byte) 73, (byte) 196, (byte) 102, (byte) 230, (byte) 223, (byte) 105, (byte) 179, (byte) 86};
    private static final byte[] xZioccU60iNt2OblieP = {(byte) 157, (byte) 145, (byte) 240, (byte) 235, (byte) 36, (byte) 22, (byte) 233, (byte) 163, (byte) 11, (byte) 93, (byte) 66, (byte) 124, (byte) 253, (byte) 99, (byte) 96, (byte) 114, (byte) 42, (byte) 57, (byte) 69, (byte) 150, (byte) 224, (byte) 62, (byte) 217, (byte) 111, (byte) 245, (byte) 201, (byte) 180, (byte) 254, (byte) 223, (byte) 36, (byte) 198, (byte) 50};
    private static final byte[] DruqesCkygkeCYevx8 = {(byte) 220, (byte) 255, (byte) 148, (byte) 28, (byte) 121, (byte) 186, (byte) 102, (byte) 176, (byte) 174, (byte) 134, (byte) 230, (byte) 242, (byte) 103, (byte) 44, (byte) 81, (byte) 160, (byte) 210, (byte) 30, (byte) 93, (byte) 158, (byte) 100, (byte) 3, (byte) 111, (byte) 61, (byte) 178, (byte) 241, (byte) 171, (byte) 187, (byte) 80, (byte) 85, (byte) 250, (byte) 245};
    private static final byte[] z27BLVS50AfsMVQSmguel = {(byte) 63, (byte) 235, (byte) 100, (byte) 68, (byte) 123, (byte) 166, (byte) 129, (byte) 168, (byte) 55, (byte) 64, (byte) 26, (byte) 138, (byte) 117, (byte) 72, (byte) 62, (byte) 85};

    public VEf2qW4PQbSn0GNh3FI(Clans clans) {
        this.xtOheRiObl4QeAl = clans;
        Un3NRLL6aWivTcbodkcK();
        lGGwXL678c4Kv7skJb5NiE();
    }

    private void Un3NRLL6aWivTcbodkcK() {
        Set<String> keys;
        ConfigurationSection configurationSection = this.xtOheRiObl4QeAl.getFiles().Un3NRLL6aWivTcbodkcK().getConfigurationSection(uhjH5QbAWlTHpjXF());
        if (configurationSection == null || (keys = configurationSection.getKeys(false)) == null) {
            return;
        }
        for (String str : keys) {
            p31abtwfBag2jhMH6K().put(str, this.xtOheRiObl4QeAl.getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.command_main." + str));
        }
    }

    private void lGGwXL678c4Kv7skJb5NiE() {
        Set<String> keys;
        ConfigurationSection configurationSection = this.xtOheRiObl4QeAl.getFiles().Un3NRLL6aWivTcbodkcK().getConfigurationSection(VuVpQrV8S6WeqQ());
        if (configurationSection == null || (keys = configurationSection.getKeys(false)) == null) {
            return;
        }
        for (String str : keys) {
            b4i2FbOkaKeg91LiAe6l().put(str, this.xtOheRiObl4QeAl.getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.command_aliases." + str));
        }
    }

    public void v8qP8fE86HMhvNuYPFjqY() {
        jBUuLP0sWwaPyPOmogdX7l();
        this.zJnaNCVQSgEShq = new me.ulrich.clans.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL(this.xtOheRiObl4QeAl);
        this.CDW4Fj1iwdIXEOqWjiJSR = new me.ulrich.clans.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH(this.xtOheRiObl4QeAl);
        if (this.xtOheRiObl4QeAl.getDescription().getCommands().containsKey(CNYnyFyPx5ABPFfoI())) {
            this.xtOheRiObl4QeAl.getCommand(m1AErPuhL8KlWwHa8hPC()).setExecutor(this.zJnaNCVQSgEShq);
        }
        if (this.xtOheRiObl4QeAl.getDescription().getCommands().containsKey(GQHivj1oTdpq75J7())) {
            this.xtOheRiObl4QeAl.getCommand(PTUrYGSWQQUf58BN35N8wJ()).setExecutor(this.CDW4Fj1iwdIXEOqWjiJSR);
        }
        this.xtOheRiObl4QeAl.getCommand(ISjGjduYH2gqKX9dc()).setTabCompleter(new me.ulrich.clans.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx(this.xtOheRiObl4QeAl));
        this.xtOheRiObl4QeAl.getCommand(L7sb1huVxubpeQ7u19wBW()).setTabCompleter(new me.ulrich.clans.DTKXb4fQF6nDgxzg.Ijap9SQKkijXSxP5(this.xtOheRiObl4QeAl));
    }

    public void jBUuLP0sWwaPyPOmogdX7l() {
        try {
            ZwrsrwOCXRUscW6Q().clear();
            iZTqZaRK5UGoe0Z().clear();
        } catch (Exception e) {
        }
        try {
            String strPLM2y7eUjBvKNj = PLM2y7eUjBvKNj();
            for (String str : xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getConfigurationSection("Commands.list." + strPLM2y7eUjBvKNj).getKeys(false)) {
                if (!xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".enabled") || xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getBoolean("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".enabled")) {
                    j1NhA9lhrlY9Vsk9AEeGv();
                    X6JqaXT69vbrs6Pg6C99o();
                    GVye7Cx4Q8fXeCVJ();
                    VhZrQt7bMYVLpZc();
                    try {
                        CommandData_show commandData_show = new CommandData_show(jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_show_on_help"))), jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_show_on_success"))), jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_show_on_error"))), jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_show_on_usage"))));
                        CommandData_actionbar commandData_actionbar = new CommandData_actionbar(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".actionbar.on_help"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".actionbar.on_success"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".actionbar.on_error"));
                        CommandData_title commandData_title = new CommandData_title(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".title.on_help"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".title.on_success"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".title.on_error"));
                        CommandData_sound commandData_sound = new CommandData_sound(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".sound.on_help"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".sound.on_success"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".sound.on_error"));
                        double d = 0.0d;
                        try {
                            if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getDouble("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".value") > 0.0d) {
                                d = xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getDouble("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".value");
                            }
                        } catch (Exception e2) {
                        }
                        HashMap map = new HashMap();
                        try {
                            if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".subcommands")) {
                                xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getStringList("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".subcommands").iterator().forEachRemaining(str2 -> {
                                    String strD3UtSaogKNlRIQF5C1CS = D3UtSaogKNlRIQF5C1CS();
                                    String strKNi0Y6SAC4jqzBu98Bgl8z = kNi0Y6SAC4jqzBu98Bgl8z();
                                    String strWgog2K6bdM6AkISyHp = wgog2K6bdM6AkISyHp();
                                    String strIfIhgZnbkRVUnjQUeRQ = ifIhgZnbkRVUnjQUeRQ();
                                    try {
                                        strD3UtSaogKNlRIQF5C1CS = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_subcommands_" + str2 + "_show_on_help")));
                                        strKNi0Y6SAC4jqzBu98Bgl8z = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_subcommands_" + str2 + "_show_on_usage")));
                                        strWgog2K6bdM6AkISyHp = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_subcommands_" + str2 + "_show_on_error")));
                                        strIfIhgZnbkRVUnjQUeRQ = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strPLM2y7eUjBvKNj + "_" + str + "_subcommands_" + str2 + "_show_on_success")));
                                    } catch (Exception e3) {
                                    }
                                    map.put(str2, new CommandData_show(strD3UtSaogKNlRIQF5C1CS, strIfIhgZnbkRVUnjQUeRQ, strWgog2K6bdM6AkISyHp, strKNi0Y6SAC4jqzBu98Bgl8z));
                                });
                            }
                        } catch (Exception e3) {
                        }
                        CommandData_disable commandData_disable = new CommandData_disable(new ArrayList(), new ArrayList());
                        try {
                            if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".disabled_worlds")) {
                                commandData_disable.setDisabledWorlds(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getStringList("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".disabled_worlds"));
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".disabled_regions")) {
                                commandData_disable.setDisabledRegions(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getStringList("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".disabled_regions"));
                            }
                        } catch (Exception e5) {
                        }
                        ZwrsrwOCXRUscW6Q().put(str, new CommandData(str, xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".permission"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.command_aliases." + str), d, xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getInt("Commands.list." + strPLM2y7eUjBvKNj + "." + str + ".cooldown"), commandData_show, commandData_title, commandData_actionbar, commandData_sound, map, commandData_disable));
                    } catch (Exception e6) {
                    }
                }
            }
        } catch (Exception e7) {
        }
        try {
            String strB4MRXDdL6LI5xR2YdpJdk = b4MRXDdL6LI5xR2YdpJdk();
            for (String str3 : xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getConfigurationSection("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk).getKeys(false)) {
                qDlHNfVQwyDAcEL();
                d8nFa1qGnDuGq23();
                zJH57AOjyx13k8UdfViFT();
                xnv08uOyQds5hFtdSbtU();
                try {
                    CommandData_show commandData_show2 = new CommandData_show(jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_show_on_help"))), jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_show_on_success"))), jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_show_on_error"))), jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_show_on_usage"))));
                    CommandData_actionbar commandData_actionbar2 = new CommandData_actionbar(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".actionbar.on_help"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".actionbar.on_success"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".actionbar.on_error"));
                    CommandData_title commandData_title2 = new CommandData_title(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".title.on_help"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".title.on_success"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".title.on_error"));
                    CommandData_sound commandData_sound2 = new CommandData_sound(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".sound.on_help"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".sound.on_success"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".sound.on_error"));
                    double d2 = 0.0d;
                    try {
                        if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getDouble("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".value") > 0.0d) {
                            d2 = xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getDouble("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".value");
                        }
                    } catch (Exception e8) {
                    }
                    HashMap map2 = new HashMap();
                    try {
                        if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".subcommands")) {
                            xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getStringList("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".subcommands").iterator().forEachRemaining(str4 -> {
                                String strBODdsAXJ7b8NyN0 = bODdsAXJ7b8NyN0();
                                String strLj8IvPqqNpcCKxmd9BQ8r = Lj8IvPqqNpcCKxmd9BQ8r();
                                String strUqXsv0RPqJThhY = uqXsv0RPqJThhY();
                                String strC8GIkQU5HLjCRR5H = c8GIkQU5HLjCRR5H();
                                try {
                                    strBODdsAXJ7b8NyN0 = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_subcommands_" + str4 + "_show_on_help")));
                                    strLj8IvPqqNpcCKxmd9BQ8r = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_subcommands_" + str4 + "_show_on_usage")));
                                    strUqXsv0RPqJThhY = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_subcommands_" + str4 + "_show_on_error")));
                                    strC8GIkQU5HLjCRR5H = jBUuLP0sWwaPyPOmogdX7l(xtOheRiObl4QeAl().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.empty()).getString(Lang.valueOf("COMMANDS_" + strB4MRXDdL6LI5xR2YdpJdk + "_" + str3 + "_subcommands_" + str4 + "_show_on_success")));
                                } catch (Exception e9) {
                                }
                                map2.put(str4, new CommandData_show(strBODdsAXJ7b8NyN0, strC8GIkQU5HLjCRR5H, strUqXsv0RPqJThhY, strLj8IvPqqNpcCKxmd9BQ8r));
                            });
                        }
                    } catch (Exception e9) {
                    }
                    CommandData_disable commandData_disable2 = new CommandData_disable(new ArrayList(), new ArrayList());
                    try {
                        if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".disabled_worlds")) {
                            commandData_disable2.setDisabledWorlds(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getStringList("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".disabled_worlds"));
                        }
                    } catch (Exception e10) {
                    }
                    try {
                        if (xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().contains("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".disabled_regions")) {
                            commandData_disable2.setDisabledRegions(xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getStringList("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".disabled_regions"));
                        }
                    } catch (Exception e11) {
                    }
                    iZTqZaRK5UGoe0Z().put(str3, new CommandData(str3, xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".permission"), xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getString("Commands.command_aliases." + str3), d2, xtOheRiObl4QeAl().getFiles().Un3NRLL6aWivTcbodkcK().getInt("Commands.list." + strB4MRXDdL6LI5xR2YdpJdk + "." + str3 + ".cooldown"), commandData_show2, commandData_title2, commandData_actionbar2, commandData_sound2, map2, commandData_disable2));
                } catch (Exception e12) {
                }
            }
        } catch (Exception e13) {
        }
    }

    public String v8qP8fE86HMhvNuYPFjqY(String str) {
        Matcher matcher = Pattern.compile(cQerKADqeSUokuWWCTf8T8()).matcher(str);
        while (matcher.find()) {
            String strIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(matcher.group(1));
            if (strIZTqZaRK5UGoe0Z != null) {
                str = str.replace(matcher.group(0), strIZTqZaRK5UGoe0Z);
            }
        }
        return str;
    }

    public String jBUuLP0sWwaPyPOmogdX7l(String str) {
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(str);
        Matcher matcher = Pattern.compile(Lx7EdTbYxZOG2LfoDHIMz8()).matcher(strV8qP8fE86HMhvNuYPFjqY);
        while (matcher.find()) {
            String strZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(matcher.group(1));
            if (strZwrsrwOCXRUscW6Q != null) {
                strV8qP8fE86HMhvNuYPFjqY = strV8qP8fE86HMhvNuYPFjqY.replace(matcher.group(0), strZwrsrwOCXRUscW6Q);
            }
        }
        return strV8qP8fE86HMhvNuYPFjqY;
    }

    public void v8qP8fE86HMhvNuYPFjqY(CommandSender commandSender, CommandData commandData) {
        HashMap<String, CommandData_show> subcommands = commandData.getSubcommands();
        if (subcommands.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            subcommands.entrySet().iterator().forEachRemaining(entry -> {
                arrayList.add((String) entry.getKey());
            });
            if (this.xtOheRiObl4QeAl.getFiles().p31abtwfBag2jhMH6K().getBoolean(ZfvoXaMKuct7jGYgvYTNrv())) {
                Collections.sort(arrayList);
            }
            arrayList.iterator().forEachRemaining(str -> {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str, ClanEnum.MsgUsage.help, null);
            });
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        return b4i2FbOkaKeg91LiAe6l().containsKey(str) && b4i2FbOkaKeg91LiAe6l().get(str).equalsIgnoreCase(str2);
    }

    public String ZwrsrwOCXRUscW6Q(String str) {
        if (b4i2FbOkaKeg91LiAe6l().containsKey(str)) {
            return b4i2FbOkaKeg91LiAe6l().get(str);
        }
        return null;
    }

    public String iZTqZaRK5UGoe0Z(String str) {
        if (p31abtwfBag2jhMH6K().containsKey(str)) {
            return p31abtwfBag2jhMH6K().get(str);
        }
        return null;
    }

    public String xtOheRiObl4QeAl(String str) {
        try {
            for (Map.Entry<String, String> entry : b4i2FbOkaKeg91LiAe6l().entrySet()) {
                if (entry.getValue().equalsIgnoreCase(str)) {
                    return entry.getKey();
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public ConcurrentHashMap<String, CommandData> ZwrsrwOCXRUscW6Q() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public ConcurrentHashMap<String, CommandData> iZTqZaRK5UGoe0Z() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public Clans xtOheRiObl4QeAl() {
        return this.xtOheRiObl4QeAl;
    }

    public me.ulrich.clans.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL zJnaNCVQSgEShq() {
        return this.zJnaNCVQSgEShq;
    }

    public me.ulrich.clans.DTKXb4fQF6nDgxzg.UsEbiuprSHpNw3qjITfH CDW4Fj1iwdIXEOqWjiJSR() {
        return this.CDW4Fj1iwdIXEOqWjiJSR;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, CommandData commandData, boolean z) {
        if (commandData.getDisable() == null) {
            return true;
        }
        if (commandData.getDisable().getDisabledWorlds() != null && commandData.getDisable().getDisabledWorlds().size() > 0 && commandData.getDisable().getDisabledWorlds().contains(player.getWorld().getName())) {
            if (!z) {
                return false;
            }
            MessageUtils.sendText((CommandSender) player, this.xtOheRiObl4QeAl.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.DISABLED_WORLD_COMMAND));
            return false;
        }
        if (commandData.getDisable().getDisabledRegions() == null) {
            return true;
        }
        List<String> disabledRegions = commandData.getDisable().getDisabledRegions();
        if (player.hasPermission(this.xtOheRiObl4QeAl.getFiles().p31abtwfBag2jhMH6K().getString(Pmk7RnluOesdlu()))) {
            return true;
        }
        Optional<RegionImplement> optionalHX3ZfRb1nSpNq57s7x5ui = this.xtOheRiObl4QeAl.getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
        if (!optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() || !optionalHX3ZfRb1nSpNq57s7x5ui.get().playerHasRegionList(player, disabledRegions)) {
            return true;
        }
        MessageUtils.sendText((CommandSender) player, this.xtOheRiObl4QeAl.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.DISABLED_REGION_COMMAND));
        return true;
    }

    public ConcurrentHashMap<String, String> b4i2FbOkaKeg91LiAe6l() {
        return this.ZwrsrwOCXRUscW6Q;
    }

    public ConcurrentHashMap<String, String> p31abtwfBag2jhMH6K() {
        return this.iZTqZaRK5UGoe0Z;
    }

    private static String uhjH5QbAWlTHpjXF() {
        return "Commands.command_main";
    }

    private static String VuVpQrV8S6WeqQ() {
        return "Commands.command_aliases";
    }

    private static String CNYnyFyPx5ABPFfoI() {
        return "uclan";
    }

    private static String m1AErPuhL8KlWwHa8hPC() {
        return "uclan";
    }

    private static String GQHivj1oTdpq75J7() {
        return "clan";
    }

    private static String PTUrYGSWQQUf58BN35N8wJ() {
        return "clan";
    }

    private static String ISjGjduYH2gqKX9dc() {
        return "uclan";
    }

    private static String L7sb1huVxubpeQ7u19wBW() {
        return "clan";
    }

    private static String PLM2y7eUjBvKNj() {
        return "clan";
    }

    private static String j1NhA9lhrlY9Vsk9AEeGv() {
        return "Empty";
    }

    private static String X6JqaXT69vbrs6Pg6C99o() {
        return "Empty";
    }

    private static String GVye7Cx4Q8fXeCVJ() {
        return "Empty";
    }

    private static String VhZrQt7bMYVLpZc() {
        return "Empty";
    }

    private static String b4MRXDdL6LI5xR2YdpJdk() {
        return "uclan";
    }

    private static String qDlHNfVQwyDAcEL() {
        return "Empty";
    }

    private static String d8nFa1qGnDuGq23() {
        return "Empty";
    }

    private static String zJH57AOjyx13k8UdfViFT() {
        return "Empty";
    }

    private static String xnv08uOyQds5hFtdSbtU() {
        return "Empty";
    }

    private static String cQerKADqeSUokuWWCTf8T8() {
        return "\\{_([^}]*)\\}";
    }

    private static String Lx7EdTbYxZOG2LfoDHIMz8() {
        return "\\{_([^}]*)\\}";
    }

    private static String ZfvoXaMKuct7jGYgvYTNrv() {
        return "Config.command.sort_alphabetically";
    }

    private static String Pmk7RnluOesdlu() {
        return "Config.special_permissions.bypass_command_regions";
    }

    private static String bODdsAXJ7b8NyN0() {
        return "Empty";
    }

    private static String Lj8IvPqqNpcCKxmd9BQ8r() {
        return "Empty";
    }

    private static String uqXsv0RPqJThhY() {
        return "Empty";
    }

    private static String c8GIkQU5HLjCRR5H() {
        return "Empty";
    }

    private static String D3UtSaogKNlRIQF5C1CS() {
        return "Empty";
    }

    private static String kNi0Y6SAC4jqzBu98Bgl8z() {
        return "Empty";
    }

    private static String wgog2K6bdM6AkISyHp() {
        return "Empty";
    }

    private static String ifIhgZnbkRVUnjQUeRQ() {
        return "Empty";
    }
}
