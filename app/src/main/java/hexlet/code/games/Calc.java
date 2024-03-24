package hexlet.code.games;

import java.util.List;
import static hexlet.code.util.Utils.getRandomNumber;

public class Calc {
    public static final int ID = 3;
    public static final String TITLE = "Calc";
    public static final String RULES = "What is the result of the expression?";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final String[] OPERATIONS = {"+", "-", "*"};


    public static String generateQuestionParameters() {
        final int firstNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        final int secondNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        final int operatorIndex = (int) (Math.random() * 10) % OPERATIONS.length;
        final String operator = OPERATIONS[operatorIndex];
        return firstNumber + " " + operator + " " + secondNumber;
    }

    public static String giveRightAnswer(String questionParameters) {
        final List<String> parameters = List.of(questionParameters.split(" "));
        final int firstNumber = Integer.parseInt(parameters.getFirst());
        final int lastNumber = Integer.parseInt(parameters.getLast());

        return switch (parameters.get(1)) {
            case "+" -> firstNumber + lastNumber + "";
            case "-" -> firstNumber - lastNumber + "";
            case "*" -> firstNumber * lastNumber + "";
            default -> "Error: false parameters";
        };
    }
}
