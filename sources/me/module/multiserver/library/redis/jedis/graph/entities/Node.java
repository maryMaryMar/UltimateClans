package me.module.multiserver.library.redis.jedis.graph.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/entities/Node.class */
public class Node extends GraphEntity {
    private final List<String> labels;

    public Node() {
        this.labels = new ArrayList();
    }

    public Node(int i, int i2) {
        super(i2);
        this.labels = new ArrayList(i);
    }

    public void addLabel(String str) {
        this.labels.add(str);
    }

    public void removeLabel(String str) {
        this.labels.remove(str);
    }

    public String getLabel(int i) {
        return this.labels.get(i);
    }

    public int getNumberOfLabels() {
        return this.labels.size();
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Node) && super.equals(obj)) {
            return Objects.equals(this.labels, ((Node) obj).labels);
        }
        return false;
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.labels);
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity
    public String toString() {
        StringBuilder sb = new StringBuilder("Node{");
        sb.append("labels=").append(this.labels);
        sb.append(", id=").append(this.id);
        sb.append(", propertyMap=").append(this.propertyMap);
        sb.append('}');
        return sb.toString();
    }
}
