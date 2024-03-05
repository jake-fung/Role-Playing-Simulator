package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            CharacterLog cl = new CharacterLog();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            CharacterLog cl = new CharacterLog();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            cl = reader.read();
            assertEquals(0, cl.getNumCharacters());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            CharacterLog cl = new CharacterLog();
            Character c0 = new Character(100, 20, 15);
            Character c1 = new Character(80, 30, 5);
            Character c2 = new Character(80, 30, 5);
            c0.setName("jake");
            c0.setIsMale(true);
            c0.setExperience(19);
            c1.setName("Alex");
            c1.setIsMale(true);
            c1.setExperience(30);
            c2.setName("roger");
            c2.setIsMale(false);
            c2.setExperience(0);
            cl.addCharacter(c0);
            cl.addCharacter(c1);
            cl.addCharacter(c2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(cl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            cl = reader.read();
            assertEquals(3, cl.getNumCharacters());
            assertCharacter(cl.getCharacter(0), "jake", true, 19, 100, 20, 15);
            assertCharacter(cl.getCharacter(1), "Alex", true, 30, 80, 30, 5);
            assertCharacter(cl.getCharacter(2), "roger", false, 0, 80, 30, 5);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
