package machine;

public class Controller {
    private final Resources resources;
    private Drinks drink;
    private State state;

    public Controller() {
        resources = new Resources();
        state = State.MENU;

        initialState();
    }

    private void initialState() {
        fillResources(400, 120, 540, 9, 550);
        stateMessage();
    }

    public void listenAction(String userInput) {
        try {
            switch (state) {
                case MENU:
                    menuAction(Action.valueOf(userInput.toUpperCase()));
                    break;
                case FILL:
                    fillAction(Integer.parseInt(userInput));
                    break;
                case BUY:
                    selectDrink(userInput);
                    break;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Incorrect input. Try again.");
        }
        stateMessage();
    }

    private void stateMessage() {
        switch (state) {
            case MENU:
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
            case BUY:
                System.out.printf("\nWhat do you want to buy? %s, back - to main menu:\n", Drinks.getDrinksDescription());
                break;
            case FILL:
                switch (state.getStep()) {
                    case 1:
                        System.out.println("\nWrite how many ml of water do you want to add: ");
                        break;
                    case 2:
                        System.out.println("Write how many ml of milk do you want to add: ");
                        break;
                    case 3:
                        System.out.println("Write how many grams of coffee beans do you want to add: ");
                        break;
                    case 4:
                        System.out.println("Write how many disposable cups of coffee do you want to add: ");
                        break;
                    default:
                        System.out.println("ERROR: Unsupported step of fill!");
                }
                break;
            default:
                System.out.println("\nERROR: Unsupported state!");
                break;
        }
    }

    private void menuAction(Action action) {
        switch (action) {
            case BUY:
                state = State.BUY;
                break;
            case FILL:
                state = State.FILL;
                break;
            case EXIT:
                state = State.MENU;
                shutDown();
                break;
            case TAKE:
                state = State.MENU;
                takeMoney();
                break;
            case REMAINING:
                state = State.MENU;
                printLog();
                break;
            default:
                state = State.MENU;
                throw new IllegalArgumentException("ERROR: Unsupported menu action!");
        }
    }

    private void fillAction(int resource) {
        switch (state.getStep()) {
            case 1:
                fillResources(resource, 0, 0, 0, 0);
                state.nextStep();
                break;
            case 2:
                fillResources(0, 0, resource, 0, 0);
                state.nextStep();
                break;
            case 3:
                fillResources(0, resource, 0, 0, 0);
                state.nextStep();
                break;
            case 4:
                fillResources(0, 0, 0, resource, 0);
                state.resetStep();
                state = State.MENU;
                break;
            default:
                state = State.MENU;
                throw new IllegalArgumentException("ERROR: Unsupported fill step. User input ignored.");
        }
    }

    private void selectDrink(String type) {
        if(type.equals("back")){
            state = State.MENU;
            return;
        }
        try {
            drink = Drinks.values()[Integer.parseInt(type) - 1];
            makeDrink(1);
            state = State.MENU;
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("ERROR: Unsupported drink type. User input ignored.");
        }
    }

    private int checkResources() {
        int milkCups = drink.getResources().getMilk() == 0 ?
                resources.getMilk() : resources.getMilk() / drink.getResources().getMilk();
        int waterCups = drink.getResources().getWater() == 0 ?
                resources.getWater() : resources.getWater() / drink.getResources().getWater();
        int beansCups = drink.getResources().getBeans() == 0 ?
                resources.getBeans() : resources.getBeans() / drink.getResources().getBeans();
        int cups = drink.getResources().getCups() == 0 ?
                resources.getCups() : resources.getCups() / drink.getResources().getCups();
        if (milkCups == 0) {
            System.out.println("Sorry, not enough milk!");
        }
        if (waterCups == 0) {
            System.out.println("Sorry, not enough water!");
        }
        if (beansCups == 0) {
            System.out.println("Sorry, not enough coffee beans!");
        }
        if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
        return Math.min(Math.min(beansCups, cups), Math.min(milkCups, waterCups));
    }

    private int makeDrink(int askCups) {
        if (drink == null) {
            throw new IllegalArgumentException("ERROR: Drink not selected. Cannot brew coffee!");
        }
        if (askCups < 0) {
            throw new IllegalArgumentException("ERROR: cups to make negative!");
        }
        if (askCups == 0) {
            return 0;
        }
        int availableCups = checkResources();
        if (askCups > availableCups) {
            return -availableCups;
        }
        resources.spend(drink.getResources());
        System.out.printf("I have enough resources, making you a %s!\n", drink.getDescription());
        return makeDrink(--askCups);
    }

    private void takeMoney() {
        System.out.println("I gave you $" + resources.getMoney());
        resources.spend(new Resources(0, 0, 0, 0, resources.getMoney()));
    }

    private void printLog() {
        String message = String.format("The coffee machine has:\n" +
                        "%d of water\n" +
                        "%d of milk\n" +
                        "%d of coffee beans\n" +
                        "%d of disposable cups\n" +
                        "$%d of money",
                resources.getWater(),
                resources.getMilk(),
                resources.getBeans(),
                resources.getCups(),
                resources.getMoney());
        System.out.println(message);
    }

    private void shutDown() {
        System.exit(0);
    }

    private void fillResources(int water, int beans, int milk, int cups, int money) {
        resources.add(new Resources(water, beans, milk, cups, money));
    }
}
