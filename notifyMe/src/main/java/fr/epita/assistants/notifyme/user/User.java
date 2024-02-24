package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;

import java.util.ArrayList;
import java.util.List;

public class User implements IMultiNotificationSender {

    public final List<INotificationSender> parNotificationList;
    public String username;
    public User(final String username, final List<INotificationSender> parNotificationList) {
        this.parNotificationList = parNotificationList;
        this.username = username;
    }

    public User(final String username) // Equivalent to User(myUsername, new ArrayList<>())
    {
        this.username = username;
        this.parNotificationList = new ArrayList<>();
    }

    public String getUsername() // Returns the username
    {
        return username;
    }

    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
        for (int i = 0; i < parNotificationList.size(); i++)
        {
            INotificationSender j = parNotificationList.get(i);
            j.notify(username, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        parNotificationList.add(parNotifier);
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return parNotificationList;
    }
}
