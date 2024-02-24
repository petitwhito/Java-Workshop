package fr.epita.assistants.exceptions;

public class main {
    public static void main(String[] args) throws InvalidAgeException, InvalidNameException, InvalidMajorException {
        try
        { new Student("K3vin", 21, "mti"); } catch (InvalidNameException e) {
            System.out.println(e.getMessage()); }

        try
        { new Student("Paul", -2, "gistre"); } catch (InvalidAgeException e) {
            System.out.println(e.getMessage()); }

        try
        { new Student("Maxime", 21, "unknown"); } catch (InvalidMajorException e) {
            System.out.println(e.getMessage()); }

        Student paul = new Student("Jean-Michel", 19, "iMAgE");
        System.out.println(paul.toString());

    }
}
