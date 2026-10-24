package me.ulrich.clans.library.kyori.adventure.text.serializer.legacy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.TextComponent;
import me.ulrich.clans.library.kyori.adventure.text.TextReplacementConfig;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.library.kyori.adventure.text.flattener.ComponentFlattener;
import me.ulrich.clans.library.kyori.adventure.text.flattener.FlattenerListener;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.Style;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextDecoration;
import me.ulrich.clans.library.kyori.adventure.text.format.TextFormat;
import me.ulrich.clans.library.kyori.adventure.util.Services;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl.class */
final class LegacyComponentSerializerImpl implements LegacyComponentSerializer {
    private static final char LEGACY_BUNGEE_HEX_CHAR = 'x';
    private final char character;
    private final char hexCharacter;

    @Nullable
    private final TextReplacementConfig urlReplacementConfig;
    private final boolean hexColours;
    private final boolean useTerriblyStupidHexFormat;
    private final ComponentFlattener flattener;
    private final CharacterAndFormatSet formats;
    static final Pattern DEFAULT_URL_PATTERN = Pattern.compile("(?:(https?)://)?([-\\w_.]+\\.\\w{2,})(/([A-Za-z0-9\\-._~!$&'()*+,;=:@/]|%[0-9A-Fa-f]{2})*)?");
    static final Pattern URL_SCHEME_PATTERN = Pattern.compile("^[a-z][a-z0-9+\\-.]*:");
    private static final TextDecoration[] DECORATIONS = TextDecoration.values();
    private static final Optional<LegacyComponentSerializer.Provider> SERVICE = Services.service(LegacyComponentSerializer.Provider.class);
    static final Consumer<LegacyComponentSerializer.Builder> BUILDER = (Consumer) SERVICE.map((v0) -> {
        return v0.legacy();
    }).orElseGet(() -> {
        return builder -> {
        };
    });

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl$BuilderImpl.class */
    static final class BuilderImpl implements LegacyComponentSerializer.Builder {
        private char character;
        private char hexCharacter;
        private TextReplacementConfig urlReplacementConfig;
        private boolean hexColours;
        private boolean useTerriblyStupidHexFormat;
        private ComponentFlattener flattener;
        private CharacterAndFormatSet formats;

        BuilderImpl() {
            this.character = (char) 167;
            this.hexCharacter = '#';
            this.urlReplacementConfig = null;
            this.hexColours = false;
            this.useTerriblyStupidHexFormat = false;
            this.flattener = ComponentFlattener.basic();
            this.formats = CharacterAndFormatSet.DEFAULT;
            LegacyComponentSerializerImpl.BUILDER.accept(this);
        }

        BuilderImpl(@NotNull LegacyComponentSerializerImpl legacyComponentSerializerImpl) {
            this();
            this.character = legacyComponentSerializerImpl.character;
            this.hexCharacter = legacyComponentSerializerImpl.hexCharacter;
            this.urlReplacementConfig = legacyComponentSerializerImpl.urlReplacementConfig;
            this.hexColours = legacyComponentSerializerImpl.hexColours;
            this.useTerriblyStupidHexFormat = legacyComponentSerializerImpl.useTerriblyStupidHexFormat;
            this.flattener = legacyComponentSerializerImpl.flattener;
            this.formats = legacyComponentSerializerImpl.formats;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder character(char c) {
            this.character = c;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder hexCharacter(char c) {
            this.hexCharacter = c;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder extractUrls() {
            return extractUrls(LegacyComponentSerializerImpl.DEFAULT_URL_PATTERN, null);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder extractUrls(@NotNull Pattern pattern) {
            return extractUrls(pattern, null);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder extractUrls(@Nullable Style style) {
            return extractUrls(LegacyComponentSerializerImpl.DEFAULT_URL_PATTERN, style);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder extractUrls(@NotNull Pattern pattern, @Nullable Style style) {
            Objects.requireNonNull(pattern, "pattern");
            this.urlReplacementConfig = TextReplacementConfig.builder().match(pattern).replacement(builder -> {
                String strContent = builder.content();
                if (!LegacyComponentSerializerImpl.URL_SCHEME_PATTERN.matcher(strContent).find()) {
                    strContent = "http://" + strContent;
                }
                try {
                    new URI(strContent);
                    return (style == null ? builder : builder.style(style)).clickEvent(ClickEvent.openUrl(strContent));
                } catch (URISyntaxException e) {
                    return builder;
                }
            }).build2();
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder hexColors() {
            this.hexColours = true;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder useUnusualXRepeatedCharacterHexFormat() {
            this.useTerriblyStupidHexFormat = true;
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder flattener(@NotNull ComponentFlattener componentFlattener) {
            this.flattener = (ComponentFlattener) Objects.requireNonNull(componentFlattener, "flattener");
            return this;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder
        @NotNull
        public LegacyComponentSerializer.Builder formats(@NotNull List<CharacterAndFormat> list) {
            this.formats = CharacterAndFormatSet.of(list);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer.Builder, me.ulrich.clans.library.kyori.adventure.builder.AbstractBuilder, me.ulrich.clans.library.kyori.adventure.util.Buildable.Builder
        @NotNull
        /* JADX INFO: renamed from: build */
        public LegacyComponentSerializer build2() {
            return new LegacyComponentSerializerImpl(this.character, this.hexCharacter, this.urlReplacementConfig, this.hexColours, this.useTerriblyStupidHexFormat, this.flattener, this.formats);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl$Cereal.class */
    private final class Cereal implements FlattenerListener {
        private final StringBuilder sb;
        private final StyleState style;

        @Nullable
        private TextFormat lastWritten;
        private StyleState[] styles;
        private int head;

        /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl$Cereal$StyleState.class */
        private final class StyleState {

            @Nullable
            private TextColor color;
            private final Set<TextDecoration> decorations = EnumSet.noneOf(TextDecoration.class);
            private boolean needsReset;

            StyleState() {
            }

            void set(@NotNull StyleState styleState) {
                this.color = styleState.color;
                this.decorations.clear();
                this.decorations.addAll(styleState.decorations);
            }

            public void clear() {
                this.color = null;
                this.decorations.clear();
            }

            void apply(@NotNull Style style) {
                TextColor textColorColor = style.color();
                if (textColorColor != null) {
                    this.color = textColorColor;
                }
                int length = LegacyComponentSerializerImpl.DECORATIONS.length;
                for (int i = 0; i < length; i++) {
                    TextDecoration textDecoration = LegacyComponentSerializerImpl.DECORATIONS[i];
                    switch (style.decoration(textDecoration)) {
                        case TRUE:
                            this.decorations.add(textDecoration);
                            break;
                        case FALSE:
                            if (this.decorations.remove(textDecoration)) {
                                this.needsReset = true;
                            }
                            break;
                    }
                }
            }

            void applyFormat() {
                boolean z = this.color != Cereal.this.style.color;
                if (this.needsReset) {
                    if (!z) {
                        Cereal.this.append(Reset.INSTANCE);
                    }
                    this.needsReset = false;
                }
                if (z || Cereal.this.lastWritten == Reset.INSTANCE) {
                    applyFullFormat();
                    return;
                }
                if (!this.decorations.containsAll(Cereal.this.style.decorations)) {
                    applyFullFormat();
                    return;
                }
                for (TextDecoration textDecoration : this.decorations) {
                    if (Cereal.this.style.decorations.add(textDecoration)) {
                        Cereal.this.append(textDecoration);
                    }
                }
            }

            private void applyFullFormat() {
                if (this.color != null) {
                    Cereal.this.append(this.color);
                } else {
                    Cereal.this.append(Reset.INSTANCE);
                }
                Cereal.this.style.color = this.color;
                Iterator<TextDecoration> it = this.decorations.iterator();
                while (it.hasNext()) {
                    Cereal.this.append(it.next());
                }
                Cereal.this.style.decorations.clear();
                Cereal.this.style.decorations.addAll(this.decorations);
            }
        }

        private Cereal() {
            this.sb = new StringBuilder();
            this.style = new StyleState();
            this.styles = new StyleState[8];
            this.head = -1;
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.FlattenerListener
        public void pushStyle(@NotNull Style style) {
            int i = this.head + 1;
            this.head = i;
            if (i >= this.styles.length) {
                this.styles = (StyleState[]) Arrays.copyOf(this.styles, this.styles.length * 2);
            }
            StyleState styleState = this.styles[i];
            if (styleState == null) {
                StyleState[] styleStateArr = this.styles;
                StyleState styleState2 = new StyleState();
                styleState = styleState2;
                styleStateArr[i] = styleState2;
            }
            if (i > 0) {
                styleState.set(this.styles[i - 1]);
            } else {
                styleState.clear();
            }
            styleState.apply(style);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.FlattenerListener
        public void component(@NotNull String str) {
            if (str.isEmpty()) {
                return;
            }
            if (this.head < 0) {
                throw new IllegalStateException("No style has been pushed!");
            }
            this.styles[this.head].applyFormat();
            this.sb.append(str);
        }

        @Override // me.ulrich.clans.library.kyori.adventure.text.flattener.FlattenerListener
        public void popStyle(@NotNull Style style) {
            int i = this.head;
            this.head = i - 1;
            if (i < 0) {
                throw new IllegalStateException("Tried to pop beyond what was pushed!");
            }
        }

        void append(@NotNull TextFormat textFormat) {
            if (this.lastWritten != textFormat) {
                String legacyCode = LegacyComponentSerializerImpl.this.toLegacyCode(textFormat);
                if (legacyCode == null) {
                    return;
                } else {
                    this.sb.append(LegacyComponentSerializerImpl.this.character).append(legacyCode);
                }
            }
            this.lastWritten = textFormat;
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl$DecodedFormat.class */
    static final class DecodedFormat {
        final FormatCodeType encodedFormat;
        final TextFormat format;

        private DecodedFormat(FormatCodeType formatCodeType, TextFormat textFormat) {
            if (textFormat == null) {
                throw new IllegalStateException("No format found");
            }
            this.encodedFormat = formatCodeType;
            this.format = textFormat;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl$FormatCodeType.class */
    enum FormatCodeType {
        MOJANG_LEGACY,
        KYORI_HEX,
        BUNGEECORD_UNUSUAL_HEX
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/serializer/legacy/LegacyComponentSerializerImpl$Instances.class */
    static final class Instances {
        static final LegacyComponentSerializer SECTION = (LegacyComponentSerializer) LegacyComponentSerializerImpl.SERVICE.map((v0) -> {
            return v0.legacySection();
        }).orElseGet(() -> {
            return new LegacyComponentSerializerImpl((char) 167, '#', null, false, false, ComponentFlattener.basic(), CharacterAndFormatSet.DEFAULT);
        });
        static final LegacyComponentSerializer AMPERSAND = (LegacyComponentSerializer) LegacyComponentSerializerImpl.SERVICE.map((v0) -> {
            return v0.legacyAmpersand();
        }).orElseGet(() -> {
            return new LegacyComponentSerializerImpl('&', '#', null, false, false, ComponentFlattener.basic(), CharacterAndFormatSet.DEFAULT);
        });

        Instances() {
        }
    }

    LegacyComponentSerializerImpl(char c, char c2, @Nullable TextReplacementConfig textReplacementConfig, boolean z, boolean z2, ComponentFlattener componentFlattener, CharacterAndFormatSet characterAndFormatSet) {
        this.character = c;
        this.hexCharacter = c2;
        this.urlReplacementConfig = textReplacementConfig;
        this.hexColours = z;
        this.useTerriblyStupidHexFormat = z2;
        this.flattener = componentFlattener;
        this.formats = characterAndFormatSet;
    }

    @Nullable
    private FormatCodeType determineFormatType(char c, String str, int i) {
        if (i >= 14) {
            int i2 = i - 13;
            if (str.charAt(i - 14) == this.character && str.charAt(i2) == LEGACY_BUNGEE_HEX_CHAR) {
                return FormatCodeType.BUNGEECORD_UNUSUAL_HEX;
            }
        }
        if (c == this.hexCharacter && str.length() - i >= 6) {
            return FormatCodeType.KYORI_HEX;
        }
        if (this.formats.characters.indexOf(c) != -1) {
            return FormatCodeType.MOJANG_LEGACY;
        }
        return null;
    }

    @Nullable
    static LegacyFormat legacyFormat(char c) {
        int iIndexOf = CharacterAndFormatSet.DEFAULT.characters.indexOf(c);
        if (iIndexOf == -1) {
            return null;
        }
        TextFormat textFormat = CharacterAndFormatSet.DEFAULT.formats.get(iIndexOf);
        if (textFormat instanceof NamedTextColor) {
            return new LegacyFormat((NamedTextColor) textFormat);
        }
        if (textFormat instanceof TextDecoration) {
            return new LegacyFormat((TextDecoration) textFormat);
        }
        if (textFormat instanceof Reset) {
            return LegacyFormat.RESET;
        }
        return null;
    }

    @Nullable
    private DecodedFormat decodeTextFormat(char c, String str, int i) {
        FormatCodeType formatCodeTypeDetermineFormatType = determineFormatType(c, str, i);
        if (formatCodeTypeDetermineFormatType == null) {
            return null;
        }
        if (formatCodeTypeDetermineFormatType == FormatCodeType.KYORI_HEX) {
            TextColor textColorTryParseHexColor = tryParseHexColor(str.substring(i, i + 6));
            if (textColorTryParseHexColor != null) {
                return new DecodedFormat(formatCodeTypeDetermineFormatType, textColorTryParseHexColor);
            }
            return null;
        }
        if (formatCodeTypeDetermineFormatType == FormatCodeType.MOJANG_LEGACY) {
            return new DecodedFormat(formatCodeTypeDetermineFormatType, this.formats.formats.get(this.formats.characters.indexOf(c)));
        }
        if (formatCodeTypeDetermineFormatType != FormatCodeType.BUNGEECORD_UNUSUAL_HEX) {
            return null;
        }
        StringBuilder sb = new StringBuilder(6);
        for (int i2 = i - 1; i2 >= i - 11; i2 -= 2) {
            sb.append(str.charAt(i2));
        }
        TextColor textColorTryParseHexColor2 = tryParseHexColor(sb.reverse().toString());
        if (textColorTryParseHexColor2 != null) {
            return new DecodedFormat(formatCodeTypeDetermineFormatType, textColorTryParseHexColor2);
        }
        return null;
    }

    @Nullable
    private static TextColor tryParseHexColor(String str) {
        try {
            return TextColor.color(Integer.parseInt(str, 16));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static boolean isHexTextColor(TextFormat textFormat) {
        return (textFormat instanceof TextColor) && !(textFormat instanceof NamedTextColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String toLegacyCode(TextFormat textFormat) {
        if (isHexTextColor(textFormat)) {
            TextColor textColor = (TextColor) textFormat;
            if (this.hexColours) {
                String str = String.format("%06x", Integer.valueOf(textColor.value()));
                if (!this.useTerriblyStupidHexFormat) {
                    return this.hexCharacter + str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf('x'));
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    sb.append(this.character).append(str.charAt(i));
                }
                return sb.toString();
            }
            if (!(textColor instanceof NamedTextColor)) {
                textFormat = TextColor.nearestColorTo(this.formats.colors, textColor);
            }
        }
        int iIndexOf = this.formats.formats.indexOf(textFormat);
        if (iIndexOf == -1) {
            return null;
        }
        return Character.toString(this.formats.characters.charAt(iIndexOf));
    }

    private TextComponent extractUrl(TextComponent textComponent) {
        if (this.urlReplacementConfig == null) {
            return textComponent;
        }
        Component componentReplaceText = textComponent.replaceText(this.urlReplacementConfig);
        return componentReplaceText instanceof TextComponent ? (TextComponent) componentReplaceText : Component.text().append(componentReplaceText).build2();
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentDecoder
    @NotNull
    public TextComponent deserialize(@NotNull String str) {
        int iLastIndexOf = str.lastIndexOf(this.character, str.length() - 2);
        if (iLastIndexOf == -1) {
            return extractUrl(Component.text(str));
        }
        ArrayList arrayList = new ArrayList();
        TextComponent.Builder builderText = null;
        boolean zApplyFormat = false;
        int length = str.length();
        do {
            DecodedFormat decodedFormatDecodeTextFormat = decodeTextFormat(str.charAt(iLastIndexOf + 1), str, iLastIndexOf + 2);
            if (decodedFormatDecodeTextFormat != null) {
                int i = iLastIndexOf + (decodedFormatDecodeTextFormat.encodedFormat == FormatCodeType.KYORI_HEX ? 8 : 2);
                if (i != length) {
                    if (builderText == null) {
                        builderText = Component.text();
                    } else if (zApplyFormat) {
                        arrayList.add(builderText.build2());
                        zApplyFormat = false;
                        builderText = Component.text();
                    } else {
                        builderText = Component.text().append((Component) builderText.build2());
                    }
                    builderText.content(str.substring(i, length));
                } else if (builderText == null) {
                    builderText = Component.text();
                }
                if (!zApplyFormat) {
                    zApplyFormat = applyFormat(builderText, decodedFormatDecodeTextFormat.format);
                }
                if (decodedFormatDecodeTextFormat.encodedFormat == FormatCodeType.BUNGEECORD_UNUSUAL_HEX) {
                    iLastIndexOf -= 12;
                }
                length = iLastIndexOf;
            }
            iLastIndexOf = str.lastIndexOf(this.character, iLastIndexOf - 1);
        } while (iLastIndexOf != -1);
        if (builderText != null) {
            arrayList.add((TextComponent) builderText.build2());
        }
        String strSubstring = length > 0 ? str.substring(0, length) : "";
        if (arrayList.size() == 1 && strSubstring.isEmpty()) {
            return extractUrl((TextComponent) arrayList.get(0));
        }
        Collections.reverse(arrayList);
        return extractUrl(Component.text().content(strSubstring).append(arrayList).build2());
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentSerializer, me.ulrich.clans.library.kyori.adventure.text.serializer.ComponentEncoder
    @NotNull
    public String serialize(@NotNull Component component) {
        Cereal cereal = new Cereal();
        this.flattener.flatten(component, cereal);
        return cereal.toString();
    }

    private static boolean applyFormat(TextComponent.Builder builder, @NotNull TextFormat textFormat) {
        if (textFormat instanceof TextColor) {
            builder.colorIfAbsent((TextColor) textFormat);
            return true;
        }
        if (textFormat instanceof TextDecoration) {
            builder.decoration((TextDecoration) textFormat, TextDecoration.State.TRUE);
            return false;
        }
        if (textFormat instanceof Reset) {
            return true;
        }
        throw new IllegalArgumentException(String.format("unknown format '%s'", textFormat.getClass()));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.util.Buildable
    @NotNull
    /* JADX INFO: renamed from: toBuilder */
    public LegacyComponentSerializer.Builder mo683toBuilder() {
        return new BuilderImpl(this);
    }
}
