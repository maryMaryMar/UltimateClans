package me.ulrich.clans.library.enumconfig.library.representer;

import java.util.Base64;
import java.util.Date;
import me.ulrich.clans.library.enumconfig.library.DumperOptions;
import me.ulrich.clans.library.enumconfig.library.nodes.Node;
import me.ulrich.clans.library.enumconfig.library.nodes.Tag;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/JsonRepresenter.class */
public class JsonRepresenter extends Representer {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/JsonRepresenter$RepresentByteArray.class */
    protected class RepresentByteArray implements Represent {
        protected RepresentByteArray() {
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.Represent
        public Node representData(Object obj) {
            return JsonRepresenter.this.representScalar(Tag.STR, Base64.getEncoder().encodeToString((byte[]) obj));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/representer/JsonRepresenter$RepresentDate.class */
    protected class RepresentDate extends SafeRepresenter.RepresentDate {
        protected RepresentDate() {
            super();
        }

        @Override // me.ulrich.clans.library.enumconfig.library.representer.SafeRepresenter.RepresentDate
        public Tag getDefaultTag() {
            return Tag.STR;
        }
    }

    public JsonRepresenter(DumperOptions dumperOptions) {
        super(dumperOptions);
        this.representers.put(byte[].class, new RepresentByteArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        if (dumperOptions.getDefaultScalarStyle() != DumperOptions.ScalarStyle.JSON_SCALAR_STYLE) {
            throw new IllegalStateException("JSON requires ScalarStyle.JSON_SCALAR_STYLE");
        }
        if (dumperOptions.getNonPrintableStyle() != DumperOptions.NonPrintableStyle.ESCAPE) {
            throw new IllegalStateException("JSON requires NonPrintableStyle.ESCAPE");
        }
    }
}
