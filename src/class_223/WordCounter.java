package class_223;

import java.util.*;

public class WordCounter {
    private String[] words;
    private HashMap<String, Integer> wordToCount = new HashMap<>();

    public WordCounter(String[] words) {
        this.words = words;
    }

    private void getWordToCount() {
        for (String word : words) {
            if (wordToCount.containsKey(word)) {
                wordToCount.put(word, wordToCount.get(word) + 1);
            } else {
                wordToCount.put(word, 1);
            }
        }
    }

    private void processArray() {
        if (wordToCount.isEmpty()) {
            getWordToCount();
        }
    }

    private void printSep() {
        System.out.println("==========================================================================================");
    }

    void printCount() {
        processArray();
        System.out.println(String.format("%-5s  %s", "word", "count"));
        for (Map.Entry<String, Integer> wordCountPair : wordToCount.entrySet()) {
            System.out.println(String.format("%-6s => %d", wordCountPair.getKey(), wordCountPair.getValue()));
        }
        printSep();
    }

    void printUniq() {
        processArray();
        System.out.println(String.format("Array has %d unique elements out of %d", wordToCount.size(), words.length));
        for (Map.Entry<String, Integer> wordCountPair : wordToCount.entrySet()) {
            System.out.println(wordCountPair.getKey());
        }
        printSep();
    }
}
