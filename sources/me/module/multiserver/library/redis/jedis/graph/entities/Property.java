package me.module.multiserver.library.redis.jedis.graph.entities;

import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/entities/Property.class */
public class Property<T> {
    private final String name;
    private final T value;

    public Property(String str, T t) {
        this.name = str;
        this.value = t;
    }

    public String getName() {
        return this.name;
    }

    public T getValue() {
        return this.value;
    }

    private boolean valueEquals(Object obj, Object obj2) {
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).longValue());
        }
        if (obj2 instanceof Integer) {
            obj2 = Long.valueOf(((Integer) obj2).longValue());
        }
        return Objects.equals(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Property)) {
            return false;
        }
        Property property = (Property) obj;
        return Objects.equals(this.name, property.name) && valueEquals(this.value, property.value);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Property{");
        sb.append("name='").append(this.name).append('\'');
        sb.append(", value=").append(this.value);
        sb.append('}');
        return sb.toString();
    }
}
