package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.model.Transaction;
import be.continuum.bigbank.service.BankService;

public class TransferMenu {
    private final BankService bankService;
    private final BankAccount user;
    private final MenuHandler menu;

    public TransferMenu(BankAccount user, MenuHandler menu, BankService service) {
        this.user = user;
        this.menu = menu;
        this.bankService = service;
    }

    public void showMenu() {
        menu.showSubMenuTitle("Make a Transfer");

        String recipientIban = menu.askForUserInput("Recipient's IBAN: ");
        String transferAmount = menu.askForUserInput("Amount: " + MenuHandler.EURO_SIGN + " ");
        String transferDescription = menu.askForUserInput("Description (Optional): ");

        try {
            Transaction transaction = bankService.createTransaction(user, recipientIban, Double.parseDouble(transferAmount), transferDescription);
            bankService.transfer(transaction);
        } catch (RuntimeException re) {
            menu.showError(re.getMessage());
        }
    }
}
