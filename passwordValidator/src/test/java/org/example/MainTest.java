package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // Helper method to create Password instance
    private Password createPasswordInstance(String pass) {
        return new Password(pass);
    }

    // Is it eight characters?
    @Test
    void isItEightExpectTrue() {
        Password password = createPasswordInstance("myNewPassword");
        assertTrue(password.isItEight());
    }

    @Test
    void isItEightExpectFalse() {
        Password password = createPasswordInstance("passw");
        assertFalse(password.isItEight());
    }

    // Is digit included?
    @Test
    void isDigitExpectTrue() {
        Password password = createPasswordInstance("myNewPassword8");
        assertTrue(password.isDigitIncluded());
    }

    @Test
    void isDigitExpectFalse() {
        Password password = createPasswordInstance("passw");
        assertFalse(password.isDigitIncluded());
    }

    // Is Upper and Lower case Included?
    @Test
    void isUpperLowerExpectTrue() {
        Password password = createPasswordInstance("myNewPassword8");
        assertTrue(password.isLowerAndUpper());
    }

    @Test
    void isUpperLowerExpectFalse() {
        Password password = createPasswordInstance("passw");
        assertFalse(password.isLowerAndUpper());
    }

    // Is it commonly used one?
    @Test
    void isCommonlyUsedExpectTrue() {
        Password password = createPasswordInstance("password");
        assertTrue(password.isCommonlyUsedPassword());
    }

    @Test
    void isCommonlyUsedExpectFalse() {
        Password password = createPasswordInstance("pasasfsafsw");
        assertFalse(password.isCommonlyUsedPassword());
    }

    // Does it contain special Characters?
    @Test
    void isSpecialCharacterExpectTrue() {
        Password password = createPasswordInstance("password!");
        assertTrue(password.isSpecialCharacter());
    }

    @Test
    void isSpecialCharacterExpectFalse() {
        Password password = createPasswordInstance("pasasfsafsw");
        assertFalse(password.isSpecialCharacter());
    }
}
