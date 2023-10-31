package be.continuum.bigbank.menu;

import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.model.Transaction;

import static be.continuum.bigbank.menu.MenuHandler.EURO_SIGN;

public class TransactionMenu {
    private final MenuHandler menu;
    private final BankAccount user;

    public TransactionMenu(MenuHandler menu, BankAccount user) {
        this.menu = menu;
        this.user = user;
    }

    public void showIncomingTransactionMenu() {
        menu.showSubMenuTitle("Incoming Transactions");
        for (Transaction transaction : user.getIncomingTransactions()) {
            transactionRepresentation(transaction);
        }
    }

    public void showOutgoingTransactionMenu() {
        menu.showSubMenuTitle("Outgoing Transactions");
        for (Transaction transaction : user.getOutgoingTransactions()) {
            menu.showMenuItem(transactionRepresentation(transaction));
        }
    }

    private String transactionRepresentation(Transaction transaction) {
        return String.format(
                "FROM: %s\nTOO: %s\nAmount: %s %.2f\n",
                transaction.getSender().getFullName(),
                transaction.getReceiver().getFullName(),
                EURO_SIGN,
                transaction.getAmount()

        );
    }
}
