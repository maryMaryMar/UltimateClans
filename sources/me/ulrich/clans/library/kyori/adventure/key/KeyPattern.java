package me.ulrich.clans.library.kyori.adventure.key;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.intellij.lang.annotations.Pattern;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/KeyPattern.class */
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PARAMETER})
@Pattern("(?:([a-z0-9_\\-.]+:)?|:)[a-z0-9_\\-./]+")
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface KeyPattern {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/KeyPattern$Namespace.class */
    @Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PARAMETER})
    @Pattern("[a-z0-9_\\-.]+")
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Namespace {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/kyori/adventure/key/KeyPattern$Value.class */
    @Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PARAMETER})
    @Pattern("[a-z0-9_\\-./]+")
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Value {
    }
}
