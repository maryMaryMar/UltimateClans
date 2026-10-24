package org.slf4j.spi;

import java.util.Deque;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/spi/MDCAdapter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/spi/MDCAdapter.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/MDCAdapter.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/spi/MDCAdapter.class */
public interface MDCAdapter {
    void put(String str, String str2);

    String get(String str);

    void remove(String str);

    void clear();

    Map<String, String> getCopyOfContextMap();

    void setContextMap(Map<String, String> map);

    void pushByKey(String str, String str2);

    String popByKey(String str);

    Deque<String> getCopyOfDequeByKey(String str);

    void clearDequeByKey(String str);
}
