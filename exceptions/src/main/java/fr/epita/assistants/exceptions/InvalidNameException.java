package fr.epita.assistants.exceptions;

public class InvalidNameException extends Exception {
    private String name;

    public InvalidNameException(String name) {
        super("InvalidNameException: " + name);
    }
}
