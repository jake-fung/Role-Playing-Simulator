package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a character.
public class Character implements Writable {
    protected String name;
    protected boolean isMale;
    protected Classes classes;
    protected int experience;
    protected int level;
    protected int health;
    protected int attackPower;
    protected int defensePower;

    // EFFECTS: Constructs a new Character object with an empty name, false isMale (to be set later) and 0 experience
    // points, health, attackPower and defensePower are set by separate classes.
    public Character() {
        this.name = "";
        this.isMale = false;
        this.experience = 0;
        this.level = 1;
    }

    // REQUIRES: amount >= 0
    // MODIFIES: this
    // EFFECTS: Add amount into experience points.
    public void gainExperience(int amount) {
        setExperience(getExperience() + amount);
    }

    // MODIFIES: this
    // EFFECTS: If experience points is less than 20, return false. Else, level up until experience points is below 20.
    public boolean levelUp() {
        if (this.experience < 20) {
            return false;
        } else {
            do {
                this.experience = this.experience - 20;
                this.level++;
                this.health = this.health + 20;
                this.attackPower = this.attackPower + 5;
                this.defensePower = this.defensePower + 5;
            } while (experience >= 20);
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        EventLog.getInstance().logEvent(new Event("Character " + name
                + " the " + classes + " has been selected and statistics has been retrieved."));
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    // EFFECTS: returns a Character as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("isMale", isMale);
        json.put("classes", classes);
        json.put("experience", experience);
        json.put("level", level);
        json.put("health", health);
        json.put("attackPower", attackPower);
        json.put("defensePower", defensePower);
        return json;
    }
}
