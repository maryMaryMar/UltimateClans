package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.objective;

import java.util.Collection;
import java.util.Objects;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import me.ulrich.clans.library.kyori.adventure.translation.GlobalTranslator;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import me.ulrich.clans.library.scoreboardlibrary.implementation.commons.LegacyFormatUtil;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsClasses;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsEnums;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsObjectives;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectiveConstants;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.LocalePacketUtil;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.FieldAccessor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/objective/LegacyObjectivePacketAdapterImpl.class */
public final class LegacyObjectivePacketAdapterImpl implements ObjectivePacketAdapter {
    private final PacketAdapterProviderImpl provider;
    private final String objectiveName;
    private Object removePacket;

    public LegacyObjectivePacketAdapterImpl(PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
        this.provider = packetAdapterProviderImpl;
        this.objectiveName = str;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    @NotNull
    public String objectiveName() {
        return this.objectiveName;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void display(@NotNull Collection<Player> collection, @NotNull ObjectiveDisplaySlot objectiveDisplaySlot) {
        Object objInvoke = NmsObjectives.DISPLAY_CONSTRUCTOR.invoke(new Object[0]);
        ((FieldAccessor) Objects.requireNonNull(NmsObjectives.DISPLAY_SLOT)).set(objInvoke, Integer.valueOf(ObjectiveConstants.displaySlotIndex(objectiveDisplaySlot, false)));
        NmsObjectives.DISPLAY_OBJECTIVE_NAME.set(objInvoke, this.objectiveName);
        this.provider.packetSender().sendPacket(collection, objInvoke);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void sendProperties(@NotNull Collection<Player> collection, @NotNull PropertiesPacketType propertiesPacketType, @NotNull Component component, @NotNull ObjectiveRenderType objectiveRenderType, @Nullable ScoreFormat scoreFormat) {
        LocalePacketUtil.sendLocalePackets(this.provider.packetSender(), collection, locale -> {
            return createPropertiesPacket(propertiesPacketType, GlobalTranslator.render(component, locale), objectiveRenderType);
        });
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void remove(@NotNull Collection<Player> collection) {
        if (this.removePacket == null) {
            this.removePacket = NmsObjectives.OBJECTIVE_PACKET_CONSTRUCTOR.invoke(new Object[0]);
            NmsObjectives.OBJECTIVE_NAME_FIELD.set(this.removePacket, this.objectiveName);
            NmsObjectives.OBJECTIVE_VALUE_FIELD.set(this.removePacket, "");
            NmsObjectives.OBJECTIVE_MODE_FIELD.set(this.removePacket, 1);
        }
        this.provider.packetSender().sendPacket(collection, this.removePacket);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void sendScore(@NotNull Collection<Player> collection, @NotNull String str, int i, @Nullable Component component, @Nullable ScoreFormat scoreFormat) {
        Object objInvoke = NmsObjectives.SCORE_CONSTRUCTOR.invoke(str);
        ((FieldAccessor) Objects.requireNonNull(NmsObjectives.SCORE_OBJECTIVE_NAME_FIELD)).set(objInvoke, this.objectiveName);
        ((FieldAccessor) Objects.requireNonNull(NmsObjectives.SCORE_VALUE_FIELD)).set(objInvoke, Integer.valueOf(i));
        if (NmsClasses.IS_1_8_OR_ABOVE) {
            ((FieldAccessor) Objects.requireNonNull(NmsObjectives.SCORE_ACTION_FIELD)).set(objInvoke, NmsEnums.SCORE_ACTION_CHANGE);
        } else {
            ((FieldAccessor) Objects.requireNonNull(NmsObjectives.SCORE_ACTION_FIELD)).set(objInvoke, 0);
        }
        this.provider.packetSender().sendPacket(collection, objInvoke);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void removeScore(@NotNull Collection<Player> collection, @NotNull String str) {
        Object objInvoke = NmsObjectives.SCORE_CONSTRUCTOR.invoke(str);
        ((FieldAccessor) Objects.requireNonNull(NmsObjectives.SCORE_OBJECTIVE_NAME_FIELD)).set(objInvoke, this.objectiveName);
        this.provider.packetSender().sendPacket(collection, objInvoke);
    }

    @NotNull
    private Object createPropertiesPacket(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Component component, @NotNull ObjectiveRenderType objectiveRenderType) {
        Object objInvoke = NmsObjectives.OBJECTIVE_PACKET_CONSTRUCTOR.invoke(new Object[0]);
        NmsObjectives.OBJECTIVE_NAME_FIELD.set(objInvoke, this.objectiveName);
        NmsObjectives.OBJECTIVE_MODE_FIELD.set(objInvoke, Integer.valueOf(ObjectiveConstants.mode(propertiesPacketType)));
        NmsObjectives.OBJECTIVE_VALUE_FIELD.set(objInvoke, LegacyFormatUtil.limitLegacyText(LegacyComponentSerializer.legacySection().serialize(component), 32));
        if (NmsObjectives.OBJECTIVE_RENDER_TYPE_FIELD != null) {
            NmsObjectives.OBJECTIVE_RENDER_TYPE_FIELD.set(objInvoke, NmsEnums.renderType(objectiveRenderType));
        }
        return objInvoke;
    }
}
