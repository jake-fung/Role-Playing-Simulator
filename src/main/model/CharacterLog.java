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

    public int getNumCharacters() {
        return characterLog.size();
    }

    public Character getCharacter(int i) {
        return characterLog.get(i);
    }

    public void displayCharactersName() {
        for (int i = 0; i < getNumCharacters(); i++) {
            System.out.println((i + 1) + ". " + getCharacter(i).getName());
        }
    }

}
