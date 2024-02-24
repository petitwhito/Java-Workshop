package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {

    private int infoCounter;
    private int warnCounter;
    private int errorCounter;

    // Private constructor to prevent instantiation
    private StaticSingletonLogger() {
        // Initialization code if needed
    }

    // Inner private static class to hold the single instance
    private static class InstanceHolder {
        private static final StaticSingletonLogger _INSTANCE = new StaticSingletonLogger();
    }

    // Static method to get the instance of StaticSingletonLogger
    public static StaticSingletonLogger getInstance() {
        return InstanceHolder._INSTANCE;
    }

    @Override
    public void log(Level level, String message) {
        String formattedLog = Logger.getFormattedLog(level, message);
        System.err.println(formattedLog);

        switch (level) {
            case INFO -> infoCounter++;
            case WARN -> warnCounter++;
            case ERROR -> errorCounter++;
        }
    }

    @Override
    public int getInfoCounter() {
        return infoCounter;
    }

    @Override
    public int getWarnCounter() {
        return warnCounter;
    }

    @Override
    public int getErrorCounter() {
        return errorCounter;
    }

    @Override
    public void reset() {
        infoCounter = 0;
        warnCounter = 0;
        errorCounter = 0;
    }
}
