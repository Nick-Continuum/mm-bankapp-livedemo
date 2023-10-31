package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;

public class BankMainMenu {
    private final MenuHandler menu = new MenuHandler();
    private final LoginMenu loginMenu = new LoginMenu(menu);

    public void run() {
        menu.showMenuTitle("Welcome to the Big Bank App");

        BankAccount loggedInUser = loginMenu.login();

        mainMenu(loggedInUser);
    }

    private void mainMenu(BankAccount user) {
        while(true) {
            menu.showSubMenuTitle("Main Menu");

            menu.showMenuBlock(
                    "1. Incoming Transactions",
                    "2. Outgoing Transactions",
                    "3. Make Transfer",
                    "4. Logout"
            );
            String choice = menu.askForUserInput("Please enter your choice from the menu: ");

            switch (choice) {
                case "1":
                    menu.showMenuItem("HERE BE TRANSACTIONS");
                    break;
                case "2":
                    menu.showMenuItem("HERE BE OTHER TRANSACTIONS");
                    break;
                case "3":
                    menu.showMenuItem("HERE BE TRANSFERS");
                    break;
                default:
                    menu.showError("Fraude detected, Invalid choice!");
                case "4":
                    loginMenu.logOut();
            }
        }
    }
}
