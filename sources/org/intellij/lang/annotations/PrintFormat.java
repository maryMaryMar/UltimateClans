package org.intellij.lang.annotations;

import java.lang.annotation.Documented;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/intellij/lang/annotations/PrintFormat.class */
@Pattern("(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*")
@Documented
public @interface PrintFormat {
}
