package fr.epita.assistants.throwback;

public class PositiveIntegerException extends IntegerException {
    public PositiveIntegerException(String message) {
        super("IntegerException: PositiveIntegerException: " + message);
    }
}
