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
        boolean expected = Main.isDigitIncluded("myNewPassword8");
        assertEquals(given, expected);
    }
    @Test
    void isDigitExpectFalse() {
        boolean given = false;
        boolean expected = Main.isDigitIncluded("passw");
        assertEquals(given, expected);
    }
    //Is Upper and Lower case Included?
    @Test
    void isUpperLowerExpectTrue() {
        boolean given = true;
        boolean expected = Main.isLowerAndUpper("myNewPassword8");
        assertEquals(given, expected);
    }
    @Test
    void isUpperLowerExpectFalse() {
        boolean given = false;
        boolean expected = Main.isLowerAndUpper("passw");
        assertEquals(given, expected);
    }

    //Is it commonly used one?
    @Test
    void isCommonlyUsedExpectTrue() {
        boolean given = true;
        boolean expected = Main.isCommonlyUsedPasswords("password");
        assertEquals(given, expected);
    }
    @Test
    void isCommonlyUsedExpectFalse() {
        boolean given = false;
        boolean expected = Main.isCommonlyUsedPasswords("pasasfsafsw");
        assertEquals(given, expected);
    }
}
