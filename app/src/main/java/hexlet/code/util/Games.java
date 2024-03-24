package hexlet.code.util;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class Games {
    static Game greet = new Game(1, "Greet", "");
    static Game even = new Game(Even.ID, Even.TITEL, Even.RULES);
    static Game calc = new Game(Calc.ID, Calc.TITEL, Calc.RULES);
    static Game gcd = new Game(GCD.ID, GCD.TITEL, GCD.RULES);
    static Game progression = new Game(Progression.ID, Progression.TITEL, Progression.RULES);
    static Game prime = new Game(Prime.ID, Prime.TITEL, Prime.RULES);
    static Game exit = new Game(0, "Exit", "");

    public static Game[] games = {greet, even, calc, gcd, progression, prime, exit};

    public static String getTitle(int gameNumber) {
        for (var game : games) {
            if (game.id == gameNumber) {
                return game.title;
            }
        }
        return "Error: game title is not found";
    }
    public static String getRules(int gameNumber) {
        for (var game : games) {
            if (game.id == gameNumber) {
                return game.rules;
            }
        }
        return "Error: rules are not found";
    }
}
