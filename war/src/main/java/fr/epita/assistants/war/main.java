package fr.epita.assistants.war;

public class main {
    public static void main(String[] args) {
        Soldier s1 = new Soldier();
        Knight k1 = new Knight();
        Assassin a1 = new Assassin();
        Vehicle v1 = new Vehicle("M47 Patton", 500);
        Vehicle v2 = new Vehicle("T-54", 500);
        s1.attack(k1);
        k1.attack(a1);
        a1.attack(s1);
        v1.attack(v2);
        s1.printState();
        k1.printState();
        a1.printState();
        v1.printState();
        v2.printState();
    }
}
