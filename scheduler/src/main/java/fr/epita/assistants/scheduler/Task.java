package fr.epita.assistants.scheduler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Represent a single task to be executed. Tasks can be chained using the andThenDo method.
 *
 * @param <RETURN_TYPE> The expected return type.
 */
public interface Task<RETURN_TYPE> {

    /**
     * Static initializer allowing the creation of a task instance with the given {@link Supplier}.
     *
     * @param actionSupplier The actual action to execute.
     * @param <RETURN_TYPE>  The expected return type, inferred by the call chain.
     * @return A {@link Task} instance.
     */
    static <RETURN_TYPE> Task<RETURN_TYPE> of(Supplier<RETURN_TYPE> actionSupplier) {
        throw new UnsupportedOperationException("This default implementation should never be called, and should be" +
                "implemented in classes that implement this interface");
    }

    /**
     * Build the actual completable future according to this instance specifications.
     *
     * @return The built {@link CompletableFuture}.
     */
    CompletableFuture<RETURN_TYPE> build();

    /**
     * Execute a task and return its result.
     *
     * @return The result of the execution of this task.
     */
    default RETURN_TYPE execute() {
        try {
            return build().get();
        } catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException("Exception during task computing", exception);
        }
    }

    /**
     * Specify a function that provides a recovery value to use if the task fails.
     *
     * @param recoveryFunction The function that will be called with the exception - should any happen - in order to
     *                         compute a recovery value.
     * @return The updated task.
     */
    Task<RETURN_TYPE> onErrorRecoverWith(final Function<Throwable, RETURN_TYPE> recoveryFunction);

    /**
     * Chain a new task to be executed after the current one, taking the output of the current one as its input.
     *
     * @param action            The action to perform.
     * @param <NEW_RETURN_TYPE> The return type of the task to create.
     * @return The created task.
     */
    <NEW_RETURN_TYPE> Task<NEW_RETURN_TYPE> andThenDo(final Function<RETURN_TYPE, NEW_RETURN_TYPE> action);

    /**
     * Wait for the given number of timeUnit.
     *
     * @param number   The number of units to wait for.
     * @param timeUnit The unit.
     * @return The created task.
     */
    Task<RETURN_TYPE> andThenWait(final long number, final TimeUnit timeUnit);

}
