package machine;

public class Ingredients {
    private int milk;
    private int water;
    private int beans;

    public Ingredients(int milk, int water, int beans) {
        this.milk = milk;
        this.water = water;
        this.beans = beans;
    }

    public int canBeCooked(Drink drink) {
        int milkCups = drink.getIngredients().milk == 0 ? milk : milk / drink.getIngredients().milk;
        int waterCups = drink.getIngredients().water == 0 ? water : water / drink.getIngredients().water;
        int beansCups = drink.getIngredients().beans == 0 ? beans : beans / drink.getIngredients().beans;
        return Math.min(beansCups, Math.min(milkCups, waterCups));
    }

    public void spend(Ingredients ingredients) {
        this.beans -= ingredients.beans;
        this.milk -= ingredients.milk;
        this.water -= ingredients.water;
    }

}
