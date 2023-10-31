package be.continuum.bigbank.service;

import be.continuum.bigbank.BankAccountInMemoryRepository;
import be.continuum.bigbank.exceptions.IncorrectPinCodeException;
import be.continuum.bigbank.exceptions.LockedAccountException;
import be.continuum.bigbank.model.BankAccount;

public class LoginService {
    public BankAccount login(String iban, String pin) {
        BankAccountInMemoryRepository accountRepository = new BankAccountInMemoryRepository();
        BankAccount user = accountRepository.findByIban(iban);

        if (user.getPin().equals(pin)) return user;
        if (user.isLocked()) throw new LockedAccountException("Account has been locked after 3 failed attempts");

        user.failedPinAttempt();
        throw new IncorrectPinCodeException("The provided pincode was not correct. " + user.getAttemptsRemaining() + " attempts remaining");
    }
}
