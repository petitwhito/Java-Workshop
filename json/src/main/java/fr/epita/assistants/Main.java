package fr.epita.assistants;

import fr.epita.assistants.json.Json;

public class Main {
    public static void main(String[] args) {
        Json.addToJson("foo", "bar", "res.json");
        Json.addToJson("ser", "val", "res.json");
        Json.addToJson("ya", "ka", "res.json");

        // Use the following to test for random numbers
        /*
        for (int i = 0; i < 42; ++i) {
            Json.addToJson(Long.toString(new Random().nextLong()), Long.toString(new Random().nextLong()), "res.json");
        }
        */
    }
}
