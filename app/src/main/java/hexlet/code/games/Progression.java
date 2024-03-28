package hexlet.code.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hexlet.code.util.Utils.getRandomList;
import static hexlet.code.util.Utils.getRandomNumber;

public class Progression {
    public static final String RULES = "What number is missing in the progression?";
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MIN_FIRST_MEMBER = 1;
    private static final int MAX_FIRST_MEMBER = 20;
    private static final int MIN_COMMON_DIFFERENCE = 2;
    private static final int MAX_COMMON_DIFFERENCE = 9;
    private static final String BLIND_SYMBOL = "*";

    private static String calculate(List<Integer> numbers, int blindIndex) {
        final int blindMember = numbers.get(blindIndex);
        StringBuilder sb = new StringBuilder();

        for (var member : numbers) {
            if (numbers.indexOf(member) == blindIndex) {
                sb.append(BLIND_SYMBOL).append(" ");
            } else {
                sb.append(member).append(" ");
            }
        }

        return sb.toString();
    }

    public static List<String> generateParameters() {
        List<Integer> progression = getRandomList(
                MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH,
                MIN_FIRST_MEMBER, MAX_FIRST_MEMBER,
                MIN_COMMON_DIFFERENCE, MAX_COMMON_DIFFERENCE
        );
        int blindIndex = getRandomNumber(0, progression.size() - 1);
        List<String> gameParameters = new ArrayList<>(Arrays.asList("Question parameters", "Right answer"));

        String questionParameters = calculate(progression, blindIndex);
        gameParameters.set(0, questionParameters);

        String rightAnswer = progression.get(blindIndex) + "";
        gameParameters.set(1, rightAnswer);

        return gameParameters;
    }
}
