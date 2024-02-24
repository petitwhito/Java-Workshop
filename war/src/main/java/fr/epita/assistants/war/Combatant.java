package fr.epita.assistants.war;

public abstract class Combatant {
    void printState() {
        System.err.println("Error 404. Class not found.");
    }
    abstract void attack(Soldier s);
    abstract void attack(Vehicle v);
    abstract void scream();
}
