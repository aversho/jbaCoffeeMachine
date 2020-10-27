package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (scanner.hasNext()) {
            controller.listenAction(scanner.nextLine());
        }
    }

}
