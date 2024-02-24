package fr.epita.assistants;

import ch.qos.logback.classic.Logger;
import fr.epita.assistants.loggingThreads.*;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger LOGGER =(Logger) LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        LOGGER.info("Entering application");

        TimeWaster waster = new TimeWaster();

        Thread sum = new Thread(() -> waster.sumUpTo(123456789));
        Thread importantThing = new Thread(waster::doImportantThing);

        sum.start();
        importantThing.start();

        importantThing.interrupt();

        sum.join();
        importantThing.join();

        LOGGER.info("Clean application exit");
    }
}