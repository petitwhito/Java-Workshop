package fr.epita.assistants.test2;

import fr.epita.assistants.server.MyServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.net.BindException;
import java.rmi.ConnectException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

public class Test2Test {
    @Test
    void Test1() {
        assertDoesNotThrow(MyServer::stopServer);
        assertDoesNotThrow(MyServer::launchServer);
        assertDoesNotThrow(Test2::serverGetResponseCode);
        long n;
        try {
            n = Test2.serverGetResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertThrows(BindException.class, MyServer::launchServer, "nanio");
        assertDoesNotThrow(MyServer::stopServer);
        assertEquals(200, n);
    }

    @Test
    void Test2() {
        assertDoesNotThrow(MyServer::stopServer);
        assertDoesNotThrow(MyServer::launchServer);
        assertDoesNotThrow(Test2::serverGetResponseCode);
        assertDoesNotThrow(MyServer::stopServer);
    }

    @Test
    void Test3() {
        assertDoesNotThrow(MyServer::stopServer);
    }

    @Test
    @Timeout(1)
    void Test4() {
        int n = -1;
        assertThrows(IllegalArgumentException.class, () -> Test2.tribonacci(n), "Error: n must be positive");
    }

    @Test
    @Timeout(1)
    void Test5() {
        int n = 0;
        assertDoesNotThrow(() -> Test2.tribonacci(n));
        long actual = Test2.tribonacci(n);
        assertEquals(actual, 0);
    }

    @Test
    @Timeout(1)
    void Test6() {
        int n = 2;
        assertDoesNotThrow(() -> Test2.tribonacci(n));
        long actual = Test2.tribonacci(n);
        assertEquals(actual, 1);
    }

    @Test
    @Timeout(1)
    void Test7() {
        int n = 3;
        assertDoesNotThrow(() -> Test2.tribonacci(n));
        long actual = Test2.tribonacci(n);
        assertEquals(actual, 2);
    }

    @Test
    @Timeout(1)
    void Test8() {
        int n = Integer.MAX_VALUE;
        assertThrows(TimeoutException.class,() -> Test2.tribonacci(n));
        long actual = Test2.tribonacci(n);
        assertEquals(2147483647, actual);
    }

    @Test
    void Test9() {
        assertDoesNotThrow(MyServer::stopServer);
        assertThrows(ConnectException.class, Test2::serverGetResponseCode, "Error: n must be positive");
        assertDoesNotThrow(MyServer::stopServer);
    }

    @Test
    void Test10() {
        assertDoesNotThrow(MyServer::launchServer);
        long n;
        try {
            n = Test2.serverGetResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(200, n);
        assertDoesNotThrow(Test2::serverGetResponseCode);
        assertDoesNotThrow(MyServer::stopServer);
    }

    @Test
    void Test11() {
        assertThrows(ArithmeticException.class,() -> Test2.division(0, 0));
    }

    @Test
    void Test12() {
        int division = Test2.division(1, 1);
        assertDoesNotThrow(() -> Test2.division(1, 1));
        assertEquals(division, 1);
    }

    @Test
    void Test13() {
        int division = Test2.division(1, 2);
        assertDoesNotThrow(() -> Test2.division(1, 2));
        assertEquals(division, 0);
    }

    @Test
    @Timeout(2)
    void Test14()
    {
        assertDoesNotThrow(MyServer::launchServer);
        assertThrows(TimeoutException.class, () -> {Test2.serverGetResponseCode(); Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();Test2.serverGetResponseCode();}, "java.util.concurrent.TimeoutException to be thrown, but nothing was thrown.");
        assertDoesNotThrow(MyServer::stopServer);
    }

    /*
    @Test
    void Test14() {
        assertThrows(ArithmeticException.class, () -> {MyServer.launchServer(); Thread.sleep(2000); MyServer.launchServer(); MyServer.launchServer(); Test2::serverGetResponseCode;}    );
    }
    */


}
