package me.ulrich.clans.qjkRaOgynIj1;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/qjkRaOgynIj1/jfN3Uc9ymXXFWVHj7Oor.class */
public class jfN3Uc9ymXXFWVHj7Oor {
    private List<Object> v8qP8fE86HMhvNuYPFjqY;
    private int jBUuLP0sWwaPyPOmogdX7l = 1;
    private int ZwrsrwOCXRUscW6Q;

    public jfN3Uc9ymXXFWVHj7Oor(List<Object> list, int i) {
        this.v8qP8fE86HMhvNuYPFjqY = list;
        this.ZwrsrwOCXRUscW6Q = i;
    }

    public int v8qP8fE86HMhvNuYPFjqY(int i) {
        int iCDW4Fj1iwdIXEOqWjiJSR = CDW4Fj1iwdIXEOqWjiJSR();
        if (i < 1) {
            this.jBUuLP0sWwaPyPOmogdX7l = 1;
        } else if (i > iCDW4Fj1iwdIXEOqWjiJSR) {
            this.jBUuLP0sWwaPyPOmogdX7l = iCDW4Fj1iwdIXEOqWjiJSR;
        } else {
            this.jBUuLP0sWwaPyPOmogdX7l = i;
        }
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public List<Object> v8qP8fE86HMhvNuYPFjqY() {
        if (this.jBUuLP0sWwaPyPOmogdX7l < 1 || this.jBUuLP0sWwaPyPOmogdX7l > CDW4Fj1iwdIXEOqWjiJSR()) {
            return new ArrayList();
        }
        int i = (this.jBUuLP0sWwaPyPOmogdX7l - 1) * this.ZwrsrwOCXRUscW6Q;
        return this.v8qP8fE86HMhvNuYPFjqY.subList(i, Math.min(i + this.ZwrsrwOCXRUscW6Q, this.v8qP8fE86HMhvNuYPFjqY.size()));
    }

    public boolean jBUuLP0sWwaPyPOmogdX7l() {
        return this.jBUuLP0sWwaPyPOmogdX7l < CDW4Fj1iwdIXEOqWjiJSR();
    }

    public boolean ZwrsrwOCXRUscW6Q() {
        return this.jBUuLP0sWwaPyPOmogdX7l > 1;
    }

    public int iZTqZaRK5UGoe0Z() {
        return jBUuLP0sWwaPyPOmogdX7l() ? this.jBUuLP0sWwaPyPOmogdX7l + 1 : this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public int xtOheRiObl4QeAl() {
        return ZwrsrwOCXRUscW6Q() ? this.jBUuLP0sWwaPyPOmogdX7l - 1 : this.jBUuLP0sWwaPyPOmogdX7l;
    }

    public int zJnaNCVQSgEShq() {
        return CDW4Fj1iwdIXEOqWjiJSR();
    }

    private int CDW4Fj1iwdIXEOqWjiJSR() {
        return (int) Math.ceil(((double) this.v8qP8fE86HMhvNuYPFjqY.size()) / ((double) this.ZwrsrwOCXRUscW6Q));
    }
}
