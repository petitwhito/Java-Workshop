package fr.epita.assistants.classics;

import org.apache.commons.lang3.ObjectUtils;

public class Classics {
    /**
     * Computes the factorial of n.
     *
     * @param n the nth value to compute, negative values should return -1
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0)
            return -1;
        if (n <= 1)
            return 1;
        long res = 1;
        while (n >= 1) {
            res = res * n;
            n--;
        }
        return res;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n <= 1)
            return n;
        long a = 0;
        long b = 0;
        long c = 1;
        for (int i = 1; i < n; i++) {
            long tmp_a = a + b + c;
            a = b;
            b = c;
            c = tmp_a;
        }
        return c;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;
        StringBuilder temp = new StringBuilder();
        word = word.toLowerCase();
        word = word.replaceAll("\\s", "");
        for (int i = 0; i < word.length(); i++) {
            temp.insert(0, word.charAt(i));
        }
        return word.contentEquals(temp);
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        StringBuilder res = new StringBuilder();
        int tmp = 0;

        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                res.append(a.charAt(i));
                res.append(b.charAt(i));
                tmp = i + 1;
            }
            for (int i = tmp; i < a.length(); i++) {
                res.append(a.charAt(i));
            }
            return res.toString();
        }

        for (int i = 0; i < a.length(); i++) {
            res.append(a.charAt(i));
            res.append(b.charAt(i));
            tmp = i + 1;
        }
        for (int i = tmp; i < b.length(); i++) {
            res.append(b.charAt(i));
        }
        return res.toString();
    }
}
