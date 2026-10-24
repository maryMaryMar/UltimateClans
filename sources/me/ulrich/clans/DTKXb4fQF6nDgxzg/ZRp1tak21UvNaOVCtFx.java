package me.ulrich.clans.DTKXb4fQF6nDgxzg;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx implements TabCompleter {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static String Cuh2UGrZmxPsdI;
    private static String zAu6gl0e6YSXUTr7OrEktj;
    private static String NrT9IEbck20B8cS1;
    private static volatile String iIa8FXFcvOjXl5sqcX;
    private static String dHjRZrlCmfa32FUPSzdj9U;
    private static String MV6Sajxo1DA99XCWT;
    private static String k7yPknozNeQIXzvn;
    private static String htbznyZyLSa3lj;
    private static volatile String SNqaPn9XqaUrgw;
    private static String ksitHfpbOpuFgUHBoTHo;
    private static String f70ozTbYkZgSYg48evrVCI;
    private static String ampTUIt8sqRt1c5ydvi;
    private static String H9HLq8oq5YKTCB;
    private static volatile String gVsvNIgKH50OoUG;
    private static volatile String JkTfaJ8tWL5R2V4gN;
    private static String Tfhnogeo2KUHbgtYPKyIKF;
    private static String q5P2fKrHTE8uz3GtYjpI7;
    private static String qBmqyavHyvNT0h8;
    private static String NDADaOCzHAygO3xji15Ub;
    private static String MMqekDoIHYYMD4LTvf;
    private static String uRh7teYDgi79trHb1i;
    private static volatile String Gu8ox2SJvDFbS8i8Dfcg;
    private static String wkLbyX13ZhUDl3;
    private static volatile String gpG5UyoJjdw1YPUc6;
    private static volatile String Ea4x0uuUp4iS2Hl4;
    private static String pwRDqJqabw76nmuorM3;
    private static volatile String m26EfOd2vf8VLKBdttVlE;
    private static String aoEAtocnPxoGCXPe;
    private static volatile String XVcVFewQDRNc3EIfrRUP;
    private static String jJnjn9GDEAVDNvtSjAyzJQ;
    private static volatile String sh4w9LCSusTVZY;
    private static String r3hNkgYUyl3rAoJZ;
    private static volatile String oaftvxdKLCzXpdgmnRu7;
    private static String iumVSC4TUKKe9EU;
    private static volatile String LN1MC5SWYwVc9s;
    private static String JUjaiGadefJFRh8eNI;
    private static volatile String Yp1IzcNd8gAObx;
    private static volatile String AEqPSYDxbINGVccHYCO;
    private static volatile String oHBrHJvQYyWdQzuz6kkPYw;
    private static volatile String vwtr5ZyGncSae8WxetyOZD;
    private static String tfA2kpqvYJAvuKs5k2d;
    private static volatile String EDkObPlQKEkLNAR5sLO;
    private static volatile String dQlZROustVTOw5tIr;
    private static String AjbMT6fZUKwAEaJA7;
    private static String L8gRRAijGKKlzCu8n5s2;
    private static String uGfowWYoWBKBzk4xZ7AD;
    private static final byte[] LQe90RO7g9DCnNIc = {(byte) 10, (byte) 52, (byte) 220, (byte) 235, (byte) 208, (byte) 182, (byte) 91, (byte) 57, (byte) 140, (byte) 176, (byte) 30, (byte) 51, (byte) 224, (byte) 141, (byte) 127, (byte) 181};
    private static final byte[] ELfOYNq5KpRLJtCJDX = {(byte) 64, (byte) 19, (byte) 176, (byte) 182, (byte) 145, (byte) 220, (byte) 91, (byte) 51, (byte) 229, (byte) 12, (byte) 118, (byte) 86, (byte) 139, (byte) 126, (byte) 17, (byte) 139};
    private static final byte[] S3dwSXwNrL2gAGA7IbcINa = {(byte) 230, (byte) 208, (byte) 60, (byte) 203, (byte) 49, (byte) 111, (byte) 2, (byte) 69, (byte) 206, (byte) 104, (byte) 82, (byte) 121, (byte) 130, (byte) 118, (byte) 125, (byte) 12};
    private static final byte[] f2dxtQyro6rmhF3l = {(byte) 172, (byte) 4, (byte) 233, (byte) 105, (byte) 142, (byte) 111, (byte) 101, (byte) 194, (byte) 243, (byte) 193, (byte) 148, (byte) 76, (byte) 248, (byte) 4, (byte) 221, (byte) 129};
    private static final byte[] Q1Akyi222zCd6Kv0zSc6Le = {(byte) 150, (byte) 247, (byte) 129, (byte) 4, (byte) 102, (byte) 85, (byte) 241, (byte) 150, (byte) 93, (byte) 71, (byte) 177, (byte) 176, (byte) 255, (byte) 129, (byte) 212, (byte) 145};
    private static final byte[] D0QXfUY1lgXGXfLCIBRs = {(byte) 232, (byte) 48, (byte) 211, (byte) 90, (byte) 137, (byte) 185, (byte) 56, (byte) 63, (byte) 8, (byte) 56, (byte) 178, (byte) 140, (byte) 210, (byte) 148, (byte) 212, (byte) 169};
    private static final byte[] rV7xl7jJ1asqefYzlWQY = {(byte) 212, (byte) 237, (byte) 219, (byte) 152, (byte) 191, (byte) 60, (byte) 126, (byte) 22, (byte) 105, (byte) 249, (byte) 227, (byte) 11, (byte) 146, (byte) 48, (byte) 120, (byte) 124};
    private static final byte[] Q3jCuoenutcQ5gG4 = {(byte) 250, (byte) 164, (byte) 221, (byte) 96, (byte) 9, (byte) 129, (byte) 230, (byte) 217, (byte) 177, (byte) 36, (byte) 181, (byte) 251, (byte) 231, (byte) 192, (byte) 87, (byte) 100};
    private static final byte[] kURBIeDRUbd6aZA2qUBN = {(byte) 106, (byte) 150, (byte) 71, (byte) 176, (byte) 221, (byte) 166, (byte) 99, (byte) 2, (byte) 233, (byte) 77, (byte) 220, (byte) 242, (byte) 141, (byte) 221, (byte) 127, (byte) 47};
    private static final byte[] mRRVN5erDzKLHUc = {(byte) 190, (byte) 4, (byte) 70, (byte) 92, (byte) 21, (byte) 110, (byte) 227, (byte) 40, (byte) 140, (byte) 48, (byte) 114, (byte) 217, (byte) 241, (byte) 179, (byte) 179, (byte) 147};
    private static final byte[] Ry5EnF1KI5Ee59z9uPZ41a = {(byte) 213, (byte) 215, (byte) 106, (byte) 118, (byte) 142, (byte) 60, (byte) 39, (byte) 240, (byte) 66, (byte) 214, (byte) 241, (byte) 128, (byte) 179, (byte) 54, (byte) 154, (byte) 90};
    private static final byte[] sy6xUrY5PC2Kv4KZIIGJpI = {(byte) 200, (byte) 38, (byte) 99, (byte) 190, (byte) 59, (byte) 65, (byte) 120, (byte) 11, (byte) 57, (byte) 87, (byte) 8, (byte) 170, (byte) 184, (byte) 79, (byte) 59, (byte) 23};
    private static final byte[] sEvvQir0EyMyT3hKVjY0v1 = {(byte) 14, (byte) 87, (byte) 194, (byte) 246, (byte) 52, (byte) 98, (byte) 47, (byte) 123, (byte) 219, (byte) 160, (byte) 136, (byte) 199, (byte) 115, (byte) 4, (byte) 45, (byte) 23};
    private static final byte[] isRnYyegzGGd9wqR87YT = {(byte) 213, (byte) 215, (byte) 106, (byte) 118, (byte) 142, (byte) 60, (byte) 39, (byte) 240, (byte) 66, (byte) 214, (byte) 241, (byte) 128, (byte) 179, (byte) 54, (byte) 154, (byte) 90};
    private static final byte[] TF537xR0fMWGCP38Dtyq = {(byte) 240, (byte) 203, (byte) 220, (byte) 38, (byte) 23, (byte) 232, (byte) 25, (byte) 148, (byte) 79, (byte) 50, (byte) 102, (byte) 228, (byte) 184, (byte) 245, (byte) 22, (byte) 199};
    private static final byte[] Sdjpc6mDTm1muqw7ALskr = {(byte) 17, (byte) 160, (byte) 58, (byte) 67, (byte) 140, (byte) 225, (byte) 184, (byte) 82, (byte) 230, (byte) 45, (byte) 167, (byte) 199, (byte) 103, (byte) 186, (byte) 138, (byte) 245};
    private static final byte[] TgtuIBqOfUkgIduKbdb = {(byte) 71, (byte) 183, (byte) 108, (byte) 182, (byte) 32, (byte) 119, (byte) 206, (byte) 127, (byte) 230, (byte) 57, (byte) 139, (byte) 139, (byte) 65, (byte) 224, (byte) 32, (byte) 97};
    private static final byte[] bDhSBJ5ajgAHI2Zia0B = {(byte) 172, (byte) 4, (byte) 233, (byte) 105, (byte) 142, (byte) 111, (byte) 101, (byte) 194, (byte) 243, (byte) 193, (byte) 148, (byte) 76, (byte) 248, (byte) 4, (byte) 221, (byte) 129};
    private static final byte[] IJn6VBQ3GOddgNE = {(byte) 190, (byte) 4, (byte) 70, (byte) 92, (byte) 21, (byte) 110, (byte) 227, (byte) 40, (byte) 140, (byte) 48, (byte) 114, (byte) 217, (byte) 241, (byte) 179, (byte) 179, (byte) 147};
    private static final byte[] aPZvwD49fRMI40kTnL = {(byte) 200, (byte) 162, (byte) 194, (byte) 27, (byte) 153, (byte) 109, (byte) 105, (byte) 8, (byte) 24, (byte) 127, (byte) 157, (byte) 43, (byte) 71, (byte) 164, (byte) 80, (byte) 186};
    private static final byte[] LN7ICWkX8hJZFgrs = {(byte) 11, (byte) 44, (byte) 36, (byte) 143, (byte) 160, (byte) 104, (byte) 109, (byte) 14, (byte) 50, (byte) 31, (byte) 254, (byte) 197, (byte) 81, (byte) 97, (byte) 51, (byte) 143};
    private static final byte[] uXxuKnF7kyThpGzhnFY1 = {(byte) 17, (byte) 46, (byte) 64, (byte) 164, (byte) 84, (byte) 87, (byte) 167, (byte) 232, (byte) 161, (byte) 159, (byte) 74, (byte) 212, (byte) 137, (byte) 217, (byte) 189, (byte) 238, (byte) 155, (byte) 149, (byte) 24, (byte) 9, (byte) 224, (byte) 249, (byte) 115, (byte) 204, (byte) 86, (byte) 112, (byte) 107, (byte) 64, (byte) 167, (byte) 210, (byte) 213, (byte) 123};
    private static final byte[] WMyuIXL7vHNtc7PwwEtBu = {(byte) 15, (byte) 111, (byte) 178, (byte) 22, (byte) 8, (byte) 234, (byte) 186, (byte) 108, (byte) 85, (byte) 110, (byte) 180, (byte) 88, (byte) 197, (byte) 26, (byte) 51, (byte) 65};

    public ZRp1tak21UvNaOVCtFx(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (strArr.length == 1) {
            try {
                for (Map.Entry<String, CommandData> entry : v8qP8fE86HMhvNuYPFjqY().getCommandManager().iZTqZaRK5UGoe0Z().entrySet()) {
                    if ((!entry.getValue().getPermission().isEmpty() && commandSender.hasPermission(entry.getValue().getPermission())) || entry.getValue().getPermission().isEmpty()) {
                        arrayList.add(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q(entry.getValue().getId()));
                    }
                }
                return (List) arrayList.stream().filter(str2 -> {
                    return str2 != null && str2.startsWith(strArr[0]);
                }).collect(Collectors.toList());
            } catch (Exception e) {
                return arrayList;
            }
        }
        if (strArr.length == 2) {
            if (strArr[0] != null && !strArr[0].isEmpty()) {
                String strXtOheRiObl4QeAl = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[0]);
                if (strXtOheRiObl4QeAl != null && this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(strXtOheRiObl4QeAl)) {
                    CommandData commandData = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().iZTqZaRK5UGoe0Z().get(strXtOheRiObl4QeAl);
                    Iterator<Map.Entry<String, CommandData_show>> it = commandData.getSubcommands().entrySet().iterator();
                    if (commandData.getSubcommands().size() > 0) {
                        while (it.hasNext()) {
                            arrayList2.add(this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q(it.next().getKey()));
                        }
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(vnCtP2B8ymONwjzw()) || strXtOheRiObl4QeAl.equalsIgnoreCase(nVYOTLiRf2ceDUZ()) || strXtOheRiObl4QeAl.equalsIgnoreCase(bdYhe66dO9lSJQPMqL()) || strXtOheRiObl4QeAl.equalsIgnoreCase(fPmyuYJiMBq3iQAYikIS()) || strXtOheRiObl4QeAl.equalsIgnoreCase(CtCqBkDGyl2RUAoDtpkl9()) || strXtOheRiObl4QeAl.equalsIgnoreCase(F4cmBh6L7pll3WeARAT()) || strXtOheRiObl4QeAl.equalsIgnoreCase(Xkw3M1wERcgFgmtqMDu()) || strXtOheRiObl4QeAl.equalsIgnoreCase(fH5eqGfsfqCpKXcCRLG()) || strXtOheRiObl4QeAl.equalsIgnoreCase(jymmnWCGIp8LyNFizqefZr()) || strXtOheRiObl4QeAl.equalsIgnoreCase(BZFLFwiH9umvDkoZ()) || strXtOheRiObl4QeAl.equalsIgnoreCase(yeC8gnl262qO4i7()) || strXtOheRiObl4QeAl.equalsIgnoreCase(j8JyOTvCPa6iMp())) {
                        this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator().forEachRemaining(clanData -> {
                            arrayList2.add(clanData.getTagNoColor());
                        });
                    } else if (strXtOheRiObl4QeAl.equalsIgnoreCase(L8UV2nIaIj5rti3BY8U()) || strXtOheRiObl4QeAl.equalsIgnoreCase(HYshVYhWtjChi3E())) {
                        Bukkit.getOnlinePlayers().stream().filter(player -> {
                            return this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId());
                        }).iterator().forEachRemaining(player2 -> {
                            arrayList2.add(player2.getName());
                        });
                    }
                }
                return (List) arrayList2.stream().filter(str3 -> {
                    return str3.toLowerCase().startsWith(strArr[1].toLowerCase());
                }).collect(Collectors.toList());
            }
        } else if (strArr.length == 3 && strArr[0] != null && !strArr[0].isEmpty()) {
            String strXtOheRiObl4QeAl2 = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().xtOheRiObl4QeAl(strArr[0]);
            if (strXtOheRiObl4QeAl2 != null && this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(strXtOheRiObl4QeAl2)) {
                if (strXtOheRiObl4QeAl2.equalsIgnoreCase(JzrB4xiFHPKAQpBW())) {
                    this.v8qP8fE86HMhvNuYPFjqY.getClanManager().CDW4Fj1iwdIXEOqWjiJSR().values().iterator().forEachRemaining(clanData2 -> {
                        arrayList3.add(clanData2.getTagNoColor());
                    });
                } else if (strXtOheRiObl4QeAl2.equals(AhFey7f2BHL4vzi7cZVCrH()) && strArr[1].equals(uwcn55vnkmurUU2EteTQl())) {
                    Arrays.asList(ClanEnum.ClansModules.values()).iterator().forEachRemaining(clansModules -> {
                        arrayList3.add(clansModules.toString());
                    });
                } else if (strXtOheRiObl4QeAl2.equals(PR1fB38geXOLTnBWyd()) && strArr[1].equals(E4s5RCxmdUZ2Y5vIiF5wCw())) {
                    this.v8qP8fE86HMhvNuYPFjqY.getModuleEnabledList().entrySet().iterator().forEachRemaining(entry2 -> {
                        arrayList3.add(((Module) entry2.getKey()).getName());
                    });
                } else if (strXtOheRiObl4QeAl2.equals(BMJwr487ayMOWJcUttN()) && strArr[1].equals(L2RUAYVhht2jslyktv())) {
                    this.v8qP8fE86HMhvNuYPFjqY.getModuleEnabledList().entrySet().iterator().forEachRemaining(entry3 -> {
                        arrayList3.add(((Module) entry3.getKey()).getName());
                    });
                } else if (strXtOheRiObl4QeAl2.equals(gf0QJjAiksQUPgx()) && strArr[1].equals(Fu58AhEBur2bPwDY0dLsg())) {
                    Arrays.asList(ClanEnum.ClansExtensions.values()).iterator().forEachRemaining(clansExtensions -> {
                        arrayList3.add(clansExtensions.toString());
                    });
                } else if (strXtOheRiObl4QeAl2.equals(c4mtoIPHGYeR1SQ2bkj()) && strArr[1].equals(FhGW1O5PirpDenNre())) {
                    this.v8qP8fE86HMhvNuYPFjqY.getExtensionEnabledList().entrySet().iterator().forEachRemaining(entry4 -> {
                        arrayList3.add(((Extension) entry4.getKey()).getName());
                    });
                } else if (strXtOheRiObl4QeAl2.equals(BygfY9A8xbn8eXt()) && strArr[1].equals(M8vpC2fbl0EcSzVlAFu9())) {
                    this.v8qP8fE86HMhvNuYPFjqY.getExtensionEnabledList().entrySet().iterator().forEachRemaining(entry5 -> {
                        arrayList3.add(((Extension) entry5.getKey()).getName());
                    });
                } else if (!strXtOheRiObl4QeAl2.equalsIgnoreCase(szxIbGsdEJhLAe59UO2()) && !strXtOheRiObl4QeAl2.equalsIgnoreCase(BHD4dGKUE9TudA6())) {
                    if (strXtOheRiObl4QeAl2.equalsIgnoreCase(Gtt1G11a8rSoJhKcjJr5dq())) {
                        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
                        ArrayList<Player> arrayList4 = new ArrayList<>();
                        arrayList4.addAll(onlinePlayers);
                        ((List<Player>) arrayList4.stream().filter(player3 -> {
                            return !this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().vVo2VUvxrriklPdRxI(player3.getUniqueId());
                        }).collect(Collectors.toList())).iterator().forEachRemaining(player4 -> {
                            arrayList3.add(player4.getName());
                        });
                    } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(DfS5W5lMg6cfcFij())) {
                        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strArr[1]);
                        if (optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
                            optionalJBUuLP0sWwaPyPOmogdX7l.get().getMembers().iterator().forEachRemaining(uuid -> {
                                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().p31abtwfBag2jhMH6K(uuid);
                                if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                                    arrayList3.add(optionalP31abtwfBag2jhMH6K.get().getName());
                                }
                            });
                        }
                    } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(NM2VohaaOwxgqxaRb4StNU())) {
                        arrayList3.add(gZVebMgwK78dEpS8WCluB());
                        arrayList3.add(lcPogkFk1MeaRysu());
                        arrayList3.add(oJ08A2csSsPEcT2II46F());
                    } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(MuRsSbm2ULUxKpKTwdEGsl())) {
                        arrayList3.addAll(Arrays.asList(p7R45Vtj05BMr8R(), OAe9udvmwgmNoUGvu(), TUMPEa0VVicnXZU3xc(), jMBZdkwwB384eIuof()));
                    } else if (strXtOheRiObl4QeAl2.equalsIgnoreCase(ieGaNcNOEO9MNLZb()) || strXtOheRiObl4QeAl2.equalsIgnoreCase(L9yqCyWDvEJacgERrE()) || strXtOheRiObl4QeAl2.equalsIgnoreCase(dYLuMU0k44NimVuK())) {
                        arrayList3.addAll(Arrays.asList(aI9dLXupL3aq4lGn9SG9e(), ZQEVfag3uIwOv9H0(), aFjWDT7L3VcOPhwOGvzc()));
                    }
                }
            }
            return (List) arrayList3.stream().filter(str4 -> {
                return str4.toLowerCase().startsWith(strArr[2].toLowerCase());
            }).collect(Collectors.toList());
        }
        return arrayList;
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String vnCtP2B8ymONwjzw() {
        return "setleader";
    }

    private static String nVYOTLiRf2ceDUZ() {
        return "kick";
    }

    private static String bdYhe66dO9lSJQPMqL() {
        return "setpoints";
    }

    private static String fPmyuYJiMBq3iQAYikIS() {
        return "addpoints";
    }

    private static String CtCqBkDGyl2RUAoDtpkl9() {
        return "removepoints";
    }

    private static String F4cmBh6L7pll3WeARAT() {
        return "setslot";
    }

    private static String Xkw3M1wERcgFgmtqMDu() {
        return "addslot";
    }

    private static String fH5eqGfsfqCpKXcCRLG() {
        return "removeslot";
    }

    private static String jymmnWCGIp8LyNFizqefZr() {
        return "changetag";
    }

    private static String BZFLFwiH9umvDkoZ() {
        return "delete";
    }

    private static String yeC8gnl262qO4i7() {
        return "resetclankdr";
    }

    private static String j8JyOTvCPa6iMp() {
        return "verify";
    }

    private static String L8UV2nIaIj5rti3BY8U() {
        return "resetplayerkdr";
    }

    private static String HYshVYhWtjChi3E() {
        return "forcejoin";
    }

    private static String JzrB4xiFHPKAQpBW() {
        return "forcejoin";
    }

    private static String AhFey7f2BHL4vzi7cZVCrH() {
        return "module";
    }

    private static String uwcn55vnkmurUU2EteTQl() {
        return "download";
    }

    private static String PR1fB38geXOLTnBWyd() {
        return "module";
    }

    private static String E4s5RCxmdUZ2Y5vIiF5wCw() {
        return "update";
    }

    private static String BMJwr487ayMOWJcUttN() {
        return "module";
    }

    private static String L2RUAYVhht2jslyktv() {
        return "view";
    }

    private static String gf0QJjAiksQUPgx() {
        return "extension";
    }

    private static String Fu58AhEBur2bPwDY0dLsg() {
        return "download";
    }

    private static String c4mtoIPHGYeR1SQ2bkj() {
        return "extension";
    }

    private static String FhGW1O5PirpDenNre() {
        return "update";
    }

    private static String BygfY9A8xbn8eXt() {
        return "extension";
    }

    private static String M8vpC2fbl0EcSzVlAFu9() {
        return "view";
    }

    private static String szxIbGsdEJhLAe59UO2() {
        return "addpoints";
    }

    private static String BHD4dGKUE9TudA6() {
        return "removepoints";
    }

    private static String Gtt1G11a8rSoJhKcjJr5dq() {
        return "setleader";
    }

    private static String DfS5W5lMg6cfcFij() {
        return "kick";
    }

    private static String NM2VohaaOwxgqxaRb4StNU() {
        return "reload";
    }

    private static String gZVebMgwK78dEpS8WCluB() {
        return "all";
    }

    private static String lcPogkFk1MeaRysu() {
        return "addons";
    }

    private static String oJ08A2csSsPEcT2II46F() {
        return "configurations";
    }

    private static String MuRsSbm2ULUxKpKTwdEGsl() {
        return "setpoints";
    }

    private static String p7R45Vtj05BMr8R() {
        return "0";
    }

    private static String OAe9udvmwgmNoUGvu() {
        return "1";
    }

    private static String TUMPEa0VVicnXZU3xc() {
        return "100";
    }

    private static String jMBZdkwwB384eIuof() {
        return "1000";
    }

    private static String ieGaNcNOEO9MNLZb() {
        return "setslot";
    }

    private static String L9yqCyWDvEJacgERrE() {
        return "addslot";
    }

    private static String dYLuMU0k44NimVuK() {
        return "removeslot";
    }

    private static String aI9dLXupL3aq4lGn9SG9e() {
        return "1";
    }

    private static String ZQEVfag3uIwOv9H0() {
        return "5";
    }

    private static String aFjWDT7L3VcOPhwOGvzc() {
        return "10";
    }
}
