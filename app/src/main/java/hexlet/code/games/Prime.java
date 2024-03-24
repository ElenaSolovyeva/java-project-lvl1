package hexlet.code.games;
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


    public static String generateQuestionParameters() {
        int number = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        return number + "";
    }

    public static String giveRightAnswer(String questionParameters) {
        int number = Integer.parseInt(questionParameters);
        return isPrime(number) ? POSITIVE_ANSWER : NEGATIVE_ANSWER;
    }
}
