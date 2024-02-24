package fr.epita.assistants;

import fr.epita.assistants.triad.FixMyMistake;
import fr.epita.assistants.triad.UglyClass;
import fr.epita.assistants.triad.WriteGettersAndConstructorForMe;
import fr.epita.assistants.triad.HelloWorld;

public class Main {
    public static void main(String[] args) {
        // Use Alt+Enter to import missing classes
        final WriteGettersAndConstructorForMe writeGettersAndConstructorForMe = new WriteGettersAndConstructorForMe(
                "name", "firstName", "lastName", "random", "anotherOne", "anotherOne2", "anotherOne3", "xyz", 1, 2.0,
                3.0f, true, false);
        System.out.println(writeGettersAndConstructorForMe.getName());
        System.out.println(writeGettersAndConstructorForMe.getFirstName());
        System.out.println(writeGettersAndConstructorForMe.getLastName());
        System.out.println(writeGettersAndConstructorForMe.getRandom());
        System.out.println(writeGettersAndConstructorForMe.getAnotherOne());
        System.out.println(writeGettersAndConstructorForMe.getAnotherOne2());
        System.out.println(writeGettersAndConstructorForMe.getAnotherOne3());
        System.out.println(writeGettersAndConstructorForMe.getXyz());
        System.out.println(writeGettersAndConstructorForMe.getX());
        System.out.println(writeGettersAndConstructorForMe.getY());
        System.out.println(writeGettersAndConstructorForMe.getZ());
        System.out.println("Hello World!");
        System.out.println(FixMyMistake.myEasyFunction()); // 43
        UglyClass.getMyMessWithParameters();
        HelloWorld h = new HelloWorld(5);
        h.HelloSir();
        System.out.println(h.getNumber());
    }
}
