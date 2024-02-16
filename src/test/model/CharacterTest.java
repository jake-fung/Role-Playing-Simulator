package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character john = new Character(10, 10, 10);

    @Test
    public void testConstructor() {
        Character alex = new Character(10, 20, 30);
        assertEquals(10, alex.getHealth());
        assertEquals(20, alex.getAttackPower());
        assertEquals(30, alex.getDefensePower());
    }

    @Test
    void gainExperience() {
        Character bob = new Character(20, 30, 40);
        assertEquals(0, bob.getExperience());
        bob.gainExperience(10);
        assertEquals(10, bob.getExperience());
    }

    @Test
    public void testSetAndGetName() {
        john.setName("Jane");
        String name = john.getName();
        assertEquals("Jane", name);
    }

    @Test
    public void testSetAndGetIsMale() {
        john.setIsMale(false);
        boolean isMale = john.getIsMale();
        assertFalse(isMale);
    }

    @Test
    public void testSetAndGetExperience() {
        assertEquals(0, john.getExperience());
        john.setExperience(100);
        int exp = john.getExperience();
        assertEquals(100, exp);
    }

    @Test
    public void testSetAndGetHealth() {
        assertEquals(10, john.getHealth());
        john.setHealth(100);
        int health = john.getHealth();
        assertEquals(100, health);
    }

    @Test
    public void testSetAndGetAttackPower() {
        assertEquals(10, john.getAttackPower());
        john.setAttackPower(20);
        int attack = john.getAttackPower();
        assertEquals(20, attack);
    }

    @Test
    public void testSetAndGetDefensePower() {
        assertEquals(10, john.getDefensePower());
        john.setDefensePower(30);
        int defense = john.getDefensePower();
        assertEquals(30, defense);
    }

}