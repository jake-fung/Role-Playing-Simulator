package model;

// Represents the 'Ranger' class of the character
public class Ranger extends Character {

    // EFFECTS: set up a new Ranger with 80 health, 30 attack power, and 5 defense power.
    public Ranger() {
        super();
        this.health = 80;
        this.attackPower = 30;
        this.defensePower = 5;
        this.classes = Classes.Ranger;
    }
}
