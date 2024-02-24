package fr.epita.assistants.forkjoin;

import java.lang.*;
import java.util.Arrays;
import  java.util.concurrent.RecursiveTask;
public class MyRecursiveTask extends RecursiveTask<Double> {

    final private double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    @Override
    protected Double compute() {

        if (matrix.length == 0)
            return 0.0;

        int lengthX = xUpperBound - xLowerBound;
        int lengthY = yUpperBound - yLowerBound;

        if (lengthX <= 5 && lengthY <= 5) {
            double sum = 0;
            for (int i = yLowerBound; i < yUpperBound; i++)
                for (int j = xLowerBound; j < xUpperBound; j++)
                    sum += matrix[i][j];

            double total = ((xUpperBound - xLowerBound) * (yUpperBound - yLowerBound));
            return sum / total;
        }
        else {
            if (matrix.length == 0)
                return 0.0;

            int midX = xLowerBound + lengthX / 2;
            int midY = yLowerBound + lengthY / 2;

            MyRecursiveTask bottomLeft = new MyRecursiveTask(matrix, xLowerBound, midX, midY, yUpperBound);
            MyRecursiveTask bottomRight = new MyRecursiveTask(matrix, midX, xUpperBound, midY, yUpperBound);

            MyRecursiveTask topLeft = new MyRecursiveTask(matrix, xLowerBound, midX, yLowerBound, midY);
            MyRecursiveTask topRight = new MyRecursiveTask(matrix, midX, xUpperBound, yLowerBound, midY);

            topLeft.fork();
            topRight.fork();
            bottomLeft.fork();
            Double topRightResult = topRight.join();
            Double bottomLeftResult = bottomLeft.join();
            Double topLeftResult = topLeft.join();

            Double bottomRightResult = bottomRight.compute();
            //Double topLeftResult = topLeft.compute();
            //Double topLeftResult = topLeft.join();

            double res = (topLeftResult + topRightResult + bottomLeftResult + bottomRightResult);

            return res / 4;
        }
    }

}
