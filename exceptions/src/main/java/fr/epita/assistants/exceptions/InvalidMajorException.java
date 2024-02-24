package fr.epita.assistants.exceptions;

public class InvalidMajorException extends Exception {
    private String major;

    public InvalidMajorException(String major) {
        super("InvalidMajorException: " + major);
    }
}
