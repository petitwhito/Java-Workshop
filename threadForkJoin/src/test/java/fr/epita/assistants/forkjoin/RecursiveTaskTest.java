package fr.epita.assistants.forkjoin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(1)
public class RecursiveTaskTest {
    @Test
    void exampleTest() {
        // Create a Matrix
        double[][] matrix = new double[][]{
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25},
                new double[]{10, 52, 100, 50, 74, 25}
        };
        double expected = 51.83;

        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);

        // Fork and join task
        mrt.fork();
        double got = mrt.join();

        // Need delta because of 'double' type
        assertEquals(expected, got, 0.01);
    }

    // Write your tests here ...
}
