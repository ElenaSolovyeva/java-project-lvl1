package hexlet.code.games;

import hexlet.code.util.Parameters;
import static hexlet.code.util.Utils.getRandomNumber;

public class Calc {
    public static final int ID = 3;
    public static final String TITLE = "Calc";
    public static final String RULES = "What is the result of the expression?";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static Parameters generateParameters() {
        Parameters param = new Parameters();
        final int firstNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        final int secondNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        final int operatorIndex = (int) (Math.random() * 10) % OPERATIONS.length;
        final String operator = OPERATIONS[operatorIndex];
        param.setQuestionParameters(firstNumber + " " + operator + " " + secondNumber);
        switch (operator) {
            case "+":
                param.setRightAnswer(firstNumber + secondNumber + "");
                break;
            case "-":
                param.setRightAnswer(firstNumber - secondNumber + "");
                break;
            case "*":
                param.setRightAnswer(firstNumber * secondNumber + "");
                break;
            default:
                param.setRightAnswer("Error: false parameters");
        }
        return  param;
    }
}
