package me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.objective;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveDisplaySlot;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveRenderType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.PropertiesPacketType;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.PacketAdapterProviderImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsClasses;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsEnums;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.impl.nms.NmsObjectives;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectiveConstants;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter;
import me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.util.reflect.ConstructorAccessor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/packetAdapter/impl/objective/AbstractObjectivePacketAdapter.class */
public abstract class AbstractObjectivePacketAdapter implements ObjectivePacketAdapter {
    protected final PacketAdapterProviderImpl provider;
    protected final String objectiveName;
    private Object removePacket;
    static final /* synthetic */ boolean $assertionsDisabled;

    public AbstractObjectivePacketAdapter(@NotNull PacketAdapterProviderImpl packetAdapterProviderImpl, @NotNull String str) {
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
        this.provider.packetSender().sendPacket(collection, createDisplayPacket(objectiveDisplaySlot));
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void remove(@NotNull Collection<Player> collection) {
        if (this.removePacket == null) {
            this.removePacket = NmsObjectives.OBJECTIVE_PACKET_CONSTRUCTOR.invoke(new Object[0]);
            NmsObjectives.OBJECTIVE_NAME_FIELD.set(this.removePacket, this.objectiveName);
            NmsObjectives.OBJECTIVE_MODE_FIELD.set(this.removePacket, 1);
        }
        this.provider.packetSender().sendPacket(collection, this.removePacket);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.packetAdapter.objective.ObjectivePacketAdapter
    public void removeScore(@NotNull Collection<Player> collection, @NotNull String str) {
        this.provider.packetSender().sendPacket(collection, NmsClasses.IS_1_20_3_OR_ABOVE ? ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.RESET_SCORE_CONSTRUCTOR)).invoke(str, this.objectiveName) : ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.SCORE_CONSTRUCTOR)).invoke(NmsEnums.SCORE_ACTION_REMOVE, this.objectiveName, str, 0));
    }

    @NotNull
    protected Object createDisplayPacket(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot) {
        Object objInvoke;
        if (NmsClasses.IS_1_20_2_OR_ABOVE) {
            objInvoke = ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.DISPLAY_CONSTRUCTOR)).invoke(NmsEnums.DISPLAY_SLOT_VALUES[ObjectiveConstants.displaySlotIndex(objectiveDisplaySlot)], null);
        } else if (NmsClasses.IS_1_17_OR_ABOVE) {
            objInvoke = ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.DISPLAY_CONSTRUCTOR)).invoke(Integer.valueOf(ObjectiveConstants.displaySlotIndex(objectiveDisplaySlot)), null);
        } else {
            if (!$assertionsDisabled && NmsObjectives.DISPLAY_SLOT == null) {
                throw new AssertionError();
            }
            objInvoke = ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.DISPLAY_CONSTRUCTOR)).invoke(new Object[0]);
            NmsObjectives.DISPLAY_SLOT.set(objInvoke, Integer.valueOf(ObjectiveConstants.displaySlotIndex(objectiveDisplaySlot)));
        }
        NmsObjectives.DISPLAY_OBJECTIVE_NAME.set(objInvoke, this.objectiveName);
        return objInvoke;
    }

    @NotNull
    protected Object createScorePacket(@NotNull String str, int i, @Nullable Object obj, @Nullable Object obj2) {
        if (NmsClasses.IS_1_20_5_OR_ABOVE) {
            return ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.SCORE_CONSTRUCTOR)).invoke(str, this.objectiveName, Integer.valueOf(i), Optional.ofNullable(obj), Optional.ofNullable(obj2));
        }
        return NmsClasses.IS_1_20_3_OR_ABOVE ? ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.SCORE_CONSTRUCTOR)).invoke(str, this.objectiveName, Integer.valueOf(i), obj, obj2) : ((ConstructorAccessor) Objects.requireNonNull(NmsObjectives.SCORE_CONSTRUCTOR)).invoke(NmsEnums.SCORE_ACTION_CHANGE, this.objectiveName, str, Integer.valueOf(i));
    }

    @NotNull
    protected Object createObjectivePacket(@NotNull PropertiesPacketType propertiesPacketType, @NotNull Object obj, @NotNull ObjectiveRenderType objectiveRenderType, @Nullable Object obj2) {
        Object objInvoke = NmsObjectives.OBJECTIVE_PACKET_CONSTRUCTOR.invoke(new Object[0]);
        NmsObjectives.OBJECTIVE_MODE_FIELD.set(objInvoke, Integer.valueOf(ObjectiveConstants.mode(propertiesPacketType)));
        NmsObjectives.OBJECTIVE_NAME_FIELD.set(objInvoke, this.objectiveName);
        NmsObjectives.OBJECTIVE_VALUE_FIELD.set(objInvoke, obj);
        if (NmsClasses.IS_1_20_3_OR_ABOVE) {
            if (!$assertionsDisabled && NmsObjectives.OBJECTIVE_NUMBER_FORMAT_FIELD == null) {
                throw new AssertionError();
            }
            NmsObjectives.OBJECTIVE_NUMBER_FORMAT_FIELD.set(objInvoke, NmsClasses.IS_1_20_5_OR_ABOVE ? Optional.ofNullable(obj2) : obj2);
        }
        if (!$assertionsDisabled && NmsObjectives.OBJECTIVE_RENDER_TYPE_FIELD == null) {
            throw new AssertionError();
        }
        NmsObjectives.OBJECTIVE_RENDER_TYPE_FIELD.set(objInvoke, NmsEnums.renderType(objectiveRenderType));
        return objInvoke;
    }

    static {
        $assertionsDisabled = !AbstractObjectivePacketAdapter.class.desiredAssertionStatus();
    }
}
