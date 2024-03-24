package hexlet.code.games;

import hexlet.code.util.Parameters;
import static hexlet.code.util.Utils.getGCD;
import static hexlet.code.util.Utils.getRandomNumber;

/*GCD: Greatest Common Divisor*/
public class GCD {
    public static final int ID = 4;
    public static final String TITLE = "GCD";
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 20;
    private static final int MIN_MULTIPLIER = 2;
    private static final int MAX_MULTIPLIER = 5;

    public static Parameters generateParameters() {
        Parameters param = new Parameters();
        final int multiplier = getRandomNumber(MIN_MULTIPLIER, MAX_MULTIPLIER);
        final int firstNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER) * multiplier;
        final int secondNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER) * multiplier;
        param.setQuestionParameters(firstNumber + " " + secondNumber);
        int rightAnswer = getGCD(firstNumber, secondNumber);
        param.setRightAnswer(rightAnswer + "");

        return param;
    }
}
