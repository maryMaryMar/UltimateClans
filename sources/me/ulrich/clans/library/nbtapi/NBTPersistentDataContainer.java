package me.ulrich.clans.library.nbtapi;

import java.util.Map;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.bukkit.persistence.PersistentDataContainer;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTPersistentDataContainer.class */
public class NBTPersistentDataContainer extends NBTCompound {
    private final PersistentDataContainer container;

    public NBTPersistentDataContainer(PersistentDataContainer persistentDataContainer) {
        this(persistentDataContainer, false);
    }

    protected NBTPersistentDataContainer(PersistentDataContainer persistentDataContainer, boolean z) {
        super(null, null, z);
        this.container = persistentDataContainer;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    public Object getCompound() {
        return ReflectionMethod.CRAFT_PERSISTENT_DATA_CONTAINER_TO_TAG.run(this.container, new Object[0]);
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setCompound(Object obj) {
        ((Map) ReflectionMethod.CRAFT_PERSISTENT_DATA_CONTAINER_GET_MAP.run(this.container, new Object[0])).clear();
        ReflectionMethod.CRAFT_PERSISTENT_DATA_CONTAINER_PUT_ALL.run(this.container, obj);
    }
}
