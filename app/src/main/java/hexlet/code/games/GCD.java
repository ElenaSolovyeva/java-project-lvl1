package hexlet.code.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static hexlet.code.util.Utils.getRandomNumber;

/*GCD: Greatest Common Divisor*/
public class GCD {
    public static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 20;
    private static final int MIN_MULTIPLIER = 2;
    private static final int MAX_MULTIPLIER = 5;

    private static int calculate(int first, int second) {
        int maxNumber = Math.abs(Math.max(first, second));
        int result = 1;

        for (int i = 2; i <= maxNumber; i++) {
            if (first % i == 0 && second % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public static List<String> generateParameters() {
        int multiplier = getRandomNumber(MIN_MULTIPLIER, MAX_MULTIPLIER);
        int firstNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER) * multiplier;
        int secondNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER) * multiplier;
        List<String> gameParameters = new ArrayList<>(Arrays.asList("Question parameters", "Right answer"));

        String questionParameters = firstNumber + " " + secondNumber;
        gameParameters.set(0, questionParameters);

        String rightAnswer = calculate(firstNumber, secondNumber) + "";
        gameParameters.set(1, rightAnswer);

        return gameParameters;
    }
}
