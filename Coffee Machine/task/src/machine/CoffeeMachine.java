package machine;

public class CoffeeMachine {
    private final Controller controller;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (true) {
            String action = Display.prompt("Write action (buy, fill, take, remaining, exit):");
            switch (action) {
                case "buy":
                    coffeeMachine.buy();
                    break;
                case "fill":
                    coffeeMachine.fill();
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.printLog();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    Display.println("Incorrect input.");
                    break;
            }
            Display.println("");
        }
    }

    public CoffeeMachine() {
        this.controller = new Controller();
        this.controller.fillResources(400, 120, 540, 9, 550);
    }

    private void printLog() {
        controller.printLog();
    }

    private void buy() {
        if(controller.selectDrink()) {
            controller.makeDrink(1);
        }
    }

    private void fill(){
        int water = Display.promptInt("Write how many ml of water do you want to add: ");
        int milk = Display.promptInt("Write how many ml of milk do you want to add: ");
        int beans = Display.promptInt("Write how many grams of coffee beans do you want to add: ");
        int cups = Display.promptInt("Write how many disposable cups of coffee do you want to add: ");
        controller.fillResources(water, beans, milk, cups, 0);

    }

    private void take(){
        Display.println("I gave you $" + controller.takeMoney());
    }

    private void makeCoffee(int cups) {
        controller.setDrink(new Espresso());
        int availableCups = controller.makeDrink(cups);
        if (availableCups >= 0) {
            Display.println(availableCups > 0 ?
                    String.format("Yes, I can make that amount of coffee (and even %d more than that)", availableCups) :
                    "Yes, I can make that amount of coffee");
        } else {
            Display.println(String.format("No, I can make only %d cup(s) of coffee", -availableCups));
        }
    }

}
