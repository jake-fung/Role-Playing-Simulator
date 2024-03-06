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
}
