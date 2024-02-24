package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;

import java.util.List;

public interface IMultiNotificationSender {
    /**
     * Sends a notification to all registered notifiers
     * @param parRecipient the recipient of the notification
     * @param parMessage the message to send
     */
    void sendNotifications(String parRecipient, String parMessage);

    /**
     * Adds a notification sender to the list of possible recipients
     * @param parNotifier the new notifier to add, should be ignored if null
     */
    void addNotifier(INotificationSender parNotifier);

    /**
     * Returns the list of notifiers
     * @return the list of notifiers
     */
    List<INotificationSender> getNotifiers();
}
