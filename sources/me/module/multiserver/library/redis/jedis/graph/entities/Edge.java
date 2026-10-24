package me.module.multiserver.library.redis.jedis.graph.entities;

import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/entities/Edge.class */
public class Edge extends GraphEntity {
    private String relationshipType;
    private long source;
    private long destination;

    public Edge() {
    }

    public Edge(int i) {
        super(i);
    }

    public String getRelationshipType() {
        return this.relationshipType;
    }

    public void setRelationshipType(String str) {
        this.relationshipType = str;
    }

    public long getSource() {
        return this.source;
    }

    public void setSource(long j) {
        this.source = j;
    }

    public long getDestination() {
        return this.destination;
    }

    public void setDestination(long j) {
        this.destination = j;
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Edge) || !super.equals(obj)) {
            return false;
        }
        Edge edge = (Edge) obj;
        return this.source == edge.source && this.destination == edge.destination && Objects.equals(this.relationshipType, edge.relationshipType);
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.relationshipType, Long.valueOf(this.source), Long.valueOf(this.destination));
    }

    @Override // me.module.multiserver.library.redis.jedis.graph.entities.GraphEntity
    public String toString() {
        StringBuilder sb = new StringBuilder("Edge{");
        sb.append("relationshipType='").append(this.relationshipType).append('\'');
        sb.append(", source=").append(this.source);
        sb.append(", destination=").append(this.destination);
        sb.append(", id=").append(this.id);
        sb.append(", propertyMap=").append(this.propertyMap);
        sb.append('}');
        return sb.toString();
    }
}
