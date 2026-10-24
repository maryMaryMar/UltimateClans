package me.module.multiserver.library.redis.jedis;

import java.util.function.Supplier;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Response.class */
public class Response<T> implements Supplier<T> {
    private Builder<T> builder;
    private Object data;
    protected T response = null;
    protected JedisDataException exception = null;
    private boolean building = false;
    private boolean built = false;
    private boolean set = false;
    private Response<?> dependency = null;

    public Response(Builder<T> builder) {
        this.builder = builder;
    }

    public void set(Object obj) {
        this.data = obj;
        this.set = true;
    }

    @Override // java.util.function.Supplier
    public T get() {
        if (this.dependency != null && this.dependency.set && !this.dependency.built) {
            this.dependency.build();
        }
        if (!this.set) {
            throw new IllegalStateException("Please close pipeline or multi block before calling this method.");
        }
        if (!this.built) {
            build();
        }
        if (this.exception != null) {
            throw this.exception;
        }
        return this.response;
    }

    public void setDependency(Response<?> response) {
        this.dependency = response;
    }

    private void build() {
        if (this.building) {
            return;
        }
        this.building = true;
        try {
            if (this.data != null) {
                if (this.data instanceof JedisDataException) {
                    this.exception = (JedisDataException) this.data;
                } else {
                    this.response = this.builder.build(this.data);
                }
            }
            this.data = null;
        } finally {
            this.building = false;
            this.built = true;
        }
    }

    public String toString() {
        return "Response " + this.builder.toString();
    }
}
