package me.ext.nexo.manager;

import com.nexomc.nexo.api.NexoItems;
import com.nexomc.nexo.items.ItemBuilder;
import java.util.Optional;
import me.ext.nexo.Nexo;
import me.ulrich.clans.interfaces.ItemParseImplement;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Nexo.jar:me/ext/nexo/manager/Implementation.class */
public final class Implementation implements ItemParseImplement {
    @Override // me.ulrich.clans.interfaces.ItemParseImplement
    public ItemStack getItem(String itemName) {
        ItemBuilder itemBuilder = NexoItems.itemFromId(itemName);
        if (itemBuilder != null) {
            return itemBuilder.build();
        }
        return null;
    }

    @Override // me.ulrich.clans.interfaces.ItemParseImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(Nexo.getExtensionCore().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ItemParseImplement
    public Optional<String> getPluginName() {
        return Optional.of(Nexo.getExtensionCore().getName());
    }
}
