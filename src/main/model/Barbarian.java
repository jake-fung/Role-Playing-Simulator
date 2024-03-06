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

    // EFFECTS: Method to attain special abilities at level 10
    public void attainLevel10Abilities() {
        System.out.println("You have attained Frenzy!");
    }

    // EFFECTS: Method to attain special abilities at level 20
    public void attainLevel20Abilities() {
        System.out.println("You have attained Frenzy and Rampage!");
    }

    // EFFECTS: Method to attain special abilities at level 30
    public void attainLevel30Abilities() {
        System.out.println("You have attained Frenzy, Rampage and Earth Shaker!");
    }
}