package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.format.NamedTextColor;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.Emitable;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.SerializableResolver;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.serializer.TokenEmitter;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/GradientTag.class */
class GradientTag extends AbstractColorChangingTag {
    private int index;
    private double multiplier;
    private final TextColor[] colors;
    double phase;
    private final boolean negativePhase;
    private static final TextColor DEFAULT_WHITE = TextColor.color(16777215);
    private static final TextColor DEFAULT_BLACK = TextColor.color(0);
    private static final String GRADIENT = "gradient";
    static final TagResolver RESOLVER = SerializableResolver.claimingComponent(GRADIENT, (BiFunction<ArgumentQueue, Context, Tag>) GradientTag::create, (Function<Component, Emitable>) AbstractColorChangingTag::claimComponent);

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        List listEmptyList;
        double asDouble = 0.0d;
        if (argumentQueue.hasNext()) {
            listEmptyList = new ArrayList();
            while (argumentQueue.hasNext()) {
                Tag.Argument argumentPop = argumentQueue.pop();
                String strValue = argumentPop.value();
                TextColor textColorResolveColorOrNull = ColorTagResolver.resolveColorOrNull(strValue);
                if (textColorResolveColorOrNull == null) {
                    if (!argumentQueue.hasNext()) {
                        OptionalDouble optionalDoubleAsDouble = argumentPop.asDouble();
                        if (optionalDoubleAsDouble.isPresent()) {
                            asDouble = optionalDoubleAsDouble.getAsDouble();
                            if (asDouble >= -1.0d && asDouble <= 1.0d) {
                                break;
                            }
                            throw context.newException(String.format("Gradient phase is out of range (%s). Must be in the range [-1.0, 1.0] (inclusive).", Double.valueOf(asDouble)), argumentQueue);
                        }
                    }
                    throw context.newException(String.format("Unable to parse a color from '%s'. Please use named colors or hex (#RRGGBB) colors.", strValue), argumentQueue);
                }
                listEmptyList.add(textColorResolveColorOrNull);
            }
            if (listEmptyList.size() == 1) {
                throw context.newException("Invalid gradient, not enough colors. Gradients must have at least two colors.", argumentQueue);
            }
        } else {
            listEmptyList = Collections.emptyList();
        }
        return new GradientTag(asDouble, listEmptyList, context);
    }

    GradientTag(double d, List<TextColor> list, Context context) {
        super(context);
        this.index = 0;
        this.multiplier = 1.0d;
        if (list.isEmpty()) {
            this.colors = new TextColor[]{DEFAULT_WHITE, DEFAULT_BLACK};
        } else {
            this.colors = (TextColor[]) list.toArray(new TextColor[0]);
        }
        if (d >= 0.0d) {
            this.negativePhase = false;
            this.phase = d;
        } else {
            this.negativePhase = true;
            this.phase = 1.0d + d;
            Collections.reverse(Arrays.asList(this.colors));
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    protected void init() {
        this.multiplier = size() == 1 ? 0.0d : ((double) (this.colors.length - 1)) / ((double) (size() - 1));
        this.phase *= (double) (this.colors.length - 1);
        this.index = 0;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    protected void advanceColor() {
        this.index++;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    protected TextColor color() {
        double d = (((double) this.index) * this.multiplier) + this.phase;
        int iFloor = (int) Math.floor(d);
        return TextColor.lerp(((float) d) - iFloor, this.colors[iFloor % this.colors.length], this.colors[((int) Math.ceil(d)) % this.colors.length]);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    @NotNull
    protected Consumer<TokenEmitter> preserveData() {
        TextColor[] textColorArr;
        double d;
        if (this.negativePhase) {
            textColorArr = (TextColor[]) Arrays.copyOf(this.colors, this.colors.length);
            Collections.reverse(Arrays.asList(textColorArr));
            d = this.phase - 1.0d;
        } else {
            textColorArr = this.colors;
            d = this.phase;
        }
        TextColor[] textColorArr2 = textColorArr;
        double d2 = d;
        return tokenEmitter -> {
            tokenEmitter.tag(GRADIENT);
            if (textColorArr2.length != 2 || !textColorArr2[0].equals(DEFAULT_WHITE) || !textColorArr2[1].equals(DEFAULT_BLACK)) {
                for (TextColor textColor : textColorArr2) {
                    if (textColor instanceof NamedTextColor) {
                        tokenEmitter.argument(NamedTextColor.NAMES.keyOrThrow((NamedTextColor) textColor));
                    } else {
                        tokenEmitter.argument(textColor.asHexString());
                    }
                }
            }
            if (d2 != 0.0d) {
                tokenEmitter.argument(Double.toString(d2));
            }
        };
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("phase", this.phase), ExaminableProperty.of("colors", this.colors)});
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GradientTag gradientTag = (GradientTag) obj;
        return this.index == gradientTag.index && this.phase == gradientTag.phase && Arrays.equals(this.colors, gradientTag.colors);
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    public int hashCode() {
        return (31 * Objects.hash(Integer.valueOf(this.index), Double.valueOf(this.phase))) + Arrays.hashCode(this.colors);
    }
}
