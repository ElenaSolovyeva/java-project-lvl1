package hexlet.code.games;
import hexlet.code.util.Parameters;

import static hexlet.code.util.Utils.POSITIVE_ANSWER;
import static hexlet.code.util.Utils.NEGATIVE_ANSWER;
import static hexlet.code.util.Utils.getRandomNumber;
import static hexlet.code.util.Utils.isPrime;

public class Prime {
    public static final int ID = 6;
    public static final String TITLE = "Prime";
    public static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 4;
    private static final int MAX_NUMBER = 99;

    public static Parameters generateParameters() {
        Parameters param = new Parameters();
        int currentNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        param.setQuestionParameters(currentNumber + "");
        String rightAnswer = isPrime(currentNumber) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
        param.setRightAnswer(rightAnswer);
        return param;
    }
}
