package machine;

public class Ingredients {
    private int milk;
    private int water;
    private int beans;

    public Ingredients(){
        this(0,0,0);
    }

    public Ingredients(int water, int beans) {
        this(water, beans, 0);
    }

    public Ingredients(int water, int beans, int milk) {
        this.milk = Math.max(milk, 0);
        this.water = Math.max(water, 0);
        this.beans = Math.max(beans, 0);
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

    public void add(Ingredients ingredients) {
        this.beans += ingredients.beans;
        this.milk += ingredients.milk;
        this.water += ingredients.water;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getBeans() {
        return beans;
    }
}
