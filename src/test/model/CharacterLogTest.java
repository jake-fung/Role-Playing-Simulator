package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CharacterLogTest {
    CharacterLog characterLog;
    Character alex;
    Character bob;
    Character charlie;
    CharacterLog characterLogFull;

    @BeforeEach
    public void setUp() {
        characterLog = new CharacterLog();
        alex = new Character(10, 10, 10);
        bob = new Character(20, 30, 40);
        charlie = new Character(50, 60, 10);
        characterLogFull = new CharacterLog();
        characterLogFull.addCharacter(alex);
        characterLogFull.addCharacter(bob);
        characterLogFull.addCharacter(charlie);
    }

    @Test
    public void testAddCharacterOneCharacter() {
        assertEquals(0, characterLog.getNumCharacters());
        characterLog.addCharacter(alex);
        assertEquals(1, characterLog.getNumCharacters());
    }

    @Test
    public void testAddCharacterMultipleCharacter() {
        assertEquals(0, characterLog.getNumCharacters());
        characterLog.addCharacter(alex);
        characterLog.addCharacter(bob);
        characterLog.addCharacter(charlie);
        assertEquals(3, characterLog.getNumCharacters());
    }

    @Test
    public void testRemoveCharacter() {
        assertEquals(alex, characterLogFull.getCharacter(0));
        assertEquals(3, characterLogFull.getNumCharacters());
        characterLogFull.removeCharacter(0);
        assertFalse(characterLogFull.getCharacter(0) == alex);
        assertEquals(2, characterLogFull.getNumCharacters());
    }

    @Test
    public void testRemoveMultipleCharacter() {
        assertEquals(alex, characterLogFull.getCharacter(0));
        assertEquals(3, characterLogFull.getNumCharacters());
        characterLogFull.removeCharacter(0);
        characterLogFull.removeCharacter(0);
        characterLogFull.removeCharacter(0);
        assertEquals(0, characterLogFull.getNumCharacters());
    }

    @Test
    public void testGetNumItemsEmptyList() {
        assertEquals(0, characterLog.getNumCharacters());
    }

    @Test
    public void testGetNumItemsFullList() {
        assertEquals(3, characterLogFull.getNumCharacters());
    }

    @Test
    public void testGetCharacter() {
        assertNull(characterLogFull.getCharacter(-1));
        assertEquals(alex, characterLogFull.getCharacter(0));
        assertEquals(bob, characterLogFull.getCharacter(1));
        assertEquals(charlie, characterLogFull.getCharacter(2));
    }
}