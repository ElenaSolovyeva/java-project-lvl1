package hexlet.code.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hexlet.code.util.Utils.POSITIVE_ANSWER;
import static hexlet.code.util.Utils.NEGATIVE_ANSWER;
import static hexlet.code.util.Utils.getRandomNumber;

public class Prime {
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NUMBER = 99;

    private static String calculate(int number) {
        String result = POSITIVE_ANSWER;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                result = NEGATIVE_ANSWER;
                break;
            }
        }
        return result;
    }

    public static List<String> generateParameters() {
        int number = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        List<String> gameParameters = new ArrayList<>(Arrays.asList("Question parameters", "Right answer"));

        String questionParameters = number + "";
        gameParameters.set(0, questionParameters);

        String rightAnswer = calculate(number);
        gameParameters.set(1, rightAnswer);

        return gameParameters;
    }
}
