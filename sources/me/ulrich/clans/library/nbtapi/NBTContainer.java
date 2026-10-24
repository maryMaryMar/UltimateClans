package me.ulrich.clans.library.nbtapi;

import java.io.InputStream;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ClassWrapper;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ObjectCreator;
import me.ulrich.clans.library.nbtapi.utils.nmsmappings.ReflectionMethod;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/NBTContainer.class */
public class NBTContainer extends NBTCompound {
    private Object nbt;
    private boolean closed;
    private boolean readOnly;

    @Deprecated
    public NBTContainer() {
        super(null, null);
        this.nbt = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
    }

    @Deprecated
    public NBTContainer(Object obj) {
        super(null, null);
        obj = obj == null ? ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]) : obj;
        if (!ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().isAssignableFrom(obj.getClass())) {
            throw new NbtApiException("The object '" + obj.getClass() + "' is not a valid NBT-Object!");
        }
        this.nbt = obj;
    }

    @Deprecated
    public NBTContainer(InputStream inputStream) {
        super(null, null);
        this.nbt = NBTReflectionUtil.readNBT(inputStream);
    }

    @Deprecated
    public NBTContainer(String str) {
        super(null, null);
        if (str == null) {
            throw new NullPointerException("The String can't be null!");
        }
        try {
            this.nbt = ReflectionMethod.PARSE_NBT.run(null, str);
        } catch (Exception e) {
            throw new NbtApiException("Unable to parse Malformed Json!", e);
        }
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    public Object getCompound() {
        return this.nbt;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    public void setCompound(Object obj) {
        this.nbt = obj;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected void setClosed() {
        this.closed = true;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected boolean isClosed() {
        return this.closed;
    }

    @Override // me.ulrich.clans.library.nbtapi.NBTCompound
    protected boolean isReadOnly() {
        return this.readOnly;
    }

    protected NBTContainer setReadOnly(boolean z) {
        this.readOnly = true;
        return this;
    }
}
