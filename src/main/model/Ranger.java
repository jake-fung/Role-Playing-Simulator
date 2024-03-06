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

    // EFFECTS: Method to attain special abilities at level 10
    public void attainLevel10Abilities() {
        System.out.println("You have attained Precision Shot!");
    }

    // EFFECTS: Method to attain special abilities at level 20
    public void attainLevel20Abilities() {
        System.out.println("You have attained Precision Shot and Explosive Arrow!");
    }

    // EFFECTS: Method to attain special abilities at level 30
    public void attainLevel30Abilities() {
        System.out.println("You have attained Precision Shot, Explosive Arrow and Camouflage Mastery!");
    }
}
