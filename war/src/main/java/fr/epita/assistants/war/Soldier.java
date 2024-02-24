package fr.epita.assistants.war;

public class Soldier extends Combatant {
    public int health_points;
    public int damage_points;
    public String scream;

    public Soldier() {
        this.health_points = 15;
        this.damage_points = 3;
        this.scream = "No pity for losers!";
    }

    public void kill()
    {
        this.health_points = 0;
    }

    @Override
    void printState()
    {
        System.out.println("I have " + health_points + " health points.");
    }

    @Override
    void attack(Soldier s) {
        s.health_points -= damage_points;
    }

    @Override
    void attack(Vehicle v) {
        System.out.println("I can't fight this.");
    }

    @Override
    void scream() {
        System.out.println(scream);
    }
}
