package fr.epita.assistants.maths;

public class Matrix {
    private final int[][] _matrix;

    public Matrix(int[][] matrix) {
        _matrix = matrix;
    }

    public int[][] getMatrix() {
        return _matrix;
    }

    @Override
    public boolean equals(Object obj) {
        Matrix mat = (Matrix) obj;
        return mat._matrix == _matrix;
    }

    public Matrix multiply(Matrix mat2) {
        int[][] result = new int[_matrix.length][_matrix[0].length];

        for (int i = 0; i < _matrix.length; i++)
            for (int j = 0; j < mat2._matrix[0].length; j++) {
                int value = 0;
                for (int x = 0, y = 0; x < _matrix[i].length && y < mat2._matrix.length; x++, y++)
                    value += _matrix[i][x] * mat2._matrix[y][j];

                result[i][j] = value;
            }
        return new Matrix(result);
    }
}
