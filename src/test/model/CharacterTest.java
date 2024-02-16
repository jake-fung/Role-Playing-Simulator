package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

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
}