package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus.class */
public final class ApiStatus {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$AvailableSince.class */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface AvailableSince {
        String value();
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$Experimental.class */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Experimental {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$Internal.class */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Internal {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$NonExtendable.class */
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface NonExtendable {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$Obsolete.class */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Obsolete {
        String since() default "";
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$OverrideOnly.class */
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface OverrideOnly {
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/ApiStatus$ScheduledForRemoval.class */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface ScheduledForRemoval {
        String inVersion() default "";
    }

    private ApiStatus() {
        throw new AssertionError("ApiStatus should not be instantiated");
    }
}
