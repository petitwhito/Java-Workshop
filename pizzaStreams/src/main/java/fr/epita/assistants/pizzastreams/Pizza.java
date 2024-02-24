package fr.epita.assistants.pizzastreams;

import fr.epita.assistants.pizzastreams.Topping.Cheese;
import fr.epita.assistants.pizzastreams.Topping.Protein;
import fr.epita.assistants.pizzastreams.Topping.Sauce;
import fr.epita.assistants.pizzastreams.Topping.Vegetable;

import java.util.List;

public class Pizza {
    private final String name;
    private final Dough dough;
    private final Topping topping;
    private final Integer price;

    public Pizza(final String name, final Dough dough, final Sauce sauce, final Cheese cheese,
                 final List<Vegetable> vegetableList, final Protein protein) {
        this.name = name;
        this.topping = new Topping(sauce, cheese, vegetableList, protein);
        this.dough = dough;

        final int doughPrice = dough.getPrice();
        final int saucePrice = topping.getSaucePrice();
        final int cheesePrice = topping.getCheesePrice();
        final int vegetablesPrice = topping.getVegetablesPrice();
        final int proteinPrice = topping.getProteinPrice();

        this.price = doughPrice + saucePrice + cheesePrice + vegetablesPrice
                + proteinPrice;
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public Topping getTopping() {
        return topping;
    }

    public Integer getPrice() {
        return price;
    }
}
