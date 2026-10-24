package me.ulrich.clans.tjCyMSV004ze7Mc;

import me.ulrich.clans.Clans;
import me.ulrich.entitywizard.packetevents.event.PacketListener;
import me.ulrich.entitywizard.packetevents.event.PacketListenerPriority;
import me.ulrich.entitywizard.packetevents.event.SimplePacketListenerAbstract;
import me.ulrich.entitywizard.packetevents.event.simple.PacketPlayReceiveEvent;
import me.ulrich.entitywizard.packetevents.event.simple.PacketPlaySendEvent;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH extends SimplePacketListenerAbstract implements PacketListener {
    private Clans v8qP8fE86HMhvNuYPFjqY;

    public UsEbiuprSHpNw3qjITfH(Clans clans) {
        super(PacketListenerPriority.HIGH);
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public void v8qP8fE86HMhvNuYPFjqY(PacketPlaySendEvent packetPlaySendEvent) {
    }

    public void v8qP8fE86HMhvNuYPFjqY(PacketPlayReceiveEvent packetPlayReceiveEvent) {
        if (((Player) packetPlayReceiveEvent.getPlayer()) == null) {
        }
    }
}
