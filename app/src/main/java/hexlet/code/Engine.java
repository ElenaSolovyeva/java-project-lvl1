package hexlet.code;

import static hexlet.code.App.greeting;
import static hexlet.code.App.selectGame;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.*;

public class Engine {
    public static final int MAX_ROUNDS_COUNT = 3;

    public static void play() throws InputMismatchException {
        int counter = 0;
        int gameNumber;
        String userName;

        try {
            gameNumber = selectGame();
        } catch (InputMismatchException e) {
            System.out.println("You should give a game number. Please try again.");
            return;
        }

        if (gameNumber == 0) {
            return;
        }

        userName = greeting();

        while (counter < MAX_ROUNDS_COUNT) {
            String gameRules;
            String usersAnswer;
            List<String> gameParameters = new ArrayList<>(Arrays.asList("Question parameters", "Right answer"));

            switch (gameNumber) {
                case 1:
                    return;
                case 2:
                    gameRules = Even.RULES;
                    gameParameters = Even.generateParameters();
                    break;
                case 3:
                    gameRules = Calc.RULES;
                    gameParameters = Calc.generateParameters();
                    break;
                case 4:
                    gameRules = GCD.RULES;
                    gameParameters = GCD.generateParameters();
                    break;
                case 5:
                    gameRules = Progression.RULES;
                    gameParameters = Progression.generateParameters();
                    break;
                case 6:
                    gameRules = Prime.RULES;
                    gameParameters = Prime.generateParameters();
                    break;
                default:
                    return;
            }

            if (counter == 0) {
                System.out.println(gameRules);
            }

            System.out.println("Question: " + gameParameters.getFirst());
            Scanner scanner = new Scanner(System.in);
            usersAnswer = scanner.next().toLowerCase();

            if (usersAnswer.equals(gameParameters.getLast())) {
                System.out.println("Correct!");
                counter += 1;
            } else {
                System.out.println("'" + usersAnswer + "'" + " is a wrong answer ;(. "
                        + "Correct answer was " + "'" + gameParameters.getLast() + "'. \n"
                        + "Let's try again, " + userName + "!"
                );
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
