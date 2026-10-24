package me.ulrich.clans.data;

import java.util.Optional;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/RequerimentData_Return.class */
public class RequerimentData_Return {
    private String requiredValue;
    private Optional<String> trueMessage;
    private Optional<String> falseMessage;

    public RequerimentData_Return(String str, Optional<String> optional, Optional<String> optional2) {
        setRequiredValue(str);
        setTrueMessage(optional);
        setFalseMessage(optional2);
    }

    public Optional<String> getTrueMessage() {
        return this.trueMessage;
    }

    public void setTrueMessage(Optional<String> optional) {
        this.trueMessage = optional;
    }

    public Optional<String> getFalseMessage() {
        return this.falseMessage;
    }

    public void setFalseMessage(Optional<String> optional) {
        this.falseMessage = optional;
    }

    public String getRequiredValue() {
        return this.requiredValue;
    }

    public void setRequiredValue(String str) {
        this.requiredValue = str;
    }
}
