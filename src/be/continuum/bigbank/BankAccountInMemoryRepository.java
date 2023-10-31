package be.continuum.bigbank;

import be.continuum.bigbank.exceptions.IbanNotFoundException;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.model.Transaction;

public class BankAccountInMemoryRepository {
    private BankAccount[] accounts = new BankAccount[] {
            new BankAccount("BE123456789", "1234", "Nick Bauters", 5000, new Transaction[]{}, new Transaction[]{}),
            new BankAccount("BE987654321", "9876", "Kelly de Lange", 2500, new Transaction[]{}, new Transaction[]{})
    };

    public BankAccount findByIban(String iban){
        for (BankAccount account : accounts) {
            if (account.getIban().equals(iban)) return account;
        }
        throw new IbanNotFoundException("Iban could not be linked to an existing account");
    }
}
