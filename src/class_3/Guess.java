package class_3;

import java.io.Reader;

public interface Guess {
    int getRandomNum(int cap);

    String getUserInput(Reader input);

    void playGame();
}
