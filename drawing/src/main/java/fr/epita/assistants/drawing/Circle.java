package fr.epita.assistants.drawing;

public class Circle extends Entity {
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw()
    {
        for (int y = -radius; y <= radius; y++)
        {
            for (int x = -radius; x <= radius; x++)
            {
                int sqDist = Math.abs(radius * radius - (x*x+y*y));
                if (sqDist < radius)
                    System.out.print("#");
                else
                    System.out.print(" ");

                if (x < radius)
                    System.out.print(" ");
            }
            if (y < radius)
                System.out.println();
        }
    }
}
