package me.module.anvil.manager;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import me.module.anvil.Anvil_1_18;
import me.ulrich.clans.data.AnvilResult;
import me.ulrich.clans.data.AnvilSession;
import me.ulrich.clans.interfaces.AnvilAction;
import me.ulrich.clans.interfaces.AnvilClickContext;
import me.ulrich.clans.interfaces.AnvilClickHandler;
import me.ulrich.clans.interfaces.AnvilModuleAPI;
import me.ulrich.clans.library.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX WARN: Classes with same name are omitted, all sources:
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_18.jar:me/module/anvil/manager/Implementation.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_19.jar:me/module/anvil/manager/Implementation.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_20.jar:me/module/anvil/manager/Implementation.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_21.jar:me/module/anvil/manager/Implementation.class
  UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_26.jar:me/module/anvil/manager/Implementation.class
 */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Anvil_1_18.jar:me/module/anvil/manager/Implementation.class */
public final class Implementation implements AnvilModuleAPI {
    @Override // me.ulrich.clans.interfaces.AnvilModuleAPI
    public boolean supports() {
        return true;
    }

    @Override // me.ulrich.clans.interfaces.AnvilModuleAPI
    public AnvilSession open(Player player, String title, Optional<String> final_text, Optional<ItemStack> left, Optional<ItemStack> right, Optional<ItemStack> output, AnvilClickHandler handler) {
        CompletableFuture<AnvilResult> future = new CompletableFuture<>();
        AnvilSessionImpl session = new AnvilSessionImpl(player, future);
        AnvilGUI.Builder builder = new AnvilGUI.Builder();
        builder.title(title);
        if (final_text.isPresent()) {
            builder.text(final_text.get());
        }
        if (left.isPresent()) {
            builder.itemLeft(left.get());
        }
        if (right.isPresent()) {
            builder.itemRight(right.get());
        }
        if (output.isPresent()) {
            builder.itemOutput(output.get());
        }
        builder.plugin(Anvil_1_18.getClanCore());
        builder.onClick((slot, state) -> {
            int slotId = slot.intValue();
            AnvilClickContext context = new AnvilClickContext(player, state.getText(), slotId);
            AnvilAction action = handler.onClick(context);
            if (slotId != 2) {
                return (slotId == 1 && action.getType() == AnvilAction.Type.CLOSE) ? Arrays.asList(AnvilGUI.ResponseAction.close()) : Collections.emptyList();
            }
            switch (action.getType()) {
                case CLOSE:
                    future.complete(AnvilResult.completed(state.getText()));
                    return Arrays.asList(AnvilGUI.ResponseAction.close());
                case UPDATE_TEXT:
                    return Arrays.asList(AnvilGUI.ResponseAction.replaceInputText(action.getText()));
                case KEEP_OPEN:
                default:
                    return Collections.emptyList();
            }
        });
        builder.onClose(state2 -> {
            session.setOpen(false);
            if (!future.isDone()) {
                future.complete(new AnvilResult(AnvilResult.Type.CANCELLED, state2.getText()));
            }
        });
        builder.open(player);
        return session;
    }

    @Override // me.ulrich.clans.interfaces.AnvilModuleAPI
    public boolean isInternal() {
        return false;
    }

    @Override // me.ulrich.clans.interfaces.AnvilModuleAPI
    public Optional<String> getPluginVersion() {
        return Optional.of(Anvil_1_18.getModuleCore().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.AnvilModuleAPI
    public Optional<String> getPluginName() {
        return Optional.of(Anvil_1_18.getModuleCore().getName());
    }
}
