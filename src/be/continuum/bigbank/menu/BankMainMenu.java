package be.continuum.bigbank.menu;

import java.util.Scanner;

public class BankMainMenu {
    public void run() {
        System.out.println("+++++      +++++++       ++++++");
        System.out.println("+ Welcome to the Big Bank App +");
        System.out.println("+++++      +++++++       ++++++");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your IBAN: ");
        String authenticatingUserIban = keyboard.next();
        System.out.println("Please enter your Pincode: ");
        String authenticatingUserPin = keyboard.next();
        int userPin = Integer.parseInt(authenticatingUserPin);
    }
}
