package model;

import java.util.ArrayList;

public class CharacterLog {
    ArrayList<Character> characterLog;

    public CharacterLog() {
        characterLog = new ArrayList<>();
    }

    public void addCharacter(Character c) {
        characterLog.add(c);
    }

    public void removeCharacter(int i) {
        characterLog.remove(i);
    }

    public int getNumCharacters() {
        return characterLog.size();
    }

    public Character getCharacter(int i) {
        return characterLog.get(i);
    }

}
