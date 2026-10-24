package me.ulrich.clans.library.enumconfig.library.serializer;

import java.text.NumberFormat;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/serializer/NumberAnchorGenerator.class */
public class NumberAnchorGenerator implements AnchorGenerator {
    private int lastAnchorId;

    public NumberAnchorGenerator(int i) {
        this.lastAnchorId = 0;
        this.lastAnchorId = i;
    }

    @Override // me.ulrich.clans.library.enumconfig.library.serializer.AnchorGenerator
    public String nextAnchor(Node node) {
        if (node.getAnchor() != null) {
            return node.getAnchor();
        }
        this.lastAnchorId++;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(3);
        numberInstance.setMaximumFractionDigits(0);
        numberInstance.setGroupingUsed(false);
        return "id" + numberInstance.format(this.lastAnchorId);
    }
}
