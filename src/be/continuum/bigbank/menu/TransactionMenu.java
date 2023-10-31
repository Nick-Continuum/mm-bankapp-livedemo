package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.model.Transaction;
import be.continuum.bigbank.service.BankService;

public class TransactionMenu {
    private final MenuHandler menu;
    private final BankAccount user;
    private final BankService service;

    public TransactionMenu(MenuHandler menu, BankAccount user, BankService service) {
        this.menu = menu;
        this.user = user;
        this.service = service;
    }

    public void showIncomingTransactionMenu() {

    }

    public void showOutgoingTransactionMenu() {

    }

    private String transactionRepresentation(Transaction transaction) {
        return String.format(
                "FROM: %s\nTOO: %s\nAmount: %.2f\n",
                transaction.getSender().getFullName(),
                transaction.getReceiver().getFullName(),
                transaction.getAmount()

        );
    }
}
