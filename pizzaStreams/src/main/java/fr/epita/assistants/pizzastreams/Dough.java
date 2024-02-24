package fr.epita.assistants.pizzastreams;

public enum Dough {
    NATURE(2),
    CAJUN(3);

    private final Integer price;

    Dough(final Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }
}
