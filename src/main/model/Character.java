package model;

// Represents a character.
public class Character {
    protected String name;
    protected boolean isMale;
    protected int experience;
    protected int health;
    protected int attackPower;
    protected int defensePower;

    // EFFECTS: Constructs a new Character object with an empty name, false isMale (to be set later) and 0 experience
    // points, health, attackPower and defensePower are set by separate classes.
    public Character(int health, int attackPower, int defensePower) {
        this.name = "";
        this.isMale = false;
        this.experience = 0;
        this.health = health;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    // REQUIRES: amount >= 0
    // MODIFIES: this
    // EFFECTS: Add amount into experience points.
    public void gainExperience(int amount) {
        setExperience(getExperience() + amount);
    }

    public String getName() {
        return name;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }
}
