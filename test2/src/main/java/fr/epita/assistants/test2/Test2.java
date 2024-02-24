package fr.epita.assistants.test2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test2 {
    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Error: n must be positive");

        if (n == 0)
            return 0;
        if (n < 3)
            return 1;

        long one = 0;
        long two = 1;
        long three = 1;
        long res = 0;

        for (long i = 3; i <= n; i++) {
            res = one + two + three;
            one = two;
            two = three;
            three = res;
        }

        return res;
    }

    public static long serverGetResponseCode() throws IOException {
        URL url = new URL("http://localhost:8080/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con.getResponseCode();
    }

    public static int division(int a, int b) {
        return a / b;
    }
}
