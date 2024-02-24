package fr.epita.assistants.staticpen;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.PrintStream;

public class Pen {

    // FIXME: Add attributes here.
    public enum Color {
        RED,
        BLUE
    }

    public Color color;
    public static int count_global = 0;
    public static int count_red = 0;
    public static int count_blue = 0;

    public Pen(final Color color) {
        this.color = color;
        count_global++;
        if (color == Color.RED)
            count_red++;
        else
            count_blue++;
    }

    public static int getRedPenCounter() {
        return count_red;
    }

    public static int getPenCounter() {
        return count_global;
    }

    public static int getBluePenCounter() {
        return count_blue;
    }

    public void changeColor(final Color color) {
        if (color == this.color)
            return;
        else if (color == Color.BLUE)
        {
            count_blue++;
            count_red--;
        }
        else
        {
            count_blue--;
            count_red++;
        }
        this.color = color;
    }

    public static void resetCounts() {
        count_red = 0;
        count_global = 0;
        count_blue = 0;
    }

    public void print() {
        if (color == Color.RED)
            System.out.println("I'm a RED pen.");
        else
            System.out.println("I'm a BLUE pen.");
    }
}
