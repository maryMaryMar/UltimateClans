package me.ulrich.clans.library.nbtapi.wrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/NBTTarget.class */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NBTTarget {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/NBTTarget$Type.class */
    public enum Type {
        AUTOMATIC,
        GET,
        SET,
        HAS
    }

    String value();

    Type type() default Type.AUTOMATIC;
}
