package be.continuum.bigbank;

import be.continuum.bigbank.menu.BankMainMenu;

public class BankApp {
    public static void main(String[] args) {
        BankMainMenu mainMenu = new BankMainMenu();
        mainMenu.run();
    }
}
