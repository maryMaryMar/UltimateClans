package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.ulrich.clans.library.kyori.adventure.text.format.TextColor;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.Context;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.Tag;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import me.ulrich.clans.library.kyori.examination.ExaminableProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/standard/PrideTag.class */
final class PrideTag extends GradientTag {
    private static final String PRIDE = "pride";
    static final TagResolver RESOLVER = TagResolver.resolver(PRIDE, (BiFunction<ArgumentQueue, Context, Tag>) PrideTag::create);
    private static final Map<String, List<TextColor>> FLAGS;
    private final String flag;

    static Tag create(ArgumentQueue argumentQueue, Context context) {
        double d = 0.0d;
        String str = PRIDE;
        if (argumentQueue.hasNext()) {
            String lowerCase = argumentQueue.pop().value().toLowerCase(Locale.ROOT);
            if (FLAGS.containsKey(lowerCase)) {
                str = lowerCase;
            } else if (!lowerCase.isEmpty()) {
                try {
                    d = Double.parseDouble(lowerCase);
                    if (d < -1.0d || d > 1.0d) {
                        throw context.newException(String.format("Gradient phase is out of range (%s). Must be in the range [-1.0, 1.0] (inclusive).", Double.valueOf(d)), argumentQueue);
                    }
                } catch (NumberFormatException e) {
                    throw context.newException("Expected phase, got " + lowerCase);
                }
            }
        }
        return new PrideTag(d, FLAGS.get(str), str, context);
    }

    PrideTag(double d, @NotNull List<TextColor> list, @NotNull String str, Context context) {
        super(d, list, context);
        this.flag = str;
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.GradientTag, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag, me.ulrich.clans.library.kyori.examination.Examinable
    @NotNull
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((Object[]) new ExaminableProperty[]{ExaminableProperty.of("flag", this.flag), ExaminableProperty.of("phase", this.phase)});
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.GradientTag, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    public int hashCode() {
        return Objects.hash(this.flag, Double.valueOf(this.phase));
    }

    @Override // me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.GradientTag, me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.standard.AbstractColorChangingTag
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrideTag prideTag = (PrideTag) obj;
        return this.phase == prideTag.phase && this.flag.equals(prideTag.flag);
    }

    @NotNull
    private static List<TextColor> colors(int... iArr) {
        return (List) Arrays.stream(iArr).mapToObj(TextColor::color).collect(Collectors.toList());
    }

    static {
        HashMap map = new HashMap();
        map.put(PRIDE, colors(15007744, 16747776, 16772608, 164129, 19711, 7798920));
        map.put("progress", colors(16777215, 16756679, 7591918, 6371605, 0, 15007744, 16747776, 16772608, 164129, 19711, 7798920));
        map.put("trans", colors(6017019, 16100281, 16777215, 16100281, 6017019));
        map.put("bi", colors(14025328, 10178454, 14504));
        map.put("pan", colors(16718989, 16766720, 1750015));
        map.put("nb", colors(16577585, 16579836, 10312146, 2631720));
        map.put("lesbian", colors(14034944, 16751446, 16777215, 13918886, 10748002));
        map.put("ace", colors(0, 10790052, 16777215, 8454273));
        map.put("agender", colors(0, 12237498, 16777215, 12252292, 16777215, 12237498, 0));
        map.put("demisexual", colors(0, 16777215, 7209073, 13882323));
        map.put("genderqueer", colors(11894749, 16777215, 4817438));
        map.put("genderfluid", colors(16676514, 16777215, 12522199, 0, 3161278));
        map.put("intersex", colors(16766976, 7930538, 16766976));
        map.put("aro", colors(3909440, 11064442, 16777215, 11250603, 0));
        map.put("baker", colors(13461247, 16737689, 16646144, 16685312, 16776961, 39168, 39371, 3473561, 10027161));
        map.put("philly", colors(0, 7884567, 16646144, 16616448, 16770304, 1154827, 410803, 12725980));
        map.put("queer", colors(0, 10148330, 41960, 11920669, 16777215, 16763149, 16541287, 16690889, 0));
        map.put("gay", colors(495216, 2543274, 10021057, 16777215, 8105442, 5261771, 4004472));
        map.put("bigender", colors(12876192, 15509195, 14010344, 16777215, 14010344, 10143720, 7111631));
        map.put("demigender", colors(8355711, 12829635, 16514932, 16777215, 16514932, 12829635, 8355711));
        FLAGS = Collections.unmodifiableMap(map);
    }
}
