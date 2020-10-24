package machine;

public class Espresso extends Drink{
    public Espresso() {
        ingredients = new Ingredients(250, 16);
    }

    @Override
    double getCost() {
        return 4;
    }
}
