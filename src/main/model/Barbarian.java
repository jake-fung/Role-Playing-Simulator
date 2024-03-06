package model;

// Represents the 'Barbarian' class of the character
public class Barbarian extends Character {

    // EFFECTS: set up a new Barbarian with 120 health, 25 attack power, and 10 defense power and class Barbarian.
    public Barbarian() {
        super();
        this.health = 120;
        this.attackPower = 25;
        this.defensePower = 10;
        this.classes = Classes.Barbarian;
    }
}