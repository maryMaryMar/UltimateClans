package me.ulrich.clans.library.kyori.adventure.chat;

import java.security.SecureRandom;
import java.time.Instant;
import me.ulrich.clans.library.kyori.adventure.identity.Identity;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/SignedMessageImpl.class */
final class SignedMessageImpl implements SignedMessage {
    static final SecureRandom RANDOM = new SecureRandom();
    private final Instant instant = Instant.now();
    private final long salt = RANDOM.nextLong();
    private final String message;
    private final Component unsignedContent;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/chat/SignedMessageImpl$SignatureImpl.class */
    static final class SignatureImpl implements SignedMessage.Signature {
        final byte[] signature;

        SignatureImpl(byte[] bArr) {
            this.signature = bArr;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.chat.SignedMessage.Signature
        public byte[] bytes() {
            return this.signature;
        }
    }

    SignedMessageImpl(String str, Component component) {
        this.message = str;
        this.unsignedContent = component;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.chat.SignedMessage
    @NotNull
    public Instant timestamp() {
        return this.instant;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.chat.SignedMessage
    public long salt() {
        return this.salt;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.chat.SignedMessage
    public SignedMessage.Signature signature() {
        return null;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.chat.SignedMessage
    @Nullable
    public Component unsignedContent() {
        return this.unsignedContent;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.chat.SignedMessage
    @NotNull
    public String message() {
        return this.message;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.identity.Identified
    @NotNull
    public Identity identity() {
        return Identity.nil();
    }
}
