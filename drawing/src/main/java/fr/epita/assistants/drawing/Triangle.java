package fr.epita.assistants.drawing;

public class Triangle extends Sharp {
    public Triangle(int length) {
        super(length);
    }
    public void draw()
    {
        int rows = length;
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (j == 1 || (i == rows && j < i))
                    System.out.print("# ");
                else if (j == i)
                    System.out.print("#");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
