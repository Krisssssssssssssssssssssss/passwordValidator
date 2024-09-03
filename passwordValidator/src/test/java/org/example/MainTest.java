package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //Is it eight characters?
    @Test
    void isItEightExpectTrue() {
        boolean given = true;
        boolean expected = Main.isItEight("myNewPassword");
        assertEquals(given, expected);
    }
    @Test
    void isItEightExpectFalse() {
        boolean given = false;
        boolean expected = Main.isItEight("passw");
        assertEquals(given, expected);
    }

    //Is digit included?
    @Test
    void isDigitExpectTrue() {
        boolean given = true;
        boolean expected = Main.isItEight("myNewPassword8");
        assertEquals(given, expected);
    }
    @Test
    void isDigitExpectFalse() {
        boolean given = false;
        boolean expected = Main.isItEight("passw");
        assertEquals(given, expected);
    }
}
