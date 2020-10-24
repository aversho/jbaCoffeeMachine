package machine;

public class Latte extends Drink{
    public Latte() {
        ingredients = new Ingredients(350, 20, 75);
        description = "latte";
    }

    @Override
    double getCost() {
        return 7.0;
    }
}
