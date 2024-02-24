package fr.epita.assistants.maths;

import org.junit.jupiter.api.*;

public class MatrixTests {
    @Test
    void Test1() {
        int[][] arr1 = { {1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }

    @Test
    void Test13() {
        int[][] arr1 = {};
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }

    @Test
    void Test14() {
        int[][] arr1 = {{1}, {1, 2}};
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }

    @Test
    void Test2() {
        int[][] arr1 = { {1, 2}, {3, 4}};
        int[][] res = { {7, 10}, {15, 22}};
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.multiply(matrix1).getMatrix(), res);
    }
    @Test
    void Test3() {
        int[][] arr1 = { {1, 2}, {3, 4}};
        int[][] arr2 = { {7, 10}, {15, 22}};
        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);
        Assertions.assertFalse(matrix1.equals(matrix2));
    }
    @Test
    void Test4() {
        int[][] arr1 = { {} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }

    @Test
    void Test44() {
        int[][] arr1 = { {1}, {2}, {3} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }
    @Test
    void Test444() {
        int[][] arr1 = null;
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }
    @Test
    void Test5() {
        int[][] arr1 = { {}};
        int[][] res = { {} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.multiply(matrix1).getMatrix(), res);
    }
    @Test
    void Test6() {
        int[][] arr1 = { {}, {} };
        int[][] arr2 = { {}, {} };
        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);
        Assertions.assertFalse(matrix1.equals(matrix2));
    }

    @Test
    void Test7() {
        int[][] arr1 = { {1, 2}, {2} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }
    @Test
    void Test8() {
        int[][] arr1 = { {1, 2}, {2} };
        int[][] res = { {} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.multiply(matrix1).getMatrix(), res);
    }
    @Test
    void Test9() {
        int[][] arr1 = { {}, {} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertFalse(matrix1.equals("couscous"));
    }

    @Test
    void Test10() {
        int[][] arr1 = { {1} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.getMatrix(), arr1);
    }
    @Test
    void Test11() {
        int[][] arr1 = { {1}};
        int[][] res = { {1} };
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.multiply(matrix1).getMatrix(), res);
    }
    @Test
    void Test12() {
        int[][] arr1 = { {1}, {1} };
        int[][] arr2 = { {1} };
        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);
        Assertions.assertFalse(matrix1.equals(matrix2));
    }

    @Test
    void Test16() {
        int[][] arr1 = {};
        int[][] res = {};
        Matrix matrix1 = new Matrix(arr1);
        Assertions.assertArrayEquals(matrix1.multiply(matrix1).getMatrix(), res);
    }
    @Test
    void Test15() {
        int[][] arr1 = {};
        int[][] arr2 = {};
        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);
        Assertions.assertFalse(matrix1.equals(matrix2));
    }

}
