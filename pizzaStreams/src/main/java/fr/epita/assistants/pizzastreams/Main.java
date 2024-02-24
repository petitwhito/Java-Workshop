package fr.epita.assistants.pizzastreams;

import fr.epita.assistants.pizzastreams.Topping.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pizza> pizzas = List.of(
                new Pizza("Napoli", Dough.NATURE, Sauce.TOMATO,
                        Cheese.MOZZARELLA, List.of(Vegetable.OLIVE),
                        null),
                new Pizza("Chicken", Dough.NATURE, Sauce.TOMATO,
                        Cheese.MOZZARELLA,
                        List.of(Vegetable.MUSHROOM, Vegetable.ONION),
                        Protein.CHICKEN));

        System.out.println(
                "Total price is " + PizzaStreams.getTotalPrice(pizzas.stream())
                        + "\nAverage price is "
                        + PizzaStreams.getAveragePrice(pizzas.stream())
                        + "\nCheapest is: "
                        + PizzaStreams.getCheapest(pizzas.stream()).getName()
                        + "\nAre all nature italian? "
                        + PizzaStreams.areAllNatureItalians(pizzas.stream()));

        List<String> sortedByPrice = PizzaStreams.sortByPrice(pizzas.stream());
        System.out.printf("Sorted by price pizzas: %s%n",
                String.join(", ", sortedByPrice));

        List<String> carnivorousPizzas =
                PizzaStreams.getCarnivorous(pizzas.stream());
        System.out.printf("Carnivorous pizzas: %s%n",
                String.join(", ", carnivorousPizzas));

        List<String> vegePizzas = PizzaStreams.getVeggies(pizzas.stream());
        System.out.printf("Vegetarian pizzas: %s%n",
                String.join(", ", vegePizzas));
    }
}
