package org.example;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    System.out.println(isCommonlyUsedPasswords("password"));
    System.out.println(isCommonlyUsedPasswords("asasfasfasdf"));
    }

    //Minimum Length
    public static boolean isItEight (String pass) {
        return pass.length() >= 8 ? true : false;
    }

    //Digits
    public static boolean isDigitIncluded(String pass) {
        for (char c : pass.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    //Upper or Lower
        public static boolean isLowerAndUpper (String pass) {
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
            if (isLower && isUpper){
                return true;
            }
            else return false;
    }
    //Common passwords

    private static final Set<String> COMMONLY_USED_PASSWORDS = new HashSet<>();

    static {
        // Add commonly used weak passwords to the set
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
    public static boolean isCommonlyUsedPasswords(String pass) {
        return COMMONLY_USED_PASSWORDS.contains(pass);
    }
}

