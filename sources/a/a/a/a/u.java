package a.a.a.a;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/a/a/u.class */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface u {
    String a();

    String b() default "";

    String c() default "";

    Class<? extends Annotation>[] d() default {};

    Class<? extends Annotation>[] e() default {};
}
