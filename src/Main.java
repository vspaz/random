import class_3.GuessNumGame;
import class_3.GuessWordGame;

public class Main {

    public static void main(String[] args) {
        GuessNumGame numGame = new GuessNumGame();
        numGame.playGame();

        GuessWordGame wordGame = new GuessWordGame();
        wordGame.playGame();
    }
}
