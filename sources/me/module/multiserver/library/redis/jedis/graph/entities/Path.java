package me.module.multiserver.library.redis.jedis.graph.entities;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/entities/Path.class */
public final class Path {
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Path(List<Node> list, List<Edge> list2) {
        this.nodes = list;
        this.edges = list2;
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public int length() {
        return this.edges.size();
    }

    public int nodeCount() {
        return this.nodes.size();
    }

    public Node firstNode() {
        return this.nodes.get(0);
    }

    public Node lastNode() {
        return this.nodes.get(this.nodes.size() - 1);
    }

    public Node getNode(int i) {
        return this.nodes.get(i);
    }

    public Edge getEdge(int i) {
        return this.edges.get(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Path path = (Path) obj;
        return Objects.equals(this.nodes, path.nodes) && Objects.equals(this.edges, path.edges);
    }

    public int hashCode() {
        return Objects.hash(this.nodes, this.edges);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Path{");
        sb.append("nodes=").append(this.nodes);
        sb.append(", edges=").append(this.edges);
        sb.append('}');
        return sb.toString();
    }
}
