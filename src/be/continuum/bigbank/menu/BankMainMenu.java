package be.continuum.bigbank.menu;

import static be.continuum.bigbank.menu.MenuHandler.KEYBOARD;

public class BankMainMenu {
    public void run() {
        MenuHandler menu = new MenuHandler();
        menu.showMenuTitle("Welcome to the Big Bank App");

        String authenticatingUserIban = menu.askForUserInput("Please enter your IBAN: ");
        int authenticatingUserPin = menu.askForUserInputAsInteger("Please enter your Pincode: ");
    }
}
