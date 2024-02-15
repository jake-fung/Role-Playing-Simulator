package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trainer {
    private List<String> wordList;
    private Random random = new Random();
    private FileReader fileReader;
    private String word;
    private int wordCount;

    public Trainer() {
        wordList = readWords();
        wordCount = 0;
    }

    public static List<String> readWords() {
        List<String> wordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/randomWords.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
        return wordList;
    }

    public String getRandomWord() {
        int index = random.nextInt(wordList.size());
        return wordList.get(index);
    }

    public void addWordCount() {
        wordCount++;
    }

    public int getWordCount() {
        return wordCount;
    }
}
