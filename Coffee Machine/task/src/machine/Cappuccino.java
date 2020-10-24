package machine;

public class Cappuccino extends Drink {
    public Cappuccino(){
        ingredients = new Ingredients(200, 12, 100);
        description = "cappuccino";
    }

    @Override
    double getCost() {
        return 6.0;
    }
}
