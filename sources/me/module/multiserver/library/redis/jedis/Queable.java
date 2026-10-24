package me.module.multiserver.library.redis.jedis;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/Queable.class */
public class Queable {
    private final Queue<Response<?>> pipelinedResponses = new LinkedList();

    protected final void clean() {
        this.pipelinedResponses.clear();
    }

    protected final Response<?> generateResponse(Object obj) {
        Response<?> responsePoll = this.pipelinedResponses.poll();
        responsePoll.set(obj);
        return responsePoll;
    }

    protected final <T> Response<T> enqueResponse(Builder<T> builder) {
        Response<T> response = new Response<>(builder);
        this.pipelinedResponses.add(response);
        return response;
    }

    protected final int getPipelinedResponseLength() {
        return this.pipelinedResponses.size();
    }
}
