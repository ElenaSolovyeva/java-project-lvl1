package hexlet.code.games;

import hexlet.code.util.Parameters;
import static hexlet.code.util.Utils.POSITIVE_ANSWER;
import static hexlet.code.util.Utils.NEGATIVE_ANSWER;
import static hexlet.code.util.Utils.getRandomNumber;

public class Even {
    public static final int ID = 2;
    public static final String TITLE = "Even";
    public static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;

    public static Parameters generateParameters() {
        Parameters param = new Parameters();
        int randomNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        param.setQuestionParameters(randomNumber + "");
        String rightAnswer = (randomNumber % 2 == 0) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
        param.setRightAnswer(rightAnswer);
        return param;
    }
}
