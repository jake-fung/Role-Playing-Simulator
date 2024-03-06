package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character john = new Barbarian();

    @Test
    void testGainExperience() {
        Character bob = new Barbarian();
        assertEquals(0, bob.getExperience());
        bob.gainExperience(10);
        assertEquals(10, bob.getExperience());
    }

    @Test
    void testLevelUpNotEnoughExperience() {
        Character charlie = new Ranger();
        assertEquals(0, charlie.getExperience());
        assertFalse(charlie.levelUp());
        assertEquals(1, charlie.getLevel());
    }

    @Test
    void testLevelUpEnoughExperience() {
        Character david = new Knight();
        david.setExperience(20);
        assertEquals(20, david.getExperience());
        assertTrue(david.levelUp());
        assertEquals(2, david.getLevel());
        assertEquals(120, david.getHealth());
        assertEquals(25, david.getAttackPower());
        assertEquals(20, david.getDefensePower());
    }

    @Test
    void testLevelUpEnoughExperienceMultipleLevels() {
        Character eva = new Barbarian();
        eva.setExperience(200);
        assertEquals(200, eva.getExperience());
        assertTrue(eva.levelUp());
        assertEquals(10, eva.getLevel());
        assertEquals(300, eva.getHealth());
        assertEquals(70, eva.getAttackPower());
        assertEquals(55, eva.getDefensePower());
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
    void testSetAndGetClasses() {
        assertEquals(Classes.Barbarian, john.getClasses());
        john.setClasses(Classes.Knight);
        Classes classes = john.getClasses();
        assertEquals(Classes.Knight, classes);
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
        assertEquals(120, john.getHealth());
        john.setHealth(100);
        int health = john.getHealth();
        assertEquals(100, health);
    }

    @Test
    void testSetAndGetAttackPower() {
        assertEquals(25, john.getAttackPower());
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