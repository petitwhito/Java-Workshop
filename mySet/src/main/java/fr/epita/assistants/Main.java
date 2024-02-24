package fr.epita.assistants;

import fr.epita.assistants.myset.IntegerSet;
import fr.epita.assistants.myset.GenericSet;


public class Main {
    public static void main(String[] args) {
        GenericSet my_set = new GenericSet();
        my_set.insert(1);
        my_set.insert(2);
        System.out.println("My set contains " + my_set.size() + " element(s)");
        my_set.remove(3);
        my_set.remove(2);
        System.out.println("My set contains " + my_set.size() + " element(s)");
        my_set.insert(1);
        System.out.println(my_set.has(1));
    }
}