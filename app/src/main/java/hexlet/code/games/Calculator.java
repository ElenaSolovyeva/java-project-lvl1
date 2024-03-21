package hexlet.code.games;

import java.util.Scanner;

public class Calculator {
    public static void playCalculator(String userName, int maxRoundsCount) {
        int counter = 0;
        String[] operations = {"+", "-", "*"};

        while (counter < maxRoundsCount) {
            System.out.println("What is the result of the expression?");
            int firstNumber = (int) (Math.random() * 10) + 1;
            int secondNumber = (int) (Math.random() * 10) + 1;
            int index = (int) (Math.random() * 10) % 3;
            int rightAnswer;

            switch (operations[index]) {
                case "+" :
                    rightAnswer = firstNumber + secondNumber;
                    break;

                case "-" :
                    rightAnswer = firstNumber - secondNumber;
                    break;
                case "*" :
                    rightAnswer = firstNumber * secondNumber;
                    break;
                default:
                    rightAnswer = 99999;
            }

            System.out.println("Question: " + firstNumber + " " + operations[index] + " " + secondNumber);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(rightAnswer + "")) {
                System.out.println("\nCorrect!");
                counter += 1;
            } else {

                System.out.println("'" + userAnswer + "'" + "is a wrong answer ;(. Correct answer was "
                        + "'" + rightAnswer + "'");
                System.out.println("Let's try again, " + userName);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
