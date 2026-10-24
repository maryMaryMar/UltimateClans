package me.ulrich.clans.library.kyori.adventure.text.minimessage.tag;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.internal.TagInternals;
import org.intellij.lang.annotations.Pattern;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/text/minimessage/tag/TagPattern.class */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Pattern(TagInternals.TAG_NAME_REGEX)
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface TagPattern {
}
