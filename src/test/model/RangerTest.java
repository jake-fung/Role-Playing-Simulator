package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangerTest {

    @Test
    public void testConstructor() {
        Character aman = new Ranger();
        assertEquals(80, aman.getHealth());
        assertEquals(30, aman.getAttackPower());
        assertEquals(5, aman.getDefensePower());
    }
}
