package class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

abstract class GuessGame implements Guess {
    public int getRandomNum(int cap) {
        Random rand = new Random();
        return rand.nextInt(cap);
    }

    public String getUserInput(Reader input) {
        try {
            BufferedReader bufferedReader = new BufferedReader(input);
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(e.toString());
            return "";
        }
    }
}
