package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            CharacterLog cl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCharacterLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCharacterLog.json");
        try {
            CharacterLog cl = reader.read();
            assertEquals(0, cl.getNumCharacters());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCharacterLog.json");
        try {
            CharacterLog cl = reader.read();
            assertEquals(3, cl.getNumCharacters());
            assertCharacter(cl.getCharacter(0), "jake", true, 19, 100, 20, 15);
            assertCharacter(cl.getCharacter(1), "Alex", true, 30, 80, 30, 5);
            assertCharacter(cl.getCharacter(2), "roger", false, 0, 80, 30, 5);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
