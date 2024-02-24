package fr.epita.assistants.streamstudent;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamStudentTest {
    static void assertStreamEquals(Stream<Pair<Integer, String>> expectedStream,
                                   Stream<Pair<Integer, String>> actualStream) {
        // Get iterators from stream
        Iterator<Pair<Integer, String>> iterator1 = expectedStream.iterator();
        Iterator<Pair<Integer, String>> iterator2 = actualStream.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            // Get next objects
            Pair<Integer, String> login1 = iterator1.next();
            Pair<Integer, String> login2 = iterator2.next();

            // Check if pairs are equal
            assertEquals(login1, login2);
        }

        assertTrue(!iterator1.hasNext() && !iterator2.hasNext(),
                "Streams do not have the same length");

    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(50, "xavier_login_");
        Pair<Integer, String> loginValid = new Pair<>(90, "xavier_login");
        Pair<Integer, String> loginMultipleUnderscord = new Pair<>(10, "_login__x");
        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid, loginMultipleUnderscord);

        var expected = List.of(loginValid).stream();
        var actual = streamer.validator(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void test1() {
        Pair<Integer, String> lo1 = new Pair<>(2, "zzz_z");
        Pair<Integer, String> lo2 = new Pair<>(2, "aaaa_z");
        Pair<Integer, String> lo3 = new Pair<>(1, "aaa_z");
        Streamer streamer = new Streamer();
        var loginList = List.of(lo1, lo2, lo3);
        var actual = streamer.orderGrade(loginList.stream());
        var expected = List.of(lo3, lo2, lo1).stream();
        assertStreamEquals(expected, actual);
    }

    @Test
    public void test2() {
        Pair<Integer, String> lo1 = new Pair<>(10, "tigrou_c");
        Pair<Integer, String> lo2 = new Pair<>(10, "login_x");
        Streamer streamer = new Streamer();
        var loginList = List.of(lo2);
        var actual = streamer.encryption(loginList.stream());
        var expected = List.of(lo2).stream();
        assertStreamEquals(expected, actual);
    }
}
