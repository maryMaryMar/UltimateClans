package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.adventure.util.HSVLike;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/RainbowTag.class */
final class RainbowTag extends AbstractColorChangingTag {
    private static final String REVERSE = "!";
    private static final String RAINBOW = "rainbow";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(RAINBOW, (BiFunction<ArgumentQueue, Context, Tag>) RainbowTag::create, (Function<Component, Emitable>) AbstractColorChangingTag::claimComponent);
    private final boolean reversed;
    private final double dividedPhase;
    private int colorIndex;

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        boolean z = false;
        int i = 0;
        if (argumentQueue.hasNext()) {
            String strValue = argumentQueue.pop().value();
            if (strValue.startsWith("!")) {
                z = true;
                strValue = strValue.substring("!".length());
            }
            if (strValue.length() > 0) {
                try {
                    i = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    throw context.newException("Expected phase, got " + strValue);
                }
            }
        }
        return new RainbowTag(z, i, context);
    }

    private RainbowTag(boolean z, int i, Context context) {
        super(context);
        this.colorIndex = 0;
        this.reversed = z;
        this.dividedPhase = ((double) i) / 10.0d;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    protected void init() {
        if (this.reversed) {
            this.colorIndex = size() - 1;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    protected void advanceColor() {
        if (!this.reversed) {
            this.colorIndex++;
        } else if (this.colorIndex == 0) {
            this.colorIndex = size() - 1;
        } else {
            this.colorIndex--;
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    protected TextColor color() {
        return TextColor.color(HSVLike.hsvLike((float) ((((double) (this.colorIndex / size())) + this.dividedPhase) % 1.0d), 1.0f, 1.0f));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    @NotNull
    protected Consumer<TokenEmitter> preserveData() {
        boolean z = this.reversed;
        int iRound = (int) Math.round(this.dividedPhase * 10.0d);
        return tokenEmitter -> {
            tokenEmitter.tag(RAINBOW);
            if (z && iRound != 0) {
                tokenEmitter.argument("!" + iRound);
            } else if (z) {
                tokenEmitter.argument("!");
            } else if (iRound != 0) {
                tokenEmitter.argument(Integer.toString(iRound));
            }
        };
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("phase", this.dividedPhase));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RainbowTag rainbowTag = (RainbowTag) obj;
        return this.colorIndex == rainbowTag.colorIndex && this.dividedPhase == rainbowTag.dividedPhase;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.colorIndex), Double.valueOf(this.dividedPhase));
    }
}
