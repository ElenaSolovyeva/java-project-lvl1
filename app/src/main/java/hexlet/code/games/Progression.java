package hexlet.code.games;

import hexlet.code.util.Parameters;

import java.util.ArrayList;
import java.util.List;
import static hexlet.code.util.Utils.getRandomNumber;

public class Progression {
    public static final int ID = 5;
    public static final String TITLE = "Progression";
    public static final String RULES = "What number is missing in the progression?";

    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MIN_FIRST_MEMBER = 1;
    private static final int MAX_FIRST_MEMBER = 20;
    private static final int MIN_COMMON_DIFFERENCE = 2;
    private static final int MAX_COMMON_DIFFERENCE = 9;
    private static final String BLIND_SYMBOL = "*";

    private static List<Integer> getRandomProgression() {
        int progressionLength = getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int firstMember = getRandomNumber(MIN_FIRST_MEMBER, MAX_FIRST_MEMBER);
        int commonDifference = getRandomNumber(MIN_COMMON_DIFFERENCE, MAX_COMMON_DIFFERENCE);
        final List<Integer> result = new ArrayList<>();

        for (int i = 1; i < progressionLength + 1; i++) {
            result.add(firstMember + i * commonDifference);
        }

        return result;
    }

    private static String getProgressionWithBlindMember(List<Integer> numbers, int blindIndex) {
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

    public static Parameters generateParameters() {
        Parameters param = new Parameters();
        List<Integer> progression = getRandomProgression();
        final int blindIndex = getRandomNumber(0, progression.size() - 1);

        param.setQuestionParameters(getProgressionWithBlindMember(progression, blindIndex));
        param.setRightAnswer(progression.get(blindIndex) + "");
        return param;
    }
}
