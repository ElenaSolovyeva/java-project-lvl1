package hexlet.code.games;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static int getGCD(int first, int second) {
        int maxNumber = Math.abs(Math.max(first, second));
        int result = 1;

        for (int i = 2; i <= maxNumber / 2; i++) {
            if (first % i == 0 && second % i == 0) {
                result = i;
            }
        }
        return result;
    }
    public static void playGCD(String userName, int maxRoundsCount) {
        int counter = 0;
        System.out.println("Find the greatest common divisor of given numbers.");

        while (counter < maxRoundsCount) {
            int multiplier = (int) (2 + (Math.random() * 10) % 5);
            int firstNumber = (int) (Math.random() * 10 + 1) * multiplier;
            int secondNumber = (int) (Math.random() * 10 + 1) * multiplier;
            int gcd = getGCD(firstNumber, secondNumber);
            System.out.println("Question: " + firstNumber + " " + secondNumber);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            int answer = Integer.parseInt(userAnswer);

            if (answer == gcd) {
                System.out.println("\nCorrect!");
                counter += 1;
            } else {
                System.out.println("'" + userAnswer + "'" + "is a wrong answer ;(. Correct answer was "
                        + "'" + gcd + "'");
                System.out.println("Let's try again, " + userName);
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
