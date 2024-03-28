package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Engine.play();
    }

    public static final String[][] GAMES = {
            {"1", "Greet"},
            {"2", "Even"},
            {"3", "Calc"},
            {"4", "GCD"},
            {"5", "Progression"},
            {"6", "Prime"},
            {"0", "Exit"}
    };

    public static int selectGame()  throws InputMismatchException {
        System.out.println("Please enter the game number and press Enter.");
        for (var game : GAMES) {
            System.out.println(game[0] + " - " + game[1]);
        }
        System.out.print("Your choise: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
