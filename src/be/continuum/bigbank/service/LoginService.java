package be.continuum.bigbank.service;

import be.continuum.bigbank.BankAccountInMemoryRepository;
import be.continuum.bigbank.model.BankAccount;

public class LoginService {
    public BankAccount login(String iban, String pin) {
        BankAccountInMemoryRepository accountRepository = new BankAccountInMemoryRepository();
        BankAccount user = accountRepository.findByIban(iban);

        if (user.getPin().equals(pin)) return user;
        // todo bij een foutieve pincode moet de gebruiker opnieuw de pincode ingeven
        //   Bij 3 foutieve pincodes, moet de gebruiker worden gelockt
        return null;
    }
}
