package hexlet.code.games;

import static hexlet.code.util.Utils.POSITIVE_ANSWER;
import static hexlet.code.util.Utils.NEGATIVE_ANSWER;
import static hexlet.code.util.Utils.getRandomNumber;

public class Even {
    public static final int ID = 2;
    public static final String TITEL = "Even";
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;

    public static String generateQuestionParameters() {
        final int number = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        return number + "";
    }

    public static String giveRightAnswer(String questionParameters) {
        int number = Integer.parseInt(questionParameters);
        return (number % 2 == 0) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }
}
