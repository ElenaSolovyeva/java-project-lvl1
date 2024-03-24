package hexlet.code.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import static hexlet.code.util.Games.games;

public class Utils {
    public static final String POSITIVE_ANSWER = "yes";
    public static final String NEGATIVE_ANSWER = "no";
    public static final String POSITIVE_FEEDBACK = "Correct!";

    public static String giveNegativeFeedback(String userAnswer, String rightAnswer, String userName) {
        return "'" + userAnswer + "' is a wrong answer ;(."
                + " Correct answer was '" + rightAnswer + "'."
                + "\nLet's try again, " + userName;
    }

    public static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int getRandomNumber(int low, int high) {
        while (true) {
            int randomNumber = (int) (Math.random()  * high);
            if (randomNumber >= low && randomNumber <= high) {
                return randomNumber;
            }
        }
    }

    public static int getGCD(int first, int second) {
        int maxNumber = Math.abs(Math.max(first, second));
        int result = 1;

        for (int i = 2; i <= maxNumber; i++) {
            if (first % i == 0 && second % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static int selectGame()  throws InputMismatchException {
        System.out.println("Please enter the game number and press Enter.");
        for (var game : games) {
            System.out.println(game.id + " - " + game.title);
        }
        System.out.print("Your choise: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
