package me.ulrich.clans.library.enumconfig.library.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ulrich.clans.library.enumconfig.library.nodes.MappingNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.NodeTuple;
import me.ulrich.clans.library.enumconfig.library.nodes.ScalarNode;
import me.ulrich.clans.library.enumconfig.library.nodes.SequenceNode;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/MergeUtils.class */
public abstract class MergeUtils {
    public abstract MappingNode asMappingNode(Node node);

    public List<NodeTuple> flatten(MappingNode mappingNode) {
        List<NodeTuple> value = mappingNode.getValue();
        List<NodeTuple> list = value;
        boolean z = true;
        while (z) {
            z = false;
            ArrayList arrayList = new ArrayList(value.size());
            HashSet hashSet = new HashSet(value.size());
            ArrayList arrayList2 = new ArrayList(2);
            for (NodeTuple nodeTuple : value) {
                Node keyNode = nodeTuple.getKeyNode();
                if (keyNode.getTag().equals(Tag.MERGE)) {
                    arrayList2.add(nodeTuple);
                } else {
                    arrayList.add(nodeTuple);
                    if (keyNode instanceof ScalarNode) {
                        hashSet.add(((ScalarNode) keyNode).getValue());
                    }
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Node valueNode = ((NodeTuple) it.next()).getValueNode();
                if (valueNode instanceof SequenceNode) {
                    Iterator<Node> it2 = ((SequenceNode) valueNode).getValue().iterator();
                    while (it2.hasNext()) {
                        MappingNode mappingNodeAsMappingNode = asMappingNode(it2.next());
                        z = z || mappingNodeAsMappingNode.isMerged();
                        Tuple<List<NodeTuple>, Set<String>> tupleFilter = filter(mappingNodeAsMappingNode.getValue(), hashSet);
                        arrayList.addAll(tupleFilter._1());
                        hashSet.addAll(tupleFilter._2());
                    }
                } else {
                    MappingNode mappingNodeAsMappingNode2 = asMappingNode(valueNode);
                    z = z || mappingNodeAsMappingNode2.isMerged();
                    Tuple<List<NodeTuple>, Set<String>> tupleFilter2 = filter(mappingNodeAsMappingNode2.getValue(), hashSet);
                    arrayList.addAll(tupleFilter2._1());
                    hashSet.addAll(tupleFilter2._2());
                }
            }
            list = arrayList;
            if (z) {
                value = arrayList;
            }
        }
        return list;
    }

    private Tuple<List<NodeTuple>, Set<String>> filter(List<NodeTuple> list, Set<String> set) {
        int size = list.size();
        HashSet hashSet = new HashSet(size);
        ArrayList arrayList = new ArrayList(size);
        for (NodeTuple nodeTuple : list) {
            Node keyNode = nodeTuple.getKeyNode();
            if (keyNode instanceof ScalarNode) {
                String value = ((ScalarNode) keyNode).getValue();
                if (!set.contains(value)) {
                    arrayList.add(nodeTuple);
                    hashSet.add(value);
                }
            } else {
                arrayList.add(nodeTuple);
            }
        }
        return new Tuple<>(arrayList, hashSet);
    }
}
