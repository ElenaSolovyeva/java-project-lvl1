package hexlet.code.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static hexlet.code.util.Utils.getRandomNumber;

public class Progression {
    public static final int ID = 5;
    public static final String TITEL = "Progression";
    public static final String RULES = "What number is missing in the progression?";

    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MIN_FIRST_MEMBER = 1;
    private static final int MAX_FIRST_MEMBER = 20;
    private static final int MIN_COMMON_DIFFERENCE = 2;
    private static final int MAX_COMMON_DIFFERENCE = 9;
    private static final String BLIND_SYMBOL = "*";

    /*private static int getRandomNumberBetweenValues(int low, int high) {
        while (true) {
            int randomNumber = (int) (Math.random()  * high);
            if (randomNumber >= low && randomNumber <= high) {
                return randomNumber;
            }
        }
    }*/

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

    private static List<String> getProgression() {
        List<Integer> numbers = getRandomProgression();
        final int blindIndex = getRandomNumber(0, numbers.size() - 1);
        final int blindMember = numbers.get(blindIndex);
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>(2);

        for (var member : numbers) {
            if (numbers.indexOf(member) == blindIndex) {
                sb.append(BLIND_SYMBOL).append(" ");
            } else {
                sb.append(member).append(" ");
            }
        }

        result.add(sb.toString().trim());
        result.add(blindMember + "");

        return result;
    }

    public static void playProgression(String userName, int maxRoundsCount) {
        int counter = 0;
        System.out.println(RULES);

        while (counter < maxRoundsCount) {
            List<String> progression = getProgression();
            final String progressionString = progression.getFirst();
            final String blindMember = progression.getLast();
            System.out.println("Question: " + progressionString);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(blindMember)) {
                System.out.println("\nCorrect!");
                counter += 1;
            } else {
                System.out.println("'" + userAnswer + "'" + " is a wrong answer ;(. Correct answer was "
                        + "'" + blindMember + "'");
                System.out.println("Let's try again, " + userName);
                return;
            }
        }
    }
}
