package me.ulrich.clans.data;

import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/MailData.class */
public class MailData {
    private UUID id;
    private UUID from;
    private UUID sender;
    private String text;
    private long date;
    private UUID to;
    private List<UUID> readBy;

    public MailData(UUID uuid, UUID uuid2, UUID uuid3, UUID uuid4, String str, long j, List<UUID> list) {
        setId(uuid);
        setFrom(uuid2);
        setTo(uuid3);
        setSender(uuid4);
        setText(str);
        setDate(j);
        setReadBy(list);
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public UUID getTo() {
        return this.to;
    }

    public void setTo(UUID uuid) {
        this.to = uuid;
    }

    public UUID getFrom() {
        return this.from;
    }

    public void setFrom(UUID uuid) {
        this.from = uuid;
    }

    public List<UUID> getReadBy() {
        return this.readBy;
    }

    public void setReadBy(List<UUID> list) {
        this.readBy = list;
    }

    public UUID getSender() {
        return this.sender;
    }

    public void setSender(UUID uuid) {
        this.sender = uuid;
    }
}
