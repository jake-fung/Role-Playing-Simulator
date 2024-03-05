package model;

// Represents a character log for character storage.
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class CharacterLog implements Writable {
    ArrayList<Character> characterLog;

    // EFFECTS: Constructs a new CharacterLog object with an empty list.
    public CharacterLog() {
        characterLog = new ArrayList<>();
    }

    // REQUIRES: c is not null.
    // MODIFIES: this
    // EFFECTS: Adds the specified Character object to the end of the characterLog list.
    public void addCharacter(Character c) {
        characterLog.add(c);
    }

    // REQUIRES: i >= 0.
    // MODIFIES: this
    // EFFECTS: Removes the Character object at the specified index i from the characterLog.
    public void removeCharacter(int i) {
        characterLog.remove(i);
    }

    // REQUIRES: characterLog is not null
    // EFFECTS: Returns the number of Character objects currently stored in the characterLog list.
    public int getNumCharacters() {
        return characterLog.size();
    }

    // EFFECTS: Returns the Character object at the specified index i from the characterLog list. If the index is out of
    // bounds, returns null.
    public Character getCharacter(int i) {
        try {
            if (i >= 0) {
                return characterLog.get(i);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    // EFFECTS: returns a CharacterLog as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("characters", characterstoJson());
        return json;
    }

    // EFFECTS: returns Character in this CharacterLog as a JSON array
    private JSONArray characterstoJson() {
        JSONArray jsonArray = new JSONArray();

        for (Character character : characterLog) {
            jsonArray.put(character.toJson());
        }
        return jsonArray;
    }
}
