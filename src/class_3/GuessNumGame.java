package class_3;

import java.io.InputStreamReader;
import java.io.Reader;

public class GuessNumGame extends GuessGame {
    int toInt(String numericString) throws Exception {
        int num = Integer.parseInt(numericString);
        if (0 > num || num > 9)
            throw new Exception(String.format("%s is not in [0, 9] range.", num));
        return num;
    }

    boolean isWinner(int guessedNum, Reader in) {
        int userNum;
        for (int i = 0; i < 3; i++) {
            System.out.println("Please input your num [0, 9]\n");
            try {
                userNum = toInt(getUserInput(in));
            } catch (Exception e) {
                System.out.println(e.toString());
                break;
            }
            if (userNum == guessedNum) {
                return true;
            } else if (userNum > guessedNum) {
                System.out.println(userNum + " is greater");
            } else {
                System.out.println(userNum + " is smaller");
            }
        }
        return false;
    }

    boolean isExit(Reader reader) {
        String input = getUserInput(reader);
        int exitFlag = 1;
        try {
            exitFlag = toInt(input);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("Thank you for playing; exiting...");
        return exitFlag == 0;
    }

    @Override
    public void playGame() {
        String endGameMessage = "Sorry, you lost :-(";
        InputStreamReader in = new InputStreamReader(System.in);
        while (true) {
            int guessedNum = getRandomNum(9);
            if (isWinner(guessedNum, in))
                endGameMessage = "Congrats, you won!";
            System.out.println(endGameMessage + "\nPress 1 to play again; 0 to exit");
            if (isExit(in))
                return;
        }
    }
}
