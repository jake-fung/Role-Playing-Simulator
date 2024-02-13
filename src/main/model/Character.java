package model;

public abstract class Character {
    protected String name;
    protected boolean isMale;
    protected int health;
    protected int attackPower;
    protected int defensePower;

    public Character(String name, boolean isMale, int health, int attackPower, int defensePower) {
        this.name = name;
        this.isMale = isMale;
        this.health = health;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public abstract void specialAbility();

    // Getters and Setters
    public String getName() {
        return name;
    }

    public boolean getIsMale() {
        return isMale;
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
