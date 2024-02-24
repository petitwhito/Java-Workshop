package fr.epita.assistants;

import fr.epita.assistants.staticpen.Pen;

public class Main {
    public static void main(String[] args) {
        Pen pen1 = new Pen(Pen.Color.RED);
        Pen pen2 = new Pen(Pen.Color.BLUE);

        pen1.print();
        pen2.print();

        System.out.println(Pen.getBluePenCounter());
        System.out.println(Pen.getRedPenCounter());

        System.out.println(Pen.getPenCounter());
    }
}
