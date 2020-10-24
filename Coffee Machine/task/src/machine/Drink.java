package machine;

public abstract class Drink {
    Ingredients ingredients;
    String description = "unnamed drink";
    Ingredients getIngredients(){
        return ingredients;
    }
    abstract double getCost();
    String getDescription(){
        return description;
    }
}
