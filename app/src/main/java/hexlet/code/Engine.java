package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import hexlet.code.util.Games;
import hexlet.code.util.Parameters;

import java.util.InputMismatchException;
import java.util.Scanner;
import static hexlet.code.util.Utils.POSITIVE_FEEDBACK;
import static hexlet.code.util.Utils.giveNegativeFeedback;
import static hexlet.code.util.Utils.greeting;
import static hexlet.code.util.Utils.selectGame;
import static hexlet.code.util.Games.getTitle;

public class Engine {
    public static final int MAX_ROUNDS_COUNT = 3;

    public static void play() {
        int gameNumber = 0;
        try {
            gameNumber = selectGame(); // final int GAME_NUMBER = selectGame();  isn't accept by linter
        } catch (InputMismatchException e) {
            System.out.println("You should give a game number. Please try again.");
            return;
        }

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

            switch (getTitle(gameNumber)) {
                case "Calc":
                    questionParameters = Calc.generateQuestionParameters();
                    rightAnswer = Calc.giveRightAnswer(questionParameters);
                    break;
                case "Even":
                    questionParameters = Even.generateQuestionParameters();
                    rightAnswer = Even.giveRightAnswer(questionParameters);
                    break;
                case "GCD":
                    questionParameters = GCD.generateQuestionParameters();
                    rightAnswer = GCD.giveRightAnswer(questionParameters);
                    break;
                case "Prime":
                    questionParameters = Prime.generateQuestionParameters();
                    rightAnswer = Prime.giveRightAnswer(questionParameters);
                    break;
                case "Progression":
                    Parameters param = Progression.generateParameters();
                    questionParameters = param.getQuestionParameters();
                    rightAnswer = param.getRightAnswer();
                    break;
                default:
                    questionParameters = "Question parameters are not defined";
            }

            System.out.println("Question: " + questionParameters);
            System.out.print("Your answer: ");
            Scanner sc = new Scanner(System.in);
            userAnswer = sc.next().toLowerCase();

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
