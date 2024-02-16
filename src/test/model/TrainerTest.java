package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    private Trainer trainer;

    @BeforeEach
    public void setUp() {
        trainer = new Trainer();
    }

    @Test
    public void testConstructor() {
        assertEquals(0,trainer.getWordCount());
    }

    @Test
    public void testGetRandomWord() {
        List<String> wordList = Trainer.readWords();
        String randomWord = trainer.getRandomWord();
        assertTrue(wordList.contains(randomWord));
    }

    @Test
    public void testAddWordCount() {
        int initialCount = trainer.getWordCount();
        trainer.addWordCount();
        assertEquals(initialCount + 1, trainer.getWordCount());
    }

    @Test
    public void testGetWordCount() {
        int initialCount = trainer.getWordCount();
        assertEquals(initialCount, trainer.getWordCount());
    }
}