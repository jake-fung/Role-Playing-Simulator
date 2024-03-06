package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
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
            Character c0 = new Barbarian();
            Character c1 = new Knight();
            Character c2 = new Ranger();
            c0.setName("Jake");
            c0.setIsMale(true);
            c0.setExperience(3);
            c0.setLevel(10);
            c1.setName("Abelle");
            c1.setIsMale(false);
            c1.setExperience(0);
            c1.setLevel(6);
            c2.setName("Tyler");
            c2.setIsMale(true);
            c2.setExperience(20);
            c2.setLevel(7);
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
            assertCharacter(cl.getCharacter(0), "Jake", true, Classes.Barbarian, 3, 10, 120, 25, 10);
            assertCharacter(cl.getCharacter(1), "Abelle", false, Classes.Knight, 0, 6, 100, 20, 15);
            assertCharacter(cl.getCharacter(2), "Tyler", true, Classes.Ranger, 20, 7, 80, 30, 5);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
