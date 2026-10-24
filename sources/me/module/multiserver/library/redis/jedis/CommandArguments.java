package me.module.multiserver.library.redis.jedis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.args.RawableFactory;
import me.module.multiserver.library.redis.jedis.commands.ProtocolCommand;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/CommandArguments.class */
public class CommandArguments implements Iterable<Rawable> {
    private final ArrayList<Rawable> args;
    private boolean blocking;

    private CommandArguments() {
        throw new InstantiationError();
    }

    public CommandArguments(ProtocolCommand protocolCommand) {
        this.args = new ArrayList<>();
        this.args.add(protocolCommand);
    }

    public ProtocolCommand getCommand() {
        return (ProtocolCommand) this.args.get(0);
    }

    public CommandArguments add(Object obj) {
        if (obj instanceof Rawable) {
            this.args.add((Rawable) obj);
        } else if (obj instanceof byte[]) {
            this.args.add(RawableFactory.from((byte[]) obj));
        } else if (obj instanceof String) {
            this.args.add(RawableFactory.from((String) obj));
        } else if (obj instanceof Boolean) {
            this.args.add(RawableFactory.from(Integer.toString(((Boolean) obj).booleanValue() ? 1 : 0)));
        } else {
            if (obj == null) {
                throw new IllegalArgumentException("null is not a valid argument.");
            }
            this.args.add(RawableFactory.from(String.valueOf(obj)));
        }
        return this;
    }

    public CommandArguments addObjects(Object... objArr) {
        for (Object obj : objArr) {
            add(obj);
        }
        return this;
    }

    public CommandArguments addObjects(Collection collection) {
        collection.forEach(obj -> {
            add(obj);
        });
        return this;
    }

    @Deprecated
    public CommandArguments addObjects(int[] iArr) {
        for (int i : iArr) {
            add(Integer.valueOf(i));
        }
        return this;
    }

    public CommandArguments key(Object obj) {
        if (obj instanceof Rawable) {
            Rawable rawable = (Rawable) obj;
            processKey(rawable.getRaw());
            this.args.add(rawable);
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            processKey(bArr);
            this.args.add(RawableFactory.from(bArr));
        } else {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException("\"" + obj.toString() + "\" is not a valid argument.");
            }
            String str = (String) obj;
            processKey(str);
            this.args.add(RawableFactory.from(str));
        }
        return this;
    }

    public final CommandArguments keys(Object... objArr) {
        for (Object obj : objArr) {
            key(obj);
        }
        return this;
    }

    public final CommandArguments addParams(IParams iParams) {
        iParams.addParams(this);
        return this;
    }

    protected CommandArguments processKey(byte[] bArr) {
        return this;
    }

    protected final CommandArguments processKeys(byte[]... bArr) {
        for (byte[] bArr2 : bArr) {
            processKey(bArr2);
        }
        return this;
    }

    protected CommandArguments processKey(String str) {
        return this;
    }

    protected final CommandArguments processKeys(String... strArr) {
        for (String str : strArr) {
            processKey(str);
        }
        return this;
    }

    public int size() {
        return this.args.size();
    }

    @Override // java.lang.Iterable
    public Iterator<Rawable> iterator() {
        return this.args.iterator();
    }

    public boolean isBlocking() {
        return this.blocking;
    }

    public CommandArguments blocking() {
        this.blocking = true;
        return this;
    }
}
