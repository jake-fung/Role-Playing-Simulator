package model;

public class Ranger extends Character {
    public Ranger(String name, boolean isMale) {
        super(name, isMale, 80, 30, 5);
    }

    @Override
    public void specialAbility() {
        System.out.println("Ranger's special ability: Aim Shot!");
    }
}
