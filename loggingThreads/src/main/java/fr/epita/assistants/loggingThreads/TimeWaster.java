package fr.epita.assistants.loggingThreads;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.math.*;
import java.util.HashMap;

public class TimeWaster {

    private final Logger LOGGER;
    private final HashMap<String, Long> map;
    public TimeWaster() {
        LOGGER = (Logger) LoggerFactory.getLogger(TimeWaster.class);
        LOGGER.setLevel(Level.TRACE);
        map = new HashMap<>();
    }

    /**
     * @param n Last natural number to sum
     * @return The sum of integers from 0 to n
     */
    public BigInteger sumUpTo(int n) {
        LOGGER.trace("Calculating");

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }
        LOGGER.debug("Finished calculating sum up to " + n + ": " + sum);
        return sum;
    }

    public void doImportantThing() {
        try {
            LOGGER.info("Waiting");
            Thread.currentThread().sleep(2000);
            if (Thread.interrupted())
                LOGGER.error("Wait interrupted");
            else
                LOGGER.info("Successfully waited");
        } catch (InterruptedException e) {
            LOGGER.error("Wait interrupted");
        }
    }
}
