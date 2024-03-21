package hexlet.code;
import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.Progression;

import java.util.Scanner;
public class Engine {
    public static final int MAX_ROUNDS_COUNT = 3;
    private static final String[][] GAMES = {
            {"1", "Greet"},
            {"2", "Even"},
            {"3", "Calc"},
            {"4", "GCD"},
            {"5", "Progression"},
            {"0", "Exit"}};
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

        for (String[] game : GAMES) {
            System.out.println(game[0] + " - " + game[1]);
        }
        System.out.print("Your choise: ");

        Scanner scanner = new Scanner(System.in);
        String gameNumber = scanner.next();
        System.out.println();

        switch (gameNumber) {
            case "1" -> greeting();
            case "2" -> {
                greeting();
                Even.playEven(userName, MAX_ROUNDS_COUNT);
            }
            case "3" -> {
                greeting();
                Calculator.playCalculator(userName, MAX_ROUNDS_COUNT);
            }
            case "4" -> {
                greeting();
                GreatestCommonDivisor.playGCD(userName, MAX_ROUNDS_COUNT);
            }
            case "5" -> {
                greeting();
                Progression.playProgression(userName, MAX_ROUNDS_COUNT);
            }
            default -> {
                return;
            }
        }
    }
}
