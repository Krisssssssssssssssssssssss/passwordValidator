package org.example;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Password {
    private String pass;
    private boolean isValid = true;

    public Password(String pass) {
        this.pass = pass;
    }
    public Password() {
    }

    //Fields I will need to do manipulations
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "@#$%^&+=!()[]{};:'\",.<>?/\\|`~_-";

    private static final int MIN_LENGTH = 8;

    // Set of commonly used passwords
    private static final Set<String> COMMONLY_USED_PASSWORDS = new HashSet<>();

    static {
        COMMONLY_USED_PASSWORDS.add("password");
        COMMONLY_USED_PASSWORDS.add("123456");
        COMMONLY_USED_PASSWORDS.add("password1");
        COMMONLY_USED_PASSWORDS.add("123456789");
        COMMONLY_USED_PASSWORDS.add("12345678");
        COMMONLY_USED_PASSWORDS.add("qwerty");
        COMMONLY_USED_PASSWORDS.add("abc123");
        COMMONLY_USED_PASSWORDS.add("Password1");
        COMMONLY_USED_PASSWORDS.add("Aa345678");
    }
    //Get the password
    public String getPass (){
        return this.pass;
    }
    public boolean getIsValid (){
        return this.isValid;
    }


    // Minimum Length Check
    public boolean isItEight() {
        return pass.length() >= 8;
    }

    // Digits Check
    public boolean isDigitIncluded() {
        for (char c : pass.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // Uppercase and Lowercase Check
    public boolean isLowerAndUpper() {
        boolean isLower = false;
        boolean isUpper = false;
        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) {
                isUpper = true;
            }
            if (Character.isLowerCase(c)) {
                isLower = true;
            }
        }
        return isLower && isUpper;
    }

    // Common Passwords Check
    public boolean isCommonlyUsedPassword() {
        return COMMONLY_USED_PASSWORDS.contains(pass);
    }
    public boolean isCommonlyUsedPassword(String pass) {
        return COMMONLY_USED_PASSWORDS.contains(pass);
    }

    // Special Characters Check
    public boolean isSpecialCharacter() {
        return pass.matches(".*[\\W_].*");
    }

    //Generate a password
    public void generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        List<Character> charList = new ArrayList<>();
        // Ensure at least one character from each required set
        charList.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        charList.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        charList.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        charList.add(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Fill the remaining characters randomly
        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        while (charList.size() < MIN_LENGTH || isCommonlyUsedPassword(password.toString())) {
            charList.add(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the characters to ensure randomness
        while (password.length() < MIN_LENGTH) {
            password.append(charList.remove(random.nextInt(charList.size())));
        }

        pass = password.toString();
    }

    //Print
    public void printMethod() {
        if (!isItEight()) {
            System.out.println(ANSI_RED + "Password must be at least 8 characters long." + ANSI_RESET);
            this.isValid = false;
        }

        if (!isDigitIncluded()) {
            System.out.println(ANSI_RED + "Password must contain at least one digit." + ANSI_RESET);
            this.isValid = false;
        }

        if (!isLowerAndUpper()) {
            System.out.println(ANSI_RED + "Password must contain both uppercase and lowercase letters." + ANSI_RESET);
            this.isValid = false;
        }

        if (isCommonlyUsedPassword()) {
            System.out.println(ANSI_RED + "Password is too common and easily guessable. Please choose a different password." + ANSI_RESET);
            this.isValid = false;
        }

        if (!isSpecialCharacter()) {
            System.out.println(ANSI_RED + "Password must contain at least one special character." + ANSI_RESET);
            this.isValid = false;
        }

        if (isValid) {
            System.out.println();
            System.out.println(ANSI_GREEN + "Password successfully created!" + ANSI_RESET);
        } else {
            System.out.println();
            System.out.println("Password creation failed. Please try again.");
        }
    }
}