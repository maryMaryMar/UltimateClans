package me.ulrich.clans.library.kyori.adventure.text.minimessage.internal;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.TagPattern;
import org.intellij.lang.annotations.RegExp;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/internal/TagInternals.class */
@ApiStatus.Internal
public final class TagInternals {

    @RegExp
    public static final String TAG_NAME_REGEX = "[!?#]?[a-z0-9_-]*";
    private static final Pattern TAG_NAME_PATTERN = Pattern.compile(TAG_NAME_REGEX);

    private TagInternals() {
    }

    public static void assertValidTagName(@TagPattern @NotNull String str) {
        if (!TAG_NAME_PATTERN.matcher((CharSequence) Objects.requireNonNull(str)).matches()) {
            throw new IllegalArgumentException("Tag name must match pattern " + TAG_NAME_PATTERN.pattern() + ", was " + str);
        }
    }

    public static boolean sanitizeAndCheckValidTagName(@TagPattern @NotNull String str) {
        return TAG_NAME_PATTERN.matcher(((String) Objects.requireNonNull(str)).toLowerCase(Locale.ROOT)).matches();
    }

    public static void sanitizeAndAssertValidTagName(@TagPattern @NotNull String str) {
        assertValidTagName(((String) Objects.requireNonNull(str)).toLowerCase(Locale.ROOT));
    }
}
