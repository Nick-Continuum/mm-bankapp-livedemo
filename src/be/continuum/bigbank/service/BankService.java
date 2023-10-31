package be.continuum.bigbank.service;

import be.continuum.bigbank.BankAccountInMemoryRepository;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.model.Transaction;

public class BankService {
    private final BankAccountInMemoryRepository accountRepository;

    public BankService(BankAccountInMemoryRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(Transaction transaction) {
        BankAccount sender = transaction.getSender();
        BankAccount receiver = transaction.getReceiver();
        double amount = transaction.getAmount();

        sender.withdraw(amount);
        sender.addOutgoingTransaction(transaction);
        receiver.deposit(amount);
        receiver.addIncomingTransaction(transaction);
    }

    public Transaction createTransaction(BankAccount sender, String iban, double amount, String description) {
        BankAccount receiver = accountRepository.findByIban(iban);

        return new Transaction(
                sender,
                receiver,
                amount,
                description
        );
    }
}
