import class_3.GuessNumGame;
import class_3.GuessWordGame;
import class_3.InfixCalculator;

public class Main {

    public static void main(String[] args) {
        GuessNumGame numGame = new GuessNumGame();
        numGame.playGame();

        GuessWordGame wordGame = new GuessWordGame();
        wordGame.playGame();

        InfixCalculator calc = new InfixCalculator();
        System.out.println(calc.getRet ("( 2 + ( 10 ** 2 ) )"));
    }
}
