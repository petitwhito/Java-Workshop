package fr.epita.assistants.logger;

/**
 * A standard logger interface
 */
public interface Logger {
    /**
     * The Level enum, representing the gravity of a log message.
     */
    enum Level {
        INFO,
        WARN,
        ERROR
    }

    /**
     * Formats a message and returns it as a string
     * @param level   The gravity level of the logged message.
     * @param message The logged message.
     * @return
     */
    static String getFormattedLog(final Level level, final String message) {
        return '[' +
                level.toString() +
                "] " +
                message;
    }

    /**
     * Outputs the logged message with the format '[LEVEL] Message' to stderr.
     *
     * @param level   The gravity level of the logged message.
     * @param message The logged message.
     */
    void log(final Level level, final String message);

    /**
     * Getter for infoCounter.
     *
     * @return infoCounter.
     */
    int getInfoCounter();

    /**
     * Getter for warnCounter.
     *
     * @return warnCounter.
     */
    int getWarnCounter();

    /**
     * Getter for errorCounter.
     *
     * @return errorCounter.
     */
    int getErrorCounter();

    /**
     * Resets the counters.
     */
    void reset();
}
