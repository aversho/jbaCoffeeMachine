package machine;

public class Controller {
    private final Ingredients ingredients;
    private Drink drink;

    public Controller(Ingredients ingredients){
        this.ingredients = ingredients;
    }

    public void selectDrink(Drink drink){
        this.drink = drink;
    }

    public int availableCupsOfDrink(){
        return ingredients.canBeCooked(drink);
    }

    public int make(int cups){
        int availableCups = availableCupsOfDrink();
        if(cups <= 0){
            return availableCups;
        }
        if(cups > availableCups) {
            return -availableCups;
        }
        ingredients.spend(drink.getIngredients());
        return make(--cups);
    }
}
