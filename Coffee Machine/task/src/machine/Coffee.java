package machine;

public class Coffee implements Drink{
    private final Ingredients ingredients;

    public Coffee() {
        ingredients = new Ingredients(50, 200, 15);
    }

    public Ingredients getIngredients() {
        return this.ingredients;
    }
}
