package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    @Test
    void testConstructor() {
        Character aman = new Knight();
        assertEquals(100, aman.getHealth());
        assertEquals(20, aman.getAttackPower());
        assertEquals(15, aman.getDefensePower());
    }
}
