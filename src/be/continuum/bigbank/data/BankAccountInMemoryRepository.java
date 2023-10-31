package be.continuum.bigbank.data;

import be.continuum.bigbank.exceptions.IbanNotFoundException;
import be.continuum.bigbank.model.BankAccount;
import be.continuum.bigbank.model.Transaction;

public class BankAccountInMemoryRepository {
    private BankAccount[] accounts = new BankAccount[] {
            new BankAccount(
                    "BE123456789",
                    "1234",
                    "Nick Bauters",
                    5000,
                    new Transaction[]{},
                    new Transaction[]{}
            ),
            new BankAccount(
                    "BE987654321",
                    "9876",
                    "Kelly de Lange",
                    2500,
                    new Transaction[]{},
                    new Transaction[]{}
            )
    };

    public BankAccountInMemoryRepository() {
        BankAccount account1 = accounts[0];
        BankAccount account2 = accounts[1];

        Transaction transaction1 = new Transaction(
                account1,
                account2,
                1000
        );
        account1.addOutgoingTransaction(transaction1);
        account2.addIncomingTransaction(transaction1);

        Transaction transaction2 = new Transaction(
                account2,
                account1,
                500
        );
        account1.addIncomingTransaction(transaction2);
        account2.addOutgoingTransaction(transaction2);
    }

    public BankAccount findByIban(String iban){
        for (BankAccount account : accounts) {
            if (account.getIban().equals(iban)) return account;
        }
        throw new IbanNotFoundException("Iban could not be linked to an existing account");
    }
}
