package me.module.multiserver.library.redis.jedis.graph.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/entities/GraphEntity.class */
public abstract class GraphEntity {
    protected long id;
    protected final Map<String, Property<?>> propertyMap;

    public GraphEntity() {
        this.propertyMap = new HashMap();
    }

    public GraphEntity(int i) {
        this.propertyMap = new HashMap(i);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void addProperty(String str, Object obj) {
        addProperty(new Property(str, obj));
    }

    public Set<String> getEntityPropertyNames() {
        return this.propertyMap.keySet();
    }

    public void addProperty(Property property) {
        this.propertyMap.put(property.getName(), property);
    }

    public int getNumberOfProperties() {
        return this.propertyMap.size();
    }

    public Property getProperty(String str) {
        return this.propertyMap.get(str);
    }

    public void removeProperty(String str) {
        this.propertyMap.remove(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphEntity)) {
            return false;
        }
        GraphEntity graphEntity = (GraphEntity) obj;
        return this.id == graphEntity.id && Objects.equals(this.propertyMap, graphEntity.propertyMap);
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.id), this.propertyMap);
    }

    public abstract String toString();
}
