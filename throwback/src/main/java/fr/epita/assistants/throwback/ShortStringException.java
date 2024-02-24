package fr.epita.assistants.throwback;

public class ShortStringException extends StringException {
    public ShortStringException(String message) {
        super("StringException: ShortStringException: " + message + " (length: " + message.length() + ")");
        //System.err.println("StringException: ShortStringException: " + message + " (length: " + n + ")");
    }
}
