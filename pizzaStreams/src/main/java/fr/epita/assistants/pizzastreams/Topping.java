package fr.epita.assistants.pizzastreams;

import java.util.List;
import java.util.Optional;

public class Topping {
    public enum Sauce {
        TOMATO,
        BUFFALO,
        PESTO,
    }

    public enum Cheese {
        MOZZARELLA,
        CHEDDAR,
        CREAM,
    }

    public enum Vegetable {
        OLIVE,
        MUSHROOM,
        ONION,
    }

    public enum Protein {
        CHICKEN,
        BACON,
        MERGUEZ,
    }

    private final Sauce sauce;
    private final Cheese cheese;
    private final List<Vegetable> vegetableList;
    private final Protein protein;

    public Topping(final Sauce sauce, final Cheese cheese, final List<Vegetable> vegetableList,
                   final Protein protein) {
        this.sauce = sauce;
        this.cheese = cheese;
        this.vegetableList = vegetableList;
        this.protein = protein;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public List<Vegetable> getVegetableList() {
        return vegetableList;
    }

    public Optional<Protein> getProtein() {
        return Optional.ofNullable(protein);
    }

    public Integer getSaucePrice() {
        return (sauce == Sauce.TOMATO) ? 1 : ((sauce == Sauce.BUFFALO) ? 2 : 3);
    }

    public Integer getCheesePrice() {
        return (cheese == Cheese.MOZZARELLA) ? 2 : ((cheese == Cheese.CHEDDAR) ? 3 : 4);
    }

    public Integer getProteinPrice() {
        return protein == null ? 0
                : protein == Protein.CHICKEN ? 5 : 8;
    }

    public Integer getVegetablesPrice() {
        return (vegetableList
                .isEmpty()
                ? 0
                : vegetableList.stream()
                .mapToInt((v) -> (v == Vegetable.OLIVE
                        || v == Vegetable.ONION) ? 1 : 2)
                .sum());
    }
}
