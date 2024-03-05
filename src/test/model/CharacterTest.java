package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character john = new Character(10, 10, 10);

    @Test
    void testConstructor() {
        Character alex = new Character(10, 20, 30);
        assertEquals(10, alex.getHealth());
        assertEquals(20, alex.getAttackPower());
        assertEquals(30, alex.getDefensePower());
    }

    @Test
    void testGainExperience() {
        Character bob = new Character(20, 30, 40);
        assertEquals(0, bob.getExperience());
        bob.gainExperience(10);
        assertEquals(10, bob.getExperience());
    }

    @Test
    void testLevelUpNotEnoughExperience() {
        Character charlie = new Character(0, 0, 0);
        assertEquals(0, charlie.getExperience());
        assertFalse(charlie.levelUp());
        assertEquals(1, charlie.getLevel());
    }

    @Test
    void testLevelUpEnoughExperience() {
        Character david = new Character(0, 0, 0);
        david.setExperience(20);
        assertEquals(20, david.getExperience());
        assertTrue(david.levelUp());
        assertEquals(2, david.getLevel());
        assertEquals(20, david.getHealth());
        assertEquals(5, david.getAttackPower());
        assertEquals(5, david.getDefensePower());
    }

    @Test
    void testLevelUpEnoughExperienceMultipleLevels() {
        Character eva = new Character(0, 0, 0);
        eva.setExperience(200);
        assertEquals(200, eva.getExperience());
        assertTrue(eva.levelUp());
        assertEquals(10, eva.getLevel());
        assertEquals(180, eva.getHealth());
        assertEquals(45, eva.getAttackPower());
        assertEquals(45, eva.getDefensePower());
    }

    @Test
    void testSetAndGetName() {
        john.setName("Jane");
        String name = john.getName();
        assertEquals("Jane", name);
    }

    @Test
    void testSetAndGetIsMale() {
        john.setIsMale(false);
        boolean isMale = john.getIsMale();
        assertFalse(isMale);
    }

    @Test
    void testSetAndGetExperience() {
        assertEquals(0, john.getExperience());
        john.setExperience(100);
        int exp = john.getExperience();
        assertEquals(100, exp);
    }

    @Test
    void testSetAndGetLevel() {
        assertEquals(1, john.getLevel());
        john.setLevel(10);
        int level = john.getLevel();
        assertEquals(10, level);
    }

    @Test
    void testSetAndGetHealth() {
        assertEquals(10, john.getHealth());
        john.setHealth(100);
        int health = john.getHealth();
        assertEquals(100, health);
    }

    @Test
    void testSetAndGetAttackPower() {
        assertEquals(10, john.getAttackPower());
        john.setAttackPower(20);
        int attack = john.getAttackPower();
        assertEquals(20, attack);
    }

    @Test
    void testSetAndGetDefensePower() {
        assertEquals(10, john.getDefensePower());
        john.setDefensePower(30);
        int defense = john.getDefensePower();
        assertEquals(30, defense);
    }

}