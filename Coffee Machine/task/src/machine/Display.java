package machine;

import java.util.Scanner;

public class Display {
    private static final Scanner sc = new Scanner(System.in);
    public static void print(String text) {
        System.out.print(text);
    }
    public static void println(String text) {
        System.out.println(text);
    }
    public static int promptInt(String text){
        Display.println(text);
        return sc.nextInt();
    }
    public static String prompt(String text){
        Display.println(text);
        return sc.nextLine();
    }
}
