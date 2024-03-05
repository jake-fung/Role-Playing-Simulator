package persistence;

import model.Character;
import model.CharacterLog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CharacterLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCharacterLog(jsonObject);
    }

    public CharacterLog parseCharacterLog(JSONObject jsonObject) {
        CharacterLog cl = new CharacterLog();
        JSONArray jsonArray = jsonObject.getJSONArray("characters");
        for (Object json : jsonArray) {
            JSONObject nextCharacter = (JSONObject) json;
            addCharacterToCharacterLog(cl, nextCharacter);
        }
        return cl;
    }

    private void addCharacterToCharacterLog(CharacterLog cl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        boolean isMale = jsonObject.getBoolean("isMale");
        int experience = jsonObject.getInt("experience");
        int health = jsonObject.getInt("health");
        int attackPower = jsonObject.getInt("attackPower");
        int defensePower = jsonObject.getInt("defensePower");
        Character character = new Character(health, attackPower, defensePower);
        character.setName(name);
        character.setIsMale(isMale);
        character.setExperience(experience);
        cl.addCharacter(character);
    }

    // Method taken from JSONReader class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

}
