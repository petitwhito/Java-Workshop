package fr.epita.assistants.loggingbasics;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
import org.slf4j.Logger.*;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Trombinoscope {
    private final Logger LOGGER;
    private final HashMap<String, Long> map;

    public Trombinoscope() {
        // FIXME: Instantiate logger with level TRACE

        // FIXME: Add logging here
        LOGGER = (Logger) LoggerFactory.getLogger(Trombinoscope.class);
        LOGGER.setLevel(Level.TRACE);
        LOGGER.trace("Instantiating new Trombinoscope");
        map = new HashMap<>();
    }

    public Long putPerson(String name, long photoId) {
        // FIXME: Add logging here
        LOGGER.setLevel(Level.DEBUG);
        LOGGER.debug("Putting person (" + "\"" + name + "\"" + ", " + photoId + ")");

        boolean temp = false;
        if (map.containsKey(name)) {
            temp = true;
        }
        Long oldPhotoId = map.put(name,
                photoId);

        if (!temp) {
            LOGGER.setLevel(Level.TRACE);
            LOGGER.trace("Added entry for person " + "\"" + name + "\"");
        }
        else
        {
            LOGGER.setLevel(Level.TRACE);
            LOGGER.trace("Updated entry for person " + "\"" + name + "\"");
        }
        // FIXME: Add logging here

        return oldPhotoId;
    }
}
