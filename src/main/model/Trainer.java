package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Represents a trainer game.
public class Trainer {
    private List<String> wordList;
    private Random random = new Random();
    private FileReader fileReader;
    private String word;
    private int wordCount;

    public Trainer(String path) {
        wordCount = 0;
        wordList = readWords(path);
    }

    // EFFECTS: Reads lines of text from the "src/randomWords.txt" file and returns a 'List' containing those lines as
    // 'String' objects. If the file is not accessible or does not exist, prints an error message and
    // returns an empty 'List'.
    public static List<String> readWords(String path) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
        return wordList;
    }

    // EFFECTS: Returns a randomly selected String from the wordList.
    public String getRandomWord() {
        int index = random.nextInt(wordList.size());
        return wordList.get(index);
    }

    // MODIFIES: this
    // EFFECTS: Increases the wordCount by 1
    public void addWordCount() {
        wordCount++;
    }

    // EFFECTS: Returns the current value of wordCount.
    public int getWordCount() {
        return wordCount;
    }
}
