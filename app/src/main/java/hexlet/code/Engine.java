package hexlet.code;
import hexlet.code.games.Calculator;
import hexlet.code.games.Even;

import java.util.Scanner;
public class Engine {
    public final static int MAX_ROUNDS_COUNT = 3;
    private static String userName = "";
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static void selectGame() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calculator");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String gameNumber = scanner.next();
        System.out.println();

        if (gameNumber.equals("1")) {
            greeting();
        } else if (gameNumber.equals("2")) {
            greeting();
            Even.playEven(userName, MAX_ROUNDS_COUNT);
        } else if (gameNumber.equals("3")) {
            greeting();
            Calculator.playCalculator(userName, MAX_ROUNDS_COUNT);
        }
    }
}
