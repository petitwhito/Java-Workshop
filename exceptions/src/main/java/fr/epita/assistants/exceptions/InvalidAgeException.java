package fr.epita.assistants.exceptions;

public class InvalidAgeException extends Exception {
    private int age;

    public InvalidAgeException(int age) {
        super("InvalidAgeException: " + age);
    }
}
