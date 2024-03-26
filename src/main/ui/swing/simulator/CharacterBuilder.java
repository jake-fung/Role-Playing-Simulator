package ui.swing.simulator;

import model.Character;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CharacterBuilder {
    private static final String JSON_STORE = "./data/characterlog.json";
    private CharacterLog cl;


    public CharacterBuilder() {
        cl = new CharacterLog();
    }

    public int getNumCharacters() {
        return cl.getNumCharacters();
    }

    public void saveCharacters() throws FileNotFoundException {
        JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
        jsonWriter.open();
        jsonWriter.write(cl);
        jsonWriter.close();
    }

    public void loadCharacters() throws IOException, RuntimeException {
        JsonReader jsonReader = new JsonReader(JSON_STORE);
        cl = jsonReader.read();
        if (cl.getNumCharacters() == 0) {
            throw new RuntimeException();
        }
    }

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
        cl.addCharacter(character);
    }

    public ArrayList<Character> getCharacters() {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < cl.getNumCharacters(); i++) {
            characters.add(cl.getCharacter(i));
        }
        return characters;
    }

    public Character getCharacter(int index) {
        return cl.getCharacter(index);
    }

    public void removeResident(int index) {
        cl.removeCharacter(index);
    }
}
