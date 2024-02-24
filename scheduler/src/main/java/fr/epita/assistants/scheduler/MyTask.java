package fr.epita.assistants.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.concurrent.CompletableFuture.delayedExecutor;

public class MyTask<INPUT_TYPE, RETURN_TYPE> implements Task<RETURN_TYPE> {

    public CompletableFuture<RETURN_TYPE> future;

    static <RETURN_TYPE> Task<RETURN_TYPE> of(Supplier<RETURN_TYPE> actionSupplier) {
        MyTask m = new MyTask<>();
        m.future = CompletableFuture.supplyAsync(actionSupplier);
        return m;
    }

    @Override
    public CompletableFuture<RETURN_TYPE> build() {
        return future;
    }

    @Override
    public Task<RETURN_TYPE> onErrorRecoverWith(Function<Throwable, RETURN_TYPE> recoveryFunction) {
        MyTask m = new MyTask<>();
        m.future = future.handle((list, exception) -> recoveryFunction.apply(exception));
        return m;
    }

    @Override
    public <NEW_RETURN_TYPE> Task<NEW_RETURN_TYPE> andThenDo(Function<RETURN_TYPE, NEW_RETURN_TYPE> action) {
        MyTask m = new MyTask<>();
        m.future = future.thenApplyAsync(action);
        return m;
    }

    @Override
    public Task<RETURN_TYPE> andThenWait(long number, TimeUnit timeUnit) {
        MyTask m = new MyTask<>();
        m.future = future.thenCompose((result) ->
                CompletableFuture.supplyAsync(() ->
                        result, CompletableFuture.delayedExecutor(number, timeUnit)));
        return m;
    }

}