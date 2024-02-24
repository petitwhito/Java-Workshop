package fr.epita.assistants.observer;

import java.util.Set;

/**
 * Observer interface.
 *
 * @param <EVENT_T> Type of observed events
 */
public interface Observable<EVENT_T> {

    /**
     * Get all registered observers.
     *
     * @return The set of observers
     */
    Set<Observer<EVENT_T>> getObservers();

    /**
     * Register observers.
     *
     * @param observers Observers to register
     */
    void register(final Observer<EVENT_T>... observers);

    /**
     * Unregister the given observer.
     *
     * @param observer The observer to deactivate
     */
    void unregister(final Observer<EVENT_T> observer);

    /**
     * Notify all registered observers of the given event.
     *
     * @param event The event to notify observers with.
     */
    void fire(final EVENT_T event);

    /**
     * Sub interface for observers.
     *
     * @param <EVENT_T> The type of observed events
     */
    @FunctionalInterface
    interface Observer<EVENT_T> {

        /**
         * Notification callback.
         *
         * @param event The event being sent
         */
        void onEvent(final EVENT_T event);
    }
}
