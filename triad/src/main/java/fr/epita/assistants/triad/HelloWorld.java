package fr.epita.assistants.triad;

public class HelloWorld {

    private final int number;

    public int getNumber() {
        return number;
    }

    public HelloWorld(int number) {
        this.number = number;
    }

    public void HelloSir() {
        System.out.println("Hello World!");
        System.out.println(number);
    }
}
