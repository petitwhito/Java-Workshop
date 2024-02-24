package fr.epita.assistants;

import fr.epita.assistants.practicelombok.*;

public class Main {
    public static void main(String[] args) {
        Spider spider = new Spider("Spider");
        System.out.println(spider.getName());

        Tiger tiger = new Tiger("Tiger", "Tigrou");
        System.out.println(tiger);

        Horse horse = new Horse("Horse", "My little poney", 88);
        System.out.println(horse.hashCode());

        Shark shark = new Shark("Shark", "Baby shark", 50);
        System.out.println(shark);
        
        Falcon falcon = new Falcon();
        System.out.println(falcon);
    }
}
