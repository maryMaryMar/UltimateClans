package me.ulrich.clans.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CustomChatPrompt.class */
public class CustomChatPrompt {
    private final int durationSeconds;
    private final boolean alertOnly;
    private final List<String> chatMessages;
    private final String actionBar;
    private final String title;
    private final String subtitle;
    private final String bossBarText;
    private final BossBar.Color bossBarColor;
    private final BossBar.Overlay bossBarOverlay;
    private final List<BossBar.Flag> bossBarFlags;
    private final boolean bossBarAnimated;
    private final String scoreboardTitle;
    private final List<String> scoreboardLines;
    private final String sound;
    private final BiConsumer<Player, String> onInputReceived;
    private final Consumer<Player> onTimeoutOrCancel;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/CustomChatPrompt$Builder.class */
    public static class Builder {
        private String actionBar;
        private String title;
        private String subtitle;
        private String bossBarText;
        private String sound;
        private String scoreboardTitle;
        private BiConsumer<Player, String> onInputReceived;
        private Consumer<Player> onTimeoutOrCancel;
        private int durationSeconds = 30;
        private boolean alertOnly = false;
        private List<String> chatMessages = new ArrayList();
        private BossBar.Color bossBarColor = BossBar.Color.RED;
        private BossBar.Overlay bossBarOverlay = BossBar.Overlay.PROGRESS;
        private List<BossBar.Flag> bossBarFlags = new ArrayList();
        private boolean bossBarAnimated = false;
        private List<String> scoreboardLines = new ArrayList();

        public Builder setDuration(int i) {
            this.durationSeconds = i;
            return this;
        }

        public Builder setAlertOnly(boolean z) {
            this.alertOnly = z;
            return this;
        }

        public Builder addChatMessage(String str) {
            this.chatMessages.add(str);
            return this;
        }

        public Builder setChatMessages(List<String> list) {
            this.chatMessages = list;
            return this;
        }

        public Builder setActionBar(String str) {
            this.actionBar = str;
            return this;
        }

        public Builder setTitle(String str, String str2) {
            this.title = str;
            this.subtitle = str2;
            return this;
        }

        public Builder setSound(String str) {
            this.sound = str;
            return this;
        }

        public Builder setBossBar(String str, BossBar.Color color, BossBar.Overlay overlay, List<BossBar.Flag> list, boolean z) {
            this.bossBarText = str;
            if (color != null) {
                this.bossBarColor = color;
            }
            if (overlay != null) {
                this.bossBarOverlay = overlay;
            }
            if (list != null) {
                this.bossBarFlags = list;
            }
            this.bossBarAnimated = z;
            return this;
        }

        public Builder setScoreboard(String str, List<String> list) {
            this.scoreboardTitle = str;
            this.scoreboardLines = list;
            return this;
        }

        public Builder onResponse(BiConsumer<Player, String> biConsumer) {
            this.onInputReceived = biConsumer;
            return this;
        }

        public Builder onCancel(Consumer<Player> consumer) {
            this.onTimeoutOrCancel = consumer;
            return this;
        }

        public CustomChatPrompt build() {
            if (this.alertOnly || this.onInputReceived != null) {
                return new CustomChatPrompt(this);
            }
            throw new IllegalStateException("O prompt precisa de uma ação de resposta quando não for configurado como alertOnly!");
        }
    }

    private CustomChatPrompt(Builder builder) {
        this.durationSeconds = builder.durationSeconds;
        this.alertOnly = builder.alertOnly;
        this.chatMessages = builder.chatMessages;
        this.actionBar = builder.actionBar;
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.bossBarText = builder.bossBarText;
        this.bossBarColor = builder.bossBarColor;
        this.bossBarOverlay = builder.bossBarOverlay;
        this.bossBarFlags = builder.bossBarFlags;
        this.bossBarAnimated = builder.bossBarAnimated;
        this.scoreboardTitle = builder.scoreboardTitle;
        this.scoreboardLines = builder.scoreboardLines;
        this.sound = builder.sound;
        this.onInputReceived = builder.onInputReceived;
        this.onTimeoutOrCancel = builder.onTimeoutOrCancel;
    }

    public int getDurationSeconds() {
        return this.durationSeconds;
    }

    public boolean isAlertOnly() {
        return this.alertOnly;
    }

    public List<String> getChatMessages() {
        return this.chatMessages;
    }

    public String getActionBar() {
        return this.actionBar;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getBossBarText() {
        return this.bossBarText;
    }

    public BossBar.Color getBossBarColor() {
        return this.bossBarColor;
    }

    public BossBar.Overlay getBossBarOverlay() {
        return this.bossBarOverlay;
    }

    public List<BossBar.Flag> getBossBarFlags() {
        return this.bossBarFlags;
    }

    public boolean isBossBarAnimated() {
        return this.bossBarAnimated;
    }

    public String getScoreboardTitle() {
        return this.scoreboardTitle;
    }

    public List<String> getScoreboardLines() {
        return this.scoreboardLines;
    }

    public String getSound() {
        return this.sound;
    }

    public BiConsumer<Player, String> getOnInputReceived() {
        return this.onInputReceived;
    }

    public Consumer<Player> getOnTimeoutOrCancel() {
        return this.onTimeoutOrCancel;
    }
}
