package model;

public class Knight extends Character {
    public Knight(String name, boolean isMale) {
        super(name, isMale, 100, 20, 15);
    }

    @Override
    public void specialAbility() {
        System.out.println("Knight's special ability: Shield Bash!");
    }
}
