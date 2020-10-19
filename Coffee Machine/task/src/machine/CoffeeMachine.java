package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static Display display = new Display();

    public static void main(String[] args) {
        Calculator calc = new Calculator(promptForCups());
        display.print(String.format("For %d cups of coffee you will need:", calc.getCups()));
        display.print(String.format("%d ml of water", calc.water()));
        display.print(String.format("%d ml of milk", calc.milk()));
        display.print(String.format("%d g of coffee beans", calc.beans()));
    }

    private static int promptForCups(){
        Scanner sc = new Scanner(System.in);
        display.print("Write how many cups of coffee you will need: ");
        return sc.nextInt();
    }

}
