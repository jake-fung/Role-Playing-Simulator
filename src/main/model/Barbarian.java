package model;

public class Barbarian extends Character {
    public Barbarian(String name, boolean isMale) {
        super(name, isMale, 120, 25, 10);
    }

    @Override
    public void specialAbility() {
        System.out.println("Barbarian's special ability: Rage!");
    }
}
