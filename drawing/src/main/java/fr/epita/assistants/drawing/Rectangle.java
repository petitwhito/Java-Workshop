package fr.epita.assistants.drawing;

public class Rectangle extends Sharp {

    private int width;
    public Rectangle(int width, int length) {
        super(length);
        this.width = width;
    }

    @Override
    public void draw() {
        int w = width;
        int h = length;
        for (int i = 0; i < h; i++)
        {
            for (int j = 0; j < w; j++)
            {
                if (j == 0 || (i == 0 && j + 1 < w) || (i + 1 == h && j + 1 < w))
                    System.out.print("# ");
                else if (j + 1 == w)
                    System.out.print("#");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
