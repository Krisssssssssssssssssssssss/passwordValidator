package org.example;

import java.util.HashSet;
import java.util.Set;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 for an auto-generated password or 2 to enter your own password:");
        System.out.println("1 - AUTO GENERATED");
        System.out.println("2 - SELF-MADE");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            Password password = new Password();
            password.generatePassword();
            System.out.println("Your new password is: " + password.getPass());
            password.printMethod();
        } else if (choice == 2) {
            boolean isPasswordWrong = true;
            do {
                System.out.println("Please enter a new password:");
                System.out.println();
                String userInput = scanner.nextLine();
                Password password = new Password(userInput);
                System.out.println();
                password.printMethod();
                isPasswordWrong = password.getIsValid();
            }
            while (!isPasswordWrong);


        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }


        scanner.close();
    }
}


