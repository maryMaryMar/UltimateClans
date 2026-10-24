package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.CustomChatPrompt;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.utils.Actionbar;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.Title;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/bUQFEznViQX6XlU8D.class */
public class bUQFEznViQX6XlU8D {
    private final Map<UUID, Ijap9SQKkijXSxP5> v8qP8fE86HMhvNuYPFjqY = new ConcurrentHashMap();
    private static final byte[] ZdHcMdol8QqcnxPEW = {(byte) 52, (byte) 60, (byte) 252, (byte) 77, (byte) 189, (byte) 123, (byte) 125, (byte) 1, (byte) 81, (byte) 209, (byte) 224, (byte) 88, (byte) 154, (byte) 220, (byte) 204, (byte) 111, (byte) 149, (byte) 4, (byte) 120, (byte) 134, (byte) 127, (byte) 124, (byte) 61, (byte) 156, (byte) 176, (byte) 172, (byte) 177, (byte) 244, (byte) 22, (byte) 11, (byte) 84, (byte) 78};
    private static final byte[] pBDH1JFVjydXxbupQV = {(byte) 61, (byte) 125, (byte) 156, (byte) 129, (byte) 72, (byte) 119, (byte) 183, (byte) 94, (byte) 157, (byte) 228, (byte) 193, (byte) 91, (byte) 121, (byte) 73, (byte) 231, (byte) 236};
    private static String FTRAdgxSF6vEVlejWetwlm;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/bUQFEznViQX6XlU8D$Ijap9SQKkijXSxP5.class */
    private static class Ijap9SQKkijXSxP5 {
        private final CustomChatPrompt v8qP8fE86HMhvNuYPFjqY;
        private final MyScheduledTask jBUuLP0sWwaPyPOmogdX7l;

        public Ijap9SQKkijXSxP5(CustomChatPrompt customChatPrompt, MyScheduledTask myScheduledTask) {
            this.v8qP8fE86HMhvNuYPFjqY = customChatPrompt;
            this.jBUuLP0sWwaPyPOmogdX7l = myScheduledTask;
        }

        public CustomChatPrompt v8qP8fE86HMhvNuYPFjqY() {
            return this.v8qP8fE86HMhvNuYPFjqY;
        }

        public MyScheduledTask jBUuLP0sWwaPyPOmogdX7l() {
            return this.jBUuLP0sWwaPyPOmogdX7l;
        }
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player) {
        return this.v8qP8fE86HMhvNuYPFjqY.containsKey(player.getUniqueId());
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, CustomChatPrompt customChatPrompt) {
        if (player == null || v8qP8fE86HMhvNuYPFjqY(player)) {
            return false;
        }
        if (!customChatPrompt.getChatMessages().isEmpty()) {
            customChatPrompt.getChatMessages().forEach(str -> {
                MessageUtils.sendText((CommandSender) player, Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), str)));
            });
        }
        if (customChatPrompt.getActionBar() != null && !customChatPrompt.getActionBar().isEmpty()) {
            Actionbar.showTimedActionbar(player, Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), customChatPrompt.getActionBar()), customChatPrompt.getDurationSeconds());
        }
        if (customChatPrompt.getTitle() != null || customChatPrompt.getSubtitle() != null) {
            Title.showTimedTitle(player, Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), customChatPrompt.getTitle()), Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), customChatPrompt.getSubtitle()), customChatPrompt.getDurationSeconds() * 20);
        }
        if (customChatPrompt.getScoreboardTitle() != null || customChatPrompt.getScoreboardLines() != null) {
            String text = Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), customChatPrompt.getScoreboardTitle());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < customChatPrompt.getScoreboardLines().size(); i++) {
                arrayList.add(Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), customChatPrompt.getScoreboardLines().get(i)));
            }
            Clans.getClanCore().getScoreboardmanager().v8qP8fE86HMhvNuYPFjqY(player, text, arrayList);
        }
        if (customChatPrompt.getBossBarText() != null && !customChatPrompt.getBossBarText().isEmpty()) {
            Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player);
            Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player, customChatPrompt.getBossBarColor(), customChatPrompt.getBossBarOverlay(), customChatPrompt.getBossBarFlags(), Clans.getClanCore().getClanAPI().parseText(player.getUniqueId(), customChatPrompt.getBossBarText()), customChatPrompt.getDurationSeconds(), true, new ArrayList());
        }
        if (customChatPrompt.getSound() != null && !customChatPrompt.getSound().isEmpty()) {
            Clans.getClanCore().getLibManager().v8qP8fE86HMhvNuYPFjqY(player, customChatPrompt.getSound());
        }
        if (customChatPrompt.isAlertOnly()) {
            return true;
        }
        this.v8qP8fE86HMhvNuYPFjqY.put(player.getUniqueId(), new Ijap9SQKkijXSxP5(customChatPrompt, Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            v8qP8fE86HMhvNuYPFjqY(player, true);
        }, ((long) customChatPrompt.getDurationSeconds()) * 20)));
        return true;
    }

    public void v8qP8fE86HMhvNuYPFjqY(Player player, String str) {
        Clans.getClanCore().getScoreboardmanager().jBUuLP0sWwaPyPOmogdX7l(player);
        Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5Remove = this.v8qP8fE86HMhvNuYPFjqY.remove(player.getUniqueId());
        if (ijap9SQKkijXSxP5Remove == null) {
            return;
        }
        ijap9SQKkijXSxP5Remove.jBUuLP0sWwaPyPOmogdX7l().cancel();
        Title.resetTitle(player);
        Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player);
        Actionbar.resetActionbar(player);
        if (str.equalsIgnoreCase(ZkwwojPVNGml8Q7())) {
            if (ijap9SQKkijXSxP5Remove.v8qP8fE86HMhvNuYPFjqY().getOnTimeoutOrCancel() != null) {
                ijap9SQKkijXSxP5Remove.v8qP8fE86HMhvNuYPFjqY().getOnTimeoutOrCancel().accept(player);
            }
        } else if (ijap9SQKkijXSxP5Remove.v8qP8fE86HMhvNuYPFjqY().getOnInputReceived() != null) {
            ijap9SQKkijXSxP5Remove.v8qP8fE86HMhvNuYPFjqY().getOnInputReceived().accept(player, str);
        }
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l(Player player) {
        return v8qP8fE86HMhvNuYPFjqY(player, false);
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, boolean z) {
        Clans.getClanCore().getScoreboardmanager().jBUuLP0sWwaPyPOmogdX7l(player);
        Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5Remove = this.v8qP8fE86HMhvNuYPFjqY.remove(player.getUniqueId());
        if (ijap9SQKkijXSxP5Remove == null) {
            return false;
        }
        ijap9SQKkijXSxP5Remove.jBUuLP0sWwaPyPOmogdX7l().cancel();
        Title.resetTitle(player);
        Clans.getClanCore().getBossBarManager().v8qP8fE86HMhvNuYPFjqY(player);
        Actionbar.resetActionbar(player);
        if (!z || ijap9SQKkijXSxP5Remove.v8qP8fE86HMhvNuYPFjqY().getOnTimeoutOrCancel() == null) {
            return true;
        }
        ijap9SQKkijXSxP5Remove.v8qP8fE86HMhvNuYPFjqY().getOnTimeoutOrCancel().accept(player);
        return true;
    }

    private static String ZkwwojPVNGml8Q7() {
        return "cancel";
    }
}
