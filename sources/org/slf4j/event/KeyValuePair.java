package org.slf4j.event;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:org/slf4j/event/KeyValuePair.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/slf4j/event/KeyValuePair.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/event/KeyValuePair.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:org/slf4j/event/KeyValuePair.class */
public class KeyValuePair {
    public final String key;
    public final Object value;

    public KeyValuePair(String str, Object obj) {
        this.key = str;
        this.value = obj;
    }

    public String toString() {
        return String.valueOf(this.key) + "=\"" + String.valueOf(this.value) + "\"";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyValuePair keyValuePair = (KeyValuePair) obj;
        return Objects.equals(this.key, keyValuePair.key) && Objects.equals(this.value, keyValuePair.value);
    }

    public int hashCode() {
        return Objects.hash(this.key, this.value);
    }
}
