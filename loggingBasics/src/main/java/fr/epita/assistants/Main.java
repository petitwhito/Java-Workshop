package fr.epita.assistants;

import ch.qos.logback.classic.Level;
import fr.epita.assistants.loggingbasics.*;
import org.slf4j.*;


public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // FIXME: Add logging here
        final Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Entering application");
        Trombinoscope trombi = new Trombinoscope();

        trombi.putPerson("Bob", 1);
        trombi.putPerson("Bob", 2);
    }
}
