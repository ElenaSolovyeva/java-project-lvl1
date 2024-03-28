package hexlet.code.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String POSITIVE_ANSWER = "yes";
    public static final String NEGATIVE_ANSWER = "no";

    public static boolean isPrime(int number) {
        boolean result = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int getRandomNumber(int low, int high) {
        while (true) {
            int randomNumber = (int) (Math.random()  * high);
            if (randomNumber >= low && randomNumber <= high) {
                return randomNumber;
            }
        }
    }

    public static List<Integer> getRandomList(int minProgressionLength, int maxProgressionLength,
                                              int minFirstMember, int maxFirstMember,
                                              int minCommonDifference, int maxCommonDifference) {
        List<Integer> result = new ArrayList<>();
        int progressionLength = getRandomNumber(minProgressionLength, maxProgressionLength);
        int firstMember = getRandomNumber(minFirstMember, maxFirstMember);
        int commonDifference = getRandomNumber(minCommonDifference, maxCommonDifference);

        for (int i = 1; i < progressionLength + 1; i++) {
            result.add(firstMember + i * commonDifference);
        }

        return result;
    }
}
