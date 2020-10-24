package machine;

public class Controller {
    private Ingredients ingredients;
    private Drink drink;
    private int money;
    private int cups;

    public Controller(){
        ingredients = new Ingredients();
        cups = 0;
        money = 0;
    }

    public void setDrink(Drink drink){
        this.drink = drink;
    }

    public boolean selectDrink(){
        drink = null;
        boolean returnToMenu = false;
        while (drink == null && !returnToMenu) {
            String type = Display.prompt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main returnToMenu:");
            switch (type) {
                case "1":
                    drink = new Espresso();
                    break;
                case "2":
                    drink = new Latte();
                    break;
                case "3":
                    drink = new Cappuccino();
                    break;
                case "back":
                    returnToMenu = true;
                    break;
                default:
                    Display.println("Incorrect input. Try again.");
                    break;
            }
        }
        return !returnToMenu;
    }

    public int availableCupsOfDrink(){
        return ingredients.canBeCooked(drink);
    }

    public int makeDrink(int askCups){
        if(drink == null){
            return 0;
        }
        int availableCups = Math.min(availableCupsOfDrink(), cups);
        if(askCups <= 0){
            return availableCups;
        }
        if(askCups > availableCups) {
            return -availableCups;
        }
        ingredients.spend(drink.getIngredients());
        cups--;
        money += drink.getCost();
        return makeDrink(--askCups);
    }

    public int takeMoney(){
        int take = this.money;
        this.money = 0;
        return take;
    }

    public void printLog(){
        String message = String.format("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n", ingredients.getWater(), ingredients.getMilk(), ingredients.getBeans(), cups, money);
        Display.println(message);
    }

    public void fillResources(int water, int beans, int milk, int cups, int money){
        this.cups += Math.max(cups, 0);
        this.money += Math.max(money, 0);
        this.ingredients.add(new Ingredients(water, beans, milk));
    }
}
