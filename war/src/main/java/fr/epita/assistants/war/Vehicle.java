package fr.epita.assistants.war;

public class Vehicle extends Combatant {
    public int defense;
    public String name;
    public Vehicle(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    @Override
    void printState()
    {
        System.out.println("I have " + defense + " defense points.");
    }

    @Override
    void attack(Soldier s) {
        s.health_points = 0;
    }

    @Override
    void attack(Vehicle v) {
        v.defense /= 2;
    }

    @Override
    void scream() {
        System.out.println("I'm " + name + "!");
    }
}
