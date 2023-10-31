package be.continuum.bigbank.menu;

import be.continuum.bigbank.data.BankAccountInMemoryRepository;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.service.BankService;

public class BankMainMenu {
    private final MenuHandler menu = new MenuHandler();
    private final BankAccountInMemoryRepository accountRepository = new BankAccountInMemoryRepository();
    private final BankService bankService = new BankService(accountRepository);
    private final LoginMenu loginMenu = new LoginMenu(menu, accountRepository);

    public void run() {
        menu.showMenuTitle("Welcome to the Big Bank App");

        BankAccount loggedInUser = loginMenu.login();

        mainMenu(loggedInUser);
    }

    private void mainMenu(BankAccount user) {
        while(true) {
            menu.showSubMenuTitle("Main Menu");

            menu.showMenuBlock(
                    "1. Show Balance",
                    "2. Incoming Transactions",
                    "3. Outgoing Transactions",
                    "4. Make Transfer",
                    "5. Logout"
            );
            String choice = menu.askForUserInput("Please enter your choice from the menu: ");

            handleChoice(choice, user);
        }
    }

    private void handleChoice(String choice, BankAccount user) {
        switch (choice) {
            case "1":
                new BalanceMenu(user, menu).showMenu();
                break;
            case "2":
                new TransactionMenu(menu, user).showIncomingTransactionMenu();
                break;
            case "3":
                new TransactionMenu(menu, user).showOutgoingTransactionMenu();
                break;
            case "4":
                new TransferMenu(user, menu, bankService).showMenu();
                break;
            default:
                menu.showError("Fraude detected, Invalid choice!");
            case "5":
                loginMenu.logout();
        }
    }
}
