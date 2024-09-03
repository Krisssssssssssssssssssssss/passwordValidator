package org.example;

import javax.lang.model.type.TypeKind;

public class Main {
    public static void main(String[] args) {


    }

    public static boolean isItEight (String pass) {
        return pass.length() >= 8 ? true : false;
    }

    public static boolean isDigitIncluded(String pass) {
        for (char c : pass.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }


//        public static boolean isLowerAndUpper (String pass) {}
//        public static void commonlyUsedPasswords (String pass) {}


}

