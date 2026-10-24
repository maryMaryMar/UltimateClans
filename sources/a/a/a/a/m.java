package a.a.a.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/a/a/m.class */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
public @interface m {
    String a();

    String[] b() default {};

    String[] c() default {};
}
