package me.module.mail.manager;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/h.class */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Object> f141a;
    private int b = 1;
    private int c;

    public h(List<Object> list, int i) {
        this.f141a = list;
        this.c = i;
    }

    public int a(int i) {
        int iG = g();
        if (i < 1) {
            this.b = 1;
        } else if (i > iG) {
            this.b = iG;
        } else {
            this.b = i;
        }
        return this.b;
    }

    public List<Object> a() {
        if (this.b < 1 || this.b > g()) {
            return new ArrayList();
        }
        int i = (this.b - 1) * this.c;
        return this.f141a.subList(i, Math.min(i + this.c, this.f141a.size()));
    }

    public boolean b() {
        return this.b < g();
    }

    public boolean c() {
        return this.b > 1;
    }

    public int d() {
        return b() ? this.b + 1 : this.b;
    }

    public int e() {
        return c() ? this.b - 1 : this.b;
    }

    public int f() {
        return g();
    }

    private int g() {
        return (int) Math.ceil(((double) this.f141a.size()) / ((double) this.c));
    }
}
