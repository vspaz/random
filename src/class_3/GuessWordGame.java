package class_3;

import java.io.InputStreamReader;

public class GuessWordGame extends GuessGame {
    private static String[] words = {
            "apple", "orange", "lemon",
            "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon",
            "leak", "kiwi", "mango",
            "mushroom", "nut", "olive",
            "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin",
            "potato"
    };

    String getCommonPrefix(String randomWord, String userWord) {
        StringBuilder commonPrefix = new StringBuilder();
        int randomLen = randomWord.length();
        int userLen = userWord.length();

        int minLen = randomLen < userLen ? randomLen : userLen;

        for (int i = 0; i < minLen; i++) {
            if (randomWord.charAt(i) == userWord.charAt(i))
                commonPrefix.append(userWord.charAt(i));
            else
                break;
        }
        return commonPrefix.toString();
    }

    @Override
    public void playGame() {
        String randomWord = words[getRandomNum(words.length - 1)];
        int count = 0;
        String userWord;
        while (true) {
            System.out.println("Please, input fruit or veggie\n");
            userWord = getUserInput(new InputStreamReader(System.in));
            if (userWord.equals(randomWord)) {
                System.out.println("Congrats!\nnumber of attempts: " + count);
                return;
            }
            System.out.println(getCommonPrefix(randomWord, userWord) + "#############");
            count++;
        }
    }
}
