package fr.epita.assistants.throwback;

public class LongStringException extends StringException {

    public LongStringException(String message) {
        //System.err.println("StringException: LongStringException: " + message + " (length: " + n + ")");
        super("StringException: LongStringException: " + message + " (length: " + message.length() + ")");
    }
}
