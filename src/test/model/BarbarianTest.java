package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarbarianTest {

    @Test
    public void testConstructor() {
        Character aman = new Barbarian();
        assertEquals(120, aman.getHealth());
        assertEquals(25, aman.getAttackPower());
        assertEquals(10, aman.getDefensePower());
    }
}
