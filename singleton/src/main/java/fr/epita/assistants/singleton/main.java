package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;


public class main {
    public static void main(String[] args) {
        final var logger = StaticSingletonLogger.getInstance(); // or StaticSingletonLogger.getInstance()
        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());
        logger.log(Logger.Level.INFO, "Logger instantiated");
        logger.log(Logger.Level.WARN, "This is a warning message");
        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());
        logger.log(Logger.Level.ERROR, "This is an error message");
        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());
        logger.reset();
        System.err.println(logger.getInfoCounter());
        System.err.println(logger.getWarnCounter());
        System.err.println(logger.getErrorCounter());
    }
}
