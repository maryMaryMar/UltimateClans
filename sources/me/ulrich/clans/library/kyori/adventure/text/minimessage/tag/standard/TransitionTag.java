package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.examination.Examinable;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/TransitionTag.class */
public final class TransitionTag implements Inserting, Examinable {
    private final TextColor[] colors;
    private final float phase;
    private final boolean negativePhase;
    public static final String TRANSITION = "transition";
    static final TagResolver RESOLVER = TagResolver.resolver(TRANSITION, (BiFunction<ArgumentQueue, Context, Tag>) TransitionTag::create);

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        List listEmptyList;
        float asDouble = 0.0f;
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
                            asDouble = (float) optionalDoubleAsDouble.getAsDouble();
                            if (asDouble >= -1.0f && asDouble <= 1.0f) {
                                break;
                            }
                            throw context.newException(String.format("Gradient phase is out of range (%s). Must be in the range [-1.0f, 1.0f] (inclusive).", Float.valueOf(asDouble)), argumentQueue);
                        }
                    }
                    throw context.newException(String.format("Unable to parse a color from '%s'. Please use named colors or hex (#RRGGBB) colors.", strValue), argumentQueue);
                }
                listEmptyList.add(textColorResolveColorOrNull);
            }
            if (listEmptyList.size() < 2) {
                throw context.newException("Invalid transition, not enough colors. Transitions must have at least two colors.", argumentQueue);
            }
        } else {
            listEmptyList = Collections.emptyList();
        }
        return new TransitionTag(asDouble, listEmptyList);
    }

    private TransitionTag(float f, List<TextColor> list) {
        if (f < 0.0f) {
            this.negativePhase = true;
            this.phase = 1.0f + f;
            Collections.reverse(list);
        } else {
            this.negativePhase = false;
            this.phase = f;
        }
        if (list.isEmpty()) {
            this.colors = new TextColor[]{TextColor.color(16777215), TextColor.color(0)};
        } else {
            this.colors = (TextColor[]) list.toArray(new TextColor[0]);
        }
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Inserting
    @NotNull
    public Component value() {
        return Component.text("", color());
    }

    private TextColor color() {
        float length = 1.0f / (this.colors.length - 1);
        for (int i = 1; i < this.colors.length; i++) {
            float f = i * length;
            if (f >= this.phase) {
                float length2 = 1.0f + ((this.phase - f) * (this.colors.length - 1));
                return this.negativePhase ? TextColor.lerp(1.0f - length2, this.colors[i], this.colors[i - 1]) : TextColor.lerp(length2, this.colors[i - 1], this.colors[i]);
            }
        }
        return this.colors[0];
    }

    @Override // me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("phase", this.phase), ExaminableProperty.of("colors", this.colors)});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TransitionTag transitionTag = (TransitionTag) obj;
        return this.phase == transitionTag.phase && Arrays.equals(this.colors, transitionTag.colors);
    }

    public int hashCode() {
        return (31 * Objects.hash(Float.valueOf(this.phase))) + Arrays.hashCode(this.colors);
    }
}
