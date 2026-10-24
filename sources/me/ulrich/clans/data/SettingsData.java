package me.ulrich.clans.data;

import java.util.Optional;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/SettingsData.class */
public class SettingsData {
    private boolean warInvite;
    private boolean allySharedChat;
    private boolean joinLeave;
    private boolean allySharedHome;
    private boolean opened;
    private boolean publicHomes;
    private boolean receveMailAllies;
    private boolean receiveMailAll;
    private Optional<JSONObject> jsonMeta;
    private boolean allyPvp;

    public SettingsData(Optional<JSONObject> optional, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        setWarInvite(z);
        setAllySharedChat(z2);
        setJoinLeave(z3);
        setAllySharedHome(z4);
        setOpened(z5);
        setPublicHomes(z6);
        setReceveMailAllies(z7);
        setReceiveMailAll(z8);
        setJsonMeta(optional);
        setAllyPvp(z9);
    }

    public boolean isWarInvite() {
        return this.warInvite;
    }

    public void setWarInvite(boolean z) {
        this.warInvite = z;
    }

    public boolean isAllySharedChat() {
        return this.allySharedChat;
    }

    public void setAllySharedChat(boolean z) {
        this.allySharedChat = z;
    }

    public boolean isJoinLeave() {
        return this.joinLeave;
    }

    public void setJoinLeave(boolean z) {
        this.joinLeave = z;
    }

    public boolean isAllySharedHome() {
        return this.allySharedHome;
    }

    public void setAllySharedHome(boolean z) {
        this.allySharedHome = z;
    }

    public boolean isOpened() {
        return this.opened;
    }

    public void setOpened(boolean z) {
        this.opened = z;
    }

    public boolean isPublicHomes() {
        return this.publicHomes;
    }

    public void setPublicHomes(boolean z) {
        this.publicHomes = z;
    }

    public boolean isReceveMailAllies() {
        return this.receveMailAllies;
    }

    public void setReceveMailAllies(boolean z) {
        this.receveMailAllies = z;
    }

    public boolean isReceiveMailAll() {
        return this.receiveMailAll;
    }

    public void setReceiveMailAll(boolean z) {
        this.receiveMailAll = z;
    }

    public Optional<JSONObject> getJsonMeta() {
        return this.jsonMeta;
    }

    public void setJsonMeta(Optional<JSONObject> optional) {
        this.jsonMeta = optional;
    }

    public boolean isAllyPvp() {
        return this.allyPvp;
    }

    public void setAllyPvp(boolean z) {
        this.allyPvp = z;
    }
}
