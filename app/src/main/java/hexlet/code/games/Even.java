package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void playEven(String userName, int maxRoundsCount) {
        int counter = 0;
        String positiveAnswer = "yes";
        String negativeAnswer = "no";

        while (counter < maxRoundsCount) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            int number = (int) (Math.random() * 10);
            boolean isEven = number % 2 == 0;
            System.out.println("Question: " + number);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (isEven && userAnswer.equals(positiveAnswer) || !isEven && userAnswer.equals(negativeAnswer)) {
                System.out.println("\nCorrect!");
                counter += 1;
            } else {
                String correctAnswer = negativeAnswer;
                if (userAnswer.equals(negativeAnswer)) {
                    correctAnswer = positiveAnswer;
                }
                System.out.println("'" + userAnswer + "'" + "is a wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'");
                System.out.println("Let's try again, " + userName);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
