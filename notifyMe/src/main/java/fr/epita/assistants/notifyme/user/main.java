package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;
import fr.epita.assistants.notifyme.user.IMultiNotificationSender;
import fr.epita.assistants.notifyme.notify.ShellNotifier;

import java.util.List;


public class main {

    // Or using addNotifier instead of the constructor
    public static void main(String[] args) {
        final User user = new User("John Doe");
        user.addNotifier(new ShellNotifier(false));
        user.addNotifier(new ShellNotifier(true));
        user.sendNotifications("ING1", "Hello World!");
    }
}
