package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;

public class BankMainMenu {
    private final MenuHandler menu = new MenuHandler();
    private final LoginMenu loginMenu = new LoginMenu(menu);

    public void run() {
        menu.showMenuTitle("Welcome to the Big Bank App");

        BankAccount loggedInUser = loginMenu.login();
    }
}
