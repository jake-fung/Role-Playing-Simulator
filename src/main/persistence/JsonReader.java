package persistence;

import model.Barbarian;
import model.Character;
import model.CharacterLog;
import model.Classes;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads CharacterLog from JSON data stored in file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads CharacterLog from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CharacterLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCharacterLog(jsonObject);
    }

    // EFFECTS: parses CharacterLog from JSON object and returns it
    public CharacterLog parseCharacterLog(JSONObject jsonObject) {
        CharacterLog cl = new CharacterLog();
        JSONArray jsonArray = jsonObject.getJSONArray("characters");
        for (Object json : jsonArray) {
            JSONObject nextCharacter = (JSONObject) json;
            addCharacterToCharacterLog(cl, nextCharacter);
        }
        return cl;
    }

    //MODIFIES: cl
    //EFFECTS: parses Character from JSON object and adds them to CharacterLog
    private void addCharacterToCharacterLog(CharacterLog cl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        boolean isMale = jsonObject.getBoolean("isMale");
        Classes classes = Classes.valueOf(jsonObject.getString("classes"));
        int experience = jsonObject.getInt("experience");
        int level = jsonObject.getInt("level");
        int health = jsonObject.getInt("health");
        int attackPower = jsonObject.getInt("attackPower");
        int defensePower = jsonObject.getInt("defensePower");
        Character character = new Barbarian();
        character.setName(name);
        character.setIsMale(isMale);
        character.setClasses(classes);
        character.setExperience(experience);
        character.setLevel(level);
        character.setHealth(health);
        character.setAttackPower(attackPower);
        character.setDefensePower(defensePower);
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
