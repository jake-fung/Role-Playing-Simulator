package ui.swing.simulator;

import model.Character;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// Represents a character builder running on swing.
public class CharacterBuilder {
    private static final String JSON_STORE = "./data/characterlog.json";
    private final JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private final JsonReader jsonReader = new JsonReader(JSON_STORE);
    private CharacterLog characterLog;

    // EFFECTS: initiates all simulators and runs the character builder application.
    public CharacterBuilder() {
        characterLog = new CharacterLog();
    }

    // MODIFIES: this
    // EFFECTS: create a new character based on name, isMale and classes.
    public void createCharacter(String name, boolean isMale, Classes classes) {
        Character character;
        if (classes == Classes.Barbarian) {
            character = new Barbarian();
        } else if (classes == Classes.Knight) {
            character = new Knight();
        } else {
            character = new Ranger();
        }
        character.setName(name);
        character.setIsMale(isMale);
        characterLog.addCharacter(character);
    }

    // EFFECTS: return the number of characters in Characterlog.
    public int getNumCharacters() {
        return characterLog.getNumCharacters();
    }

    // EFFECTS: return the character corresponding to the position of Characterlog.
    public Character getCharacter(int index) {
        return characterLog.getCharacter(index);
    }

    // EFFECTS: return an array list of all the characters in Characterlog.
    public ArrayList<Character> getCharacters() {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < characterLog.getNumCharacters(); i++) {
            characters.add(characterLog.getCharacter(i));
        }
        return characters;
    }

    // MODIFIES: this
    // EFFECTS: remove the character corresponding to the position in the Characterlog.
    public void removeResident(int index) {
        characterLog.removeCharacter(index);
    }

    // EFFECTS: write contents into a JSON file.
    public void saveCharacters() throws FileNotFoundException {
        jsonWriter.open();
        jsonWriter.write(characterLog);
        jsonWriter.close();
    }

    // EFFECTS: read contents from a JSON file.
    public void loadCharacters() throws IOException, RuntimeException {
        characterLog = jsonReader.read();
        if (characterLog.getNumCharacters() == 0) {
            throw new RuntimeException();
        }
    }
}
