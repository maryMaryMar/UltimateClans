package me.ulrich.clans.tasks;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/bUQFEznViQX6XlU8D.class */
public class bUQFEznViQX6XlU8D extends TimerTask {
    private ScheduledExecutorService v8qP8fE86HMhvNuYPFjqY;
    private Clans jBUuLP0sWwaPyPOmogdX7l;

    public bUQFEznViQX6XlU8D(Clans clans) {
        this.jBUuLP0sWwaPyPOmogdX7l = clans;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.jBUuLP0sWwaPyPOmogdX7l.getTopManager().v8qP8fE86HMhvNuYPFjqY(new ArrayList());
        this.jBUuLP0sWwaPyPOmogdX7l.getTopManager().jBUuLP0sWwaPyPOmogdX7l(new ArrayList());
    }

    public ScheduledExecutorService v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    public Clans jBUuLP0sWwaPyPOmogdX7l() {
        return this.jBUuLP0sWwaPyPOmogdX7l;
    }
}
