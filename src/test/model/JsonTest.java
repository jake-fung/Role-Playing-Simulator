package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void assertCharacter(Character c, String name, boolean isMale, int experience, int level, int health, int attackPower, int defensePower) {
        assertEquals(name, c.getName());
        assertEquals(isMale, c.getIsMale());
        assertEquals(experience, c.getExperience());
        assertEquals(level, c.getLevel());
        assertEquals(health, c.getHealth());
        assertEquals(attackPower, c.getAttackPower());
        assertEquals(defensePower, c.getDefensePower());
    }
}