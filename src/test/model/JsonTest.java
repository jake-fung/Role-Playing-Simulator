package model;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonTest {
    protected void assertCharacter(Character c, String name, boolean isMale, int experience, int health, int attackPower, int defensePower) {
        assertEquals(name, c.getName());
        assertEquals(isMale, c.getIsMale());
        assertEquals(experience, c.getExperience());
        assertEquals(health, c.getHealth());
        assertEquals(attackPower, c.getAttackPower());
        assertEquals(defensePower, c.getDefensePower());
    }
}