package machine;

public class CoffeeMachine {
    private final Controller controller;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        int cups = Display.promptInt("Write how many cups of coffee you will need: ");
        coffeeMachine.makeCoffee(cups);
    }

    public CoffeeMachine() {
        int waterHas = Display.promptInt("Write how many ml of water the coffee machine has: ");
        int milkHas = Display.promptInt("Write how many ml of milk the coffee machine has: ");
        int beansHas = Display.promptInt("Write how many grams of coffee beans the coffee machine has: ");
        this.controller = new Controller(new Ingredients(milkHas, waterHas, beansHas));
    }

    private void makeCoffee(int cups) {
        controller.selectDrink(new Coffee());
        int availableCups = controller.make(cups);
        if (availableCups >= 0) {
            Display.println(availableCups > 0 ?
                    String.format("Yes, I can make that amount of coffee (and even %d more than that)", availableCups) :
                    "Yes, I can make that amount of coffee");
        } else {
            Display.println(String.format("No, I can make only %d cup(s) of coffee", -availableCups));
        }
    }

}
