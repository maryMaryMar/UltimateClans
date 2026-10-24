package me.ulrich.clans.library.kyori.adventure.text.minimessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.QuotingOverride;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageSerializer.class */
final class MiniMessageSerializer {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageSerializer$Collector.class */
    static final class Collector implements ClaimConsumer, TokenEmitter {
        private static final String MARK = "__<'\"\\MARK__";
        private static final char[] TEXT_ESCAPES = {'\\', '<'};
        private static final char[] TAG_TOKENS = {'>', ':'};
        private static final char[] SINGLE_QUOTED_ESCAPES = {'\\', '\''};
        private static final char[] DOUBLE_QUOTED_ESCAPES = {'\\', '\"'};
        private final SerializableResolver resolver;
        private final boolean strict;
        private final StringBuilder consumer;

        @Nullable
        Emitable componentClaim;
        private String[] activeTags = new String[4];
        private int tagLevel = 0;
        private TagState tagState = TagState.TEXT;
        final Set<String> claimedStyleElements = new HashSet();

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/MiniMessageSerializer$Collector$TagState.class */
        enum TagState {
            TEXT(false),
            MID(true),
            MID_SELF_CLOSING(true);

            final boolean isTag;

            TagState(boolean z) {
                this.isTag = z;
            }
        }

        Collector(SerializableResolver serializableResolver, boolean z, StringBuilder sb) {
            this.resolver = serializableResolver;
            this.strict = z;
            this.consumer = sb;
        }

        private void pushActiveTag(String str) {
            if (this.tagLevel >= this.activeTags.length) {
                this.activeTags = (String[]) Arrays.copyOf(this.activeTags, this.activeTags.length * 2);
            }
            String[] strArr = this.activeTags;
            int i = this.tagLevel;
            this.tagLevel = i + 1;
            strArr[i] = str;
        }

        private String popTag(boolean z) {
            int i = this.tagLevel;
            this.tagLevel = i - 1;
            if (i <= 0) {
                throw new IllegalStateException("Unbalanced tags, tried to pop below depth");
            }
            String str = this.activeTags[this.tagLevel];
            if (z || str != MARK) {
                return str;
            }
            throw new IllegalStateException("Tried to pop past mark, tag stack: " + Arrays.toString(this.activeTags) + " @ " + this.tagLevel);
        }

        void mark() {
            pushActiveTag(MARK);
        }

        void popToMark() {
            if (this.tagLevel == 0) {
                return;
            }
            while (true) {
                String strPopTag = popTag(true);
                if (strPopTag == MARK) {
                    return;
                } else {
                    emitClose(strPopTag);
                }
            }
        }

        void popAll() {
            while (this.tagLevel > 0) {
                String[] strArr = this.activeTags;
                int i = this.tagLevel - 1;
                this.tagLevel = i;
                String str = strArr[i];
                if (str != MARK) {
                    emitClose(str);
                }
            }
        }

        void completeTag() {
            if (this.tagState.isTag) {
                this.consumer.append('>');
                this.tagState = TagState.TEXT;
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public Collector tag(@NotNull String str) {
            completeTag();
            this.consumer.append('<');
            escapeTagContent(str, QuotingOverride.UNQUOTED);
            this.tagState = TagState.MID;
            pushActiveTag(str);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public TokenEmitter selfClosingTag(@NotNull String str) {
            completeTag();
            this.consumer.append('<');
            escapeTagContent(str, QuotingOverride.UNQUOTED);
            this.tagState = TagState.MID_SELF_CLOSING;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public TokenEmitter argument(@NotNull String str) {
            if (!this.tagState.isTag) {
                throw new IllegalStateException("Not within a tag!");
            }
            this.consumer.append(':');
            escapeTagContent(str, null);
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public TokenEmitter argument(@NotNull String str, @NotNull QuotingOverride quotingOverride) {
            if (!this.tagState.isTag) {
                throw new IllegalStateException("Not within a tag!");
            }
            this.consumer.append(':');
            escapeTagContent(str, (QuotingOverride) Objects.requireNonNull(quotingOverride, "quotingPreference"));
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public TokenEmitter argument(@NotNull Component component) {
            return argument(MiniMessageSerializer.serialize(component, this.resolver, this.strict), QuotingOverride.QUOTED);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public Collector text(@NotNull String str) {
            completeTag();
            appendEscaping(this.consumer, str, TEXT_ESCAPES, true);
            return this;
        }

        private void escapeTagContent(String str, @Nullable QuotingOverride quotingOverride) {
            boolean z = quotingOverride == QuotingOverride.QUOTED;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == '>' || cCharAt == ':' || cCharAt == ' ') {
                    z = true;
                    if (0 != 0 && z3) {
                        break;
                    }
                } else {
                    if (cCharAt == '\'') {
                        z2 = true;
                        break;
                    }
                    if (cCharAt == '\"') {
                        z3 = true;
                        if (z && 0 != 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (z2) {
                this.consumer.append('\"');
                appendEscaping(this.consumer, str, DOUBLE_QUOTED_ESCAPES, true);
                this.consumer.append('\"');
            } else {
                if (!z3 && !z) {
                    appendEscaping(this.consumer, str, TAG_TOKENS, false);
                    return;
                }
                this.consumer.append('\'');
                appendEscaping(this.consumer, str, SINGLE_QUOTED_ESCAPES, true);
                this.consumer.append('\'');
            }
        }

        static void appendEscaping(StringBuilder sb, String str, char[] cArr, boolean z) {
            int i = 0;
            boolean z2 = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                boolean z3 = false;
                for (char c : cArr) {
                    if (cCharAt == c) {
                        if (!z) {
                            throw new IllegalArgumentException("Invalid escapable character '" + cCharAt + "' found at index " + i2 + " in string '" + str + "'");
                        }
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    if (z2) {
                        sb.append((CharSequence) str, i, i2);
                    }
                    i = i2 + 1;
                    sb.append('\\').append(cCharAt);
                } else {
                    z2 = true;
                }
            }
            if (i >= str.length() || !z2) {
                return;
            }
            sb.append((CharSequence) str, i, str.length());
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter
        @NotNull
        public Collector pop() {
            emitClose(popTag(false));
            return this;
        }

        private void emitClose(@NotNull String str) {
            if (!this.tagState.isTag) {
                this.consumer.append('<').append('/');
                escapeTagContent(str, QuotingOverride.UNQUOTED);
                this.consumer.append('>');
            } else {
                if (this.tagState == TagState.MID) {
                    this.consumer.append('/');
                }
                this.consumer.append('>');
                this.tagState = TagState.TEXT;
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer
        public void style(@NotNull String str, @NotNull Emitable emitable) {
            if (this.claimedStyleElements.add((String) Objects.requireNonNull(str, "claimKey"))) {
                emitable.emit(this);
            }
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer
        public boolean component(@NotNull Emitable emitable) {
            if (this.componentClaim != null) {
                return false;
            }
            this.componentClaim = (Emitable) Objects.requireNonNull(emitable, "componentClaim");
            return true;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer
        public boolean componentClaimed() {
            return this.componentClaim != null;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.ClaimConsumer
        public boolean styleClaimed(@NotNull String str) {
            return this.claimedStyleElements.contains(str);
        }

        @Nullable
        Component flushClaims(Component component) {
            Component componentSubstitute = null;
            if (this.componentClaim != null) {
                this.componentClaim.emit(this);
                componentSubstitute = this.componentClaim.substitute();
                this.componentClaim = null;
            } else {
                if (!(component instanceof TextComponent)) {
                    throw new IllegalStateException("Unclaimed component " + component);
                }
                text(((TextComponent) component).content());
            }
            this.claimedStyleElements.clear();
            return componentSubstitute;
        }
    }

    private MiniMessageSerializer() {
    }

    @NotNull
    static String serialize(@NotNull Component component, @NotNull SerializableResolver serializableResolver, boolean z) {
        StringBuilder sb = new StringBuilder();
        Collector collector = new Collector(serializableResolver, z, sb);
        collector.mark();
        visit(component, collector, serializableResolver, true);
        if (z) {
            collector.popAll();
        } else {
            collector.completeTag();
        }
        return sb.toString();
    }

    private static void visit(@NotNull Component component, Collector collector, SerializableResolver serializableResolver, boolean z) {
        serializableResolver.handle(component, collector);
        Component componentFlushClaims = collector.flushClaims(component);
        if (componentFlushClaims == null) {
            componentFlushClaims = component;
        }
        Iterator<Component> it = componentFlushClaims.children().iterator();
        while (it.hasNext()) {
            collector.mark();
            visit(it.next(), collector, serializableResolver, z && !it.hasNext());
        }
        if (z) {
            return;
        }
        collector.popToMark();
    }
}
