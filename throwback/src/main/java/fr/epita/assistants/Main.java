package fr.epita.assistants;

import fr.epita.assistants.throwback.Pitcher;

/**
 * A very simple test
 */
public class Main {
    public static void main(String[] args) {
        /*
          Replace this String to try other exceptions.
          Hint: this one should trigger an UnknownException.
         */
        String exception = "--42        ";

        try {
            Pitcher.throwException(exception);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
