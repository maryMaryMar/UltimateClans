package a.a.b;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: a.a.b.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/d.class */
public interface InterfaceC0011d {
    String a(Field field);

    default List<String> b(Field field) {
        return Collections.emptyList();
    }
}
