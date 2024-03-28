package hexlet.code.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hexlet.code.util.Utils.getRandomNumber;

public class Calc {
    public static final String RULES = "What is the result of the expression?";
    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 10;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    private static int calculate(int first, int second, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            default -> first * second;
        };
    }

    public static List<String> generateParameters() {
        int firstNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        int secondNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        int operationIndex = getRandomNumber(0, OPERATIONS.length);
        String operator = OPERATIONS[operationIndex];
        List<String> gameParameters = new ArrayList<>(Arrays.asList("Question parameters", "Right answer"));

        String questionParameters = firstNumber + " " + operator + " " + secondNumber;
        gameParameters.set(0, questionParameters);

        String rightAnswer = calculate(firstNumber, secondNumber, operator) + "";
        gameParameters.set(1, rightAnswer);

        return gameParameters;
    }
}
