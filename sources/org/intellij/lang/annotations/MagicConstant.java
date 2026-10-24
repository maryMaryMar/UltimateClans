package org.intellij.lang.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.NonNls;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/intellij/lang/annotations/MagicConstant.class */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface MagicConstant {
    long[] intValues() default {};

    @NonNls
    String[] stringValues() default {};

    long[] flags() default {};

    Class<?> valuesFromClass() default void.class;

    Class<?> flagsFromClass() default void.class;
}
