package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    private Trainer trainer;
    private List<String> wordList;
    private Trainer FileReader;

    @BeforeEach
    void setUp() {
        trainer = new Trainer("src/randomWords.txt");
        wordList = Trainer.readWords("src/randomWords.txt");
    }

    @Test
    void testConstructor() {
        assertEquals(0,trainer.getWordCount());
    }

    @Test
    void testGetRandomWord() {
        String randomWord = trainer.getRandomWord();
        assertTrue(wordList.contains(randomWord));
    }

    @Test
    void testAddWordCount() {
        int initialCount = trainer.getWordCount();
        trainer.addWordCount();
        assertEquals(initialCount + 1, trainer.getWordCount());
    }

    @Test
    void testGetWordCount() {
        int initialCount = trainer.getWordCount();
        assertEquals(initialCount, trainer.getWordCount());
    }

    // Helper method to create a temporary file with specified content
    private File createTempFileWithContent(String content) throws IOException {
        File file = File.createTempFile("tempFile", ".txt");
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
        return file;
    }

    @Test
    void testReadWordsFileExistsAndReadable() {
        try {
            String content = "word1\nword2\nword3";
            File tempFile = createTempFileWithContent(content);

            List<String> wordList = FileReader.readWords(tempFile.getAbsolutePath());

            assertEquals(3, wordList.size());
            assertEquals("word1", wordList.get(0));
            assertEquals("word2", wordList.get(1));
            assertEquals("word3", wordList.get(2));

            tempFile.delete(); // Clean up temporary file
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testReadWordsFileDoesNotExist() {
        List<String> wordList = FileReader.readWords("nonexistent_file.txt");

        assertTrue(wordList.isEmpty());
    }

    @Test
    void testReadWordsFileExistsButNotReadable() {
        try {
            // Create a directory instead of a file, which can't be read
            File tempDir = File.createTempFile("tempDir", "");
            tempDir.delete();
            tempDir.mkdir();

            List<String> wordList = FileReader.readWords(tempDir.getAbsolutePath());

            assertTrue(wordList.isEmpty());
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}