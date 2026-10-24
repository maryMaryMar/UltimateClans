package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/jetbrains/annotations/Range.class */
@Target({ElementType.TYPE_USE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Range {
    long from();

    long to();
}
