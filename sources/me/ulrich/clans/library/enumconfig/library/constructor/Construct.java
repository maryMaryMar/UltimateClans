package me.ulrich.clans.library.enumconfig.library.constructor;

import me.ulrich.clans.library.enumconfig.library.nodes.Node;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/constructor/Construct.class */
public interface Construct {
    Object construct(Node node);

    void construct2ndStep(Node node, Object obj);
}
