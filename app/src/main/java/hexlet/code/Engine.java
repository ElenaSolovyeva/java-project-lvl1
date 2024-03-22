package hexlet.code;

import hexlet.code.games.Prime;
import hexlet.code.util.Games;
import java.util.Scanner;
import static hexlet.code.util.Utils.POSITIVE_FEEDBACK;
import static hexlet.code.util.Utils.giveNegativeFeedback;
import static hexlet.code.util.Utils.greeting;
import static hexlet.code.util.Utils.selectGame;

public class Engine {
    public static final int MAX_ROUNDS_COUNT = 3;

    public static void play() {
        final int gameNumber = selectGame(); // GAME_NUMBER isn't accept by linter
        if (gameNumber == 0) {
            return;
        }
        final String userName = greeting();
        int counter = 0;
        System.out.println(Games.getRules(gameNumber));
        while (counter < MAX_ROUNDS_COUNT) {
            String questionParameters;
            String rightAnswer = "";
            String userAnswer;

            switch (gameNumber) {
                case 6:
                    questionParameters = Prime.generateQuestionParameters();
                    rightAnswer = Prime.giveRightAnswer(questionParameters);
                    break;
                default:
                    questionParameters = "Question parameters are not defined";
            }

            System.out.println("Question: " + questionParameters);
            System.out.print("Your answer: ");
            Scanner sc = new Scanner(System.in);
            userAnswer = sc.next();

            if (userAnswer.equals(rightAnswer)) {
                System.out.println(POSITIVE_FEEDBACK);
                counter += 1;
            } else {
                System.out.println(giveNegativeFeedback(userAnswer, rightAnswer, userName));
                return;
            }
        }

        System.out.println("Gratulations, " + userName + "!");
    }
}
