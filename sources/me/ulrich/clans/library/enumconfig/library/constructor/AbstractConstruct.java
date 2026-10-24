package me.ulrich.clans.library.enumconfig.library.constructor;

import me.ulrich.clans.library.enumconfig.library.error.YAMLException;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/AbstractConstruct.class */
public abstract class AbstractConstruct implements Construct {
    @Override // me.ulrich.clans.library.enumconfig.library.constructor.Construct
    public void construct2ndStep(Node node, Object obj) {
        if (!node.isTwoStepsConstruction()) {
            throw new YAMLException("Unexpected recursive structure for Node: " + node);
        }
        throw new IllegalStateException("Not Implemented in " + getClass().getName());
    }
}
