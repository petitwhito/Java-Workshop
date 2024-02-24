package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public enum SingletonEnumLogger implements Logger {

    INSTANCE;

    private int infoCounter;
    private int warnCounter;
    private int errorCounter;

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