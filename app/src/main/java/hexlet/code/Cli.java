package hexlet.code;
import java.util.Scanner;
public class Cli {
    public static String userName;
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static void playEven() {
        int counter = 0;
        String positiveAnswer = "yes";
        String negativeAnswer = "no";

        while (counter < 3) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            int number = (int) (Math.random() * 10);
            boolean isEven = number % 2 == 0;
            System.out.println("Question: " + number);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your answer: ");
            String userAnswer = scanner.next();

            if (isEven && userAnswer.equals(positiveAnswer) || !isEven && userAnswer.equals(negativeAnswer)) {
                System.out.println("Correct!");
                counter += 1;
            } else {
                String correctAnswer = negativeAnswer;
                if (userAnswer.equals(negativeAnswer)) {
                    correctAnswer = positiveAnswer;
                }
                System.out.println("'" + userAnswer + "'" + "is a wrong answer ;(. Correct answer was "
                                + "'" + correctAnswer + "'");
                System.out.println("Let's try again, " + userAnswer);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void selectGame() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String gameNumber = scanner.next();
        System.out.println();

        if (gameNumber.equals("1")) {
            greeting();
        } else if (gameNumber.equals("2")) {
            greeting();
            playEven();
        }
    }
}
