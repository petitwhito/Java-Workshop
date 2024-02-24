package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int expected = 120;
        if (Classics.factorial(n) != expected)
            System.err.println("Error factorial("+ n +") " +
                    "-> Actual: " + Classics.factorial(5) + " Expected: " + expected);

        for (int i = 0; i < 10; i++)
            System.out.println(Classics.tribonacci(i));

        System.out.println(Classics.isPalindrome("Hello World"));
        System.out.println(Classics.isPalindrome("KayaK"));

        System.out.println(Classics.combine("abc", "def"));
    }
}
