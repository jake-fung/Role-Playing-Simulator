package model;

// Represents the 'Knight' class of the character
public class Knight extends Character {

    // EFFECTS: set up a new Knight with 100 health, 20 attack power, and 15 defense power and class Knight.
    public Knight() {
        super();
        this.health = 100;
        this.attackPower = 20;
        this.defensePower = 15;
        this.classes = Classes.Knight;
    }

    // EFFECTS: Method to attain special abilities at level 10
    public void attainLevel10Abilities() {
        System.out.println("You have attained Shield Bash!");
    }

    // EFFECTS: Method to attain special abilities at level 20
    public void attainLevel20Abilities() {
        System.out.println("You have attained Shield Bash and Guardian's Aura!");
    }

    // EFFECTS: Method to attain special abilities at level 30
    public void attainLevel30Abilities() {
        System.out.println("You have attained Shield Bash, Guardian's Aura and Sword of Justice!");
    }
}
