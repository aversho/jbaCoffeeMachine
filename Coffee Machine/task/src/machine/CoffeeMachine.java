package machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        Display display = new Display();
        String messages = "Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!";
        for (String message : messages.split("\n")) {
            display.print(message);
        }
    }
}
